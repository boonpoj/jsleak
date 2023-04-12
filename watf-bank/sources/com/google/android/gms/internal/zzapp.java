package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.zzapq;
/* loaded from: assets/classes2.dex */
public class zzapp {
    private boolean zztW = false;
    private zzapq zzaWI = null;

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Throwable] */
    public void initialize(Context context) {
        synchronized (this) {
            if (this.zztW) {
                return;
            }
            try {
                this.zzaWI = zzapq.zza.asInterface(DynamiteModule.zza(context, DynamiteModule.zzaQw, "com.google.android.gms.flags").zzdX("com.google.android.gms.flags.impl.FlagProviderImpl"));
                this.zzaWI.init(com.google.android.gms.dynamic.zze.zzA(context));
                this.zztW = true;
            } catch (RemoteException | DynamiteModule.zza e) {
                Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
            }
        }
    }

    public <T> T zzb(zzapn<T> zzapnVar) {
        synchronized (this) {
            if (this.zztW) {
                return zzapnVar.zza(this.zzaWI);
            }
            return zzapnVar.zzfm();
        }
    }
}
