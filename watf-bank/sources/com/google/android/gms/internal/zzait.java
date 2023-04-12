package com.google.android.gms.internal;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class zzait {
    public final int count;
    public final String name;
    private double zzdcd;
    private double zzdce;
    public final double zzdcf;

    public zzait(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzdce = d;
        this.zzdcd = d2;
        this.zzdcf = d3;
        this.count = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzait) {
            zzait zzaitVar = (zzait) obj;
            return com.google.android.gms.common.internal.zzbg.equal(this.name, zzaitVar.name) && this.zzdcd == zzaitVar.zzdcd && this.zzdce == zzaitVar.zzdce && this.count == zzaitVar.count && Double.compare(this.zzdcf, zzaitVar.zzdcf) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, Double.valueOf(this.zzdcd), Double.valueOf(this.zzdce), Double.valueOf(this.zzdcf), Integer.valueOf(this.count)});
    }

    public final String toString() {
        return com.google.android.gms.common.internal.zzbg.zzx(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzdce)).zzg("maxBound", Double.valueOf(this.zzdcd)).zzg("percent", Double.valueOf(this.zzdcf)).zzg("count", Integer.valueOf(this.count)).toString();
    }
}
