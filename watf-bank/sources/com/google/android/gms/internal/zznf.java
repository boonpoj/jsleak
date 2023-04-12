package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.ConditionVariable;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zznf {
    private Context zzbhi;
    private final Object mLock = new Object();
    private final ConditionVariable zzbhg = new ConditionVariable();
    private volatile boolean zzare = false;
    private SharedPreferences zzbhh = null;

    /* loaded from: assets/classes2.dex */
    public static final class zza {
        private int zzRn;
        private int zzRo;
        private int zzUa;
        private boolean zzUb;
        private boolean zzUc;
        private String zzUd;
        private String zzUe;
        private boolean zzUf;
        private boolean zzUg;
        private boolean zzUh;
        private boolean zzUi;
        private String zzUj;
        private String zzUk;
        private int zzUl;
        private int zzUm;
        private int zzUn;
        private int zzUo;
        private int zzUp;
        private int zzUq;
        private double zzUr;
        private boolean zzUs;
        private boolean zzUt;
        private int zzUu;
        private String zzUv;
        private boolean zzUw;
        private float zzxa;

        public zza(Context context) {
            DisplayMetrics displayMetrics;
            PackageManager packageManager = context.getPackageManager();
            zzs(context);
            zza(context, packageManager);
            zzt(context);
            Locale locale = Locale.getDefault();
            this.zzUb = zza(packageManager, "geo:0,0?q=donuts") != null;
            this.zzUc = zza(packageManager, "http://www.google.com") != null;
            this.zzUe = locale.getCountry();
            this.zzUf = zzeh.zzeO().zzkI();
            this.zzUg = com.google.android.gms.common.util.zzi.zzaK(context);
            this.zzUj = locale.getLanguage();
            this.zzUk = zza(packageManager);
            Resources resources = context.getResources();
            if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
                return;
            }
            this.zzxa = displayMetrics.density;
            this.zzRn = displayMetrics.widthPixels;
            this.zzRo = displayMetrics.heightPixels;
        }

        public zza(Context context, zznf zznfVar) {
            PackageManager packageManager = context.getPackageManager();
            zzs(context);
            zza(context, packageManager);
            zzt(context);
            zzu(context);
            this.zzUb = zznfVar.zzUb;
            this.zzUc = zznfVar.zzUc;
            this.zzUe = zznfVar.zzUe;
            this.zzUf = zznfVar.zzUf;
            this.zzUg = zznfVar.zzUg;
            this.zzUj = zznfVar.zzUj;
            this.zzUk = zznfVar.zzUk;
            this.zzxa = zznfVar.zzxa;
            this.zzRn = zznfVar.zzRn;
            this.zzRo = zznfVar.zzRo;
        }

        private static ResolveInfo zza(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        }

        private static String zza(PackageManager packageManager) {
            ActivityInfo activityInfo;
            ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
            if (zza == null || (activityInfo = zza.activityInfo) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                if (packageInfo != null) {
                    int i = packageInfo.versionCode;
                    String valueOf = String.valueOf(activityInfo.packageName);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb.append(i);
                    sb.append(".");
                    sb.append(valueOf);
                    return sb.toString();
                }
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @TargetApi(16)
        private void zza(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.zzUd = telephonyManager.getNetworkOperator();
            this.zzUn = telephonyManager.getNetworkType();
            this.zzUo = telephonyManager.getPhoneType();
            this.zzUm = -2;
            this.zzUt = false;
            this.zzUu = -1;
            if (com.google.android.gms.ads.internal.zzv.zzcJ().zza(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.zzUm = activeNetworkInfo.getType();
                    this.zzUu = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.zzUm = -1;
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    this.zzUt = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        private void zzs(Context context) {
            AudioManager zzG = com.google.android.gms.ads.internal.zzv.zzcJ().zzG(context);
            if (zzG != null) {
                try {
                    this.zzUa = zzG.getMode();
                    this.zzUh = zzG.isMusicActive();
                    this.zzUi = zzG.isSpeakerphoneOn();
                    this.zzUl = zzG.getStreamVolume(3);
                    this.zzUp = zzG.getRingerMode();
                    this.zzUq = zzG.getStreamVolume(2);
                    return;
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzv.zzcN().zza(th, "DeviceInfo.gatherAudioInfo");
                }
            }
            this.zzUa = -2;
            this.zzUh = false;
            this.zzUi = false;
            this.zzUl = 0;
            this.zzUp = 0;
            this.zzUq = 0;
        }

        private void zzt(Context context) {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            boolean z = false;
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                this.zzUr = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                }
            } else {
                this.zzUr = -1.0d;
            }
            this.zzUs = z;
        }

        private void zzu(Context context) {
            this.zzUv = Build.FINGERPRINT;
            this.zzUw = zzgl.zzn(context);
        }

        public zznf zzjn() {
            return new zznf(this.zzUa, this.zzUb, this.zzUc, this.zzUd, this.zzUe, this.zzUf, this.zzUg, this.zzUh, this.zzUi, this.zzUj, this.zzUk, this.zzUl, this.zzUm, this.zzUn, this.zzUo, this.zzUp, this.zzUq, this.zzxa, this.zzRn, this.zzRo, this.zzUr, this.zzUs, this.zzUt, this.zzUu, this.zzUv, this.zzUw);
        }
    }

    public final void initialize(Context context) {
        if (this.zzare) {
            return;
        }
        synchronized (this.mLock) {
            if (this.zzare) {
                return;
            }
            this.zzbhi = context.getApplicationContext() == null ? context : context.getApplicationContext();
            Context remoteContext = com.google.android.gms.common.zzp.getRemoteContext(context);
            if (remoteContext == null && context != null && (remoteContext = context.getApplicationContext()) == null) {
                remoteContext = context;
            }
            if (remoteContext == null) {
                this.zzbhg.open();
                return;
            }
            zzkb.zzid();
            this.zzbhh = remoteContext.getSharedPreferences("google_ads_flags", 0);
            this.zzare = true;
            this.zzbhg.open();
        }
    }

    public final <T> T zzd(zzmx<T> zzmxVar) {
        if (this.zzbhg.block(5000L)) {
            if (!this.zzare || this.zzbhh == null) {
                synchronized (this.mLock) {
                    if (this.zzare && this.zzbhh != null) {
                    }
                    return zzmxVar.zziv();
                }
            }
            return (T) zzajk.zza(this.zzbhi, new zzng(this, zzmxVar));
        }
        throw new IllegalStateException("Flags.initialize() was not called!");
    }
}
