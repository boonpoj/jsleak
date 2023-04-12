package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfkb extends zzfjm<zzfkb> {
    private zzfkc zzpou = null;
    private zzfjy[] zzpoo = zzfjy.zzdan();
    private byte[] body = null;
    private byte[] zzpop = null;
    private Integer zzpoq = null;
    private byte[] zzpov = null;

    public zzfkb() {
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    @Override // com.google.android.gms.internal.zzfjs
    public final /* synthetic */ zzfjs zza(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            if (zzcvt == 10) {
                if (this.zzpou == null) {
                    this.zzpou = new zzfkc();
                }
                zzfjjVar.zza(this.zzpou);
            } else if (zzcvt == 18) {
                int zzb = zzfjv.zzb(zzfjjVar, 18);
                zzfjy[] zzfjyVarArr = this.zzpoo;
                int length = zzfjyVarArr == null ? 0 : zzfjyVarArr.length;
                zzfjy[] zzfjyVarArr2 = new zzfjy[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzpoo, 0, zzfjyVarArr2, 0, length);
                }
                while (length < zzfjyVarArr2.length - 1) {
                    zzfjyVarArr2[length] = new zzfjy();
                    zzfjjVar.zza(zzfjyVarArr2[length]);
                    zzfjjVar.zzcvt();
                    length++;
                }
                zzfjyVarArr2[length] = new zzfjy();
                zzfjjVar.zza(zzfjyVarArr2[length]);
                this.zzpoo = zzfjyVarArr2;
            } else if (zzcvt == 26) {
                this.body = zzfjjVar.readBytes();
            } else if (zzcvt == 34) {
                this.zzpop = zzfjjVar.readBytes();
            } else if (zzcvt == 40) {
                this.zzpoq = Integer.valueOf(zzfjjVar.zzcvw());
            } else if (zzcvt == 50) {
                this.zzpov = zzfjjVar.readBytes();
            } else if (!super.zza(zzfjjVar, zzcvt)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        zzfkc zzfkcVar = this.zzpou;
        if (zzfkcVar != null) {
            zzfjkVar.zza(1, zzfkcVar);
        }
        zzfjy[] zzfjyVarArr = this.zzpoo;
        if (zzfjyVarArr != null && zzfjyVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzfjy[] zzfjyVarArr2 = this.zzpoo;
                if (i >= zzfjyVarArr2.length) {
                    break;
                }
                zzfjy zzfjyVar = zzfjyVarArr2[i];
                if (zzfjyVar != null) {
                    zzfjkVar.zza(2, zzfjyVar);
                }
                i++;
            }
        }
        byte[] bArr = this.body;
        if (bArr != null) {
            zzfjkVar.zzc(3, bArr);
        }
        byte[] bArr2 = this.zzpop;
        if (bArr2 != null) {
            zzfjkVar.zzc(4, bArr2);
        }
        Integer num = this.zzpoq;
        if (num != null) {
            zzfjkVar.zzaa(5, num.intValue());
        }
        byte[] bArr3 = this.zzpov;
        if (bArr3 != null) {
            zzfjkVar.zzc(6, bArr3);
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        zzfkc zzfkcVar = this.zzpou;
        if (zzfkcVar != null) {
            zzq += zzfjk.zzb(1, zzfkcVar);
        }
        zzfjy[] zzfjyVarArr = this.zzpoo;
        if (zzfjyVarArr != null && zzfjyVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzfjy[] zzfjyVarArr2 = this.zzpoo;
                if (i >= zzfjyVarArr2.length) {
                    break;
                }
                zzfjy zzfjyVar = zzfjyVarArr2[i];
                if (zzfjyVar != null) {
                    zzq += zzfjk.zzb(2, zzfjyVar);
                }
                i++;
            }
        }
        byte[] bArr = this.body;
        if (bArr != null) {
            zzq += zzfjk.zzd(3, bArr);
        }
        byte[] bArr2 = this.zzpop;
        if (bArr2 != null) {
            zzq += zzfjk.zzd(4, bArr2);
        }
        Integer num = this.zzpoq;
        if (num != null) {
            zzq += zzfjk.zzad(5, num.intValue());
        }
        byte[] bArr3 = this.zzpov;
        return bArr3 != null ? zzq + zzfjk.zzd(6, bArr3) : zzq;
    }
}
