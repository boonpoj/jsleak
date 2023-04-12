package com.mopub.common.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Preconditions;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.common.privacy.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0182 implements ConsentData {
    @Nullable

    /* renamed from: ֏  reason: contains not printable characters */
    private String f588;
    @Nullable

    /* renamed from: ؠ  reason: contains not printable characters */
    private String f589;
    @Nullable

    /* renamed from: ހ  reason: contains not printable characters */
    private String f590;
    @Nullable

    /* renamed from: ށ  reason: contains not printable characters */
    private String f591;
    @Nullable

    /* renamed from: ނ  reason: contains not printable characters */
    private String f592;
    @Nullable

    /* renamed from: ރ  reason: contains not printable characters */
    private String f593;
    @Nullable

    /* renamed from: ބ  reason: contains not printable characters */
    private String f594;
    @Nullable

    /* renamed from: ޅ  reason: contains not printable characters */
    private String f595;

    /* renamed from: ކ  reason: contains not printable characters */
    private boolean f596;
    @Nullable

    /* renamed from: އ  reason: contains not printable characters */
    private Boolean f597;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f598;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f599;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private ConsentStatus f600;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private ConsentStatus f601;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private String f602;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f603;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private String f604;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private String f605;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private ConsentStatus f606;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private boolean f607;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private String f608;
    @Nullable

    /* renamed from: ࢬ  reason: contains not printable characters */
    private String f609;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0182(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        this.f598 = context.getApplicationContext();
        this.f600 = ConsentStatus.UNKNOWN;
        m547();
        this.f599 = str;
    }

    /* renamed from: ֏  reason: contains not printable characters */
    private void m547() {
        SharedPreferences sharedPreferences = SharedPreferencesHelper.getSharedPreferences(this.f598, "com.mopub.privacy");
        this.f599 = sharedPreferences.getString("info/adunit", "");
        this.f600 = ConsentStatus.fromString(sharedPreferences.getString("info/consent_status", ConsentStatus.UNKNOWN.name()));
        String string = sharedPreferences.getString("info/last_successfully_synced_consent_status", null);
        if (TextUtils.isEmpty(string)) {
            this.f601 = null;
        } else {
            this.f601 = ConsentStatus.fromString(string);
        }
        this.f607 = sharedPreferences.getBoolean("info/is_whitelisted", false);
        this.f608 = sharedPreferences.getString("info/current_vendor_list_version", null);
        this.f609 = sharedPreferences.getString("info/current_vendor_list_link", null);
        this.f588 = sharedPreferences.getString("info/current_privacy_policy_version", null);
        this.f589 = sharedPreferences.getString("info/current_privacy_policy_link", null);
        this.f590 = sharedPreferences.getString("info/current_vendor_list_iab_format", null);
        this.f591 = sharedPreferences.getString("info/current_vendor_list_iab_hash", null);
        this.f592 = sharedPreferences.getString("info/consented_vendor_list_version", null);
        this.f593 = sharedPreferences.getString("info/consented_privacy_policy_version", null);
        this.f594 = sharedPreferences.getString("info/consented_vendor_list_iab_format", null);
        this.f595 = sharedPreferences.getString("info/extras", null);
        this.f602 = sharedPreferences.getString("info/consent_change_reason", null);
        this.f596 = sharedPreferences.getBoolean("info/reacquire_consent", false);
        String string2 = sharedPreferences.getString("info/gdpr_applies", null);
        if (TextUtils.isEmpty(string2)) {
            this.f597 = null;
        } else {
            this.f597 = Boolean.valueOf(Boolean.parseBoolean(string2));
        }
        this.f603 = sharedPreferences.getBoolean("info/force_gdpr_applies", false);
        this.f604 = sharedPreferences.getString("info/udid", null);
        this.f605 = sharedPreferences.getString("info/last_changed_ms", null);
        String string3 = sharedPreferences.getString("info/consent_status_before_dnt", null);
        if (TextUtils.isEmpty(string3)) {
            this.f606 = null;
        } else {
            this.f606 = ConsentStatus.fromString(string3);
        }
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m548(@NonNull Context context, @Nullable String str) {
        String[] iSOLanguages;
        Preconditions.checkNotNull(context);
        for (String str2 : Locale.getISOLanguages()) {
            if (str2 != null && str2.equals(str)) {
                return str;
            }
        }
        return ClientMetadata.getCurrentLanguage(context);
    }

    @NonNull
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static String m549(@Nullable String str, @NonNull Context context, @Nullable String str2) {
        Preconditions.checkNotNull(context);
        return TextUtils.isEmpty(str) ? "" : str.replaceAll("%%LANGUAGE%%", m548(context, str2));
    }

    @Override // com.mopub.common.privacy.ConsentData
    @Nullable
    public String getConsentedPrivacyPolicyVersion() {
        return this.f593;
    }

    @Override // com.mopub.common.privacy.ConsentData
    @Nullable
    public String getConsentedVendorListIabFormat() {
        return this.f594;
    }

    @Override // com.mopub.common.privacy.ConsentData
    @Nullable
    public String getConsentedVendorListVersion() {
        return this.f592;
    }

    @Override // com.mopub.common.privacy.ConsentData
    @NonNull
    public String getCurrentPrivacyPolicyLink() {
        return getCurrentPrivacyPolicyLink(null);
    }

    @Override // com.mopub.common.privacy.ConsentData
    @NonNull
    public String getCurrentPrivacyPolicyLink(@Nullable String str) {
        return m549(this.f589, this.f598, str);
    }

    @Override // com.mopub.common.privacy.ConsentData
    @Nullable
    public String getCurrentPrivacyPolicyVersion() {
        return this.f588;
    }

    @Override // com.mopub.common.privacy.ConsentData
    @Nullable
    public String getCurrentVendorListIabFormat() {
        return this.f590;
    }

    @Override // com.mopub.common.privacy.ConsentData
    @NonNull
    public String getCurrentVendorListLink() {
        return getCurrentVendorListLink(null);
    }

    @Override // com.mopub.common.privacy.ConsentData
    @NonNull
    public String getCurrentVendorListLink(@Nullable String str) {
        return m549(this.f609, this.f598, str);
    }

    @Override // com.mopub.common.privacy.ConsentData
    @Nullable
    public String getCurrentVendorListVersion() {
        return this.f608;
    }

    @Nullable
    public String getExtras() {
        return this.f595;
    }

    @Override // com.mopub.common.privacy.ConsentData
    public boolean isForceGdprApplies() {
        return this.f603;
    }

    public void setExtras(@Nullable String str) {
        this.f595 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m550() {
        SharedPreferences.Editor edit = SharedPreferencesHelper.getSharedPreferences(this.f598, "com.mopub.privacy").edit();
        edit.putString("info/adunit", this.f599);
        edit.putString("info/consent_status", this.f600.name());
        edit.putString("info/last_successfully_synced_consent_status", this.f601 == null ? null : this.f601.name());
        edit.putBoolean("info/is_whitelisted", this.f607);
        edit.putString("info/current_vendor_list_version", this.f608);
        edit.putString("info/current_vendor_list_link", this.f609);
        edit.putString("info/current_privacy_policy_version", this.f588);
        edit.putString("info/current_privacy_policy_link", this.f589);
        edit.putString("info/current_vendor_list_iab_format", this.f590);
        edit.putString("info/current_vendor_list_iab_hash", this.f591);
        edit.putString("info/consented_vendor_list_version", this.f592);
        edit.putString("info/consented_privacy_policy_version", this.f593);
        edit.putString("info/consented_vendor_list_iab_format", this.f594);
        edit.putString("info/extras", this.f595);
        edit.putString("info/consent_change_reason", this.f602);
        edit.putBoolean("info/reacquire_consent", this.f596);
        edit.putString("info/gdpr_applies", this.f597 == null ? null : this.f597.toString());
        edit.putBoolean("info/force_gdpr_applies", this.f603);
        edit.putString("info/udid", this.f604);
        edit.putString("info/last_changed_ms", this.f605);
        edit.putString("info/consent_status_before_dnt", this.f606 != null ? this.f606.name() : null);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m551(@NonNull ConsentStatus consentStatus) {
        this.f600 = consentStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m552(@Nullable Boolean bool) {
        this.f597 = bool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m553(@Nullable String str) {
        this.f608 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m554(boolean z) {
        this.f607 = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢢ  reason: contains not printable characters */
    public String m555() {
        return this.f599;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m556(@Nullable ConsentStatus consentStatus) {
        this.f601 = consentStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m557(@Nullable String str) {
        this.f609 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m558(boolean z) {
        this.f596 = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢣ  reason: contains not printable characters */
    public ConsentStatus m559() {
        return this.f600;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m560(@Nullable ConsentStatus consentStatus) {
        this.f606 = consentStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m561(@Nullable String str) {
        this.f588 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m562(boolean z) {
        this.f603 = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢤ  reason: contains not printable characters */
    public ConsentStatus m563() {
        return this.f601;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m564(@Nullable String str) {
        this.f589 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public void m565(@Nullable String str) {
        this.f590 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public boolean m566() {
        return this.f607;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢦ  reason: contains not printable characters */
    public String m567() {
        return this.f591;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢦ  reason: contains not printable characters */
    public void m568(@Nullable String str) {
        this.f591 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢧ  reason: contains not printable characters */
    public String m569() {
        return this.f602;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢧ  reason: contains not printable characters */
    public void m570(@Nullable String str) {
        this.f592 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public void m571(@Nullable String str) {
        this.f593 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public boolean m572() {
        return this.f596;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢩ  reason: contains not printable characters */
    public Boolean m573() {
        return this.f597;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢩ  reason: contains not printable characters */
    public void m574(@Nullable String str) {
        this.f594 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢪ  reason: contains not printable characters */
    public String m575() {
        return this.f604;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢪ  reason: contains not printable characters */
    public void m576(@Nullable String str) {
        this.f602 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢫ  reason: contains not printable characters */
    public String m577() {
        return this.f605;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢫ  reason: contains not printable characters */
    public void m578(@Nullable String str) {
        this.f604 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢬ  reason: contains not printable characters */
    public ConsentStatus m579() {
        return this.f606;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢬ  reason: contains not printable characters */
    public void m580(@Nullable String str) {
        this.f605 = str;
    }
}
