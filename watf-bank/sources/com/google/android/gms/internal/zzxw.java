package com.google.android.gms.internal;

import android.content.Context;
@zzzv
/* loaded from: classes.dex */
public abstract class zzxw extends zzagb {
    protected final Context mContext;
    protected final Object mLock;
    protected final zzyb zzcjj;
    protected final zzafp zzcjk;
    protected zzaax zzcjl;
    protected final Object zzcjn;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzxw(Context context, zzafp zzafpVar, zzyb zzybVar) {
        super(true);
        this.mLock = new Object();
        this.zzcjn = new Object();
        this.mContext = context;
        this.zzcjk = zzafpVar;
        this.zzcjl = zzafpVar.zzcxy;
        this.zzcjj = zzybVar;
    }

    @Override // com.google.android.gms.internal.zzagb
    public void onStop() {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033 A[Catch: all -> 0x0060, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x000c, B:21:0x0050, B:22:0x005e, B:8:0x0015, B:13:0x0020, B:15:0x002f, B:17:0x0033, B:18:0x0038, B:20:0x0045, B:19:0x003b, B:14:0x0028), top: B:31:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b A[Catch: all -> 0x0060, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x000c, B:21:0x0050, B:22:0x005e, B:8:0x0015, B:13:0x0020, B:15:0x002f, B:17:0x0033, B:18:0x0038, B:20:0x0045, B:19:0x003b, B:14:0x0028), top: B:31:0x0003, inners: #0 }] */
    @Override // com.google.android.gms.internal.zzagb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzdm() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            java.lang.String r1 = "AdRendererBackgroundTask started."
            com.google.android.gms.internal.zzagf.zzbx(r1)     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.internal.zzafp r1 = r5.zzcjk     // Catch: java.lang.Throwable -> L60
            int r1 = r1.errorCode     // Catch: java.lang.Throwable -> L60
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch: com.google.android.gms.internal.zzxz -> L14 java.lang.Throwable -> L60
            r5.zze(r2)     // Catch: com.google.android.gms.internal.zzxz -> L14 java.lang.Throwable -> L60
            goto L50
        L14:
            r1 = move-exception
            int r2 = r1.getErrorCode()     // Catch: java.lang.Throwable -> L60
            r3 = 3
            if (r2 == r3) goto L28
            r3 = -1
            if (r2 != r3) goto L20
            goto L28
        L20:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.internal.zzagf.zzcu(r1)     // Catch: java.lang.Throwable -> L60
            goto L2f
        L28:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.internal.zzagf.zzct(r1)     // Catch: java.lang.Throwable -> L60
        L2f:
            com.google.android.gms.internal.zzaax r1 = r5.zzcjl     // Catch: java.lang.Throwable -> L60
            if (r1 != 0) goto L3b
            com.google.android.gms.internal.zzaax r1 = new com.google.android.gms.internal.zzaax     // Catch: java.lang.Throwable -> L60
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L60
        L38:
            r5.zzcjl = r1     // Catch: java.lang.Throwable -> L60
            goto L45
        L3b:
            com.google.android.gms.internal.zzaax r1 = new com.google.android.gms.internal.zzaax     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.internal.zzaax r3 = r5.zzcjl     // Catch: java.lang.Throwable -> L60
            long r3 = r3.zzcdq     // Catch: java.lang.Throwable -> L60
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L60
            goto L38
        L45:
            android.os.Handler r1 = com.google.android.gms.internal.zzahn.zzdaw     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.internal.zzxx r3 = new com.google.android.gms.internal.zzxx     // Catch: java.lang.Throwable -> L60
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L60
            r1.post(r3)     // Catch: java.lang.Throwable -> L60
            r1 = r2
        L50:
            com.google.android.gms.internal.zzafo r1 = r5.zzy(r1)     // Catch: java.lang.Throwable -> L60
            android.os.Handler r2 = com.google.android.gms.internal.zzahn.zzdaw     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.internal.zzxy r3 = new com.google.android.gms.internal.zzxy     // Catch: java.lang.Throwable -> L60
            r3.<init>(r5, r1)     // Catch: java.lang.Throwable -> L60
            r2.post(r3)     // Catch: java.lang.Throwable -> L60
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
            return
        L60:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
            goto L64
        L63:
            throw r1
        L64:
            goto L63
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzxw.zzdm():void");
    }

    protected abstract void zze(long j) throws zzxz;

    protected abstract zzafo zzy(int i);
}
