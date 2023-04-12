package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import java.util.HashMap;
@zzzv
/* loaded from: classes.dex */
public final class zzrj extends com.google.android.gms.dynamic.zzp<zzqc> {
    public zzrj() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    public final zzpz zzb(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        try {
            IBinder zza = zzde(view.getContext()).zza(com.google.android.gms.dynamic.zzn.zzz(view), com.google.android.gms.dynamic.zzn.zzz(hashMap), com.google.android.gms.dynamic.zzn.zzz(hashMap2));
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            return queryLocalInterface instanceof zzpz ? (zzpz) queryLocalInterface : new zzqb(zza);
        } catch (RemoteException | com.google.android.gms.dynamic.zzq e) {
            zzakb.zzc("Could not create remote NativeAdViewHolderDelegate.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzqc zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        return queryLocalInterface instanceof zzqc ? (zzqc) queryLocalInterface : new zzqd(iBinder);
    }
}
