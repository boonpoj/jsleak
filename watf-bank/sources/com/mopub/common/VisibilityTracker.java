package com.mopub.common;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Views;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: assets/classes2.dex */
public class VisibilityTracker {
    @NonNull
    @VisibleForTesting

    /* renamed from: ࢠ  reason: contains not printable characters */
    final ViewTreeObserver.OnPreDrawListener f441;
    @NonNull
    @VisibleForTesting

    /* renamed from: ࢢ  reason: contains not printable characters */
    WeakReference<ViewTreeObserver> f442;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final ArrayList<View> f443;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private long f444;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Map<View, C0173> f445;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final VisibilityChecker f446;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private VisibilityTrackerListener f447;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final RunnableC0174 f448;
    @NonNull

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final Handler f449;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private boolean f450;

    /* loaded from: assets/classes2.dex */
    public static class VisibilityChecker {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final Rect f452 = new Rect();

        public boolean hasRequiredTimeElapsed(long j, int i) {
            return SystemClock.uptimeMillis() - j >= ((long) i);
        }

        public boolean isVisible(@Nullable View view, @Nullable View view2, int i, @Nullable Integer num) {
            if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || !view2.getGlobalVisibleRect(this.f452)) {
                return false;
            }
            long height = this.f452.height() * this.f452.width();
            long height2 = view2.getHeight() * view2.getWidth();
            if (height2 <= 0) {
                return false;
            }
            return (num == null || num.intValue() <= 0) ? height * 100 >= ((long) i) * height2 : height >= ((long) num.intValue());
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface VisibilityTrackerListener {
        void onVisibilityChanged(List<View> list, List<View> list2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.common.VisibilityTracker$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0173 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        int f453;

        /* renamed from: ࢢ  reason: contains not printable characters */
        int f454;

        /* renamed from: ࢣ  reason: contains not printable characters */
        long f455;

        /* renamed from: ࢤ  reason: contains not printable characters */
        View f456;
        @Nullable

        /* renamed from: ࢥ  reason: contains not printable characters */
        Integer f457;

        C0173() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.common.VisibilityTracker$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class RunnableC0174 implements Runnable {
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final ArrayList<View> f460 = new ArrayList<>();
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final ArrayList<View> f459 = new ArrayList<>();

        RunnableC0174() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<View> arrayList;
            VisibilityTracker.this.f450 = false;
            for (Map.Entry entry : VisibilityTracker.this.f445.entrySet()) {
                View view = (View) entry.getKey();
                int i = ((C0173) entry.getValue()).f453;
                int i2 = ((C0173) entry.getValue()).f454;
                Integer num = ((C0173) entry.getValue()).f457;
                View view2 = ((C0173) entry.getValue()).f456;
                if (VisibilityTracker.this.f446.isVisible(view2, view, i, num)) {
                    arrayList = this.f459;
                } else if (!VisibilityTracker.this.f446.isVisible(view2, view, i2, null)) {
                    arrayList = this.f460;
                }
                arrayList.add(view);
            }
            if (VisibilityTracker.this.f447 != null) {
                VisibilityTracker.this.f447.onVisibilityChanged(this.f459, this.f460);
            }
            this.f459.clear();
            this.f460.clear();
        }
    }

    public VisibilityTracker(@NonNull Context context) {
        this(context, new WeakHashMap(10), new VisibilityChecker(), new Handler());
    }

    @VisibleForTesting
    VisibilityTracker(@NonNull Context context, @NonNull Map<View, C0173> map, @NonNull VisibilityChecker visibilityChecker, @NonNull Handler handler) {
        this.f444 = 0L;
        this.f445 = map;
        this.f446 = visibilityChecker;
        this.f449 = handler;
        this.f448 = new RunnableC0174();
        this.f443 = new ArrayList<>(50);
        this.f441 = new ViewTreeObserver.OnPreDrawListener() { // from class: com.mopub.common.VisibilityTracker.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                VisibilityTracker.this.scheduleVisibilityCheck();
                return true;
            }
        };
        this.f442 = new WeakReference<>(null);
        m476(context, (View) null);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m475(long j) {
        for (Map.Entry<View, C0173> entry : this.f445.entrySet()) {
            if (entry.getValue().f455 < j) {
                this.f443.add(entry.getKey());
            }
        }
        Iterator<View> it = this.f443.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.f443.clear();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m476(@Nullable Context context, @Nullable View view) {
        ViewTreeObserver viewTreeObserver = this.f442.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            View topmostView = Views.getTopmostView(context, view);
            if (topmostView == null) {
                MoPubLog.d("Unable to set Visibility Tracker due to no available root view.");
                return;
            }
            ViewTreeObserver viewTreeObserver2 = topmostView.getViewTreeObserver();
            if (!viewTreeObserver2.isAlive()) {
                MoPubLog.w("Visibility Tracker was unable to track views because the root view tree observer was not alive");
                return;
            }
            this.f442 = new WeakReference<>(viewTreeObserver2);
            viewTreeObserver2.addOnPreDrawListener(this.f441);
        }
    }

    public void addView(@NonNull View view, int i, @Nullable Integer num) {
        addView(view, view, i, num);
    }

    public void addView(@NonNull View view, @NonNull View view2, int i, int i2, @Nullable Integer num) {
        m476(view2.getContext(), view2);
        C0173 c0173 = this.f445.get(view2);
        if (c0173 == null) {
            c0173 = new C0173();
            this.f445.put(view2, c0173);
            scheduleVisibilityCheck();
        }
        int min = Math.min(i2, i);
        c0173.f456 = view;
        c0173.f453 = i;
        c0173.f454 = min;
        c0173.f455 = this.f444;
        c0173.f457 = num;
        this.f444++;
        if (this.f444 % 50 == 0) {
            m475(this.f444 - 50);
        }
    }

    public void addView(@NonNull View view, @NonNull View view2, int i, @Nullable Integer num) {
        addView(view, view2, i, i, num);
    }

    public void clear() {
        this.f445.clear();
        this.f449.removeMessages(0);
        this.f450 = false;
    }

    public void destroy() {
        clear();
        ViewTreeObserver viewTreeObserver = this.f442.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f441);
        }
        this.f442.clear();
        this.f447 = null;
    }

    public void removeView(@NonNull View view) {
        this.f445.remove(view);
    }

    public void scheduleVisibilityCheck() {
        if (this.f450) {
            return;
        }
        this.f450 = true;
        this.f449.postDelayed(this.f448, 100L);
    }

    public void setVisibilityTrackerListener(@Nullable VisibilityTrackerListener visibilityTrackerListener) {
        this.f447 = visibilityTrackerListener;
    }
}
