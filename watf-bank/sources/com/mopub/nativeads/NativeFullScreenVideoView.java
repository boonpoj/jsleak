package com.mopub.nativeads;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastVideoProgressBarWidget;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.CtaButtonDrawable;
import com.mopub.mobileads.resource.DrawableConstants;
/* loaded from: assets/classes2.dex */
public class NativeFullScreenVideoView extends RelativeLayout {
    @NonNull

    /* renamed from: ֏  reason: contains not printable characters */
    private final ProgressBar f1757;
    @NonNull

    /* renamed from: ؠ  reason: contains not printable characters */
    private final ImageView f1758;
    @NonNull

    /* renamed from: ހ  reason: contains not printable characters */
    private final ImageView f1759;
    @NonNull

    /* renamed from: ށ  reason: contains not printable characters */
    private final VastVideoProgressBarWidget f1760;
    @NonNull

    /* renamed from: ނ  reason: contains not printable characters */
    private final View f1761;
    @NonNull

    /* renamed from: ރ  reason: contains not printable characters */
    private final ImageView f1762;
    @NonNull

    /* renamed from: ބ  reason: contains not printable characters */
    private final ImageView f1763;
    @NonNull

    /* renamed from: ޅ  reason: contains not printable characters */
    private final ImageView f1764;
    @NonNull

    /* renamed from: ކ  reason: contains not printable characters */
    private final ImageView f1765;
    @NonNull
    @VisibleForTesting

    /* renamed from: ࢠ  reason: contains not printable characters */
    Mode f1766;
    @VisibleForTesting

    /* renamed from: ࢢ  reason: contains not printable characters */
    final int f1767;
    @VisibleForTesting

    /* renamed from: ࢣ  reason: contains not printable characters */
    final int f1768;
    @VisibleForTesting

    /* renamed from: ࢤ  reason: contains not printable characters */
    final int f1769;
    @VisibleForTesting

    /* renamed from: ࢥ  reason: contains not printable characters */
    final int f1770;
    @VisibleForTesting

    /* renamed from: ࢦ  reason: contains not printable characters */
    final int f1771;
    @VisibleForTesting

    /* renamed from: ࢧ  reason: contains not printable characters */
    final int f1772;
    @VisibleForTesting

    /* renamed from: ࢨ  reason: contains not printable characters */
    final int f1773;
    @VisibleForTesting

    /* renamed from: ࢩ  reason: contains not printable characters */
    final int f1774;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private int f1775;
    @NonNull

    /* renamed from: ࢫ  reason: contains not printable characters */
    private final ImageView f1776;
    @NonNull

    /* renamed from: ࢬ  reason: contains not printable characters */
    private final TextureView f1777;

    /* loaded from: assets/classes2.dex */
    public enum Mode {
        LOADING,
        PLAYING,
        PAUSED,
        FINISHED
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.NativeFullScreenVideoView$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0271 extends Drawable {
        @VisibleForTesting

        /* renamed from: ࢠ  reason: contains not printable characters */
        final int f1780;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final RectF f1781;
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final Paint f1782;

        C0271(@NonNull Context context) {
            this(context, new RectF(), new Paint());
        }

        C0271(@NonNull Context context, @NonNull RectF rectF, @NonNull Paint paint) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(rectF);
            Preconditions.checkNotNull(paint);
            this.f1781 = rectF;
            this.f1782 = paint;
            this.f1782.setColor(-16777216);
            this.f1782.setAlpha(128);
            this.f1782.setAntiAlias(true);
            this.f1780 = Dips.asIntPixels(5.0f, context);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            this.f1781.set(getBounds());
            canvas.drawRoundRect(this.f1781, this.f1780, this.f1780, this.f1782);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public NativeFullScreenVideoView(@NonNull Context context, int i, @Nullable String str) {
        this(context, i, str, new ImageView(context), new TextureView(context), new ProgressBar(context), new ImageView(context), new ImageView(context), new VastVideoProgressBarWidget(context), new View(context), new ImageView(context), new ImageView(context), new ImageView(context), new ImageView(context));
    }

    @VisibleForTesting
    NativeFullScreenVideoView(@NonNull Context context, int i, @Nullable String str, @NonNull ImageView imageView, @NonNull TextureView textureView, @NonNull ProgressBar progressBar, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull VastVideoProgressBarWidget vastVideoProgressBarWidget, @NonNull View view, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7) {
        super(context);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(imageView);
        Preconditions.checkNotNull(textureView);
        Preconditions.checkNotNull(progressBar);
        Preconditions.checkNotNull(imageView2);
        Preconditions.checkNotNull(imageView3);
        Preconditions.checkNotNull(vastVideoProgressBarWidget);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(imageView4);
        Preconditions.checkNotNull(imageView5);
        Preconditions.checkNotNull(imageView6);
        Preconditions.checkNotNull(imageView7);
        this.f1775 = i;
        this.f1766 = Mode.LOADING;
        this.f1767 = Dips.asIntPixels(200.0f, context);
        this.f1768 = Dips.asIntPixels(42.0f, context);
        this.f1769 = Dips.asIntPixels(10.0f, context);
        this.f1770 = Dips.asIntPixels(50.0f, context);
        this.f1771 = Dips.asIntPixels(8.0f, context);
        this.f1772 = Dips.asIntPixels(44.0f, context);
        this.f1773 = Dips.asIntPixels(50.0f, context);
        this.f1774 = Dips.asIntPixels(45.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f1777 = textureView;
        this.f1777.setId((int) Utils.generateUniqueId());
        this.f1777.setLayoutParams(layoutParams);
        addView(this.f1777);
        this.f1776 = imageView;
        this.f1776.setId((int) Utils.generateUniqueId());
        this.f1776.setLayoutParams(layoutParams);
        this.f1776.setBackgroundColor(0);
        addView(this.f1776);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f1773, this.f1773);
        layoutParams2.addRule(13);
        this.f1757 = progressBar;
        this.f1757.setId((int) Utils.generateUniqueId());
        this.f1757.setBackground(new C0271(context));
        this.f1757.setLayoutParams(layoutParams2);
        this.f1757.setIndeterminate(true);
        addView(this.f1757);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f1774);
        layoutParams3.addRule(8, this.f1777.getId());
        this.f1758 = imageView2;
        this.f1758.setId((int) Utils.generateUniqueId());
        this.f1758.setLayoutParams(layoutParams3);
        this.f1758.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{DrawableConstants.GradientStrip.START_COLOR, DrawableConstants.GradientStrip.END_COLOR}));
        addView(this.f1758);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, this.f1774);
        layoutParams4.addRule(10);
        this.f1759 = imageView3;
        this.f1759.setId((int) Utils.generateUniqueId());
        this.f1759.setLayoutParams(layoutParams4);
        this.f1759.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{DrawableConstants.GradientStrip.START_COLOR, DrawableConstants.GradientStrip.END_COLOR}));
        addView(this.f1759);
        this.f1760 = vastVideoProgressBarWidget;
        this.f1760.setId((int) Utils.generateUniqueId());
        this.f1760.setAnchorId(this.f1777.getId());
        this.f1760.calibrateAndMakeVisible(1000, 0);
        addView(this.f1760);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(13);
        this.f1761 = view;
        this.f1761.setId((int) Utils.generateUniqueId());
        this.f1761.setLayoutParams(layoutParams5);
        this.f1761.setBackgroundColor(DrawableConstants.TRANSPARENT_GRAY);
        addView(this.f1761);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(this.f1773, this.f1773);
        layoutParams6.addRule(13);
        this.f1762 = imageView4;
        this.f1762.setId((int) Utils.generateUniqueId());
        this.f1762.setLayoutParams(layoutParams6);
        this.f1762.setImageDrawable(Drawables.NATIVE_PLAY.createDrawable(context));
        addView(this.f1762);
        this.f1763 = imageView5;
        this.f1763.setId((int) Utils.generateUniqueId());
        this.f1763.setPadding(this.f1771, this.f1771, this.f1771 * 2, this.f1771 * 2);
        addView(this.f1763);
        CtaButtonDrawable ctaButtonDrawable = new CtaButtonDrawable(context);
        if (!TextUtils.isEmpty(str)) {
            ctaButtonDrawable.setCtaText(str);
        }
        this.f1764 = imageView6;
        this.f1764.setId((int) Utils.generateUniqueId());
        this.f1764.setImageDrawable(ctaButtonDrawable);
        addView(this.f1764);
        this.f1765 = imageView7;
        this.f1765.setId((int) Utils.generateUniqueId());
        this.f1765.setImageDrawable(new CloseButtonDrawable());
        this.f1765.setPadding(this.f1771 * 3, this.f1771, this.f1771, this.f1771 * 3);
        addView(this.f1765);
        m1441();
    }

    private void setCachedImageVisibility(int i) {
        this.f1776.setVisibility(i);
    }

    private void setLoadingSpinnerVisibility(int i) {
        this.f1757.setVisibility(i);
    }

    private void setPlayButtonVisibility(int i) {
        this.f1762.setVisibility(i);
        this.f1761.setVisibility(i);
    }

    private void setVideoProgressVisibility(int i) {
        this.f1760.setVisibility(i);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1441() {
        switch (this.f1766) {
            case LOADING:
                setCachedImageVisibility(0);
                setLoadingSpinnerVisibility(0);
                setVideoProgressVisibility(4);
                setPlayButtonVisibility(4);
                m1442();
                m1443();
                return;
            case PLAYING:
                setCachedImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoProgressVisibility(0);
                setPlayButtonVisibility(4);
                m1442();
                m1443();
                return;
            case PAUSED:
                setCachedImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoProgressVisibility(0);
                setPlayButtonVisibility(0);
                m1442();
                m1443();
                return;
            case FINISHED:
                setCachedImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoProgressVisibility(4);
                setPlayButtonVisibility(0);
                m1442();
                m1443();
                return;
            default:
                m1442();
                m1443();
                return;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m1442() {
        Configuration configuration = getContext().getResources().getConfiguration();
        ViewGroup.LayoutParams layoutParams = this.f1777.getLayoutParams();
        int dipsToIntPixels = Dips.dipsToIntPixels(configuration.screenWidthDp, getContext());
        if (dipsToIntPixels != layoutParams.width) {
            layoutParams.width = dipsToIntPixels;
        }
        int dipsToIntPixels2 = Dips.dipsToIntPixels((configuration.screenWidthDp * 9.0f) / 16.0f, getContext());
        if (dipsToIntPixels2 != layoutParams.height) {
            layoutParams.height = dipsToIntPixels2;
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m1443() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f1767, this.f1768);
        layoutParams.setMargins(this.f1769, this.f1769, this.f1769, this.f1769);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f1772, this.f1772);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f1770, this.f1770);
        switch (this.f1775) {
            case 1:
                layoutParams.addRule(3, this.f1777.getId());
                layoutParams.addRule(14);
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
                layoutParams3.addRule(10);
                layoutParams3.addRule(11);
                break;
            case 2:
                layoutParams.addRule(2, this.f1760.getId());
                layoutParams.addRule(11);
                layoutParams2.addRule(6, this.f1777.getId());
                layoutParams2.addRule(5, this.f1777.getId());
                layoutParams3.addRule(6, this.f1777.getId());
                layoutParams3.addRule(7, this.f1777.getId());
                break;
        }
        this.f1764.setLayoutParams(layoutParams);
        this.f1763.setLayoutParams(layoutParams2);
        this.f1765.setLayoutParams(layoutParams3);
    }

    @VisibleForTesting
    @Deprecated
    ImageView getCtaButton() {
        return this.f1764;
    }

    @NonNull
    public TextureView getTextureView() {
        return this.f1777;
    }

    public void resetProgress() {
        this.f1760.reset();
    }

    public void setCachedVideoFrame(@Nullable Bitmap bitmap) {
        this.f1776.setImageBitmap(bitmap);
    }

    public void setCloseControlListener(@Nullable View.OnClickListener onClickListener) {
        this.f1765.setOnClickListener(onClickListener);
    }

    public void setCtaClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f1764.setOnClickListener(onClickListener);
    }

    public void setMode(@NonNull Mode mode) {
        Preconditions.checkNotNull(mode);
        if (this.f1766 == mode) {
            return;
        }
        this.f1766 = mode;
        m1441();
    }

    public void setOrientation(int i) {
        if (this.f1775 == i) {
            return;
        }
        this.f1775 = i;
        m1441();
    }

    public void setPlayControlClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f1762.setOnClickListener(onClickListener);
        this.f1761.setOnClickListener(onClickListener);
    }

    public void setPrivacyInformationClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f1763.setOnClickListener(onClickListener);
    }

    public void setPrivacyInformationIconImageUrl(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            this.f1763.setImageDrawable(Drawables.NATIVE_PRIVACY_INFORMATION_ICON.createDrawable(this.f1763.getContext()));
        } else {
            NativeImageHelper.loadImageView(str, this.f1763);
        }
    }

    public void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.f1777.setSurfaceTextureListener(surfaceTextureListener);
        SurfaceTexture surfaceTexture = this.f1777.getSurfaceTexture();
        if (surfaceTexture == null || surfaceTextureListener == null) {
            return;
        }
        surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, this.f1777.getWidth(), this.f1777.getHeight());
    }

    public void updateProgress(int i) {
        this.f1760.updateProgress(i);
    }
}
