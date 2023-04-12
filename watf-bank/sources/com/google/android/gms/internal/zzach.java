package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzach {
    private final Context mContext;
    private String zzcrt;
    private String zzcru;
    private final Object mLock = new Object();
    private zzalf<zzacn> zzcrv = new zzalf<>();
    private com.google.android.gms.ads.internal.gmsg.zzt<Object> zzcrw = new zzaci(this);
    private com.google.android.gms.ads.internal.gmsg.zzt<Object> zzcrx = new zzacj(this);
    private com.google.android.gms.ads.internal.gmsg.zzt<Object> zzcry = new zzack(this);

    /* loaded from: assets/classes2.dex */
    public static final class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Parcelable.Creator<zza> CREATOR = new zzacj();
        final int versionCode;
        final String zzaFy;
        final int zzaFz;

        zza(int i, String str, int i2) {
            this.versionCode = i;
            this.zzaFy = str;
            this.zzaFz = i2;
        }

        zza(String str, int i) {
            this.versionCode = 1;
            this.zzaFy = str;
            this.zzaFz = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzacj.zza(this, parcel, i);
        }
    }

    public zzach(Context context, String str, String str2) {
        this.mContext = context;
        this.zzcru = str2;
        this.zzcrt = str;
    }
}
