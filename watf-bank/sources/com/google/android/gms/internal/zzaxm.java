package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
/* loaded from: assets/classes2.dex */
public final class zzaxm {
    public static final Api.zzf<zzaxy> zzahc = new Api.zzf<>();
    public static final Api.zzf<zzaxy> zzbCd = new Api.zzf<>();
    public static final Api.zza<zzaxy, zzaxo> zzahd = new Api.zza<zzaxy, zzaxo>() { // from class: com.google.android.gms.internal.zzaxm.1
        public zzaxy zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzgVar, zzaxo zzaxoVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (zzaxoVar == null) {
                zzaxoVar = zzaxo.zzbCg;
            }
            return new zzaxy(context, looper, true, zzgVar, zzaxoVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    static final Api.zza<zzaxy, zza> zzbCe = new Api.zza<zzaxy, zza>() { // from class: com.google.android.gms.internal.zzaxm.2
        public zzaxy zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzgVar, zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzaxy(context, looper, false, zzgVar, zzaVar.zzOd(), connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Scope zzajd = new Scope(Scopes.PROFILE);
    public static final Scope zzaje = new Scope("email");
    public static final Api<zzaxo> API = new Api<>("SignIn.API", zzahd, zzahc);
    public static final Api<zza> zzaJq = new Api<>("SignIn.INTERNAL_API", zzbCe, zzbCd);

    /* loaded from: assets/classes2.dex */
    public static class zza implements Api.ApiOptions.HasOptions {
        private final Bundle zzbCf;

        public Bundle zzOd() {
            return this.zzbCf;
        }
    }
}
