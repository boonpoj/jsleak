package com.integralads.avid.library.mopub.video;

import com.integralads.avid.library.mopub.base.AvidBaseListenerImpl;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AvidVideoPlaybackListenerImpl extends AvidBaseListenerImpl implements AvidVideoPlaybackListener {
    public static final String AD_CLICK_THRU = "AdClickThru";
    public static final String AD_DURATION = "adDuration";
    public static final String AD_DURATION_CHANGE = "AdDurationChange";
    public static final String AD_ENTERED_FULLSCREEN = "AdEnteredFullscreen";
    public static final String AD_ERROR = "AdError";
    public static final String AD_EXITED_FULLSCREEN = "AdExitedFullscreen";
    public static final String AD_EXPANDED_CHANGE = "AdExpandedChange";
    public static final String AD_IMPRESSION = "AdImpression";
    public static final String AD_LOADED = "AdLoaded";
    public static final String AD_PAUSED = "AdPaused";
    public static final String AD_PLAYING = "AdPlaying";
    public static final String AD_REMAINING_TIME = "adDuration";
    public static final String AD_SKIPPED = "AdSkipped";
    public static final String AD_STARTED = "AdStarted";
    public static final String AD_STOPPED = "AdStopped";
    public static final String AD_USER_ACCEPT_INVITATION = "AdUserAcceptInvitation";
    public static final String AD_USER_CLOSE = "AdUserClose";
    public static final String AD_USER_MINIMIZE = "AdUserMinimize";
    public static final String AD_VIDEO_COMPLETE = "AdVideoComplete";
    public static final String AD_VIDEO_FIRST_QUARTILE = "AdVideoFirstQuartile";
    public static final String AD_VIDEO_MIDPOINT = "AdVideoMidpoint";
    public static final String AD_VIDEO_START = "AdVideoStart";
    public static final String AD_VIDEO_THIRD_QUARTILE = "AdVideoThirdQuartile";
    public static final String AD_VOLUME_CHANGE = "AdVolumeChange";
    public static final String MESSAGE = "message";
    public static final String VOLUME = "volume";

    public AvidVideoPlaybackListenerImpl(InternalAvidAdSession internalAvidAdSession, AvidBridgeManager avidBridgeManager) {
        super(internalAvidAdSession, avidBridgeManager);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m70(String str, JSONObject jSONObject) {
        m43();
        m71();
        m42().publishVideoEvent(str, jSONObject);
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m71() {
        if (!m41().isReady()) {
            throw new IllegalStateException("The AVID ad session is not ready. Please ensure you have called recordReadyEvent for the deferred AVID ad session before recording any video event.");
        }
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdClickThruEvent() {
        m70(AD_CLICK_THRU, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdCompleteEvent() {
        m70(AD_VIDEO_COMPLETE, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdDurationChangeEvent(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adDuration", str);
            jSONObject.put("adDuration", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m70(AD_DURATION_CHANGE, jSONObject);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdEnteredFullscreenEvent() {
        m70(AD_ENTERED_FULLSCREEN, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdError(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MESSAGE, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m70(AD_ERROR, jSONObject);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdExitedFullscreenEvent() {
        m70(AD_EXITED_FULLSCREEN, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdExpandedChangeEvent() {
        m70(AD_EXPANDED_CHANGE, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdImpressionEvent() {
        m70(AD_IMPRESSION, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdLoadedEvent() {
        m70(AD_LOADED, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdPausedEvent() {
        m70(AD_PAUSED, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdPlayingEvent() {
        m70(AD_PLAYING, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdSkippedEvent() {
        m70(AD_SKIPPED, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdStartedEvent() {
        m70(AD_STARTED, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdStoppedEvent() {
        m70(AD_STOPPED, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdUserAcceptInvitationEvent() {
        m70(AD_USER_ACCEPT_INVITATION, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdUserCloseEvent() {
        m70(AD_USER_CLOSE, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdUserMinimizeEvent() {
        m70(AD_USER_MINIMIZE, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdVideoFirstQuartileEvent() {
        m70(AD_VIDEO_FIRST_QUARTILE, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdVideoMidpointEvent() {
        m70(AD_VIDEO_MIDPOINT, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdVideoStartEvent() {
        m70(AD_VIDEO_START, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdVideoThirdQuartileEvent() {
        m70(AD_VIDEO_THIRD_QUARTILE, null);
    }

    @Override // com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener
    public void recordAdVolumeChangeEvent(Integer num) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VOLUME, num);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m70(AD_VOLUME_CHANGE, jSONObject);
    }
}
