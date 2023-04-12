package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Numbers;
import com.mopub.mobileads.resource.DrawableConstants;
/* loaded from: assets/classes2.dex */
public class RadialCountdownDrawable extends BaseWidgetDrawable {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Paint f1200;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Paint f1201;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Paint f1202;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Rect f1203;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f1204;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f1205;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private float f1206;

    public RadialCountdownDrawable(@NonNull Context context) {
        int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, context);
        float dipsToFloatPixels = Dips.dipsToFloatPixels(18.0f, context);
        this.f1200 = new Paint();
        this.f1200.setColor(-1);
        this.f1200.setAlpha(128);
        this.f1200.setStyle(DrawableConstants.RadialCountdown.BACKGROUND_STYLE);
        float f = dipsToIntPixels;
        this.f1200.setStrokeWidth(f);
        this.f1200.setAntiAlias(true);
        this.f1201 = new Paint();
        this.f1201.setColor(-1);
        this.f1201.setAlpha(255);
        this.f1201.setStyle(DrawableConstants.RadialCountdown.PROGRESS_STYLE);
        this.f1201.setStrokeWidth(f);
        this.f1201.setAntiAlias(true);
        this.f1202 = new Paint();
        this.f1202.setColor(-1);
        this.f1202.setTextAlign(DrawableConstants.RadialCountdown.TEXT_ALIGN);
        this.f1202.setTextSize(dipsToFloatPixels);
        this.f1202.setAntiAlias(true);
        this.f1203 = new Rect();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int centerX = getBounds().centerX();
        int centerY = getBounds().centerY();
        canvas.drawCircle(centerX, centerY, Math.min(centerX, centerY), this.f1200);
        m1007(canvas, this.f1202, this.f1203, String.valueOf(this.f1205));
        canvas.drawArc(new RectF(getBounds()), -90.0f, this.f1206, false, this.f1201);
    }

    @VisibleForTesting
    @Deprecated
    public int getInitialCountdownMilliseconds() {
        return this.f1204;
    }

    public void setInitialCountdown(int i) {
        this.f1204 = i;
    }

    public void updateCountdownProgress(int i) {
        this.f1205 = (int) Numbers.convertMillisecondsToSecondsRoundedUp(this.f1204 - i);
        this.f1206 = (i * 360.0f) / this.f1204;
        invalidateSelf();
    }
}
