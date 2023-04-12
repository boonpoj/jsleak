package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzfs implements zzga {
    private final Context mApplicationContext;
    private final zzakd zzapr;
    private final com.google.android.gms.ads.internal.js.zzn zzavs;
    private final Object mLock = new Object();
    private final WeakHashMap<zzafo, zzft> zzavq = new WeakHashMap<>();
    private final ArrayList<zzft> zzavr = new ArrayList<>();

    public zzfs(Context context, zzakd zzakdVar) {
        this.mApplicationContext = context.getApplicationContext();
        this.zzapr = zzakdVar;
        this.zzavs = new com.google.android.gms.ads.internal.js.zzn(context.getApplicationContext(), zzakdVar, (String) zzkb.zzif().zzd(zznh.zzbhm));
    }

    private final boolean zzg(zzafo zzafoVar) {
        boolean z;
        synchronized (this.mLock) {
            zzft zzftVar = this.zzavq.get(zzafoVar);
            z = zzftVar != null && zzftVar.zzga();
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzga
    public final void zza(zzft zzftVar) {
        synchronized (this.mLock) {
            if (!zzftVar.zzga()) {
                this.zzavr.remove(zzftVar);
                Iterator<Map.Entry<zzafo, zzft>> it = this.zzavq.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == zzftVar) {
                        it.remove();
                    }
                }
            }
        }
    }

    public final void zza(zzjn zzjnVar, zzafo zzafoVar) {
        zzanh zzanhVar = zzafoVar.zzciy;
        if (zzanhVar == null) {
            throw null;
        }
        zza(zzjnVar, zzafoVar, (View) zzanhVar);
    }

    public final void zza(zzjn zzjnVar, zzafo zzafoVar, View view) {
        zza(zzjnVar, zzafoVar, new zzfz(view, zzafoVar), (zzanh) null);
    }

    public final void zza(zzjn zzjnVar, zzafo zzafoVar, View view, zzanh zzanhVar) {
        zza(zzjnVar, zzafoVar, new zzfz(view, zzafoVar), zzanhVar);
    }

    public final void zza(zzjn zzjnVar, zzafo zzafoVar, zzhd zzhdVar, zzanh zzanhVar) {
        zzft zzftVar;
        synchronized (this.mLock) {
            if (zzg(zzafoVar)) {
                zzftVar = this.zzavq.get(zzafoVar);
            } else {
                zzft zzftVar2 = new zzft(this.mApplicationContext, zzjnVar, zzafoVar, this.zzapr, zzhdVar);
                zzftVar2.zza(this);
                this.zzavq.put(zzafoVar, zzftVar2);
                this.zzavr.add(zzftVar2);
                zzftVar = zzftVar2;
            }
            zzftVar.zza(zzanhVar != null ? new zzgb(zzftVar, zzanhVar) : new zzgf(zzftVar, this.zzavs, this.mApplicationContext));
        }
    }

    public final void zzh(zzafo zzafoVar) {
        synchronized (this.mLock) {
            zzft zzftVar = this.zzavq.get(zzafoVar);
            if (zzftVar != null) {
                zzftVar.zzfy();
            }
        }
    }

    public final void zzi(zzafo zzafoVar) {
        synchronized (this.mLock) {
            zzft zzftVar = this.zzavq.get(zzafoVar);
            if (zzftVar != null) {
                zzftVar.stop();
            }
        }
    }

    public final void zzj(zzafo zzafoVar) {
        synchronized (this.mLock) {
            zzft zzftVar = this.zzavq.get(zzafoVar);
            if (zzftVar != null) {
                zzftVar.pause();
            }
        }
    }

    public final void zzk(zzafo zzafoVar) {
        synchronized (this.mLock) {
            zzft zzftVar = this.zzavq.get(zzafoVar);
            if (zzftVar != null) {
                zzftVar.resume();
            }
        }
    }
}
