package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjr;
import com.mopub.common.AdType;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzjz extends zzjr.zza<zzadk> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzux zzbfb;
    private /* synthetic */ zzjr zzbfc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjz(zzjr zzjrVar, Context context, zzux zzuxVar) {
        super();
        this.zzbfc = zzjrVar;
        this.val$context = context;
        this.zzbfb = zzuxVar;
    }

    @Override // com.google.android.gms.internal.zzjr.zza
    public final /* synthetic */ zzadk zza(zzla zzlaVar) throws RemoteException {
        return zzlaVar.createRewardedVideoAd(com.google.android.gms.dynamic.zzn.zzz(this.val$context), this.zzbfb, 11910000);
    }

    @Override // com.google.android.gms.internal.zzjr.zza
    public final /* synthetic */ zzadk zzhw() throws RemoteException {
        zzadt zzadtVar;
        zzadtVar = this.zzbfc.zzbew;
        zzadk zza = zzadtVar.zza(this.val$context, this.zzbfb);
        if (zza != null) {
            return zza;
        }
        zzjr zzjrVar = this.zzbfc;
        zzjr.zza(this.val$context, AdType.REWARDED_VIDEO);
        return new zzml();
    }
}
