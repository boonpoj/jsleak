package com.google.android.gms.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzal implements zzb {
    private final Map<String, zzam> zzbx;
    private long zzby;
    private final File zzbz;
    private final int zzca;

    public zzal(File file) {
        this(file, 5242880);
    }

    private zzal(File file, int i) {
        this.zzbx = new LinkedHashMap(16, 0.75f, true);
        this.zzby = 0L;
        this.zzbz = file;
        this.zzca = 5242880;
    }

    private final synchronized void remove(String str) {
        boolean delete = zze(str).delete();
        removeEntry(str);
        if (!delete) {
            zzae.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzd(str));
        }
    }

    private final void removeEntry(String str) {
        zzam remove = this.zzbx.remove(str);
        if (remove != null) {
            this.zzby -= remove.zzcb;
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private static InputStream zza(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzan zzanVar) throws IOException {
        return new String(zza(zzanVar, zzc(zzanVar)), "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private final void zza(String str, zzam zzamVar) {
        if (this.zzbx.containsKey(str)) {
            this.zzby += zzamVar.zzcb - this.zzbx.get(str).zzcb;
        } else {
            this.zzby += zzamVar.zzcb;
        }
        this.zzbx.put(str, zzamVar);
    }

    private static byte[] zza(zzan zzanVar, long j) throws IOException {
        long zzn = zzanVar.zzn();
        if (j >= 0 && j <= zzn) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzanVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(zzn);
        throw new IOException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | zza(inputStream) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<zzl> zzb(zzan zzanVar) throws IOException {
        int zzb = zzb((InputStream) zzanVar);
        List<zzl> emptyList = zzb == 0 ? Collections.emptyList() : new ArrayList<>(zzb);
        for (int i = 0; i < zzb; i++) {
            emptyList.add(new zzl(zza(zzanVar).intern(), zza(zzanVar).intern()));
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzc(InputStream inputStream) throws IOException {
        return (zza(inputStream) & 255) | 0 | ((zza(inputStream) & 255) << 8) | ((zza(inputStream) & 255) << 16) | ((zza(inputStream) & 255) << 24) | ((zza(inputStream) & 255) << 32) | ((zza(inputStream) & 255) << 40) | ((zza(inputStream) & 255) << 48) | ((255 & zza(inputStream)) << 56);
    }

    private static String zzd(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final File zze(String str) {
        return new File(this.zzbz, zzd(str));
    }

    @Override // com.google.android.gms.internal.zzb
    public final synchronized void initialize() {
        long length;
        zzan zzanVar;
        if (!this.zzbz.exists()) {
            if (!this.zzbz.mkdirs()) {
                zzae.zzc("Unable to create cache dir %s", this.zzbz.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.zzbz.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                length = file.length();
                zzanVar = new zzan(new BufferedInputStream(zza(file)), length);
            } catch (IOException e) {
                file.delete();
            }
            try {
                zzam zzc = zzam.zzc(zzanVar);
                zzc.zzcb = length;
                zza(zzc.key, zzc);
                zzanVar.close();
            } catch (Throwable th) {
                zzanVar.close();
                throw th;
                break;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzb
    public final synchronized zzc zza(String str) {
        zzam zzamVar = this.zzbx.get(str);
        if (zzamVar == null) {
            return null;
        }
        File zze = zze(str);
        try {
            zzan zzanVar = new zzan(new BufferedInputStream(zza(zze)), zze.length());
            try {
                zzam zzc = zzam.zzc(zzanVar);
                if (!TextUtils.equals(str, zzc.key)) {
                    zzae.zzb("%s: key=%s, found=%s", zze.getAbsolutePath(), str, zzc.key);
                    removeEntry(str);
                    return null;
                }
                byte[] zza = zza(zzanVar, zzanVar.zzn());
                zzc zzcVar = new zzc();
                zzcVar.data = zza;
                zzcVar.zza = zzamVar.zza;
                zzcVar.zzb = zzamVar.zzb;
                zzcVar.zzc = zzamVar.zzc;
                zzcVar.zzd = zzamVar.zzd;
                zzcVar.zze = zzamVar.zze;
                zzcVar.zzf = zzao.zza(zzamVar.zzg);
                zzcVar.zzg = Collections.unmodifiableList(zzamVar.zzg);
                return zzcVar;
            } finally {
                zzanVar.close();
            }
        } catch (IOException e) {
            zzae.zzb("%s: %s", zze.getAbsolutePath(), e.toString());
            remove(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzb
    public final synchronized void zza(String str, zzc zzcVar) {
        long j;
        Iterator<Map.Entry<String, zzam>> it;
        long length = zzcVar.data.length;
        if (this.zzby + length >= this.zzca) {
            if (zzae.DEBUG) {
                zzae.zza("Pruning old cache entries.", new Object[0]);
            }
            long j2 = this.zzby;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, zzam>> it2 = this.zzbx.entrySet().iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    j = j2;
                    break;
                }
                zzam value = it2.next().getValue();
                j = j2;
                if (zze(value.key).delete()) {
                    it = it2;
                    this.zzby -= value.zzcb;
                } else {
                    it = it2;
                    zzae.zzb("Could not delete cache entry for key=%s, filename=%s", value.key, zzd(value.key));
                }
                it.remove();
                i++;
                if (((float) (this.zzby + length)) < this.zzca * 0.9f) {
                    break;
                }
                j2 = j;
                it2 = it;
            }
            if (zzae.DEBUG) {
                zzae.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.zzby - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
        File zze = zze(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(zze));
            zzam zzamVar = new zzam(str, zzcVar);
            if (!zzamVar.zza(bufferedOutputStream)) {
                bufferedOutputStream.close();
                zzae.zzb("Failed to write header for %s", zze.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(zzcVar.data);
            bufferedOutputStream.close();
            zza(str, zzamVar);
        } catch (IOException e) {
            if (zze.delete()) {
                return;
            }
            zzae.zzb("Could not clean up file %s", zze.getAbsolutePath());
        }
    }
}
