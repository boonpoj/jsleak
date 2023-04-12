package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.internal.zzhh;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzhm implements Runnable {
    final /* synthetic */ zzhk zzazn;
    private ValueCallback<String> zzazo = new zzhn(this);
    final /* synthetic */ zzhe zzazp;
    final /* synthetic */ WebView zzazq;
    final /* synthetic */ boolean zzazr;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzhm {

        /* renamed from: com.google.android.gms.internal.zzhm$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0042zza implements zzhm {
            private IBinder zzrp;

            C0042zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzhh zzhhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
                    obtain.writeStrongBinder(zzhhVar != null ? zzhhVar.asBinder() : null);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
        }

        public static zzhm zzK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzhm)) ? new C0042zza(iBinder) : (zzhm) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
            zza(zzhh.zza.zzG(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhm(zzhk zzhkVar, zzhe zzheVar, WebView webView, boolean z) {
        this.zzazn = zzhkVar;
        this.zzazp = zzheVar;
        this.zzazq = webView;
        this.zzazr = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzazq.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzazq.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzazo);
            } catch (Throwable th) {
                this.zzazo.onReceiveValue("");
            }
        }
    }
}
