package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdv extends BroadcastReceiver {
    private /* synthetic */ zzdt zzakh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv(zzdt zzdtVar) {
        this.zzakh = zzdtVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzakh.zzax();
    }
}
