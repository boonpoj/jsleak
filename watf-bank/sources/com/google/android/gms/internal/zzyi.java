package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzv
/* loaded from: classes.dex */
public final class zzyi extends zzagb {
    private final Object mLock;
    private final zzyb zzcjj;
    private final zzafp zzcjk;
    private final zzaax zzcjl;
    private final zzym zzcka;
    private Future<zzafo> zzckb;

    public zzyi(Context context, com.google.android.gms.ads.internal.zzba zzbaVar, zzafp zzafpVar, zzcv zzcvVar, zzyb zzybVar, zznu zznuVar) {
        this(zzafpVar, zzybVar, new zzym(context, zzbaVar, new zzaiv(context), zzcvVar, zzafpVar, zznuVar));
    }

    private zzyi(zzafp zzafpVar, zzyb zzybVar, zzym zzymVar) {
        this.mLock = new Object();
        this.zzcjk = zzafpVar;
        this.zzcjl = zzafpVar.zzcxy;
        this.zzcjj = zzybVar;
        this.zzcka = zzymVar;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void onStop() {
        synchronized (this.mLock) {
            if (this.zzckb != null) {
                this.zzckb.cancel(true);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        int i;
        zzafo zzafoVar = null;
        try {
            synchronized (this.mLock) {
                this.zzckb = zzahh.zza(zzahh.zzdar, this.zzcka);
            }
            zzafoVar = this.zzckb.get(60000L, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (InterruptedException e) {
            i = 0;
        } catch (CancellationException e2) {
            i = 0;
        } catch (ExecutionException e3) {
            i = 0;
        } catch (TimeoutException e4) {
            zzagf.zzcu("Timed out waiting for native ad.");
            this.zzckb.cancel(true);
            i = 2;
        }
        zzahn.zzdaw.post(new zzyj(this, zzafoVar != null ? zzafoVar : new zzafo(this.zzcjk.zzcqv.zzcnd, null, null, i, null, null, this.zzcjl.orientation, this.zzcjl.zzcdq, this.zzcjk.zzcqv.zzcng, false, null, null, null, null, null, this.zzcjl.zzcox, this.zzcjk.zzauc, this.zzcjl.zzcov, this.zzcjk.zzcxp, this.zzcjl.zzcpa, this.zzcjl.zzcpb, this.zzcjk.zzcxj, null, null, null, null, this.zzcjk.zzcxy.zzcpo, this.zzcjk.zzcxy.zzcpp, null, null, this.zzcjl.zzcps, this.zzcjk.zzcxw, this.zzcjk.zzcxy.zzaqv, false)));
    }
}
