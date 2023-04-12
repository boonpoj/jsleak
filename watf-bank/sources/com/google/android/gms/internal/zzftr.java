package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
public final class zzftr {
    private static String zzrab;

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ab, code lost:
        if (r6.contains("com.google.android.apps.chrome") != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String zzff(android.content.Context r10) {
        /*
            java.lang.String r0 = com.google.android.gms.internal.zzftr.zzrab
            if (r0 == 0) goto L5
            return r0
        L5:
            android.content.pm.PackageManager r0 = r10.getPackageManager()
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "http://www.example.com"
            android.net.Uri r2 = android.net.Uri.parse(r2)
            java.lang.String r3 = "android.intent.action.VIEW"
            r1.<init>(r3, r2)
            r2 = 0
            android.content.pm.ResolveInfo r3 = r0.resolveActivity(r1, r2)
            r4 = 0
            if (r3 == 0) goto L23
            android.content.pm.ActivityInfo r3 = r3.activityInfo
            java.lang.String r3 = r3.packageName
            goto L24
        L23:
            r3 = r4
        L24:
            java.util.List r5 = r0.queryIntentActivities(r1, r2)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L31:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L5c
            java.lang.Object r7 = r5.next()
            android.content.pm.ResolveInfo r7 = (android.content.pm.ResolveInfo) r7
            android.content.Intent r8 = new android.content.Intent
            r8.<init>()
            java.lang.String r9 = "android.support.customtabs.action.CustomTabsService"
            r8.setAction(r9)
            android.content.pm.ActivityInfo r9 = r7.activityInfo
            java.lang.String r9 = r9.packageName
            r8.setPackage(r9)
            android.content.pm.ResolveInfo r8 = r0.resolveService(r8, r2)
            if (r8 == 0) goto L31
            android.content.pm.ActivityInfo r7 = r7.activityInfo
            java.lang.String r7 = r7.packageName
            r6.add(r7)
            goto L31
        L5c:
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L65
            com.google.android.gms.internal.zzftr.zzrab = r4
            goto Lae
        L65:
            int r0 = r6.size()
            r4 = 1
            if (r0 != r4) goto L75
            java.lang.Object r10 = r6.get(r2)
            java.lang.String r10 = (java.lang.String) r10
        L72:
            com.google.android.gms.internal.zzftr.zzrab = r10
            goto Lae
        L75:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L8a
            boolean r10 = zzj(r10, r1)
            if (r10 != 0) goto L8a
            boolean r10 = r6.contains(r3)
            if (r10 == 0) goto L8a
            com.google.android.gms.internal.zzftr.zzrab = r3
            goto Lae
        L8a:
            java.lang.String r10 = "com.android.chrome"
            boolean r0 = r6.contains(r10)
            if (r0 == 0) goto L93
        L92:
            goto L72
        L93:
            java.lang.String r10 = "com.chrome.beta"
            boolean r0 = r6.contains(r10)
            if (r0 == 0) goto L9c
            goto L92
        L9c:
            java.lang.String r10 = "com.chrome.dev"
            boolean r0 = r6.contains(r10)
            if (r0 == 0) goto La5
            goto L92
        La5:
            java.lang.String r10 = "com.google.android.apps.chrome"
            boolean r0 = r6.contains(r10)
            if (r0 == 0) goto Lae
            goto L92
        Lae:
            java.lang.String r10 = com.google.android.gms.internal.zzftr.zzrab
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzftr.zzff(android.content.Context):java.lang.String");
    }

    private static boolean zzj(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        try {
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        } catch (RuntimeException e) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
        if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
