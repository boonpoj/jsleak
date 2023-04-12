package com.google.android.gms.internal;

import android.view.MotionEvent;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzoo implements zzoq {
    private /* synthetic */ zzon zzbun;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoo(zzon zzonVar) {
        this.zzbun = zzonVar;
    }

    @Override // com.google.android.gms.internal.zzoq
    public final void zzc(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.zzoq
    public final void zzkb() {
        this.zzbun.performClick(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
    }
}
