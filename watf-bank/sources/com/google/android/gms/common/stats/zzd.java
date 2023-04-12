package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzd implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
                case 4:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 5:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 6:
                    arrayList = zzbfn.zzac(parcel, readInt);
                    break;
                case 8:
                    j2 = zzbfn.zzi(parcel, readInt);
                    break;
                case 10:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 11:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 12:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 13:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 14:
                    i4 = zzbfn.zzg(parcel, readInt);
                    break;
                case 15:
                    f = zzbfn.zzl(parcel, readInt);
                    break;
                case 16:
                    j3 = zzbfn.zzi(parcel, readInt);
                    break;
                case 17:
                    str5 = zzbfn.zzq(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3, str5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
