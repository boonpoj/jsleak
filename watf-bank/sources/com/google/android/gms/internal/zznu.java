package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zznu {
    private boolean zzbrz;
    private String zzbss;
    private zznu zzbst;
    private final List<zzns> zzbsq = new LinkedList();
    private final Map<String, String> zzbsr = new LinkedHashMap();
    private final Object mLock = new Object();

    public zznu(boolean z, String str, String str2) {
        this.zzbrz = z;
        this.zzbsr.put("action", str);
        this.zzbsr.put("ad_format", str2);
    }

    public final boolean zza(zzns zznsVar, long j, String... strArr) {
        synchronized (this.mLock) {
            for (String str : strArr) {
                this.zzbsq.add(new zzns(j, str, zznsVar));
            }
        }
        return true;
    }

    public final boolean zza(zzns zznsVar, String... strArr) {
        if (!this.zzbrz || zznsVar == null) {
            return false;
        }
        return zza(zznsVar, com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime(), strArr);
    }

    public final void zzao(String str) {
        if (this.zzbrz) {
            synchronized (this.mLock) {
                this.zzbss = str;
            }
        }
    }

    public final void zzc(zznu zznuVar) {
        synchronized (this.mLock) {
            this.zzbst = zznuVar;
        }
    }

    public final zzns zzd(long j) {
        if (this.zzbrz) {
            return new zzns(j, null, null);
        }
        return null;
    }

    public final void zzf(String str, String str2) {
        zznk zzpc;
        if (!this.zzbrz || TextUtils.isEmpty(str2) || (zzpc = com.google.android.gms.ads.internal.zzbs.zzem().zzpc()) == null) {
            return;
        }
        synchronized (this.mLock) {
            zzno zzam = zzpc.zzam(str);
            Map<String, String> map = this.zzbsr;
            map.put(str, zzam.zze(map.get(str), str2));
        }
    }

    public final zzns zzjf() {
        return zzd(com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime());
    }

    public final String zzjg() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.mLock) {
            for (zzns zznsVar : this.zzbsq) {
                long time = zznsVar.getTime();
                String zzjc = zznsVar.zzjc();
                zzns zzjd = zznsVar.zzjd();
                if (zzjd != null && time > 0) {
                    sb2.append(zzjc);
                    sb2.append('.');
                    sb2.append(time - zzjd.getTime());
                    sb2.append(',');
                }
            }
            this.zzbsq.clear();
            if (!TextUtils.isEmpty(this.zzbss)) {
                sb2.append(this.zzbss);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> zzjh() {
        synchronized (this.mLock) {
            zznk zzpc = com.google.android.gms.ads.internal.zzbs.zzem().zzpc();
            if (zzpc != null && this.zzbst != null) {
                return zzpc.zza(this.zzbsr, this.zzbst.zzjh());
            }
            return this.zzbsr;
        }
    }

    public final zzns zzji() {
        synchronized (this.mLock) {
        }
        return null;
    }
}
