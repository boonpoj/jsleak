package com.mopub.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: assets/classes2.dex */
public class DateAndTime {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static DateAndTime f614 = new DateAndTime();

    public static String getTimeZoneOffsetString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Z", Locale.US);
        simpleDateFormat.setTimeZone(localTimeZone());
        return simpleDateFormat.format(now());
    }

    public static TimeZone localTimeZone() {
        return f614.internalLocalTimeZone();
    }

    public static Date now() {
        return f614.internalNow();
    }

    @Deprecated
    public static void setInstance(DateAndTime dateAndTime) {
        f614 = dateAndTime;
    }

    public TimeZone internalLocalTimeZone() {
        return TimeZone.getDefault();
    }

    public Date internalNow() {
        return new Date();
    }
}
