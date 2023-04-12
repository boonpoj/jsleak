package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzha implements zzhc {
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ Bundle zzail;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzha(zzgu zzguVar, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzail = bundle;
    }

    @Override // com.google.android.gms.internal.zzhc
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzail);
    }
}
