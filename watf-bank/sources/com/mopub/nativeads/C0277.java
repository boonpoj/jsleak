package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.factories.CustomEventNativeFactory;
import com.mopub.network.AdResponse;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.nativeads.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0277 {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Handler f1901;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Runnable f1902;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private CustomEventNative f1903;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private CustomEventNative.CustomEventNativeListener f1904;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private volatile boolean f1905;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0277(@NonNull CustomEventNative.CustomEventNativeListener customEventNativeListener) {
        Preconditions.checkNotNull(customEventNativeListener);
        this.f1904 = customEventNativeListener;
        this.f1905 = false;
        this.f1901 = new Handler();
        this.f1902 = new Runnable() { // from class: com.mopub.nativeads.ࢢ.1
            @Override // java.lang.Runnable
            public void run() {
                if (C0277.this.f1905) {
                    return;
                }
                MoPubLog.d("Timeout loading native ad content. " + C0277.this.toString());
                C0277.this.m1496();
                C0277.this.f1904.onNativeAdFailed(NativeErrorCode.NETWORK_TIMEOUT);
            }
        };
    }

    @NonNull
    /* renamed from: ࢢ  reason: contains not printable characters */
    private CustomEventNative.CustomEventNativeListener m1492() {
        return new CustomEventNative.CustomEventNativeListener() { // from class: com.mopub.nativeads.ࢢ.2
            @Override // com.mopub.nativeads.CustomEventNative.CustomEventNativeListener
            public void onNativeAdFailed(NativeErrorCode nativeErrorCode) {
                if (C0277.this.f1905) {
                    return;
                }
                C0277.this.m1494();
                C0277.this.f1904.onNativeAdFailed(nativeErrorCode);
            }

            @Override // com.mopub.nativeads.CustomEventNative.CustomEventNativeListener
            public void onNativeAdLoaded(BaseNativeAd baseNativeAd) {
                if (C0277.this.f1905) {
                    return;
                }
                C0277.this.m1494();
                C0277.this.f1904.onNativeAdLoaded(baseNativeAd);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public synchronized void m1494() {
        if (!this.f1905) {
            this.f1905 = true;
            this.f1901.removeCallbacks(this.f1902);
            this.f1903 = null;
        }
    }

    public void loadNativeAd(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull AdResponse adResponse) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(map);
        Preconditions.checkNotNull(adResponse);
        String customEventClassName = adResponse.getCustomEventClassName();
        MoPubLog.d("Attempting to invoke custom event: " + customEventClassName);
        try {
            this.f1903 = CustomEventNativeFactory.create(customEventClassName);
            if (adResponse.hasJson()) {
                map.put(DataKeys.JSON_BODY_KEY, adResponse.getJsonBody());
            }
            map.put(DataKeys.CLICK_TRACKING_URL_KEY, adResponse.getClickTrackingUrl());
            try {
                this.f1903.mo1268(context, m1492(), map, adResponse.getServerExtras());
                this.f1901.postDelayed(this.f1902, adResponse.getAdTimeoutMillis(30000).intValue());
            } catch (Exception e) {
                MoPubLog.w("Loading custom event native threw an error.", e);
                this.f1904.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
            }
        } catch (Exception unused) {
            MoPubLog.e("Failed to load Custom Event Native class: " + customEventClassName);
            this.f1904.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1496() {
        try {
            if (this.f1903 != null) {
                this.f1903.mo1302();
            }
        } catch (Exception e) {
            MoPubLog.e(e.toString());
        }
        m1494();
    }
}
