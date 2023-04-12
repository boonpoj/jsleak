package com.google.android.gms.internal;

import android.os.Handler;
import java.util.LinkedList;
import java.util.List;
@zzzv
/* loaded from: classes.dex */
public final class zzse {
    private final List<zztc> zzapa = new LinkedList();

    public static /* synthetic */ List zza(zzse zzseVar) {
        return zzseVar.zzapa;
    }

    public final void zza(zztd zztdVar) {
        Handler handler = zzahn.zzdaw;
        for (zztc zztcVar : this.zzapa) {
            handler.post(new zztb(this, zztcVar, zztdVar));
        }
        this.zzapa.clear();
    }
}
