package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdtn;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdtl extends zzffu<zzdtl, zza> implements zzfhg {
    private static volatile zzfhk<zzdtl> zzbbk;
    private static final zzdtl zzlxk;
    private int zzltn;
    private zzdtn zzlxj;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdtl, zza> implements zzfhg {
        private zza() {
            super(zzdtl.zzlxk);
        }

        /* synthetic */ zza(zzdtm zzdtmVar) {
            this();
        }

        public final zza zzb(zzdtn zzdtnVar) {
            zzcxr();
            ((zzdtl) this.zzpgv).zza(zzdtnVar);
            return this;
        }

        public final zza zzgb(int i) {
            zzcxr();
            ((zzdtl) this.zzpgv).setVersion(0);
            return this;
        }
    }

    static {
        zzdtl zzdtlVar = new zzdtl();
        zzlxk = zzdtlVar;
        zzdtlVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdtlVar.zzpgr.zzbiy();
    }

    private zzdtl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzltn = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdtn zzdtnVar) {
        if (zzdtnVar == null) {
            throw new NullPointerException();
        }
        this.zzlxj = zzdtnVar;
    }

    public static zzdtl zzaj(zzfes zzfesVar) throws zzfge {
        return (zzdtl) zzffu.zza(zzlxk, zzfesVar);
    }

    public static zza zzbpt() {
        zzdtl zzdtlVar = zzlxk;
        zzffu.zza zzaVar = (zzffu.zza) zzdtlVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdtlVar);
        return (zza) zzaVar;
    }

    public final int getVersion() {
        return this.zzltn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdtn.zza zzaVar;
        switch (zzdtm.zzbbi[i - 1]) {
            case 1:
                return new zzdtl();
            case 2:
                return zzlxk;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdtl zzdtlVar = (zzdtl) obj2;
                this.zzltn = zzhVar.zza(this.zzltn != 0, this.zzltn, zzdtlVar.zzltn != 0, zzdtlVar.zzltn);
                this.zzlxj = (zzdtn) zzhVar.zza(this.zzlxj, zzdtlVar.zzlxj);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    while (!r0) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 8) {
                                    this.zzltn = zzffbVar.zzcwc();
                                } else if (zzcvt == 18) {
                                    if (this.zzlxj != null) {
                                        zzdtn zzdtnVar = this.zzlxj;
                                        zzffu.zza zzaVar2 = (zzffu.zza) zzdtnVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                        zzaVar2.zza((zzffu.zza) zzdtnVar);
                                        zzaVar = (zzdtn.zza) zzaVar2;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzlxj = (zzdtn) zzffbVar.zza((zzffb) zzdtn.zzbpw(), zzffmVar);
                                    if (zzaVar != null) {
                                        zzaVar.zza((zzdtn.zza) this.zzlxj);
                                        this.zzlxj = zzaVar.zzcxs();
                                    }
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
                    synchronized (zzdtl.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlxk);
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
        return zzlxk;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzltn;
        if (i != 0) {
            zzffgVar.zzab(1, i);
        }
        zzdtn zzdtnVar = this.zzlxj;
        if (zzdtnVar != null) {
            if (zzdtnVar == null) {
                zzdtnVar = zzdtn.zzbpw();
            }
            zzffgVar.zza(2, zzdtnVar);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdtn zzbps() {
        zzdtn zzdtnVar = this.zzlxj;
        return zzdtnVar == null ? zzdtn.zzbpw() : zzdtnVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzltn;
        int zzae = i2 != 0 ? 0 + zzffg.zzae(1, i2) : 0;
        zzdtn zzdtnVar = this.zzlxj;
        if (zzdtnVar != null) {
            if (zzdtnVar == null) {
                zzdtnVar = zzdtn.zzbpw();
            }
            zzae += zzffg.zzc(2, zzdtnVar);
        }
        int zzho = zzae + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
