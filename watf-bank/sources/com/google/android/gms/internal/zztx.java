package com.google.android.gms.internal;

import android.content.Context;
@zzzv
/* loaded from: classes.dex */
public final class zztx {
    private static zzaiq<com.google.android.gms.ads.internal.js.zzc> zzcce = new zzty();
    private static zzaiq<com.google.android.gms.ads.internal.js.zzc> zzccf = new zztz();
    private final com.google.android.gms.ads.internal.js.zzn zzccg;

    public zztx(Context context, zzakd zzakdVar, String str) {
        this.zzccg = new com.google.android.gms.ads.internal.js.zzn(context, zzakdVar, str, zzcce, zzccf);
    }

    public final <I, O> zztp<I, O> zza(String str, zzts<I> zztsVar, zztr<O> zztrVar) {
        return new zzua(this.zzccg, str, zztsVar, zztrVar);
    }
}
