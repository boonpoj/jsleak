package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzzv;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzc implements zzt<zzanh> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        zzanh zzanhVar2 = zzanhVar;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get(AvidJSONUtil.KEY_TIMESTAMP);
            if (TextUtils.isEmpty(str2)) {
                zzagf.zzcu("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzagf.zzcu("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = zzbs.zzeo().elapsedRealtime() + (Long.parseLong(str4) - zzbs.zzeo().currentTimeMillis());
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzanhVar2.zzsj().zza(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e) {
                    zzagf.zzc("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzagf.zzcu("No value given for CSI experiment.");
                return;
            }
            zznu zzje = zzanhVar2.zzsj().zzje();
            if (zzje == null) {
                zzagf.zzcu("No ticker for WebView, dropping experiment ID.");
            } else {
                zzje.zzf("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzagf.zzcu("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzagf.zzcu("No name given for CSI extra.");
            } else {
                zznu zzje2 = zzanhVar2.zzsj().zzje();
                if (zzje2 == null) {
                    zzagf.zzcu("No ticker for WebView, dropping extra parameter.");
                } else {
                    zzje2.zzf(str6, str7);
                }
            }
        }
    }
}
