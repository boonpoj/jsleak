package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@zzzv
/* loaded from: classes.dex */
public final class zzvv implements NativeMediationAdRequest {
    private final zzpe zzapn;
    private final int zzbdw;
    private final boolean zzbei;
    private final int zzcfm;
    private final Date zzhh;
    private final Set<String> zzhj;
    private final boolean zzhk;
    private final Location zzhl;
    private final List<String> zzapo = new ArrayList();
    private final Map<String, Boolean> zzcfu = new HashMap();

    public zzvv(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzpe zzpeVar, List<String> list, boolean z2) {
        Map<String, Boolean> map;
        String str;
        boolean z3;
        this.zzhh = date;
        this.zzbdw = i;
        this.zzhj = set;
        this.zzhl = location;
        this.zzhk = z;
        this.zzcfm = i2;
        this.zzapn = zzpeVar;
        this.zzbei = z2;
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith("custom:")) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            map = this.zzcfu;
                            str = split[1];
                            z3 = true;
                        } else if ("false".equals(split[2])) {
                            map = this.zzcfu;
                            str = split[1];
                            z3 = false;
                        }
                        map.put(str, z3);
                    }
                } else {
                    this.zzapo.add(str2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final float getAdVolume() {
        return zzly.zziq().zzdn();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Date getBirthday() {
        return this.zzhh;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int getGender() {
        return this.zzbdw;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzhj;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.zzhl;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        if (this.zzapn == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzapn.zzbve).setImageOrientation(this.zzapn.zzbvf).setRequestMultipleImages(this.zzapn.zzbvg);
        if (this.zzapn.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(this.zzapn.zzbvh);
        }
        if (this.zzapn.versionCode >= 3 && this.zzapn.zzbvi != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(this.zzapn.zzbvi));
        }
        return requestMultipleImages.build();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAdMuted() {
        return zzly.zziq().zzdo();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAppInstallAdRequested() {
        List<String> list = this.zzapo;
        return list != null && list.contains(InternalAvidAdSessionContext.AVID_API_LEVEL);
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isContentAdRequested() {
        List<String> list = this.zzapo;
        return list != null && list.contains("1");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isDesignedForFamilies() {
        return this.zzbei;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzhk;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzcfm;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzmo() {
        List<String> list = this.zzapo;
        return list != null && list.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> zzmp() {
        return this.zzcfu;
    }
}
