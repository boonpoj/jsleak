package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.NativeAdOptions;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzpe extends zzbfm {
    public static final Parcelable.Creator<zzpe> CREATOR = new zzpf();
    public final int versionCode;
    public final boolean zzbve;
    public final int zzbvf;
    public final boolean zzbvg;
    public final int zzbvh;
    public final zzmr zzbvi;

    public zzpe(int i, boolean z, int i2, boolean z2, int i3, zzmr zzmrVar) {
        this.versionCode = i;
        this.zzbve = z;
        this.zzbvf = i2;
        this.zzbvg = z2;
        this.zzbvh = i3;
        this.zzbvi = zzmrVar;
    }

    public zzpe(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzmr(nativeAdOptions.getVideoOptions()) : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.versionCode);
        zzbfp.zza(parcel, 2, this.zzbve);
        zzbfp.zzc(parcel, 3, this.zzbvf);
        zzbfp.zza(parcel, 4, this.zzbvg);
        zzbfp.zzc(parcel, 5, this.zzbvh);
        zzbfp.zza(parcel, 6, (Parcelable) this.zzbvi, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
