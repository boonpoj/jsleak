package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsg;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdse extends zzffu<zzdse, zza> implements zzfhg {
    private static volatile zzfhk<zzdse> zzbbk;
    private static final zzdse zzlus;
    private zzdsg zzlur;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdse, zza> implements zzfhg {
        private zza() {
            super(zzdse.zzlus);
        }

        /* synthetic */ zza(zzdsf zzdsfVar) {
            this();
        }
    }

    static {
        zzdse zzdseVar = new zzdse();
        zzlus = zzdseVar;
        zzdseVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdseVar.zzpgr.zzbiy();
    }

    private zzdse() {
    }

    public static zzdse zzw(zzfes zzfesVar) throws zzfge {
        return (zzdse) zzffu.zza(zzlus, zzfesVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdsg.zza zzaVar;
        switch (zzdsf.zzbbi[i - 1]) {
            case 1:
                return new zzdse();
            case 2:
                return zzlus;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                this.zzlur = (zzdsg) ((zzffu.zzh) obj).zza(this.zzlur, ((zzdse) obj2).zzlur);
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
                                    } else if (!zza(zzcvt, zzffbVar)) {
                                    }
                                }
                                z = true;
                            } catch (IOException e) {
                                throw new RuntimeException(new zzfge(e.getMessage()).zzi(this));
                            }
                        } catch (zzfge e2) {
                            throw new RuntimeException(e2.zzi(this));
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
                    synchronized (zzdse.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlus);
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
        return zzlus;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        zzdsg zzdsgVar = this.zzlur;
        if (zzdsgVar != null) {
            if (zzdsgVar == null) {
                zzdsgVar = zzdsg.zzbno();
            }
            zzffgVar.zza(1, zzdsgVar);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdsg zzbnj() {
        zzdsg zzdsgVar = this.zzlur;
        return zzdsgVar == null ? zzdsg.zzbno() : zzdsgVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        zzdsg zzdsgVar = this.zzlur;
        int i2 = 0;
        if (zzdsgVar != null) {
            if (zzdsgVar == null) {
                zzdsgVar = zzdsg.zzbno();
            }
            i2 = 0 + zzffg.zzc(1, zzdsgVar);
        }
        int zzho = i2 + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
