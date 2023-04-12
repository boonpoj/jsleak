package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdtd;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdsc extends zzffu<zzdsc, zza> implements zzfhg {
    private static volatile zzfhk<zzdsc> zzbbk;
    private static final zzdsc zzluq;
    private zzdtd zzlup;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdsc, zza> implements zzfhg {
        private zza() {
            super(zzdsc.zzluq);
        }

        /* synthetic */ zza(zzdsd zzdsdVar) {
            this();
        }
    }

    static {
        zzdsc zzdscVar = new zzdsc();
        zzluq = zzdscVar;
        zzdscVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdscVar.zzpgr.zzbiy();
    }

    private zzdsc() {
    }

    public static zzdsc zzbnh() {
        return zzluq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdtd.zza zzaVar;
        switch (zzdsd.zzbbi[i - 1]) {
            case 1:
                return new zzdsc();
            case 2:
                return zzluq;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                this.zzlup = (zzdtd) ((zzffu.zzh) obj).zza(this.zzlup, ((zzdsc) obj2).zzlup);
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
                                    if (zzcvt == 18) {
                                        if (this.zzlup != null) {
                                            zzdtd zzdtdVar = this.zzlup;
                                            zzffu.zza zzaVar2 = (zzffu.zza) zzdtdVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                            zzaVar2.zza((zzffu.zza) zzdtdVar);
                                            zzaVar = (zzdtd.zza) zzaVar2;
                                        } else {
                                            zzaVar = null;
                                        }
                                        this.zzlup = (zzdtd) zzffbVar.zza((zzffb) zzdtd.zzbot(), zzffmVar);
                                        if (zzaVar != null) {
                                            zzaVar.zza((zzdtd.zza) this.zzlup);
                                            this.zzlup = zzaVar.zzcxs();
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
                    synchronized (zzdsc.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzluq);
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
        return zzluq;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        zzdtd zzdtdVar = this.zzlup;
        if (zzdtdVar != null) {
            if (zzdtdVar == null) {
                zzdtdVar = zzdtd.zzbot();
            }
            zzffgVar.zza(2, zzdtdVar);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdtd zzbng() {
        zzdtd zzdtdVar = this.zzlup;
        return zzdtdVar == null ? zzdtd.zzbot() : zzdtdVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        zzdtd zzdtdVar = this.zzlup;
        int i2 = 0;
        if (zzdtdVar != null) {
            if (zzdtdVar == null) {
                zzdtdVar = zzdtd.zzbot();
            }
            i2 = 0 + zzffg.zzc(2, zzdtdVar);
        }
        int zzho = i2 + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
