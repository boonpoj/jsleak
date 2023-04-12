package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzpg extends zzpv implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static String[] zzbvj = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO};
    FrameLayout zzamm;
    private zzos zzbuf;
    private final FrameLayout zzbvk;
    private View zzbvl;
    private final boolean zzbvm;
    private View zzbvo;
    private final Object mLock = new Object();
    private Map<String, WeakReference<View>> zzbvn = Collections.synchronizedMap(new HashMap());
    private boolean zzbvp = false;
    private Point zzbvq = new Point();
    private Point zzbvr = new Point();
    private WeakReference<zzgp> zzbvs = new WeakReference<>(null);

    /* renamed from: com.google.android.gms.internal.zzpg$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 extends zza {
        final /* synthetic */ boolean zzWA;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, boolean z) {
            super(null);
            this.zztd = context;
            this.zzWA = z;
        }

        public void zzcm() {
            SharedPreferences.Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putBoolean("use_https", this.zzWA);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$10  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass10 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass10(Context context, zzb zzbVar) {
            super(null);
            this.zztd = context;
            this.zzWD = zzbVar;
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", zzm.getBoolean("use_https", true));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$11  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass11 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(Context context, zzb zzbVar) {
            super(null);
            this.zztd = context;
            this.zzWD = zzbVar;
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", zzm.getInt("webview_cache_version", 0));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$12  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass12 extends zza {
        final /* synthetic */ boolean zzWI;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass12(Context context, boolean z) {
            super(null);
            this.zztd = context;
            this.zzWI = z;
        }

        public void zzcm() {
            SharedPreferences.Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putBoolean("content_url_opted_out", this.zzWI);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$13  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass13 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass13(Context context, zzb zzbVar) {
            super(null);
            this.zztd = context;
            this.zzWD = zzbVar;
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", zzm.getBoolean("content_url_opted_out", true));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$14  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass14 extends zza {
        final /* synthetic */ String zzWB;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass14(Context context, String str) {
            super(null);
            this.zztd = context;
            this.zzWB = str;
        }

        public void zzcm() {
            SharedPreferences.Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putString("content_url_hashes", this.zzWB);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$15  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass15 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass15(Context context, zzb zzbVar) {
            super(null);
            this.zztd = context;
            this.zzWD = zzbVar;
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putString("content_url_hashes", zzm.getString("content_url_hashes", ""));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass2 extends zza {
        final /* synthetic */ String zzWB;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, String str) {
            super(null);
            this.zztd = context;
            this.zzWB = str;
        }

        public void zzcm() {
            SharedPreferences.Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putString("content_vertical_hashes", this.zzWB);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass3 extends zza {
        final /* synthetic */ boolean zzWC;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Context context, boolean z) {
            super(null);
            this.zztd = context;
            this.zzWC = z;
        }

        public void zzcm() {
            SharedPreferences.Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putBoolean("auto_collect_location", this.zzWC);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass4 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Context context, zzb zzbVar) {
            super(null);
            this.zztd = context;
            this.zzWD = zzbVar;
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", zzm.getBoolean("auto_collect_location", false));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass5 extends zza {
        final /* synthetic */ String zzWE;
        final /* synthetic */ long zzWF;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Context context, String str, long j) {
            super(null);
            this.zztd = context;
            this.zzWE = str;
            this.zzWF = j;
        }

        public void zzcm() {
            SharedPreferences.Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putString("app_settings_json", this.zzWE);
            edit.putLong("app_settings_last_update_ms", this.zzWF);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$6  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass6 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(Context context, zzb zzbVar) {
            super(null);
            this.zztd = context;
            this.zzWD = zzbVar;
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putString("app_settings_json", zzm.getString("app_settings_json", ""));
            bundle.putLong("app_settings_last_update_ms", zzm.getLong("app_settings_last_update_ms", 0L));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$7  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass7 extends zza {
        final /* synthetic */ long zzWG;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(Context context, long j) {
            super(null);
            this.zztd = context;
            this.zzWG = j;
        }

        public void zzcm() {
            SharedPreferences.Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putLong("app_last_background_time_ms", this.zzWG);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$8  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass8 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(Context context, zzb zzbVar) {
            super(null);
            this.zztd = context;
            this.zzWD = zzbVar;
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", zzm.getLong("app_last_background_time_ms", 0L));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg$9  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass9 extends zza {
        final /* synthetic */ int zzWH;
        final /* synthetic */ Context zztd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Context context, int i) {
            super(null);
            this.zztd = context;
            this.zzWH = i;
        }

        public void zzcm() {
            SharedPreferences.Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putInt("request_in_session_count", this.zzWH);
            edit.apply();
        }
    }

    /* loaded from: assets/classes2.dex */
    private static abstract class zza extends zzpd {
        private zza() {
        }

        /* synthetic */ zza(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onStop() {
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zzb {
        void zzh(Bundle bundle);
    }

    public zzpg(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzbvk = frameLayout;
        this.zzamm = frameLayout2;
        com.google.android.gms.ads.internal.zzbs.zzfc();
        zzaln.zza((View) this.zzbvk, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzbs.zzfc();
        zzaln.zza((View) this.zzbvk, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzbvk.setOnTouchListener(this);
        this.zzbvk.setOnClickListener(this);
        if (frameLayout2 != null && com.google.android.gms.common.util.zzq.zzamn()) {
            frameLayout2.setElevation(Float.MAX_VALUE);
        }
        zznh.initialize(this.zzbvk.getContext());
        this.zzbvm = ((Boolean) zzkb.zzif().zzd(zznh.zzboy)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzow zzowVar) {
        View view;
        synchronized (this.mLock) {
            zzowVar.zzh(this.zzbvn);
            if (this.zzbvn != null) {
                for (String str : zzbvj) {
                    WeakReference<View> weakReference = this.zzbvn.get(str);
                    if (weakReference != null) {
                        view = weakReference.get();
                        break;
                    }
                }
            }
            view = null;
            if (!(view instanceof FrameLayout)) {
                zzowVar.zzki();
                return;
            }
            zzpi zzpiVar = new zzpi(this, view);
            if (zzowVar instanceof zzor) {
                zzowVar.zzb(view, zzpiVar);
            } else {
                zzowVar.zza(view, zzpiVar);
            }
        }
    }

    private final void zzk(View view) {
        zzos zzosVar = this.zzbuf;
        if (zzosVar != null) {
            if (zzosVar instanceof zzor) {
                zzosVar = ((zzor) zzosVar).zzkf();
            }
            if (zzosVar != null) {
                zzosVar.zzk(view);
            }
        }
    }

    private final void zzkl() {
        synchronized (this.mLock) {
            if (!this.zzbvm && this.zzbvp) {
                int measuredWidth = this.zzbvk.getMeasuredWidth();
                int measuredHeight = this.zzbvk.getMeasuredHeight();
                if (measuredWidth != 0 && measuredHeight != 0 && this.zzamm != null) {
                    this.zzamm.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, measuredHeight));
                    this.zzbvp = false;
                }
            }
        }
    }

    private final int zzt(int i) {
        zzkb.zzia();
        return zzajr.zzd(this.zzbuf.getContext(), i);
    }

    @Override // com.google.android.gms.internal.zzpu
    public final void destroy() {
        synchronized (this.mLock) {
            if (this.zzamm != null) {
                this.zzamm.removeAllViews();
            }
            this.zzamm = null;
            this.zzbvn = null;
            this.zzbvo = null;
            this.zzbuf = null;
            this.zzbvq = null;
            this.zzbvr = null;
            this.zzbvs = null;
            this.zzbvl = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzos zzosVar;
        String str;
        Map<String, WeakReference<View>> map;
        FrameLayout frameLayout;
        synchronized (this.mLock) {
            if (this.zzbuf == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat(AvidJSONUtil.KEY_X, zzt(this.zzbvq.x));
            bundle.putFloat(AvidJSONUtil.KEY_Y, zzt(this.zzbvq.y));
            bundle.putFloat("start_x", zzt(this.zzbvr.x));
            bundle.putFloat("start_y", zzt(this.zzbvr.y));
            if (this.zzbvo == null || !this.zzbvo.equals(view)) {
                this.zzbuf.zza(view, this.zzbvn, bundle, this.zzbvk);
            } else {
                if (!(this.zzbuf instanceof zzor)) {
                    zzosVar = this.zzbuf;
                    str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
                    map = this.zzbvn;
                    frameLayout = this.zzbvk;
                } else if (((zzor) this.zzbuf).zzkf() != null) {
                    zzosVar = ((zzor) this.zzbuf).zzkf();
                    str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
                    map = this.zzbvn;
                    frameLayout = this.zzbvk;
                }
                zzosVar.zza(view, str, bundle, map, frameLayout);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        synchronized (this.mLock) {
            zzkl();
            if (this.zzbuf != null) {
                this.zzbuf.zzc(this.zzbvk, this.zzbvn);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        synchronized (this.mLock) {
            if (this.zzbuf != null) {
                this.zzbuf.zzc(this.zzbvk, this.zzbvn);
            }
            zzkl();
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzbuf == null) {
                return false;
            }
            int[] iArr = new int[2];
            this.zzbvk.getLocationOnScreen(iArr);
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

    @Override // com.google.android.gms.internal.zzpu
    public final void zza(IObjectWrapper iObjectWrapper) {
        zzow zzowVar;
        zzow zzowVar2;
        synchronized (this.mLock) {
            ViewGroup viewGroup = null;
            zzk(null);
            Object zzx = com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
            if (!(zzx instanceof zzow)) {
                zzagf.zzcu("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            if (!this.zzbvm && this.zzamm != null) {
                this.zzamm.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
                this.zzbvk.requestLayout();
            }
            boolean z = true;
            this.zzbvp = true;
            zzow zzowVar3 = (zzow) zzx;
            if (this.zzbuf != null) {
                if (((Boolean) zzkb.zzif().zzd(zznh.zzboq)).booleanValue()) {
                    this.zzbuf.zzb(this.zzbvk, this.zzbvn);
                }
            }
            if ((this.zzbuf instanceof zzow) && (zzowVar2 = (zzow) this.zzbuf) != null && zzowVar2.getContext() != null && com.google.android.gms.ads.internal.zzbs.zzfd().zzs(this.zzbvk.getContext())) {
                zzafe zzkk = zzowVar2.zzkk();
                if (zzkk != null) {
                    zzkk.zzu(false);
                }
                zzgp zzgpVar = this.zzbvs.get();
                if (zzgpVar != null && zzkk != null) {
                    zzgpVar.zzb(zzkk);
                }
            }
            if ((this.zzbuf instanceof zzor) && ((zzor) this.zzbuf).zzke()) {
                ((zzor) this.zzbuf).zzc(zzowVar3);
            } else {
                this.zzbuf = zzowVar3;
                if (zzowVar3 instanceof zzor) {
                    ((zzor) zzowVar3).zzc(null);
                }
            }
            if (this.zzamm == null) {
                return;
            }
            if (((Boolean) zzkb.zzif().zzd(zznh.zzboq)).booleanValue()) {
                this.zzamm.setClickable(false);
            }
            this.zzamm.removeAllViews();
            boolean zzkc = zzowVar3.zzkc();
            if (zzkc && this.zzbvn != null) {
                WeakReference<View> weakReference = this.zzbvn.get(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
                KeyEvent.Callback callback = weakReference != null ? (View) weakReference.get() : null;
                if (callback instanceof ViewGroup) {
                    viewGroup = (ViewGroup) callback;
                }
            }
            if (!zzkc || viewGroup == null) {
                z = false;
            }
            this.zzbvo = zzowVar3.zza(this, z);
            if (this.zzbvo != null) {
                if (this.zzbvn != null) {
                    this.zzbvn.put(NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, new WeakReference<>(this.zzbvo));
                }
                if (z) {
                    viewGroup.removeAllViews();
                    viewGroup.addView(this.zzbvo);
                } else {
                    AdChoicesView adChoicesView = new AdChoicesView(zzowVar3.getContext());
                    adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    adChoicesView.addView(this.zzbvo);
                    if (this.zzamm != null) {
                        this.zzamm.addView(adChoicesView);
                    }
                }
            }
            zzowVar3.zza(this.zzbvk, this.zzbvn, (Map<String, WeakReference<View>>) null, this, this);
            zzahn.zzdaw.post(new zzph(this, zzowVar3));
            zzk(this.zzbvk);
            this.zzbuf.zzi(this.zzbvk);
            if ((this.zzbuf instanceof zzow) && (zzowVar = (zzow) this.zzbuf) != null && zzowVar.getContext() != null && com.google.android.gms.ads.internal.zzbs.zzfd().zzs(this.zzbvk.getContext())) {
                zzgp zzgpVar2 = this.zzbvs.get();
                if (zzgpVar2 == null) {
                    zzgpVar2 = new zzgp(this.zzbvk.getContext(), this.zzbvk);
                    this.zzbvs = new WeakReference<>(zzgpVar2);
                }
                zzgpVar2.zza(zzowVar.zzkk());
            }
        }
    }

    @Override // com.google.android.gms.internal.zzpu
    public final IObjectWrapper zzal(String str) {
        synchronized (this.mLock) {
            View view = null;
            if (this.zzbvn == null) {
                return null;
            }
            WeakReference<View> weakReference = this.zzbvn.get(str);
            if (weakReference != null) {
                view = weakReference.get();
            }
            return com.google.android.gms.dynamic.zzn.zzz(view);
        }
    }

    @Override // com.google.android.gms.internal.zzpu
    public final void zzb(IObjectWrapper iObjectWrapper, int i) {
        WeakReference<zzgp> weakReference;
        zzgp zzgpVar;
        if (com.google.android.gms.ads.internal.zzbs.zzfd().zzs(this.zzbvk.getContext()) && (weakReference = this.zzbvs) != null && (zzgpVar = weakReference.get()) != null) {
            zzgpVar.zzgi();
        }
        zzkl();
    }

    @Override // com.google.android.gms.internal.zzpu
    public final void zzb(String str, IObjectWrapper iObjectWrapper) {
        View view = (View) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper);
        synchronized (this.mLock) {
            if (this.zzbvn == null) {
                return;
            }
            if (view == null) {
                this.zzbvn.remove(str);
            } else {
                this.zzbvn.put(str, new WeakReference<>(view));
                if (NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                    return;
                }
                view.setOnTouchListener(this);
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }
}
