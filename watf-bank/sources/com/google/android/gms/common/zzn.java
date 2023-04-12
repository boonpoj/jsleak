package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzau;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
/* loaded from: classes.dex */
public final class zzn extends zzbfm {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();
    private final String zzflg;
    private final zzh zzflh;
    private final boolean zzfli;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(String str, IBinder iBinder, boolean z) {
        this.zzflg = str;
        this.zzflh = zzak(iBinder);
        this.zzfli = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(String str, zzh zzhVar, boolean z) {
        this.zzflg = str;
        this.zzflh = zzhVar;
        this.zzfli = z;
    }

    private static zzh zzak(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper zzaga = zzau.zzam(iBinder).zzaga();
            byte[] bArr = zzaga == null ? null : (byte[]) com.google.android.gms.dynamic.zzn.zzx(zzaga);
            if (bArr != null) {
                return new zzi(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzflg, false);
        zzh zzhVar = this.zzflh;
        if (zzhVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            asBinder = null;
        } else {
            asBinder = zzhVar.asBinder();
        }
        zzbfp.zza(parcel, 2, asBinder, false);
        zzbfp.zza(parcel, 3, this.zzfli);
        zzbfp.zzai(parcel, zze);
    }
}
