package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
@zzzv
/* loaded from: classes.dex */
final class zzafr {
    private long zzcyi = -1;
    private long zzcyj = -1;

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzcyi);
        bundle.putLong("tclose", this.zzcyj);
        return bundle;
    }

    public final long zzor() {
        return this.zzcyj;
    }

    public final void zzos() {
        this.zzcyj = SystemClock.elapsedRealtime();
    }

    public final void zzot() {
        this.zzcyi = SystemClock.elapsedRealtime();
    }
}
