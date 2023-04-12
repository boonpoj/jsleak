package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.mobileads.C0231;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.factories.CustomEventBannerFactory;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: assets/classes2.dex */
public class CustomEventBannerAdapter implements CustomEventBanner.CustomEventBannerListener {
    public static final int DEFAULT_BANNER_TIMEOUT_DELAY = 10000;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean f813;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private MoPubView f814;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private Context f815;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private CustomEventBanner f816;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Map<String, Object> f817;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private Map<String, String> f818;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final Handler f819;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final Runnable f820;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private int f821 = Integer.MIN_VALUE;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private int f822 = Integer.MIN_VALUE;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private boolean f823 = false;
    @Nullable

    /* renamed from: ࢬ  reason: contains not printable characters */
    private C0231 f824;

    public CustomEventBannerAdapter(@NonNull MoPubView moPubView, @NonNull String str, @NonNull Map<String, String> map, long j, @Nullable AdReport adReport) {
        Preconditions.checkNotNull(map);
        this.f819 = new Handler();
        this.f814 = moPubView;
        this.f815 = moPubView.getContext();
        this.f820 = new Runnable() { // from class: com.mopub.mobileads.CustomEventBannerAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                MoPubLog.d("Third-party network timed out.");
                CustomEventBannerAdapter.this.onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
                CustomEventBannerAdapter.this.invalidate();
            }
        };
        MoPubLog.d("Attempting to invoke custom event: " + str);
        try {
            this.f816 = CustomEventBannerFactory.create(str);
            this.f818 = new TreeMap(map);
            m743();
            this.f817 = this.f814.getLocalExtras();
            if (this.f814.getLocation() != null) {
                this.f817.put("location", this.f814.getLocation());
            }
            this.f817.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(j));
            this.f817.put(DataKeys.AD_REPORT_KEY, adReport);
            this.f817.put(DataKeys.AD_WIDTH, Integer.valueOf(this.f814.getAdWidth()));
            this.f817.put(DataKeys.AD_HEIGHT, Integer.valueOf(this.f814.getAdHeight()));
            this.f817.put(DataKeys.BANNER_IMPRESSION_PIXEL_COUNT_ENABLED, Boolean.valueOf(this.f823));
        } catch (Exception unused) {
            MoPubLog.d("Couldn't locate or instantiate custom event: " + str + ".");
            this.f814.m836(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m741() {
        this.f819.removeCallbacks(this.f820);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int m742() {
        if (this.f814 == null) {
            return 10000;
        }
        return this.f814.m834(10000).intValue();
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m743() {
        String str = this.f818.get(DataKeys.BANNER_IMPRESSION_MIN_VISIBLE_DIPS);
        String str2 = this.f818.get(DataKeys.BANNER_IMPRESSION_MIN_VISIBLE_MS);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            this.f821 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            MoPubLog.d("Cannot parse integer from header banner-impression-min-pixels");
        }
        try {
            this.f822 = Integer.parseInt(str2);
        } catch (NumberFormatException unused2) {
            MoPubLog.d("Cannot parse integer from header banner-impression-min-ms");
        }
        if (this.f821 <= 0 || this.f822 < 0) {
            return;
        }
        this.f823 = true;
    }

    @ReflectionTarget
    void invalidate() {
        if (this.f816 != null) {
            try {
                this.f816.mo698();
            } catch (Exception e) {
                MoPubLog.d("Invalidating a custom event banner threw an exception", e);
            }
        }
        if (this.f824 != null) {
            try {
                this.f824.m1055();
            } catch (Exception e2) {
                MoPubLog.d("Destroying a banner visibility tracker threw an exception", e2);
            }
            this.f824 = null;
        }
        this.f815 = null;
        this.f816 = null;
        this.f817 = null;
        this.f818 = null;
        this.f813 = true;
    }

    @ReflectionTarget
    void loadAd() {
        if (m744() || this.f816 == null) {
            return;
        }
        this.f819.postDelayed(this.f820, m742());
        try {
            this.f816.mo699(this.f815, this, this.f817, this.f818);
        } catch (Exception e) {
            MoPubLog.d("Loading a custom event banner threw an exception.", e);
            onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
        }
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerClicked() {
        if (m744() || this.f814 == null) {
            return;
        }
        this.f814.m835();
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerCollapsed() {
        if (m744()) {
            return;
        }
        this.f814.m846();
        this.f814.m840();
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerExpanded() {
        if (m744()) {
            return;
        }
        this.f814.m845();
        this.f814.m839();
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerFailed(MoPubErrorCode moPubErrorCode) {
        if (m744()) {
            return;
        }
        m741();
        if (this.f814 != null) {
            if (moPubErrorCode == null) {
                moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
            }
            this.f814.m836(moPubErrorCode);
        }
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerImpression() {
        if (m744() || this.f814 == null || this.f816 == null || this.f816.m738()) {
            return;
        }
        this.f814.m837();
        if (this.f823) {
            this.f816.mo737();
        }
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onBannerLoaded(View view) {
        if (m744()) {
            return;
        }
        m741();
        if (this.f814 != null) {
            this.f814.m842();
            if (this.f823 && this.f816 != null && this.f816.m738()) {
                this.f814.m843();
                this.f824 = new C0231(this.f815, this.f814, view, this.f821, this.f822);
                this.f824.m1056(new C0231.InterfaceC0234() { // from class: com.mopub.mobileads.CustomEventBannerAdapter.2
                    @Override // com.mopub.mobileads.C0231.InterfaceC0234
                    public void onVisibilityChanged() {
                        CustomEventBannerAdapter.this.f814.m837();
                        if (CustomEventBannerAdapter.this.f816 != null) {
                            CustomEventBannerAdapter.this.f816.mo737();
                        }
                        CustomEventBannerAdapter.this.f814.m844();
                    }
                });
            }
            this.f814.setAdContentView(view);
            if (this.f823 || this.f816 == null || !this.f816.m738() || (view instanceof HtmlBannerWebView)) {
                return;
            }
            this.f814.m837();
        }
    }

    @Override // com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener
    public void onLeaveApplication() {
        onBannerClicked();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean m744() {
        return this.f813;
    }
}
