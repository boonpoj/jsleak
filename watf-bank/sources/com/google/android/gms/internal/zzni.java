package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzni implements Callable<Void> {
    private /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzni(Context context) {
        this.val$context = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        zzkb.zzif().initialize(this.val$context);
        return null;
    }
}
