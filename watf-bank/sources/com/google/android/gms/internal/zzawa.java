package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: assets/classes2.dex */
public class zzawa extends com.google.android.gms.common.internal.safeparcel.zza implements Comparable<zzawa> {
    public static final Parcelable.Creator<zzawa> CREATOR = new zzawb();
    final int mVersionCode;
    public final int zzbzp;
    public final zzawc[] zzbzq;
    public final String[] zzbzr;
    public final Map<String, zzawc> zzbzs = new TreeMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawa(int i, int i2, zzawc[] zzawcVarArr, String[] strArr) {
        this.mVersionCode = i;
        this.zzbzp = i2;
        this.zzbzq = zzawcVarArr;
        for (zzawc zzawcVar : zzawcVarArr) {
            this.zzbzs.put(zzawcVar.name, zzawcVar);
        }
        this.zzbzr = strArr;
        if (this.zzbzr != null) {
            Arrays.sort(this.zzbzr);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzawa)) {
            return false;
        }
        zzawa zzawaVar = (zzawa) obj;
        return this.mVersionCode == zzawaVar.mVersionCode && this.zzbzp == zzawaVar.zzbzp && com.google.android.gms.common.internal.zzaa.equal(this.zzbzs, zzawaVar.zzbzs) && Arrays.equals(this.zzbzr, zzawaVar.zzbzr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Configuration(");
        sb.append(this.mVersionCode);
        sb.append(", ");
        sb.append(this.zzbzp);
        sb.append(", ");
        sb.append("(");
        for (zzawc zzawcVar : this.zzbzs.values()) {
            sb.append(zzawcVar);
            sb.append(", ");
        }
        sb.append(")");
        sb.append(", ");
        sb.append("(");
        if (this.zzbzr != null) {
            for (String str : this.zzbzr) {
                sb.append(str);
                sb.append(", ");
            }
        } else {
            sb.append("null");
        }
        sb.append(")");
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzawb.zza(this, parcel, i);
    }

    @Override // java.lang.Comparable
    /* renamed from: zza */
    public int compareTo(zzawa zzawaVar) {
        return this.zzbzp - zzawaVar.zzbzp;
    }
}
