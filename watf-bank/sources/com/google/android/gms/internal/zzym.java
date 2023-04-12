package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzym implements Callable<zzafo> {
    private static long zzckf = 10;
    private final Context mContext;
    private final zznu zzanj;
    private final zzzb zzarn;
    private final zzcv zzbuv;
    private final zzafp zzcjk;
    private final zzaiv zzckg;
    private final com.google.android.gms.ads.internal.zzba zzckh;
    private JSONObject zzckk;
    private final Object mLock = new Object();
    private boolean zzcki = false;
    private int mErrorCode = -2;
    private List<String> zzckj = null;
    private String zzckl = null;

    public zzym(Context context, com.google.android.gms.ads.internal.zzba zzbaVar, zzaiv zzaivVar, zzcv zzcvVar, zzafp zzafpVar, zznu zznuVar) {
        this.mContext = context;
        this.zzckh = zzbaVar;
        this.zzckg = zzaivVar;
        this.zzcjk = zzafpVar;
        this.zzbuv = zzcvVar;
        this.zzanj = zznuVar;
        this.zzarn = zzbaVar.zzdq();
    }

    private final zzafo zza(zzou zzouVar) {
        int i;
        synchronized (this.mLock) {
            i = (zzouVar == null && this.mErrorCode == -2) ? 0 : this.mErrorCode;
        }
        return new zzafo(this.zzcjk.zzcqv.zzcnd, null, this.zzcjk.zzcxy.zzcdk, i, this.zzcjk.zzcxy.zzcdl, this.zzckj, this.zzcjk.zzcxy.orientation, this.zzcjk.zzcxy.zzcdq, this.zzcjk.zzcqv.zzcng, false, null, null, null, null, null, 0L, this.zzcjk.zzauc, this.zzcjk.zzcxy.zzcov, this.zzcjk.zzcxp, this.zzcjk.zzcxq, this.zzcjk.zzcxy.zzcpb, this.zzckk, i != -2 ? null : zzouVar, null, null, null, this.zzcjk.zzcxy.zzcpo, this.zzcjk.zzcxy.zzcpp, null, this.zzcjk.zzcxy.zzcdn, this.zzckl, this.zzcjk.zzcxw, this.zzcjk.zzcxy.zzaqv, this.zzcjk.zzcxx);
    }

    private final zzakv<zzoi> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? zzakl.zzi(new zzoi(null, Uri.parse(string), optDouble)) : this.zzckg.zza(string, new zzyq(this, z, optDouble, optBoolean, string));
        }
        zzd(0, z);
        return zzakl.zzi(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzanh zzb(zzakv<zzanh> zzakvVar) {
        try {
            return zzakvVar.get(((Integer) zzkb.zzif().zzd(zznh.zzbot)).intValue(), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            zzagf.zzc("InterruptedException occurred while waiting for video to load", e);
            Thread.currentThread().interrupt();
            return null;
        } catch (CancellationException e2) {
            e = e2;
            zzagf.zzc("Exception occurred while waiting for video to load", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            zzagf.zzc("Exception occurred while waiting for video to load", e);
            return null;
        } catch (TimeoutException e4) {
            e = e4;
            zzagf.zzc("Exception occurred while waiting for video to load", e);
            return null;
        }
    }

    private static Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzqm zzqmVar, String str) {
        try {
            zzqw zzs = this.zzckh.zzs(zzqmVar.getCustomTemplateId());
            if (zzs != null) {
                zzs.zzb(zzqmVar, str);
            }
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzagf.zzc(sb.toString(), e);
        }
    }

    private static String[] zzd(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private static <V> zzakv<List<V>> zzl(List<zzakv<V>> list) {
        zzalf zzalfVar = new zzalf();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzakv<V> zzakvVar : list) {
            zzakvVar.zza(new zzyr(atomicInteger, size, zzalfVar, list), zzahh.zzdar);
        }
        return zzalfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V> List<V> zzm(List<zzakv<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (zzakv<V> zzakvVar : list) {
            V v = zzakvVar.get();
            if (v != null) {
                arrayList.add(v);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
        if (r4.length() != 0) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091 A[Catch: Exception -> 0x018c, TimeoutException -> 0x0190, JSONException -> 0x0194, InterruptedException -> 0x019b, ExecutionException -> 0x019d, CancellationException -> 0x019f, TryCatch #2 {InterruptedException -> 0x019b, CancellationException -> 0x019f, ExecutionException -> 0x019d, TimeoutException -> 0x0190, JSONException -> 0x0194, Exception -> 0x018c, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x0038, B:10:0x003e, B:13:0x0046, B:16:0x0050, B:18:0x0068, B:20:0x0079, B:24:0x0083, B:26:0x0091, B:28:0x009b, B:30:0x00a3, B:32:0x00ad, B:34:0x00b5, B:50:0x011e, B:55:0x0129, B:59:0x013d, B:61:0x016d, B:63:0x0171, B:64:0x0187, B:58:0x0139, B:35:0x00bf, B:37:0x00c7, B:38:0x00d1, B:40:0x00d9, B:42:0x00f6, B:43:0x00fc, B:45:0x010c, B:47:0x0116, B:46:0x0111, B:48:0x011a, B:15:0x004c), top: B:83:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3 A[Catch: Exception -> 0x018c, TimeoutException -> 0x0190, JSONException -> 0x0194, InterruptedException -> 0x019b, ExecutionException -> 0x019d, CancellationException -> 0x019f, TryCatch #2 {InterruptedException -> 0x019b, CancellationException -> 0x019f, ExecutionException -> 0x019d, TimeoutException -> 0x0190, JSONException -> 0x0194, Exception -> 0x018c, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x0038, B:10:0x003e, B:13:0x0046, B:16:0x0050, B:18:0x0068, B:20:0x0079, B:24:0x0083, B:26:0x0091, B:28:0x009b, B:30:0x00a3, B:32:0x00ad, B:34:0x00b5, B:50:0x011e, B:55:0x0129, B:59:0x013d, B:61:0x016d, B:63:0x0171, B:64:0x0187, B:58:0x0139, B:35:0x00bf, B:37:0x00c7, B:38:0x00d1, B:40:0x00d9, B:42:0x00f6, B:43:0x00fc, B:45:0x010c, B:47:0x0116, B:46:0x0111, B:48:0x011a, B:15:0x004c), top: B:83:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5 A[Catch: Exception -> 0x018c, TimeoutException -> 0x0190, JSONException -> 0x0194, InterruptedException -> 0x019b, ExecutionException -> 0x019d, CancellationException -> 0x019f, TryCatch #2 {InterruptedException -> 0x019b, CancellationException -> 0x019f, ExecutionException -> 0x019d, TimeoutException -> 0x0190, JSONException -> 0x0194, Exception -> 0x018c, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x0038, B:10:0x003e, B:13:0x0046, B:16:0x0050, B:18:0x0068, B:20:0x0079, B:24:0x0083, B:26:0x0091, B:28:0x009b, B:30:0x00a3, B:32:0x00ad, B:34:0x00b5, B:50:0x011e, B:55:0x0129, B:59:0x013d, B:61:0x016d, B:63:0x0171, B:64:0x0187, B:58:0x0139, B:35:0x00bf, B:37:0x00c7, B:38:0x00d1, B:40:0x00d9, B:42:0x00f6, B:43:0x00fc, B:45:0x010c, B:47:0x0116, B:46:0x0111, B:48:0x011a, B:15:0x004c), top: B:83:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf A[Catch: Exception -> 0x018c, TimeoutException -> 0x0190, JSONException -> 0x0194, InterruptedException -> 0x019b, ExecutionException -> 0x019d, CancellationException -> 0x019f, TryCatch #2 {InterruptedException -> 0x019b, CancellationException -> 0x019f, ExecutionException -> 0x019d, TimeoutException -> 0x0190, JSONException -> 0x0194, Exception -> 0x018c, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x0038, B:10:0x003e, B:13:0x0046, B:16:0x0050, B:18:0x0068, B:20:0x0079, B:24:0x0083, B:26:0x0091, B:28:0x009b, B:30:0x00a3, B:32:0x00ad, B:34:0x00b5, B:50:0x011e, B:55:0x0129, B:59:0x013d, B:61:0x016d, B:63:0x0171, B:64:0x0187, B:58:0x0139, B:35:0x00bf, B:37:0x00c7, B:38:0x00d1, B:40:0x00d9, B:42:0x00f6, B:43:0x00fc, B:45:0x010c, B:47:0x0116, B:46:0x0111, B:48:0x011a, B:15:0x004c), top: B:83:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0139 A[Catch: Exception -> 0x018c, TimeoutException -> 0x0190, JSONException -> 0x0194, InterruptedException -> 0x019b, ExecutionException -> 0x019d, CancellationException -> 0x019f, TryCatch #2 {InterruptedException -> 0x019b, CancellationException -> 0x019f, ExecutionException -> 0x019d, TimeoutException -> 0x0190, JSONException -> 0x0194, Exception -> 0x018c, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x0038, B:10:0x003e, B:13:0x0046, B:16:0x0050, B:18:0x0068, B:20:0x0079, B:24:0x0083, B:26:0x0091, B:28:0x009b, B:30:0x00a3, B:32:0x00ad, B:34:0x00b5, B:50:0x011e, B:55:0x0129, B:59:0x013d, B:61:0x016d, B:63:0x0171, B:64:0x0187, B:58:0x0139, B:35:0x00bf, B:37:0x00c7, B:38:0x00d1, B:40:0x00d9, B:42:0x00f6, B:43:0x00fc, B:45:0x010c, B:47:0x0116, B:46:0x0111, B:48:0x011a, B:15:0x004c), top: B:83:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0171 A[Catch: Exception -> 0x018c, TimeoutException -> 0x0190, JSONException -> 0x0194, InterruptedException -> 0x019b, ExecutionException -> 0x019d, CancellationException -> 0x019f, TryCatch #2 {InterruptedException -> 0x019b, CancellationException -> 0x019f, ExecutionException -> 0x019d, TimeoutException -> 0x0190, JSONException -> 0x0194, Exception -> 0x018c, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x0038, B:10:0x003e, B:13:0x0046, B:16:0x0050, B:18:0x0068, B:20:0x0079, B:24:0x0083, B:26:0x0091, B:28:0x009b, B:30:0x00a3, B:32:0x00ad, B:34:0x00b5, B:50:0x011e, B:55:0x0129, B:59:0x013d, B:61:0x016d, B:63:0x0171, B:64:0x0187, B:58:0x0139, B:35:0x00bf, B:37:0x00c7, B:38:0x00d1, B:40:0x00d9, B:42:0x00f6, B:43:0x00fc, B:45:0x010c, B:47:0x0116, B:46:0x0111, B:48:0x011a, B:15:0x004c), top: B:83:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a4  */
    @Override // java.util.concurrent.Callable
    /* renamed from: zzng */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzafo call() {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzym.call():com.google.android.gms.internal.zzafo");
    }

    private final boolean zznh() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcki;
        }
        return z;
    }

    private final void zzz(int i) {
        synchronized (this.mLock) {
            this.zzcki = true;
            this.mErrorCode = i;
        }
    }

    public final zzakv<zzoi> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public final List<zzakv<zzoi>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() == 0) {
            zzd(0, false);
            return arrayList;
        }
        int length = z3 ? optJSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, false, z2));
        }
        return arrayList;
    }

    public final Future<zzoi> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public final zzakv<zzanh> zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzakl.zzi(null);
        }
        if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            zzagf.zzcu("Required field 'vast_xml' is missing");
            return zzakl.zzi(null);
        }
        zzyt zzytVar = new zzyt(this.mContext, this.zzbuv, this.zzcjk, this.zzanj, this.zzckh);
        zzalf zzalfVar = new zzalf();
        com.google.android.gms.ads.internal.zzbs.zzei();
        zzahn.runOnUiThread(new zzyu(zzytVar, optJSONObject, zzalfVar));
        return zzalfVar;
    }

    public final void zzd(int i, boolean z) {
        if (z) {
            zzz(i);
        }
    }

    public final zzakv<zzog> zzh(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzakl.zzi(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        int i = (this.zzcjk.zzcqv.zzauo == null || this.zzcjk.zzcqv.zzauo.versionCode < 2) ? 1 : this.zzcjk.zzcqv.zzauo.zzbvh;
        boolean optBoolean = optJSONObject.optBoolean("allow_pub_rendering");
        List<zzakv<zzoi>> arrayList = new ArrayList<>();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        return zzakl.zza(zzl(arrayList), new zzyp(this, optString, zzb2, zzb, optInt, optInt3, optInt2, i, optBoolean), zzahh.zzdar);
    }
}
