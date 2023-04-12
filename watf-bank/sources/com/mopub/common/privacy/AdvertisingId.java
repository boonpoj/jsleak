package com.mopub.common.privacy;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: assets/classes2.dex */
public class AdvertisingId implements Serializable {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    final Calendar f465;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    final String f466;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    final String f467;

    /* renamed from: ࢤ  reason: contains not printable characters */
    final boolean f468;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvertisingId(@NonNull String str, @NonNull String str2, boolean z, long j) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str);
        this.f466 = str;
        this.f467 = str2;
        this.f468 = z;
        this.f465 = Calendar.getInstance();
        this.f465.setTimeInMillis(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static AdvertisingId m482() {
        return new AdvertisingId("", m484(), false, (Calendar.getInstance().getTimeInMillis() - 86400000) - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢣ  reason: contains not printable characters */
    public static AdvertisingId m483() {
        return new AdvertisingId("", m484(), false, Calendar.getInstance().getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢤ  reason: contains not printable characters */
    public static String m484() {
        return UUID.randomUUID().toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdvertisingId) {
            AdvertisingId advertisingId = (AdvertisingId) obj;
            if (this.f468 == advertisingId.f468 && this.f466.equals(advertisingId.f466)) {
                return this.f467.equals(advertisingId.f467);
            }
            return false;
        }
        return false;
    }

    @NonNull
    public String getIdWithPrefix(boolean z) {
        StringBuilder sb;
        String str;
        if (this.f468 || !z || this.f466.isEmpty()) {
            sb = new StringBuilder();
            sb.append("mopub:");
            str = this.f467;
        } else {
            sb = new StringBuilder();
            sb.append("ifa:");
            str = this.f466;
        }
        sb.append(str);
        return sb.toString();
    }

    public String getIdentifier(boolean z) {
        return (this.f468 || !z) ? this.f467 : this.f466;
    }

    public int hashCode() {
        return (((this.f466.hashCode() * 31) + this.f467.hashCode()) * 31) + (this.f468 ? 1 : 0);
    }

    public boolean isDoNotTrack() {
        return this.f468;
    }

    public String toString() {
        return "AdvertisingId{mLastRotation=" + this.f465 + ", mAdvertisingId='" + this.f466 + "', mMopubId='" + this.f467 + "', mDoNotTrack=" + this.f468 + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m485() {
        if (TextUtils.isEmpty(this.f466)) {
            return "";
        }
        return "ifa:" + this.f466;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public boolean m486() {
        return Calendar.getInstance().getTimeInMillis() - this.f465.getTimeInMillis() >= 86400000;
    }
}
