package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzlv;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BaseAdView extends ViewGroup {
    protected final zzlv zzaly;

    public BaseAdView(Context context, int i) {
        super(context);
        this.zzaly = new zzlv(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zzaly = new zzlv(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zzaly = new zzlv(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.zzaly.destroy();
    }

    public AdListener getAdListener() {
        return this.zzaly.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzaly.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzaly.getAdUnitId();
    }

    public String getMediationAdapterClassName() {
        return this.zzaly.getMediationAdapterClassName();
    }

    public boolean isLoading() {
        return this.zzaly.isLoading();
    }

    public void loadAd(AdRequest adRequest) {
        this.zzaly.zza(adRequest.zzbg());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzakb.zzb("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.zzaly.pause();
    }

    public void resume() {
        this.zzaly.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzaly.setAdListener(adListener);
        if (adListener == null) {
            this.zzaly.zza((zzje) null);
            this.zzaly.setAppEventListener(null);
            return;
        }
        if (adListener instanceof zzje) {
            this.zzaly.zza((zzje) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zzaly.setAppEventListener((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzaly.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzaly.setAdUnitId(str);
    }
}
