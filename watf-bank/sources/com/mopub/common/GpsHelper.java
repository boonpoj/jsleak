package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;
import java.lang.ref.WeakReference;
/* loaded from: assets/classes2.dex */
public class GpsHelper {
    public static final int GOOGLE_PLAY_SUCCESS_CODE = 0;
    public static final String IS_LIMIT_AD_TRACKING_ENABLED_KEY = "isLimitAdTrackingEnabled";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String f365 = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    /* loaded from: assets/classes2.dex */
    public static class AdvertisingInfo {
        public final String advertisingId;
        public final boolean limitAdTracking;

        public AdvertisingInfo(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTracking = z;
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface GpsHelperListener {
        void onFetchAdInfoCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.common.GpsHelper$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class AsyncTaskC0170 extends AsyncTask<Void, Void, Void> {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private WeakReference<Context> f366;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private WeakReference<GpsHelperListener> f367;

        public AsyncTaskC0170(Context context, GpsHelperListener gpsHelperListener) {
            this.f366 = new WeakReference<>(context);
            this.f367 = new WeakReference<>(gpsHelperListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public Void doInBackground(Void... voidArr) {
            Context context;
            try {
                context = this.f366.get();
            } catch (Exception unused) {
                MoPubLog.d("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            }
            if (context == null) {
                return null;
            }
            MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(GpsHelper.f365)).addParam((Class<Class>) Context.class, (Class) context).execute();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void onPostExecute(Void r1) {
            GpsHelperListener gpsHelperListener = this.f367.get();
            if (gpsHelperListener != null) {
                gpsHelperListener.onFetchAdInfoCompleted();
            }
        }
    }

    public static void fetchAdvertisingInfoAsync(Context context, GpsHelperListener gpsHelperListener) {
        m427(context, gpsHelperListener);
    }

    @Nullable
    public static AdvertisingInfo fetchAdvertisingInfoSync(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Object execute = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(f365)).addParam((Class<Class>) Context.class, (Class) context).execute();
            return new AdvertisingInfo(m426(execute, (String) null), m428(execute, false));
        } catch (Exception unused) {
            MoPubLog.d("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            return null;
        }
    }

    public static boolean isLimitAdTrackingEnabled(Context context) {
        return SharedPreferencesHelper.getSharedPreferences(context).getBoolean(IS_LIMIT_AD_TRACKING_ENABLED_KEY, false);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static String m426(Object obj, String str) {
        try {
            return (String) MethodBuilderFactory.create(obj, "getId").execute();
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m427(Context context, GpsHelperListener gpsHelperListener) {
        if (!Reflection.classFound(f365)) {
            if (gpsHelperListener != null) {
                gpsHelperListener.onFetchAdInfoCompleted();
                return;
            }
            return;
        }
        try {
            AsyncTasks.safeExecuteOnExecutor(new AsyncTaskC0170(context, gpsHelperListener), new Void[0]);
        } catch (Exception e) {
            MoPubLog.d("Error executing FetchAdvertisingInfoTask", e);
            if (gpsHelperListener != null) {
                gpsHelperListener.onFetchAdInfoCompleted();
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static boolean m428(Object obj, boolean z) {
        try {
            Boolean bool = (Boolean) MethodBuilderFactory.create(obj, IS_LIMIT_AD_TRACKING_ENABLED_KEY).execute();
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception unused) {
            return z;
        }
    }
}
