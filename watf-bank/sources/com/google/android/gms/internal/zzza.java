package com.google.android.gms.internal;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzza implements ViewTreeObserver.OnScrollChangedListener {
    private /* synthetic */ zzyt zzclk;
    private /* synthetic */ WeakReference zzclm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzza(zzyt zzytVar, WeakReference weakReference) {
        this.zzclk = zzytVar;
        this.zzclm = weakReference;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        this.zzclk.zza((WeakReference<zzanh>) this.zzclm, true);
    }
}
