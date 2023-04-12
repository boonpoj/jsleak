package com.google.android.gms.internal;

import java.util.Map;
/* loaded from: classes.dex */
public final class zzajd extends zzr<zzp> {
    private final zzalf<zzp> zzdcr;
    private final Map<String, String> zzdcs;
    private final zzajv zzdct;

    public zzajd(String str, zzalf<zzp> zzalfVar) {
        this(str, null, zzalfVar);
    }

    private zzajd(String str, Map<String, String> map, zzalf<zzp> zzalfVar) {
        super(0, str, new zzaje(zzalfVar));
        this.zzdcs = null;
        this.zzdcr = zzalfVar;
        this.zzdct = new zzajv();
        this.zzdct.zza(str, "GET", null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.zzr
    public final zzw<zzp> zza(zzp zzpVar) {
        return zzw.zza(zzpVar, zzao.zzb(zzpVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzr
    public final /* synthetic */ void zza(zzp zzpVar) {
        zzp zzpVar2 = zzpVar;
        this.zzdct.zza(zzpVar2.zzac, zzpVar2.statusCode);
        zzajv zzajvVar = this.zzdct;
        byte[] bArr = zzpVar2.data;
        if (zzajv.isEnabled() && bArr != null) {
            zzajvVar.zzf(bArr);
        }
        this.zzdcr.set(zzpVar2);
    }
}
