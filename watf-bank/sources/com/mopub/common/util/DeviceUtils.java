package com.mopub.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Reflection;
import java.io.File;
import java.net.SocketException;
/* loaded from: assets/classes2.dex */
public class DeviceUtils {

    /* loaded from: assets/classes2.dex */
    public enum ForceOrientation {
        FORCE_PORTRAIT("portrait"),
        FORCE_LANDSCAPE("landscape"),
        DEVICE_ORIENTATION("device"),
        UNDEFINED("");
        
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final String f616;

        ForceOrientation(String str) {
            this.f616 = str;
        }

        @NonNull
        public static ForceOrientation getForceOrientation(@Nullable String str) {
            ForceOrientation[] values;
            for (ForceOrientation forceOrientation : values()) {
                if (forceOrientation.f616.equalsIgnoreCase(str)) {
                    return forceOrientation;
                }
            }
            return UNDEFINED;
        }
    }

    @Deprecated
    /* loaded from: assets/classes2.dex */
    public enum IP {
        IPv4,
        IPv6
    }

    private DeviceUtils() {
    }

    public static long diskCacheSizeBytes(File file) {
        return diskCacheSizeBytes(file, 31457280L);
    }

    public static long diskCacheSizeBytes(File file, long j) {
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (statFs.getBlockCount() * statFs.getBlockSize()) / 50;
        } catch (IllegalArgumentException unused) {
            MoPubLog.d("Unable to calculate 2% of available disk space, defaulting to minimum");
        }
        return Math.max(Math.min(j, 104857600L), 31457280L);
    }

    @TargetApi(17)
    public static Point getDeviceDimensions(@NonNull Context context) {
        Integer num;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Integer num2 = null;
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            Integer valueOf = Integer.valueOf(point.x);
            num2 = Integer.valueOf(point.y);
            num = valueOf;
        } else {
            try {
                num = (Integer) new Reflection.MethodBuilder(defaultDisplay, "getRawWidth").execute();
            } catch (Exception e) {
                e = e;
                num = null;
            }
            try {
                num2 = (Integer) new Reflection.MethodBuilder(defaultDisplay, "getRawHeight").execute();
            } catch (Exception e2) {
                e = e2;
                MoPubLog.v("Display#getRawWidth/Height failed.", e);
                if (num != null) {
                }
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                num = Integer.valueOf(displayMetrics.widthPixels);
                num2 = Integer.valueOf(displayMetrics.heightPixels);
                return new Point(num.intValue(), num2.intValue());
            }
        }
        if (num != null || num2 == null) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            num = Integer.valueOf(displayMetrics2.widthPixels);
            num2 = Integer.valueOf(displayMetrics2.heightPixels);
        }
        return new Point(num.intValue(), num2.intValue());
    }

    @Nullable
    @Deprecated
    public static String getHashedUdid(Context context) {
        return null;
    }

    @Nullable
    @Deprecated
    public static String getIpAddress(IP ip) throws SocketException {
        return null;
    }

    public static int getScreenOrientation(@NonNull Activity activity) {
        return m583(activity.getWindowManager().getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
    }

    public static boolean isNetworkAvailable(@Nullable Context context) {
        if (context != null && isPermissionGranted(context, "android.permission.INTERNET")) {
            if (isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE")) {
                try {
                    return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
                } catch (NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isPermissionGranted(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void lockOrientation(@NonNull Activity activity, @NonNull CreativeOrientation creativeOrientation) {
        if (Preconditions.NoThrow.checkNotNull(creativeOrientation) && Preconditions.NoThrow.checkNotNull(activity)) {
            int m583 = m583(((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
            int i = 8;
            if (CreativeOrientation.PORTRAIT == creativeOrientation) {
                i = 9 == m583 ? 9 : 1;
            } else if (CreativeOrientation.LANDSCAPE != creativeOrientation) {
                return;
            } else {
                if (8 != m583) {
                    i = 0;
                }
            }
            activity.setRequestedOrientation(i);
        }
    }

    public static int memoryCacheSizeBytes(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        long memoryClass = activityManager.getMemoryClass();
        try {
            if (Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null))) {
                memoryClass = ((Integer) new Reflection.MethodBuilder(activityManager, "getLargeMemoryClass").execute()).intValue();
            }
        } catch (Exception unused) {
            MoPubLog.d("Unable to reflectively determine large heap size.");
        }
        return (int) Math.min(31457280L, (memoryClass / 8) * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static int m583(int i, int i2) {
        if (1 == i2) {
            switch (i) {
                case 1:
                case 2:
                    return 9;
                default:
                    return 1;
            }
        } else if (2 != i2) {
            MoPubLog.d("Unknown screen orientation. Defaulting to portrait.");
            return 9;
        } else {
            switch (i) {
                case 2:
                case 3:
                    return 8;
                default:
                    return 0;
            }
        }
    }
}
