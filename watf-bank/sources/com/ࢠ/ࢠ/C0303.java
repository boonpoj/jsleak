package com.ࢠ.ࢠ;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import defpackage.PixelActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
/* renamed from: com.ࢠ.ࢠ.֏  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0303 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static final List<ࢤ> f2246 = new ArrayList<ࢤ>() { // from class: com.ࢠ.ࢠ.֏.1
        {
            add(ࢤ.ࢢ);
            add(ࢤ.ࢠ);
            add(ࢤ.ࢥ);
        }
    };

    /* renamed from: ࢢ  reason: contains not printable characters */
    private WeakReference<Activity> f2247;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private C0304 f2248;

    public C0303(Activity activity, int i) {
        this.f2247 = null;
        this.f2248 = null;
        this.f2247 = new WeakReference<>(activity);
        if (C0306.m1748().m1752() < C0338.m1885().m1890() && !C0339.m1902().m1907()) {
            if (new Random(System.currentTimeMillis()).nextInt(100) > ((int) C0338.m1885().m1893()) || Build.VERSION.SDK_INT > 24) {
                this.f2248 = new C0304(activity);
                return;
            }
            try {
                C0339.m1902().m1906(i);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static String m1718() {
        return C0309.m1774("LB4u8AFs0fKz9cZBiw9P8g");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1719(Context context, int i) {
        if (C0327.m1834(context) && C0327.m1836(context) && C0338.m1885().m1888()) {
            if (new Random(System.currentTimeMillis()).nextInt(100) > C0338.m1885().m1886(Calendar.getInstance().get(11))) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - C0337.m1883();
            if (currentTimeMillis < 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis < C0338.m1885().m1889() * 1000) {
                return;
            }
            Intent intent = new Intent(context, PixelActivity.class);
            intent.setFlags(335544320);
            intent.putExtra("step", i);
            context.startActivity(intent);
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static String m1720() {
        return "LB4u8AFs0fKz9cZBiw9P8g";
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m1721() {
        if (this.f2248 != null) {
            this.f2248.m1734();
            return;
        }
        try {
            Activity activity = this.f2247.get();
            if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            activity.finish();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m1722() {
        if (this.f2248 != null) {
            this.f2248.m1735();
        }
    }
}
