package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzaes implements zzafb {
    private final Context mContext;
    private final zzaey zzctb;
    private final zzfjw zzcwe;
    private final LinkedHashMap<String, zzfke> zzcwf;
    private final zzafd zzcwg;
    boolean zzcwh;
    private final Object mLock = new Object();
    private HashSet<String> zzcwi = new HashSet<>();
    private boolean zzcwj = false;
    private boolean zzcwk = false;
    private boolean zzcwl = false;

    public zzaes(Context context, zzakd zzakdVar, zzaey zzaeyVar, String str, zzafd zzafdVar) {
        com.google.android.gms.common.internal.zzbq.checkNotNull(zzaeyVar, "SafeBrowsing config is not present.");
        this.mContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzcwf = new LinkedHashMap<>();
        this.zzcwg = zzafdVar;
        this.zzctb = zzaeyVar;
        for (String str2 : this.zzctb.zzcwt) {
            this.zzcwi.add(str2.toLowerCase(Locale.ENGLISH));
        }
        this.zzcwi.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzfjw zzfjwVar = new zzfjw();
        zzfjwVar.zzpnw = 8;
        zzfjwVar.url = str;
        zzfjwVar.zzpny = str;
        zzfjwVar.zzpoa = new zzfjx();
        zzfjwVar.zzpoa.zzcwp = this.zzctb.zzcwp;
        zzfkf zzfkfVar = new zzfkf();
        zzfkfVar.zzpph = zzakdVar.zzcv;
        zzfkfVar.zzppj = Boolean.valueOf(zzbhf.zzdb(this.mContext).zzamu());
        com.google.android.gms.common.zzf.zzafy();
        long zzcf = com.google.android.gms.common.zzf.zzcf(this.mContext);
        if (zzcf > 0) {
            zzfkfVar.zzppi = Long.valueOf(zzcf);
        }
        zzfjwVar.zzpok = zzfkfVar;
        this.zzcwe = zzfjwVar;
    }

    private final zzfke zzbw(String str) {
        zzfke zzfkeVar;
        synchronized (this.mLock) {
            zzfkeVar = this.zzcwf.get(str);
        }
        return zzfkeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void send() {
        zzfke[] zzfkeVarArr;
        if ((this.zzcwh && this.zzctb.zzcwv) || (this.zzcwl && this.zzctb.zzcwu) || (!this.zzcwh && this.zzctb.zzcws)) {
            synchronized (this.mLock) {
                this.zzcwe.zzpob = new zzfke[this.zzcwf.size()];
                this.zzcwf.values().toArray(this.zzcwe.zzpob);
                if (zzafa.isEnabled()) {
                    String str = this.zzcwe.url;
                    String str2 = this.zzcwe.zzpoc;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length());
                    sb.append("Sending SB report\n  url: ");
                    sb.append(str);
                    sb.append("\n  clickUrl: ");
                    sb.append(str2);
                    sb.append("\n  resources: \n");
                    StringBuilder sb2 = new StringBuilder(sb.toString());
                    for (zzfke zzfkeVar : this.zzcwe.zzpob) {
                        sb2.append("    [");
                        sb2.append(zzfkeVar.zzppg.length);
                        sb2.append("] ");
                        sb2.append(zzfkeVar.url);
                    }
                    zzafa.zzbx(sb2.toString());
                }
                zzakv<String> zza = new zzaiv(this.mContext).zza(1, this.zzctb.zzcwq, null, zzfjs.zzc(this.zzcwe));
                if (zzafa.isEnabled()) {
                    zza.zza(new zzaev(this), zzahh.zzdar);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzafb
    public final void zza(String str, Map<String, String> map, int i) {
        synchronized (this.mLock) {
            if (i == 3) {
                this.zzcwl = true;
            }
            if (this.zzcwf.containsKey(str)) {
                if (i == 3) {
                    this.zzcwf.get(str).zzppf = Integer.valueOf(i);
                }
                return;
            }
            zzfke zzfkeVar = new zzfke();
            zzfkeVar.zzppf = Integer.valueOf(i);
            zzfkeVar.zzjjw = Integer.valueOf(this.zzcwf.size());
            zzfkeVar.url = str;
            zzfkeVar.zzppa = new zzfjz();
            if (this.zzcwi.size() > 0 && map != null) {
                LinkedList linkedList = new LinkedList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        String key = entry.getKey() != null ? entry.getKey() : "";
                        String value = entry.getValue() != null ? entry.getValue() : "";
                        if (this.zzcwi.contains(key.toLowerCase(Locale.ENGLISH))) {
                            zzfjy zzfjyVar = new zzfjy();
                            zzfjyVar.zzpom = key.getBytes("UTF-8");
                            zzfjyVar.zzohg = value.getBytes("UTF-8");
                            linkedList.add(zzfjyVar);
                        }
                    } catch (UnsupportedEncodingException e) {
                        zzafa.zzbx("Cannot convert string to bytes, skip header.");
                    }
                }
                zzfjy[] zzfjyVarArr = new zzfjy[linkedList.size()];
                linkedList.toArray(zzfjyVarArr);
                zzfkeVar.zzppa.zzpoo = zzfjyVarArr;
            }
            this.zzcwf.put(str, zzfkeVar);
        }
    }

    @Override // com.google.android.gms.internal.zzafb
    public final void zzbv(String str) {
        synchronized (this.mLock) {
            this.zzcwe.zzpoc = str;
        }
    }

    @Override // com.google.android.gms.internal.zzafb
    public final zzaey zzok() {
        return this.zzctb;
    }

    @Override // com.google.android.gms.internal.zzafb
    public final boolean zzol() {
        return com.google.android.gms.common.util.zzq.zzaml() && this.zzctb.zzcwr && !this.zzcwk;
    }

    @Override // com.google.android.gms.internal.zzafb
    public final void zzom() {
        this.zzcwj = true;
    }

    @Override // com.google.android.gms.internal.zzafb
    public final void zzon() {
        synchronized (this.mLock) {
            zzakv<Map<String, String>> zza = this.zzcwg.zza(this.mContext, this.zzcwf.keySet());
            zza.zza(new zzaeu(this, zza), zzahh.zzdar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzp(Map<String, String> map) throws JSONException {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            JSONArray optJSONArray = new JSONObject(map.get(str)).optJSONArray("matches");
            if (optJSONArray != null) {
                synchronized (this.mLock) {
                    int length = optJSONArray.length();
                    zzfke zzbw = zzbw(str);
                    if (zzbw == null) {
                        String valueOf = String.valueOf(str);
                        zzafa.zzbx(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                    } else {
                        zzbw.zzppg = new String[length];
                        for (int i = 0; i < length; i++) {
                            zzbw.zzppg[i] = optJSONArray.getJSONObject(i).getString("threat_type");
                        }
                        this.zzcwh = (length > 0) | this.zzcwh;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzafb
    public final void zzq(View view) {
        if (this.zzctb.zzcwr && !this.zzcwk) {
            com.google.android.gms.ads.internal.zzbs.zzei();
            Bitmap zzs = zzahn.zzs(view);
            if (zzs == null) {
                zzafa.zzbx("Failed to capture the webview bitmap.");
                return;
            }
            this.zzcwk = true;
            zzahn.zzb(new zzaet(this, zzs));
        }
    }
}
