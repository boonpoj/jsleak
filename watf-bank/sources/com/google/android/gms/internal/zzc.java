package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzc {
    public byte[] data;
    public String zza;
    public long zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public Map<String, String> zzf = Collections.emptyMap();
    public List<zzl> zzg;

    /* renamed from: com.google.android.gms.internal.zzc$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzk zzl;

        AnonymousClass1(zzk zzkVar) {
            this.zzl = zzkVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzc.zza(zzc.this).put(this.zzl);
            } catch (InterruptedException unused) {
            }
        }
    }

    public final boolean zza() {
        return this.zzd < System.currentTimeMillis();
    }
}
