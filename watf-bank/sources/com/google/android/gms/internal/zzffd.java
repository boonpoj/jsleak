package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzffd extends zzffb {
    private final byte[] buffer;
    private final boolean immutable;
    private int limit;
    private int pos;
    private int zzpfr;
    private int zzpfs;
    private int zzpft;
    private int zzpfu;

    private zzffd(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzpfu = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzpfs = this.pos;
        this.immutable = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b0, code lost:
        if (r2[r0] >= 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzcwn() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffd.zzcwn():long");
    }

    private final int zzcwo() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzfge.zzcya();
    }

    private final long zzcwp() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }
        throw zzfge.zzcya();
    }

    private final void zzcwq() {
        this.limit += this.zzpfr;
        int i = this.limit;
        int i2 = i - this.zzpfs;
        int i3 = this.zzpfu;
        if (i2 <= i3) {
            this.zzpfr = 0;
            return;
        }
        this.zzpfr = i2 - i3;
        this.limit = i - this.zzpfr;
    }

    private final byte zzcwr() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzfge.zzcya();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzcwp());
    }

    @Override // com.google.android.gms.internal.zzffb
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzcwo());
    }

    @Override // com.google.android.gms.internal.zzffb
    public final String readString() throws IOException {
        int zzcwi = zzcwi();
        if (zzcwi > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzcwi <= i - i2) {
                String str = new String(this.buffer, i2, zzcwi, zzffz.UTF_8);
                this.pos += zzcwi;
                return str;
            }
        }
        if (zzcwi == 0) {
            return "";
        }
        if (zzcwi < 0) {
            throw zzfge.zzcyb();
        }
        throw zzfge.zzcya();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final <T extends zzffu<T, ?>> T zza(T t, zzffm zzffmVar) throws IOException {
        int zzcwi = zzcwi();
        if (this.zzpfm < this.zzpfn) {
            int zzks = zzks(zzcwi);
            this.zzpfm++;
            T t2 = (T) zzffu.zza(t, this, zzffmVar);
            zzkp(0);
            this.zzpfm--;
            zzkt(zzks);
            return t2;
        }
        throw zzfge.zzcyg();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final void zza(zzfhf zzfhfVar, zzffm zzffmVar) throws IOException {
        int zzcwi = zzcwi();
        if (this.zzpfm >= this.zzpfn) {
            throw zzfge.zzcyg();
        }
        int zzks = zzks(zzcwi);
        this.zzpfm++;
        zzfhfVar.zzb(this, zzffmVar);
        zzkp(0);
        this.zzpfm--;
        zzkt(zzks);
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzcvt() throws IOException {
        if (zzcwl()) {
            this.zzpft = 0;
            return 0;
        }
        this.zzpft = zzcwi();
        int i = this.zzpft;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzfge.zzcyd();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final long zzcvu() throws IOException {
        return zzcwn();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final long zzcvv() throws IOException {
        return zzcwn();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzcvw() throws IOException {
        return zzcwi();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final long zzcvx() throws IOException {
        return zzcwp();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzcvy() throws IOException {
        return zzcwo();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final boolean zzcvz() throws IOException {
        return zzcwn() != 0;
    }

    @Override // com.google.android.gms.internal.zzffb
    public final String zzcwa() throws IOException {
        int zzcwi = zzcwi();
        if (zzcwi > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzcwi <= i - i2) {
                if (zzfis.zzk(this.buffer, i2, i2 + zzcwi)) {
                    int i3 = this.pos;
                    this.pos = i3 + zzcwi;
                    return new String(this.buffer, i3, zzcwi, zzffz.UTF_8);
                }
                throw zzfge.zzcyi();
            }
        }
        if (zzcwi == 0) {
            return "";
        }
        if (zzcwi <= 0) {
            throw zzfge.zzcyb();
        }
        throw zzfge.zzcya();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final zzfes zzcwb() throws IOException {
        byte[] bArr;
        int zzcwi = zzcwi();
        if (zzcwi > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzcwi <= i - i2) {
                zzfes zze = zzfes.zze(this.buffer, i2, zzcwi);
                this.pos += zzcwi;
                return zze;
            }
        }
        if (zzcwi == 0) {
            return zzfes.zzpfg;
        }
        if (zzcwi > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzcwi <= i3 - i4) {
                this.pos = zzcwi + i4;
                bArr = Arrays.copyOfRange(this.buffer, i4, this.pos);
                return zzfes.zzba(bArr);
            }
        }
        if (zzcwi <= 0) {
            if (zzcwi == 0) {
                bArr = zzffz.EMPTY_BYTE_ARRAY;
                return zzfes.zzba(bArr);
            }
            throw zzfge.zzcyb();
        }
        throw zzfge.zzcya();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzcwc() throws IOException {
        return zzcwi();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzcwd() throws IOException {
        return zzcwi();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzcwe() throws IOException {
        return zzcwo();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final long zzcwf() throws IOException {
        return zzcwp();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzcwg() throws IOException {
        return zzkv(zzcwi());
    }

    @Override // com.google.android.gms.internal.zzffb
    public final long zzcwh() throws IOException {
        return zzcs(zzcwn());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r2[r3] >= 0) goto L13;
     */
    @Override // com.google.android.gms.internal.zzffb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzcwi() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L6b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.pos = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6b
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L68
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2d:
            r1 = r3
            goto L68
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L68
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6b
        L68:
            r5.pos = r1
            return r0
        L6b:
            long r0 = r5.zzcwj()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffd.zzcwi():int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.zzffb
    public final long zzcwj() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcwr = zzcwr();
            j |= (zzcwr & Byte.MAX_VALUE) << i;
            if ((zzcwr & 128) == 0) {
                return j;
            }
        }
        throw zzfge.zzcyc();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzcwk() {
        int i = this.zzpfu;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - zzcwm();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final boolean zzcwl() throws IOException {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzcwm() {
        return this.pos - this.zzpfs;
    }

    @Override // com.google.android.gms.internal.zzffb
    public final void zzkp(int i) throws zzfge {
        if (this.zzpft != i) {
            throw zzfge.zzcye();
        }
    }

    @Override // com.google.android.gms.internal.zzffb
    public final boolean zzkq(int i) throws IOException {
        int zzcvt;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.limit - this.pos < 10) {
                while (i3 < 10) {
                    if (zzcwr() < 0) {
                        i3++;
                    }
                }
                throw zzfge.zzcyc();
            }
            while (i3 < 10) {
                byte[] bArr = this.buffer;
                int i4 = this.pos;
                this.pos = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw zzfge.zzcyc();
            return true;
        } else if (i2 == 1) {
            zzku(8);
            return true;
        } else if (i2 == 2) {
            zzku(zzcwi());
            return true;
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 5) {
                    zzku(4);
                    return true;
                }
                throw zzfge.zzcyf();
            }
            return false;
        } else {
            do {
                zzcvt = zzcvt();
                if (zzcvt == 0) {
                    break;
                }
            } while (zzkq(zzcvt));
            zzkp(((i >>> 3) << 3) | 4);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzks(int i) throws zzfge {
        if (i >= 0) {
            int zzcwm = i + zzcwm();
            int i2 = this.zzpfu;
            if (zzcwm <= i2) {
                this.zzpfu = zzcwm;
                zzcwq();
                return i2;
            }
            throw zzfge.zzcya();
        }
        throw zzfge.zzcyb();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final void zzkt(int i) {
        this.zzpfu = i;
        zzcwq();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final void zzku(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw zzfge.zzcya();
        }
        throw zzfge.zzcyb();
    }
}
