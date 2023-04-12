package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzadd;
import com.google.android.gms.internal.zzadk;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzxe;
import com.google.android.gms.internal.zzxo;
import com.google.android.gms.internal.zzzv;
import java.util.HashMap;
@zzzv
/* loaded from: classes.dex */
public class ClientApi extends zzlb {
    @Override // com.google.android.gms.internal.zzla
    public zzkn createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzux zzuxVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
        zzbs.zzei();
        return new zzaj(context, str, zzuxVar, new zzakd(11910000, i, true, zzahn.zzau(context)), zzv.zzc(context));
    }

    @Override // com.google.android.gms.internal.zzla
    public zzxe createAdOverlay(IObjectWrapper iObjectWrapper) {
        return new com.google.android.gms.ads.internal.overlay.zzd((Activity) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzla
    public zzks createBannerAdManager(IObjectWrapper iObjectWrapper, zzjn zzjnVar, String str, zzux zzuxVar, int i) throws RemoteException {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
        zzbs.zzei();
        return new zzx(context, zzjnVar, str, zzuxVar, new zzakd(11910000, i, true, zzahn.zzau(context)), zzv.zzc(context));
    }

    @Override // com.google.android.gms.internal.zzla
    public zzxo createInAppPurchaseManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0034, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.zzkb.zzif().zzd(com.google.android.gms.internal.zznh.zzblu)).booleanValue() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0048, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.zzkb.zzif().zzd(com.google.android.gms.internal.zznh.zzblv)).booleanValue() != false) goto L5;
     */
    @Override // com.google.android.gms.internal.zzla
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.zzks createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper r8, com.google.android.gms.internal.zzjn r9, java.lang.String r10, com.google.android.gms.internal.zzux r11, int r12) throws android.os.RemoteException {
        /*
            r7 = this;
            java.lang.Object r8 = com.google.android.gms.dynamic.zzn.zzx(r8)
            r1 = r8
            android.content.Context r1 = (android.content.Context) r1
            com.google.android.gms.internal.zznh.initialize(r1)
            com.google.android.gms.internal.zzakd r5 = new com.google.android.gms.internal.zzakd
            com.google.android.gms.ads.internal.zzbs.zzei()
            boolean r8 = com.google.android.gms.internal.zzahn.zzau(r1)
            r0 = 1
            r2 = 11910000(0xb5bb70, float:1.6689465E-38)
            r5.<init>(r2, r12, r0, r8)
            java.lang.String r8 = r9.zzbek
            java.lang.String r12 = "reward_mb"
            boolean r8 = r12.equals(r8)
            if (r8 != 0) goto L36
            com.google.android.gms.internal.zzmx<java.lang.Boolean> r12 = com.google.android.gms.internal.zznh.zzblu
            com.google.android.gms.internal.zznf r2 = com.google.android.gms.internal.zzkb.zzif()
            java.lang.Object r12 = r2.zzd(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L4c
        L36:
            if (r8 == 0) goto L4b
            com.google.android.gms.internal.zzmx<java.lang.Boolean> r8 = com.google.android.gms.internal.zznh.zzblv
            com.google.android.gms.internal.zznf r12 = com.google.android.gms.internal.zzkb.zzif()
            java.lang.Object r8 = r12.zzd(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L4b
            goto L4c
        L4b:
            r0 = 0
        L4c:
            if (r0 == 0) goto L5d
            com.google.android.gms.internal.zztl r8 = new com.google.android.gms.internal.zztl
            com.google.android.gms.ads.internal.zzv r9 = com.google.android.gms.ads.internal.zzv.zzc(r1)
            r0 = r8
            r2 = r10
            r3 = r11
            r4 = r5
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return r8
        L5d:
            com.google.android.gms.ads.internal.zzak r8 = new com.google.android.gms.ads.internal.zzak
            com.google.android.gms.ads.internal.zzv r6 = com.google.android.gms.ads.internal.zzv.zzc(r1)
            r0 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ClientApi.createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.zzjn, java.lang.String, com.google.android.gms.internal.zzux, int):com.google.android.gms.internal.zzks");
    }

    @Override // com.google.android.gms.internal.zzla
    public zzpu createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzpg((FrameLayout) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper), (FrameLayout) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper2));
    }

    @Override // com.google.android.gms.internal.zzla
    public zzpz createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzpj((View) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper), (HashMap) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper2), (HashMap) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.zzla
    public zzadk createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzux zzuxVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
        zzbs.zzei();
        return new zzadd(context, zzv.zzc(context), zzuxVar, new zzakd(11910000, i, true, zzahn.zzau(context)));
    }

    @Override // com.google.android.gms.internal.zzla
    public zzks createSearchAdManager(IObjectWrapper iObjectWrapper, zzjn zzjnVar, String str, int i) throws RemoteException {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
        zzbs.zzei();
        return new zzbm(context, zzjnVar, str, new zzakd(11910000, i, true, zzahn.zzau(context)));
    }

    @Override // com.google.android.gms.internal.zzla
    public zzlg getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.zzla
    public zzlg getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
        zzbs.zzei();
        return zzaw.zza(context, new zzakd(11910000, i, true, zzahn.zzau(context)));
    }
}
