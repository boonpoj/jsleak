package com.integralads.avid.library.mopub.utils;

import android.text.TextUtils;
import android.util.Log;
import com.mopub.mobileads.VastExtensionXmlManager;
/* loaded from: assets/classes2.dex */
public class AvidLogs {
    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.d(VastExtensionXmlManager.AVID, str);
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(VastExtensionXmlManager.AVID, str);
    }

    public static void e(String str, Exception exc) {
        if (TextUtils.isEmpty(str) && exc == null) {
            return;
        }
        Log.e(VastExtensionXmlManager.AVID, str, exc);
    }

    public static void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.i(VastExtensionXmlManager.AVID, str);
    }

    public static void w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.w(VastExtensionXmlManager.AVID, str);
    }
}
