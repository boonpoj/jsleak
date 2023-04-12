package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzcv;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbp implements Callable<zzcv> {
    private /* synthetic */ zzbm zzasj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbp(zzbm zzbmVar) {
        this.zzasj = zzbmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzcv call() throws Exception {
        zzakd zzakdVar;
        Context context;
        zzakdVar = this.zzasj.zzapr;
        String str = zzakdVar.zzcv;
        context = this.zzasj.mContext;
        return new zzcv(zzcu.zza(str, context, false));
    }
}
