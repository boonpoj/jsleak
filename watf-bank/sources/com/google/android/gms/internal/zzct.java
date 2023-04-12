package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzqi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public class zzct extends zzcs {
    protected boolean zzahr;
    private String zzahs;
    private boolean zzaht;
    private boolean zzahu;
    private zzdt zzahv;
    private static Object zzahq = new Object();
    private static final String TAG = zzct.class.getSimpleName();
    private static volatile zzdm zzagr = null;
    private static boolean initialized = false;
    private static long startTime = 0;

    /* renamed from: com.google.android.gms.internal.zzct$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zzqi.zzc<zzjb> {
        AnonymousClass1() {
        }

        @Override // com.google.android.gms.internal.zzqi.zzc
        /* renamed from: zzb */
        public void zzd(zzjb zzjbVar) {
            zzct.zza(zzct.this, true);
            zzct.this.zzc(zzjbVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zzqi.zza {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.zzcu, com.google.android.gms.internal.zzct] */
        @Override // com.google.android.gms.internal.zzqi.zza
        public void run() {
            zzct.zza(zzct.this).zzb(zzct.this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements zzqi.zzc<zzjb> {
        final /* synthetic */ JSONObject zzwG;

        AnonymousClass3(zzct zzctVar, JSONObject jSONObject) {
            this.zzwG = jSONObject;
        }

        @Override // com.google.android.gms.internal.zzqi.zzc
        /* renamed from: zzb */
        public void zzd(zzjb zzjbVar) {
            zzjbVar.zza("AFMA_updateActiveView", this.zzwG);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 implements zzqi.zzc<zzjb> {
        AnonymousClass4() {
        }

        @Override // com.google.android.gms.internal.zzqi.zzc
        /* renamed from: zzb */
        public void zzd(zzjb zzjbVar) {
            zzct.this.zzd(zzjbVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass5 implements zzhx {
        AnonymousClass5() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            if (zzct.zza(zzct.this).zzb(map)) {
                zzct.zza(zzct.this).zzb(zzqpVar, map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$6  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass6 implements zzhx {
        AnonymousClass6() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzcu, com.google.android.gms.internal.zzct] */
        public void zza(zzqp zzqpVar, Map<String, String> map) {
            if (zzct.zza(zzct.this).zzb(map)) {
                zzct.zza(zzct.this).zza(zzct.this, map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$7  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass7 implements zzhx {
        AnonymousClass7() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            if (zzct.zza(zzct.this).zzb(map)) {
                zzct.zza(zzct.this).zzc(map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzct(Context context, String str, boolean z) {
        super(context);
        this.zzahr = false;
        this.zzaht = false;
        this.zzahu = false;
        this.zzahs = str;
        this.zzahr = z;
    }

    private static zzdq zza(zzdm zzdmVar, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zzdj {
        Method zza = zzdmVar.zza("Qplw2pUqnSpmThNy4cjVdvqrjxx/9Z0jyK1w8BPQVMfA35eh0MC7cXEA3u5Xkcuj", "JqjJogq0azQ/rErdMQn/B0NsEhrIRbxY2b3jvD0/vE8=");
        if (zza == null || motionEvent == null) {
            throw new zzdj();
        }
        try {
            return new zzdq((String) zza.invoke(null, motionEvent, displayMetrics));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new zzdj(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void zza(Context context, boolean z) {
        synchronized (zzct.class) {
            if (!initialized) {
                startTime = zzdr.zzat().longValue() / 1000;
                zzagr = zzb(context, z);
                initialized = true;
            }
        }
    }

    private static zzdm zzb(Context context, boolean z) {
        if (zzagr == null) {
            synchronized (zzahq) {
                if (zzagr == null) {
                    zzdm zza = zzdm.zza(context, "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", z);
                    if (zza.isInitialized()) {
                        zza.zza("VywbbfxE2QuRqZ5xcIwapO7AdSzfVaSWnmJxmUg+0adJ3QBAH5P7EgXr1uzyY+u6", "JgKAyQW0PWqOrZHk4ZNT0IJH02FdSWTXOOjBnF9RRok=", Context.class);
                        zza.zza("yzGxsS8IwfgINPYaD3TFRjRVH+0Pq4QvVGq15MBf/opCBPnlCr4QHvEcReKXEMs7", "kMEgIGkHy2R1ROJUgud//6gDu/wM35rLhA6gUKrjKq0=", Context.class);
                        zza.zza("notQcG55r2oh2A1cS/dLfKg9hawk3H86BF0iXzU7AAnhYpfHWl9mq3lZzdkAltxm", "U9ntf5BvZUTabci6TosC4bQNHZ+DOrzvRmpSy4CzkoQ=", Context.class);
                        zza.zza("2GI4cQuNT2V9TGPC/Z2McvgqRAU80qquJKbm0BMTxLR8WwMEgJwPEKdGCxKNxeUN", "1Kj5K8xXQ2YA9zbG2Rm9FzZtUD9R2drVmZXzLVF7uLA=", Context.class);
                        zza.zza("ZsnUMRH5gS7aUE0TqnSYS8JWwJCKCL7bH7XFSqbI4dWEEyg2o14AuyyBvtsnwc4D", "SFchXCfZXuuDAwXfTJDosXRUHrZZ0v26SJChYX3rL/o=", Context.class);
                        zza.zza("lMH30ZU/uP5xaOsdIj/K3/wZfVr7hnOzUHjpO1NWhTJQvW+gY38/OvCWA8Ap4ZOf", "FCjXGcebz7gnog9LMAWyd/isayIV3I84uK1cUtHZ2fI=", Context.class);
                        zza.zza("oWVj3eW9lsJMixyFq7g0kyuRqYP087mdDp4dCL3paE/7Ut3Ewp3IcEq6P10MPRyy", "siNRngHYHRLjixmg2PEX5OdKhRHe1h8DNRpJp4wC0pk=", Context.class);
                        zza.zza("yATd8qneW4MlwQIx8jIN6cfiWJ28/zOw6vW7xs0IWvNvim2a85v5X4ZiVD1KK9hX", "0wjmexcQnona3bxO7Nd7FrKMEEoBhOp7s6KivBhMQKU=", Context.class);
                        zza.zza("Qplw2pUqnSpmThNy4cjVdvqrjxx/9Z0jyK1w8BPQVMfA35eh0MC7cXEA3u5Xkcuj", "JqjJogq0azQ/rErdMQn/B0NsEhrIRbxY2b3jvD0/vE8=", MotionEvent.class, DisplayMetrics.class);
                        zza.zza("I8ATAvvv3zdNeDvmT5gQ/ekfiNEF+bBdZZ3FGipPSiGHOLI4yQdK3XpX6xFRuejz", "SRWP8PeqaQflId3WUP9WJTho9Un3bF1tLB8c7UP1Ruo=", MotionEvent.class, DisplayMetrics.class, Integer.TYPE);
                        zza.zza("HYkEKMk8dvMdQrlbFR00sh73U7jSOxxrrxd0BhHmEXYlIfEqe1EzBQsw2kucbDs8", "puD1TaAJX/qcP/8PMgKROAswM+eaSDu4sTUEXpqs2fU=", new Class[0]);
                        zza.zza("8Hx2xRqW2QZDPiXj7EKgQgzecg5taNOrZe4YkZ9zi7FcQAOy1BO0rYbAdBI9x6Pm", "nJw4XP5tQfSQ6wm+0x6UMq5j2kNiUh+TXa92gyyhaOo=", new Class[0]);
                        zza.zza("4w5pMN4cUsuXvD3CJ7PKPSwMmWPClIaNSjeM6jtHahV40Q7EiLps1VIbOcEaCSp4", "5XuSFVTSxDkE27CIZHrBIXal5K53Dv1J/UFXKGBFAXY=", new Class[0]);
                        zza.zza("igTfSDGbP3Q2KSYfnqAL0vFW/zSSX6v+f+5s7NdwuKQgo6M7dQVerLATgNETrLAr", "Wz4eX479PrQ8rGu0gkJoEYqOJ2Dr8sAHE85KoBBz7s4=", new Class[0]);
                        zza.zza("BiRNVQ0aQHyQJTXKNLbpSFJJy6+rG5ICwTiWxRhS6qdZjM6S9BBOaVfdO1b0Kd8E", "z9Ycw/7CJTzBzg6MPXNZ2oLMXcxWzT8qsF0ig0ITUxc=", new Class[0]);
                        zza.zza("2glehmg5UKxyaNPdnG06BLa5QbEzBADKVm3lYiT3+JTkguRZEzOA9BDahqC4W8ki", "wM87KVhGHShMaqkZWTxt04VnU6kJHrMxqQyksEW6glI=", new Class[0]);
                        zza.zza("DGPkHpN6F5DQjFiQDfOpLUfwAMooIPhSFT4YA2aSEj+k+u5Kt4pQoimNrK0aCsHP", "V/2NrZQU5cdFMpqYa0Q9vKRizJ0aHS7vWXQS8vp0qlI=", Context.class, Boolean.TYPE);
                        zza.zza("hoZ4RlhPWT5MX/I+m/lUD5aYJ9aPmEb2eUGLaeSBLBDs9eDpXoNNJPm6j1dXVkvA", "Z7StFiuQ59x4y88apmlBJn3lPoWOEnuqoEhP2AVUL8A=", StackTraceElement[].class);
                        zza.zza("peD/v7hHRn46N2uI0dQKpTtMr7rKDQ+Rzb4yluPWMw4TUUwj2SFV9GkdTp0kog66", "XxfDY0AzBkt4iSC5Sim2fww10jQc1evowDldz5+caY4=", View.class, DisplayMetrics.class);
                        zza.zza("cINMMi7uKicDN2DHSf1rHdgax7DU+CM2mIG3cRQw3SI0nkdhPwdVz1PCbewJpJoO", "VWQmr3p+wsDJ15H20t2tLb975qLEArv8gtHgpBQKEOE=", Context.class, Boolean.TYPE);
                        zza.zza("6qQh+8GAMu6fM86JkRzoeHiiHD67+MgHO4xhhwcbyPT7CQmAN57q8YytJQRqDjU5", "Qrc1hPZgr+QjlmQtpbdJO1QCxqr2PdTRKIIDeDNdHp8=", View.class, Activity.class);
                        zza.zza("HBbZPURZUWU/TDYIx99LmOTdgpFP2mdidp6Zk4sZdEVCGaQNYtmNlQBCP3rgXOne", "pdXBsPFh4N2rQp3r0gjTSQiWtas1GOGaKulNSciQTj0=", Long.TYPE);
                    }
                    zzagr = zza;
                }
            }
        }
        return zzagr;
    }

    private static void zzb(List<Callable<Void>> list) {
        ExecutorService zzag;
        if (zzagr == null || (zzag = zzagr.zzag()) == null || list.isEmpty()) {
            return;
        }
        try {
            zzag.invokeAll(list, ((Long) zzkb.zzif().zzd(zznh.zzbnl)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Log.d(TAG, String.format("class methods got exception: %s", zzdr.zza(e)));
        }
    }

    @Override // com.google.android.gms.internal.zzcs
    protected final long zza(StackTraceElement[] stackTraceElementArr) throws zzdj {
        Method zza = zzagr.zza("hoZ4RlhPWT5MX/I+m/lUD5aYJ9aPmEb2eUGLaeSBLBDs9eDpXoNNJPm6j1dXVkvA", "Z7StFiuQ59x4y88apmlBJn3lPoWOEnuqoEhP2AVUL8A=");
        if (zza == null || stackTraceElementArr == null) {
            throw new zzdj();
        }
        try {
            return new zzdk((String) zza.invoke(null, stackTraceElementArr)).zzaim.longValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new zzdj(e);
        }
    }

    @Override // com.google.android.gms.internal.zzcs
    protected final zzaz zza(Context context, View view, Activity activity) {
        List arrayList;
        Long l;
        zzaz zzazVar = new zzaz();
        if (!TextUtils.isEmpty(this.zzahs)) {
            zzazVar.zzcv = this.zzahs;
        }
        zzdm zzb = zzb(context, this.zzahr);
        if (zzb.isInitialized()) {
            try {
                zzdq zza = zza(zzb, this.zzagx, this.zzahp);
                zzazVar.zzdn = zza.zzajl;
                zzazVar.zzdo = zza.zzajm;
                zzazVar.zzdp = zza.zzajn;
                if (this.zzaho) {
                    zzazVar.zzeb = zza.zzfm;
                    zzazVar.zzec = zza.zzfk;
                }
            } catch (zzdj e) {
            }
            zzba zzbaVar = new zzba();
            if (this.zzagz > 0 && zzdr.zza(this.zzahp)) {
                int intValue = ((Integer) zzkb.zzif().zzd(zznh.zzbnq)).intValue();
                zzbaVar.zzfu = Long.valueOf(zzdr.zza(this.zzahg, intValue, this.zzahp));
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbnr)).booleanValue()) {
                    zzbaVar.zzfv = Long.valueOf(zzdr.zza(this.zzahl - this.zzahj, intValue, this.zzahp));
                    zzbaVar.zzfw = Long.valueOf(zzdr.zza(this.zzahm - this.zzahk, intValue, this.zzahp));
                    zzbaVar.zzfz = Long.valueOf(zzdr.zza(this.zzahj, intValue, this.zzahp));
                    zzbaVar.zzga = Long.valueOf(zzdr.zza(this.zzahk, intValue, this.zzahp));
                }
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbns)).booleanValue() && this.zzaho && this.zzagx != null) {
                    long zza2 = zzdr.zza(((this.zzahj - this.zzahl) + this.zzagx.getRawX()) - this.zzagx.getX(), intValue, this.zzahp);
                    if (zza2 != 0) {
                        zzbaVar.zzfx = Long.valueOf(zza2);
                    }
                    long zza3 = zzdr.zza(((this.zzahk - this.zzahm) + this.zzagx.getRawY()) - this.zzagx.getY(), intValue, this.zzahp);
                    if (zza3 != 0) {
                        zzbaVar.zzfy = Long.valueOf(zza3);
                    }
                }
            }
            try {
                zzdq zzb2 = zzb(this.zzagx);
                zzbaVar.zzdn = zzb2.zzajl;
                zzbaVar.zzdo = zzb2.zzajm;
                zzbaVar.zzgb = zzb2.zzajs;
                zzbaVar.zzgc = zzb2.zzajt;
                zzbaVar.zzfp = zzb2.zzajn;
                if (this.zzaho) {
                    zzbaVar.zzfk = zzb2.zzfk;
                    zzbaVar.zzfm = zzb2.zzfm;
                    zzbaVar.zzfo = Integer.valueOf(zzb2.zzajo.longValue() != 0 ? 1 : 0);
                    if (this.zzaha > 0) {
                        if (zzdr.zza(this.zzahp)) {
                            double d = this.zzahf;
                            double d2 = this.zzaha;
                            Double.isNaN(d);
                            Double.isNaN(d2);
                            l = Long.valueOf(Math.round(d / d2));
                        } else {
                            l = null;
                        }
                        zzbaVar.zzfl = l;
                        double d3 = this.zzahe;
                        double d4 = this.zzaha;
                        Double.isNaN(d3);
                        Double.isNaN(d4);
                        zzbaVar.zzfn = Long.valueOf(Math.round(d3 / d4));
                    }
                    zzbaVar.zzfr = zzb2.zzfr;
                    zzbaVar.zzfq = zzb2.zzfq;
                    zzbaVar.zzfs = Integer.valueOf(zzb2.zzajr.longValue() != 0 ? 1 : 0);
                }
            } catch (zzdj e2) {
            }
            if (this.zzahd > 0) {
                zzbaVar.zzft = Long.valueOf(this.zzahd);
            }
            zzazVar.zzes = zzbaVar;
            if (this.zzagz > 0) {
                zzazVar.zzeg = Long.valueOf(this.zzagz);
            }
            if (this.zzaha > 0) {
                zzazVar.zzef = Long.valueOf(this.zzaha);
            }
            if (this.zzahb > 0) {
                zzazVar.zzee = Long.valueOf(this.zzahb);
            }
            if (this.zzahc > 0) {
                zzazVar.zzeh = Long.valueOf(this.zzahc);
            }
            try {
                int size = this.zzagy.size() - 1;
                if (size > 0) {
                    zzazVar.zzet = new zzba[size];
                    for (int i = 0; i < size; i++) {
                        zzdq zza4 = zza(zzagr, this.zzagy.get(i), this.zzahp);
                        zzba zzbaVar2 = new zzba();
                        zzbaVar2.zzdn = zza4.zzajl;
                        zzbaVar2.zzdo = zza4.zzajm;
                        zzazVar.zzet[i] = zzbaVar2;
                    }
                }
            } catch (zzdj e3) {
                zzazVar.zzet = null;
            }
            arrayList = new ArrayList();
            if (zzb.zzag() != null) {
                int zzac = zzb.zzac();
                arrayList.add(new zzee(zzb, zzazVar));
                arrayList.add(new zzeh(zzb, "4w5pMN4cUsuXvD3CJ7PKPSwMmWPClIaNSjeM6jtHahV40Q7EiLps1VIbOcEaCSp4", "5XuSFVTSxDkE27CIZHrBIXal5K53Dv1J/UFXKGBFAXY=", zzazVar, zzac, 1));
                arrayList.add(new zzec(zzb, "HYkEKMk8dvMdQrlbFR00sh73U7jSOxxrrxd0BhHmEXYlIfEqe1EzBQsw2kucbDs8", "puD1TaAJX/qcP/8PMgKROAswM+eaSDu4sTUEXpqs2fU=", zzazVar, startTime, zzac, 25));
                arrayList.add(new zzeb(zzb, "igTfSDGbP3Q2KSYfnqAL0vFW/zSSX6v+f+5s7NdwuKQgo6M7dQVerLATgNETrLAr", "Wz4eX479PrQ8rGu0gkJoEYqOJ2Dr8sAHE85KoBBz7s4=", zzazVar, zzac, 44));
                arrayList.add(new zzeg(zzb, "ZsnUMRH5gS7aUE0TqnSYS8JWwJCKCL7bH7XFSqbI4dWEEyg2o14AuyyBvtsnwc4D", "SFchXCfZXuuDAwXfTJDosXRUHrZZ0v26SJChYX3rL/o=", zzazVar, zzac, 12));
                arrayList.add(new zzei(zzb, "lMH30ZU/uP5xaOsdIj/K3/wZfVr7hnOzUHjpO1NWhTJQvW+gY38/OvCWA8Ap4ZOf", "FCjXGcebz7gnog9LMAWyd/isayIV3I84uK1cUtHZ2fI=", zzazVar, zzac, 3));
                arrayList.add(new zzef(zzb, "BiRNVQ0aQHyQJTXKNLbpSFJJy6+rG5ICwTiWxRhS6qdZjM6S9BBOaVfdO1b0Kd8E", "z9Ycw/7CJTzBzg6MPXNZ2oLMXcxWzT8qsF0ig0ITUxc=", zzazVar, zzac, 22));
                arrayList.add(new zzea(zzb, "2GI4cQuNT2V9TGPC/Z2McvgqRAU80qquJKbm0BMTxLR8WwMEgJwPEKdGCxKNxeUN", "1Kj5K8xXQ2YA9zbG2Rm9FzZtUD9R2drVmZXzLVF7uLA=", zzazVar, zzac, 5));
                arrayList.add(new zzep(zzb, "oWVj3eW9lsJMixyFq7g0kyuRqYP087mdDp4dCL3paE/7Ut3Ewp3IcEq6P10MPRyy", "siNRngHYHRLjixmg2PEX5OdKhRHe1h8DNRpJp4wC0pk=", zzazVar, zzac, 48));
                arrayList.add(new zzdx(zzb, "yATd8qneW4MlwQIx8jIN6cfiWJ28/zOw6vW7xs0IWvNvim2a85v5X4ZiVD1KK9hX", "0wjmexcQnona3bxO7Nd7FrKMEEoBhOp7s6KivBhMQKU=", zzazVar, zzac, 49));
                arrayList.add(new zzem(zzb, "2glehmg5UKxyaNPdnG06BLa5QbEzBADKVm3lYiT3+JTkguRZEzOA9BDahqC4W8ki", "wM87KVhGHShMaqkZWTxt04VnU6kJHrMxqQyksEW6glI=", zzazVar, zzac, 51));
                arrayList.add(new zzel(zzb, "hoZ4RlhPWT5MX/I+m/lUD5aYJ9aPmEb2eUGLaeSBLBDs9eDpXoNNJPm6j1dXVkvA", "Z7StFiuQ59x4y88apmlBJn3lPoWOEnuqoEhP2AVUL8A=", zzazVar, zzac, 45, new Throwable().getStackTrace()));
                arrayList.add(new zzeq(zzb, "peD/v7hHRn46N2uI0dQKpTtMr7rKDQ+Rzb4yluPWMw4TUUwj2SFV9GkdTp0kog66", "XxfDY0AzBkt4iSC5Sim2fww10jQc1evowDldz5+caY4=", zzazVar, zzac, 57, view));
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbnn)).booleanValue()) {
                    arrayList.add(new zzek(zzb, "cINMMi7uKicDN2DHSf1rHdgax7DU+CM2mIG3cRQw3SI0nkdhPwdVz1PCbewJpJoO", "VWQmr3p+wsDJ15H20t2tLb975qLEArv8gtHgpBQKEOE=", zzazVar, zzac, 61));
                }
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbno)).booleanValue()) {
                    arrayList.add(new zzdw(zzb, "6qQh+8GAMu6fM86JkRzoeHiiHD67+MgHO4xhhwcbyPT7CQmAN57q8YytJQRqDjU5", "Qrc1hPZgr+QjlmQtpbdJO1QCxqr2PdTRKIIDeDNdHp8=", zzazVar, zzac, 62, view, activity));
                }
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbnp)).booleanValue()) {
                    arrayList.add(new zzen(zzb, "HBbZPURZUWU/TDYIx99LmOTdgpFP2mdidp6Zk4sZdEVCGaQNYtmNlQBCP3rgXOne", "pdXBsPFh4N2rQp3r0gjTSQiWtas1GOGaKulNSciQTj0=", zzazVar, zzac, 53, this.zzahv));
                }
            }
        } else {
            zzazVar.zzdt = Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE);
            arrayList = Arrays.asList(new zzee(zzb, zzazVar));
        }
        zzb(arrayList);
        return zzazVar;
    }

    @Override // com.google.android.gms.internal.zzcs
    protected final zzaz zza(Context context, zzaw zzawVar) {
        zzaz zzazVar = new zzaz();
        if (!TextUtils.isEmpty(this.zzahs)) {
            zzazVar.zzcv = this.zzahs;
        }
        zzdm zzb = zzb(context, this.zzahr);
        if (zzb.zzag() != null) {
            zzb(zza(zzb, zzazVar, (zzaw) null));
        }
        return zzazVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Callable<Void>> zza(zzdm zzdmVar, zzaz zzazVar, zzaw zzawVar) {
        int zzac = zzdmVar.zzac();
        ArrayList arrayList = new ArrayList();
        if (!zzdmVar.isInitialized()) {
            zzazVar.zzdt = Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE);
            return arrayList;
        }
        arrayList.add(new zzdz(zzdmVar, "DGPkHpN6F5DQjFiQDfOpLUfwAMooIPhSFT4YA2aSEj+k+u5Kt4pQoimNrK0aCsHP", "V/2NrZQU5cdFMpqYa0Q9vKRizJ0aHS7vWXQS8vp0qlI=", zzazVar, zzac, 27, zzawVar));
        arrayList.add(new zzec(zzdmVar, "HYkEKMk8dvMdQrlbFR00sh73U7jSOxxrrxd0BhHmEXYlIfEqe1EzBQsw2kucbDs8", "puD1TaAJX/qcP/8PMgKROAswM+eaSDu4sTUEXpqs2fU=", zzazVar, startTime, zzac, 25));
        arrayList.add(new zzeh(zzdmVar, "4w5pMN4cUsuXvD3CJ7PKPSwMmWPClIaNSjeM6jtHahV40Q7EiLps1VIbOcEaCSp4", "5XuSFVTSxDkE27CIZHrBIXal5K53Dv1J/UFXKGBFAXY=", zzazVar, zzac, 1));
        arrayList.add(new zzej(zzdmVar, "notQcG55r2oh2A1cS/dLfKg9hawk3H86BF0iXzU7AAnhYpfHWl9mq3lZzdkAltxm", "U9ntf5BvZUTabci6TosC4bQNHZ+DOrzvRmpSy4CzkoQ=", zzazVar, zzac, 31));
        arrayList.add(new zzeo(zzdmVar, "8Hx2xRqW2QZDPiXj7EKgQgzecg5taNOrZe4YkZ9zi7FcQAOy1BO0rYbAdBI9x6Pm", "nJw4XP5tQfSQ6wm+0x6UMq5j2kNiUh+TXa92gyyhaOo=", zzazVar, zzac, 33));
        arrayList.add(new zzdy(zzdmVar, "yzGxsS8IwfgINPYaD3TFRjRVH+0Pq4QvVGq15MBf/opCBPnlCr4QHvEcReKXEMs7", "kMEgIGkHy2R1ROJUgud//6gDu/wM35rLhA6gUKrjKq0=", zzazVar, zzac, 29));
        arrayList.add(new zzea(zzdmVar, "2GI4cQuNT2V9TGPC/Z2McvgqRAU80qquJKbm0BMTxLR8WwMEgJwPEKdGCxKNxeUN", "1Kj5K8xXQ2YA9zbG2Rm9FzZtUD9R2drVmZXzLVF7uLA=", zzazVar, zzac, 5));
        arrayList.add(new zzeg(zzdmVar, "ZsnUMRH5gS7aUE0TqnSYS8JWwJCKCL7bH7XFSqbI4dWEEyg2o14AuyyBvtsnwc4D", "SFchXCfZXuuDAwXfTJDosXRUHrZZ0v26SJChYX3rL/o=", zzazVar, zzac, 12));
        arrayList.add(new zzei(zzdmVar, "lMH30ZU/uP5xaOsdIj/K3/wZfVr7hnOzUHjpO1NWhTJQvW+gY38/OvCWA8Ap4ZOf", "FCjXGcebz7gnog9LMAWyd/isayIV3I84uK1cUtHZ2fI=", zzazVar, zzac, 3));
        arrayList.add(new zzeb(zzdmVar, "igTfSDGbP3Q2KSYfnqAL0vFW/zSSX6v+f+5s7NdwuKQgo6M7dQVerLATgNETrLAr", "Wz4eX479PrQ8rGu0gkJoEYqOJ2Dr8sAHE85KoBBz7s4=", zzazVar, zzac, 44));
        arrayList.add(new zzef(zzdmVar, "BiRNVQ0aQHyQJTXKNLbpSFJJy6+rG5ICwTiWxRhS6qdZjM6S9BBOaVfdO1b0Kd8E", "z9Ycw/7CJTzBzg6MPXNZ2oLMXcxWzT8qsF0ig0ITUxc=", zzazVar, zzac, 22));
        arrayList.add(new zzep(zzdmVar, "oWVj3eW9lsJMixyFq7g0kyuRqYP087mdDp4dCL3paE/7Ut3Ewp3IcEq6P10MPRyy", "siNRngHYHRLjixmg2PEX5OdKhRHe1h8DNRpJp4wC0pk=", zzazVar, zzac, 48));
        arrayList.add(new zzdx(zzdmVar, "yATd8qneW4MlwQIx8jIN6cfiWJ28/zOw6vW7xs0IWvNvim2a85v5X4ZiVD1KK9hX", "0wjmexcQnona3bxO7Nd7FrKMEEoBhOp7s6KivBhMQKU=", zzazVar, zzac, 49));
        arrayList.add(new zzem(zzdmVar, "2glehmg5UKxyaNPdnG06BLa5QbEzBADKVm3lYiT3+JTkguRZEzOA9BDahqC4W8ki", "wM87KVhGHShMaqkZWTxt04VnU6kJHrMxqQyksEW6glI=", zzazVar, zzac, 51));
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbnn)).booleanValue()) {
            arrayList.add(new zzek(zzdmVar, "cINMMi7uKicDN2DHSf1rHdgax7DU+CM2mIG3cRQw3SI0nkdhPwdVz1PCbewJpJoO", "VWQmr3p+wsDJ15H20t2tLb975qLEArv8gtHgpBQKEOE=", zzazVar, zzac, 61));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.zzcs
    protected final zzdq zzb(MotionEvent motionEvent) throws zzdj {
        Method zza = zzagr.zza("I8ATAvvv3zdNeDvmT5gQ/ekfiNEF+bBdZZ3FGipPSiGHOLI4yQdK3XpX6xFRuejz", "SRWP8PeqaQflId3WUP9WJTho9Un3bF1tLB8c7UP1Ruo=");
        if (zza == null || motionEvent == null) {
            throw new zzdj();
        }
        try {
            return new zzdq((String) zza.invoke(null, motionEvent, this.zzahp, zzkb.zzif().zzd(zznh.zzbnq)));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new zzdj(e);
        }
    }

    @Override // com.google.android.gms.internal.zzcs, com.google.android.gms.internal.zzcr
    public final void zzb(View view) {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbnp)).booleanValue()) {
            zzdt zzdtVar = this.zzahv;
            if (zzdtVar == null) {
                this.zzahv = new zzdt(zzagr, view);
            } else {
                zzdtVar.zzd(view);
            }
        }
    }
}
