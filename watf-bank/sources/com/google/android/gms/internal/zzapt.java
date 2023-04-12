package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzaf;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: assets/classes2.dex */
public class zzapt {

    /* loaded from: assets/classes2.dex */
    static class zza implements zzf.zzb, zzf.zzc {
        private final String packageName;
        protected zzapu zzbfB;
        private final String zzbfC;
        private final LinkedBlockingQueue<zzaf.zza> zzbfD;
        private final HandlerThread zzbfE = new HandlerThread("GassClient");

        public zza(Context context, String str, String str2) {
            this.packageName = str;
            this.zzbfC = str2;
            this.zzbfE.start();
            this.zzbfB = new zzapu(context, this.zzbfE.getLooper(), this, this);
            this.zzbfD = new LinkedBlockingQueue<>();
            connect();
        }

        protected void connect() {
            this.zzbfB.zzwT();
        }

        public void onConnected(Bundle bundle) {
            zzapz zzFW = zzFW();
            if (zzFW != null) {
                try {
                    this.zzbfD.put(zzFW.zza(new zzapv(this.packageName, this.zzbfC)).zzFZ());
                } catch (Throwable unused) {
                }
                zziY();
                this.zzbfE.quit();
            }
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            try {
                this.zzbfD.put(new zzaf.zza());
            } catch (InterruptedException unused) {
            }
        }

        public void onConnectionSuspended(int i) {
            try {
                this.zzbfD.put(new zzaf.zza());
            } catch (InterruptedException unused) {
            }
        }

        protected zzapz zzFW() {
            try {
                return this.zzbfB.zzFX();
            } catch (DeadObjectException | IllegalStateException unused) {
                return null;
            }
        }

        public zzaf.zza zzaS() {
            return zzjo(2000);
        }

        public void zziY() {
            if (this.zzbfB != null) {
                if (this.zzbfB.isConnected() || this.zzbfB.isConnecting()) {
                    this.zzbfB.disconnect();
                }
            }
        }

        public zzaf.zza zzjo(int i) {
            zzaf.zza zzaVar;
            try {
                zzaVar = this.zzbfD.poll(i, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                zzaVar = null;
            }
            return zzaVar == null ? new zzaf.zza() : zzaVar;
        }
    }

    public static zzaf.zza zzi(Context context, String str, String str2) {
        return new zza(context, str, str2).zzaS();
    }
}
