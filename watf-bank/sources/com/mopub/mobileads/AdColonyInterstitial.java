package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.MoPub;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.common.util.Json;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Arrays;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class AdColonyInterstitial extends CustomEventInterstitial {
    public static final String ALL_ZONE_IDS_KEY = "allZoneIds";
    public static final String APP_ID_KEY = "appId";
    public static final String CLIENT_OPTIONS_KEY = "clientOptions";
    public static final String ZONE_ID_KEY = "zoneId";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final String[] f690 = {"ZONE_ID_1", "ZONE_ID_2", "..."};

    /* renamed from: ࢦ  reason: contains not printable characters */
    private static String[] f691;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private CustomEventInterstitial.CustomEventInterstitialListener f692;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private com.adcolony.sdk.ࢩ f693;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Handler f694 = new Handler();

    /* renamed from: ࢥ  reason: contains not printable characters */
    private com.adcolony.sdk.ࢨ f695;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m631(Map<String, String> map) {
        return map != null && map.containsKey("clientOptions") && map.containsKey("appId") && map.containsKey("allZoneIds") && map.containsKey("zoneId");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m632(String[] strArr, String[] strArr2) {
        if (strArr == null) {
            return true;
        }
        if (strArr2 == null) {
            return false;
        }
        if (strArr.length != strArr2.length) {
            return true;
        }
        Arrays.sort(strArr);
        Arrays.sort(strArr2);
        return !Arrays.equals(strArr, strArr2);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean m634() {
        return !com.adcolony.sdk.ࢠ.ࢢ().isEmpty();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String[] m635(Map<String, String> map) {
        String[] jsonArrayToStringArray = Json.jsonArrayToStringArray(map.get("allZoneIds"));
        return jsonArrayToStringArray.length == 0 ? new String[]{""} : jsonArrayToStringArray;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private com.adcolony.sdk.ࢩ m636() {
        return this.f693 != null ? this.f693 : new com.adcolony.sdk.ࢩ() { // from class: com.mopub.mobileads.AdColonyInterstitial.2
            public void onClicked(@NonNull com.adcolony.sdk.ࢨ r1) {
                AdColonyInterstitial.this.f692.onInterstitialClicked();
            }

            public void onClosed(@NonNull com.adcolony.sdk.ࢨ r2) {
                AdColonyInterstitial.this.f694.post(new Runnable() { // from class: com.mopub.mobileads.AdColonyInterstitial.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdColonyInterstitial.this.f692.onInterstitialDismissed();
                    }
                });
            }

            public void onExpiring(@NonNull com.adcolony.sdk.ࢨ r2) {
                com.adcolony.sdk.ࢠ.ࢠ(r2.ࢣ(), AdColonyInterstitial.this.f693);
            }

            public void onOpened(@NonNull com.adcolony.sdk.ࢨ r2) {
                AdColonyInterstitial.this.f694.post(new Runnable() { // from class: com.mopub.mobileads.AdColonyInterstitial.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AdColonyInterstitial.this.f692.onInterstitialShown();
                    }
                });
            }

            public void onRequestFilled(@NonNull com.adcolony.sdk.ࢨ r2) {
                AdColonyInterstitial.this.f695 = r2;
                AdColonyInterstitial.this.f694.post(new Runnable() { // from class: com.mopub.mobileads.AdColonyInterstitial.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdColonyInterstitial.this.f692.onInterstitialLoaded();
                    }
                });
            }

            public void onRequestNotFilled(@NonNull com.adcolony.sdk.ؠ r2) {
                AdColonyInterstitial.this.f694.post(new Runnable() { // from class: com.mopub.mobileads.AdColonyInterstitial.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdColonyInterstitial.this.f692.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void loadInterstitial(@NonNull Context context, @NonNull CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, @Nullable Map<String, Object> map, @NonNull Map<String, String> map2) {
        if (!(context instanceof Activity)) {
            customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        String str = "version=YOUR_APP_VERSION_HERE,store:google";
        String str2 = "YOUR_AD_COLONY_APP_ID_HERE";
        String[] strArr = f690;
        String str3 = "YOUR_CURRENT_ZONE_ID";
        this.f692 = customEventInterstitialListener;
        if (m631(map2)) {
            str = map2.get("clientOptions");
            str2 = map2.get("appId");
            strArr = m635(map2);
            str3 = map2.get("zoneId");
        }
        com.adcolony.sdk.ࢤ r6 = com.adcolony.sdk.ࢤ.ࢤ(str);
        PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
        if (r6 == null) {
            r6 = new com.adcolony.sdk.ࢤ();
        }
        if (personalInformationManager != null && personalInformationManager.gdprApplies() != null && personalInformationManager.gdprApplies().booleanValue()) {
            r6.ࢠ("explicit_consent_given", true).ࢠ("consent_response", MoPub.canCollectPersonalInformation());
        }
        this.f693 = m636();
        if (!m634()) {
            com.adcolony.sdk.ࢠ.ࢠ((Activity) context, r6, str2, strArr);
        } else if (m632(f691, strArr)) {
            com.adcolony.sdk.ࢠ.ࢠ((Activity) context, r6, str2, strArr);
            f691 = strArr;
        } else {
            com.adcolony.sdk.ࢠ.ࢠ(r6);
        }
        com.adcolony.sdk.ࢠ.ࢠ(str3, this.f693);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        if (this.f695 != null) {
            this.f693 = null;
            this.f695.ࢠ((com.adcolony.sdk.ࢩ) null);
            this.f695.ࢥ();
            this.f695 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        if (this.f695 == null || this.f695.ࢤ()) {
            this.f694.post(new Runnable() { // from class: com.mopub.mobileads.AdColonyInterstitial.1
                @Override // java.lang.Runnable
                public void run() {
                    AdColonyInterstitial.this.f692.onInterstitialFailed(MoPubErrorCode.VIDEO_PLAYBACK_ERROR);
                }
            });
        } else {
            this.f695.ࢠ();
        }
    }
}
