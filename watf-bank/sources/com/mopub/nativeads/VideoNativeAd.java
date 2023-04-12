package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.Preconditions;
import com.mopub.nativeads.NativeVideoController;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public abstract class VideoNativeAd extends BaseNativeAd implements NativeVideoController.Listener {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f1870;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f1871;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f1872;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f1873;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private String f1874;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private String f1875;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private String f1876;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private String f1877;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private String f1878;
    @NonNull

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final Map<String, Object> f1879 = new HashMap();

    public final void addExtra(@NonNull String str, @Nullable Object obj) {
        if (Preconditions.NoThrow.checkNotNull(str, "addExtra key is not allowed to be null")) {
            this.f1879.put(str, obj);
        }
    }

    @Override // com.mopub.nativeads.BaseNativeAd
    public void clear(@NonNull View view) {
    }

    @Override // com.mopub.nativeads.BaseNativeAd
    public void destroy() {
    }

    @Nullable
    public String getCallToAction() {
        return this.f1873;
    }

    @Nullable
    public String getClickDestinationUrl() {
        return this.f1872;
    }

    @Nullable
    public final Object getExtra(@NonNull String str) {
        if (Preconditions.NoThrow.checkNotNull(str, "getExtra key is not allowed to be null")) {
            return this.f1879.get(str);
        }
        return null;
    }

    public final Map<String, Object> getExtras() {
        return this.f1879;
    }

    @Nullable
    public String getIconImageUrl() {
        return this.f1871;
    }

    @Nullable
    public String getMainImageUrl() {
        return this.f1870;
    }

    @Nullable
    public String getPrivacyInformationIconClickThroughUrl() {
        return this.f1876;
    }

    @Nullable
    public String getPrivacyInformationIconImageUrl() {
        return this.f1877;
    }

    @Nullable
    public String getText() {
        return this.f1875;
    }

    @Nullable
    public String getTitle() {
        return this.f1874;
    }

    @Nullable
    public String getVastVideo() {
        return this.f1878;
    }

    @Override // com.mopub.nativeads.BaseNativeAd
    public void prepare(@NonNull View view) {
    }

    public void render(@NonNull MediaLayout mediaLayout) {
    }

    public void setCallToAction(@Nullable String str) {
        this.f1873 = str;
    }

    public void setClickDestinationUrl(@Nullable String str) {
        this.f1872 = str;
    }

    public void setIconImageUrl(@Nullable String str) {
        this.f1871 = str;
    }

    public void setMainImageUrl(@Nullable String str) {
        this.f1870 = str;
    }

    public void setPrivacyInformationIconClickThroughUrl(@Nullable String str) {
        this.f1876 = str;
    }

    public void setPrivacyInformationIconImageUrl(@Nullable String str) {
        this.f1877 = str;
    }

    public void setText(@Nullable String str) {
        this.f1875 = str;
    }

    public void setTitle(@Nullable String str) {
        this.f1874 = str;
    }

    public void setVastVideo(String str) {
        this.f1878 = str;
    }
}
