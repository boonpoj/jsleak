package com.google.android.gms.internal;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzbb extends zzfjm<zzbb> {
    private Long zzep = null;
    private Long zzeq = null;
    public Long zzgd = null;
    public Long zzge = null;
    public Long zzgf = null;

    public zzbb() {
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
                this.zzep = Long.valueOf(zzfjjVar.zzcwn());
            } else if (zzcvt == 16) {
                this.zzeq = Long.valueOf(zzfjjVar.zzcwn());
            } else if (zzcvt == 24) {
                this.zzgd = Long.valueOf(zzfjjVar.zzcwn());
            } else if (zzcvt == 32) {
                this.zzge = Long.valueOf(zzfjjVar.zzcwn());
            } else if (zzcvt == 40) {
                this.zzgf = Long.valueOf(zzfjjVar.zzcwn());
            } else if (!super.zza(zzfjjVar, zzcvt)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        Long l = this.zzep;
        if (l != null) {
            zzfjkVar.zzf(1, l.longValue());
        }
        Long l2 = this.zzeq;
        if (l2 != null) {
            zzfjkVar.zzf(2, l2.longValue());
        }
        Long l3 = this.zzgd;
        if (l3 != null) {
            zzfjkVar.zzf(3, l3.longValue());
        }
        Long l4 = this.zzge;
        if (l4 != null) {
            zzfjkVar.zzf(4, l4.longValue());
        }
        Long l5 = this.zzgf;
        if (l5 != null) {
            zzfjkVar.zzf(5, l5.longValue());
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        Long l = this.zzep;
        if (l != null) {
            zzq += zzfjk.zzc(1, l.longValue());
        }
        Long l2 = this.zzeq;
        if (l2 != null) {
            zzq += zzfjk.zzc(2, l2.longValue());
        }
        Long l3 = this.zzgd;
        if (l3 != null) {
            zzq += zzfjk.zzc(3, l3.longValue());
        }
        Long l4 = this.zzge;
        if (l4 != null) {
            zzq += zzfjk.zzc(4, l4.longValue());
        }
        Long l5 = this.zzgf;
        return l5 != null ? zzq + zzfjk.zzc(5, l5.longValue()) : zzq;
    }
}
