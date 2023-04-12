package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class zzdqf implements zzdpq {
    @Override // com.google.android.gms.internal.zzdpq
    public final zzdpw zzd(String str, String str2, int i) throws GeneralSecurityException {
        zzdpw zzdqhVar;
        String lowerCase = str2.toLowerCase();
        char c = 65535;
        if (((lowerCase.hashCode() == 2989895 && lowerCase.equals("aead")) ? (char) 0 : (char) 65535) == 0) {
            switch (str.hashCode()) {
                case 360753376:
                    if (str.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1215885937:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1469984853:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1797113348:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1855890991:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2079211877:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                zzdqhVar = new zzdqh();
            } else if (c == 1) {
                zzdqhVar = new zzdqj();
            } else if (c == 2) {
                zzdqhVar = new zzdqk();
            } else if (c == 3) {
                zzdqhVar = new zzdql();
            } else if (c == 4) {
                zzdqhVar = new zzdqm();
            } else if (c != 5) {
                throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", str));
            } else {
                zzdqhVar = new zzdqo();
            }
            if (i <= 0) {
                return zzdqhVar;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i)));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
    }
}
