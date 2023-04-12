package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
@zzzv
/* loaded from: classes.dex */
public final class zzafl implements zzafn {
    @Override // com.google.android.gms.internal.zzafn
    public final zzakv<String> zza(String str, PackageInfo packageInfo) {
        return zzakl.zzi(str);
    }

    @Override // com.google.android.gms.internal.zzafn
    public final zzakv<AdvertisingIdClient.Info> zzab(Context context) {
        zzalf zzalfVar = new zzalf();
        zzkb.zzia();
        if (zzajr.zzbf(context)) {
            zzahh.zza(new zzafm(this, context, zzalfVar));
        }
        return zzalfVar;
    }
}
