package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzf implements zzt {
    private final Map<String, List<zzr<?>>> zzp = new HashMap();
    private final zzd zzq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(zzd zzdVar) {
        this.zzq = zzdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean zzb(zzr<?> zzrVar) {
        String url = zzrVar.getUrl();
        if (!this.zzp.containsKey(url)) {
            this.zzp.put(url, null);
            zzrVar.zza((zzt) this);
            if (zzae.DEBUG) {
                zzae.zzb("new request, sending to network %s", url);
            }
            return false;
        }
        List<zzr<?>> list = this.zzp.get(url);
        if (list == null) {
            list = new ArrayList<>();
        }
        zzrVar.zzb("waiting-for-response");
        list.add(zzrVar);
        this.zzp.put(url, list);
        if (zzae.DEBUG) {
            zzae.zzb("Request for cacheKey=%s is in flight, putting on hold.", url);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.zzt
    public final synchronized void zza(zzr<?> zzrVar) {
        String url = zzrVar.getUrl();
        List<zzr<?>> remove = this.zzp.remove(url);
        if (remove != null && !remove.isEmpty()) {
            if (zzae.DEBUG) {
                zzae.zza("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), url);
            }
            zzr<?> remove2 = remove.remove(0);
            this.zzp.put(url, remove);
            remove2.zza((zzt) this);
            try {
                zzd.zza(this.zzq).put(remove2);
            } catch (InterruptedException e) {
                zzae.zzc("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzq.quit();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzt
    public final void zza(zzr<?> zzrVar, zzw<?> zzwVar) {
        List<zzr<?>> remove;
        if (zzwVar.zzbh == null || zzwVar.zzbh.zza()) {
            zza(zzrVar);
            return;
        }
        String url = zzrVar.getUrl();
        synchronized (this) {
            remove = this.zzp.remove(url);
        }
        if (remove != null) {
            if (zzae.DEBUG) {
                zzae.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), url);
            }
            for (zzr<?> zzrVar2 : remove) {
                zzd.zzb(this.zzq).zzb(zzrVar2, zzwVar);
            }
        }
    }
}
