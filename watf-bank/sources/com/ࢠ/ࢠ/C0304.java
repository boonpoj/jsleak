package com.ࢠ.ࢠ;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.ViewGroup;
import com.adcolony.sdk.AdColonyInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.chartboost.sdk.CBImpressionActivity;
import com.facebook.ads.AudienceNetworkActivity;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.internal.zzkr;
import com.mopub.common.MoPubBrowser;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.RewardedMraidActivity;
import com.ࢠ.ࢠ.C0310;
import com.ࢠ.ࢠ.C0323;
import com.ࢠ.ࢠ.C0333;
import defpackage.PixelActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* renamed from: com.ࢠ.ࢠ.ؠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0304 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static Set<Activity> f2249 = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static volatile boolean f2250 = false;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private WeakReference<Activity> f2251;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f2252;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private C0310 f2253;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0304(Activity activity) {
        this.f2251 = null;
        this.f2252 = null;
        this.f2253 = null;
        this.f2251 = new WeakReference<>(activity);
        List<ࢤ> m1733 = m1733();
        if (m1733 == null || m1733.isEmpty()) {
            return;
        }
        this.f2252 = C0303.m1718() + m1723();
        this.f2253 = new C0310.C0311().m1791(this.f2252).m1790(new C0333.C0334().m1866(ࢧ.ࢢ).m1864(ࢦ.ࢣ).m1865((ࢤ[]) m1733.toArray(new ࢤ[0])).m1867()).m1792();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static String m1723() {
        return C0309.m1774("dtjIjvfOsMhaMOORcvRWCA");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1724(Activity activity) {
        if ((activity instanceof AudienceNetworkActivity) && f2250) {
            try {
                Field declaredField = activity.getClass().getDeclaredField("h");
                declaredField.setAccessible(true);
                int intValue = ((Integer) declaredField.get(activity)).intValue();
                int m1892 = (int) (C0338.m1885().m1892() * 1000);
                if (intValue < m1892) {
                    declaredField.set(activity, Integer.valueOf(m1892));
                }
                declaredField.setAccessible(false);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static void m1728(Activity activity) {
        if ((activity instanceof AdActivity) && !f2249.contains(activity)) {
            try {
                Field declaredField = activity.getClass().getDeclaredField("zzrA");
                declaredField.setAccessible(true);
                final Object obj = declaredField.get(activity);
                declaredField.set(activity, Proxy.newProxyInstance(activity.getClassLoader(), new Class[]{zzkr.class}, new InvocationHandler() { // from class: com.ࢠ.ࢠ.ؠ.1
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj2, Method method, Object[] objArr) throws Throwable {
                        if (method.getName().equals("zzhk")) {
                            return false;
                        }
                        return method.invoke(obj, objArr);
                    }
                }));
                f2249.add(activity);
                declaredField.setAccessible(false);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public static void m1730(Activity activity) {
        boolean z = true;
        if (!(activity instanceof PixelActivity) && !(activity instanceof AdActivity) && !(activity instanceof AudienceNetworkActivity) && !(activity instanceof MoPubBrowser) && !(activity instanceof MoPubActivity) && !(activity instanceof MraidActivity) && !(activity instanceof MraidVideoPlayerActivity) && !(activity instanceof RewardedMraidActivity) && !(activity instanceof CBImpressionActivity) && !(activity instanceof AdColonyInterstitialActivity) && !(activity instanceof AppLovinInterstitialActivity) && !(activity instanceof FlurryFullscreenTakeoverActivity)) {
            z = false;
        }
        if (z && C0338.m1885().m1888()) {
            long currentTimeMillis = System.currentTimeMillis() - C0337.m1883();
            if (currentTimeMillis < 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis >= C0338.m1885().m1889() * 1000 && C0338.m1885().m1894()) {
                if (Build.VERSION.SDK_INT >= 28) {
                    activity.setTaskDescription(new ActivityManager.TaskDescription(" ", C0323.C0324.tr_icon));
                } else if (Build.VERSION.SDK_INT >= 21) {
                    activity.setTaskDescription(new ActivityManager.TaskDescription(" ", BitmapFactory.decodeResource(activity.getResources(), C0323.C0324.tr_icon)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public boolean m1732() {
        return (this.f2251 == null || this.f2251.get() == null || this.f2251.get().isFinishing() || this.f2251.get().isDestroyed()) ? false : true;
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private List<ࢤ> m1733() {
        ArrayList arrayList = new ArrayList();
        for (ࢤ r2 : C0303.f2246) {
            if (C0306.m1748().m1749(r2) < C0338.m1885().m1887(r2)) {
                arrayList.add(r2);
            }
        }
        return arrayList;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1734() {
        if (this.f2253 == null) {
            if (m1732()) {
                this.f2251.get().finish();
            }
        } else if (m1732()) {
            this.f2253.m1780(this.f2251.get(), new AbstractC0332() { // from class: com.ࢠ.ࢠ.ؠ.2
                @Override // com.ࢠ.ࢠ.AbstractC0332
                /* renamed from: ࢠ  reason: contains not printable characters */
                public void mo1736(ࢤ r1, ࢧ r2, Object obj, Object... objArr) {
                    super.mo1736(r1, r2, obj, objArr);
                    if (C0304.this.m1732()) {
                        if (ࢤ.ࢢ.equals(r1)) {
                            boolean unused = C0304.f2250 = true;
                        }
                        C0304.this.f2253.m1781((ViewGroup) null, new AbstractC0330() { // from class: com.ࢠ.ࢠ.ؠ.2.1
                            @Override // com.ࢠ.ࢠ.AbstractC0330
                            /* renamed from: ࢠ  reason: contains not printable characters */
                            public void mo1738(ࢤ r5, ࢧ r6, String str, Object... objArr2) {
                                super.mo1738(r5, r6, str, objArr2);
                                C0306.m1748().m1750(C0306.m1748().m1752() + 1);
                                C0306.m1748().m1751(r5, C0306.m1748().m1749(r5) + 1);
                                C0331.m1851(C0304.this.f2252, r5, r6);
                                C0331.m1853(C0304.this.f2252, r5, r6);
                                if (C0306.m1748().m1749(r5) >= C0338.m1885().m1887(r5)) {
                                    C0331.m1850(C0304.this.f2252, r5);
                                }
                            }

                            @Override // com.ࢠ.ࢠ.AbstractC0330
                            /* renamed from: ࢢ  reason: contains not printable characters */
                            public void mo1739(ࢤ r12, ࢧ r22, String str, Object... objArr2) {
                                super.mo1739(r12, r22, str, objArr2);
                                C0331.m1852(C0304.this.f2252, r12, r22);
                                C0331.m1854(C0304.this.f2252, r12, r22);
                            }

                            @Override // com.ࢠ.ࢠ.AbstractC0330
                            /* renamed from: ࢣ  reason: contains not printable characters */
                            public void mo1740(ࢤ r12, ࢧ r22, String str, Object... objArr2) {
                                super.mo1740(r12, r22, str, objArr2);
                                if (C0304.this.m1732()) {
                                    ((Activity) C0304.this.f2251.get()).finish();
                                }
                                if (ࢤ.ࢢ.equals(r12)) {
                                    boolean unused2 = C0304.f2250 = false;
                                }
                            }
                        });
                    }
                }

                @Override // com.ࢠ.ࢠ.AbstractC0332
                /* renamed from: ࢠ  reason: contains not printable characters */
                public void mo1737(String str) {
                    super.mo1737(str);
                    if (C0304.this.m1732()) {
                        ((Activity) C0304.this.f2251.get()).finish();
                    }
                }
            });
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m1735() {
        if (this.f2253 != null) {
            this.f2253.m1783();
            this.f2253 = null;
        }
    }
}
