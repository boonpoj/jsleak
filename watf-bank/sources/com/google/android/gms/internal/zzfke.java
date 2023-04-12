package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfke extends zzfjm<zzfke> {
    private static volatile zzfke[] zzpoz;
    public Integer zzjjw = null;
    public String url = null;
    public zzfjz zzppa = null;
    private zzfkb zzppb = null;
    private Integer zzppc = null;
    private int[] zzppd = zzfjv.zzpnp;
    private String zzppe = null;
    public Integer zzppf = null;
    public String[] zzppg = zzfjv.EMPTY_STRING_ARRAY;

    public zzfke() {
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjs
    /* renamed from: zzaq */
    public final zzfke zza(zzfjj zzfjjVar) throws IOException {
        zzfjs zzfjsVar;
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            switch (zzcvt) {
                case 0:
                    return this;
                case 8:
                    this.zzjjw = Integer.valueOf(zzfjjVar.zzcvw());
                    continue;
                case 18:
                    this.url = zzfjjVar.readString();
                    continue;
                case 26:
                    if (this.zzppa == null) {
                        this.zzppa = new zzfjz();
                    }
                    zzfjsVar = this.zzppa;
                    break;
                case 34:
                    if (this.zzppb == null) {
                        this.zzppb = new zzfkb();
                    }
                    zzfjsVar = this.zzppb;
                    break;
                case 40:
                    this.zzppc = Integer.valueOf(zzfjjVar.zzcvw());
                    continue;
                case 48:
                    int zzb = zzfjv.zzb(zzfjjVar, 48);
                    int[] iArr = this.zzppd;
                    int length = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzppd, 0, iArr2, 0, length);
                    }
                    while (length < iArr2.length - 1) {
                        iArr2[length] = zzfjjVar.zzcvw();
                        zzfjjVar.zzcvt();
                        length++;
                    }
                    iArr2[length] = zzfjjVar.zzcvw();
                    this.zzppd = iArr2;
                    continue;
                case 50:
                    int zzks = zzfjjVar.zzks(zzfjjVar.zzcwi());
                    int position = zzfjjVar.getPosition();
                    int i = 0;
                    while (zzfjjVar.zzcwk() > 0) {
                        zzfjjVar.zzcvw();
                        i++;
                    }
                    zzfjjVar.zzmg(position);
                    int[] iArr3 = this.zzppd;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzppd, 0, iArr4, 0, length2);
                    }
                    while (length2 < iArr4.length) {
                        iArr4[length2] = zzfjjVar.zzcvw();
                        length2++;
                    }
                    this.zzppd = iArr4;
                    zzfjjVar.zzkt(zzks);
                    continue;
                case 58:
                    this.zzppe = zzfjjVar.readString();
                    continue;
                case 64:
                    int position2 = zzfjjVar.getPosition();
                    try {
                        int zzcvw = zzfjjVar.zzcvw();
                        if (zzcvw != 0 && zzcvw != 1 && zzcvw != 2 && zzcvw != 3) {
                            StringBuilder sb = new StringBuilder(46);
                            sb.append(zzcvw);
                            sb.append(" is not a valid enum AdResourceType");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                        }
                        this.zzppf = Integer.valueOf(zzcvw);
                        continue;
                    } catch (IllegalArgumentException e) {
                        zzfjjVar.zzmg(position2);
                        zza(zzfjjVar, zzcvt);
                    }
                    break;
                case 74:
                    int zzb2 = zzfjv.zzb(zzfjjVar, 74);
                    String[] strArr = this.zzppg;
                    int length3 = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[zzb2 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzppg, 0, strArr2, 0, length3);
                    }
                    while (length3 < strArr2.length - 1) {
                        strArr2[length3] = zzfjjVar.readString();
                        zzfjjVar.zzcvt();
                        length3++;
                    }
                    strArr2[length3] = zzfjjVar.readString();
                    this.zzppg = strArr2;
                    continue;
                default:
                    if (super.zza(zzfjjVar, zzcvt)) {
                        continue;
                    } else {
                        return this;
                    }
            }
            zzfjjVar.zza(zzfjsVar);
        }
    }

    public static zzfke[] zzdao() {
        if (zzpoz == null) {
            synchronized (zzfjq.zzpnk) {
                if (zzpoz == null) {
                    zzpoz = new zzfke[0];
                }
            }
        }
        return zzpoz;
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        zzfjkVar.zzaa(1, this.zzjjw.intValue());
        String str = this.url;
        if (str != null) {
            zzfjkVar.zzn(2, str);
        }
        zzfjz zzfjzVar = this.zzppa;
        if (zzfjzVar != null) {
            zzfjkVar.zza(3, zzfjzVar);
        }
        zzfkb zzfkbVar = this.zzppb;
        if (zzfkbVar != null) {
            zzfjkVar.zza(4, zzfkbVar);
        }
        Integer num = this.zzppc;
        if (num != null) {
            zzfjkVar.zzaa(5, num.intValue());
        }
        int[] iArr = this.zzppd;
        int i = 0;
        if (iArr != null && iArr.length > 0) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.zzppd;
                if (i2 >= iArr2.length) {
                    break;
                }
                zzfjkVar.zzaa(6, iArr2[i2]);
                i2++;
            }
        }
        String str2 = this.zzppe;
        if (str2 != null) {
            zzfjkVar.zzn(7, str2);
        }
        Integer num2 = this.zzppf;
        if (num2 != null) {
            zzfjkVar.zzaa(8, num2.intValue());
        }
        String[] strArr = this.zzppg;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.zzppg;
                if (i >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i];
                if (str3 != null) {
                    zzfjkVar.zzn(9, str3);
                }
                i++;
            }
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int[] iArr;
        int zzq = super.zzq() + zzfjk.zzad(1, this.zzjjw.intValue());
        String str = this.url;
        if (str != null) {
            zzq += zzfjk.zzo(2, str);
        }
        zzfjz zzfjzVar = this.zzppa;
        if (zzfjzVar != null) {
            zzq += zzfjk.zzb(3, zzfjzVar);
        }
        zzfkb zzfkbVar = this.zzppb;
        if (zzfkbVar != null) {
            zzq += zzfjk.zzb(4, zzfkbVar);
        }
        Integer num = this.zzppc;
        if (num != null) {
            zzq += zzfjk.zzad(5, num.intValue());
        }
        int[] iArr2 = this.zzppd;
        int i = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                iArr = this.zzppd;
                if (i2 >= iArr.length) {
                    break;
                }
                i3 += zzfjk.zzlh(iArr[i2]);
                i2++;
            }
            zzq = zzq + i3 + (iArr.length * 1);
        }
        String str2 = this.zzppe;
        if (str2 != null) {
            zzq += zzfjk.zzo(7, str2);
        }
        Integer num2 = this.zzppf;
        if (num2 != null) {
            zzq += zzfjk.zzad(8, num2.intValue());
        }
        String[] strArr = this.zzppg;
        if (strArr == null || strArr.length <= 0) {
            return zzq;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.zzppg;
            if (i >= strArr2.length) {
                return zzq + i4 + (i5 * 1);
            }
            String str3 = strArr2[i];
            if (str3 != null) {
                i5++;
                i4 += zzfjk.zztt(str3);
            }
            i++;
        }
    }
}
