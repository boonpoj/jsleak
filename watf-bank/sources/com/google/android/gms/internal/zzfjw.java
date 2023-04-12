package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfjw extends zzfjm<zzfjw> {
    public Integer zzpnw = null;
    private Integer zzpnx = null;
    public String url = null;
    public String zzpny = null;
    private String zzpnz = null;
    public zzfjx zzpoa = null;
    public zzfke[] zzpob = zzfke.zzdao();
    public String zzpoc = null;
    public zzfkd zzpod = null;
    private Boolean zzpoe = null;
    private String[] zzpof = zzfjv.EMPTY_STRING_ARRAY;
    private String zzpog = null;
    private Boolean zzpoh = null;
    private Boolean zzpoi = null;
    private byte[] zzpoj = null;
    public zzfkf zzpok = null;

    public zzfjw() {
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjs
    /* renamed from: zzao */
    public final zzfjw zza(zzfjj zzfjjVar) throws IOException {
        zzfjs zzfjsVar;
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            switch (zzcvt) {
                case 0:
                    return this;
                case 10:
                    this.url = zzfjjVar.readString();
                    break;
                case 18:
                    this.zzpny = zzfjjVar.readString();
                    break;
                case 26:
                    this.zzpnz = zzfjjVar.readString();
                    break;
                case 34:
                    int zzb = zzfjv.zzb(zzfjjVar, 34);
                    zzfke[] zzfkeVarArr = this.zzpob;
                    int length = zzfkeVarArr == null ? 0 : zzfkeVarArr.length;
                    zzfke[] zzfkeVarArr2 = new zzfke[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzpob, 0, zzfkeVarArr2, 0, length);
                    }
                    while (length < zzfkeVarArr2.length - 1) {
                        zzfkeVarArr2[length] = new zzfke();
                        zzfjjVar.zza(zzfkeVarArr2[length]);
                        zzfjjVar.zzcvt();
                        length++;
                    }
                    zzfkeVarArr2[length] = new zzfke();
                    zzfjjVar.zza(zzfkeVarArr2[length]);
                    this.zzpob = zzfkeVarArr2;
                    break;
                case 40:
                    this.zzpoe = Boolean.valueOf(zzfjjVar.zzcvz());
                    break;
                case 50:
                    int zzb2 = zzfjv.zzb(zzfjjVar, 50);
                    String[] strArr = this.zzpof;
                    int length2 = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[zzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzpof, 0, strArr2, 0, length2);
                    }
                    while (length2 < strArr2.length - 1) {
                        strArr2[length2] = zzfjjVar.readString();
                        zzfjjVar.zzcvt();
                        length2++;
                    }
                    strArr2[length2] = zzfjjVar.readString();
                    this.zzpof = strArr2;
                    break;
                case 58:
                    this.zzpog = zzfjjVar.readString();
                    break;
                case 64:
                    this.zzpoh = Boolean.valueOf(zzfjjVar.zzcvz());
                    break;
                case 72:
                    this.zzpoi = Boolean.valueOf(zzfjjVar.zzcvz());
                    break;
                case 80:
                    int position = zzfjjVar.getPosition();
                    try {
                        int zzcvw = zzfjjVar.zzcvw();
                        switch (zzcvw) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                                this.zzpnw = Integer.valueOf(zzcvw);
                                continue;
                            default:
                                StringBuilder sb = new StringBuilder(42);
                                sb.append(zzcvw);
                                sb.append(" is not a valid enum ReportType");
                                throw new IllegalArgumentException(sb.toString());
                                break;
                        }
                    } catch (IllegalArgumentException e) {
                        zzfjjVar.zzmg(position);
                        zza(zzfjjVar, zzcvt);
                    }
                case 88:
                    int position2 = zzfjjVar.getPosition();
                    try {
                        int zzcvw2 = zzfjjVar.zzcvw();
                        if (zzcvw2 != 0 && zzcvw2 != 1 && zzcvw2 != 2 && zzcvw2 != 3 && zzcvw2 != 4) {
                            StringBuilder sb2 = new StringBuilder(39);
                            sb2.append(zzcvw2);
                            sb2.append(" is not a valid enum Verdict");
                            throw new IllegalArgumentException(sb2.toString());
                            break;
                        }
                        this.zzpnx = Integer.valueOf(zzcvw2);
                    } catch (IllegalArgumentException e2) {
                        zzfjjVar.zzmg(position2);
                        zza(zzfjjVar, zzcvt);
                    }
                    break;
                case 98:
                    if (this.zzpoa == null) {
                        this.zzpoa = new zzfjx();
                    }
                    zzfjsVar = this.zzpoa;
                    zzfjjVar.zza(zzfjsVar);
                    break;
                case 106:
                    this.zzpoc = zzfjjVar.readString();
                    break;
                case 114:
                    if (this.zzpod == null) {
                        this.zzpod = new zzfkd();
                    }
                    zzfjsVar = this.zzpod;
                    zzfjjVar.zza(zzfjsVar);
                    break;
                case 122:
                    this.zzpoj = zzfjjVar.readBytes();
                    break;
                case 138:
                    if (this.zzpok == null) {
                        this.zzpok = new zzfkf();
                    }
                    zzfjsVar = this.zzpok;
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
        String str = this.url;
        if (str != null) {
            zzfjkVar.zzn(1, str);
        }
        String str2 = this.zzpny;
        if (str2 != null) {
            zzfjkVar.zzn(2, str2);
        }
        String str3 = this.zzpnz;
        if (str3 != null) {
            zzfjkVar.zzn(3, str3);
        }
        zzfke[] zzfkeVarArr = this.zzpob;
        int i = 0;
        if (zzfkeVarArr != null && zzfkeVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzfke[] zzfkeVarArr2 = this.zzpob;
                if (i2 >= zzfkeVarArr2.length) {
                    break;
                }
                zzfke zzfkeVar = zzfkeVarArr2[i2];
                if (zzfkeVar != null) {
                    zzfjkVar.zza(4, zzfkeVar);
                }
                i2++;
            }
        }
        Boolean bool = this.zzpoe;
        if (bool != null) {
            zzfjkVar.zzl(5, bool.booleanValue());
        }
        String[] strArr = this.zzpof;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.zzpof;
                if (i >= strArr2.length) {
                    break;
                }
                String str4 = strArr2[i];
                if (str4 != null) {
                    zzfjkVar.zzn(6, str4);
                }
                i++;
            }
        }
        String str5 = this.zzpog;
        if (str5 != null) {
            zzfjkVar.zzn(7, str5);
        }
        Boolean bool2 = this.zzpoh;
        if (bool2 != null) {
            zzfjkVar.zzl(8, bool2.booleanValue());
        }
        Boolean bool3 = this.zzpoi;
        if (bool3 != null) {
            zzfjkVar.zzl(9, bool3.booleanValue());
        }
        Integer num = this.zzpnw;
        if (num != null) {
            zzfjkVar.zzaa(10, num.intValue());
        }
        Integer num2 = this.zzpnx;
        if (num2 != null) {
            zzfjkVar.zzaa(11, num2.intValue());
        }
        zzfjx zzfjxVar = this.zzpoa;
        if (zzfjxVar != null) {
            zzfjkVar.zza(12, zzfjxVar);
        }
        String str6 = this.zzpoc;
        if (str6 != null) {
            zzfjkVar.zzn(13, str6);
        }
        zzfkd zzfkdVar = this.zzpod;
        if (zzfkdVar != null) {
            zzfjkVar.zza(14, zzfkdVar);
        }
        byte[] bArr = this.zzpoj;
        if (bArr != null) {
            zzfjkVar.zzc(15, bArr);
        }
        zzfkf zzfkfVar = this.zzpok;
        if (zzfkfVar != null) {
            zzfjkVar.zza(17, zzfkfVar);
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int zzq = super.zzq();
        String str = this.url;
        if (str != null) {
            zzq += zzfjk.zzo(1, str);
        }
        String str2 = this.zzpny;
        if (str2 != null) {
            zzq += zzfjk.zzo(2, str2);
        }
        String str3 = this.zzpnz;
        if (str3 != null) {
            zzq += zzfjk.zzo(3, str3);
        }
        zzfke[] zzfkeVarArr = this.zzpob;
        int i = 0;
        if (zzfkeVarArr != null && zzfkeVarArr.length > 0) {
            int i2 = zzq;
            int i3 = 0;
            while (true) {
                zzfke[] zzfkeVarArr2 = this.zzpob;
                if (i3 >= zzfkeVarArr2.length) {
                    break;
                }
                zzfke zzfkeVar = zzfkeVarArr2[i3];
                if (zzfkeVar != null) {
                    i2 += zzfjk.zzb(4, zzfkeVar);
                }
                i3++;
            }
            zzq = i2;
        }
        Boolean bool = this.zzpoe;
        if (bool != null) {
            bool.booleanValue();
            zzq += zzfjk.zzlg(5) + 1;
        }
        String[] strArr = this.zzpof;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.zzpof;
                if (i >= strArr2.length) {
                    break;
                }
                String str4 = strArr2[i];
                if (str4 != null) {
                    i5++;
                    i4 += zzfjk.zztt(str4);
                }
                i++;
            }
            zzq = zzq + i4 + (i5 * 1);
        }
        String str5 = this.zzpog;
        if (str5 != null) {
            zzq += zzfjk.zzo(7, str5);
        }
        Boolean bool2 = this.zzpoh;
        if (bool2 != null) {
            bool2.booleanValue();
            zzq += zzfjk.zzlg(8) + 1;
        }
        Boolean bool3 = this.zzpoi;
        if (bool3 != null) {
            bool3.booleanValue();
            zzq += zzfjk.zzlg(9) + 1;
        }
        Integer num = this.zzpnw;
        if (num != null) {
            zzq += zzfjk.zzad(10, num.intValue());
        }
        Integer num2 = this.zzpnx;
        if (num2 != null) {
            zzq += zzfjk.zzad(11, num2.intValue());
        }
        zzfjx zzfjxVar = this.zzpoa;
        if (zzfjxVar != null) {
            zzq += zzfjk.zzb(12, zzfjxVar);
        }
        String str6 = this.zzpoc;
        if (str6 != null) {
            zzq += zzfjk.zzo(13, str6);
        }
        zzfkd zzfkdVar = this.zzpod;
        if (zzfkdVar != null) {
            zzq += zzfjk.zzb(14, zzfkdVar);
        }
        byte[] bArr = this.zzpoj;
        if (bArr != null) {
            zzq += zzfjk.zzd(15, bArr);
        }
        zzfkf zzfkfVar = this.zzpok;
        return zzfkfVar != null ? zzq + zzfjk.zzb(17, zzfkfVar) : zzq;
    }
}
