package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zztj {
    com.google.android.gms.ads.internal.zzak zzbzx;
    zzjj zzbzy;
    zzse zzbzz;
    long zzcaa;
    boolean zzcab;
    boolean zzcac;
    private /* synthetic */ zzti zzcad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztj(zzti zztiVar, zzsd zzsdVar) {
        String str;
        this.zzcad = zztiVar;
        str = zztiVar.zzapq;
        this.zzbzx = zzsdVar.zzaw(str);
        this.zzbzz = new zzse();
        zzse zzseVar = this.zzbzz;
        com.google.android.gms.ads.internal.zzak zzakVar = this.zzbzx;
        zzakVar.zza(new zzsf(zzseVar));
        zzakVar.zza(new zzsn(zzseVar));
        zzakVar.zza(new zzsp(zzseVar));
        zzakVar.zza(new zzsr(zzseVar));
        zzakVar.zza(new zzst(zzseVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztj(zzti zztiVar, zzsd zzsdVar, zzjj zzjjVar) {
        this(zztiVar, zzsdVar);
        this.zzbzy = zzjjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean load() {
        if (this.zzcab) {
            return false;
        }
        zzjj zzjjVar = this.zzbzy;
        if (zzjjVar == null) {
            zzjjVar = this.zzcad.zzbzu;
        }
        this.zzcac = this.zzbzx.zzb(zztg.zzj(zzjjVar));
        this.zzcab = true;
        this.zzcaa = com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis();
        return true;
    }
}
