package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class zzdmf {
    private static HashMap<String, String> zzlnf;
    private static Object zzlnk;
    private static boolean zzlnl;
    private static Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static Uri zzlnb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static Pattern zzlnc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static Pattern zzlnd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzlne = new AtomicBoolean();
    private static HashMap<String, Boolean> zzlng = new HashMap<>();
    private static HashMap<String, Integer> zzlnh = new HashMap<>();
    private static HashMap<String, Long> zzlni = new HashMap<>();
    private static HashMap<String, Float> zzlnj = new HashMap<>();
    private static String[] zzlnm = new String[0];

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        Object zzb = zzb(contentResolver);
        long j2 = 0;
        Long l = (Long) zza((HashMap<String, long>) zzlni, str, 0L);
        if (l != null) {
            return l.longValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null) {
            try {
                long parseLong = Long.parseLong(zza);
                l = Long.valueOf(parseLong);
                j2 = parseLong;
            } catch (NumberFormatException e) {
            }
        }
        zza(zzb, zzlni, str, l);
        return j2;
    }

    private static <T> T zza(HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzdmf.class) {
            if (hashMap.containsKey(str)) {
                T t2 = hashMap.get(str);
                if (t2 == null) {
                    t2 = t;
                }
                return t2;
            }
            return null;
        }
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzdmf.class) {
            zza(contentResolver);
            Object obj = zzlnk;
            if (zzlnf.containsKey(str)) {
                String str3 = zzlnf.get(str);
                if (str3 == null) {
                    str3 = null;
                }
                return str3;
            }
            for (String str4 : zzlnm) {
                if (str.startsWith(str4)) {
                    if (!zzlnl || zzlnf.isEmpty()) {
                        zzlnf.putAll(zza(contentResolver, zzlnm));
                        zzlnl = true;
                        if (zzlnf.containsKey(str)) {
                            String str5 = zzlnf.get(str);
                            if (str5 == null) {
                                str5 = null;
                            }
                            return str5;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(1);
                        if (string != null && string.equals(null)) {
                            string = null;
                        }
                        zza(obj, str, string);
                        if (string == null) {
                            string = null;
                        }
                        return string;
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
            return null;
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzlnb, null, null, strArr, null);
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
        if (zzlnf == null) {
            zzlne.set(false);
            zzlnf = new HashMap<>();
            zzlnk = new Object();
            zzlnl = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzdmg(null));
        } else if (zzlne.getAndSet(false)) {
            zzlnf.clear();
            zzlng.clear();
            zzlnh.clear();
            zzlni.clear();
            zzlnj.clear();
            zzlnk = new Object();
            zzlnl = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzdmf.class) {
            if (obj == zzlnk) {
                zzlnf.put(str, str2);
            }
        }
    }

    private static <T> void zza(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzdmf.class) {
            if (obj == zzlnk) {
                hashMap.put(str, t);
                zzlnf.remove(str);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb = zzb(contentResolver);
        Boolean bool = (Boolean) zza(zzlng, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null && !zza.equals("")) {
            if (zzlnc.matcher(zza).matches()) {
                bool = true;
                z = true;
            } else if (zzlnd.matcher(zza).matches()) {
                bool = false;
                z = false;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + zza + "\") as boolean");
            }
        }
        zza(zzb, zzlng, str, bool);
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzdmf.class) {
            zza(contentResolver);
            obj = zzlnk;
        }
        return obj;
    }
}
