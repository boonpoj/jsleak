package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.֏  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0342 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final C0342 f2402 = new C0342();

    /* renamed from: ࢥ  reason: contains not printable characters */
    private ScheduledFuture<?> f2406;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private ScheduledFuture<?> f2407;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final ScheduledExecutorService f2405 = Executors.newScheduledThreadPool(1);

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Map<C0343, String> f2403 = new WeakHashMap();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Map<AbstractC0383, String> f2404 = new WeakHashMap();

    private C0342() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0342 m1916() {
        return f2402;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final void m1921(final Context context, C0343 c0343) {
        if (c0343 != null) {
            this.f2403.put(c0343, "");
            if (this.f2407 == null || this.f2407.isDone()) {
                C0379.m2046(3, "JSUpdateLooper", this, "Starting metadata reporting loop");
                this.f2407 = this.f2405.scheduleWithFixedDelay(new Runnable() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.֏.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent("UPDATE_METADATA"));
                            if (C0342.this.f2403.isEmpty()) {
                                C0342.this.f2407.cancel(true);
                            }
                        } catch (Exception e) {
                            C0348.m1974(e);
                        }
                    }
                }, 0L, 50L, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final void m1922(final Context context, AbstractC0383 abstractC0383) {
        if (abstractC0383 != null) {
            C0379.m2046(3, "JSUpdateLooper", this, "addActiveTracker" + abstractC0383.hashCode());
            if (this.f2404.containsKey(abstractC0383)) {
                return;
            }
            this.f2404.put(abstractC0383, "");
            if (this.f2406 == null || this.f2406.isDone()) {
                C0379.m2046(3, "JSUpdateLooper", this, "Starting view update loop");
                this.f2406 = this.f2405.scheduleWithFixedDelay(new Runnable() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.֏.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent("UPDATE_VIEW_INFO"));
                            if (C0342.this.f2404.isEmpty()) {
                                C0379.m2046(3, "JSUpdateLooper", C0342.this, "No more active trackers");
                                C0342.this.f2406.cancel(true);
                            }
                        } catch (Exception e) {
                            C0348.m1974(e);
                        }
                    }
                }, 0L, C0355.m2002().f2489, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final void m1923(C0343 c0343) {
        if (c0343 != null) {
            C0379.m2046(3, "JSUpdateLooper", this, "removeSetupNeededBridge" + c0343.hashCode());
            this.f2403.remove(c0343);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final void m1924(AbstractC0383 abstractC0383) {
        if (abstractC0383 != null) {
            C0379.m2046(3, "JSUpdateLooper", this, "removeActiveTracker" + abstractC0383.hashCode());
            this.f2404.remove(abstractC0383);
        }
    }
}
