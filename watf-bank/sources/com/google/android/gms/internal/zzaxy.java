package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzaxv;
/* loaded from: assets/classes2.dex */
public class zzaxy extends com.google.android.gms.common.internal.zzl<zzaxv> implements zzaxn {
    private Integer zzaEe;
    private final com.google.android.gms.common.internal.zzg zzazs;
    private final Bundle zzbCf;
    private final boolean zzbCq;

    public zzaxy(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzg zzgVar, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzgVar, connectionCallbacks, onConnectionFailedListener);
        this.zzbCq = z;
        this.zzazs = zzgVar;
        this.zzbCf = bundle;
        this.zzaEe = zzgVar.zzxl();
    }

    public zzaxy(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzg zzgVar, zzaxo zzaxoVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, zzgVar, zza(zzgVar), connectionCallbacks, onConnectionFailedListener);
    }

    private com.google.android.gms.common.internal.zzad zzOn() {
        Account zzwU = this.zzazs.zzwU();
        return new com.google.android.gms.common.internal.zzad(zzwU, this.zzaEe.intValue(), "<<default account>>".equals(zzwU.name) ? com.google.android.gms.auth.api.signin.internal.zzl.zzaa(getContext()).zzrc() : null);
    }

    public static Bundle zza(com.google.android.gms.common.internal.zzg zzgVar) {
        zzaxo zzxk = zzgVar.zzxk();
        Integer zzxl = zzgVar.zzxl();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzgVar.getAccount());
        if (zzxl != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zzxl.intValue());
        }
        if (zzxk != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzxk.zzOf());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzxk.zzqK());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzxk.zzqN());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzxk.zzqM());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzxk.zzqO());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzxk.zzOg());
            if (zzxk.zzOh() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", zzxk.zzOh().longValue());
            }
            if (zzxk.zzOi() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", zzxk.zzOi().longValue());
            }
        }
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzaxn
    public void connect() {
        zza((zzf.zzf) new zzf.zzi(this));
    }

    @Override // com.google.android.gms.internal.zzaxn
    public void zzOe() {
        try {
            ((zzaxv) zzwW()).zzmK(this.zzaEe.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.internal.zzaxn
    public void zza(com.google.android.gms.common.internal.zzr zzrVar, boolean z) {
        try {
            ((zzaxv) zzwW()).zza(zzrVar, this.zzaEe.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.internal.zzaxn
    public void zza(zzaxu zzaxuVar) {
        com.google.android.gms.common.internal.zzac.zzb(zzaxuVar, "Expecting a valid ISignInCallbacks");
        try {
            ((zzaxv) zzwW()).zza(new zzaxz(zzOn()), zzaxuVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzaxuVar.zzb(new zzayb(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: zzeZ */
    public zzaxv zzh(IBinder iBinder) {
        return zzaxv.zza.zzeY(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.signin.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public boolean zzqD() {
        return this.zzbCq;
    }

    protected Bundle zzql() {
        if (!getContext().getPackageName().equals(this.zzazs.zzxh())) {
            this.zzbCf.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzazs.zzxh());
        }
        return this.zzbCf;
    }
}
