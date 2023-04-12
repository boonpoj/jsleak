package com.google.android.gms.internal;

import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaml implements Runnable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaml(zzamk zzamkVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
