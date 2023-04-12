package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzzt {

    /* loaded from: assets/classes2.dex */
    private class zza implements GoogleApiClient.OnConnectionFailedListener {
        public final GoogleApiClient.OnConnectionFailedListener zzayA;
        public final int zzayy;
        public final GoogleApiClient zzayz;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzayy = i;
            this.zzayz = googleApiClient;
            this.zzayA = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append((CharSequence) str).append("GoogleApiClient #").print(this.zzayy);
            printWriter.println(":");
            this.zzayz.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            Log.d("AutoManageHelper", sb.toString());
            zzzt.this.zzb(connectionResult, this.zzayy);
        }

        public void zzuX() {
            this.zzayz.unregisterConnectionFailedListener(this);
            this.zzayz.disconnect();
        }
    }

    void zza(Throwable th, String str);
}
