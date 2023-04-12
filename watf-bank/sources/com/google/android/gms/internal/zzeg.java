package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import com.mopub.common.AdType;
import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzeg extends zzet {
    private long zzakq;

    /* renamed from: com.google.android.gms.internal.zzeg$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 extends zza<zzep> {
        final /* synthetic */ String zztb;
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzec zzzA;
        final /* synthetic */ zzjs zzzB;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, zzec zzecVar, String str, zzjs zzjsVar) {
            super();
            this.zztd = context;
            this.zzzA = zzecVar;
            this.zztb = str;
            this.zzzB = zzjsVar;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zza */
        public zzep zzb(zzes zzesVar) throws RemoteException {
            return zzesVar.createBannerAdManager(com.google.android.gms.dynamic.zze.zzA(this.zztd), this.zzzA, this.zztb, this.zzzB, 10084000);
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzeD */
        public zzep zzeE() {
            zzep zza = zzeg.zzb(zzeg.this).zza(this.zztd, this.zzzA, this.zztb, this.zzzB, 1);
            if (zza != null) {
                return zza;
            }
            zzeg.zza(zzeg.this, this.zztd, "banner");
            return new zzff();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 extends zza<zzep> {
        final /* synthetic */ String zztb;
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzec zzzA;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, zzec zzecVar, String str) {
            super();
            this.zztd = context;
            this.zzzA = zzecVar;
            this.zztb = str;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zza */
        public zzep zzb(zzes zzesVar) throws RemoteException {
            return zzesVar.createSearchAdManager(com.google.android.gms.dynamic.zze.zzA(this.zztd), this.zzzA, this.zztb, 10084000);
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzeD */
        public zzep zzeE() {
            zzep zza = zzeg.zzb(zzeg.this).zza(this.zztd, this.zzzA, this.zztb, null, 3);
            if (zza != null) {
                return zza;
            }
            zzeg.zza(zzeg.this, this.zztd, "search");
            return new zzff();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 extends zza<zzep> {
        final /* synthetic */ String zztb;
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzec zzzA;
        final /* synthetic */ zzjs zzzB;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Context context, zzec zzecVar, String str, zzjs zzjsVar) {
            super();
            this.zztd = context;
            this.zzzA = zzecVar;
            this.zztb = str;
            this.zzzB = zzjsVar;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zza */
        public zzep zzb(zzes zzesVar) throws RemoteException {
            return zzesVar.createInterstitialAdManager(com.google.android.gms.dynamic.zze.zzA(this.zztd), this.zzzA, this.zztb, this.zzzB, 10084000);
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzeD */
        public zzep zzeE() {
            zzep zza = zzeg.zzb(zzeg.this).zza(this.zztd, this.zzzA, this.zztb, this.zzzB, 2);
            if (zza != null) {
                return zza;
            }
            zzeg.zza(zzeg.this, this.zztd, AdType.INTERSTITIAL);
            return new zzff();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 extends zza<zzen> {
        final /* synthetic */ String zztb;
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzjs zzzB;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Context context, String str, zzjs zzjsVar) {
            super();
            this.zztd = context;
            this.zztb = str;
            this.zzzB = zzjsVar;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzc */
        public zzen zzb(zzes zzesVar) throws RemoteException {
            return zzesVar.createAdLoaderBuilder(com.google.android.gms.dynamic.zze.zzA(this.zztd), this.zztb, this.zzzB, 10084000);
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzeF */
        public zzen zzeE() {
            zzen zza = zzeg.zzc(zzeg.this).zza(this.zztd, this.zztb, this.zzzB);
            if (zza != null) {
                return zza;
            }
            zzeg.zza(zzeg.this, this.zztd, "native_ad");
            return new zzfe();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass5 extends zza<zzeu> {
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Context context) {
            super();
            this.zztd = context;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzd */
        public zzeu zzb(zzes zzesVar) throws RemoteException {
            return zzesVar.getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.zze.zzA(this.zztd), 10084000);
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzeG */
        public zzeu zzeE() {
            zzeu zzl = zzeg.zzd(zzeg.this).zzl(this.zztd);
            if (zzl != null) {
                return zzl;
            }
            zzeg.zza(zzeg.this, this.zztd, "mobile_ads_settings");
            return new zzfg();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg$6  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass6 extends zza<zzhb> {
        final /* synthetic */ Context zztd;
        final /* synthetic */ FrameLayout zzzD;
        final /* synthetic */ FrameLayout zzzE;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
            super();
            this.zzzD = frameLayout;
            this.zzzE = frameLayout2;
            this.zztd = context;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zze */
        public zzhb zzb(zzes zzesVar) throws RemoteException {
            return zzesVar.createNativeAdViewDelegate(com.google.android.gms.dynamic.zze.zzA(this.zzzD), com.google.android.gms.dynamic.zze.zzA(this.zzzE));
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzeH */
        public zzhb zzeE() {
            zzhb zzb = zzeg.zze(zzeg.this).zzb(this.zztd, this.zzzD, this.zzzE);
            if (zzb != null) {
                return zzb;
            }
            zzeg.zza(zzeg.this, this.zztd, "native_ad_view_delegate");
            return new zzfh();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg$7  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass7 extends zza<zznr> {
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzjs zzzB;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(Context context, zzjs zzjsVar) {
            super();
            this.zztd = context;
            this.zzzB = zzjsVar;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzeI */
        public zznr zzeE() {
            zznr zzb = zzeg.zzf(zzeg.this).zzb(this.zztd, this.zzzB);
            if (zzb != null) {
                return zzb;
            }
            zzeg.zza(zzeg.this, this.zztd, AdType.REWARDED_VIDEO);
            return new zzfi();
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzf */
        public zznr zzb(zzes zzesVar) throws RemoteException {
            return zzesVar.createRewardedVideoAd(com.google.android.gms.dynamic.zze.zzA(this.zztd), this.zzzB, 10084000);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg$8  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass8 extends zza<zzla> {
        final /* synthetic */ Activity val$activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(Activity activity) {
            super();
            this.val$activity = activity;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzeJ */
        public zzla zzeE() {
            zzla zzg = zzeg.zzg(zzeg.this).zzg(this.val$activity);
            if (zzg != null) {
                return zzg;
            }
            zzeg.zza(zzeg.this, this.val$activity, "iap");
            return null;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzg */
        public zzla zzb(zzes zzesVar) throws RemoteException {
            return zzesVar.createInAppPurchaseManager(com.google.android.gms.dynamic.zze.zzA(this.val$activity));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg$9  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass9 extends zza<zzkr> {
        final /* synthetic */ Activity val$activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Activity activity) {
            super();
            this.val$activity = activity;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzeK */
        public zzkr zzeE() {
            zzkr zzf = zzeg.zzh(zzeg.this).zzf(this.val$activity);
            if (zzf != null) {
                return zzf;
            }
            zzeg.zza(zzeg.this, this.val$activity, "ad_overlay");
            return null;
        }

        @Override // com.google.android.gms.internal.zzeg.zza
        /* renamed from: zzh */
        public zzkr zzb(zzes zzesVar) throws RemoteException {
            return zzesVar.createAdOverlay(com.google.android.gms.dynamic.zze.zzA(this.val$activity));
        }
    }

    @VisibleForTesting
    /* loaded from: assets/classes2.dex */
    abstract class zza<T> {
        zza() {
        }

        @Nullable
        protected abstract T zzb(zzes zzesVar) throws RemoteException;

        @Nullable
        protected abstract T zzeE() throws RemoteException;

        @Nullable
        protected final T zzeL() {
            zzes zza = zzeg.zza(zzeg.this);
            if (zza == null) {
                zzpy.zzbe("ClientApi class cannot be loaded.");
                return null;
            }
            try {
                return zzb(zza);
            } catch (RemoteException e) {
                zzpy.zzc("Cannot invoke local loader using ClientApi class", e);
                return null;
            }
        }

        @Nullable
        protected final T zzeM() {
            try {
                return zzeE();
            } catch (RemoteException e) {
                zzpy.zzc("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    public zzeg(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 12);
        this.zzakq = -1L;
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        this.zzako.zzdl = -1L;
        this.zzako.zzdl = (Long) this.zzakw.invoke(null, this.zzagr.getContext());
    }
}
