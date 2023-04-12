package com.google.android.gms.common.api.internal;

import android.os.Bundle;
/* loaded from: classes.dex */
final class zzch implements Runnable {
    private /* synthetic */ String zzat;
    private /* synthetic */ LifecycleCallback zzfuh;
    private /* synthetic */ zzcg zzfui;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzch(zzcg zzcgVar, LifecycleCallback lifecycleCallback, String str) {
        this.zzfui = zzcgVar;
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
        i = this.zzfui.zzcbc;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.zzfuh;
            bundle = this.zzfui.zzfug;
            if (bundle != null) {
                bundle3 = this.zzfui.zzfug;
                bundle2 = bundle3.getBundle(this.zzat);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i2 = this.zzfui.zzcbc;
        if (i2 >= 2) {
            this.zzfuh.onStart();
        }
        i3 = this.zzfui.zzcbc;
        if (i3 >= 3) {
            this.zzfuh.onResume();
        }
        i4 = this.zzfui.zzcbc;
        if (i4 >= 4) {
            this.zzfuh.onStop();
        }
        i5 = this.zzfui.zzcbc;
        if (i5 >= 5) {
            this.zzfuh.onDestroy();
        }
    }
}
