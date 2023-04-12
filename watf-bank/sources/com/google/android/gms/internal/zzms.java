package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.OutputStream;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzms implements Parcelable.Creator<zzmr> {

    /* renamed from: com.google.android.gms.internal.zzms$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ OutputStream zzSq;
        final /* synthetic */ byte[] zzSr;

        AnonymousClass1(zzms zzmsVar, OutputStream outputStream, byte[] bArr) {
            this.zzSq = outputStream;
            this.zzSr = bArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10, types: [java.io.DataOutputStream] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                r0 = 0
                java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L1b
                java.io.OutputStream r2 = r5.zzSq     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L1b
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L1b
                byte[] r0 = r5.zzSr     // Catch: java.io.IOException -> L14 java.lang.Throwable -> L39
                int r0 = r0.length     // Catch: java.io.IOException -> L14 java.lang.Throwable -> L39
                r1.writeInt(r0)     // Catch: java.io.IOException -> L14 java.lang.Throwable -> L39
                byte[] r0 = r5.zzSr     // Catch: java.io.IOException -> L14 java.lang.Throwable -> L39
                r1.write(r0)     // Catch: java.io.IOException -> L14 java.lang.Throwable -> L39
                goto L35
            L14:
                r0 = move-exception
                goto L1f
            L16:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
                goto L3a
            L1b:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
            L1f:
                java.lang.String r2 = "Error transporting the ad response"
                com.google.android.gms.internal.zzpe.zzb(r2, r0)     // Catch: java.lang.Throwable -> L39
                com.google.android.gms.internal.zzoy r2 = com.google.android.gms.ads.internal.zzv.zzcN()     // Catch: java.lang.Throwable -> L39
                java.lang.String r3 = "LargeParcelTeleporter.pipeData.1"
                r2.zza(r0, r3)     // Catch: java.lang.Throwable -> L39
                if (r1 != 0) goto L35
                java.io.OutputStream r0 = r5.zzSq
                com.google.android.gms.common.util.zzo.zzb(r0)
                goto L38
            L35:
                com.google.android.gms.common.util.zzo.zzb(r1)
            L38:
                return
            L39:
                r0 = move-exception
            L3a:
                if (r1 != 0) goto L3e
                java.io.OutputStream r1 = r5.zzSq
            L3e:
                com.google.android.gms.common.util.zzo.zzb(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzms.AnonymousClass1.run():void");
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmr createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 2) {
                z = zzbfn.zzc(parcel, readInt);
            } else if (i == 3) {
                z2 = zzbfn.zzc(parcel, readInt);
            } else if (i != 4) {
                zzbfn.zzb(parcel, readInt);
            } else {
                z3 = zzbfn.zzc(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzmr(z, z2, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmr[] newArray(int i) {
        return new zzmr[i];
    }
}
