package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.List;
import java.util.concurrent.Future;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzaau {
    public final ApplicationInfo applicationInfo;
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
    public final String zzcnu;
    public final float zzcnv;
    public final int zzcnw;
    public final int zzcnx;
    public final boolean zzcny;
    public final boolean zzcnz;
    public final boolean zzcob;
    public final String zzcoc;
    public final int zzcod;
    public final Bundle zzcoe;
    public final String zzcof;
    public final boolean zzcog;
    public final Bundle zzcoh;
    public final boolean zzcol;
    public final String zzcom;
    public final List<String> zzcon;
    public final int zzcoo;
    public final boolean zzcop;
    public final boolean zzcoq;
    public final boolean zzcor;
    public final Future<String> zzcos;
    public final Future<String> zzcot;

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zzc(int i, boolean z);

        void zzc(ConnectionResult connectionResult);

        void zzo(Bundle bundle);
    }

    public zzaau(Bundle bundle, zzjj zzjjVar, zzjn zzjnVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, zzakd zzakdVar, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i, int i2, float f, String str4, long j, String str5, List<String> list3, String str6, zzpe zzpeVar, String str7, float f2, boolean z2, int i3, int i4, boolean z3, boolean z4, Future<String> future, String str8, boolean z5, int i5, Bundle bundle4, String str9, zzlr zzlrVar, boolean z6, Bundle bundle5, boolean z7, Future<String> future2, List<Integer> list4, String str10, List<String> list5, int i6, boolean z8, boolean z9, boolean z10) {
        List<String> list6;
        this.zzcnc = bundle;
        this.zzcnd = zzjjVar;
        this.zzauc = zzjnVar;
        this.zzatw = str;
        this.applicationInfo = applicationInfo;
        this.zzcne = packageInfo;
        this.zzcng = str2;
        this.zzcnh = str3;
        this.zzaty = zzakdVar;
        this.zzcni = bundle2;
        this.zzcnl = z;
        this.zzcnm = i;
        this.zzcnn = i2;
        this.zzaxx = f;
        if (list == null || list.size() <= 0) {
            this.zzcnj = 0;
            list6 = null;
            this.zzauw = null;
        } else {
            this.zzcnj = 3;
            this.zzauw = list;
            list6 = list2;
        }
        this.zzcns = list6;
        this.zzcnk = bundle3;
        this.zzcno = str4;
        this.zzcnp = j;
        this.zzcnq = str5;
        this.zzcnr = list3;
        this.zzatv = str6;
        this.zzauo = zzpeVar;
        this.zzcnu = str7;
        this.zzcnv = f2;
        this.zzcob = z2;
        this.zzcnw = i3;
        this.zzcnx = i4;
        this.zzcny = z3;
        this.zzcnz = z4;
        this.zzcos = future;
        this.zzcoc = str8;
        this.zzcdo = z5;
        this.zzcod = i5;
        this.zzcoe = bundle4;
        this.zzcof = str9;
        this.zzauq = zzlrVar;
        this.zzcog = z6;
        this.zzcoh = bundle5;
        this.zzcol = z7;
        this.zzcot = future2;
        this.zzaus = list4;
        this.zzcom = str10;
        this.zzcon = list5;
        this.zzcoo = i6;
        this.zzcop = z8;
        this.zzcoq = z9;
        this.zzcor = z10;
    }
}
