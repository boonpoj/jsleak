package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
/* loaded from: classes.dex */
public final class zzdvb implements zzduv<MessageDigest> {
    @Override // com.google.android.gms.internal.zzduv
    public final /* synthetic */ MessageDigest zzb(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
    }
}
