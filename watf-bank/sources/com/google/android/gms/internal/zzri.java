package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
@zzzv
/* loaded from: classes.dex */
public final class zzri extends com.google.android.gms.dynamic.zzp<zzpx> {
    public zzri() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public final zzpu zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder zza = zzde(context).zza(com.google.android.gms.dynamic.zzn.zzz(context), com.google.android.gms.dynamic.zzn.zzz(frameLayout), com.google.android.gms.dynamic.zzn.zzz(frameLayout2), 11910000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            return queryLocalInterface instanceof zzpu ? (zzpu) queryLocalInterface : new zzpw(zza);
        } catch (RemoteException | com.google.android.gms.dynamic.zzq e) {
            zzakb.zzc("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzpx zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        return queryLocalInterface instanceof zzpx ? (zzpx) queryLocalInterface : new zzpy(iBinder);
    }
}
