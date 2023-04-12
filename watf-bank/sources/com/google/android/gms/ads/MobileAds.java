package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzma;
/* loaded from: classes.dex */
public class MobileAds {

    /* loaded from: classes.dex */
    public static final class Settings {
        private final zzma zzamb = new zzma();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }

        final zzma zzbi() {
            return this.zzamb;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzly.zziq().getRewardedVideoAdInstance(context);
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzly.zziq().zza(context, str, settings == null ? null : settings.zzbi());
    }

    public static void openDebugMenu(Context context, String str) {
        zzly.zziq().openDebugMenu(context, str);
    }

    public static void setAppMuted(boolean z) {
        zzly.zziq().setAppMuted(z);
    }

    public static void setAppVolume(float f) {
        zzly.zziq().setAppVolume(f);
    }
}
