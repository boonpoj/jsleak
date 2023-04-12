package com.ࢠ.ࢠ;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.util.Views;
import com.mopub.mobileads.DefaultBannerAdListener;
import com.mopub.mobileads.DefaultInterstitialAdListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubRewardedAd;
import com.mopub.mobileads.MoPubRewardedVideoListener;
import com.mopub.mobileads.MoPubRewardedVideoManager;
import com.mopub.mobileads.MoPubRewardedVideos;
import com.mopub.mobileads.MoPubView;
import com.mopub.nativeads.AppLovinAdRenderer;
import com.mopub.nativeads.FlurryNativeAdRenderer;
import com.mopub.nativeads.MediaViewBinder;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.MoPubStaticNativeAdRenderer;
import com.mopub.nativeads.MoPubVideoNativeAdRenderer;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.ViewBinder;
import com.ࢠ.ࢠ.C0323;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* renamed from: com.ࢠ.ࢠ.ފ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0319 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static volatile boolean f2323 = false;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static volatile boolean f2324 = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ࢠ.ࢠ.ފ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static final class C0320 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        NativeAd f2339;

        /* renamed from: ࢢ  reason: contains not printable characters */
        MoPubNative f2340;

        private C0320() {
            this.f2339 = null;
            this.f2340 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ࢠ.ࢠ.ފ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static final class C0321 {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private static volatile C0321 f2341;

        /* renamed from: ࢠ  reason: contains not printable characters */
        MoPubRewardedVideoListener f2342;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private Map<String, WeakReference<C0322>> f2343 = new ConcurrentHashMap();

        C0321() {
            this.f2342 = null;
            this.f2342 = new MoPubRewardedVideoListener() { // from class: com.ࢠ.ࢠ.ފ.ࢢ.1
                @Override // com.mopub.mobileads.MoPubRewardedVideoListener
                public void onRewardedVideoClicked(@NonNull String str) {
                    WeakReference weakReference = (WeakReference) C0321.this.f2343.get(str);
                    if (weakReference == null || weakReference.get() == null || ((C0322) weakReference.get()).f2348 == null) {
                        return;
                    }
                    ((C0322) weakReference.get()).f2348.mo1739(ࢤ.ࢥ, ࢧ.ࢤ, str, new Object[0]);
                }

                @Override // com.mopub.mobileads.MoPubRewardedVideoListener
                public void onRewardedVideoClosed(@NonNull String str) {
                    WeakReference weakReference = (WeakReference) C0321.this.f2343.remove(str);
                    if (weakReference == null || weakReference.get() == null || ((C0322) weakReference.get()).f2348 == null) {
                        return;
                    }
                    ((C0322) weakReference.get()).f2348.mo1740(ࢤ.ࢥ, ࢧ.ࢤ, str, Integer.valueOf(((C0322) weakReference.get()).f2351));
                }

                @Override // com.mopub.mobileads.MoPubRewardedVideoListener
                public void onRewardedVideoCompleted(@NonNull Set<String> set, @NonNull MoPubReward moPubReward) {
                    WeakReference weakReference;
                    for (String str : set) {
                        if (moPubReward.isSuccessful() && (weakReference = (WeakReference) C0321.this.f2343.get(str)) != null && weakReference.get() != null) {
                            C0322 c0322 = (C0322) weakReference.get();
                            c0322.f2349 = moPubReward.isSuccessful();
                            c0322.f2350 = moPubReward.getLabel();
                            c0322.f2351 = moPubReward.getAmount();
                        }
                    }
                }

                @Override // com.mopub.mobileads.MoPubRewardedVideoListener
                public void onRewardedVideoLoadFailure(@NonNull String str, @NonNull MoPubErrorCode moPubErrorCode) {
                    WeakReference weakReference = (WeakReference) C0321.this.f2343.remove(str);
                    if (weakReference == null || weakReference.get() == null || ((C0322) weakReference.get()).f2347 == null) {
                        return;
                    }
                    ((C0322) weakReference.get()).f2347.mo1737(moPubErrorCode.toString());
                }

                @Override // com.mopub.mobileads.MoPubRewardedVideoListener
                public void onRewardedVideoLoadSuccess(@NonNull String str) {
                    WeakReference weakReference = (WeakReference) C0321.this.f2343.remove(str);
                    if (weakReference == null || weakReference.get() == null || ((C0322) weakReference.get()).f2347 == null) {
                        return;
                    }
                    ((C0322) weakReference.get()).f2347.mo1736(ࢤ.ࢥ, ࢧ.ࢤ, weakReference.get(), new Object[0]);
                }

                @Override // com.mopub.mobileads.MoPubRewardedVideoListener
                public void onRewardedVideoPlaybackError(@NonNull String str, @NonNull MoPubErrorCode moPubErrorCode) {
                }

                @Override // com.mopub.mobileads.MoPubRewardedVideoListener
                public void onRewardedVideoStarted(@NonNull String str) {
                    WeakReference weakReference = (WeakReference) C0321.this.f2343.get(str);
                    if (weakReference == null || weakReference.get() == null || ((C0322) weakReference.get()).f2348 == null) {
                        return;
                    }
                    ((C0322) weakReference.get()).f2348.mo1738(ࢤ.ࢥ, ࢧ.ࢤ, str, new Object[0]);
                }
            };
            MoPubRewardedVideos.setRewardedVideoListener(this.f2342);
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public static C0321 m1829() {
            if (f2341 == null) {
                synchronized (C0321.class) {
                    if (f2341 == null) {
                        f2341 = new C0321();
                    }
                }
            }
            return f2341;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        C0322 m1831(Activity activity, String str, AbstractC0332 abstractC0332) {
            C0322 c0322 = new C0322();
            c0322.f2345 = str;
            c0322.f2347 = abstractC0332;
            synchronized (C0321.class) {
                if (this.f2343.containsKey(str) && this.f2343.get(str).get() != null) {
                    if (!MoPubRewardedVideos.hasRewardedVideo(str)) {
                        this.f2343.put(str, new WeakReference<>(c0322));
                        MoPubRewardedVideoManager.updateActivity(activity);
                        return c0322;
                    }
                    this.f2343.remove(str).get();
                }
                this.f2343.put(str, new WeakReference<>(c0322));
                MoPubRewardedVideoManager.updateActivity(activity);
                MoPubRewardedVideos.loadRewardedVideo(str, new MediationSettings[0]);
                return c0322;
            }
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1832(C0322 c0322) {
            String str = c0322.f2345;
            if (!TextUtils.isEmpty(str) && this.f2343.containsKey(str)) {
                WeakReference<C0322> weakReference = this.f2343.get(str);
                boolean z = true;
                if (weakReference != null && weakReference.get() != null && !weakReference.get().equals(c0322)) {
                    z = false;
                }
                if (z) {
                    this.f2343.remove(str);
                }
            }
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1833(C0322 c0322, AbstractC0330 abstractC0330) {
            c0322.f2348 = abstractC0330;
            String str = c0322.f2345;
            synchronized (C0321.class) {
                if (!this.f2343.containsKey(str) || this.f2343.get(str).get() == null) {
                    this.f2343.put(str, new WeakReference<>(c0322));
                    if (MoPubRewardedVideos.hasRewardedVideo(str)) {
                        MoPubRewardedVideos.showRewardedVideo(str);
                    } else {
                        this.f2343.remove(str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ࢠ.ࢠ.ފ$ࢣ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static final class C0322 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        String f2345;

        /* renamed from: ࢢ  reason: contains not printable characters */
        MoPubRewardedAd f2346;

        /* renamed from: ࢣ  reason: contains not printable characters */
        AbstractC0332 f2347;

        /* renamed from: ࢤ  reason: contains not printable characters */
        AbstractC0330 f2348;

        /* renamed from: ࢥ  reason: contains not printable characters */
        boolean f2349;

        /* renamed from: ࢦ  reason: contains not printable characters */
        String f2350;

        /* renamed from: ࢧ  reason: contains not printable characters */
        int f2351;

        private C0322() {
            this.f2345 = null;
            this.f2346 = null;
            this.f2347 = null;
            this.f2348 = null;
            this.f2349 = false;
            this.f2350 = null;
            this.f2351 = 0;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static MoPubInterstitial m1816(Activity activity, String str, final AbstractC0332 abstractC0332) {
        MoPubInterstitial moPubInterstitial = new MoPubInterstitial(activity, str);
        if (abstractC0332 != null) {
            moPubInterstitial.setInterstitialAdListener(new DefaultInterstitialAdListener() { // from class: com.ࢠ.ࢠ.ފ.4

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0332> f2329;

                {
                    this.f2329 = new WeakReference<>(AbstractC0332.this);
                }

                @Override // com.mopub.mobileads.DefaultInterstitialAdListener, com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener
                public void onInterstitialFailed(MoPubInterstitial moPubInterstitial2, MoPubErrorCode moPubErrorCode) {
                    AbstractC0332 abstractC03322 = this.f2329.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1737(moPubErrorCode.toString());
                    }
                }

                @Override // com.mopub.mobileads.DefaultInterstitialAdListener, com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener
                public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial2) {
                    AbstractC0332 abstractC03322 = this.f2329.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1736(ࢤ.ࢥ, ࢧ.ࢢ, moPubInterstitial2, new Object[0]);
                    }
                }
            });
        }
        moPubInterstitial.load();
        return moPubInterstitial;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static MoPubView m1817(Context context, String str, final AbstractC0332 abstractC0332) {
        MoPubView moPubView = new MoPubView(context);
        moPubView.setAdUnitId(str);
        moPubView.setAutorefreshEnabled(true);
        if (abstractC0332 != null) {
            moPubView.setBannerAdListener(new DefaultBannerAdListener() { // from class: com.ࢠ.ࢠ.ފ.2

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0332> f2325;

                {
                    this.f2325 = new WeakReference<>(AbstractC0332.this);
                }

                @Override // com.mopub.mobileads.DefaultBannerAdListener, com.mopub.mobileads.MoPubView.BannerAdListener
                public void onBannerFailed(MoPubView moPubView2, MoPubErrorCode moPubErrorCode) {
                    AbstractC0332 abstractC03322 = this.f2325.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1737(moPubErrorCode.toString());
                    }
                }

                @Override // com.mopub.mobileads.DefaultBannerAdListener, com.mopub.mobileads.MoPubView.BannerAdListener
                public void onBannerLoaded(MoPubView moPubView2) {
                    AbstractC0332 abstractC03322 = this.f2325.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1736(ࢤ.ࢥ, ࢧ.ࢠ, moPubView2, new Object[0]);
                    }
                }
            });
        }
        moPubView.loadAd();
        return moPubView;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static Object m1818(Context context, ࢧ r2, ࢦ r3, String str, AbstractC0332 abstractC0332) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (!f2323 && (context instanceof Activity)) {
                m1819((Activity) context, str);
                return null;
            } else if (ࢧ.ࢠ.equals(r2)) {
                return m1817(context, str, abstractC0332);
            } else {
                if (ࢧ.ࢢ.equals(r2)) {
                    if (context instanceof Activity) {
                        return m1816((Activity) context, str, abstractC0332);
                    }
                } else if (ࢧ.ࢣ.equals(r2)) {
                    return m1826(context, str, abstractC0332);
                } else {
                    if (ࢧ.ࢤ.equals(r2) && (context instanceof Activity)) {
                        return C0321.m1829().m1831((Activity) context, str, abstractC0332);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1819(Activity activity, String str) {
        if (f2324 || f2323) {
            return;
        }
        synchronized (C0319.class) {
            if (!f2324 && !f2323) {
                if (activity != null && !TextUtils.isEmpty(str)) {
                    f2324 = true;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("com.mopub.mobileads.GooglePlayServicesRewardedVideo");
                    arrayList.add("com.mopub.mobileads.AdColonyRewardedVideo");
                    arrayList.add("com.mopub.mobileads.ChartboostRewardedVideo");
                    arrayList.add("com.mopub.mobileads.AppLovinRewardedVideo");
                    MoPub.initializeSdk(activity, new SdkConfiguration.Builder(str).withNetworksToInit(arrayList).build(), new SdkInitializationListener() { // from class: com.ࢠ.ࢠ.ފ.1
                        @Override // com.mopub.common.SdkInitializationListener
                        public void onInitializationFinished() {
                            boolean unused = C0319.f2324 = false;
                            boolean unused2 = C0319.f2323 = MoPub.isSdkInitialized();
                        }
                    });
                }
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1820(MoPubInterstitial moPubInterstitial, final AbstractC0330 abstractC0330) {
        if (abstractC0330 != null) {
            moPubInterstitial.setInterstitialAdListener(new DefaultInterstitialAdListener() { // from class: com.ࢠ.ࢠ.ފ.5

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0330> f2331;

                {
                    this.f2331 = new WeakReference<>(AbstractC0330.this);
                }

                @Override // com.mopub.mobileads.DefaultInterstitialAdListener, com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener
                public void onInterstitialClicked(MoPubInterstitial moPubInterstitial2) {
                    AbstractC0330 abstractC03302 = this.f2331.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1739(ࢤ.ࢥ, ࢧ.ࢢ, "unknown_id", new Object[0]);
                    }
                }

                @Override // com.mopub.mobileads.DefaultInterstitialAdListener, com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener
                public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial2) {
                    AbstractC0330 abstractC03302 = this.f2331.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1740(ࢤ.ࢥ, ࢧ.ࢢ, "unknown_id", new Object[0]);
                    }
                }

                @Override // com.mopub.mobileads.DefaultInterstitialAdListener, com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener
                public void onInterstitialShown(MoPubInterstitial moPubInterstitial2) {
                    AbstractC0330 abstractC03302 = this.f2331.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1738(ࢤ.ࢥ, ࢧ.ࢢ, "unknown_id", new Object[0]);
                    }
                }
            });
        }
        moPubInterstitial.show();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1821(MoPubView moPubView, ViewGroup viewGroup, final AbstractC0330 abstractC0330) {
        if (abstractC0330 != null) {
            moPubView.setBannerAdListener(new DefaultBannerAdListener() { // from class: com.ࢠ.ࢠ.ފ.3

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0330> f2327;

                {
                    this.f2327 = new WeakReference<>(AbstractC0330.this);
                }

                @Override // com.mopub.mobileads.DefaultBannerAdListener, com.mopub.mobileads.MoPubView.BannerAdListener
                public void onBannerClicked(MoPubView moPubView2) {
                    AbstractC0330 abstractC03302 = this.f2327.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1739(ࢤ.ࢥ, ࢧ.ࢠ, moPubView2.getAdUnitId(), new Object[0]);
                    }
                }
            });
        }
        Views.removeFromParent(moPubView);
        viewGroup.removeAllViews();
        viewGroup.addView(moPubView);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* renamed from: ࢠ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void m1822(com.ࢠ.ࢠ.C0319.C0320 r3, android.view.ViewGroup r4, com.ࢠ.ࢠ.ࢦ r5, final com.ࢠ.ࢠ.AbstractC0330 r6) {
        /*
            com.mopub.nativeads.NativeAd r3 = r3.f2339
            if (r3 == 0) goto L7d
            boolean r0 = r3.isDestroyed()
            if (r0 == 0) goto Lc
            goto L7d
        Lc:
            if (r6 == 0) goto L16
            com.ࢠ.ࢠ.ފ$7 r0 = new com.ࢠ.ࢠ.ފ$7
            r0.<init>()
            r3.setMoPubNativeEventListener(r0)
        L16:
            com.mopub.nativeads.AdapterHelper r6 = new com.mopub.nativeads.AdapterHelper
            android.content.Context r0 = r4.getContext()
            r1 = 3
            r2 = 0
            r6.<init>(r0, r2, r1)
            r0 = 0
            com.mopub.nativeads.ViewBinder$Builder r1 = new com.mopub.nativeads.ViewBinder$Builder
            r1.<init>(r2)
            com.mopub.nativeads.ViewBinder r1 = r1.build()
            android.view.View r6 = r6.getAdView(r0, r4, r3, r1)
            com.mopub.nativeads.MoPubAdRenderer r3 = r3.getMoPubAdRenderer()
            boolean r0 = r3 instanceof com.mopub.nativeads.MoPubStaticNativeAdRenderer
            if (r0 == 0) goto L41
            int r1 = com.ࢠ.ࢠ.C0323.C0325.mopub_ad_main_img
        L39:
            android.view.View r1 = r6.findViewById(r1)
            r1.setVisibility(r2)
            goto L4f
        L41:
            boolean r1 = r3 instanceof com.mopub.nativeads.MoPubVideoNativeAdRenderer
            if (r1 == 0) goto L48
            int r1 = com.ࢠ.ࢠ.C0323.C0325.mopub_ad_main_media
            goto L39
        L48:
            boolean r1 = r3 instanceof com.mopub.nativeads.AppLovinAdRenderer
            if (r1 == 0) goto L4d
            goto L4f
        L4d:
            boolean r1 = r3 instanceof com.mopub.nativeads.FlurryNativeAdRenderer
        L4f:
            com.ࢠ.ࢠ.ࢦ r1 = com.ࢠ.ࢠ.ࢦ.ࢠ
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L77
            r5 = 8
            if (r0 != 0) goto L6e
            boolean r0 = r3 instanceof com.mopub.nativeads.MoPubVideoNativeAdRenderer
            if (r0 == 0) goto L60
            goto L6e
        L60:
            boolean r0 = r3 instanceof com.mopub.nativeads.AppLovinAdRenderer
            if (r0 == 0) goto L67
            int r3 = com.ࢠ.ࢠ.C0323.C0325.applovin_native_media_Placeholder
            goto L70
        L67:
            boolean r3 = r3 instanceof com.mopub.nativeads.FlurryNativeAdRenderer
            if (r3 == 0) goto L77
            int r3 = com.ࢠ.ࢠ.C0323.C0325.flurry_ad_media_container
            goto L70
        L6e:
            int r3 = com.ࢠ.ࢠ.C0323.C0325.mopub_ad_main_container
        L70:
            android.view.View r3 = r6.findViewById(r3)
            r3.setVisibility(r5)
        L77:
            r4.removeAllViews()
            r4.addView(r6)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ࢠ.ࢠ.C0319.m1822(com.ࢠ.ࢠ.ފ$ࢠ, android.view.ViewGroup, com.ࢠ.ࢠ.ࢦ, com.ࢠ.ࢠ.ࢠ):void");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1823(Object obj, ViewGroup viewGroup, ࢦ r3, AbstractC0330 abstractC0330) {
        if (obj instanceof MoPubView) {
            m1821((MoPubView) obj, viewGroup, abstractC0330);
        } else if (obj instanceof MoPubInterstitial) {
            m1820((MoPubInterstitial) obj, abstractC0330);
        } else if (obj instanceof C0320) {
            m1822((C0320) obj, viewGroup, r3, abstractC0330);
        } else if (obj instanceof C0322) {
            C0321.m1829().m1833((C0322) obj, abstractC0330);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m1824(Object obj) {
        if (obj instanceof MoPubView) {
            MoPubView moPubView = (MoPubView) obj;
            return true;
        } else if (obj instanceof MoPubInterstitial) {
            return ((MoPubInterstitial) obj).isReady();
        } else {
            if (obj instanceof C0320) {
                C0320 c0320 = (C0320) obj;
                return true;
            } else if (obj instanceof C0322) {
                return MoPubRewardedVideos.hasRewardedVideo(((C0322) obj).f2345);
            } else {
                return false;
            }
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static C0320 m1826(Context context, String str, final AbstractC0332 abstractC0332) {
        final C0320 c0320 = new C0320();
        MoPubNative moPubNative = new MoPubNative(context, str, new MoPubNative.MoPubNativeNetworkListener() { // from class: com.ࢠ.ࢠ.ފ.6

            /* renamed from: ࢠ  reason: contains not printable characters */
            final WeakReference<AbstractC0332> f2333;

            {
                this.f2333 = new WeakReference<>(AbstractC0332.this);
            }

            @Override // com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener
            public void onNativeFail(NativeErrorCode nativeErrorCode) {
                AbstractC0332 abstractC03322 = this.f2333.get();
                if (abstractC03322 != null) {
                    abstractC03322.mo1737(nativeErrorCode.toString());
                }
            }

            @Override // com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener
            public void onNativeLoad(NativeAd nativeAd) {
                c0320.f2339 = nativeAd;
                AbstractC0332 abstractC03322 = this.f2333.get();
                if (abstractC03322 != null) {
                    abstractC03322.mo1736(ࢤ.ࢥ, ࢧ.ࢣ, c0320, new Object[0]);
                }
            }
        });
        c0320.f2340 = moPubNative;
        moPubNative.registerAdRenderer(new MoPubStaticNativeAdRenderer(new ViewBinder.Builder(C0323.C0326.layout_mopub_native).iconImageId(C0323.C0325.mopub_ad_icon).titleId(C0323.C0325.mopub_ad_title).textId(C0323.C0325.mopub_ad_text).mainImageId(C0323.C0325.mopub_ad_main_img).callToActionId(C0323.C0325.mopub_ad_cta).privacyInformationIconImageId(C0323.C0325.mopub_privacy_info_icon_img).build()));
        moPubNative.registerAdRenderer(new MoPubVideoNativeAdRenderer(new MediaViewBinder.Builder(C0323.C0326.layout_mopub_native).iconImageId(C0323.C0325.mopub_ad_icon).titleId(C0323.C0325.mopub_ad_title).textId(C0323.C0325.mopub_ad_text).mediaLayoutId(C0323.C0325.mopub_ad_main_media).callToActionId(C0323.C0325.mopub_ad_cta).privacyInformationIconImageId(C0323.C0325.mopub_privacy_info_icon_img).build()));
        moPubNative.registerAdRenderer(new AppLovinAdRenderer(new AppLovinAdRenderer.AppLovinViewBinder.Builder(C0323.C0326.layout_applovin_native).iconImageId(C0323.C0325.applovin_native_appIcon).ratingImageId(C0323.C0325.applovin_native_appRating).titleId(C0323.C0325.applovin_native_appTitle).textId(C0323.C0325.applovin_native_appDescription).callToActionId(C0323.C0325.applovin_native_CTABtn).mediaPlaceHolderId(C0323.C0325.applovin_native_media_Placeholder).build()));
        moPubNative.registerAdRenderer(new FlurryNativeAdRenderer(new FlurryNativeAdRenderer.FlurryViewBinder.Builder(new ViewBinder.Builder(C0323.C0326.layout_flurry_native).iconImageId(C0323.C0325.flurry_ad_icon).titleId(C0323.C0325.flurry_ad_title).callToActionId(C0323.C0325.flurry_ad_cta).mainImageId(C0323.C0325.flurry_ad_media_img).privacyInformationIconImageId(C0323.C0325.flurry_ad_sponsored_marker).build()).advertiserNameViewId(C0323.C0325.flurry_ad_source).videoViewId(C0323.C0325.flurry_ad_media_video).build()));
        moPubNative.makeRequest();
        return c0320;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static void m1827(Object obj) {
        if (obj instanceof MoPubView) {
            ((MoPubView) obj).destroy();
        } else if (obj instanceof MoPubInterstitial) {
            ((MoPubInterstitial) obj).destroy();
        } else if (!(obj instanceof C0320)) {
            if (obj instanceof C0322) {
                C0321.m1829().m1832((C0322) obj);
            }
        } else {
            C0320 c0320 = (C0320) obj;
            if (c0320.f2340 != null) {
                c0320.f2340.destroy();
                c0320.f2340 = null;
            }
            if (c0320.f2339 != null) {
                c0320.f2339.destroy();
                c0320.f2339 = null;
            }
        }
    }
}
