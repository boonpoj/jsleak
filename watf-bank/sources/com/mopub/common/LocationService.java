package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import java.math.BigDecimal;
/* loaded from: assets/classes2.dex */
public class LocationService {

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static volatile LocationService f368;
    @Nullable
    @VisibleForTesting

    /* renamed from: ࢠ  reason: contains not printable characters */
    Location f369;
    @VisibleForTesting

    /* renamed from: ࢢ  reason: contains not printable characters */
    long f370;

    /* loaded from: assets/classes2.dex */
    public enum LocationAwareness {
        NORMAL,
        TRUNCATED,
        DISABLED;

        @Deprecated
        public static LocationAwareness fromMoPubLocationAwareness(MoPub.LocationAwareness locationAwareness) {
            return locationAwareness == MoPub.LocationAwareness.DISABLED ? DISABLED : locationAwareness == MoPub.LocationAwareness.TRUNCATED ? TRUNCATED : NORMAL;
        }

        @Deprecated
        public MoPub.LocationAwareness getNewLocationAwareness() {
            return this == TRUNCATED ? MoPub.LocationAwareness.TRUNCATED : this == DISABLED ? MoPub.LocationAwareness.DISABLED : MoPub.LocationAwareness.NORMAL;
        }
    }

    /* loaded from: assets/classes2.dex */
    public enum ValidLocationProvider {
        NETWORK("network"),
        GPS("gps");
        
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        final String f374;

        ValidLocationProvider(String str) {
            this.f374 = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ࢠ  reason: contains not printable characters */
        public boolean m436(@NonNull Context context) {
            switch (this) {
                case NETWORK:
                    return DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION") || DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION");
                case GPS:
                    return DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION");
                default:
                    return false;
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f374;
        }
    }

    private LocationService() {
    }

    @VisibleForTesting
    @Deprecated
    public static void clearLastKnownLocation() {
        m433().f369 = null;
    }

    @Nullable
    public static Location getLastKnownLocation(@NonNull Context context, int i, @NonNull MoPub.LocationAwareness locationAwareness) {
        if (MoPub.canCollectPersonalInformation()) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(locationAwareness);
            if (locationAwareness == MoPub.LocationAwareness.DISABLED) {
                return null;
            }
            LocationService m433 = m433();
            if (m435()) {
                return m433.f369;
            }
            Location m432 = m432(m431(context, ValidLocationProvider.GPS), m431(context, ValidLocationProvider.NETWORK));
            if (locationAwareness == MoPub.LocationAwareness.TRUNCATED) {
                m434(m432, i);
            }
            m433.f369 = m432;
            m433.f370 = SystemClock.elapsedRealtime();
            return m432;
        }
        return null;
    }

    @Nullable
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static Location m431(@NonNull Context context, @NonNull ValidLocationProvider validLocationProvider) {
        StringBuilder sb;
        String str;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(validLocationProvider);
        if (MoPub.canCollectPersonalInformation() && validLocationProvider.m436(context)) {
            try {
                return ((LocationManager) context.getSystemService("location")).getLastKnownLocation(validLocationProvider.toString());
            } catch (IllegalArgumentException unused) {
                sb = new StringBuilder();
                sb.append("Failed to retrieve location: device has no ");
                sb.append(validLocationProvider.toString());
                str = " location provider.";
                sb.append(str);
                MoPubLog.d(sb.toString());
                return null;
            } catch (NullPointerException unused2) {
                sb = new StringBuilder();
                sb.append("Failed to retrieve location: device has no ");
                sb.append(validLocationProvider.toString());
                str = " location provider.";
                sb.append(str);
                MoPubLog.d(sb.toString());
                return null;
            } catch (SecurityException unused3) {
                sb = new StringBuilder();
                sb.append("Failed to retrieve location from ");
                sb.append(validLocationProvider.toString());
                str = " provider: access appears to be disabled.";
                sb.append(str);
                MoPubLog.d(sb.toString());
                return null;
            }
        }
        return null;
    }

    @Nullable
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static Location m432(@Nullable Location location, @Nullable Location location2) {
        return location == null ? location2 : (location2 != null && location.getTime() <= location2.getTime()) ? location2 : location;
    }

    @NonNull
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static LocationService m433() {
        LocationService locationService = f368;
        if (locationService == null) {
            synchronized (LocationService.class) {
                locationService = f368;
                if (locationService == null) {
                    locationService = new LocationService();
                    f368 = locationService;
                }
            }
        }
        return locationService;
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m434(@Nullable Location location, int i) {
        if (location == null || i < 0) {
            return;
        }
        location.setLatitude(BigDecimal.valueOf(location.getLatitude()).setScale(i, 5).doubleValue());
        location.setLongitude(BigDecimal.valueOf(location.getLongitude()).setScale(i, 5).doubleValue());
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static boolean m435() {
        LocationService m433 = m433();
        return m433.f369 != null && SystemClock.elapsedRealtime() - m433.f370 <= MoPub.getMinimumLocationRefreshTimeMillis();
    }
}
