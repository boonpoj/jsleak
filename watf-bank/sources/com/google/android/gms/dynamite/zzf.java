package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class zzf implements DynamiteModule.zzd {
    @Override // com.google.android.gms.dynamite.DynamiteModule.zzd
    public final zzj zza(Context context, String str, zzi zziVar) throws DynamiteModule.zzc {
        int i;
        zzj zzjVar = new zzj();
        zzjVar.zzgxg = zziVar.zzab(context, str);
        zzjVar.zzgxh = zziVar.zzc(context, str, true);
        if (zzjVar.zzgxg == 0 && zzjVar.zzgxh == 0) {
            i = 0;
        } else if (zzjVar.zzgxh >= zzjVar.zzgxg) {
            zzjVar.zzgxi = 1;
            return zzjVar;
        } else {
            i = -1;
        }
        zzjVar.zzgxi = i;
        return zzjVar;
    }
}
