package com.google.android.gms.internal;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public interface zzfhe extends zzfhg {
    byte[] toByteArray();

    zzfes toByteString();

    void writeTo(OutputStream outputStream) throws IOException;

    void zza(zzffg zzffgVar) throws IOException;

    zzfhk<? extends zzfhe> zzcxm();

    zzfhf zzcxp();

    int zzho();
}
