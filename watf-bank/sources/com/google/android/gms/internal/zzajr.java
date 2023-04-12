package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.mopub.common.Constants;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
@zzzv
/* loaded from: classes.dex */
public final class zzajr {
    public static final Handler zzajw = new Handler(Looper.getMainLooper());
    private static final String zzddr = AdView.class.getName();
    private static final String zzdds = InterstitialAd.class.getName();
    private static final String zzddt = PublisherAdView.class.getName();
    private static final String zzddu = PublisherInterstitialAd.class.getName();
    private static final String zzddv = SearchAdView.class.getName();
    private static final String zzddw = AdLoader.class.getName();

    public static int zza(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, i, displayMetrics);
    }

    public static String zza(StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        int i2;
        String str2;
        while (true) {
            i2 = i + 1;
            if (i2 >= stackTraceElementArr.length) {
                str2 = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            String className = stackTraceElement.getClassName();
            i = ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (zzddr.equalsIgnoreCase(className) || zzdds.equalsIgnoreCase(className) || zzddt.equalsIgnoreCase(className) || zzddu.equalsIgnoreCase(className) || zzddv.equalsIgnoreCase(className) || zzddw.equalsIgnoreCase(className))) ? 0 : i2;
        }
        str2 = stackTraceElementArr[i2].getClassName();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            StringBuilder sb = new StringBuilder();
            int i3 = 2;
            if (stringTokenizer.hasMoreElements()) {
                sb.append(stringTokenizer.nextToken());
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 <= 0 || !stringTokenizer.hasMoreElements()) {
                        break;
                    }
                    sb.append(".");
                    sb.append(stringTokenizer.nextToken());
                    i3 = i4;
                }
                str = sb.toString();
            }
            if (str2 != null && !str2.contains(str)) {
                return str2;
            }
        }
        return null;
    }

    public static void zza(Context context, String str, String str2, Bundle bundle, boolean z, zzaju zzajuVar) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", Build.VERSION.RELEASE);
            bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
            bundle.putString("appid", applicationContext.getPackageName());
            if (str == null) {
                com.google.android.gms.common.zzf.zzafy();
                int zzcf = com.google.android.gms.common.zzf.zzcf(context);
                StringBuilder sb = new StringBuilder(23);
                sb.append(zzcf);
                sb.append(".11910000");
                str = sb.toString();
            }
            bundle.putString("js", str);
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme(Constants.HTTPS).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        zzajuVar.zzck(appendQueryParameter.toString());
    }

    private final void zza(ViewGroup viewGroup, zzjn zzjnVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setBackgroundColor(i2);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(i);
        int zzc = zzc(context, 3);
        frameLayout.addView(textView, new FrameLayout.LayoutParams(zzjnVar.widthPixels - zzc, zzjnVar.heightPixels - zzc, 17));
        viewGroup.addView(frameLayout, zzjnVar.widthPixels, zzjnVar.heightPixels);
    }

    public static void zza(boolean z, HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public static int zzav(Context context) {
        return DynamiteModule.zzac(context, ModuleDescriptor.MODULE_ID);
    }

    public static int zzaw(Context context) {
        return DynamiteModule.zzab(context, ModuleDescriptor.MODULE_ID);
    }

    public static int zzb(DisplayMetrics displayMetrics, int i) {
        return Math.round(i / displayMetrics.density);
    }

    public static String zzbc(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return zzcp(((contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id")) == null || zzqy()) ? "emulator" : "emulator");
    }

    public static String zzbd(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return null;
        }
        return Settings.Secure.getString(contentResolver, "android_id");
    }

    public static boolean zzbe(Context context) {
        return com.google.android.gms.common.zzf.zzafy().isGooglePlayServicesAvailable(context) == 0;
    }

    public static boolean zzbf(Context context) {
        int isGooglePlayServicesAvailable = com.google.android.gms.common.zzf.zzafy().isGooglePlayServicesAvailable(context);
        return isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2;
    }

    public static boolean zzbg(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    public static boolean zzbh(Context context) {
        int intValue;
        int intValue2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (com.google.android.gms.common.util.zzq.zzamj()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            intValue = displayMetrics.heightPixels;
            intValue2 = displayMetrics.widthPixels;
        } else {
            try {
                intValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.heightPixels == intValue && displayMetrics.widthPixels == intValue2;
    }

    public static int zzbi(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int zzc(Context context, int i) {
        return zza(context.getResources().getDisplayMetrics(), i);
    }

    public static Throwable zzc(Throwable th) {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbht)).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th3.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (zzcq(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else {
                    String className = stackTraceElement.getClassName();
                    if (!(!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java.")))) {
                        stackTraceElement = new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1);
                    }
                    arrayList.add(stackTraceElement);
                }
            }
            if (z) {
                th2 = th2 == null ? new Throwable(th3.getMessage()) : new Throwable(th3.getMessage(), th2);
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            }
        }
        return th2;
    }

    public static String zzcp(String str) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException e) {
                return null;
            } catch (NoSuchAlgorithmException e2) {
            }
        }
        return null;
    }

    public static boolean zzcq(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) zzkb.zzif().zzd(zznh.zzbhu))) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zzzv.class);
        } catch (Exception e) {
            String valueOf = String.valueOf(str);
            zzakb.zza(valueOf.length() != 0 ? "Fail to check class type for class ".concat(valueOf) : new String("Fail to check class type for class "), e);
            return false;
        }
    }

    public static int zzd(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return zzb(displayMetrics, i);
    }

    public static boolean zzqy() {
        return Build.DEVICE.startsWith("generic");
    }

    public static boolean zzqz() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String zzra() {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public final void zza(Context context, String str, String str2, Bundle bundle, boolean z) {
        zza(context, null, str2, bundle, true, new zzajs(this));
    }

    public final void zza(ViewGroup viewGroup, zzjn zzjnVar, String str) {
        zza(viewGroup, zzjnVar, str, -16777216, -1);
    }

    public final void zza(ViewGroup viewGroup, zzjn zzjnVar, String str, String str2) {
        zzakb.zzcu(str2);
        zza(viewGroup, zzjnVar, str, SupportMenu.CATEGORY_MASK, -16777216);
    }
}
