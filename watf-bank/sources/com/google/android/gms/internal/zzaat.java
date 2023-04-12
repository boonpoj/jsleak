package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzaat extends zzbfm {
    public static final Parcelable.Creator<zzaat> CREATOR = new zzaav();
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final String zzatv;
    public final String zzatw;
    public final zzakd zzaty;
    public final zzjn zzauc;
    public final zzpe zzauo;
    public final zzlr zzauq;
    public final List<Integer> zzaus;
    public final List<String> zzauw;
    public final float zzaxx;
    public final boolean zzcdo;
    public final Bundle zzcnc;
    public final zzjj zzcnd;
    public final PackageInfo zzcne;
    public final String zzcnf;
    public final String zzcng;
    public final String zzcnh;
    public final Bundle zzcni;
    public final int zzcnj;
    public final Bundle zzcnk;
    public final boolean zzcnl;
    public final int zzcnm;
    public final int zzcnn;
    public final String zzcno;
    public final long zzcnp;
    public final String zzcnq;
    public final List<String> zzcnr;
    public final List<String> zzcns;
    public final long zzcnt;
    public final String zzcnu;
    public final float zzcnv;
    public final int zzcnw;
    public final int zzcnx;
    public final boolean zzcny;
    public final boolean zzcnz;
    public final String zzcoa;
    public final boolean zzcob;
    public final String zzcoc;
    public final int zzcod;
    public final Bundle zzcoe;
    public final String zzcof;
    public final boolean zzcog;
    public final Bundle zzcoh;
    public final String zzcoi;
    public final String zzcoj;
    public final String zzcok;
    public final boolean zzcol;
    public final String zzcom;
    public final List<String> zzcon;
    public final int zzcoo;
    public final boolean zzcop;
    public final boolean zzcoq;
    public final boolean zzcor;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzaat {

        /* renamed from: com.google.android.gms.internal.zzaat$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0002zza implements zzaat {
            private IBinder zzrp;

            C0002zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zzp(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.api.internal.IStatusCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public static zzaat zzbp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaat)) ? new C0002zza(iBinder) : (zzaat) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.common.api.internal.IStatusCallback");
                zzp(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.android.gms.common.api.internal.IStatusCallback");
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaat(int i, Bundle bundle, zzjj zzjjVar, zzjn zzjnVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzakd zzakdVar, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, zzpe zzpeVar, List<String> list3, long j2, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4, String str11, zzlr zzlrVar, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i8, boolean z8, boolean z9, boolean z10) {
        this.versionCode = i;
        this.zzcnc = bundle;
        this.zzcnd = zzjjVar;
        this.zzauc = zzjnVar;
        this.zzatw = str;
        this.applicationInfo = applicationInfo;
        this.zzcne = packageInfo;
        this.zzcnf = str2;
        this.zzcng = str3;
        this.zzcnh = str4;
        this.zzaty = zzakdVar;
        this.zzcni = bundle2;
        this.zzcnj = i2;
        this.zzauw = list;
        this.zzcns = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzcnk = bundle3;
        this.zzcnl = z;
        this.zzcnm = i3;
        this.zzcnn = i4;
        this.zzaxx = f;
        this.zzcno = str5;
        this.zzcnp = j;
        this.zzcnq = str6;
        this.zzcnr = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzatv = str7;
        this.zzauo = zzpeVar;
        this.zzcnt = j2;
        this.zzcnu = str8;
        this.zzcnv = f2;
        this.zzcob = z2;
        this.zzcnw = i5;
        this.zzcnx = i6;
        this.zzcny = z3;
        this.zzcnz = z4;
        this.zzcoa = str9;
        this.zzcoc = str10;
        this.zzcdo = z5;
        this.zzcod = i7;
        this.zzcoe = bundle4;
        this.zzcof = str11;
        this.zzauq = zzlrVar;
        this.zzcog = z6;
        this.zzcoh = bundle5;
        this.zzcoi = str12;
        this.zzcoj = str13;
        this.zzcok = str14;
        this.zzcol = z7;
        this.zzaus = list4;
        this.zzcom = str15;
        this.zzcon = list5;
        this.zzcoo = i8;
        this.zzcop = z8;
        this.zzcoq = z9;
        this.zzcor = z10;
    }

    private zzaat(Bundle bundle, zzjj zzjjVar, zzjn zzjnVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzakd zzakdVar, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f, String str5, long j, String str6, List<String> list3, String str7, zzpe zzpeVar, long j2, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, zzlr zzlrVar, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i7, boolean z8, boolean z9, boolean z10) {
        this(24, bundle, zzjjVar, zzjnVar, str, applicationInfo, packageInfo, str2, str3, str4, zzakdVar, bundle2, i, list, bundle3, z, i2, i3, f, str5, j, str6, list3, str7, zzpeVar, list2, j2, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, zzlrVar, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i7, z8, z9, z10);
    }

    public zzaat(zzaau zzaauVar, long j, String str, String str2, String str3) {
        this(zzaauVar.zzcnc, zzaauVar.zzcnd, zzaauVar.zzauc, zzaauVar.zzatw, zzaauVar.applicationInfo, zzaauVar.zzcne, (String) zzakl.zza(zzaauVar.zzcot, ""), zzaauVar.zzcng, zzaauVar.zzcnh, zzaauVar.zzaty, zzaauVar.zzcni, zzaauVar.zzcnj, zzaauVar.zzauw, zzaauVar.zzcns, zzaauVar.zzcnk, zzaauVar.zzcnl, zzaauVar.zzcnm, zzaauVar.zzcnn, zzaauVar.zzaxx, zzaauVar.zzcno, zzaauVar.zzcnp, zzaauVar.zzcnq, zzaauVar.zzcnr, zzaauVar.zzatv, zzaauVar.zzauo, j, zzaauVar.zzcnu, zzaauVar.zzcnv, zzaauVar.zzcob, zzaauVar.zzcnw, zzaauVar.zzcnx, zzaauVar.zzcny, zzaauVar.zzcnz, (String) zzakl.zza(zzaauVar.zzcos, "", 1L, TimeUnit.SECONDS), zzaauVar.zzcoc, zzaauVar.zzcdo, zzaauVar.zzcod, zzaauVar.zzcoe, zzaauVar.zzcof, zzaauVar.zzauq, zzaauVar.zzcog, zzaauVar.zzcoh, str, str2, str3, zzaauVar.zzcol, zzaauVar.zzaus, zzaauVar.zzcom, zzaauVar.zzcon, zzaauVar.zzcoo, zzaauVar.zzcop, zzaauVar.zzcoq, zzaauVar.zzcor);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.versionCode);
        zzbfp.zza(parcel, 2, this.zzcnc, false);
        zzbfp.zza(parcel, 3, (Parcelable) this.zzcnd, i, false);
        zzbfp.zza(parcel, 4, (Parcelable) this.zzauc, i, false);
        zzbfp.zza(parcel, 5, this.zzatw, false);
        zzbfp.zza(parcel, 6, (Parcelable) this.applicationInfo, i, false);
        zzbfp.zza(parcel, 7, (Parcelable) this.zzcne, i, false);
        zzbfp.zza(parcel, 8, this.zzcnf, false);
        zzbfp.zza(parcel, 9, this.zzcng, false);
        zzbfp.zza(parcel, 10, this.zzcnh, false);
        zzbfp.zza(parcel, 11, (Parcelable) this.zzaty, i, false);
        zzbfp.zza(parcel, 12, this.zzcni, false);
        zzbfp.zzc(parcel, 13, this.zzcnj);
        zzbfp.zzb(parcel, 14, this.zzauw, false);
        zzbfp.zza(parcel, 15, this.zzcnk, false);
        zzbfp.zza(parcel, 16, this.zzcnl);
        zzbfp.zzc(parcel, 18, this.zzcnm);
        zzbfp.zzc(parcel, 19, this.zzcnn);
        zzbfp.zza(parcel, 20, this.zzaxx);
        zzbfp.zza(parcel, 21, this.zzcno, false);
        zzbfp.zza(parcel, 25, this.zzcnp);
        zzbfp.zza(parcel, 26, this.zzcnq, false);
        zzbfp.zzb(parcel, 27, this.zzcnr, false);
        zzbfp.zza(parcel, 28, this.zzatv, false);
        zzbfp.zza(parcel, 29, (Parcelable) this.zzauo, i, false);
        zzbfp.zzb(parcel, 30, this.zzcns, false);
        zzbfp.zza(parcel, 31, this.zzcnt);
        zzbfp.zza(parcel, 33, this.zzcnu, false);
        zzbfp.zza(parcel, 34, this.zzcnv);
        zzbfp.zzc(parcel, 35, this.zzcnw);
        zzbfp.zzc(parcel, 36, this.zzcnx);
        zzbfp.zza(parcel, 37, this.zzcny);
        zzbfp.zza(parcel, 38, this.zzcnz);
        zzbfp.zza(parcel, 39, this.zzcoa, false);
        zzbfp.zza(parcel, 40, this.zzcob);
        zzbfp.zza(parcel, 41, this.zzcoc, false);
        zzbfp.zza(parcel, 42, this.zzcdo);
        zzbfp.zzc(parcel, 43, this.zzcod);
        zzbfp.zza(parcel, 44, this.zzcoe, false);
        zzbfp.zza(parcel, 45, this.zzcof, false);
        zzbfp.zza(parcel, 46, (Parcelable) this.zzauq, i, false);
        zzbfp.zza(parcel, 47, this.zzcog);
        zzbfp.zza(parcel, 48, this.zzcoh, false);
        zzbfp.zza(parcel, 49, this.zzcoi, false);
        zzbfp.zza(parcel, 50, this.zzcoj, false);
        zzbfp.zza(parcel, 51, this.zzcok, false);
        zzbfp.zza(parcel, 52, this.zzcol);
        zzbfp.zza(parcel, 53, this.zzaus, false);
        zzbfp.zza(parcel, 54, this.zzcom, false);
        zzbfp.zzb(parcel, 55, this.zzcon, false);
        zzbfp.zzc(parcel, 56, this.zzcoo);
        zzbfp.zza(parcel, 57, this.zzcop);
        zzbfp.zza(parcel, 58, this.zzcoq);
        zzbfp.zza(parcel, 59, this.zzcor);
        zzbfp.zzai(parcel, zze);
    }
}
