package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzzv;
import java.lang.ref.WeakReference;
@zzzv
/* loaded from: classes.dex */
public final class zzbi {
    private final zzbk zzarw;
    private zzjj zzarx;
    private boolean zzary;
    private boolean zzarz;
    private long zzasa;
    private final Runnable zzz;

    public zzbi(zza zzaVar) {
        this(zzaVar, new zzbk(zzahn.zzdaw));
    }

    private zzbi(zza zzaVar, zzbk zzbkVar) {
        this.zzary = false;
        this.zzarz = false;
        this.zzasa = 0L;
        this.zzarw = zzbkVar;
        this.zzz = new zzbj(this, new WeakReference(zzaVar));
    }

    public final void cancel() {
        this.zzary = false;
        this.zzarw.removeCallbacks(this.zzz);
    }

    public final void pause() {
        this.zzarz = true;
        if (this.zzary) {
            this.zzarw.removeCallbacks(this.zzz);
        }
    }

    public final void resume() {
        this.zzarz = false;
        if (this.zzary) {
            this.zzary = false;
            zza(this.zzarx, this.zzasa);
        }
    }

    public final void zza(zzjj zzjjVar, long j) {
        if (this.zzary) {
            zzagf.zzcu("An ad refresh is already scheduled.");
            return;
        }
        this.zzarx = zzjjVar;
        this.zzary = true;
        this.zzasa = j;
        if (this.zzarz) {
            return;
        }
        StringBuilder sb = new StringBuilder(65);
        sb.append("Scheduling ad refresh ");
        sb.append(j);
        sb.append(" milliseconds from now.");
        zzagf.zzct(sb.toString());
        this.zzarw.postDelayed(this.zzz, j);
    }

    public final boolean zzdx() {
        return this.zzary;
    }

    public final void zzf(zzjj zzjjVar) {
        this.zzarx = zzjjVar;
    }

    public final void zzg(zzjj zzjjVar) {
        zza(zzjjVar, 60000L);
    }
}
