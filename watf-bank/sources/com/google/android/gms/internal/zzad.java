package com.google.android.gms.internal;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public class zzad extends Exception {
    private long zzae;
    private zzp zzbk;

    /* loaded from: assets/classes2.dex */
    public static final class zza extends zzbut {
        public zzb zzaJ;
        public zzc zzaK;

        public zza() {
            zzu();
        }

        public static zza zzc(byte[] bArr) throws zzbus {
            return (zza) zzbut.zza(new zza(), bArr);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zza */
        public zza zzb(zzbul zzbulVar) throws IOException {
            zzbut zzbutVar;
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 10) {
                    if (this.zzaJ == null) {
                        this.zzaJ = new zzb();
                    }
                    zzbutVar = this.zzaJ;
                } else if (zzacu == 18) {
                    if (this.zzaK == null) {
                        this.zzaK = new zzc();
                    }
                    zzbutVar = this.zzaK;
                } else if (!zzbuw.zzb(zzbulVar, zzacu)) {
                    return this;
                }
                zzbulVar.zza(zzbutVar);
            }
        }

        @Override // com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzaJ != null) {
                zzbumVar.zza(1, this.zzaJ);
            }
            if (this.zzaK != null) {
                zzbumVar.zza(2, this.zzaK);
            }
            super.zza(zzbumVar);
        }

        public zza zzu() {
            this.zzaJ = null;
            this.zzaK = null;
            this.zzcsg = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzbut
        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzaJ != null) {
                zzv += zzbum.zzc(1, this.zzaJ);
            }
            return this.zzaK != null ? zzv + zzbum.zzc(2, this.zzaK) : zzv;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzb extends zzbut {
        public Integer zzaL;

        public zzb() {
            zzw();
        }

        @Override // com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzaL != null) {
                zzbumVar.zzF(27, this.zzaL.intValue());
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzc */
        public zzb zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 216) {
                    int zzacy = zzbulVar.zzacy();
                    switch (zzacy) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.zzaL = Integer.valueOf(zzacy);
                            continue;
                    }
                } else if (!zzbuw.zzb(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbut
        protected int zzv() {
            int zzv = super.zzv();
            return this.zzaL != null ? zzv + zzbum.zzH(27, this.zzaL.intValue()) : zzv;
        }

        public zzb zzw() {
            this.zzcsg = -1;
            return this;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzc extends zzbut {
        public String zzaM;
        public String zzaN;
        public String zzaO;
        public String zzaP;
        public String zzaQ;

        public zzc() {
            zzx();
        }

        @Override // com.google.android.gms.internal.zzbut
        public void zza(zzbum zzbumVar) throws IOException {
            if (this.zzaM != null) {
                zzbumVar.zzq(1, this.zzaM);
            }
            if (this.zzaN != null) {
                zzbumVar.zzq(2, this.zzaN);
            }
            if (this.zzaO != null) {
                zzbumVar.zzq(3, this.zzaO);
            }
            if (this.zzaP != null) {
                zzbumVar.zzq(4, this.zzaP);
            }
            if (this.zzaQ != null) {
                zzbumVar.zzq(5, this.zzaQ);
            }
            super.zza(zzbumVar);
        }

        @Override // com.google.android.gms.internal.zzbut
        /* renamed from: zzd */
        public zzc zzb(zzbul zzbulVar) throws IOException {
            while (true) {
                int zzacu = zzbulVar.zzacu();
                if (zzacu == 0) {
                    return this;
                }
                if (zzacu == 10) {
                    this.zzaM = zzbulVar.readString();
                } else if (zzacu == 18) {
                    this.zzaN = zzbulVar.readString();
                } else if (zzacu == 26) {
                    this.zzaO = zzbulVar.readString();
                } else if (zzacu == 34) {
                    this.zzaP = zzbulVar.readString();
                } else if (zzacu == 42) {
                    this.zzaQ = zzbulVar.readString();
                } else if (!zzbuw.zzb(zzbulVar, zzacu)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzbut
        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzaM != null) {
                zzv += zzbum.zzr(1, this.zzaM);
            }
            if (this.zzaN != null) {
                zzv += zzbum.zzr(2, this.zzaN);
            }
            if (this.zzaO != null) {
                zzv += zzbum.zzr(3, this.zzaO);
            }
            if (this.zzaP != null) {
                zzv += zzbum.zzr(4, this.zzaP);
            }
            return this.zzaQ != null ? zzv + zzbum.zzr(5, this.zzaQ) : zzv;
        }

        public zzc zzx() {
            this.zzaM = null;
            this.zzaN = null;
            this.zzaO = null;
            this.zzaP = null;
            this.zzaQ = null;
            this.zzcsg = -1;
            return this;
        }
    }

    public zzad() {
        this.zzbk = null;
    }

    public zzad(zzp zzpVar) {
        this.zzbk = zzpVar;
    }

    public zzad(String str) {
        super(str);
        this.zzbk = null;
    }

    public zzad(Throwable th) {
        super(th);
        this.zzbk = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzae = j;
    }
}
