package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.ConsentData;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.VolleyError;
/* loaded from: assets/classes2.dex */
public class MoPubConversionTracker {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f876;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f877;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final String f878;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private SharedPreferences f879;

    public MoPubConversionTracker(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        this.f876 = context.getApplicationContext();
        String packageName = this.f876.getPackageName();
        this.f877 = packageName + " wantToTrack";
        this.f878 = packageName + " tracked";
        this.f879 = SharedPreferencesHelper.getSharedPreferences(this.f876);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m778() {
        return this.f879.getBoolean(this.f878, false);
    }

    public void reportAppOpen() {
        reportAppOpen(false);
    }

    public void reportAppOpen(boolean z) {
        PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
        if (personalInformationManager == null) {
            MoPubLog.w("Cannot report app open until initialization is done");
        } else if (!z && m778()) {
            MoPubLog.d("Conversion already tracked");
        } else if (!z && !MoPub.canCollectPersonalInformation()) {
            this.f879.edit().putBoolean(this.f877, true).apply();
        } else {
            ConsentData consentData = personalInformationManager.getConsentData();
            TrackingRequest.makeTrackingHttpRequest(new C0236(this.f876).withGdprApplies(personalInformationManager.gdprApplies()).withForceGdprApplies(consentData.isForceGdprApplies()).withCurrentConsentStatus(personalInformationManager.getPersonalInfoConsentStatus().getValue()).withConsentedPrivacyPolicyVersion(consentData.getConsentedPrivacyPolicyVersion()).withConsentedVendorListVersion(consentData.getConsentedVendorListVersion()).withSessionTracker(z).generateUrlString(Constants.HOST), this.f876, new TrackingRequest.Listener() { // from class: com.mopub.mobileads.MoPubConversionTracker.1
                @Override // com.mopub.volley.Response.ErrorListener
                public void onErrorResponse(VolleyError volleyError) {
                }

                @Override // com.mopub.network.TrackingRequest.Listener
                public void onResponse(@NonNull String str) {
                    MoPubConversionTracker.this.f879.edit().putBoolean(MoPubConversionTracker.this.f878, true).putBoolean(MoPubConversionTracker.this.f877, false).apply();
                }
            });
        }
    }

    public boolean shouldTrack() {
        PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
        return personalInformationManager != null && personalInformationManager.canCollectPersonalInformation() && this.f879.getBoolean(this.f877, false);
    }
}
