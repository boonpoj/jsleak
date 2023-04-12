package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahs extends BroadcastReceiver {
    private /* synthetic */ zzahn zzdbe;

    private zzahs(zzahn zzahnVar) {
        this.zzdbe = zzahnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzahs(zzahn zzahnVar, zzaho zzahoVar) {
        this(zzahnVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.zzdbe.zzdax = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.zzdbe.zzdax = false;
        }
    }
}
