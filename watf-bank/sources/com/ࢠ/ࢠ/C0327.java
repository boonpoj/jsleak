package com.ࢠ.ࢠ;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import java.util.ArrayList;
/* renamed from: com.ࢠ.ࢠ.ތ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0327 {
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static final boolean m1834(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return Build.VERSION.SDK_INT < 20 ? powerManager.isScreenOn() : powerManager.isInteractive();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m1835(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ArrayList arrayList = (ArrayList) ((ActivityManager) context.getSystemService("activity")).getRunningServices(30);
            for (int i = 0; i < arrayList.size(); i++) {
                if (((ActivityManager.RunningServiceInfo) arrayList.get(i)).service.getClassName().equals(str)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static final boolean m1836(Context context) {
        if (C0337.m1882(context, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return true;
    }
}
