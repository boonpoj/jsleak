package com.mopub.common;

import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import java.util.IllegalFormatException;
/* loaded from: assets/classes2.dex */
public final class Preconditions {
    public static final String EMPTY_ARGUMENTS = "";

    /* loaded from: assets/classes2.dex */
    public static final class NoThrow {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private static volatile boolean f410 = false;

        public static boolean checkArgument(boolean z) {
            return Preconditions.m460(z, f410, "Illegal argument", "");
        }

        public static boolean checkArgument(boolean z, String str) {
            return Preconditions.m460(z, f410, str, "");
        }

        public static boolean checkArgument(boolean z, String str, Object... objArr) {
            return Preconditions.m460(z, f410, str, objArr);
        }

        public static boolean checkNotNull(Object obj) {
            return Preconditions.m457(obj, f410, "Object can not be null.", "");
        }

        public static boolean checkNotNull(Object obj, String str) {
            return Preconditions.m457(obj, f410, str, "");
        }

        public static boolean checkNotNull(Object obj, String str, Object... objArr) {
            return Preconditions.m457(obj, f410, str, objArr);
        }

        public static boolean checkState(boolean z) {
            return Preconditions.m461(z, f410, "Illegal state.", "");
        }

        public static boolean checkState(boolean z, String str) {
            return Preconditions.m461(z, f410, str, "");
        }

        public static boolean checkState(boolean z, String str, Object... objArr) {
            return Preconditions.m461(z, f410, str, objArr);
        }

        public static boolean checkUiThread() {
            return Preconditions.m458(f410, "This method must be called from the UI thread.", "");
        }

        public static boolean checkUiThread(String str) {
            return Preconditions.m458(f410, str, "");
        }

        public static boolean checkUiThread(String str, Object... objArr) {
            return Preconditions.m458(false, str, objArr);
        }

        public static void setStrictMode(boolean z) {
            f410 = z;
        }
    }

    private Preconditions() {
    }

    public static void checkArgument(boolean z) {
        m460(z, true, "Illegal argument.", "");
    }

    public static void checkArgument(boolean z, String str) {
        m460(z, true, str, "");
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        m460(z, true, str, objArr);
    }

    public static void checkNotNull(Object obj) {
        m457(obj, true, "Object can not be null.", "");
    }

    public static void checkNotNull(Object obj, String str) {
        m457(obj, true, str, "");
    }

    public static void checkNotNull(Object obj, String str, Object... objArr) {
        m457(obj, true, str, objArr);
    }

    public static void checkState(boolean z) {
        m461(z, true, "Illegal state.", "");
    }

    public static void checkState(boolean z, String str) {
        m461(z, true, str, "");
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        m461(z, true, str, objArr);
    }

    public static void checkUiThread() {
        m458(true, "This method must be called from the UI thread.", "");
    }

    public static void checkUiThread(String str) {
        m458(true, str, "");
    }

    public static void checkUiThread(String str, Object... objArr) {
        m458(true, str, objArr);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m453(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        try {
            return String.format(valueOf, objArr);
        } catch (IllegalFormatException e) {
            MoPubLog.e("MoPub preconditions had a format exception: " + e.getMessage());
            return valueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static boolean m457(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String m453 = m453(str, objArr);
        if (z) {
            throw new NullPointerException(m453);
        }
        MoPubLog.e(m453);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static boolean m458(boolean z, String str, Object... objArr) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String m453 = m453(str, objArr);
        if (z) {
            throw new IllegalStateException(m453);
        }
        MoPubLog.e(m453);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public static boolean m460(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String m453 = m453(str, objArr);
        if (z2) {
            throw new IllegalArgumentException(m453);
        }
        MoPubLog.e(m453);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public static boolean m461(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String m453 = m453(str, objArr);
        if (z2) {
            throw new IllegalStateException(m453);
        }
        MoPubLog.e(m453);
        return false;
    }
}
