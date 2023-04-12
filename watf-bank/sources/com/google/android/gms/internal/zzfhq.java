package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfhq extends zzfes {
    private static final int[] zzpjg;
    private final int zzpjh;
    private final zzfes zzpji;
    private final zzfes zzpjj;
    private final int zzpjk;
    private final int zzpjl;

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        zzpjg = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = zzpjg;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    private zzfhq(zzfes zzfesVar, zzfes zzfesVar2) {
        this.zzpji = zzfesVar;
        this.zzpjj = zzfesVar2;
        this.zzpjk = zzfesVar.size();
        this.zzpjh = this.zzpjk + zzfesVar2.size();
        this.zzpjl = Math.max(zzfesVar.zzcvn(), zzfesVar2.zzcvn()) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfes zza(zzfes zzfesVar, zzfes zzfesVar2) {
        if (zzfesVar2.size() == 0) {
            return zzfesVar;
        }
        if (zzfesVar.size() == 0) {
            return zzfesVar2;
        }
        int size = zzfesVar.size() + zzfesVar2.size();
        if (size < 128) {
            return zzb(zzfesVar, zzfesVar2);
        }
        if (zzfesVar instanceof zzfhq) {
            zzfhq zzfhqVar = (zzfhq) zzfesVar;
            if (zzfhqVar.zzpjj.size() + zzfesVar2.size() < 128) {
                return new zzfhq(zzfhqVar.zzpji, zzb(zzfhqVar.zzpjj, zzfesVar2));
            } else if (zzfhqVar.zzpji.zzcvn() > zzfhqVar.zzpjj.zzcvn() && zzfhqVar.zzcvn() > zzfesVar2.zzcvn()) {
                return new zzfhq(zzfhqVar.zzpji, new zzfhq(zzfhqVar.zzpjj, zzfesVar2));
            }
        }
        return size >= zzpjg[Math.max(zzfesVar.zzcvn(), zzfesVar2.zzcvn()) + 1] ? new zzfhq(zzfesVar, zzfesVar2) : zzfhs.zza(new zzfhs(), zzfesVar, zzfesVar2);
    }

    private static zzfes zzb(zzfes zzfesVar, zzfes zzfesVar2) {
        int size = zzfesVar.size();
        int size2 = zzfesVar2.size();
        byte[] bArr = new byte[size + size2];
        zzfesVar.zza(bArr, 0, 0, size);
        zzfesVar2.zza(bArr, 0, size, size2);
        return zzfes.zzba(bArr);
    }

    @Override // com.google.android.gms.internal.zzfes
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfes)) {
            return false;
        }
        zzfes zzfesVar = (zzfes) obj;
        if (this.zzpjh != zzfesVar.size()) {
            return false;
        }
        if (this.zzpjh == 0) {
            return true;
        }
        int zzcvp = zzcvp();
        int zzcvp2 = zzfesVar.zzcvp();
        if (zzcvp != 0 && zzcvp2 != 0 && zzcvp != zzcvp2) {
            return false;
        }
        zzfht zzfhtVar = new zzfht(this);
        zzfey next = zzfhtVar.next();
        zzfht zzfhtVar2 = new zzfht(zzfesVar);
        zzfey next2 = zzfhtVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? next.zza(next2, i2, min) : next2.zza(next, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.zzpjh;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = zzfhtVar.next();
                i = 0;
            } else {
                i += min;
            }
            if (min == size2) {
                next2 = zzfhtVar2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfes
    public final int size() {
        return this.zzpjh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.zzfes
    public final void zza(zzfer zzferVar) throws IOException {
        this.zzpji.zza(zzferVar);
        this.zzpjj.zza(zzferVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfes
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzpjk;
        if (i4 <= i5) {
            this.zzpji.zzb(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zzpjj.zzb(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zzpji.zzb(bArr, i, i2, i6);
            this.zzpjj.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.zzfes
    public final zzffb zzcvm() {
        return zzffb.zzi(new zzfhu(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfes
    public final int zzcvn() {
        return this.zzpjl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfes
    public final boolean zzcvo() {
        return this.zzpjh >= zzpjg[this.zzpjl];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfes
    public final int zzg(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzpjk;
        if (i4 <= i5) {
            return this.zzpji.zzg(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzpjj.zzg(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzpjj.zzg(this.zzpji.zzg(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.zzfes
    public final byte zzkn(int i) {
        zzy(i, this.zzpjh);
        int i2 = this.zzpjk;
        return i < i2 ? this.zzpji.zzkn(i) : this.zzpjj.zzkn(i - i2);
    }

    @Override // com.google.android.gms.internal.zzfes
    public final zzfes zzx(int i, int i2) {
        int zzh = zzh(i, i2, this.zzpjh);
        if (zzh == 0) {
            return zzfes.zzpfg;
        }
        if (zzh == this.zzpjh) {
            return this;
        }
        int i3 = this.zzpjk;
        if (i2 <= i3) {
            return this.zzpji.zzx(i, i2);
        }
        if (i >= i3) {
            return this.zzpjj.zzx(i - i3, i2 - i3);
        }
        zzfes zzfesVar = this.zzpji;
        return new zzfhq(zzfesVar.zzx(i, zzfesVar.size()), this.zzpjj.zzx(0, i2 - this.zzpjk));
    }
}
