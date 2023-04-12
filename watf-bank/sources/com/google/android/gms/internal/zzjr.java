package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;
@zzzv
/* loaded from: classes.dex */
public class zzjr {
    private final Object mLock = new Object();
    private zzla zzber;
    private final zzji zzbes;
    private final zzjh zzbet;
    private final zzmb zzbeu;
    private final zzri zzbev;
    private final zzadt zzbew;
    private final zzxd zzbex;
    private final zzrj zzbey;

    /* loaded from: classes.dex */
    public abstract class zza<T> {
        public zza() {
            zzjr.this = r1;
        }

        protected abstract T zza(zzla zzlaVar) throws RemoteException;

        protected abstract T zzhw() throws RemoteException;

        protected final T zzhx() {
            zzla zzhv = zzjr.this.zzhv();
            if (zzhv == null) {
                zzakb.zzcu("ClientApi class cannot be loaded.");
                return null;
            }
            try {
                return zza(zzhv);
            } catch (RemoteException e) {
                zzakb.zzc("Cannot invoke local loader using ClientApi class", e);
                return null;
            }
        }

        protected final T zzhy() {
            try {
                return zzhw();
            } catch (RemoteException e) {
                zzakb.zzc("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    public zzjr(zzji zzjiVar, zzjh zzjhVar, zzmb zzmbVar, zzri zzriVar, zzadt zzadtVar, zzxd zzxdVar, zzrj zzrjVar) {
        this.zzbes = zzjiVar;
        this.zzbet = zzjhVar;
        this.zzbeu = zzmbVar;
        this.zzbev = zzriVar;
        this.zzbew = zzadtVar;
        this.zzbex = zzxdVar;
        this.zzbey = zzrjVar;
    }

    public static <T> T zza(Context context, boolean z, zza<T> zzaVar) {
        if (!z) {
            zzkb.zzia();
            if (!zzajr.zzbe(context)) {
                zzakb.zzbx("Google Play Services is not available");
                z = true;
            }
        }
        zzkb.zzia();
        int zzaw = zzajr.zzaw(context);
        zzkb.zzia();
        if (zzaw > zzajr.zzav(context)) {
            z = true;
        }
        if (z) {
            T zzhx = zzaVar.zzhx();
            return zzhx == null ? zzaVar.zzhy() : zzhx;
        }
        T zzhy = zzaVar.zzhy();
        return zzhy == null ? zzaVar.zzhx() : zzhy;
    }

    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzkb.zzia().zza(context, (String) null, "gmob-apps", bundle, true);
    }

    public static /* synthetic */ void zza(zzjr zzjrVar, Context context, String str) {
        zza(context, str);
    }

    public static /* synthetic */ zzji zzb(zzjr zzjrVar) {
        return zzjrVar.zzbes;
    }

    public static /* synthetic */ zzjh zzc(zzjr zzjrVar) {
        return zzjrVar.zzbet;
    }

    private static zzla zzhu() {
        try {
            Object newInstance = zzjr.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return zzlb.asInterface((IBinder) newInstance);
            }
            zzakb.zzcu("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Exception e) {
            zzakb.zzc("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    public final zzla zzhv() {
        zzla zzlaVar;
        synchronized (this.mLock) {
            if (this.zzber == null) {
                this.zzber = zzhu();
            }
            zzlaVar = this.zzber;
        }
        return zzlaVar;
    }

    public final zzpu zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzpu) zza(context, false, (zza<Object>) new zzjx(this, frameLayout, frameLayout2, context));
    }

    public final zzpz zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzpz) zza(view.getContext(), false, (zza<Object>) new zzjy(this, view, hashMap, hashMap2));
    }

    public final zzkn zzb(Context context, String str, zzux zzuxVar) {
        return (zzkn) zza(context, false, (zza<Object>) new zzjv(this, context, str, zzuxVar));
    }

    public final zzxe zzb(Activity activity) {
        Intent intent = activity.getIntent();
        boolean z = false;
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            zzakb.e("useClientJar flag not found in activity intent extras.");
        }
        return (zzxe) zza(activity, z, new zzka(this, activity));
    }
}
