package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzabm extends zzbfm {
    public static final Parcelable.Creator<zzabm> CREATOR = new zzabn();
    private ApplicationInfo applicationInfo;
    private String packageName;
    private PackageInfo zzcne;
    private List<String> zzcnr;
    private String zzcoa;
    private Bundle zzcqd;
    private zzakd zzcqe;
    private boolean zzcqf;
    private String zzcqg;

    /* renamed from: com.google.android.gms.internal.zzabm$1  reason: invalid class name */
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
            if (zzabm.zza(zzabm.this) >= 1) {
                this.zzaBw.onCreate(zzabm.zzb(zzabm.this) != null ? zzabm.zzb(zzabm.this).getBundle(this.zzO) : null);
            }
            if (zzabm.zza(zzabm.this) >= 2) {
                this.zzaBw.onStart();
            }
            if (zzabm.zza(zzabm.this) >= 3) {
                this.zzaBw.onStop();
            }
            if (zzabm.zza(zzabm.this) >= 4) {
                this.zzaBw.onDestroy();
            }
        }
    }

    public zzabm(Bundle bundle, zzakd zzakdVar, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, String str2, boolean z, String str3) {
        this.zzcqd = bundle;
        this.zzcqe = zzakdVar;
        this.packageName = str;
        this.applicationInfo = applicationInfo;
        this.zzcnr = list;
        this.zzcne = packageInfo;
        this.zzcoa = str2;
        this.zzcqf = z;
        this.zzcqg = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzcqd, false);
        zzbfp.zza(parcel, 2, (Parcelable) this.zzcqe, i, false);
        zzbfp.zza(parcel, 3, (Parcelable) this.applicationInfo, i, false);
        zzbfp.zza(parcel, 4, this.packageName, false);
        zzbfp.zzb(parcel, 5, this.zzcnr, false);
        zzbfp.zza(parcel, 6, (Parcelable) this.zzcne, i, false);
        zzbfp.zza(parcel, 7, this.zzcoa, false);
        zzbfp.zza(parcel, 8, this.zzcqf);
        zzbfp.zza(parcel, 9, this.zzcqg, false);
        zzbfp.zzai(parcel, zze);
    }
}
