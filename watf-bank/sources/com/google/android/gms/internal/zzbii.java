package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
/* loaded from: assets/classes2.dex */
public class zzbii {
    static HashMap<String, String> zzbTP;
    private static Object zzbTQ;
    private static boolean zzbTR;
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri zzbTL = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbTM = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbTN = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzbTO = new AtomicBoolean();
    static String[] zzbTS = new String[0];

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        String string = getString(contentResolver, str);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
                return j;
            }
        }
        return j;
    }

    @Deprecated
    public static String getString(ContentResolver contentResolver, String str) {
        return zza(contentResolver, str, (String) null);
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzbii.class) {
            zza(contentResolver);
            Object obj = zzbTQ;
            if (zzbTP.containsKey(str)) {
                String str3 = zzbTP.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
                return str3;
            }
            for (String str4 : zzbTS) {
                if (str.startsWith(str4)) {
                    if (!zzbTR || zzbTP.isEmpty()) {
                        zzc(contentResolver, zzbTS);
                        if (zzbTP.containsKey(str)) {
                            String str5 = zzbTP.get(str);
                            if (str5 == null) {
                                str5 = str2;
                            }
                            return str5;
                        }
                    }
                    return str2;
                }
            }
            Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(1);
                        if (string != null && string.equals(str2)) {
                            string = str2;
                        }
                        zza(obj, str, string);
                        if (string != null) {
                            str2 = string;
                        }
                        return str2;
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            zza(obj, str, (String) null);
            if (query != null) {
                query.close();
            }
            return str2;
        }
    }

    public static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzbTL, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzbTP == null) {
            zzbTO.set(false);
            zzbTP = new HashMap<>();
            zzbTQ = new Object();
            zzbTR = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new ContentObserver(null) { // from class: com.google.android.gms.internal.zzbii.1
                @Override // android.database.ContentObserver
                public void onChange(boolean z) {
                    zzbii.zzbTO.set(true);
                }
            });
        } else if (zzbTO.getAndSet(false)) {
            zzbTP.clear();
            zzbTQ = new Object();
            zzbTR = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzbii.class) {
            if (obj == zzbTQ) {
                zzbTP.put(str, str2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r3.length != 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void zzb(android.content.ContentResolver r2, java.lang.String... r3) {
        /*
            int r0 = r3.length
            if (r0 != 0) goto L4
            return
        L4:
            java.lang.Class<com.google.android.gms.internal.zzbii> r0 = com.google.android.gms.internal.zzbii.class
            monitor-enter(r0)
            zza(r2)     // Catch: java.lang.Throwable -> L27
            java.lang.String[] r3 = zzk(r3)     // Catch: java.lang.Throwable -> L27
            boolean r1 = com.google.android.gms.internal.zzbii.zzbTR     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L22
            java.util.HashMap<java.lang.String, java.lang.String> r1 = com.google.android.gms.internal.zzbii.zzbTP     // Catch: java.lang.Throwable -> L27
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L1b
            goto L22
        L1b:
            int r1 = r3.length     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L25
        L1e:
            zzc(r2, r3)     // Catch: java.lang.Throwable -> L27
            goto L25
        L22:
            java.lang.String[] r3 = com.google.android.gms.internal.zzbii.zzbTS     // Catch: java.lang.Throwable -> L27
            goto L1e
        L25:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
            return
        L27:
            r2 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbii.zzb(android.content.ContentResolver, java.lang.String[]):void");
    }

    private static void zzc(ContentResolver contentResolver, String[] strArr) {
        zzbTP.putAll(zza(contentResolver, strArr));
        zzbTR = true;
    }

    private static String[] zzk(String[] strArr) {
        HashSet hashSet = new HashSet((((zzbTS.length + strArr.length) * 4) / 3) + 1);
        hashSet.addAll(Arrays.asList(zzbTS));
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (hashSet.add(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return new String[0];
        }
        zzbTS = (String[]) hashSet.toArray(new String[hashSet.size()]);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
