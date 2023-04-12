package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants;
/* loaded from: assets/classes2.dex */
public class ProgressBarDrawable extends BaseWidgetDrawable {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Paint f1192 = new Paint();
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Paint f1193;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f1194;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f1195;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f1196;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f1197;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private float f1198;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final int f1199;

    public ProgressBarDrawable(@NonNull Context context) {
        this.f1192.setColor(-1);
        this.f1192.setAlpha(128);
        this.f1192.setStyle(DrawableConstants.ProgressBar.BACKGROUND_STYLE);
        this.f1192.setAntiAlias(true);
        this.f1193 = new Paint();
        this.f1193.setColor(DrawableConstants.ProgressBar.PROGRESS_COLOR);
        this.f1193.setAlpha(255);
        this.f1193.setStyle(DrawableConstants.ProgressBar.PROGRESS_STYLE);
        this.f1193.setAntiAlias(true);
        this.f1199 = Dips.dipsToIntPixels(4.0f, context);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds(), this.f1192);
        canvas.drawRect(getBounds().left, getBounds().top, getBounds().right * (this.f1196 / this.f1194), getBounds().bottom, this.f1193);
        if (this.f1195 <= 0 || this.f1195 >= this.f1194) {
            return;
        }
        float f = getBounds().right * this.f1198;
        canvas.drawRect(f, getBounds().top, f + this.f1199, getBounds().bottom, this.f1193);
    }

    @VisibleForTesting
    public void forceCompletion() {
        this.f1196 = this.f1194;
    }

    @VisibleForTesting
    @Deprecated
    public int getCurrentProgress() {
        return this.f1196;
    }

    @VisibleForTesting
    @Deprecated
    public float getSkipRatio() {
        return this.f1198;
    }

    public void reset() {
        this.f1197 = 0;
    }

    public void setDurationAndSkipOffset(int i, int i2) {
        this.f1194 = i;
        this.f1195 = i2;
        this.f1198 = this.f1195 / this.f1194;
    }

    public void setProgress(int i) {
        if (i >= this.f1197) {
            this.f1196 = i;
            this.f1197 = i;
        } else if (i != 0) {
            MoPubLog.d(String.format("Progress not monotonically increasing: last = %d, current = %d", Integer.valueOf(this.f1197), Integer.valueOf(i)));
            forceCompletion();
        }
        invalidateSelf();
    }
}
