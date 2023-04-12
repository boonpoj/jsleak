package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.ࢬ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0244 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final int f1280;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final int f1281;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final int f1282;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Integer f1283;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final C0220 f1284;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final List<VastTracker> f1285;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final String f1286;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final List<VastTracker> f1287;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0244(int i, int i2, @Nullable Integer num, @Nullable Integer num2, @NonNull C0220 c0220, @NonNull List<VastTracker> list, @Nullable String str, @NonNull List<VastTracker> list2) {
        Preconditions.checkNotNull(c0220);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.f1280 = i;
        this.f1281 = i2;
        this.f1282 = num == null ? 0 : num.intValue();
        this.f1283 = num2;
        this.f1284 = c0220;
        this.f1285 = list;
        this.f1286 = str;
        this.f1287 = list2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public int m1109() {
        return this.f1280;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1110(@NonNull Context context, int i, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        TrackingRequest.makeVastTrackingHttpRequest(this.f1287, null, Integer.valueOf(i), str, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1111(@NonNull final Context context, @Nullable String str, @Nullable final String str2) {
        Preconditions.checkNotNull(context);
        String correctClickThroughUrl = this.f1284.getCorrectClickThroughUrl(this.f1286, str);
        if (TextUtils.isEmpty(correctClickThroughUrl)) {
            return;
        }
        new UrlHandler.Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER).withResultActions(new UrlHandler.ResultActions() { // from class: com.mopub.mobileads.ࢬ.1
            @Override // com.mopub.common.UrlHandler.ResultActions
            public void urlHandlingFailed(@NonNull String str3, @NonNull UrlAction urlAction) {
            }

            @Override // com.mopub.common.UrlHandler.ResultActions
            public void urlHandlingSucceeded(@NonNull String str3, @NonNull UrlAction urlAction) {
                if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
                    Bundle bundle = new Bundle();
                    bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str3);
                    if (!TextUtils.isEmpty(str2)) {
                        bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, str2);
                    }
                    try {
                        Intents.startActivity(context, Intents.getStartActivityIntent(context, MoPubBrowser.class, bundle));
                    } catch (IntentNotResolvableException e) {
                        MoPubLog.d(e.getMessage());
                    }
                }
            }
        }).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUrl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public int m1112() {
        return this.f1281;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public int m1113() {
        return this.f1282;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢤ  reason: contains not printable characters */
    public Integer m1114() {
        return this.f1283;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢥ  reason: contains not printable characters */
    public C0220 m1115() {
        return this.f1284;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢦ  reason: contains not printable characters */
    public List<VastTracker> m1116() {
        return this.f1285;
    }
}
