package com.google.android.gms.internal;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzjc extends zzfjm<zzjc> {
    public String zzbcw = null;
    public long[] zzbcx = zzfjv.zzpnq;
    public zzjb zzbcy = null;
    public zzja zzbcz = null;

    public zzjc() {
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    @Override // com.google.android.gms.internal.zzfjs
    public final /* synthetic */ zzfjs zza(zzfjj zzfjjVar) throws IOException {
        zzfjs zzfjsVar;
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            if (zzcvt == 82) {
                this.zzbcw = zzfjjVar.readString();
            } else if (zzcvt == 112) {
                int zzb = zzfjv.zzb(zzfjjVar, 112);
                long[] jArr = this.zzbcx;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzbcx, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = zzfjjVar.zzcwn();
                    zzfjjVar.zzcvt();
                    length++;
                }
                jArr2[length] = zzfjjVar.zzcwn();
                this.zzbcx = jArr2;
            } else if (zzcvt != 114) {
                if (zzcvt == 122) {
                    if (this.zzbcy == null) {
                        this.zzbcy = new zzjb();
                    }
                    zzfjsVar = this.zzbcy;
                } else if (zzcvt == 146) {
                    if (this.zzbcz == null) {
                        this.zzbcz = new zzja();
                    }
                    zzfjsVar = this.zzbcz;
                } else if (!super.zza(zzfjjVar, zzcvt)) {
                    return this;
                }
                zzfjjVar.zza(zzfjsVar);
            } else {
                int zzks = zzfjjVar.zzks(zzfjjVar.zzcwi());
                int position = zzfjjVar.getPosition();
                int i = 0;
                while (zzfjjVar.zzcwk() > 0) {
                    zzfjjVar.zzcwn();
                    i++;
                }
                zzfjjVar.zzmg(position);
                long[] jArr3 = this.zzbcx;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzbcx, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = zzfjjVar.zzcwn();
                    length2++;
                }
                this.zzbcx = jArr4;
                zzfjjVar.zzkt(zzks);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        String str = this.zzbcw;
        if (str != null) {
            zzfjkVar.zzn(10, str);
        }
        long[] jArr = this.zzbcx;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.zzbcx;
                if (i >= jArr2.length) {
                    break;
                }
                zzfjkVar.zza(14, jArr2[i]);
                i++;
            }
        }
        zzjb zzjbVar = this.zzbcy;
        if (zzjbVar != null) {
            zzfjkVar.zza(15, zzjbVar);
        }
        zzja zzjaVar = this.zzbcz;
        if (zzjaVar != null) {
            zzfjkVar.zza(18, zzjaVar);
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        long[] jArr;
        int zzq = super.zzq();
        String str = this.zzbcw;
        if (str != null) {
            zzq += zzfjk.zzo(10, str);
        }
        long[] jArr2 = this.zzbcx;
        if (jArr2 != null && jArr2.length > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                jArr = this.zzbcx;
                if (i >= jArr.length) {
                    break;
                }
                i2 += zzfjk.zzdi(jArr[i]);
                i++;
            }
            zzq = zzq + i2 + (jArr.length * 1);
        }
        zzjb zzjbVar = this.zzbcy;
        if (zzjbVar != null) {
            zzq += zzfjk.zzb(15, zzjbVar);
        }
        zzja zzjaVar = this.zzbcz;
        return zzjaVar != null ? zzq + zzfjk.zzb(18, zzjaVar) : zzq;
    }
}
