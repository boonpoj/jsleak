package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdri;
import com.google.android.gms.internal.zzdsu;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdre extends zzffu<zzdre, zza> implements zzfhg {
    private static volatile zzfhk<zzdre> zzbbk;
    private static final zzdre zzltt;
    private zzdri zzltr;
    private zzdsu zzlts;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdre, zza> implements zzfhg {
        private zza() {
            super(zzdre.zzltt);
        }

        /* synthetic */ zza(zzdrf zzdrfVar) {
            this();
        }
    }

    static {
        zzdre zzdreVar = new zzdre();
        zzltt = zzdreVar;
        zzdreVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdreVar.zzpgr.zzbiy();
    }

    private zzdre() {
    }

    public static zzdre zzj(zzfes zzfesVar) throws zzfge {
        return (zzdre) zzffu.zza(zzltt, zzfesVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdsu.zza zzaVar;
        zzdri.zza zzaVar2;
        switch (zzdrf.zzbbi[i - 1]) {
            case 1:
                return new zzdre();
            case 2:
                return zzltt;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdre zzdreVar = (zzdre) obj2;
                this.zzltr = (zzdri) zzhVar.zza(this.zzltr, zzdreVar.zzltr);
                this.zzlts = (zzdsu) zzhVar.zza(this.zzlts, zzdreVar.zzlts);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int zzcvt = zzffbVar.zzcvt();
                                if (zzcvt != 0) {
                                    if (zzcvt == 10) {
                                        if (this.zzltr != null) {
                                            zzdri zzdriVar = this.zzltr;
                                            zzffu.zza zzaVar3 = (zzffu.zza) zzdriVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                            zzaVar3.zza((zzffu.zza) zzdriVar);
                                            zzaVar2 = (zzdri.zza) zzaVar3;
                                        } else {
                                            zzaVar2 = null;
                                        }
                                        this.zzltr = (zzdri) zzffbVar.zza((zzffb) zzdri.zzbmn(), zzffmVar);
                                        if (zzaVar2 != null) {
                                            zzaVar2.zza((zzdri.zza) this.zzltr);
                                            this.zzltr = zzaVar2.zzcxs();
                                        }
                                    } else if (zzcvt == 18) {
                                        if (this.zzlts != null) {
                                            zzdsu zzdsuVar = this.zzlts;
                                            zzffu.zza zzaVar4 = (zzffu.zza) zzdsuVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                            zzaVar4.zza((zzffu.zza) zzdsuVar);
                                            zzaVar = (zzdsu.zza) zzaVar4;
                                        } else {
                                            zzaVar = null;
                                        }
                                        this.zzlts = (zzdsu) zzffbVar.zza((zzffb) zzdsu.zzboh(), zzffmVar);
                                        if (zzaVar != null) {
                                            zzaVar.zza((zzdsu.zza) this.zzlts);
                                            this.zzlts = zzaVar.zzcxs();
                                        }
                                    } else if (!zza(zzcvt, zzffbVar)) {
                                    }
                                }
                                z = true;
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
                    synchronized (zzdre.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzltt);
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
        return zzltt;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        zzdri zzdriVar = this.zzltr;
        if (zzdriVar != null) {
            if (zzdriVar == null) {
                zzdriVar = zzdri.zzbmn();
            }
            zzffgVar.zza(1, zzdriVar);
        }
        zzdsu zzdsuVar = this.zzlts;
        if (zzdsuVar != null) {
            if (zzdsuVar == null) {
                zzdsuVar = zzdsu.zzboh();
            }
            zzffgVar.zza(2, zzdsuVar);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdri zzbmf() {
        zzdri zzdriVar = this.zzltr;
        return zzdriVar == null ? zzdri.zzbmn() : zzdriVar;
    }

    public final zzdsu zzbmg() {
        zzdsu zzdsuVar = this.zzlts;
        return zzdsuVar == null ? zzdsu.zzboh() : zzdsuVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        zzdri zzdriVar = this.zzltr;
        int i2 = 0;
        if (zzdriVar != null) {
            if (zzdriVar == null) {
                zzdriVar = zzdri.zzbmn();
            }
            i2 = 0 + zzffg.zzc(1, zzdriVar);
        }
        zzdsu zzdsuVar = this.zzlts;
        if (zzdsuVar != null) {
            if (zzdsuVar == null) {
                zzdsuVar = zzdsu.zzboh();
            }
            i2 += zzffg.zzc(2, zzdsuVar);
        }
        int zzho = i2 + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
