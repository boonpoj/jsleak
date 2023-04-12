package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.BaseNativeAd;
import com.mopub.network.TrackingRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: assets/classes2.dex */
public class NativeAd {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f1735;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final BaseNativeAd f1736;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final MoPubAdRenderer f1737;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Set<String> f1738 = new HashSet();
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Set<String> f1739;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final String f1740;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private MoPubNativeEventListener f1741;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f1742;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private boolean f1743;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private boolean f1744;

    /* loaded from: assets/classes2.dex */
    public interface MoPubNativeEventListener {
        void onClick(View view);

        void onImpression(View view);
    }

    public NativeAd(@NonNull Context context, @NonNull List<String> list, @NonNull String str, @NonNull String str2, @NonNull BaseNativeAd baseNativeAd, @NonNull MoPubAdRenderer moPubAdRenderer) {
        this.f1735 = context.getApplicationContext();
        this.f1740 = str2;
        this.f1738.addAll(list);
        this.f1738.addAll(baseNativeAd.m1300());
        this.f1739 = new HashSet();
        this.f1739.add(str);
        this.f1739.addAll(baseNativeAd.m1301());
        this.f1736 = baseNativeAd;
        this.f1736.setNativeEventListener(new BaseNativeAd.NativeEventListener() { // from class: com.mopub.nativeads.NativeAd.1
            @Override // com.mopub.nativeads.BaseNativeAd.NativeEventListener
            public void onAdClicked() {
                NativeAd.this.m1436(null);
            }

            @Override // com.mopub.nativeads.BaseNativeAd.NativeEventListener
            public void onAdImpressed() {
                NativeAd.this.m1435(null);
            }
        });
        this.f1737 = moPubAdRenderer;
    }

    public void clear(@NonNull View view) {
        if (this.f1744) {
            return;
        }
        this.f1736.clear(view);
    }

    @NonNull
    public View createAdView(@NonNull Context context, @Nullable ViewGroup viewGroup) {
        return this.f1737.createAdView(context, viewGroup);
    }

    public void destroy() {
        if (this.f1744) {
            return;
        }
        this.f1736.destroy();
        this.f1744 = true;
    }

    @NonNull
    public String getAdUnitId() {
        return this.f1740;
    }

    @NonNull
    public BaseNativeAd getBaseNativeAd() {
        return this.f1736;
    }

    @NonNull
    public MoPubAdRenderer getMoPubAdRenderer() {
        return this.f1737;
    }

    public boolean isDestroyed() {
        return this.f1744;
    }

    public void prepare(@NonNull View view) {
        if (this.f1744) {
            return;
        }
        this.f1736.prepare(view);
    }

    public void renderAdView(View view) {
        this.f1737.renderAdView(view, this.f1736);
    }

    public void setMoPubNativeEventListener(@Nullable MoPubNativeEventListener moPubNativeEventListener) {
        this.f1741 = moPubNativeEventListener;
    }

    public String toString() {
        return "\nimpressionTrackers:" + this.f1738 + "\nclickTrackers:" + this.f1739 + "\nrecordedImpression:" + this.f1742 + "\nisClicked:" + this.f1743 + "\nisDestroyed:" + this.f1744 + "\n";
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1435(@Nullable View view) {
        if (this.f1742 || this.f1744) {
            return;
        }
        TrackingRequest.makeTrackingHttpRequest(this.f1738, this.f1735);
        if (this.f1741 != null) {
            this.f1741.onImpression(view);
        }
        this.f1742 = true;
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    void m1436(@Nullable View view) {
        if (this.f1743 || this.f1744) {
            return;
        }
        TrackingRequest.makeTrackingHttpRequest(this.f1739, this.f1735);
        if (this.f1741 != null) {
            this.f1741.onClick(view);
        }
        this.f1743 = true;
    }
}
