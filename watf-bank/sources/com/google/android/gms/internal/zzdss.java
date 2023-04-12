package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsw;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdss extends zzffu<zzdss, zza> implements zzfhg {
    private static volatile zzfhk<zzdss> zzbbk;
    private static final zzdss zzlvv;
    private int zzltn;
    private zzfes zzltv = zzfes.zzpfg;
    private zzdsw zzlvu;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdss, zza> implements zzfhg {
        private zza() {
            super(zzdss.zzlvv);
        }

        /* synthetic */ zza(zzdst zzdstVar) {
            this();
        }

        public final zza zzaf(zzfes zzfesVar) {
            zzcxr();
            ((zzdss) this.zzpgv).zzk(zzfesVar);
            return this;
        }

        public final zza zzc(zzdsw zzdswVar) {
            zzcxr();
            ((zzdss) this.zzpgv).zzb(zzdswVar);
            return this;
        }

        public final zza zzfs(int i) {
            zzcxr();
            ((zzdss) this.zzpgv).setVersion(0);
            return this;
        }
    }

    static {
        zzdss zzdssVar = new zzdss();
        zzlvv = zzdssVar;
        zzdssVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdssVar.zzpgr.zzbiy();
    }

    private zzdss() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzltn = i;
    }

    public static zzdss zzae(zzfes zzfesVar) throws zzfge {
        return (zzdss) zzffu.zza(zzlvv, zzfesVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzdsw zzdswVar) {
        if (zzdswVar == null) {
            throw new NullPointerException();
        }
        this.zzlvu = zzdswVar;
    }

    public static zza zzboe() {
        zzdss zzdssVar = zzlvv;
        zzffu.zza zzaVar = (zzffu.zza) zzdssVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdssVar);
        return (zza) zzaVar;
    }

    public static zzdss zzbof() {
        return zzlvv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(zzfes zzfesVar) {
        if (zzfesVar == null) {
            throw new NullPointerException();
        }
        this.zzltv = zzfesVar;
    }

    public final int getVersion() {
        return this.zzltn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdsw.zza zzaVar;
        switch (zzdst.zzbbi[i - 1]) {
            case 1:
                return new zzdss();
            case 2:
                return zzlvv;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdss zzdssVar = (zzdss) obj2;
                this.zzltn = zzhVar.zza(this.zzltn != 0, this.zzltn, zzdssVar.zzltn != 0, zzdssVar.zzltn);
                this.zzlvu = (zzdsw) zzhVar.zza(this.zzlvu, zzdssVar.zzlvu);
                this.zzltv = zzhVar.zza(this.zzltv != zzfes.zzpfg, this.zzltv, zzdssVar.zzltv != zzfes.zzpfg, zzdssVar.zzltv);
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
                                        if (this.zzlvu != null) {
                                            zzdsw zzdswVar = this.zzlvu;
                                            zzffu.zza zzaVar2 = (zzffu.zza) zzdswVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                            zzaVar2.zza((zzffu.zza) zzdswVar);
                                            zzaVar = (zzdsw.zza) zzaVar2;
                                        } else {
                                            zzaVar = null;
                                        }
                                        this.zzlvu = (zzdsw) zzffbVar.zza((zzffb) zzdsw.zzbol(), zzffmVar);
                                        if (zzaVar != null) {
                                            zzaVar.zza((zzdsw.zza) this.zzlvu);
                                            this.zzlvu = zzaVar.zzcxs();
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
                    synchronized (zzdss.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlvv);
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
        return zzlvv;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzltn;
        if (i != 0) {
            zzffgVar.zzab(1, i);
        }
        zzdsw zzdswVar = this.zzlvu;
        if (zzdswVar != null) {
            if (zzdswVar == null) {
                zzdswVar = zzdsw.zzbol();
            }
            zzffgVar.zza(2, zzdswVar);
        }
        if (!this.zzltv.isEmpty()) {
            zzffgVar.zza(3, this.zzltv);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzfes zzbmj() {
        return this.zzltv;
    }

    public final zzdsw zzbod() {
        zzdsw zzdswVar = this.zzlvu;
        return zzdswVar == null ? zzdsw.zzbol() : zzdswVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzltn;
        int zzae = i2 != 0 ? 0 + zzffg.zzae(1, i2) : 0;
        zzdsw zzdswVar = this.zzlvu;
        if (zzdswVar != null) {
            if (zzdswVar == null) {
                zzdswVar = zzdsw.zzbol();
            }
            zzae += zzffg.zzc(2, zzdswVar);
        }
        if (!this.zzltv.isEmpty()) {
            zzae += zzffg.zzc(3, this.zzltv);
        }
        int zzho = zzae + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
