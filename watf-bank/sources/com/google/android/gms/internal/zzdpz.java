package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public final class zzdpz {
    private static final CopyOnWriteArrayList<zzdpy> zzlsq = new CopyOnWriteArrayList<>();

    public static zzdpy zzof(String str) throws GeneralSecurityException {
        Iterator<zzdpy> it = zzlsq.iterator();
        while (it.hasNext()) {
            zzdpy next = it.next();
            if (next.zzod(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
