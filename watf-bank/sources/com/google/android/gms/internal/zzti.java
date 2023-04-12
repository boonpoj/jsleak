package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzv
/* loaded from: classes.dex */
public final class zzti {
    private final String zzapq;
    private final LinkedList<zztj> zzbzt;
    private zzjj zzbzu;
    private final int zzbzv;
    private boolean zzbzw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzti(zzjj zzjjVar, String str, int i) {
        com.google.android.gms.common.internal.zzbq.checkNotNull(zzjjVar);
        com.google.android.gms.common.internal.zzbq.checkNotNull(str);
        this.zzbzt = new LinkedList<>();
        this.zzbzu = zzjjVar;
        this.zzapq = str;
        this.zzbzv = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getAdUnitId() {
        return this.zzapq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getNetworkType() {
        return this.zzbzv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int size() {
        return this.zzbzt.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzsd zzsdVar, zzjj zzjjVar) {
        this.zzbzt.add(new zztj(this, zzsdVar, zzjjVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb(zzsd zzsdVar) {
        zztj zztjVar = new zztj(this, zzsdVar);
        this.zzbzt.add(zztjVar);
        return zztjVar.load();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjj zzkx() {
        return this.zzbzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzky() {
        Iterator<zztj> it = this.zzbzt.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().zzcab) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzkz() {
        Iterator<zztj> it = this.zzbzt.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().load()) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzla() {
        this.zzbzw = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzlb() {
        return this.zzbzw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zztj zzm(zzjj zzjjVar) {
        if (zzjjVar != null) {
            this.zzbzu = zzjjVar;
        }
        return this.zzbzt.remove();
    }
}
