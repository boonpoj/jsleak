package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdsm extends zzffu<zzdsm, zza> implements zzfhg {
    private static volatile zzfhk<zzdsm> zzbbk;
    private static final zzdsm zzlvf;
    private int zzlvc;
    private int zzlvd;
    private zzfes zzlve = zzfes.zzpfg;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdsm, zza> implements zzfhg {
        private zza() {
            super(zzdsm.zzlvf);
        }

        /* synthetic */ zza(zzdsn zzdsnVar) {
            this();
        }
    }

    static {
        zzdsm zzdsmVar = new zzdsm();
        zzlvf = zzdsmVar;
        zzdsmVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdsmVar.zzpgr.zzbiy();
    }

    private zzdsm() {
    }

    public static zzdsm zzbob() {
        return zzlvf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdsn.zzbbi[i - 1]) {
            case 1:
                return new zzdsm();
            case 2:
                return zzlvf;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdsm zzdsmVar = (zzdsm) obj2;
                this.zzlvc = zzhVar.zza(this.zzlvc != 0, this.zzlvc, zzdsmVar.zzlvc != 0, zzdsmVar.zzlvc);
                this.zzlvd = zzhVar.zza(this.zzlvd != 0, this.zzlvd, zzdsmVar.zzlvd != 0, zzdsmVar.zzlvd);
                this.zzlve = zzhVar.zza(this.zzlve != zzfes.zzpfg, this.zzlve, zzdsmVar.zzlve != zzfes.zzpfg, zzdsmVar.zzlve);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (!z) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 8) {
                                    this.zzlvc = zzffbVar.zzcwd();
                                } else if (zzcvt == 16) {
                                    this.zzlvd = zzffbVar.zzcwd();
                                } else if (zzcvt == 90) {
                                    this.zzlve = zzffbVar.zzcwb();
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
                    synchronized (zzdsm.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlvf);
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
        return zzlvf;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        if (this.zzlvc != zzdso.UNKNOWN_CURVE.zzhq()) {
            zzffgVar.zzaa(1, this.zzlvc);
        }
        if (this.zzlvd != zzdsq.UNKNOWN_HASH.zzhq()) {
            zzffgVar.zzaa(2, this.zzlvd);
        }
        if (!this.zzlve.isEmpty()) {
            zzffgVar.zza(11, this.zzlve);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdso zzbny() {
        zzdso zzfq = zzdso.zzfq(this.zzlvc);
        return zzfq == null ? zzdso.UNRECOGNIZED : zzfq;
    }

    public final zzdsq zzbnz() {
        zzdsq zzfr = zzdsq.zzfr(this.zzlvd);
        return zzfr == null ? zzdsq.UNRECOGNIZED : zzfr;
    }

    public final zzfes zzboa() {
        return this.zzlve;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int zzag = this.zzlvc != zzdso.UNKNOWN_CURVE.zzhq() ? 0 + zzffg.zzag(1, this.zzlvc) : 0;
        if (this.zzlvd != zzdsq.UNKNOWN_HASH.zzhq()) {
            zzag += zzffg.zzag(2, this.zzlvd);
        }
        if (!this.zzlve.isEmpty()) {
            zzag += zzffg.zzc(11, this.zzlve);
        }
        int zzho = zzag + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
