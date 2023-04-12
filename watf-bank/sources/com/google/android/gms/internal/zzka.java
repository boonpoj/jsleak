package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjr;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzka extends zzjr.zza<zzxe> {
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ zzjr zzbfc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzka(zzjr zzjrVar, Activity activity) {
        super();
        this.zzbfc = zzjrVar;
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.zzjr.zza
    public final /* synthetic */ zzxe zza(zzla zzlaVar) throws RemoteException {
        return zzlaVar.createAdOverlay(com.google.android.gms.dynamic.zzn.zzz(this.val$activity));
    }

    @Override // com.google.android.gms.internal.zzjr.zza
    public final /* synthetic */ zzxe zzhw() throws RemoteException {
        zzxd zzxdVar;
        zzxdVar = this.zzbfc.zzbex;
        zzxe zze = zzxdVar.zze(this.val$activity);
        if (zze != null) {
            return zze;
        }
        zzjr zzjrVar = this.zzbfc;
        zzjr.zza(this.val$activity, "ad_overlay");
        return null;
    }
}
