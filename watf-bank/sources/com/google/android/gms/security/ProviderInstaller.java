package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zzf;
import com.google.android.gms.common.zzp;
import java.lang.reflect.Method;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final zzf zzkbn = zzf.zzafy();
    private static final Object sLock = new Object();
    private static Method zzkbo = null;

    /* renamed from: com.google.android.gms.security.ProviderInstaller$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 extends AsyncTask<Void, Void, Integer> {
        final /* synthetic */ ProviderInstallListener zzbCc;
        final /* synthetic */ Context zztd;

        AnonymousClass1(Context context, ProviderInstallListener providerInstallListener) {
            this.zztd = context;
            this.zzbCc = providerInstallListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: zzc */
        public Integer doInBackground(Void... voidArr) {
            int connectionStatusCode;
            try {
                ProviderInstaller.installIfNeeded(this.zztd);
                connectionStatusCode = 0;
            } catch (GooglePlayServicesNotAvailableException e) {
                connectionStatusCode = e.errorCode;
            } catch (GooglePlayServicesRepairableException e2) {
                connectionStatusCode = e2.getConnectionStatusCode();
            }
            return Integer.valueOf(connectionStatusCode);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: zzg */
        public void onPostExecute(Integer num) {
            if (num.intValue() == 0) {
                this.zzbCc.onProviderInstalled();
                return;
            }
            this.zzbCc.onProviderInstallFailed(num.intValue(), ProviderInstaller.zzOc().zzb(this.zztd, num.intValue(), "pi"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      assets/classes2.dex
     */
    /* loaded from: classes.dex */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzbq.checkNotNull(context, "Context must not be null");
        zzf.zzcd(context);
        Context remoteContext = zzp.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (sLock) {
            try {
                try {
                    if (zzkbo == null) {
                        zzkbo = remoteContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
                    }
                    zzkbo.invoke(null, remoteContext);
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e("ProviderInstaller", valueOf.length() != 0 ? "Failed to install provider: ".concat(valueOf) : new String("Failed to install provider: "));
                    throw new GooglePlayServicesNotAvailableException(8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        zzbq.checkNotNull(context, "Context must not be null");
        zzbq.checkNotNull(providerInstallListener, "Listener must not be null");
        zzbq.zzge("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }
}
