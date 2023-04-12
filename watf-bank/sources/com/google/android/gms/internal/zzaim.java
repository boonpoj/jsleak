package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzaim {
    private final Object mLock = new Object();
    private String zzdbq = "";
    private String zzdbr = "";
    private boolean zzdbs = false;
    private String zzdbt = "";

    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            zzahn.zzdaw.post(new zzain(this, context, str, z, z2));
        } else {
            zzagf.zzct("Can not create dialog without Activity Context");
        }
    }

    private final String zzaz(Context context) {
        String str;
        synchronized (this.mLock) {
            if (TextUtils.isEmpty(this.zzdbq)) {
                com.google.android.gms.ads.internal.zzbs.zzei();
                this.zzdbq = zzahn.zzq(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzdbq)) {
                    com.google.android.gms.ads.internal.zzbs.zzei();
                    this.zzdbq = zzahn.zzqb();
                    com.google.android.gms.ads.internal.zzbs.zzei();
                    zzahn.zzf(context, "debug_signals_id.txt", this.zzdbq);
                }
            }
            str = this.zzdbq;
        }
        return str;
    }

    private final Uri zzc(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzaz(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private final boolean zzh(Context context, String str, String str2) {
        String zzj = zzj(context, zzc(context, (String) zzkb.zzif().zzd(zznh.zzbqx), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzj)) {
            zzagf.zzbx("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzj.trim());
            String optString = jSONObject.optString("gct");
            this.zzdbt = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
            synchronized (this.mLock) {
                this.zzdbr = optString;
            }
            return true;
        } catch (JSONException e) {
            zzagf.zzc("Fail to get in app preview response json.", e);
            return false;
        }
    }

    private final boolean zzi(Context context, String str, String str2) {
        String zzj = zzj(context, zzc(context, (String) zzkb.zzif().zzd(zznh.zzbqy), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzj)) {
            zzagf.zzbx("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzj.trim()).optString("debug_mode"));
            synchronized (this.mLock) {
                this.zzdbs = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzagf.zzc("Fail to get debug mode response json.", e);
            return false;
        }
    }

    private static String zzj(Context context, String str, String str2) {
        String str3;
        String valueOf;
        String str4;
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzbs.zzei().zzp(context, str2));
        zzakv<String> zzb = new zzaiv(context).zzb(str, hashMap);
        try {
            return zzb.get(((Integer) zzkb.zzif().zzd(zznh.zzbra)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e = e;
            str3 = "Interrupted while retriving a response from: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() == 0) {
                str4 = new String("Interrupted while retriving a response from: ");
                zzagf.zzb(str4, e);
                zzb.cancel(true);
                return null;
            }
            str4 = str3.concat(valueOf);
            zzagf.zzb(str4, e);
            zzb.cancel(true);
            return null;
        } catch (TimeoutException e2) {
            e = e2;
            str3 = "Timeout while retriving a response from: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() == 0) {
                str4 = new String("Timeout while retriving a response from: ");
                zzagf.zzb(str4, e);
                zzb.cancel(true);
                return null;
            }
            str4 = str3.concat(valueOf);
            zzagf.zzb(str4, e);
            zzb.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf2 = String.valueOf(str);
            zzagf.zzb(valueOf2.length() != 0 ? "Error retriving a response from: ".concat(valueOf2) : new String("Error retriving a response from: "), e3);
            return null;
        }
    }

    private final void zzk(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzbs.zzei();
        zzahn.zza(context, zzc(context, (String) zzkb.zzif().zzd(zznh.zzbqw), str, str2));
    }

    public final void zza(Context context, String str, String str2, String str3) {
        boolean zzqq = zzqq();
        if (!zzi(context, str, str2)) {
            zzk(context, str, str2);
            return;
        }
        if (!zzqq && !TextUtils.isEmpty(str3)) {
            zzb(context, str2, str3, str);
        }
        zzagf.zzbx("Device is linked for debug signals.");
        zza(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    public final void zzb(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzc(context, (String) zzkb.zzif().zzd(zznh.zzbqz), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzbs.zzei();
        zzahn.zze(context, str, buildUpon.build().toString());
    }

    public final void zzg(Context context, String str, String str2) {
        if (!zzh(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (InternalAvidAdSessionContext.AVID_API_LEVEL.equals(this.zzdbt)) {
            zzagf.zzbx("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzdbt)) {
            zzagf.zzbx("The app is not linked for creative preview.");
            zzk(context, str, str2);
        } else if ("0".equals(this.zzdbt)) {
            zzagf.zzbx("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final String zzqp() {
        String str;
        synchronized (this.mLock) {
            str = this.zzdbr;
        }
        return str;
    }

    public final boolean zzqq() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdbs;
        }
        return z;
    }
}
