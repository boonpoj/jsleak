package com.integralads.avid.library.ࢠ.ࢧ;

import android.os.Build;
import android.view.View;
/* renamed from: com.integralads.avid.library.ࢠ.ࢧ.ࢥ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0143 {
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m279(View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        return Build.VERSION.SDK_INT < 11 || ((double) view.getAlpha()) > 0.0d;
    }
}
