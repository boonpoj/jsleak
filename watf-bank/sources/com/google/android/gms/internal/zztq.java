package com.google.android.gms.internal;

import android.content.Context;
@zzzv
/* loaded from: classes.dex */
public final class zztq {
    private final Object mLock = new Object();
    private zztx zzcca;

    public final zztx zzb(Context context, zzakd zzakdVar) {
        zztx zztxVar;
        synchronized (this.mLock) {
            if (this.zzcca == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                this.zzcca = new zztx(context, zzakdVar, (String) zzkb.zzif().zzd(zznh.zzbhm));
            }
            zztxVar = this.zzcca;
        }
        return zztxVar;
    }
}
