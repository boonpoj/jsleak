package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzgr extends BroadcastReceiver {
    private /* synthetic */ zzgp zzaxn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgr(zzgp zzgpVar) {
        this.zzaxn = zzgpVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzaxn.zzm(3);
    }
}
