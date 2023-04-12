package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfjy extends zzfjm<zzfjy> {
    private static volatile zzfjy[] zzpol;
    public byte[] zzpom = null;
    public byte[] zzohg = null;

    public zzfjy() {
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    public static zzfjy[] zzdan() {
        if (zzpol == null) {
            synchronized (zzfjq.zzpnk) {
                if (zzpol == null) {
                    zzpol = new zzfjy[0];
                }
            }
        }
        return zzpol;
    }

    @Override // com.google.android.gms.internal.zzfjs
    public final /* synthetic */ zzfjs zza(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            if (zzcvt == 10) {
                this.zzpom = zzfjjVar.readBytes();
            } else if (zzcvt == 18) {
                this.zzohg = zzfjjVar.readBytes();
            } else if (!super.zza(zzfjjVar, zzcvt)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        zzfjkVar.zzc(1, this.zzpom);
        byte[] bArr = this.zzohg;
        if (bArr != null) {
            zzfjkVar.zzc(2, bArr);
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq() + zzfjk.zzd(1, this.zzpom);
        byte[] bArr = this.zzohg;
        return bArr != null ? zzq + zzfjk.zzd(2, bArr) : zzq;
    }
}
