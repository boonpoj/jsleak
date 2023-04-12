package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzao;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzbfn;
/* loaded from: classes.dex */
public final class zzm implements Parcelable.Creator<AdOverlayInfoParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        zzc zzcVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        String str2 = null;
        IBinder iBinder5 = null;
        String str3 = null;
        zzakd zzakdVar = null;
        String str4 = null;
        zzao zzaoVar = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    zzcVar = (zzc) zzbfn.zza(parcel, readInt, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = zzbfn.zzr(parcel, readInt);
                    break;
                case 4:
                    iBinder2 = zzbfn.zzr(parcel, readInt);
                    break;
                case 5:
                    iBinder3 = zzbfn.zzr(parcel, readInt);
                    break;
                case 6:
                    iBinder4 = zzbfn.zzr(parcel, readInt);
                    break;
                case 7:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 8:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 10:
                    iBinder5 = zzbfn.zzr(parcel, readInt);
                    break;
                case 11:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 12:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 13:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 14:
                    zzakdVar = (zzakd) zzbfn.zza(parcel, readInt, zzakd.CREATOR);
                    break;
                case 15:
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
                case 16:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 17:
                    zzaoVar = (zzao) zzbfn.zza(parcel, readInt, zzao.CREATOR);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new AdOverlayInfoParcel(zzcVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, zzakdVar, str4, zzaoVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
