package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzjj;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbj implements Runnable {
    private /* synthetic */ WeakReference zzasb;
    private /* synthetic */ zzbi zzasc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbj(zzbi zzbiVar, WeakReference weakReference) {
        this.zzasc = zzbiVar;
        this.zzasb = weakReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjj zzjjVar;
        this.zzasc.zzary = false;
        zza zzaVar = (zza) this.zzasb.get();
        if (zzaVar != null) {
            zzjjVar = this.zzasc.zzarx;
            if (zzaVar.zzc(zzjjVar)) {
                zzaVar.zzb(zzjjVar);
                return;
            }
            zzagf.zzct("Ad is not visible. Not refreshing ad.");
            zzaVar.zzann.zzg(zzjjVar);
        }
    }
}
