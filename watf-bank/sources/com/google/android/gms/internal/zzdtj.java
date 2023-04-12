package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdtj extends zzffu<zzdtj, zza> implements zzfhg {
    private static volatile zzfhk<zzdtj> zzbbk;
    private static final zzdtj zzlxh;
    private int zzlwy;
    private int zzlwz;
    private zzfgd<zzb> zzlxg = zzcxo();

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdtj, zza> implements zzfhg {
        private zza() {
            super(zzdtj.zzlxh);
        }

        /* synthetic */ zza(zzdtk zzdtkVar) {
            this();
        }

        public final zza zzb(zzb zzbVar) {
            zzcxr();
            ((zzdtj) this.zzpgv).zza(zzbVar);
            return this;
        }

        public final zza zzfy(int i) {
            zzcxr();
            ((zzdtj) this.zzpgv).zzfx(i);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzffu<zzb, zza> implements zzfhg {
        private static volatile zzfhk<zzb> zzbbk;
        private static final zzb zzlxi;
        private String zzlwa = "";
        private int zzlwr;
        private int zzlxd;
        private int zzlxe;

        /* loaded from: classes.dex */
        public static final class zza extends zzffu.zza<zzb, zza> implements zzfhg {
            private zza() {
                super(zzb.zzlxi);
            }

            /* synthetic */ zza(zzdtk zzdtkVar) {
                this();
            }

            public final zza zzb(zzdtb zzdtbVar) {
                zzcxr();
                ((zzb) this.zzpgv).zza(zzdtbVar);
                return this;
            }

            public final zza zzb(zzdtt zzdttVar) {
                zzcxr();
                ((zzb) this.zzpgv).zza(zzdttVar);
                return this;
            }

            public final zza zzga(int i) {
                zzcxr();
                ((zzb) this.zzpgv).zzfz(i);
                return this;
            }

            public final zza zzop(String str) {
                zzcxr();
                ((zzb) this.zzpgv).zzoi(str);
                return this;
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzlxi = zzbVar;
            zzbVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
            zzbVar.zzpgr.zzbiy();
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzdtb zzdtbVar) {
            if (zzdtbVar == null) {
                throw new NullPointerException();
            }
            this.zzlxd = zzdtbVar.zzhq();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzdtt zzdttVar) {
            if (zzdttVar == null) {
                throw new NullPointerException();
            }
            this.zzlwr = zzdttVar.zzhq();
        }

        public static zza zzbpp() {
            zzb zzbVar = zzlxi;
            zzffu.zza zzaVar = (zzffu.zza) zzbVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
            zzaVar.zza((zzffu.zza) zzbVar);
            return (zza) zzaVar;
        }

        public static zzb zzbpq() {
            return zzlxi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzfz(int i) {
            this.zzlxe = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzoi(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzlwa = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzffu
        public final Object zza(int i, Object obj, Object obj2) {
            boolean z = false;
            switch (zzdtk.zzbbi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return zzlxi;
                case 3:
                    return null;
                case 4:
                    return new zza(null);
                case 5:
                    zzffu.zzh zzhVar = (zzffu.zzh) obj;
                    zzb zzbVar = (zzb) obj2;
                    this.zzlwa = zzhVar.zza(!this.zzlwa.isEmpty(), this.zzlwa, !zzbVar.zzlwa.isEmpty(), zzbVar.zzlwa);
                    this.zzlxd = zzhVar.zza(this.zzlxd != 0, this.zzlxd, zzbVar.zzlxd != 0, zzbVar.zzlxd);
                    this.zzlxe = zzhVar.zza(this.zzlxe != 0, this.zzlxe, zzbVar.zzlxe != 0, zzbVar.zzlxe);
                    this.zzlwr = zzhVar.zza(this.zzlwr != 0, this.zzlwr, zzbVar.zzlwr != 0, zzbVar.zzlwr);
                    return this;
                case 6:
                    zzffb zzffbVar = (zzffb) obj;
                    if (((zzffm) obj2) != null) {
                        while (!z) {
                            try {
                                int zzcvt = zzffbVar.zzcvt();
                                if (zzcvt != 0) {
                                    if (zzcvt == 10) {
                                        this.zzlwa = zzffbVar.zzcwa();
                                    } else if (zzcvt == 16) {
                                        this.zzlxd = zzffbVar.zzcwd();
                                    } else if (zzcvt == 24) {
                                        this.zzlxe = zzffbVar.zzcwc();
                                    } else if (zzcvt == 32) {
                                        this.zzlwr = zzffbVar.zzcwd();
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
                        synchronized (zzb.class) {
                            if (zzbbk == null) {
                                zzbbk = new zzffu.zzb(zzlxi);
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
            return zzlxi;
        }

        @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
        public final void zza(zzffg zzffgVar) throws IOException {
            if (!this.zzlwa.isEmpty()) {
                zzffgVar.zzn(1, this.zzlwa);
            }
            if (this.zzlxd != zzdtb.UNKNOWN_STATUS.zzhq()) {
                zzffgVar.zzaa(2, this.zzlxd);
            }
            int i = this.zzlxe;
            if (i != 0) {
                zzffgVar.zzab(3, i);
            }
            if (this.zzlwr != zzdtt.UNKNOWN_PREFIX.zzhq()) {
                zzffgVar.zzaa(4, this.zzlwr);
            }
            this.zzpgr.zza(zzffgVar);
        }

        @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
        public final int zzho() {
            int i = this.zzpgs;
            if (i != -1) {
                return i;
            }
            int zzo = this.zzlwa.isEmpty() ? 0 : 0 + zzffg.zzo(1, this.zzlwa);
            if (this.zzlxd != zzdtb.UNKNOWN_STATUS.zzhq()) {
                zzo += zzffg.zzag(2, this.zzlxd);
            }
            int i2 = this.zzlxe;
            if (i2 != 0) {
                zzo += zzffg.zzae(3, i2);
            }
            if (this.zzlwr != zzdtt.UNKNOWN_PREFIX.zzhq()) {
                zzo += zzffg.zzag(4, this.zzlwr);
            }
            int zzho = zzo + this.zzpgr.zzho();
            this.zzpgs = zzho;
            return zzho;
        }
    }

    static {
        zzdtj zzdtjVar = new zzdtj();
        zzlxh = zzdtjVar;
        zzdtjVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdtjVar.zzpgr.zzbiy();
    }

    private zzdtj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        if (zzbVar == null) {
            throw new NullPointerException();
        }
        if (!this.zzlxg.zzcvi()) {
            zzfgd<zzb> zzfgdVar = this.zzlxg;
            int size = zzfgdVar.size();
            this.zzlxg = zzfgdVar.zzly(size == 0 ? 10 : size << 1);
        }
        this.zzlxg.add(zzbVar);
    }

    public static zza zzbpn() {
        zzdtj zzdtjVar = zzlxh;
        zzffu.zza zzaVar = (zzffu.zza) zzdtjVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdtjVar);
        return (zza) zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzfx(int i) {
        this.zzlwz = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdtk.zzbbi[i - 1]) {
            case 1:
                return new zzdtj();
            case 2:
                return zzlxh;
            case 3:
                this.zzlxg.zzbiy();
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdtj zzdtjVar = (zzdtj) obj2;
                this.zzlwz = zzhVar.zza(this.zzlwz != 0, this.zzlwz, zzdtjVar.zzlwz != 0, zzdtjVar.zzlwz);
                this.zzlxg = zzhVar.zza(this.zzlxg, zzdtjVar.zzlxg);
                if (zzhVar == zzffu.zzf.zzphb) {
                    this.zzlwy |= zzdtjVar.zzlwy;
                }
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    while (!r0) {
                        try {
                            try {
                                int zzcvt = zzffbVar.zzcvt();
                                if (zzcvt != 0) {
                                    if (zzcvt == 8) {
                                        this.zzlwz = zzffbVar.zzcwc();
                                    } else if (zzcvt == 18) {
                                        if (!this.zzlxg.zzcvi()) {
                                            zzfgd<zzb> zzfgdVar = this.zzlxg;
                                            int size = zzfgdVar.size();
                                            this.zzlxg = zzfgdVar.zzly(size == 0 ? 10 : size << 1);
                                        }
                                        this.zzlxg.add((zzb) zzffbVar.zza((zzffb) zzb.zzbpq(), zzffmVar));
                                    } else if (!zza(zzcvt, zzffbVar)) {
                                    }
                                }
                                r0 = true;
                            } catch (IOException e) {
                                throw new RuntimeException(new zzfge(e.getMessage()).zzi(this));
                            }
                        } catch (zzfge e2) {
                            throw new RuntimeException(e2.zzi(this));
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
                    synchronized (zzdtj.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlxh);
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
        return zzlxh;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzlwz;
        if (i != 0) {
            zzffgVar.zzab(1, i);
        }
        for (int i2 = 0; i2 < this.zzlxg.size(); i2++) {
            zzffgVar.zza(2, this.zzlxg.get(i2));
        }
        this.zzpgr.zza(zzffgVar);
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzlwz;
        int zzae = i2 != 0 ? zzffg.zzae(1, i2) + 0 : 0;
        for (int i3 = 0; i3 < this.zzlxg.size(); i3++) {
            zzae += zzffg.zzc(2, this.zzlxg.get(i3));
        }
        int zzho = zzae + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
