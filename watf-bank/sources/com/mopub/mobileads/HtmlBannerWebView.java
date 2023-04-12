package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBanner;
/* loaded from: assets/classes2.dex */
public class HtmlBannerWebView extends BaseHtmlWebView {
    public static final String EXTRA_AD_CLICK_DATA = "com.mopub.intent.extra.AD_CLICK_DATA";

    /* renamed from: com.mopub.mobileads.HtmlBannerWebView$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0202 implements HtmlWebViewListener {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final CustomEventBanner.CustomEventBannerListener f866;

        public C0202(CustomEventBanner.CustomEventBannerListener customEventBannerListener) {
            this.f866 = customEventBannerListener;
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public void onClicked() {
            this.f866.onBannerClicked();
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public void onCollapsed() {
            this.f866.onBannerCollapsed();
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public void onFailed(MoPubErrorCode moPubErrorCode) {
            this.f866.onBannerFailed(moPubErrorCode);
        }

        @Override // com.mopub.mobileads.HtmlWebViewListener
        public void onLoaded(BaseHtmlWebView baseHtmlWebView) {
            this.f866.onBannerLoaded(baseHtmlWebView);
        }
    }

    public HtmlBannerWebView(Context context, AdReport adReport) {
        super(context, adReport);
    }

    public void init(CustomEventBanner.CustomEventBannerListener customEventBannerListener, String str, String str2) {
        super.init();
        setWebViewClient(new C0237(new C0202(customEventBannerListener), this, str, str2));
    }
}
