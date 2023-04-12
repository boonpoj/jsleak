package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzahn {
    public static final Handler zzdaw = new zzagg(Looper.getMainLooper());
    private String zzczb;
    private Pattern zzdba;
    private Pattern zzdbb;
    private final Object mLock = new Object();
    private boolean zzdax = true;
    private boolean zzday = false;
    private boolean zzdaz = false;

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            zzdaw.post(runnable);
        }
    }

    public static Bundle zza(zzhk zzhkVar) {
        String zzpe;
        String zzpf;
        String str;
        if (zzhkVar == null) {
            return null;
        }
        if (!((Boolean) zzkb.zzif().zzd(zznh.zzbju)).booleanValue()) {
            if (!((Boolean) zzkb.zzif().zzd(zznh.zzbjw)).booleanValue()) {
                return null;
            }
        }
        if (com.google.android.gms.ads.internal.zzbs.zzem().zzoy() && com.google.android.gms.ads.internal.zzbs.zzem().zzoz()) {
            return null;
        }
        if (zzhkVar.zzgx()) {
            zzhkVar.wakeup();
        }
        zzhe zzgv = zzhkVar.zzgv();
        if (zzgv != null) {
            zzpe = zzgv.zzgk();
            str = zzgv.zzgl();
            zzpf = zzgv.zzgm();
            if (zzpe != null) {
                com.google.android.gms.ads.internal.zzbs.zzem().zzca(zzpe);
            }
            if (zzpf != null) {
                com.google.android.gms.ads.internal.zzbs.zzem().zzcb(zzpf);
            }
        } else {
            zzpe = com.google.android.gms.ads.internal.zzbs.zzem().zzpe();
            zzpf = com.google.android.gms.ads.internal.zzbs.zzem().zzpf();
            str = null;
        }
        Bundle bundle = new Bundle(1);
        if (zzpf != null) {
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbjw)).booleanValue() && !com.google.android.gms.ads.internal.zzbs.zzem().zzoz()) {
                bundle.putString("v_fp_vertical", zzpf);
            }
        }
        if (zzpe != null) {
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbju)).booleanValue() && !com.google.android.gms.ads.internal.zzbs.zzem().zzoy()) {
                bundle.putString("fingerprint", zzpe);
                if (!zzpe.equals(str)) {
                    bundle.putString("v_fp", str);
                }
            }
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    public static DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    public static String zza(Context context, View view, zzjn zzjnVar) {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbkm)).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", zzjnVar.width);
                jSONObject2.put("height", zzjnVar.height);
                jSONObject.put("size", jSONObject2);
                jSONObject.put("activity", zzam(context));
                if (!zzjnVar.zzbel) {
                    JSONArray jSONArray = new JSONArray();
                    while (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(VastExtensionXmlManager.TYPE, parent.getClass().getName());
                            jSONObject3.put("index_of_child", indexOfChild);
                            jSONArray.put(jSONObject3);
                        }
                        view = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("parents", jSONArray);
                    }
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                zzagf.zzc("Fail to get view hierarchy json", e);
                return null;
            }
        }
        return null;
    }

    public static String zza(Context context, zzcv zzcvVar, String str, View view, Activity activity) {
        if (zzcvVar == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzcvVar.zzc(parse)) {
                parse = zzcvVar.zza(parse, context, view, activity);
            }
            return parse.toString();
        } catch (Exception e) {
            return str;
        }
    }

    public static String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    private final JSONArray zza(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            zza(jSONArray, it.next());
        }
        return jSONArray;
    }

    public static void zza(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void zza(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
    }

    public static void zza(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }
    }

    public static void zza(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbqr)).booleanValue()) {
                zzb(context, intent);
            }
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzagf.zzbx(sb.toString());
        } catch (ActivityNotFoundException e) {
            zzagf.zzb("No browser is found.", e);
        }
    }

    public static void zza(Context context, String str, List<String> list) {
        for (String str2 : list) {
            new zzajh(context, str, str2).zznd();
        }
    }

    private final void zza(JSONArray jSONArray, Object obj) throws JSONException {
        Object zza;
        if (obj instanceof Bundle) {
            zza = zzc((Bundle) obj);
        } else if (obj instanceof Map) {
            zza = zzq((Map) obj);
        } else if (!(obj instanceof Collection)) {
            if (!(obj instanceof Object[])) {
                jSONArray.put(obj);
                return;
            }
            JSONArray jSONArray2 = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                zza(jSONArray2, obj2);
            }
            jSONArray.put(jSONArray2);
            return;
        } else {
            zza = zza((Collection) obj);
        }
        jSONArray.put(zza);
    }

    private final void zza(JSONObject jSONObject, String str, Object obj) throws JSONException {
        Collection<?> asList;
        Object zza;
        if (obj instanceof Bundle) {
            zza = zzc((Bundle) obj);
        } else if (obj instanceof Map) {
            zza = zzq((Map) obj);
        } else {
            if (obj instanceof Collection) {
                if (str == null) {
                    str = "null";
                }
                asList = (Collection) obj;
            } else if (!(obj instanceof Object[])) {
                jSONObject.put(str, obj);
                return;
            } else {
                asList = Arrays.asList((Object[]) obj);
            }
            zza = zza(asList);
        }
        jSONObject.put(str, zza);
    }

    public static boolean zza(Activity activity, Configuration configuration) {
        zzkb.zzia();
        int zzc = zzajr.zzc(activity, configuration.screenHeightDp);
        int zzc2 = zzajr.zzc(activity, configuration.screenWidthDp);
        DisplayMetrics zza = zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza.heightPixels;
        int i2 = zza.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d = activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        int round = ((int) Math.round(d + 0.5d)) * ((Integer) zzkb.zzif().zzd(zznh.zzbrb)).intValue();
        return zzb(i, zzc + dimensionPixelSize, round) && zzb(i2, zzc2, round);
    }

    public static boolean zza(ClassLoader classLoader, Class<?> cls, String str) {
        try {
            return cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean zzag(Context context) {
        String str;
        boolean z;
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            str = "Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.";
        } else {
            if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
                zzagf.zzcu(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboard"));
                z = false;
            } else {
                z = true;
            }
            if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
                zzagf.zzcu(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboardHidden"));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
                zzagf.zzcu(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "orientation"));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
                zzagf.zzcu(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenLayout"));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
                zzagf.zzcu(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "uiMode"));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
                zzagf.zzcu(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenSize"));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
                return z;
            }
            str = String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "smallestScreenSize");
        }
        zzagf.zzcu(str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String zzaj(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable th) {
            return zzqa();
        }
    }

    public static AlertDialog.Builder zzak(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static zzmt zzal(Context context) {
        return new zzmt(context);
    }

    private static String zzam(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                return runningTaskInfo.topActivity.getClassName();
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (r3.importance != 100) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r2.inKeyguardRestrictedInputMode() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        r6 = (android.os.PowerManager) r6.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r6 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        r6 = r6.isScreenOn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
        if (r6 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzan(android.content.Context r6) {
        /*
            r0 = 0
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r6.getSystemService(r1)     // Catch: java.lang.Throwable -> L56
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = "keyguard"
            java.lang.Object r2 = r6.getSystemService(r2)     // Catch: java.lang.Throwable -> L56
            android.app.KeyguardManager r2 = (android.app.KeyguardManager) r2     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L55
            if (r2 != 0) goto L16
            goto L55
        L16:
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L56
            if (r1 != 0) goto L1d
            return r0
        L1d:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L56
        L21:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L55
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L56
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch: java.lang.Throwable -> L56
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L56
            int r5 = r3.pid     // Catch: java.lang.Throwable -> L56
            if (r4 != r5) goto L21
            int r1 = r3.importance     // Catch: java.lang.Throwable -> L56
            r3 = 100
            if (r1 != r3) goto L55
            boolean r1 = r2.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L56
            if (r1 != 0) goto L55
            java.lang.String r1 = "power"
            java.lang.Object r6 = r6.getSystemService(r1)     // Catch: java.lang.Throwable -> L56
            android.os.PowerManager r6 = (android.os.PowerManager) r6     // Catch: java.lang.Throwable -> L56
            if (r6 != 0) goto L4d
            r6 = 0
            goto L51
        L4d:
            boolean r6 = r6.isScreenOn()     // Catch: java.lang.Throwable -> L56
        L51:
            if (r6 == 0) goto L55
            r6 = 1
            return r6
        L55:
            return r0
        L56:
            r6 = move-exception
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.zzan(android.content.Context):boolean");
    }

    public static Bitmap zzao(Context context) {
        Bitmap bitmap = null;
        if (context instanceof Activity) {
            try {
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbod)).booleanValue()) {
                    Window window = ((Activity) context).getWindow();
                    if (window != null) {
                        bitmap = zzu(window.getDecorView().getRootView());
                    }
                } else {
                    bitmap = zzt(((Activity) context).getWindow().getDecorView());
                }
            } catch (RuntimeException e) {
                zzagf.zzb("Fail to capture screen shot", e);
            }
            return bitmap;
        }
        return null;
    }

    public static AudioManager zzap(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public static float zzaq(Context context) {
        AudioManager zzap = zzap(context);
        if (zzap == null) {
            return 0.0f;
        }
        int streamMaxVolume = zzap.getStreamMaxVolume(3);
        int streamVolume = zzap.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return streamVolume / streamMaxVolume;
    }

    public static int zzar(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    private static KeyguardManager zzas(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    public static boolean zzat(Context context) {
        KeyguardManager zzas;
        return context != null && com.google.android.gms.common.util.zzq.zzami() && (zzas = zzas(context)) != null && zzas.isKeyguardLocked();
    }

    public static boolean zzau(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        } catch (Throwable th) {
            zzagf.zzb("Error loading class.", th);
            com.google.android.gms.ads.internal.zzbs.zzem().zza(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static int zzav(Context context) {
        return DynamiteModule.zzac(context, ModuleDescriptor.MODULE_ID);
    }

    public static int zzaw(Context context) {
        return DynamiteModule.zzab(context, ModuleDescriptor.MODULE_ID);
    }

    public static Uri zzb(String str, String str2, String str3) throws UnsupportedOperationException {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf != -1) {
            int i = indexOf + 1;
            return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
        }
        return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }

    public static void zzb(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
    }

    public static void zzb(Context context, Intent intent) {
        if (intent != null && com.google.android.gms.common.util.zzq.zzamk()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static void zzb(zzjj zzjjVar, boolean z) {
        Bundle bundle;
        Bundle bundle2 = zzjjVar.zzbdp != null ? zzjjVar.zzbdp : new Bundle();
        if (bundle2.getBundle(AdMobAdapter.class.getName()) != null) {
            bundle = bundle2.getBundle(AdMobAdapter.class.getName());
        } else {
            Bundle bundle3 = new Bundle();
            bundle2.putBundle(AdMobAdapter.class.getName(), bundle3);
            bundle = bundle3;
        }
        bundle.putBoolean("render_test_label", true);
    }

    public static void zzb(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzahh.zza(runnable);
        }
    }

    private static boolean zzb(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    private final JSONObject zzc(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static String zzcd(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public static int zzce(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzagf.zzcu(sb.toString());
            return 0;
        }
    }

    public static boolean zzcf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static String zzci(String str) {
        return TextUtils.isEmpty(str) ? "" : str.split(";")[0].trim();
    }

    public static String zzcj(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(";");
        if (split.length == 1) {
            return "";
        }
        for (int i = 1; i < split.length; i++) {
            if (split[i].trim().startsWith("charset")) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length > 1) {
                    return split2[1].trim();
                }
            }
        }
        return "";
    }

    public static boolean zzd(Context context, String str, String str2) {
        return zzbhf.zzdb(context).checkPermission(str2, str) == 0;
    }

    public static float zzdn() {
        return com.google.android.gms.ads.internal.zzbs.zzff().zzdn();
    }

    public static boolean zzdo() {
        return com.google.android.gms.ads.internal.zzbs.zzff().zzdo();
    }

    public static void zze(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, arrayList);
    }

    public static Map<String, String> zzf(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : com.google.android.gms.ads.internal.zzbs.zzek().zzg(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public static void zzf(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Exception e) {
            zzagf.zzb("Error writing to file in internal storage.", e);
        }
    }

    public static int[] zzf(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        return (window == null || (findViewById = window.findViewById(16908290)) == null) ? zzqd() : new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public static boolean zzp(zzjj zzjjVar) {
        Bundle bundle = zzjjVar.zzbdp != null ? zzjjVar.zzbdp : new Bundle();
        return (bundle.getBundle(AdMobAdapter.class.getName()) != null ? bundle.getBundle(AdMobAdapter.class.getName()) : new Bundle()).getBoolean("render_test_label", false);
    }

    public static String zzq(Context context, String str) {
        try {
            return new String(com.google.android.gms.common.util.zzn.zza(context.openFileInput(str), true), "UTF-8");
        } catch (IOException e) {
            zzagf.zzbx("Error reading from internal storage.");
            return "";
        }
    }

    private static String zzqa() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            stringBuffer.append(" ");
            stringBuffer.append(Build.VERSION.RELEASE);
        }
        stringBuffer.append("; ");
        stringBuffer.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ");
            stringBuffer.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/");
                stringBuffer.append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public static String zzqb() {
        return UUID.randomUUID().toString();
    }

    public static String zzqc() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    private static int[] zzqd() {
        return new int[]{0, 0};
    }

    public static Bundle zzqe() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbit)).booleanValue()) {
                Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbiu)).booleanValue()) {
                Runtime runtime = Runtime.getRuntime();
                bundle.putLong("runtime_free_memory", runtime.freeMemory());
                bundle.putLong("runtime_max_memory", runtime.maxMemory());
                bundle.putLong("runtime_total_memory", runtime.totalMemory());
            }
            bundle.putInt("web_view_count", com.google.android.gms.ads.internal.zzbs.zzem().zzpv());
        } catch (Exception e) {
            zzagf.zzc("Unable to gather memory stats", e);
        }
        return bundle;
    }

    public static Bitmap zzr(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap zzs(View view) {
        if (view == null) {
            return null;
        }
        Bitmap zzu = zzu(view);
        return zzu == null ? zzt(view) : zzu;
    }

    private static Bitmap zzt(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                view.layout(0, 0, width, height);
                view.draw(canvas);
                return createBitmap;
            }
            zzagf.zzcu("Width or height of view is zero");
            return null;
        } catch (RuntimeException e) {
            zzagf.zzb("Fail to capture the webview", e);
            return null;
        }
    }

    private static Bitmap zzu(View view) {
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            r0 = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (RuntimeException e) {
            zzagf.zzb("Fail to capture the web view", e);
        }
        return r0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzv(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 == 0) goto L12
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L12
            android.app.Activity r2 = (android.app.Activity) r2
            goto L13
        L12:
            r2 = r0
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.zzv(android.view.View):boolean");
    }

    public static int zzw(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public final JSONObject zza(Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                return zzc(bundle);
            } catch (JSONException e) {
                zzagf.zzb("Error converting Bundle to JSON", e);
            }
        }
        return null;
    }

    public final void zza(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            com.google.android.gms.ads.internal.zzbs.zzei();
            bundle.putString("device", zzqc());
            bundle.putString("eids", TextUtils.join(",", zznh.zziw()));
        }
        zzkb.zzia();
        zzajr.zza(context, str, str2, bundle, z, new zzahq(this, context, str));
    }

    public final void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", zzp(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final void zza(Context context, List<String> list) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (TextUtils.isEmpty(zzftr.zzff(activity))) {
                return;
            }
            if (list == null) {
                zzagf.v("Cannot ping urls: empty list.");
            } else if (!zzoe.zzh(context)) {
                zzagf.v("Cannot ping url because custom tabs is not supported");
            } else {
                zzoe zzoeVar = new zzoe();
                zzoeVar.zza(new zzaho(this, list, zzoeVar, context));
                zzoeVar.zzd(activity);
            }
        }
    }

    public final boolean zza(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zza(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, zzas(context));
    }

    public final boolean zza(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        if (!com.google.android.gms.ads.internal.zzbs.zzei().zzdax) {
            if (keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) {
                if (!((Boolean) zzkb.zzif().zzd(zznh.zzbmq)).booleanValue() || !zzv(view)) {
                    z = false;
                    if (view.getVisibility() == 0 && view.isShown()) {
                        if ((powerManager != null || powerManager.isScreenOn()) && z) {
                            if (((Boolean) zzkb.zzif().zzd(zznh.zzbmo)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        z = true;
        if (view.getVisibility() == 0) {
            if (powerManager != null || powerManager.isScreenOn()) {
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbmo)).booleanValue()) {
                }
                return true;
            }
        }
        return false;
    }

    public final boolean zzah(Context context) {
        if (this.zzday) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zzahs(this, null), intentFilter);
        this.zzday = true;
        return true;
    }

    public final boolean zzai(Context context) {
        if (this.zzdaz) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new zzahr(this, null), intentFilter);
        this.zzdaz = true;
        return true;
    }

    public final void zzb(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbmt)).booleanValue()) {
            zza(context, str, str2, bundle, z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (((java.lang.String) com.google.android.gms.internal.zzkb.zzif().zzd(com.google.android.gms.internal.zznh.zzbks)).equals(r3.zzdba.pattern()) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzcg(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            monitor-enter(r3)     // Catch: java.util.regex.PatternSyntaxException -> L46
            java.util.regex.Pattern r0 = r3.zzdba     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L25
            com.google.android.gms.internal.zzmx<java.lang.String> r0 = com.google.android.gms.internal.zznh.zzbks     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.zznf r2 = com.google.android.gms.internal.zzkb.zzif()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r2 = r3.zzdba     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r2.pattern()     // Catch: java.lang.Throwable -> L43
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L43
            if (r0 != 0) goto L37
        L25:
            com.google.android.gms.internal.zzmx<java.lang.String> r0 = com.google.android.gms.internal.zznh.zzbks     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.zznf r2 = com.google.android.gms.internal.zzkb.zzif()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch: java.lang.Throwable -> L43
            r3.zzdba = r0     // Catch: java.lang.Throwable -> L43
        L37:
            java.util.regex.Pattern r0 = r3.zzdba     // Catch: java.lang.Throwable -> L43
            java.util.regex.Matcher r4 = r0.matcher(r4)     // Catch: java.lang.Throwable -> L43
            boolean r4 = r4.matches()     // Catch: java.lang.Throwable -> L43
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            return r4
        L43:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            throw r4     // Catch: java.util.regex.PatternSyntaxException -> L46
        L46:
            r4 = move-exception
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.zzcg(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (((java.lang.String) com.google.android.gms.internal.zzkb.zzif().zzd(com.google.android.gms.internal.zznh.zzbkt)).equals(r3.zzdbb.pattern()) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzch(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            monitor-enter(r3)     // Catch: java.util.regex.PatternSyntaxException -> L46
            java.util.regex.Pattern r0 = r3.zzdbb     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L25
            com.google.android.gms.internal.zzmx<java.lang.String> r0 = com.google.android.gms.internal.zznh.zzbkt     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.zznf r2 = com.google.android.gms.internal.zzkb.zzif()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r2 = r3.zzdbb     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r2.pattern()     // Catch: java.lang.Throwable -> L43
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L43
            if (r0 != 0) goto L37
        L25:
            com.google.android.gms.internal.zzmx<java.lang.String> r0 = com.google.android.gms.internal.zznh.zzbkt     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.zznf r2 = com.google.android.gms.internal.zzkb.zzif()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch: java.lang.Throwable -> L43
            r3.zzdbb = r0     // Catch: java.lang.Throwable -> L43
        L37:
            java.util.regex.Pattern r0 = r3.zzdbb     // Catch: java.lang.Throwable -> L43
            java.util.regex.Matcher r4 = r0.matcher(r4)     // Catch: java.lang.Throwable -> L43
            boolean r4 = r4.matches()     // Catch: java.lang.Throwable -> L43
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            return r4
        L43:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            throw r4     // Catch: java.util.regex.PatternSyntaxException -> L46
        L46:
            r4 = move-exception
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.zzch(java.lang.String):boolean");
    }

    public final int[] zzg(Activity activity) {
        int[] zzf = zzf(activity);
        zzkb.zzia();
        zzkb.zzia();
        return new int[]{zzajr.zzd(activity, zzf[0]), zzajr.zzd(activity, zzf[1])};
    }

    public final int[] zzh(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        int[] zzqd = (window == null || (findViewById = window.findViewById(16908290)) == null) ? zzqd() : new int[]{findViewById.getTop(), findViewById.getBottom()};
        zzkb.zzia();
        zzkb.zzia();
        return new int[]{zzajr.zzd(activity, zzqd[0]), zzajr.zzd(activity, zzqd[1])};
    }

    public final String zzp(Context context, String str) {
        synchronized (this.mLock) {
            if (this.zzczb != null) {
                return this.zzczb;
            } else if (str == null) {
                return zzqa();
            } else {
                try {
                    this.zzczb = com.google.android.gms.ads.internal.zzbs.zzek().getDefaultUserAgent(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.zzczb)) {
                    zzkb.zzia();
                    if (zzajr.zzqz()) {
                        this.zzczb = zzaj(context);
                    } else {
                        this.zzczb = null;
                        zzdaw.post(new zzahp(this, context));
                        while (this.zzczb == null) {
                            try {
                                this.mLock.wait();
                            } catch (InterruptedException e2) {
                                this.zzczb = zzqa();
                                String valueOf = String.valueOf(this.zzczb);
                                zzagf.zzcu(valueOf.length() != 0 ? "Interrupted, use default user agent: ".concat(valueOf) : new String("Interrupted, use default user agent: "));
                            }
                        }
                    }
                }
                String valueOf2 = String.valueOf(this.zzczb);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 10 + String.valueOf(str).length());
                sb.append(valueOf2);
                sb.append(" (Mobile; ");
                sb.append(str);
                this.zzczb = sb.toString();
                try {
                    if (zzbhf.zzdb(context).zzamu()) {
                        this.zzczb = String.valueOf(this.zzczb).concat(";aia");
                    }
                } catch (Exception e3) {
                    com.google.android.gms.ads.internal.zzbs.zzem().zza(e3, "AdUtil.getUserAgent");
                }
                this.zzczb = String.valueOf(this.zzczb).concat(")");
                return this.zzczb;
            }
        }
    }

    public final JSONObject zzq(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zza(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }
}
