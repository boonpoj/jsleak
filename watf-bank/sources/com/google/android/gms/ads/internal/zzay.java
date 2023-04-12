package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzade;
import com.google.android.gms.internal.zzael;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzuh;
import com.google.android.gms.internal.zzui;
import com.google.android.gms.internal.zzva;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
final class zzay implements Runnable {
    private /* synthetic */ zzax zzari;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(zzax zzaxVar) {
        this.zzari = zzaxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = this.zzari.zzarh.mContext;
        Runnable runnable = this.zzari.zzarg;
        com.google.android.gms.common.internal.zzbq.zzge("Adapters must be initialized on the main thread.");
        Map<String, zzui> zzox = zzbs.zzem().zzpp().zzox();
        if (zzox == null || zzox.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzagf.zzc("Could not initialize rewarded ads.", th);
                return;
            }
        }
        zzade zzoa = zzade.zzoa();
        if (zzoa != null) {
            Collection<zzui> values = zzox.values();
            HashMap hashMap = new HashMap();
            IObjectWrapper zzz = com.google.android.gms.dynamic.zzn.zzz(context);
            for (zzui zzuiVar : values) {
                for (zzuh zzuhVar : zzuiVar.zzcdj) {
                    String str = zzuhVar.zzccz;
                    for (String str2 : zzuhVar.zzccs) {
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) hashMap.get(str2)).add(str);
                        }
                    }
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzael zzbq = zzoa.zzbq(str3);
                    if (zzbq != null) {
                        zzva zzoi = zzbq.zzoi();
                        if (!zzoi.isInitialized() && zzoi.zzmi()) {
                            zzoi.zza(zzz, zzbq.zzoj(), (List) entry.getValue());
                            String valueOf = String.valueOf(str3);
                            zzagf.zzbx(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (Throwable th2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                    sb.append("Failed to initialize rewarded video mediation adapter \"");
                    sb.append(str3);
                    sb.append("\"");
                    zzagf.zzc(sb.toString(), th2);
                }
            }
        }
    }
}
