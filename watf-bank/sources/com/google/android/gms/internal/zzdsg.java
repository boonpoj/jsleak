package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsc;
import com.google.android.gms.internal.zzdsm;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdsg extends zzffu<zzdsg, zza> implements zzfhg {
    private static volatile zzfhk<zzdsg> zzbbk;
    private static final zzdsg zzluw;
    private zzdsm zzlut;
    private zzdsc zzluu;
    private int zzluv;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdsg, zza> implements zzfhg {
        private zza() {
            super(zzdsg.zzluw);
        }

        /* synthetic */ zza(zzdsh zzdshVar) {
            this();
        }
    }

    static {
        zzdsg zzdsgVar = new zzdsg();
        zzluw = zzdsgVar;
        zzdsgVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdsgVar.zzpgr.zzbiy();
    }

    private zzdsg() {
    }

    public static zzdsg zzbno() {
        return zzluw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdsc.zza zzaVar;
        zzdsm.zza zzaVar2;
        switch (zzdsh.zzbbi[i - 1]) {
            case 1:
                return new zzdsg();
            case 2:
                return zzluw;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdsg zzdsgVar = (zzdsg) obj2;
                this.zzlut = (zzdsm) zzhVar.zza(this.zzlut, zzdsgVar.zzlut);
                this.zzluu = (zzdsc) zzhVar.zza(this.zzluu, zzdsgVar.zzluu);
                this.zzluv = zzhVar.zza(this.zzluv != 0, this.zzluv, zzdsgVar.zzluv != 0, zzdsgVar.zzluv);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    while (!r0) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 10) {
                                    if (this.zzlut != null) {
                                        zzdsm zzdsmVar = this.zzlut;
                                        zzffu.zza zzaVar3 = (zzffu.zza) zzdsmVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                        zzaVar3.zza((zzffu.zza) zzdsmVar);
                                        zzaVar2 = (zzdsm.zza) zzaVar3;
                                    } else {
                                        zzaVar2 = null;
                                    }
                                    this.zzlut = (zzdsm) zzffbVar.zza((zzffb) zzdsm.zzbob(), zzffmVar);
                                    if (zzaVar2 != null) {
                                        zzaVar2.zza((zzdsm.zza) this.zzlut);
                                        this.zzlut = zzaVar2.zzcxs();
                                    }
                                } else if (zzcvt == 18) {
                                    if (this.zzluu != null) {
                                        zzdsc zzdscVar = this.zzluu;
                                        zzffu.zza zzaVar4 = (zzffu.zza) zzdscVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                        zzaVar4.zza((zzffu.zza) zzdscVar);
                                        zzaVar = (zzdsc.zza) zzaVar4;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzluu = (zzdsc) zzffbVar.zza((zzffb) zzdsc.zzbnh(), zzffmVar);
                                    if (zzaVar != null) {
                                        zzaVar.zza((zzdsc.zza) this.zzluu);
                                        this.zzluu = zzaVar.zzcxs();
                                    }
                                } else if (zzcvt == 24) {
                                    this.zzluv = zzffbVar.zzcwd();
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
                    synchronized (zzdsg.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzluw);
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
        return zzluw;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        zzdsm zzdsmVar = this.zzlut;
        if (zzdsmVar != null) {
            if (zzdsmVar == null) {
                zzdsmVar = zzdsm.zzbob();
            }
            zzffgVar.zza(1, zzdsmVar);
        }
        zzdsc zzdscVar = this.zzluu;
        if (zzdscVar != null) {
            if (zzdscVar == null) {
                zzdscVar = zzdsc.zzbnh();
            }
            zzffgVar.zza(2, zzdscVar);
        }
        if (this.zzluv != zzdsa.UNKNOWN_FORMAT.zzhq()) {
            zzffgVar.zzaa(3, this.zzluv);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdsm zzbnl() {
        zzdsm zzdsmVar = this.zzlut;
        return zzdsmVar == null ? zzdsm.zzbob() : zzdsmVar;
    }

    public final zzdsc zzbnm() {
        zzdsc zzdscVar = this.zzluu;
        return zzdscVar == null ? zzdsc.zzbnh() : zzdscVar;
    }

    public final zzdsa zzbnn() {
        zzdsa zzfn = zzdsa.zzfn(this.zzluv);
        return zzfn == null ? zzdsa.UNRECOGNIZED : zzfn;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        zzdsm zzdsmVar = this.zzlut;
        int i2 = 0;
        if (zzdsmVar != null) {
            if (zzdsmVar == null) {
                zzdsmVar = zzdsm.zzbob();
            }
            i2 = 0 + zzffg.zzc(1, zzdsmVar);
        }
        zzdsc zzdscVar = this.zzluu;
        if (zzdscVar != null) {
            if (zzdscVar == null) {
                zzdscVar = zzdsc.zzbnh();
            }
            i2 += zzffg.zzc(2, zzdscVar);
        }
        if (this.zzluv != zzdsa.UNKNOWN_FORMAT.zzhq()) {
            i2 += zzffg.zzag(3, this.zzluv);
        }
        int zzho = i2 + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
