package com.google.android.gms.internal;
@zzzv
/* loaded from: classes.dex */
public final class zzuk extends zzve {
    private final Object mLock = new Object();
    private zzup zzceb;
    private zzuj zzcec;

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdClicked() {
        synchronized (this.mLock) {
            if (this.zzcec != null) {
                this.zzcec.zzcj();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdClosed() {
        synchronized (this.mLock) {
            if (this.zzcec != null) {
                this.zzcec.zzck();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdFailedToLoad(int i) {
        synchronized (this.mLock) {
            if (this.zzceb != null) {
                this.zzceb.zzv(i == 3 ? 1 : 2);
                this.zzceb = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdImpression() {
        synchronized (this.mLock) {
            if (this.zzcec != null) {
                this.zzcec.zzco();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdLeftApplication() {
        synchronized (this.mLock) {
            if (this.zzcec != null) {
                this.zzcec.zzcl();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdLoaded() {
        synchronized (this.mLock) {
            if (this.zzceb != null) {
                this.zzceb.zzv(0);
                this.zzceb = null;
                return;
            }
            if (this.zzcec != null) {
                this.zzcec.zzcn();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdOpened() {
        synchronized (this.mLock) {
            if (this.zzcec != null) {
                this.zzcec.zzcm();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAppEvent(String str, String str2) {
        synchronized (this.mLock) {
            if (this.zzcec != null) {
                this.zzcec.zzc(str, str2);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onVideoEnd() {
        synchronized (this.mLock) {
            if (this.zzcec != null) {
                this.zzcec.zzci();
            }
        }
    }

    public final void zza(zzuj zzujVar) {
        synchronized (this.mLock) {
            this.zzcec = zzujVar;
        }
    }

    public final void zza(zzup zzupVar) {
        synchronized (this.mLock) {
            this.zzceb = zzupVar;
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(zzvg zzvgVar) {
        synchronized (this.mLock) {
            if (this.zzceb != null) {
                this.zzceb.zza(0, zzvgVar);
                this.zzceb = null;
                return;
            }
            if (this.zzcec != null) {
                this.zzcec.zzcn();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zzb(zzqm zzqmVar, String str) {
        synchronized (this.mLock) {
            if (this.zzcec != null) {
                this.zzcec.zza(zzqmVar, str);
            }
        }
    }
}
