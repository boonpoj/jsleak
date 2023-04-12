package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzul implements zzup {
    private final Context mContext;
    private final zzux zzanw;
    private final zzpe zzapn;
    private final List<String> zzapo;
    private final zzakd zzapr;
    private zzjj zzarx;
    private final zzjn zzasd;
    private final boolean zzavp;
    private final String zzced;
    private final long zzcee;
    private final zzui zzcef;
    private final zzuh zzceg;
    private final List<String> zzceh;
    private final List<String> zzcei;
    private final boolean zzcej;
    private final boolean zzcek;
    private zzva zzcel;
    private zzvg zzcen;
    private final Object mLock = new Object();
    private int zzcem = -2;

    public zzul(Context context, String str, zzux zzuxVar, zzui zzuiVar, zzuh zzuhVar, zzjj zzjjVar, zzjn zzjnVar, zzakd zzakdVar, boolean z, boolean z2, zzpe zzpeVar, List<String> list, List<String> list2, List<String> list3, boolean z3) {
        String str2 = str;
        this.mContext = context;
        this.zzanw = zzuxVar;
        this.zzceg = zzuhVar;
        this.zzced = "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? zzlx() : str2;
        this.zzcef = zzuiVar;
        this.zzcee = zzuhVar.zzcdi != -1 ? zzuhVar.zzcdi : zzuiVar.zzcdi != -1 ? zzuiVar.zzcdi : 10000L;
        this.zzarx = zzjjVar;
        this.zzasd = zzjnVar;
        this.zzapr = zzakdVar;
        this.zzavp = z;
        this.zzcej = z2;
        this.zzapn = zzpeVar;
        this.zzapo = list;
        this.zzceh = list2;
        this.zzcei = list3;
        this.zzcek = z3;
    }

    private static zzva zza(MediationAdapter mediationAdapter) {
        return new zzvr(mediationAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzuk zzukVar) {
        String zzbe = zzbe(this.zzceg.zzccz);
        try {
            if (this.zzapr.zzdek < 4100000) {
                if (this.zzasd.zzbel) {
                    this.zzcel.zza(com.google.android.gms.dynamic.zzn.zzz(this.mContext), this.zzarx, zzbe, zzukVar);
                    return;
                } else {
                    this.zzcel.zza(com.google.android.gms.dynamic.zzn.zzz(this.mContext), this.zzasd, this.zzarx, zzbe, zzukVar);
                    return;
                }
            }
            if (!this.zzavp && !this.zzceg.zzlw()) {
                if (this.zzasd.zzbel) {
                    this.zzcel.zza(com.google.android.gms.dynamic.zzn.zzz(this.mContext), this.zzarx, zzbe, this.zzceg.zzccq, zzukVar);
                    return;
                } else if (!this.zzcej) {
                    this.zzcel.zza(com.google.android.gms.dynamic.zzn.zzz(this.mContext), this.zzasd, this.zzarx, zzbe, this.zzceg.zzccq, zzukVar);
                    return;
                } else if (this.zzceg.zzcdc != null) {
                    this.zzcel.zza(com.google.android.gms.dynamic.zzn.zzz(this.mContext), this.zzarx, zzbe, this.zzceg.zzccq, zzukVar, new zzpe(zzbf(this.zzceg.zzcdg)), this.zzceg.zzcdf);
                    return;
                } else {
                    this.zzcel.zza(com.google.android.gms.dynamic.zzn.zzz(this.mContext), this.zzasd, this.zzarx, zzbe, this.zzceg.zzccq, zzukVar);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList(this.zzapo);
            if (this.zzceh != null) {
                for (String str : this.zzceh) {
                    String str2 = ":false";
                    if (this.zzcei != null && this.zzcei.contains(str)) {
                        str2 = ":true";
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7 + String.valueOf(str2).length());
                    sb.append("custom:");
                    sb.append(str);
                    sb.append(str2);
                    arrayList.add(sb.toString());
                }
            }
            this.zzcel.zza(com.google.android.gms.dynamic.zzn.zzz(this.mContext), this.zzarx, zzbe, this.zzceg.zzccq, zzukVar, this.zzapn, arrayList);
        } catch (RemoteException e) {
            zzagf.zzc("Could not request ad from mediation adapter.", e);
            zzv(5);
        }
    }

    private final String zzbe(String str) {
        if (str != null && zzma() && !zzw(2)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.remove("cpm_floor_cents");
                return jSONObject.toString();
            } catch (JSONException e) {
                zzagf.zzcu("Could not remove field. Returning the original value");
            }
        }
        return str;
    }

    private static NativeAdOptions zzbf(String str) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (str == null) {
            return builder.build();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            builder.setRequestMultipleImages(jSONObject.optBoolean("multiple_images", false));
            builder.setReturnUrlsForImageAssets(jSONObject.optBoolean("only_urls", false));
            String optString = jSONObject.optString("native_image_orientation", "any");
            if ("landscape".equals(optString)) {
                i = 2;
            } else if ("portrait".equals(optString)) {
                i = 1;
            } else if (!"any".equals(optString)) {
                i = -1;
            }
            builder.setImageOrientation(i);
        } catch (JSONException e) {
            zzagf.zzc("Exception occurred when creating native ad options", e);
        }
        return builder.build();
    }

    private final String zzlx() {
        try {
            if (!TextUtils.isEmpty(this.zzceg.zzccu)) {
                return this.zzanw.zzbh(this.zzceg.zzccu) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            zzagf.zzcu("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private final zzvg zzly() {
        if (this.zzcem == 0 && zzma()) {
            try {
                if (zzw(4) && this.zzcen != null && this.zzcen.zzmc() != 0) {
                    return this.zzcen;
                }
            } catch (RemoteException e) {
                zzagf.zzcu("Could not get cpm value from MediationResponseMetadata");
            }
            return new zzun(zzmb());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzva zzlz() {
        String valueOf = String.valueOf(this.zzced);
        zzagf.zzct(valueOf.length() != 0 ? "Instantiating mediation adapter: ".concat(valueOf) : new String("Instantiating mediation adapter: "));
        if (!this.zzavp && !this.zzceg.zzlw()) {
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbne)).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzced)) {
                return zza(new AdMobAdapter());
            }
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbnf)).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.zzced)) {
                return zza(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.zzced)) {
                return new zzvr(new zzwl());
            }
        }
        try {
            return this.zzanw.zzbg(this.zzced);
        } catch (RemoteException e) {
            String valueOf2 = String.valueOf(this.zzced);
            zzagf.zza(valueOf2.length() != 0 ? "Could not instantiate mediation adapter: ".concat(valueOf2) : new String("Could not instantiate mediation adapter: "), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzma() {
        return this.zzcef.zzcdt != -1;
    }

    private final int zzmb() {
        if (this.zzceg.zzccz == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.zzceg.zzccz);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzced)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = zzw(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            zzagf.zzcu("Could not convert to json. Returning 0");
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzw(int i) {
        try {
            Bundle zzmh = this.zzavp ? this.zzcel.zzmh() : this.zzasd.zzbel ? this.zzcel.getInterstitialAdapterInfo() : this.zzcel.zzmg();
            return zzmh != null && (zzmh.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            zzagf.zzcu("Could not get adapter info. Returning false");
            return false;
        }
    }

    public final void cancel() {
        synchronized (this.mLock) {
            try {
                if (this.zzcel != null) {
                    this.zzcel.destroy();
                }
            } catch (RemoteException e) {
                zzagf.zzc("Could not destroy mediation adapter.", e);
            }
            this.zzcem = -1;
            this.mLock.notify();
        }
    }

    public final zzuo zza(long j, long j2) {
        zzuo zzuoVar;
        synchronized (this.mLock) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzuk zzukVar = new zzuk();
            zzahn.zzdaw.post(new zzum(this, zzukVar));
            long j3 = this.zzcee;
            while (this.zzcem == -2) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                long j4 = j3 - (elapsedRealtime2 - elapsedRealtime);
                long j5 = j2 - (elapsedRealtime2 - j);
                if (j4 <= 0 || j5 <= 0) {
                    zzagf.zzct("Timed out waiting for adapter.");
                    this.zzcem = 3;
                } else {
                    try {
                        this.mLock.wait(Math.min(j4, j5));
                    } catch (InterruptedException e) {
                        this.zzcem = 5;
                    }
                }
            }
            zzuoVar = new zzuo(this.zzceg, this.zzcel, this.zzced, zzukVar, this.zzcem, zzly(), com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime() - elapsedRealtime);
        }
        return zzuoVar;
    }

    @Override // com.google.android.gms.internal.zzup
    public final void zza(int i, zzvg zzvgVar) {
        synchronized (this.mLock) {
            this.zzcem = 0;
            this.zzcen = zzvgVar;
            this.mLock.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzup
    public final void zzv(int i) {
        synchronized (this.mLock) {
            this.zzcem = i;
            this.mLock.notify();
        }
    }
}
