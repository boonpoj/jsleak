package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.network.AdLoader;
import com.mopub.network.AdResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: assets/classes2.dex */
public class RewardedAdsLoaders {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final HashMap<String, C0229> f964 = new HashMap<>();
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final MoPubRewardedVideoManager f965;

    /* loaded from: assets/classes2.dex */
    public class RewardedVideoRequestListener implements AdLoader.Listener {
        public final String adUnitId;

        RewardedVideoRequestListener(String str) {
            this.adUnitId = str;
        }

        @Override // com.mopub.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            RewardedAdsLoaders.this.f965.m827(volleyError, this.adUnitId);
        }

        @Override // com.mopub.network.AdLoader.Listener
        public void onSuccess(AdResponse adResponse) {
            RewardedAdsLoaders.this.f965.m826(adResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RewardedAdsLoaders(@NonNull MoPubRewardedVideoManager moPubRewardedVideoManager) {
        this.f965 = moPubRewardedVideoManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Request<?> m856(@NonNull Context context, @NonNull String str, @NonNull String str2, @Nullable MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(context);
        C0229 c0229 = this.f964.get(str);
        if (c0229 == null || !c0229.hasMoreAds()) {
            c0229 = new C0229(str2, AdFormat.REWARDED_VIDEO, str, context, new RewardedVideoRequestListener(str));
            this.f964.put(str, c0229);
        }
        return c0229.loadNextAd(moPubErrorCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m857(@NonNull String str, @NonNull Context context) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(context);
        C0229 c0229 = this.f964.get(str);
        if (c0229 == null) {
            return;
        }
        c0229.m1042(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m858(@NonNull String str) {
        return this.f964.containsKey(str) && this.f964.get(str).isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m859(@NonNull String str) {
        Preconditions.checkNotNull(str);
        if (this.f964.containsKey(str)) {
            this.f964.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m860(@NonNull String str, @NonNull Context context) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(context);
        C0229 c0229 = this.f964.get(str);
        if (c0229 == null) {
            return;
        }
        c0229.m1044(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m861(@NonNull String str) {
        Preconditions.checkNotNull(str);
        if (this.f964.containsKey(str)) {
            this.f964.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public boolean m862(@NonNull String str) {
        C0229 c0229 = this.f964.get(str);
        return (c0229 == null || c0229.m1045() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public boolean m863(@NonNull String str) {
        C0229 c0229 = this.f964.get(str);
        return c0229 != null && c0229.hasMoreAds();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢦ  reason: contains not printable characters */
    public void m864(@NonNull String str) {
        C0229 c0229 = this.f964.get(str);
        if (c0229 == null) {
            return;
        }
        c0229.creativeDownloadSuccess();
    }
}
