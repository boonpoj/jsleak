package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
@zzzv
/* loaded from: classes.dex */
public final class zzvt extends zzvk {
    private final NativeAppInstallAdMapper zzcfs;

    public zzvt(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzcfs = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.zzvj
    public final String getBody() {
        return this.zzcfs.getBody();
    }

    @Override // com.google.android.gms.internal.zzvj
    public final String getCallToAction() {
        return this.zzcfs.getCallToAction();
    }

    @Override // com.google.android.gms.internal.zzvj
    public final Bundle getExtras() {
        return this.zzcfs.getExtras();
    }

    @Override // com.google.android.gms.internal.zzvj
    public final String getHeadline() {
        return this.zzcfs.getHeadline();
    }

    @Override // com.google.android.gms.internal.zzvj
    public final List getImages() {
        List<NativeAd.Image> images = this.zzcfs.getImages();
        if (images != null) {
            ArrayList arrayList = new ArrayList();
            for (NativeAd.Image image : images) {
                arrayList.add(new zzoi(image.getDrawable(), image.getUri(), image.getScale()));
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvj
    public final boolean getOverrideClickHandling() {
        return this.zzcfs.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.zzvj
    public final boolean getOverrideImpressionRecording() {
        return this.zzcfs.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.zzvj
    public final String getPrice() {
        return this.zzcfs.getPrice();
    }

    @Override // com.google.android.gms.internal.zzvj
    public final double getStarRating() {
        return this.zzcfs.getStarRating();
    }

    @Override // com.google.android.gms.internal.zzvj
    public final String getStore() {
        return this.zzcfs.getStore();
    }

    @Override // com.google.android.gms.internal.zzvj
    public final zzll getVideoController() {
        if (this.zzcfs.getVideoController() != null) {
            return this.zzcfs.getVideoController().zzbj();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvj
    public final void recordImpression() {
        this.zzcfs.recordImpression();
    }

    @Override // com.google.android.gms.internal.zzvj
    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zzcfs.handleClick((View) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzvj
    public final void zzi(IObjectWrapper iObjectWrapper) {
        this.zzcfs.trackView((View) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzvj
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzcfs.untrackView((View) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzvj
    public final zzpq zzjs() {
        NativeAd.Image icon = this.zzcfs.getIcon();
        if (icon != null) {
            return new zzoi(icon.getDrawable(), icon.getUri(), icon.getScale());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvj
    public final IObjectWrapper zzjx() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzvj
    public final zzpm zzjy() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzvj
    public final IObjectWrapper zzmk() {
        View adChoicesContent = this.zzcfs.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return com.google.android.gms.dynamic.zzn.zzz(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.zzvj
    public final IObjectWrapper zzml() {
        View zzul = this.zzcfs.zzul();
        if (zzul == null) {
            return null;
        }
        return com.google.android.gms.dynamic.zzn.zzz(zzul);
    }
}
