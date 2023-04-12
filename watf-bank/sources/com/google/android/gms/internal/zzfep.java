package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfep extends zzffu<zzfep, zza> implements zzfhg {
    private static volatile zzfhk<zzfep> zzbbk;
    private static final zzfep zzpff;
    private String zzlwa = "";
    private zzfes zzlwb = zzfes.zzpfg;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzfep, zza> implements zzfhg {
        private zza() {
            super(zzfep.zzpff);
        }

        /* synthetic */ zza(zzfeq zzfeqVar) {
            this();
        }
    }

    static {
        zzfep zzfepVar = new zzfep();
        zzpff = zzfepVar;
        zzfepVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzfepVar.zzpgr.zzbiy();
    }

    private zzfep() {
    }

    public static zzfep zzcvk() {
        return zzpff;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        boolean zzb;
        switch (zzfeq.zzbbi[i - 1]) {
            case 1:
                return new zzfep();
            case 2:
                return zzpff;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzfep zzfepVar = (zzfep) obj2;
                this.zzlwa = zzhVar.zza(!this.zzlwa.isEmpty(), this.zzlwa, !zzfepVar.zzlwa.isEmpty(), zzfepVar.zzlwa);
                this.zzlwb = zzhVar.zza(this.zzlwb != zzfes.zzpfg, this.zzlwb, zzfepVar.zzlwb != zzfes.zzpfg, zzfepVar.zzlwb);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    boolean z = false;
                    while (!z) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 10) {
                                    this.zzlwa = zzffbVar.zzcwa();
                                } else if (zzcvt != 18) {
                                    if ((zzcvt & 7) == 4) {
                                        zzb = false;
                                    } else {
                                        if (this.zzpgr == zzfio.zzczu()) {
                                            this.zzpgr = zzfio.zzczv();
                                        }
                                        zzb = this.zzpgr.zzb(zzcvt, zzffbVar);
                                    }
                                    if (!zzb) {
                                    }
                                } else {
                                    this.zzlwb = zzffbVar.zzcwb();
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
                    synchronized (zzfep.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzpff);
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
        return zzpff;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        if (!this.zzlwa.isEmpty()) {
            zzffgVar.zzn(1, this.zzlwa);
        }
        if (!this.zzlwb.isEmpty()) {
            zzffgVar.zza(2, this.zzlwb);
        }
        this.zzpgr.zza(zzffgVar);
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
        int zzho = zzo + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
