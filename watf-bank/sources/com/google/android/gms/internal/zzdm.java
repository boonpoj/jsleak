package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public class zzdm {
    private static final String TAG = zzdm.class.getSimpleName();
    protected Context zzair;
    private ExecutorService zzais;
    private DexClassLoader zzait;
    private zzcx zzaiu;
    private byte[] zzaiv;
    private boolean zzaiy;
    private zzcp zzajb;
    private Map<Pair<String, String>, zzer> zzaje;
    private volatile AdvertisingIdClient zzaiw = null;
    private volatile boolean zzahr = false;
    private Future zzaix = null;
    private volatile zzaz zzaiz = null;
    private Future zzaja = null;
    private boolean zzajc = false;
    private boolean zzajd = false;
    private boolean zzajf = false;
    private boolean zzajg = true;
    private boolean zzajh = false;

    /* loaded from: classes.dex */
    final class zza extends BroadcastReceiver {
        private zza() {
        }

        /* synthetic */ zza(zzdm zzdmVar, zzdn zzdnVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzdm.this.zzajg = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzdm.this.zzajg = false;
            }
        }
    }

    private zzdm(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.zzaiy = applicationContext != null;
        this.zzair = this.zzaiy ? applicationContext : context;
        this.zzaje = new HashMap();
    }

    public static zzdm zza(Context context, String str, String str2, boolean z) {
        File cacheDir;
        File file;
        zzdm zzdmVar = new zzdm(context);
        try {
            zzdmVar.zzais = Executors.newCachedThreadPool();
            zzdmVar.zzahr = z;
            if (z) {
                zzdmVar.zzaix = zzdmVar.zzais.submit(new zzdn(zzdmVar));
            }
            zzdmVar.zzais.execute(new zzdp(zzdmVar));
            try {
                com.google.android.gms.common.zzf zzafy = com.google.android.gms.common.zzf.zzafy();
                zzdmVar.zzajc = com.google.android.gms.common.zzf.zzcf(zzdmVar.zzair) > 0;
                zzdmVar.zzajd = zzafy.isGooglePlayServicesAvailable(zzdmVar.zzair) == 0;
            } catch (Throwable th) {
            }
            zzdmVar.zza(0, true);
            if (zzdr.zzau() && ((Boolean) zzkb.zzif().zzd(zznh.zzbnv)).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            zzdmVar.zzaiu = new zzcx(null);
            try {
                zzdmVar.zzaiv = zzdmVar.zzaiu.zzl(str);
                try {
                    try {
                        try {
                            try {
                                cacheDir = zzdmVar.zzair.getCacheDir();
                                if (cacheDir == null && (cacheDir = zzdmVar.zzair.getDir("dex", 0)) == null) {
                                    throw new zzdj();
                                }
                                file = new File(String.format("%s/%s.jar", cacheDir, "1505450608132"));
                                if (!file.exists()) {
                                    byte[] zzb = zzdmVar.zzaiu.zzb(zzdmVar.zzaiv, str2);
                                    file.createNewFile();
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    fileOutputStream.write(zzb, 0, zzb.length);
                                    fileOutputStream.close();
                                }
                                zzdmVar.zzb(cacheDir, "1505450608132");
                            } catch (zzcy e) {
                                throw new zzdj(e);
                            }
                        } catch (FileNotFoundException e2) {
                            throw new zzdj(e2);
                        }
                    } catch (IOException e3) {
                        throw new zzdj(e3);
                    }
                } catch (NullPointerException e4) {
                    throw new zzdj(e4);
                }
            } catch (zzcy e5) {
                throw new zzdj(e5);
            }
        } catch (zzdj e6) {
        }
        try {
            zzdmVar.zzait = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzdmVar.zzair.getClassLoader());
            zzb(file);
            zzdmVar.zza(cacheDir, "1505450608132");
            zzm(String.format("%s/%s.dex", cacheDir, "1505450608132"));
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbnn)).booleanValue() && !zzdmVar.zzajh) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                zzdmVar.zzair.registerReceiver(new zza(zzdmVar, null), intentFilter);
                zzdmVar.zzajh = true;
            }
            zzdmVar.zzajb = new zzcp(zzdmVar);
            zzdmVar.zzajf = true;
            return zzdmVar;
        } catch (Throwable th2) {
            zzb(file);
            zzdmVar.zza(cacheDir, "1505450608132");
            zzm(String.format("%s/%s.dex", cacheDir, "1505450608132"));
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zza(java.io.File r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.zza(java.io.File, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zza(int i, zzaz zzazVar) {
        if (i < 4) {
            if (zzazVar == null) {
                return true;
            }
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbny)).booleanValue() && (zzazVar.zzcw == null || zzazVar.zzcw.equals("0000000000000000000000000000000000000000000000000000000000000000"))) {
                return true;
            }
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbnz)).booleanValue()) {
                return zzazVar.zzfi == null || zzazVar.zzfi.zzgg == null || zzazVar.zzfi.zzgg.longValue() == -2;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaq() {
        try {
            if (this.zzaiw == null && this.zzaiy) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzair);
                advertisingIdClient.start();
                this.zzaiw = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
            this.zzaiw = null;
        }
    }

    private final zzaz zzar() {
        try {
            return zzcbm.zzm(this.zzair, this.zzair.getPackageName(), Integer.toString(this.zzair.getPackageManager().getPackageInfo(this.zzair.getPackageName(), 0).versionCode));
        } catch (Throwable th) {
            return null;
        }
    }

    private static void zzb(File file) {
        if (file.exists()) {
            file.delete();
        } else {
            Log.d(TAG, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzb(java.io.File r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.zzb(java.io.File, java.lang.String):boolean");
    }

    private static void zzm(String str) {
        zzb(new File(str));
    }

    public final Context getContext() {
        return this.zzair;
    }

    public final boolean isInitialized() {
        return this.zzajf;
    }

    public final Method zza(String str, String str2) {
        zzer zzerVar = this.zzaje.get(new Pair(str, str2));
        if (zzerVar == null) {
            return null;
        }
        return zzerVar.zzbd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i, boolean z) {
        if (this.zzajd) {
            Future<?> submit = this.zzais.submit(new zzdo(this, i, z));
            if (i == 0) {
                this.zzaja = submit;
            }
        }
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzaje.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzaje.put(new Pair<>(str, str2), new zzer(this, str, str2, clsArr));
        return true;
    }

    public final int zzac() {
        if (this.zzajb != null) {
            return zzcp.zzac();
        }
        return Integer.MIN_VALUE;
    }

    public final ExecutorService zzag() {
        return this.zzais;
    }

    public final DexClassLoader zzah() {
        return this.zzait;
    }

    public final zzcx zzai() {
        return this.zzaiu;
    }

    public final byte[] zzaj() {
        return this.zzaiv;
    }

    public final boolean zzak() {
        return this.zzajc;
    }

    public final zzcp zzal() {
        return this.zzajb;
    }

    public final boolean zzam() {
        return this.zzajd;
    }

    public final boolean zzan() {
        return this.zzajg;
    }

    public final zzaz zzao() {
        return this.zzaiz;
    }

    public final Future zzap() {
        return this.zzaja;
    }

    public final AdvertisingIdClient zzas() {
        if (this.zzahr) {
            if (this.zzaiw != null) {
                return this.zzaiw;
            }
            Future future = this.zzaix;
            if (future != null) {
                try {
                    future.get(2000L, TimeUnit.MILLISECONDS);
                    this.zzaix = null;
                } catch (InterruptedException e) {
                } catch (ExecutionException e2) {
                } catch (TimeoutException e3) {
                    this.zzaix.cancel(true);
                }
            }
            return this.zzaiw;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaz zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException e) {
            }
        }
        return zzar();
    }
}
