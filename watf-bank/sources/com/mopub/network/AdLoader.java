package com.mopub.network;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubError;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MultiAdRequest;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
/* loaded from: assets/classes2.dex */
public class AdLoader {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected MultiAdResponse f1969;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final MultiAdRequest.Listener f1971;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final WeakReference<Context> f1972;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Listener f1973;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private MultiAdRequest f1974;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private C0291 f1976;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private volatile boolean f1977;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private volatile boolean f1978;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private boolean f1979;
    @NonNull

    /* renamed from: ࢬ  reason: contains not printable characters */
    private Handler f1980;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final Object f1975 = new Object();
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected AdResponse f1970 = null;

    /* loaded from: assets/classes2.dex */
    public interface Listener extends Response.ErrorListener {
        void onSuccess(AdResponse adResponse);
    }

    public AdLoader(@NonNull String str, @NonNull AdFormat adFormat, @Nullable String str2, @NonNull Context context, @NonNull Listener listener) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str));
        Preconditions.checkNotNull(adFormat);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(listener);
        this.f1972 = new WeakReference<>(context);
        this.f1973 = listener;
        this.f1980 = new Handler();
        this.f1971 = new MultiAdRequest.Listener() { // from class: com.mopub.network.AdLoader.1
            @Override // com.mopub.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                AdLoader.this.f1978 = true;
                AdLoader.this.f1977 = false;
                AdLoader.this.m1559(volleyError);
            }

            @Override // com.mopub.network.MultiAdRequest.Listener
            public void onSuccessResponse(MultiAdResponse multiAdResponse) {
                synchronized (AdLoader.this.f1975) {
                    AdLoader.this.f1977 = false;
                    AdLoader.this.f1969 = multiAdResponse;
                    if (AdLoader.this.f1969.hasNext()) {
                        AdLoader.this.m1558(AdLoader.this.f1969.next());
                    }
                }
            }
        };
        this.f1977 = false;
        this.f1978 = false;
        this.f1974 = new MultiAdRequest(str, adFormat, str2, context, this.f1971);
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private Request<?> m1553(@NonNull MultiAdRequest multiAdRequest, @Nullable Context context) {
        Preconditions.checkNotNull(multiAdRequest);
        if (context == null) {
            return null;
        }
        this.f1977 = true;
        MoPubRequestQueue requestQueue = Networking.getRequestQueue(context);
        this.f1974 = multiAdRequest;
        requestQueue.add(multiAdRequest);
        return multiAdRequest;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1555(@Nullable MoPubError moPubError) {
        String str;
        if (moPubError == null) {
            str = "Must provide error code to report creative download error";
        } else {
            Context context = this.f1972.get();
            if (context != null && this.f1970 != null) {
                if (this.f1976 != null) {
                    this.f1976.m1619(context, moPubError);
                    this.f1976.m1621(context, moPubError);
                    return;
                }
                return;
            }
            str = "Cannot send creative mFailed analytics.";
        }
        MoPubLog.w(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1558(@NonNull AdResponse adResponse) {
        Preconditions.checkNotNull(adResponse);
        this.f1976 = new C0291(adResponse);
        this.f1976.m1618(this.f1972.get());
        if (this.f1973 != null) {
            this.f1970 = adResponse;
            this.f1973.onSuccess(adResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1559(@NonNull VolleyError volleyError) {
        Preconditions.checkNotNull(volleyError);
        this.f1970 = null;
        if (this.f1973 != null) {
            if (volleyError instanceof MoPubNetworkError) {
                this.f1973.onErrorResponse(volleyError);
            } else {
                this.f1973.onErrorResponse(new MoPubNetworkError(volleyError.getMessage(), volleyError.getCause(), MoPubNetworkError.Reason.UNSPECIFIED));
            }
        }
    }

    public void creativeDownloadSuccess() {
        this.f1979 = true;
        if (this.f1976 == null) {
            MoPubLog.e("Response analytics should not be null here");
            return;
        }
        Context context = this.f1972.get();
        if (context == null || this.f1970 == null) {
            MoPubLog.w("Cannot send 'x-after-load-url' analytics.");
            return;
        }
        this.f1976.m1619(context, (MoPubError) null);
        this.f1976.m1620(context);
    }

    public boolean hasMoreAds() {
        if (this.f1978 || this.f1979) {
            return false;
        }
        MultiAdResponse multiAdResponse = this.f1969;
        return multiAdResponse == null || multiAdResponse.hasNext() || !multiAdResponse.m1611();
    }

    public boolean isFailed() {
        return this.f1978;
    }

    public boolean isRunning() {
        return this.f1977;
    }

    @Nullable
    public Request<?> loadNextAd(@Nullable MoPubError moPubError) {
        Handler handler;
        Runnable runnable;
        if (this.f1977) {
            return this.f1974;
        }
        if (this.f1978) {
            handler = this.f1980;
            runnable = new Runnable() { // from class: com.mopub.network.AdLoader.2
                @Override // java.lang.Runnable
                public void run() {
                    AdLoader.this.m1559(new MoPubNetworkError(MoPubNetworkError.Reason.UNSPECIFIED));
                }
            };
        } else {
            synchronized (this.f1975) {
                if (this.f1969 == null) {
                    return m1553(this.f1974, this.f1972.get());
                }
                if (moPubError != null) {
                    m1555(moPubError);
                }
                if (this.f1969.hasNext()) {
                    final AdResponse next = this.f1969.next();
                    this.f1980.post(new Runnable() { // from class: com.mopub.network.AdLoader.3
                        @Override // java.lang.Runnable
                        public void run() {
                            AdLoader.this.m1558(next);
                        }
                    });
                    return this.f1974;
                } else if (!this.f1969.m1611()) {
                    this.f1974 = new MultiAdRequest(this.f1969.getFailURL(), this.f1974.f2065, this.f1974.f2066, this.f1972.get(), this.f1971);
                    return m1553(this.f1974, this.f1972.get());
                } else {
                    handler = this.f1980;
                    runnable = new Runnable() { // from class: com.mopub.network.AdLoader.4
                        @Override // java.lang.Runnable
                        public void run() {
                            AdLoader.this.m1559(new MoPubNetworkError(MoPubNetworkError.Reason.NO_FILL));
                        }
                    };
                }
            }
        }
        handler.post(runnable);
        return null;
    }
}
