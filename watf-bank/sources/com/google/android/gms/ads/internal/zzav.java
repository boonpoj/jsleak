package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzvj;
import com.google.android.gms.internal.zzvm;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzav implements com.google.android.gms.ads.internal.gmsg.zzt<zzanh> {
    private /* synthetic */ zzvj zzara;
    private /* synthetic */ zzab zzarb;
    private /* synthetic */ zzvm zzarc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(zzvj zzvjVar, zzab zzabVar, zzvm zzvmVar) {
        this.zzara = zzvjVar;
        this.zzarb = zzabVar;
        this.zzarc = zzvmVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        zzanh zzanhVar2 = zzanhVar;
        if (zzanhVar2 == null) {
            throw null;
        }
        View view = (View) zzanhVar2;
        if (view != null) {
            try {
                if (this.zzara != null) {
                    if (this.zzara.getOverrideClickHandling()) {
                        zzaq.zzc(zzanhVar2);
                        return;
                    }
                    this.zzara.zzh(com.google.android.gms.dynamic.zzn.zzz(view));
                    this.zzarb.zzaot.onAdClicked();
                } else if (this.zzarc != null) {
                    if (this.zzarc.getOverrideClickHandling()) {
                        zzaq.zzc(zzanhVar2);
                        return;
                    }
                    this.zzarc.zzh(com.google.android.gms.dynamic.zzn.zzz(view));
                    this.zzarb.zzaot.onAdClicked();
                }
            } catch (RemoteException e) {
                zzagf.zzc("Unable to call handleClick on mapper", e);
            }
        }
    }
}
