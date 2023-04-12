package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.zzgl;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzkh extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzkh$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zzgl.zza {
        AnonymousClass1(zzkh zzkhVar) {
        }

        @Override // com.google.android.gms.internal.zzgl.zza
        public void zzfE() {
            zzpy.zzbc("Hinting CustomTabsService for the load of the new url.");
        }

        @Override // com.google.android.gms.internal.zzgl.zza
        public void zzfF() {
            zzpy.zzbc("Disconnecting from CustomTabs service.");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkh$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements com.google.android.gms.ads.internal.overlay.zzh {
        AnonymousClass2() {
        }

        public void onPause() {
            zzpy.zzbc("AdMobCustomTabsAdapter overlay is paused.");
        }

        public void onResume() {
            zzpy.zzbc("AdMobCustomTabsAdapter overlay is resumed.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.internal.zzkh] */
        public void zzbN() {
            zzpy.zzbc("AdMobCustomTabsAdapter overlay is closed.");
            zzkh.zza(zzkh.this).onAdClosed(zzkh.this);
            zzkh.zzc(zzkh.this).zzd(zzkh.zzb(zzkh.this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.internal.zzkh] */
        public void zzbO() {
            zzpy.zzbc("Opening AdMobCustomTabsAdapter overlay.");
            zzkh.zza(zzkh.this).onAdOpened(zzkh.this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkh$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ AdOverlayInfoParcel zztF;

        AnonymousClass3(AdOverlayInfoParcel adOverlayInfoParcel) {
            this.zztF = adOverlayInfoParcel;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.ads.internal.zzv.zzcH().zza(zzkh.zzb(zzkh.this), this.zztF);
        }
    }

    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;
}
