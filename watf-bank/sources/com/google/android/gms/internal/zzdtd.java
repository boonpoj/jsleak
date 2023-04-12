package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdtd extends zzffu<zzdtd, zza> implements zzfhg {
    private static volatile zzfhk<zzdtd> zzbbk;
    private static final zzdtd zzlws;
    private String zzlwa = "";
    private zzfes zzlwb = zzfes.zzpfg;
    private int zzlwr;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdtd, zza> implements zzfhg {
        private zza() {
            super(zzdtd.zzlws);
        }

        /* synthetic */ zza(zzdte zzdteVar) {
            this();
        }
    }

    static {
        zzdtd zzdtdVar = new zzdtd();
        zzlws = zzdtdVar;
        zzdtdVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdtdVar.zzpgr.zzbiy();
    }

    private zzdtd() {
    }

    public static zzdtd zzbot() {
        return zzlws;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdte.zzbbi[i - 1]) {
            case 1:
                return new zzdtd();
            case 2:
                return zzlws;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdtd zzdtdVar = (zzdtd) obj2;
                this.zzlwa = zzhVar.zza(!this.zzlwa.isEmpty(), this.zzlwa, !zzdtdVar.zzlwa.isEmpty(), zzdtdVar.zzlwa);
                this.zzlwb = zzhVar.zza(this.zzlwb != zzfes.zzpfg, this.zzlwb, zzdtdVar.zzlwb != zzfes.zzpfg, zzdtdVar.zzlwb);
                this.zzlwr = zzhVar.zza(this.zzlwr != 0, this.zzlwr, zzdtdVar.zzlwr != 0, zzdtdVar.zzlwr);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (!z) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 10) {
                                    this.zzlwa = zzffbVar.zzcwa();
                                } else if (zzcvt == 18) {
                                    this.zzlwb = zzffbVar.zzcwb();
                                } else if (zzcvt == 24) {
                                    this.zzlwr = zzffbVar.zzcwd();
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
                    synchronized (zzdtd.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlws);
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
        return zzlws;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        if (!this.zzlwa.isEmpty()) {
            zzffgVar.zzn(1, this.zzlwa);
        }
        if (!this.zzlwb.isEmpty()) {
            zzffgVar.zza(2, this.zzlwb);
        }
        if (this.zzlwr != zzdtt.UNKNOWN_PREFIX.zzhq()) {
            zzffgVar.zzaa(3, this.zzlwr);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final String zzbon() {
        return this.zzlwa;
    }

    public final zzfes zzboo() {
        return this.zzlwb;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int zzo = this.zzlwa.isEmpty() ? 0 : 0 + zzffg.zzo(1, this.zzlwa);
        if (!this.zzlwb.isEmpty()) {
            zzo += zzffg.zzc(2, this.zzlwb);
        }
        if (this.zzlwr != zzdtt.UNKNOWN_PREFIX.zzhq()) {
            zzo += zzffg.zzag(3, this.zzlwr);
        }
        int zzho = zzo + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
