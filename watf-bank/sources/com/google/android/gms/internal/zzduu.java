package com.google.android.gms.internal;

import com.google.android.gms.internal.zzduv;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public final class zzduu<T_WRAPPER extends zzduv<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzduu.class.getName());
    private static final List<Provider> zzlzo;
    public static final zzduu<zzduw, Cipher> zzlzp;
    public static final zzduu<zzdva, Mac> zzlzq;
    private static zzduu<zzdvc, Signature> zzlzr;
    private static zzduu<zzdvb, MessageDigest> zzlzs;
    public static final zzduu<zzdux, KeyAgreement> zzlzt;
    public static final zzduu<zzduz, KeyPairGenerator> zzlzu;
    private static zzduu<zzduy, KeyFactory> zzlzv;
    private T_WRAPPER zzlzw;
    private List<Provider> zzlzx = zzlzo;
    private boolean zzlzy = true;

    static {
        if (zzdvj.zzajk()) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            zzlzo = arrayList;
        } else {
            zzlzo = new ArrayList();
        }
        zzlzp = new zzduu<>(new zzduw());
        zzlzq = new zzduu<>(new zzdva());
        zzlzr = new zzduu<>(new zzdvc());
        zzlzs = new zzduu<>(new zzdvb());
        zzlzt = new zzduu<>(new zzdux());
        zzlzu = new zzduu<>(new zzduz());
        zzlzv = new zzduu<>(new zzduy());
    }

    private zzduu(T_WRAPPER t_wrapper) {
        this.zzlzw = t_wrapper;
    }

    private final boolean zza(String str, Provider provider) {
        try {
            this.zzlzw.zzb(str, provider);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
        return (T_ENGINE) r0.zzb(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T_ENGINE zzos(java.lang.String r4) throws java.security.GeneralSecurityException {
        /*
            r3 = this;
            java.util.List<java.security.Provider> r0 = r3.zzlzx
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L1f
            java.lang.Object r1 = r0.next()
            java.security.Provider r1 = (java.security.Provider) r1
            boolean r2 = r3.zza(r4, r1)
            if (r2 == 0) goto L6
            T_WRAPPER extends com.google.android.gms.internal.zzduv<T_ENGINE> r0 = r3.zzlzw
        L1a:
            java.lang.Object r4 = r0.zzb(r4, r1)
            return r4
        L1f:
            boolean r0 = r3.zzlzy
            if (r0 == 0) goto L27
            T_WRAPPER extends com.google.android.gms.internal.zzduv<T_ENGINE> r0 = r3.zzlzw
            r1 = 0
            goto L1a
        L27:
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException
            java.lang.String r0 = "No good Provider found."
            r4.<init>(r0)
            goto L30
        L2f:
            throw r4
        L30:
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzduu.zzos(java.lang.String):java.lang.Object");
    }
}
