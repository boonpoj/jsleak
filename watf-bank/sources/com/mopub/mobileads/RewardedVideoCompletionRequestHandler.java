package com.mopub.mobileads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.RewardedVideoCompletionRequest;
import com.mopub.network.Networking;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.VolleyError;
/* loaded from: assets/classes2.dex */
public class RewardedVideoCompletionRequestHandler implements RewardedVideoCompletionRequest.RewardedVideoCompletionRequestListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    static final int[] f977 = {5000, 10000, 20000, 40000, 60000};
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f978;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Handler f979;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final RequestQueue f980;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Context f981;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f982;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private volatile boolean f983;

    RewardedVideoCompletionRequestHandler(@NonNull Context context, @NonNull String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable String str5, @Nullable String str6) {
        this(context, str, str2, str3, str4, str5, str6, new Handler());
    }

    @VisibleForTesting
    RewardedVideoCompletionRequestHandler(@NonNull Context context, @NonNull String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable String str5, @Nullable String str6, @NonNull Handler handler) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str3);
        Preconditions.checkNotNull(str4);
        Preconditions.checkNotNull(handler);
        this.f978 = m869(str, str2, str3, str4, str5, str6);
        this.f982 = 0;
        this.f979 = handler;
        this.f980 = Networking.getRequestQueue(context);
        this.f981 = context.getApplicationContext();
    }

    public static void makeRewardedVideoCompletionRequest(@Nullable Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable String str5, @Nullable String str6) {
        if (context == null || TextUtils.isEmpty(str) || str3 == null || str4 == null) {
            return;
        }
        new RewardedVideoCompletionRequestHandler(context, str, str2, str3, str4, str5, str6).m870();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static int m868(int i) {
        return (i < 0 || i >= f977.length) ? f977[f977.length - 1] : f977[i];
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m869(@NonNull String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable String str5, @Nullable String str6) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str3);
        Preconditions.checkNotNull(str4);
        StringBuilder sb = new StringBuilder(str);
        sb.append("&customer_id=");
        sb.append(str2 == null ? "" : Uri.encode(str2));
        sb.append("&rcn=");
        sb.append(Uri.encode(str3));
        sb.append("&rca=");
        sb.append(Uri.encode(str4));
        sb.append("&nv=");
        sb.append(Uri.encode("5.4.1"));
        sb.append("&v=");
        sb.append(1);
        sb.append("&cec=");
        sb.append(str5 == null ? "" : Uri.encode(str5));
        if (!TextUtils.isEmpty(str6)) {
            sb.append("&rcd=");
            sb.append(Uri.encode(str6));
        }
        return sb.toString();
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        if (volleyError == null || volleyError.networkResponse == null) {
            return;
        }
        if (volleyError.networkResponse.statusCode < 500 || volleyError.networkResponse.statusCode >= 600) {
            this.f983 = true;
        }
    }

    @Override // com.mopub.mobileads.RewardedVideoCompletionRequest.RewardedVideoCompletionRequestListener
    public void onResponse(Integer num) {
        if (num != null) {
            if (num.intValue() < 500 || num.intValue() >= 600) {
                this.f983 = true;
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m870() {
        if (this.f983) {
            this.f980.cancelAll(this.f978);
            return;
        }
        RewardedVideoCompletionRequest rewardedVideoCompletionRequest = new RewardedVideoCompletionRequest(this.f981, this.f978, new DefaultRetryPolicy(m868(this.f982) + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED, 0, 0.0f), this);
        rewardedVideoCompletionRequest.setTag(this.f978);
        this.f980.add(rewardedVideoCompletionRequest);
        if (this.f982 >= 17) {
            MoPubLog.d("Exceeded number of retries for rewarded video completion request.");
            return;
        }
        this.f979.postDelayed(new Runnable() { // from class: com.mopub.mobileads.RewardedVideoCompletionRequestHandler.1
            @Override // java.lang.Runnable
            public void run() {
                RewardedVideoCompletionRequestHandler.this.m870();
            }
        }, m868(this.f982));
        this.f982++;
    }
}
