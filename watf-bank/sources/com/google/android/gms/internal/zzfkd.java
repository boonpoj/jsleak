package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfkd extends zzfjm<zzfkd> {
    public Integer zzpnw = null;
    public String mimeType = null;
    public byte[] zzpoy = null;

    public zzfkd() {
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjs
    /* renamed from: zzap */
    public final zzfkd zza(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            if (zzcvt == 8) {
                int position = zzfjjVar.getPosition();
                try {
                    int zzcvw = zzfjjVar.zzcvw();
                    if (zzcvw != 0 && zzcvw != 1) {
                        StringBuilder sb = new StringBuilder(36);
                        sb.append(zzcvw);
                        sb.append(" is not a valid enum Type");
                        throw new IllegalArgumentException(sb.toString());
                        break;
                    }
                    this.zzpnw = Integer.valueOf(zzcvw);
                } catch (IllegalArgumentException e) {
                    zzfjjVar.zzmg(position);
                    zza(zzfjjVar, zzcvt);
                }
            } else if (zzcvt == 18) {
                this.mimeType = zzfjjVar.readString();
            } else if (zzcvt == 26) {
                this.zzpoy = zzfjjVar.readBytes();
            } else if (!super.zza(zzfjjVar, zzcvt)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        Integer num = this.zzpnw;
        if (num != null) {
            zzfjkVar.zzaa(1, num.intValue());
        }
        String str = this.mimeType;
        if (str != null) {
            zzfjkVar.zzn(2, str);
        }
        byte[] bArr = this.zzpoy;
        if (bArr != null) {
            zzfjkVar.zzc(3, bArr);
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        Integer num = this.zzpnw;
        if (num != null) {
            zzq += zzfjk.zzad(1, num.intValue());
        }
        String str = this.mimeType;
        if (str != null) {
            zzq += zzfjk.zzo(2, str);
        }
        byte[] bArr = this.zzpoy;
        return bArr != null ? zzq + zzfjk.zzd(3, bArr) : zzq;
    }
}
