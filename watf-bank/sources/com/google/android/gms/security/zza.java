package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.zzf;
import com.google.android.gms.security.ProviderInstaller;
/* loaded from: classes.dex */
final class zza extends AsyncTask<Void, Void, Integer> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ ProviderInstaller.ProviderInstallListener zzkbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.val$context = context;
        this.zzkbp = providerInstallListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zzb */
    public final Integer doInBackground(Void... voidArr) {
        int connectionStatusCode;
        try {
            ProviderInstaller.installIfNeeded(this.val$context);
            connectionStatusCode = 0;
        } catch (GooglePlayServicesNotAvailableException e) {
            connectionStatusCode = e.errorCode;
        } catch (GooglePlayServicesRepairableException e2) {
            connectionStatusCode = e2.getConnectionStatusCode();
        }
        return Integer.valueOf(connectionStatusCode);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Integer num) {
        zzf unused;
        Integer num2 = num;
        if (num2.intValue() == 0) {
            this.zzkbp.onProviderInstalled();
            return;
        }
        unused = ProviderInstaller.zzkbn;
        this.zzkbp.onProviderInstallFailed(num2.intValue(), zzf.zza(this.val$context, num2.intValue(), "pi"));
    }
}
