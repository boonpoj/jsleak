package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.PathInterpolatorCompat;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNative;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.mopub.nativeads.ࢤ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0279 {
    @VisibleForTesting

    /* renamed from: ࢠ  reason: contains not printable characters */
    static final int[] f1916 = {1000, PathInterpolatorCompat.MAX_NUM_POINTS, 5000, 25000, 60000, 300000};
    @NonNull

    /* renamed from: ֏  reason: contains not printable characters */
    private final AdRendererRegistry f1917;
    @VisibleForTesting

    /* renamed from: ࢢ  reason: contains not printable characters */
    boolean f1918;
    @VisibleForTesting

    /* renamed from: ࢣ  reason: contains not printable characters */
    boolean f1919;
    @VisibleForTesting

    /* renamed from: ࢤ  reason: contains not printable characters */
    int f1920;
    @VisibleForTesting

    /* renamed from: ࢥ  reason: contains not printable characters */
    int f1921;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final List<C0289<NativeAd>> f1922;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final Handler f1923;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final Runnable f1924;
    @NonNull

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final MoPubNative.MoPubNativeNetworkListener f1925;
    @Nullable

    /* renamed from: ࢪ  reason: contains not printable characters */
    private InterfaceC0280 f1926;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private RequestParameters f1927;
    @Nullable

    /* renamed from: ࢬ  reason: contains not printable characters */
    private MoPubNative f1928;

    /* renamed from: com.mopub.nativeads.ࢤ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    interface InterfaceC0280 {
        void onAdsAvailable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0279() {
        this(new ArrayList(1), new Handler(), new AdRendererRegistry());
    }

    @VisibleForTesting
    C0279(@NonNull List<C0289<NativeAd>> list, @NonNull Handler handler, @NonNull AdRendererRegistry adRendererRegistry) {
        this.f1922 = list;
        this.f1923 = handler;
        this.f1924 = new Runnable() { // from class: com.mopub.nativeads.ࢤ.1
            @Override // java.lang.Runnable
            public void run() {
                C0279.this.f1919 = false;
                C0279.this.m1513();
            }
        };
        this.f1917 = adRendererRegistry;
        this.f1925 = new MoPubNative.MoPubNativeNetworkListener() { // from class: com.mopub.nativeads.ࢤ.2
            @Override // com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener
            public void onNativeFail(NativeErrorCode nativeErrorCode) {
                C0279.this.f1918 = false;
                if (C0279.this.f1921 >= C0279.f1916.length - 1) {
                    C0279.this.m1511();
                    return;
                }
                C0279.this.m1510();
                C0279.this.f1919 = true;
                C0279.this.f1923.postDelayed(C0279.this.f1924, C0279.this.m1512());
            }

            @Override // com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener
            public void onNativeLoad(@NonNull NativeAd nativeAd) {
                if (C0279.this.f1928 == null) {
                    return;
                }
                C0279.this.f1918 = false;
                C0279.this.f1920++;
                C0279.this.m1511();
                C0279.this.f1922.add(new C0289(nativeAd));
                if (C0279.this.f1922.size() == 1 && C0279.this.f1926 != null) {
                    C0279.this.f1926.onAdsAvailable();
                }
                C0279.this.m1513();
            }
        };
        this.f1920 = 0;
        m1511();
    }

    @Nullable
    public MoPubAdRenderer getAdRendererForViewType(int i) {
        return this.f1917.getRendererForViewType(i);
    }

    public int getViewTypeForAd(@NonNull NativeAd nativeAd) {
        return this.f1917.getViewTypeForAd(nativeAd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public int m1503() {
        return this.f1917.getAdRendererCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1504(@NonNull Activity activity, @NonNull String str, RequestParameters requestParameters) {
        m1506(requestParameters, new MoPubNative(activity, str, this.f1925));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1505(@NonNull MoPubAdRenderer moPubAdRenderer) {
        this.f1917.registerAdRenderer(moPubAdRenderer);
        if (this.f1928 != null) {
            this.f1928.registerAdRenderer(moPubAdRenderer);
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1506(RequestParameters requestParameters, MoPubNative moPubNative) {
        m1508();
        for (MoPubAdRenderer moPubAdRenderer : this.f1917.getRendererIterable()) {
            moPubNative.registerAdRenderer(moPubAdRenderer);
        }
        this.f1927 = requestParameters;
        this.f1928 = moPubNative;
        m1513();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1507(@Nullable InterfaceC0280 interfaceC0280) {
        this.f1926 = interfaceC0280;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1508() {
        if (this.f1928 != null) {
            this.f1928.destroy();
            this.f1928 = null;
        }
        this.f1927 = null;
        for (C0289<NativeAd> c0289 : this.f1922) {
            c0289.f1967.destroy();
        }
        this.f1922.clear();
        this.f1923.removeMessages(0);
        this.f1918 = false;
        this.f1920 = 0;
        m1511();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢣ  reason: contains not printable characters */
    public NativeAd m1509() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!this.f1918 && !this.f1919) {
            this.f1923.post(this.f1924);
        }
        while (!this.f1922.isEmpty()) {
            C0289<NativeAd> remove = this.f1922.remove(0);
            if (uptimeMillis - remove.f1968 < 14400000) {
                return remove.f1967;
            }
        }
        return null;
    }

    @VisibleForTesting
    /* renamed from: ࢤ  reason: contains not printable characters */
    void m1510() {
        if (this.f1921 < f1916.length - 1) {
            this.f1921++;
        }
    }

    @VisibleForTesting
    /* renamed from: ࢥ  reason: contains not printable characters */
    void m1511() {
        this.f1921 = 0;
    }

    @VisibleForTesting
    /* renamed from: ࢦ  reason: contains not printable characters */
    int m1512() {
        if (this.f1921 >= f1916.length) {
            this.f1921 = f1916.length - 1;
        }
        return f1916[this.f1921];
    }

    @VisibleForTesting
    /* renamed from: ࢧ  reason: contains not printable characters */
    void m1513() {
        if (this.f1918 || this.f1928 == null || this.f1922.size() >= 1) {
            return;
        }
        this.f1918 = true;
        this.f1928.makeRequest(this.f1927, Integer.valueOf(this.f1920));
    }
}
