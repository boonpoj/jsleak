package com.google.android.gms.internal;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzacr implements Callable<zzaco> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzacq zzcul;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacr(zzacq zzacqVar, Context context) {
        this.zzcul = zzacqVar;
        this.val$context = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzaco call() throws Exception {
        WeakHashMap weakHashMap;
        zzaco zzny;
        WeakHashMap weakHashMap2;
        weakHashMap = this.zzcul.zzcuk;
        zzacs zzacsVar = (zzacs) weakHashMap.get(this.val$context);
        if (zzacsVar != null) {
            if (!(zzacsVar.zzcum + ((Long) zzkb.zzif().zzd(zznh.zzbms)).longValue() < com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis())) {
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbmr)).booleanValue()) {
                    zzny = new zzacp(this.val$context, zzacsVar.zzcun).zzny();
                    weakHashMap2 = this.zzcul.zzcuk;
                    weakHashMap2.put(this.val$context, new zzacs(this.zzcul, zzny));
                    return zzny;
                }
            }
        }
        zzny = new zzacp(this.val$context).zzny();
        weakHashMap2 = this.zzcul.zzcuk;
        weakHashMap2.put(this.val$context, new zzacs(this.zzcul, zzny));
        return zzny;
    }
}
