package com.integralads.avid.library.mopub.activity;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.view.Window;
import com.integralads.avid.library.mopub.weakreference.AvidActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class AvidActivityStack {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AvidActivityStack f34 = new AvidActivityStack();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final ArrayList<AvidActivity> f35 = new ArrayList<>();

    public static AvidActivityStack getInstance() {
        return f34;
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    private View m38(AvidActivity avidActivity) {
        Window window;
        Activity activity = avidActivity.get();
        if (activity == null || (window = activity.getWindow()) == null || !activity.hasWindowFocus()) {
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView == null || !decorView.isShown()) {
            return null;
        }
        return decorView;
    }

    public void addActivity(Activity activity) {
        if (m39(activity) == null) {
            this.f35.add(new AvidActivity(activity));
        }
    }

    public void cleanup() {
        this.f35.clear();
    }

    public List<View> getRootViews() {
        ArrayList arrayList = new ArrayList();
        Iterator<AvidActivity> it = this.f35.iterator();
        View view = null;
        while (it.hasNext()) {
            AvidActivity next = it.next();
            if (m40(next)) {
                it.remove();
            } else {
                View m38 = m38(next);
                if (m38 != null) {
                    view = m38;
                }
            }
        }
        if (view != null) {
            arrayList.add(view);
        }
        return arrayList;
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    AvidActivity m39(Activity activity) {
        Iterator<AvidActivity> it = this.f35.iterator();
        while (it.hasNext()) {
            AvidActivity next = it.next();
            if (next.contains(activity)) {
                return next;
            }
        }
        return null;
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean m40(AvidActivity avidActivity) {
        Activity activity = avidActivity.get();
        if (activity == null) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 17 ? activity.isDestroyed() : activity.isFinishing();
    }
}
