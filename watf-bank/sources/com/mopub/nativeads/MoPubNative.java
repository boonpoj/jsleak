package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.ManifestUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.network.AdLoader;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: assets/classes2.dex */
public class MoPubNative {

    /* renamed from: ࢠ  reason: contains not printable characters */
    static final MoPubNativeNetworkListener f1681 = new MoPubNativeNetworkListener() { // from class: com.mopub.nativeads.MoPubNative.1
        @Override // com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener
        public void onNativeFail(NativeErrorCode nativeErrorCode) {
        }

        @Override // com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener
        public void onNativeLoad(@NonNull NativeAd nativeAd) {
            nativeAd.destroy();
        }
    };
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    AdRendererRegistry f1682;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final WeakReference<Context> f1683;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final String f1684;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private MoPubNativeNetworkListener f1685;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private Map<String, Object> f1686;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private AdLoader f1687;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private C0277 f1688;
    @NonNull

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final AdLoader.Listener f1689;
    @Nullable

    /* renamed from: ࢪ  reason: contains not printable characters */
    private Request f1690;

    /* loaded from: assets/classes2.dex */
    public interface MoPubNativeNetworkListener {
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(NativeAd nativeAd);
    }

    @VisibleForTesting
    public MoPubNative(@NonNull Context context, @NonNull String str, @NonNull AdRendererRegistry adRendererRegistry, @NonNull MoPubNativeNetworkListener moPubNativeNetworkListener) {
        this.f1686 = new TreeMap();
        Preconditions.checkNotNull(context, "context may not be null.");
        Preconditions.checkNotNull(str, "AdUnitId may not be null.");
        Preconditions.checkNotNull(adRendererRegistry, "AdRendererRegistry may not be null.");
        Preconditions.checkNotNull(moPubNativeNetworkListener, "MoPubNativeNetworkListener may not be null.");
        ManifestUtils.checkNativeActivitiesDeclared(context);
        this.f1683 = new WeakReference<>(context);
        this.f1684 = str;
        this.f1685 = moPubNativeNetworkListener;
        this.f1682 = adRendererRegistry;
        this.f1689 = new AdLoader.Listener() { // from class: com.mopub.nativeads.MoPubNative.2
            @Override // com.mopub.volley.Response.ErrorListener
            public void onErrorResponse(@NonNull VolleyError volleyError) {
                MoPubNative.this.m1403(volleyError);
            }

            @Override // com.mopub.network.AdLoader.Listener
            public void onSuccess(@NonNull AdResponse adResponse) {
                MoPubNative.this.m1398(adResponse);
            }
        };
    }

    public MoPubNative(@NonNull Context context, @NonNull String str, @NonNull MoPubNativeNetworkListener moPubNativeNetworkListener) {
        this(context, str, new AdRendererRegistry(), moPubNativeNetworkListener);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1397(@Nullable RequestParameters requestParameters, @Nullable Integer num) {
        Context m1402 = m1402();
        if (m1402 == null) {
            return;
        }
        C0283 m1520 = new C0283(m1402).withAdUnitId(this.f1684).m1520(requestParameters);
        if (num != null) {
            m1520.m1519(num.intValue());
        }
        String generateUrlString = m1520.generateUrlString(Constants.HOST);
        if (generateUrlString != null) {
            MoPubLog.d("MoPubNative Loading ad from: " + generateUrlString);
        }
        m1404(generateUrlString, (NativeErrorCode) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1398(@NonNull final AdResponse adResponse) {
        Context m1402 = m1402();
        if (m1402 == null) {
            return;
        }
        CustomEventNative.CustomEventNativeListener customEventNativeListener = new CustomEventNative.CustomEventNativeListener() { // from class: com.mopub.nativeads.MoPubNative.3
            @Override // com.mopub.nativeads.CustomEventNative.CustomEventNativeListener
            public void onNativeAdFailed(NativeErrorCode nativeErrorCode) {
                MoPubLog.v(String.format("Native Ad failed to load with error: %s.", nativeErrorCode));
                MoPubNative.this.f1688 = null;
                MoPubNative.this.m1404("", nativeErrorCode);
            }

            @Override // com.mopub.nativeads.CustomEventNative.CustomEventNativeListener
            public void onNativeAdLoaded(@NonNull BaseNativeAd baseNativeAd) {
                MoPubLog.w("MoPubNative.onNativeAdLoaded " + MoPubNative.this.f1688);
                MoPubNative.this.f1688 = null;
                Context m14022 = MoPubNative.this.m1402();
                if (m14022 == null) {
                    return;
                }
                MoPubAdRenderer rendererForAd = MoPubNative.this.f1682.getRendererForAd(baseNativeAd);
                if (rendererForAd == null) {
                    onNativeAdFailed(NativeErrorCode.NATIVE_RENDERER_CONFIGURATION_ERROR);
                    return;
                }
                if (MoPubNative.this.f1687 != null) {
                    MoPubNative.this.f1687.creativeDownloadSuccess();
                }
                MoPubNative.this.f1685.onNativeLoad(new NativeAd(m14022, adResponse.getImpressionTrackingUrls(), adResponse.getClickTrackingUrl(), MoPubNative.this.f1684, baseNativeAd, rendererForAd));
            }
        };
        if (this.f1688 != null) {
            MoPubLog.w("Native adapter is not null.");
            this.f1688.m1496();
        }
        this.f1688 = new C0277(customEventNativeListener);
        this.f1688.loadNativeAd(m1402, this.f1686, adResponse);
    }

    public void destroy() {
        this.f1683.clear();
        if (this.f1690 != null) {
            this.f1690.cancel();
            this.f1690 = null;
        }
        this.f1687 = null;
        this.f1685 = f1681;
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void makeRequest(@Nullable RequestParameters requestParameters) {
        makeRequest(requestParameters, null);
    }

    public void makeRequest(@Nullable RequestParameters requestParameters, @Nullable Integer num) {
        Context m1402 = m1402();
        if (m1402 == null) {
            return;
        }
        if (DeviceUtils.isNetworkAvailable(m1402)) {
            m1397(requestParameters, num);
        } else {
            this.f1685.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
        }
    }

    public void registerAdRenderer(MoPubAdRenderer moPubAdRenderer) {
        this.f1682.registerAdRenderer(moPubAdRenderer);
    }

    public void setLocalExtras(@Nullable Map<String, Object> map) {
        if (map == null) {
            this.f1686 = new TreeMap();
        } else {
            this.f1686 = new TreeMap(map);
        }
    }

    @Nullable
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    Context m1402() {
        Context context = this.f1683.get();
        if (context == null) {
            destroy();
            MoPubLog.d("Weak reference to Context in MoPubNative became null. This instance of MoPubNative is destroyed and No more requests will be processed.");
        }
        return context;
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1403(@NonNull VolleyError volleyError) {
        MoPubNativeNetworkListener moPubNativeNetworkListener;
        NativeErrorCode nativeErrorCode;
        MoPubNativeNetworkListener moPubNativeNetworkListener2;
        NativeErrorCode nativeErrorCode2;
        MoPubLog.d("Native ad request failed.", volleyError);
        if (volleyError instanceof MoPubNetworkError) {
            switch (((MoPubNetworkError) volleyError).getReason()) {
                case BAD_BODY:
                case BAD_HEADER_DATA:
                    moPubNativeNetworkListener2 = this.f1685;
                    nativeErrorCode2 = NativeErrorCode.INVALID_RESPONSE;
                    break;
                case WARMING_UP:
                    MoPubLog.c(MoPubErrorCode.WARMUP.toString());
                case NO_FILL:
                    moPubNativeNetworkListener2 = this.f1685;
                    nativeErrorCode2 = NativeErrorCode.EMPTY_AD_RESPONSE;
                    break;
                default:
                    moPubNativeNetworkListener2 = this.f1685;
                    nativeErrorCode2 = NativeErrorCode.UNSPECIFIED;
                    break;
            }
            moPubNativeNetworkListener2.onNativeFail(nativeErrorCode2);
            return;
        }
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (networkResponse != null && networkResponse.statusCode >= 500 && networkResponse.statusCode < 600) {
            moPubNativeNetworkListener = this.f1685;
            nativeErrorCode = NativeErrorCode.SERVER_ERROR_RESPONSE_CODE;
        } else if (networkResponse != null || DeviceUtils.isNetworkAvailable(this.f1683.get())) {
            moPubNativeNetworkListener = this.f1685;
            nativeErrorCode = NativeErrorCode.UNSPECIFIED;
        } else {
            MoPubLog.c(String.valueOf(MoPubErrorCode.NO_CONNECTION.toString()));
            moPubNativeNetworkListener = this.f1685;
            nativeErrorCode = NativeErrorCode.CONNECTION_ERROR;
        }
        moPubNativeNetworkListener.onNativeFail(nativeErrorCode);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1404(@Nullable String str, @Nullable NativeErrorCode nativeErrorCode) {
        Context m1402 = m1402();
        if (m1402 == null) {
            return;
        }
        if (this.f1687 == null || !this.f1687.hasMoreAds()) {
            if (TextUtils.isEmpty(str)) {
                MoPubNativeNetworkListener moPubNativeNetworkListener = this.f1685;
                if (nativeErrorCode == null) {
                    nativeErrorCode = NativeErrorCode.INVALID_REQUEST_URL;
                }
                moPubNativeNetworkListener.onNativeFail(nativeErrorCode);
                return;
            }
            this.f1687 = new AdLoader(str, AdFormat.NATIVE, this.f1684, m1402, this.f1689);
        }
        this.f1690 = this.f1687.loadNextAd(nativeErrorCode);
    }
}
