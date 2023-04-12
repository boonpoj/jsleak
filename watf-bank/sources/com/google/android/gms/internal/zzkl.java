package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzkl extends zzev implements zzkk {

    /* renamed from: com.google.android.gms.internal.zzkl$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements DialogInterface.OnClickListener {
        final /* synthetic */ String zzLG;
        final /* synthetic */ String zzLH;

        AnonymousClass1(String str, String str2) {
            this.zzLG = str;
            this.zzLH = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ((DownloadManager) zzkl.zza(zzkl.this).getSystemService("download")).enqueue(zzkl.this.zzj(this.zzLG, this.zzLH));
            } catch (IllegalStateException unused) {
                zzkl.this.zzay("Could not store picture.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkl$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements DialogInterface.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            zzkl.this.zzay("User canceled the download.");
        }
    }

    public zzkl() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String mediationAdapterClassName;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            if (i == 2) {
                mediationAdapterClassName = getMediationAdapterClassName();
            } else if (i == 3) {
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzew.zza(parcel2, isLoading);
                return true;
            } else if (i == 4) {
                mediationAdapterClassName = zzcp();
            } else if (i != 5) {
                return false;
            } else {
                zza((zzjj) zzew.zza(parcel, zzjj.CREATOR), parcel.readInt());
            }
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
            return true;
        }
        zzd((zzjj) zzew.zza(parcel, zzjj.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
