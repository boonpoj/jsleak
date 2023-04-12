package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.internal.zzbhf;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class zzy {
    private static final Method zzgew = zzamp();
    private static final Method zzgex = zzamq();
    private static final Method zzgey = zzamr();
    private static final Method zzgez = zzams();
    private static final Method zzgfa = zzamt();

    private static int zza(WorkSource workSource) {
        Method method = zzgey;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    private static String zza(WorkSource workSource, int i) {
        Method method = zzgfa;
        if (method != null) {
            try {
                return (String) method.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                return null;
            }
        }
        return null;
    }

    public static WorkSource zzaa(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfo = zzbhf.zzdb(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    String valueOf = String.valueOf(str);
                    Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
                    return null;
                }
                return zze(applicationInfo.uid, str);
            } catch (PackageManager.NameNotFoundException e) {
                String valueOf2 = String.valueOf(str);
                Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            }
        }
        return null;
    }

    private static Method zzamp() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzamq() {
        if (zzq.zzamk()) {
            try {
                return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception e) {
            }
        }
        return null;
    }

    private static Method zzamr() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzams() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzamt() {
        if (zzq.zzamk()) {
            try {
                return WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static List<String> zzb(WorkSource workSource) {
        int zza = workSource == null ? 0 : zza(workSource);
        if (zza == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zza; i++) {
            String zza2 = zza(workSource, i);
            if (!zzu.zzgs(zza2)) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }

    public static boolean zzcy(Context context) {
        return (context == null || context.getPackageManager() == null || zzbhf.zzdb(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0035 -> B:15:0x0038). Please submit an issue!!! */
    private static WorkSource zze(int i, String str) {
        WorkSource workSource = new WorkSource();
        try {
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
        }
        if (zzgex == null) {
            Method method = zzgew;
            if (method != null) {
                method.invoke(workSource, Integer.valueOf(i));
            }
            return workSource;
        }
        if (str == null) {
            str = "";
        }
        zzgex.invoke(workSource, Integer.valueOf(i), str);
        return workSource;
    }
}
