package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzaba implements Parcelable.Creator<zzaaz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaaz createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 2) {
                z = zzbfn.zzc(parcel, readInt);
            } else if (i != 3) {
                zzbfn.zzb(parcel, readInt);
            } else {
                arrayList = zzbfn.zzac(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzaaz(z, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaaz[] newArray(int i) {
        return new zzaaz[i];
    }
}
