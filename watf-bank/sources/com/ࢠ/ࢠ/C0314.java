package com.ࢠ.ࢠ;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.evernote.android.job.֏;
import com.evernote.android.job.ࢠ;
import com.evernote.android.job.ࢣ;
import com.evernote.android.job.ࢦ;
import defpackage.PixelService;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* renamed from: com.ࢠ.ࢠ.އ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0314 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static int f2311;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static int f2312;

    /* renamed from: com.ࢠ.ࢠ.އ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0315 extends com.evernote.android.job.ࢠ {
        C0315() {
        }

        @NonNull
        /* renamed from: ࢠ  reason: contains not printable characters */
        protected ࢠ.ࢠ m1807(@NonNull ࢣ.ࢠ r3) {
            try {
                Set set = com.evernote.android.job.ࢩ.ࢠ().ࢠ("SYS_JOB");
                if (set == null || set.isEmpty()) {
                    C0314.m1804(TimeUnit.MINUTES.toMillis(1L));
                }
            } catch (Throwable unused) {
            }
            return ࢠ.ࢠ.ࢠ;
        }
    }

    /* renamed from: com.ࢠ.ࢠ.އ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0316 extends com.evernote.android.job.ࢣ {
        C0316() {
        }

        @NonNull
        protected ࢣ.ࢢ a_(@NonNull ࢣ.ࢠ r3) {
            C0314.m1804(TimeUnit.MINUTES.toMillis(5L));
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
            } catch (Exception unused) {
            }
            try {
                Context context = ࢩ();
                if (!C0327.m1835(context, PixelService.class.getName())) {
                    C0305.m1741();
                    context.sendBroadcast(new Intent("Ne0hGmDkkivy0aYpZYm"));
                }
            } catch (Throwable unused2) {
            }
            return ࢣ.ࢢ.ࢠ;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1803() {
        com.evernote.android.job.ࢩ.ࢠ(C0337.m1878()).ࢠ(new ࢦ() { // from class: com.ࢠ.ࢠ.އ.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Nullable
            /* renamed from: ࢠ  reason: contains not printable characters */
            public com.evernote.android.job.ࢣ m1806(@NonNull String str) {
                char c;
                int hashCode = str.hashCode();
                if (hashCode != -1019055349) {
                    switch (hashCode) {
                        case -59643907:
                            if (str.equals("SYS_JOB_1")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -59643906:
                            if (str.equals("SYS_JOB_2")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                } else {
                    if (str.equals("SYS_JOB")) {
                        c = 0;
                    }
                    c = 65535;
                }
                switch (c) {
                    case 0:
                        return new C0316();
                    case 1:
                    case 2:
                        return new C0315();
                    default:
                        return null;
                }
            }
        });
        m1804(TimeUnit.MINUTES.toMillis(1L));
        m1805();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m1804(long j) {
        f2311 = new ֏.ࢢ("SYS_JOB").ࢠ(j, TimeUnit.MINUTES.toMillis(1L) + j).ࢠ(TimeUnit.SECONDS.toMillis(10L), ֏.ࢠ.ࢠ).ࢠ(true).ࢠ().ޏ();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    static void m1805() {
        f2312 = com.evernote.android.job.ࢠ.ࢠ(new ֏.ࢢ("SYS_JOB_1"), TimeUnit.HOURS.toMillis(8L), TimeUnit.HOURS.toMillis(11L));
        f2312 = com.evernote.android.job.ࢠ.ࢠ(new ֏.ࢢ("SYS_JOB_2"), TimeUnit.HOURS.toMillis(18L), TimeUnit.HOURS.toMillis(22L));
    }
}
