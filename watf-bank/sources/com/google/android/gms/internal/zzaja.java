package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaja extends zzau {
    private /* synthetic */ byte[] zzdco;
    private /* synthetic */ Map zzdcp;
    private /* synthetic */ zzajv zzdcq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaja(zzaiv zzaivVar, int i, String str, zzy zzyVar, zzx zzxVar, byte[] bArr, Map map, zzajv zzajvVar) {
        super(i, str, zzyVar, zzxVar);
        this.zzdco = bArr;
        this.zzdcp = map;
        this.zzdcq = zzajvVar;
    }

    @Override // com.google.android.gms.internal.zzr
    public final Map<String, String> getHeaders() throws zza {
        Map<String, String> map = this.zzdcp;
        return map == null ? super.getHeaders() : map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzau, com.google.android.gms.internal.zzr
    public final /* synthetic */ void zza(String str) {
        zza(str);
    }

    @Override // com.google.android.gms.internal.zzr
    public final byte[] zzf() throws zza {
        byte[] bArr = this.zzdco;
        return bArr == null ? super.zzf() : bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzau
    public final void zzh(String str) {
        this.zzdcq.zzcr(str);
        super.zza(str);
    }
}
