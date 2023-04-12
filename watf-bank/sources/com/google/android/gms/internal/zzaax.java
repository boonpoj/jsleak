package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzaax extends zzbfm {
    public static final Parcelable.Creator<zzaax> CREATOR = new zzaay();
    public String body;
    public final int errorCode;
    public final int orientation;
    private int versionCode;
    public final boolean zzaqv;
    public final boolean zzben;
    public final boolean zzbeo;
    public final boolean zzbep;
    public final List<String> zzcdk;
    public final List<String> zzcdl;
    public final List<String> zzcdn;
    public final boolean zzcdo;
    public final long zzcdq;
    private zzaat zzcey;
    public final String zzcja;
    public final boolean zzcnl;
    public final boolean zzcnz;
    public String zzcoa;
    public final boolean zzcol;
    public final long zzcov;
    public final boolean zzcow;
    public final long zzcox;
    public final List<String> zzcoy;
    public final String zzcoz;
    public final long zzcpa;
    public final String zzcpb;
    public final boolean zzcpc;
    public final String zzcpd;
    public final String zzcpe;
    public final boolean zzcpf;
    public final boolean zzcpg;
    public final boolean zzcph;
    private zzabj zzcpi;
    public String zzcpj;
    public final String zzcpk;
    public final zzaeq zzcpl;
    public final List<String> zzcpm;
    public final List<String> zzcpn;
    public final boolean zzcpo;
    public final zzaaz zzcpp;
    public final String zzcpq;
    public final zzaey zzcpr;
    public final String zzcps;
    public final boolean zzcpt;
    private Bundle zzcpu;
    public final int zzcpv;

    public zzaax(int i) {
        this(19, null, null, null, i, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0);
    }

    public zzaax(int i, long j) {
        this(19, null, null, null, i, null, -1L, false, -1L, null, j, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaax(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, zzabj zzabjVar, String str7, String str8, boolean z8, boolean z9, zzaeq zzaeqVar, List<String> list4, List<String> list5, boolean z10, zzaaz zzaazVar, boolean z11, String str9, List<String> list6, boolean z12, String str10, zzaey zzaeyVar, String str11, boolean z13, boolean z14, Bundle bundle, boolean z15, int i4) {
        zzabj zzabjVar2;
        zzabx zzabxVar;
        this.versionCode = i;
        this.zzcja = str;
        this.body = str2;
        this.zzcdk = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzcdl = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzcov = j;
        this.zzcow = z;
        this.zzcox = j2;
        this.zzcoy = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzcdq = j3;
        this.orientation = i3;
        this.zzcoz = str3;
        this.zzcpa = j4;
        this.zzcpb = str4;
        this.zzcpc = z2;
        this.zzcpd = str5;
        this.zzcpe = str6;
        this.zzcpf = z3;
        this.zzben = z4;
        this.zzcnl = z5;
        this.zzcpg = z6;
        this.zzcpt = z13;
        this.zzcph = z7;
        this.zzcpi = zzabjVar;
        this.zzcpj = str7;
        this.zzcpk = str8;
        if (this.body == null && (zzabjVar2 = this.zzcpi) != null && (zzabxVar = (zzabx) zzabjVar2.zza(zzabx.CREATOR)) != null && !TextUtils.isEmpty(zzabxVar.zzbsw)) {
            this.body = zzabxVar.zzbsw;
        }
        this.zzbeo = z8;
        this.zzbep = z9;
        this.zzcpl = zzaeqVar;
        this.zzcpm = list4;
        this.zzcpn = list5;
        this.zzcpo = z10;
        this.zzcpp = zzaazVar;
        this.zzcnz = z11;
        this.zzcoa = str9;
        this.zzcdn = list6;
        this.zzcdo = z12;
        this.zzcpq = str10;
        this.zzcpr = zzaeyVar;
        this.zzcps = str11;
        this.zzcol = z14;
        this.zzcpu = bundle;
        this.zzaqv = z15;
        this.zzcpv = i4;
    }

    public zzaax(zzaat zzaatVar, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, zzaeq zzaeqVar, List<String> list4, List<String> list5, boolean z9, zzaaz zzaazVar, boolean z10, String str7, List<String> list6, boolean z11, String str8, zzaey zzaeyVar, String str9, boolean z12, boolean z13, boolean z14, int i2) {
        this(19, str, str2, list, -2, list2, j, z, -1L, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, false, null, null, str6, z7, z8, zzaeqVar, list4, list5, z9, zzaazVar, z10, str7, list6, z11, str8, zzaeyVar, str9, z12, z13, null, z14, i2);
        this.zzcey = zzaatVar;
    }

    public zzaax(zzaat zzaatVar, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, zzaeq zzaeqVar, List<String> list4, List<String> list5, boolean z10, zzaaz zzaazVar, boolean z11, String str8, List<String> list6, boolean z12, String str9, zzaey zzaeyVar, String str10, boolean z13, boolean z14, boolean z15, int i2) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, zzaeqVar, list4, list5, z10, zzaazVar, z11, str8, list6, z12, str9, zzaeyVar, str10, z13, z14, null, z15, 0);
        this.zzcey = zzaatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzaat zzaatVar = this.zzcey;
        if (zzaatVar != null && zzaatVar.versionCode >= 9 && !TextUtils.isEmpty(this.body)) {
            this.zzcpi = new zzabj(new zzabx(this.body));
            this.body = null;
        }
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.versionCode);
        zzbfp.zza(parcel, 2, this.zzcja, false);
        zzbfp.zza(parcel, 3, this.body, false);
        zzbfp.zzb(parcel, 4, this.zzcdk, false);
        zzbfp.zzc(parcel, 5, this.errorCode);
        zzbfp.zzb(parcel, 6, this.zzcdl, false);
        zzbfp.zza(parcel, 7, this.zzcov);
        zzbfp.zza(parcel, 8, this.zzcow);
        zzbfp.zza(parcel, 9, this.zzcox);
        zzbfp.zzb(parcel, 10, this.zzcoy, false);
        zzbfp.zza(parcel, 11, this.zzcdq);
        zzbfp.zzc(parcel, 12, this.orientation);
        zzbfp.zza(parcel, 13, this.zzcoz, false);
        zzbfp.zza(parcel, 14, this.zzcpa);
        zzbfp.zza(parcel, 15, this.zzcpb, false);
        zzbfp.zza(parcel, 18, this.zzcpc);
        zzbfp.zza(parcel, 19, this.zzcpd, false);
        zzbfp.zza(parcel, 21, this.zzcpe, false);
        zzbfp.zza(parcel, 22, this.zzcpf);
        zzbfp.zza(parcel, 23, this.zzben);
        zzbfp.zza(parcel, 24, this.zzcnl);
        zzbfp.zza(parcel, 25, this.zzcpg);
        zzbfp.zza(parcel, 26, this.zzcph);
        zzbfp.zza(parcel, 28, (Parcelable) this.zzcpi, i, false);
        zzbfp.zza(parcel, 29, this.zzcpj, false);
        zzbfp.zza(parcel, 30, this.zzcpk, false);
        zzbfp.zza(parcel, 31, this.zzbeo);
        zzbfp.zza(parcel, 32, this.zzbep);
        zzbfp.zza(parcel, 33, (Parcelable) this.zzcpl, i, false);
        zzbfp.zzb(parcel, 34, this.zzcpm, false);
        zzbfp.zzb(parcel, 35, this.zzcpn, false);
        zzbfp.zza(parcel, 36, this.zzcpo);
        zzbfp.zza(parcel, 37, (Parcelable) this.zzcpp, i, false);
        zzbfp.zza(parcel, 38, this.zzcnz);
        zzbfp.zza(parcel, 39, this.zzcoa, false);
        zzbfp.zzb(parcel, 40, this.zzcdn, false);
        zzbfp.zza(parcel, 42, this.zzcdo);
        zzbfp.zza(parcel, 43, this.zzcpq, false);
        zzbfp.zza(parcel, 44, (Parcelable) this.zzcpr, i, false);
        zzbfp.zza(parcel, 45, this.zzcps, false);
        zzbfp.zza(parcel, 46, this.zzcpt);
        zzbfp.zza(parcel, 47, this.zzcol);
        zzbfp.zza(parcel, 48, this.zzcpu, false);
        zzbfp.zza(parcel, 49, this.zzaqv);
        zzbfp.zzc(parcel, 50, this.zzcpv);
        zzbfp.zzai(parcel, zze);
    }
}
