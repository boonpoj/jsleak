package com.mopub.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.MoPubIdentifier;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import java.util.Locale;
/* loaded from: assets/classes2.dex */
public class ClientMetadata {

    /* renamed from: ࢩ  reason: contains not printable characters */
    private static volatile ClientMetadata f279;

    /* renamed from: ֏  reason: contains not printable characters */
    private final String f280;

    /* renamed from: ؠ  reason: contains not printable characters */
    private final String f281;

    /* renamed from: ހ  reason: contains not printable characters */
    private final String f282;

    /* renamed from: ށ  reason: contains not printable characters */
    private final String f283;

    /* renamed from: ނ  reason: contains not printable characters */
    private String f284;

    /* renamed from: ރ  reason: contains not printable characters */
    private final Context f285;

    /* renamed from: ބ  reason: contains not printable characters */
    private final ConnectivityManager f286;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f287;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f288;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f289;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f290;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private String f291;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private String f292;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private String f293;
    @NonNull

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final MoPubIdentifier f294;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final String f295;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private final String f296;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private final String f297;

    /* loaded from: assets/classes2.dex */
    public enum MoPubNetworkType {
        UNKNOWN(0),
        ETHERNET(1),
        WIFI(2),
        MOBILE(3),
        GG(4),
        GGG(5),
        GGGG(6);
        

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final int f299;

        MoPubNetworkType(int i) {
            this.f299 = i;
        }

        public int getId() {
            return this.f299;
        }

        @Override // java.lang.Enum
        public String toString() {
            return Integer.toString(this.f299);
        }
    }

    public ClientMetadata(@NonNull Context context) {
        ApplicationInfo applicationInfo;
        String str;
        Preconditions.checkNotNull(context);
        this.f285 = context.getApplicationContext();
        this.f286 = (ConnectivityManager) this.f285.getSystemService("connectivity");
        this.f295 = Build.MANUFACTURER;
        this.f296 = Build.MODEL;
        this.f297 = Build.PRODUCT;
        this.f280 = Build.VERSION.RELEASE;
        this.f281 = "5.4.1";
        this.f282 = m372(this.f285);
        PackageManager packageManager = this.f285.getPackageManager();
        this.f283 = this.f285.getPackageName();
        try {
            applicationInfo = packageManager.getApplicationInfo(this.f283, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            this.f284 = (String) packageManager.getApplicationLabel(applicationInfo);
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.f285.getSystemService("phone");
        if (telephonyManager != null) {
            this.f287 = telephonyManager.getNetworkOperator();
            this.f288 = telephonyManager.getNetworkOperator();
            if (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) {
                this.f287 = telephonyManager.getSimOperator();
                this.f289 = telephonyManager.getSimOperator();
            }
            if (MoPub.canCollectPersonalInformation()) {
                this.f290 = telephonyManager.getNetworkCountryIso();
                str = telephonyManager.getSimCountryIso();
            } else {
                this.f290 = "";
                str = "";
            }
            this.f291 = str;
            try {
                this.f292 = telephonyManager.getNetworkOperatorName();
                if (telephonyManager.getSimState() == 5) {
                    this.f293 = telephonyManager.getSimOperatorName();
                }
            } catch (SecurityException unused2) {
                this.f292 = null;
                this.f293 = null;
            }
        }
        this.f294 = new MoPubIdentifier(this.f285);
    }

    @VisibleForTesting
    @Deprecated
    public static void clearForTesting() {
        f279 = null;
    }

    @NonNull
    public static String getCurrentLanguage(@NonNull Context context) {
        String trim = Locale.getDefault().getLanguage().trim();
        Locale locale = context.getResources().getConfiguration().locale;
        return (locale == null || locale.getLanguage().trim().isEmpty()) ? trim : locale.getLanguage().trim();
    }

    @Nullable
    public static ClientMetadata getInstance() {
        ClientMetadata clientMetadata = f279;
        if (clientMetadata == null) {
            synchronized (ClientMetadata.class) {
                clientMetadata = f279;
            }
        }
        return clientMetadata;
    }

    @NonNull
    public static ClientMetadata getInstance(@NonNull Context context) {
        ClientMetadata clientMetadata = f279;
        if (clientMetadata == null) {
            synchronized (ClientMetadata.class) {
                clientMetadata = f279;
                if (clientMetadata == null) {
                    clientMetadata = new ClientMetadata(context);
                    f279 = clientMetadata;
                }
            }
        }
        return clientMetadata;
    }

    @VisibleForTesting
    @Deprecated
    public static void setInstance(ClientMetadata clientMetadata) {
        synchronized (ClientMetadata.class) {
            f279 = clientMetadata;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m372(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            MoPubLog.d("Failed to retrieve PackageInfo#versionName.");
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public MoPubNetworkType getActiveNetworkType() {
        if (DeviceUtils.isPermissionGranted(this.f285, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = this.f286.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return MoPubNetworkType.UNKNOWN;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                for (Network network : this.f286.getAllNetworks()) {
                    NetworkCapabilities networkCapabilities = this.f286.getNetworkCapabilities(network);
                    if (networkCapabilities != null && networkCapabilities.hasTransport(3)) {
                        return MoPubNetworkType.ETHERNET;
                    }
                }
            } else if (activeNetworkInfo.getType() == 9) {
                return MoPubNetworkType.ETHERNET;
            }
            NetworkInfo networkInfo = this.f286.getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isConnected()) {
                NetworkInfo networkInfo2 = this.f286.getNetworkInfo(0);
                if (networkInfo2 == null || !networkInfo2.isConnected()) {
                    return MoPubNetworkType.UNKNOWN;
                }
                switch (networkInfo2.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return MoPubNetworkType.GG;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                        return MoPubNetworkType.GGG;
                    case 13:
                    case 15:
                        return MoPubNetworkType.GGGG;
                    default:
                        return MoPubNetworkType.MOBILE;
                }
            }
            return MoPubNetworkType.WIFI;
        }
        return MoPubNetworkType.UNKNOWN;
    }

    public String getAppName() {
        return this.f284;
    }

    public String getAppPackageName() {
        return this.f283;
    }

    public String getAppVersion() {
        return this.f282;
    }

    public float getDensity() {
        return this.f285.getResources().getDisplayMetrics().density;
    }

    public Point getDeviceDimensions() {
        return Preconditions.NoThrow.checkNotNull(this.f285) ? DeviceUtils.getDeviceDimensions(this.f285) : new Point(0, 0);
    }

    public Locale getDeviceLocale() {
        return this.f285.getResources().getConfiguration().locale;
    }

    public String getDeviceManufacturer() {
        return this.f295;
    }

    public String getDeviceModel() {
        return this.f296;
    }

    public String getDeviceOsVersion() {
        return this.f280;
    }

    public String getDeviceProduct() {
        return this.f297;
    }

    public int getDeviceScreenHeightDip() {
        return Dips.screenHeightAsIntDips(this.f285);
    }

    public int getDeviceScreenWidthDip() {
        return Dips.screenWidthAsIntDips(this.f285);
    }

    public String getIsoCountryCode() {
        return MoPub.canCollectPersonalInformation() ? this.f290 : "";
    }

    @NonNull
    public MoPubIdentifier getMoPubIdentifier() {
        return this.f294;
    }

    public String getNetworkOperator() {
        return this.f288;
    }

    public String getNetworkOperatorForUrl() {
        return this.f287;
    }

    public String getNetworkOperatorName() {
        return this.f292;
    }

    public String getOrientationString() {
        int i = this.f285.getResources().getConfiguration().orientation;
        return i == 1 ? "p" : i == 2 ? "l" : i == 3 ? "s" : "u";
    }

    public String getSdkVersion() {
        return this.f281;
    }

    public String getSimIsoCountryCode() {
        return MoPub.canCollectPersonalInformation() ? this.f291 : "";
    }

    public String getSimOperator() {
        return this.f289;
    }

    public String getSimOperatorName() {
        return this.f293;
    }

    public void repopulateCountryData() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f285.getSystemService("phone");
        if (!MoPub.canCollectPersonalInformation() || telephonyManager == null) {
            return;
        }
        this.f290 = telephonyManager.getNetworkCountryIso();
        this.f291 = telephonyManager.getSimCountryIso();
    }
}
