package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;
import java.util.Date;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final zzlt zzals;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final zzlu zzalt = new zzlu();

        public final Builder addCategoryExclusion(String str) {
            this.zzalt.zzaj(str);
            return this;
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzalt.zzb(cls, bundle);
            return this;
        }

        public final Builder addCustomTargeting(String str, String str2) {
            this.zzalt.zzd(str, str2);
            return this;
        }

        public final Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zzalt.zzd(str, TextUtils.join(",", list));
            }
            return this;
        }

        public final Builder addKeyword(String str) {
            this.zzalt.zzad(str);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzalt.zza(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzalt.zza(cls, bundle);
            return this;
        }

        public final Builder addTestDevice(String str) {
            this.zzalt.zzae(str);
            return this;
        }

        public final PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        public final Builder setBirthday(Date date) {
            this.zzalt.zza(date);
            return this;
        }

        public final Builder setContentUrl(String str) {
            zzbq.checkNotNull(str, "Content URL must be non-null.");
            zzbq.zzh(str, "Content URL must be non-empty.");
            zzbq.zzb(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.zzalt.zzag(str);
            return this;
        }

        public final Builder setGender(int i) {
            this.zzalt.zzr(i);
            return this;
        }

        public final Builder setIsDesignedForFamilies(boolean z) {
            this.zzalt.zzj(z);
            return this;
        }

        public final Builder setLocation(Location location) {
            this.zzalt.zzb(location);
            return this;
        }

        @Deprecated
        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzalt.setManualImpressionsEnabled(z);
            return this;
        }

        public final Builder setPublisherProvidedId(String str) {
            this.zzalt.zzah(str);
            return this;
        }

        public final Builder setRequestAgent(String str) {
            this.zzalt.zzai(str);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.zzalt.zzi(z);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.zzals = new zzlt(builder.zzalt);
    }

    public static void updateCorrelator() {
    }

    public final Date getBirthday() {
        return this.zzals.getBirthday();
    }

    public final String getContentUrl() {
        return this.zzals.getContentUrl();
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzals.getCustomEventExtrasBundle(cls);
    }

    public final Bundle getCustomTargeting() {
        return this.zzals.getCustomTargeting();
    }

    public final int getGender() {
        return this.zzals.getGender();
    }

    public final Set<String> getKeywords() {
        return this.zzals.getKeywords();
    }

    public final Location getLocation() {
        return this.zzals.getLocation();
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzals.getManualImpressionsEnabled();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzals.getNetworkExtras(cls);
    }

    public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzals.getNetworkExtrasBundle(cls);
    }

    public final String getPublisherProvidedId() {
        return this.zzals.getPublisherProvidedId();
    }

    public final boolean isTestDevice(Context context) {
        return this.zzals.isTestDevice(context);
    }

    public final zzlt zzbg() {
        return this.zzals;
    }
}
