package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdtf extends zzffu<zzdtf, zza> implements zzfhg {
    private static volatile zzfhk<zzdtf> zzbbk;
    private static final zzdtf zzlwx;
    private int zzlwu;
    private boolean zzlwv;
    private String zzlwt = "";
    private String zzlwa = "";
    private String zzlww = "";

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdtf, zza> implements zzfhg {
        private zza() {
            super(zzdtf.zzlwx);
        }

        /* synthetic */ zza(zzdtg zzdtgVar) {
            this();
        }

        public final zza zzcc(boolean z) {
            zzcxr();
            ((zzdtf) this.zzpgv).zzcb(true);
            return this;
        }

        public final zza zzfw(int i) {
            zzcxr();
            ((zzdtf) this.zzpgv).zzfv(0);
            return this;
        }

        public final zza zzom(String str) {
            zzcxr();
            ((zzdtf) this.zzpgv).zzok(str);
            return this;
        }

        public final zza zzon(String str) {
            zzcxr();
            ((zzdtf) this.zzpgv).zzoi(str);
            return this;
        }

        public final zza zzoo(String str) {
            zzcxr();
            ((zzdtf) this.zzpgv).zzol(str);
            return this;
        }
    }

    static {
        zzdtf zzdtfVar = new zzdtf();
        zzlwx = zzdtfVar;
        zzdtfVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdtfVar.zzpgr.zzbiy();
    }

    private zzdtf() {
    }

    public static zza zzboz() {
        zzdtf zzdtfVar = zzlwx;
        zzffu.zza zzaVar = (zzffu.zza) zzdtfVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdtfVar);
        return (zza) zzaVar;
    }

    public static zzdtf zzbpa() {
        return zzlwx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzcb(boolean z) {
        this.zzlwv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzfv(int i) {
        this.zzlwu = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzoi(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzlwa = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzok(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzlwt = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzol(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzlww = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdtg.zzbbi[i - 1]) {
            case 1:
                return new zzdtf();
            case 2:
                return zzlwx;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdtf zzdtfVar = (zzdtf) obj2;
                this.zzlwt = zzhVar.zza(!this.zzlwt.isEmpty(), this.zzlwt, !zzdtfVar.zzlwt.isEmpty(), zzdtfVar.zzlwt);
                this.zzlwa = zzhVar.zza(!this.zzlwa.isEmpty(), this.zzlwa, !zzdtfVar.zzlwa.isEmpty(), zzdtfVar.zzlwa);
                this.zzlwu = zzhVar.zza(this.zzlwu != 0, this.zzlwu, zzdtfVar.zzlwu != 0, zzdtfVar.zzlwu);
                boolean z = this.zzlwv;
                boolean z2 = zzdtfVar.zzlwv;
                this.zzlwv = zzhVar.zza(z, z, z2, z2);
                this.zzlww = zzhVar.zza(!this.zzlww.isEmpty(), this.zzlww, true ^ zzdtfVar.zzlww.isEmpty(), zzdtfVar.zzlww);
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (!r0) {
                        try {
                            try {
                                int zzcvt = zzffbVar.zzcvt();
                                if (zzcvt != 0) {
                                    if (zzcvt == 10) {
                                        this.zzlwt = zzffbVar.zzcwa();
                                    } else if (zzcvt == 18) {
                                        this.zzlwa = zzffbVar.zzcwa();
                                    } else if (zzcvt == 24) {
                                        this.zzlwu = zzffbVar.zzcwc();
                                    } else if (zzcvt == 32) {
                                        this.zzlwv = zzffbVar.zzcvz();
                                    } else if (zzcvt == 42) {
                                        this.zzlww = zzffbVar.zzcwa();
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
                    synchronized (zzdtf.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlwx);
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
        return zzlwx;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        if (!this.zzlwt.isEmpty()) {
            zzffgVar.zzn(1, this.zzlwt);
        }
        if (!this.zzlwa.isEmpty()) {
            zzffgVar.zzn(2, this.zzlwa);
        }
        int i = this.zzlwu;
        if (i != 0) {
            zzffgVar.zzab(3, i);
        }
        boolean z = this.zzlwv;
        if (z) {
            zzffgVar.zzl(4, z);
        }
        if (!this.zzlww.isEmpty()) {
            zzffgVar.zzn(5, this.zzlww);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final String zzbon() {
        return this.zzlwa;
    }

    public final String zzbov() {
        return this.zzlwt;
    }

    public final int zzbow() {
        return this.zzlwu;
    }

    public final boolean zzbox() {
        return this.zzlwv;
    }

    public final String zzboy() {
        return this.zzlww;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int zzo = this.zzlwt.isEmpty() ? 0 : 0 + zzffg.zzo(1, this.zzlwt);
        if (!this.zzlwa.isEmpty()) {
            zzo += zzffg.zzo(2, this.zzlwa);
        }
        int i2 = this.zzlwu;
        if (i2 != 0) {
            zzo += zzffg.zzae(3, i2);
        }
        boolean z = this.zzlwv;
        if (z) {
            zzo += zzffg.zzm(4, z);
        }
        if (!this.zzlww.isEmpty()) {
            zzo += zzffg.zzo(5, this.zzlww);
        }
        int zzho = zzo + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
