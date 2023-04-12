package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzfjj {
    private final byte[] buffer;
    private int zzpfm;
    private int zzpfr;
    private int zzpft;
    private final int zzpfw;
    private final int zzpmz;
    private int zzpna;
    private int zzpnb;
    private int zzpfu = Integer.MAX_VALUE;
    private int zzpfn = 64;
    private int zzpfo = 67108864;

    private zzfjj(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzpmz = i;
        int i3 = i2 + i;
        this.zzpna = i3;
        this.zzpfw = i3;
        this.zzpnb = i;
    }

    public static zzfjj zzbe(byte[] bArr) {
        return zzn(bArr, 0, bArr.length);
    }

    private final void zzcwq() {
        this.zzpna += this.zzpfr;
        int i = this.zzpna;
        int i2 = this.zzpfu;
        if (i <= i2) {
            this.zzpfr = 0;
            return;
        }
        this.zzpfr = i - i2;
        this.zzpna = i - this.zzpfr;
    }

    private final byte zzcwr() throws IOException {
        int i = this.zzpnb;
        if (i != this.zzpna) {
            byte[] bArr = this.buffer;
            this.zzpnb = i + 1;
            return bArr[i];
        }
        throw zzfjr.zzdai();
    }

    private final void zzku(int i) throws IOException {
        if (i < 0) {
            throw zzfjr.zzdaj();
        }
        int i2 = this.zzpnb;
        int i3 = i2 + i;
        int i4 = this.zzpfu;
        if (i3 > i4) {
            zzku(i4 - i2);
            throw zzfjr.zzdai();
        } else if (i > this.zzpna - i2) {
            throw zzfjr.zzdai();
        } else {
            this.zzpnb = i2 + i;
        }
    }

    public static zzfjj zzn(byte[] bArr, int i, int i2) {
        return new zzfjj(bArr, 0, i2);
    }

    public final int getPosition() {
        return this.zzpnb - this.zzpmz;
    }

    public final byte[] readBytes() throws IOException {
        int zzcwi = zzcwi();
        if (zzcwi >= 0) {
            if (zzcwi == 0) {
                return zzfjv.zzpnv;
            }
            int i = this.zzpna;
            int i2 = this.zzpnb;
            if (zzcwi <= i - i2) {
                byte[] bArr = new byte[zzcwi];
                System.arraycopy(this.buffer, i2, bArr, 0, zzcwi);
                this.zzpnb += zzcwi;
                return bArr;
            }
            throw zzfjr.zzdai();
        }
        throw zzfjr.zzdaj();
    }

    public final String readString() throws IOException {
        int zzcwi = zzcwi();
        if (zzcwi >= 0) {
            int i = this.zzpna;
            int i2 = this.zzpnb;
            if (zzcwi <= i - i2) {
                String str = new String(this.buffer, i2, zzcwi, zzfjq.UTF_8);
                this.zzpnb += zzcwi;
                return str;
            }
            throw zzfjr.zzdai();
        }
        throw zzfjr.zzdaj();
    }

    public final void zza(zzfjs zzfjsVar) throws IOException {
        int zzcwi = zzcwi();
        if (this.zzpfm >= this.zzpfn) {
            throw zzfjr.zzdal();
        }
        int zzks = zzks(zzcwi);
        this.zzpfm++;
        zzfjsVar.zza(this);
        zzkp(0);
        this.zzpfm--;
        zzkt(zzks);
    }

    public final void zza(zzfjs zzfjsVar, int i) throws IOException {
        int i2 = this.zzpfm;
        if (i2 >= this.zzpfn) {
            throw zzfjr.zzdal();
        }
        this.zzpfm = i2 + 1;
        zzfjsVar.zza(this);
        zzkp((i << 3) | 4);
        this.zzpfm--;
    }

    public final byte[] zzal(int i, int i2) {
        if (i2 == 0) {
            return zzfjv.zzpnv;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzpmz + i, bArr, 0, i2);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzam(int i, int i2) {
        int i3 = this.zzpnb;
        int i4 = this.zzpmz;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= 0) {
            this.zzpnb = i4 + i;
            this.zzpft = i2;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final int zzcvt() throws IOException {
        if (this.zzpnb == this.zzpna) {
            this.zzpft = 0;
            return 0;
        }
        this.zzpft = zzcwi();
        int i = this.zzpft;
        if (i != 0) {
            return i;
        }
        throw new zzfjr("Protocol message contained an invalid tag (zero).");
    }

    public final long zzcvv() throws IOException {
        return zzcwn();
    }

    public final int zzcvw() throws IOException {
        return zzcwi();
    }

    public final boolean zzcvz() throws IOException {
        return zzcwi() != 0;
    }

    public final long zzcwh() throws IOException {
        long zzcwn = zzcwn();
        return (-(zzcwn & 1)) ^ (zzcwn >>> 1);
    }

    public final int zzcwi() throws IOException {
        int i;
        byte zzcwr = zzcwr();
        if (zzcwr >= 0) {
            return zzcwr;
        }
        int i2 = zzcwr & Byte.MAX_VALUE;
        byte zzcwr2 = zzcwr();
        if (zzcwr2 >= 0) {
            i = zzcwr2 << 7;
        } else {
            i2 |= (zzcwr2 & Byte.MAX_VALUE) << 7;
            byte zzcwr3 = zzcwr();
            if (zzcwr3 >= 0) {
                i = zzcwr3 << 14;
            } else {
                i2 |= (zzcwr3 & Byte.MAX_VALUE) << 14;
                byte zzcwr4 = zzcwr();
                if (zzcwr4 < 0) {
                    int i3 = i2 | ((zzcwr4 & Byte.MAX_VALUE) << 21);
                    byte zzcwr5 = zzcwr();
                    int i4 = i3 | (zzcwr5 << 28);
                    if (zzcwr5 < 0) {
                        for (int i5 = 0; i5 < 5; i5++) {
                            if (zzcwr() >= 0) {
                                return i4;
                            }
                        }
                        throw zzfjr.zzdak();
                    }
                    return i4;
                }
                i = zzcwr4 << 21;
            }
        }
        return i2 | i;
    }

    public final int zzcwk() {
        int i = this.zzpfu;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzpnb;
    }

    public final long zzcwn() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcwr = zzcwr();
            j |= (zzcwr & Byte.MAX_VALUE) << i;
            if ((zzcwr & 128) == 0) {
                return j;
            }
        }
        throw zzfjr.zzdak();
    }

    public final int zzcwo() throws IOException {
        return (zzcwr() & 255) | ((zzcwr() & 255) << 8) | ((zzcwr() & 255) << 16) | ((zzcwr() & 255) << 24);
    }

    public final long zzcwp() throws IOException {
        byte zzcwr = zzcwr();
        byte zzcwr2 = zzcwr();
        return ((zzcwr2 & 255) << 8) | (zzcwr & 255) | ((zzcwr() & 255) << 16) | ((zzcwr() & 255) << 24) | ((zzcwr() & 255) << 32) | ((zzcwr() & 255) << 40) | ((zzcwr() & 255) << 48) | ((zzcwr() & 255) << 56);
    }

    public final void zzkp(int i) throws zzfjr {
        if (this.zzpft != i) {
            throw new zzfjr("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzkq(int i) throws IOException {
        int zzcvt;
        int i2 = i & 7;
        if (i2 == 0) {
            zzcwi();
            return true;
        } else if (i2 == 1) {
            zzcwp();
            return true;
        } else if (i2 == 2) {
            zzku(zzcwi());
            return true;
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 5) {
                    zzcwo();
                    return true;
                }
                throw new zzfjr("Protocol message tag had invalid wire type.");
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

    public final int zzks(int i) throws zzfjr {
        if (i >= 0) {
            int i2 = i + this.zzpnb;
            int i3 = this.zzpfu;
            if (i2 <= i3) {
                this.zzpfu = i2;
                zzcwq();
                return i3;
            }
            throw zzfjr.zzdai();
        }
        throw zzfjr.zzdaj();
    }

    public final void zzkt(int i) {
        this.zzpfu = i;
        zzcwq();
    }

    public final void zzmg(int i) {
        zzam(i, this.zzpft);
    }
}
