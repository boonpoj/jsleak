package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
/* loaded from: classes.dex */
public final class Scope extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzf();
    private int zzeck;
    private final String zzfnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scope(int i, String str) {
        zzbq.zzh(str, "scopeUri must not be null or empty");
        this.zzeck = i;
        this.zzfnh = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.zzfnh.equals(((Scope) obj).zzfnh);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzfnh.hashCode();
    }

    public final String toString() {
        return this.zzfnh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, this.zzfnh, false);
        zzbfp.zzai(parcel, zze);
    }

    public final String zzagw() {
        return this.zzfnh;
    }
}
