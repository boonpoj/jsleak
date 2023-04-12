package com.mopub.common.privacy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.MoPubIdentifier;
import com.mopub.common.privacy.SyncRequest;
import com.mopub.common.util.ManifestUtils;
import com.mopub.mobileads.MoPubConversionTracker;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MultiAdResponse;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: assets/classes2.dex */
public class PersonalInfoManager {

    /* renamed from: ֏  reason: contains not printable characters */
    private boolean f511;

    /* renamed from: ؠ  reason: contains not printable characters */
    private boolean f512;

    /* renamed from: ހ  reason: contains not printable characters */
    private boolean f513;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f514;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Set<ConsentStatusChangeListener> f515;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final C0182 f516;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final ConsentDialogController f517;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final MoPubConversionTracker f518;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final SyncRequest.Listener f519;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private MultiAdResponse.ServerOverrideListener f520;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private SdkInitializationListener f521;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private long f522 = 300000;
    @Nullable

    /* renamed from: ࢪ  reason: contains not printable characters */
    private Long f523;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private ConsentStatus f524;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private long f525;

    /* renamed from: com.mopub.common.privacy.PersonalInfoManager$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private class C0179 implements MultiAdResponse.ServerOverrideListener {
        private C0179() {
        }

        @Override // com.mopub.network.MultiAdResponse.ServerOverrideListener
        public void onForceExplicitNo(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                PersonalInfoManager.this.m524(ConsentStatus.EXPLICIT_NO, ConsentChangeReason.REVOKED_BY_SERVER);
            } else {
                PersonalInfoManager.this.m544(ConsentStatus.EXPLICIT_NO, str);
            }
        }

        @Override // com.mopub.network.MultiAdResponse.ServerOverrideListener
        public void onForceGdprApplies() {
            PersonalInfoManager.this.forceGdprApplies();
        }

        @Override // com.mopub.network.MultiAdResponse.ServerOverrideListener
        public void onInvalidateConsent(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                PersonalInfoManager.this.m524(ConsentStatus.UNKNOWN, ConsentChangeReason.REACQUIRE_BY_SERVER);
            } else {
                PersonalInfoManager.this.m544(ConsentStatus.UNKNOWN, str);
            }
        }

        @Override // com.mopub.network.MultiAdResponse.ServerOverrideListener
        public void onReacquireConsent(@Nullable String str) {
            if (!TextUtils.isEmpty(str)) {
                PersonalInfoManager.this.f516.m576(str);
            }
            PersonalInfoManager.this.f516.m558(true);
            PersonalInfoManager.this.f516.m550();
        }
    }

    /* renamed from: com.mopub.common.privacy.PersonalInfoManager$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private class C0180 implements SyncRequest.Listener {
        private C0180() {
        }

        @Override // com.mopub.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed sync request because of ");
            sb.append(volleyError instanceof MoPubNetworkError ? ((MoPubNetworkError) volleyError).getReason() : volleyError.getMessage());
            MoPubLog.d(sb.toString());
            PersonalInfoManager.this.f511 = false;
            if (PersonalInfoManager.this.f521 != null) {
                MoPubLog.d("Personal Info Manager initialization finished but ran into errors.");
                PersonalInfoManager.this.f521.onInitializationFinished();
                PersonalInfoManager.this.f521 = null;
            }
        }

        @Override // com.mopub.common.privacy.SyncRequest.Listener
        public void onSuccess(SyncResponse syncResponse) {
            boolean canCollectPersonalInformation = PersonalInfoManager.this.canCollectPersonalInformation();
            if (PersonalInfoManager.this.f516.m573() == null) {
                PersonalInfoManager.this.f516.m552(Boolean.valueOf(syncResponse.isGdprRegion()));
            }
            if (syncResponse.isForceGdprApplies()) {
                PersonalInfoManager.this.f512 = true;
                PersonalInfoManager.this.f516.m562(true);
                boolean canCollectPersonalInformation2 = PersonalInfoManager.this.canCollectPersonalInformation();
                if (canCollectPersonalInformation != canCollectPersonalInformation2) {
                    PersonalInfoManager.this.m525(PersonalInfoManager.this.f516.m559(), PersonalInfoManager.this.f516.m559(), canCollectPersonalInformation2);
                }
            }
            C0182 c0182 = PersonalInfoManager.this.f516;
            c0182.m580("" + PersonalInfoManager.this.f525);
            PersonalInfoManager.this.f516.m556(PersonalInfoManager.this.f524);
            PersonalInfoManager.this.f516.m554(syncResponse.isWhitelisted());
            PersonalInfoManager.this.f516.m553(syncResponse.getCurrentVendorListVersion());
            PersonalInfoManager.this.f516.m557(syncResponse.getCurrentVendorListLink());
            PersonalInfoManager.this.f516.m561(syncResponse.getCurrentPrivacyPolicyVersion());
            PersonalInfoManager.this.f516.m564(syncResponse.getCurrentPrivacyPolicyLink());
            String currentVendorListIabHash = syncResponse.getCurrentVendorListIabHash();
            String currentVendorListIabFormat = syncResponse.getCurrentVendorListIabFormat();
            if (!TextUtils.isEmpty(currentVendorListIabHash) && !currentVendorListIabHash.equals(PersonalInfoManager.this.f516.m567()) && !TextUtils.isEmpty(currentVendorListIabFormat)) {
                PersonalInfoManager.this.f516.m565(currentVendorListIabFormat);
                PersonalInfoManager.this.f516.m568(currentVendorListIabHash);
            }
            String m546 = syncResponse.m546();
            if (!TextUtils.isEmpty(m546)) {
                PersonalInfoManager.this.f516.setExtras(m546);
            }
            String consentChangeReason = syncResponse.getConsentChangeReason();
            if (syncResponse.isForceExplicitNo()) {
                PersonalInfoManager.this.f520.onForceExplicitNo(consentChangeReason);
            } else if (syncResponse.isInvalidateConsent()) {
                PersonalInfoManager.this.f520.onInvalidateConsent(consentChangeReason);
            } else if (syncResponse.isReacquireConsent()) {
                PersonalInfoManager.this.f520.onReacquireConsent(consentChangeReason);
            }
            String callAgainAfterSecs = syncResponse.getCallAgainAfterSecs();
            if (!TextUtils.isEmpty(callAgainAfterSecs)) {
                try {
                    long parseLong = Long.parseLong(callAgainAfterSecs);
                    if (parseLong > 0) {
                        PersonalInfoManager.this.f522 = parseLong * 1000;
                    } else {
                        MoPubLog.d("callAgainAfterSecs is not positive: " + callAgainAfterSecs);
                    }
                } catch (NumberFormatException unused) {
                    MoPubLog.d("Unable to parse callAgainAfterSecs. Ignoring value");
                }
            }
            if (!ConsentStatus.EXPLICIT_YES.equals(PersonalInfoManager.this.f524)) {
                PersonalInfoManager.this.f516.m578(null);
            }
            if (PersonalInfoManager.this.f513) {
                PersonalInfoManager.this.f512 = false;
                PersonalInfoManager.this.f513 = false;
            }
            PersonalInfoManager.this.f516.m550();
            PersonalInfoManager.this.f511 = false;
            if (ConsentStatus.POTENTIAL_WHITELIST.equals(PersonalInfoManager.this.f524) && PersonalInfoManager.this.f516.m566()) {
                PersonalInfoManager.this.m524(ConsentStatus.EXPLICIT_YES, ConsentChangeReason.GRANTED_BY_WHITELISTED_PUB);
                PersonalInfoManager.this.requestSync(true);
            }
            if (PersonalInfoManager.this.f521 != null) {
                PersonalInfoManager.this.f521.onInitializationFinished();
                PersonalInfoManager.this.f521 = null;
            }
        }
    }

    public PersonalInfoManager(@NonNull Context context, @NonNull String str, @Nullable SdkInitializationListener sdkInitializationListener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        this.f514 = context.getApplicationContext();
        this.f515 = Collections.synchronizedSet(new HashSet());
        this.f519 = new C0180();
        this.f520 = new C0179();
        MultiAdResponse.setServerOverrideListener(this.f520);
        this.f517 = new ConsentDialogController(this.f514);
        this.f516 = new C0182(this.f514, str);
        this.f518 = new MoPubConversionTracker(this.f514);
        MoPubIdentifier.AdvertisingIdChangeListener advertisingIdChangeListener = new MoPubIdentifier.AdvertisingIdChangeListener() { // from class: com.mopub.common.privacy.PersonalInfoManager.1
            @Override // com.mopub.common.privacy.MoPubIdentifier.AdvertisingIdChangeListener
            public void onIdChanged(@NonNull AdvertisingId advertisingId, @NonNull AdvertisingId advertisingId2) {
                Preconditions.checkNotNull(advertisingId);
                Preconditions.checkNotNull(advertisingId2);
                if (advertisingId.isDoNotTrack() && advertisingId2.isDoNotTrack()) {
                    return;
                }
                if (!advertisingId.isDoNotTrack() && advertisingId2.isDoNotTrack()) {
                    PersonalInfoManager.this.m524(ConsentStatus.DNT, ConsentChangeReason.DENIED_BY_DNT_ON);
                    PersonalInfoManager.this.requestSync(true);
                } else if (advertisingId.isDoNotTrack() && !advertisingId2.isDoNotTrack()) {
                    if (ConsentStatus.EXPLICIT_NO.equals(PersonalInfoManager.this.f516.m579())) {
                        PersonalInfoManager.this.m524(ConsentStatus.EXPLICIT_NO, ConsentChangeReason.DNT_OFF);
                    } else {
                        PersonalInfoManager.this.m524(ConsentStatus.UNKNOWN, ConsentChangeReason.DNT_OFF);
                    }
                } else if (TextUtils.isEmpty(advertisingId2.f466) || advertisingId2.m485().equals(PersonalInfoManager.this.f516.m575()) || !ConsentStatus.EXPLICIT_YES.equals(PersonalInfoManager.this.f516.m559())) {
                } else {
                    PersonalInfoManager.this.f516.m556((ConsentStatus) null);
                    PersonalInfoManager.this.f516.m580(null);
                    PersonalInfoManager.this.m524(ConsentStatus.UNKNOWN, ConsentChangeReason.IFA_CHANGED);
                }
            }
        };
        this.f521 = sdkInitializationListener;
        MoPubIdentifier moPubIdentifier = ClientMetadata.getInstance(this.f514).getMoPubIdentifier();
        moPubIdentifier.setIdChangeListener(advertisingIdChangeListener);
        moPubIdentifier.m517(m531());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m524(@NonNull ConsentStatus consentStatus, @NonNull ConsentChangeReason consentChangeReason) {
        m544(consentStatus, consentChangeReason.getReason());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m525(@NonNull final ConsentStatus consentStatus, @NonNull final ConsentStatus consentStatus2, final boolean z) {
        synchronized (this.f515) {
            for (final ConsentStatusChangeListener consentStatusChangeListener : this.f515) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mopub.common.privacy.PersonalInfoManager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        consentStatusChangeListener.onConsentStateChange(consentStatus, consentStatus2, z);
                    }
                });
            }
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static boolean m529(boolean z, @Nullable Boolean bool, boolean z2, @Nullable Long l, long j, @Nullable String str, boolean z3) {
        if (z) {
            return false;
        }
        if (bool == null) {
            return true;
        }
        if (bool.booleanValue()) {
            if (z2) {
                return true;
            }
            if (z3 && TextUtils.isEmpty(str)) {
                return false;
            }
            return l == null || SystemClock.uptimeMillis() - l.longValue() > j;
        }
        return false;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private SdkInitializationListener m531() {
        return new SdkInitializationListener() { // from class: com.mopub.common.privacy.PersonalInfoManager.5
            @Override // com.mopub.common.SdkInitializationListener
            public void onInitializationFinished() {
                MoPubLog.d("MoPubIdentifier initialized.");
                if (PersonalInfoManager.m529(PersonalInfoManager.this.f511, PersonalInfoManager.this.gdprApplies(), false, PersonalInfoManager.this.f523, PersonalInfoManager.this.f522, PersonalInfoManager.this.f516.m575(), ClientMetadata.getInstance(PersonalInfoManager.this.f514).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack())) {
                    PersonalInfoManager.this.m542();
                } else if (PersonalInfoManager.this.f521 != null) {
                    PersonalInfoManager.this.f521.onInitializationFinished();
                    PersonalInfoManager.this.f521 = null;
                }
                new MoPubConversionTracker(PersonalInfoManager.this.f514).reportAppOpen(true);
            }
        };
    }

    public boolean canCollectPersonalInformation() {
        Boolean gdprApplies = gdprApplies();
        if (gdprApplies == null) {
            return false;
        }
        if (gdprApplies.booleanValue()) {
            return getPersonalInfoConsentStatus().equals(ConsentStatus.EXPLICIT_YES) && !ClientMetadata.getInstance(this.f514).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack();
        }
        return true;
    }

    public void forceGdprApplies() {
        if (this.f516.isForceGdprApplies()) {
            return;
        }
        boolean canCollectPersonalInformation = canCollectPersonalInformation();
        this.f516.m562(true);
        this.f512 = true;
        this.f516.m550();
        boolean canCollectPersonalInformation2 = canCollectPersonalInformation();
        if (canCollectPersonalInformation != canCollectPersonalInformation2) {
            m525(this.f516.m559(), this.f516.m559(), canCollectPersonalInformation2);
        }
        requestSync(true);
    }

    @Nullable
    public Boolean gdprApplies() {
        if (this.f516.isForceGdprApplies()) {
            return true;
        }
        return this.f516.m573();
    }

    public ConsentData getConsentData() {
        return new C0182(this.f514, this.f516.m555());
    }

    @NonNull
    public ConsentStatus getPersonalInfoConsentStatus() {
        return this.f516.m559();
    }

    public void grantConsent() {
        ConsentStatus consentStatus;
        ConsentChangeReason consentChangeReason;
        if (ClientMetadata.getInstance(this.f514).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack()) {
            MoPubLog.e("Cannot grant consent because Do Not Track is on.");
            return;
        }
        if (this.f516.m566()) {
            consentStatus = ConsentStatus.EXPLICIT_YES;
            consentChangeReason = ConsentChangeReason.GRANTED_BY_WHITELISTED_PUB;
        } else {
            MoPubLog.w("You do not have approval to use the grantConsent API. Please reach out to your account teams or support@mopub.com for more information.");
            consentStatus = ConsentStatus.POTENTIAL_WHITELIST;
            consentChangeReason = ConsentChangeReason.GRANTED_BY_NOT_WHITELISTED_PUB;
        }
        m524(consentStatus, consentChangeReason);
        requestSync(true);
    }

    public boolean isConsentDialogReady() {
        return this.f517.m495();
    }

    public void loadConsentDialog(@Nullable final ConsentDialogListener consentDialogListener) {
        ManifestUtils.checkGdprActivitiesDeclared(this.f514);
        if (ClientMetadata.getInstance(this.f514).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack()) {
            if (consentDialogListener != null) {
                new Handler().post(new Runnable() { // from class: com.mopub.common.privacy.PersonalInfoManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        consentDialogListener.onConsentDialogLoadFailed(MoPubErrorCode.DO_NOT_TRACK);
                    }
                });
                return;
            }
            return;
        }
        Boolean gdprApplies = gdprApplies();
        if (gdprApplies == null || gdprApplies.booleanValue()) {
            this.f517.m493(consentDialogListener, gdprApplies, this.f516);
        } else if (consentDialogListener != null) {
            new Handler().post(new Runnable() { // from class: com.mopub.common.privacy.PersonalInfoManager.3
                @Override // java.lang.Runnable
                public void run() {
                    consentDialogListener.onConsentDialogLoadFailed(MoPubErrorCode.GDPR_DOES_NOT_APPLY);
                }
            });
        }
    }

    public void requestSync(boolean z) {
        if (MoPub.isSdkInitialized()) {
            if (m529(this.f511, gdprApplies(), z, this.f523, this.f522, this.f516.m575(), ClientMetadata.getInstance(this.f514).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack())) {
                m542();
            }
        }
    }

    public void revokeConsent() {
        if (ClientMetadata.getInstance(this.f514).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack()) {
            MoPubLog.e("Cannot revoke consent because Do Not Track is on.");
            return;
        }
        m524(ConsentStatus.EXPLICIT_NO, ConsentChangeReason.DENIED_BY_PUB);
        requestSync(true);
    }

    public boolean shouldShowConsentDialog() {
        if (gdprApplies() == null || !gdprApplies().booleanValue() || ClientMetadata.getInstance(this.f514).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack()) {
            return false;
        }
        if (this.f516.m572() && this.f516.m559().equals(ConsentStatus.EXPLICIT_YES)) {
            return true;
        }
        return this.f516.m559().equals(ConsentStatus.UNKNOWN);
    }

    public boolean showConsentDialog() {
        return this.f517.m494();
    }

    public void subscribeConsentStatusChangeListener(@Nullable ConsentStatusChangeListener consentStatusChangeListener) {
        if (consentStatusChangeListener == null) {
            return;
        }
        this.f515.add(consentStatusChangeListener);
    }

    public void unsubscribeConsentStatusChangeListener(@Nullable ConsentStatusChangeListener consentStatusChangeListener) {
        this.f515.remove(consentStatusChangeListener);
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m542() {
        this.f524 = this.f516.m559();
        this.f525 = Calendar.getInstance().getTimeInMillis();
        this.f511 = true;
        this.f523 = Long.valueOf(SystemClock.uptimeMillis());
        SyncUrlGenerator syncUrlGenerator = new SyncUrlGenerator(this.f514, this.f524.getValue());
        syncUrlGenerator.withAdUnitId(this.f516.m555()).withUdid(this.f516.m575()).withLastChangedMs(this.f516.m577()).withLastConsentStatus(this.f516.m563()).withConsentChangeReason(this.f516.m569()).withConsentedVendorListVersion(this.f516.getConsentedVendorListVersion()).withConsentedPrivacyPolicyVersion(this.f516.getConsentedPrivacyPolicyVersion()).withCachedVendorListIabHash(this.f516.m567()).withExtras(this.f516.getExtras()).withGdprApplies(gdprApplies()).withForceGdprApplies(this.f516.isForceGdprApplies());
        if (this.f512) {
            this.f513 = true;
            syncUrlGenerator.withForceGdprAppliesChanged(true);
        }
        Networking.getRequestQueue(this.f514).add(new SyncRequest(this.f514, syncUrlGenerator.generateUrlString(Constants.HOST), this.f519));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m543(@NonNull ConsentStatus consentStatus) {
        ConsentChangeReason consentChangeReason;
        Preconditions.checkNotNull(consentStatus);
        switch (consentStatus) {
            case EXPLICIT_YES:
                consentChangeReason = ConsentChangeReason.GRANTED_BY_USER;
                break;
            case EXPLICIT_NO:
                consentChangeReason = ConsentChangeReason.DENIED_BY_USER;
                break;
            default:
                MoPubLog.d("Invalid consent status: " + consentStatus + ". This is a bug with the use of changeConsentStateFromDialog.");
                return;
        }
        m524(consentStatus, consentChangeReason);
        requestSync(true);
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m544(@NonNull ConsentStatus consentStatus, @NonNull String str) {
        Preconditions.checkNotNull(consentStatus);
        Preconditions.checkNotNull(str);
        ConsentStatus m559 = this.f516.m559();
        if (m559.equals(consentStatus)) {
            MoPubLog.d("Consent status is already " + m559 + ". Not doing a state transition.");
            return;
        }
        MoPubLog.d("Changing consent status from " + m559 + "to " + consentStatus + " because " + str);
        this.f516.m576(str);
        this.f516.m551(consentStatus);
        if (ConsentStatus.POTENTIAL_WHITELIST.equals(consentStatus) || (!ConsentStatus.POTENTIAL_WHITELIST.equals(m559) && ConsentStatus.EXPLICIT_YES.equals(consentStatus))) {
            this.f516.m571(this.f516.getCurrentPrivacyPolicyVersion());
            this.f516.m570(this.f516.getCurrentVendorListVersion());
            this.f516.m574(this.f516.getCurrentVendorListIabFormat());
        }
        if (ConsentStatus.DNT.equals(consentStatus) || ConsentStatus.EXPLICIT_NO.equals(consentStatus) || ConsentStatus.UNKNOWN.equals(consentStatus)) {
            this.f516.m571(null);
            this.f516.m570(null);
            this.f516.m574(null);
        }
        if (ConsentStatus.EXPLICIT_YES.equals(consentStatus)) {
            this.f516.m578(ClientMetadata.getInstance(this.f514).getMoPubIdentifier().getAdvertisingInfo().m485());
        }
        if (ConsentStatus.DNT.equals(consentStatus)) {
            this.f516.m560(m559);
        }
        this.f516.m558(false);
        this.f516.m550();
        boolean canCollectPersonalInformation = canCollectPersonalInformation();
        if (canCollectPersonalInformation) {
            ClientMetadata.getInstance(this.f514).repopulateCountryData();
            if (this.f518.shouldTrack()) {
                this.f518.reportAppOpen(false);
            }
        }
        m525(m559, consentStatus, canCollectPersonalInformation);
    }
}
