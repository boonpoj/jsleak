package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.zzjr;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzjy extends zzjr.zza<zzpz> {
    private /* synthetic */ zzjr zzbfc;
    private /* synthetic */ View zzbff;
    private /* synthetic */ HashMap zzbfg;
    private /* synthetic */ HashMap zzbfh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjy(zzjr zzjrVar, View view, HashMap hashMap, HashMap hashMap2) {
        super();
        this.zzbfc = zzjrVar;
        this.zzbff = view;
        this.zzbfg = hashMap;
        this.zzbfh = hashMap2;
    }

    @Override // com.google.android.gms.internal.zzjr.zza
    public final /* synthetic */ zzpz zza(zzla zzlaVar) throws RemoteException {
        return zzlaVar.createNativeAdViewHolderDelegate(com.google.android.gms.dynamic.zzn.zzz(this.zzbff), com.google.android.gms.dynamic.zzn.zzz(this.zzbfg), com.google.android.gms.dynamic.zzn.zzz(this.zzbfh));
    }

    @Override // com.google.android.gms.internal.zzjr.zza
    public final /* synthetic */ zzpz zzhw() throws RemoteException {
        zzrj zzrjVar;
        zzrjVar = this.zzbfc.zzbey;
        zzpz zzb = zzrjVar.zzb(this.zzbff, this.zzbfg, this.zzbfh);
        if (zzb != null) {
            return zzb;
        }
        zzjr zzjrVar = this.zzbfc;
        zzjr.zza(this.zzbff.getContext(), "native_ad_view_holder_delegate");
        return new zzmk();
    }
}
