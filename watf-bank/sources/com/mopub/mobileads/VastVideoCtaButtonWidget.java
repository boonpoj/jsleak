package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CtaButtonDrawable;
/* loaded from: assets/classes2.dex */
public class VastVideoCtaButtonWidget extends ImageView {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private CtaButtonDrawable f1069;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final RelativeLayout.LayoutParams f1070;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final RelativeLayout.LayoutParams f1071;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f1072;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f1073;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f1074;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f1075;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f1076;

    public VastVideoCtaButtonWidget(@NonNull Context context, int i, boolean z, boolean z2) {
        super(context);
        this.f1074 = z;
        this.f1075 = z2;
        this.f1076 = false;
        setId((int) Utils.generateUniqueId());
        int dipsToIntPixels = Dips.dipsToIntPixels(150.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(38.0f, context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(16.0f, context);
        this.f1069 = new CtaButtonDrawable(context);
        setImageDrawable(this.f1069);
        this.f1070 = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels2);
        this.f1070.setMargins(dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3);
        this.f1070.addRule(8, i);
        this.f1070.addRule(7, i);
        this.f1071 = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels2);
        this.f1071.setMargins(dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3);
        this.f1071.addRule(12);
        this.f1071.addRule(11);
        m913();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m913() {
        String str;
        RelativeLayout.LayoutParams layoutParams;
        int i;
        if (!this.f1075) {
            setVisibility(8);
            return;
        }
        if (!this.f1072) {
            i = 4;
        } else if (this.f1073 && this.f1074 && !this.f1076) {
            setVisibility(8);
            return;
        } else {
            switch (getResources().getConfiguration().orientation) {
                case 0:
                    str = "Screen orientation undefined: CTA button widget defaulting to portrait layout";
                    MoPubLog.d(str);
                    layoutParams = this.f1071;
                    break;
                case 1:
                    layoutParams = this.f1071;
                    break;
                case 2:
                    layoutParams = this.f1070;
                    break;
                case 3:
                    str = "Screen orientation is deprecated ORIENTATION_SQUARE: CTA button widget defaulting to portrait layout";
                    MoPubLog.d(str);
                    layoutParams = this.f1071;
                    break;
                default:
                    str = "Unrecognized screen orientation: CTA button widget defaulting to portrait layout";
                    MoPubLog.d(str);
                    layoutParams = this.f1071;
                    break;
            }
            setLayoutParams(layoutParams);
            i = 0;
        }
        setVisibility(i);
    }

    @VisibleForTesting
    @Deprecated
    String getCtaText() {
        return this.f1069.getCtaText();
    }

    boolean getHasSocialActions() {
        return this.f1076;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m913();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHasSocialActions(boolean z) {
        this.f1076 = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m914() {
        this.f1072 = true;
        m913();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m915(@NonNull String str) {
        this.f1069.setCtaText(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m916() {
        this.f1072 = true;
        this.f1073 = true;
        m913();
    }
}
