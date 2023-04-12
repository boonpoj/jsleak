package com.google.android.gms.internal;

import java.security.SecureRandom;
/* loaded from: classes.dex */
public final class zzdvi {
    private static final SecureRandom zzmad = new SecureRandom();

    public static byte[] zzgh(int i) {
        byte[] bArr = new byte[i];
        zzmad.nextBytes(bArr);
        return bArr;
    }
}
