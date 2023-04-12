package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdrq extends zzffu<zzdrq, zza> implements zzfhg {
    private static volatile zzfhk<zzdrq> zzbbk;
    private static final zzdrq zzlue;
    private int zzltz;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdrq, zza> implements zzfhg {
        private zza() {
            super(zzdrq.zzlue);
        }

        /* synthetic */ zza(zzdrr zzdrrVar) {
            this();
        }
    }

    static {
        zzdrq zzdrqVar = new zzdrq();
        zzlue = zzdrqVar;
        zzdrqVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdrqVar.zzpgr.zzbiy();
    }

    private zzdrq() {
    }

    public static zzdrq zzbmw() {
        return zzlue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdrr.zzbbi[i - 1]) {
            case 1:
                return new zzdrq();
            case 2:
                return zzlue;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzdrq zzdrqVar = (zzdrq) obj2;
                this.zzltz = ((zzffu.zzh) obj).zza(this.zzltz != 0, this.zzltz, zzdrqVar.zzltz != 0, zzdrqVar.zzltz);
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
                    synchronized (zzdrq.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlue);
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
        return zzlue;
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
