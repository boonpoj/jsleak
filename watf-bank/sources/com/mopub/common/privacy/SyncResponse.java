package com.mopub.common.privacy;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
/* loaded from: assets/classes2.dex */
public class SyncResponse {
    @Nullable

    /* renamed from: ֏  reason: contains not printable characters */
    private final String f543;
    @Nullable

    /* renamed from: ؠ  reason: contains not printable characters */
    private final String f544;
    @Nullable

    /* renamed from: ހ  reason: contains not printable characters */
    private final String f545;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final boolean f546;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final boolean f547;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final boolean f548;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final boolean f549;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final boolean f550;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final boolean f551;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final String f552;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final String f553;
    @NonNull

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final String f554;
    @NonNull

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final String f555;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private final String f556;
    @NonNull

    /* renamed from: ࢬ  reason: contains not printable characters */
    private final String f557;

    /* loaded from: assets/classes2.dex */
    public static class Builder {

        /* renamed from: ֏  reason: contains not printable characters */
        private String f558;

        /* renamed from: ؠ  reason: contains not printable characters */
        private String f559;

        /* renamed from: ހ  reason: contains not printable characters */
        private String f560;

        /* renamed from: ࢠ  reason: contains not printable characters */
        private String f561;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private String f562;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private String f563;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private String f564;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private String f565;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private String f566;

        /* renamed from: ࢧ  reason: contains not printable characters */
        private String f567;

        /* renamed from: ࢨ  reason: contains not printable characters */
        private String f568;

        /* renamed from: ࢩ  reason: contains not printable characters */
        private String f569;

        /* renamed from: ࢪ  reason: contains not printable characters */
        private String f570;

        /* renamed from: ࢫ  reason: contains not printable characters */
        private String f571;

        /* renamed from: ࢬ  reason: contains not printable characters */
        private String f572;

        public SyncResponse build() {
            return new SyncResponse(this.f561, this.f562, this.f563, this.f564, this.f565, this.f566, this.f567, this.f568, this.f569, this.f570, this.f571, this.f572, this.f558, this.f559, this.f560);
        }

        public Builder setCallAgainAfterSecs(@Nullable String str) {
            this.f558 = str;
            return this;
        }

        public Builder setConsentChangeReason(@Nullable String str) {
            this.f560 = str;
            return this;
        }

        public Builder setCurrentPrivacyPolicyLink(@NonNull String str) {
            this.f570 = str;
            return this;
        }

        public Builder setCurrentPrivacyPolicyVersion(@NonNull String str) {
            this.f569 = str;
            return this;
        }

        public Builder setCurrentVendorListIabFormat(@Nullable String str) {
            this.f571 = str;
            return this;
        }

        public Builder setCurrentVendorListIabHash(@NonNull String str) {
            this.f572 = str;
            return this;
        }

        public Builder setCurrentVendorListLink(@NonNull String str) {
            this.f568 = str;
            return this;
        }

        public Builder setCurrentVendorListVersion(@NonNull String str) {
            this.f567 = str;
            return this;
        }

        public Builder setExtras(@Nullable String str) {
            this.f559 = str;
            return this;
        }

        public Builder setForceExplicitNo(@Nullable String str) {
            this.f562 = str;
            return this;
        }

        public Builder setForceGdprApplies(@Nullable String str) {
            this.f566 = str;
            return this;
        }

        public Builder setInvalidateConsent(@Nullable String str) {
            this.f563 = str;
            return this;
        }

        public Builder setIsGdprRegion(@NonNull String str) {
            this.f561 = str;
            return this;
        }

        public Builder setIsWhitelisted(@NonNull String str) {
            this.f565 = str;
            return this;
        }

        public Builder setReacquireConsent(@Nullable String str) {
            this.f564 = str;
            return this;
        }
    }

    private SyncResponse(@NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull String str5, @Nullable String str6, @NonNull String str7, @NonNull String str8, @NonNull String str9, @NonNull String str10, @Nullable String str11, @NonNull String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str5);
        Preconditions.checkNotNull(str7);
        Preconditions.checkNotNull(str8);
        Preconditions.checkNotNull(str9);
        Preconditions.checkNotNull(str10);
        Preconditions.checkNotNull(str12);
        this.f546 = !"0".equals(str);
        this.f547 = "1".equals(str2);
        this.f548 = "1".equals(str3);
        this.f549 = "1".equals(str4);
        this.f550 = "1".equals(str5);
        this.f551 = "1".equals(str6);
        this.f552 = str7;
        this.f553 = str8;
        this.f554 = str9;
        this.f555 = str10;
        this.f556 = str11;
        this.f557 = str12;
        this.f543 = str13;
        this.f544 = str14;
        this.f545 = str15;
    }

    @Nullable
    public String getCallAgainAfterSecs() {
        return this.f543;
    }

    @Nullable
    public String getConsentChangeReason() {
        return this.f545;
    }

    @NonNull
    public String getCurrentPrivacyPolicyLink() {
        return this.f555;
    }

    @NonNull
    public String getCurrentPrivacyPolicyVersion() {
        return this.f554;
    }

    @Nullable
    public String getCurrentVendorListIabFormat() {
        return this.f556;
    }

    @NonNull
    public String getCurrentVendorListIabHash() {
        return this.f557;
    }

    @NonNull
    public String getCurrentVendorListLink() {
        return this.f553;
    }

    @NonNull
    public String getCurrentVendorListVersion() {
        return this.f552;
    }

    public boolean isForceExplicitNo() {
        return this.f547;
    }

    public boolean isForceGdprApplies() {
        return this.f551;
    }

    public boolean isGdprRegion() {
        return this.f546;
    }

    public boolean isInvalidateConsent() {
        return this.f548;
    }

    public boolean isReacquireConsent() {
        return this.f549;
    }

    public boolean isWhitelisted() {
        return this.f550;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m546() {
        return this.f544;
    }
}
