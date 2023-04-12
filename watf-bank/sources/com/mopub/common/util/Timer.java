package com.mopub.common.util;

import java.util.concurrent.TimeUnit;
/* loaded from: assets/classes2.dex */
public class Timer {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private long f639;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private long f640;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private EnumC0185 f641 = EnumC0185.STOPPED;

    /* renamed from: com.mopub.common.util.Timer$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private enum EnumC0185 {
        STARTED,
        STOPPED
    }

    public long getTime() {
        return TimeUnit.MILLISECONDS.convert((this.f641 == EnumC0185.STARTED ? System.nanoTime() : this.f639) - this.f640, TimeUnit.NANOSECONDS);
    }

    public void start() {
        this.f640 = System.nanoTime();
        this.f641 = EnumC0185.STARTED;
    }

    public void stop() {
        if (this.f641 != EnumC0185.STARTED) {
            throw new IllegalStateException("EventTimer was not started.");
        }
        this.f641 = EnumC0185.STOPPED;
        this.f639 = System.nanoTime();
    }
}
