package com.mopub.common.privacy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.GpsHelper;
import com.mopub.common.Preconditions;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import java.util.Calendar;
/* loaded from: assets/classes2.dex */
public class MoPubIdentifier {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private AdvertisingId f504;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Context f505;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private AdvertisingIdChangeListener f506;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f507;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f508;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private volatile SdkInitializationListener f509;

    /* loaded from: assets/classes2.dex */
    public interface AdvertisingIdChangeListener {
        void onIdChanged(@NonNull AdvertisingId advertisingId, @NonNull AdvertisingId advertisingId2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.common.privacy.MoPubIdentifier$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class AsyncTaskC0178 extends AsyncTask<Void, Void, Void> {
        private AsyncTaskC0178() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public Void doInBackground(Void... voidArr) {
            MoPubIdentifier.this.m516();
            MoPubIdentifier.this.f507 = false;
            return null;
        }
    }

    public MoPubIdentifier(@NonNull Context context) {
        this(context, null);
    }

    @VisibleForTesting
    MoPubIdentifier(@NonNull Context context, @Nullable AdvertisingIdChangeListener advertisingIdChangeListener) {
        Preconditions.checkNotNull(context);
        this.f505 = context;
        this.f506 = advertisingIdChangeListener;
        this.f504 = m508(this.f505);
        if (this.f504 == null) {
            this.f504 = AdvertisingId.m482();
        }
        m514();
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    static synchronized AdvertisingId m508(@NonNull Context context) {
        synchronized (MoPubIdentifier.class) {
            Preconditions.checkNotNull(context);
            Calendar calendar = Calendar.getInstance();
            try {
                SharedPreferences sharedPreferences = SharedPreferencesHelper.getSharedPreferences(context, "com.mopub.settings.identifier");
                String string = sharedPreferences.getString("privacy.identifier.ifa", "");
                String string2 = sharedPreferences.getString("privacy.identifier.mopub", "");
                long j = sharedPreferences.getLong("privacy.identifier.time", calendar.getTimeInMillis());
                boolean z = sharedPreferences.getBoolean("privacy.limit.ad.tracking", false);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    return new AdvertisingId(string, string2, z, j);
                }
            } catch (ClassCastException unused) {
                MoPubLog.e("Cannot read identifier from shared preferences");
            }
            return null;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static synchronized void m509(@NonNull Context context, @NonNull AdvertisingId advertisingId) {
        synchronized (MoPubIdentifier.class) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(advertisingId);
            SharedPreferences.Editor edit = SharedPreferencesHelper.getSharedPreferences(context, "com.mopub.settings.identifier").edit();
            edit.putBoolean("privacy.limit.ad.tracking", advertisingId.f468);
            edit.putString("privacy.identifier.ifa", advertisingId.f466);
            edit.putString("privacy.identifier.mopub", advertisingId.f467);
            edit.putLong("privacy.identifier.time", advertisingId.f465.getTimeInMillis());
            edit.apply();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m510(@NonNull AdvertisingId advertisingId, @NonNull AdvertisingId advertisingId2) {
        Preconditions.checkNotNull(advertisingId2);
        if (this.f506 != null) {
            this.f506.onIdChanged(advertisingId, advertisingId2);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m511(@NonNull String str, @NonNull String str2, boolean z, long j) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        m518(new AdvertisingId(str, str2, z, j));
    }

    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    private AdvertisingId m513(@NonNull Context context) {
        Preconditions.NoThrow.checkNotNull(context);
        ContentResolver contentResolver = context.getContentResolver();
        int i = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", -1);
        String string = Settings.Secure.getString(contentResolver, "advertising_id");
        if (i == -1 || TextUtils.isEmpty(string)) {
            return null;
        }
        boolean z = i != 0;
        AdvertisingId advertisingId = this.f504;
        return new AdvertisingId(string, advertisingId.f467, z, advertisingId.f465.getTimeInMillis());
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m514() {
        if (this.f507) {
            return;
        }
        this.f507 = true;
        AsyncTasks.safeExecuteOnExecutor(new AsyncTaskC0178(), new Void[0]);
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private synchronized void m515() {
        SdkInitializationListener sdkInitializationListener = this.f509;
        if (sdkInitializationListener != null) {
            this.f509 = null;
            sdkInitializationListener.onInitializationFinished();
        }
    }

    @NonNull
    public AdvertisingId getAdvertisingInfo() {
        AdvertisingId advertisingId = this.f504;
        m514();
        return advertisingId;
    }

    public void setIdChangeListener(@Nullable AdvertisingIdChangeListener advertisingIdChangeListener) {
        this.f506 = advertisingIdChangeListener;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m516() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        AdvertisingId advertisingId = this.f504;
        GpsHelper.AdvertisingInfo fetchAdvertisingInfoSync = GpsHelper.fetchAdvertisingInfoSync(this.f505);
        AdvertisingId m513 = (fetchAdvertisingInfoSync == null || TextUtils.isEmpty(fetchAdvertisingInfoSync.advertisingId)) ? m513(this.f505) : new AdvertisingId(fetchAdvertisingInfoSync.advertisingId, advertisingId.f467, fetchAdvertisingInfoSync.limitAdTracking, advertisingId.f465.getTimeInMillis());
        if (m513 != null) {
            String m484 = advertisingId.m486() ? AdvertisingId.m484() : advertisingId.f467;
            if (!advertisingId.m486()) {
                timeInMillis = advertisingId.f465.getTimeInMillis();
            }
            m511(m513.f466, m484, m513.f468, timeInMillis);
        }
        m519();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m517(@Nullable SdkInitializationListener sdkInitializationListener) {
        this.f509 = sdkInitializationListener;
        if (this.f508) {
            m515();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m518(@NonNull AdvertisingId advertisingId) {
        AdvertisingId advertisingId2 = this.f504;
        this.f504 = advertisingId;
        m509(this.f505, this.f504);
        if (!this.f504.equals(advertisingId2) || !this.f508) {
            m510(advertisingId2, this.f504);
        }
        this.f508 = true;
        m515();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    void m519() {
        m518(!this.f504.m486() ? this.f504 : AdvertisingId.m483());
    }
}
