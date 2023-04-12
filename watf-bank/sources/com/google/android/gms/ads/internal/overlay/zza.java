package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzzv;
import net.sqlcipher.database.SQLiteDatabase;
@zzzv
/* loaded from: classes.dex */
public final class zza {
    private static boolean zza(Context context, Intent intent, zzq zzqVar) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzagf.v(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzbs.zzei();
            zzahn.zza(context, intent);
            if (zzqVar != null) {
                zzqVar.zzbt();
                return true;
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzagf.zzcu(e.getMessage());
            return false;
        }
    }

    public static boolean zza(Context context, zzc zzcVar, zzq zzqVar) {
        String str;
        int i = 0;
        if (zzcVar == null) {
            str = "No intent data for launcher overlay.";
        } else {
            zznh.initialize(context);
            if (zzcVar.intent != null) {
                return zza(context, zzcVar.intent, zzqVar);
            }
            Intent intent = new Intent();
            if (!TextUtils.isEmpty(zzcVar.url)) {
                if (TextUtils.isEmpty(zzcVar.mimeType)) {
                    intent.setData(Uri.parse(zzcVar.url));
                } else {
                    intent.setDataAndType(Uri.parse(zzcVar.url), zzcVar.mimeType);
                }
                intent.setAction("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(zzcVar.packageName)) {
                    intent.setPackage(zzcVar.packageName);
                }
                if (!TextUtils.isEmpty(zzcVar.zzchu)) {
                    String[] split = zzcVar.zzchu.split("/", 2);
                    if (split.length < 2) {
                        String valueOf = String.valueOf(zzcVar.zzchu);
                        zzagf.zzcu(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                        return false;
                    }
                    intent.setClassName(split[0], split[1]);
                }
                String str2 = zzcVar.zzchv;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        i = Integer.parseInt(str2);
                    } catch (NumberFormatException e) {
                        zzagf.zzcu("Could not parse intent flags.");
                    }
                    intent.addFlags(i);
                }
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbqt)).booleanValue()) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
                } else {
                    if (((Boolean) zzkb.zzif().zzd(zznh.zzbqs)).booleanValue()) {
                        zzbs.zzei();
                        zzahn.zzb(context, intent);
                    }
                }
                return zza(context, intent, zzqVar);
            }
            str = "Open GMSG did not contain a URL.";
        }
        zzagf.zzcu(str);
        return false;
    }
}
