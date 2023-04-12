package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class WebViewCacheService {
    @NonNull
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static final Map<Long, Config> f1168 = Collections.synchronizedMap(new HashMap());
    @NonNull
    @VisibleForTesting

    /* renamed from: ࢠ  reason: contains not printable characters */
    static final RunnableC0215 f1167 = new RunnableC0215();
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static Handler f1169 = new Handler();

    /* loaded from: assets/classes2.dex */
    public static class Config {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final BaseWebView f1170;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final WeakReference<Interstitial> f1171;
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final ExternalViewabilitySessionManager f1172;

        Config(@NonNull BaseWebView baseWebView, @NonNull Interstitial interstitial, @NonNull ExternalViewabilitySessionManager externalViewabilitySessionManager) {
            this.f1170 = baseWebView;
            this.f1171 = new WeakReference<>(interstitial);
            this.f1172 = externalViewabilitySessionManager;
        }

        @NonNull
        public ExternalViewabilitySessionManager getViewabilityManager() {
            return this.f1172;
        }

        @NonNull
        public WeakReference<Interstitial> getWeakInterstitial() {
            return this.f1171;
        }

        @NonNull
        public BaseWebView getWebView() {
            return this.f1170;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.mobileads.WebViewCacheService$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class RunnableC0215 implements Runnable {
        private RunnableC0215() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebViewCacheService.m999();
        }
    }

    private WebViewCacheService() {
    }

    @VisibleForTesting
    @Deprecated
    public static void clearAll() {
        f1168.clear();
        f1169.removeCallbacks(f1167);
    }

    @Nullable
    public static Config popWebViewConfig(@NonNull Long l) {
        Preconditions.checkNotNull(l);
        return f1168.remove(l);
    }

    @VisibleForTesting
    public static void storeWebViewConfig(@NonNull Long l, @NonNull Interstitial interstitial, @NonNull BaseWebView baseWebView, @NonNull ExternalViewabilitySessionManager externalViewabilitySessionManager) {
        Preconditions.checkNotNull(l);
        Preconditions.checkNotNull(interstitial);
        Preconditions.checkNotNull(baseWebView);
        m999();
        if (f1168.size() >= 50) {
            MoPubLog.w("Unable to cache web view. Please destroy some via MoPubInterstitial#destroy() and try again.");
        } else {
            f1168.put(l, new Config(baseWebView, interstitial, externalViewabilitySessionManager));
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static synchronized void m999() {
        synchronized (WebViewCacheService.class) {
            Iterator<Map.Entry<Long, Config>> it = f1168.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Long, Config> next = it.next();
                if (next.getValue().getWeakInterstitial().get() == null) {
                    next.getValue().getViewabilityManager().endDisplaySession();
                    it.remove();
                }
            }
            if (!f1168.isEmpty()) {
                f1169.removeCallbacks(f1167);
                f1169.postDelayed(f1167, 900000L);
            }
        }
    }
}
