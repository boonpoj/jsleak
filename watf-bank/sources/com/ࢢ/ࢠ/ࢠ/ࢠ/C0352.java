package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.FloatRange;
import android.telephony.TelephonyManager;
import com.chartboost.sdk.impl.b;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.ref.WeakReference;
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ޅ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
final class C0352 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String f2465;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static int[] f2468 = {-39340411, 1646369784, -593413711, -1069164445, -50787683, -1327220997, 423245644, -742130253, 54775946, -495304555, 1880137505, 1742082653, 65717847, 1497802820, 828947133, -614454858, 941569790, -1897799303};

    /* renamed from: ࢥ  reason: contains not printable characters */
    private static int f2469 = 0;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private static int f2470 = 1;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static C0354 f2466 = null;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static C0353 f2467 = null;

    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ޅ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0353 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        String f2472;

        /* renamed from: ࢢ  reason: contains not printable characters */
        String f2473;

        /* renamed from: ࢣ  reason: contains not printable characters */
        Integer f2474;

        /* renamed from: ࢤ  reason: contains not printable characters */
        boolean f2475;

        /* renamed from: ࢥ  reason: contains not printable characters */
        boolean f2476;

        /* renamed from: ࢦ  reason: contains not printable characters */
        boolean f2477;

        private C0353() {
            this.f2472 = "_unknown_";
            this.f2473 = "_unknown_";
            this.f2474 = -1;
            this.f2475 = false;
            this.f2476 = false;
            this.f2477 = false;
            try {
                Context m1990 = C0352.m1990();
                if (m1990 != null) {
                    this.f2477 = true;
                    TelephonyManager telephonyManager = (TelephonyManager) m1990.getSystemService("phone");
                    this.f2472 = telephonyManager.getSimOperatorName();
                    this.f2473 = telephonyManager.getNetworkOperatorName();
                    this.f2474 = Integer.valueOf(telephonyManager.getPhoneType());
                    this.f2475 = C0352.m1994();
                    this.f2476 = C0352.m1988(m1990);
                }
            } catch (Exception e) {
                C0348.m1974(e);
            }
        }

        /* synthetic */ C0353(byte b) {
            this();
        }
    }

    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ޅ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0354 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private boolean f2478;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private String f2479;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private String f2480;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private String f2481;

        private C0354() {
            this.f2478 = false;
            this.f2479 = "_unknown_";
            this.f2480 = "_unknown_";
            this.f2481 = "_unknown_";
            try {
                Context m1990 = C0352.m1990();
                if (m1990 == null) {
                    C0379.m2046(3, "Util", this, "Can't get app name, appContext is null.");
                    return;
                }
                this.f2478 = true;
                PackageManager packageManager = m1990.getPackageManager();
                this.f2480 = m1990.getPackageName();
                this.f2479 = packageManager.getApplicationLabel(m1990.getApplicationInfo()).toString();
                this.f2481 = packageManager.getInstallerPackageName(this.f2480);
            } catch (Exception e) {
                C0348.m1974(e);
            }
        }

        /* synthetic */ C0354(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ࢠ  reason: contains not printable characters */
        public final String m1997() {
            return this.f2479;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ࢢ  reason: contains not printable characters */
        public final String m1998() {
            return this.f2480;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ࢣ  reason: contains not printable characters */
        public final String m1999() {
            return this.f2481 != null ? this.f2481 : "_unknown_";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 1.0d)
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static double m1984() {
        try {
            double m1995 = m1995();
            double streamMaxVolume = ((AudioManager) C0381.m2054().getSystemService(m1986(new int[]{-1741845568, 995393484, -1443163044, -1832527325}, 5).intern())).getStreamMaxVolume(3);
            Double.isNaN(m1995);
            Double.isNaN(streamMaxVolume);
            return m1995 / streamMaxVolume;
        } catch (Exception e) {
            C0348.m1974(e);
            return 0.0d;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m1986(int[] iArr, int i) {
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length << 1];
        int[] iArr2 = (int[]) f2468.clone();
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                return new String(cArr2, 0, i);
            }
            cArr[0] = iArr[i2] >>> 16;
            cArr[1] = (char) iArr[i2];
            int i3 = i2 + 1;
            cArr[2] = iArr[i3] >>> 16;
            cArr[3] = (char) iArr[i3];
            b.a(cArr, iArr2, false);
            int i4 = i2 << 1;
            cArr2[i4] = cArr[0];
            cArr2[i4 + 1] = cArr[1];
            cArr2[i4 + 2] = cArr[2];
            cArr2[i4 + 3] = cArr[3];
            i2 += 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1987(final Application application) {
        try {
            AsyncTask.execute(new Runnable() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.ޅ.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(application);
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                            C0379.m2046(3, "Util", this, "User has limited ad tracking");
                            return;
                        }
                        String unused = C0352.f2465 = advertisingIdInfo.getId();
                        C0379.m2046(3, "Util", this, "Retrieved Advertising ID = " + C0352.f2465);
                    } catch (Exception e) {
                        C0348.m1974(e);
                    }
                }
            });
        } catch (Exception e) {
            C0348.m1974(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m1988(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static String m1989() {
        return f2465;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public static Context m1990() {
        WeakReference<Context> weakReference = ((C0385) AbstractC0368.m2030()).f2568;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public static C0354 m1991() {
        if (f2466 == null || !f2466.f2478) {
            f2466 = new C0354((byte) 0);
        }
        return f2466;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public static C0353 m1992() {
        if (f2467 == null || !f2467.f2477) {
            f2467 = new C0353((byte) 0);
        }
        return f2467;
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    static /* synthetic */ boolean m1994() {
        int i;
        WeakReference<Context> weakReference = ((C0385) AbstractC0368.m2030()).f2568;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            int i2 = f2470 + 27;
            f2469 = i2 % 128;
            int i3 = i2 % 2;
            if ((Build.VERSION.SDK_INT < 17 ? (char) 22 : (char) 19) != 22) {
                int i4 = f2470 + 87;
                f2469 = i4 % 128;
                int i5 = i4 % 2;
                i = Settings.Global.getInt(context.getContentResolver(), m1986(new int[]{-474338915, -1244865125, 562481890, 44523707, -1306238932, 74746991}, 11).intern(), 0);
            } else {
                i = Settings.Secure.getInt(context.getContentResolver(), m1986(new int[]{-474338915, -1244865125, 562481890, 44523707, -1306238932, 74746991}, 11).intern(), 0);
            }
        } else {
            i = 0;
        }
        if (!(i == 1)) {
            return false;
        }
        int i6 = f2469 + 33;
        f2470 = i6 % 128;
        int i7 = i6 % 2;
        return true;
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    private static int m1995() {
        try {
            return ((AudioManager) C0381.m2054().getSystemService(m1986(new int[]{-1741845568, 995393484, -1443163044, -1832527325}, 5).intern())).getStreamVolume(3);
        } catch (Exception e) {
            C0348.m1974(e);
            return 0;
        }
    }
}
