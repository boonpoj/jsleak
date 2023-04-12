package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzoe implements zzftt {
    private CustomTabsSession zzbsy;
    private CustomTabsClient zzbsz;
    private CustomTabsServiceConnection zzbta;
    private zzof zzbtb;

    public static boolean zzh(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && resolveActivity != null) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzftr.zzff(context));
                }
            }
        }
        return false;
    }

    public final boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        CustomTabsClient customTabsClient = this.zzbsz;
        if (customTabsClient == null) {
            return false;
        }
        if (customTabsClient == null) {
            this.zzbsy = null;
        } else if (this.zzbsy == null) {
            this.zzbsy = customTabsClient.newSession((CustomTabsCallback) null);
        }
        CustomTabsSession customTabsSession = this.zzbsy;
        if (customTabsSession == null) {
            return false;
        }
        return customTabsSession.mayLaunchUrl(uri, (Bundle) null, (List) null);
    }

    @Override // com.google.android.gms.internal.zzftt
    public final void zza(CustomTabsClient customTabsClient) {
        this.zzbsz = customTabsClient;
        this.zzbsz.warmup(0L);
        zzof zzofVar = this.zzbtb;
        if (zzofVar != null) {
            zzofVar.zzjl();
        }
    }

    public final void zza(zzof zzofVar) {
        this.zzbtb = zzofVar;
    }

    public final void zzc(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.zzbta;
        if (customTabsServiceConnection == null) {
            return;
        }
        activity.unbindService(customTabsServiceConnection);
        this.zzbsz = null;
        this.zzbsy = null;
        this.zzbta = null;
    }

    public final void zzd(Activity activity) {
        String zzff;
        if (this.zzbsz == null && (zzff = zzftr.zzff(activity)) != null) {
            this.zzbta = new zzfts(this);
            CustomTabsClient.bindCustomTabsService(activity, zzff, this.zzbta);
        }
    }

    @Override // com.google.android.gms.internal.zzftt
    public final void zzjk() {
        this.zzbsz = null;
        this.zzbsy = null;
    }
}
