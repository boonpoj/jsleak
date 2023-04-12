package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
public final class zzdrb {
    public static final zzdtv zzlta = zzdtv.zzbqg().zzor("TINK_MAC_1_0_0").zzb(zzdpr.zza("TinkMac", "Mac", "HmacKey", 0, true)).zzcxt();

    static {
        try {
            zzbly();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zzbly() throws GeneralSecurityException {
        zzdqe.zza("TinkMac", new zzdra());
    }
}
