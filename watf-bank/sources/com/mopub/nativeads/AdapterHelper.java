package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;
/* loaded from: assets/classes2.dex */
public final class AdapterHelper {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final WeakReference<Context> f1420;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Context f1421;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final int f1422;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final int f1423;

    public AdapterHelper(@NonNull Context context, int i, int i2) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkArgument(i >= 0, "start position must be non-negative");
        Preconditions.checkArgument(i2 >= 2, "interval must be at least 2");
        this.f1420 = new WeakReference<>(context);
        this.f1421 = context.getApplicationContext();
        this.f1422 = i;
        this.f1423 = i2;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int m1250(int i) {
        if (i <= this.f1422) {
            return 0;
        }
        double d = i - this.f1422;
        double d2 = this.f1423;
        Double.isNaN(d);
        Double.isNaN(d2);
        return ((int) Math.floor(d / d2)) + 1;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int m1251(int i) {
        if (i <= this.f1422) {
            return 0;
        }
        int i2 = this.f1423 - 1;
        if ((i - this.f1422) % i2 == 0) {
            return (i - this.f1422) / i2;
        }
        double d = i - this.f1422;
        double d2 = i2;
        Double.isNaN(d);
        Double.isNaN(d2);
        return ((int) Math.floor(d / d2)) + 1;
    }

    @NonNull
    public View getAdView(@Nullable View view, @Nullable ViewGroup viewGroup, @Nullable NativeAd nativeAd) {
        return getAdView(view, viewGroup, nativeAd, null);
    }

    @NonNull
    public View getAdView(@Nullable View view, @Nullable ViewGroup viewGroup, @Nullable NativeAd nativeAd, @Nullable ViewBinder viewBinder) {
        Context context = this.f1420.get();
        if (context == null) {
            MoPubLog.w("Weak reference to Context in AdapterHelper became null. Returning empty view.");
            return new View(this.f1421);
        }
        return C0281.m1514(view, viewGroup, context, nativeAd);
    }

    public boolean isAdPosition(int i) {
        return i >= this.f1422 && (i - this.f1422) % this.f1423 == 0;
    }

    public int shiftedCount(int i) {
        return i + m1251(i);
    }

    public int shiftedPosition(int i) {
        return i - m1250(i);
    }
}
