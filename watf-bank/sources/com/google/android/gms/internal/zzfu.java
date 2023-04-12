package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzfu extends BroadcastReceiver {
    private /* synthetic */ zzft zzawn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfu(zzft zzftVar) {
        this.zzawn = zzftVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzawn.zzl(3);
    }
}
