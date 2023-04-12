package com.google.android.gms.internal;

import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzabk implements Runnable {
    private /* synthetic */ OutputStream zzcqb;
    private /* synthetic */ byte[] zzcqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabk(zzabj zzabjVar, OutputStream outputStream, byte[] bArr) {
        this.zzcqb = outputStream;
        this.zzcqc = bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.DataOutputStream, java.io.Closeable] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r5 = this;
            r0 = 0
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
            java.io.OutputStream r2 = r5.zzcqb     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
            byte[] r0 = r5.zzcqc     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L3c
            int r0 = r0.length     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L3c
            r1.writeInt(r0)     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L3c
            byte[] r0 = r5.zzcqc     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L3c
            r1.write(r0)     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L3c
            com.google.android.gms.common.util.zzn.closeQuietly(r1)
            return
        L17:
            r0 = move-exception
            goto L22
        L19:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L3d
        L1e:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L22:
            java.lang.String r2 = "Error transporting the ad response"
            com.google.android.gms.internal.zzagf.zzb(r2, r0)     // Catch: java.lang.Throwable -> L3c
            com.google.android.gms.internal.zzaft r2 = com.google.android.gms.ads.internal.zzbs.zzem()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = "LargeParcelTeleporter.pipeData.1"
            r2.zza(r0, r3)     // Catch: java.lang.Throwable -> L3c
            if (r1 != 0) goto L38
            java.io.OutputStream r0 = r5.zzcqb
            com.google.android.gms.common.util.zzn.closeQuietly(r0)
            return
        L38:
            com.google.android.gms.common.util.zzn.closeQuietly(r1)
            return
        L3c:
            r0 = move-exception
        L3d:
            if (r1 != 0) goto L41
            java.io.OutputStream r1 = r5.zzcqb
        L41:
            com.google.android.gms.common.util.zzn.closeQuietly(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzabk.run():void");
    }
}
