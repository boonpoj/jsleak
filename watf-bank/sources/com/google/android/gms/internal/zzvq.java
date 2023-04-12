package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;
@zzzv
/* loaded from: classes.dex */
public final class zzvq implements MediationAdRequest {
    private final int zzbdw;
    private final boolean zzbei;
    private final int zzcfm;
    private final Date zzhh;
    private final Set<String> zzhj;
    private final boolean zzhk;
    private final Location zzhl;

    public zzvq(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2) {
        this.zzhh = date;
        this.zzbdw = i;
        this.zzhj = set;
        this.zzhl = location;
        this.zzhk = z;
        this.zzcfm = i2;
        this.zzbei = z2;
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
}
