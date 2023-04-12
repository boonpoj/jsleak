package com.google.android.gms.internal;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzbe extends zzfjm<zzbe> {
    public Long zzgg = null;
    private String zzgo = null;
    private byte[] zzgp = null;

    public zzbe() {
        this.zzpfd = -1;
    }

    @Override // com.google.android.gms.internal.zzfjs
    public final /* synthetic */ zzfjs zza(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            if (zzcvt == 8) {
                this.zzgg = Long.valueOf(zzfjjVar.zzcwn());
            } else if (zzcvt == 26) {
                this.zzgo = zzfjjVar.readString();
            } else if (zzcvt == 34) {
                this.zzgp = zzfjjVar.readBytes();
            } else if (!super.zza(zzfjjVar, zzcvt)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        Long l = this.zzgg;
        if (l != null) {
            zzfjkVar.zzf(1, l.longValue());
        }
        String str = this.zzgo;
        if (str != null) {
            zzfjkVar.zzn(3, str);
        }
        byte[] bArr = this.zzgp;
        if (bArr != null) {
            zzfjkVar.zzc(4, bArr);
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        Long l = this.zzgg;
        if (l != null) {
            zzq += zzfjk.zzc(1, l.longValue());
        }
        String str = this.zzgo;
        if (str != null) {
            zzq += zzfjk.zzo(3, str);
        }
        byte[] bArr = this.zzgp;
        return bArr != null ? zzq + zzfjk.zzd(4, bArr) : zzq;
    }
}
