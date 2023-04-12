package com.mopub.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.VastErrorCode;
import com.mopub.mobileads.VastMacroHelper;
import com.mopub.mobileads.VastTracker;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class TrackingRequest extends MoPubRequest<Void> {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Listener f2084;

    /* loaded from: assets/classes2.dex */
    public interface Listener extends Response.ErrorListener {
        void onResponse(@NonNull String str);
    }

    private TrackingRequest(@NonNull Context context, @NonNull String str, @Nullable Listener listener) {
        super(context, str, listener);
        this.f2084 = listener;
        setShouldCache(false);
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 0, 1.0f));
    }

    public static void makeTrackingHttpRequest(@Nullable Iterable<String> iterable, @Nullable Context context) {
        makeTrackingHttpRequest(iterable, context, (Listener) null);
    }

    public static void makeTrackingHttpRequest(@Nullable Iterable<String> iterable, @Nullable Context context, @Nullable final Listener listener) {
        if (iterable == null || context == null) {
            return;
        }
        MoPubRequestQueue requestQueue = Networking.getRequestQueue(context);
        for (final String str : iterable) {
            if (!TextUtils.isEmpty(str)) {
                requestQueue.add(new TrackingRequest(context, str, new Listener() { // from class: com.mopub.network.TrackingRequest.1
                    @Override // com.mopub.volley.Response.ErrorListener
                    public void onErrorResponse(VolleyError volleyError) {
                        MoPubLog.d("Failed to hit tracking endpoint: " + str);
                        if (Listener.this != null) {
                            Listener.this.onErrorResponse(volleyError);
                        }
                    }

                    @Override // com.mopub.network.TrackingRequest.Listener
                    public void onResponse(@NonNull String str2) {
                        MoPubLog.d("Successfully hit tracking endpoint: " + str2);
                        if (Listener.this != null) {
                            Listener.this.onResponse(str2);
                        }
                    }
                }));
            }
        }
    }

    public static void makeTrackingHttpRequest(@Nullable String str, @Nullable Context context) {
        makeTrackingHttpRequest(str, context, (Listener) null);
    }

    public static void makeTrackingHttpRequest(@Nullable String str, @Nullable Context context, @Nullable Listener listener) {
        if (str != null) {
            makeTrackingHttpRequest(Arrays.asList(str), context, listener);
        }
    }

    public static void makeVastTrackingHttpRequest(@NonNull List<VastTracker> list, @Nullable VastErrorCode vastErrorCode, @Nullable Integer num, @Nullable String str, @Nullable Context context) {
        Preconditions.checkNotNull(list);
        ArrayList arrayList = new ArrayList(list.size());
        for (VastTracker vastTracker : list) {
            if (vastTracker != null && (!vastTracker.isTracked() || vastTracker.isRepeatable())) {
                arrayList.add(vastTracker.getContent());
                vastTracker.setTracked();
            }
        }
        makeTrackingHttpRequest(new VastMacroHelper(arrayList).withErrorCode(vastErrorCode).withContentPlayHead(num).withAssetUri(str).getUris(), context);
    }

    @Override // com.mopub.volley.Request
    public void deliverResponse(Void r2) {
        if (this.f2084 != null) {
            this.f2084.onResponse(getUrl());
        }
    }

    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ */
    protected Response<Void> mo502(NetworkResponse networkResponse) {
        if (networkResponse.statusCode != 200) {
            return Response.error(new MoPubNetworkError("Failed to log tracking request. Response code: " + networkResponse.statusCode + " for url: " + getUrl(), MoPubNetworkError.Reason.TRACKING_FAILURE));
        }
        return Response.success(null, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }
}
