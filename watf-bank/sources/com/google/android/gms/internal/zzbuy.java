package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/classes2.dex */
public interface zzbuy {

    /* loaded from: assets/classes2.dex */
    public static final class zza extends zzbun<zza> implements Cloneable {
        public String version;
        public int zzcss;
        public String zzcst;

        public zza() {
            zzadb();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zza) {
                zza zzaVar = (zza) obj;
                if (this.zzcss != zzaVar.zzcss) {
                    return false;
                }
                if (this.zzcst == null) {
                    if (zzaVar.zzcst != null) {
                        return false;
                    }
                } else if (!this.zzcst.equals(zzaVar.zzcst)) {
                    return false;
                }
                if (this.version == null) {
                    if (zzaVar.version != null) {
                        return false;
                    }
                } else if (!this.version.equals(zzaVar.version)) {
                    return false;
                }
                return (this.zzcrX == null || this.zzcrX.isEmpty()) ? zzaVar.zzcrX == null || zzaVar.zzcrX.isEmpty() : this.zzcrX.equals(zzaVar.zzcrX);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.zzcss) * 31) + (this.zzcst == null ? 0 : this.zzcst.hashCode())) * 31) + (this.version == null ? 0 : this.version.hashCode())) * 31;
            if (this.zzcrX != null && !this.zzcrX.isEmpty()) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzcss != 0) {
                zzbumVar.zzF(1, this.zzcss);
            }
            if (this.zzcst != null && !this.zzcst.equals("")) {
                zzbumVar.zzq(2, this.zzcst);
            }
            if (this.version != null && !this.version.equals("")) {
                zzbumVar.zzq(3, this.version);
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzaO */
        public zza zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 8) {
                    this.zzcss = zzbulVar.zzacy();
                } else if (zzacu == 18) {
                    this.zzcst = zzbulVar.readString();
                } else if (zzacu == 26) {
                    this.version = zzbulVar.readString();
                } else if (!super.zza(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbun
        public /* synthetic */ zza zzacN() throws CloneNotSupportedException {
            return (zza) zzacO();
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public /* synthetic */ zzbut zzacO() throws CloneNotSupportedException {
            return (zza) clone();
        }

        public zza zzadb() {
            this.zzcss = 0;
            this.zzcst = "";
            this.version = "";
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        /* renamed from: zzadc */
        public zza clone() {
            try {
                return (zza) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public int zzv() {
            int zzv = super.zzv();
            if (this.zzcss != 0) {
                zzv += zzbum.zzH(1, this.zzcss);
            }
            if (this.zzcst != null && !this.zzcst.equals("")) {
                zzv += zzbum.zzr(2, this.zzcst);
            }
            return (this.version == null || this.version.equals("")) ? zzv : zzv + zzbum.zzr(3, this.version);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzb extends zzbun<zzb> implements Cloneable {
        public byte[] zzcsu;
        public String zzcsv;
        public byte[][] zzcsw;
        public boolean zzcsx;

        public zzb() {
            zzadd();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zzb) {
                zzb zzbVar = (zzb) obj;
                if (Arrays.equals(this.zzcsu, zzbVar.zzcsu)) {
                    if (this.zzcsv == null) {
                        if (zzbVar.zzcsv != null) {
                            return false;
                        }
                    } else if (!this.zzcsv.equals(zzbVar.zzcsv)) {
                        return false;
                    }
                    if (zzbur.zza(this.zzcsw, zzbVar.zzcsw) && this.zzcsx == zzbVar.zzcsx) {
                        return (this.zzcrX == null || this.zzcrX.isEmpty()) ? zzbVar.zzcrX == null || zzbVar.zzcrX.isEmpty() : this.zzcrX.equals(zzbVar.zzcrX);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzcsu)) * 31) + (this.zzcsv == null ? 0 : this.zzcsv.hashCode())) * 31) + zzbur.zzb(this.zzcsw)) * 31) + (this.zzcsx ? 1231 : 1237)) * 31;
            if (this.zzcrX != null && !this.zzcrX.isEmpty()) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (!Arrays.equals(this.zzcsu, zzbuw.zzcsp)) {
                zzbumVar.zzb(1, this.zzcsu);
            }
            if (this.zzcsw != null && this.zzcsw.length > 0) {
                for (int i = 0; i < this.zzcsw.length; i++) {
                    byte[] bArr = this.zzcsw[i];
                    if (bArr != null) {
                        zzbumVar.zzb(2, bArr);
                    }
                }
            }
            if (this.zzcsx) {
                zzbumVar.zzg(3, this.zzcsx);
            }
            if (this.zzcsv != null && !this.zzcsv.equals("")) {
                zzbumVar.zzq(4, this.zzcsv);
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzaP */
        public zzb zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 10) {
                    this.zzcsu = zzbulVar.readBytes();
                } else if (zzacu == 18) {
                    int zzc = zzbuw.zzc(zzbulVar, 18);
                    int length = this.zzcsw == null ? 0 : this.zzcsw.length;
                    byte[][] bArr = new byte[zzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzcsw, 0, bArr, 0, length);
                    }
                    while (length < bArr.length - 1) {
                        bArr[length] = zzbulVar.readBytes();
                        zzbulVar.zzacu();
                        length++;
                    }
                    bArr[length] = zzbulVar.readBytes();
                    this.zzcsw = bArr;
                } else if (zzacu == 24) {
                    this.zzcsx = zzbulVar.zzacA();
                } else if (zzacu == 34) {
                    this.zzcsv = zzbulVar.readString();
                } else if (!super.zza(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbun
        public /* synthetic */ zzb zzacN() throws CloneNotSupportedException {
            return (zzb) zzacO();
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public /* synthetic */ zzbut zzacO() throws CloneNotSupportedException {
            return (zzb) clone();
        }

        public zzb zzadd() {
            this.zzcsu = zzbuw.zzcsp;
            this.zzcsv = "";
            this.zzcsw = zzbuw.zzcso;
            this.zzcsx = false;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        /* renamed from: zzade */
        public zzb clone() {
            try {
                zzb zzbVar = (zzb) super.clone();
                if (this.zzcsw != null && this.zzcsw.length > 0) {
                    zzbVar.zzcsw = (byte[][]) this.zzcsw.clone();
                }
                return zzbVar;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public int zzv() {
            int zzv = super.zzv();
            if (!Arrays.equals(this.zzcsu, zzbuw.zzcsp)) {
                zzv += zzbum.zzc(1, this.zzcsu);
            }
            if (this.zzcsw != null && this.zzcsw.length > 0) {
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < this.zzcsw.length; i3++) {
                    byte[] bArr = this.zzcsw[i3];
                    if (bArr != null) {
                        i2++;
                        i += zzbum.zzag(bArr);
                    }
                }
                zzv = zzv + i + (i2 * 1);
            }
            if (this.zzcsx) {
                zzv += zzbum.zzh(3, this.zzcsx);
            }
            return (this.zzcsv == null || this.zzcsv.equals("")) ? zzv : zzv + zzbum.zzr(4, this.zzcsv);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzc extends zzbun<zzc> implements Cloneable {
        public String tag;
        public boolean zzcbV;
        public long zzcsA;
        public int zzcsB;
        public zzd[] zzcsC;
        public byte[] zzcsD;
        public zza zzcsE;
        public byte[] zzcsF;
        public String zzcsG;
        public String zzcsH;
        public String zzcsI;
        public long zzcsJ;
        public zzb zzcsK;
        public byte[] zzcsL;
        public String zzcsM;
        public int zzcsN;
        public int[] zzcsO;
        public long zzcsP;
        public zze zzcsQ;
        public long zzcsy;
        public long zzcsz;
        public int zzrn;

        public zzc() {
            zzadf();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zzc) {
                zzc zzcVar = (zzc) obj;
                if (this.zzcsy == zzcVar.zzcsy && this.zzcsz == zzcVar.zzcsz && this.zzcsA == zzcVar.zzcsA) {
                    if (this.tag == null) {
                        if (zzcVar.tag != null) {
                            return false;
                        }
                    } else if (!this.tag.equals(zzcVar.tag)) {
                        return false;
                    }
                    if (this.zzcsB == zzcVar.zzcsB && this.zzrn == zzcVar.zzrn && this.zzcbV == zzcVar.zzcbV && zzbur.equals(this.zzcsC, zzcVar.zzcsC) && Arrays.equals(this.zzcsD, zzcVar.zzcsD)) {
                        if (this.zzcsE == null) {
                            if (zzcVar.zzcsE != null) {
                                return false;
                            }
                        } else if (!this.zzcsE.equals(zzcVar.zzcsE)) {
                            return false;
                        }
                        if (Arrays.equals(this.zzcsF, zzcVar.zzcsF)) {
                            if (this.zzcsG == null) {
                                if (zzcVar.zzcsG != null) {
                                    return false;
                                }
                            } else if (!this.zzcsG.equals(zzcVar.zzcsG)) {
                                return false;
                            }
                            if (this.zzcsH == null) {
                                if (zzcVar.zzcsH != null) {
                                    return false;
                                }
                            } else if (!this.zzcsH.equals(zzcVar.zzcsH)) {
                                return false;
                            }
                            if (this.zzcsI == null) {
                                if (zzcVar.zzcsI != null) {
                                    return false;
                                }
                            } else if (!this.zzcsI.equals(zzcVar.zzcsI)) {
                                return false;
                            }
                            if (this.zzcsJ != zzcVar.zzcsJ) {
                                return false;
                            }
                            if (this.zzcsK == null) {
                                if (zzcVar.zzcsK != null) {
                                    return false;
                                }
                            } else if (!this.zzcsK.equals(zzcVar.zzcsK)) {
                                return false;
                            }
                            if (Arrays.equals(this.zzcsL, zzcVar.zzcsL)) {
                                if (this.zzcsM == null) {
                                    if (zzcVar.zzcsM != null) {
                                        return false;
                                    }
                                } else if (!this.zzcsM.equals(zzcVar.zzcsM)) {
                                    return false;
                                }
                                if (this.zzcsN == zzcVar.zzcsN && zzbur.equals(this.zzcsO, zzcVar.zzcsO) && this.zzcsP == zzcVar.zzcsP) {
                                    if (this.zzcsQ == null) {
                                        if (zzcVar.zzcsQ != null) {
                                            return false;
                                        }
                                    } else if (!this.zzcsQ.equals(zzcVar.zzcsQ)) {
                                        return false;
                                    }
                                    return (this.zzcrX == null || this.zzcrX.isEmpty()) ? zzcVar.zzcrX == null || zzcVar.zzcrX.isEmpty() : this.zzcrX.equals(zzcVar.zzcrX);
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((((((((((((((((((((((((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzcsy ^ (this.zzcsy >>> 32)))) * 31) + ((int) (this.zzcsz ^ (this.zzcsz >>> 32)))) * 31) + ((int) (this.zzcsA ^ (this.zzcsA >>> 32)))) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + this.zzcsB) * 31) + this.zzrn) * 31) + (this.zzcbV ? 1231 : 1237)) * 31) + zzbur.hashCode(this.zzcsC)) * 31) + Arrays.hashCode(this.zzcsD)) * 31) + (this.zzcsE == null ? 0 : this.zzcsE.hashCode())) * 31) + Arrays.hashCode(this.zzcsF)) * 31) + (this.zzcsG == null ? 0 : this.zzcsG.hashCode())) * 31) + (this.zzcsH == null ? 0 : this.zzcsH.hashCode())) * 31) + (this.zzcsI == null ? 0 : this.zzcsI.hashCode())) * 31) + ((int) (this.zzcsJ ^ (this.zzcsJ >>> 32)))) * 31) + (this.zzcsK == null ? 0 : this.zzcsK.hashCode())) * 31) + Arrays.hashCode(this.zzcsL)) * 31) + (this.zzcsM == null ? 0 : this.zzcsM.hashCode())) * 31) + this.zzcsN) * 31) + zzbur.hashCode(this.zzcsO)) * 31) + ((int) (this.zzcsP ^ (this.zzcsP >>> 32)))) * 31) + (this.zzcsQ == null ? 0 : this.zzcsQ.hashCode())) * 31;
            if (this.zzcrX != null && !this.zzcrX.isEmpty()) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzcsy != 0) {
                zzbumVar.zzb(1, this.zzcsy);
            }
            if (this.tag != null && !this.tag.equals("")) {
                zzbumVar.zzq(2, this.tag);
            }
            if (this.zzcsC != null && this.zzcsC.length > 0) {
                for (int i = 0; i < this.zzcsC.length; i++) {
                    zzd zzdVar = this.zzcsC[i];
                    if (zzdVar != null) {
                        zzbumVar.zza(3, zzdVar);
                    }
                }
            }
            if (!Arrays.equals(this.zzcsD, zzbuw.zzcsp)) {
                zzbumVar.zzb(4, this.zzcsD);
            }
            if (!Arrays.equals(this.zzcsF, zzbuw.zzcsp)) {
                zzbumVar.zzb(6, this.zzcsF);
            }
            if (this.zzcsG != null && !this.zzcsG.equals("")) {
                zzbumVar.zzq(8, this.zzcsG);
            }
            if (this.zzcsE != null) {
                zzbumVar.zza(9, this.zzcsE);
            }
            if (this.zzcbV) {
                zzbumVar.zzg(10, this.zzcbV);
            }
            if (this.zzcsB != 0) {
                zzbumVar.zzF(11, this.zzcsB);
            }
            if (this.zzrn != 0) {
                zzbumVar.zzF(12, this.zzrn);
            }
            if (this.zzcsH != null && !this.zzcsH.equals("")) {
                zzbumVar.zzq(13, this.zzcsH);
            }
            if (this.zzcsI != null && !this.zzcsI.equals("")) {
                zzbumVar.zzq(14, this.zzcsI);
            }
            if (this.zzcsJ != 180000) {
                zzbumVar.zzd(15, this.zzcsJ);
            }
            if (this.zzcsK != null) {
                zzbumVar.zza(16, this.zzcsK);
            }
            if (this.zzcsz != 0) {
                zzbumVar.zzb(17, this.zzcsz);
            }
            if (!Arrays.equals(this.zzcsL, zzbuw.zzcsp)) {
                zzbumVar.zzb(18, this.zzcsL);
            }
            if (this.zzcsN != 0) {
                zzbumVar.zzF(19, this.zzcsN);
            }
            if (this.zzcsO != null && this.zzcsO.length > 0) {
                for (int i2 = 0; i2 < this.zzcsO.length; i2++) {
                    zzbumVar.zzF(20, this.zzcsO[i2]);
                }
            }
            if (this.zzcsA != 0) {
                zzbumVar.zzb(21, this.zzcsA);
            }
            if (this.zzcsP != 0) {
                zzbumVar.zzb(22, this.zzcsP);
            }
            if (this.zzcsQ != null) {
                zzbumVar.zza(23, this.zzcsQ);
            }
            if (this.zzcsM != null && !this.zzcsM.equals("")) {
                zzbumVar.zzq(24, this.zzcsM);
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzaQ */
        public zzc zzb(zzbul zzbulVar) throws IOException {
            zzbut zzbutVar;
            while (true) {
                int zzacu = zzbulVar.zzacu();
                switch (zzacu) {
                    case 0:
                        return this;
                    case 8:
                        this.zzcsy = zzbulVar.zzacx();
                        continue;
                    case 18:
                        this.tag = zzbulVar.readString();
                        continue;
                    case 26:
                        int zzc = zzbuw.zzc(zzbulVar, 26);
                        int length = this.zzcsC == null ? 0 : this.zzcsC.length;
                        zzd[] zzdVarArr = new zzd[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzcsC, 0, zzdVarArr, 0, length);
                        }
                        while (length < zzdVarArr.length - 1) {
                            zzdVarArr[length] = new zzd();
                            zzbulVar.zza(zzdVarArr[length]);
                            zzbulVar.zzacu();
                            length++;
                        }
                        zzdVarArr[length] = new zzd();
                        zzbulVar.zza(zzdVarArr[length]);
                        this.zzcsC = zzdVarArr;
                        continue;
                    case 34:
                        this.zzcsD = zzbulVar.readBytes();
                        continue;
                    case 50:
                        this.zzcsF = zzbulVar.readBytes();
                        continue;
                    case 66:
                        this.zzcsG = zzbulVar.readString();
                        continue;
                    case 74:
                        if (this.zzcsE == null) {
                            this.zzcsE = new zza();
                        }
                        zzbutVar = this.zzcsE;
                        break;
                    case 80:
                        this.zzcbV = zzbulVar.zzacA();
                        continue;
                    case 88:
                        this.zzcsB = zzbulVar.zzacy();
                        continue;
                    case 96:
                        this.zzrn = zzbulVar.zzacy();
                        continue;
                    case 106:
                        this.zzcsH = zzbulVar.readString();
                        continue;
                    case 114:
                        this.zzcsI = zzbulVar.readString();
                        continue;
                    case 120:
                        this.zzcsJ = zzbulVar.zzacC();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        if (this.zzcsK == null) {
                            this.zzcsK = new zzb();
                        }
                        zzbutVar = this.zzcsK;
                        break;
                    case 136:
                        this.zzcsz = zzbulVar.zzacx();
                        continue;
                    case 146:
                        this.zzcsL = zzbulVar.readBytes();
                        continue;
                    case 152:
                        int zzacy = zzbulVar.zzacy();
                        switch (zzacy) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzcsN = zzacy;
                                continue;
                            default:
                                continue;
                        }
                    case 160:
                        int zzc2 = zzbuw.zzc(zzbulVar, 160);
                        int length2 = this.zzcsO == null ? 0 : this.zzcsO.length;
                        int[] iArr = new int[zzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzcsO, 0, iArr, 0, length2);
                        }
                        while (length2 < iArr.length - 1) {
                            iArr[length2] = zzbulVar.zzacy();
                            zzbulVar.zzacu();
                            length2++;
                        }
                        iArr[length2] = zzbulVar.zzacy();
                        this.zzcsO = iArr;
                        continue;
                    case 162:
                        int zzqj = zzbulVar.zzqj(zzbulVar.zzacD());
                        int position = zzbulVar.getPosition();
                        int i = 0;
                        while (zzbulVar.zzacI() > 0) {
                            zzbulVar.zzacy();
                            i++;
                        }
                        zzbulVar.zzql(position);
                        int length3 = this.zzcsO == null ? 0 : this.zzcsO.length;
                        int[] iArr2 = new int[i + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzcsO, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzbulVar.zzacy();
                            length3++;
                        }
                        this.zzcsO = iArr2;
                        zzbulVar.zzqk(zzqj);
                        continue;
                    case 168:
                        this.zzcsA = zzbulVar.zzacx();
                        continue;
                    case 176:
                        this.zzcsP = zzbulVar.zzacx();
                        continue;
                    case 186:
                        if (this.zzcsQ == null) {
                            this.zzcsQ = new zze();
                        }
                        zzbutVar = this.zzcsQ;
                        break;
                    case 194:
                        this.zzcsM = zzbulVar.readString();
                        continue;
                    default:
                        if (super.zza(zzbulVar, zzacu)) {
                            continue;
                        } else {
                            return this;
                        }
                }
                zzbulVar.zza(zzbutVar);
            }
        }

        @Override // com.google.android.gms.internal.zzbun
        public /* synthetic */ zzc zzacN() throws CloneNotSupportedException {
            return (zzc) zzacO();
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public /* synthetic */ zzbut zzacO() throws CloneNotSupportedException {
            return (zzc) clone();
        }

        public zzc zzadf() {
            this.zzcsy = 0L;
            this.zzcsz = 0L;
            this.zzcsA = 0L;
            this.tag = "";
            this.zzcsB = 0;
            this.zzrn = 0;
            this.zzcbV = false;
            this.zzcsC = zzd.zzadh();
            this.zzcsD = zzbuw.zzcsp;
            this.zzcsE = null;
            this.zzcsF = zzbuw.zzcsp;
            this.zzcsG = "";
            this.zzcsH = "";
            this.zzcsI = "";
            this.zzcsJ = 180000L;
            this.zzcsK = null;
            this.zzcsL = zzbuw.zzcsp;
            this.zzcsM = "";
            this.zzcsN = 0;
            this.zzcsO = zzbuw.zzcsi;
            this.zzcsP = 0L;
            this.zzcsQ = null;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        /* renamed from: zzadg */
        public zzc clone() {
            try {
                zzc zzcVar = (zzc) super.clone();
                if (this.zzcsC != null && this.zzcsC.length > 0) {
                    zzcVar.zzcsC = new zzd[this.zzcsC.length];
                    for (int i = 0; i < this.zzcsC.length; i++) {
                        if (this.zzcsC[i] != null) {
                            zzcVar.zzcsC[i] = (zzd) this.zzcsC[i].zzacO();
                        }
                    }
                }
                if (this.zzcsE != null) {
                    zzcVar.zzcsE = (zza) this.zzcsE.zzacO();
                }
                if (this.zzcsK != null) {
                    zzcVar.zzcsK = (zzb) this.zzcsK.zzacO();
                }
                if (this.zzcsO != null && this.zzcsO.length > 0) {
                    zzcVar.zzcsO = (int[]) this.zzcsO.clone();
                }
                if (this.zzcsQ != null) {
                    zzcVar.zzcsQ = (zze) this.zzcsQ.zzacO();
                }
                return zzcVar;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public int zzv() {
            int zzv = super.zzv();
            if (this.zzcsy != 0) {
                zzv += zzbum.zzf(1, this.zzcsy);
            }
            if (this.tag != null && !this.tag.equals("")) {
                zzv += zzbum.zzr(2, this.tag);
            }
            if (this.zzcsC != null && this.zzcsC.length > 0) {
                int i = zzv;
                for (int i2 = 0; i2 < this.zzcsC.length; i2++) {
                    zzd zzdVar = this.zzcsC[i2];
                    if (zzdVar != null) {
                        i += zzbum.zzc(3, zzdVar);
                    }
                }
                zzv = i;
            }
            if (!Arrays.equals(this.zzcsD, zzbuw.zzcsp)) {
                zzv += zzbum.zzc(4, this.zzcsD);
            }
            if (!Arrays.equals(this.zzcsF, zzbuw.zzcsp)) {
                zzv += zzbum.zzc(6, this.zzcsF);
            }
            if (this.zzcsG != null && !this.zzcsG.equals("")) {
                zzv += zzbum.zzr(8, this.zzcsG);
            }
            if (this.zzcsE != null) {
                zzv += zzbum.zzc(9, this.zzcsE);
            }
            if (this.zzcbV) {
                zzv += zzbum.zzh(10, this.zzcbV);
            }
            if (this.zzcsB != 0) {
                zzv += zzbum.zzH(11, this.zzcsB);
            }
            if (this.zzrn != 0) {
                zzv += zzbum.zzH(12, this.zzrn);
            }
            if (this.zzcsH != null && !this.zzcsH.equals("")) {
                zzv += zzbum.zzr(13, this.zzcsH);
            }
            if (this.zzcsI != null && !this.zzcsI.equals("")) {
                zzv += zzbum.zzr(14, this.zzcsI);
            }
            if (this.zzcsJ != 180000) {
                zzv += zzbum.zzh(15, this.zzcsJ);
            }
            if (this.zzcsK != null) {
                zzv += zzbum.zzc(16, this.zzcsK);
            }
            if (this.zzcsz != 0) {
                zzv += zzbum.zzf(17, this.zzcsz);
            }
            if (!Arrays.equals(this.zzcsL, zzbuw.zzcsp)) {
                zzv += zzbum.zzc(18, this.zzcsL);
            }
            if (this.zzcsN != 0) {
                zzv += zzbum.zzH(19, this.zzcsN);
            }
            if (this.zzcsO != null && this.zzcsO.length > 0) {
                int i3 = 0;
                for (int i4 = 0; i4 < this.zzcsO.length; i4++) {
                    i3 += zzbum.zzqp(this.zzcsO[i4]);
                }
                zzv = zzv + i3 + (this.zzcsO.length * 2);
            }
            if (this.zzcsA != 0) {
                zzv += zzbum.zzf(21, this.zzcsA);
            }
            if (this.zzcsP != 0) {
                zzv += zzbum.zzf(22, this.zzcsP);
            }
            if (this.zzcsQ != null) {
                zzv += zzbum.zzc(23, this.zzcsQ);
            }
            return (this.zzcsM == null || this.zzcsM.equals("")) ? zzv : zzv + zzbum.zzr(24, this.zzcsM);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzd extends zzbun<zzd> implements Cloneable {
        private static volatile zzd[] zzcsR;
        public String value;
        public String zzaA;

        public zzd() {
            zzadi();
        }

        public static zzd[] zzadh() {
            if (zzcsR == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzcsR == null) {
                        zzcsR = new zzd[0];
                    }
                }
            }
            return zzcsR;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zzd) {
                zzd zzdVar = (zzd) obj;
                if (this.zzaA == null) {
                    if (zzdVar.zzaA != null) {
                        return false;
                    }
                } else if (!this.zzaA.equals(zzdVar.zzaA)) {
                    return false;
                }
                if (this.value == null) {
                    if (zzdVar.value != null) {
                        return false;
                    }
                } else if (!this.value.equals(zzdVar.value)) {
                    return false;
                }
                return (this.zzcrX == null || this.zzcrX.isEmpty()) ? zzdVar.zzcrX == null || zzdVar.zzcrX.isEmpty() : this.zzcrX.equals(zzdVar.zzcrX);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + (this.zzaA == null ? 0 : this.zzaA.hashCode())) * 31) + (this.value == null ? 0 : this.value.hashCode())) * 31;
            if (this.zzcrX != null && !this.zzcrX.isEmpty()) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzaA != null && !this.zzaA.equals("")) {
                zzbumVar.zzq(1, this.zzaA);
            }
            if (this.value != null && !this.value.equals("")) {
                zzbumVar.zzq(2, this.value);
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzaR */
        public zzd zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 10) {
                    this.zzaA = zzbulVar.readString();
                } else if (zzacu == 18) {
                    this.value = zzbulVar.readString();
                } else if (!super.zza(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbun
        public /* synthetic */ zzd zzacN() throws CloneNotSupportedException {
            return (zzd) zzacO();
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public /* synthetic */ zzbut zzacO() throws CloneNotSupportedException {
            return (zzd) clone();
        }

        public zzd zzadi() {
            this.zzaA = "";
            this.value = "";
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        /* renamed from: zzadj */
        public zzd clone() {
            try {
                return (zzd) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public int zzv() {
            int zzv = super.zzv();
            if (this.zzaA != null && !this.zzaA.equals("")) {
                zzv += zzbum.zzr(1, this.zzaA);
            }
            return (this.value == null || this.value.equals("")) ? zzv : zzv + zzbum.zzr(2, this.value);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zze extends zzbun<zze> implements Cloneable {
        public int zzcsS;
        public int zzcsT;

        public zze() {
            zzadk();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zze) {
                zze zzeVar = (zze) obj;
                if (this.zzcsS == zzeVar.zzcsS && this.zzcsT == zzeVar.zzcsT) {
                    return (this.zzcrX == null || this.zzcrX.isEmpty()) ? zzeVar.zzcrX == null || zzeVar.zzcrX.isEmpty() : this.zzcrX.equals(zzeVar.zzcrX);
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return ((((((getClass().getName().hashCode() + 527) * 31) + this.zzcsS) * 31) + this.zzcsT) * 31) + ((this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode());
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzcsS != -1) {
                zzbumVar.zzF(1, this.zzcsS);
            }
            if (this.zzcsT != 0) {
                zzbumVar.zzF(2, this.zzcsT);
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzaS */
        public zze zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 8) {
                    int zzacy = zzbulVar.zzacy();
                    switch (zzacy) {
                        case -1:
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
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                            this.zzcsS = zzacy;
                            continue;
                    }
                } else if (zzacu == 16) {
                    int zzacy2 = zzbulVar.zzacy();
                    if (zzacy2 != 100) {
                        switch (zzacy2) {
                        }
                    }
                    this.zzcsT = zzacy2;
                } else if (!super.zza(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbun
        public /* synthetic */ zze zzacN() throws CloneNotSupportedException {
            return (zze) zzacO();
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public /* synthetic */ zzbut zzacO() throws CloneNotSupportedException {
            return (zze) clone();
        }

        public zze zzadk() {
            this.zzcsS = -1;
            this.zzcsT = 0;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        /* renamed from: zzadl */
        public zze clone() {
            try {
                return (zze) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public int zzv() {
            int zzv = super.zzv();
            if (this.zzcsS != -1) {
                zzv += zzbum.zzH(1, this.zzcsS);
            }
            return this.zzcsT != 0 ? zzv + zzbum.zzH(2, this.zzcsT) : zzv;
        }
    }
}
