package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
final class zzk implements Runnable {
    private /* synthetic */ Drawable zzcit;
    private /* synthetic */ zzj zzciu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(zzj zzjVar, Drawable drawable) {
        this.zzciu = zzjVar;
        this.zzcit = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        activity = this.zzciu.zzciq.mActivity;
        activity.getWindow().setBackgroundDrawable(this.zzcit);
    }
}
