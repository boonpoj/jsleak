package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.KeyAgreement;
/* loaded from: classes.dex */
public final class zzdux implements zzduv<KeyAgreement> {
    @Override // com.google.android.gms.internal.zzduv
    public final /* synthetic */ KeyAgreement zzb(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
    }
}
