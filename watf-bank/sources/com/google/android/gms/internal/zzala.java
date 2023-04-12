package com.google.android.gms.internal;

import java.util.concurrent.Executor;
@zzzv
/* loaded from: classes.dex */
public final class zzala {
    public static final Executor zzdfe = new zzalb();
    public static final Executor zzdff = new zzalc();
    private static zzakz zzdfg = zza(zzdfe);
    private static zzakz zzdfh = zza(zzdff);

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzald, com.google.android.gms.internal.zzakz] */
    private static zzakz zza(Executor executor) {
        return new zzald(executor, null);
    }
}
