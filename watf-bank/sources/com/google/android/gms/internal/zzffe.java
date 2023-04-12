package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzffe extends zzffb {
    private final byte[] buffer;
    private int pos;
    private int zzpfr;
    private int zzpft;
    private int zzpfu;
    private final InputStream zzpfv;
    private int zzpfw;
    private int zzpfx;
    private zzfff zzpfy;

    private zzffe(InputStream inputStream, int i) {
        super();
        this.zzpfu = Integer.MAX_VALUE;
        this.zzpfy = null;
        zzffz.zzc(inputStream, "input");
        this.zzpfv = inputStream;
        this.buffer = new byte[i];
        this.zzpfw = 0;
        this.pos = 0;
        this.zzpfx = 0;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffe.zzcwn():long");
    }

    private final int zzcwo() throws IOException {
        int i = this.pos;
        if (this.zzpfw - i < 4) {
            zzkw(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzcwp() throws IOException {
        int i = this.pos;
        if (this.zzpfw - i < 8) {
            zzkw(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private final void zzcwq() {
        this.zzpfw += this.zzpfr;
        int i = this.zzpfx;
        int i2 = this.zzpfw;
        int i3 = i + i2;
        int i4 = this.zzpfu;
        if (i3 <= i4) {
            this.zzpfr = 0;
            return;
        }
        this.zzpfr = i3 - i4;
        this.zzpfw = i2 - this.zzpfr;
    }

    private final byte zzcwr() throws IOException {
        if (this.pos == this.zzpfw) {
            zzkw(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzkw(int i) throws IOException {
        if (zzkx(i)) {
            return;
        }
        if (i <= (this.zzpfo - this.zzpfx) - this.pos) {
            throw zzfge.zzcya();
        }
        throw zzfge.zzcyh();
    }

    private final boolean zzkx(int i) throws IOException {
        while (this.pos + i > this.zzpfw) {
            int i2 = this.zzpfo;
            int i3 = this.zzpfx;
            int i4 = this.pos;
            if (i > (i2 - i3) - i4 || i3 + i4 + i > this.zzpfu) {
                return false;
            }
            if (i4 > 0) {
                int i5 = this.zzpfw;
                if (i5 > i4) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                }
                this.zzpfx += i4;
                this.zzpfw -= i4;
                this.pos = 0;
            }
            InputStream inputStream = this.zzpfv;
            byte[] bArr2 = this.buffer;
            int i6 = this.zzpfw;
            int read = inputStream.read(bArr2, i6, Math.min(bArr2.length - i6, (this.zzpfo - this.zzpfx) - this.zzpfw));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                StringBuilder sb = new StringBuilder(102);
                sb.append("InputStream#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            } else if (read <= 0) {
                return false;
            } else {
                this.zzpfw += read;
                zzcwq();
                if (this.zzpfw >= i) {
                    return true;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    private final byte[] zzky(int i) throws IOException {
        byte[] zzkz = zzkz(i);
        if (zzkz != null) {
            return zzkz;
        }
        int i2 = this.pos;
        int i3 = this.zzpfw;
        int i4 = i3 - i2;
        this.zzpfx += i3;
        this.pos = 0;
        this.zzpfw = 0;
        List<byte[]> zzla = zzla(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzla) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
    }

    private final byte[] zzkz(int i) throws IOException {
        if (i == 0) {
            return zzffz.EMPTY_BYTE_ARRAY;
        }
        if (i >= 0) {
            int i2 = this.zzpfx + this.pos + i;
            if (i2 - this.zzpfo <= 0) {
                int i3 = this.zzpfu;
                if (i2 > i3) {
                    zzku((i3 - this.zzpfx) - this.pos);
                    throw zzfge.zzcya();
                }
                int i4 = this.zzpfw - this.pos;
                int i5 = i - i4;
                if (i5 < 4096 || i5 <= this.zzpfv.available()) {
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.buffer, this.pos, bArr, 0, i4);
                    this.zzpfx += this.zzpfw;
                    this.pos = 0;
                    this.zzpfw = 0;
                    while (i4 < bArr.length) {
                        int read = this.zzpfv.read(bArr, i4, i - i4);
                        if (read == -1) {
                            throw zzfge.zzcya();
                        }
                        this.zzpfx += read;
                        i4 += read;
                    }
                    return bArr;
                }
                return null;
            }
            throw zzfge.zzcyh();
        }
        throw zzfge.zzcyb();
    }

    private final List<byte[]> zzla(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.zzpfv.read(bArr, i2, bArr.length - i2);
                if (read == -1) {
                    throw zzfge.zzcya();
                }
                this.zzpfx += read;
                i2 += read;
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
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
            int i = this.zzpfw;
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
        if (zzcwi <= this.zzpfw) {
            zzkw(zzcwi);
            String str2 = new String(this.buffer, this.pos, zzcwi, zzffz.UTF_8);
            this.pos += zzcwi;
            return str2;
        }
        return new String(zzky(zzcwi), zzffz.UTF_8);
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
        byte[] zzky;
        int zzcwi = zzcwi();
        int i = this.pos;
        int i2 = 0;
        if (zzcwi <= this.zzpfw - i && zzcwi > 0) {
            zzky = this.buffer;
            this.pos = i + zzcwi;
            i2 = i;
        } else if (zzcwi == 0) {
            return "";
        } else {
            if (zzcwi <= this.zzpfw) {
                zzkw(zzcwi);
                zzky = this.buffer;
                this.pos = zzcwi;
            } else {
                zzky = zzky(zzcwi);
            }
        }
        if (zzfis.zzk(zzky, i2, i2 + zzcwi)) {
            return new String(zzky, i2, zzcwi, zzffz.UTF_8);
        }
        throw zzfge.zzcyi();
    }

    @Override // com.google.android.gms.internal.zzffb
    public final zzfes zzcwb() throws IOException {
        int zzcwi = zzcwi();
        int i = this.zzpfw;
        int i2 = this.pos;
        if (zzcwi <= i - i2 && zzcwi > 0) {
            zzfes zze = zzfes.zze(this.buffer, i2, zzcwi);
            this.pos += zzcwi;
            return zze;
        } else if (zzcwi == 0) {
            return zzfes.zzpfg;
        } else {
            byte[] zzkz = zzkz(zzcwi);
            if (zzkz != null) {
                return zzfes.zzba(zzkz);
            }
            int i3 = this.pos;
            int i4 = this.zzpfw;
            int i5 = i4 - i3;
            this.zzpfx += i4;
            this.pos = 0;
            this.zzpfw = 0;
            List<byte[]> zzla = zzla(zzcwi - i5);
            ArrayList arrayList = new ArrayList(zzla.size() + 1);
            arrayList.add(zzfes.zze(this.buffer, i3, i5));
            for (byte[] bArr : zzla) {
                arrayList.add(zzfes.zzba(bArr));
            }
            return zzfes.zzf(arrayList);
        }
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
            int r1 = r5.zzpfw
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffe.zzcwi():int");
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
        return i - (this.zzpfx + this.pos);
    }

    @Override // com.google.android.gms.internal.zzffb
    public final boolean zzcwl() throws IOException {
        return this.pos == this.zzpfw && !zzkx(1);
    }

    @Override // com.google.android.gms.internal.zzffb
    public final int zzcwm() {
        return this.zzpfx + this.pos;
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
            if (this.zzpfw - this.pos < 10) {
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
            int i2 = i + this.zzpfx + this.pos;
            int i3 = this.zzpfu;
            if (i2 <= i3) {
                this.zzpfu = i2;
                zzcwq();
                return i3;
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
        int i2 = this.zzpfw;
        int i3 = this.pos;
        if (i <= i2 - i3 && i >= 0) {
            this.pos = i3 + i;
        } else if (i < 0) {
            throw zzfge.zzcyb();
        } else {
            int i4 = this.zzpfx;
            int i5 = this.pos;
            int i6 = i4 + i5 + i;
            int i7 = this.zzpfu;
            if (i6 > i7) {
                zzku((i7 - i4) - i5);
                throw zzfge.zzcya();
            }
            int i8 = this.zzpfw;
            int i9 = i8 - i5;
            this.pos = i8;
            while (true) {
                zzkw(1);
                int i10 = i - i9;
                int i11 = this.zzpfw;
                if (i10 <= i11) {
                    this.pos = i10;
                    return;
                } else {
                    i9 += i11;
                    this.pos = i11;
                }
            }
        }
    }
}
