package com.google.android.gms.internal;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzyu implements Runnable {
    final /* synthetic */ JSONObject zzcli;
    final /* synthetic */ zzalf zzclj;
    final /* synthetic */ zzyt zzclk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyu(zzyt zzytVar, JSONObject jSONObject, zzalf zzalfVar) {
        this.zzclk = zzytVar;
        this.zzcli = jSONObject;
        this.zzclj = zzalfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzba zzbaVar;
        ViewTreeObserver.OnGlobalLayoutListener zza;
        ViewTreeObserver.OnScrollChangedListener zzb;
        try {
            zzanh zznj = this.zzclk.zznj();
            zznj.zza(zzapa.zzug());
            zzbaVar = this.zzclk.zzclf;
            zzbaVar.zze(zznj);
            WeakReference weakReference = new WeakReference(zznj);
            zzani zzsz = zznj.zzsz();
            zza = this.zzclk.zza(weakReference);
            zzb = this.zzclk.zzb(weakReference);
            zzsz.zza(zza, zzb);
            this.zzclk.zzf(zznj);
            zznj.zzsz().zza(new zzyv(this, zznj));
            zznj.zzsz().zza(new zzyw(this));
            zznj.loadUrl((String) zzkb.zzif().zzd(zznh.zzboo));
        } catch (Exception e) {
            zzagf.zzc("Exception occurred while getting video view", e);
            this.zzclj.set(null);
        }
    }
}
