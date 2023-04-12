package com.google.android.gms.internal;

import android.content.SharedPreferences;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zznb extends zzmx<Float> {

    /* renamed from: com.google.android.gms.internal.zznb$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zzhx {
        AnonymousClass1() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            synchronized (zznb.zza(zznb.this)) {
                if (zznb.zzb(zznb.this).isDone()) {
                    return;
                }
                if (zznb.zzc(zznb.this).equals(map.get("request_id"))) {
                    zzne zzneVar = new zzne(1, map);
                    String valueOf = String.valueOf(zzneVar.getType());
                    String valueOf2 = String.valueOf(zzneVar.zzji());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length());
                    sb.append("Invalid ");
                    sb.append(valueOf);
                    sb.append(" request error: ");
                    sb.append(valueOf2);
                    zzpe.zzbe(sb.toString());
                    zznb.zzb(zznb.this).zzh(zzneVar);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zznb$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zzhx {
        AnonymousClass2() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            synchronized (zznb.zza(zznb.this)) {
                if (zznb.zzb(zznb.this).isDone()) {
                    return;
                }
                zzne zzneVar = new zzne(-2, map);
                if (zznb.zzc(zznb.this).equals(zzneVar.getRequestId())) {
                    String url = zzneVar.getUrl();
                    if (url == null) {
                        zzpe.zzbe("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (url.contains("%40mediation_adapters%40")) {
                        String replaceAll = url.replaceAll("%40mediation_adapters%40", zzpc.zza(zzqpVar.getContext(), map.get("check_adapters"), zznb.zzd(zznb.this)));
                        zzneVar.setUrl(replaceAll);
                        String valueOf = String.valueOf(replaceAll);
                        zzpe.v(valueOf.length() != 0 ? "Ad request URL modified to ".concat(valueOf) : new String("Ad request URL modified to "));
                    }
                    zznb.zzb(zznb.this).zzh(zzneVar);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zznb$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements zzhx {
        AnonymousClass3() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            synchronized (zznb.zza(zznb.this)) {
                if (zznb.zzb(zznb.this).isDone()) {
                    return;
                }
                zzne zzneVar = new zzne(-2, map);
                if (zznb.zzc(zznb.this).equals(zzneVar.getRequestId())) {
                    zznb.zzb(zznb.this).zzh(zzneVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznb(int i, String str, Float f) {
        super(i, str, f, null);
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ Float zza(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(getKey(), zziv().floatValue()));
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Float f) {
        editor.putFloat(getKey(), f.floatValue());
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ Float zzc(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(getKey(), zziv().floatValue()));
    }
}
