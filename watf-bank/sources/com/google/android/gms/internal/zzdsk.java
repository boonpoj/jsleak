package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsg;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdsk extends zzffu<zzdsk, zza> implements zzfhg {
    private static volatile zzfhk<zzdsk> zzbbk;
    private static final zzdsk zzlvb;
    private int zzltn;
    private zzdsg zzlur;
    private zzfes zzluz = zzfes.zzpfg;
    private zzfes zzlva = zzfes.zzpfg;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdsk, zza> implements zzfhg {
        private zza() {
            super(zzdsk.zzlvb);
        }

        /* synthetic */ zza(zzdsl zzdslVar) {
            this();
        }

        public final zza zzac(zzfes zzfesVar) {
            zzcxr();
            ((zzdsk) this.zzpgv).zzz(zzfesVar);
            return this;
        }

        public final zza zzad(zzfes zzfesVar) {
            zzcxr();
            ((zzdsk) this.zzpgv).zzaa(zzfesVar);
            return this;
        }

        public final zza zzc(zzdsg zzdsgVar) {
            zzcxr();
            ((zzdsk) this.zzpgv).zzb(zzdsgVar);
            return this;
        }

        public final zza zzfp(int i) {
            zzcxr();
            ((zzdsk) this.zzpgv).setVersion(0);
            return this;
        }
    }

    static {
        zzdsk zzdskVar = new zzdsk();
        zzlvb = zzdskVar;
        zzdskVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdskVar.zzpgr.zzbiy();
    }

    private zzdsk() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzltn = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(zzfes zzfesVar) {
        if (zzfesVar == null) {
            throw new NullPointerException();
        }
        this.zzlva = zzfesVar;
    }

    public static zzdsk zzab(zzfes zzfesVar) throws zzfge {
        return (zzdsk) zzffu.zza(zzlvb, zzfesVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzdsg zzdsgVar) {
        if (zzdsgVar == null) {
            throw new NullPointerException();
        }
        this.zzlur = zzdsgVar;
    }

    public static zza zzbnv() {
        zzdsk zzdskVar = zzlvb;
        zzffu.zza zzaVar = (zzffu.zza) zzdskVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdskVar);
        return (zza) zzaVar;
    }

    public static zzdsk zzbnw() {
        return zzlvb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzz(zzfes zzfesVar) {
        if (zzfesVar == null) {
            throw new NullPointerException();
        }
        this.zzluz = zzfesVar;
    }

    public final int getVersion() {
        return this.zzltn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdsg.zza zzaVar;
        boolean z = false;
        switch (zzdsl.zzbbi[i - 1]) {
            case 1:
                return new zzdsk();
            case 2:
                return zzlvb;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdsk zzdskVar = (zzdsk) obj2;
                this.zzltn = zzhVar.zza(this.zzltn != 0, this.zzltn, zzdskVar.zzltn != 0, zzdskVar.zzltn);
                this.zzlur = (zzdsg) zzhVar.zza(this.zzlur, zzdskVar.zzlur);
                this.zzluz = zzhVar.zza(this.zzluz != zzfes.zzpfg, this.zzluz, zzdskVar.zzluz != zzfes.zzpfg, zzdskVar.zzluz);
                this.zzlva = zzhVar.zza(this.zzlva != zzfes.zzpfg, this.zzlva, zzdskVar.zzlva != zzfes.zzpfg, zzdskVar.zzlva);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    while (!z) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 8) {
                                    this.zzltn = zzffbVar.zzcwc();
                                } else if (zzcvt == 18) {
                                    if (this.zzlur != null) {
                                        zzdsg zzdsgVar = this.zzlur;
                                        zzffu.zza zzaVar2 = (zzffu.zza) zzdsgVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                        zzaVar2.zza((zzffu.zza) zzdsgVar);
                                        zzaVar = (zzdsg.zza) zzaVar2;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzlur = (zzdsg) zzffbVar.zza((zzffb) zzdsg.zzbno(), zzffmVar);
                                    if (zzaVar != null) {
                                        zzaVar.zza((zzdsg.zza) this.zzlur);
                                        this.zzlur = zzaVar.zzcxs();
                                    }
                                } else if (zzcvt == 26) {
                                    this.zzluz = zzffbVar.zzcwb();
                                } else if (zzcvt == 34) {
                                    this.zzlva = zzffbVar.zzcwb();
                                } else if (!zza(zzcvt, zzffbVar)) {
                                }
                            }
                            z = true;
                        } catch (zzfge e) {
                            throw new RuntimeException(e.zzi(this));
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
                    synchronized (zzdsk.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlvb);
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
        return zzlvb;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzltn;
        if (i != 0) {
            zzffgVar.zzab(1, i);
        }
        zzdsg zzdsgVar = this.zzlur;
        if (zzdsgVar != null) {
            if (zzdsgVar == null) {
                zzdsgVar = zzdsg.zzbno();
            }
            zzffgVar.zza(2, zzdsgVar);
        }
        if (!this.zzluz.isEmpty()) {
            zzffgVar.zza(3, this.zzluz);
        }
        if (!this.zzlva.isEmpty()) {
            zzffgVar.zza(4, this.zzlva);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdsg zzbnj() {
        zzdsg zzdsgVar = this.zzlur;
        return zzdsgVar == null ? zzdsg.zzbno() : zzdsgVar;
    }

    public final zzfes zzbnt() {
        return this.zzluz;
    }

    public final zzfes zzbnu() {
        return this.zzlva;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzltn;
        int zzae = i2 != 0 ? 0 + zzffg.zzae(1, i2) : 0;
        zzdsg zzdsgVar = this.zzlur;
        if (zzdsgVar != null) {
            if (zzdsgVar == null) {
                zzdsgVar = zzdsg.zzbno();
            }
            zzae += zzffg.zzc(2, zzdsgVar);
        }
        if (!this.zzluz.isEmpty()) {
            zzae += zzffg.zzc(3, this.zzluz);
        }
        if (!this.zzlva.isEmpty()) {
            zzae += zzffg.zzc(4, this.zzlva);
        }
        int zzho = zzae + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
