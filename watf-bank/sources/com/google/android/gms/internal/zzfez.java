package com.google.android.gms.internal;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzfez extends zzfey {
    protected final byte[] zzjng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfez(byte[] bArr) {
        this.zzjng = bArr;
    }

    @Override // com.google.android.gms.internal.zzfes
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfes) && size() == ((zzfes) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof zzfez) {
                zzfez zzfezVar = (zzfez) obj;
                int zzcvp = zzcvp();
                int zzcvp2 = zzfezVar.zzcvp();
                if (zzcvp == 0 || zzcvp2 == 0 || zzcvp == zzcvp2) {
                    return zza(zzfezVar, 0, size());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzfes
    public int size() {
        return this.zzjng.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.zzfes
    public final void zza(zzfer zzferVar) throws IOException {
        zzferVar.zzd(this.zzjng, zzcvq(), size());
    }

    @Override // com.google.android.gms.internal.zzfey
    final boolean zza(zzfes zzfesVar, int i, int i2) {
        if (i2 > zzfesVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int i3 = i + i2;
        if (i3 > zzfesVar.size()) {
            int size2 = zzfesVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (zzfesVar instanceof zzfez) {
            zzfez zzfezVar = (zzfez) zzfesVar;
            byte[] bArr = this.zzjng;
            byte[] bArr2 = zzfezVar.zzjng;
            int zzcvq = zzcvq() + i2;
            int zzcvq2 = zzcvq();
            int zzcvq3 = zzfezVar.zzcvq() + i;
            while (zzcvq2 < zzcvq) {
                if (bArr[zzcvq2] != bArr2[zzcvq3]) {
                    return false;
                }
                zzcvq2++;
                zzcvq3++;
            }
            return true;
        } else {
            return zzfesVar.zzx(i, i3).equals(zzx(0, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfes
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzjng, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.zzfes
    public final zzffb zzcvm() {
        return zzffb.zzb(this.zzjng, zzcvq(), size(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzcvq() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfes
    public final int zzg(int i, int i2, int i3) {
        return zzffz.zza(i, this.zzjng, zzcvq() + i2, i3);
    }

    @Override // com.google.android.gms.internal.zzfes
    public byte zzkn(int i) {
        return this.zzjng[i];
    }

    @Override // com.google.android.gms.internal.zzfes
    public final zzfes zzx(int i, int i2) {
        int zzh = zzh(i, i2, size());
        return zzh == 0 ? zzfes.zzpfg : new zzfev(this.zzjng, zzcvq() + i, zzh);
    }
}
