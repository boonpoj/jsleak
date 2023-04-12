package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.AdFormat;
import com.mopub.common.AdType;
import com.mopub.common.util.ResponseHeader;
import com.mopub.network.HeaderUtils;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AdTypeTranslator {
    public static final String BANNER_SUFFIX = "_banner";
    public static final String INTERSTITIAL_SUFFIX = "_interstitial";

    /* loaded from: assets/classes2.dex */
    public enum CustomEventType {
        GOOGLE_PLAY_SERVICES_BANNER("admob_native_banner", "com.mopub.mobileads.GooglePlayServicesBanner", false),
        GOOGLE_PLAY_SERVICES_INTERSTITIAL("admob_full_interstitial", "com.mopub.mobileads.GooglePlayServicesInterstitial", false),
        MILLENNIAL_BANNER("millennial_native_banner", "com.mopub.mobileads.MillennialBanner", false),
        MILLENNIAL_INTERSTITIAL("millennial_full_interstitial", "com.mopub.mobileads.MillennialInterstitial", false),
        MRAID_BANNER("mraid_banner", "com.mopub.mraid.MraidBanner", true),
        MRAID_INTERSTITIAL("mraid_interstitial", "com.mopub.mraid.MraidInterstitial", true),
        HTML_BANNER("html_banner", "com.mopub.mobileads.HtmlBanner", true),
        HTML_INTERSTITIAL("html_interstitial", "com.mopub.mobileads.HtmlInterstitial", true),
        VAST_VIDEO_INTERSTITIAL("vast_interstitial", "com.mopub.mobileads.VastVideoInterstitial", true),
        MOPUB_NATIVE("mopub_native", "com.mopub.nativeads.MoPubCustomEventNative", true),
        MOPUB_VIDEO_NATIVE("mopub_video_native", "com.mopub.nativeads.MoPubCustomEventVideoNative", true),
        MOPUB_REWARDED_VIDEO(AdType.REWARDED_VIDEO, "com.mopub.mobileads.MoPubRewardedVideo", true),
        MOPUB_REWARDED_PLAYABLE(AdType.REWARDED_PLAYABLE, "com.mopub.mobileads.MoPubRewardedPlayable", true),
        UNSPECIFIED("", null, false);
        
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final String f723;
        @Nullable

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final String f724;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final boolean f725;

        CustomEventType(String str, String str2, boolean z) {
            this.f723 = str;
            this.f724 = str2;
            this.f725 = z;
        }

        public static boolean isMoPubSpecific(@Nullable String str) {
            return m658(str).f725;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ࢢ  reason: contains not printable characters */
        public static CustomEventType m657(@Nullable String str) {
            CustomEventType[] values;
            for (CustomEventType customEventType : values()) {
                if (customEventType.f723.equals(str)) {
                    return customEventType;
                }
            }
            return UNSPECIFIED;
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        private static CustomEventType m658(@Nullable String str) {
            CustomEventType[] values;
            for (CustomEventType customEventType : values()) {
                if (customEventType.f724 != null && customEventType.f724.equals(str)) {
                    return customEventType;
                }
            }
            return UNSPECIFIED;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f724;
        }
    }

    public static String getCustomEventName(@NonNull AdFormat adFormat, @NonNull String str, @Nullable String str2, @Nullable JSONObject jSONObject) {
        StringBuilder sb;
        String str3;
        if (AdType.CUSTOM.equalsIgnoreCase(str)) {
            return HeaderUtils.extractHeader(jSONObject, ResponseHeader.CUSTOM_EVENT_NAME);
        }
        if (AdType.STATIC_NATIVE.equalsIgnoreCase(str)) {
            return CustomEventType.MOPUB_NATIVE.toString();
        }
        if (AdType.VIDEO_NATIVE.equalsIgnoreCase(str)) {
            return CustomEventType.MOPUB_VIDEO_NATIVE.toString();
        }
        if (AdType.REWARDED_VIDEO.equalsIgnoreCase(str)) {
            return CustomEventType.MOPUB_REWARDED_VIDEO.toString();
        }
        if (AdType.REWARDED_PLAYABLE.equalsIgnoreCase(str)) {
            return CustomEventType.MOPUB_REWARDED_PLAYABLE.toString();
        }
        if (AdType.HTML.equalsIgnoreCase(str) || AdType.MRAID.equalsIgnoreCase(str)) {
            if (AdFormat.INTERSTITIAL.equals(adFormat)) {
                sb = new StringBuilder();
                sb.append(str);
                str3 = INTERSTITIAL_SUFFIX;
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str3 = BANNER_SUFFIX;
            }
            sb.append(str3);
            return CustomEventType.m657(sb.toString()).toString();
        } else if (AdType.INTERSTITIAL.equalsIgnoreCase(str)) {
            return CustomEventType.m657(str2 + INTERSTITIAL_SUFFIX).toString();
        } else {
            return CustomEventType.m657(str + BANNER_SUFFIX).toString();
        }
    }
}
