package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsw;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdsu extends zzffu<zzdsu, zza> implements zzfhg {
    private static volatile zzfhk<zzdsu> zzbbk;
    private static final zzdsu zzlvw;
    private int zzltx;
    private zzdsw zzlvu;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdsu, zza> implements zzfhg {
        private zza() {
            super(zzdsu.zzlvw);
        }

        /* synthetic */ zza(zzdsv zzdsvVar) {
            this();
        }
    }

    static {
        zzdsu zzdsuVar = new zzdsu();
        zzlvw = zzdsuVar;
        zzdsuVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdsuVar.zzpgr.zzbiy();
    }

    private zzdsu() {
    }

    public static zzdsu zzag(zzfes zzfesVar) throws zzfge {
        return (zzdsu) zzffu.zza(zzlvw, zzfesVar);
    }

    public static zzdsu zzboh() {
        return zzlvw;
    }

    public final int getKeySize() {
        return this.zzltx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        zzdsw.zza zzaVar;
        switch (zzdsv.zzbbi[i - 1]) {
            case 1:
                return new zzdsu();
            case 2:
                return zzlvw;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdsu zzdsuVar = (zzdsu) obj2;
                this.zzlvu = (zzdsw) zzhVar.zza(this.zzlvu, zzdsuVar.zzlvu);
                this.zzltx = zzhVar.zza(this.zzltx != 0, this.zzltx, zzdsuVar.zzltx != 0, zzdsuVar.zzltx);
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
                    synchronized (zzdsu.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlvw);
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
        return zzlvw;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        zzdsw zzdswVar = this.zzlvu;
        if (zzdswVar != null) {
            if (zzdswVar == null) {
                zzdswVar = zzdsw.zzbol();
            }
            zzffgVar.zza(1, zzdswVar);
        }
        int i = this.zzltx;
        if (i != 0) {
            zzffgVar.zzab(2, i);
        }
        this.zzpgr.zza(zzffgVar);
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
        zzdsw zzdswVar = this.zzlvu;
        int i2 = 0;
        if (zzdswVar != null) {
            if (zzdswVar == null) {
                zzdswVar = zzdsw.zzbol();
            }
            i2 = 0 + zzffg.zzc(1, zzdswVar);
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
