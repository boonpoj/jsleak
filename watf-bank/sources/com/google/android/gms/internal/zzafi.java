package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
@zzzv
/* loaded from: classes.dex */
public final class zzafi {
    public static String zzb(String str, Context context) {
        String zzy;
        if (!com.google.android.gms.ads.internal.zzbs.zzfd().zzq(context) || TextUtils.isEmpty(str) || (zzy = com.google.android.gms.ads.internal.zzbs.zzfd().zzy(context)) == null) {
            return str;
        }
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbkv)).booleanValue()) {
            CharSequence charSequence = (String) zzkb.zzif().zzd(zznh.zzbkw);
            if (str.contains(charSequence)) {
                if (com.google.android.gms.ads.internal.zzbs.zzei().zzcg(str)) {
                    com.google.android.gms.ads.internal.zzbs.zzfd().zze(context, zzy);
                    return str.replace(charSequence, zzy);
                } else if (com.google.android.gms.ads.internal.zzbs.zzei().zzch(str)) {
                    com.google.android.gms.ads.internal.zzbs.zzfd().zzf(context, zzy);
                    return str.replace(charSequence, zzy);
                } else {
                    return str;
                }
            }
            return str;
        } else if (str.contains("fbs_aeid")) {
            return str;
        } else {
            if (com.google.android.gms.ads.internal.zzbs.zzei().zzcg(str)) {
                com.google.android.gms.ads.internal.zzbs.zzfd().zze(context, zzy);
                com.google.android.gms.ads.internal.zzbs.zzei();
                return zzahn.zzb(str, "fbs_aeid", zzy).toString();
            } else if (com.google.android.gms.ads.internal.zzbs.zzei().zzch(str)) {
                com.google.android.gms.ads.internal.zzbs.zzfd().zzf(context, zzy);
                com.google.android.gms.ads.internal.zzbs.zzei();
                return zzahn.zzb(str, "fbs_aeid", zzy).toString();
            } else {
                return str;
            }
        }
    }
}
