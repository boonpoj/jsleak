package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzie implements Runnable {
    private /* synthetic */ zzid zzbaw;

    /* loaded from: assets/classes2.dex */
    public static class zza {
        private final zzqp zzGt;

        public zza(zzqp zzqpVar) {
            this.zzGt = zzqpVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.content.Intent zza(android.content.Context r8, java.util.Map<java.lang.String, java.lang.String> r9) {
            /*
                r7 = this;
                java.lang.String r0 = "activity"
                java.lang.Object r0 = r8.getSystemService(r0)
                android.app.ActivityManager r0 = (android.app.ActivityManager) r0
                java.lang.String r1 = "u"
                java.lang.Object r1 = r9.get(r1)
                java.lang.String r1 = (java.lang.String) r1
                boolean r2 = android.text.TextUtils.isEmpty(r1)
                r3 = 0
                if (r2 == 0) goto L18
                return r3
            L18:
                com.google.android.gms.internal.zzqp r2 = r7.zzGt
                if (r2 == 0) goto L26
                com.google.android.gms.internal.zzpi r2 = com.google.android.gms.ads.internal.zzv.zzcJ()
                com.google.android.gms.internal.zzqp r4 = r7.zzGt
                java.lang.String r1 = r2.zza(r4, r1)
            L26:
                android.net.Uri r1 = android.net.Uri.parse(r1)
                java.lang.String r2 = "use_first_package"
                java.lang.Object r2 = r9.get(r2)
                java.lang.String r2 = (java.lang.String) r2
                boolean r2 = java.lang.Boolean.parseBoolean(r2)
                java.lang.String r4 = "use_running_process"
                java.lang.Object r9 = r9.get(r4)
                java.lang.String r9 = (java.lang.String) r9
                boolean r9 = java.lang.Boolean.parseBoolean(r9)
                java.lang.String r4 = "http"
                java.lang.String r5 = r1.getScheme()
                boolean r4 = r4.equalsIgnoreCase(r5)
                if (r4 == 0) goto L5d
                android.net.Uri$Builder r3 = r1.buildUpon()
                java.lang.String r4 = "https"
            L54:
                android.net.Uri$Builder r3 = r3.scheme(r4)
                android.net.Uri r3 = r3.build()
                goto L70
            L5d:
                java.lang.String r4 = "https"
                java.lang.String r5 = r1.getScheme()
                boolean r4 = r4.equalsIgnoreCase(r5)
                if (r4 == 0) goto L70
                android.net.Uri$Builder r3 = r1.buildUpon()
                java.lang.String r4 = "http"
                goto L54
            L70:
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                android.content.Intent r1 = r7.zzf(r1)
                android.content.Intent r3 = r7.zzf(r3)
                android.content.pm.ResolveInfo r5 = r7.zza(r8, r1, r4)
                if (r5 == 0) goto L88
                android.content.Intent r8 = r7.zza(r1, r5)
                return r8
            L88:
                if (r3 == 0) goto L9b
                android.content.pm.ResolveInfo r3 = r7.zza(r8, r3)
                if (r3 == 0) goto L9b
                android.content.Intent r3 = r7.zza(r1, r3)
                android.content.pm.ResolveInfo r8 = r7.zza(r8, r3)
                if (r8 == 0) goto L9b
                return r3
            L9b:
                int r8 = r4.size()
                if (r8 != 0) goto La2
                return r1
            La2:
                if (r9 == 0) goto Ldd
                if (r0 == 0) goto Ldd
                java.util.List r8 = r0.getRunningAppProcesses()
                if (r8 == 0) goto Ldd
                java.util.Iterator r9 = r4.iterator()
            Lb0:
                boolean r0 = r9.hasNext()
                if (r0 == 0) goto Ldd
                java.lang.Object r0 = r9.next()
                android.content.pm.ResolveInfo r0 = (android.content.pm.ResolveInfo) r0
                java.util.Iterator r3 = r8.iterator()
            Lc0:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto Lb0
                java.lang.Object r5 = r3.next()
                android.app.ActivityManager$RunningAppProcessInfo r5 = (android.app.ActivityManager.RunningAppProcessInfo) r5
                java.lang.String r5 = r5.processName
                android.content.pm.ActivityInfo r6 = r0.activityInfo
                java.lang.String r6 = r6.packageName
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto Lc0
                android.content.Intent r8 = r7.zza(r1, r0)
                return r8
            Ldd:
                if (r2 == 0) goto Leb
                r8 = 0
                java.lang.Object r8 = r4.get(r8)
                android.content.pm.ResolveInfo r8 = (android.content.pm.ResolveInfo) r8
                android.content.Intent r8 = r7.zza(r1, r8)
                return r8
            Leb:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzie.zza.zza(android.content.Context, java.util.Map):android.content.Intent");
        }

        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList<>());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    ResolveInfo resolveInfo = queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo.activityInfo.name)) {
                        break;
                    }
                }
            }
            resolveActivity = null;
            arrayList.addAll(queryIntentActivities);
            return resolveActivity;
        }

        public Intent zzf(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzie(zzid zzidVar) {
        this.zzbaw = zzidVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbaw.disconnect();
    }
}
