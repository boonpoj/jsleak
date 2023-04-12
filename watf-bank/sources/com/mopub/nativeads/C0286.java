package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.PositioningSource;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.nativeads.ࢩ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0286 implements PositioningSource {
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Context f1945;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private PositioningSource.PositioningListener f1950;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private int f1951;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private String f1952;
    @Nullable

    /* renamed from: ࢪ  reason: contains not printable characters */
    private PositioningRequest f1953;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f1944 = 300000;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Handler f1946 = new Handler();
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Runnable f1947 = new Runnable() { // from class: com.mopub.nativeads.ࢩ.1
        @Override // java.lang.Runnable
        public void run() {
            C0286.this.m1543();
        }
    };

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Response.Listener<MoPubNativeAdPositioning.MoPubClientPositioning> f1948 = new Response.Listener<MoPubNativeAdPositioning.MoPubClientPositioning>() { // from class: com.mopub.nativeads.ࢩ.2
        @Override // com.mopub.volley.Response.Listener
        public void onResponse(MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
            C0286.this.m1544(moPubClientPositioning);
        }
    };

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final Response.ErrorListener f1949 = new Response.ErrorListener() { // from class: com.mopub.nativeads.ࢩ.3
        @Override // com.mopub.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (!(volleyError instanceof MoPubNetworkError) || ((MoPubNetworkError) volleyError).getReason().equals(MoPubNetworkError.Reason.WARMING_UP)) {
                MoPubLog.e("Failed to load positioning data", volleyError);
                if (volleyError.networkResponse == null && !DeviceUtils.isNetworkAvailable(C0286.this.f1945)) {
                    MoPubLog.c(String.valueOf(MoPubErrorCode.NO_CONNECTION.toString()));
                }
            }
            C0286.this.m1548();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0286(@NonNull Context context) {
        this.f1945 = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1543() {
        MoPubLog.d("Loading positioning from: " + this.f1952);
        this.f1953 = new PositioningRequest(this.f1945, this.f1952, this.f1948, this.f1949);
        Networking.getRequestQueue(this.f1945).add(this.f1953);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1544(@NonNull MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        if (this.f1950 != null) {
            this.f1950.onLoad(moPubClientPositioning);
        }
        this.f1950 = null;
        this.f1951 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1548() {
        int pow = (int) (Math.pow(2.0d, this.f1951 + 1) * 1000.0d);
        if (pow < this.f1944) {
            this.f1951++;
            this.f1946.postDelayed(this.f1947, pow);
            return;
        }
        MoPubLog.d("Error downloading positioning information");
        if (this.f1950 != null) {
            this.f1950.onFailed();
        }
        this.f1950 = null;
    }

    @Override // com.mopub.nativeads.PositioningSource
    public void loadPositions(@NonNull String str, @NonNull PositioningSource.PositioningListener positioningListener) {
        if (this.f1953 != null) {
            this.f1953.cancel();
            this.f1953 = null;
        }
        if (this.f1951 > 0) {
            this.f1946.removeCallbacks(this.f1947);
            this.f1951 = 0;
        }
        this.f1950 = positioningListener;
        this.f1952 = new C0285(this.f1945).withAdUnitId(str).generateUrlString(Constants.HOST);
        m1543();
    }
}
