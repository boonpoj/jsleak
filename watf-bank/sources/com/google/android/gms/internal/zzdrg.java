package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrk;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdrg extends zzffu<zzdrg, zza> implements zzfhg {
    private static volatile zzfhk<zzdrg> zzbbk;
    private static final zzdrg zzltw;
    private int zzltn;
    private zzdrk zzltu;
    private zzfes zzltv = zzfes.zzpfg;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdrg, zza> implements zzfhg {
        private zza() {
            super(zzdrg.zzltw);
        }

        /* synthetic */ zza(zzdrh zzdrhVar) {
            this();
        }

        public final zza zzc(zzdrk zzdrkVar) {
            zzcxr();
            ((zzdrg) this.zzpgv).zzb(zzdrkVar);
            return this;
        }

        public final zza zzfj(int i) {
            zzcxr();
            ((zzdrg) this.zzpgv).setVersion(0);
            return this;
        }

        public final zza zzm(zzfes zzfesVar) {
            zzcxr();
            ((zzdrg) this.zzpgv).zzk(zzfesVar);
            return this;
        }
    }

    static {
        zzdrg zzdrgVar = new zzdrg();
        zzltw = zzdrgVar;
        zzdrgVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdrgVar.zzpgr.zzbiy();
    }

    private zzdrg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzltn = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzdrk zzdrkVar) {
        if (zzdrkVar == null) {
            throw new NullPointerException();
        }
        this.zzltu = zzdrkVar;
    }

    public static zza zzbmk() {
        zzdrg zzdrgVar = zzltw;
        zzffu.zza zzaVar = (zzffu.zza) zzdrgVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdrgVar);
        return (zza) zzaVar;
    }

    public static zzdrg zzbml() {
        return zzltw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(zzfes zzfesVar) {
        if (zzfesVar == null) {
            throw new NullPointerException();
        }
        this.zzltv = zzfesVar;
    }

    public static zzdrg zzl(zzfes zzfesVar) throws zzfge {
        return (zzdrg) zzffu.zza(zzltw, zzfesVar);
    }

    public final int getVersion() {
        return this.zzltn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdrk.zza zzaVar;
        switch (zzdrh.zzbbi[i - 1]) {
            case 1:
                return new zzdrg();
            case 2:
                return zzltw;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdrg zzdrgVar = (zzdrg) obj2;
                this.zzltn = zzhVar.zza(this.zzltn != 0, this.zzltn, zzdrgVar.zzltn != 0, zzdrgVar.zzltn);
                this.zzltu = (zzdrk) zzhVar.zza(this.zzltu, zzdrgVar.zzltu);
                this.zzltv = zzhVar.zza(this.zzltv != zzfes.zzpfg, this.zzltv, zzdrgVar.zzltv != zzfes.zzpfg, zzdrgVar.zzltv);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    while (!r0) {
                        try {
                            try {
                                int zzcvt = zzffbVar.zzcvt();
                                if (zzcvt != 0) {
                                    if (zzcvt == 8) {
                                        this.zzltn = zzffbVar.zzcwc();
                                    } else if (zzcvt == 18) {
                                        if (this.zzltu != null) {
                                            zzdrk zzdrkVar = this.zzltu;
                                            zzffu.zza zzaVar2 = (zzffu.zza) zzdrkVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                            zzaVar2.zza((zzffu.zza) zzdrkVar);
                                            zzaVar = (zzdrk.zza) zzaVar2;
                                        } else {
                                            zzaVar = null;
                                        }
                                        this.zzltu = (zzdrk) zzffbVar.zza((zzffb) zzdrk.zzbmq(), zzffmVar);
                                        if (zzaVar != null) {
                                            zzaVar.zza((zzdrk.zza) this.zzltu);
                                            this.zzltu = zzaVar.zzcxs();
                                        }
                                    } else if (zzcvt == 26) {
                                        this.zzltv = zzffbVar.zzcwb();
                                    } else if (!zza(zzcvt, zzffbVar)) {
                                    }
                                }
                                r0 = true;
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
                    synchronized (zzdrg.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzltw);
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
        return zzltw;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzltn;
        if (i != 0) {
            zzffgVar.zzab(1, i);
        }
        zzdrk zzdrkVar = this.zzltu;
        if (zzdrkVar != null) {
            if (zzdrkVar == null) {
                zzdrkVar = zzdrk.zzbmq();
            }
            zzffgVar.zza(2, zzdrkVar);
        }
        if (!this.zzltv.isEmpty()) {
            zzffgVar.zza(3, this.zzltv);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdrk zzbmi() {
        zzdrk zzdrkVar = this.zzltu;
        return zzdrkVar == null ? zzdrk.zzbmq() : zzdrkVar;
    }

    public final zzfes zzbmj() {
        return this.zzltv;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzltn;
        int zzae = i2 != 0 ? 0 + zzffg.zzae(1, i2) : 0;
        zzdrk zzdrkVar = this.zzltu;
        if (zzdrkVar != null) {
            if (zzdrkVar == null) {
                zzdrkVar = zzdrk.zzbmq();
            }
            zzae += zzffg.zzc(2, zzdrkVar);
        }
        if (!this.zzltv.isEmpty()) {
            zzae += zzffg.zzc(3, this.zzltv);
        }
        int zzho = zzae + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
