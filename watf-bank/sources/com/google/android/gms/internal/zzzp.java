package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.mopub.common.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzzp implements zzzt {
    private static final Object sLock = new Object();
    private static zzzt zzcme = null;
    private final zzakd zzarf;
    private final Context zzbhi;
    private final Object zzcmf = new Object();
    private final WeakHashMap<Thread, Boolean> zzcmg = new WeakHashMap<>();
    private final ExecutorService zzais = Executors.newCachedThreadPool();

    private zzzp(Context context) {
        this.zzbhi = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzarf = zzakd.zzrd();
        Thread thread = Looper.getMainLooper().getThread();
        if (thread != null) {
            synchronized (this.zzcmf) {
                this.zzcmg.put(thread, true);
            }
            thread.setUncaughtExceptionHandler(new zzzr(this, thread.getUncaughtExceptionHandler()));
        }
        Thread.setDefaultUncaughtExceptionHandler(new zzzq(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private final Uri.Builder zza(String str, String str2, String str3, int i) {
        boolean z;
        String str4;
        try {
            z = zzbhf.zzdb(this.zzbhi).zzamu();
        } catch (Throwable th) {
            zzakb.zzb("Error fetching instant app info", th);
            z = false;
        }
        try {
            str4 = this.zzbhi.getPackageName();
        } catch (Throwable th2) {
            zzakb.zzcu("Cannot obtain package name, proceeding.");
            str4 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme(Constants.HTTPS).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 1 + String.valueOf(str6).length());
            sb.append(str5);
            sb.append(" ");
            sb.append(str6);
            str6 = sb.toString();
        }
        return appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzarf.zzcv).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zznh.zziw())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "179146524").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzkb.zzic()).appendQueryParameter("sampling_rate", Integer.toString(1)).appendQueryParameter("pb_tm", String.valueOf(zzkb.zzif().zzd(zznh.zzbru)));
    }

    public static zzzt zzj(Context context) {
        synchronized (sLock) {
            if (zzcme == null) {
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbhs)).booleanValue()) {
                    zzcme = new zzzp(context);
                } else {
                    zzcme = new zzzu();
                }
            }
        }
        return zzcme;
    }

    private final void zzo(List<String> list) {
        for (String str : list) {
            this.zzais.submit(new zzzs(this, new zzakc(), str));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(Thread thread, Throwable th) {
        boolean z;
        StackTraceElement[] stackTrace;
        if (th != null) {
            Throwable th2 = th;
            boolean z2 = false;
            boolean z3 = false;
            while (th2 != null) {
                boolean z4 = z3;
                boolean z5 = z2;
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    if (zzajr.zzcq(stackTraceElement.getClassName())) {
                        z5 = true;
                    }
                    if (getClass().getName().equals(stackTraceElement.getClassName())) {
                        z4 = true;
                    }
                }
                th2 = th2.getCause();
                z2 = z5;
                z3 = z4;
            }
            if (z2 && !z3) {
                z = true;
                if (z || zzajr.zzc(th) == null) {
                }
                String name = th.getClass().getName();
                StringWriter stringWriter = new StringWriter();
                zzdvl.zza(th, new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                if (Math.random() < 1.0d) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(zza(name, stringWriter2, "", 1).toString());
                    zzo(arrayList);
                    return;
                }
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    @Override // com.google.android.gms.internal.zzzt
    public final void zza(Throwable th, String str) {
        if (zzajr.zzc(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            zzdvl.zza(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (Math.random() < 1.0d) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(zza(name, stringWriter2, str, 1).toString());
                zzo(arrayList);
            }
        }
    }
}
