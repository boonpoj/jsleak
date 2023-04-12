package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzae;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzs implements Runnable {
    private /* synthetic */ String zzat;
    private /* synthetic */ long zzau;
    private /* synthetic */ zzr zzav;

    /* loaded from: assets/classes2.dex */
    static class zza {
        public static final boolean zzai = zzs.DEBUG;
        private final List<C0078zza> zzaj = new ArrayList();
        private boolean zzak = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zzs$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        public static class C0078zza {
            public final String name;
            public final long time;
            public final long zzal;

            public C0078zza(String str, long j, long j2) {
                this.name = str;
                this.zzal = j;
                this.time = j2;
            }
        }

        zza() {
        }

        private long getTotalDuration() {
            if (this.zzaj.size() == 0) {
                return 0L;
            }
            return this.zzaj.get(this.zzaj.size() - 1).time - this.zzaj.get(0).time;
        }

        protected void finalize() throws Throwable {
            if (this.zzak) {
                return;
            }
            zzd("Request on the loose");
            zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void zza(String str, long j) {
            if (this.zzak) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.zzaj.add(new C0078zza(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void zzd(String str) {
            this.zzak = true;
            long totalDuration = getTotalDuration();
            if (totalDuration <= 0) {
                return;
            }
            long j = this.zzaj.get(0).time;
            zzs.zzb("(%-4d ms) %s", new Object[]{Long.valueOf(totalDuration), str});
            for (C0078zza c0078zza : this.zzaj) {
                long j2 = c0078zza.time;
                zzs.zzb("(+%-4d) [%2d] %s", new Object[]{Long.valueOf(j2 - j), Long.valueOf(c0078zza.zzal), c0078zza.name});
                j = j2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(zzr zzrVar, String str, long j) {
        this.zzav = zzrVar;
        this.zzat = str;
        this.zzau = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzae.zza zzaVar;
        zzae.zza zzaVar2;
        zzaVar = this.zzav.zzaf;
        zzaVar.zza(this.zzat, this.zzau);
        zzaVar2 = this.zzav.zzaf;
        zzaVar2.zzc(toString());
    }
}
