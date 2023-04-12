package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzaco {
    public final float zzaxx;
    public final int zzcnm;
    public final int zzcnn;
    public final int zzctl;
    public final boolean zzctm;
    public final boolean zzctn;
    public final String zzcto;
    public final String zzctp;
    public final boolean zzctq;
    public final boolean zzctr;
    public final boolean zzcts;
    public final boolean zzctt;
    public final String zzctu;
    public final String zzctv;
    public final String zzctw;
    public final int zzctx;
    public final int zzcty;
    public final int zzctz;
    public final int zzcua;
    public final int zzcub;
    public final int zzcuc;
    public final double zzcud;
    public final boolean zzcue;
    public final boolean zzcuf;
    public final int zzcug;
    public final String zzcuh;
    public final String zzcui;
    public final boolean zzcuj;

    /* loaded from: assets/classes2.dex */
    public static class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Parcelable.Creator<zza> CREATOR = new zzacq();
        final String className;
        final int versionCode;
        final ArrayList<zzb> zzaFN;

        zza(int i, String str, ArrayList<zzb> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.zzaFN = arrayList;
        }

        zza(String str, Map<String, zzack.zza<?, ?>> map) {
            this.versionCode = 1;
            this.className = str;
            this.zzaFN = zzW(map);
        }

        private static ArrayList<zzb> zzW(Map<String, zzack.zza<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<zzb> arrayList = new ArrayList<>();
            for (String str : map.keySet()) {
                arrayList.add(new zzb(str, map.get(str)));
            }
            return arrayList;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzacq.zza(this, parcel, i);
        }

        HashMap<String, zzack.zza<?, ?>> zzxZ() {
            HashMap<String, zzack.zza<?, ?>> hashMap = new HashMap<>();
            int size = this.zzaFN.size();
            for (int i = 0; i < size; i++) {
                zzb zzbVar = this.zzaFN.get(i);
                hashMap.put(zzbVar.zzaA, zzbVar.zzaFO);
            }
            return hashMap;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzb extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Parcelable.Creator<zzb> CREATOR = new zzacn();
        final int versionCode;
        final String zzaA;
        final zzack.zza<?, ?> zzaFO;

        zzb(int i, String str, zzack.zza<?, ?> zzaVar) {
            this.versionCode = i;
            this.zzaA = str;
            this.zzaFO = zzaVar;
        }

        zzb(String str, zzack.zza<?, ?> zzaVar) {
            this.versionCode = 1;
            this.zzaA = str;
            this.zzaFO = zzaVar;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzacn.zza(this, parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaco(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, String str5, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str6, boolean z9, String str7) {
        this.zzctl = i;
        this.zzctm = z;
        this.zzctn = z2;
        this.zzcto = str;
        this.zzctp = str2;
        this.zzctq = z3;
        this.zzctr = z4;
        this.zzcts = z5;
        this.zzctt = z6;
        this.zzctu = str3;
        this.zzctv = str4;
        this.zzctx = i2;
        this.zzcty = i3;
        this.zzctz = i4;
        this.zzcua = i5;
        this.zzcub = i6;
        this.zzcuc = i7;
        this.zzaxx = f;
        this.zzcnm = i8;
        this.zzcnn = i9;
        this.zzcud = d;
        this.zzcue = z7;
        this.zzcuf = z8;
        this.zzcug = i10;
        this.zzcuh = str6;
        this.zzcuj = z9;
        this.zzctw = str5;
        this.zzcui = str7;
    }
}
