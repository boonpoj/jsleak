package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.ExternalViewabilitySession;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.IntentActions;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.C0223;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class VastVideoViewController extends BaseVideoViewController {
    public static final int WEBVIEW_PADDING = 16;
    @NonNull

    /* renamed from: ֏  reason: contains not printable characters */
    private final View f1093;
    @NonNull

    /* renamed from: ؠ  reason: contains not printable characters */
    private final View f1094;
    @NonNull

    /* renamed from: ހ  reason: contains not printable characters */
    private final Map<String, VastCompanionAdConfig> f1095;
    @NonNull

    /* renamed from: ށ  reason: contains not printable characters */
    private View f1096;
    @NonNull

    /* renamed from: ނ  reason: contains not printable characters */
    private final View f1097;
    @NonNull

    /* renamed from: ރ  reason: contains not printable characters */
    private final View f1098;
    @NonNull

    /* renamed from: ބ  reason: contains not printable characters */
    private final VastVideoViewProgressRunnable f1099;
    @NonNull

    /* renamed from: ޅ  reason: contains not printable characters */
    private final VastVideoViewCountdownRunnable f1100;
    @NonNull

    /* renamed from: ކ  reason: contains not printable characters */
    private final View.OnTouchListener f1101;

    /* renamed from: އ  reason: contains not printable characters */
    private int f1102;

    /* renamed from: ވ  reason: contains not printable characters */
    private boolean f1103;

    /* renamed from: މ  reason: contains not printable characters */
    private int f1104;

    /* renamed from: ފ  reason: contains not printable characters */
    private boolean f1105;

    /* renamed from: ދ  reason: contains not printable characters */
    private boolean f1106;

    /* renamed from: ތ  reason: contains not printable characters */
    private boolean f1107;

    /* renamed from: ލ  reason: contains not printable characters */
    private boolean f1108;

    /* renamed from: ގ  reason: contains not printable characters */
    private boolean f1109;

    /* renamed from: ޏ  reason: contains not printable characters */
    private int f1110;

    /* renamed from: ސ  reason: contains not printable characters */
    private boolean f1111;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final VastVideoConfig f1112;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final VastVideoView f1113;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private ExternalViewabilitySessionManager f1114;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private VastVideoGradientStripWidget f1115;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private VastVideoGradientStripWidget f1116;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private ImageView f1117;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private VastVideoProgressBarWidget f1118;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private VastVideoRadialCountdownWidget f1119;
    @NonNull

    /* renamed from: ࢩ  reason: contains not printable characters */
    private VastVideoCtaButtonWidget f1120;
    @NonNull

    /* renamed from: ࢪ  reason: contains not printable characters */
    private VastVideoCloseButtonWidget f1121;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private VastCompanionAdConfig f1122;
    @Nullable

    /* renamed from: ࢬ  reason: contains not printable characters */
    private final C0244 f1123;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastVideoViewController(final Activity activity, Bundle bundle, @Nullable Bundle bundle2, long j, BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener) throws IllegalStateException {
        super(activity, Long.valueOf(j), baseVideoViewControllerListener);
        this.f1102 = 5000;
        this.f1107 = false;
        this.f1108 = false;
        this.f1109 = false;
        this.f1111 = false;
        this.f1104 = -1;
        Serializable serializable = bundle2 != null ? bundle2.getSerializable("resumed_vast_config") : null;
        Serializable serializable2 = bundle.getSerializable("vast_video_config");
        if (serializable != null && (serializable instanceof VastVideoConfig)) {
            this.f1112 = (VastVideoConfig) serializable;
            this.f1104 = bundle2.getInt("current_position", -1);
        } else if (serializable2 == null || !(serializable2 instanceof VastVideoConfig)) {
            throw new IllegalStateException("VastVideoConfig is invalid");
        } else {
            this.f1112 = (VastVideoConfig) serializable2;
        }
        if (this.f1112.getDiskMediaFileUrl() == null) {
            throw new IllegalStateException("VastVideoConfig does not have a video disk path");
        }
        this.f1122 = this.f1112.getVastCompanionAd(activity.getResources().getConfiguration().orientation);
        this.f1095 = this.f1112.getSocialActionsCompanionAds();
        this.f1123 = this.f1112.getVastIconConfig();
        this.f1101 = new View.OnTouchListener() { // from class: com.mopub.mobileads.VastVideoViewController.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 && VastVideoViewController.this.m925()) {
                    VastVideoViewController.this.f1114.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_CLICK_THRU, VastVideoViewController.this.m969());
                    VastVideoViewController.this.f1111 = true;
                    VastVideoViewController.this.m722(IntentActions.ACTION_INTERSTITIAL_CLICK);
                    VastVideoViewController.this.f1112.handleClickForResult(activity, VastVideoViewController.this.f1105 ? VastVideoViewController.this.f1110 : VastVideoViewController.this.m969(), 1);
                }
                return true;
            }
        };
        getLayout().setBackgroundColor(-16777216);
        m951(activity, 4);
        this.f1113 = m934(activity, 0);
        this.f1113.requestFocus();
        this.f1114 = new ExternalViewabilitySessionManager(activity);
        this.f1114.createVideoSession(activity, this.f1113, this.f1112);
        this.f1114.registerVideoObstruction(this.f1117);
        this.f1093 = m963(activity, this.f1112.getVastCompanionAd(2), 4);
        this.f1094 = m963(activity, this.f1112.getVastCompanionAd(1), 4);
        m936((Context) activity);
        m941(activity, 4);
        m940(activity);
        m944(activity, 4);
        this.f1098 = m965(activity, this.f1123, 4);
        this.f1098.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.mopub.mobileads.VastVideoViewController.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                VastVideoViewController.this.f1096 = VastVideoViewController.this.m962(activity);
                VastVideoViewController.this.f1098.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        m943(activity);
        this.f1097 = m964(activity, this.f1095.get(VastXmlManagerAggregator.SOCIAL_ACTIONS_AD_SLOT_ID), Dips.dipsToIntPixels(38.0f, activity), 6, this.f1120, 4, 16);
        m948(activity, 8);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f1099 = new VastVideoViewProgressRunnable(this, this.f1112, handler);
        this.f1100 = new VastVideoViewCountdownRunnable(this, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ށ  reason: contains not printable characters */
    public void m922() {
        int m968 = m968();
        if (this.f1112.isRewardedVideo()) {
            this.f1102 = m968;
            return;
        }
        if (m968 < 16000) {
            this.f1102 = m968;
        }
        Integer skipOffsetMillis = this.f1112.getSkipOffsetMillis(m968);
        if (skipOffsetMillis != null) {
            this.f1102 = skipOffsetMillis.intValue();
            this.f1107 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ނ  reason: contains not printable characters */
    public boolean m925() {
        return this.f1103;
    }

    /* renamed from: ރ  reason: contains not printable characters */
    private void m927() {
        this.f1099.startRepeating(50L);
        this.f1100.startRepeating(250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ބ  reason: contains not printable characters */
    public void m929() {
        this.f1099.stop();
        this.f1100.stop();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private VastVideoView m934(@NonNull final Context context, int i) {
        if (this.f1112.getDiskMediaFileUrl() != null) {
            final VastVideoView vastVideoView = new VastVideoView(context);
            vastVideoView.setId((int) Utils.generateUniqueId());
            vastVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.mopub.mobileads.VastVideoViewController.5
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    VastVideoViewController.this.f1110 = VastVideoViewController.this.f1113.getDuration();
                    VastVideoViewController.this.f1114.onVideoPrepared(VastVideoViewController.this.getLayout(), VastVideoViewController.this.f1110);
                    VastVideoViewController.this.m922();
                    if (VastVideoViewController.this.f1122 == null || VastVideoViewController.this.f1109) {
                        vastVideoView.prepareBlurredLastVideoFrame(VastVideoViewController.this.f1117, VastVideoViewController.this.f1112.getDiskMediaFileUrl());
                    }
                    VastVideoViewController.this.f1118.calibrateAndMakeVisible(VastVideoViewController.this.m968(), VastVideoViewController.this.f1102);
                    VastVideoViewController.this.f1119.calibrateAndMakeVisible(VastVideoViewController.this.f1102);
                    VastVideoViewController.this.f1108 = true;
                }
            });
            vastVideoView.setOnTouchListener(this.f1101);
            vastVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.mopub.mobileads.VastVideoViewController.6
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    VastVideoViewController.this.m929();
                    VastVideoViewController.this.m970();
                    VastVideoViewController.this.m725(false);
                    VastVideoViewController.this.f1105 = true;
                    if (VastVideoViewController.this.f1112.isRewardedVideo()) {
                        VastVideoViewController.this.m722(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
                    }
                    if (!VastVideoViewController.this.f1106 && VastVideoViewController.this.f1112.getRemainingProgressTrackerCount() == 0) {
                        VastVideoViewController.this.f1114.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_COMPLETE, VastVideoViewController.this.m969());
                        VastVideoViewController.this.f1112.handleComplete(VastVideoViewController.this.m731(), VastVideoViewController.this.m969());
                    }
                    vastVideoView.setVisibility(4);
                    VastVideoViewController.this.f1118.setVisibility(8);
                    if (!VastVideoViewController.this.f1109) {
                        VastVideoViewController.this.f1098.setVisibility(8);
                    } else if (VastVideoViewController.this.f1117.getDrawable() != null) {
                        VastVideoViewController.this.f1117.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        VastVideoViewController.this.f1117.setVisibility(0);
                    }
                    VastVideoViewController.this.f1115.m918();
                    VastVideoViewController.this.f1116.m918();
                    VastVideoViewController.this.f1120.m916();
                    if (VastVideoViewController.this.f1122 != null) {
                        (context.getResources().getConfiguration().orientation == 1 ? VastVideoViewController.this.f1094 : VastVideoViewController.this.f1093).setVisibility(0);
                        VastVideoViewController.this.f1122.m871(context, VastVideoViewController.this.f1110);
                    } else if (VastVideoViewController.this.f1117.getDrawable() != null) {
                        VastVideoViewController.this.f1117.setVisibility(0);
                    }
                }
            });
            vastVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.mopub.mobileads.VastVideoViewController.7
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                    VastVideoViewController.this.f1114.recordVideoEvent(ExternalViewabilitySession.VideoEvent.RECORD_AD_ERROR, VastVideoViewController.this.m969());
                    VastVideoViewController.this.m929();
                    VastVideoViewController.this.m970();
                    VastVideoViewController.this.m723(false);
                    VastVideoViewController.this.f1106 = true;
                    VastVideoViewController.this.f1112.handleError(VastVideoViewController.this.m731(), VastErrorCode.GENERAL_LINEAR_AD_ERROR, VastVideoViewController.this.m969());
                    return false;
                }
            });
            vastVideoView.setVideoPath(this.f1112.getDiskMediaFileUrl());
            vastVideoView.setVisibility(i);
            return vastVideoView;
        }
        throw new IllegalStateException("VastVideoConfig does not have a video disk path");
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    private C0223 m935(@NonNull final Context context, @NonNull final VastCompanionAdConfig vastCompanionAdConfig) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastCompanionAdConfig);
        C0223 m1028 = C0223.m1028(context, vastCompanionAdConfig.getVastResource());
        m1028.m1030(new C0223.InterfaceC0224() { // from class: com.mopub.mobileads.VastVideoViewController.11
            @Override // com.mopub.mobileads.C0223.InterfaceC0224
            public void onVastWebViewClick() {
                VastVideoViewController.this.m722(IntentActions.ACTION_INTERSTITIAL_CLICK);
                TrackingRequest.makeVastTrackingHttpRequest(vastCompanionAdConfig.getClickTrackers(), null, Integer.valueOf(VastVideoViewController.this.f1110), null, context);
                vastCompanionAdConfig.m872(context, 1, null, VastVideoViewController.this.f1112.getDspCreativeId());
            }
        });
        m1028.setWebViewClient(new WebViewClient() { // from class: com.mopub.mobileads.VastVideoViewController.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                vastCompanionAdConfig.m872(context, 1, str, VastVideoViewController.this.f1112.getDspCreativeId());
                return true;
            }
        });
        return m1028;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m936(@NonNull Context context) {
        this.f1115 = new VastVideoGradientStripWidget(context, GradientDrawable.Orientation.TOP_BOTTOM, this.f1112.getCustomForceOrientation(), this.f1122 != null, 0, 6, getLayout().getId());
        getLayout().addView(this.f1115);
        this.f1114.registerVideoObstruction(this.f1115);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m940(@NonNull Context context) {
        this.f1116 = new VastVideoGradientStripWidget(context, GradientDrawable.Orientation.BOTTOM_TOP, this.f1112.getCustomForceOrientation(), this.f1122 != null, 8, 2, this.f1118.getId());
        getLayout().addView(this.f1116);
        this.f1114.registerVideoObstruction(this.f1116);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m941(@NonNull Context context, int i) {
        this.f1118 = new VastVideoProgressBarWidget(context);
        this.f1118.setAnchorId(this.f1113.getId());
        this.f1118.setVisibility(i);
        getLayout().addView(this.f1118);
        this.f1114.registerVideoObstruction(this.f1118);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m943(@NonNull Context context) {
        this.f1120 = new VastVideoCtaButtonWidget(context, this.f1113.getId(), this.f1122 != null, true ^ TextUtils.isEmpty(this.f1112.getClickThroughUrl()));
        getLayout().addView(this.f1120);
        this.f1114.registerVideoObstruction(this.f1120);
        this.f1120.setOnTouchListener(this.f1101);
        String customCtaText = this.f1112.getCustomCtaText();
        if (customCtaText != null) {
            this.f1120.m915(customCtaText);
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m944(@NonNull Context context, int i) {
        this.f1119 = new VastVideoRadialCountdownWidget(context);
        this.f1119.setVisibility(i);
        getLayout().addView(this.f1119);
        this.f1114.registerVideoObstruction(this.f1119);
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m948(@NonNull Context context, int i) {
        this.f1121 = new VastVideoCloseButtonWidget(context);
        this.f1121.setVisibility(i);
        getLayout().addView(this.f1121);
        this.f1114.registerVideoObstruction(this.f1121);
        this.f1121.setOnTouchListenerToContent(new View.OnTouchListener() { // from class: com.mopub.mobileads.VastVideoViewController.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int m969 = VastVideoViewController.this.f1105 ? VastVideoViewController.this.f1110 : VastVideoViewController.this.m969();
                if (motionEvent.getAction() == 1) {
                    VastVideoViewController.this.f1111 = true;
                    if (!VastVideoViewController.this.f1105) {
                        VastVideoViewController.this.f1114.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_SKIPPED, VastVideoViewController.this.m969());
                    }
                    VastVideoViewController.this.f1112.handleClose(VastVideoViewController.this.m731(), m969);
                    VastVideoViewController.this.m730().onFinish();
                }
                return true;
            }
        });
        String customSkipText = this.f1112.getCustomSkipText();
        if (customSkipText != null) {
            this.f1121.m902(customSkipText);
        }
        String customCloseIconUrl = this.f1112.getCustomCloseIconUrl();
        if (customCloseIconUrl != null) {
            this.f1121.m903(customCloseIconUrl);
        }
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private void m951(@NonNull Context context, int i) {
        this.f1117 = new ImageView(context);
        this.f1117.setVisibility(i);
        getLayout().addView(this.f1117, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public boolean backButtonEnabled() {
        return this.f1103;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ֏  reason: contains not printable characters */
    public void m959() {
        if (this.f1108) {
            this.f1119.updateCountdownProgress(this.f1102, m969());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ؠ  reason: contains not printable characters */
    public void m960() {
        this.f1118.updateProgress(m969());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ހ  reason: contains not printable characters */
    public String m961() {
        if (this.f1112 == null) {
            return null;
        }
        return this.f1112.getNetworkMediaFileUrl();
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    View m962(Activity activity) {
        return m964(activity, this.f1095.get(VastXmlManagerAggregator.ADS_BY_AD_SLOT_ID), this.f1098.getHeight(), 1, this.f1098, 0, 6);
    }

    @NonNull
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    View m963(@NonNull Context context, @Nullable VastCompanionAdConfig vastCompanionAdConfig, int i) {
        Preconditions.checkNotNull(context);
        if (vastCompanionAdConfig == null) {
            View view = new View(context);
            view.setVisibility(4);
            return view;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(17);
        getLayout().addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f1114.registerVideoObstruction(relativeLayout);
        C0223 m935 = m935(context, vastCompanionAdConfig);
        m935.setVisibility(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(vastCompanionAdConfig.getWidth() + 16, context), Dips.dipsToIntPixels(vastCompanionAdConfig.getHeight() + 16, context));
        layoutParams.addRule(13, -1);
        relativeLayout.addView(m935, layoutParams);
        this.f1114.registerVideoObstruction(m935);
        return m935;
    }

    @NonNull
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    View m964(@NonNull Context context, @Nullable VastCompanionAdConfig vastCompanionAdConfig, int i, int i2, @NonNull View view, int i3, int i4) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(view);
        if (vastCompanionAdConfig == null) {
            View view2 = new View(context);
            view2.setVisibility(4);
            return view2;
        }
        this.f1109 = true;
        this.f1120.setHasSocialActions(this.f1109);
        C0223 m935 = m935(context, vastCompanionAdConfig);
        int dipsToIntPixels = Dips.dipsToIntPixels(vastCompanionAdConfig.getWidth(), context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(vastCompanionAdConfig.getHeight(), context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(i4, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels2);
        layoutParams.addRule(i2, view.getId());
        layoutParams.addRule(6, view.getId());
        layoutParams.setMargins(dipsToIntPixels3, (i - dipsToIntPixels2) / 2, 0, 0);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(16);
        relativeLayout.addView(m935, new RelativeLayout.LayoutParams(-2, -2));
        this.f1114.registerVideoObstruction(m935);
        getLayout().addView(relativeLayout, layoutParams);
        this.f1114.registerVideoObstruction(relativeLayout);
        m935.setVisibility(i3);
        return m935;
    }

    @NonNull
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    View m965(@NonNull final Context context, @Nullable final C0244 c0244, int i) {
        Preconditions.checkNotNull(context);
        if (c0244 == null) {
            return new View(context);
        }
        C0223 m1028 = C0223.m1028(context, c0244.m1115());
        m1028.m1030(new C0223.InterfaceC0224() { // from class: com.mopub.mobileads.VastVideoViewController.9
            @Override // com.mopub.mobileads.C0223.InterfaceC0224
            public void onVastWebViewClick() {
                TrackingRequest.makeVastTrackingHttpRequest(c0244.m1116(), null, Integer.valueOf(VastVideoViewController.this.m969()), VastVideoViewController.this.m961(), context);
                c0244.m1111(VastVideoViewController.this.m731(), (String) null, VastVideoViewController.this.f1112.getDspCreativeId());
            }
        });
        m1028.setWebViewClient(new WebViewClient() { // from class: com.mopub.mobileads.VastVideoViewController.10
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                c0244.m1111(VastVideoViewController.this.m731(), str, VastVideoViewController.this.f1112.getDspCreativeId());
                return true;
            }
        });
        m1028.setVisibility(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.asIntPixels(c0244.m1109(), context), Dips.asIntPixels(c0244.m1112(), context));
        layoutParams.setMargins(Dips.dipsToIntPixels(12.0f, context), Dips.dipsToIntPixels(12.0f, context), 0, 0);
        getLayout().addView(m1028, layoutParams);
        this.f1114.registerVideoObstruction(m1028);
        return m1028;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢠ */
    public void mo718() {
        BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener;
        int i;
        super.mo718();
        switch (this.f1112.getCustomForceOrientation()) {
            case FORCE_PORTRAIT:
                baseVideoViewControllerListener = m730();
                i = 1;
                break;
            case FORCE_LANDSCAPE:
                baseVideoViewControllerListener = m730();
                i = 6;
                break;
            case DEVICE_ORIENTATION:
            case UNDEFINED:
            default:
                this.f1112.handleImpression(m731(), m969());
                m722(IntentActions.ACTION_INTERSTITIAL_SHOW);
        }
        baseVideoViewControllerListener.onSetRequestedOrientation(i);
        this.f1112.handleImpression(m731(), m969());
        m722(IntentActions.ACTION_INTERSTITIAL_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m966(int i) {
        if (this.f1123 == null || i < this.f1123.m1113()) {
            return;
        }
        this.f1098.setVisibility(0);
        this.f1123.m1110(m731(), i, m961());
        if (this.f1123.m1114() != null && i >= this.f1123.m1113() + this.f1123.m1114().intValue()) {
            this.f1098.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢠ */
    public void mo719(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m730().onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢠ */
    public void mo720(Configuration configuration) {
        View view;
        int i = m731().getResources().getConfiguration().orientation;
        this.f1122 = this.f1112.getVastCompanionAd(i);
        if (this.f1093.getVisibility() == 0 || this.f1094.getVisibility() == 0) {
            if (i == 1) {
                this.f1093.setVisibility(4);
                view = this.f1094;
            } else {
                this.f1094.setVisibility(4);
                view = this.f1093;
            }
            view.setVisibility(0);
            if (this.f1122 != null) {
                this.f1122.m871(m731(), this.f1110);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢠ */
    public void mo721(@NonNull Bundle bundle) {
        bundle.putInt("current_position", this.f1104);
        bundle.putSerializable("resumed_vast_config", this.f1112);
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢢ */
    protected VideoView mo724() {
        return this.f1113;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m967(@NonNull String str) {
        this.f1114.recordVideoEvent((ExternalViewabilitySession.VideoEvent) Enum.valueOf(ExternalViewabilitySession.VideoEvent.class, str), m969());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢣ */
    public void mo726() {
        m929();
        this.f1104 = m969();
        this.f1113.pause();
        if (this.f1105 || this.f1111) {
            return;
        }
        this.f1114.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_PAUSED, m969());
        this.f1112.handlePause(m731(), this.f1104);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢤ */
    public void mo727() {
        m927();
        if (this.f1104 > 0) {
            this.f1114.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_PLAYING, this.f1104);
            this.f1113.seekTo(this.f1104);
        } else {
            this.f1114.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_LOADED, m969());
        }
        if (!this.f1105) {
            this.f1113.start();
        }
        if (this.f1104 != -1) {
            this.f1112.handleResume(m731(), this.f1104);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢥ */
    public void mo728() {
        m929();
        this.f1114.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_STOPPED, m969());
        this.f1114.endVideoSession();
        m722(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        this.f1113.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢦ */
    public void mo729() {
        if (this.f1105) {
            return;
        }
        this.f1114.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_SKIPPED, m969());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢩ  reason: contains not printable characters */
    public int m968() {
        return this.f1113.getDuration();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢪ  reason: contains not printable characters */
    public int m969() {
        return this.f1113.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢫ  reason: contains not printable characters */
    public void m970() {
        this.f1103 = true;
        this.f1119.setVisibility(8);
        this.f1121.setVisibility(0);
        this.f1120.m914();
        this.f1097.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢬ  reason: contains not printable characters */
    public boolean m971() {
        return !this.f1103 && m969() >= this.f1102;
    }
}
