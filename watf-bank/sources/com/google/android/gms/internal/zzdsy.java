package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzdsy extends zzffu<zzdsy, zza> implements zzfhg {
    private static volatile zzfhk<zzdsy> zzbbk;
    private static final zzdsy zzlwd;
    private String zzlwa = "";
    private zzfes zzlwb = zzfes.zzpfg;
    private int zzlwc;

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzdsy, zza> implements zzfhg {
        private zza() {
            super(zzdsy.zzlwd);
        }

        /* synthetic */ zza(zzdsz zzdszVar) {
            this();
        }

        public final zza zzai(zzfes zzfesVar) {
            zzcxr();
            ((zzdsy) this.zzpgv).zzah(zzfesVar);
            return this;
        }

        public final zza zzb(zzb zzbVar) {
            zzcxr();
            ((zzdsy) this.zzpgv).zza(zzbVar);
            return this;
        }

        public final zza zzoj(String str) {
            zzcxr();
            ((zzdsy) this.zzpgv).zzoi(str);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum zzb implements zzfga {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzfgb<zzb> zzbcl = new zzdta();
        private final int value;

        zzb(int i) {
            this.value = i;
        }

        public static zzb zzft(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return REMOTE;
                        }
                        return ASYMMETRIC_PUBLIC;
                    }
                    return ASYMMETRIC_PRIVATE;
                }
                return SYMMETRIC;
            }
            return UNKNOWN_KEYMATERIAL;
        }

        @Override // com.google.android.gms.internal.zzfga
        public final int zzhq() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        zzdsy zzdsyVar = new zzdsy();
        zzlwd = zzdsyVar;
        zzdsyVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzdsyVar.zzpgr.zzbiy();
    }

    private zzdsy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        if (zzbVar == null) {
            throw new NullPointerException();
        }
        this.zzlwc = zzbVar.zzhq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzah(zzfes zzfesVar) {
        if (zzfesVar == null) {
            throw new NullPointerException();
        }
        this.zzlwb = zzfesVar;
    }

    public static zza zzboq() {
        zzdsy zzdsyVar = zzlwd;
        zzffu.zza zzaVar = (zzffu.zza) zzdsyVar.zza(zzffu.zzg.zzphj, (Object) null, (Object) null);
        zzaVar.zza((zzffu.zza) zzdsyVar);
        return (zza) zzaVar;
    }

    public static zzdsy zzbor() {
        return zzlwd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzoi(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzlwa = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    protected final Object zza(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdsz.zzbbi[i - 1]) {
            case 1:
                return new zzdsy();
            case 2:
                return zzlwd;
            case 3:
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzdsy zzdsyVar = (zzdsy) obj2;
                this.zzlwa = zzhVar.zza(!this.zzlwa.isEmpty(), this.zzlwa, !zzdsyVar.zzlwa.isEmpty(), zzdsyVar.zzlwa);
                this.zzlwb = zzhVar.zza(this.zzlwb != zzfes.zzpfg, this.zzlwb, zzdsyVar.zzlwb != zzfes.zzpfg, zzdsyVar.zzlwb);
                this.zzlwc = zzhVar.zza(this.zzlwc != 0, this.zzlwc, zzdsyVar.zzlwc != 0, zzdsyVar.zzlwc);
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
                                } else if (zzcvt == 18) {
                                    this.zzlwb = zzffbVar.zzcwb();
                                } else if (zzcvt == 24) {
                                    this.zzlwc = zzffbVar.zzcwd();
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
                    synchronized (zzdsy.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzlwd);
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
        return zzlwd;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        if (!this.zzlwa.isEmpty()) {
            zzffgVar.zzn(1, this.zzlwa);
        }
        if (!this.zzlwb.isEmpty()) {
            zzffgVar.zza(2, this.zzlwb);
        }
        if (this.zzlwc != zzb.UNKNOWN_KEYMATERIAL.zzhq()) {
            zzffgVar.zzaa(3, this.zzlwc);
        }
        this.zzpgr.zza(zzffgVar);
    }

    public final String zzbon() {
        return this.zzlwa;
    }

    public final zzfes zzboo() {
        return this.zzlwb;
    }

    public final zzb zzbop() {
        zzb zzft = zzb.zzft(this.zzlwc);
        return zzft == null ? zzb.UNRECOGNIZED : zzft;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int zzo = this.zzlwa.isEmpty() ? 0 : 0 + zzffg.zzo(1, this.zzlwa);
        if (!this.zzlwb.isEmpty()) {
            zzo += zzffg.zzc(2, this.zzlwb);
        }
        if (this.zzlwc != zzb.UNKNOWN_KEYMATERIAL.zzhq()) {
            zzo += zzffg.zzag(3, this.zzlwc);
        }
        int zzho = zzo + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
