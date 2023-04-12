package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.ProgressBarDrawable;
/* loaded from: assets/classes2.dex */
public class VastVideoProgressBarWidget extends ImageView {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private ProgressBarDrawable f1087;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final int f1088;

    public VastVideoProgressBarWidget(@NonNull Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        this.f1087 = new ProgressBarDrawable(context);
        setImageDrawable(this.f1087);
        this.f1088 = Dips.dipsToIntPixels(4.0f, context);
    }

    public void calibrateAndMakeVisible(int i, int i2) {
        this.f1087.setDurationAndSkipOffset(i, i2);
        setVisibility(0);
    }

    @VisibleForTesting
    @Deprecated
    ProgressBarDrawable getImageViewDrawable() {
        return this.f1087;
    }

    public void reset() {
        this.f1087.reset();
        this.f1087.setProgress(0);
    }

    public void setAnchorId(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f1088);
        layoutParams.addRule(8, i);
        setLayoutParams(layoutParams);
    }

    @VisibleForTesting
    @Deprecated
    void setImageViewDrawable(@NonNull ProgressBarDrawable progressBarDrawable) {
        this.f1087 = progressBarDrawable;
    }

    public void updateProgress(int i) {
        this.f1087.setProgress(i);
    }
}
