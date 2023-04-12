package com.google.android.gms.internal;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzaf {
    public final String name;
    public final long time;
    public final long zzbo;

    /* loaded from: assets/classes2.dex */
    public static final class zza extends zzbun<zza> {
        public zzb zzbC;
        public C0006zza zzbR;
        public zzb zzbT;
        public zze zzca;
        public String zzba = null;
        public String zzaZ = null;
        public Long zzbb = null;
        public Long zzbc = null;
        public Long zzbd = null;
        public Long zzbe = null;
        public Long zzbf = null;
        public Long zzbg = null;
        public Long zzbh = null;
        public Long zzbi = null;
        public Long zzbj = null;
        public Long zzbk = null;
        public String zzbl = null;
        public Long zzbm = null;
        public Long zzbn = null;
        public Long zzbo = null;
        public Long zzbp = null;
        public Long zzbq = null;
        public Long zzbr = null;
        public Long zzbs = null;
        public Long zzbt = null;
        public Long zzbu = null;
        public String zzaM = null;
        public String zzbv = null;
        public Long zzbw = null;
        public Long zzbx = null;
        public Long zzby = null;
        public String zzaO = null;
        public Long zzbz = null;
        public Long zzbA = null;
        public Long zzbB = null;
        public Long zzbD = null;
        public Long zzbE = null;
        public Long zzbF = null;
        public Long zzbG = null;
        public Long zzbH = null;
        public Long zzbI = null;
        public String zzaP = null;
        public String zzaQ = null;
        public Integer zzbJ = null;
        public Integer zzbK = null;
        public Long zzbL = null;
        public Long zzbM = null;
        public Long zzbN = null;
        public Long zzbO = null;
        public Long zzbP = null;
        public Integer zzbQ = null;
        public C0006zza[] zzbS = C0006zza.zzy();
        public Long zzbU = null;
        public String zzbV = null;
        public Integer zzbW = null;
        public Boolean zzbX = null;
        public String zzbY = null;
        public Long zzbZ = null;

        /* renamed from: com.google.android.gms.internal.zzaf$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        public static final class C0006zza extends zzbun<C0006zza> {
            private static volatile C0006zza[] zzcb;
            public Long zzbm = null;
            public Long zzbn = null;
            public Long zzcc = null;
            public Long zzcd = null;
            public Long zzce = null;
            public Long zzcf = null;
            public Integer zzcg = null;
            public Long zzch = null;
            public Long zzci = null;
            public Long zzcj = null;
            public Integer zzck = null;
            public Long zzcl = null;

            public C0006zza() {
                this.zzcsg = -1;
            }

            public static C0006zza[] zzy() {
                if (zzcb == null) {
                    synchronized (zzbur.zzcsf) {
                        if (zzcb == null) {
                            zzcb = new C0006zza[0];
                        }
                    }
                }
                return zzcb;
            }

            @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
            public void zza(zzbum zzbumVar) throws IOException {
                if (this.zzbm != null) {
                    zzbumVar.zzb(1, this.zzbm.longValue());
                }
                if (this.zzbn != null) {
                    zzbumVar.zzb(2, this.zzbn.longValue());
                }
                if (this.zzcc != null) {
                    zzbumVar.zzb(3, this.zzcc.longValue());
                }
                if (this.zzcd != null) {
                    zzbumVar.zzb(4, this.zzcd.longValue());
                }
                if (this.zzce != null) {
                    zzbumVar.zzb(5, this.zzce.longValue());
                }
                if (this.zzcf != null) {
                    zzbumVar.zzb(6, this.zzcf.longValue());
                }
                if (this.zzcg != null) {
                    zzbumVar.zzF(7, this.zzcg.intValue());
                }
                if (this.zzch != null) {
                    zzbumVar.zzb(8, this.zzch.longValue());
                }
                if (this.zzci != null) {
                    zzbumVar.zzb(9, this.zzci.longValue());
                }
                if (this.zzcj != null) {
                    zzbumVar.zzb(10, this.zzcj.longValue());
                }
                if (this.zzck != null) {
                    zzbumVar.zzF(11, this.zzck.intValue());
                }
                if (this.zzcl != null) {
                    zzbumVar.zzb(12, this.zzcl.longValue());
                }
                super.zza(zzbumVar);
            }

            @Override // com.google.android.gms.internal.zzbut
            /* renamed from: zzg */
            public C0006zza zzb(zzbul zzbulVar) throws IOException {
                while (true) {
                    int zzacu = zzbulVar.zzacu();
                    switch (zzacu) {
                        case 0:
                            return this;
                        case 8:
                            this.zzbm = Long.valueOf(zzbulVar.zzacx());
                            break;
                        case 16:
                            this.zzbn = Long.valueOf(zzbulVar.zzacx());
                            break;
                        case 24:
                            this.zzcc = Long.valueOf(zzbulVar.zzacx());
                            break;
                        case 32:
                            this.zzcd = Long.valueOf(zzbulVar.zzacx());
                            break;
                        case 40:
                            this.zzce = Long.valueOf(zzbulVar.zzacx());
                            break;
                        case 48:
                            this.zzcf = Long.valueOf(zzbulVar.zzacx());
                            break;
                        case 56:
                            int zzacy = zzbulVar.zzacy();
                            if (zzacy != 1000) {
                                switch (zzacy) {
                                }
                            }
                            this.zzcg = Integer.valueOf(zzacy);
                            break;
                        case 64:
                            this.zzch = Long.valueOf(zzbulVar.zzacx());
                            break;
                        case 72:
                            this.zzci = Long.valueOf(zzbulVar.zzacx());
                            break;
                        case 80:
                            this.zzcj = Long.valueOf(zzbulVar.zzacx());
                            break;
                        case 88:
                            int zzacy2 = zzbulVar.zzacy();
                            if (zzacy2 != 1000) {
                                switch (zzacy2) {
                                }
                            }
                            this.zzck = Integer.valueOf(zzacy2);
                            break;
                        case 96:
                            this.zzcl = Long.valueOf(zzbulVar.zzacx());
                            break;
                        default:
                            if (super.zza(zzbulVar, zzacu)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
            protected int zzv() {
                int zzv = super.zzv();
                if (this.zzbm != null) {
                    zzv += zzbum.zzf(1, this.zzbm.longValue());
                }
                if (this.zzbn != null) {
                    zzv += zzbum.zzf(2, this.zzbn.longValue());
                }
                if (this.zzcc != null) {
                    zzv += zzbum.zzf(3, this.zzcc.longValue());
                }
                if (this.zzcd != null) {
                    zzv += zzbum.zzf(4, this.zzcd.longValue());
                }
                if (this.zzce != null) {
                    zzv += zzbum.zzf(5, this.zzce.longValue());
                }
                if (this.zzcf != null) {
                    zzv += zzbum.zzf(6, this.zzcf.longValue());
                }
                if (this.zzcg != null) {
                    zzv += zzbum.zzH(7, this.zzcg.intValue());
                }
                if (this.zzch != null) {
                    zzv += zzbum.zzf(8, this.zzch.longValue());
                }
                if (this.zzci != null) {
                    zzv += zzbum.zzf(9, this.zzci.longValue());
                }
                if (this.zzcj != null) {
                    zzv += zzbum.zzf(10, this.zzcj.longValue());
                }
                if (this.zzck != null) {
                    zzv += zzbum.zzH(11, this.zzck.intValue());
                }
                return this.zzcl != null ? zzv + zzbum.zzf(12, this.zzcl.longValue()) : zzv;
            }
        }

        /* loaded from: assets/classes2.dex */
        public static final class zzb extends zzbun<zzb> {
            public Long zzbO = null;
            public Long zzbP = null;
            public Long zzcm = null;

            public zzb() {
                this.zzcsg = -1;
            }

            @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
            public void zza(zzbum zzbumVar) throws IOException {
                if (this.zzbO != null) {
                    zzbumVar.zzb(1, this.zzbO.longValue());
                }
                if (this.zzbP != null) {
                    zzbumVar.zzb(2, this.zzbP.longValue());
                }
                if (this.zzcm != null) {
                    zzbumVar.zzb(3, this.zzcm.longValue());
                }
                super.zza(zzbumVar);
            }

            @Override // com.google.android.gms.internal.zzbut
            /* renamed from: zzh */
            public zzb zzb(zzbul zzbulVar) throws IOException {
                while (true) {
                    int zzacu = zzbulVar.zzacu();
                    if (zzacu == 0) {
                        return this;
                    }
                    if (zzacu == 8) {
                        this.zzbO = Long.valueOf(zzbulVar.zzacx());
                    } else if (zzacu == 16) {
                        this.zzbP = Long.valueOf(zzbulVar.zzacx());
                    } else if (zzacu == 24) {
                        this.zzcm = Long.valueOf(zzbulVar.zzacx());
                    } else if (!super.zza(zzbulVar, zzacu)) {
                        return this;
                    }
                }
            }

            @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
            protected int zzv() {
                int zzv = super.zzv();
                if (this.zzbO != null) {
                    zzv += zzbum.zzf(1, this.zzbO.longValue());
                }
                if (this.zzbP != null) {
                    zzv += zzbum.zzf(2, this.zzbP.longValue());
                }
                return this.zzcm != null ? zzv + zzbum.zzf(3, this.zzcm.longValue()) : zzv;
            }
        }

        public zza() {
            this.zzcsg = -1;
        }

        public static zza zzd(byte[] bArr) throws zzbus {
            return (zza) zzbut.zza(new zza(), bArr);
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzba != null) {
                zzbumVar.zzq(1, this.zzba);
            }
            if (this.zzaZ != null) {
                zzbumVar.zzq(2, this.zzaZ);
            }
            if (this.zzbb != null) {
                zzbumVar.zzb(3, this.zzbb.longValue());
            }
            if (this.zzbc != null) {
                zzbumVar.zzb(4, this.zzbc.longValue());
            }
            if (this.zzbd != null) {
                zzbumVar.zzb(5, this.zzbd.longValue());
            }
            if (this.zzbe != null) {
                zzbumVar.zzb(6, this.zzbe.longValue());
            }
            if (this.zzbf != null) {
                zzbumVar.zzb(7, this.zzbf.longValue());
            }
            if (this.zzbg != null) {
                zzbumVar.zzb(8, this.zzbg.longValue());
            }
            if (this.zzbh != null) {
                zzbumVar.zzb(9, this.zzbh.longValue());
            }
            if (this.zzbi != null) {
                zzbumVar.zzb(10, this.zzbi.longValue());
            }
            if (this.zzbj != null) {
                zzbumVar.zzb(11, this.zzbj.longValue());
            }
            if (this.zzbk != null) {
                zzbumVar.zzb(12, this.zzbk.longValue());
            }
            if (this.zzbl != null) {
                zzbumVar.zzq(13, this.zzbl);
            }
            if (this.zzbm != null) {
                zzbumVar.zzb(14, this.zzbm.longValue());
            }
            if (this.zzbn != null) {
                zzbumVar.zzb(15, this.zzbn.longValue());
            }
            if (this.zzbo != null) {
                zzbumVar.zzb(16, this.zzbo.longValue());
            }
            if (this.zzbp != null) {
                zzbumVar.zzb(17, this.zzbp.longValue());
            }
            if (this.zzbq != null) {
                zzbumVar.zzb(18, this.zzbq.longValue());
            }
            if (this.zzbr != null) {
                zzbumVar.zzb(19, this.zzbr.longValue());
            }
            if (this.zzbs != null) {
                zzbumVar.zzb(20, this.zzbs.longValue());
            }
            if (this.zzbU != null) {
                zzbumVar.zzb(21, this.zzbU.longValue());
            }
            if (this.zzbt != null) {
                zzbumVar.zzb(22, this.zzbt.longValue());
            }
            if (this.zzbu != null) {
                zzbumVar.zzb(23, this.zzbu.longValue());
            }
            if (this.zzbV != null) {
                zzbumVar.zzq(24, this.zzbV);
            }
            if (this.zzbZ != null) {
                zzbumVar.zzb(25, this.zzbZ.longValue());
            }
            if (this.zzbW != null) {
                zzbumVar.zzF(26, this.zzbW.intValue());
            }
            if (this.zzaM != null) {
                zzbumVar.zzq(27, this.zzaM);
            }
            if (this.zzbX != null) {
                zzbumVar.zzg(28, this.zzbX.booleanValue());
            }
            if (this.zzbv != null) {
                zzbumVar.zzq(29, this.zzbv);
            }
            if (this.zzbY != null) {
                zzbumVar.zzq(30, this.zzbY);
            }
            if (this.zzbw != null) {
                zzbumVar.zzb(31, this.zzbw.longValue());
            }
            if (this.zzbx != null) {
                zzbumVar.zzb(32, this.zzbx.longValue());
            }
            if (this.zzby != null) {
                zzbumVar.zzb(33, this.zzby.longValue());
            }
            if (this.zzaO != null) {
                zzbumVar.zzq(34, this.zzaO);
            }
            if (this.zzbz != null) {
                zzbumVar.zzb(35, this.zzbz.longValue());
            }
            if (this.zzbA != null) {
                zzbumVar.zzb(36, this.zzbA.longValue());
            }
            if (this.zzbB != null) {
                zzbumVar.zzb(37, this.zzbB.longValue());
            }
            if (this.zzbC != null) {
                zzbumVar.zza(38, this.zzbC);
            }
            if (this.zzbD != null) {
                zzbumVar.zzb(39, this.zzbD.longValue());
            }
            if (this.zzbE != null) {
                zzbumVar.zzb(40, this.zzbE.longValue());
            }
            if (this.zzbF != null) {
                zzbumVar.zzb(41, this.zzbF.longValue());
            }
            if (this.zzbG != null) {
                zzbumVar.zzb(42, this.zzbG.longValue());
            }
            if (this.zzbS != null && this.zzbS.length > 0) {
                for (int i = 0; i < this.zzbS.length; i++) {
                    C0006zza c0006zza = this.zzbS[i];
                    if (c0006zza != null) {
                        zzbumVar.zza(43, c0006zza);
                    }
                }
            }
            if (this.zzbH != null) {
                zzbumVar.zzb(44, this.zzbH.longValue());
            }
            if (this.zzbI != null) {
                zzbumVar.zzb(45, this.zzbI.longValue());
            }
            if (this.zzaP != null) {
                zzbumVar.zzq(46, this.zzaP);
            }
            if (this.zzaQ != null) {
                zzbumVar.zzq(47, this.zzaQ);
            }
            if (this.zzbJ != null) {
                zzbumVar.zzF(48, this.zzbJ.intValue());
            }
            if (this.zzbK != null) {
                zzbumVar.zzF(49, this.zzbK.intValue());
            }
            if (this.zzbR != null) {
                zzbumVar.zza(50, this.zzbR);
            }
            if (this.zzbL != null) {
                zzbumVar.zzb(51, this.zzbL.longValue());
            }
            if (this.zzbM != null) {
                zzbumVar.zzb(52, this.zzbM.longValue());
            }
            if (this.zzbN != null) {
                zzbumVar.zzb(53, this.zzbN.longValue());
            }
            if (this.zzbO != null) {
                zzbumVar.zzb(54, this.zzbO.longValue());
            }
            if (this.zzbP != null) {
                zzbumVar.zzb(55, this.zzbP.longValue());
            }
            if (this.zzbQ != null) {
                zzbumVar.zzF(56, this.zzbQ.intValue());
            }
            if (this.zzbT != null) {
                zzbumVar.zza(57, this.zzbT);
            }
            if (this.zzca != null) {
                zzbumVar.zza(201, this.zzca);
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzf */
        public zza zzb(zzbul zzbulVar) throws IOException {
            zzbut zzbutVar;
            while (true) {
                int zzacu = zzbulVar.zzacu();
                switch (zzacu) {
                    case 0:
                        return this;
                    case 10:
                        this.zzba = zzbulVar.readString();
                        continue;
                    case 18:
                        this.zzaZ = zzbulVar.readString();
                        continue;
                    case 24:
                        this.zzbb = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 32:
                        this.zzbc = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 40:
                        this.zzbd = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 48:
                        this.zzbe = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 56:
                        this.zzbf = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 64:
                        this.zzbg = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 72:
                        this.zzbh = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 80:
                        this.zzbi = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 88:
                        this.zzbj = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 96:
                        this.zzbk = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 106:
                        this.zzbl = zzbulVar.readString();
                        continue;
                    case 112:
                        this.zzbm = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 120:
                        this.zzbn = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 128:
                        this.zzbo = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 136:
                        this.zzbp = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 144:
                        this.zzbq = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 152:
                        this.zzbr = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 160:
                        this.zzbs = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 168:
                        this.zzbU = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 176:
                        this.zzbt = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 184:
                        this.zzbu = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 194:
                        this.zzbV = zzbulVar.readString();
                        continue;
                    case 200:
                        this.zzbZ = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 208:
                        int zzacy = zzbulVar.zzacy();
                        switch (zzacy) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.zzbW = Integer.valueOf(zzacy);
                                continue;
                            default:
                                continue;
                        }
                    case 218:
                        this.zzaM = zzbulVar.readString();
                        continue;
                    case 224:
                        this.zzbX = Boolean.valueOf(zzbulVar.zzacA());
                        continue;
                    case 234:
                        this.zzbv = zzbulVar.readString();
                        continue;
                    case 242:
                        this.zzbY = zzbulVar.readString();
                        continue;
                    case 248:
                        this.zzbw = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 256:
                        this.zzbx = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 264:
                        this.zzby = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 274:
                        this.zzaO = zzbulVar.readString();
                        continue;
                    case 280:
                        this.zzbz = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 288:
                        this.zzbA = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 296:
                        this.zzbB = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 306:
                        if (this.zzbC == null) {
                            this.zzbC = new zzb();
                        }
                        zzbutVar = this.zzbC;
                        break;
                    case 312:
                        this.zzbD = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 320:
                        this.zzbE = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 328:
                        this.zzbF = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 336:
                        this.zzbG = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 346:
                        int zzc = zzbuw.zzc(zzbulVar, 346);
                        int length = this.zzbS == null ? 0 : this.zzbS.length;
                        C0006zza[] c0006zzaArr = new C0006zza[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzbS, 0, c0006zzaArr, 0, length);
                        }
                        while (length < c0006zzaArr.length - 1) {
                            c0006zzaArr[length] = new C0006zza();
                            zzbulVar.zza(c0006zzaArr[length]);
                            zzbulVar.zzacu();
                            length++;
                        }
                        c0006zzaArr[length] = new C0006zza();
                        zzbulVar.zza(c0006zzaArr[length]);
                        this.zzbS = c0006zzaArr;
                        continue;
                    case 352:
                        this.zzbH = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 360:
                        this.zzbI = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 370:
                        this.zzaP = zzbulVar.readString();
                        continue;
                    case 378:
                        this.zzaQ = zzbulVar.readString();
                        continue;
                    case 384:
                        int zzacy2 = zzbulVar.zzacy();
                        if (zzacy2 != 1000) {
                            switch (zzacy2) {
                                case 0:
                                case 1:
                                case 2:
                                    break;
                                default:
                                    continue;
                            }
                        }
                        this.zzbJ = Integer.valueOf(zzacy2);
                    case 392:
                        int zzacy3 = zzbulVar.zzacy();
                        if (zzacy3 != 1000) {
                            switch (zzacy3) {
                                case 0:
                                case 1:
                                case 2:
                                    break;
                                default:
                                    continue;
                            }
                        }
                        this.zzbK = Integer.valueOf(zzacy3);
                    case 402:
                        if (this.zzbR == null) {
                            this.zzbR = new C0006zza();
                        }
                        zzbutVar = this.zzbR;
                        break;
                    case 408:
                        this.zzbL = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 416:
                        this.zzbM = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 424:
                        this.zzbN = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 432:
                        this.zzbO = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 440:
                        this.zzbP = Long.valueOf(zzbulVar.zzacx());
                        continue;
                    case 448:
                        int zzacy4 = zzbulVar.zzacy();
                        if (zzacy4 != 1000) {
                            switch (zzacy4) {
                                case 0:
                                case 1:
                                case 2:
                                    break;
                                default:
                                    continue;
                            }
                        }
                        this.zzbQ = Integer.valueOf(zzacy4);
                    case 458:
                        if (this.zzbT == null) {
                            this.zzbT = new zzb();
                        }
                        zzbutVar = this.zzbT;
                        break;
                    case 1610:
                        if (this.zzca == null) {
                            this.zzca = new zze();
                        }
                        zzbutVar = this.zzca;
                        break;
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

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzba != null) {
                zzv += zzbum.zzr(1, this.zzba);
            }
            if (this.zzaZ != null) {
                zzv += zzbum.zzr(2, this.zzaZ);
            }
            if (this.zzbb != null) {
                zzv += zzbum.zzf(3, this.zzbb.longValue());
            }
            if (this.zzbc != null) {
                zzv += zzbum.zzf(4, this.zzbc.longValue());
            }
            if (this.zzbd != null) {
                zzv += zzbum.zzf(5, this.zzbd.longValue());
            }
            if (this.zzbe != null) {
                zzv += zzbum.zzf(6, this.zzbe.longValue());
            }
            if (this.zzbf != null) {
                zzv += zzbum.zzf(7, this.zzbf.longValue());
            }
            if (this.zzbg != null) {
                zzv += zzbum.zzf(8, this.zzbg.longValue());
            }
            if (this.zzbh != null) {
                zzv += zzbum.zzf(9, this.zzbh.longValue());
            }
            if (this.zzbi != null) {
                zzv += zzbum.zzf(10, this.zzbi.longValue());
            }
            if (this.zzbj != null) {
                zzv += zzbum.zzf(11, this.zzbj.longValue());
            }
            if (this.zzbk != null) {
                zzv += zzbum.zzf(12, this.zzbk.longValue());
            }
            if (this.zzbl != null) {
                zzv += zzbum.zzr(13, this.zzbl);
            }
            if (this.zzbm != null) {
                zzv += zzbum.zzf(14, this.zzbm.longValue());
            }
            if (this.zzbn != null) {
                zzv += zzbum.zzf(15, this.zzbn.longValue());
            }
            if (this.zzbo != null) {
                zzv += zzbum.zzf(16, this.zzbo.longValue());
            }
            if (this.zzbp != null) {
                zzv += zzbum.zzf(17, this.zzbp.longValue());
            }
            if (this.zzbq != null) {
                zzv += zzbum.zzf(18, this.zzbq.longValue());
            }
            if (this.zzbr != null) {
                zzv += zzbum.zzf(19, this.zzbr.longValue());
            }
            if (this.zzbs != null) {
                zzv += zzbum.zzf(20, this.zzbs.longValue());
            }
            if (this.zzbU != null) {
                zzv += zzbum.zzf(21, this.zzbU.longValue());
            }
            if (this.zzbt != null) {
                zzv += zzbum.zzf(22, this.zzbt.longValue());
            }
            if (this.zzbu != null) {
                zzv += zzbum.zzf(23, this.zzbu.longValue());
            }
            if (this.zzbV != null) {
                zzv += zzbum.zzr(24, this.zzbV);
            }
            if (this.zzbZ != null) {
                zzv += zzbum.zzf(25, this.zzbZ.longValue());
            }
            if (this.zzbW != null) {
                zzv += zzbum.zzH(26, this.zzbW.intValue());
            }
            if (this.zzaM != null) {
                zzv += zzbum.zzr(27, this.zzaM);
            }
            if (this.zzbX != null) {
                zzv += zzbum.zzh(28, this.zzbX.booleanValue());
            }
            if (this.zzbv != null) {
                zzv += zzbum.zzr(29, this.zzbv);
            }
            if (this.zzbY != null) {
                zzv += zzbum.zzr(30, this.zzbY);
            }
            if (this.zzbw != null) {
                zzv += zzbum.zzf(31, this.zzbw.longValue());
            }
            if (this.zzbx != null) {
                zzv += zzbum.zzf(32, this.zzbx.longValue());
            }
            if (this.zzby != null) {
                zzv += zzbum.zzf(33, this.zzby.longValue());
            }
            if (this.zzaO != null) {
                zzv += zzbum.zzr(34, this.zzaO);
            }
            if (this.zzbz != null) {
                zzv += zzbum.zzf(35, this.zzbz.longValue());
            }
            if (this.zzbA != null) {
                zzv += zzbum.zzf(36, this.zzbA.longValue());
            }
            if (this.zzbB != null) {
                zzv += zzbum.zzf(37, this.zzbB.longValue());
            }
            if (this.zzbC != null) {
                zzv += zzbum.zzc(38, this.zzbC);
            }
            if (this.zzbD != null) {
                zzv += zzbum.zzf(39, this.zzbD.longValue());
            }
            if (this.zzbE != null) {
                zzv += zzbum.zzf(40, this.zzbE.longValue());
            }
            if (this.zzbF != null) {
                zzv += zzbum.zzf(41, this.zzbF.longValue());
            }
            if (this.zzbG != null) {
                zzv += zzbum.zzf(42, this.zzbG.longValue());
            }
            if (this.zzbS != null && this.zzbS.length > 0) {
                for (int i = 0; i < this.zzbS.length; i++) {
                    C0006zza c0006zza = this.zzbS[i];
                    if (c0006zza != null) {
                        zzv += zzbum.zzc(43, c0006zza);
                    }
                }
            }
            if (this.zzbH != null) {
                zzv += zzbum.zzf(44, this.zzbH.longValue());
            }
            if (this.zzbI != null) {
                zzv += zzbum.zzf(45, this.zzbI.longValue());
            }
            if (this.zzaP != null) {
                zzv += zzbum.zzr(46, this.zzaP);
            }
            if (this.zzaQ != null) {
                zzv += zzbum.zzr(47, this.zzaQ);
            }
            if (this.zzbJ != null) {
                zzv += zzbum.zzH(48, this.zzbJ.intValue());
            }
            if (this.zzbK != null) {
                zzv += zzbum.zzH(49, this.zzbK.intValue());
            }
            if (this.zzbR != null) {
                zzv += zzbum.zzc(50, this.zzbR);
            }
            if (this.zzbL != null) {
                zzv += zzbum.zzf(51, this.zzbL.longValue());
            }
            if (this.zzbM != null) {
                zzv += zzbum.zzf(52, this.zzbM.longValue());
            }
            if (this.zzbN != null) {
                zzv += zzbum.zzf(53, this.zzbN.longValue());
            }
            if (this.zzbO != null) {
                zzv += zzbum.zzf(54, this.zzbO.longValue());
            }
            if (this.zzbP != null) {
                zzv += zzbum.zzf(55, this.zzbP.longValue());
            }
            if (this.zzbQ != null) {
                zzv += zzbum.zzH(56, this.zzbQ.intValue());
            }
            if (this.zzbT != null) {
                zzv += zzbum.zzc(57, this.zzbT);
            }
            return this.zzca != null ? zzv + zzbum.zzc(201, this.zzca) : zzv;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzb extends zzbun<zzb> {
        public Long zzcn = null;
        public Integer zzco = null;
        public Boolean zzcp = null;
        public int[] zzcq = zzbuw.zzcsi;
        public Long zzcr = null;

        public zzb() {
            this.zzcsg = -1;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzcn != null) {
                zzbumVar.zzb(1, this.zzcn.longValue());
            }
            if (this.zzco != null) {
                zzbumVar.zzF(2, this.zzco.intValue());
            }
            if (this.zzcp != null) {
                zzbumVar.zzg(3, this.zzcp.booleanValue());
            }
            if (this.zzcq != null && this.zzcq.length > 0) {
                for (int i = 0; i < this.zzcq.length; i++) {
                    zzbumVar.zzF(4, this.zzcq[i]);
                }
            }
            if (this.zzcr != null) {
                zzbumVar.zza(5, this.zzcr.longValue());
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzi */
        public zzb zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 8) {
                    this.zzcn = Long.valueOf(zzbulVar.zzacx());
                } else if (zzacu == 16) {
                    this.zzco = Integer.valueOf(zzbulVar.zzacy());
                } else if (zzacu == 24) {
                    this.zzcp = Boolean.valueOf(zzbulVar.zzacA());
                } else if (zzacu == 32) {
                    int zzc = zzbuw.zzc(zzbulVar, 32);
                    int length = this.zzcq == null ? 0 : this.zzcq.length;
                    int[] iArr = new int[zzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzcq, 0, iArr, 0, length);
                    }
                    while (length < iArr.length - 1) {
                        iArr[length] = zzbulVar.zzacy();
                        zzbulVar.zzacu();
                        length++;
                    }
                    iArr[length] = zzbulVar.zzacy();
                    this.zzcq = iArr;
                } else if (zzacu == 34) {
                    int zzqj = zzbulVar.zzqj(zzbulVar.zzacD());
                    int position = zzbulVar.getPosition();
                    int i = 0;
                    while (zzbulVar.zzacI() > 0) {
                        zzbulVar.zzacy();
                        i++;
                    }
                    zzbulVar.zzql(position);
                    int length2 = this.zzcq == null ? 0 : this.zzcq.length;
                    int[] iArr2 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzcq, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length) {
                        iArr2[length2] = zzbulVar.zzacy();
                        length2++;
                    }
                    this.zzcq = iArr2;
                    zzbulVar.zzqk(zzqj);
                } else if (zzacu == 40) {
                    this.zzcr = Long.valueOf(zzbulVar.zzacw());
                } else if (!super.zza(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzcn != null) {
                zzv += zzbum.zzf(1, this.zzcn.longValue());
            }
            if (this.zzco != null) {
                zzv += zzbum.zzH(2, this.zzco.intValue());
            }
            if (this.zzcp != null) {
                zzv += zzbum.zzh(3, this.zzcp.booleanValue());
            }
            if (this.zzcq != null && this.zzcq.length > 0) {
                int i = 0;
                for (int i2 = 0; i2 < this.zzcq.length; i2++) {
                    i += zzbum.zzqp(this.zzcq[i2]);
                }
                zzv = zzv + i + (this.zzcq.length * 1);
            }
            return this.zzcr != null ? zzv + zzbum.zze(5, this.zzcr.longValue()) : zzv;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzc extends zzbun<zzc> {
        public byte[] zzcs = null;
        public byte[] zzct = null;

        public zzc() {
            this.zzcsg = -1;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzcs != null) {
                zzbumVar.zzb(1, this.zzcs);
            }
            if (this.zzct != null) {
                zzbumVar.zzb(2, this.zzct);
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzj */
        public zzc zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 10) {
                    this.zzcs = zzbulVar.readBytes();
                } else if (zzacu == 18) {
                    this.zzct = zzbulVar.readBytes();
                } else if (!super.zza(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzcs != null) {
                zzv += zzbum.zzc(1, this.zzcs);
            }
            return this.zzct != null ? zzv + zzbum.zzc(2, this.zzct) : zzv;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzd extends zzbun<zzd> {
        public byte[] data = null;
        public byte[] zzcu = null;
        public byte[] zzcv = null;
        public byte[] zzcw = null;

        public zzd() {
            this.zzcsg = -1;
        }

        public static zzd zze(byte[] bArr) throws zzbus {
            return (zzd) zzbut.zza(new zzd(), bArr);
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.data != null) {
                zzbumVar.zzb(1, this.data);
            }
            if (this.zzcu != null) {
                zzbumVar.zzb(2, this.zzcu);
            }
            if (this.zzcv != null) {
                zzbumVar.zzb(3, this.zzcv);
            }
            if (this.zzcw != null) {
                zzbumVar.zzb(4, this.zzcw);
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzk */
        public zzd zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 10) {
                    this.data = zzbulVar.readBytes();
                } else if (zzacu == 18) {
                    this.zzcu = zzbulVar.readBytes();
                } else if (zzacu == 26) {
                    this.zzcv = zzbulVar.readBytes();
                } else if (zzacu == 34) {
                    this.zzcw = zzbulVar.readBytes();
                } else if (!super.zza(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        protected int zzv() {
            int zzv = super.zzv();
            if (this.data != null) {
                zzv += zzbum.zzc(1, this.data);
            }
            if (this.zzcu != null) {
                zzv += zzbum.zzc(2, this.zzcu);
            }
            if (this.zzcv != null) {
                zzv += zzbum.zzc(3, this.zzcv);
            }
            return this.zzcw != null ? zzv + zzbum.zzc(4, this.zzcw) : zzv;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zze extends zzbun<zze> {
        public Long zzcn = null;
        public String zzcx = null;
        public byte[] zzcy = null;

        public zze() {
            this.zzcsg = -1;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzcn != null) {
                zzbumVar.zzb(1, this.zzcn.longValue());
            }
            if (this.zzcx != null) {
                zzbumVar.zzq(3, this.zzcx);
            }
            if (this.zzcy != null) {
                zzbumVar.zzb(4, this.zzcy);
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzl */
        public zze zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 8) {
                    this.zzcn = Long.valueOf(zzbulVar.zzacx());
                } else if (zzacu == 26) {
                    this.zzcx = zzbulVar.readString();
                } else if (zzacu == 34) {
                    this.zzcy = zzbulVar.readBytes();
                } else if (!super.zza(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzcn != null) {
                zzv += zzbum.zzf(1, this.zzcn.longValue());
            }
            if (this.zzcx != null) {
                zzv += zzbum.zzr(3, this.zzcx);
            }
            return this.zzcy != null ? zzv + zzbum.zzc(4, this.zzcy) : zzv;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzf extends zzbun<zzf> {
        public byte[][] zzcz = zzbuw.zzcso;
        public byte[] zzcu = null;
        public Integer zzcA = null;
        public Integer zzcB = null;

        public zzf() {
            this.zzcsg = -1;
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzcz != null && this.zzcz.length > 0) {
                for (int i = 0; i < this.zzcz.length; i++) {
                    byte[] bArr = this.zzcz[i];
                    if (bArr != null) {
                        zzbumVar.zzb(1, bArr);
                    }
                }
            }
            if (this.zzcu != null) {
                zzbumVar.zzb(2, this.zzcu);
            }
            if (this.zzcA != null) {
                zzbumVar.zzF(3, this.zzcA.intValue());
            }
            if (this.zzcB != null) {
                zzbumVar.zzF(4, this.zzcB.intValue());
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzm */
        public zzf zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 10) {
                    int zzc = zzbuw.zzc(zzbulVar, 10);
                    int length = this.zzcz == null ? 0 : this.zzcz.length;
                    byte[][] bArr = new byte[zzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzcz, 0, bArr, 0, length);
                    }
                    while (length < bArr.length - 1) {
                        bArr[length] = zzbulVar.readBytes();
                        zzbulVar.zzacu();
                        length++;
                    }
                    bArr[length] = zzbulVar.readBytes();
                    this.zzcz = bArr;
                } else if (zzacu == 18) {
                    this.zzcu = zzbulVar.readBytes();
                } else if (zzacu == 24) {
                    int zzacy = zzbulVar.zzacy();
                    switch (zzacy) {
                        case 0:
                        case 1:
                            this.zzcA = Integer.valueOf(zzacy);
                            continue;
                    }
                } else if (zzacu == 32) {
                    int zzacy2 = zzbulVar.zzacy();
                    switch (zzacy2) {
                        case 0:
                        case 1:
                            this.zzcB = Integer.valueOf(zzacy2);
                            continue;
                    }
                } else if (!super.zza(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbun, com.google.android.gms.internal.zzbut
        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzcz != null && this.zzcz.length > 0) {
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < this.zzcz.length; i3++) {
                    byte[] bArr = this.zzcz[i3];
                    if (bArr != null) {
                        i2++;
                        i += zzbum.zzag(bArr);
                    }
                }
                zzv = zzv + i + (i2 * 1);
            }
            if (this.zzcu != null) {
                zzv += zzbum.zzc(2, this.zzcu);
            }
            if (this.zzcA != null) {
                zzv += zzbum.zzH(3, this.zzcA.intValue());
            }
            return this.zzcB != null ? zzv + zzbum.zzH(4, this.zzcB.intValue()) : zzv;
        }
    }

    public zzaf(String str, long j, long j2) {
        this.name = str;
        this.zzbo = j;
        this.time = j2;
    }
}
