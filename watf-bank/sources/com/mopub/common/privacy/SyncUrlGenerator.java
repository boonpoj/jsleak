package com.mopub.common.privacy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.network.PlayServicesUrlRewriter;
/* loaded from: assets/classes2.dex */
public class SyncUrlGenerator extends BaseUrlGenerator {

    /* renamed from: ֏  reason: contains not printable characters */
    private boolean f573;
    @Nullable

    /* renamed from: ؠ  reason: contains not printable characters */
    private Boolean f574;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f575;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f576;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f577;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f578;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private String f579;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final String f580;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private String f581;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private String f582;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private String f583;
    @Nullable

    /* renamed from: ࢪ  reason: contains not printable characters */
    private String f584;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private String f585;
    @Nullable

    /* renamed from: ࢬ  reason: contains not printable characters */
    private Boolean f586;

    public SyncUrlGenerator(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        this.f575 = context.getApplicationContext();
        this.f580 = str;
    }

    @Override // com.mopub.common.BaseUrlGenerator
    public String generateUrlString(@NonNull String str) {
        m363(str, Constants.GDPR_SYNC_HANDLER);
        m365("id", this.f576);
        m365("nv", "5.4.1");
        m365("last_changed_ms", this.f578);
        m365("last_consent_status", this.f579);
        m365("current_consent_status", this.f580);
        m365("consent_change_reason", this.f581);
        m365("consented_vendor_list_version", this.f582);
        m365("consented_privacy_policy_version", this.f583);
        m365("cached_vendor_list_iab_hash", this.f584);
        m365("extras", this.f585);
        m365("udid", this.f577);
        m362("gdpr_applies", this.f586);
        m362("force_gdpr_applies", Boolean.valueOf(this.f573));
        m362("forced_gdpr_applies_changed", this.f574);
        m365("bundle", ClientMetadata.getInstance(this.f575).getAppPackageName());
        m365("dnt", PlayServicesUrlRewriter.DO_NOT_TRACK_TEMPLATE);
        return m367();
    }

    public SyncUrlGenerator withAdUnitId(@Nullable String str) {
        this.f576 = str;
        return this;
    }

    public SyncUrlGenerator withCachedVendorListIabHash(@Nullable String str) {
        this.f584 = str;
        return this;
    }

    public SyncUrlGenerator withConsentChangeReason(@Nullable String str) {
        this.f581 = str;
        return this;
    }

    public SyncUrlGenerator withConsentedPrivacyPolicyVersion(@Nullable String str) {
        this.f583 = str;
        return this;
    }

    public SyncUrlGenerator withConsentedVendorListVersion(@Nullable String str) {
        this.f582 = str;
        return this;
    }

    public SyncUrlGenerator withExtras(@Nullable String str) {
        this.f585 = str;
        return this;
    }

    public SyncUrlGenerator withForceGdprApplies(boolean z) {
        this.f573 = z;
        return this;
    }

    public SyncUrlGenerator withForceGdprAppliesChanged(@Nullable Boolean bool) {
        this.f574 = bool;
        return this;
    }

    public SyncUrlGenerator withGdprApplies(@Nullable Boolean bool) {
        this.f586 = bool;
        return this;
    }

    public SyncUrlGenerator withLastChangedMs(@Nullable String str) {
        this.f578 = str;
        return this;
    }

    public SyncUrlGenerator withLastConsentStatus(@Nullable ConsentStatus consentStatus) {
        this.f579 = consentStatus == null ? null : consentStatus.getValue();
        return this;
    }

    public SyncUrlGenerator withUdid(@Nullable String str) {
        this.f577 = str;
        return this;
    }
}
