package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdsw extends zzffu<zzdsw, zza> implements zzfhg {
    private static volatile zzfhk<zzdsw> zzbbk;
    private static final zzdsw zzlvz;
    private int zzlvx;
    private int zzlvy;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdsw, zza> implements zzfhg {
        private zza() {
            super(zzdsw.zzlvz);
        }

        /* synthetic */ zza(zzdsx zzdsxVar) {
            this();
        }
    }

    static {
        zzdsw zzdswVar = new zzdsw();
        zzlvz = zzdswVar;
        zzdswVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdswVar.zzpgr.zzbiy();
    }

    private zzdsw() {
    }

    public static zzdsw zzbol() {
        return zzlvz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdsx.zzbbi[i - 1]) {
            case 1:
                return new zzdsw();
            case 2:
                return zzlvz;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdsw zzdswVar = (zzdsw) obj2;
                this.zzlvx = zzhVar.zza(this.zzlvx != 0, this.zzlvx, zzdswVar.zzlvx != 0, zzdswVar.zzlvx);
                this.zzlvy = zzhVar.zza(this.zzlvy != 0, this.zzlvy, zzdswVar.zzlvy != 0, zzdswVar.zzlvy);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (!z) {
                        try {
                            try {
                                int zzcvt = zzffbVar.zzcvt();
                                if (zzcvt != 0) {
                                    if (zzcvt == 8) {
                                        this.zzlvx = zzffbVar.zzcwd();
                                    } else if (zzcvt == 16) {
                                        this.zzlvy = zzffbVar.zzcwc();
                                    } else if (!zza(zzcvt, zzffbVar)) {
                                    }
                                }
                                z = true;
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
                    synchronized (zzdsw.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlvz);
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
        return zzlvz;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        if (this.zzlvx != zzdsq.UNKNOWN_HASH.zzhq()) {
            zzffgVar.zzaa(1, this.zzlvx);
        }
        int i = this.zzlvy;
        if (i != 0) {
            zzffgVar.zzab(2, i);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final zzdsq zzboj() {
        zzdsq zzfr = zzdsq.zzfr(this.zzlvx);
        return zzfr == null ? zzdsq.UNRECOGNIZED : zzfr;
    }

    public final int zzbok() {
        return this.zzlvy;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int zzag = this.zzlvx != zzdsq.UNKNOWN_HASH.zzhq() ? 0 + zzffg.zzag(1, this.zzlvx) : 0;
        int i2 = this.zzlvy;
        if (i2 != 0) {
            zzag += zzffg.zzae(2, i2);
        }
        int zzho = zzag + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
