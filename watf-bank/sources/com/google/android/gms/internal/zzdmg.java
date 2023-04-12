package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdmg extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmg(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = zzdmf.zzlne;
        atomicBoolean.set(true);
    }
}
