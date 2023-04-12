package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
@zzzv
/* loaded from: classes.dex */
public final class zzaff {
    private final AtomicReference<ThreadPoolExecutor> zzcwx = new AtomicReference<>(null);
    private final Object zzcwy = new Object();
    private String zzcwz = null;
    private AtomicBoolean zzcxa = new AtomicBoolean(false);
    private final AtomicInteger zzcxb = new AtomicInteger(-1);
    private final AtomicReference<Object> zzcxc = new AtomicReference<>(null);
    private final AtomicReference<Object> zzcxd = new AtomicReference<>(null);
    private ConcurrentMap<String, Method> zzcxe = new ConcurrentHashMap(9);

    private static Bundle zza(Context context, String str, boolean z) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzagf.zzb(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if (z) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    private final Object zza(String str, Context context) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzcxc, true)) {
            try {
                return zzi(context, str).invoke(this.zzcxc.get(), new Object[0]);
            } catch (Exception e) {
                zza(e, str, true);
                return null;
            }
        }
        return null;
    }

    private final void zza(Context context, String str, Bundle bundle) {
        if (zzq(context) && zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzcxc, true)) {
            try {
                zzz(context).invoke(this.zzcxc.get(), "am", str, bundle);
            } catch (Exception e) {
                zza(e, "logEventInternal", true);
            }
        }
    }

    private final void zza(Exception exc, String str, boolean z) {
        if (this.zzcxa.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
        sb.append("Invoke Firebase method ");
        sb.append(str);
        sb.append(" error.");
        zzagf.zzcu(sb.toString());
        if (z) {
            zzagf.zzcu("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.zzcxa.set(true);
        }
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception e) {
                zza(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void zzb(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzcxc, true)) {
            try {
                zzh(context, str2).invoke(this.zzcxc.get(), str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzagf.v(sb.toString());
            } catch (Exception e) {
                zza(e, str2, false);
            }
        }
    }

    private final Method zzh(Context context, String str) {
        Method method = this.zzcxe.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.zzcxe.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzi(Context context, String str) {
        Method method = this.zzcxe.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzcxe.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzj(Context context, String str) {
        Method method = this.zzcxe.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.zzcxe.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzz(Context context) {
        Method method = this.zzcxe.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.zzcxe.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, "logEventInternal", true);
            return null;
        }
    }

    public final void zza(Context context, String str, String str2) {
        if (zzq(context)) {
            zza(context, str, zza(context, str2, "_ac".equals(str)));
        }
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzq(context)) {
            Bundle zza = zza(context, str, false);
            zza.putString("_ai", str2);
            zza.putString(VastExtensionXmlManager.TYPE, str3);
            zza.putInt("value", i);
            zza(context, "_ar", zza);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzagf.v(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzaa(Context context) throws Exception {
        return (String) zza("getAppInstanceId", context);
    }

    public final void zzb(Context context, String str) {
        if (zzq(context)) {
            zzb(context, str, "beginAdUnitExposure");
        }
    }

    public final void zzc(Context context, String str) {
        if (zzq(context)) {
            zzb(context, str, "endAdUnitExposure");
        }
    }

    public final void zzd(Context context, String str) {
        if (zzq(context) && (context instanceof Activity) && zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzcxd, false)) {
            try {
                zzj(context, "setCurrentScreen").invoke(this.zzcxd.get(), (Activity) context, str, context.getPackageName());
            } catch (Exception e) {
                zza(e, "setCurrentScreen", false);
            }
        }
    }

    public final void zze(Context context, String str) {
        zza(context, "_ac", str);
    }

    public final void zzf(Context context, String str) {
        zza(context, "_ai", str);
    }

    public final void zzg(Context context, String str) {
        zza(context, "_aq", str);
    }

    public final boolean zzq(Context context) {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbkn)).booleanValue() && !this.zzcxa.get()) {
            if (this.zzcxb.get() == -1) {
                zzkb.zzia();
                if (!zzajr.zzbe(context)) {
                    zzkb.zzia();
                    if (zzajr.zzbf(context)) {
                        zzagf.zzcu("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzcxb.set(0);
                    }
                }
                this.zzcxb.set(1);
            }
            if (this.zzcxb.get() == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzr(Context context) {
        return ((Boolean) zzkb.zzif().zzd(zznh.zzbko)).booleanValue() && zzq(context);
    }

    public final boolean zzs(Context context) {
        return ((Boolean) zzkb.zzif().zzd(zznh.zzbkp)).booleanValue() && zzq(context);
    }

    public final boolean zzt(Context context) {
        return ((Boolean) zzkb.zzif().zzd(zznh.zzbkq)).booleanValue() && zzq(context);
    }

    public final boolean zzu(Context context) {
        return ((Boolean) zzkb.zzif().zzd(zznh.zzbkr)).booleanValue() && zzq(context);
    }

    public final String zzv(Context context) {
        if (zzq(context) && zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzcxc, true)) {
            try {
                String str = (String) zzi(context, "getCurrentScreenName").invoke(this.zzcxc.get(), new Object[0]);
                if (str == null) {
                    str = (String) zzi(context, "getCurrentScreenClass").invoke(this.zzcxc.get(), new Object[0]);
                }
                return str != null ? str : "";
            } catch (Exception e) {
                zza(e, "getCurrentScreenName", false);
                return "";
            }
        }
        return "";
    }

    public final String zzw(Context context) {
        if (zzq(context)) {
            synchronized (this.zzcwy) {
                if (this.zzcwz != null) {
                    return this.zzcwz;
                }
                this.zzcwz = (String) zza("getGmpAppId", context);
                return this.zzcwz;
            }
        }
        return null;
    }

    public final String zzx(final Context context) {
        if (zzq(context)) {
            long longValue = ((Long) zzkb.zzif().zzd(zznh.zzbkx)).longValue();
            if (longValue < 0) {
                return (String) zza("getAppInstanceId", context);
            }
            if (this.zzcwx.get() == null) {
                this.zzcwx.compareAndSet(null, new ThreadPoolExecutor(((Integer) zzkb.zzif().zzd(zznh.zzbky)).intValue(), ((Integer) zzkb.zzif().zzd(zznh.zzbky)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzafh(this)));
            }
            Future submit = this.zzcwx.get().submit(new Callable(this, context) { // from class: com.google.android.gms.internal.zzafg
                private final zzaff zzcxf;
                private final Context zzcxg;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcxf = this;
                    this.zzcxg = context;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzcxf.zzaa(this.zzcxg);
                }
            });
            try {
                return (String) submit.get(longValue, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                submit.cancel(true);
                if (e instanceof TimeoutException) {
                    return "TIME_OUT";
                }
                return null;
            }
        }
        return null;
    }

    public final String zzy(Context context) {
        Object zza;
        if (zzq(context) && (zza = zza("generateEventId", context)) != null) {
            return zza.toString();
        }
        return null;
    }
}
