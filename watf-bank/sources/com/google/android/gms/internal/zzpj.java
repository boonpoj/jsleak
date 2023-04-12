package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzpj extends zzqa implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    static final String[] zzbvj = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO};
    private zzos zzbuf;
    private View zzbvo;
    private final WeakReference<View> zzbvw;
    private final Object mLock = new Object();
    private final Map<String, WeakReference<View>> zzbvx = new HashMap();
    private final Map<String, WeakReference<View>> zzbvy = new HashMap();
    private final Map<String, WeakReference<View>> zzbvz = new HashMap();
    private Point zzbvq = new Point();
    private Point zzbvr = new Point();
    private WeakReference<zzgp> zzbvs = new WeakReference<>(null);

    @TargetApi(9)
    /* loaded from: assets/classes2.dex */
    public static class zza extends zzpj {
        public zza() {
            super(null);
        }

        public boolean zza(DownloadManager.Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        public int zzkp() {
            return 6;
        }

        public int zzkq() {
            return 7;
        }
    }

    @TargetApi(11)
    /* loaded from: assets/classes2.dex */
    public static class zzb extends zza {
        @Override // com.google.android.gms.internal.zzpj.zza
        public boolean zza(DownloadManager.Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        public boolean zza(final Context context, final WebSettings webSettings) {
            super.zza(context, webSettings);
            return ((Boolean) zzpv.zzb(new Callable<Boolean>(this) { // from class: com.google.android.gms.internal.zzpj.zzb.1
                @Override // java.util.concurrent.Callable
                /* renamed from: zzkt */
                public Boolean call() {
                    if (context.getCacheDir() != null) {
                        webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                        webSettings.setAppCacheMaxSize(0L);
                        webSettings.setAppCacheEnabled(true);
                    }
                    webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                    webSettings.setDatabaseEnabled(true);
                    webSettings.setDomStorageEnabled(true);
                    webSettings.setDisplayZoomControls(false);
                    webSettings.setBuiltInZoomControls(true);
                    webSettings.setSupportZoom(true);
                    webSettings.setAllowContentAccess(false);
                    return true;
                }
            })).booleanValue();
        }

        public boolean zza(Window window) {
            window.setFlags(16777216, 16777216);
            return true;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzqq, com.google.android.gms.internal.zzqx] */
        public zzqq zzb(zzqp zzqpVar, boolean z) {
            return new zzqx(zzqpVar, z);
        }

        public Set<String> zzh(Uri uri) {
            return uri.getQueryParameterNames();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzqw, android.webkit.WebChromeClient] */
        public WebChromeClient zzn(zzqp zzqpVar) {
            return new zzqw(zzqpVar);
        }

        public boolean zzt(View view) {
            view.setLayerType(0, null);
            return true;
        }

        public boolean zzu(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    @TargetApi(14)
    /* loaded from: assets/classes2.dex */
    public static class zzc extends zzb {
        public String zza(SslError sslError) {
            return sslError.getUrl();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzqy, android.webkit.WebChromeClient] */
        @Override // com.google.android.gms.internal.zzpj.zzb
        public WebChromeClient zzn(zzqp zzqpVar) {
            return new zzqy(zzqpVar);
        }
    }

    @TargetApi(17)
    /* loaded from: assets/classes2.dex */
    public static class zzd extends zzf {
        public String getDefaultUserAgent(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
            if (!z || f <= 0.0f || f > 25.0f) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                RenderScript create = RenderScript.create(context);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                return new BitmapDrawable(context.getResources(), createBitmap);
            } catch (RuntimeException unused) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }

        @Override // com.google.android.gms.internal.zzpj.zzf, com.google.android.gms.internal.zzpj.zzb
        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    @TargetApi(18)
    /* loaded from: assets/classes2.dex */
    public static class zze extends zzd {
        public boolean isAttachedToWindow(View view) {
            return super.isAttachedToWindow(view) || view.getWindowId() != null;
        }

        public int zzkr() {
            return 14;
        }
    }

    @TargetApi(16)
    /* loaded from: assets/classes2.dex */
    public static class zzf extends zzc {
        public void zza(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        @Override // com.google.android.gms.internal.zzpj.zzb
        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
            return true;
        }

        public void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
                return;
            }
            zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    @TargetApi(19)
    /* loaded from: assets/classes2.dex */
    public static class zzg extends zze {
        @Override // com.google.android.gms.internal.zzpj.zze
        public boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }

        public ViewGroup.LayoutParams zzks() {
            return new ViewGroup.LayoutParams(-1, -1);
        }
    }

    @TargetApi(21)
    /* loaded from: assets/classes2.dex */
    public static class zzh extends zzg {
        public CookieManager zzL(Context context) {
            return CookieManager.getInstance();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzrb, com.google.android.gms.internal.zzqq] */
        @Override // com.google.android.gms.internal.zzpj.zzb
        public zzqq zzb(zzqp zzqpVar, boolean z) {
            return new zzrb(zzqpVar, z);
        }
    }

    public zzpj(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        com.google.android.gms.ads.internal.zzbs.zzfc();
        zzaln.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzbs.zzfc();
        zzaln.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        this.zzbvw = new WeakReference<>(view);
        zzi(hashMap);
        this.zzbvz.putAll(this.zzbvx);
        zzj(hashMap2);
        this.zzbvz.putAll(this.zzbvy);
        zznh.initialize(view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzow zzowVar) {
        View view;
        synchronized (this.mLock) {
            String[] strArr = zzbvj;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    view = null;
                    break;
                }
                WeakReference<View> weakReference = this.zzbvz.get(strArr[i]);
                if (weakReference != null) {
                    view = weakReference.get();
                    break;
                }
                i++;
            }
            if (!(view instanceof FrameLayout)) {
                zzowVar.zzki();
                return;
            }
            zzpl zzplVar = new zzpl(this, view);
            if (zzowVar instanceof zzor) {
                zzowVar.zzb(view, zzplVar);
            } else {
                zzowVar.zza(view, zzplVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zza(String[] strArr) {
        for (String str : strArr) {
            if (this.zzbvx.get(str) != null) {
                return true;
            }
        }
        for (String str2 : strArr) {
            if (this.zzbvy.get(str2) != null) {
                return false;
            }
        }
        return false;
    }

    private final void zzi(Map<String, View> map) {
        for (Map.Entry<String, View> entry : map.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.zzbvx.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
    }

    private final void zzj(Map<String, View> map) {
        for (Map.Entry<String, View> entry : map.entrySet()) {
            View value = entry.getValue();
            if (value != null) {
                this.zzbvy.put(entry.getKey(), new WeakReference<>(value));
                value.setOnTouchListener(this);
            }
        }
    }

    private final void zzk(View view) {
        synchronized (this.mLock) {
            if (this.zzbuf != null) {
                zzos zzkf = this.zzbuf instanceof zzor ? ((zzor) this.zzbuf).zzkf() : this.zzbuf;
                if (zzkf != null) {
                    zzkf.zzk(view);
                }
            }
        }
    }

    private final int zzt(int i) {
        int zzd2;
        synchronized (this.mLock) {
            zzkb.zzia();
            zzd2 = zzajr.zzd(this.zzbuf.getContext(), i);
        }
        return zzd2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzos zzosVar;
        String str;
        Map<String, WeakReference<View>> map;
        synchronized (this.mLock) {
            if (this.zzbuf == null) {
                return;
            }
            View view2 = this.zzbvw.get();
            if (view2 == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat(AvidJSONUtil.KEY_X, zzt(this.zzbvq.x));
            bundle.putFloat(AvidJSONUtil.KEY_Y, zzt(this.zzbvq.y));
            bundle.putFloat("start_x", zzt(this.zzbvr.x));
            bundle.putFloat("start_y", zzt(this.zzbvr.y));
            if (this.zzbvo == null || !this.zzbvo.equals(view)) {
                this.zzbuf.zza(view, this.zzbvz, bundle, view2);
            } else {
                if (!(this.zzbuf instanceof zzor)) {
                    zzosVar = this.zzbuf;
                    str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
                    map = this.zzbvz;
                } else if (((zzor) this.zzbuf).zzkf() != null) {
                    zzosVar = ((zzor) this.zzbuf).zzkf();
                    str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
                    map = this.zzbvz;
                }
                zzosVar.zza(view, str, bundle, map, view2);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View view;
        synchronized (this.mLock) {
            if (this.zzbuf != null && (view = this.zzbvw.get()) != null) {
                this.zzbuf.zzc(view, this.zzbvz);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        View view;
        synchronized (this.mLock) {
            if (this.zzbuf != null && (view = this.zzbvw.get()) != null) {
                this.zzbuf.zzc(view, this.zzbvz);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzbuf == null) {
                return false;
            }
            View view2 = this.zzbvw.get();
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            Point point = new Point((int) (motionEvent.getRawX() - iArr[0]), (int) (motionEvent.getRawY() - iArr[1]));
            this.zzbvq = point;
            if (motionEvent.getAction() == 0) {
                this.zzbvr = point;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation(point.x, point.y);
            this.zzbuf.zzd(obtain);
            obtain.recycle();
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzpz
    public final void unregisterNativeAd() {
        synchronized (this.mLock) {
            this.zzbvo = null;
            this.zzbuf = null;
            this.zzbvq = null;
            this.zzbvr = null;
        }
    }

    @Override // com.google.android.gms.internal.zzpz
    public final void zza(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            zzk(null);
            Object zzx = com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
            if (!(zzx instanceof zzow)) {
                zzagf.zzcu("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            zzow zzowVar = (zzow) zzx;
            if (!zzowVar.zzkd()) {
                zzagf.e("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
                return;
            }
            View view = this.zzbvw.get();
            if (this.zzbuf != null && view != null) {
                if (((Boolean) zzkb.zzif().zzd(zznh.zzboq)).booleanValue()) {
                    this.zzbuf.zzb(view, this.zzbvz);
                }
            }
            synchronized (this.mLock) {
                if (this.zzbuf instanceof zzow) {
                    zzow zzowVar2 = (zzow) this.zzbuf;
                    View view2 = this.zzbvw.get();
                    if (zzowVar2 != null && zzowVar2.getContext() != null && view2 != null && com.google.android.gms.ads.internal.zzbs.zzfd().zzs(view2.getContext())) {
                        zzafe zzkk = zzowVar2.zzkk();
                        if (zzkk != null) {
                            zzkk.zzu(false);
                        }
                        zzgp zzgpVar = this.zzbvs.get();
                        if (zzgpVar != null && zzkk != null) {
                            zzgpVar.zzb(zzkk);
                        }
                    }
                }
            }
            if ((this.zzbuf instanceof zzor) && ((zzor) this.zzbuf).zzke()) {
                ((zzor) this.zzbuf).zzc(zzowVar);
            } else {
                this.zzbuf = zzowVar;
                if (zzowVar instanceof zzor) {
                    ((zzor) zzowVar).zzc(null);
                }
            }
            WeakReference<View> weakReference = this.zzbvz.get(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
            if (weakReference == null) {
                zzagf.zzcu("Ad choices asset view is not provided.");
            } else {
                View view3 = weakReference.get();
                ViewGroup viewGroup = view3 instanceof ViewGroup ? (ViewGroup) view3 : null;
                if (viewGroup != null) {
                    this.zzbvo = zzowVar.zza((View.OnClickListener) this, true);
                    if (this.zzbvo != null) {
                        this.zzbvz.put(NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, new WeakReference<>(this.zzbvo));
                        this.zzbvx.put(NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, new WeakReference<>(this.zzbvo));
                        viewGroup.removeAllViews();
                        viewGroup.addView(this.zzbvo);
                    }
                }
            }
            zzowVar.zza(view, this.zzbvx, this.zzbvy, this, this);
            zzahn.zzdaw.post(new zzpk(this, zzowVar));
            zzk(view);
            this.zzbuf.zzi(view);
            synchronized (this.mLock) {
                if (this.zzbuf instanceof zzow) {
                    zzow zzowVar3 = (zzow) this.zzbuf;
                    View view4 = this.zzbvw.get();
                    if (zzowVar3 != null && zzowVar3.getContext() != null && view4 != null && com.google.android.gms.ads.internal.zzbs.zzfd().zzs(view4.getContext())) {
                        zzgp zzgpVar2 = this.zzbvs.get();
                        if (zzgpVar2 == null) {
                            zzgpVar2 = new zzgp(view4.getContext(), view4);
                            this.zzbvs = new WeakReference<>(zzgpVar2);
                        }
                        zzgpVar2.zza(zzowVar3.zzkk());
                    }
                }
            }
        }
    }
}
