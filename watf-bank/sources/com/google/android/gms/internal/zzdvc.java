package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Signature;
/* loaded from: classes.dex */
public final class zzdvc implements zzduv<Signature> {
    @Override // com.google.android.gms.internal.zzduv
    public final /* synthetic */ Signature zzb(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
    }
}
