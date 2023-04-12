package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class zzao extends zzbfm {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();
    public final boolean zzaqo;
    public final boolean zzaqp;
    private String zzaqq;
    public final boolean zzaqr;
    public final float zzaqs;
    public final int zzaqt;
    public final boolean zzaqu;
    public final boolean zzaqv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(boolean z, boolean z2, String str, boolean z3, float f, int i, boolean z4, boolean z5) {
        this.zzaqo = z;
        this.zzaqp = z2;
        this.zzaqq = str;
        this.zzaqr = z3;
        this.zzaqs = f;
        this.zzaqt = i;
        this.zzaqu = z4;
        this.zzaqv = z5;
    }

    public zzao(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5) {
        this(z, z2, null, z3, f, i, z4, z5);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzaqo);
        zzbfp.zza(parcel, 3, this.zzaqp);
        zzbfp.zza(parcel, 4, this.zzaqq, false);
        zzbfp.zza(parcel, 5, this.zzaqr);
        zzbfp.zza(parcel, 6, this.zzaqs);
        zzbfp.zzc(parcel, 7, this.zzaqt);
        zzbfp.zza(parcel, 8, this.zzaqu);
        zzbfp.zza(parcel, 9, this.zzaqv);
        zzbfp.zzai(parcel, zze);
    }
}
