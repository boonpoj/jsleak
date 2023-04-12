package com.mopub.mobileads;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryAgentListener;
/* loaded from: assets/classes2.dex */
public final class FlurryAgentWrapper {
    public static final String PARAM_AD_SPACE_NAME = "adSpaceName";
    public static final String PARAM_API_KEY = "apiKey";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private FlurryAgent.Builder f841;

    /* renamed from: com.mopub.mobileads.FlurryAgentWrapper$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static class C0198 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private static final FlurryAgentWrapper f842 = new FlurryAgentWrapper();
    }

    private FlurryAgentWrapper() {
        this.f841 = new FlurryAgent.Builder().withLogEnabled(false).withLogLevel(2);
        FlurryAgent.addOrigin("Flurry_Mopub_Android", "6.5.0");
    }

    public static FlurryAgentWrapper getInstance() {
        return C0198.f842;
    }

    public synchronized void endSession(Context context) {
        if (context != null) {
            if (FlurryAgent.isSessionActive()) {
                if (Build.VERSION.SDK_INT >= 14) {
                    return;
                }
                FlurryAgent.onEndSession(context);
            }
        }
    }

    public synchronized boolean isSessionActive() {
        return FlurryAgent.isSessionActive();
    }

    public synchronized void startSession(@NonNull Context context, String str, @Nullable FlurryAgentListener flurryAgentListener) {
        if (!TextUtils.isEmpty(str) && !FlurryAgent.isSessionActive()) {
            this.f841.withListener(flurryAgentListener).build(context, str);
            if (Build.VERSION.SDK_INT >= 14) {
                return;
            }
            FlurryAgent.onStartSession(context);
        }
    }
}
