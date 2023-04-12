package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzabx extends zzbfm {
    public static final Parcelable.Creator<zzabx> CREATOR = new zzaby();
    String zzbsw;

    /* renamed from: com.google.android.gms.internal.zzabx$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 extends Api.zza<zzacb, Api.ApiOptions.NoOptions> {
        AnonymousClass1() {
        }

        /* renamed from: zzf */
        public zzacb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzgVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzacb(context, looper, zzgVar, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zzabx(String str) {
        this.zzbsw = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzbsw, false);
        zzbfp.zzai(parcel, zze);
    }
}
