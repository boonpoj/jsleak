package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
/* loaded from: assets/classes2.dex */
public abstract class BaseWidgetDrawable extends Drawable {
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1007(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Rect rect, @NonNull String str) {
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, getBounds().centerX(), getBounds().centerY() + (((paint.descent() - paint.ascent()) / 2.0f) - paint.descent()), paint);
    }
}
