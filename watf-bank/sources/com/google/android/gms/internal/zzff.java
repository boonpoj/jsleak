package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzep;
/* loaded from: assets/classes2.dex */
public class zzff extends zzep.zza {
    private zzel zzti;

    public void destroy() {
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public boolean isLoading() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void pause() {
    }

    public void resume() {
    }

    public void setManualImpressionsEnabled(boolean z) {
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() {
    }

    public void stopLoading() {
    }

    public void zza(zzec zzecVar) {
    }

    public void zza(zzek zzekVar) {
    }

    public void zza(zzel zzelVar) {
        this.zzti = zzelVar;
    }

    public void zza(zzer zzerVar) {
    }

    public void zza(zzet zzetVar) {
    }

    public void zza(zzfn zzfnVar) {
    }

    public void zza(zzgj zzgjVar) {
    }

    public void zza(zzkz zzkzVar) {
    }

    public void zza(zzld zzldVar, String str) {
    }

    public void zza(zznt zzntVar) {
    }

    public boolean zzb(zzdy zzdyVar) {
        zzpy.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzpx.zzXU.post(new Runnable() { // from class: com.google.android.gms.internal.zzff.1
            @Override // java.lang.Runnable
            public void run() {
                if (zzff.this.zzti != null) {
                    try {
                        zzff.this.zzti.onAdFailedToLoad(1);
                    } catch (RemoteException e) {
                        zzpy.zzc("Could not notify onAdFailedToLoad event.", e);
                    }
                }
            }
        });
        return false;
    }

    public com.google.android.gms.dynamic.zzd zzbC() {
        return null;
    }

    public zzec zzbD() {
        return null;
    }

    public void zzbF() {
    }

    public zzew zzbG() {
        return null;
    }
}
