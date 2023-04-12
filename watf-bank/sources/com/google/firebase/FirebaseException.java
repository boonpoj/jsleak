package com.google.firebase;

import com.google.android.gms.common.internal.zzbq;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public class FirebaseException extends Exception {
    @Deprecated
    protected FirebaseException() {
    }

    public FirebaseException(String str) {
        super(zzbq.zzh(str, "Detail message must not be empty"));
    }

    public FirebaseException(String str, Throwable th) {
        super(zzbq.zzh(str, "Detail message must not be empty"), th);
    }
}
