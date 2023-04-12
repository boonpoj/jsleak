package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public class zzau extends zzr<String> {
    private final zzy<String> zzcj;

    public zzau(int i, String str, zzy<String> zzyVar, zzx zzxVar) {
        super(i, str, zzxVar);
        this.zzcj = zzyVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzr
    public final zzw<String> zza(zzp zzpVar) {
        String str;
        try {
            str = new String(zzpVar.data, zzao.zzb(zzpVar.zzac));
        } catch (UnsupportedEncodingException e) {
            str = new String(zzpVar.data);
        }
        return zzw.zza(str, zzao.zzb(zzpVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzr
    /* renamed from: zzh */
    public void zza(String str) {
        zzy<String> zzyVar = this.zzcj;
        if (zzyVar != null) {
            zzyVar.zzb(str);
        }
    }
}
