package com.ࢠ.ࢠ;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdChoicesView;
import com.facebook.ads.AdError;
import com.facebook.ads.AdIconView;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.ࢠ.ࢠ.C0323;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* renamed from: com.ࢠ.ࢠ.ރ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0308 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean f2273 = false;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AdView m1760(Context context, ࢦ r3, String str, final AbstractC0332 abstractC0332) {
        AdSize adSize = AdSize.RECTANGLE_HEIGHT_250;
        if (ࢦ.ࢠ.equals(r3)) {
            adSize = AdSize.BANNER_HEIGHT_50;
        }
        final AdView adView = new AdView(context, str, adSize);
        if (abstractC0332 != null) {
            adView.setAdListener(new AbstractAdListener() { // from class: com.ࢠ.ࢠ.ރ.1

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0332> f2274;

                {
                    this.f2274 = new WeakReference<>(AbstractC0332.this);
                }

                public void onAdLoaded(Ad ad) {
                    super.onAdLoaded(ad);
                    AbstractC0332 abstractC03322 = this.f2274.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1736(ࢤ.ࢢ, ࢧ.ࢠ, adView, new Object[0]);
                    }
                }

                public void onError(Ad ad, AdError adError) {
                    super.onError(ad, adError);
                    ad.getPlacementId();
                    AbstractC0332 abstractC03322 = this.f2274.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1737(adError.getErrorMessage());
                    }
                }
            });
        }
        adView.loadAd();
        return adView;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static InterstitialAd m1761(Context context, String str, final AbstractC0332 abstractC0332) {
        final InterstitialAd interstitialAd = new InterstitialAd(context, str);
        if (abstractC0332 != null) {
            interstitialAd.setAdListener(new AbstractAdListener() { // from class: com.ࢠ.ࢠ.ރ.3

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0332> f2280;

                {
                    this.f2280 = new WeakReference<>(AbstractC0332.this);
                }

                public void onAdLoaded(Ad ad) {
                    super.onAdLoaded(ad);
                    AbstractC0332 abstractC03322 = this.f2280.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1736(ࢤ.ࢢ, ࢧ.ࢢ, interstitialAd, new Object[0]);
                    }
                }

                public void onError(Ad ad, AdError adError) {
                    super.onError(ad, adError);
                    ad.getPlacementId();
                    AbstractC0332 abstractC03322 = this.f2280.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1737(adError.getErrorMessage());
                    }
                }
            });
        }
        interstitialAd.loadAd();
        return interstitialAd;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static Object m1762(Context context, ࢧ r3, ࢦ r4, String str, AbstractC0332 abstractC0332) {
        if (f2273 && context != null && !TextUtils.isEmpty(str)) {
            if (ࢧ.ࢠ.equals(r3)) {
                return m1760(context, r4, str, abstractC0332);
            }
            if (ࢧ.ࢢ.equals(r3)) {
                return m1761(context, str, abstractC0332);
            }
            if (ࢧ.ࢣ.equals(r3)) {
                return ࢦ.ࢠ.equals(r4) ? m1772(context, str, abstractC0332) : m1770(context, str, abstractC0332);
            }
        }
        return null;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1763(Context context) {
        f2273 = C0337.m1880(context, "com.facebook.katana") || C0337.m1880(context, "com.facebook.lite") || C0337.m1880(context, "com.facebook.mlite") || C0337.m1880(context, "com.facebook.orca");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1764(final AdView adView, ViewGroup viewGroup, final AbstractC0330 abstractC0330) {
        if (adView.getParent() != null) {
            return;
        }
        if (abstractC0330 != null) {
            adView.setAdListener(new AbstractAdListener() { // from class: com.ࢠ.ࢠ.ރ.2

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0330> f2277;

                {
                    this.f2277 = new WeakReference<>(AbstractC0330.this);
                }

                public void onAdClicked(Ad ad) {
                    super.onAdClicked(ad);
                    AbstractC0330 abstractC03302 = this.f2277.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1739(ࢤ.ࢢ, ࢧ.ࢠ, adView.getPlacementId(), new Object[0]);
                    }
                }

                public void onLoggingImpression(Ad ad) {
                    super.onLoggingImpression(ad);
                    AbstractC0330 abstractC03302 = this.f2277.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1738(ࢤ.ࢢ, ࢧ.ࢠ, adView.getPlacementId(), new Object[0]);
                    }
                }
            });
        }
        viewGroup.addView(adView);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1765(InterstitialAd interstitialAd, final AbstractC0330 abstractC0330) {
        if (abstractC0330 != null) {
            interstitialAd.setAdListener(new AbstractAdListener() { // from class: com.ࢠ.ࢠ.ރ.4

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0330> f2283;

                {
                    this.f2283 = new WeakReference<>(AbstractC0330.this);
                }

                public void onAdClicked(Ad ad) {
                    super.onAdClicked(ad);
                    AbstractC0330 abstractC03302 = this.f2283.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1739(ࢤ.ࢢ, ࢧ.ࢢ, ad.getPlacementId(), new Object[0]);
                    }
                }

                public void onInterstitialDismissed(Ad ad) {
                    super.onInterstitialDismissed(ad);
                    AbstractC0330 abstractC03302 = this.f2283.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1740(ࢤ.ࢢ, ࢧ.ࢢ, ad.getPlacementId(), new Object[0]);
                    }
                }

                public void onLoggingImpression(Ad ad) {
                    super.onLoggingImpression(ad);
                    AbstractC0330 abstractC03302 = this.f2283.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1738(ࢤ.ࢢ, ࢧ.ࢢ, ad.getPlacementId(), new Object[0]);
                    }
                }
            });
        }
        interstitialAd.show();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1766(NativeAd nativeAd, ViewGroup viewGroup, final AbstractC0330 abstractC0330) {
        nativeAd.unregisterView();
        if (abstractC0330 != null) {
            nativeAd.setAdListener(new NativeAdListener() { // from class: com.ࢠ.ࢠ.ރ.7

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0330> f2289;

                {
                    this.f2289 = new WeakReference<>(AbstractC0330.this);
                }

                public void onAdClicked(Ad ad) {
                    AbstractC0330 abstractC03302 = this.f2289.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1739(ࢤ.ࢢ, ࢧ.ࢣ, ad.getPlacementId(), new Object[0]);
                    }
                }

                public void onAdLoaded(Ad ad) {
                }

                public void onError(Ad ad, AdError adError) {
                }

                public void onLoggingImpression(Ad ad) {
                    AbstractC0330 abstractC03302 = this.f2289.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1738(ࢤ.ࢢ, ࢧ.ࢣ, ad.getPlacementId(), new Object[0]);
                    }
                }

                public void onMediaDownloaded(Ad ad) {
                }
            });
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0323.C0326.layout_facebook_native, viewGroup, false);
        viewGroup.addView(inflate);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(C0323.C0325.ad_choices_container);
        AdChoicesView adChoicesView = new AdChoicesView(viewGroup.getContext(), nativeAd, true);
        viewGroup2.removeAllViews();
        viewGroup2.addView((View) adChoicesView, 0);
        AdIconView findViewById = inflate.findViewById(C0323.C0325.fb_ad_icon);
        TextView textView = (TextView) inflate.findViewById(C0323.C0325.fb_ad_name);
        MediaView findViewById2 = inflate.findViewById(C0323.C0325.fb_ad_media);
        TextView textView2 = (TextView) inflate.findViewById(C0323.C0325.fb_ad_social_context);
        TextView textView3 = (TextView) inflate.findViewById(C0323.C0325.fb_ad_body);
        TextView textView4 = (TextView) inflate.findViewById(C0323.C0325.fb_ad_sponsored_label);
        Button button = (Button) inflate.findViewById(C0323.C0325.fb_ad_call_to_action);
        String advertiserName = nativeAd.getAdvertiserName();
        if (advertiserName.length() > 25) {
            advertiserName = advertiserName.substring(0, 25) + "...";
        }
        textView.setText(advertiserName);
        textView3.setText(nativeAd.getAdBodyText());
        textView2.setText(nativeAd.getAdSocialContext());
        button.setVisibility(nativeAd.hasCallToAction() ? 0 : 4);
        button.setText(nativeAd.getAdCallToAction());
        textView4.setText(nativeAd.getSponsoredTranslation());
        ArrayList arrayList = new ArrayList();
        arrayList.add(textView);
        arrayList.add(button);
        nativeAd.registerViewForInteraction(inflate, findViewById2, findViewById, arrayList);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1767(NativeBannerAd nativeBannerAd, ViewGroup viewGroup, final AbstractC0330 abstractC0330) {
        nativeBannerAd.unregisterView();
        if (abstractC0330 != null) {
            nativeBannerAd.setAdListener(new NativeAdListener() { // from class: com.ࢠ.ࢠ.ރ.8

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0330> f2291;

                {
                    this.f2291 = new WeakReference<>(AbstractC0330.this);
                }

                public void onAdClicked(Ad ad) {
                    AbstractC0330 abstractC03302 = this.f2291.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1739(ࢤ.ࢢ, ࢧ.ࢣ, ad.getPlacementId(), new Object[0]);
                    }
                }

                public void onAdLoaded(Ad ad) {
                }

                public void onError(Ad ad, AdError adError) {
                }

                public void onLoggingImpression(Ad ad) {
                    AbstractC0330 abstractC03302 = this.f2291.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1738(ࢤ.ࢢ, ࢧ.ࢣ, ad.getPlacementId(), new Object[0]);
                    }
                }

                public void onMediaDownloaded(Ad ad) {
                }
            });
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0323.C0326.layout_facebook_native, viewGroup, false);
        viewGroup.addView(inflate);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(C0323.C0325.ad_choices_container);
        AdChoicesView adChoicesView = new AdChoicesView(viewGroup.getContext(), nativeBannerAd, true);
        viewGroup2.removeAllViews();
        viewGroup2.addView((View) adChoicesView, 0);
        TextView textView = (TextView) inflate.findViewById(C0323.C0325.fb_ad_name);
        TextView textView2 = (TextView) inflate.findViewById(C0323.C0325.fb_ad_social_context);
        TextView textView3 = (TextView) inflate.findViewById(C0323.C0325.fb_ad_sponsored_label);
        AdIconView findViewById = inflate.findViewById(C0323.C0325.fb_ad_icon);
        Button button = (Button) inflate.findViewById(C0323.C0325.fb_ad_call_to_action);
        inflate.findViewById(C0323.C0325.fb_ad_media).setVisibility(8);
        ((TextView) inflate.findViewById(C0323.C0325.fb_ad_body)).setVisibility(8);
        button.setText(nativeBannerAd.getAdCallToAction());
        button.setVisibility(nativeBannerAd.hasCallToAction() ? 0 : 4);
        String advertiserName = nativeBannerAd.getAdvertiserName();
        if (advertiserName.length() > 25) {
            advertiserName = advertiserName.substring(0, 25) + "...";
        }
        textView.setText(advertiserName);
        textView2.setText(nativeBannerAd.getAdSocialContext());
        textView3.setText(nativeBannerAd.getSponsoredTranslation());
        ArrayList arrayList = new ArrayList();
        arrayList.add(textView);
        arrayList.add(button);
        nativeBannerAd.registerViewForInteraction(inflate, findViewById, arrayList);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1768(Object obj, ViewGroup viewGroup, ࢦ r2, AbstractC0330 abstractC0330) {
        if (obj instanceof AdView) {
            m1764((AdView) obj, viewGroup, abstractC0330);
        } else if (obj instanceof InterstitialAd) {
            m1765((InterstitialAd) obj, abstractC0330);
        } else if (obj instanceof NativeAd) {
            m1766((NativeAd) obj, viewGroup, abstractC0330);
        } else if (obj instanceof NativeBannerAd) {
            m1767((NativeBannerAd) obj, viewGroup, abstractC0330);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m1769(Object obj) {
        if (obj instanceof AdView) {
            AdView adView = (AdView) obj;
            return true;
        } else if (obj instanceof InterstitialAd) {
            return ((InterstitialAd) obj).isAdLoaded();
        } else {
            if (obj instanceof NativeAd) {
                return ((NativeAd) obj).isAdLoaded();
            }
            if (obj instanceof NativeBannerAd) {
                return ((NativeBannerAd) obj).isAdLoaded();
            }
            return false;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static NativeAd m1770(Context context, String str, final AbstractC0332 abstractC0332) {
        NativeAd nativeAd = new NativeAd(context, str);
        if (abstractC0332 != null) {
            nativeAd.setAdListener(new NativeAdListener() { // from class: com.ࢠ.ࢠ.ރ.5

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0332> f2285;

                {
                    this.f2285 = new WeakReference<>(AbstractC0332.this);
                }

                public void onAdClicked(Ad ad) {
                }

                public void onAdLoaded(Ad ad) {
                    AbstractC0332 abstractC03322 = this.f2285.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1736(ࢤ.ࢢ, ࢧ.ࢣ, ad, new Object[0]);
                    }
                }

                public void onError(Ad ad, AdError adError) {
                    AbstractC0332 abstractC03322 = this.f2285.get();
                    ad.getPlacementId();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1737(adError.getErrorMessage());
                    }
                }

                public void onLoggingImpression(Ad ad) {
                }

                public void onMediaDownloaded(Ad ad) {
                }
            });
        }
        nativeAd.loadAd();
        return nativeAd;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static void m1771(Object obj) {
        if (obj instanceof AdView) {
            ((AdView) obj).destroy();
        } else if (obj instanceof InterstitialAd) {
            ((InterstitialAd) obj).destroy();
        } else if (obj instanceof NativeAd) {
            ((NativeAd) obj).destroy();
        } else if (obj instanceof NativeBannerAd) {
            ((NativeBannerAd) obj).destroy();
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static NativeBannerAd m1772(Context context, String str, final AbstractC0332 abstractC0332) {
        NativeBannerAd nativeBannerAd = new NativeBannerAd(context, str);
        if (abstractC0332 != null) {
            nativeBannerAd.setAdListener(new NativeAdListener() { // from class: com.ࢠ.ࢠ.ރ.6

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0332> f2287;

                {
                    this.f2287 = new WeakReference<>(AbstractC0332.this);
                }

                public void onAdClicked(Ad ad) {
                }

                public void onAdLoaded(Ad ad) {
                    AbstractC0332 abstractC03322 = this.f2287.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1736(ࢤ.ࢢ, ࢧ.ࢣ, ad, new Object[0]);
                    }
                }

                public void onError(Ad ad, AdError adError) {
                    AbstractC0332 abstractC03322 = this.f2287.get();
                    ad.getPlacementId();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1737(adError.getErrorMessage());
                    }
                }

                public void onLoggingImpression(Ad ad) {
                }

                public void onMediaDownloaded(Ad ad) {
                }
            });
        }
        nativeBannerAd.loadAd();
        return nativeBannerAd;
    }
}
