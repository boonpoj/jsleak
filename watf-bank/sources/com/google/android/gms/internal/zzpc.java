package com.google.android.gms.internal;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzpc implements com.google.android.gms.ads.internal.gmsg.zzt<Object> {
    private /* synthetic */ zzzb zzbva;
    private /* synthetic */ zzoy zzbvb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpc(zzoy zzoyVar, zzzb zzzbVar) {
        this.zzbvb = zzoyVar;
        this.zzbva = zzzbVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        WeakReference weakReference;
        weakReference = this.zzbvb.zzbuy;
        zzanh zzanhVar = (zzanh) weakReference.get();
        if (zzanhVar == null) {
            this.zzbva.zzb("/hideOverlay", this);
        } else if (zzanhVar == null) {
            throw null;
        } else {
            ((View) zzanhVar).setVisibility(8);
        }
    }
}
