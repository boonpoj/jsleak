package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzij implements Parcelable.Creator<zzii> {

    /* renamed from: com.google.android.gms.internal.zzij$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.ads.internal.zzv.zzdg().zzb(zzij.this);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzii createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                zzbfn.zzb(parcel, readInt);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) zzbfn.zza(parcel, readInt, ParcelFileDescriptor.CREATOR);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzii(parcelFileDescriptor);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzii[] newArray(int i) {
        return new zzii[i];
    }
}
