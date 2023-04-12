package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzaau;
import com.google.android.gms.internal.zziu;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzzy extends zzagb implements zzaal {
    private final Context mContext;
    private zzui zzcef;
    private zzaat zzcey;
    private zzaax zzcjl;
    private Runnable zzcjm;
    private final Object zzcjn = new Object();
    private final zzzx zzcmm;
    private final zzaau zzcmn;
    private final zzis zzcmo;
    private final zzix zzcmp;
    zzaif zzcmq;

    public zzzy(Context context, zzaau zzaauVar, zzzx zzzxVar, zzix zzixVar) {
        zzis zzisVar;
        zzit zzitVar;
        this.zzcmm = zzzxVar;
        this.mContext = context;
        this.zzcmn = zzaauVar;
        this.zzcmp = zzixVar;
        this.zzcmo = new zzis(this.zzcmp, ((Boolean) zzkb.zzif().zzd(zznh.zzbrf)).booleanValue());
        this.zzcmo.zza(new zzit(this) { // from class: com.google.android.gms.internal.zzzz
            private final zzzy zzcmr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcmr = this;
            }

            @Override // com.google.android.gms.internal.zzit
            public final void zza(zzjc zzjcVar) {
                this.zzcmr.zzc(zzjcVar);
            }
        });
        final zzjd zzjdVar = new zzjd();
        zzjdVar.zzbda = Integer.valueOf(this.zzcmn.zzaty.zzdej);
        zzjdVar.zzbdb = Integer.valueOf(this.zzcmn.zzaty.zzdek);
        zzjdVar.zzbdc = Integer.valueOf(this.zzcmn.zzaty.zzdel ? 0 : 2);
        this.zzcmo.zza(new zzit(zzjdVar) { // from class: com.google.android.gms.internal.zzaaa
            private final zzjd zzcms;

            /* renamed from: com.google.android.gms.internal.zzaaa$1  reason: invalid class name */
            /* loaded from: assets/classes2.dex */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    zzaaa.zza(zzaaa.this).lock();
                    try {
                        zzaaa.zzb(zzaaa.this);
                    } finally {
                        zzaaa.zza(zzaaa.this).unlock();
                    }
                }
            }

            /* loaded from: assets/classes2.dex */
            private class zza implements zzaau.zza {
                private zza() {
                }

                @Override // com.google.android.gms.internal.zzaau.zza
                public void zzc(int i, boolean z) {
                    zzaaa.zza(zzaaa.this).lock();
                    try {
                        if (!zzaaa.zzc(zzaaa.this) && zzaaa.zzd(zzaaa.this) != null && zzaaa.zzd(zzaaa.this).isSuccess()) {
                            zzaaa.zza(zzaaa.this, true);
                            zzaaa.zze(zzaaa.this).onConnectionSuspended(i);
                            return;
                        }
                        zzaaa.zza(zzaaa.this, false);
                        zzaaa.zza(zzaaa.this, i, z);
                    } finally {
                        zzaaa.zza(zzaaa.this).unlock();
                    }
                }

                @Override // com.google.android.gms.internal.zzaau.zza
                public void zzc(@NonNull ConnectionResult connectionResult) {
                    zzaaa.zza(zzaaa.this).lock();
                    try {
                        zzaaa.zza(zzaaa.this, connectionResult);
                        zzaaa.zzb(zzaaa.this);
                    } finally {
                        zzaaa.zza(zzaaa.this).unlock();
                    }
                }

                @Override // com.google.android.gms.internal.zzaau.zza
                public void zzo(@Nullable Bundle bundle) {
                    zzaaa.zza(zzaaa.this).lock();
                    try {
                        zzaaa.zza(zzaaa.this, bundle);
                        zzaaa.zza(zzaaa.this, ConnectionResult.zzawX);
                        zzaaa.zzb(zzaaa.this);
                    } finally {
                        zzaaa.zza(zzaaa.this).unlock();
                    }
                }
            }

            /* loaded from: assets/classes2.dex */
            private class zzb implements zzaau.zza {
                private zzb() {
                }

                @Override // com.google.android.gms.internal.zzaau.zza
                public void zzc(int i, boolean z) {
                    zzaaa.zza(zzaaa.this).lock();
                    try {
                        if (zzaaa.zzc(zzaaa.this)) {
                            zzaaa.zza(zzaaa.this, false);
                            zzaaa.zza(zzaaa.this, i, z);
                            return;
                        }
                        zzaaa.zza(zzaaa.this, true);
                        zzaaa.zzf(zzaaa.this).onConnectionSuspended(i);
                    } finally {
                        zzaaa.zza(zzaaa.this).unlock();
                    }
                }

                @Override // com.google.android.gms.internal.zzaau.zza
                public void zzc(@NonNull ConnectionResult connectionResult) {
                    zzaaa.zza(zzaaa.this).lock();
                    try {
                        zzaaa.zzb(zzaaa.this, connectionResult);
                        zzaaa.zzb(zzaaa.this);
                    } finally {
                        zzaaa.zza(zzaaa.this).unlock();
                    }
                }

                @Override // com.google.android.gms.internal.zzaau.zza
                public void zzo(@Nullable Bundle bundle) {
                    zzaaa.zza(zzaaa.this).lock();
                    try {
                        zzaaa.zzb(zzaaa.this, ConnectionResult.zzawX);
                        zzaaa.zzb(zzaaa.this);
                    } finally {
                        zzaaa.zza(zzaaa.this).unlock();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcms = zzjdVar;
            }

            @Override // com.google.android.gms.internal.zzit
            public final void zza(zzjc zzjcVar) {
                zzjcVar.zzbcy.zzbcv = this.zzcms;
            }
        });
        if (this.zzcmn.zzcne != null) {
            this.zzcmo.zza(new zzit(this) { // from class: com.google.android.gms.internal.zzaab
                private final zzzy zzcmr;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcmr = this;
                }

                @Override // com.google.android.gms.internal.zzit
                public final void zza(zzjc zzjcVar) {
                    this.zzcmr.zzb(zzjcVar);
                }
            });
        }
        zzjn zzjnVar = this.zzcmn.zzauc;
        if (zzjnVar.zzbel && "interstitial_mb".equals(zzjnVar.zzbek)) {
            zzisVar = this.zzcmo;
            zzitVar = zzaac.zzcmt;
        } else if (zzjnVar.zzbel && "reward_mb".equals(zzjnVar.zzbek)) {
            zzisVar = this.zzcmo;
            zzitVar = zzaad.zzcmt;
        } else if (zzjnVar.zzben || zzjnVar.zzbel) {
            zzisVar = this.zzcmo;
            zzitVar = zzaaf.zzcmt;
        } else {
            zzisVar = this.zzcmo;
            zzitVar = zzaae.zzcmt;
        }
        zzisVar.zza(zzitVar);
        this.zzcmo.zza(zziu.zza.zzb.AD_REQUEST);
    }

    private final zzjn zza(zzaat zzaatVar) throws zzaai {
        zzjn[] zzjnVarArr;
        zzjn[] zzjnVarArr2;
        zzui zzuiVar;
        zzaat zzaatVar2 = this.zzcey;
        if (!((zzaatVar2 == null || zzaatVar2.zzaus == null || this.zzcey.zzaus.size() <= 1) ? false : true) || (zzuiVar = this.zzcef) == null || zzuiVar.zzcea) {
            if (this.zzcjl.zzbeo) {
                for (zzjn zzjnVar : zzaatVar.zzauc.zzbem) {
                    if (zzjnVar.zzbeo) {
                        return new zzjn(zzjnVar, zzaatVar.zzauc.zzbem);
                    }
                }
            }
            if (this.zzcjl.zzcoz != null) {
                String[] split = this.zzcjl.zzcoz.split(AvidJSONUtil.KEY_X);
                if (split.length != 2) {
                    String valueOf = String.valueOf(this.zzcjl.zzcoz);
                    throw new zzaai(valueOf.length() != 0 ? "Invalid ad size format from the ad response: ".concat(valueOf) : new String("Invalid ad size format from the ad response: "), 0);
                }
                try {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    for (zzjn zzjnVar2 : zzaatVar.zzauc.zzbem) {
                        float f = this.mContext.getResources().getDisplayMetrics().density;
                        int i = zzjnVar2.width == -1 ? (int) (zzjnVar2.widthPixels / f) : zzjnVar2.width;
                        int i2 = zzjnVar2.height == -2 ? (int) (zzjnVar2.heightPixels / f) : zzjnVar2.height;
                        if (parseInt == i && parseInt2 == i2 && !zzjnVar2.zzbeo) {
                            return new zzjn(zzjnVar2, zzaatVar.zzauc.zzbem);
                        }
                    }
                    String valueOf2 = String.valueOf(this.zzcjl.zzcoz);
                    throw new zzaai(valueOf2.length() != 0 ? "The ad size from the ad response was not one of the requested sizes: ".concat(valueOf2) : new String("The ad size from the ad response was not one of the requested sizes: "), 0);
                } catch (NumberFormatException e) {
                    String valueOf3 = String.valueOf(this.zzcjl.zzcoz);
                    throw new zzaai(valueOf3.length() != 0 ? "Invalid ad size number from the ad response: ".concat(valueOf3) : new String("Invalid ad size number from the ad response: "), 0);
                }
            }
            throw new zzaai("The ad response must specify one of the supported ad sizes.", 0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(int i, String str) {
        if (i == 3 || i == -1) {
            zzagf.zzct(str);
        } else {
            zzagf.zzcu(str);
        }
        zzaax zzaaxVar = this.zzcjl;
        if (zzaaxVar == null) {
            this.zzcjl = new zzaax(i);
        } else {
            this.zzcjl = new zzaax(i, zzaaxVar.zzcdq);
        }
        zzaat zzaatVar = this.zzcey;
        if (zzaatVar == null) {
            zzaatVar = new zzaat(this.zzcmn, -1L, null, null, null);
        }
        zzaax zzaaxVar2 = this.zzcjl;
        this.zzcmm.zza(new zzafp(zzaatVar, zzaaxVar2, this.zzcef, null, i, -1L, zzaaxVar2.zzcpa, null, this.zzcmo, null));
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void onStop() {
        synchronized (this.zzcjn) {
            if (this.zzcmq != null) {
                this.zzcmq.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaif zza(zzakd zzakdVar, zzalh<zzaat> zzalhVar) {
        Context context = this.mContext;
        if (new zzaak(context).zza(zzakdVar)) {
            zzagf.zzbx("Fetching ad response from local ad request service.");
            zzaaq zzaaqVar = new zzaaq(context, zzalhVar, this);
            zzaaqVar.zznd();
            return zzaaqVar;
        }
        zzagf.zzbx("Fetching ad response from remote ad request service.");
        zzkb.zzia();
        if (zzajr.zzbe(context)) {
            return new zzaar(context, zzakdVar, zzalhVar, this);
        }
        zzagf.zzcu("Failed to connect to remote ad request service.");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01eb  */
    @Override // com.google.android.gms.internal.zzaal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.zzaax r14) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzzy.zza(com.google.android.gms.internal.zzaax):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzjc zzjcVar) {
        zzjcVar.zzbcy.zzbcu = this.zzcmn.zzcne.packageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzjc zzjcVar) {
        zzjcVar.zzbcw = this.zzcmn.zzcnq;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        String string;
        zzagf.zzbx("AdLoaderBackgroundTask started.");
        this.zzcjm = new zzaag(this);
        zzahn.zzdaw.postDelayed(this.zzcjm, ((Long) zzkb.zzif().zzd(zznh.zzbni)).longValue());
        long elapsedRealtime = com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime();
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbng)).booleanValue() && this.zzcmn.zzcnd.extras != null && (string = this.zzcmn.zzcnd.extras.getString("_ad")) != null) {
            this.zzcey = new zzaat(this.zzcmn, elapsedRealtime, null, null, null);
            zza(zzacg.zza(this.mContext, this.zzcey, string));
            return;
        }
        zzall zzallVar = new zzall();
        zzahh.zza(new zzaah(this, zzallVar));
        String zzw = com.google.android.gms.ads.internal.zzbs.zzfd().zzw(this.mContext);
        String zzx = com.google.android.gms.ads.internal.zzbs.zzfd().zzx(this.mContext);
        String zzy = com.google.android.gms.ads.internal.zzbs.zzfd().zzy(this.mContext);
        com.google.android.gms.ads.internal.zzbs.zzfd().zzg(this.mContext, zzy);
        this.zzcey = new zzaat(this.zzcmn, elapsedRealtime, zzw, zzx, zzy);
        zzallVar.zzk(this.zzcey);
    }
}
