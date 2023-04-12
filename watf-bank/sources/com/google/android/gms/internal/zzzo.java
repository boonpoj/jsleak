package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzzo implements zzaki<zzanh> {

    /* loaded from: assets/classes2.dex */
    static class zza {
        final ContentResolver mContentResolver;

        zza(Context context) {
            if (context == null || !zzaj(context)) {
                this.mContentResolver = null;
                return;
            }
            this.mContentResolver = context.getContentResolver();
            zzbii.zzb(this.mContentResolver, "gms:playlog:service:sampling_");
        }

        private static boolean zzaj(Context context) {
            if (zzzo.zzawQ == null) {
                zzzo.zzawQ = Boolean.valueOf(context.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
            }
            return zzzo.zzawQ.booleanValue();
        }

        String zzda(String str) {
            if (this.mContentResolver == null) {
                return null;
            }
            ContentResolver contentResolver = this.mContentResolver;
            String valueOf = String.valueOf("gms:playlog:service:sampling_");
            String valueOf2 = String.valueOf(str);
            return zzbii.zza(contentResolver, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) null);
        }

        long zzux() {
            if (this.mContentResolver == null) {
                return 0L;
            }
            return zzbii.getLong(this.mContentResolver, "android_id", 0L);
        }
    }

    /* loaded from: assets/classes2.dex */
    static class zzb {
        public final String zzawS;
        public final long zzawT;
        public final long zzawU;

        public zzb(String str, long j, long j2) {
            this.zzawS = str;
            this.zzawT = j;
            this.zzawU = j2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zzb) {
                zzb zzbVar = (zzb) obj;
                return com.google.android.gms.common.internal.zzaa.equal(this.zzawS, zzbVar.zzawS) && com.google.android.gms.common.internal.zzaa.equal(Long.valueOf(this.zzawT), Long.valueOf(zzbVar.zzawT)) && com.google.android.gms.common.internal.zzaa.equal(Long.valueOf(this.zzawU), Long.valueOf(zzbVar.zzawU));
            }
            return false;
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.zzaa.hashCode(new Object[]{this.zzawS, Long.valueOf(this.zzawT), Long.valueOf(this.zzawU)});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzo(zzzf zzzfVar) {
    }

    @Override // com.google.android.gms.internal.zzaki
    public final /* synthetic */ void onSuccess(zzanh zzanhVar) {
        zzanhVar.destroy();
    }

    @Override // com.google.android.gms.internal.zzaki
    public final void zzb(Throwable th) {
    }
}
