package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzpu;
/* loaded from: classes.dex */
public class NativeAdView extends FrameLayout {
    private final FrameLayout zzamm;
    private final zzpu zzamn;

    public NativeAdView(Context context) {
        super(context);
        this.zzamm = zzb(context);
        this.zzamn = zzbm();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzamm = zzb(context);
        this.zzamn = zzbm();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzamm = zzb(context);
        this.zzamn = zzbm();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzamm = zzb(context);
        this.zzamn = zzbm();
    }

    private final FrameLayout zzb(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzpu zzbm() {
        zzbq.checkNotNull(this.zzamm, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzkb.zzib().zza(this.zzamm.getContext(), this, this.zzamm);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzamm);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzamm;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public void destroy() {
        try {
            this.zzamn.destroy();
        } catch (RemoteException e) {
            zzakb.zzb("Unable to destroy native ad view", e);
        }
    }

    public AdChoicesView getAdChoicesView() {
        View zzq = zzq(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzq instanceof AdChoicesView) {
            return (AdChoicesView) zzq;
        }
        return null;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzpu zzpuVar = this.zzamn;
        if (zzpuVar != null) {
            try {
                zzpuVar.zzb(zzn.zzz(view), i);
            } catch (RemoteException e) {
                zzakb.zzb("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzamm);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.zzamm == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzamn.zza((IObjectWrapper) nativeAd.zzbl());
        } catch (RemoteException e) {
            zzakb.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(String str, View view) {
        try {
            this.zzamn.zzb(str, zzn.zzz(view));
        } catch (RemoteException e) {
            zzakb.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View zzq(String str) {
        try {
            IObjectWrapper zzal = this.zzamn.zzal(str);
            if (zzal != null) {
                return (View) zzn.zzx(zzal);
            }
            return null;
        } catch (RemoteException e) {
            zzakb.zzb("Unable to call getAssetView on delegate", e);
            return null;
        }
    }
}
