package com.google.android.gms.common.api.internal;

import android.os.Bundle;
/* loaded from: classes.dex */
final class zzdc implements Runnable {
    private /* synthetic */ String zzat;
    private /* synthetic */ LifecycleCallback zzfuh;
    private /* synthetic */ zzdb zzfuw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdc(zzdb zzdbVar, LifecycleCallback lifecycleCallback, String str) {
        this.zzfuw = zzdbVar;
        this.zzfuh = lifecycleCallback;
        this.zzat = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        i = this.zzfuw.zzcbc;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.zzfuh;
            bundle = this.zzfuw.zzfug;
            if (bundle != null) {
                bundle3 = this.zzfuw.zzfug;
                bundle2 = bundle3.getBundle(this.zzat);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i2 = this.zzfuw.zzcbc;
        if (i2 >= 2) {
            this.zzfuh.onStart();
        }
        i3 = this.zzfuw.zzcbc;
        if (i3 >= 3) {
            this.zzfuh.onResume();
        }
        i4 = this.zzfuw.zzcbc;
        if (i4 >= 4) {
            this.zzfuh.onStop();
        }
        i5 = this.zzfuw.zzcbc;
        if (i5 >= 5) {
            this.zzfuh.onDestroy();
        }
    }
}
