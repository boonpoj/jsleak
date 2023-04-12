package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzls implements Parcelable.Creator<zzlr> {

    /* renamed from: com.google.android.gms.internal.zzls$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzov zzsW;

        AnonymousClass1(zzov zzovVar) {
            this.zzsW = zzovVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzls.zza(zzls.this).zzb(this.zzsW);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzlr createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                zzbfn.zzb(parcel, readInt);
            } else {
                i = zzbfn.zzg(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzlr(i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzlr[] newArray(int i) {
        return new zzlr[i];
    }
}
