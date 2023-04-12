package com.integralads.avid.library.ࢠ.ࢧ;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* renamed from: com.integralads.avid.library.ࢠ.ࢧ.ࢦ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0144 {
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m280(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
