package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: assets/classes2.dex */
public final class zzbul {
    private final byte[] buffer;
    private int zzcrN;
    private int zzcrO;
    private int zzcrP;
    private int zzcrQ;
    private int zzcrR;
    private int zzcrT;
    private int zzcrS = Integer.MAX_VALUE;
    private int zzcrU = 64;
    private int zzcrV = 67108864;

    private zzbul(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzcrN = i;
        this.zzcrO = i2 + i;
        this.zzcrQ = i;
    }

    public static long zzaV(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    private void zzacH() {
        this.zzcrO += this.zzcrP;
        int i = this.zzcrO;
        if (i <= this.zzcrS) {
            this.zzcrP = 0;
            return;
        }
        this.zzcrP = i - this.zzcrS;
        this.zzcrO -= this.zzcrP;
    }

    public static zzbul zzad(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static zzbul zzb(byte[] bArr, int i, int i2) {
        return new zzbul(bArr, i, i2);
    }

    public static int zzqi(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public int getPosition() {
        return this.zzcrQ - this.zzcrN;
    }

    public byte[] readBytes() throws IOException {
        int zzacD = zzacD();
        if (zzacD >= 0) {
            if (zzacD == 0) {
                return zzbuw.zzcsp;
            }
            if (zzacD <= this.zzcrO - this.zzcrQ) {
                byte[] bArr = new byte[zzacD];
                System.arraycopy(this.buffer, this.zzcrQ, bArr, 0, zzacD);
                this.zzcrQ += zzacD;
                return bArr;
            }
            throw zzbus.zzacR();
        }
        throw zzbus.zzacS();
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzacG());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzacF());
    }

    public String readString() throws IOException {
        int zzacD = zzacD();
        if (zzacD >= 0) {
            if (zzacD <= this.zzcrO - this.zzcrQ) {
                String str = new String(this.buffer, this.zzcrQ, zzacD, zzbur.UTF_8);
                this.zzcrQ += zzacD;
                return str;
            }
            throw zzbus.zzacR();
        }
        throw zzbus.zzacS();
    }

    public byte[] zzE(int i, int i2) {
        if (i2 == 0) {
            return zzbuw.zzcsp;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzcrN + i, bArr, 0, i2);
        return bArr;
    }

    public void zza(zzbut zzbutVar) throws IOException {
        int zzacD = zzacD();
        if (this.zzcrT >= this.zzcrU) {
            throw zzbus.zzacX();
        }
        int zzqj = zzqj(zzacD);
        this.zzcrT++;
        zzbutVar.zzb(this);
        zzqg(0);
        this.zzcrT--;
        zzqk(zzqj);
    }

    public void zza(zzbut zzbutVar, int i) throws IOException {
        if (this.zzcrT >= this.zzcrU) {
            throw zzbus.zzacX();
        }
        this.zzcrT++;
        zzbutVar.zzb(this);
        zzqg(zzbuw.zzK(i, 4));
        this.zzcrT--;
    }

    public boolean zzacA() throws IOException {
        return zzacD() != 0;
    }

    public int zzacB() throws IOException {
        return zzqi(zzacD());
    }

    public long zzacC() throws IOException {
        return zzaV(zzacE());
    }

    public int zzacD() throws IOException {
        int i;
        byte zzacK = zzacK();
        if (zzacK >= 0) {
            return zzacK;
        }
        int i2 = zzacK & Byte.MAX_VALUE;
        byte zzacK2 = zzacK();
        if (zzacK2 >= 0) {
            i = zzacK2 << 7;
        } else {
            i2 |= (zzacK2 & Byte.MAX_VALUE) << 7;
            byte zzacK3 = zzacK();
            if (zzacK3 >= 0) {
                i = zzacK3 << 14;
            } else {
                i2 |= (zzacK3 & Byte.MAX_VALUE) << 14;
                byte zzacK4 = zzacK();
                if (zzacK4 < 0) {
                    int i3 = i2 | ((zzacK4 & Byte.MAX_VALUE) << 21);
                    byte zzacK5 = zzacK();
                    int i4 = i3 | (zzacK5 << 28);
                    if (zzacK5 < 0) {
                        for (int i5 = 0; i5 < 5; i5++) {
                            if (zzacK() >= 0) {
                                return i4;
                            }
                        }
                        throw zzbus.zzacT();
                    }
                    return i4;
                }
                i = zzacK4 << 21;
            }
        }
        return i2 | i;
    }

    public long zzacE() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzacK = zzacK();
            j |= (zzacK & Byte.MAX_VALUE) << i;
            if ((zzacK & 128) == 0) {
                return j;
            }
        }
        throw zzbus.zzacT();
    }

    public int zzacF() throws IOException {
        return (zzacK() & 255) | ((zzacK() & 255) << 8) | ((zzacK() & 255) << 16) | ((zzacK() & 255) << 24);
    }

    public long zzacG() throws IOException {
        byte zzacK = zzacK();
        byte zzacK2 = zzacK();
        return ((zzacK2 & 255) << 8) | (zzacK & 255) | ((zzacK() & 255) << 16) | ((zzacK() & 255) << 24) | ((zzacK() & 255) << 32) | ((zzacK() & 255) << 40) | ((zzacK() & 255) << 48) | ((zzacK() & 255) << 56);
    }

    public int zzacI() {
        if (this.zzcrS == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzcrS - this.zzcrQ;
    }

    public boolean zzacJ() {
        return this.zzcrQ == this.zzcrO;
    }

    public byte zzacK() throws IOException {
        if (this.zzcrQ != this.zzcrO) {
            byte[] bArr = this.buffer;
            int i = this.zzcrQ;
            this.zzcrQ = i + 1;
            return bArr[i];
        }
        throw zzbus.zzacR();
    }

    public int zzacu() throws IOException {
        if (zzacJ()) {
            this.zzcrR = 0;
            return 0;
        }
        this.zzcrR = zzacD();
        if (this.zzcrR != 0) {
            return this.zzcrR;
        }
        throw zzbus.zzacU();
    }

    public void zzacv() throws IOException {
        int zzacu;
        do {
            zzacu = zzacu();
            if (zzacu == 0) {
                return;
            }
        } while (zzqh(zzacu));
    }

    public long zzacw() throws IOException {
        return zzacE();
    }

    public long zzacx() throws IOException {
        return zzacE();
    }

    public int zzacy() throws IOException {
        return zzacD();
    }

    public long zzacz() throws IOException {
        return zzacG();
    }

    public void zzqg(int i) throws zzbus {
        if (this.zzcrR != i) {
            throw zzbus.zzacV();
        }
    }

    public boolean zzqh(int i) throws IOException {
        switch (zzbuw.zzqA(i)) {
            case 0:
                zzacy();
                return true;
            case 1:
                zzacG();
                return true;
            case 2:
                zzqm(zzacD());
                return true;
            case 3:
                zzacv();
                zzqg(zzbuw.zzK(zzbuw.zzqB(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                zzacF();
                return true;
            default:
                throw zzbus.zzacW();
        }
    }

    public int zzqj(int i) throws zzbus {
        if (i >= 0) {
            int i2 = i + this.zzcrQ;
            int i3 = this.zzcrS;
            if (i2 <= i3) {
                this.zzcrS = i2;
                zzacH();
                return i3;
            }
            throw zzbus.zzacR();
        }
        throw zzbus.zzacS();
    }

    public void zzqk(int i) {
        this.zzcrS = i;
        zzacH();
    }

    public void zzql(int i) {
        if (i <= this.zzcrQ - this.zzcrN) {
            if (i >= 0) {
                this.zzcrQ = this.zzcrN + i;
                return;
            }
            StringBuilder sb = new StringBuilder(24);
            sb.append("Bad position ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        int i2 = this.zzcrQ - this.zzcrN;
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("Position ");
        sb2.append(i);
        sb2.append(" is beyond current ");
        sb2.append(i2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public void zzqm(int i) throws IOException {
        if (i < 0) {
            throw zzbus.zzacS();
        }
        if (this.zzcrQ + i > this.zzcrS) {
            zzqm(this.zzcrS - this.zzcrQ);
            throw zzbus.zzacR();
        } else if (i > this.zzcrO - this.zzcrQ) {
            throw zzbus.zzacR();
        } else {
            this.zzcrQ += i;
        }
    }
}
