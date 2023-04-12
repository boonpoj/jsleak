package com.ࢠ.ࢠ;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import java.lang.ref.WeakReference;
/* renamed from: com.ࢠ.ࢠ.ࢨ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0336 {
    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AdView m1869(Context context, ࢦ r3, String str, final AbstractC0332 abstractC0332) {
        final AdView adView = null;
        if (context == null) {
            return null;
        }
        if (r3 != null && !ࢦ.ࢣ.equals(r3)) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            adView = new AdView(context);
            adView.setAdSize(ࢦ.ࢠ.equals(r3) ? AdSize.BANNER : AdSize.MEDIUM_RECTANGLE);
            adView.setAdUnitId(str);
            if (abstractC0332 != null) {
                adView.setAdListener(new AdListener() { // from class: com.ࢠ.ࢠ.ࢨ.1

                    /* renamed from: ࢠ  reason: contains not printable characters */
                    final WeakReference<AbstractC0332> f2371;

                    {
                        this.f2371 = new WeakReference<>(AbstractC0332.this);
                    }

                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdFailedToLoad(int i) {
                        AbstractC0332 abstractC03322 = this.f2371.get();
                        if (abstractC03322 != null) {
                            abstractC03322.mo1737(String.valueOf(i));
                        }
                    }

                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdLoaded() {
                        AbstractC0332 abstractC03322 = this.f2371.get();
                        if (abstractC03322 != null) {
                            abstractC03322.mo1736(ࢤ.ࢠ, ࢧ.ࢠ, adView, new Object[0]);
                        }
                    }
                });
            }
            adView.loadAd(new AdRequest.Builder().build());
        }
        return adView;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static InterstitialAd m1870(Context context, String str, final AbstractC0332 abstractC0332) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        final InterstitialAd interstitialAd = new InterstitialAd(context);
        interstitialAd.setAdUnitId(str);
        if (abstractC0332 != null) {
            interstitialAd.setAdListener(new AdListener() { // from class: com.ࢠ.ࢠ.ࢨ.3

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0332> f2377;

                {
                    this.f2377 = new WeakReference<>(AbstractC0332.this);
                }

                @Override // com.google.android.gms.ads.AdListener
                public void onAdFailedToLoad(int i) {
                    super.onAdFailedToLoad(i);
                    AbstractC0332 abstractC03322 = this.f2377.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1737(String.valueOf(i));
                    }
                }

                @Override // com.google.android.gms.ads.AdListener
                public void onAdLoaded() {
                    super.onAdLoaded();
                    AbstractC0332 abstractC03322 = this.f2377.get();
                    if (abstractC03322 != null) {
                        abstractC03322.mo1736(ࢤ.ࢠ, ࢧ.ࢢ, interstitialAd, new Object[0]);
                    }
                }
            });
        }
        interstitialAd.loadAd(new AdRequest.Builder().build());
        return interstitialAd;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static Object m1871(Context context, ࢧ r3, ࢦ r4, String str, AbstractC0332 abstractC0332) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (ࢧ.ࢠ.equals(r3)) {
                return m1869(context, r4, str, abstractC0332);
            }
            if (ࢧ.ࢢ.equals(r3)) {
                return m1870(context, str, abstractC0332);
            }
            if (!ࢧ.ࢣ.equals(r3)) {
                ࢧ.ࢤ.equals(r3);
            }
        }
        return null;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1872(Context context, String str) {
        if (context != null) {
            TextUtils.isEmpty(str);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1873(final AdView adView, ViewGroup viewGroup, final AbstractC0330 abstractC0330) {
        if (adView.getParent() != null) {
            return;
        }
        if (abstractC0330 != null) {
            adView.setAdListener(new AdListener() { // from class: com.ࢠ.ࢠ.ࢨ.2

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0330> f2374;

                {
                    this.f2374 = new WeakReference<>(AbstractC0330.this);
                }

                @Override // com.google.android.gms.ads.AdListener
                public void onAdLeftApplication() {
                    AbstractC0330 abstractC03302 = this.f2374.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1739(ࢤ.ࢠ, ࢧ.ࢠ, adView.getAdUnitId(), new Object[0]);
                    }
                }
            });
        }
        viewGroup.addView(adView);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1874(final InterstitialAd interstitialAd, final AbstractC0330 abstractC0330) {
        if (abstractC0330 != null) {
            interstitialAd.setAdListener(new AdListener() { // from class: com.ࢠ.ࢠ.ࢨ.4

                /* renamed from: ࢠ  reason: contains not printable characters */
                final WeakReference<AbstractC0330> f2380;

                {
                    this.f2380 = new WeakReference<>(AbstractC0330.this);
                }

                @Override // com.google.android.gms.ads.AdListener
                public void onAdClosed() {
                    super.onAdClosed();
                    AbstractC0330 abstractC03302 = this.f2380.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1740(ࢤ.ࢠ, ࢧ.ࢢ, interstitialAd.getAdUnitId(), new Object[0]);
                    }
                }

                @Override // com.google.android.gms.ads.AdListener
                public void onAdLeftApplication() {
                    super.onAdLeftApplication();
                    AbstractC0330 abstractC03302 = this.f2380.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1739(ࢤ.ࢠ, ࢧ.ࢢ, interstitialAd.getAdUnitId(), new Object[0]);
                    }
                }

                @Override // com.google.android.gms.ads.AdListener
                public void onAdOpened() {
                    super.onAdOpened();
                    AbstractC0330 abstractC03302 = this.f2380.get();
                    if (abstractC03302 != null) {
                        abstractC03302.mo1738(ࢤ.ࢠ, ࢧ.ࢢ, interstitialAd.getAdUnitId(), new Object[0]);
                    }
                }
            });
            interstitialAd.show();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1875(Object obj, ViewGroup viewGroup, ࢦ r2, AbstractC0330 abstractC0330) {
        if (obj instanceof AdView) {
            m1873((AdView) obj, viewGroup, abstractC0330);
        } else if (obj instanceof InterstitialAd) {
            m1874((InterstitialAd) obj, abstractC0330);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static boolean m1876(Object obj) {
        if (obj instanceof AdView) {
            AdView adView = (AdView) obj;
            return true;
        } else if (obj instanceof InterstitialAd) {
            return ((InterstitialAd) obj).isLoaded();
        } else {
            return false;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static void m1877(Object obj) {
        if (obj instanceof AdView) {
            ((AdView) obj).destroy();
        } else {
            boolean z = obj instanceof InterstitialAd;
        }
    }
}
