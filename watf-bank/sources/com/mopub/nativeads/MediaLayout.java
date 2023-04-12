package com.mopub.nativeads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastVideoProgressBarWidget;
import com.mopub.mobileads.resource.DrawableConstants;
/* loaded from: assets/classes2.dex */
public class MediaLayout extends RelativeLayout {
    @Nullable

    /* renamed from: ֏  reason: contains not printable characters */
    private Drawable f1567;

    /* renamed from: ؠ  reason: contains not printable characters */
    private boolean f1568;

    /* renamed from: ހ  reason: contains not printable characters */
    private final int f1569;

    /* renamed from: ށ  reason: contains not printable characters */
    private final int f1570;

    /* renamed from: ނ  reason: contains not printable characters */
    private final int f1571;

    /* renamed from: ރ  reason: contains not printable characters */
    private final int f1572;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private volatile Mode f1573;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private MuteState f1574;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private ImageView f1575;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private TextureView f1576;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private ProgressBar f1577;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private ImageView f1578;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private ImageView f1579;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private ImageView f1580;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private VastVideoProgressBarWidget f1581;
    @Nullable

    /* renamed from: ࢪ  reason: contains not printable characters */
    private ImageView f1582;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private View f1583;
    @Nullable

    /* renamed from: ࢬ  reason: contains not printable characters */
    private Drawable f1584;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.nativeads.MediaLayout$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        static final /* synthetic */ int[] f1586;

        static {
            try {
                f1587[Mode.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1587[Mode.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1587[Mode.BUFFERING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1587[Mode.PLAYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1587[Mode.PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1587[Mode.FINISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f1586 = new int[MuteState.values().length];
            try {
                f1586[MuteState.MUTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1586[MuteState.UNMUTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public enum Mode {
        IMAGE,
        PLAYING,
        LOADING,
        BUFFERING,
        PAUSED,
        FINISHED
    }

    /* loaded from: assets/classes2.dex */
    public enum MuteState {
        MUTED,
        UNMUTED
    }

    public MediaLayout(@NonNull Context context) {
        this(context, null);
    }

    public MediaLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1573 = Mode.IMAGE;
        Preconditions.checkNotNull(context);
        this.f1574 = MuteState.MUTED;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f1575 = new ImageView(context);
        this.f1575.setLayoutParams(layoutParams);
        this.f1575.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f1575);
        this.f1569 = Dips.asIntPixels(40.0f, context);
        this.f1570 = Dips.asIntPixels(35.0f, context);
        this.f1571 = Dips.asIntPixels(36.0f, context);
        this.f1572 = Dips.asIntPixels(10.0f, context);
    }

    private void setLoadingSpinnerVisibility(int i) {
        if (this.f1577 != null) {
            this.f1577.setVisibility(i);
        }
        if (this.f1580 != null) {
            this.f1580.setVisibility(i);
        }
    }

    private void setMainImageVisibility(int i) {
        this.f1575.setVisibility(i);
    }

    private void setPlayButtonVisibility(int i) {
        if (this.f1578 == null || this.f1583 == null) {
            return;
        }
        this.f1578.setVisibility(i);
        this.f1583.setVisibility(i);
    }

    private void setVideoControlVisibility(int i) {
        if (this.f1579 != null) {
            this.f1579.setVisibility(i);
        }
        if (this.f1581 != null) {
            this.f1581.setVisibility(i);
        }
        if (this.f1582 != null) {
            this.f1582.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1331() {
        switch (this.f1573) {
            case IMAGE:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(4);
                return;
            case LOADING:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(0);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(4);
                return;
            case BUFFERING:
                setMainImageVisibility(4);
                setLoadingSpinnerVisibility(0);
                setVideoControlVisibility(0);
                setPlayButtonVisibility(4);
                setMainImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(0);
                setPlayButtonVisibility(4);
                return;
            case PLAYING:
                setMainImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(0);
                setPlayButtonVisibility(4);
                return;
            case PAUSED:
                setMainImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(0);
                setPlayButtonVisibility(0);
                return;
            case FINISHED:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(0);
                return;
            default:
                return;
        }
    }

    @Nullable
    public ImageView getMainImageView() {
        return this.f1575;
    }

    public TextureView getTextureView() {
        return this.f1576;
    }

    public void initForVideo() {
        if (this.f1568) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f1576 = new TextureView(getContext());
        this.f1576.setLayoutParams(layoutParams);
        this.f1576.setId((int) Utils.generateUniqueId());
        addView(this.f1576);
        this.f1575.bringToFront();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f1569, this.f1569);
        layoutParams2.addRule(10);
        layoutParams2.addRule(11);
        this.f1577 = new ProgressBar(getContext());
        this.f1577.setLayoutParams(layoutParams2);
        this.f1577.setPadding(0, this.f1572, this.f1572, 0);
        this.f1577.setIndeterminate(true);
        addView(this.f1577);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f1570);
        layoutParams3.addRule(8, this.f1576.getId());
        this.f1579 = new ImageView(getContext());
        this.f1579.setLayoutParams(layoutParams3);
        this.f1579.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{DrawableConstants.GradientStrip.START_COLOR, DrawableConstants.GradientStrip.END_COLOR}));
        addView(this.f1579);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, this.f1570);
        layoutParams4.addRule(6, this.f1576.getId());
        this.f1580 = new ImageView(getContext());
        this.f1580.setLayoutParams(layoutParams4);
        this.f1580.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{DrawableConstants.GradientStrip.START_COLOR, DrawableConstants.GradientStrip.END_COLOR}));
        addView(this.f1580);
        this.f1581 = new VastVideoProgressBarWidget(getContext());
        this.f1581.setAnchorId(this.f1576.getId());
        this.f1581.calibrateAndMakeVisible(1000, 0);
        addView(this.f1581);
        this.f1584 = Drawables.NATIVE_MUTED.createDrawable(getContext());
        this.f1567 = Drawables.NATIVE_UNMUTED.createDrawable(getContext());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(this.f1571, this.f1571);
        layoutParams5.addRule(9);
        layoutParams5.addRule(2, this.f1581.getId());
        this.f1582 = new ImageView(getContext());
        this.f1582.setLayoutParams(layoutParams5);
        this.f1582.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f1582.setPadding(this.f1572, this.f1572, this.f1572, this.f1572);
        this.f1582.setImageDrawable(this.f1584);
        addView(this.f1582);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams6.addRule(13);
        this.f1583 = new View(getContext());
        this.f1583.setLayoutParams(layoutParams6);
        this.f1583.setBackgroundColor(0);
        addView(this.f1583);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(this.f1569, this.f1569);
        layoutParams7.addRule(13);
        this.f1578 = new ImageView(getContext());
        this.f1578.setLayoutParams(layoutParams7);
        this.f1578.setImageDrawable(Drawables.NATIVE_PLAY.createDrawable(getContext()));
        addView(this.f1578);
        this.f1568 = true;
        m1331();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(size, measuredWidth) : measuredWidth;
        }
        int i3 = (int) (size * 0.5625f);
        if (mode2 == 1073741824 && size2 < i3) {
            size = (int) (size2 * 1.7777778f);
            i3 = size2;
        }
        if (Math.abs(i3 - measuredHeight) >= 2 || Math.abs(size - measuredWidth) >= 2) {
            MoPubLog.v(String.format("Resetting mediaLayout size to w: %d h: %d", Integer.valueOf(size), Integer.valueOf(i3)));
            getLayoutParams().width = size;
            getLayoutParams().height = i3;
        }
        super.onMeasure(i, i2);
    }

    public void reset() {
        setMode(Mode.IMAGE);
        setPlayButtonClickListener(null);
        setMuteControlClickListener(null);
        setVideoClickListener(null);
    }

    public void resetProgress() {
        if (this.f1581 != null) {
            this.f1581.reset();
        }
    }

    public void setMainImageDrawable(@NonNull Drawable drawable) {
        Preconditions.checkNotNull(drawable);
        this.f1575.setImageDrawable(drawable);
    }

    public void setMode(@NonNull Mode mode) {
        Preconditions.checkNotNull(mode);
        this.f1573 = mode;
        post(new Runnable() { // from class: com.mopub.nativeads.MediaLayout.1
            @Override // java.lang.Runnable
            public void run() {
                MediaLayout.this.m1331();
            }
        });
    }

    public void setMuteControlClickListener(@Nullable View.OnClickListener onClickListener) {
        if (this.f1582 != null) {
            this.f1582.setOnClickListener(onClickListener);
        }
    }

    public void setMuteState(@NonNull MuteState muteState) {
        ImageView imageView;
        Drawable drawable;
        Preconditions.checkNotNull(muteState);
        if (muteState == this.f1574) {
            return;
        }
        this.f1574 = muteState;
        if (this.f1582 != null) {
            if (AnonymousClass2.f1586[this.f1574.ordinal()] != 1) {
                imageView = this.f1582;
                drawable = this.f1567;
            } else {
                imageView = this.f1582;
                drawable = this.f1584;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public void setPlayButtonClickListener(@Nullable View.OnClickListener onClickListener) {
        if (this.f1578 == null || this.f1583 == null) {
            return;
        }
        this.f1583.setOnClickListener(onClickListener);
        this.f1578.setOnClickListener(onClickListener);
    }

    public void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener surfaceTextureListener) {
        if (this.f1576 != null) {
            this.f1576.setSurfaceTextureListener(surfaceTextureListener);
            SurfaceTexture surfaceTexture = this.f1576.getSurfaceTexture();
            if (surfaceTexture == null || surfaceTextureListener == null) {
                return;
            }
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, this.f1576.getWidth(), this.f1576.getHeight());
        }
    }

    public void setVideoClickListener(@Nullable View.OnClickListener onClickListener) {
        if (this.f1576 != null) {
            this.f1576.setOnClickListener(onClickListener);
        }
    }

    public void updateProgress(int i) {
        if (this.f1581 != null) {
            this.f1581.updateProgress(i);
        }
    }
}
