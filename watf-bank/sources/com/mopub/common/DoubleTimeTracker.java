package com.mopub.common;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.mopub.common.logging.MoPubLog;
/* loaded from: assets/classes2.dex */
public class DoubleTimeTracker {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private volatile EnumC0168 f354;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private long f355;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private long f356;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Clock f357;

    /* loaded from: assets/classes2.dex */
    public interface Clock {
        long elapsedRealTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.common.DoubleTimeTracker$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0168 {
        STARTED,
        PAUSED
    }

    /* renamed from: com.mopub.common.DoubleTimeTracker$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static class C0169 implements Clock {
        private C0169() {
        }

        @Override // com.mopub.common.DoubleTimeTracker.Clock
        public long elapsedRealTime() {
            return SystemClock.elapsedRealtime();
        }
    }

    public DoubleTimeTracker() {
        this(new C0169());
    }

    @VisibleForTesting
    public DoubleTimeTracker(@NonNull Clock clock) {
        this.f357 = clock;
        this.f354 = EnumC0168.PAUSED;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private synchronized long m422() {
        return this.f354 == EnumC0168.PAUSED ? 0L : this.f357.elapsedRealTime() - this.f355;
    }

    public synchronized double getInterval() {
        return this.f356 + m422();
    }

    public synchronized void pause() {
        if (this.f354 == EnumC0168.PAUSED) {
            MoPubLog.v("DoubleTimeTracker already paused.");
            return;
        }
        this.f356 += m422();
        this.f355 = 0L;
        this.f354 = EnumC0168.PAUSED;
    }

    public synchronized void start() {
        if (this.f354 == EnumC0168.STARTED) {
            MoPubLog.v("DoubleTimeTracker already started.");
            return;
        }
        this.f354 = EnumC0168.STARTED;
        this.f355 = this.f357.elapsedRealTime();
    }
}
