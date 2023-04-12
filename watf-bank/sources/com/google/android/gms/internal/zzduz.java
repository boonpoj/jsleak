package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.Provider;
/* loaded from: classes.dex */
public final class zzduz implements zzduv<KeyPairGenerator> {
    @Override // com.google.android.gms.internal.zzduv
    public final /* synthetic */ KeyPairGenerator zzb(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
    }
}
