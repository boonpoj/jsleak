package com.mopub.common.util;

import java.security.MessageDigest;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: assets/classes2.dex */
public class Utils {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final AtomicLong f643 = new AtomicLong(1);

    public static boolean bitMaskContainsFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static long generateUniqueId() {
        long j;
        long j2;
        do {
            j = f643.get();
            j2 = j + 1;
        } while (!f643.compareAndSet(j, j2 <= 9223372036854775806L ? j2 : 1L));
        return j;
    }

    public static String sha1(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%02X", Byte.valueOf(digest[i])));
            }
            return sb.toString().toLowerCase(Locale.US);
        } catch (Exception unused) {
            return "";
        }
    }
}
