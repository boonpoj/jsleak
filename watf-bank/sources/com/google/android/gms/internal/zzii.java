package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.InputStream;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzii extends zzbfm {
    public static final Parcelable.Creator<zzii> CREATOR = new zzij();
    private ParcelFileDescriptor zzbax;

    public zzii() {
        this(null);
    }

    public zzii(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbax = parcelFileDescriptor;
    }

    private synchronized ParcelFileDescriptor zzhh() {
        return this.zzbax;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, (Parcelable) zzhh(), i, false);
        zzbfp.zzai(parcel, zze);
    }

    public final synchronized boolean zzhf() {
        return this.zzbax != null;
    }

    public final synchronized InputStream zzhg() {
        if (this.zzbax == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbax);
        this.zzbax = null;
        return autoCloseInputStream;
    }
}
