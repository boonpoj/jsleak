package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class zzb implements DynamiteModule.zzd {
    @Override // com.google.android.gms.dynamite.DynamiteModule.zzd
    public final zzj zza(Context context, String str, zzi zziVar) throws DynamiteModule.zzc {
        zzj zzjVar = new zzj();
        zzjVar.zzgxh = zziVar.zzc(context, str, true);
        if (zzjVar.zzgxh != 0) {
            zzjVar.zzgxi = 1;
        } else {
            zzjVar.zzgxg = zziVar.zzab(context, str);
            if (zzjVar.zzgxg != 0) {
                zzjVar.zzgxi = -1;
            }
        }
        return zzjVar;
    }
}
