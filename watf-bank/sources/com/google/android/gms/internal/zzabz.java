package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaca;
import com.google.android.gms.internal.zzzv;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzabz {
    public Location zzbdn;
    public String zzcnf;
    public Bundle zzcnk;
    public Bundle zzcqr;
    public zzacy zzcqs;
    public String zzcqt;
    public AdvertisingIdClient.Info zzcqu;
    public zzaat zzcqv;
    public zzaco zzcqw;
    public boolean zzcqy;
    public JSONObject zzcqx = new JSONObject();
    public List<String> zzcnr = new ArrayList();

    /* renamed from: com.google.android.gms.internal.zzabz$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 extends zzaca.zza {
        AnonymousClass1(zzabz zzabzVar, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzacc, com.google.android.gms.internal.zzabz$zza] */
        public void zza(zzacb zzacbVar) throws RemoteException {
            ((zzacd) zzacbVar.zzwW()).zza(new zza(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: assets/classes2.dex */
    public static class zza extends zzabw {
        private final zzzv.zzb<Status> zzaFq;

        public zza(zzzv.zzb<Status> zzbVar) {
            this.zzaFq = zzbVar;
        }

        public void zzcX(int i) throws RemoteException {
            this.zzaFq.setResult(new Status(i));
        }
    }
}
