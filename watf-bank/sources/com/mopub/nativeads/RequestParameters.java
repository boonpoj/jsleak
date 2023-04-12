package com.mopub.nativeads;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.MoPub;
import java.util.EnumSet;
/* loaded from: assets/classes2.dex */
public class RequestParameters {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f1846;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f1847;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Location f1848;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final EnumSet<NativeAdAsset> f1849;

    /* loaded from: assets/classes2.dex */
    public static final class Builder {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private String f1850;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private String f1851;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private Location f1852;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private EnumSet<NativeAdAsset> f1853;

        @NonNull
        public final RequestParameters build() {
            return new RequestParameters(this);
        }

        @NonNull
        public final Builder desiredAssets(EnumSet<NativeAdAsset> enumSet) {
            this.f1853 = EnumSet.copyOf((EnumSet) enumSet);
            return this;
        }

        @NonNull
        public final Builder keywords(String str) {
            this.f1850 = str;
            return this;
        }

        @NonNull
        public final Builder location(Location location) {
            if (!MoPub.canCollectPersonalInformation()) {
                location = null;
            }
            this.f1852 = location;
            return this;
        }

        @NonNull
        public final Builder userDataKeywords(String str) {
            if (!MoPub.canCollectPersonalInformation()) {
                str = null;
            }
            this.f1851 = str;
            return this;
        }
    }

    /* loaded from: assets/classes2.dex */
    public enum NativeAdAsset {
        TITLE("title"),
        TEXT("text"),
        ICON_IMAGE("iconimage"),
        MAIN_IMAGE("mainimage"),
        CALL_TO_ACTION_TEXT("ctatext"),
        STAR_RATING("starrating");
        

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final String f1855;

        NativeAdAsset(String str) {
            this.f1855 = str;
        }

        @Override // java.lang.Enum
        @NonNull
        public String toString() {
            return this.f1855;
        }
    }

    private RequestParameters(@NonNull Builder builder) {
        this.f1846 = builder.f1850;
        this.f1849 = builder.f1853;
        boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
        this.f1847 = canCollectPersonalInformation ? builder.f1851 : null;
        this.f1848 = canCollectPersonalInformation ? builder.f1852 : null;
    }

    public final String getDesiredAssets() {
        return this.f1849 != null ? TextUtils.join(",", this.f1849.toArray()) : "";
    }

    @Nullable
    public final String getKeywords() {
        return this.f1846;
    }

    @Nullable
    public final Location getLocation() {
        return this.f1848;
    }

    @Nullable
    public final String getUserDataKeywords() {
        if (MoPub.canCollectPersonalInformation()) {
            return this.f1847;
        }
        return null;
    }
}
