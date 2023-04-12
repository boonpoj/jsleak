package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrq;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdrm extends zzffu<zzdrm, zza> implements zzfhg {
    private static volatile zzfhk<zzdrm> zzbbk;
    private static final zzdrm zzluc;
    private int zzltn;
    private zzfes zzltv = zzfes.zzpfg;
    private zzdrq zzlub;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdrm, zza> implements zzfhg {
        private zza() {
            super(zzdrm.zzluc);
        }

        /* synthetic */ zza(zzdrn zzdrnVar) {
            this();
        }

        public final zza zzb(zzdrq zzdrqVar) {
            zzcxr();
            ((zzdrm) this.zzpgv).zza(zzdrqVar);
            return this;
        }

        public final zza zzfk(int i) {
            zzcxr();
            ((zzdrm) this.zzpgv).setVersion(0);
            return this;
        }

        public final zza zzp(zzfes zzfesVar) {
            zzcxr();
            ((zzdrm) this.zzpgv).zzk(zzfesVar);
            return this;
        }
    }

    static {
        zzdrm zzdrmVar = new zzdrm();
        zzluc = zzdrmVar;
        zzdrmVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdrmVar.zzpgr.zzbiy();
    }

    private zzdrm() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzltn = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdrq zzdrqVar) {
        if (zzdrqVar == null) {
            throw new NullPointerException();
        }
        this.zzlub = zzdrqVar;
    }

    public static zza zzbmt() {
        zzdrm zzdrmVar = zzluc;
        zzffu.zza zzaVar = (zzffu.zza) zzdrmVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdrmVar);
        return (zza) zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(zzfes zzfesVar) {
        if (zzfesVar == null) {
            throw new NullPointerException();
        }
        this.zzltv = zzfesVar;
    }

    public static zzdrm zzo(zzfes zzfesVar) throws zzfge {
        return (zzdrm) zzffu.zza(zzluc, zzfesVar);
    }

    public final int getVersion() {
        return this.zzltn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdrq.zza zzaVar;
        switch (zzdrn.zzbbi[i - 1]) {
            case 1:
                return new zzdrm();
            case 2:
                return zzluc;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdrm zzdrmVar = (zzdrm) obj2;
                this.zzltn = zzhVar.zza(this.zzltn != 0, this.zzltn, zzdrmVar.zzltn != 0, zzdrmVar.zzltn);
                this.zzlub = (zzdrq) zzhVar.zza(this.zzlub, zzdrmVar.zzlub);
                this.zzltv = zzhVar.zza(this.zzltv != zzfes.zzpfg, this.zzltv, zzdrmVar.zzltv != zzfes.zzpfg, zzdrmVar.zzltv);
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
                                        if (this.zzlub != null) {
                                            zzdrq zzdrqVar = this.zzlub;
                                            zzffu.zza zzaVar2 = (zzffu.zza) zzdrqVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                            zzaVar2.zza((zzffu.zza) zzdrqVar);
                                            zzaVar = (zzdrq.zza) zzaVar2;
                                        } else {
                                            zzaVar = null;
                                        }
                                        this.zzlub = (zzdrq) zzffbVar.zza((zzffb) zzdrq.zzbmw(), zzffmVar);
                                        if (zzaVar != null) {
                                            zzaVar.zza((zzdrq.zza) this.zzlub);
                                            this.zzlub = zzaVar.zzcxs();
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
                    synchronized (zzdrm.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzluc);
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
        return zzluc;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzltn;
        if (i != 0) {
            zzffgVar.zzab(1, i);
        }
        zzdrq zzdrqVar = this.zzlub;
        if (zzdrqVar != null) {
            if (zzdrqVar == null) {
                zzdrqVar = zzdrq.zzbmw();
            }
            zzffgVar.zza(2, zzdrqVar);
        }
        if (!this.zzltv.isEmpty()) {
            zzffgVar.zza(3, this.zzltv);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzfes zzbmj() {
        return this.zzltv;
    }

    public final zzdrq zzbms() {
        zzdrq zzdrqVar = this.zzlub;
        return zzdrqVar == null ? zzdrq.zzbmw() : zzdrqVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzltn;
        int zzae = i2 != 0 ? 0 + zzffg.zzae(1, i2) : 0;
        zzdrq zzdrqVar = this.zzlub;
        if (zzdrqVar != null) {
            if (zzdrqVar == null) {
                zzdrqVar = zzdrq.zzbmw();
            }
            zzae += zzffg.zzc(2, zzdrqVar);
        }
        if (!this.zzltv.isEmpty()) {
            zzae += zzffg.zzc(3, this.zzltv);
        }
        int zzho = zzae + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
