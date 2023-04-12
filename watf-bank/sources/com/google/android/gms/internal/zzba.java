package com.google.android.gms.internal;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzba extends zzfjm<zzba> {
    private static volatile zzba[] zzfj;
    public Integer zzfo;
    public Integer zzfs;
    public Long zzdn = null;
    public Long zzdo = null;
    public Long zzfk = null;
    public Long zzfl = null;
    public Long zzfm = null;
    public Long zzfn = null;
    public Long zzfp = null;
    public Long zzfq = null;
    public Long zzfr = null;
    public Long zzft = null;
    public Long zzfu = null;
    public Long zzfv = null;
    public Long zzfw = null;
    public Long zzfx = null;
    public Long zzfy = null;
    public Long zzfz = null;
    public Long zzga = null;
    public Long zzgb = null;
    public Long zzgc = null;

    public zzba() {
        this.zzpfd = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjs
    /* renamed from: zzc */
    public final zzba zza(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            switch (zzcvt) {
                case 0:
                    return this;
                case 8:
                    this.zzdn = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 16:
                    this.zzdo = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 24:
                    this.zzfk = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 32:
                    this.zzfl = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 40:
                    this.zzfm = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 48:
                    this.zzfn = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 56:
                    zzfjjVar.getPosition();
                    this.zzfo = Integer.valueOf(zzay.zzd(zzfjjVar.zzcwi()));
                    break;
                case 64:
                    this.zzfp = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 72:
                    this.zzfq = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 80:
                    this.zzfr = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 88:
                    int position = zzfjjVar.getPosition();
                    try {
                        this.zzfs = Integer.valueOf(zzay.zzd(zzfjjVar.zzcwi()));
                        break;
                    } catch (IllegalArgumentException e) {
                        zzfjjVar.zzmg(position);
                        zza(zzfjjVar, zzcvt);
                        break;
                    }
                case 96:
                    this.zzft = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 104:
                    this.zzfu = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 112:
                    this.zzfv = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 120:
                    this.zzfw = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 128:
                    this.zzfx = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 136:
                    this.zzfy = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 144:
                    this.zzfz = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 152:
                    this.zzga = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 160:
                    this.zzgb = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 168:
                    this.zzgc = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                default:
                    if (super.zza(zzfjjVar, zzcvt)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    public static zzba[] zzr() {
        if (zzfj == null) {
            synchronized (zzfjq.zzpnk) {
                if (zzfj == null) {
                    zzfj = new zzba[0];
                }
            }
        }
        return zzfj;
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        Long l = this.zzdn;
        if (l != null) {
            zzfjkVar.zzf(1, l.longValue());
        }
        Long l2 = this.zzdo;
        if (l2 != null) {
            zzfjkVar.zzf(2, l2.longValue());
        }
        Long l3 = this.zzfk;
        if (l3 != null) {
            zzfjkVar.zzf(3, l3.longValue());
        }
        Long l4 = this.zzfl;
        if (l4 != null) {
            zzfjkVar.zzf(4, l4.longValue());
        }
        Long l5 = this.zzfm;
        if (l5 != null) {
            zzfjkVar.zzf(5, l5.longValue());
        }
        Long l6 = this.zzfn;
        if (l6 != null) {
            zzfjkVar.zzf(6, l6.longValue());
        }
        Integer num = this.zzfo;
        if (num != null) {
            zzfjkVar.zzaa(7, num.intValue());
        }
        Long l7 = this.zzfp;
        if (l7 != null) {
            zzfjkVar.zzf(8, l7.longValue());
        }
        Long l8 = this.zzfq;
        if (l8 != null) {
            zzfjkVar.zzf(9, l8.longValue());
        }
        Long l9 = this.zzfr;
        if (l9 != null) {
            zzfjkVar.zzf(10, l9.longValue());
        }
        Integer num2 = this.zzfs;
        if (num2 != null) {
            zzfjkVar.zzaa(11, num2.intValue());
        }
        Long l10 = this.zzft;
        if (l10 != null) {
            zzfjkVar.zzf(12, l10.longValue());
        }
        Long l11 = this.zzfu;
        if (l11 != null) {
            zzfjkVar.zzf(13, l11.longValue());
        }
        Long l12 = this.zzfv;
        if (l12 != null) {
            zzfjkVar.zzf(14, l12.longValue());
        }
        Long l13 = this.zzfw;
        if (l13 != null) {
            zzfjkVar.zzf(15, l13.longValue());
        }
        Long l14 = this.zzfx;
        if (l14 != null) {
            zzfjkVar.zzf(16, l14.longValue());
        }
        Long l15 = this.zzfy;
        if (l15 != null) {
            zzfjkVar.zzf(17, l15.longValue());
        }
        Long l16 = this.zzfz;
        if (l16 != null) {
            zzfjkVar.zzf(18, l16.longValue());
        }
        Long l17 = this.zzga;
        if (l17 != null) {
            zzfjkVar.zzf(19, l17.longValue());
        }
        Long l18 = this.zzgb;
        if (l18 != null) {
            zzfjkVar.zzf(20, l18.longValue());
        }
        Long l19 = this.zzgc;
        if (l19 != null) {
            zzfjkVar.zzf(21, l19.longValue());
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        Long l = this.zzdn;
        if (l != null) {
            zzq += zzfjk.zzc(1, l.longValue());
        }
        Long l2 = this.zzdo;
        if (l2 != null) {
            zzq += zzfjk.zzc(2, l2.longValue());
        }
        Long l3 = this.zzfk;
        if (l3 != null) {
            zzq += zzfjk.zzc(3, l3.longValue());
        }
        Long l4 = this.zzfl;
        if (l4 != null) {
            zzq += zzfjk.zzc(4, l4.longValue());
        }
        Long l5 = this.zzfm;
        if (l5 != null) {
            zzq += zzfjk.zzc(5, l5.longValue());
        }
        Long l6 = this.zzfn;
        if (l6 != null) {
            zzq += zzfjk.zzc(6, l6.longValue());
        }
        Integer num = this.zzfo;
        if (num != null) {
            zzq += zzfjk.zzad(7, num.intValue());
        }
        Long l7 = this.zzfp;
        if (l7 != null) {
            zzq += zzfjk.zzc(8, l7.longValue());
        }
        Long l8 = this.zzfq;
        if (l8 != null) {
            zzq += zzfjk.zzc(9, l8.longValue());
        }
        Long l9 = this.zzfr;
        if (l9 != null) {
            zzq += zzfjk.zzc(10, l9.longValue());
        }
        Integer num2 = this.zzfs;
        if (num2 != null) {
            zzq += zzfjk.zzad(11, num2.intValue());
        }
        Long l10 = this.zzft;
        if (l10 != null) {
            zzq += zzfjk.zzc(12, l10.longValue());
        }
        Long l11 = this.zzfu;
        if (l11 != null) {
            zzq += zzfjk.zzc(13, l11.longValue());
        }
        Long l12 = this.zzfv;
        if (l12 != null) {
            zzq += zzfjk.zzc(14, l12.longValue());
        }
        Long l13 = this.zzfw;
        if (l13 != null) {
            zzq += zzfjk.zzc(15, l13.longValue());
        }
        Long l14 = this.zzfx;
        if (l14 != null) {
            zzq += zzfjk.zzc(16, l14.longValue());
        }
        Long l15 = this.zzfy;
        if (l15 != null) {
            zzq += zzfjk.zzc(17, l15.longValue());
        }
        Long l16 = this.zzfz;
        if (l16 != null) {
            zzq += zzfjk.zzc(18, l16.longValue());
        }
        Long l17 = this.zzga;
        if (l17 != null) {
            zzq += zzfjk.zzc(19, l17.longValue());
        }
        Long l18 = this.zzgb;
        if (l18 != null) {
            zzq += zzfjk.zzc(20, l18.longValue());
        }
        Long l19 = this.zzgc;
        return l19 != null ? zzq + zzfjk.zzc(21, l19.longValue()) : zzq;
    }
}
