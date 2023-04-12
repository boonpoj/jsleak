package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzyg extends zzxw {
    private final zznu zzanj;
    private zzux zzanw;
    private final zzanh zzbyk;
    private zzui zzcef;
    private zzug zzcjw;
    protected zzuo zzcjx;
    private boolean zzcjy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyg(Context context, zzafp zzafpVar, zzux zzuxVar, zzyb zzybVar, zznu zznuVar, zzanh zzanhVar) {
        super(context, zzafpVar, zzybVar);
        this.zzanw = zzuxVar;
        this.zzcef = zzafpVar.zzcxl;
        this.zzanj = zznuVar;
        this.zzbyk = zzanhVar;
    }

    private static String zzk(List<zzuo> list) {
        String str = "";
        if (list == null) {
            return "".toString();
        }
        Iterator<zzuo> it = list.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                return str.substring(0, Math.max(0, str.length() - 1));
            }
            zzuo next = it.next();
            if (next != null && next.zzces != null && !TextUtils.isEmpty(next.zzces.zzcct)) {
                String valueOf = String.valueOf(str);
                String str2 = next.zzces.zzcct;
                int i2 = next.zzcer;
                if (i2 == -1) {
                    i = 4;
                } else if (i2 != 0) {
                    i = i2 != 1 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? 6 : 5 : 3 : 2 : 1;
                }
                long j = next.zzcex;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 33);
                sb.append(str2);
                sb.append(".");
                sb.append(i);
                sb.append(".");
                sb.append(j);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(sb2).length());
                sb3.append(valueOf);
                sb3.append(sb2);
                sb3.append("_");
                str = sb3.toString();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzxw, com.google.android.gms.internal.zzagb
    public final void onStop() {
        synchronized (this.zzcjn) {
            super.onStop();
            if (this.zzcjw != null) {
                this.zzcjw.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzxw
    protected final void zze(long j) throws zzxz {
        Bundle bundle;
        synchronized (this.zzcjn) {
            this.zzcjw = this.zzcef.zzcdt != -1 ? new zzur(this.mContext, this.zzcjk.zzcqv, this.zzanw, this.zzcef, this.zzcjl.zzben, this.zzcjl.zzbep, this.zzcjl.zzcpq, j, ((Long) zzkb.zzif().zzd(zznh.zzbnj)).longValue(), 2, this.zzcjk.zzcxx) : new zzuu(this.mContext, this.zzcjk.zzcqv, this.zzanw, this.zzcef, this.zzcjl.zzben, this.zzcjl.zzbep, this.zzcjl.zzcpq, j, ((Long) zzkb.zzif().zzd(zznh.zzbnj)).longValue(), this.zzanj, this.zzcjk.zzcxx);
        }
        ArrayList arrayList = new ArrayList(this.zzcef.zzcdj);
        Bundle bundle2 = this.zzcjk.zzcqv.zzcnd.zzbdp;
        if ((bundle2 == null || (bundle = bundle2.getBundle("com.google.ads.mediation.admob.AdMobAdapter")) == null) ? false : bundle.getBoolean("_skipMediation")) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((zzuh) listIterator.next()).zzccs.contains("com.google.ads.mediation.admob.AdMobAdapter")) {
                    listIterator.remove();
                }
            }
        }
        this.zzcjx = this.zzcjw.zzh(arrayList);
        int i = this.zzcjx.zzcer;
        if (i != 0) {
            if (i == 1) {
                throw new zzxz("No fill from any mediation ad networks.", 3);
            }
            int i2 = this.zzcjx.zzcer;
            StringBuilder sb = new StringBuilder(40);
            sb.append("Unexpected mediation result: ");
            sb.append(i2);
            throw new zzxz(sb.toString(), 0);
        } else if (this.zzcjx.zzces == null || this.zzcjx.zzces.zzcdc == null) {
        } else {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            zzahn.zzdaw.post(new zzyh(this, countDownLatch));
            try {
                countDownLatch.await(10L, TimeUnit.SECONDS);
                synchronized (this.zzcjn) {
                    if (!this.zzcjy) {
                        throw new zzxz("View could not be prepared", 0);
                    }
                    if (this.zzbyk.isDestroyed()) {
                        throw new zzxz("Assets not loaded, web view is destroyed", 0);
                    }
                }
            } catch (InterruptedException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 38);
                sb2.append("Interrupted while waiting for latch : ");
                sb2.append(valueOf);
                throw new zzxz(sb2.toString(), 0);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzxw
    protected final zzafo zzy(int i) {
        zzaat zzaatVar = this.zzcjk.zzcqv;
        zzjj zzjjVar = zzaatVar.zzcnd;
        zzanh zzanhVar = this.zzbyk;
        List<String> list = this.zzcjl.zzcdk;
        List<String> list2 = this.zzcjl.zzcdl;
        List<String> list3 = this.zzcjl.zzcoy;
        int i2 = this.zzcjl.orientation;
        long j = this.zzcjl.zzcdq;
        String str = zzaatVar.zzcng;
        boolean z = this.zzcjl.zzcow;
        zzuo zzuoVar = this.zzcjx;
        zzuh zzuhVar = zzuoVar != null ? zzuoVar.zzces : null;
        zzuo zzuoVar2 = this.zzcjx;
        zzva zzvaVar = zzuoVar2 != null ? zzuoVar2.zzcet : null;
        zzuo zzuoVar3 = this.zzcjx;
        String name = zzuoVar3 != null ? zzuoVar3.zzceu : AdMobAdapter.class.getName();
        zzui zzuiVar = this.zzcef;
        zzuo zzuoVar4 = this.zzcjx;
        zzuk zzukVar = zzuoVar4 != null ? zzuoVar4.zzcev : null;
        zzuh zzuhVar2 = zzuhVar;
        zzva zzvaVar2 = zzvaVar;
        long j2 = this.zzcjl.zzcox;
        zzjn zzjnVar = this.zzcjk.zzauc;
        long j3 = this.zzcjl.zzcov;
        long j4 = this.zzcjk.zzcxp;
        long j5 = this.zzcjl.zzcpa;
        String str2 = this.zzcjl.zzcpb;
        JSONObject jSONObject = this.zzcjk.zzcxj;
        zzaeq zzaeqVar = this.zzcjl.zzcpl;
        List<String> list4 = this.zzcjl.zzcpm;
        List<String> list5 = this.zzcjl.zzcpn;
        zzui zzuiVar2 = this.zzcef;
        boolean z2 = zzuiVar2 != null ? zzuiVar2.zzcdv : false;
        zzaaz zzaazVar = this.zzcjl.zzcpp;
        zzug zzugVar = this.zzcjw;
        return new zzafo(zzjjVar, zzanhVar, list, i, list2, list3, i2, j, str, z, zzuhVar2, zzvaVar2, name, zzuiVar, zzukVar, j2, zzjnVar, j3, j4, j5, str2, jSONObject, null, zzaeqVar, list4, list5, z2, zzaazVar, zzugVar != null ? zzk(zzugVar.zzlu()) : null, this.zzcjl.zzcdn, this.zzcjl.zzcps, this.zzcjk.zzcxw, this.zzcjl.zzaqv, this.zzcjk.zzcxx);
    }
}
