package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdTypeTranslator;
import com.mopub.mobileads.CustomEventInterstitialAdapter;
import com.mopub.mobileads.factories.CustomEventInterstitialAdapterFactory;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class MoPubInterstitial implements CustomEventInterstitialAdapter.InterfaceC0197 {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private MoPubInterstitialView f884;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private CustomEventInterstitialAdapter f885;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private InterstitialAdListener f886;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Activity f887;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Handler f888;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final Runnable f889;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private volatile EnumC0205 f890;

    /* loaded from: assets/classes2.dex */
    public interface InterstitialAdListener {
        void onInterstitialClicked(MoPubInterstitial moPubInterstitial);

        void onInterstitialDismissed(MoPubInterstitial moPubInterstitial);

        void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode);

        void onInterstitialLoaded(MoPubInterstitial moPubInterstitial);

        void onInterstitialShown(MoPubInterstitial moPubInterstitial);
    }

    /* loaded from: assets/classes2.dex */
    public class MoPubInterstitialView extends MoPubView {
        public MoPubInterstitialView(Context context) {
            super(context);
            setAutorefreshEnabled(false);
        }

        @Override // com.mopub.mobileads.MoPubView
        public AdFormat getAdFormat() {
            return AdFormat.INTERSTITIAL;
        }

        @Nullable
        String getCustomEventClassName() {
            return this.f942.getCustomEventClassName();
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        protected void m794() {
            MoPubLog.d("Tracking impression for interstitial.");
            if (this.f942 != null) {
                this.f942.m687();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.mopub.mobileads.MoPubView
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void mo795(MoPubErrorCode moPubErrorCode) {
            MoPubInterstitial.this.m783(EnumC0205.IDLE);
            if (MoPubInterstitial.this.f886 != null) {
                MoPubInterstitial.this.f886.onInterstitialFailed(MoPubInterstitial.this, moPubErrorCode);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.mopub.mobileads.MoPubView
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void mo796(String str, Map<String, String> map) {
            if (this.f942 == null) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                MoPubLog.d("Couldn't invoke custom event because the server did not specify one.");
                m836(MoPubErrorCode.ADAPTER_NOT_FOUND);
                return;
            }
            if (MoPubInterstitial.this.f885 != null) {
                MoPubInterstitial.this.f885.m752();
            }
            MoPubLog.d("Loading custom event interstitial adapter.");
            MoPubInterstitial.this.f885 = CustomEventInterstitialAdapterFactory.create(MoPubInterstitial.this, str, map, this.f942.getBroadcastIdentifier(), this.f942.getAdReport());
            MoPubInterstitial.this.f885.m750(MoPubInterstitial.this);
            MoPubInterstitial.this.f885.m749();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.mopub.mobileads.MoPubInterstitial$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0205 {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MoPubInterstitial(@NonNull Activity activity, @NonNull String str) {
        this.f887 = activity;
        this.f884 = new MoPubInterstitialView(this.f887);
        this.f884.setAdUnitId(str);
        this.f890 = EnumC0205.IDLE;
        this.f888 = new Handler();
        this.f889 = new Runnable() { // from class: com.mopub.mobileads.MoPubInterstitial.1
            @Override // java.lang.Runnable
            public void run() {
                MoPubLog.d("Expiring unused Interstitial ad.");
                MoPubInterstitial.this.m793(EnumC0205.IDLE, true);
                if (EnumC0205.SHOWING.equals(MoPubInterstitial.this.f890) || EnumC0205.DESTROYED.equals(MoPubInterstitial.this.f890)) {
                    return;
                }
                MoPubInterstitial.this.f884.mo795(MoPubErrorCode.EXPIRED);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m783(@NonNull EnumC0205 enumC0205) {
        return m793(enumC0205, false);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m786() {
        m790();
        this.f886 = null;
        this.f884.setBannerAdListener(null);
        this.f884.destroy();
        this.f888.removeCallbacks(this.f889);
        this.f890 = EnumC0205.DESTROYED;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m788() {
        if (this.f885 != null) {
            this.f885.m751();
        }
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m790() {
        if (this.f885 != null) {
            this.f885.m752();
            this.f885 = null;
        }
    }

    public void destroy() {
        m783(EnumC0205.DESTROYED);
    }

    public void forceRefresh() {
        m793(EnumC0205.IDLE, true);
        m793(EnumC0205.LOADING, true);
    }

    @NonNull
    public Activity getActivity() {
        return this.f887;
    }

    @Nullable
    public InterstitialAdListener getInterstitialAdListener() {
        return this.f886;
    }

    @Nullable
    public String getKeywords() {
        return this.f884.getKeywords();
    }

    @NonNull
    public Map<String, Object> getLocalExtras() {
        return this.f884.getLocalExtras();
    }

    @Nullable
    public Location getLocation() {
        return this.f884.getLocation();
    }

    public boolean getTesting() {
        return this.f884.getTesting();
    }

    @Nullable
    public String getUserDataKeywords() {
        return this.f884.getUserDataKeywords();
    }

    public boolean isReady() {
        return this.f890 == EnumC0205.READY;
    }

    public void load() {
        m783(EnumC0205.LOADING);
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC0197
    public void onCustomEventInterstitialClicked() {
        if (m792()) {
            return;
        }
        this.f884.m835();
        if (this.f886 != null) {
            this.f886.onInterstitialClicked(this);
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC0197
    public void onCustomEventInterstitialDismissed() {
        if (m792()) {
            return;
        }
        m783(EnumC0205.IDLE);
        if (this.f886 != null) {
            this.f886.onInterstitialDismissed(this);
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC0197
    public void onCustomEventInterstitialFailed(@NonNull MoPubErrorCode moPubErrorCode) {
        if (m792() || this.f884.m836(moPubErrorCode)) {
            return;
        }
        m783(EnumC0205.IDLE);
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC0197
    public void onCustomEventInterstitialImpression() {
        if (m792() || this.f885 == null || this.f885.m754()) {
            return;
        }
        this.f884.m794();
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC0197
    public void onCustomEventInterstitialLoaded() {
        if (m792()) {
            return;
        }
        m783(EnumC0205.READY);
        if (this.f884.f942 != null) {
            this.f884.f942.m679();
        }
        if (this.f886 != null) {
            this.f886.onInterstitialLoaded(this);
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitialAdapter.InterfaceC0197
    public void onCustomEventInterstitialShown() {
        if (m792()) {
            return;
        }
        if (this.f885 == null || this.f885.m754()) {
            this.f884.m794();
        }
        if (this.f886 != null) {
            this.f886.onInterstitialShown(this);
        }
    }

    public void setInterstitialAdListener(@Nullable InterstitialAdListener interstitialAdListener) {
        this.f886 = interstitialAdListener;
    }

    public void setKeywords(@Nullable String str) {
        this.f884.setKeywords(str);
    }

    public void setLocalExtras(Map<String, Object> map) {
        this.f884.setLocalExtras(map);
    }

    public void setTesting(boolean z) {
        this.f884.setTesting(z);
    }

    public void setUserDataKeywords(@Nullable String str) {
        this.f884.setUserDataKeywords(str);
    }

    public boolean show() {
        return m783(EnumC0205.SHOWING);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Integer m791(int i) {
        return this.f884.m834(i);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean m792() {
        return this.f890 == EnumC0205.DESTROYED;
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    synchronized boolean m793(@NonNull EnumC0205 enumC0205, boolean z) {
        Preconditions.checkNotNull(enumC0205);
        switch (this.f890) {
            case LOADING:
                switch (enumC0205) {
                    case LOADING:
                        if (!z) {
                            MoPubLog.d("Already loading an interstitial.");
                        }
                        return false;
                    case SHOWING:
                        MoPubLog.d("Interstitial is not ready to be shown yet.");
                        return false;
                    case DESTROYED:
                        m786();
                        return true;
                    case IDLE:
                        m790();
                        this.f890 = EnumC0205.IDLE;
                        return true;
                    case READY:
                        this.f890 = EnumC0205.READY;
                        if (AdTypeTranslator.CustomEventType.isMoPubSpecific(this.f884.getCustomEventClassName())) {
                            this.f888.postDelayed(this.f889, 14400000L);
                        }
                        return true;
                    default:
                        return false;
                }
            case SHOWING:
                switch (enumC0205) {
                    case LOADING:
                        if (!z) {
                            MoPubLog.d("Interstitial already showing. Not loading another.");
                        }
                        return false;
                    case SHOWING:
                        MoPubLog.d("Already showing an interstitial. Cannot show it again.");
                        return false;
                    case DESTROYED:
                        m786();
                        return true;
                    case IDLE:
                        if (z) {
                            MoPubLog.d("Cannot force refresh while showing an interstitial.");
                            return false;
                        }
                        m790();
                        this.f890 = EnumC0205.IDLE;
                        return true;
                    default:
                        return false;
                }
            case DESTROYED:
                MoPubLog.d("MoPubInterstitial destroyed. Ignoring all requests.");
                return false;
            case IDLE:
                switch (enumC0205) {
                    case LOADING:
                        m790();
                        this.f890 = EnumC0205.LOADING;
                        if (z) {
                            this.f884.forceRefresh();
                        } else {
                            this.f884.loadAd();
                        }
                        return true;
                    case SHOWING:
                        MoPubLog.d("No interstitial loading or loaded.");
                        return false;
                    case DESTROYED:
                        m786();
                        return true;
                    default:
                        return false;
                }
            case READY:
                switch (enumC0205) {
                    case LOADING:
                        MoPubLog.d("Interstitial already loaded. Not loading another.");
                        if (this.f886 != null) {
                            this.f886.onInterstitialLoaded(this);
                        }
                        return false;
                    case SHOWING:
                        m788();
                        this.f890 = EnumC0205.SHOWING;
                        this.f888.removeCallbacks(this.f889);
                        return true;
                    case DESTROYED:
                        m786();
                        return true;
                    case IDLE:
                        if (z) {
                            m790();
                            this.f890 = EnumC0205.IDLE;
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }
}
