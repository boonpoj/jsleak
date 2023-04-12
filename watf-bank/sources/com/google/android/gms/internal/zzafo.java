package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzafo {
    public final int errorCode;
    public final int orientation;
    public final boolean zzaqv;
    public final List<String> zzcdk;
    public final List<String> zzcdl;
    public final List<String> zzcdn;
    public final long zzcdq;
    public final zzuh zzces;
    public final zzva zzcet;
    public final String zzceu;
    public final zzuk zzcev;
    public final zzanh zzciy;
    public final zzjj zzcnd;
    public final String zzcng;
    private long zzcov;
    public final boolean zzcow;
    private long zzcox;
    public final List<String> zzcoy;
    public final String zzcpb;
    public final zzaeq zzcpl;
    public final List<String> zzcpn;
    public final boolean zzcpo;
    private zzaaz zzcpp;
    public final String zzcps;
    public final JSONObject zzcxj;
    public boolean zzcxk;
    public final zzui zzcxl;
    public final String zzcxm;
    public final zzjn zzcxn;
    public final List<String> zzcxo;
    public final long zzcxp;
    public final long zzcxq;
    public final zzou zzcxr;
    public boolean zzcxs;
    public boolean zzcxt;
    public boolean zzcxu;
    public boolean zzcxv;
    public final zzis zzcxw;
    public final boolean zzcxx;

    public zzafo(zzafp zzafpVar, zzanh zzanhVar, zzuh zzuhVar, zzva zzvaVar, String str, zzuk zzukVar, zzou zzouVar, String str2) {
        this(zzafpVar.zzcqv.zzcnd, null, zzafpVar.zzcxy.zzcdk, zzafpVar.errorCode, zzafpVar.zzcxy.zzcdl, zzafpVar.zzcxy.zzcoy, zzafpVar.zzcxy.orientation, zzafpVar.zzcxy.zzcdq, zzafpVar.zzcqv.zzcng, zzafpVar.zzcxy.zzcow, null, null, null, zzafpVar.zzcxl, null, zzafpVar.zzcxy.zzcox, zzafpVar.zzauc, zzafpVar.zzcxy.zzcov, zzafpVar.zzcxp, zzafpVar.zzcxq, zzafpVar.zzcxy.zzcpb, zzafpVar.zzcxj, null, zzafpVar.zzcxy.zzcpl, zzafpVar.zzcxy.zzcpm, zzafpVar.zzcxy.zzcpm, zzafpVar.zzcxy.zzcpo, zzafpVar.zzcxy.zzcpp, null, zzafpVar.zzcxy.zzcdn, zzafpVar.zzcxy.zzcps, zzafpVar.zzcxw, zzafpVar.zzcxy.zzaqv, zzafpVar.zzcxx);
    }

    public zzafo(zzjj zzjjVar, zzanh zzanhVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, zzuh zzuhVar, zzva zzvaVar, String str2, zzui zzuiVar, zzuk zzukVar, long j2, zzjn zzjnVar, long j3, long j4, long j5, String str3, JSONObject jSONObject, zzou zzouVar, zzaeq zzaeqVar, List<String> list4, List<String> list5, boolean z2, zzaaz zzaazVar, String str4, List<String> list6, String str5, zzis zzisVar, boolean z3, boolean z4) {
        this.zzcxs = false;
        this.zzcxt = false;
        this.zzcxu = false;
        this.zzcxv = false;
        this.zzcnd = zzjjVar;
        this.zzciy = zzanhVar;
        this.zzcdk = zzq(list);
        this.errorCode = i;
        this.zzcdl = zzq(list2);
        this.zzcoy = zzq(list3);
        this.orientation = i2;
        this.zzcdq = j;
        this.zzcng = str;
        this.zzcow = z;
        this.zzces = zzuhVar;
        this.zzcet = zzvaVar;
        this.zzceu = str2;
        this.zzcxl = zzuiVar;
        this.zzcev = zzukVar;
        this.zzcox = j2;
        this.zzcxn = zzjnVar;
        this.zzcov = j3;
        this.zzcxp = j4;
        this.zzcxq = j5;
        this.zzcpb = str3;
        this.zzcxj = jSONObject;
        this.zzcxr = zzouVar;
        this.zzcpl = zzaeqVar;
        this.zzcxo = zzq(list4);
        this.zzcpn = zzq(list5);
        this.zzcpo = z2;
        this.zzcpp = zzaazVar;
        this.zzcxm = str4;
        this.zzcdn = zzq(list6);
        this.zzcps = str5;
        this.zzcxw = zzisVar;
        this.zzaqv = z3;
        this.zzcxx = z4;
    }

    private static <T> List<T> zzq(List<T> list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public final boolean zzfv() {
        zzanh zzanhVar = this.zzciy;
        if (zzanhVar == null || zzanhVar.zzsz() == null) {
            return false;
        }
        return this.zzciy.zzsz().zzfv();
    }
}
