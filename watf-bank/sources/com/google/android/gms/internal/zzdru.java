package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrw;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdru extends zzffu<zzdru, zza> implements zzfhg {
    private static volatile zzfhk<zzdru> zzbbk;
    private static final zzdru zzluh;
    private int zzltx;
    private zzdrw zzluf;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdru, zza> implements zzfhg {
        private zza() {
            super(zzdru.zzluh);
        }

        /* synthetic */ zza(zzdrv zzdrvVar) {
            this();
        }
    }

    static {
        zzdru zzdruVar = new zzdru();
        zzluh = zzdruVar;
        zzdruVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdruVar.zzpgr.zzbiy();
    }

    private zzdru() {
    }

    public static zzdru zzt(zzfes zzfesVar) throws zzfge {
        return (zzdru) zzffu.zza(zzluh, zzfesVar);
    }

    public final int getKeySize() {
        return this.zzltx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdrw.zza zzaVar;
        switch (zzdrv.zzbbi[i - 1]) {
            case 1:
                return new zzdru();
            case 2:
                return zzluh;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdru zzdruVar = (zzdru) obj2;
                this.zzluf = (zzdrw) zzhVar.zza(this.zzluf, zzdruVar.zzluf);
                this.zzltx = zzhVar.zza(this.zzltx != 0, this.zzltx, zzdruVar.zzltx != 0, zzdruVar.zzltx);
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
                                    if (this.zzluf != null) {
                                        zzdrw zzdrwVar = this.zzluf;
                                        zzffu.zza zzaVar2 = (zzffu.zza) zzdrwVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
                                        zzaVar2.zza((zzffu.zza) zzdrwVar);
                                        zzaVar = (zzdrw.zza) zzaVar2;
                                    } else {
                                        zzaVar = null;
                                    }
                                    this.zzluf = (zzdrw) zzffbVar.zza((zzffb) zzdrw.zzbnc(), zzffmVar);
                                    if (zzaVar != null) {
                                        zzaVar.zza((zzdrw.zza) this.zzluf);
                                        this.zzluf = zzaVar.zzcxs();
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
                    synchronized (zzdru.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzluh);
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
        return zzluh;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        zzdrw zzdrwVar = this.zzluf;
        if (zzdrwVar != null) {
            if (zzdrwVar == null) {
                zzdrwVar = zzdrw.zzbnc();
            }
            zzffgVar.zza(1, zzdrwVar);
        }
        int i = this.zzltx;
        if (i != 0) {
            zzffgVar.zzab(2, i);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdrw zzbna() {
        zzdrw zzdrwVar = this.zzluf;
        return zzdrwVar == null ? zzdrw.zzbnc() : zzdrwVar;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        zzdrw zzdrwVar = this.zzluf;
        int i2 = 0;
        if (zzdrwVar != null) {
            if (zzdrwVar == null) {
                zzdrwVar = zzdrw.zzbnc();
            }
            i2 = 0 + zzffg.zzc(1, zzdrwVar);
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
