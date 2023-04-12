package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zzf;
import com.google.android.gms.common.zzp;
import com.google.android.gms.internal.zzfo;
import com.google.android.gms.internal.zzfp;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class AdvertisingIdClient {
    private final Context mContext;
    private com.google.android.gms.common.zza zzamu;
    private zzfo zzamv;
    private boolean zzamw;
    private Object zzamx;
    private zza zzamy;
    private boolean zzamz;
    private long zzana;

    /* loaded from: classes.dex */
    public static final class Info {
        private final String zzang;
        private final boolean zzanh;

        public Info(String str, boolean z) {
            this.zzang = str;
            this.zzanh = z;
        }

        public final String getId() {
            return this.zzang;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzanh;
        }

        public final String toString() {
            String str = this.zzang;
            boolean z = this.zzanh;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzanc;
        private long zzand;
        CountDownLatch zzane = new CountDownLatch(1);
        boolean zzanf = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzanc = new WeakReference<>(advertisingIdClient);
            this.zzand = j;
            start();
        }

        private final void disconnect() {
            AdvertisingIdClient advertisingIdClient = this.zzanc.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzanf = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.zzane.await(this.zzand, TimeUnit.MILLISECONDS)) {
                    return;
                }
                disconnect();
            } catch (InterruptedException e) {
                disconnect();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        this.zzamx = new Object();
        zzbq.checkNotNull(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.mContext = context;
        this.zzamw = false;
        this.zzana = j;
        this.zzamz = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb zzbVar = new zzb(context);
        boolean z = zzbVar.getBoolean("gads:ad_id_app_context:enabled", false);
        float f = zzbVar.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        String string = zzbVar.getString("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, z, zzbVar.getBoolean("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.start(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, z, f, SystemClock.elapsedRealtime() - elapsedRealtime, string, null);
            return info;
        } finally {
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb zzbVar = new zzb(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, zzbVar.getBoolean("gads:ad_id_app_context:enabled", false), zzbVar.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.start(false);
            return advertisingIdClient.getIsAdIdFakeForDebugLogging();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private final void start(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzamw) {
                finish();
            }
            this.zzamu = zzc(this.mContext, this.zzamz);
            this.zzamv = zza(this.mContext, this.zzamu);
            this.zzamw = true;
            if (z) {
                zzbo();
            }
        }
    }

    private static zzfo zza(Context context, com.google.android.gms.common.zza zzaVar) throws IOException {
        try {
            return zzfp.zzc(zzaVar.zza(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > f) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (info != null && info.getId() != null) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new com.google.android.gms.ads.identifier.zza(this, hashMap).start();
        return true;
    }

    private final void zzbo() {
        synchronized (this.zzamx) {
            if (this.zzamy != null) {
                this.zzamy.zzane.countDown();
                try {
                    this.zzamy.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzana > 0) {
                this.zzamy = new zza(this, this.zzana);
            }
        }
    }

    private static com.google.android.gms.common.zza zzc(Context context, boolean z) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(zzp.GOOGLE_PLAY_STORE_PACKAGE, 0);
            int isGooglePlayServicesAvailable = zzf.zzafy().isGooglePlayServicesAvailable(context);
            if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
                String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                com.google.android.gms.common.zza zzaVar = new com.google.android.gms.common.zza();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    if (com.google.android.gms.common.stats.zza.zzamc().zza(context, intent, zzaVar, 1)) {
                        return zzaVar;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            }
            throw new IOException("Google Play services not available");
        } catch (PackageManager.NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public void finish() {
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.zzamu == null) {
                return;
            }
            if (this.zzamw) {
                com.google.android.gms.common.stats.zza.zzamc();
                this.mContext.unbindService(this.zzamu);
            }
            this.zzamw = false;
            this.zzamv = null;
            this.zzamu = null;
        }
    }

    public Info getInfo() throws IOException {
        Info info;
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamw) {
                synchronized (this.zzamx) {
                    if (this.zzamy == null || !this.zzamy.zzanf) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamw) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            zzbq.checkNotNull(this.zzamu);
            zzbq.checkNotNull(this.zzamv);
            try {
                info = new Info(this.zzamv.getId(), this.zzamv.zzb(true));
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        zzbo();
        return info;
    }

    public boolean getIsAdIdFakeForDebugLogging() throws IOException {
        boolean zzbp;
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamw) {
                synchronized (this.zzamx) {
                    if (this.zzamy == null || !this.zzamy.zzanf) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamw) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            zzbq.checkNotNull(this.zzamu);
            zzbq.checkNotNull(this.zzamv);
            try {
                zzbp = this.zzamv.zzbp();
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        zzbo();
        return zzbp;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        start(true);
    }
}
