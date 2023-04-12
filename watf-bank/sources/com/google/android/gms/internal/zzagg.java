package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
@zzzv
/* loaded from: classes.dex */
public final class zzagg extends Handler {
    public zzagg(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "AdMobHandler.handleMessage");
        }
    }
}
