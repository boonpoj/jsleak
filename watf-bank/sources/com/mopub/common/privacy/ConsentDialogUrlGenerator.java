package com.mopub.common.privacy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
/* loaded from: assets/classes2.dex */
public class ConsentDialogUrlGenerator extends BaseUrlGenerator {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f495;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f496;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final String f497;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Boolean f498;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f499;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private String f500;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private String f501;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConsentDialogUrlGenerator(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        this.f495 = context.getApplicationContext();
        this.f496 = str;
        this.f497 = str2;
    }

    @Override // com.mopub.common.BaseUrlGenerator
    public String generateUrlString(String str) {
        m363(str, Constants.GDPR_CONSENT_HANDLER);
        m365("id", this.f496);
        m365("current_consent_status", this.f497);
        m365("nv", "5.4.1");
        m365("language", ClientMetadata.getCurrentLanguage(this.f495));
        m362("gdpr_applies", this.f498);
        m362("force_gdpr_applies", Boolean.valueOf(this.f499));
        m365("consented_vendor_list_version", this.f500);
        m365("consented_privacy_policy_version", this.f501);
        m365("bundle", ClientMetadata.getInstance(this.f495).getAppPackageName());
        return m367();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public ConsentDialogUrlGenerator m504(@Nullable Boolean bool) {
        this.f498 = bool;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public ConsentDialogUrlGenerator m505(@Nullable String str) {
        this.f500 = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public ConsentDialogUrlGenerator m506(boolean z) {
        this.f499 = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public ConsentDialogUrlGenerator m507(@Nullable String str) {
        this.f501 = str;
        return this;
    }
}
