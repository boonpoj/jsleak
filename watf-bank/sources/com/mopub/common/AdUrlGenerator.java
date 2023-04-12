package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.ClientMetadata;
import com.mopub.common.privacy.ConsentData;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.common.util.DateAndTime;
/* loaded from: assets/classes2.dex */
public abstract class AdUrlGenerator extends BaseUrlGenerator {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected Context f261;

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected String f262;

    /* renamed from: ࢣ  reason: contains not printable characters */
    protected String f263;

    /* renamed from: ࢤ  reason: contains not printable characters */
    protected String f264;

    /* renamed from: ࢥ  reason: contains not printable characters */
    protected Location f265;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final PersonalInfoManager f266 = MoPub.getPersonalInformationManager();
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final ConsentData f267;

    public AdUrlGenerator(Context context) {
        this.f261 = context;
        this.f267 = this.f266 == null ? null : this.f266.getConsentData();
    }

    /* renamed from: ހ  reason: contains not printable characters */
    private int m328(String str) {
        return Math.min(3, str.length());
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m329(String str, ClientMetadata.MoPubNetworkType moPubNetworkType) {
        m365(str, moPubNetworkType.toString());
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static int m330(Location location) {
        Preconditions.checkNotNull(location);
        return (int) (System.currentTimeMillis() - location.getTime());
    }

    public AdUrlGenerator withAdUnitId(String str) {
        this.f262 = str;
        return this;
    }

    @Deprecated
    public AdUrlGenerator withFacebookSupported(boolean z) {
        return this;
    }

    public AdUrlGenerator withKeywords(String str) {
        this.f263 = str;
        return this;
    }

    public AdUrlGenerator withLocation(Location location) {
        this.f265 = location;
        return this;
    }

    public AdUrlGenerator withUserDataKeywords(String str) {
        this.f264 = str;
        return this;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void m331() {
        m365("abt", MoPub.m438(this.f261));
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void m332(float f) {
        m365("sc", "" + f);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void m333(@Nullable Location location) {
        if (MoPub.canCollectPersonalInformation()) {
            Location lastKnownLocation = LocationService.getLastKnownLocation(this.f261, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
            if (lastKnownLocation != null && (location == null || lastKnownLocation.getTime() >= location.getTime())) {
                location = lastKnownLocation;
            }
            if (location != null) {
                m365("ll", location.getLatitude() + "," + location.getLongitude());
                m365("lla", String.valueOf((int) location.getAccuracy()));
                m365("llf", String.valueOf(m330(location)));
                if (location == lastKnownLocation) {
                    m365("llsdk", "1");
                }
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void m334(ClientMetadata.MoPubNetworkType moPubNetworkType) {
        m329("ct", moPubNetworkType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m335(ClientMetadata clientMetadata) {
        m336(this.f262);
        m339(clientMetadata.getSdkVersion());
        m364(clientMetadata.getDeviceManufacturer(), clientMetadata.getDeviceModel(), clientMetadata.getDeviceProduct());
        m352(clientMetadata.getAppPackageName());
        m341(this.f263);
        if (MoPub.canCollectPersonalInformation()) {
            m343(this.f264);
            m333(this.f265);
        }
        m345(DateAndTime.getTimeZoneOffsetString());
        m347(clientMetadata.getOrientationString());
        m361(clientMetadata.getDeviceDimensions());
        m332(clientMetadata.getDensity());
        String networkOperatorForUrl = clientMetadata.getNetworkOperatorForUrl();
        m348(networkOperatorForUrl);
        m349(networkOperatorForUrl);
        m350(clientMetadata.getIsoCountryCode());
        m351(clientMetadata.getNetworkOperatorName());
        m334(clientMetadata.getActiveNetworkType());
        m360(clientMetadata.getAppVersion());
        m331();
        m368();
        m338();
        m340();
        m342();
        m344();
        m346();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void m336(String str) {
        m365("id", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m337(boolean z) {
        if (z) {
            m365("mr", "1");
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected void m338() {
        if (this.f266 != null) {
            m362("gdpr_applies", this.f266.gdprApplies());
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected void m339(String str) {
        m365("nv", str);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    protected void m340() {
        if (this.f267 != null) {
            m362("force_gdpr_applies", Boolean.valueOf(this.f267.isForceGdprApplies()));
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    protected void m341(String str) {
        m365("q", str);
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    protected void m342() {
        if (this.f266 != null) {
            m365("current_consent_status", this.f266.getPersonalInfoConsentStatus().getValue());
        }
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    protected void m343(String str) {
        if (MoPub.canCollectPersonalInformation()) {
            m365("user_data_q", str);
        }
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    protected void m344() {
        if (this.f267 != null) {
            m365("consented_privacy_policy_version", this.f267.getConsentedPrivacyPolicyVersion());
        }
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    protected void m345(String str) {
        m365("z", str);
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    protected void m346() {
        if (this.f267 != null) {
            m365("consented_vendor_list_version", this.f267.getConsentedVendorListVersion());
        }
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    protected void m347(String str) {
        m365("o", str);
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    protected void m348(String str) {
        m365("mcc", str == null ? "" : str.substring(0, m328(str)));
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    protected void m349(String str) {
        m365("mnc", str == null ? "" : str.substring(m328(str)));
    }

    /* renamed from: ࢩ  reason: contains not printable characters */
    protected void m350(String str) {
        m365("iso", str);
    }

    /* renamed from: ࢪ  reason: contains not printable characters */
    protected void m351(String str) {
        m365("cn", str);
    }

    /* renamed from: ࢫ  reason: contains not printable characters */
    protected void m352(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m365("bundle", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢬ  reason: contains not printable characters */
    public void m353(@NonNull String str) {
        Preconditions.checkNotNull(str);
        m365("vv", str);
    }
}
