package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
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
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class VastCompanionAdConfig implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final int f986;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final int f987;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final C0220 f988;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final String f989;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final List<VastTracker> f990;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final List<VastTracker> f991;

    public VastCompanionAdConfig(int i, int i2, @NonNull C0220 c0220, @Nullable String str, @NonNull List<VastTracker> list, @NonNull List<VastTracker> list2) {
        Preconditions.checkNotNull(c0220);
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        Preconditions.checkNotNull(list2, "creativeViewTrackers cannot be null");
        this.f986 = i;
        this.f987 = i2;
        this.f988 = c0220;
        this.f989 = str;
        this.f990 = list;
        this.f991 = list2;
    }

    public void addClickTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        this.f990.addAll(list);
    }

    public void addCreativeViewTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "creativeViewTrackers cannot be null");
        this.f991.addAll(list);
    }

    @Nullable
    public String getClickThroughUrl() {
        return this.f989;
    }

    @NonNull
    public List<VastTracker> getClickTrackers() {
        return this.f990;
    }

    @NonNull
    public List<VastTracker> getCreativeViewTrackers() {
        return this.f991;
    }

    public int getHeight() {
        return this.f987;
    }

    @NonNull
    public C0220 getVastResource() {
        return this.f988;
    }

    public int getWidth() {
        return this.f986;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m871(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context);
        TrackingRequest.makeVastTrackingHttpRequest(this.f991, null, Integer.valueOf(i), null, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m872(@NonNull final Context context, final int i, @Nullable String str, @Nullable final String str2) {
        Preconditions.checkNotNull(context);
        Preconditions.checkArgument(context instanceof Activity, "context must be an activity");
        String correctClickThroughUrl = this.f988.getCorrectClickThroughUrl(this.f989, str);
        if (TextUtils.isEmpty(correctClickThroughUrl)) {
            return;
        }
        new UrlHandler.Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new UrlHandler.ResultActions() { // from class: com.mopub.mobileads.VastCompanionAdConfig.1
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
                        ((Activity) context).startActivityForResult(Intents.getStartActivityIntent(context, MoPubBrowser.class, bundle), i);
                    } catch (ActivityNotFoundException unused) {
                        MoPubLog.d("Activity " + MoPubBrowser.class.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
                    }
                }
            }
        }).withDspCreativeId(str2).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUrl);
    }
}
