package com.google.android.gms.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.util.zzx;
import com.google.android.gms.internal.zzbhf;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class zzp {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 11910000;
    private static boolean zzflj = false;
    private static boolean zzflk = false;
    private static boolean zzfll = false;
    private static boolean zzflm = false;
    static final AtomicBoolean zzfln = new AtomicBoolean();
    private static final AtomicBoolean zzflo = new AtomicBoolean();

    zzp() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzf.zzafy().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        String str;
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !zzflo.get()) {
            int zzcq = zzbf.zzcq(context);
            if (zzcq == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
            int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
            if (zzcq != i) {
                StringBuilder sb = new StringBuilder(String.valueOf("com.google.android.gms.version").length() + 290);
                sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                sb.append(i);
                sb.append(" but found ");
                sb.append(zzcq);
                sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"");
                sb.append("com.google.android.gms.version");
                sb.append("\" android:value=\"@integer/google_play_services_version\" />");
                throw new IllegalStateException(sb.toString());
            }
        }
        boolean z = (com.google.android.gms.common.util.zzi.zzct(context) || com.google.android.gms.common.util.zzi.zzcv(context)) ? false : true;
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256);
            } catch (PackageManager.NameNotFoundException e) {
                str = "Google Play Store is missing.";
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzq.zzci(context);
            if (z) {
                zzh zza = zzq.zza(packageInfo, zzk.zzflf);
                if (zza == null) {
                    str = "Google Play Store signature invalid.";
                    Log.w("GooglePlayServicesUtil", str);
                    return 9;
                } else if (zzq.zza(packageInfo2, zza) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (zzq.zza(packageInfo2, zzk.zzflf) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (packageInfo2.versionCode / 1000 >= GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000) {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e2) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                        return 1;
                    }
                }
                return !applicationInfo.enabled ? 3 : 0;
            }
            int i2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
            int i3 = packageInfo2.versionCode;
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("Google Play services out of date.  Requires ");
            sb2.append(i2);
            sb2.append(" but found ");
            sb2.append(i3);
            Log.w("GooglePlayServicesUtil", sb2.toString());
            return 2;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @Deprecated
    public static boolean zzb(Context context, int i, String str) {
        return zzx.zzb(context, i, str);
    }

    @Deprecated
    public static void zzbp(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = zzf.zzafy().isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            zzf.zzafy();
            Intent zza = zzf.zza(context, isGooglePlayServicesAvailable, "e");
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (zza != null) {
                throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", zza);
            }
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    @Deprecated
    public static void zzce(Context context) {
        if (zzfln.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
        } catch (SecurityException e) {
        }
    }

    @Deprecated
    public static int zzcf(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static boolean zzch(Context context) {
        PackageInfo packageInfo;
        try {
            if (!zzflm) {
                try {
                    packageInfo = zzbhf.zzdb(context).getPackageInfo("com.google.android.gms", 64);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
                }
                if (packageInfo != null) {
                    zzq.zzci(context);
                    if (zzq.zza(packageInfo, zzk.zzflf[1]) != null) {
                        zzfll = true;
                    }
                }
                zzfll = false;
            }
            return zzfll || !"user".equals(Build.TYPE);
        } finally {
            zzflm = true;
        }
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzv(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        return zzx.zzf(context, i);
    }

    static boolean zzv(Context context, String str) {
        Bundle applicationRestrictions;
        boolean equals = str.equals("com.google.android.gms");
        if (com.google.android.gms.common.util.zzq.zzamn()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (applicationInfo.enabled) {
                if (!(com.google.android.gms.common.util.zzq.zzamk() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile")))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }
}
