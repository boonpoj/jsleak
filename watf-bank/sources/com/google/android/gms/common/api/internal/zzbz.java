package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzca;
@Deprecated
/* loaded from: classes.dex */
public final class zzbz {
    private static final Object sLock = new Object();
    private static zzbz zzfty;
    private final String mAppId;
    private final Status zzftz;
    private final boolean zzfua;
    private final boolean zzfub;

    private zzbz(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            r3 = resources.getInteger(identifier) != 0;
            this.zzfub = !r3;
        } else {
            this.zzfub = false;
        }
        this.zzfua = r3;
        String zzcp = zzbf.zzcp(context);
        zzcp = zzcp == null ? new zzca(context).getString("google_app_id") : zzcp;
        if (TextUtils.isEmpty(zzcp)) {
            this.zzftz = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.mAppId = null;
            return;
        }
        this.mAppId = zzcp;
        this.zzftz = Status.zzfni;
    }

    public static String zzajh() {
        return zzfz("getGoogleAppId").mAppId;
    }

    public static boolean zzaji() {
        return zzfz("isMeasurementExplicitlyDisabled").zzfub;
    }

    public static Status zzck(Context context) {
        Status status;
        zzbq.checkNotNull(context, "Context must not be null.");
        synchronized (sLock) {
            if (zzfty == null) {
                zzfty = new zzbz(context);
            }
            status = zzfty.zzftz;
        }
        return status;
    }

    private static zzbz zzfz(String str) {
        zzbz zzbzVar;
        synchronized (sLock) {
            if (zzfty == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
            zzbzVar = zzfty;
        }
        return zzbzVar;
    }
}
