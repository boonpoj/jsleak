package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdrk extends zzffu<zzdrk, zza> implements zzfhg {
    private static volatile zzfhk<zzdrk> zzbbk;
    private static final zzdrk zzlua;
    private int zzltz;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdrk, zza> implements zzfhg {
        private zza() {
            super(zzdrk.zzlua);
        }

        /* synthetic */ zza(zzdrl zzdrlVar) {
            this();
        }
    }

    static {
        zzdrk zzdrkVar = new zzdrk();
        zzlua = zzdrkVar;
        zzdrkVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdrkVar.zzpgr.zzbiy();
    }

    private zzdrk() {
    }

    public static zzdrk zzbmq() {
        return zzlua;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdrl.zzbbi[i - 1]) {
            case 1:
                return new zzdrk();
            case 2:
                return zzlua;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzdrk zzdrkVar = (zzdrk) obj2;
                this.zzltz = ((zzffu.zzh) obj).zza(this.zzltz != 0, this.zzltz, zzdrkVar.zzltz != 0, zzdrkVar.zzltz);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (!r0) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 8) {
                                    this.zzltz = zzffbVar.zzcwc();
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
                    synchronized (zzdrk.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlua);
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
        return zzlua;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzltz;
        if (i != 0) {
            zzffgVar.zzab(1, i);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final int zzbmp() {
        return this.zzltz;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzltz;
        int zzae = (i2 != 0 ? 0 + zzffg.zzae(1, i2) : 0) + this.zzpgr.zzho();
        this.zzpgs = zzae;
        return zzae;
    }
}
