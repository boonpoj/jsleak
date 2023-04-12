package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public abstract class StaticNativeAd extends BaseNativeAd implements ClickInterface, ImpressionInterface {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f1858;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f1859;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f1860;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f1861;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private String f1862;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private String f1863;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private Double f1864;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private String f1865;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private String f1866;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private boolean f1867;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private int f1868 = 1000;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private int f1869 = 50;

    /* renamed from: ֏  reason: contains not printable characters */
    private Integer f1856 = null;
    @NonNull

    /* renamed from: ؠ  reason: contains not printable characters */
    private final Map<String, Object> f1857 = new HashMap();

    public final void addExtra(@NonNull String str, @Nullable Object obj) {
        if (Preconditions.NoThrow.checkNotNull(str, "addExtra key is not allowed to be null")) {
            this.f1857.put(str, obj);
        }
    }

    @Override // com.mopub.nativeads.BaseNativeAd
    public void clear(@NonNull View view) {
    }

    @Override // com.mopub.nativeads.BaseNativeAd
    public void destroy() {
        invalidate();
    }

    @Nullable
    public final String getCallToAction() {
        return this.f1861;
    }

    @Nullable
    public final String getClickDestinationUrl() {
        return this.f1860;
    }

    @Nullable
    public final Object getExtra(@NonNull String str) {
        if (Preconditions.NoThrow.checkNotNull(str, "getExtra key is not allowed to be null")) {
            return this.f1857.get(str);
        }
        return null;
    }

    @NonNull
    public final Map<String, Object> getExtras() {
        return new HashMap(this.f1857);
    }

    @Nullable
    public final String getIconImageUrl() {
        return this.f1859;
    }

    @Override // com.mopub.nativeads.ImpressionInterface
    public final int getImpressionMinPercentageViewed() {
        return this.f1869;
    }

    @Override // com.mopub.nativeads.ImpressionInterface
    public final int getImpressionMinTimeViewed() {
        return this.f1868;
    }

    @Override // com.mopub.nativeads.ImpressionInterface
    public final Integer getImpressionMinVisiblePx() {
        return this.f1856;
    }

    @Nullable
    public final String getMainImageUrl() {
        return this.f1858;
    }

    @Nullable
    public final String getPrivacyInformationIconClickThroughUrl() {
        return this.f1865;
    }

    @Nullable
    public String getPrivacyInformationIconImageUrl() {
        return this.f1866;
    }

    @Nullable
    public final Double getStarRating() {
        return this.f1864;
    }

    @Nullable
    public final String getText() {
        return this.f1863;
    }

    @Nullable
    public final String getTitle() {
        return this.f1862;
    }

    public void handleClick(@NonNull View view) {
    }

    @Override // com.mopub.nativeads.ImpressionInterface
    public final boolean isImpressionRecorded() {
        return this.f1867;
    }

    @Override // com.mopub.nativeads.BaseNativeAd
    public void prepare(@NonNull View view) {
    }

    public void recordImpression(@NonNull View view) {
    }

    public final void setCallToAction(@Nullable String str) {
        this.f1861 = str;
    }

    public final void setClickDestinationUrl(@Nullable String str) {
        this.f1860 = str;
    }

    public final void setIconImageUrl(@Nullable String str) {
        this.f1859 = str;
    }

    public final void setImpressionMinPercentageViewed(int i) {
        if (i >= 0 && i <= 100) {
            this.f1869 = i;
            return;
        }
        MoPubLog.d("Ignoring impressionMinTimeViewed that's not a percent [0, 100]: " + i);
    }

    public final void setImpressionMinTimeViewed(int i) {
        if (i > 0) {
            this.f1868 = i;
            return;
        }
        MoPubLog.d("Ignoring non-positive impressionMinTimeViewed: " + i);
    }

    public final void setImpressionMinVisiblePx(@Nullable Integer num) {
        if (num != null && num.intValue() > 0) {
            this.f1856 = num;
            return;
        }
        MoPubLog.d("Ignoring null or non-positive impressionMinVisiblePx: " + num);
    }

    @Override // com.mopub.nativeads.ImpressionInterface
    public final void setImpressionRecorded() {
        this.f1867 = true;
    }

    public final void setMainImageUrl(@Nullable String str) {
        this.f1858 = str;
    }

    public final void setPrivacyInformationIconClickThroughUrl(@Nullable String str) {
        this.f1865 = str;
    }

    public final void setPrivacyInformationIconImageUrl(@Nullable String str) {
        this.f1866 = str;
    }

    public final void setStarRating(@Nullable Double d) {
        if (d == null) {
            d = null;
        } else if (d.doubleValue() < 0.0d || d.doubleValue() > 5.0d) {
            MoPubLog.d("Ignoring attempt to set invalid star rating (" + d + "). Must be between 0.0 and 5.0.");
            return;
        }
        this.f1864 = d;
    }

    public final void setText(@Nullable String str) {
        this.f1863 = str;
    }

    public final void setTitle(@Nullable String str) {
        this.f1862 = str;
    }
}
