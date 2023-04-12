package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzaay implements Parcelable.Creator<zzaax> {

    /* renamed from: com.google.android.gms.internal.zzaay$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String zzO;
        final /* synthetic */ zzaaw zzaBw;

        AnonymousClass1(zzaaw zzaawVar, String str) {
            this.zzaBw = zzaawVar;
            this.zzO = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzaay.zza(zzaay.this) >= 1) {
                this.zzaBw.onCreate(zzaay.zzb(zzaay.this) != null ? zzaay.zzb(zzaay.this).getBundle(this.zzO) : null);
            }
            if (zzaay.zza(zzaay.this) >= 2) {
                this.zzaBw.onStart();
            }
            if (zzaay.zza(zzaay.this) >= 3) {
                this.zzaBw.onStop();
            }
            if (zzaay.zza(zzaay.this) >= 4) {
                this.zzaBw.onDestroy();
            }
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaax createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        zzabj zzabjVar = null;
        String str7 = null;
        String str8 = null;
        zzaeq zzaeqVar = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        zzaaz zzaazVar = null;
        String str9 = null;
        ArrayList<String> arrayList6 = null;
        String str10 = null;
        zzaey zzaeyVar = null;
        String str11 = null;
        Bundle bundle = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        int i4 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    arrayList = zzbfn.zzac(parcel, readInt);
                    break;
                case 5:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 6:
                    arrayList2 = zzbfn.zzac(parcel, readInt);
                    break;
                case 7:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 8:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    j2 = zzbfn.zzi(parcel, readInt);
                    break;
                case 10:
                    arrayList3 = zzbfn.zzac(parcel, readInt);
                    break;
                case 11:
                    j3 = zzbfn.zzi(parcel, readInt);
                    break;
                case 12:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 13:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 14:
                    j4 = zzbfn.zzi(parcel, readInt);
                    break;
                case 15:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 16:
                case 17:
                case 20:
                case 27:
                case 41:
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
                case 18:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 19:
                    str5 = zzbfn.zzq(parcel, readInt);
                    break;
                case 21:
                    str6 = zzbfn.zzq(parcel, readInt);
                    break;
                case 22:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 23:
                    z4 = zzbfn.zzc(parcel, readInt);
                    break;
                case 24:
                    z5 = zzbfn.zzc(parcel, readInt);
                    break;
                case 25:
                    z6 = zzbfn.zzc(parcel, readInt);
                    break;
                case 26:
                    z7 = zzbfn.zzc(parcel, readInt);
                    break;
                case 28:
                    zzabjVar = (zzabj) zzbfn.zza(parcel, readInt, zzabj.CREATOR);
                    break;
                case 29:
                    str7 = zzbfn.zzq(parcel, readInt);
                    break;
                case 30:
                    str8 = zzbfn.zzq(parcel, readInt);
                    break;
                case 31:
                    z8 = zzbfn.zzc(parcel, readInt);
                    break;
                case 32:
                    z9 = zzbfn.zzc(parcel, readInt);
                    break;
                case 33:
                    zzaeqVar = (zzaeq) zzbfn.zza(parcel, readInt, zzaeq.CREATOR);
                    break;
                case 34:
                    arrayList4 = zzbfn.zzac(parcel, readInt);
                    break;
                case 35:
                    arrayList5 = zzbfn.zzac(parcel, readInt);
                    break;
                case 36:
                    z10 = zzbfn.zzc(parcel, readInt);
                    break;
                case 37:
                    zzaazVar = (zzaaz) zzbfn.zza(parcel, readInt, zzaaz.CREATOR);
                    break;
                case 38:
                    z11 = zzbfn.zzc(parcel, readInt);
                    break;
                case 39:
                    str9 = zzbfn.zzq(parcel, readInt);
                    break;
                case 40:
                    arrayList6 = zzbfn.zzac(parcel, readInt);
                    break;
                case 42:
                    z12 = zzbfn.zzc(parcel, readInt);
                    break;
                case 43:
                    str10 = zzbfn.zzq(parcel, readInt);
                    break;
                case 44:
                    zzaeyVar = (zzaey) zzbfn.zza(parcel, readInt, zzaey.CREATOR);
                    break;
                case 45:
                    str11 = zzbfn.zzq(parcel, readInt);
                    break;
                case 46:
                    z13 = zzbfn.zzc(parcel, readInt);
                    break;
                case 47:
                    z14 = zzbfn.zzc(parcel, readInt);
                    break;
                case 48:
                    bundle = zzbfn.zzs(parcel, readInt);
                    break;
                case 49:
                    z15 = zzbfn.zzc(parcel, readInt);
                    break;
                case 50:
                    i4 = zzbfn.zzg(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzaax(i, str, str2, arrayList, i2, arrayList2, j, z, j2, arrayList3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, zzabjVar, str7, str8, z8, z9, zzaeqVar, arrayList4, arrayList5, z10, zzaazVar, z11, str9, arrayList6, z12, str10, zzaeyVar, str11, z13, z14, bundle, z15, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaax[] newArray(int i) {
        return new zzaax[i];
    }
}
