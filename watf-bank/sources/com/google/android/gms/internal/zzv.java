package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.zzb;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzv {
    private final zzm zzab;
    private final AtomicInteger zzbb;
    private final Set<zzr<?>> zzbc;
    private final PriorityBlockingQueue<zzr<?>> zzbd;
    private final PriorityBlockingQueue<zzr<?>> zzbe;
    private final zzn[] zzbf;
    private final List<Object> zzbg;
    private final com.google.android.gms.internal.zzb zzj;
    private final zzz zzk;
    private zzd zzq;

    /* loaded from: assets/classes2.dex */
    static class zza {
        public String zza;
        public String zzaA;
        public long zzaz;
        public long zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public Map<String, String> zzf;

        private zza() {
        }

        public zza(String str, zzb.zza zzaVar) {
            this.zzaA = str;
            this.zzaz = zzaVar.data.length;
            this.zza = zzaVar.zza;
            this.zzb = zzaVar.zzb;
            this.zzc = zzaVar.zzc;
            this.zzd = zzaVar.zzd;
            this.zze = zzaVar.zze;
            this.zzf = zzaVar.zzf;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zzaVar = new zza();
            if (zzv.zzb(inputStream) == 538247942) {
                zzaVar.zzaA = zzv.zzd(inputStream);
                zzaVar.zza = zzv.zzd(inputStream);
                if (zzaVar.zza.equals("")) {
                    zzaVar.zza = null;
                }
                zzaVar.zzb = zzv.zzc(inputStream);
                zzaVar.zzc = zzv.zzc(inputStream);
                zzaVar.zzd = zzv.zzc(inputStream);
                zzaVar.zze = zzv.zzc(inputStream);
                zzaVar.zzf = zzv.zze(inputStream);
                return zzaVar;
            }
            throw new IOException();
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.zzaA);
                zzv.zza(outputStream, this.zza == null ? "" : this.zza);
                zzv.zza(outputStream, this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(this.zzf, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", new Object[]{e.toString()});
                return false;
            }
        }

        public zzb.zza zzb(byte[] bArr) {
            zzb.zza zzaVar = new zzb.zza();
            zzaVar.data = bArr;
            zzaVar.zza = this.zza;
            zzaVar.zzb = this.zzb;
            zzaVar.zzc = this.zzc;
            zzaVar.zzd = this.zzd;
            zzaVar.zze = this.zze;
            zzaVar.zzf = this.zzf;
            return zzaVar;
        }
    }

    /* loaded from: assets/classes2.dex */
    private static class zzb extends FilterInputStream {
        private int zzaB;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzaB = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.zzaB++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.zzaB += read;
            }
            return read;
        }
    }

    public zzv(com.google.android.gms.internal.zzb zzbVar, zzm zzmVar) {
        this(zzbVar, zzmVar, 4);
    }

    private zzv(com.google.android.gms.internal.zzb zzbVar, zzm zzmVar, int i) {
        this(zzbVar, zzmVar, 4, new zzi(new Handler(Looper.getMainLooper())));
    }

    private zzv(com.google.android.gms.internal.zzb zzbVar, zzm zzmVar, int i, zzz zzzVar) {
        this.zzbb = new AtomicInteger();
        this.zzbc = new HashSet();
        this.zzbd = new PriorityBlockingQueue<>();
        this.zzbe = new PriorityBlockingQueue<>();
        this.zzbg = new ArrayList();
        this.zzj = zzbVar;
        this.zzab = zzmVar;
        this.zzbf = new zzn[4];
        this.zzk = zzzVar;
    }

    public final void start() {
        zzn[] zznVarArr;
        zzd zzdVar = this.zzq;
        if (zzdVar != null) {
            zzdVar.quit();
        }
        for (zzn zznVar : this.zzbf) {
            if (zznVar != null) {
                zznVar.quit();
            }
        }
        this.zzq = new zzd(this.zzbd, this.zzbe, this.zzj, this.zzk);
        this.zzq.start();
        for (int i = 0; i < this.zzbf.length; i++) {
            zzn zznVar2 = new zzn(this.zzbe, this.zzab, this.zzj, this.zzk);
            this.zzbf[i] = zznVar2;
            zznVar2.start();
        }
    }

    public final <T> zzr<T> zze(zzr<T> zzrVar) {
        zzrVar.zza(this);
        synchronized (this.zzbc) {
            this.zzbc.add(zzrVar);
        }
        zzrVar.zza(this.zzbb.incrementAndGet());
        zzrVar.zzb("add-to-queue");
        (!zzrVar.zzg() ? this.zzbe : this.zzbd).add(zzrVar);
        return zzrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> void zzf(zzr<T> zzrVar) {
        synchronized (this.zzbc) {
            this.zzbc.remove(zzrVar);
        }
        synchronized (this.zzbg) {
            Iterator<Object> it = this.zzbg.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
