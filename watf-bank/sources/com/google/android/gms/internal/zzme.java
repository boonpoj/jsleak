package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzme extends zzkl {
    final /* synthetic */ zzmc zzbgr;

    /* renamed from: com.google.android.gms.internal.zzme$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 implements zzb {
        final /* synthetic */ Context zztd;

        AnonymousClass1(Context context) {
            this.zztd = context;
        }

        @Override // com.google.android.gms.internal.zzme.zzb
        public boolean zza(zzqa zzqaVar) {
            return zzqaVar.zzYd || (com.google.android.gms.common.util.zzi.zzaK(this.zztd) && !((Boolean) zzfx.zzBF.get()).booleanValue());
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zzb(zzmk zzmkVar);
    }

    /* loaded from: assets/classes2.dex */
    interface zzb {
        boolean zza(zzqa zzqaVar);
    }

    private zzme(zzmc zzmcVar) {
        this.zzbgr = zzmcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzme(zzmc zzmcVar, zzmd zzmdVar) {
        this(zzmcVar);
    }

    @Override // com.google.android.gms.internal.zzkk
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.zzkk
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.zzkk
    public final void zza(zzjj zzjjVar, int i) throws RemoteException {
        zzakb.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzajr.zzajw.post(new zzmf(this));
    }

    @Override // com.google.android.gms.internal.zzkk
    public final String zzcp() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.zzkk
    public final void zzd(zzjj zzjjVar) throws RemoteException {
        zza(zzjjVar, 1);
    }
}
