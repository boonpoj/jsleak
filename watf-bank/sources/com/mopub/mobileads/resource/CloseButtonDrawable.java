package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.mopub.mobileads.resource.DrawableConstants;
/* loaded from: assets/classes2.dex */
public class CloseButtonDrawable extends BaseWidgetDrawable {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Paint f1183;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final float f1184;

    public CloseButtonDrawable() {
        this(8.0f);
    }

    public CloseButtonDrawable(float f) {
        this.f1184 = f / 2.0f;
        this.f1183 = new Paint();
        this.f1183.setColor(-1);
        this.f1183.setStrokeWidth(f);
        this.f1183.setStrokeCap(DrawableConstants.CloseButton.STROKE_CAP);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int width = getBounds().width();
        float height = getBounds().height();
        float f = width;
        canvas.drawLine(this.f1184 + 0.0f, height - this.f1184, f - this.f1184, this.f1184 + 0.0f, this.f1183);
        canvas.drawLine(this.f1184 + 0.0f, this.f1184 + 0.0f, f - this.f1184, height - this.f1184, this.f1183);
    }
}
