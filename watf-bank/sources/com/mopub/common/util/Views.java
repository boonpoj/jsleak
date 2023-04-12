package com.mopub.common.util;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.logging.MoPubLog;
/* loaded from: assets/classes2.dex */
public class Views {
    @Nullable
    public static View getTopmostView(@Nullable Context context, @Nullable View view) {
        View m594 = m594(context);
        return m594 != null ? m594 : m595(view);
    }

    public static void removeFromParent(@Nullable View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private static View m594(@Nullable Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        }
        return null;
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private static View m595(@Nullable View view) {
        if (view == null) {
            return null;
        }
        if (!ViewCompat.isAttachedToWindow(view)) {
            MoPubLog.d("Attempting to call View#getRootView() on an unattached View.");
        }
        View rootView = view.getRootView();
        if (rootView == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        return findViewById != null ? findViewById : rootView;
    }
}
