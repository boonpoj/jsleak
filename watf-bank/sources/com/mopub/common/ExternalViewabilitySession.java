package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import java.util.Map;
import java.util.Set;
/* loaded from: assets/classes2.dex */
public interface ExternalViewabilitySession {

    /* loaded from: assets/classes2.dex */
    public enum VideoEvent {
        AD_LOADED(null, "recordAdLoadedEvent"),
        AD_STARTED("AD_EVT_START", "recordAdStartedEvent"),
        AD_STOPPED("AD_EVT_STOPPED", "recordAdStoppedEvent"),
        AD_PAUSED("AD_EVT_PAUSED", "recordAdPausedEvent"),
        AD_PLAYING("AD_EVT_PLAYING", "recordAdPlayingEvent"),
        AD_SKIPPED("AD_EVT_SKIPPED", "recordAdSkippedEvent"),
        AD_IMPRESSED(null, "recordAdImpressionEvent"),
        AD_CLICK_THRU(null, "recordAdClickThruEvent"),
        AD_VIDEO_FIRST_QUARTILE("AD_EVT_FIRST_QUARTILE", "recordAdVideoFirstQuartileEvent"),
        AD_VIDEO_MIDPOINT("AD_EVT_MID_POINT", "recordAdVideoMidpointEvent"),
        AD_VIDEO_THIRD_QUARTILE("AD_EVT_THIRD_QUARTILE", "recordAdVideoThirdQuartileEvent"),
        AD_COMPLETE("AD_EVT_COMPLETE", "recordAdCompleteEvent"),
        RECORD_AD_ERROR(null, "recordAdError");
        
        @Nullable

        /* renamed from: ࢠ  reason: contains not printable characters */
        private String f360;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private String f361;

        VideoEvent(String str, String str2) {
            this.f360 = str;
            this.f361 = str2;
        }

        @NonNull
        public String getAvidMethodName() {
            return this.f361;
        }

        @Nullable
        public String getMoatEnumName() {
            return this.f360;
        }
    }

    @Nullable
    Boolean createDisplaySession(@NonNull Context context, @NonNull WebView webView, boolean z);

    @Nullable
    Boolean createVideoSession(@NonNull Activity activity, @NonNull View view, @NonNull Set<String> set, @NonNull Map<String, String> map);

    @Nullable
    Boolean endDisplaySession();

    @Nullable
    Boolean endVideoSession();

    @NonNull
    String getName();

    @Nullable
    Boolean initialize(@NonNull Context context);

    @Nullable
    Boolean invalidate();

    @Nullable
    Boolean onVideoPrepared(@NonNull View view, int i);

    @Nullable
    Boolean recordVideoEvent(@NonNull VideoEvent videoEvent, int i);

    @Nullable
    Boolean registerVideoObstruction(@NonNull View view);

    @Nullable
    Boolean startDeferredDisplaySession(@NonNull Activity activity);
}
