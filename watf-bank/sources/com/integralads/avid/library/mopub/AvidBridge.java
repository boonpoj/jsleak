package com.integralads.avid.library.mopub;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: assets/classes2.dex */
public class AvidBridge {
    public static final String APP_STATE_ACTIVE = "active";
    public static final String APP_STATE_INACTIVE = "inactive";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String f0;

    public static void cleanUpAvidJS() {
        f0 = null;
    }

    public static String getAvidJs() {
        return f0;
    }

    public static boolean isAvidJsReady() {
        return !TextUtils.isEmpty(f0);
    }

    public static void setAvidJs(@NonNull String str) {
        f0 = str;
    }
}
