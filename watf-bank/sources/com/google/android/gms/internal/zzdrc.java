package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrg;
import com.google.android.gms.internal.zzdss;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdrc extends zzffu<zzdrc, zza> implements zzfhg {
    private static volatile zzfhk<zzdrc> zzbbk;
    private static final zzdrc zzltq;
    private int zzltn;
    private zzdrg zzlto;
    private zzdss zzltp;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdrc, zza> implements zzfhg {
        private zza() {
            super(zzdrc.zzltq);
        }

        /* synthetic */ zza(zzdrd zzdrdVar) {
            this();
        }

        public final zza zzb(zzdrg zzdrgVar) {
            zzcxr();
            ((zzdrc) this.zzpgv).zza(zzdrgVar);
            return this;
        }

        public final zza zzb(zzdss zzdssVar) {
            zzcxr();
            ((zzdrc) this.zzpgv).zza(zzdssVar);
            return this;
        }

        public final zza zzfi(int i) {
            zzcxr();
            ((zzdrc) this.zzpgv).setVersion(i);
            return this;
        }
    }

    static {
        zzdrc zzdrcVar = new zzdrc();
        zzltq = zzdrcVar;
        zzdrcVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdrcVar.zzpgr.zzbiy();
    }

    private zzdrc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzltn = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdrg zzdrgVar) {
        if (zzdrgVar == null) {
            throw new NullPointerException();
        }
        this.zzlto = zzdrgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdss zzdssVar) {
        if (zzdssVar == null) {
            throw new NullPointerException();
        }
        this.zzltp = zzdssVar;
    }

    public static zza zzbmd() {
        zzdrc zzdrcVar = zzltq;
        zzffu.zza zzaVar = (zzffu.zza) zzdrcVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdrcVar);
        return (zza) zzaVar;
    }

    public static zzdrc zzi(zzfes zzfesVar) throws zzfge {
        return (zzdrc) zzffu.zza(zzltq, zzfesVar);
    }

    public final int getVersion() {
        return this.zzltn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdss.zza zzaVar;
        zzdrg.zza zzaVar2;
        switch (zzdrd.zzbbi[i - 1]) {
            case 1:
                return new zzdrc();
            case 2:
                return zzltq;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdrc zzdrcVar = (zzdrc) obj2;
                this.zzltn = zzhVar.zza(this.zzltn != 0, this.zzltn, zzdrcVar.zzltn != 0, zzdrcVar.zzltn);
                this.zzlto = (zzdrg) zzhVar.zza(this.zzlto, zzdrcVar.zzlto);
                this.zzltp = (zzdss) zzhVar.zza(this.zzltp, zzdrcVar.zzltp);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    while (!r0) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 8) {
                                    this.zzltn = zzffbVar.zzcwc();
                                } else if (zzcvt == 18) {
                                    if (this.zzlto != null) {
                                        zzdrg zzdrgVar = this.zzlto;
                                        zzffu.zza zzaVar3 = (zzffu.zza) zzdrgVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                        zzaVar3.zza((zzffu.zza) zzdrgVar);
                                        zzaVar2 = (zzdrg.zza) zzaVar3;
                                    } else {
                                        zzaVar2 = null;
                                    }
                                    this.zzlto = (zzdrg) zzffbVar.zza((zzffb) zzdrg.zzbml(), zzffmVar);
                                    if (zzaVar2 != null) {
                                        zzaVar2.zza((zzdrg.zza) this.zzlto);
                                        this.zzlto = zzaVar2.zzcxs();
                                    }
                                } else if (zzcvt == 26) {
                                    if (this.zzltp != null) {
                                        zzdss zzdssVar = this.zzltp;
                                        zzffu.zza zzaVar4 = (zzffu.zza) zzdssVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                        zzaVar4.zza((zzffu.zza) zzdssVar);
                                        zzaVar = (zzdss.zza) zzaVar4;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzltp = (zzdss) zzffbVar.zza((zzffb) zzdss.zzbof(), zzffmVar);
                                    if (zzaVar != null) {
                                        zzaVar.zza((zzdss.zza) this.zzltp);
                                        this.zzltp = zzaVar.zzcxs();
                                    }
                                } else if (!zza(zzcvt, zzffbVar)) {
                                }
                            }
                            r0 = true;
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
                    synchronized (zzdrc.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzltq);
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
        return zzltq;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzltn;
        if (i != 0) {
            zzffgVar.zzab(1, i);
        }
        zzdrg zzdrgVar = this.zzlto;
        if (zzdrgVar != null) {
            if (zzdrgVar == null) {
                zzdrgVar = zzdrg.zzbml();
            }
            zzffgVar.zza(2, zzdrgVar);
        }
        zzdss zzdssVar = this.zzltp;
        if (zzdssVar != null) {
            if (zzdssVar == null) {
                zzdssVar = zzdss.zzbof();
            }
            zzffgVar.zza(3, zzdssVar);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdrg zzbmb() {
        zzdrg zzdrgVar = this.zzlto;
        return zzdrgVar == null ? zzdrg.zzbml() : zzdrgVar;
    }

    public final zzdss zzbmc() {
        zzdss zzdssVar = this.zzltp;
        return zzdssVar == null ? zzdss.zzbof() : zzdssVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzltn;
        int zzae = i2 != 0 ? 0 + zzffg.zzae(1, i2) : 0;
        zzdrg zzdrgVar = this.zzlto;
        if (zzdrgVar != null) {
            if (zzdrgVar == null) {
                zzdrgVar = zzdrg.zzbml();
            }
            zzae += zzffg.zzc(2, zzdrgVar);
        }
        zzdss zzdssVar = this.zzltp;
        if (zzdssVar != null) {
            if (zzdssVar == null) {
                zzdssVar = zzdss.zzbof();
            }
            zzae += zzffg.zzc(3, zzdssVar);
        }
        int zzho = zzae + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
