package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzacc;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzacd implements Runnable {
    private /* synthetic */ zzaat zzcro;
    private /* synthetic */ zzabe zzcrp;
    private /* synthetic */ zzacb zzcrq;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzacd {

        /* renamed from: com.google.android.gms.internal.zzacd$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0005zza implements zzacd {
            private IBinder zzrp;

            C0005zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzacc zzaccVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
                    obtain.writeStrongBinder(zzaccVar != null ? zzaccVar.asBinder() : null);
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzacd zzbB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzacd)) ? new C0005zza(iBinder) : (zzacd) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
                zza(zzacc.zza.zzbA(parcel.readStrongBinder()));
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacd(zzacb zzacbVar, zzaat zzaatVar, zzabe zzabeVar) {
        this.zzcrq = zzacbVar;
        this.zzcro = zzaatVar;
        this.zzcrp = zzabeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaax zzaaxVar;
        try {
            zzaaxVar = this.zzcrq.zzb(this.zzcro);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "AdRequestServiceImpl.loadAdAsync");
            zzagf.zzc("Could not fetch ad response due to an Exception.", e);
            zzaaxVar = null;
        }
        if (zzaaxVar == null) {
            zzaaxVar = new zzaax(0);
        }
        try {
            this.zzcrp.zza(zzaaxVar);
        } catch (RemoteException e2) {
            zzagf.zzc("Fail to forward ad response.", e2);
        }
    }
}
