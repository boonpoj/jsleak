package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaob implements Runnable {
    private /* synthetic */ Map zzanb;
    private /* synthetic */ zzaoa zzdng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaob(zzaoa zzaoaVar, Map map) {
        this.zzdng = zzaoaVar;
        this.zzanb = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzamp zzampVar;
        zzampVar = this.zzdng.zzdhj;
        zzampVar.zza("pubVideoCmd", this.zzanb);
    }
}
