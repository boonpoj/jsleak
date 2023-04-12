package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.HtmlInterstitialWebView;
/* loaded from: assets/classes2.dex */
public class HtmlInterstitialWebViewFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static HtmlInterstitialWebViewFactory f1179 = new HtmlInterstitialWebViewFactory();

    public static HtmlInterstitialWebView create(Context context, AdReport adReport, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, String str) {
        return f1179.internalCreate(context, adReport, customEventInterstitialListener, str);
    }

    @Deprecated
    public static void setInstance(HtmlInterstitialWebViewFactory htmlInterstitialWebViewFactory) {
        f1179 = htmlInterstitialWebViewFactory;
    }

    public HtmlInterstitialWebView internalCreate(Context context, AdReport adReport, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, String str) {
        HtmlInterstitialWebView htmlInterstitialWebView = new HtmlInterstitialWebView(context, adReport);
        htmlInterstitialWebView.init(customEventInterstitialListener, str, adReport.getDspCreativeId());
        return htmlInterstitialWebView;
    }
}
