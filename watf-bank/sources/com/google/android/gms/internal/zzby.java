package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzby implements Runnable {
    private zzby() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzby(zzbx zzbxVar) {
        this();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzbw.zza(MessageDigest.getInstance("MD5"));
        } catch (NoSuchAlgorithmException e) {
        } catch (Throwable th) {
            zzbw.zzza.countDown();
            throw th;
        }
        zzbw.zzza.countDown();
    }
}
