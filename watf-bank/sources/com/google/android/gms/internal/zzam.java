package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzam {
    final String key;
    final String zza;
    final long zzb;
    final long zzc;
    long zzcb;
    final long zzd;
    final long zze;
    final List<zzl> zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzam(String str, zzc zzcVar) {
        this(str, zzcVar.zza, zzcVar.zzb, zzcVar.zzc, zzcVar.zzd, zzcVar.zze, zzcVar.zzg != null ? zzcVar.zzg : zzao.zza(zzcVar.zzf));
        this.zzcb = zzcVar.data.length;
    }

    private zzam(String str, String str2, long j, long j2, long j3, long j4, List<zzl> list) {
        this.key = str;
        this.zza = "".equals(str2) ? null : str2;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzg = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzam zzc(zzan zzanVar) throws IOException {
        if (zzal.zzb((InputStream) zzanVar) == 538247942) {
            return new zzam(zzal.zza(zzanVar), zzal.zza(zzanVar), zzal.zzc(zzanVar), zzal.zzc(zzanVar), zzal.zzc(zzanVar), zzal.zzc(zzanVar), zzal.zzb(zzanVar));
        }
        throw new IOException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(OutputStream outputStream) {
        try {
            zzal.zza(outputStream, 538247942);
            zzal.zza(outputStream, this.key);
            zzal.zza(outputStream, this.zza == null ? "" : this.zza);
            zzal.zza(outputStream, this.zzb);
            zzal.zza(outputStream, this.zzc);
            zzal.zza(outputStream, this.zzd);
            zzal.zza(outputStream, this.zze);
            List<zzl> list = this.zzg;
            if (list != null) {
                zzal.zza(outputStream, list.size());
                for (zzl zzlVar : list) {
                    zzal.zza(outputStream, zzlVar.getName());
                    zzal.zza(outputStream, zzlVar.getValue());
                }
            } else {
                zzal.zza(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzae.zzb("%s", e.toString());
            return false;
        }
    }
}
