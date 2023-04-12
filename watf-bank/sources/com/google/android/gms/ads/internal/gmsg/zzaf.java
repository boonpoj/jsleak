package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.internal.zzaeq;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzzv;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzaf implements zzt<Object> {
    private final zzag zzbyn;

    public zzaf(zzag zzagVar) {
        this.zzbyn = zzagVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if (!"grant".equals(str)) {
            if ("video_start".equals(str)) {
                this.zzbyn.zzdl();
                return;
            }
            return;
        }
        zzaeq zzaeqVar = null;
        try {
            int parseInt = Integer.parseInt(map.get("amount"));
            String str2 = map.get(VastExtensionXmlManager.TYPE);
            if (!TextUtils.isEmpty(str2)) {
                zzaeqVar = new zzaeq(str2, parseInt);
            }
        } catch (NumberFormatException e) {
            zzagf.zzc("Unable to parse reward amount.", e);
        }
        this.zzbyn.zzb(zzaeqVar);
    }
}
