package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: assets/classes2.dex */
public class zzawe extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzawe> CREATOR = new zzawf();
    public final String packageName;
    public final int versionCode;
    public final String zzbzA;
    public final String zzbzB;
    public final boolean zzbzC;
    public final String zzbzD;
    public final boolean zzbzE;
    public final int zzbzF;
    public final int zzbzy;
    public final int zzbzz;

    public zzawe(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.versionCode = i;
        this.packageName = str;
        this.zzbzy = i2;
        this.zzbzz = i3;
        this.zzbzA = str2;
        this.zzbzB = str3;
        this.zzbzC = z;
        this.zzbzD = str4;
        this.zzbzE = z2;
        this.zzbzF = i4;
    }

    public zzawe(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.versionCode = 1;
        this.packageName = (String) com.google.android.gms.common.internal.zzac.zzw(str);
        this.zzbzy = i;
        this.zzbzz = i2;
        this.zzbzD = str2;
        this.zzbzA = str3;
        this.zzbzB = str4;
        this.zzbzC = !z;
        this.zzbzE = z;
        this.zzbzF = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzawe) {
            zzawe zzaweVar = (zzawe) obj;
            return this.versionCode == zzaweVar.versionCode && this.packageName.equals(zzaweVar.packageName) && this.zzbzy == zzaweVar.zzbzy && this.zzbzz == zzaweVar.zzbzz && com.google.android.gms.common.internal.zzaa.equal(this.zzbzD, zzaweVar.zzbzD) && com.google.android.gms.common.internal.zzaa.equal(this.zzbzA, zzaweVar.zzbzA) && com.google.android.gms.common.internal.zzaa.equal(this.zzbzB, zzaweVar.zzbzB) && this.zzbzC == zzaweVar.zzbzC && this.zzbzE == zzaweVar.zzbzE && this.zzbzF == zzaweVar.zzbzF;
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzaa.hashCode(new Object[]{Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.zzbzy), Integer.valueOf(this.zzbzz), this.zzbzD, this.zzbzA, this.zzbzB, Boolean.valueOf(this.zzbzC), Boolean.valueOf(this.zzbzE), Integer.valueOf(this.zzbzF)});
    }

    public String toString() {
        return "PlayLoggerContext[versionCode=" + this.versionCode + ",package=" + this.packageName + ",packageVersionCode=" + this.zzbzy + ",logSource=" + this.zzbzz + ",logSourceName=" + this.zzbzD + ",uploadAccount=" + this.zzbzA + ",loggingId=" + this.zzbzB + ",logAndroidId=" + this.zzbzC + ",isAnonymous=" + this.zzbzE + ",qosTier=" + this.zzbzF + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzawf.zza(this, parcel, i);
    }
}
