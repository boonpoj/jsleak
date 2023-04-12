package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: assets/classes2.dex */
public final class zzapv extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzapv> CREATOR = new zzapw();
    public final String packageName;
    public final int versionCode;
    public final String zzbfF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapv(int i, String str, String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzbfF = str2;
    }

    public zzapv(String str, String str2) {
        this(1, str, str2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzapw.zza(this, parcel, i);
    }
}
