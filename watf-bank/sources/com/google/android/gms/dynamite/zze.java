package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class zze implements DynamiteModule.zzd {
    @Override // com.google.android.gms.dynamite.DynamiteModule.zzd
    public final zzj zza(Context context, String str, zzi zziVar) throws DynamiteModule.zzc {
        zzj zzjVar = new zzj();
        zzjVar.zzgxg = zziVar.zzab(context, str);
        zzjVar.zzgxh = zzjVar.zzgxg != 0 ? zziVar.zzc(context, str, false) : zziVar.zzc(context, str, true);
        if (zzjVar.zzgxg == 0 && zzjVar.zzgxh == 0) {
            zzjVar.zzgxi = 0;
        } else if (zzjVar.zzgxg >= zzjVar.zzgxh) {
            zzjVar.zzgxi = -1;
        } else {
            zzjVar.zzgxi = 1;
        }
        return zzjVar;
    }
}
