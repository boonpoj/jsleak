package com.mopub.network;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.MoPubError;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.network.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0291 {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    Long f2087 = null;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private AdResponse f2088;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.network.ࢠ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0292 {
        AD_LOADED("ad_loaded"),
        MISSING_ADAPTER("missing_adapter"),
        TIMEOUT("timeout"),
        INVALID_DATA("invalid_data");
        
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final String f2090;

        EnumC0292(String str) {
            this.f2090 = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0291(@NonNull AdResponse adResponse) {
        Preconditions.checkNotNull(adResponse);
        this.f2088 = adResponse;
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    private EnumC0292 m1616(@Nullable MoPubError moPubError) {
        if (moPubError == null) {
            return EnumC0292.AD_LOADED;
        }
        switch (moPubError.getIntCode()) {
            case 0:
                return EnumC0292.AD_LOADED;
            case 1:
                return EnumC0292.MISSING_ADAPTER;
            case 2:
                return EnumC0292.TIMEOUT;
            default:
                return EnumC0292.INVALID_DATA;
        }
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private List<String> m1617(@Nullable List<String> list, @NonNull String str) {
        if (list == null || list.isEmpty() || this.f2087 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            arrayList.add(str2.replace("%%LOAD_DURATION_MS%%", String.valueOf(SystemClock.uptimeMillis() - this.f2087.longValue())).replace("%%LOAD_RESULT%%", Uri.encode(str)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1618(@Nullable Context context) {
        if (context == null) {
            return;
        }
        String beforeLoadUrl = this.f2088.getBeforeLoadUrl();
        if (TextUtils.isEmpty(beforeLoadUrl)) {
            return;
        }
        this.f2087 = Long.valueOf(SystemClock.uptimeMillis());
        TrackingRequest.makeTrackingHttpRequest(beforeLoadUrl, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1619(@Nullable Context context, @Nullable MoPubError moPubError) {
        if (context == null || this.f2087 == null) {
            return;
        }
        TrackingRequest.makeTrackingHttpRequest(m1617(this.f2088.getAfterLoadUrls(), m1616(moPubError).f2090), context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1620(@Nullable Context context) {
        if (context == null || this.f2087 == null) {
            return;
        }
        TrackingRequest.makeTrackingHttpRequest(m1617(this.f2088.getAfterLoadSuccessUrls(), EnumC0292.AD_LOADED.f2090), context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1621(@Nullable Context context, @Nullable MoPubError moPubError) {
        if (context == null || this.f2087 == null) {
            return;
        }
        TrackingRequest.makeTrackingHttpRequest(m1617(this.f2088.getAfterLoadFailUrls(), m1616(moPubError).f2090), context);
    }
}
