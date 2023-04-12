package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ނ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0347 implements LocationListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0347 f2441;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private ScheduledExecutorService f2442;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private ScheduledFuture<?> f2443;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private ScheduledFuture<?> f2444;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private LocationManager f2445;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f2446;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private Location f2447;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f2448;

    private C0347() {
        try {
            this.f2446 = ((C0385) AbstractC0368.m2030()).f2566;
            if (this.f2446) {
                C0379.m2046(3, "LocationManager", this, "Moat location services disabled");
                return;
            }
            this.f2442 = Executors.newScheduledThreadPool(1);
            this.f2445 = (LocationManager) C0381.m2054().getSystemService("location");
            if (this.f2445.getAllProviders().size() == 0) {
                C0379.m2046(3, "LocationManager", this, "Device has no location providers");
            } else {
                m1961();
            }
        } catch (Exception e) {
            C0348.m1974(e);
        }
    }

    /* renamed from: ֏  reason: contains not printable characters */
    private boolean m1953() {
        boolean z;
        if (!(ContextCompat.checkSelfPermission(C0381.m2054().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0)) {
            if (!(ContextCompat.checkSelfPermission(C0381.m2054().getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                z = false;
                return (z || this.f2445.getProvider("network") == null || !this.f2445.isProviderEnabled("network")) ? false : true;
            }
        }
        z = true;
        if (z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0347 m1954() {
        if (f2441 == null) {
            f2441 = new C0347();
        }
        return f2441;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1956(boolean z) {
        try {
            C0379.m2046(3, "LocationManager", this, "stopping location fetch");
            m1964();
            m1965();
            if (z) {
                m1967();
            } else {
                m1966();
            }
        } catch (Exception e) {
            C0348.m1974(e);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m1957(Location location) {
        if (location == null) {
            return false;
        }
        return !(location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) && location.getAccuracy() >= 0.0f && ((float) ((System.currentTimeMillis() - location.getTime()) / 1000)) < 600.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m1958(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        return (location == null || location2 == null || location.getTime() != location2.getTime()) ? false : true;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static Location m1959(Location location, Location location2) {
        boolean m1957 = m1957(location);
        boolean m19572 = m1957(location2);
        if (m1957) {
            return (m19572 && location.getAccuracy() >= location.getAccuracy()) ? location2 : location;
        } else if (m19572) {
            return location2;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public void m1961() {
        try {
            if (!this.f2446 && this.f2445 != null) {
                if (this.f2448) {
                    C0379.m2046(3, "LocationManager", this, "already updating location");
                }
                C0379.m2046(3, "LocationManager", this, "starting location fetch");
                this.f2447 = m1959(this.f2447, m1962());
                if (this.f2447 == null) {
                    m1963();
                    return;
                }
                C0379.m2046(3, "LocationManager", this, "Have a valid location, won't fetch = " + this.f2447.toString());
                m1967();
            }
        } catch (Exception e) {
            C0348.m1974(e);
        }
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private Location m1962() {
        LocationManager locationManager;
        String str;
        Location lastKnownLocation;
        try {
            boolean m1968 = m1968();
            boolean m1953 = m1953();
            if (m1968 && m1953) {
                lastKnownLocation = m1959(this.f2445.getLastKnownLocation("gps"), this.f2445.getLastKnownLocation("network"));
            } else {
                if (m1968) {
                    locationManager = this.f2445;
                    str = "gps";
                } else if (!m1953) {
                    return null;
                } else {
                    locationManager = this.f2445;
                    str = "network";
                }
                lastKnownLocation = locationManager.getLastKnownLocation(str);
            }
            return lastKnownLocation;
        } catch (SecurityException e) {
            C0348.m1974(e);
            return null;
        }
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    private void m1963() {
        try {
            if (this.f2448) {
                return;
            }
            C0379.m2046(3, "LocationManager", this, "Attempting to start update");
            if (m1968()) {
                C0379.m2046(3, "LocationManager", this, "start updating gps location");
                this.f2445.requestLocationUpdates("gps", 0L, 0.0f, this, Looper.getMainLooper());
                this.f2448 = true;
            }
            if (m1953()) {
                C0379.m2046(3, "LocationManager", this, "start updating network location");
                this.f2445.requestLocationUpdates("network", 0L, 0.0f, this, Looper.getMainLooper());
                this.f2448 = true;
            }
            if (this.f2448) {
                m1965();
                this.f2444 = this.f2442.schedule(new Runnable() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.ނ.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            C0379.m2046(3, "LocationManager", this, "fetchTimedOut");
                            C0347.this.m1956(true);
                        } catch (Exception e) {
                            C0348.m1974(e);
                        }
                    }
                }, 60L, TimeUnit.SECONDS);
            }
        } catch (SecurityException e) {
            C0348.m1974(e);
        }
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    private void m1964() {
        try {
            C0379.m2046(3, "LocationManager", this, "Stopping to update location");
            boolean z = true;
            if (!(ContextCompat.checkSelfPermission(C0381.m2054().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0)) {
                if (!(ContextCompat.checkSelfPermission(C0381.m2054().getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                    z = false;
                }
            }
            if (!z || this.f2445 == null) {
                return;
            }
            this.f2445.removeUpdates(this);
            this.f2448 = false;
        } catch (SecurityException e) {
            C0348.m1974(e);
        }
    }

    /* renamed from: ࢩ  reason: contains not printable characters */
    private void m1965() {
        if (this.f2444 == null || this.f2444.isCancelled()) {
            return;
        }
        this.f2444.cancel(true);
        this.f2444 = null;
    }

    /* renamed from: ࢪ  reason: contains not printable characters */
    private void m1966() {
        if (this.f2443 == null || this.f2443.isCancelled()) {
            return;
        }
        this.f2443.cancel(true);
        this.f2443 = null;
    }

    /* renamed from: ࢫ  reason: contains not printable characters */
    private void m1967() {
        C0379.m2046(3, "LocationManager", this, "Resetting fetch timer");
        m1966();
        float f = 600.0f;
        if (this.f2447 != null) {
            f = Math.max(600.0f - ((float) ((System.currentTimeMillis() - this.f2447.getTime()) / 1000)), 0.0f);
        }
        this.f2443 = this.f2442.schedule(new Runnable() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.ނ.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C0379.m2046(3, "LocationManager", this, "fetchTimerCompleted");
                    C0347.this.m1961();
                } catch (Exception e) {
                    C0348.m1974(e);
                }
            }
        }, f, TimeUnit.SECONDS);
    }

    /* renamed from: ࢬ  reason: contains not printable characters */
    private boolean m1968() {
        return (ContextCompat.checkSelfPermission(C0381.m2054().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) && this.f2445.getProvider("gps") != null && this.f2445.isProviderEnabled("gps");
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        try {
            C0379.m2046(3, "LocationManager", this, "Received an updated location = " + location.toString());
            float currentTimeMillis = (float) ((System.currentTimeMillis() - location.getTime()) / 1000);
            if (!location.hasAccuracy() || location.getAccuracy() > 100.0f || currentTimeMillis >= 600.0f) {
                return;
            }
            this.f2447 = m1959(this.f2447, location);
            C0379.m2046(3, "LocationManager", this, "fetchCompleted");
            m1956(true);
        } catch (Exception e) {
            C0348.m1974(e);
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public final Location m1969() {
        if (this.f2446 || this.f2445 == null) {
            return null;
        }
        return this.f2447;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public final void m1970() {
        m1961();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public final void m1971() {
        m1956(false);
    }
}
