package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
@zzzv
/* loaded from: classes.dex */
public final class zzxd extends com.google.android.gms.dynamic.zzp<zzxh> {
    public zzxd() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final zzxe zze(Activity activity) {
        try {
            IBinder zzl = zzde(activity).zzl(com.google.android.gms.dynamic.zzn.zzz(activity));
            if (zzl == null) {
                return null;
            }
            IInterface queryLocalInterface = zzl.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return queryLocalInterface instanceof zzxe ? (zzxe) queryLocalInterface : new zzxg(zzl);
        } catch (RemoteException e) {
            zzakb.zzc("Could not create remote AdOverlay.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzq e2) {
            zzakb.zzc("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzxh zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return queryLocalInterface instanceof zzxh ? (zzxh) queryLocalInterface : new zzxi(iBinder);
    }
}
