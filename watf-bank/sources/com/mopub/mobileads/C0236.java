package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
/* renamed from: com.mopub.mobileads.ࢥ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0236 extends BaseUrlGenerator {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Context f1249;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f1250;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f1251;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f1252;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Boolean f1253;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f1254;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f1255;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0236(@NonNull Context context) {
        this.f1249 = context;
    }

    @Override // com.mopub.common.BaseUrlGenerator
    public String generateUrlString(String str) {
        ClientMetadata clientMetadata = ClientMetadata.getInstance(this.f1249);
        m363(str, Constants.CONVERSION_TRACKING_HANDLER);
        m359("6");
        m360(clientMetadata.getAppVersion());
        m368();
        m365("id", this.f1249.getPackageName());
        if (this.f1255) {
            m362("st", (Boolean) true);
        }
        m365("nv", "5.4.1");
        m365("current_consent_status", this.f1250);
        m365("consented_vendor_list_version", this.f1251);
        m365("consented_privacy_policy_version", this.f1252);
        m362("gdpr_applies", this.f1253);
        m362("force_gdpr_applies", Boolean.valueOf(this.f1254));
        return m367();
    }

    public C0236 withConsentedPrivacyPolicyVersion(@Nullable String str) {
        this.f1252 = str;
        return this;
    }

    public C0236 withConsentedVendorListVersion(@Nullable String str) {
        this.f1251 = str;
        return this;
    }

    public C0236 withCurrentConsentStatus(@Nullable String str) {
        this.f1250 = str;
        return this;
    }

    public C0236 withForceGdprApplies(boolean z) {
        this.f1254 = z;
        return this;
    }

    public C0236 withGdprApplies(@Nullable Boolean bool) {
        this.f1253 = bool;
        return this;
    }

    public C0236 withSessionTracker(boolean z) {
        this.f1255 = z;
        return this;
    }
}
