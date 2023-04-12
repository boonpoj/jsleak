package com.mopub.mobileads.factories;

import android.content.Context;
import android.support.annotation.NonNull;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.HtmlBannerWebView;
/* loaded from: assets/classes2.dex */
public class HtmlBannerWebViewFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static HtmlBannerWebViewFactory f1178 = new HtmlBannerWebViewFactory();

    @NonNull
    public static HtmlBannerWebView create(Context context, AdReport adReport, CustomEventBanner.CustomEventBannerListener customEventBannerListener, String str) {
        return f1178.internalCreate(context, adReport, customEventBannerListener, str);
    }

    @Deprecated
    public static void setInstance(HtmlBannerWebViewFactory htmlBannerWebViewFactory) {
        f1178 = htmlBannerWebViewFactory;
    }

    public HtmlBannerWebView internalCreate(Context context, AdReport adReport, CustomEventBanner.CustomEventBannerListener customEventBannerListener, String str) {
        HtmlBannerWebView htmlBannerWebView = new HtmlBannerWebView(context, adReport);
        htmlBannerWebView.init(customEventBannerListener, str, adReport.getDspCreativeId());
        return htmlBannerWebView;
    }
}
