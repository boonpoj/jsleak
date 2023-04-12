package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
import java.util.List;
/* loaded from: classes.dex */
public final class zzdtv extends zzffu<zzdtv, zza> implements zzfhg {
    private static volatile zzfhk<zzdtv> zzbbk;
    private static final zzdtv zzlyb;
    private int zzlwy;
    private String zzlxz = "";
    private zzfgd<zzdtf> zzlya = zzcxo();

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdtv, zza> implements zzfhg {
        private zza() {
            super(zzdtv.zzlyb);
        }

        /* synthetic */ zza(zzdtw zzdtwVar) {
            this();
        }

        public final zza zzb(zzdtf zzdtfVar) {
            zzcxr();
            ((zzdtv) this.zzpgv).zza(zzdtfVar);
            return this;
        }

        public final zza zzor(String str) {
            zzcxr();
            ((zzdtv) this.zzpgv).zzoq(str);
            return this;
        }
    }

    static {
        zzdtv zzdtvVar = new zzdtv();
        zzlyb = zzdtvVar;
        zzdtvVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdtvVar.zzpgr.zzbiy();
    }

    private zzdtv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdtf zzdtfVar) {
        if (zzdtfVar == null) {
            throw new NullPointerException();
        }
        if (!this.zzlya.zzcvi()) {
            zzfgd<zzdtf> zzfgdVar = this.zzlya;
            int size = zzfgdVar.size();
            this.zzlya = zzfgdVar.zzly(size == 0 ? 10 : size << 1);
        }
        this.zzlya.add(zzdtfVar);
    }

    public static zza zzbqg() {
        zzdtv zzdtvVar = zzlyb;
        zzffu.zza zzaVar = (zzffu.zza) zzdtvVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdtvVar);
        return (zza) zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzoq(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzlxz = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdtw.zzbbi[i - 1]) {
            case 1:
                return new zzdtv();
            case 2:
                return zzlyb;
            case 3:
                this.zzlya.zzbiy();
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdtv zzdtvVar = (zzdtv) obj2;
                this.zzlxz = zzhVar.zza(!this.zzlxz.isEmpty(), this.zzlxz, true ^ zzdtvVar.zzlxz.isEmpty(), zzdtvVar.zzlxz);
                this.zzlya = zzhVar.zza(this.zzlya, zzdtvVar.zzlya);
                if (zzhVar == zzffu.zzf.zzphb) {
                    this.zzlwy |= zzdtvVar.zzlwy;
                }
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int zzcvt = zzffbVar.zzcvt();
                                if (zzcvt != 0) {
                                    int i2 = 10;
                                    if (zzcvt == 10) {
                                        this.zzlxz = zzffbVar.zzcwa();
                                    } else if (zzcvt == 18) {
                                        if (!this.zzlya.zzcvi()) {
                                            zzfgd<zzdtf> zzfgdVar = this.zzlya;
                                            int size = zzfgdVar.size();
                                            if (size != 0) {
                                                i2 = size << 1;
                                            }
                                            this.zzlya = zzfgdVar.zzly(i2);
                                        }
                                        this.zzlya.add((zzdtf) zzffbVar.zza((zzffb) zzdtf.zzbpa(), zzffmVar));
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
                    synchronized (zzdtv.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlyb);
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
        return zzlyb;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        if (!this.zzlxz.isEmpty()) {
            zzffgVar.zzn(1, this.zzlxz);
        }
        for (int i = 0; i < this.zzlya.size(); i++) {
            zzffgVar.zza(2, this.zzlya.get(i));
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final List<zzdtf> zzbqf() {
        return this.zzlya;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int zzo = !this.zzlxz.isEmpty() ? zzffg.zzo(1, this.zzlxz) + 0 : 0;
        for (int i2 = 0; i2 < this.zzlya.size(); i2++) {
            zzo += zzffg.zzc(2, this.zzlya.get(i2));
        }
        int zzho = zzo + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
