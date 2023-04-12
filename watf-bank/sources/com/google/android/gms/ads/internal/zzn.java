package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
final class zzn implements View.OnTouchListener {
    private /* synthetic */ zzl zzaod;
    private /* synthetic */ zzw zzaoe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(zzl zzlVar, zzw zzwVar) {
        this.zzaod = zzlVar;
        this.zzaoe = zzwVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zzaoe.recordClick();
        if (this.zzaod.zzaob != null) {
            this.zzaod.zzaob.zzom();
            return false;
        }
        return false;
    }
}
