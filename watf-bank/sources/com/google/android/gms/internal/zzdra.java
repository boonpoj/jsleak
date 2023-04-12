package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class zzdra implements zzdpq {
    @Override // com.google.android.gms.internal.zzdpq
    public final zzdpw zzd(String str, String str2, int i) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        char c = 65535;
        if (((lowerCase.hashCode() == 107855 && lowerCase.equals("mac")) ? (char) 0 : (char) 65535) == 0) {
            if (str.hashCode() == 836622442 && str.equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
                c = 0;
            }
            if (c == 0) {
                zzdqy zzdqyVar = new zzdqy();
                if (i <= 0) {
                    return zzdqyVar;
                }
                throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i)));
            }
            throw new GeneralSecurityException(String.format("No support for primitive 'Mac' with key type '%s'.", str));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
    }
}
