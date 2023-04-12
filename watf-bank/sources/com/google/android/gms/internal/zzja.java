package com.google.android.gms.internal;

import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzqi;
import java.io.IOException;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzja extends zzfjm<zzja> {
    public Integer zzbct = null;

    /* renamed from: com.google.android.gms.internal.zzja$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzav zzJi;
        final /* synthetic */ zzd zzJj;

        /* renamed from: com.google.android.gms.internal.zzja$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        class C00471 implements zzix.zza {
            final /* synthetic */ zzix zzJl;

            C00471(zzix zzixVar) {
                this.zzJl = zzixVar;
            }

            @Override // com.google.android.gms.internal.zzix.zza
            public void zzgu() {
                zzpi.zzWR.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.zzja.1.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (zzja.zzc(zzja.this)) {
                            if (AnonymousClass1.this.zzJj.getStatus() != -1 && AnonymousClass1.this.zzJj.getStatus() != 1) {
                                AnonymousClass1.this.zzJj.reject();
                                com.google.android.gms.ads.internal.zzv.zzcJ().runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzja.1.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        C00471.this.zzJl.destroy();
                                    }
                                });
                                zzpe.v("Could not receive loaded message in a timely manner. Rejecting.");
                            }
                        }
                    }
                }, zza.zzJt);
            }
        }

        AnonymousClass1(zzav zzavVar, zzd zzdVar) {
            this.zzJi = zzavVar;
            this.zzJj = zzdVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            final zzix zza = zzja.this.zza(zzja.zza(zzja.this), zzja.zzb(zzja.this), this.zzJi);
            zza.zza(new C00471(zza));
            zza.zza("/jsLoaded", new zzhx() { // from class: com.google.android.gms.internal.zzja.1.2
                public void zza(zzqp zzqpVar, Map<String, String> map) {
                    synchronized (zzja.zzc(zzja.this)) {
                        if (AnonymousClass1.this.zzJj.getStatus() != -1 && AnonymousClass1.this.zzJj.getStatus() != 1) {
                            zzja.zza(zzja.this, 0);
                            zzja.zzd(zzja.this).zzd(zza);
                            AnonymousClass1.this.zzJj.zzg(zza);
                            zzja.zza(zzja.this, AnonymousClass1.this.zzJj);
                            zzpe.v("Successfully loaded JS Engine.");
                        }
                    }
                }
            });
            final zzpu zzpuVar = new zzpu();
            zzhx zzhxVar = new zzhx() { // from class: com.google.android.gms.internal.zzja.1.3
                public void zza(zzqp zzqpVar, Map<String, String> map) {
                    synchronized (zzja.zzc(zzja.this)) {
                        zzpe.zzbd("JS Engine is requesting an update");
                        if (zzja.zze(zzja.this) == 0) {
                            zzpe.zzbd("Starting reload.");
                            zzja.zza(zzja.this, 2);
                            zzja.this.zzb(AnonymousClass1.this.zzJi);
                        }
                        zza.zzb("/requestReload", (zzhx) zzpuVar.get());
                    }
                }
            };
            zzpuVar.set(zzhxVar);
            zza.zza("/requestReload", zzhxVar);
            if (zzja.zzf(zzja.this).endsWith(".js")) {
                zza.zzal(zzja.zzf(zzja.this));
            } else if (zzja.zzf(zzja.this).startsWith("<html>")) {
                zza.zzan(zzja.zzf(zzja.this));
            } else {
                zza.zzam(zzja.zzf(zzja.this));
            }
            zzpi.zzWR.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.zzja.1.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzja.zzc(zzja.this)) {
                        if (AnonymousClass1.this.zzJj.getStatus() != -1 && AnonymousClass1.this.zzJj.getStatus() != 1) {
                            AnonymousClass1.this.zzJj.reject();
                            com.google.android.gms.ads.internal.zzv.zzcJ().runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzja.1.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    zza.destroy();
                                }
                            });
                            zzpe.v("Could not receive loaded message in a timely manner. Rejecting.");
                        }
                    }
                }
            }, zza.zzJs);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzja$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zzqi.zzc<zzix> {
        final /* synthetic */ zzd zzJr;

        AnonymousClass2(zzd zzdVar) {
            this.zzJr = zzdVar;
        }

        @Override // com.google.android.gms.internal.zzqi.zzc
        /* renamed from: zza */
        public void zzd(zzix zzixVar) {
            synchronized (zzja.zzc(zzja.this)) {
                zzja.zza(zzja.this, 0);
                if (zzja.zzg(zzja.this) != null && this.zzJr != zzja.zzg(zzja.this)) {
                    zzpe.v("New JS engine is loaded, marking previous one as destroyable.");
                    zzja.zzg(zzja.this).zzgy();
                }
                zzja.zza(zzja.this, this.zzJr);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzja$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements zzqi.zza {
        final /* synthetic */ zzd zzJr;

        AnonymousClass3(zzd zzdVar) {
            this.zzJr = zzdVar;
        }

        @Override // com.google.android.gms.internal.zzqi.zza
        public void run() {
            synchronized (zzja.zzc(zzja.this)) {
                zzja.zza(zzja.this, 1);
                zzpe.v("Failed loading new engine. Marking new engine destroyable.");
                this.zzJr.zzgy();
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    static class zza {
        static int zzJs = 60000;
        static int zzJt = 10000;
    }

    /* loaded from: assets/classes2.dex */
    public static class zzb<T> implements zzpn<T> {
        public void zzd(T t) {
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzc extends zzqj<zzjb> {
        private final zzd zzJu;
        private boolean zzJv;
        private final Object zzrN = new Object();

        public zzc(zzd zzdVar) {
            this.zzJu = zzdVar;
        }

        public void release() {
            synchronized (this.zzrN) {
                if (this.zzJv) {
                    return;
                }
                this.zzJv = true;
                zza(new zzqi.zzc<zzjb>(this) { // from class: com.google.android.gms.internal.zzja.zzc.1
                    @Override // com.google.android.gms.internal.zzqi.zzc
                    /* renamed from: zzb */
                    public void zzd(zzjb zzjbVar) {
                        zzpe.v("Ending javascript session.");
                        ((zzjc) zzjbVar).zzgA();
                    }
                }, new zzqi.zzb());
                zza(new zzqi.zzc<zzjb>() { // from class: com.google.android.gms.internal.zzja.zzc.2
                    @Override // com.google.android.gms.internal.zzqi.zzc
                    /* renamed from: zzb */
                    public void zzd(zzjb zzjbVar) {
                        zzpe.v("Releasing engine reference.");
                        zzc.this.zzJu.zzgx();
                    }
                }, new zzqi.zza() { // from class: com.google.android.gms.internal.zzja.zzc.3
                    @Override // com.google.android.gms.internal.zzqi.zza
                    public void run() {
                        zzc.this.zzJu.zzgx();
                    }
                });
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzd extends zzqj<zzix> {
        private zzpn<zzix> zzJf;
        private final Object zzrN = new Object();
        private boolean zzJx = false;
        private int zzJy = 0;

        public zzd(zzpn<zzix> zzpnVar) {
            this.zzJf = zzpnVar;
        }

        public zzc zzgw() {
            final zzc zzcVar = new zzc(this);
            synchronized (this.zzrN) {
                zza(new zzqi.zzc<zzix>(this) { // from class: com.google.android.gms.internal.zzja.zzd.1
                    @Override // com.google.android.gms.internal.zzqi.zzc
                    /* renamed from: zza */
                    public void zzd(zzix zzixVar) {
                        zzpe.v("Getting a new session for JS Engine.");
                        zzcVar.zzg(zzixVar.zzgt());
                    }
                }, new zzqi.zza(this) { // from class: com.google.android.gms.internal.zzja.zzd.2
                    @Override // com.google.android.gms.internal.zzqi.zza
                    public void run() {
                        zzpe.v("Rejecting reference for JS Engine.");
                        zzcVar.reject();
                    }
                });
                com.google.android.gms.common.internal.zzac.zzar(this.zzJy >= 0);
                this.zzJy++;
            }
            return zzcVar;
        }

        protected void zzgx() {
            synchronized (this.zzrN) {
                com.google.android.gms.common.internal.zzac.zzar(this.zzJy >= 1);
                zzpe.v("Releasing 1 reference for JS Engine");
                this.zzJy--;
                zzgz();
            }
        }

        public void zzgy() {
            synchronized (this.zzrN) {
                com.google.android.gms.common.internal.zzac.zzar(this.zzJy >= 0);
                zzpe.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzJx = true;
                zzgz();
            }
        }

        protected void zzgz() {
            synchronized (this.zzrN) {
                com.google.android.gms.common.internal.zzac.zzar(this.zzJy >= 0);
                if (this.zzJx && this.zzJy == 0) {
                    zzpe.v("No reference is left (including root). Cleaning up engine.");
                    zza(new zzqi.zzc<zzix>() { // from class: com.google.android.gms.internal.zzja.zzd.3
                        @Override // com.google.android.gms.internal.zzqi.zzc
                        /* renamed from: zza */
                        public void zzd(final zzix zzixVar) {
                            com.google.android.gms.ads.internal.zzv.zzcJ().runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzja.zzd.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    zzd.this.zzJf.zzd(zzixVar);
                                    zzixVar.destroy();
                                }
                            });
                        }
                    }, new zzqi.zzb());
                } else {
                    zzpe.v("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zze extends zzqj<zzjb> {
        private zzc zzJD;

        public zze(zzc zzcVar) {
            this.zzJD = zzcVar;
        }

        public void finalize() {
            this.zzJD.release();
            this.zzJD = null;
        }

        public int getStatus() {
            return this.zzJD.getStatus();
        }

        public void reject() {
            this.zzJD.reject();
        }

        public void zza(zzqi.zzc<zzjb> zzcVar, zzqi.zza zzaVar) {
            this.zzJD.zza(zzcVar, zzaVar);
        }

        /* renamed from: zzf */
        public void zzg(zzjb zzjbVar) {
            this.zzJD.zzg(zzjbVar);
        }
    }

    public zzja() {
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjs
    /* renamed from: zzg */
    public final zzja zza(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            if (zzcvt == 56) {
                int position = zzfjjVar.getPosition();
                try {
                    int zzcwi = zzfjjVar.zzcwi();
                    switch (zzcwi) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            this.zzbct = Integer.valueOf(zzcwi);
                            break;
                        default:
                            StringBuilder sb = new StringBuilder(43);
                            sb.append(zzcwi);
                            sb.append(" is not a valid enum AdInitiater");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    zzfjjVar.zzmg(position);
                    zza(zzfjjVar, zzcvt);
                }
            } else if (!super.zza(zzfjjVar, zzcvt)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        Integer num = this.zzbct;
        if (num != null) {
            zzfjkVar.zzaa(7, num.intValue());
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        Integer num = this.zzbct;
        return num != null ? zzq + zzfjk.zzad(7, num.intValue()) : zzq;
    }
}
