package com.mopub.mobileads;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
/* loaded from: assets/classes2.dex */
public class VastVideoViewCountdownRunnable extends RepeatingHandlerRunnable {
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final VastVideoViewController f1147;

    public VastVideoViewCountdownRunnable(@NonNull VastVideoViewController vastVideoViewController, @NonNull Handler handler) {
        super(handler);
        Preconditions.checkNotNull(handler);
        Preconditions.checkNotNull(vastVideoViewController);
        this.f1147 = vastVideoViewController;
    }

    @Override // com.mopub.mobileads.RepeatingHandlerRunnable
    public void doWork() {
        this.f1147.m959();
        if (this.f1147.m971()) {
            this.f1147.m970();
        }
    }
}
