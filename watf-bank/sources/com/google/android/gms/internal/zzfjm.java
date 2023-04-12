package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfjm;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class zzfjm<M extends zzfjm<M>> extends zzfjs {
    protected zzfjo zzpnc;

    public final <T> T zza(zzfjn<M, T> zzfjnVar) {
        zzfjp zzmj;
        zzfjo zzfjoVar = this.zzpnc;
        if (zzfjoVar == null || (zzmj = zzfjoVar.zzmj(zzfjnVar.tag >>> 3)) == null) {
            return null;
        }
        return (T) zzmj.zzb(zzfjnVar);
    }

    @Override // com.google.android.gms.internal.zzfjs
    public void zza(zzfjk zzfjkVar) throws IOException {
        if (this.zzpnc == null) {
            return;
        }
        for (int i = 0; i < this.zzpnc.size(); i++) {
            this.zzpnc.zzmk(i).zza(zzfjkVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zza(zzfjj zzfjjVar, int i) throws IOException {
        int position = zzfjjVar.getPosition();
        if (zzfjjVar.zzkq(i)) {
            int i2 = i >>> 3;
            zzfju zzfjuVar = new zzfju(i, zzfjjVar.zzal(position, zzfjjVar.getPosition() - position));
            zzfjp zzfjpVar = null;
            zzfjo zzfjoVar = this.zzpnc;
            if (zzfjoVar == null) {
                this.zzpnc = new zzfjo();
            } else {
                zzfjpVar = zzfjoVar.zzmj(i2);
            }
            if (zzfjpVar == null) {
                zzfjpVar = new zzfjp();
                this.zzpnc.zza(i2, zzfjpVar);
            }
            zzfjpVar.zza(zzfjuVar);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzfjs
    /* renamed from: zzdaf */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        zzfjq.zza(this, m);
        return m;
    }

    @Override // com.google.android.gms.internal.zzfjs
    public /* synthetic */ zzfjs zzdag() throws CloneNotSupportedException {
        return (zzfjm) clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjs
    public int zzq() {
        if (this.zzpnc != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.zzpnc.size(); i2++) {
                i += this.zzpnc.zzmk(i2).zzq();
            }
            return i;
        }
        return 0;
    }
}
