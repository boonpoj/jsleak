package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.ads.FlurryAdErrorType;
import com.flurry.android.ads.FlurryAdInterstitial;
import com.flurry.android.ads.FlurryAdInterstitialListener;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: assets/classes2.dex */
public class FlurryCustomEventInterstitial extends CustomEventInterstitial {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final String f843 = "FlurryCustomEventInterstitial";

    /* renamed from: ࢢ  reason: contains not printable characters */
    private Context f844;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private CustomEventInterstitial.CustomEventInterstitialListener f845;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f846;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private FlurryAdInterstitial f847;

    /* renamed from: com.mopub.mobileads.FlurryCustomEventInterstitial$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        static final /* synthetic */ int[] f848 = new int[FlurryAdErrorType.values().length];

        static {
            try {
                f848[FlurryAdErrorType.FETCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f848[FlurryAdErrorType.RENDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f848[FlurryAdErrorType.CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.mopub.mobileads.FlurryCustomEventInterstitial$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private class C0199 implements FlurryAdInterstitialListener {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final String f850;

        private C0199() {
            this.f850 = getClass().getSimpleName();
        }

        /* synthetic */ C0199(FlurryCustomEventInterstitial flurryCustomEventInterstitial, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onAppExit(FlurryAdInterstitial flurryAdInterstitial) {
        }

        public void onClicked(FlurryAdInterstitial flurryAdInterstitial) {
            if (FlurryCustomEventInterstitial.this.f845 != null) {
                FlurryCustomEventInterstitial.this.f845.onInterstitialClicked();
            }
        }

        public void onClose(FlurryAdInterstitial flurryAdInterstitial) {
            if (FlurryCustomEventInterstitial.this.f845 != null) {
                FlurryCustomEventInterstitial.this.f845.onInterstitialDismissed();
            }
        }

        public void onDisplay(FlurryAdInterstitial flurryAdInterstitial) {
            if (FlurryCustomEventInterstitial.this.f845 != null) {
                FlurryCustomEventInterstitial.this.f845.onInterstitialImpression();
            }
        }

        public void onError(FlurryAdInterstitial flurryAdInterstitial, FlurryAdErrorType flurryAdErrorType, int i) {
            CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener;
            MoPubErrorCode moPubErrorCode;
            if (FlurryCustomEventInterstitial.this.f845 != null) {
                switch (AnonymousClass1.f848[flurryAdErrorType.ordinal()]) {
                    case 1:
                        customEventInterstitialListener = FlurryCustomEventInterstitial.this.f845;
                        moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                        break;
                    case 2:
                        customEventInterstitialListener = FlurryCustomEventInterstitial.this.f845;
                        moPubErrorCode = MoPubErrorCode.NETWORK_INVALID_STATE;
                        break;
                    case 3:
                        return;
                    default:
                        FlurryCustomEventInterstitial.this.f845.onInterstitialFailed(MoPubErrorCode.UNSPECIFIED);
                        return;
                }
                customEventInterstitialListener.onInterstitialFailed(moPubErrorCode);
            }
        }

        public void onFetched(FlurryAdInterstitial flurryAdInterstitial) {
            if (FlurryCustomEventInterstitial.this.f845 != null) {
                FlurryCustomEventInterstitial.this.f845.onInterstitialLoaded();
            }
        }

        public void onRendered(FlurryAdInterstitial flurryAdInterstitial) {
            if (FlurryCustomEventInterstitial.this.f845 != null) {
                FlurryCustomEventInterstitial.this.f845.onInterstitialShown();
            }
        }

        public void onVideoCompleted(FlurryAdInterstitial flurryAdInterstitial) {
        }
    }

    FlurryCustomEventInterstitial() {
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m760(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return (TextUtils.isEmpty(map.get(FlurryAgentWrapper.PARAM_API_KEY)) || TextUtils.isEmpty(map.get(FlurryAgentWrapper.PARAM_AD_SPACE_NAME))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        if (context != null) {
            if (customEventInterstitialListener == null) {
                return;
            }
            if ((context instanceof Activity) && m760(map2)) {
                m745(false);
                this.f844 = context;
                this.f845 = customEventInterstitialListener;
                this.f846 = map2.get(FlurryAgentWrapper.PARAM_AD_SPACE_NAME);
                FlurryAgentWrapper.getInstance().startSession(context, map2.get(FlurryAgentWrapper.PARAM_API_KEY), null);
                this.f847 = new FlurryAdInterstitial(this.f844, this.f846);
                this.f847.setListener(new C0199(this, null));
                this.f847.fetchAd();
                return;
            }
        }
        customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        if (this.f844 != null) {
            if (this.f847 != null) {
                this.f847.destroy();
                this.f847 = null;
            }
            FlurryAgentWrapper.getInstance().endSession(this.f844);
            this.f844 = null;
            this.f845 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        if (this.f847 != null) {
            this.f847.displayAd();
        }
    }
}
