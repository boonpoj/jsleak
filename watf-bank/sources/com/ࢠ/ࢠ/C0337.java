package com.ࢠ.ࢠ;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
/* renamed from: com.ࢠ.ࢠ.ࢩ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0337 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static volatile Application f2383;

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static Application m1878() {
        return f2383;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1879(Application application, boolean z) {
        f2383 = application;
        m1884();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m1880(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static String m1881() {
        try {
            PackageManager packageManager = m1878().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(m1878().getPackageName(), 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static boolean m1882(@NonNull Context context, @NonNull String str) {
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public static long m1883() {
        long m1812 = C0318.m1810().m1812("O4bkh3KjWhGf6xD6TeAJJGQhINzYyBr2SGKOpHWuoIU", 0L);
        if (m1812 == 0) {
            try {
                return f2383.getPackageManager().getPackageInfo(f2383.getPackageName(), 0).firstInstallTime;
            } catch (Throwable unused) {
                return System.currentTimeMillis();
            }
        }
        return m1812;
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static void m1884() {
        if (C0318.m1810().m1812("O4bkh3KjWhGf6xD6TeAJJGQhINzYyBr2SGKOpHWuoIU", 0L) == 0) {
            C0318.m1810().m1814("O4bkh3KjWhGf6xD6TeAJJGQhINzYyBr2SGKOpHWuoIU", System.currentTimeMillis());
        }
    }
}
