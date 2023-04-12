package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzaac implements zzit {
    static final zzit zzcmt = new zzaac();

    /* loaded from: assets/classes2.dex */
    private class zza implements OnFailureListener, OnSuccessListener<Void> {
        private zza() {
        }

        @Nullable
        private ConnectionResult zzvs() {
            int intValue;
            ConnectionResult connectionResult = null;
            int i = 0;
            for (Api api : zzaac.zzg(zzaac.this).keySet()) {
                ConnectionResult connectionResult2 = (ConnectionResult) zzaac.zzc(zzaac.this).get(((com.google.android.gms.common.api.zzc) zzaac.zzb(zzaac.this).get(api.zzuH())).getApiKey());
                if (!connectionResult2.isSuccess() && (intValue = ((Integer) zzaac.zzg(zzaac.this).get(api)).intValue()) != 2 && (intValue != 1 || connectionResult2.hasResolution() || zzaac.zzh(zzaac.this).isUserResolvableError(connectionResult2.getErrorCode()))) {
                    int priority = api.zzuF().getPriority();
                    if (connectionResult == null || i > priority) {
                        i = priority;
                        connectionResult = connectionResult2;
                    }
                }
            }
            return connectionResult;
        }

        private void zzvt() {
            if (zzaac.zzi(zzaac.this) == null) {
                zzaac.zzd(zzaac.this).zzaAs = Collections.emptySet();
                return;
            }
            HashSet hashSet = new HashSet(zzaac.zzi(zzaac.this).zzxe());
            Map zzxg = zzaac.zzi(zzaac.this).zzxg();
            for (Api api : zzxg.keySet()) {
                ConnectionResult connectionResult = (ConnectionResult) zzaac.zzc(zzaac.this).get(((com.google.android.gms.common.api.zzc) zzaac.zzb(zzaac.this).get(api.zzuH())).getApiKey());
                if (connectionResult != null && connectionResult.isSuccess()) {
                    hashSet.addAll(((zzg.zza) zzxg.get(api)).zzajm);
                }
            }
            zzaac.zzd(zzaac.this).zzaAs = hashSet;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            com.google.android.gms.common.api.zzb zzbVar = (com.google.android.gms.common.api.zzb) exc;
            zzaac.zza(zzaac.this).lock();
            try {
                zzaac.zza(zzaac.this, zzbVar.zzuK());
                zzaac.zza(zzaac.this, zzvs());
                if (zzaac.zzf(zzaac.this) == null) {
                    zzvt();
                    zzaac.zzd(zzaac.this).zzo(null);
                } else {
                    zzaac.zza(zzaac.this, false);
                    zzaac.zzd(zzaac.this).zzc(zzaac.zzf(zzaac.this));
                }
                zzaac.zze(zzaac.this).signalAll();
            } finally {
                zzaac.zza(zzaac.this).unlock();
            }
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: zza */
        public void onSuccess(Void r4) {
            zzaac.zza(zzaac.this).lock();
            try {
                zzaac.zza(zzaac.this, new ArrayMap(zzaac.zzb(zzaac.this).size()));
                for (Api.zzc zzcVar : zzaac.zzb(zzaac.this).keySet()) {
                    zzaac.zzc(zzaac.this).put(((com.google.android.gms.common.api.zzc) zzaac.zzb(zzaac.this).get(zzcVar)).getApiKey(), ConnectionResult.zzawX);
                }
                zzvt();
                zzaac.zzd(zzaac.this).zzo(null);
                zzaac.zze(zzaac.this).signalAll();
            } finally {
                zzaac.zza(zzaac.this).unlock();
            }
        }
    }

    private zzaac() {
    }

    @Override // com.google.android.gms.internal.zzit
    public final void zza(zzjc zzjcVar) {
        zzjcVar.zzbcz.zzbct = 3;
    }
}
