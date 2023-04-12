package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: assets/classes2.dex */
public class zzayd {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String zzbCt = "*gcore*:";
    private final Context mContext;
    private final String zzaGw;
    private final String zzaGy;
    private final PowerManager.WakeLock zzbCu;
    private final int zzbCv;
    private final String zzbCw;
    private boolean zzbCx;
    private int zzbCy;
    private int zzbCz;
    private WorkSource zzbiJ;

    public zzayd(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzayd(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzayd(Context context, int i, String str, String str2, String str3, String str4) {
        this.zzbCx = true;
        com.google.android.gms.common.internal.zzac.zzh(str, "Wake lock name can NOT be empty");
        this.zzbCv = i;
        this.zzbCw = str2;
        this.zzaGy = str4;
        this.mContext = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.zzaGw = str;
        } else {
            String valueOf = String.valueOf(zzbCt);
            String valueOf2 = String.valueOf(str);
            this.zzaGw = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.zzbCu = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (com.google.android.gms.common.util.zzy.zzaO(this.mContext)) {
            this.zzbiJ = com.google.android.gms.common.util.zzy.zzy(context, com.google.android.gms.common.util.zzv.zzdD(str3) ? context.getPackageName() : str3);
            zzc(this.zzbiJ);
        }
    }

    private void zzd(WorkSource workSource) {
        try {
            this.zzbCu.setWorkSource(workSource);
        } catch (IllegalArgumentException e) {
            Log.wtf(TAG, e.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r11.zzbCz == 1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r0 == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void zzgP(java.lang.String r12) {
        /*
            r11 = this;
            boolean r0 = r11.zzgQ(r12)
            java.lang.String r6 = r11.zzo(r12, r0)
            monitor-enter(r11)
            boolean r12 = r11.zzbCx     // Catch: java.lang.Throwable -> L43
            r10 = 1
            if (r12 == 0) goto L17
            int r12 = r11.zzbCy     // Catch: java.lang.Throwable -> L43
            int r12 = r12 - r10
            r11.zzbCy = r12     // Catch: java.lang.Throwable -> L43
            if (r12 == 0) goto L1f
            if (r0 != 0) goto L1f
        L17:
            boolean r12 = r11.zzbCx     // Catch: java.lang.Throwable -> L43
            if (r12 != 0) goto L41
            int r12 = r11.zzbCz     // Catch: java.lang.Throwable -> L43
            if (r12 != r10) goto L41
        L1f:
            com.google.android.gms.common.stats.zzg r1 = com.google.android.gms.common.stats.zzg.zzyr()     // Catch: java.lang.Throwable -> L43
            android.content.Context r2 = r11.mContext     // Catch: java.lang.Throwable -> L43
            android.os.PowerManager$WakeLock r12 = r11.zzbCu     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = com.google.android.gms.common.stats.zze.zza(r12, r6)     // Catch: java.lang.Throwable -> L43
            r4 = 8
            java.lang.String r5 = r11.zzaGw     // Catch: java.lang.Throwable -> L43
            java.lang.String r7 = r11.zzaGy     // Catch: java.lang.Throwable -> L43
            int r8 = r11.zzbCv     // Catch: java.lang.Throwable -> L43
            android.os.WorkSource r12 = r11.zzbiJ     // Catch: java.lang.Throwable -> L43
            java.util.List r9 = com.google.android.gms.common.util.zzy.zzb(r12)     // Catch: java.lang.Throwable -> L43
            r1.zza(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L43
            int r12 = r11.zzbCz     // Catch: java.lang.Throwable -> L43
            int r12 = r12 - r10
            r11.zzbCz = r12     // Catch: java.lang.Throwable -> L43
        L41:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L43
            return
        L43:
            r12 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L43
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzayd.zzgP(java.lang.String):void");
    }

    private boolean zzgQ(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.zzbCw)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r12.zzbCz == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r0 == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void zzm(java.lang.String r13, long r14) {
        /*
            r12 = this;
            boolean r0 = r12.zzgQ(r13)
            java.lang.String r6 = r12.zzo(r13, r0)
            monitor-enter(r12)
            boolean r13 = r12.zzbCx     // Catch: java.lang.Throwable -> L44
            if (r13 == 0) goto L17
            int r13 = r12.zzbCy     // Catch: java.lang.Throwable -> L44
            int r1 = r13 + 1
            r12.zzbCy = r1     // Catch: java.lang.Throwable -> L44
            if (r13 == 0) goto L1f
            if (r0 != 0) goto L1f
        L17:
            boolean r13 = r12.zzbCx     // Catch: java.lang.Throwable -> L44
            if (r13 != 0) goto L42
            int r13 = r12.zzbCz     // Catch: java.lang.Throwable -> L44
            if (r13 != 0) goto L42
        L1f:
            com.google.android.gms.common.stats.zzg r1 = com.google.android.gms.common.stats.zzg.zzyr()     // Catch: java.lang.Throwable -> L44
            android.content.Context r2 = r12.mContext     // Catch: java.lang.Throwable -> L44
            android.os.PowerManager$WakeLock r13 = r12.zzbCu     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = com.google.android.gms.common.stats.zze.zza(r13, r6)     // Catch: java.lang.Throwable -> L44
            r4 = 7
            java.lang.String r5 = r12.zzaGw     // Catch: java.lang.Throwable -> L44
            java.lang.String r7 = r12.zzaGy     // Catch: java.lang.Throwable -> L44
            int r8 = r12.zzbCv     // Catch: java.lang.Throwable -> L44
            android.os.WorkSource r13 = r12.zzbiJ     // Catch: java.lang.Throwable -> L44
            java.util.List r9 = com.google.android.gms.common.util.zzy.zzb(r13)     // Catch: java.lang.Throwable -> L44
            r10 = r14
            r1.zza(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L44
            int r13 = r12.zzbCz     // Catch: java.lang.Throwable -> L44
            int r13 = r13 + 1
            r12.zzbCz = r13     // Catch: java.lang.Throwable -> L44
        L42:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L44
            return
        L44:
            r13 = move-exception
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L44
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzayd.zzm(java.lang.String, long):void");
    }

    private String zzo(String str, boolean z) {
        return (this.zzbCx && z) ? str : this.zzbCw;
    }

    public void acquire(long j) {
        if (!com.google.android.gms.common.util.zzs.zzyA() && this.zzbCx) {
            String str = TAG;
            String valueOf = String.valueOf(this.zzaGw);
            Log.wtf(str, valueOf.length() != 0 ? "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ".concat(valueOf) : new String("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: "));
        }
        zzm(null, j);
        this.zzbCu.acquire(j);
    }

    public boolean isHeld() {
        return this.zzbCu.isHeld();
    }

    public void release() {
        zzgP(null);
        this.zzbCu.release();
    }

    public void setReferenceCounted(boolean z) {
        this.zzbCu.setReferenceCounted(z);
        this.zzbCx = z;
    }

    public void zzc(WorkSource workSource) {
        if (workSource == null || !com.google.android.gms.common.util.zzy.zzaO(this.mContext)) {
            return;
        }
        if (this.zzbiJ != null) {
            this.zzbiJ.add(workSource);
        } else {
            this.zzbiJ = workSource;
        }
        zzd(this.zzbiJ);
    }
}
