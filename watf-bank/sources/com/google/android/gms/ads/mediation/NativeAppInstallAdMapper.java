package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
/* loaded from: classes.dex */
public class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzbts;
    private List<NativeAd.Image> zzbtt;
    private String zzbtu;
    private String zzbtw;
    private double zzbtx;
    private String zzbty;
    private String zzbtz;
    private NativeAd.Image zzdnw;

    public final String getBody() {
        return this.zzbtu;
    }

    public final String getCallToAction() {
        return this.zzbtw;
    }

    public final String getHeadline() {
        return this.zzbts;
    }

    public final NativeAd.Image getIcon() {
        return this.zzdnw;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbtt;
    }

    public final String getPrice() {
        return this.zzbtz;
    }

    public final double getStarRating() {
        return this.zzbtx;
    }

    public final String getStore() {
        return this.zzbty;
    }

    public final void setBody(String str) {
        this.zzbtu = str;
    }

    public final void setCallToAction(String str) {
        this.zzbtw = str;
    }

    public final void setHeadline(String str) {
        this.zzbts = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.zzdnw = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzbtt = list;
    }

    public final void setPrice(String str) {
        this.zzbtz = str;
    }

    public final void setStarRating(double d) {
        this.zzbtx = d;
    }

    public final void setStore(String str) {
        this.zzbty = str;
    }
}
