package com.mopub.common.logging;

import android.support.annotation.NonNull;
import android.util.Log;
import com.mopub.common.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
/* loaded from: assets/classes2.dex */
public class MoPubLog {
    public static final String LOGGER_NAMESPACE = "com.mopub";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final Logger f462 = Logger.getLogger(LOGGER_NAMESPACE);

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static final C0175 f463 = new C0175();

    /* renamed from: com.mopub.common.logging.MoPubLog$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static final class C0175 extends Handler {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private static final Map<Level, Integer> f464 = new HashMap(7);

        static {
            f464.put(Level.FINEST, 2);
            f464.put(Level.FINER, 2);
            f464.put(Level.FINE, 2);
            f464.put(Level.CONFIG, 3);
            f464.put(Level.INFO, 4);
            f464.put(Level.WARNING, 5);
            f464.put(Level.SEVERE, 6);
        }

        private C0175() {
        }

        @Override // java.util.logging.Handler
        public void close() {
        }

        @Override // java.util.logging.Handler
        public void flush() {
        }

        @Override // java.util.logging.Handler
        public void publish(LogRecord logRecord) {
            Throwable thrown;
            if (isLoggable(logRecord)) {
                int intValue = f464.containsKey(logRecord.getLevel()) ? f464.get(logRecord.getLevel()).intValue() : 2;
                String str = logRecord.getMessage() + "\n";
                if (logRecord.getThrown() != null) {
                    str = str + Log.getStackTraceString(thrown);
                }
                Log.println(intValue, "MoPub", str);
            }
        }
    }

    static {
        f462.setUseParentHandlers(false);
        f462.setLevel(Level.ALL);
        f463.setLevel(Level.FINE);
        LogManager.getLogManager().addLogger(f462);
        m481(f462, f463);
    }

    private MoPubLog() {
    }

    public static void c(String str) {
        c(str, null);
    }

    public static void c(String str, Throwable th) {
        f462.log(Level.FINEST, str, th);
    }

    public static void d(String str) {
        d(str, null);
    }

    public static void d(String str, Throwable th) {
        f462.log(Level.CONFIG, str, th);
    }

    public static void e(String str) {
        e(str, null);
    }

    public static void e(String str, Throwable th) {
        f462.log(Level.SEVERE, str, th);
    }

    public static void i(String str) {
        i(str, null);
    }

    public static void i(String str, Throwable th) {
        f462.log(Level.INFO, str, th);
    }

    @VisibleForTesting
    public static void setSdkHandlerLevel(@NonNull Level level) {
        f463.setLevel(level);
    }

    public static void v(String str) {
        v(str, null);
    }

    public static void v(String str, Throwable th) {
        f462.log(Level.FINE, str, th);
    }

    public static void w(String str) {
        w(str, null);
    }

    public static void w(String str, Throwable th) {
        f462.log(Level.WARNING, str, th);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m481(@NonNull Logger logger, @NonNull Handler handler) {
        for (Handler handler2 : logger.getHandlers()) {
            if (handler2.equals(handler)) {
                return;
            }
        }
        logger.addHandler(handler);
    }
}
