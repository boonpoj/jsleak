package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdtf;
/* loaded from: classes.dex */
public final class zzdpr {
    public static zzdtf zza(String str, String str2, String str3, int i, boolean z) {
        zzdtf.zza zzom = zzdtf.zzboz().zzom(str2);
        String valueOf = String.valueOf(str3);
        return zzom.zzon(valueOf.length() != 0 ? "type.googleapis.com/google.crypto.tink.".concat(valueOf) : new String("type.googleapis.com/google.crypto.tink.")).zzfw(0).zzcc(true).zzoo(str).zzcxt();
    }
}
