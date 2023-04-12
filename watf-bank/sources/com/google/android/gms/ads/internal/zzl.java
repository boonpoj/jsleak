package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zzya;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzl implements Runnable {
    final /* synthetic */ zzafp zzanv;
    final /* synthetic */ zzi zzaoa;
    final /* synthetic */ zzafb zzaob;
    private /* synthetic */ zznu zzaoc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(zzi zziVar, zzafp zzafpVar, zzafb zzafbVar, zznu zznuVar) {
        this.zzaoa = zziVar;
        this.zzanv = zzafpVar;
        this.zzaob = zzafbVar;
        this.zzaoc = zznuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzanv.zzcxy.zzcpf && this.zzaoa.zzano.zzaut != null) {
            String str = null;
            if (this.zzanv.zzcxy.zzcja != null) {
                zzbs.zzei();
                str = zzahn.zzcd(this.zzanv.zzcxy.zzcja);
            }
            zznv zznvVar = new zznv(this.zzaoa, str, this.zzanv.zzcxy.body);
            this.zzaoa.zzano.zzauz = 1;
            try {
                this.zzaoa.zzanm = false;
                this.zzaoa.zzano.zzaut.zza(zznvVar);
                return;
            } catch (RemoteException e) {
                zzagf.zzc("Could not call the onCustomRenderedAdLoadedListener.", e);
                this.zzaoa.zzanm = true;
            }
        }
        zzw zzwVar = new zzw(this.zzaoa.zzano.zzair, this.zzaob, this.zzanv.zzcxy.zzcpp);
        try {
            zzanh zza = this.zzaoa.zza(this.zzanv, zzwVar, this.zzaob);
            zza.setOnTouchListener(new zzn(this, zzwVar));
            zza.setOnClickListener(new zzo(this, zzwVar));
            this.zzaoa.zzano.zzauz = 0;
            zzbt zzbtVar = this.zzaoa.zzano;
            zzbs.zzeh();
            Context context = this.zzaoa.zzano.zzair;
            zzi zziVar = this.zzaoa;
            zzbtVar.zzaub = zzya.zza(context, zziVar, this.zzanv, zziVar.zzano.zzatx, zza, this.zzaoa.zzanw, this.zzaoa, this.zzaoc);
        } catch (zzanv e2) {
            zzagf.zzb("Could not obtain webview.", e2);
            zzahn.zzdaw.post(new zzm(this));
        }
    }
}
