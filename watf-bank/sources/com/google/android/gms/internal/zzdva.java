package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public final class zzdva implements zzduv<Mac> {
    @Override // com.google.android.gms.internal.zzduv
    public final /* synthetic */ Mac zzb(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
    }
}
