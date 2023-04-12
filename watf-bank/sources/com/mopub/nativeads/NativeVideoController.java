package com.mopub.nativeads;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.RepeatingHandlerRunnable;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.network.TrackingRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class NativeVideoController extends Player.DefaultEventListener implements AudioManager.OnAudioFocusChangeListener {
    public static final long RESUME_FINISHED_THRESHOLD = 750;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_CLEARED = 5;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final Map<Long, NativeVideoController> f1790 = new HashMap(4);
    @Nullable

    /* renamed from: ֏  reason: contains not printable characters */
    private volatile ExoPlayer f1791;
    @Nullable

    /* renamed from: ؠ  reason: contains not printable characters */
    private BitmapDrawable f1792;
    @Nullable

    /* renamed from: ހ  reason: contains not printable characters */
    private MediaCodecAudioRenderer f1793;
    @Nullable

    /* renamed from: ށ  reason: contains not printable characters */
    private MediaCodecVideoRenderer f1794;

    /* renamed from: ނ  reason: contains not printable characters */
    private boolean f1795;

    /* renamed from: ރ  reason: contains not printable characters */
    private boolean f1796;

    /* renamed from: ބ  reason: contains not printable characters */
    private boolean f1797;

    /* renamed from: ޅ  reason: contains not printable characters */
    private int f1798;

    /* renamed from: ކ  reason: contains not printable characters */
    private boolean f1799;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Context f1800;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Handler f1801;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final C0272 f1802;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private VastVideoConfig f1803;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private NativeVideoProgressRunnable f1804;
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private AudioManager f1805;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private Listener f1806;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private AudioManager.OnAudioFocusChangeListener f1807;
    @Nullable

    /* renamed from: ࢪ  reason: contains not printable characters */
    private Surface f1808;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private TextureView f1809;
    @Nullable

    /* renamed from: ࢬ  reason: contains not printable characters */
    private WeakReference<Object> f1810;

    /* loaded from: assets/classes2.dex */
    public interface Listener {
        void onError(Exception exc);

        void onStateChanged(boolean z, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: assets/classes2.dex */
    public static class NativeVideoProgressRunnable extends RepeatingHandlerRunnable {
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final Context f1813;
        @NonNull

        /* renamed from: ࢤ  reason: contains not printable characters */
        private final VisibilityTracker.VisibilityChecker f1814;
        @NonNull

        /* renamed from: ࢥ  reason: contains not printable characters */
        private final List<C0273> f1815;
        @NonNull

        /* renamed from: ࢦ  reason: contains not printable characters */
        private final VastVideoConfig f1816;
        @Nullable

        /* renamed from: ࢧ  reason: contains not printable characters */
        private ExoPlayer f1817;
        @Nullable

        /* renamed from: ࢨ  reason: contains not printable characters */
        private TextureView f1818;
        @Nullable

        /* renamed from: ࢩ  reason: contains not printable characters */
        private ProgressListener f1819;

        /* renamed from: ࢪ  reason: contains not printable characters */
        private long f1820;

        /* renamed from: ࢫ  reason: contains not printable characters */
        private long f1821;

        /* renamed from: ࢬ  reason: contains not printable characters */
        private boolean f1822;

        /* loaded from: assets/classes2.dex */
        public interface ProgressListener {
            void updateProgress(int i);
        }

        @VisibleForTesting
        NativeVideoProgressRunnable(@NonNull Context context, @NonNull Handler handler, @NonNull List<C0273> list, @NonNull VisibilityTracker.VisibilityChecker visibilityChecker, @NonNull VastVideoConfig vastVideoConfig) {
            super(handler);
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(handler);
            Preconditions.checkNotNull(list);
            Preconditions.checkNotNull(vastVideoConfig);
            this.f1813 = context.getApplicationContext();
            this.f1815 = list;
            this.f1814 = visibilityChecker;
            this.f1816 = vastVideoConfig;
            this.f1821 = -1L;
            this.f1822 = false;
        }

        NativeVideoProgressRunnable(@NonNull Context context, @NonNull Handler handler, @NonNull List<C0273> list, @NonNull VastVideoConfig vastVideoConfig) {
            this(context, handler, list, new VisibilityTracker.VisibilityChecker(), vastVideoConfig);
        }

        @Override // com.mopub.mobileads.RepeatingHandlerRunnable
        public void doWork() {
            if (this.f1817 == null || !this.f1817.getPlayWhenReady()) {
                return;
            }
            this.f1820 = this.f1817.getCurrentPosition();
            this.f1821 = this.f1817.getDuration();
            m1457(false);
            if (this.f1819 != null) {
                this.f1819.updateProgress((int) ((((float) this.f1820) / ((float) this.f1821)) * 1000.0f));
            }
            List<VastTracker> untriggeredTrackersBefore = this.f1816.getUntriggeredTrackersBefore((int) this.f1820, (int) this.f1821);
            if (untriggeredTrackersBefore.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (VastTracker vastTracker : untriggeredTrackersBefore) {
                if (!vastTracker.isTracked()) {
                    arrayList.add(vastTracker.getContent());
                    vastTracker.setTracked();
                }
            }
            TrackingRequest.makeTrackingHttpRequest(arrayList, this.f1813);
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        long m1452() {
            return this.f1820;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1453(long j) {
            this.f1820 = j;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1454(@Nullable TextureView textureView) {
            this.f1818 = textureView;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1455(@Nullable ExoPlayer exoPlayer) {
            this.f1817 = exoPlayer;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1456(@Nullable ProgressListener progressListener) {
            this.f1819 = progressListener;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1457(boolean z) {
            int i = 0;
            for (C0273 c0273 : this.f1815) {
                if (!c0273.f1827) {
                    if (z || this.f1814.isVisible(this.f1818, this.f1818, c0273.f1824, c0273.f1828)) {
                        c0273.f1826 = (int) (c0273.f1826 + this.f958);
                        if (z || c0273.f1826 >= c0273.f1825) {
                            c0273.f1823.execute();
                            c0273.f1827 = true;
                        }
                    }
                }
                i++;
            }
            if (i == this.f1815.size() && this.f1822) {
                stop();
            }
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        long m1458() {
            return this.f1821;
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        void m1459() {
            this.f1822 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.NativeVideoController$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0272 {
        C0272() {
        }

        public ExoPlayer newInstance(@NonNull Renderer[] rendererArr, @NonNull TrackSelector trackSelector, @Nullable LoadControl loadControl) {
            return ExoPlayerFactory.newInstance(rendererArr, trackSelector, loadControl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.nativeads.NativeVideoController$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0273 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        InterfaceC0274 f1823;

        /* renamed from: ࢢ  reason: contains not printable characters */
        int f1824;

        /* renamed from: ࢣ  reason: contains not printable characters */
        int f1825;

        /* renamed from: ࢤ  reason: contains not printable characters */
        int f1826;

        /* renamed from: ࢥ  reason: contains not printable characters */
        boolean f1827;

        /* renamed from: ࢦ  reason: contains not printable characters */
        Integer f1828;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.nativeads.NativeVideoController$ࢢ$ࢠ  reason: contains not printable characters */
        /* loaded from: assets/classes2.dex */
        public interface InterfaceC0274 {
            void execute();
        }
    }

    private NativeVideoController(@NonNull Context context, @NonNull VastVideoConfig vastVideoConfig, @NonNull NativeVideoProgressRunnable nativeVideoProgressRunnable, @NonNull C0272 c0272, @NonNull AudioManager audioManager) {
        this.f1798 = 1;
        this.f1799 = true;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastVideoConfig);
        Preconditions.checkNotNull(c0272);
        Preconditions.checkNotNull(audioManager);
        this.f1800 = context.getApplicationContext();
        this.f1801 = new Handler(Looper.getMainLooper());
        this.f1803 = vastVideoConfig;
        this.f1804 = nativeVideoProgressRunnable;
        this.f1802 = c0272;
        this.f1805 = audioManager;
    }

    private NativeVideoController(@NonNull Context context, @NonNull List<C0273> list, @NonNull VastVideoConfig vastVideoConfig) {
        this(context, vastVideoConfig, new NativeVideoProgressRunnable(context, new Handler(Looper.getMainLooper()), list, vastVideoConfig), new C0272(), (AudioManager) context.getSystemService("audio"));
    }

    @NonNull
    @VisibleForTesting
    public static NativeVideoController createForId(long j, @NonNull Context context, @NonNull VastVideoConfig vastVideoConfig, @NonNull NativeVideoProgressRunnable nativeVideoProgressRunnable, @NonNull C0272 c0272, @NonNull AudioManager audioManager) {
        NativeVideoController nativeVideoController = new NativeVideoController(context, vastVideoConfig, nativeVideoProgressRunnable, c0272, audioManager);
        f1790.put(Long.valueOf(j), nativeVideoController);
        return nativeVideoController;
    }

    @NonNull
    public static NativeVideoController createForId(long j, @NonNull Context context, @NonNull List<C0273> list, @NonNull VastVideoConfig vastVideoConfig) {
        NativeVideoController nativeVideoController = new NativeVideoController(context, list, vastVideoConfig);
        f1790.put(Long.valueOf(j), nativeVideoController);
        return nativeVideoController;
    }

    @Nullable
    public static NativeVideoController getForId(long j) {
        return f1790.get(Long.valueOf(j));
    }

    @Nullable
    public static NativeVideoController remove(long j) {
        return f1790.remove(Long.valueOf(j));
    }

    @VisibleForTesting
    public static void setForId(long j, @NonNull NativeVideoController nativeVideoController) {
        f1790.put(Long.valueOf(j), nativeVideoController);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1445(float f) {
        ExoPlayer exoPlayer = this.f1791;
        MediaCodecAudioRenderer mediaCodecAudioRenderer = this.f1793;
        if (exoPlayer == null || mediaCodecAudioRenderer == null) {
            return;
        }
        PlayerMessage createMessage = exoPlayer.createMessage(mediaCodecAudioRenderer);
        if (createMessage == null) {
            MoPubLog.d("ExoPlayer.createMessage returned null.");
        } else {
            createMessage.setType(2).setPayload(Float.valueOf(f)).send();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1446(@Nullable Surface surface) {
        ExoPlayer exoPlayer = this.f1791;
        MediaCodecVideoRenderer mediaCodecVideoRenderer = this.f1794;
        if (exoPlayer == null || mediaCodecVideoRenderer == null) {
            return;
        }
        PlayerMessage createMessage = exoPlayer.createMessage(mediaCodecVideoRenderer);
        if (createMessage == null) {
            MoPubLog.d("ExoPlayer.createMessage returned null.");
        } else {
            createMessage.setType(1).setPayload(surface).send();
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m1447() {
        if (this.f1791 == null) {
            return;
        }
        m1446((Surface) null);
        this.f1791.stop();
        this.f1791.release();
        this.f1791 = null;
        this.f1804.stop();
        this.f1804.m1455((ExoPlayer) null);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m1448() {
        if (this.f1791 == null) {
            this.f1794 = new MediaCodecVideoRenderer(this.f1800, MediaCodecSelector.DEFAULT, 0L, this.f1801, (VideoRendererEventListener) null, 10);
            this.f1793 = new MediaCodecAudioRenderer(this.f1800, MediaCodecSelector.DEFAULT);
            DefaultAllocator defaultAllocator = new DefaultAllocator(true, 65536, 32);
            DefaultLoadControl.Builder builder = new DefaultLoadControl.Builder();
            builder.setAllocator(defaultAllocator);
            this.f1791 = this.f1802.newInstance(new Renderer[]{this.f1794, this.f1793}, new DefaultTrackSelector(), builder.createDefaultLoadControl());
            this.f1804.m1455(this.f1791);
            this.f1791.addListener(this);
            DataSource.Factory factory = new DataSource.Factory() { // from class: com.mopub.nativeads.NativeVideoController.1
                public DataSource createDataSource() {
                    return new HttpDiskCompositeDataSource(NativeVideoController.this.f1800, "exo_demo");
                }
            };
            ExtractorsFactory extractorsFactory = new ExtractorsFactory() { // from class: com.mopub.nativeads.NativeVideoController.2
                public Extractor[] createExtractors() {
                    return new Extractor[]{new Mp4Extractor()};
                }
            };
            ExtractorMediaSource.Factory factory2 = new ExtractorMediaSource.Factory(factory);
            factory2.setExtractorsFactory(extractorsFactory);
            this.f1791.prepare(factory2.createMediaSource(Uri.parse(this.f1803.getNetworkMediaFileUrl())));
            this.f1804.startRepeating(50L);
        }
        m1450();
        m1449();
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m1449() {
        if (this.f1791 == null) {
            return;
        }
        this.f1791.setPlayWhenReady(this.f1795);
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private void m1450() {
        m1445(this.f1796 ? 1.0f : 0.0f);
    }

    public void clear() {
        setPlayWhenReady(false);
        this.f1808 = null;
        m1447();
    }

    public long getCurrentPosition() {
        return this.f1804.m1452();
    }

    public long getDuration() {
        return this.f1804.m1458();
    }

    @Nullable
    public Drawable getFinalFrame() {
        return this.f1792;
    }

    public int getPlaybackState() {
        if (this.f1791 == null) {
            return 5;
        }
        return this.f1791.getPlaybackState();
    }

    public void handleCtaClick(@NonNull Context context) {
        m1451();
        this.f1803.handleClickWithoutResult(context, 0);
    }

    public boolean hasFinalFrame() {
        return this.f1792 != null;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (this.f1807 == null) {
            return;
        }
        this.f1807.onAudioFocusChange(i);
    }

    public void onLoadingChanged(boolean z) {
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        if (this.f1806 == null) {
            return;
        }
        this.f1806.onError(exoPlaybackException);
        this.f1804.m1459();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
        if (r5 == 1) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPlayerStateChanged(boolean r4, int r5) {
        /*
            r3 = this;
            r0 = 4
            if (r5 != r0) goto L33
            android.graphics.drawable.BitmapDrawable r0 = r3.f1792
            if (r0 != 0) goto L33
            com.google.android.exoplayer2.ExoPlayer r0 = r3.f1791
            if (r0 == 0) goto L2d
            android.view.Surface r0 = r3.f1808
            if (r0 == 0) goto L2d
            android.view.TextureView r0 = r3.f1809
            if (r0 != 0) goto L14
            goto L2d
        L14:
            android.graphics.drawable.BitmapDrawable r0 = new android.graphics.drawable.BitmapDrawable
            android.content.Context r1 = r3.f1800
            android.content.res.Resources r1 = r1.getResources()
            android.view.TextureView r2 = r3.f1809
            android.graphics.Bitmap r2 = r2.getBitmap()
            r0.<init>(r1, r2)
            r3.f1792 = r0
            com.mopub.nativeads.NativeVideoController$NativeVideoProgressRunnable r0 = r3.f1804
            r0.m1459()
            goto L33
        L2d:
            java.lang.String r4 = "onPlayerStateChanged called afer view has been recycled."
            com.mopub.common.logging.MoPubLog.w(r4)
            return
        L33:
            r3.f1798 = r5
            r0 = 3
            if (r5 != r0) goto L3c
            r0 = 0
        L39:
            r3.f1799 = r0
            goto L40
        L3c:
            r0 = 1
            if (r5 != r0) goto L40
            goto L39
        L40:
            com.mopub.nativeads.NativeVideoController$Listener r0 = r3.f1806
            if (r0 == 0) goto L49
            com.mopub.nativeads.NativeVideoController$Listener r0 = r3.f1806
            r0.onStateChanged(r4, r5)
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.nativeads.NativeVideoController.onPlayerStateChanged(boolean, int):void");
    }

    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public void prepare(@NonNull Object obj) {
        Preconditions.checkNotNull(obj);
        this.f1810 = new WeakReference<>(obj);
        m1447();
        m1448();
        m1446(this.f1808);
    }

    public void release(@NonNull Object obj) {
        Preconditions.checkNotNull(obj);
        if ((this.f1810 == null ? null : this.f1810.get()) == obj) {
            m1447();
        }
    }

    public void seekTo(long j) {
        if (this.f1791 == null) {
            return;
        }
        this.f1791.seekTo(j);
        this.f1804.m1453(j);
    }

    public void setAppAudioEnabled(boolean z) {
        if (this.f1797 == z) {
            return;
        }
        this.f1797 = z;
        if (this.f1797) {
            this.f1805.requestAudioFocus(this, 3, 1);
        } else {
            this.f1805.abandonAudioFocus(this);
        }
    }

    public void setAudioEnabled(boolean z) {
        this.f1796 = z;
        m1450();
    }

    public void setAudioVolume(float f) {
        if (this.f1796) {
            m1445(f);
        }
    }

    public void setListener(@Nullable Listener listener) {
        this.f1806 = listener;
    }

    public void setOnAudioFocusChangeListener(@Nullable AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        this.f1807 = onAudioFocusChangeListener;
    }

    public void setPlayWhenReady(boolean z) {
        if (this.f1795 == z) {
            return;
        }
        this.f1795 = z;
        m1449();
    }

    public void setProgressListener(@Nullable NativeVideoProgressRunnable.ProgressListener progressListener) {
        this.f1804.m1456(progressListener);
    }

    public void setTextureView(@NonNull TextureView textureView) {
        Preconditions.checkNotNull(textureView);
        this.f1808 = new Surface(textureView.getSurfaceTexture());
        this.f1809 = textureView;
        this.f1804.m1454(this.f1809);
        m1446(this.f1808);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1451() {
        this.f1804.m1457(true);
    }
}
