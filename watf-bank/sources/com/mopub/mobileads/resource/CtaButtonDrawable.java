package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants;
/* loaded from: assets/classes2.dex */
public class CtaButtonDrawable extends BaseWidgetDrawable {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Paint f1185;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Paint f1186;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Paint f1187;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final RectF f1188;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Rect f1189;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final int f1190;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private String f1191;

    public CtaButtonDrawable(@NonNull Context context) {
        int dipsToIntPixels = Dips.dipsToIntPixels(2.0f, context);
        float dipsToFloatPixels = Dips.dipsToFloatPixels(15.0f, context);
        this.f1185 = new Paint();
        this.f1185.setColor(-16777216);
        this.f1185.setAlpha(51);
        this.f1185.setStyle(DrawableConstants.CtaButton.BACKGROUND_STYLE);
        this.f1185.setAntiAlias(true);
        this.f1186 = new Paint();
        this.f1186.setColor(-1);
        this.f1186.setAlpha(51);
        this.f1186.setStyle(DrawableConstants.CtaButton.OUTLINE_STYLE);
        this.f1186.setStrokeWidth(dipsToIntPixels);
        this.f1186.setAntiAlias(true);
        this.f1187 = new Paint();
        this.f1187.setColor(-1);
        this.f1187.setTextAlign(DrawableConstants.CtaButton.TEXT_ALIGN);
        this.f1187.setTypeface(DrawableConstants.CtaButton.TEXT_TYPEFACE);
        this.f1187.setTextSize(dipsToFloatPixels);
        this.f1187.setAntiAlias(true);
        this.f1189 = new Rect();
        this.f1191 = DrawableConstants.CtaButton.DEFAULT_CTA_TEXT;
        this.f1188 = new RectF();
        this.f1190 = Dips.dipsToIntPixels(6.0f, context);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1188.set(getBounds());
        canvas.drawRoundRect(this.f1188, this.f1190, this.f1190, this.f1185);
        canvas.drawRoundRect(this.f1188, this.f1190, this.f1190, this.f1186);
        m1007(canvas, this.f1187, this.f1189, this.f1191);
    }

    @VisibleForTesting
    @Deprecated
    public String getCtaText() {
        return this.f1191;
    }

    public void setCtaText(@NonNull String str) {
        this.f1191 = str;
        invalidateSelf();
    }
}
