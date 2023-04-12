package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.C0279;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.PositioningSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
/* loaded from: assets/classes2.dex */
public class MoPubStreamAdPlacer {
    public static final int CONTENT_VIEW_TYPE = 0;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final MoPubNativeAdLoadedListener f1711 = new MoPubNativeAdLoadedListener() { // from class: com.mopub.nativeads.MoPubStreamAdPlacer.1
        @Override // com.mopub.nativeads.MoPubNativeAdLoadedListener
        public void onAdLoaded(int i) {
        }

        @Override // com.mopub.nativeads.MoPubNativeAdLoadedListener
        public void onAdRemoved(int i) {
        }
    };
    @NonNull

    /* renamed from: ֏  reason: contains not printable characters */
    private C0284 f1712;
    @Nullable

    /* renamed from: ؠ  reason: contains not printable characters */
    private String f1713;
    @NonNull

    /* renamed from: ހ  reason: contains not printable characters */
    private MoPubNativeAdLoadedListener f1714;

    /* renamed from: ށ  reason: contains not printable characters */
    private int f1715;

    /* renamed from: ނ  reason: contains not printable characters */
    private int f1716;

    /* renamed from: ރ  reason: contains not printable characters */
    private int f1717;

    /* renamed from: ބ  reason: contains not printable characters */
    private boolean f1718;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Activity f1719;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Handler f1720;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Runnable f1721;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final PositioningSource f1722;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final C0279 f1723;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final HashMap<NativeAd, WeakReference<View>> f1724;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final WeakHashMap<View, NativeAd> f1725;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private boolean f1726;
    @Nullable

    /* renamed from: ࢪ  reason: contains not printable characters */
    private C0284 f1727;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private boolean f1728;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private boolean f1729;

    public MoPubStreamAdPlacer(@NonNull Activity activity) {
        this(activity, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubStreamAdPlacer(@NonNull Activity activity, @NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        this(activity, new C0279(), new C0276(moPubClientPositioning));
    }

    public MoPubStreamAdPlacer(@NonNull Activity activity, @NonNull MoPubNativeAdPositioning.MoPubServerPositioning moPubServerPositioning) {
        this(activity, new C0279(), new C0286(activity));
    }

    @VisibleForTesting
    MoPubStreamAdPlacer(@NonNull Activity activity, @NonNull C0279 c0279, @NonNull PositioningSource positioningSource) {
        this.f1714 = f1711;
        Preconditions.checkNotNull(activity, "activity is not allowed to be null");
        Preconditions.checkNotNull(c0279, "adSource is not allowed to be null");
        Preconditions.checkNotNull(positioningSource, "positioningSource is not allowed to be null");
        this.f1719 = activity;
        this.f1722 = positioningSource;
        this.f1723 = c0279;
        this.f1712 = C0284.m1523();
        this.f1725 = new WeakHashMap<>();
        this.f1724 = new HashMap<>();
        this.f1720 = new Handler();
        this.f1721 = new Runnable() { // from class: com.mopub.nativeads.MoPubStreamAdPlacer.2
            @Override // java.lang.Runnable
            public void run() {
                if (MoPubStreamAdPlacer.this.f1718) {
                    MoPubStreamAdPlacer.this.m1430();
                    MoPubStreamAdPlacer.this.f1718 = false;
                }
            }
        };
        this.f1715 = 0;
        this.f1716 = 0;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1421(@Nullable View view) {
        NativeAd nativeAd;
        if (view == null || (nativeAd = this.f1725.get(view)) == null) {
            return;
        }
        nativeAd.clear(view);
        this.f1725.remove(view);
        this.f1724.remove(nativeAd);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1422(@NonNull NativeAd nativeAd, @NonNull View view) {
        this.f1724.put(nativeAd, new WeakReference<>(view));
        this.f1725.put(view, nativeAd);
        nativeAd.prepare(view);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1423(C0284 c0284) {
        removeAdsInRange(0, this.f1717);
        this.f1712 = c0284;
        m1430();
        this.f1729 = true;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m1424(int i) {
        NativeAd m1509 = this.f1723.m1509();
        if (m1509 == null) {
            return false;
        }
        this.f1712.m1527(i, m1509);
        this.f1717++;
        this.f1714.onAdLoaded(i);
        return true;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m1425(int i, int i2) {
        int i3 = i2 - 1;
        while (i <= i3 && i != -1 && i < this.f1717) {
            if (this.f1712.m1528(i)) {
                if (!m1424(i)) {
                    return false;
                }
                i3++;
            }
            i = this.f1712.m1529(i);
        }
        return true;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m1428() {
        if (this.f1718) {
            return;
        }
        this.f1718 = true;
        this.f1720.post(this.f1721);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m1430() {
        if (m1425(this.f1715, this.f1716)) {
            m1425(this.f1716, this.f1716 + 6);
        }
    }

    public void bindAdView(@NonNull NativeAd nativeAd, @NonNull View view) {
        WeakReference<View> weakReference = this.f1724.get(nativeAd);
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view.equals(view2)) {
            return;
        }
        m1421(view2);
        m1421(view);
        m1422(nativeAd, view);
        nativeAd.renderAdView(view);
    }

    public void clearAds() {
        removeAdsInRange(0, this.f1717);
        this.f1723.m1508();
    }

    public void destroy() {
        this.f1720.removeMessages(0);
        this.f1723.m1508();
        this.f1712.m1532();
    }

    @Nullable
    public Object getAdData(int i) {
        return this.f1712.m1534(i);
    }

    @Nullable
    public MoPubAdRenderer getAdRendererForViewType(int i) {
        return this.f1723.getAdRendererForViewType(i);
    }

    @Nullable
    public View getAdView(int i, @Nullable View view, @Nullable ViewGroup viewGroup) {
        NativeAd m1534 = this.f1712.m1534(i);
        if (m1534 == null) {
            return null;
        }
        if (view == null) {
            view = m1534.createAdView(this.f1719, viewGroup);
        }
        bindAdView(m1534, view);
        return view;
    }

    public int getAdViewType(int i) {
        NativeAd m1534 = this.f1712.m1534(i);
        if (m1534 == null) {
            return 0;
        }
        return this.f1723.getViewTypeForAd(m1534);
    }

    public int getAdViewTypeCount() {
        return this.f1723.m1503();
    }

    public int getAdjustedCount(int i) {
        return this.f1712.m1538(i);
    }

    public int getAdjustedPosition(int i) {
        return this.f1712.m1536(i);
    }

    public int getOriginalCount(int i) {
        return this.f1712.m1537(i);
    }

    public int getOriginalPosition(int i) {
        return this.f1712.m1535(i);
    }

    public void insertItem(int i) {
        this.f1712.m1539(i);
    }

    public boolean isAd(int i) {
        return this.f1712.m1533(i);
    }

    public void loadAds(@NonNull String str) {
        loadAds(str, null);
    }

    public void loadAds(@NonNull String str, @Nullable RequestParameters requestParameters) {
        if (Preconditions.NoThrow.checkNotNull(str, "Cannot load ads with a null ad unit ID")) {
            if (this.f1723.m1503() == 0) {
                MoPubLog.w("You must register at least 1 ad renderer by calling registerAdRenderer before loading ads");
                return;
            }
            this.f1713 = str;
            this.f1729 = false;
            this.f1726 = false;
            this.f1728 = false;
            this.f1722.loadPositions(str, new PositioningSource.PositioningListener() { // from class: com.mopub.nativeads.MoPubStreamAdPlacer.3
                @Override // com.mopub.nativeads.PositioningSource.PositioningListener
                public void onFailed() {
                    MoPubLog.d("Unable to show ads because ad positions could not be loaded from the MoPub ad server.");
                }

                @Override // com.mopub.nativeads.PositioningSource.PositioningListener
                public void onLoad(@NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
                    MoPubStreamAdPlacer.this.m1432(moPubClientPositioning);
                }
            });
            this.f1723.m1507(new C0279.InterfaceC0280() { // from class: com.mopub.nativeads.MoPubStreamAdPlacer.4
                @Override // com.mopub.nativeads.C0279.InterfaceC0280
                public void onAdsAvailable() {
                    MoPubStreamAdPlacer.this.m1431();
                }
            });
            this.f1723.m1504(this.f1719, str, requestParameters);
        }
    }

    public void moveItem(int i, int i2) {
        this.f1712.m1530(i, i2);
    }

    public void placeAdsInRange(int i, int i2) {
        this.f1715 = i;
        this.f1716 = Math.min(i2, i + 100);
        m1428();
    }

    public void registerAdRenderer(@NonNull MoPubAdRenderer moPubAdRenderer) {
        if (Preconditions.NoThrow.checkNotNull(moPubAdRenderer, "Cannot register a null adRenderer")) {
            this.f1723.m1505(moPubAdRenderer);
        }
    }

    public int removeAdsInRange(int i, int i2) {
        int[] m1531 = this.f1712.m1531();
        int m1536 = this.f1712.m1536(i);
        int m15362 = this.f1712.m1536(i2);
        ArrayList arrayList = new ArrayList();
        for (int length = m1531.length - 1; length >= 0; length--) {
            int i3 = m1531[length];
            if (i3 >= m1536 && i3 < m15362) {
                arrayList.add(Integer.valueOf(i3));
                if (i3 < this.f1715) {
                    this.f1715--;
                }
                this.f1717--;
            }
        }
        int m1526 = this.f1712.m1526(m1536, m15362);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f1714.onAdRemoved(((Integer) it.next()).intValue());
        }
        return m1526;
    }

    public void removeItem(int i) {
        this.f1712.m1540(i);
    }

    public void setAdLoadedListener(@Nullable MoPubNativeAdLoadedListener moPubNativeAdLoadedListener) {
        if (moPubNativeAdLoadedListener == null) {
            moPubNativeAdLoadedListener = f1711;
        }
        this.f1714 = moPubNativeAdLoadedListener;
    }

    public void setItemCount(int i) {
        this.f1717 = this.f1712.m1538(i);
        if (this.f1729) {
            m1428();
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1431() {
        if (this.f1729) {
            m1428();
            return;
        }
        if (this.f1726) {
            m1423(this.f1727);
        }
        this.f1728 = true;
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1432(@NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        C0284 m1524 = C0284.m1524(moPubClientPositioning);
        if (this.f1728) {
            m1423(m1524);
        } else {
            this.f1727 = m1524;
        }
        this.f1726 = true;
    }
}
