package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.nativeads.NativeFullScreenVideoView;
import com.mopub.nativeads.NativeVideoController;
/* loaded from: assets/classes2.dex */
public class NativeVideoViewController extends BaseVideoViewController implements AudioManager.OnAudioFocusChangeListener, TextureView.SurfaceTextureListener, NativeVideoController.Listener {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private EnumC0275 f1829;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private VastVideoConfig f1830;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final NativeFullScreenVideoView f1831;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final NativeVideoController f1832;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Bitmap f1833;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f1834;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f1835;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private int f1836;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.nativeads.NativeVideoViewController$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0275 {
        NONE,
        LOADING,
        BUFFERING,
        PAUSED,
        PLAYING,
        ENDED,
        FAILED_LOAD
    }

    public NativeVideoViewController(@NonNull Context context, @NonNull Bundle bundle, @NonNull Bundle bundle2, @NonNull BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener) {
        this(context, bundle, bundle2, baseVideoViewControllerListener, new NativeFullScreenVideoView(context, context.getResources().getConfiguration().orientation, ((VastVideoConfig) bundle.get(Constants.NATIVE_VAST_VIDEO_CONFIG)).getCustomCtaText()));
    }

    @VisibleForTesting
    NativeVideoViewController(@NonNull Context context, @NonNull Bundle bundle, @NonNull Bundle bundle2, @NonNull BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener, @NonNull NativeFullScreenVideoView nativeFullScreenVideoView) {
        super(context, null, baseVideoViewControllerListener);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotNull(baseVideoViewControllerListener);
        Preconditions.checkNotNull(nativeFullScreenVideoView);
        this.f1829 = EnumC0275.NONE;
        this.f1830 = (VastVideoConfig) bundle.get(Constants.NATIVE_VAST_VIDEO_CONFIG);
        this.f1831 = nativeFullScreenVideoView;
        this.f1832 = NativeVideoController.getForId(((Long) bundle.get(Constants.NATIVE_VIDEO_ID)).longValue());
        Preconditions.checkNotNull(this.f1830);
        Preconditions.checkNotNull(this.f1832);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
        if (r3.f1836 != 5) goto L4;
     */
    /* renamed from: ࢩ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m1469() {
        /*
            r3 = this;
            com.mopub.nativeads.NativeVideoViewController$ࢠ r0 = r3.f1829
            boolean r1 = r3.f1835
            if (r1 == 0) goto L9
            com.mopub.nativeads.NativeVideoViewController$ࢠ r0 = com.mopub.nativeads.NativeVideoViewController.EnumC0275.FAILED_LOAD
            goto L33
        L9:
            boolean r1 = r3.f1834
            if (r1 == 0) goto L10
        Ld:
            com.mopub.nativeads.NativeVideoViewController$ࢠ r0 = com.mopub.nativeads.NativeVideoViewController.EnumC0275.ENDED
            goto L33
        L10:
            int r1 = r3.f1836
            r2 = 1
            if (r1 != r2) goto L18
            com.mopub.nativeads.NativeVideoViewController$ࢠ r0 = com.mopub.nativeads.NativeVideoViewController.EnumC0275.LOADING
            goto L33
        L18:
            int r1 = r3.f1836
            r2 = 2
            if (r1 != r2) goto L20
            com.mopub.nativeads.NativeVideoViewController$ࢠ r0 = com.mopub.nativeads.NativeVideoViewController.EnumC0275.BUFFERING
            goto L33
        L20:
            int r1 = r3.f1836
            r2 = 3
            if (r1 != r2) goto L28
            com.mopub.nativeads.NativeVideoViewController$ࢠ r0 = com.mopub.nativeads.NativeVideoViewController.EnumC0275.PLAYING
            goto L33
        L28:
            int r1 = r3.f1836
            r2 = 4
            if (r1 == r2) goto Ld
            int r1 = r3.f1836
            r2 = 5
            if (r1 != r2) goto L33
            goto Ld
        L33:
            r3.m1470(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.nativeads.NativeVideoViewController.m1469():void");
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (i == -1 || i == -2) {
            m1470(EnumC0275.PAUSED);
        } else if (i == -3) {
            this.f1832.setAudioVolume(0.3f);
        } else if (i == 1) {
            this.f1832.setAudioVolume(1.0f);
            m1469();
        }
    }

    @Override // com.mopub.nativeads.NativeVideoController.Listener
    public void onError(Exception exc) {
        MoPubLog.w("Error playing back video.", exc);
        this.f1835 = true;
        m1469();
    }

    @Override // com.mopub.nativeads.NativeVideoController.Listener
    public void onStateChanged(boolean z, int i) {
        this.f1836 = i;
        m1469();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f1832.setTextureView(this.f1831.getTextureView());
        if (!this.f1834) {
            this.f1832.seekTo(this.f1832.getCurrentPosition());
        }
        this.f1832.setPlayWhenReady(!this.f1834);
        if (this.f1832.getDuration() - this.f1832.getCurrentPosition() < 750) {
            this.f1834 = true;
            m1469();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f1832.release(this);
        m1470(EnumC0275.PAUSED);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢠ */
    public void mo718() {
        this.f1831.setSurfaceTextureListener(this);
        this.f1831.setMode(NativeFullScreenVideoView.Mode.LOADING);
        this.f1831.setPlayControlClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.NativeVideoViewController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NativeVideoViewController.this.f1834) {
                    NativeVideoViewController.this.f1834 = false;
                    NativeVideoViewController.this.f1831.resetProgress();
                    NativeVideoViewController.this.f1832.seekTo(0L);
                }
                NativeVideoViewController.this.m1470(EnumC0275.PLAYING);
            }
        });
        this.f1831.setCloseControlListener(new View.OnClickListener() { // from class: com.mopub.nativeads.NativeVideoViewController.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NativeVideoViewController.this.m1471(EnumC0275.PAUSED, true);
                NativeVideoViewController.this.m730().onFinish();
            }
        });
        this.f1831.setCtaClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.NativeVideoViewController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NativeVideoViewController.this.f1832.setPlayWhenReady(false);
                NativeVideoViewController.this.f1833 = NativeVideoViewController.this.f1831.getTextureView().getBitmap();
                NativeVideoViewController.this.f1832.handleCtaClick((Activity) NativeVideoViewController.this.m731());
            }
        });
        this.f1831.setPrivacyInformationClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.NativeVideoViewController.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NativeVideoViewController.this.f1832.setPlayWhenReady(false);
                NativeVideoViewController.this.f1833 = NativeVideoViewController.this.f1831.getTextureView().getBitmap();
                String privacyInformationIconClickthroughUrl = NativeVideoViewController.this.f1830.getPrivacyInformationIconClickthroughUrl();
                if (TextUtils.isEmpty(privacyInformationIconClickthroughUrl)) {
                    privacyInformationIconClickthroughUrl = "https://www.mopub.com/optout/";
                }
                new UrlHandler.Builder().withSupportedUrlActions(UrlAction.OPEN_IN_APP_BROWSER, new UrlAction[0]).build().handleUrl(NativeVideoViewController.this.m731(), privacyInformationIconClickthroughUrl);
            }
        });
        this.f1831.setPrivacyInformationIconImageUrl(this.f1830.getPrivacyInformationIconImageUrl());
        this.f1831.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        m730().onSetContentView(this.f1831);
        this.f1832.setProgressListener(new NativeVideoController.NativeVideoProgressRunnable.ProgressListener() { // from class: com.mopub.nativeads.NativeVideoViewController.5
            @Override // com.mopub.nativeads.NativeVideoController.NativeVideoProgressRunnable.ProgressListener
            public void updateProgress(int i) {
                NativeVideoViewController.this.f1831.updateProgress(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢠ */
    public void mo720(Configuration configuration) {
        this.f1831.setOrientation(configuration.orientation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢠ */
    public void mo721(@NonNull Bundle bundle) {
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1470(@NonNull EnumC0275 enumC0275) {
        m1471(enumC0275, false);
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1471(@NonNull EnumC0275 enumC0275, boolean z) {
        NativeFullScreenVideoView nativeFullScreenVideoView;
        NativeFullScreenVideoView.Mode mode;
        Preconditions.checkNotNull(enumC0275);
        if (this.f1829 == enumC0275) {
            return;
        }
        switch (enumC0275) {
            case FAILED_LOAD:
                this.f1832.setPlayWhenReady(false);
                this.f1832.setAudioEnabled(false);
                this.f1832.setAppAudioEnabled(false);
                this.f1831.setMode(NativeFullScreenVideoView.Mode.LOADING);
                this.f1830.handleError(m731(), null, 0);
                break;
            case LOADING:
            case BUFFERING:
                this.f1832.setPlayWhenReady(true);
                nativeFullScreenVideoView = this.f1831;
                mode = NativeFullScreenVideoView.Mode.LOADING;
                nativeFullScreenVideoView.setMode(mode);
                break;
            case PLAYING:
                this.f1832.setPlayWhenReady(true);
                this.f1832.setAudioEnabled(true);
                this.f1832.setAppAudioEnabled(true);
                nativeFullScreenVideoView = this.f1831;
                mode = NativeFullScreenVideoView.Mode.PLAYING;
                nativeFullScreenVideoView.setMode(mode);
                break;
            case PAUSED:
                if (!z) {
                    this.f1832.setAppAudioEnabled(false);
                }
                this.f1832.setPlayWhenReady(false);
                nativeFullScreenVideoView = this.f1831;
                mode = NativeFullScreenVideoView.Mode.PAUSED;
                nativeFullScreenVideoView.setMode(mode);
                break;
            case ENDED:
                this.f1834 = true;
                this.f1832.setAppAudioEnabled(false);
                this.f1831.updateProgress(1000);
                this.f1831.setMode(NativeFullScreenVideoView.Mode.FINISHED);
                this.f1830.handleComplete(m731(), 0);
                break;
        }
        this.f1829 = enumC0275;
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢢ */
    protected VideoView mo724() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢣ */
    public void mo726() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢤ */
    public void mo727() {
        if (this.f1833 != null) {
            this.f1831.setCachedVideoFrame(this.f1833);
        }
        this.f1832.prepare(this);
        this.f1832.setListener(this);
        this.f1832.setOnAudioFocusChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢥ */
    public void mo728() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoViewController
    /* renamed from: ࢦ */
    public void mo729() {
        m1471(EnumC0275.PAUSED, true);
    }
}
