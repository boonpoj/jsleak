package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.internal.zzakb;
/* loaded from: classes.dex */
public final class NativeAppInstallAdView extends NativeAdView {
    public NativeAppInstallAdView(Context context) {
        super(context);
    }

    public NativeAppInstallAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeAppInstallAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NativeAppInstallAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final View getBodyView() {
        return super.zzq(NativeAppInstallAd.ASSET_BODY);
    }

    public final View getCallToActionView() {
        return super.zzq(NativeAppInstallAd.ASSET_CALL_TO_ACTION);
    }

    public final View getHeadlineView() {
        return super.zzq(NativeAppInstallAd.ASSET_HEADLINE);
    }

    public final View getIconView() {
        return super.zzq(NativeAppInstallAd.ASSET_ICON);
    }

    public final View getImageView() {
        return super.zzq(NativeAppInstallAd.ASSET_IMAGE);
    }

    public final MediaView getMediaView() {
        View zzq = super.zzq(NativeAppInstallAd.ASSET_MEDIA_VIDEO);
        if (zzq instanceof MediaView) {
            return (MediaView) zzq;
        }
        if (zzq != null) {
            zzakb.zzbx("View is not an instance of MediaView");
            return null;
        }
        return null;
    }

    public final View getPriceView() {
        return super.zzq(NativeAppInstallAd.ASSET_PRICE);
    }

    public final View getStarRatingView() {
        return super.zzq(NativeAppInstallAd.ASSET_STAR_RATING);
    }

    public final View getStoreView() {
        return super.zzq(NativeAppInstallAd.ASSET_STORE);
    }

    public final void setBodyView(View view) {
        super.zza(NativeAppInstallAd.ASSET_BODY, view);
    }

    public final void setCallToActionView(View view) {
        super.zza(NativeAppInstallAd.ASSET_CALL_TO_ACTION, view);
    }

    public final void setHeadlineView(View view) {
        super.zza(NativeAppInstallAd.ASSET_HEADLINE, view);
    }

    public final void setIconView(View view) {
        super.zza(NativeAppInstallAd.ASSET_ICON, view);
    }

    public final void setImageView(View view) {
        super.zza(NativeAppInstallAd.ASSET_IMAGE, view);
    }

    public final void setMediaView(MediaView mediaView) {
        super.zza(NativeAppInstallAd.ASSET_MEDIA_VIDEO, mediaView);
    }

    public final void setPriceView(View view) {
        super.zza(NativeAppInstallAd.ASSET_PRICE, view);
    }

    public final void setStarRatingView(View view) {
        super.zza(NativeAppInstallAd.ASSET_STAR_RATING, view);
    }

    public final void setStoreView(View view) {
        super.zza(NativeAppInstallAd.ASSET_STORE, view);
    }
}
