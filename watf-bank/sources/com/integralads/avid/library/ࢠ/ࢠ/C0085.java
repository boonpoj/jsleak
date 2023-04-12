package com.integralads.avid.library.ࢠ.ࢠ;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.view.Window;
import com.integralads.avid.library.ࢠ.ࢪ.C0158;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.integralads.avid.library.ࢠ.ࢠ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0085 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0085 f122 = new C0085();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final ArrayList<C0158> f123 = new ArrayList<>();

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0085 m84() {
        return f122;
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    private View m85(C0158 c0158) {
        Window window;
        Activity activity = c0158.m322();
        if (activity == null || (window = activity.getWindow()) == null || !activity.hasWindowFocus()) {
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView == null || !decorView.isShown()) {
            return null;
        }
        return decorView;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m86(Activity activity) {
        if (m88(activity) == null) {
            this.f123.add(new C0158(activity));
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean m87(C0158 c0158) {
        Activity activity = c0158.m322();
        if (activity == null) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 17 ? activity.isDestroyed() : activity.isFinishing();
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    C0158 m88(Activity activity) {
        Iterator<C0158> it = this.f123.iterator();
        while (it.hasNext()) {
            C0158 next = it.next();
            if (next.m325(activity)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public List<View> m89() {
        ArrayList arrayList = new ArrayList();
        Iterator<C0158> it = this.f123.iterator();
        View view = null;
        while (it.hasNext()) {
            C0158 next = it.next();
            if (m87(next)) {
                it.remove();
            } else {
                View m85 = m85(next);
                if (m85 != null) {
                    view = m85;
                }
            }
        }
        if (view != null) {
            arrayList.add(view);
        }
        return arrayList;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m90() {
        this.f123.clear();
    }
}
