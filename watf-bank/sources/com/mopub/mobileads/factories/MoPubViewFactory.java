package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.MoPubView;
/* loaded from: assets/classes2.dex */
public class MoPubViewFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static MoPubViewFactory f1180 = new MoPubViewFactory();

    public static MoPubView create(Context context) {
        return f1180.m1005(context);
    }

    @VisibleForTesting
    @Deprecated
    public static void setInstance(MoPubViewFactory moPubViewFactory) {
        f1180 = moPubViewFactory;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected MoPubView m1005(Context context) {
        return new MoPubView(context);
    }
}
