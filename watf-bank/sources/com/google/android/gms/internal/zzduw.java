package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public final class zzduw implements zzduv<Cipher> {
    @Override // com.google.android.gms.internal.zzduv
    public final /* synthetic */ Cipher zzb(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
    }
}
