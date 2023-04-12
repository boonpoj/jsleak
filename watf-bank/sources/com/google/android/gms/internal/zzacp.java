package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzacp {
    private float zzaxx;
    private int zzcnm;
    private int zzcnn;
    private int zzctl;
    private boolean zzctm;
    private boolean zzctn;
    private String zzcto;
    private String zzctp;
    private boolean zzctq;
    private boolean zzctr;
    private boolean zzcts;
    private boolean zzctt;
    private String zzctu;
    private String zzctv;
    private String zzctw;
    private int zzctx;
    private int zzcty;
    private int zzctz;
    private int zzcua;
    private int zzcub;
    private int zzcuc;
    private double zzcud;
    private boolean zzcue;
    private boolean zzcuf;
    private int zzcug;
    private String zzcuh;
    private String zzcui;
    private boolean zzcuj;

    public zzacp(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzl(context);
        zzm(context);
        zzn(context);
        Locale locale = Locale.getDefault();
        this.zzctm = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzctn = zza(packageManager, "http://www.google.com") != null;
        this.zzctp = locale.getCountry();
        zzkb.zzia();
        this.zzctq = zzajr.zzqy();
        this.zzctr = com.google.android.gms.common.util.zzi.zzcu(context);
        this.zzctu = locale.getLanguage();
        this.zzctv = zzb(context, packageManager);
        this.zzctw = zza(context, packageManager);
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        this.zzaxx = displayMetrics.density;
        this.zzcnm = displayMetrics.widthPixels;
        this.zzcnn = displayMetrics.heightPixels;
    }

    public zzacp(Context context, zzaco zzacoVar) {
        context.getPackageManager();
        zzl(context);
        zzm(context);
        zzn(context);
        this.zzcuh = Build.FINGERPRINT;
        this.zzcui = Build.DEVICE;
        this.zzcuj = com.google.android.gms.common.util.zzq.zzamh() && zzoe.zzh(context);
        this.zzctm = zzacoVar.zzctm;
        this.zzctn = zzacoVar.zzctn;
        this.zzctp = zzacoVar.zzctp;
        this.zzctq = zzacoVar.zzctq;
        this.zzctr = zzacoVar.zzctr;
        this.zzctu = zzacoVar.zzctu;
        this.zzctv = zzacoVar.zzctv;
        this.zzctw = zzacoVar.zzctw;
        this.zzaxx = zzacoVar.zzaxx;
        this.zzcnm = zzacoVar.zzcnm;
        this.zzcnn = zzacoVar.zzcnn;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzbs.zzem().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private static String zza(Context context, PackageManager packageManager) {
        try {
            PackageInfo packageInfo = zzbhf.zzdb(context).getPackageInfo(com.google.android.gms.common.zzp.GOOGLE_PLAY_STORE_PACKAGE, 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static String zzb(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = zzbhf.zzdb(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private final void zzl(Context context) {
        com.google.android.gms.ads.internal.zzbs.zzei();
        AudioManager zzap = zzahn.zzap(context);
        if (zzap != null) {
            try {
                this.zzctl = zzap.getMode();
                this.zzcts = zzap.isMusicActive();
                this.zzctt = zzap.isSpeakerphoneOn();
                this.zzctx = zzap.getStreamVolume(3);
                this.zzcub = zzap.getRingerMode();
                this.zzcuc = zzap.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzbs.zzem().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzctl = -2;
        this.zzcts = false;
        this.zzctt = false;
        this.zzctx = 0;
        this.zzcub = 0;
        this.zzcuc = 0;
    }

    private final void zzm(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzcto = telephonyManager.getNetworkOperator();
        this.zzctz = telephonyManager.getNetworkType();
        this.zzcua = telephonyManager.getPhoneType();
        this.zzcty = -2;
        this.zzcuf = false;
        this.zzcug = -1;
        com.google.android.gms.ads.internal.zzbs.zzei();
        if (zzahn.zzd(context, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.zzcty = activeNetworkInfo.getType();
                this.zzcug = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.zzcty = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.zzcuf = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void zzn(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver == null) {
            this.zzcud = -1.0d;
            this.zzcue = false;
            return;
        }
        int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        this.zzcud = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
        this.zzcue = (intExtra == 2 || intExtra == 5) ? true : true;
    }

    public final zzaco zzny() {
        return new zzaco(this.zzctl, this.zzctm, this.zzctn, this.zzcto, this.zzctp, this.zzctq, this.zzctr, this.zzcts, this.zzctt, this.zzctu, this.zzctv, this.zzctw, this.zzctx, this.zzcty, this.zzctz, this.zzcua, this.zzcub, this.zzcuc, this.zzaxx, this.zzcnm, this.zzcnn, this.zzcud, this.zzcue, this.zzcuf, this.zzcug, this.zzcuh, this.zzcuj, this.zzcui);
    }
}
