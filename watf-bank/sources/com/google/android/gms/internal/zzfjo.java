package com.google.android.gms.internal;
/* loaded from: classes.dex */
public final class zzfjo implements Cloneable {
    private static final zzfjp zzpne = new zzfjp();
    private int mSize;
    private boolean zzpnf;
    private int[] zzpng;
    private zzfjp[] zzpnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfjo() {
        this(10);
    }

    private zzfjo(int i) {
        this.zzpnf = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzpng = new int[idealIntArraySize];
        this.zzpnh = new zzfjp[idealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int zzml(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzpng[i4];
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

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzfjo zzfjoVar = new zzfjo(i);
        System.arraycopy(this.zzpng, 0, zzfjoVar.zzpng, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            zzfjp[] zzfjpVarArr = this.zzpnh;
            if (zzfjpVarArr[i2] != null) {
                zzfjoVar.zzpnh[i2] = (zzfjp) zzfjpVarArr[i2].clone();
            }
        }
        zzfjoVar.mSize = i;
        return zzfjoVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfjo) {
            zzfjo zzfjoVar = (zzfjo) obj;
            int i = this.mSize;
            if (i != zzfjoVar.mSize) {
                return false;
            }
            int[] iArr = this.zzpng;
            int[] iArr2 = zzfjoVar.zzpng;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                zzfjp[] zzfjpVarArr = this.zzpnh;
                zzfjp[] zzfjpVarArr2 = zzfjoVar.zzpnh;
                int i3 = this.mSize;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!zzfjpVarArr[i4].equals(zzfjpVarArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzpng[i2]) * 31) + this.zzpnh[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i, zzfjp zzfjpVar) {
        int zzml = zzml(i);
        if (zzml >= 0) {
            this.zzpnh[zzml] = zzfjpVar;
            return;
        }
        int i2 = zzml ^ (-1);
        if (i2 < this.mSize) {
            zzfjp[] zzfjpVarArr = this.zzpnh;
            if (zzfjpVarArr[i2] == zzpne) {
                this.zzpng[i2] = i;
                zzfjpVarArr[i2] = zzfjpVar;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzpng.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            zzfjp[] zzfjpVarArr2 = new zzfjp[idealIntArraySize];
            int[] iArr2 = this.zzpng;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zzfjp[] zzfjpVarArr3 = this.zzpnh;
            System.arraycopy(zzfjpVarArr3, 0, zzfjpVarArr2, 0, zzfjpVarArr3.length);
            this.zzpng = iArr;
            this.zzpnh = zzfjpVarArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzpng;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            zzfjp[] zzfjpVarArr4 = this.zzpnh;
            System.arraycopy(zzfjpVarArr4, i2, zzfjpVarArr4, i5, this.mSize - i2);
        }
        this.zzpng[i2] = i;
        this.zzpnh[i2] = zzfjpVar;
        this.mSize++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfjp zzmj(int i) {
        int zzml = zzml(i);
        if (zzml >= 0) {
            zzfjp[] zzfjpVarArr = this.zzpnh;
            if (zzfjpVarArr[zzml] == zzpne) {
                return null;
            }
            return zzfjpVarArr[zzml];
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfjp zzmk(int i) {
        return this.zzpnh[i];
    }
}
