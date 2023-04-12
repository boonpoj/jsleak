package com.google.android.gms.internal;
/* loaded from: assets/classes2.dex */
public final class zzbup implements Cloneable {
    private static final zzbuq zzcrZ = new zzbuq();
    private int mSize;
    private boolean zzcsa;
    private int[] zzcsb;
    private zzbuq[] zzcsc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbup() {
        this(10);
    }

    zzbup(int i) {
        this.zzcsa = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcsb = new int[idealIntArraySize];
        this.zzcsc = new zzbuq[idealIntArraySize];
        this.mSize = 0;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzbuq[] zzbuqVarArr, zzbuq[] zzbuqVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzbuqVarArr[i2].equals(zzbuqVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzqz(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzcsb[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ (-1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbup) {
            zzbup zzbupVar = (zzbup) obj;
            return size() == zzbupVar.size() && zza(this.zzcsb, zzbupVar.zzcsb, this.mSize) && zza(this.zzcsc, zzbupVar.zzcsc, this.mSize);
        }
        return false;
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzcsb[i2]) * 31) + this.zzcsc[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return this.mSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(int i, zzbuq zzbuqVar) {
        int zzqz = zzqz(i);
        if (zzqz >= 0) {
            this.zzcsc[zzqz] = zzbuqVar;
            return;
        }
        int i2 = zzqz ^ (-1);
        if (i2 < this.mSize && this.zzcsc[i2] == zzcrZ) {
            this.zzcsb[i2] = i;
            this.zzcsc[i2] = zzbuqVar;
            return;
        }
        if (this.mSize >= this.zzcsb.length) {
            int idealIntArraySize = idealIntArraySize(this.mSize + 1);
            int[] iArr = new int[idealIntArraySize];
            zzbuq[] zzbuqVarArr = new zzbuq[idealIntArraySize];
            System.arraycopy(this.zzcsb, 0, iArr, 0, this.zzcsb.length);
            System.arraycopy(this.zzcsc, 0, zzbuqVarArr, 0, this.zzcsc.length);
            this.zzcsb = iArr;
            this.zzcsc = zzbuqVarArr;
        }
        if (this.mSize - i2 != 0) {
            int i3 = i2 + 1;
            System.arraycopy(this.zzcsb, i2, this.zzcsb, i3, this.mSize - i2);
            System.arraycopy(this.zzcsc, i2, this.zzcsc, i3, this.mSize - i2);
        }
        this.zzcsb[i2] = i;
        this.zzcsc[i2] = zzbuqVar;
        this.mSize++;
    }

    /* renamed from: zzacP */
    public final zzbup clone() {
        int size = size();
        zzbup zzbupVar = new zzbup(size);
        System.arraycopy(this.zzcsb, 0, zzbupVar.zzcsb, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.zzcsc[i] != null) {
                zzbupVar.zzcsc[i] = (zzbuq) this.zzcsc[i].clone();
            }
        }
        zzbupVar.mSize = size;
        return zzbupVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbuq zzqx(int i) {
        int zzqz = zzqz(i);
        if (zzqz < 0 || this.zzcsc[zzqz] == zzcrZ) {
            return null;
        }
        return this.zzcsc[zzqz];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbuq zzqy(int i) {
        return this.zzcsc[i];
    }
}
