package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzkm extends zzeu implements zzkk {

    /* loaded from: assets/classes2.dex */
    public static final class zza {
        private boolean zzLJ;
        private boolean zzLK;
        private boolean zzLL;
        private boolean zzLM;
        private boolean zzLN;

        public zzkm zzgT() {
            return new zzkm(this, null);
        }

        public zza zzt(boolean z) {
            this.zzLJ = z;
            return this;
        }

        public zza zzu(boolean z) {
            this.zzLK = z;
            return this;
        }

        public zza zzv(boolean z) {
            this.zzLL = z;
            return this;
        }

        public zza zzw(boolean z) {
            this.zzLM = z;
            return this;
        }

        public zza zzx(boolean z) {
            this.zzLN = z;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.zzkk
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza2 = zza(2, zzbe());
        String readString = zza2.readString();
        zza2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzkk
    public final boolean isLoading() throws RemoteException {
        Parcel zza2 = zza(3, zzbe());
        boolean zza3 = zzew.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    @Override // com.google.android.gms.internal.zzkk
    public final void zza(zzjj zzjjVar, int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzjjVar);
        zzbe.writeInt(i);
        zzb(5, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkk
    public final String zzcp() throws RemoteException {
        Parcel zza2 = zza(4, zzbe());
        String readString = zza2.readString();
        zza2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzkk
    public final void zzd(zzjj zzjjVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzjjVar);
        zzb(1, zzbe);
    }
}
