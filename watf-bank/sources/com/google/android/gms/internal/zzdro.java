package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrq;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdro extends zzffu<zzdro, zza> implements zzfhg {
    private static volatile zzfhk<zzdro> zzbbk;
    private static final zzdro zzlud;
    private int zzltx;
    private zzdrq zzlub;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdro, zza> implements zzfhg {
        private zza() {
            super(zzdro.zzlud);
        }

        /* synthetic */ zza(zzdrp zzdrpVar) {
            this();
        }
    }

    static {
        zzdro zzdroVar = new zzdro();
        zzlud = zzdroVar;
        zzdroVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdroVar.zzpgr.zzbiy();
    }

    private zzdro() {
    }

    public static zzdro zzq(zzfes zzfesVar) throws zzfge {
        return (zzdro) zzffu.zza(zzlud, zzfesVar);
    }

    public final int getKeySize() {
        return this.zzltx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdrq.zza zzaVar;
        switch (zzdrp.zzbbi[i - 1]) {
            case 1:
                return new zzdro();
            case 2:
                return zzlud;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdro zzdroVar = (zzdro) obj2;
                this.zzlub = (zzdrq) zzhVar.zza(this.zzlub, zzdroVar.zzlub);
                this.zzltx = zzhVar.zza(this.zzltx != 0, this.zzltx, zzdroVar.zzltx != 0, zzdroVar.zzltx);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    while (!r0) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 10) {
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
                                } else if (zzcvt == 16) {
                                    this.zzltx = zzffbVar.zzcwc();
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
                    synchronized (zzdro.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlud);
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
        return zzlud;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        zzdrq zzdrqVar = this.zzlub;
        if (zzdrqVar != null) {
            if (zzdrqVar == null) {
                zzdrqVar = zzdrq.zzbmw();
            }
            zzffgVar.zza(1, zzdrqVar);
        }
        int i = this.zzltx;
        if (i != 0) {
            zzffgVar.zzab(2, i);
        }
        this.zzpgr.zza(zzffgVar);
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
        zzdrq zzdrqVar = this.zzlub;
        int i2 = 0;
        if (zzdrqVar != null) {
            if (zzdrqVar == null) {
                zzdrqVar = zzdrq.zzbmw();
            }
            i2 = 0 + zzffg.zzc(1, zzdrqVar);
        }
        int i3 = this.zzltx;
        if (i3 != 0) {
            i2 += zzffg.zzae(2, i3);
        }
        int zzho = i2 + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
