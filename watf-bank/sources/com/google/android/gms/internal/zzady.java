package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
@zzzv
/* loaded from: classes.dex */
public final class zzady extends zzagb implements zzaee, zzaeh {
    private final Context mContext;
    private final String zzced;
    private final zzafp zzcjk;
    private final zzael zzcvf;
    private final zzaeh zzcvg;
    private final String zzcvh;
    private final zzuh zzcvi;
    private final long zzcvj;
    private zzaeb zzcvl;
    private int zzcvk = 0;
    private int mErrorCode = 3;
    private final Object mLock = new Object();

    public zzady(Context context, String str, String str2, zzuh zzuhVar, zzafp zzafpVar, zzael zzaelVar, zzaeh zzaehVar, long j) {
        this.mContext = context;
        this.zzced = str;
        this.zzcvh = str2;
        this.zzcvi = zzuhVar;
        this.zzcjk = zzafpVar;
        this.zzcvf = zzaelVar;
        this.zzcvg = zzaehVar;
        this.zzcvj = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzjj zzjjVar, zzva zzvaVar) {
        this.zzcvf.zzoj().zza((zzaeh) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzced)) {
                zzvaVar.zza(zzjjVar, this.zzcvh, this.zzcvi.zzccq);
            } else {
                zzvaVar.zzc(zzjjVar, this.zzcvh);
            }
        } catch (RemoteException e) {
            zzagf.zzc("Fail to load ad from adapter.", e);
            zza(this.zzced, 0);
        }
    }

    private final boolean zzf(long j) {
        int i;
        long elapsedRealtime = this.zzcvj - (com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            i = 4;
        } else {
            try {
                this.mLock.wait(elapsedRealtime);
                return true;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                i = 5;
            }
        }
        this.mErrorCode = i;
        return false;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzaeh
    public final void zza(String str, int i) {
        synchronized (this.mLock) {
            this.zzcvk = 2;
            this.mErrorCode = i;
            this.mLock.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzaee
    public final void zzaa(int i) {
        zza(this.zzced, 0);
    }

    @Override // com.google.android.gms.internal.zzaeh
    public final void zzbr(String str) {
        synchronized (this.mLock) {
            this.zzcvk = 1;
            this.mLock.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        Handler handler;
        Runnable zzaeaVar;
        zzael zzaelVar = this.zzcvf;
        if (zzaelVar == null || zzaelVar.zzoj() == null || this.zzcvf.zzoi() == null) {
            return;
        }
        zzaeg zzoj = this.zzcvf.zzoj();
        zzoj.zza((zzaeh) null);
        zzoj.zza((zzaee) this);
        zzjj zzjjVar = this.zzcjk.zzcqv.zzcnd;
        zzva zzoi = this.zzcvf.zzoi();
        try {
            if (zzoi.isInitialized()) {
                handler = zzajr.zzajw;
                zzaeaVar = new zzadz(this, zzjjVar, zzoi);
            } else {
                handler = zzajr.zzajw;
                zzaeaVar = new zzaea(this, zzoi, zzjjVar, zzoj);
            }
            handler.post(zzaeaVar);
        } catch (RemoteException e) {
            zzagf.zzc("Fail to check if adapter is initialized.", e);
            zza(this.zzced, 0);
        }
        long elapsedRealtime = com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime();
        while (true) {
            synchronized (this.mLock) {
                if (this.zzcvk == 0) {
                    if (!zzf(elapsedRealtime)) {
                        this.zzcvl = new zzaed().zzab(this.mErrorCode).zzg(com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime() - elapsedRealtime).zzbs(this.zzced).zzbt(this.zzcvi.zzcct).zzog();
                        break;
                    }
                } else {
                    this.zzcvl = new zzaed().zzg(com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime() - elapsedRealtime).zzab(1 == this.zzcvk ? 6 : this.mErrorCode).zzbs(this.zzced).zzbt(this.zzcvi.zzcct).zzog();
                }
            }
        }
        zzoj.zza((zzaeh) null);
        zzoj.zza((zzaee) null);
        if (this.zzcvk == 1) {
            this.zzcvg.zzbr(this.zzced);
        } else {
            this.zzcvg.zza(this.zzced, this.mErrorCode);
        }
    }

    public final zzaeb zzod() {
        zzaeb zzaebVar;
        synchronized (this.mLock) {
            zzaebVar = this.zzcvl;
        }
        return zzaebVar;
    }

    public final zzuh zzoe() {
        return this.zzcvi;
    }

    @Override // com.google.android.gms.internal.zzaee
    public final void zzof() {
        zza(this.zzcjk.zzcqv.zzcnd, this.zzcvf.zzoi());
    }
}
