package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdtn extends zzffu<zzdtn, zza> implements zzfhg {
    private static volatile zzfhk<zzdtn> zzbbk;
    private static final zzdtn zzlxm;
    private String zzlxl = "";

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdtn, zza> implements zzfhg {
        private zza() {
            super(zzdtn.zzlxm);
        }

        /* synthetic */ zza(zzdto zzdtoVar) {
            this();
        }
    }

    static {
        zzdtn zzdtnVar = new zzdtn();
        zzlxm = zzdtnVar;
        zzdtnVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdtnVar.zzpgr.zzbiy();
    }

    private zzdtn() {
    }

    public static zzdtn zzak(zzfes zzfesVar) throws zzfge {
        return (zzdtn) zzffu.zza(zzlxm, zzfesVar);
    }

    public static zzdtn zzbpw() {
        return zzlxm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdto.zzbbi[i - 1]) {
            case 1:
                return new zzdtn();
            case 2:
                return zzlxm;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzdtn zzdtnVar = (zzdtn) obj2;
                this.zzlxl = ((zzffu.zzh) obj).zza(!this.zzlxl.isEmpty(), this.zzlxl, true ^ zzdtnVar.zzlxl.isEmpty(), zzdtnVar.zzlxl);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    boolean z = false;
                    while (!z) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 10) {
                                    this.zzlxl = zzffbVar.zzcwa();
                                } else if (!zza(zzcvt, zzffbVar)) {
                                }
                            }
                            z = true;
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
                    synchronized (zzdtn.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlxm);
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
        return zzlxm;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        if (!this.zzlxl.isEmpty()) {
            zzffgVar.zzn(1, this.zzlxl);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final String zzbpv() {
        return this.zzlxl;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int zzo = (this.zzlxl.isEmpty() ? 0 : 0 + zzffg.zzo(1, this.zzlxl)) + this.zzpgr.zzho();
        this.zzpgs = zzo;
        return zzo;
    }
}
