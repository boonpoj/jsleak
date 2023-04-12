package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdtd;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdtr extends zzffu<zzdtr, zza> implements zzfhg {
    private static volatile zzfhk<zzdtr> zzbbk;
    private static final zzdtr zzlxr;
    private String zzlxp = "";
    private zzdtd zzlxq;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdtr, zza> implements zzfhg {
        private zza() {
            super(zzdtr.zzlxr);
        }

        /* synthetic */ zza(zzdts zzdtsVar) {
            this();
        }
    }

    static {
        zzdtr zzdtrVar = new zzdtr();
        zzlxr = zzdtrVar;
        zzdtrVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdtrVar.zzpgr.zzbiy();
    }

    private zzdtr() {
    }

    public static zzdtr zzam(zzfes zzfesVar) throws zzfge {
        return (zzdtr) zzffu.zza(zzlxr, zzfesVar);
    }

    public static zzdtr zzbqd() {
        return zzlxr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdtd.zza zzaVar;
        switch (zzdts.zzbbi[i - 1]) {
            case 1:
                return new zzdtr();
            case 2:
                return zzlxr;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdtr zzdtrVar = (zzdtr) obj2;
                this.zzlxp = zzhVar.zza(!this.zzlxp.isEmpty(), this.zzlxp, true ^ zzdtrVar.zzlxp.isEmpty(), zzdtrVar.zzlxp);
                this.zzlxq = (zzdtd) zzhVar.zza(this.zzlxq, zzdtrVar.zzlxq);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    boolean z = false;
                    while (!z) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 10) {
                                    this.zzlxp = zzffbVar.zzcwa();
                                } else if (zzcvt == 18) {
                                    if (this.zzlxq != null) {
                                        zzdtd zzdtdVar = this.zzlxq;
                                        zzffu.zza zzaVar2 = (zzffu.zza) zzdtdVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                        zzaVar2.zza((zzffu.zza) zzdtdVar);
                                        zzaVar = (zzdtd.zza) zzaVar2;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzlxq = (zzdtd) zzffbVar.zza((zzffb) zzdtd.zzbot(), zzffmVar);
                                    if (zzaVar != null) {
                                        zzaVar.zza((zzdtd.zza) this.zzlxq);
                                        this.zzlxq = zzaVar.zzcxs();
                                    }
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
                    synchronized (zzdtr.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlxr);
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
        return zzlxr;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        if (!this.zzlxp.isEmpty()) {
            zzffgVar.zzn(1, this.zzlxp);
        }
        zzdtd zzdtdVar = this.zzlxq;
        if (zzdtdVar != null) {
            if (zzdtdVar == null) {
                zzdtdVar = zzdtd.zzbot();
            }
            zzffgVar.zza(2, zzdtdVar);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final String zzbqb() {
        return this.zzlxp;
    }

    public final zzdtd zzbqc() {
        zzdtd zzdtdVar = this.zzlxq;
        return zzdtdVar == null ? zzdtd.zzbot() : zzdtdVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int zzo = this.zzlxp.isEmpty() ? 0 : 0 + zzffg.zzo(1, this.zzlxp);
        zzdtd zzdtdVar = this.zzlxq;
        if (zzdtdVar != null) {
            if (zzdtdVar == null) {
                zzdtdVar = zzdtd.zzbot();
            }
            zzo += zzffg.zzc(2, zzdtdVar);
        }
        int zzho = zzo + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
