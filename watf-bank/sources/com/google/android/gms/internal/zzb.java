package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzb {

    /* loaded from: assets/classes2.dex */
    public static class zza {
        public byte[] data;
        public String zza;
        public long zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public Map<String, String> zzf = Collections.emptyMap();

        public boolean zza() {
            return this.zzd < System.currentTimeMillis();
        }

        public boolean zzb() {
            return this.zze < System.currentTimeMillis();
        }
    }

    void initialize();

    zzc zza(String str);

    void zza(String str, zzc zzcVar);
}
