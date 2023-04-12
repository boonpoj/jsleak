package com.google.android.gms.internal;

import android.content.Context;
import java.io.File;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzaiv {
    private static zzv zzdcj;
    private static final Object zzdck = new Object();
    @Deprecated
    private static zzajb<Void> zzdcl = new zzaiw();

    public zzaiv(Context context) {
        zzbb(context);
    }

    private static zzv zzbb(Context context) {
        zzv zzvVar;
        zzv zzvVar2;
        synchronized (zzdck) {
            if (zzdcj == null) {
                Context applicationContext = context.getApplicationContext();
                zznh.initialize(applicationContext);
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbqo)).booleanValue()) {
                    zzvVar2 = zzaip.zzba(applicationContext);
                } else {
                    zzvVar2 = new zzv(new zzal(new File(applicationContext.getCacheDir(), "volley")), new zzai((zzah) new zzar()));
                    zzvVar2.start();
                }
                zzdcj = zzvVar2;
            }
            zzvVar = zzdcj;
        }
        return zzvVar;
    }

    public final zzakv<String> zza(int i, String str, Map<String, String> map, byte[] bArr) {
        zzajc zzajcVar = new zzajc(null);
        zzaiz zzaizVar = new zzaiz(this, str, zzajcVar);
        zzajv zzajvVar = new zzajv(null);
        zzaja zzajaVar = new zzaja(this, i, str, zzajcVar, zzaizVar, bArr, map, zzajvVar);
        if (zzajv.isEnabled()) {
            try {
                zzajvVar.zza(str, "GET", zzajaVar.getHeaders(), zzajaVar.zzf());
            } catch (zza e) {
                zzagf.zzcu(e.getMessage());
            }
        }
        zzdcj.zze(zzajaVar);
        return zzajcVar;
    }

    @Deprecated
    public final <T> zzakv<T> zza(String str, zzajb<T> zzajbVar) {
        zzalf zzalfVar = new zzalf();
        zzdcj.zze(new zzajd(str, zzalfVar));
        return zzakl.zza(zzakl.zza(zzalfVar, new zzaiy(this, zzajbVar), zzala.zzdff), Throwable.class, new zzaix(this, zzajbVar), zzala.zzdff);
    }

    public final zzakv<String> zzb(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}
