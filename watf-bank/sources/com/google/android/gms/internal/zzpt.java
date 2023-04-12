package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzpt extends NativeAd.Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzbtr;
    private final zzpq zzbwd;

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:2|3)|(9:5|6|7|8|9|10|11|12|13)|22|6|7|8|9|10|11|12|13) */
    /* JADX WARN: Can't wrap try/catch for region: R(13:1|2|3|(9:5|6|7|8|9|10|11|12|13)|22|6|7|8|9|10|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        com.google.android.gms.internal.zzakb.zzb("Failed to get uri.", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
        com.google.android.gms.internal.zzakb.zzb("Failed to get scale.", r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzpt(com.google.android.gms.internal.zzpq r4) {
        /*
            r3 = this;
            r3.<init>()
            r3.zzbwd = r4
            r4 = 0
            com.google.android.gms.internal.zzpq r0 = r3.zzbwd     // Catch: android.os.RemoteException -> L15
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzjr()     // Catch: android.os.RemoteException -> L15
            if (r0 == 0) goto L1b
            java.lang.Object r0 = com.google.android.gms.dynamic.zzn.zzx(r0)     // Catch: android.os.RemoteException -> L15
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0     // Catch: android.os.RemoteException -> L15
            goto L1c
        L15:
            r0 = move-exception
            java.lang.String r1 = "Failed to get drawable."
            com.google.android.gms.internal.zzakb.zzb(r1, r0)
        L1b:
            r0 = r4
        L1c:
            r3.mDrawable = r0
            com.google.android.gms.internal.zzpq r0 = r3.zzbwd     // Catch: android.os.RemoteException -> L25
            android.net.Uri r4 = r0.getUri()     // Catch: android.os.RemoteException -> L25
            goto L2b
        L25:
            r0 = move-exception
            java.lang.String r1 = "Failed to get uri."
            com.google.android.gms.internal.zzakb.zzb(r1, r0)
        L2b:
            r3.mUri = r4
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            com.google.android.gms.internal.zzpq r4 = r3.zzbwd     // Catch: android.os.RemoteException -> L36
            double r0 = r4.getScale()     // Catch: android.os.RemoteException -> L36
            goto L3c
        L36:
            r4 = move-exception
            java.lang.String r2 = "Failed to get scale."
            com.google.android.gms.internal.zzakb.zzb(r2, r4)
        L3c:
            r3.zzbtr = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpt.<init>(com.google.android.gms.internal.zzpq):void");
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.zzbtr;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.mUri;
    }
}
