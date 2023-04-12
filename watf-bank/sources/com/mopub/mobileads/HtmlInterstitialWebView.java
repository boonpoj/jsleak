package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitial;
/* loaded from: assets/classes2.dex */
public class HtmlInterstitialWebView extends BaseHtmlWebView {

    /* renamed from: ࢢ  reason: contains not printable characters */
    private Handler f870;

    /* renamed from: com.mopub.mobileads.HtmlInterstitialWebView$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0203 implements HtmlWebViewListener {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final CustomEventInterstitial.CustomEventInterstitialListener f871;

        public C0203(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
            this.f871 = customEventInterstitialListener;
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public void onClicked() {
            this.f871.onInterstitialClicked();
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public void onCollapsed() {
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public void onFailed(MoPubErrorCode moPubErrorCode) {
            this.f871.onInterstitialFailed(moPubErrorCode);
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public void onLoaded(BaseHtmlWebView baseHtmlWebView) {
            this.f871.onInterstitialLoaded();
        }
    }

    public HtmlInterstitialWebView(Context context, AdReport adReport) {
        super(context, adReport);
        this.f870 = new Handler();
    }

    public void init(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, String str, String str2) {
        super.init();
        setWebViewClient(new C0237(new C0203(customEventInterstitialListener), this, str, str2));
    }
}
