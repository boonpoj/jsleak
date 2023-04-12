package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsk;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdsi extends zzffu<zzdsi, zza> implements zzfhg {
    private static volatile zzfhk<zzdsi> zzbbk;
    private static final zzdsi zzluy;
    private int zzltn;
    private zzfes zzltv = zzfes.zzpfg;
    private zzdsk zzlux;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdsi, zza> implements zzfhg {
        private zza() {
            super(zzdsi.zzluy);
        }

        /* synthetic */ zza(zzdsj zzdsjVar) {
            this();
        }

        public final zza zzb(zzdsk zzdskVar) {
            zzcxr();
            ((zzdsi) this.zzpgv).zza(zzdskVar);
            return this;
        }

        public final zza zzfo(int i) {
            zzcxr();
            ((zzdsi) this.zzpgv).setVersion(0);
            return this;
        }

        public final zza zzy(zzfes zzfesVar) {
            zzcxr();
            ((zzdsi) this.zzpgv).zzk(zzfesVar);
            return this;
        }
    }

    static {
        zzdsi zzdsiVar = new zzdsi();
        zzluy = zzdsiVar;
        zzdsiVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdsiVar.zzpgr.zzbiy();
    }

    private zzdsi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzltn = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdsk zzdskVar) {
        if (zzdskVar == null) {
            throw new NullPointerException();
        }
        this.zzlux = zzdskVar;
    }

    public static zza zzbnr() {
        zzdsi zzdsiVar = zzluy;
        zzffu.zza zzaVar = (zzffu.zza) zzdsiVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdsiVar);
        return (zza) zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(zzfes zzfesVar) {
        if (zzfesVar == null) {
            throw new NullPointerException();
        }
        this.zzltv = zzfesVar;
    }

    public static zzdsi zzx(zzfes zzfesVar) throws zzfge {
        return (zzdsi) zzffu.zza(zzluy, zzfesVar);
    }

    public final int getVersion() {
        return this.zzltn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdsk.zza zzaVar;
        switch (zzdsj.zzbbi[i - 1]) {
            case 1:
                return new zzdsi();
            case 2:
                return zzluy;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdsi zzdsiVar = (zzdsi) obj2;
                this.zzltn = zzhVar.zza(this.zzltn != 0, this.zzltn, zzdsiVar.zzltn != 0, zzdsiVar.zzltn);
                this.zzlux = (zzdsk) zzhVar.zza(this.zzlux, zzdsiVar.zzlux);
                this.zzltv = zzhVar.zza(this.zzltv != zzfes.zzpfg, this.zzltv, zzdsiVar.zzltv != zzfes.zzpfg, zzdsiVar.zzltv);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    while (!r0) {
                        try {
                            try {
                                int zzcvt = zzffbVar.zzcvt();
                                if (zzcvt != 0) {
                                    if (zzcvt == 8) {
                                        this.zzltn = zzffbVar.zzcwc();
                                    } else if (zzcvt == 18) {
                                        if (this.zzlux != null) {
                                            zzdsk zzdskVar = this.zzlux;
                                            zzffu.zza zzaVar2 = (zzffu.zza) zzdskVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                            zzaVar2.zza((zzffu.zza) zzdskVar);
                                            zzaVar = (zzdsk.zza) zzaVar2;
                                        } else {
                                            zzaVar = null;
                                        }
                                        this.zzlux = (zzdsk) zzffbVar.zza((zzffb) zzdsk.zzbnw(), zzffmVar);
                                        if (zzaVar != null) {
                                            zzaVar.zza((zzdsk.zza) this.zzlux);
                                            this.zzlux = zzaVar.zzcxs();
                                        }
                                    } else if (zzcvt == 26) {
                                        this.zzltv = zzffbVar.zzcwb();
                                    } else if (!zza(zzcvt, zzffbVar)) {
                                    }
                                }
                                r0 = true;
                            } catch (zzfge e) {
                                throw new RuntimeException(e.zzi(this));
                            }
                        } catch (IOException e2) {
                            throw new RuntimeException(new zzfge(e2.getMessage()).zzi(this));
                        }
                    }
                    break;
                } else {
                    throw new NullPointerException();
                }
            case 7:
                break;
            case 8:
                if (zzbbk == null) {
                    synchronized (zzdsi.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzluy);
                        }
                    }
                }
                return zzbbk;
            case 9:
                return (byte) 1;
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return zzluy;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzltn;
        if (i != 0) {
            zzffgVar.zzab(1, i);
        }
        zzdsk zzdskVar = this.zzlux;
        if (zzdskVar != null) {
            if (zzdskVar == null) {
                zzdskVar = zzdsk.zzbnw();
            }
            zzffgVar.zza(2, zzdskVar);
        }
        if (!this.zzltv.isEmpty()) {
            zzffgVar.zza(3, this.zzltv);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzfes zzbmj() {
        return this.zzltv;
    }

    public final zzdsk zzbnq() {
        zzdsk zzdskVar = this.zzlux;
        return zzdskVar == null ? zzdsk.zzbnw() : zzdskVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzltn;
        int zzae = i2 != 0 ? 0 + zzffg.zzae(1, i2) : 0;
        zzdsk zzdskVar = this.zzlux;
        if (zzdskVar != null) {
            if (zzdskVar == null) {
                zzdskVar = zzdsk.zzbnw();
            }
            zzae += zzffg.zzc(2, zzdskVar);
        }
        if (!this.zzltv.isEmpty()) {
            zzae += zzffg.zzc(3, this.zzltv);
        }
        int zzho = zzae + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
