package com.google.android.gms.internal;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzjd extends zzfjm<zzjd> {
    public Integer zzbda = null;
    public Integer zzbdb = null;
    public Integer zzbdc = null;

    public zzjd() {
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
            if (zzcvt == 8) {
                this.zzbda = Integer.valueOf(zzfjjVar.zzcwi());
            } else if (zzcvt == 16) {
                this.zzbdb = Integer.valueOf(zzfjjVar.zzcwi());
            } else if (zzcvt == 24) {
                this.zzbdc = Integer.valueOf(zzfjjVar.zzcwi());
            } else if (!super.zza(zzfjjVar, zzcvt)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        Integer num = this.zzbda;
        if (num != null) {
            zzfjkVar.zzaa(1, num.intValue());
        }
        Integer num2 = this.zzbdb;
        if (num2 != null) {
            zzfjkVar.zzaa(2, num2.intValue());
        }
        Integer num3 = this.zzbdc;
        if (num3 != null) {
            zzfjkVar.zzaa(3, num3.intValue());
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        Integer num = this.zzbda;
        if (num != null) {
            zzq += zzfjk.zzad(1, num.intValue());
        }
        Integer num2 = this.zzbdb;
        if (num2 != null) {
            zzq += zzfjk.zzad(2, num2.intValue());
        }
        Integer num3 = this.zzbdc;
        return num3 != null ? zzq + zzfjk.zzad(3, num3.intValue()) : zzq;
    }
}
