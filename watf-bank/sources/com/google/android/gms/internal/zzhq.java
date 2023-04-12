package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public abstract class zzhq {
    private static MessageDigest zzbaa = null;
    protected Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: protected */
    public final MessageDigest zzhd() {
        synchronized (this.mLock) {
            if (zzbaa != null) {
                return zzbaa;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbaa = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                }
            }
            return zzbaa;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] zzy(String str);
}
