package com.google.android.gms.internal;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaiy implements zzakh<zzp, T> {
    private /* synthetic */ zzajb zzdcm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaiy(zzaiv zzaivVar, zzajb zzajbVar) {
        this.zzdcm = zzajbVar;
    }

    @Override // com.google.android.gms.internal.zzakh
    public final /* synthetic */ Object apply(zzp zzpVar) {
        return this.zzdcm.zze(new ByteArrayInputStream(zzpVar.data));
    }
}
