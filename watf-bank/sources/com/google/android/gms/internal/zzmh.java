package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzmh implements Runnable {
    private /* synthetic */ zzmg zzbgt;

    @zzmb
    /* loaded from: assets/classes2.dex */
    public static final class zza {
        public final ApplicationInfo applicationInfo;
        public final boolean zzKc;
        public final boolean zzRA;
        public final boolean zzRB;
        public final String zzRC;
        public final boolean zzRD;
        public final String zzRE;
        public final int zzRF;
        public final Bundle zzRG;
        public final String zzRH;
        @Nullable
        public final Bundle zzRc;
        public final zzdy zzRd;
        @Nullable
        public final PackageInfo zzRe;
        public final String zzRg;
        public final String zzRh;
        public final Bundle zzRi;
        public final int zzRj;
        public final Bundle zzRk;
        public final boolean zzRl;
        public final Messenger zzRm;
        public final int zzRn;
        public final int zzRo;
        public final String zzRp;
        public final long zzRq;
        public final String zzRr;
        @Nullable
        public final List<String> zzRs;
        public final List<String> zzRt;
        public final zzmo zzRv;
        public final String zzRw;
        public final float zzRx;
        public final int zzRy;
        public final int zzRz;
        public final List<String> zzvB;
        public final String zzvc;
        public final String zzvd;
        public final zzqa zzvf;
        public final zzec zzvj;
        public final zzgw zzvx;
        public final float zzxa;

        public zza(@Nullable Bundle bundle, zzdy zzdyVar, zzec zzecVar, String str, ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo, String str2, String str3, zzqa zzqaVar, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, long j, String str5, @Nullable List<String> list3, String str6, zzgw zzgwVar, zzmo zzmoVar, String str7, float f2, boolean z2, int i3, int i4, boolean z3, boolean z4, String str8, String str9, boolean z5, int i5, Bundle bundle4, String str10) {
            List<String> list4;
            this.zzRc = bundle;
            this.zzRd = zzdyVar;
            this.zzvj = zzecVar;
            this.zzvd = str;
            this.applicationInfo = applicationInfo;
            this.zzRe = packageInfo;
            this.zzRg = str2;
            this.zzRh = str3;
            this.zzvf = zzqaVar;
            this.zzRi = bundle2;
            this.zzRl = z;
            this.zzRm = messenger;
            this.zzRn = i;
            this.zzRo = i2;
            this.zzxa = f;
            if (list == null || list.size() <= 0) {
                this.zzRj = 0;
                list4 = null;
                this.zzvB = null;
            } else {
                this.zzRj = 3;
                this.zzvB = list;
                list4 = list2;
            }
            this.zzRt = list4;
            this.zzRk = bundle3;
            this.zzRp = str4;
            this.zzRq = j;
            this.zzRr = str5;
            this.zzRs = list3;
            this.zzvc = str6;
            this.zzvx = zzgwVar;
            this.zzRv = zzmoVar;
            this.zzRw = str7;
            this.zzRx = f2;
            this.zzRD = z2;
            this.zzRy = i3;
            this.zzRz = i4;
            this.zzRA = z3;
            this.zzRB = z4;
            this.zzRC = str8;
            this.zzRE = str9;
            this.zzKc = z5;
            this.zzRF = i5;
            this.zzRG = bundle4;
            this.zzRH = str10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmh(zzmg zzmgVar) {
        this.zzbgt = zzmgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzmg.zza(this.zzbgt) != null) {
            try {
                zzmg.zza(this.zzbgt).onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzakb.zzc("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
