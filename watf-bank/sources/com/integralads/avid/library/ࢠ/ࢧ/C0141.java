package com.integralads.avid.library.ࢠ.ࢧ;

import android.text.TextUtils;
import android.util.Log;
import com.mopub.mobileads.VastExtensionXmlManager;
/* renamed from: com.integralads.avid.library.ࢠ.ࢧ.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0141 {
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m276(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(VastExtensionXmlManager.AVID, str);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m277(String str, Exception exc) {
        if (TextUtils.isEmpty(str) && exc == null) {
            return;
        }
        Log.e(VastExtensionXmlManager.AVID, str, exc);
    }
}
