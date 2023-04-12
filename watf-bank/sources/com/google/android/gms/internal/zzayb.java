package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
/* loaded from: assets/classes2.dex */
public class zzayb extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzayb> CREATOR = new zzayc();
    final int mVersionCode;
    private final ConnectionResult zzaFh;
    private final com.google.android.gms.common.internal.zzaf zzbCs;

    public zzayb(int i) {
        this(new ConnectionResult(i, null), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzayb(int i, ConnectionResult connectionResult, com.google.android.gms.common.internal.zzaf zzafVar) {
        this.mVersionCode = i;
        this.zzaFh = connectionResult;
        this.zzbCs = zzafVar;
    }

    public zzayb(ConnectionResult connectionResult, com.google.android.gms.common.internal.zzaf zzafVar) {
        this(1, connectionResult, zzafVar);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzayc.zza(this, parcel, i);
    }

    public com.google.android.gms.common.internal.zzaf zzOp() {
        return this.zzbCs;
    }

    public ConnectionResult zzxA() {
        return this.zzaFh;
    }
}
