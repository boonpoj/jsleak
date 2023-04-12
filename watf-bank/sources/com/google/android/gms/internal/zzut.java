package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzut implements Runnable {
    private /* synthetic */ zzur zzcfg;
    private /* synthetic */ zzakv zzcfh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzut(zzur zzurVar, zzakv zzakvVar) {
        this.zzcfg = zzurVar;
        this.zzcfh = zzakvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        Map map2;
        map = this.zzcfg.zzcfc;
        for (zzakv zzakvVar : map.keySet()) {
            if (zzakvVar != this.zzcfh) {
                map2 = this.zzcfg.zzcfc;
                ((zzul) map2.get(zzakvVar)).cancel();
            }
        }
    }
}
