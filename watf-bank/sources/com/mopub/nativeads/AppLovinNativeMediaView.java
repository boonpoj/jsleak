package com.mopub.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ࢠ.ࢠ.C0323;
/* loaded from: assets/classes2.dex */
public class AppLovinNativeMediaView extends FrameLayout implements TextureView.SurfaceTextureListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String f1457 = "AppLovinNativeMediaView";

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static boolean f1458 = false;

    /* renamed from: ֏  reason: contains not printable characters */
    private AppLovinNativeVideoState f1459;

    /* renamed from: ؠ  reason: contains not printable characters */
    private boolean f1460;

    /* renamed from: ހ  reason: contains not printable characters */
    private boolean f1461;

    /* renamed from: ށ  reason: contains not printable characters */
    private boolean f1462;

    /* renamed from: ނ  reason: contains not printable characters */
    private MediaPlayer f1463;

    /* renamed from: ރ  reason: contains not printable characters */
    private Surface f1464;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private AppLovinSdk f1465;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private AppLovinNativeAd f1466;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Handler f1467;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f1468;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private ImageView f1469;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private ViewGroup f1470;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private ViewGroup f1471;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private ViewGroup f1472;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private ImageView f1473;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private AspectRatioTextureView f1474;

    /* loaded from: assets/classes2.dex */
    public static class AppLovinNativeVideoState {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private boolean f1490;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private boolean f1491;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private boolean f1492;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private boolean f1493;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private boolean f1495;

        /* renamed from: ࢧ  reason: contains not printable characters */
        private boolean f1496;

        /* renamed from: ࢨ  reason: contains not printable characters */
        private int f1497;

        /* renamed from: ࢩ  reason: contains not printable characters */
        private boolean f1498;

        /* renamed from: ࢪ  reason: contains not printable characters */
        private MuteState f1499 = MuteState.UNSPECIFIED;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private boolean f1494 = true;

        /* loaded from: assets/classes2.dex */
        public enum MuteState {
            UNSPECIFIED,
            UNMUTED,
            MUTED
        }

        public int getLastMediaPlayerPosition() {
            return this.f1497;
        }

        public MuteState getMuteState() {
            return this.f1499;
        }

        public boolean isCurrentlyActive() {
            return this.f1496;
        }

        public boolean isFirstPlay() {
            return this.f1494;
        }

        public boolean isImpressionTracked() {
            return this.f1492;
        }

        public boolean isPreviouslyActivated() {
            return this.f1495;
        }

        public boolean isReplayOverlayVisible() {
            return this.f1498;
        }

        public boolean isVideoCompleted() {
            return this.f1491;
        }

        public boolean isVideoStartTracked() {
            return this.f1493;
        }

        public boolean isVideoStarted() {
            return this.f1490;
        }

        public void setCurrentlyActive(boolean z) {
            this.f1496 = z;
        }

        public void setFirstPlay(boolean z) {
            this.f1494 = z;
        }

        public void setImpressionTracked(boolean z) {
            this.f1492 = z;
        }

        public void setLastMediaPlayerPosition(int i) {
            this.f1497 = i;
        }

        public void setMuteState(MuteState muteState) {
            this.f1499 = muteState;
        }

        public void setPreviouslyActivated(boolean z) {
            this.f1495 = z;
        }

        public void setReplayOverlayVisible(boolean z) {
            this.f1498 = z;
        }

        public void setVideoCompleted(boolean z) {
            this.f1491 = z;
        }

        public void setVideoStartTracked(boolean z) {
            this.f1493 = z;
        }

        public void setVideoStarted(boolean z) {
            this.f1490 = z;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class AspectRatioTextureView extends TextureView {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private int f1501;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private int f1502;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private OnMeasureCompletionListener f1503;

        /* loaded from: assets/classes2.dex */
        public interface OnMeasureCompletionListener {
            void onMeasureCompleted(int i, int i2);
        }

        public AspectRatioTextureView(Context context) {
            super(context);
            this.f1501 = 0;
            this.f1502 = 0;
        }

        public AspectRatioTextureView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1501 = 0;
            this.f1502 = 0;
        }

        public AspectRatioTextureView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1501 = 0;
            this.f1502 = 0;
        }

        public OnMeasureCompletionListener getOnMeasureCompletionListener() {
            return this.f1503;
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int ceil;
            int ceil2;
            if (this.f1501 <= 0 || this.f1502 <= 0) {
                super.onMeasure(i, i2);
                return;
            }
            float height = this.f1502 / getHeight();
            float width = this.f1501 / getWidth();
            if (height > width) {
                ceil = (int) Math.ceil(this.f1502 / height);
                ceil2 = (int) Math.ceil(this.f1501 / height);
            } else {
                ceil = (int) Math.ceil(this.f1502 / width);
                ceil2 = (int) Math.ceil(this.f1501 / width);
            }
            setMeasuredDimension(ceil2, ceil);
            if (this.f1503 != null) {
                this.f1503.onMeasureCompleted(ceil2, ceil);
            }
        }

        public void setOnMeasureCompletionListener(OnMeasureCompletionListener onMeasureCompletionListener) {
            this.f1503 = onMeasureCompletionListener;
        }

        public void setVideoSize(int i, int i2) {
            this.f1501 = i;
            this.f1502 = i2;
            try {
                requestLayout();
                invalidate();
            } catch (Exception unused) {
            }
        }
    }

    public AppLovinNativeMediaView(Context context) {
        super(context);
        this.f1468 = false;
    }

    public AppLovinNativeMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1468 = false;
    }

    public AppLovinNativeMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1468 = false;
    }

    public AppLovinNativeMediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1468 = false;
    }

    private void setAppropriateMuteImage(boolean z) {
        AppLovinSdkUtils.safePopulateImageView(getContext(), this.f1473, z ? C0323.C0324.applovin_native_video_muted : C0323.C0324.applovin_native_video_unmuted, 50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public int m1273(MediaPlayer mediaPlayer) {
        float currentPosition;
        float duration = mediaPlayer.getDuration();
        if (mediaPlayer.getCurrentPosition() >= duration) {
            return 100;
        }
        return (int) Math.ceil((currentPosition / duration) * 100.0f);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Bitmap m1275(int i) {
        if (this.f1466.getVideoUrl() == null) {
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(getContext(), Uri.parse(this.f1466.getVideoUrl()));
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(i);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(frameAtTime, this.f1474.getWidth(), this.f1474.getHeight(), false);
            frameAtTime.recycle();
            return createScaledBitmap;
        } catch (Exception unused) {
            return null;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1276(AppLovinNativeVideoState.MuteState muteState, boolean z) {
        this.f1459.setMuteState(muteState);
        final boolean equals = muteState.equals(AppLovinNativeVideoState.MuteState.MUTED);
        setAppropriateMuteImage(equals);
        if (!z) {
            if (this.f1463 != null) {
                float f = equals ? 0.0f : 1.0f;
                this.f1463.setVolume(f, f);
                return;
            }
            return;
        }
        int i = 0;
        while (true) {
            float f2 = i;
            if (f2 >= 10.0f) {
                this.f1467.postDelayed(new Runnable() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AppLovinNativeMediaView.this.f1463 != null) {
                            float f3 = equals ? 0.0f : 1.0f;
                            AppLovinNativeMediaView.this.f1463.setVolume(f3, f3);
                        }
                    }
                }, 200L);
                return;
            }
            if (equals) {
                f2 = 10.0f - f2;
            }
            final float f3 = f2 / 10.0f;
            this.f1467.postDelayed(new Runnable() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AppLovinNativeMediaView.this.f1463 != null) {
                        AppLovinNativeMediaView.this.f1463.setVolume(f3, f3);
                    }
                }
            }, i * 20);
            i++;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m1280() {
        this.f1469 = (ImageView) findViewById(C0323.C0325.applovin_native_image);
        this.f1470 = (ViewGroup) findViewById(C0323.C0325.applovin_native_video_overlay);
        this.f1471 = (ViewGroup) findViewById(C0323.C0325.applovin_native_video_replay_layout);
        this.f1472 = (ViewGroup) findViewById(C0323.C0325.applovin_native_video_learn_more_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1281(int i) {
        if (this.f1459.isVideoStarted()) {
            this.f1465.getPostbackService().dispatchPostbackAsync(this.f1466.getVideoEndTrackingUrl(i, this.f1459.isFirstPlay()), (AppLovinPostbackListener) null);
            this.f1459.setFirstPlay(false);
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m1284() {
        if (this.f1468) {
            return;
        }
        this.f1468 = true;
        setBackgroundColor(getResources().getColor(17170444));
        if (this.f1466.isVideoPrecached()) {
            m1295();
        }
        AppLovinSdkUtils.safePopulateImageView(this.f1469, Uri.parse(this.f1466.getImageUrl()), AppLovinSdkUtils.dpToPx(getContext(), 350));
        this.f1473 = new ImageView(getContext());
        int dpToPx = AppLovinSdkUtils.dpToPx(getContext(), 20);
        AppLovinSdkUtils.dpToPx(getContext(), 20);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.gravity = 83;
        this.f1473.setLayoutParams(layoutParams);
        this.f1473.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppLovinNativeMediaView.this.m1286();
            }
        });
        setAppropriateMuteImage(f1458);
        this.f1470.setVisibility(this.f1459.isReplayOverlayVisible() ? 0 : 8);
        this.f1471.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppLovinNativeMediaView.this.m1290();
            }
        });
        this.f1472.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppLovinNativeMediaView.this.f1466.launchClickTarget(AppLovinNativeMediaView.this.getContext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m1286() {
        m1276(this.f1459.getMuteState().equals(AppLovinNativeVideoState.MuteState.UNMUTED) ? AppLovinNativeVideoState.MuteState.MUTED : AppLovinNativeVideoState.MuteState.UNMUTED, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public void m1288() {
        this.f1459.setLastMediaPlayerPosition(0);
        this.f1459.setReplayOverlayVisible(true);
        m1295();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        this.f1470.setVisibility(0);
        this.f1470.startAnimation(alphaAnimation);
        this.f1474.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢦ  reason: contains not printable characters */
    public void m1290() {
        this.f1470.setVisibility(4);
        this.f1459.setReplayOverlayVisible(false);
        if (this.f1474 != null) {
            this.f1474.setVisibility(0);
            playVideo(null);
            return;
        }
        this.f1461 = true;
        createVideo();
    }

    public void autoplayVideo() {
        if (AppLovinSdkUtils.isValidString(this.f1466.getVideoUrl()) && !this.f1459.isReplayOverlayVisible() && this.f1466.isVideoPrecached()) {
            if (this.f1463 != null && this.f1462 && !this.f1463.isPlaying()) {
                playVideo(this.f1463);
                return;
            }
            this.f1461 = true;
            createVideo();
        }
    }

    public void createVideo() {
        if (!AppLovinSdkUtils.isValidString(this.f1466.getVideoUrl()) || this.f1460) {
            return;
        }
        this.f1460 = true;
        this.f1474 = new AspectRatioTextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f1474.setLayoutParams(layoutParams);
        this.f1474.setSurfaceTextureListener(this);
        this.f1474.setOnMeasureCompletionListener(new AspectRatioTextureView.OnMeasureCompletionListener() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.10
            @Override // com.mopub.nativeads.AppLovinNativeMediaView.AspectRatioTextureView.OnMeasureCompletionListener
            public void onMeasureCompleted(int i, int i2) {
                int width = this.getWidth() - i;
                int height = this.getHeight() - i2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) AppLovinNativeMediaView.this.f1473.getLayoutParams();
                int dpToPx = AppLovinSdkUtils.dpToPx(AppLovinNativeMediaView.this.getContext(), 5);
                layoutParams2.leftMargin = (width / 2) + dpToPx;
                layoutParams2.bottomMargin = (height / 2) + dpToPx;
            }
        });
        addView(this.f1474);
        bringChildToFront(this.f1474);
        addView(this.f1473);
        bringChildToFront(this.f1473);
        invalidate();
        requestLayout();
        if (this.f1474.isAvailable()) {
            onSurfaceTextureAvailable(this.f1474.getSurfaceTexture(), this.f1474.getWidth(), this.f1474.getHeight());
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f1463 == null) {
            try {
                this.f1463 = new MediaPlayer();
                this.f1463.setDataSource(getContext(), Uri.parse(this.f1466.getVideoUrl()));
                this.f1464 = new Surface(surfaceTexture);
                this.f1463.setSurface(this.f1464);
                this.f1463.prepareAsync();
                this.f1463.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.11
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            AppLovinNativeMediaView.this.f1462 = true;
                            AppLovinNativeMediaView.this.f1474.setVideoSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                            int lastMediaPlayerPosition = AppLovinNativeMediaView.this.f1459.getLastMediaPlayerPosition();
                            if (lastMediaPlayerPosition > 0) {
                                mediaPlayer.seekTo(lastMediaPlayerPosition);
                            } else if (!AppLovinNativeMediaView.this.f1461 || AppLovinNativeMediaView.this.f1459.isReplayOverlayVisible()) {
                                return;
                            }
                            AppLovinNativeMediaView.this.playVideo(mediaPlayer);
                        } catch (Exception unused) {
                        }
                    }
                });
                this.f1463.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.2
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        int m1273 = AppLovinNativeMediaView.this.m1273(mediaPlayer);
                        if (m1273 == 0) {
                            m1273 = 100;
                        }
                        if (m1273 >= 98) {
                            AppLovinNativeMediaView.this.setBackgroundColor(AppLovinNativeMediaView.this.getResources().getColor(17170444));
                            AppLovinNativeMediaView.this.f1459.setVideoCompleted(true);
                            AppLovinNativeMediaView.this.m1288();
                        }
                        AppLovinNativeMediaView.this.m1281(m1273);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation.setDuration(500L);
                        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.2.1
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                AppLovinNativeMediaView.this.f1473.setVisibility(4);
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                            }
                        });
                        AppLovinNativeMediaView.this.f1473.startAnimation(alphaAnimation);
                    }
                });
                this.f1463.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.3
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i3, int i4) {
                        return true;
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void playVideo(MediaPlayer mediaPlayer) {
        setBackgroundColor(getResources().getColor(17170444));
        this.f1470.setVisibility(8);
        this.f1459.setReplayOverlayVisible(false);
        if (mediaPlayer == null) {
            mediaPlayer = this.f1463;
        }
        if (AppLovinSdkUtils.isValidString(this.f1466.getVideoUrl())) {
            m1276(this.f1459.getMuteState().equals(AppLovinNativeVideoState.MuteState.UNSPECIFIED) ? f1458 ? AppLovinNativeVideoState.MuteState.MUTED : AppLovinNativeVideoState.MuteState.UNMUTED : this.f1459.getMuteState(), false);
            mediaPlayer.start();
            if (!this.f1459.isVideoStarted()) {
                this.f1459.setVideoStarted(true);
                this.f1465.getPostbackService().dispatchPostbackAsync(this.f1466.getVideoStartTrackingUrl(), (AppLovinPostbackListener) null);
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.8
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    AppLovinNativeMediaView.this.f1473.setVisibility(0);
                }
            });
            this.f1473.startAnimation(alphaAnimation);
            if (this.f1469.getVisibility() == 0) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(this.f1469.getAlpha(), 0.0f);
                alphaAnimation2.setDuration(750L);
                alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.mopub.nativeads.AppLovinNativeMediaView.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        AppLovinNativeMediaView.this.f1469.setVisibility(4);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                this.f1469.startAnimation(alphaAnimation2);
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation3.setDuration(500L);
                this.f1474.startAnimation(alphaAnimation3);
            }
        }
    }

    public void setAd(AppLovinNativeAd appLovinNativeAd) {
        this.f1466 = appLovinNativeAd;
    }

    public void setSdk(AppLovinSdk appLovinSdk) {
        this.f1465 = appLovinSdk;
    }

    public void setUiHandler(Handler handler) {
        this.f1467 = handler;
    }

    public void setUpView() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C0323.C0326.applovin_native_media_view, (ViewGroup) this, true);
        m1280();
        m1284();
    }

    public void setVideoState(AppLovinNativeVideoState appLovinNativeVideoState) {
        this.f1459 = appLovinNativeVideoState;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1295() {
        Bitmap m1275 = m1275(Math.max(200, this.f1459.getLastMediaPlayerPosition()));
        if (m1275 != null) {
            this.f1469.setImageBitmap(m1275);
        }
    }
}
