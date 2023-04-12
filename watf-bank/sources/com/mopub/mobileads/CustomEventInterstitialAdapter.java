package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.WebViewCacheService;
import com.mopub.mobileads.factories.CustomEventInterstitialFactory;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: assets/classes2.dex */
public class CustomEventInterstitialAdapter implements CustomEventInterstitial.CustomEventInterstitialListener {
    public static final int DEFAULT_INTERSTITIAL_TIMEOUT_DELAY = 30000;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final MoPubInterstitial f828;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean f829;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private InterfaceC0197 f830;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private CustomEventInterstitial f831;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Context f832;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private Map<String, Object> f833;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private Map<String, String> f834;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private long f835;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final Handler f836;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final Runnable f837;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.CustomEventInterstitialAdapter$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0197 {
        void onCustomEventInterstitialClicked();

        void onCustomEventInterstitialDismissed();

        void onCustomEventInterstitialFailed(MoPubErrorCode moPubErrorCode);

        void onCustomEventInterstitialImpression();

        void onCustomEventInterstitialLoaded();

        void onCustomEventInterstitialShown();
    }

    public CustomEventInterstitialAdapter(@NonNull MoPubInterstitial moPubInterstitial, @NonNull String str, @NonNull Map<String, String> map, long j, @Nullable AdReport adReport) {
        Preconditions.checkNotNull(map);
        this.f836 = new Handler();
        this.f828 = moPubInterstitial;
        this.f835 = j;
        this.f832 = this.f828.getActivity();
        this.f837 = new Runnable() { // from class: com.mopub.mobileads.CustomEventInterstitialAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                MoPubLog.d("Third-party network timed out.");
                CustomEventInterstitialAdapter.this.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
                CustomEventInterstitialAdapter.this.m752();
            }
        };
        MoPubLog.d("Attempting to invoke custom event: " + str);
        try {
            this.f831 = CustomEventInterstitialFactory.create(str);
            this.f834 = new TreeMap(map);
            this.f833 = this.f828.getLocalExtras();
            if (this.f828.getLocation() != null) {
                this.f833.put("location", this.f828.getLocation());
            }
            this.f833.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(j));
            this.f833.put(DataKeys.AD_REPORT_KEY, adReport);
        } catch (Exception unused) {
            MoPubLog.d("Couldn't locate or instantiate custom event: " + str + ".");
            this.f828.onCustomEventInterstitialFailed(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private void m747() {
        this.f836.removeCallbacks(this.f837);
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    private int m748() {
        if (this.f828 == null) {
            return 30000;
        }
        return this.f828.m791(30000).intValue();
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialClicked() {
        if (m753() || this.f830 == null) {
            return;
        }
        this.f830.onCustomEventInterstitialClicked();
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialDismissed() {
        if (m753() || this.f830 == null) {
            return;
        }
        this.f830.onCustomEventInterstitialDismissed();
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        if (m753() || this.f830 == null) {
            return;
        }
        if (moPubErrorCode == null) {
            moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
        }
        m747();
        this.f830.onCustomEventInterstitialFailed(moPubErrorCode);
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialImpression() {
        if (m753() || this.f830 == null) {
            return;
        }
        this.f830.onCustomEventInterstitialImpression();
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialLoaded() {
        if (m753()) {
            return;
        }
        m747();
        if (this.f830 != null) {
            this.f830.onCustomEventInterstitialLoaded();
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onInterstitialShown() {
        if (m753() || this.f830 == null) {
            return;
        }
        this.f830.onCustomEventInterstitialShown();
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
    public void onLeaveApplication() {
        onInterstitialClicked();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m749() {
        if (m753() || this.f831 == null) {
            return;
        }
        this.f836.postDelayed(this.f837, m748());
        try {
            this.f831.loadInterstitial(this.f832, this, this.f833, this.f834);
        } catch (Exception e) {
            MoPubLog.d("Loading a custom event interstitial threw an exception.", e);
            onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m750(InterfaceC0197 interfaceC0197) {
        this.f830 = interfaceC0197;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m751() {
        if (m753() || this.f831 == null) {
            return;
        }
        try {
            this.f831.showInterstitial();
        } catch (Exception e) {
            MoPubLog.d("Showing a custom event interstitial threw an exception.", e);
            onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m752() {
        if (this.f831 != null) {
            try {
                this.f831.onInvalidate();
            } catch (Exception e) {
                MoPubLog.d("Invalidating a custom event interstitial threw an exception.", e);
            }
        }
        this.f831 = null;
        this.f832 = null;
        this.f834 = null;
        this.f833 = null;
        this.f830 = null;
        WebViewCacheService.Config popWebViewConfig = WebViewCacheService.popWebViewConfig(Long.valueOf(this.f835));
        if (popWebViewConfig != null) {
            popWebViewConfig.getWebView().destroy();
        }
        this.f829 = true;
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    boolean m753() {
        return this.f829;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public boolean m754() {
        CustomEventInterstitial customEventInterstitial = this.f831;
        if (customEventInterstitial == null) {
            return true;
        }
        return customEventInterstitial.m746();
    }
}
