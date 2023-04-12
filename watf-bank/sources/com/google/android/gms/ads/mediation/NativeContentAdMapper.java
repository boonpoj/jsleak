package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
/* loaded from: classes.dex */
public class NativeContentAdMapper extends NativeAdMapper {
    private String zzbts;
    private List<NativeAd.Image> zzbtt;
    private String zzbtu;
    private String zzbtw;
    private String zzbui;
    private NativeAd.Image zzdnx;

    public final String getAdvertiser() {
        return this.zzbui;
    }

    public final String getBody() {
        return this.zzbtu;
    }

    public final String getCallToAction() {
        return this.zzbtw;
    }

    public final String getHeadline() {
        return this.zzbts;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbtt;
    }

    public final NativeAd.Image getLogo() {
        return this.zzdnx;
    }

    public final void setAdvertiser(String str) {
        this.zzbui = str;
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

    public final void setImages(List<NativeAd.Image> list) {
        this.zzbtt = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzdnx = image;
    }
}
