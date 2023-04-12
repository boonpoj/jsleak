package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubView;
/* loaded from: assets/classes2.dex */
public class AdViewControllerFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static AdViewControllerFactory f1173 = new AdViewControllerFactory();

    public static AdViewController create(Context context, MoPubView moPubView) {
        return f1173.m1000(context, moPubView);
    }

    @Deprecated
    public static void setInstance(AdViewControllerFactory adViewControllerFactory) {
        f1173 = adViewControllerFactory;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected AdViewController m1000(Context context, MoPubView moPubView) {
        return new AdViewController(context, moPubView);
    }
}
