package com.google.android.gms.internal;

import android.content.Context;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzaak implements zzaam {
    private /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaak(Context context) {
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.zzaam
    public final boolean zza(zzakd zzakdVar) {
        zzkb.zzia();
        boolean zzbe = zzajr.zzbe(this.val$context);
        boolean z = ((Boolean) zzkb.zzif().zzd(zznh.zzbrg)).booleanValue() && zzakdVar.zzdel;
        if (zzaaj.zze(this.val$context, zzakdVar.zzdel) && zzbe && !z) {
            if (com.google.android.gms.common.util.zzi.zzcu(this.val$context)) {
                if (!((Boolean) zzkb.zzif().zzd(zznh.zzbjg)).booleanValue()) {
                }
            }
            return false;
        }
        return true;
    }
}
