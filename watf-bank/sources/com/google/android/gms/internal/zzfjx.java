package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfjx extends zzfjm<zzfjx> {
    public String zzcwp = null;

    public zzfjx() {
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
                this.zzcwp = zzfjjVar.readString();
            } else if (!super.zza(zzfjjVar, zzcvt)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        String str = this.zzcwp;
        if (str != null) {
            zzfjkVar.zzn(1, str);
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        String str = this.zzcwp;
        return str != null ? zzq + zzfjk.zzo(1, str) : zzq;
    }
}
