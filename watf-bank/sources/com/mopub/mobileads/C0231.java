package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;
import java.lang.ref.WeakReference;
/* renamed from: com.mopub.mobileads.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0231 {
    @NonNull
    @VisibleForTesting

    /* renamed from: ࢠ  reason: contains not printable characters */
    final ViewTreeObserver.OnPreDrawListener f1229;
    @NonNull
    @VisibleForTesting

    /* renamed from: ࢢ  reason: contains not printable characters */
    WeakReference<ViewTreeObserver> f1230;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final View f1231;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final View f1232;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final C0232 f1233;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private InterfaceC0234 f1234;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final RunnableC0233 f1235;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final Handler f1236;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private boolean f1237;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private boolean f1238;

    /* renamed from: com.mopub.mobileads.ࢣ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0232 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private int f1240;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private int f1241;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private long f1242 = Long.MIN_VALUE;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private final Rect f1243 = new Rect();

        C0232(int i, int i2) {
            this.f1240 = i;
            this.f1241 = i2;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        boolean m1058() {
            return this.f1242 != Long.MIN_VALUE;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        boolean m1059(@Nullable View view, @Nullable View view2) {
            return view2 != null && view2.getVisibility() == 0 && view.getParent() != null && view2.getWidth() > 0 && view2.getHeight() > 0 && view2.getGlobalVisibleRect(this.f1243) && ((long) (Dips.pixelsToIntDips((float) this.f1243.width(), view2.getContext()) * Dips.pixelsToIntDips((float) this.f1243.height(), view2.getContext()))) >= ((long) this.f1240);
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        void m1060() {
            this.f1242 = SystemClock.uptimeMillis();
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        boolean m1061() {
            return m1058() && SystemClock.uptimeMillis() - this.f1242 >= ((long) this.f1241);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.ࢣ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class RunnableC0233 implements Runnable {
        RunnableC0233() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0231.this.f1238) {
                return;
            }
            C0231.this.f1237 = false;
            if (C0231.this.f1233.m1059(C0231.this.f1232, C0231.this.f1231)) {
                if (!C0231.this.f1233.m1058()) {
                    C0231.this.f1233.m1060();
                }
                if (C0231.this.f1233.m1061() && C0231.this.f1234 != null) {
                    C0231.this.f1234.onVisibilityChanged();
                    C0231.this.f1238 = true;
                }
            }
            if (C0231.this.f1238) {
                return;
            }
            C0231.this.m1057();
        }
    }

    /* renamed from: com.mopub.mobileads.ࢣ$ࢣ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    interface InterfaceC0234 {
        void onVisibilityChanged();
    }

    @VisibleForTesting
    public C0231(@NonNull Context context, @NonNull View view, @NonNull View view2, int i, int i2) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view2);
        this.f1232 = view;
        this.f1231 = view2;
        this.f1233 = new C0232(i, i2);
        this.f1236 = new Handler();
        this.f1235 = new RunnableC0233();
        this.f1229 = new ViewTreeObserver.OnPreDrawListener() { // from class: com.mopub.mobileads.ࢣ.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                C0231.this.m1057();
                return true;
            }
        };
        this.f1230 = new WeakReference<>(null);
        m1047(context, this.f1231);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1047(@Nullable Context context, @Nullable View view) {
        ViewTreeObserver viewTreeObserver = this.f1230.get();
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
            this.f1230 = new WeakReference<>(viewTreeObserver2);
            viewTreeObserver2.addOnPreDrawListener(this.f1229);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1055() {
        this.f1236.removeMessages(0);
        this.f1237 = false;
        ViewTreeObserver viewTreeObserver = this.f1230.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f1229);
        }
        this.f1230.clear();
        this.f1234 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1056(@Nullable InterfaceC0234 interfaceC0234) {
        this.f1234 = interfaceC0234;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    void m1057() {
        if (this.f1237) {
            return;
        }
        this.f1237 = true;
        this.f1236.postDelayed(this.f1235, 100L);
    }
}
