package com.mopub.mobileads;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdTypeTranslator;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public abstract class MoPubRewardedAd extends CustomEventRewardedAd {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected String f895;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean f896;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f897;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f898;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.MoPubRewardedAd$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        static final /* synthetic */ int[] f899 = new int[MoPubErrorCode.values().length];

        static {
            try {
                f899[MoPubErrorCode.VIDEO_PLAYBACK_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    protected class MoPubRewardedAdListener implements CustomEventInterstitial.CustomEventInterstitialListener {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        final Class<? extends MoPubRewardedAd> f900;
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final Runnable f902;
        @NonNull

        /* renamed from: ࢤ  reason: contains not printable characters */
        private Handler f903;

        public MoPubRewardedAdListener(Class<? extends MoPubRewardedAd> cls) {
            Preconditions.checkNotNull(cls);
            this.f900 = cls;
            this.f903 = new Handler();
            this.f902 = new Runnable() { // from class: com.mopub.mobileads.MoPubRewardedAd.MoPubRewardedAdListener.1
                @Override // java.lang.Runnable
                public void run() {
                    MoPubLog.d("Expiring unused Rewarded ad.");
                    MoPubRewardedAdListener.this.onInterstitialFailed(MoPubErrorCode.EXPIRED);
                }
            };
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialClicked() {
            MoPubRewardedVideoManager.onRewardedVideoClicked(this.f900, MoPubRewardedAd.this.getAdNetworkId());
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialDismissed() {
            MoPubRewardedVideoManager.onRewardedVideoClosed(this.f900, MoPubRewardedAd.this.getAdNetworkId());
            MoPubRewardedAd.this.mo654();
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
            this.f903.removeCallbacks(this.f902);
            if (AnonymousClass1.f899[moPubErrorCode.ordinal()] != 1) {
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(this.f900, MoPubRewardedAd.this.getAdNetworkId(), moPubErrorCode);
            } else {
                MoPubRewardedVideoManager.onRewardedVideoPlaybackError(this.f900, MoPubRewardedAd.this.getAdNetworkId(), moPubErrorCode);
            }
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialImpression() {
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialLoaded() {
            MoPubRewardedAd.this.f896 = true;
            if (AdTypeTranslator.CustomEventType.isMoPubSpecific(this.f900.getName())) {
                this.f903.postDelayed(this.f902, 14400000L);
            }
            MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(this.f900, MoPubRewardedAd.this.getAdNetworkId());
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialShown() {
            this.f903.removeCallbacks(this.f902);
            MoPubRewardedVideoManager.onRewardedVideoStarted(this.f900, MoPubRewardedAd.this.getAdNetworkId());
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onLeaveApplication() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    public boolean checkAndInitializeSdk(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        return false;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @Nullable
    protected LifecycleListener getLifecycleListener() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    public void mo654() {
        this.f896 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo655(@android.support.annotation.NonNull android.app.Activity r3, @android.support.annotation.NonNull java.util.Map<java.lang.String, java.lang.Object> r4, @android.support.annotation.NonNull java.util.Map<java.lang.String, java.lang.String> r5) throws java.lang.Exception {
        /*
            r2 = this;
            java.lang.String r0 = "activity cannot be null"
            com.mopub.common.Preconditions.checkNotNull(r3, r0)
            java.lang.String r3 = "localExtras cannot be null"
            com.mopub.common.Preconditions.checkNotNull(r4, r3)
            java.lang.String r3 = "serverExtras cannot be null"
            com.mopub.common.Preconditions.checkNotNull(r5, r3)
            java.lang.String r3 = "rewarded-ad-currency-name"
            java.lang.Object r3 = r4.get(r3)
            boolean r5 = r3 instanceof java.lang.String
            if (r5 == 0) goto L1e
            java.lang.String r3 = (java.lang.String) r3
        L1b:
            r2.f897 = r3
            goto L26
        L1e:
            java.lang.String r3 = "No currency name specified for rewarded video. Using the default name."
            com.mopub.common.logging.MoPubLog.d(r3)
            java.lang.String r3 = ""
            goto L1b
        L26:
            java.lang.String r3 = "rewarded-ad-currency-value-string"
            java.lang.Object r3 = r4.get(r3)
            boolean r5 = r3 instanceof java.lang.String
            r0 = 0
            if (r5 == 0) goto L55
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.NumberFormatException -> L3b
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L3b
            r2.f898 = r5     // Catch: java.lang.NumberFormatException -> L3b
            goto L5c
        L3b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "Unable to convert currency amount: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r3 = ". Using the default reward amount: "
            r5.append(r3)
            r5.append(r0)
            java.lang.String r3 = r5.toString()
            goto L57
        L55:
            java.lang.String r3 = "No currency amount specified for rewarded ad. Using the default reward amount: 0"
        L57:
            com.mopub.common.logging.MoPubLog.d(r3)
            r2.f898 = r0
        L5c:
            int r3 = r2.f898
            if (r3 >= 0) goto L67
            java.lang.String r3 = "Negative currency amount specified for rewarded ad. Using the default reward amount: 0"
            com.mopub.common.logging.MoPubLog.d(r3)
            r2.f898 = r0
        L67:
            java.lang.String r3 = "com_mopub_ad_unit_id"
            java.lang.Object r3 = r4.get(r3)
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L76
            java.lang.String r3 = (java.lang.String) r3
            r2.f895 = r3
            goto L7b
        L76:
            java.lang.String r3 = "Unable to set ad unit for rewarded ad."
            com.mopub.common.logging.MoPubLog.d(r3)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.MoPubRewardedAd.mo655(android.app.Activity, java.util.Map, java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public String m798() {
        return this.f897;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢣ */
    public boolean mo756() {
        return this.f896;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public int m799() {
        return this.f898;
    }
}
