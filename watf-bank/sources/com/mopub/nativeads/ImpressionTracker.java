package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: assets/classes2.dex */
public class ImpressionTracker {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final VisibilityTracker f1555;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Map<View, ImpressionInterface> f1556;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Map<View, C0289<ImpressionInterface>> f1557;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Handler f1558;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final RunnableC0263 f1559;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final VisibilityTracker.VisibilityChecker f1560;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private VisibilityTracker.VisibilityTrackerListener f1561;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.ImpressionTracker$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class RunnableC0263 implements Runnable {
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final ArrayList<View> f1564 = new ArrayList<>();

        RunnableC0263() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Map.Entry entry : ImpressionTracker.this.f1557.entrySet()) {
                View view = (View) entry.getKey();
                C0289 c0289 = (C0289) entry.getValue();
                if (ImpressionTracker.this.f1560.hasRequiredTimeElapsed(c0289.f1968, ((ImpressionInterface) c0289.f1967).getImpressionMinTimeViewed())) {
                    ((ImpressionInterface) c0289.f1967).recordImpression(view);
                    ((ImpressionInterface) c0289.f1967).setImpressionRecorded();
                    this.f1564.add(view);
                }
            }
            Iterator<View> it = this.f1564.iterator();
            while (it.hasNext()) {
                ImpressionTracker.this.removeView(it.next());
            }
            this.f1564.clear();
            if (ImpressionTracker.this.f1557.isEmpty()) {
                return;
            }
            ImpressionTracker.this.m1330();
        }
    }

    public ImpressionTracker(@NonNull Context context) {
        this(new WeakHashMap(), new WeakHashMap(), new VisibilityTracker.VisibilityChecker(), new VisibilityTracker(context), new Handler(Looper.getMainLooper()));
    }

    @VisibleForTesting
    ImpressionTracker(@NonNull Map<View, ImpressionInterface> map, @NonNull Map<View, C0289<ImpressionInterface>> map2, @NonNull VisibilityTracker.VisibilityChecker visibilityChecker, @NonNull VisibilityTracker visibilityTracker, @NonNull Handler handler) {
        this.f1556 = map;
        this.f1557 = map2;
        this.f1560 = visibilityChecker;
        this.f1555 = visibilityTracker;
        this.f1561 = new VisibilityTracker.VisibilityTrackerListener() { // from class: com.mopub.nativeads.ImpressionTracker.1
            @Override // com.mopub.common.VisibilityTracker.VisibilityTrackerListener
            public void onVisibilityChanged(@NonNull List<View> list, @NonNull List<View> list2) {
                for (View view : list) {
                    ImpressionInterface impressionInterface = (ImpressionInterface) ImpressionTracker.this.f1556.get(view);
                    if (impressionInterface == null) {
                        ImpressionTracker.this.removeView(view);
                    } else {
                        C0289 c0289 = (C0289) ImpressionTracker.this.f1557.get(view);
                        if (c0289 == null || !impressionInterface.equals(c0289.f1967)) {
                            ImpressionTracker.this.f1557.put(view, new C0289(impressionInterface));
                        }
                    }
                }
                for (View view2 : list2) {
                    ImpressionTracker.this.f1557.remove(view2);
                }
                ImpressionTracker.this.m1330();
            }
        };
        this.f1555.setVisibilityTrackerListener(this.f1561);
        this.f1558 = handler;
        this.f1559 = new RunnableC0263();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1327(View view) {
        this.f1557.remove(view);
    }

    public void addView(View view, @NonNull ImpressionInterface impressionInterface) {
        if (this.f1556.get(view) == impressionInterface) {
            return;
        }
        removeView(view);
        if (impressionInterface.isImpressionRecorded()) {
            return;
        }
        this.f1556.put(view, impressionInterface);
        this.f1555.addView(view, impressionInterface.getImpressionMinPercentageViewed(), impressionInterface.getImpressionMinVisiblePx());
    }

    public void clear() {
        this.f1556.clear();
        this.f1557.clear();
        this.f1555.clear();
        this.f1558.removeMessages(0);
    }

    public void destroy() {
        clear();
        this.f1555.destroy();
        this.f1561 = null;
    }

    public void removeView(View view) {
        this.f1556.remove(view);
        m1327(view);
        this.f1555.removeView(view);
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1330() {
        if (this.f1558.hasMessages(0)) {
            return;
        }
        this.f1558.postDelayed(this.f1559, 250L);
    }
}
