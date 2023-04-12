package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class zzdqr implements zzdpq {
    @Override // com.google.android.gms.internal.zzdpq
    public final zzdpw zzd(String str, String str2, int i) throws GeneralSecurityException {
        char c;
        zzdpw zzdqpVar;
        String lowerCase = str2.toLowerCase();
        int hashCode = lowerCase.hashCode();
        char c2 = 65535;
        if (hashCode != 275448849) {
            if (hashCode == 1420614889 && lowerCase.equals("hybridencrypt")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (lowerCase.equals("hybriddecrypt")) {
                c = 0;
            }
            c = 65535;
        }
        if (c == 0) {
            if (str.hashCode() == -80133005 && str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
                c2 = 0;
            }
            if (c2 != 0) {
                throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", str));
            }
            zzdqpVar = new zzdqp();
        } else if (c != 1) {
            throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
        } else {
            if (str.hashCode() == 396454335 && str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                c2 = 0;
            }
            if (c2 != 0) {
                throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", str));
            }
            zzdqpVar = new zzdqq();
        }
        if (i <= 0) {
            return zzdqpVar;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i)));
    }
}
