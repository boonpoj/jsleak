package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
/* loaded from: classes.dex */
public final class zzduy implements zzduv<KeyFactory> {
    @Override // com.google.android.gms.internal.zzduv
    public final /* synthetic */ KeyFactory zzb(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
    }
}
