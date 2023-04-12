package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
@zzzv
/* loaded from: classes.dex */
public final class zzamh extends zzamc {
    @Override // com.google.android.gms.internal.zzamc
    public final zzamb zza(Context context, zzamp zzampVar, int i, boolean z, zznu zznuVar, zzamo zzamoVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || applicationInfo.targetSdkVersion >= 11) {
            return new zzalr(context, z, zzampVar.zzsx().zzuh(), zzamoVar, new zzamq(context, zzampVar.zzsk(), zzampVar.getRequestId(), zznuVar, zzampVar.zzsh()));
        }
        return null;
    }
}
