package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzzv;
import net.sqlcipher.database.SQLiteDatabase;
@zzzv
/* loaded from: classes.dex */
public final class zzl {
    public static void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzcje == 4 && adOverlayInfoParcel.zzcix == null) {
            if (adOverlayInfoParcel.zzciw != null) {
                adOverlayInfoParcel.zzciw.onAdClicked();
            }
            zzbs.zzef();
            zza.zza(context, adOverlayInfoParcel.zzciv, adOverlayInfoParcel.zzcjd);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzaty.zzdel);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!com.google.android.gms.common.util.zzq.zzamn()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        zzbs.zzei();
        zzahn.zza(context, intent);
    }
}
