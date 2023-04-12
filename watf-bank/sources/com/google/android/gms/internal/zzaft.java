package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzaft implements zzahg, zzhj {
    private Context mContext;
    private zzfs zzanq;
    private zzakd zzapr;
    private String zzcyy;
    private String zzcyz;
    private String zzczb;
    private final Object mLock = new Object();
    private BigInteger zzcyr = BigInteger.ONE;
    private final HashSet<zzafq> zzcys = new HashSet<>();
    private final HashMap<String, zzafz> zzcyt = new HashMap<>();
    private boolean zzcyu = false;
    private boolean zzcsn = true;
    private int zzcyv = 0;
    private boolean zzare = false;
    private zznk zzcyw = null;
    private boolean zzcso = true;
    private boolean zzcsp = true;
    private zzhk zzcyx = null;
    private zzhf zzazc = null;
    private Boolean zzcza = null;
    private boolean zzczc = false;
    private boolean zzczd = false;
    private boolean zzcsw = false;
    private String zzcze = "";
    private long zzczf = 0;
    private long zzczg = 0;
    private long zzczh = 0;
    private int zzczi = -1;
    private JSONObject zzczj = new JSONObject();
    private int zzczk = 0;
    private final AtomicInteger zzczl = new AtomicInteger(0);
    private final zzafv zzczm = new zzafv();
    private final zzafx zzcyq = new zzafx(zzkb.zzic());

    public zzaft(zzahn zzahnVar) {
    }

    private final Future zzad(int i) {
        Future zzb;
        synchronized (this.mLock) {
            this.zzczi = i;
            zzb = zzagh.zzb(this.mContext, i);
        }
        return zzb;
    }

    private final Future zzj(long j) {
        Future zza;
        synchronized (this.mLock) {
            this.zzczg = j;
            zza = zzagh.zza(this.mContext, j);
        }
        return zza;
    }

    public final Resources getResources() {
        if (this.zzapr.zzdel) {
            return this.mContext.getResources();
        }
        try {
            DynamiteModule zza = DynamiteModule.zza(this.mContext, DynamiteModule.zzgww, ModuleDescriptor.MODULE_ID);
            if (zza != null) {
                return zza.zzaqb().getResources();
            }
            return null;
        } catch (DynamiteModule.zzc e) {
            zzagf.zzc("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final Bundle zza(Context context, zzafy zzafyVar, String str) {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putBundle("app", this.zzcyq.zzl(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.zzcyt.keySet()) {
                bundle2.putBundle(str2, this.zzcyt.get(str2).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzafq> it = this.zzcys.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzafyVar.zza(this.zzcys);
            this.zzcys.clear();
        }
        return bundle;
    }

    public final void zza(zzafq zzafqVar) {
        synchronized (this.mLock) {
            this.zzcys.add(zzafqVar);
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.mLock) {
            this.zzcza = bool;
        }
    }

    public final void zza(String str, zzafz zzafzVar) {
        synchronized (this.mLock) {
            this.zzcyt.put(str, zzafzVar);
        }
    }

    public final void zza(Throwable th, String str) {
        zzzp.zzj(this.mContext).zza(th, str);
    }

    public final zzhk zzac(Context context) {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbjo)).booleanValue()) {
            if (!((Boolean) zzkb.zzif().zzd(zznh.zzbjw)).booleanValue()) {
                if (!((Boolean) zzkb.zzif().zzd(zznh.zzbju)).booleanValue()) {
                    return null;
                }
            }
            if (zzoy() && zzoz()) {
                return null;
            }
            synchronized (this.mLock) {
                if (Looper.getMainLooper() != null && context != null) {
                    if (this.zzazc == null) {
                        this.zzazc = new zzhf();
                    }
                    if (this.zzcyx == null) {
                        this.zzcyx = new zzhk(this.zzazc, zzzp.zzj(this.mContext));
                    }
                    this.zzcyx.zzgt();
                    return this.zzcyx;
                }
                return null;
            }
        }
        return null;
    }

    public final Future zzac(int i) {
        Future zza;
        synchronized (this.mLock) {
            this.zzczk = i;
            zza = zzagh.zza(this.mContext, i);
        }
        return zza;
    }

    public final Future zzb(Context context, String str, String str2, boolean z) {
        synchronized (this.mLock) {
            JSONArray optJSONArray = this.zzczj.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null && str2.equals(optJSONObject.optString("template_id"))) {
                    if (z && optJSONObject.optBoolean("uses_media_view", false) == z) {
                        return null;
                    } else {
                        length = i;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzczj.put(str, optJSONArray);
            } catch (JSONException e) {
                zzagf.zzc("Could not update native advanced settings", e);
            }
            return zzagh.zzo(this.mContext, this.zzczj.toString());
        }
    }

    @Override // com.google.android.gms.internal.zzahg
    public final void zzb(Bundle bundle) {
        synchronized (this.mLock) {
            this.zzcsn = bundle.getBoolean("use_https", this.zzcsn);
            this.zzcyv = bundle.getInt("webview_cache_version", this.zzcyv);
            if (bundle.containsKey("content_url_opted_out")) {
                zzx(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.zzcyy = bundle.getString("content_url_hashes");
            }
            this.zzcsw = bundle.getBoolean("auto_collect_location", this.zzcsw);
            if (bundle.containsKey("content_vertical_opted_out")) {
                zzy(bundle.getBoolean("content_vertical_opted_out"));
            }
            if (bundle.containsKey("content_vertical_hashes")) {
                this.zzcyz = bundle.getString("content_vertical_hashes");
            }
            if (bundle.containsKey("native_advanced_settings")) {
                try {
                    this.zzczj = new JSONObject(bundle.getString("native_advanced_settings"));
                } catch (JSONException e) {
                    zzagf.zzc("Could not convert native advanced settings to json object", e);
                }
            }
            if (bundle.containsKey("version_code")) {
                this.zzczk = bundle.getInt("version_code");
            }
            this.zzcze = bundle.containsKey("app_settings_json") ? bundle.getString("app_settings_json") : this.zzcze;
            this.zzczf = bundle.getLong("app_settings_last_update_ms", this.zzczf);
            this.zzczg = bundle.getLong("app_last_background_time_ms", this.zzczg);
            this.zzczi = bundle.getInt("request_in_session_count", this.zzczi);
            this.zzczh = bundle.getLong("first_ad_req_time_ms", this.zzczh);
        }
    }

    public final void zzb(HashSet<zzafq> hashSet) {
        synchronized (this.mLock) {
            this.zzcys.addAll(hashSet);
        }
    }

    public final void zzc(Context context, zzakd zzakdVar) {
        synchronized (this.mLock) {
            if (!this.zzare) {
                this.mContext = context.getApplicationContext();
                this.zzapr = zzakdVar;
                com.google.android.gms.ads.internal.zzbs.zzel().zza(this);
                zzagh.zza(context, this);
                zzagh.zzb(context, this);
                zzagh.zzh(context, this);
                zzagh.zzf(context, this);
                zzagh.zzc(context, this);
                zzagh.zzd(context, this);
                zzagh.zze(context, this);
                zzagh.zzg(context, this);
                zzagh.zzi(context, this);
                zzagh.zzj(context, this);
                zzagh.zzk(context, this);
                zzzp.zzj(this.mContext);
                this.zzczb = com.google.android.gms.ads.internal.zzbs.zzei().zzp(context, zzakdVar.zzcv);
                if (Build.VERSION.SDK_INT >= 23 && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.zzczd = true;
                }
                this.zzanq = new zzfs(context.getApplicationContext(), this.zzapr);
                zznj zznjVar = new zznj(this.mContext, this.zzapr.zzcv);
                try {
                    com.google.android.gms.ads.internal.zzbs.zzeq();
                    this.zzcyw = zznm.zza(zznjVar);
                } catch (IllegalArgumentException e) {
                    zzagf.zzc("Cannot initialize CSI reporter.", e);
                }
                this.zzare = true;
            }
        }
    }

    public final Future zzca(String str) {
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzcyy)) {
                    this.zzcyy = str;
                    return zzagh.zzm(this.mContext, str);
                }
            }
            return null;
        }
    }

    public final Future zzcb(String str) {
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzcyz)) {
                    this.zzcyz = str;
                    return zzagh.zzn(this.mContext, str);
                }
            }
            return null;
        }
    }

    public final Future zzf(Context context, boolean z) {
        synchronized (this.mLock) {
            if (z != this.zzcsn) {
                this.zzcsn = z;
                return zzagh.zzf(context, z);
            }
            return null;
        }
    }

    public final Future zzg(Context context, boolean z) {
        synchronized (this.mLock) {
            if (z != this.zzcsw) {
                this.zzcsw = z;
                return zzagh.zzi(context, z);
            }
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzhj
    public final void zzg(boolean z) {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis();
        if (!z) {
            zzj(currentTimeMillis);
            zzad(this.zzcyq.zzczi);
            return;
        }
        if (currentTimeMillis - this.zzczg > ((Long) zzkb.zzif().zzd(zznh.zzblg)).longValue()) {
            this.zzcyq.zzczi = -1;
            return;
        }
        this.zzcyq.zzczi = this.zzczi;
    }

    public final zzakv zzk(Context context, String str) {
        this.zzczf = com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis();
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzcze)) {
                    this.zzcze = str;
                    return zzagh.zza(context, str, this.zzczf);
                }
            }
            return zzakl.zzi(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future zzk(long j) {
        Future zzb;
        synchronized (this.mLock) {
            this.zzczh = j;
            zzb = zzagh.zzb(this.mContext, j);
        }
        return zzb;
    }

    public final boolean zzoy() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcso;
        }
        return z;
    }

    public final boolean zzoz() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcsp;
        }
        return z;
    }

    public final String zzpa() {
        String bigInteger;
        synchronized (this.mLock) {
            bigInteger = this.zzcyr.toString();
            this.zzcyr = this.zzcyr.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public final zzafx zzpb() {
        zzafx zzafxVar;
        synchronized (this.mLock) {
            zzafxVar = this.zzcyq;
        }
        return zzafxVar;
    }

    public final zznk zzpc() {
        zznk zznkVar;
        synchronized (this.mLock) {
            zznkVar = this.zzcyw;
        }
        return zznkVar;
    }

    public final boolean zzpd() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcsn || this.zzczd;
        }
        return z;
    }

    public final String zzpe() {
        String str;
        synchronized (this.mLock) {
            str = this.zzcyy;
        }
        return str;
    }

    public final String zzpf() {
        String str;
        synchronized (this.mLock) {
            str = this.zzcyz;
        }
        return str;
    }

    public final Boolean zzpg() {
        Boolean bool;
        synchronized (this.mLock) {
            bool = this.zzcza;
        }
        return bool;
    }

    public final boolean zzph() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcsw;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzpi() {
        long j;
        synchronized (this.mLock) {
            j = this.zzczg;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzpj() {
        long j;
        synchronized (this.mLock) {
            j = this.zzczh;
        }
        return j;
    }

    public final int zzpk() {
        int i;
        synchronized (this.mLock) {
            i = this.zzczk;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzpl() {
        int i;
        synchronized (this.mLock) {
            i = this.zzczi;
        }
        return i;
    }

    public final boolean zzpm() {
        return this.zzczm.zzpm();
    }

    public final boolean zzpn() {
        return this.zzczm.zzpn();
    }

    public final void zzpo() {
        this.zzczm.zzpo();
    }

    public final zzafs zzpp() {
        zzafs zzafsVar;
        synchronized (this.mLock) {
            zzafsVar = new zzafs(this.zzcze, this.zzczf);
        }
        return zzafsVar;
    }

    public final JSONObject zzpq() {
        JSONObject jSONObject;
        synchronized (this.mLock) {
            jSONObject = this.zzczj;
        }
        return jSONObject;
    }

    public final Future zzpr() {
        Future zzaf;
        synchronized (this.mLock) {
            zzaf = zzagh.zzaf(this.mContext);
        }
        return zzaf;
    }

    public final zzfs zzps() {
        return this.zzanq;
    }

    public final void zzpt() {
        this.zzczl.incrementAndGet();
    }

    public final void zzpu() {
        this.zzczl.decrementAndGet();
    }

    public final int zzpv() {
        return this.zzczl.get();
    }

    public final void zzx(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcso != z) {
                zzagh.zzh(this.mContext, z);
            }
            this.zzcso = z;
            zzhk zzac = zzac(this.mContext);
            if (zzac != null && !zzac.isAlive()) {
                zzagf.zzct("start fetching content...");
                zzac.zzgt();
            }
        }
    }

    public final void zzy(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcsp != z) {
                zzagh.zzh(this.mContext, z);
            }
            zzagh.zzh(this.mContext, z);
            this.zzcsp = z;
            zzhk zzac = zzac(this.mContext);
            if (zzac != null && !zzac.isAlive()) {
                zzagf.zzct("start fetching content...");
                zzac.zzgt();
            }
        }
    }

    public final void zzz(boolean z) {
        this.zzczm.zzz(z);
    }
}
