package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants;
/* loaded from: assets/classes2.dex */
public class VastVideoGradientStripWidget extends ImageView {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    DeviceUtils.ForceOrientation f1077;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f1078;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private boolean f1079;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f1080;

    public VastVideoGradientStripWidget(@NonNull Context context, @NonNull GradientDrawable.Orientation orientation, @NonNull DeviceUtils.ForceOrientation forceOrientation, boolean z, int i, int i2, int i3) {
        super(context);
        this.f1077 = forceOrientation;
        this.f1078 = i;
        this.f1079 = z;
        setImageDrawable(new GradientDrawable(orientation, new int[]{DrawableConstants.GradientStrip.START_COLOR, DrawableConstants.GradientStrip.END_COLOR}));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Dips.dipsToIntPixels(72.0f, context));
        layoutParams.addRule(i2, i3);
        setLayoutParams(layoutParams);
        m917();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m917() {
        String str;
        if (this.f1080) {
            setVisibility(this.f1079 ? this.f1078 : 8);
            return;
        }
        if (this.f1077 != DeviceUtils.ForceOrientation.FORCE_PORTRAIT) {
            if (this.f1077 != DeviceUtils.ForceOrientation.FORCE_LANDSCAPE) {
                switch (getResources().getConfiguration().orientation) {
                    case 0:
                        str = "Screen orientation undefined: do not show gradient strip widget";
                        MoPubLog.d(str);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        str = "Screen orientation is deprecated ORIENTATION_SQUARE: do not show gradient strip widget";
                        MoPubLog.d(str);
                        break;
                    default:
                        str = "Unrecognized screen orientation: do not show gradient strip widget";
                        MoPubLog.d(str);
                        break;
                }
            }
            setVisibility(0);
            return;
        }
        setVisibility(4);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m917();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m918() {
        this.f1080 = true;
        m917();
    }
}
