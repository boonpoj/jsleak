package com.google.android.gms.internal;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzbc extends zzfjm<zzbc> {
    private Long zzgg = null;
    private Integer zzgh = null;
    private Boolean zzgi = null;
    private int[] zzgj = zzfjv.zzpnp;
    private Long zzgk = null;

    /* renamed from: com.google.android.gms.internal.zzbc$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zzbc.zzb(zzbc.this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbc$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zzbc.zzc(zzbc.this);
            synchronized (zzbc.zzqC) {
                zzbc.zza(zzbc.this, false);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbc$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zzfx.initialize(zzbc.this.zzqr);
        }
    }

    public zzbc() {
        this.zzpfd = -1;
    }

    @Override // com.google.android.gms.internal.zzfjs
    public final /* synthetic */ zzfjs zza(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int zzcvt = zzfjjVar.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            if (zzcvt == 8) {
                this.zzgg = Long.valueOf(zzfjjVar.zzcwn());
            } else if (zzcvt == 16) {
                this.zzgh = Integer.valueOf(zzfjjVar.zzcwi());
            } else if (zzcvt == 24) {
                this.zzgi = Boolean.valueOf(zzfjjVar.zzcvz());
            } else if (zzcvt == 32) {
                int zzb = zzfjv.zzb(zzfjjVar, 32);
                int[] iArr = this.zzgj;
                int length = iArr == null ? 0 : iArr.length;
                int[] iArr2 = new int[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzgj, 0, iArr2, 0, length);
                }
                while (length < iArr2.length - 1) {
                    iArr2[length] = zzfjjVar.zzcwi();
                    zzfjjVar.zzcvt();
                    length++;
                }
                iArr2[length] = zzfjjVar.zzcwi();
                this.zzgj = iArr2;
            } else if (zzcvt == 34) {
                int zzks = zzfjjVar.zzks(zzfjjVar.zzcwi());
                int position = zzfjjVar.getPosition();
                int i = 0;
                while (zzfjjVar.zzcwk() > 0) {
                    zzfjjVar.zzcwi();
                    i++;
                }
                zzfjjVar.zzmg(position);
                int[] iArr3 = this.zzgj;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int[] iArr4 = new int[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzgj, 0, iArr4, 0, length2);
                }
                while (length2 < iArr4.length) {
                    iArr4[length2] = zzfjjVar.zzcwi();
                    length2++;
                }
                this.zzgj = iArr4;
                zzfjjVar.zzkt(zzks);
            } else if (zzcvt == 40) {
                this.zzgk = Long.valueOf(zzfjjVar.zzcwn());
            } else if (!super.zza(zzfjjVar, zzcvt)) {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final void zza(zzfjk zzfjkVar) throws IOException {
        Long l = this.zzgg;
        if (l != null) {
            zzfjkVar.zzf(1, l.longValue());
        }
        Integer num = this.zzgh;
        if (num != null) {
            zzfjkVar.zzaa(2, num.intValue());
        }
        Boolean bool = this.zzgi;
        if (bool != null) {
            zzfjkVar.zzl(3, bool.booleanValue());
        }
        int[] iArr = this.zzgj;
        if (iArr != null && iArr.length > 0) {
            int i = 0;
            while (true) {
                int[] iArr2 = this.zzgj;
                if (i >= iArr2.length) {
                    break;
                }
                zzfjkVar.zzaa(4, iArr2[i]);
                i++;
            }
        }
        Long l2 = this.zzgk;
        if (l2 != null) {
            zzfjkVar.zza(5, l2.longValue());
        }
        super.zza(zzfjkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    public final int zzq() {
        int[] iArr;
        int zzq = super.zzq();
        Long l = this.zzgg;
        if (l != null) {
            zzq += zzfjk.zzc(1, l.longValue());
        }
        Integer num = this.zzgh;
        if (num != null) {
            zzq += zzfjk.zzad(2, num.intValue());
        }
        Boolean bool = this.zzgi;
        if (bool != null) {
            bool.booleanValue();
            zzq += zzfjk.zzlg(3) + 1;
        }
        int[] iArr2 = this.zzgj;
        if (iArr2 != null && iArr2.length > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                iArr = this.zzgj;
                if (i >= iArr.length) {
                    break;
                }
                i2 += zzfjk.zzlh(iArr[i]);
                i++;
            }
            zzq = zzq + i2 + (iArr.length * 1);
        }
        Long l2 = this.zzgk;
        if (l2 != null) {
            return zzq + zzfjk.zzlg(5) + zzfjk.zzdi(l2.longValue());
        }
        return zzq;
    }
}
