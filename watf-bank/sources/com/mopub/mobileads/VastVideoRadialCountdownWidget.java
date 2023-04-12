package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.RadialCountdownDrawable;
/* loaded from: assets/classes2.dex */
public class VastVideoRadialCountdownWidget extends ImageView {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private RadialCountdownDrawable f1089;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f1090;

    public VastVideoRadialCountdownWidget(@NonNull Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        int dipsToIntPixels = Dips.dipsToIntPixels(45.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(16.0f, context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(16.0f, context);
        int dipsToIntPixels4 = Dips.dipsToIntPixels(5.0f, context);
        this.f1089 = new RadialCountdownDrawable(context);
        setImageDrawable(this.f1089);
        setPadding(dipsToIntPixels4, dipsToIntPixels4, dipsToIntPixels4, dipsToIntPixels4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.setMargins(0, dipsToIntPixels2, dipsToIntPixels3, 0);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    public void calibrateAndMakeVisible(int i) {
        this.f1089.setInitialCountdown(i);
        setVisibility(0);
    }

    @VisibleForTesting
    @Deprecated
    public RadialCountdownDrawable getImageViewDrawable() {
        return this.f1089;
    }

    @VisibleForTesting
    @Deprecated
    public void setImageViewDrawable(RadialCountdownDrawable radialCountdownDrawable) {
        this.f1089 = radialCountdownDrawable;
    }

    public void updateCountdownProgress(int i, int i2) {
        if (i2 >= this.f1090) {
            if (i - i2 < 0) {
                setVisibility(8);
                return;
            }
            this.f1089.updateCountdownProgress(i2);
            this.f1090 = i2;
        }
    }
}
