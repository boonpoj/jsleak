package com.google.android.gms.internal;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzaz extends zzfjm<zzaz> {
    public Integer zzek;
    public Integer zzel;
    public Integer zzer;
    public Integer zzfe;
    public String zzdb = null;
    public String zzcv = null;
    public Long zzdc = null;
    private Long zzdd = null;
    public Long zzde = null;
    public Long zzdf = null;
    private Long zzdg = null;
    private Long zzdh = null;
    private Long zzdi = null;
    private Long zzdj = null;
    private Long zzdk = null;
    public Long zzdl = null;
    private String zzdm = null;
    public Long zzdn = null;
    public Long zzdo = null;
    public Long zzdp = null;
    public Long zzdq = null;
    private Long zzdr = null;
    private Long zzds = null;
    public Long zzdt = null;
    public Long zzdu = null;
    public Long zzdv = null;
    public String zzcw = null;
    public String zzdw = null;
    public Long zzdx = null;
    public Long zzdy = null;
    public Long zzdz = null;
    public String zzcy = null;
    public Long zzea = null;
    public Long zzeb = null;
    public Long zzec = null;
    private zzbc zzed = null;
    public Long zzee = null;
    public Long zzef = null;
    public Long zzeg = null;
    public Long zzeh = null;
    public Long zzei = null;
    public Long zzej = null;
    public String zzcz = null;
    public String zzda = null;
    public Long zzem = null;
    public Long zzen = null;
    public Long zzeo = null;
    private Long zzep = null;
    private Long zzeq = null;
    public zzba zzes = null;
    public zzba[] zzet = zzba.zzr();
    public zzbb zzeu = null;
    private Long zzev = null;
    public Long zzew = null;
    public Long zzex = null;
    public Long zzey = null;
    public Long zzez = null;
    public Long zzfa = null;
    private Long zzfb = null;
    private Long zzfc = null;
    public String zzfd = null;
    public Boolean zzff = null;
    private String zzfg = null;
    public Long zzfh = null;
    public zzbe zzfi = null;

    public zzaz() {
        this.zzpfd = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjs
    /* renamed from: zzb */
    public final zzaz zza(zzfjj zzfjjVar) throws IOException {
        int position;
        zzfjs zzfjsVar;
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            switch (zzcvt) {
                case 0:
                    return this;
                case 10:
                    this.zzdb = zzfjjVar.readString();
                    break;
                case 18:
                    this.zzcv = zzfjjVar.readString();
                    break;
                case 24:
                    this.zzdc = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 32:
                    this.zzdd = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 40:
                    this.zzde = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 48:
                    this.zzdf = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 56:
                    this.zzdg = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 64:
                    this.zzdh = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 72:
                    this.zzdi = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 80:
                    this.zzdj = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 88:
                    this.zzdk = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 96:
                    this.zzdl = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 106:
                    this.zzdm = zzfjjVar.readString();
                    break;
                case 112:
                    this.zzdn = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 120:
                    this.zzdo = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 128:
                    this.zzdp = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 136:
                    this.zzdq = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 144:
                    this.zzdr = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 152:
                    this.zzds = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 160:
                    this.zzdt = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 168:
                    this.zzfc = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 176:
                    this.zzdu = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 184:
                    this.zzdv = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 194:
                    this.zzfd = zzfjjVar.readString();
                    break;
                case 200:
                    this.zzfh = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 208:
                    position = zzfjjVar.getPosition();
                    int zzcwi = zzfjjVar.zzcwi();
                    switch (zzcwi) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.zzfe = Integer.valueOf(zzcwi);
                            break;
                        default:
                            StringBuilder sb = new StringBuilder(44);
                            sb.append(zzcwi);
                            sb.append(" is not a valid enum DeviceIdType");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                    }
                case 218:
                    this.zzcw = zzfjjVar.readString();
                    break;
                case 224:
                    this.zzff = Boolean.valueOf(zzfjjVar.zzcvz());
                    break;
                case 234:
                    this.zzdw = zzfjjVar.readString();
                    break;
                case 242:
                    this.zzfg = zzfjjVar.readString();
                    break;
                case 248:
                    this.zzdx = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 256:
                    this.zzdy = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 264:
                    this.zzdz = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 274:
                    this.zzcy = zzfjjVar.readString();
                    break;
                case 280:
                    this.zzea = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 288:
                    this.zzeb = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 296:
                    this.zzec = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 306:
                    if (this.zzed == null) {
                        this.zzed = new zzbc();
                    }
                    zzfjsVar = this.zzed;
                    zzfjjVar.zza(zzfjsVar);
                    break;
                case 312:
                    this.zzee = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 320:
                    this.zzef = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 328:
                    this.zzeg = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 336:
                    this.zzeh = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 346:
                    int zzb = zzfjv.zzb(zzfjjVar, 346);
                    zzba[] zzbaVarArr = this.zzet;
                    int length = zzbaVarArr == null ? 0 : zzbaVarArr.length;
                    zzba[] zzbaVarArr2 = new zzba[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzet, 0, zzbaVarArr2, 0, length);
                    }
                    while (length < zzbaVarArr2.length - 1) {
                        zzbaVarArr2[length] = new zzba();
                        zzfjjVar.zza(zzbaVarArr2[length]);
                        zzfjjVar.zzcvt();
                        length++;
                    }
                    zzbaVarArr2[length] = new zzba();
                    zzfjjVar.zza(zzbaVarArr2[length]);
                    this.zzet = zzbaVarArr2;
                    break;
                case 352:
                    this.zzei = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 360:
                    this.zzej = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 370:
                    this.zzcz = zzfjjVar.readString();
                    break;
                case 378:
                    this.zzda = zzfjjVar.readString();
                    break;
                case 384:
                    zzfjjVar.getPosition();
                    this.zzek = Integer.valueOf(zzay.zzd(zzfjjVar.zzcwi()));
                    break;
                case 392:
                    zzfjjVar.getPosition();
                    this.zzel = Integer.valueOf(zzay.zzd(zzfjjVar.zzcwi()));
                    break;
                case 402:
                    if (this.zzes == null) {
                        this.zzes = new zzba();
                    }
                    zzfjsVar = this.zzes;
                    zzfjjVar.zza(zzfjsVar);
                    break;
                case 408:
                    this.zzem = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 416:
                    this.zzen = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 424:
                    this.zzeo = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 432:
                    this.zzep = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 440:
                    this.zzeq = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 448:
                    position = zzfjjVar.getPosition();
                    try {
                        this.zzer = Integer.valueOf(zzay.zzd(zzfjjVar.zzcwi()));
                        break;
                    } catch (IllegalArgumentException e) {
                        zzfjjVar.zzmg(position);
                        zza(zzfjjVar, zzcvt);
                        break;
                    }
                case 458:
                    if (this.zzeu == null) {
                        this.zzeu = new zzbb();
                    }
                    zzfjsVar = this.zzeu;
                    zzfjjVar.zza(zzfjsVar);
                    break;
                case 464:
                    this.zzev = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 472:
                    this.zzew = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 480:
                    this.zzex = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 488:
                    this.zzey = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 496:
                    this.zzez = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 504:
                    this.zzfa = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 512:
                    this.zzfb = Long.valueOf(zzfjjVar.zzcwn());
                    break;
                case 1610:
                    if (this.zzfi == null) {
                        this.zzfi = new zzbe();
                    }
                    zzfjsVar = this.zzfi;
                    zzfjjVar.zza(zzfjsVar);
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

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        String str = this.zzdb;
        if (str != null) {
            zzfjkVar.zzn(1, str);
        }
        String str2 = this.zzcv;
        if (str2 != null) {
            zzfjkVar.zzn(2, str2);
        }
        Long l = this.zzdc;
        if (l != null) {
            zzfjkVar.zzf(3, l.longValue());
        }
        Long l2 = this.zzdd;
        if (l2 != null) {
            zzfjkVar.zzf(4, l2.longValue());
        }
        Long l3 = this.zzde;
        if (l3 != null) {
            zzfjkVar.zzf(5, l3.longValue());
        }
        Long l4 = this.zzdf;
        if (l4 != null) {
            zzfjkVar.zzf(6, l4.longValue());
        }
        Long l5 = this.zzdg;
        if (l5 != null) {
            zzfjkVar.zzf(7, l5.longValue());
        }
        Long l6 = this.zzdh;
        if (l6 != null) {
            zzfjkVar.zzf(8, l6.longValue());
        }
        Long l7 = this.zzdi;
        if (l7 != null) {
            zzfjkVar.zzf(9, l7.longValue());
        }
        Long l8 = this.zzdj;
        if (l8 != null) {
            zzfjkVar.zzf(10, l8.longValue());
        }
        Long l9 = this.zzdk;
        if (l9 != null) {
            zzfjkVar.zzf(11, l9.longValue());
        }
        Long l10 = this.zzdl;
        if (l10 != null) {
            zzfjkVar.zzf(12, l10.longValue());
        }
        String str3 = this.zzdm;
        if (str3 != null) {
            zzfjkVar.zzn(13, str3);
        }
        Long l11 = this.zzdn;
        if (l11 != null) {
            zzfjkVar.zzf(14, l11.longValue());
        }
        Long l12 = this.zzdo;
        if (l12 != null) {
            zzfjkVar.zzf(15, l12.longValue());
        }
        Long l13 = this.zzdp;
        if (l13 != null) {
            zzfjkVar.zzf(16, l13.longValue());
        }
        Long l14 = this.zzdq;
        if (l14 != null) {
            zzfjkVar.zzf(17, l14.longValue());
        }
        Long l15 = this.zzdr;
        if (l15 != null) {
            zzfjkVar.zzf(18, l15.longValue());
        }
        Long l16 = this.zzds;
        if (l16 != null) {
            zzfjkVar.zzf(19, l16.longValue());
        }
        Long l17 = this.zzdt;
        if (l17 != null) {
            zzfjkVar.zzf(20, l17.longValue());
        }
        Long l18 = this.zzfc;
        if (l18 != null) {
            zzfjkVar.zzf(21, l18.longValue());
        }
        Long l19 = this.zzdu;
        if (l19 != null) {
            zzfjkVar.zzf(22, l19.longValue());
        }
        Long l20 = this.zzdv;
        if (l20 != null) {
            zzfjkVar.zzf(23, l20.longValue());
        }
        String str4 = this.zzfd;
        if (str4 != null) {
            zzfjkVar.zzn(24, str4);
        }
        Long l21 = this.zzfh;
        if (l21 != null) {
            zzfjkVar.zzf(25, l21.longValue());
        }
        Integer num = this.zzfe;
        if (num != null) {
            zzfjkVar.zzaa(26, num.intValue());
        }
        String str5 = this.zzcw;
        if (str5 != null) {
            zzfjkVar.zzn(27, str5);
        }
        Boolean bool = this.zzff;
        if (bool != null) {
            zzfjkVar.zzl(28, bool.booleanValue());
        }
        String str6 = this.zzdw;
        if (str6 != null) {
            zzfjkVar.zzn(29, str6);
        }
        String str7 = this.zzfg;
        if (str7 != null) {
            zzfjkVar.zzn(30, str7);
        }
        Long l22 = this.zzdx;
        if (l22 != null) {
            zzfjkVar.zzf(31, l22.longValue());
        }
        Long l23 = this.zzdy;
        if (l23 != null) {
            zzfjkVar.zzf(32, l23.longValue());
        }
        Long l24 = this.zzdz;
        if (l24 != null) {
            zzfjkVar.zzf(33, l24.longValue());
        }
        String str8 = this.zzcy;
        if (str8 != null) {
            zzfjkVar.zzn(34, str8);
        }
        Long l25 = this.zzea;
        if (l25 != null) {
            zzfjkVar.zzf(35, l25.longValue());
        }
        Long l26 = this.zzeb;
        if (l26 != null) {
            zzfjkVar.zzf(36, l26.longValue());
        }
        Long l27 = this.zzec;
        if (l27 != null) {
            zzfjkVar.zzf(37, l27.longValue());
        }
        zzbc zzbcVar = this.zzed;
        if (zzbcVar != null) {
            zzfjkVar.zza(38, zzbcVar);
        }
        Long l28 = this.zzee;
        if (l28 != null) {
            zzfjkVar.zzf(39, l28.longValue());
        }
        Long l29 = this.zzef;
        if (l29 != null) {
            zzfjkVar.zzf(40, l29.longValue());
        }
        Long l30 = this.zzeg;
        if (l30 != null) {
            zzfjkVar.zzf(41, l30.longValue());
        }
        Long l31 = this.zzeh;
        if (l31 != null) {
            zzfjkVar.zzf(42, l31.longValue());
        }
        zzba[] zzbaVarArr = this.zzet;
        if (zzbaVarArr != null && zzbaVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzba[] zzbaVarArr2 = this.zzet;
                if (i >= zzbaVarArr2.length) {
                    break;
                }
                zzba zzbaVar = zzbaVarArr2[i];
                if (zzbaVar != null) {
                    zzfjkVar.zza(43, zzbaVar);
                }
                i++;
            }
        }
        Long l32 = this.zzei;
        if (l32 != null) {
            zzfjkVar.zzf(44, l32.longValue());
        }
        Long l33 = this.zzej;
        if (l33 != null) {
            zzfjkVar.zzf(45, l33.longValue());
        }
        String str9 = this.zzcz;
        if (str9 != null) {
            zzfjkVar.zzn(46, str9);
        }
        String str10 = this.zzda;
        if (str10 != null) {
            zzfjkVar.zzn(47, str10);
        }
        Integer num2 = this.zzek;
        if (num2 != null) {
            zzfjkVar.zzaa(48, num2.intValue());
        }
        Integer num3 = this.zzel;
        if (num3 != null) {
            zzfjkVar.zzaa(49, num3.intValue());
        }
        zzba zzbaVar2 = this.zzes;
        if (zzbaVar2 != null) {
            zzfjkVar.zza(50, zzbaVar2);
        }
        Long l34 = this.zzem;
        if (l34 != null) {
            zzfjkVar.zzf(51, l34.longValue());
        }
        Long l35 = this.zzen;
        if (l35 != null) {
            zzfjkVar.zzf(52, l35.longValue());
        }
        Long l36 = this.zzeo;
        if (l36 != null) {
            zzfjkVar.zzf(53, l36.longValue());
        }
        Long l37 = this.zzep;
        if (l37 != null) {
            zzfjkVar.zzf(54, l37.longValue());
        }
        Long l38 = this.zzeq;
        if (l38 != null) {
            zzfjkVar.zzf(55, l38.longValue());
        }
        Integer num4 = this.zzer;
        if (num4 != null) {
            zzfjkVar.zzaa(56, num4.intValue());
        }
        zzbb zzbbVar = this.zzeu;
        if (zzbbVar != null) {
            zzfjkVar.zza(57, zzbbVar);
        }
        Long l39 = this.zzev;
        if (l39 != null) {
            zzfjkVar.zzf(58, l39.longValue());
        }
        Long l40 = this.zzew;
        if (l40 != null) {
            zzfjkVar.zzf(59, l40.longValue());
        }
        Long l41 = this.zzex;
        if (l41 != null) {
            zzfjkVar.zzf(60, l41.longValue());
        }
        Long l42 = this.zzey;
        if (l42 != null) {
            zzfjkVar.zzf(61, l42.longValue());
        }
        Long l43 = this.zzez;
        if (l43 != null) {
            zzfjkVar.zzf(62, l43.longValue());
        }
        Long l44 = this.zzfa;
        if (l44 != null) {
            zzfjkVar.zzf(63, l44.longValue());
        }
        Long l45 = this.zzfb;
        if (l45 != null) {
            zzfjkVar.zzf(64, l45.longValue());
        }
        zzbe zzbeVar = this.zzfi;
        if (zzbeVar != null) {
            zzfjkVar.zza(201, zzbeVar);
        }
        super.zza(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    protected final int zzq() {
        int zzq = super.zzq();
        String str = this.zzdb;
        if (str != null) {
            zzq += zzfjk.zzo(1, str);
        }
        String str2 = this.zzcv;
        if (str2 != null) {
            zzq += zzfjk.zzo(2, str2);
        }
        Long l = this.zzdc;
        if (l != null) {
            zzq += zzfjk.zzc(3, l.longValue());
        }
        Long l2 = this.zzdd;
        if (l2 != null) {
            zzq += zzfjk.zzc(4, l2.longValue());
        }
        Long l3 = this.zzde;
        if (l3 != null) {
            zzq += zzfjk.zzc(5, l3.longValue());
        }
        Long l4 = this.zzdf;
        if (l4 != null) {
            zzq += zzfjk.zzc(6, l4.longValue());
        }
        Long l5 = this.zzdg;
        if (l5 != null) {
            zzq += zzfjk.zzc(7, l5.longValue());
        }
        Long l6 = this.zzdh;
        if (l6 != null) {
            zzq += zzfjk.zzc(8, l6.longValue());
        }
        Long l7 = this.zzdi;
        if (l7 != null) {
            zzq += zzfjk.zzc(9, l7.longValue());
        }
        Long l8 = this.zzdj;
        if (l8 != null) {
            zzq += zzfjk.zzc(10, l8.longValue());
        }
        Long l9 = this.zzdk;
        if (l9 != null) {
            zzq += zzfjk.zzc(11, l9.longValue());
        }
        Long l10 = this.zzdl;
        if (l10 != null) {
            zzq += zzfjk.zzc(12, l10.longValue());
        }
        String str3 = this.zzdm;
        if (str3 != null) {
            zzq += zzfjk.zzo(13, str3);
        }
        Long l11 = this.zzdn;
        if (l11 != null) {
            zzq += zzfjk.zzc(14, l11.longValue());
        }
        Long l12 = this.zzdo;
        if (l12 != null) {
            zzq += zzfjk.zzc(15, l12.longValue());
        }
        Long l13 = this.zzdp;
        if (l13 != null) {
            zzq += zzfjk.zzc(16, l13.longValue());
        }
        Long l14 = this.zzdq;
        if (l14 != null) {
            zzq += zzfjk.zzc(17, l14.longValue());
        }
        Long l15 = this.zzdr;
        if (l15 != null) {
            zzq += zzfjk.zzc(18, l15.longValue());
        }
        Long l16 = this.zzds;
        if (l16 != null) {
            zzq += zzfjk.zzc(19, l16.longValue());
        }
        Long l17 = this.zzdt;
        if (l17 != null) {
            zzq += zzfjk.zzc(20, l17.longValue());
        }
        Long l18 = this.zzfc;
        if (l18 != null) {
            zzq += zzfjk.zzc(21, l18.longValue());
        }
        Long l19 = this.zzdu;
        if (l19 != null) {
            zzq += zzfjk.zzc(22, l19.longValue());
        }
        Long l20 = this.zzdv;
        if (l20 != null) {
            zzq += zzfjk.zzc(23, l20.longValue());
        }
        String str4 = this.zzfd;
        if (str4 != null) {
            zzq += zzfjk.zzo(24, str4);
        }
        Long l21 = this.zzfh;
        if (l21 != null) {
            zzq += zzfjk.zzc(25, l21.longValue());
        }
        Integer num = this.zzfe;
        if (num != null) {
            zzq += zzfjk.zzad(26, num.intValue());
        }
        String str5 = this.zzcw;
        if (str5 != null) {
            zzq += zzfjk.zzo(27, str5);
        }
        Boolean bool = this.zzff;
        if (bool != null) {
            bool.booleanValue();
            zzq += zzfjk.zzlg(28) + 1;
        }
        String str6 = this.zzdw;
        if (str6 != null) {
            zzq += zzfjk.zzo(29, str6);
        }
        String str7 = this.zzfg;
        if (str7 != null) {
            zzq += zzfjk.zzo(30, str7);
        }
        Long l22 = this.zzdx;
        if (l22 != null) {
            zzq += zzfjk.zzc(31, l22.longValue());
        }
        Long l23 = this.zzdy;
        if (l23 != null) {
            zzq += zzfjk.zzc(32, l23.longValue());
        }
        Long l24 = this.zzdz;
        if (l24 != null) {
            zzq += zzfjk.zzc(33, l24.longValue());
        }
        String str8 = this.zzcy;
        if (str8 != null) {
            zzq += zzfjk.zzo(34, str8);
        }
        Long l25 = this.zzea;
        if (l25 != null) {
            zzq += zzfjk.zzc(35, l25.longValue());
        }
        Long l26 = this.zzeb;
        if (l26 != null) {
            zzq += zzfjk.zzc(36, l26.longValue());
        }
        Long l27 = this.zzec;
        if (l27 != null) {
            zzq += zzfjk.zzc(37, l27.longValue());
        }
        zzbc zzbcVar = this.zzed;
        if (zzbcVar != null) {
            zzq += zzfjk.zzb(38, zzbcVar);
        }
        Long l28 = this.zzee;
        if (l28 != null) {
            zzq += zzfjk.zzc(39, l28.longValue());
        }
        Long l29 = this.zzef;
        if (l29 != null) {
            zzq += zzfjk.zzc(40, l29.longValue());
        }
        Long l30 = this.zzeg;
        if (l30 != null) {
            zzq += zzfjk.zzc(41, l30.longValue());
        }
        Long l31 = this.zzeh;
        if (l31 != null) {
            zzq += zzfjk.zzc(42, l31.longValue());
        }
        zzba[] zzbaVarArr = this.zzet;
        if (zzbaVarArr != null && zzbaVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzba[] zzbaVarArr2 = this.zzet;
                if (i >= zzbaVarArr2.length) {
                    break;
                }
                zzba zzbaVar = zzbaVarArr2[i];
                if (zzbaVar != null) {
                    zzq += zzfjk.zzb(43, zzbaVar);
                }
                i++;
            }
        }
        Long l32 = this.zzei;
        if (l32 != null) {
            zzq += zzfjk.zzc(44, l32.longValue());
        }
        Long l33 = this.zzej;
        if (l33 != null) {
            zzq += zzfjk.zzc(45, l33.longValue());
        }
        String str9 = this.zzcz;
        if (str9 != null) {
            zzq += zzfjk.zzo(46, str9);
        }
        String str10 = this.zzda;
        if (str10 != null) {
            zzq += zzfjk.zzo(47, str10);
        }
        Integer num2 = this.zzek;
        if (num2 != null) {
            zzq += zzfjk.zzad(48, num2.intValue());
        }
        Integer num3 = this.zzel;
        if (num3 != null) {
            zzq += zzfjk.zzad(49, num3.intValue());
        }
        zzba zzbaVar2 = this.zzes;
        if (zzbaVar2 != null) {
            zzq += zzfjk.zzb(50, zzbaVar2);
        }
        Long l34 = this.zzem;
        if (l34 != null) {
            zzq += zzfjk.zzc(51, l34.longValue());
        }
        Long l35 = this.zzen;
        if (l35 != null) {
            zzq += zzfjk.zzc(52, l35.longValue());
        }
        Long l36 = this.zzeo;
        if (l36 != null) {
            zzq += zzfjk.zzc(53, l36.longValue());
        }
        Long l37 = this.zzep;
        if (l37 != null) {
            zzq += zzfjk.zzc(54, l37.longValue());
        }
        Long l38 = this.zzeq;
        if (l38 != null) {
            zzq += zzfjk.zzc(55, l38.longValue());
        }
        Integer num4 = this.zzer;
        if (num4 != null) {
            zzq += zzfjk.zzad(56, num4.intValue());
        }
        zzbb zzbbVar = this.zzeu;
        if (zzbbVar != null) {
            zzq += zzfjk.zzb(57, zzbbVar);
        }
        Long l39 = this.zzev;
        if (l39 != null) {
            zzq += zzfjk.zzc(58, l39.longValue());
        }
        Long l40 = this.zzew;
        if (l40 != null) {
            zzq += zzfjk.zzc(59, l40.longValue());
        }
        Long l41 = this.zzex;
        if (l41 != null) {
            zzq += zzfjk.zzc(60, l41.longValue());
        }
        Long l42 = this.zzey;
        if (l42 != null) {
            zzq += zzfjk.zzc(61, l42.longValue());
        }
        Long l43 = this.zzez;
        if (l43 != null) {
            zzq += zzfjk.zzc(62, l43.longValue());
        }
        Long l44 = this.zzfa;
        if (l44 != null) {
            zzq += zzfjk.zzc(63, l44.longValue());
        }
        Long l45 = this.zzfb;
        if (l45 != null) {
            zzq += zzfjk.zzc(64, l45.longValue());
        }
        zzbe zzbeVar = this.zzfi;
        return zzbeVar != null ? zzq + zzfjk.zzb(201, zzbeVar) : zzq;
    }
}
