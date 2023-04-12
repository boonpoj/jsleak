package com.ࢠ.ࢠ;

import android.content.Context;
import android.content.SharedPreferences;
/* renamed from: com.ࢠ.ࢠ.މ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0318 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0318 f2321;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private SharedPreferences f2322;

    private C0318(Context context) {
        this.f2322 = context.getSharedPreferences(context.getPackageName() + "_pref", 0);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0318 m1810() {
        if (f2321 == null) {
            m1811(C0337.m1878());
        }
        return f2321;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1811(Context context) {
        if (f2321 == null) {
            synchronized (C0318.class) {
                f2321 = new C0318(context);
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public long m1812(String str, long j) {
        return this.f2322.getLong(str, j);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m1813(String str, String str2) {
        return this.f2322.getString(str, str2);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1814(String str, long j) {
        this.f2322.edit().putLong(str, j).apply();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1815(String str, String str2) {
        this.f2322.edit().putString(str, str2).apply();
    }
}
