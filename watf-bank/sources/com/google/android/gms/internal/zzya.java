package com.google.android.gms.internal;

import android.content.Context;
@zzzv
/* loaded from: classes.dex */
public final class zzya {
    public static zzaif zza(Context context, com.google.android.gms.ads.internal.zza zzaVar, zzafp zzafpVar, zzcv zzcvVar, zzanh zzanhVar, zzux zzuxVar, zzyb zzybVar, zznu zznuVar) {
        zzaif zzyiVar;
        zzaax zzaaxVar = zzafpVar.zzcxy;
        if (zzaaxVar.zzcow) {
            zzyiVar = new zzyg(context, zzafpVar, zzuxVar, zzybVar, zznuVar, zzanhVar);
        } else if (zzaaxVar.zzben || (zzaVar instanceof com.google.android.gms.ads.internal.zzba)) {
            zzyiVar = (zzaaxVar.zzben && (zzaVar instanceof com.google.android.gms.ads.internal.zzba)) ? new zzyi(context, (com.google.android.gms.ads.internal.zzba) zzaVar, zzafpVar, zzcvVar, zzybVar, zznuVar) : new zzyd(zzafpVar, zzybVar);
        } else {
            zzyiVar = (((Boolean) zzkb.zzif().zzd(zznh.zzbkh)).booleanValue() && com.google.android.gms.common.util.zzq.zzaml() && !com.google.android.gms.common.util.zzq.zzamn() && zzanhVar != null && zzanhVar.zzsx().zzuh()) ? new zzyf(context, zzafpVar, zzanhVar, zzybVar) : new zzyc(context, zzafpVar, zzanhVar, zzybVar);
        }
        String valueOf = String.valueOf(zzyiVar.getClass().getName());
        zzagf.zzbx(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzyiVar.zznd();
        return zzyiVar;
    }
}
