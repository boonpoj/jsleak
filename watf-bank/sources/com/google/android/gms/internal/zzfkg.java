package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfkg extends zzffu<zzfkg, zza> implements zzfhg {
    private static volatile zzfhk<zzfkg> zzbbk;
    private static final zzfkg zzppn;
    private int zzlwy;
    private int zzppk;
    private String zzppl = "";
    private zzfgd<zzfep> zzppm = zzcxo();

    /* loaded from: classes.dex */
    public static final class zza extends zzffu.zza<zzfkg, zza> implements zzfhg {
        private zza() {
            super(zzfkg.zzppn);
        }

        /* synthetic */ zza(zzfkh zzfkhVar) {
            this();
        }
    }

    static {
        zzfkg zzfkgVar = new zzfkg();
        zzppn = zzfkgVar;
        zzfkgVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
        zzfkgVar.zzpgr.zzbiy();
    }

    private zzfkg() {
    }

    public static zzfkg zzdap() {
        return zzppn;
    }

    public final int getCode() {
        return this.zzppk;
    }

    public final String getMessage() {
        return this.zzppl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzffu
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzfkh.zzbbi[i - 1]) {
            case 1:
                return new zzfkg();
            case 2:
                return zzppn;
            case 3:
                this.zzppm.zzbiy();
                return null;
            case 4:
                return new zza(null);
            case 5:
                zzffu.zzh zzhVar = (zzffu.zzh) obj;
                zzfkg zzfkgVar = (zzfkg) obj2;
                this.zzppk = zzhVar.zza(this.zzppk != 0, this.zzppk, zzfkgVar.zzppk != 0, zzfkgVar.zzppk);
                this.zzppl = zzhVar.zza(!this.zzppl.isEmpty(), this.zzppl, true ^ zzfkgVar.zzppl.isEmpty(), zzfkgVar.zzppl);
                this.zzppm = zzhVar.zza(this.zzppm, zzfkgVar.zzppm);
                if (zzhVar == zzffu.zzf.zzphb) {
                    this.zzlwy |= zzfkgVar.zzlwy;
                }
                return this;
            case 6:
                zzffb zzffbVar = (zzffb) obj;
                zzffm zzffmVar = (zzffm) obj2;
                if (zzffmVar != null) {
                    while (!r0) {
                        try {
                            int zzcvt = zzffbVar.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 8) {
                                    this.zzppk = zzffbVar.zzcvw();
                                } else if (zzcvt == 18) {
                                    this.zzppl = zzffbVar.zzcwa();
                                } else if (zzcvt == 26) {
                                    if (!this.zzppm.zzcvi()) {
                                        zzfgd<zzfep> zzfgdVar = this.zzppm;
                                        int size = zzfgdVar.size();
                                        this.zzppm = zzfgdVar.zzly(size == 0 ? 10 : size << 1);
                                    }
                                    this.zzppm.add((zzfep) zzffbVar.zza((zzffb) zzfep.zzcvk(), zzffmVar));
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
                    synchronized (zzfkg.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzffu.zzb(zzppn);
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
        return zzppn;
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final void zza(zzffg zzffgVar) throws IOException {
        int i = this.zzppk;
        if (i != 0) {
            zzffgVar.zzaa(1, i);
        }
        if (!this.zzppl.isEmpty()) {
            zzffgVar.zzn(2, this.zzppl);
        }
        for (int i2 = 0; i2 < this.zzppm.size(); i2++) {
            zzffgVar.zza(3, this.zzppm.get(i2));
        }
        this.zzpgr.zza(zzffgVar);
    }

    @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = this.zzppk;
        int zzad = i2 != 0 ? zzffg.zzad(1, i2) + 0 : 0;
        if (!this.zzppl.isEmpty()) {
            zzad += zzffg.zzo(2, this.zzppl);
        }
        for (int i3 = 0; i3 < this.zzppm.size(); i3++) {
            zzad += zzffg.zzc(3, this.zzppm.get(i3));
        }
        int zzho = zzad + this.zzpgr.zzho();
        this.zzpgs = zzho;
        return zzho;
    }
}
