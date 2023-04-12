package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdtr;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdtp extends zzffu<zzdtp, zza> implements zzfhg {
    private static volatile zzfhk<zzdtp> zzbbk;
    private static final zzdtp zzlxo;
    private int zzltn;
    private zzdtr zzlxn;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdtp, zza> implements zzfhg {
        private zza() {
            super(zzdtp.zzlxo);
        }

        /* synthetic */ zza(zzdtq zzdtqVar) {
            this();
        }

        public final zza zzb(zzdtr zzdtrVar) {
            zzcxr();
            ((zzdtp) this.zzpgv).zza(zzdtrVar);
            return this;
        }

        public final zza zzgc(int i) {
            zzcxr();
            ((zzdtp) this.zzpgv).setVersion(0);
            return this;
        }
    }

    static {
        zzdtp zzdtpVar = new zzdtp();
        zzlxo = zzdtpVar;
        zzdtpVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdtpVar.zzpgr.zzbiy();
    }

    private zzdtp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzltn = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdtr zzdtrVar) {
        if (zzdtrVar == null) {
            throw new NullPointerException();
        }
        this.zzlxn = zzdtrVar;
    }

    public static zzdtp zzal(zzfes zzfesVar) throws zzfge {
        return (zzdtp) zzffu.zza(zzlxo, zzfesVar);
    }

    public static zza zzbpz() {
        zzdtp zzdtpVar = zzlxo;
        zzffu.zza zzaVar = (zzffu.zza) zzdtpVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdtpVar);
        return (zza) zzaVar;
    }

    public final int getVersion() {
        return this.zzltn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdtr.zza zzaVar;
        switch (zzdtq.zzbbi[i - 1]) {
            case 1:
                return new zzdtp();
            case 2:
                return zzlxo;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdtp zzdtpVar = (zzdtp) obj2;
                this.zzltn = zzhVar.zza(this.zzltn != 0, this.zzltn, zzdtpVar.zzltn != 0, zzdtpVar.zzltn);
                this.zzlxn = (zzdtr) zzhVar.zza(this.zzlxn, zzdtpVar.zzlxn);
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
                                    if (this.zzlxn != null) {
                                        zzdtr zzdtrVar = this.zzlxn;
                                        zzffu.zza zzaVar2 = (zzffu.zza) zzdtrVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                        zzaVar2.zza((zzffu.zza) zzdtrVar);
                                        zzaVar = (zzdtr.zza) zzaVar2;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzlxn = (zzdtr) zzffbVar.zza((zzffb) zzdtr.zzbqd(), zzffmVar);
                                    if (zzaVar != null) {
                                        zzaVar.zza((zzdtr.zza) this.zzlxn);
                                        this.zzlxn = zzaVar.zzcxs();
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
                    synchronized (zzdtp.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlxo);
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
        return zzlxo;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzltn;
        if (i != 0) {
            zzffgVar.zzab(1, i);
        }
        zzdtr zzdtrVar = this.zzlxn;
        if (zzdtrVar != null) {
            if (zzdtrVar == null) {
                zzdtrVar = zzdtr.zzbqd();
            }
            zzffgVar.zza(2, zzdtrVar);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdtr zzbpy() {
        zzdtr zzdtrVar = this.zzlxn;
        return zzdtrVar == null ? zzdtr.zzbqd() : zzdtrVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzltn;
        int zzae = i2 != 0 ? 0 + zzffg.zzae(1, i2) : 0;
        zzdtr zzdtrVar = this.zzlxn;
        if (zzdtrVar != null) {
            if (zzdtrVar == null) {
                zzdtrVar = zzdtr.zzbqd();
            }
            zzae += zzffg.zzc(2, zzdtrVar);
        }
        int zzho = zzae + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
