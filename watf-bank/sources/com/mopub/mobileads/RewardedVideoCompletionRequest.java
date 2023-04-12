package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.mopub.network.MoPubRequest;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.RetryPolicy;
import com.mopub.volley.toolbox.HttpHeaderParser;
/* loaded from: assets/classes2.dex */
public class RewardedVideoCompletionRequest extends MoPubRequest<Integer> {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    final RewardedVideoCompletionRequestListener f976;

    /* loaded from: assets/classes2.dex */
    public interface RewardedVideoCompletionRequestListener extends Response.ErrorListener {
        void onResponse(Integer num);
    }

    public RewardedVideoCompletionRequest(@NonNull Context context, @NonNull String str, @NonNull RetryPolicy retryPolicy, @NonNull RewardedVideoCompletionRequestListener rewardedVideoCompletionRequestListener) {
        super(context, str, rewardedVideoCompletionRequestListener);
        setShouldCache(false);
        setRetryPolicy(retryPolicy);
        this.f976 = rewardedVideoCompletionRequestListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ */
    public Response<Integer> mo502(NetworkResponse networkResponse) {
        return Response.success(Integer.valueOf(networkResponse.statusCode), HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void deliverResponse(Integer num) {
        this.f976.onResponse(num);
    }
}
