package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzqq;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzgv implements zzhc {
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ Bundle zzail;

    /* renamed from: com.google.android.gms.internal.zzgv$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 extends zzlt.zza {
        final /* synthetic */ JSONObject zzGx;

        AnonymousClass1(zzgv zzgvVar, JSONObject jSONObject) {
            this.zzGx = jSONObject;
        }

        @Override // com.google.android.gms.internal.zzlt.zza
        public void zze(zzjb zzjbVar) {
            zzjbVar.zza("google.afma.nativeAds.handleClickGmsg", this.zzGx);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgv$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 extends zzlt.zza {
        final /* synthetic */ JSONObject zzGx;

        AnonymousClass2(zzgv zzgvVar, JSONObject jSONObject) {
            this.zzGx = jSONObject;
        }

        @Override // com.google.android.gms.internal.zzlt.zza
        public void zze(zzjb zzjbVar) {
            zzjbVar.zza("google.afma.nativeAds.handleImpressionPing", this.zzGx);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgv$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 extends zzlt.zza {
        AnonymousClass3() {
        }

        @Override // com.google.android.gms.internal.zzlt.zza
        public void zze(final zzjb zzjbVar) {
            zzjbVar.zza("/loadHtml", new zzhx() { // from class: com.google.android.gms.internal.zzgv.3.1
                public void zza(zzqp zzqpVar, final Map<String, String> map) {
                    zzgv.zzb(zzgv.this).zzkV().zza(new zzqq.zza() { // from class: com.google.android.gms.internal.zzgv.3.1.1
                        @Override // com.google.android.gms.internal.zzqq.zza
                        public void zza(zzqp zzqpVar2, boolean z) {
                            zzgv.zza(zzgv.this, (String) map.get("id"));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("messageType", "htmlLoaded");
                                jSONObject.put("id", zzgv.zza(zzgv.this));
                                zzjbVar.zzb("sendMessageToNativeJs", jSONObject);
                            } catch (JSONException e) {
                                zzpe.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                            }
                        }
                    });
                    String str = map.get("overlayHtml");
                    String str2 = map.get("baseUrl");
                    if (TextUtils.isEmpty(str2)) {
                        zzgv.zzb(zzgv.this).loadData(str, "text/html", "UTF-8");
                    } else {
                        zzgv.zzb(zzgv.this).loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                    }
                }
            });
            zzjbVar.zza("/showOverlay", new zzhx() { // from class: com.google.android.gms.internal.zzgv.3.2
                public void zza(zzqp zzqpVar, Map<String, String> map) {
                    zzgv.zzb(zzgv.this).getView().setVisibility(0);
                }
            });
            zzjbVar.zza("/hideOverlay", new zzhx() { // from class: com.google.android.gms.internal.zzgv.3.3
                public void zza(zzqp zzqpVar, Map<String, String> map) {
                    zzgv.zzb(zzgv.this).getView().setVisibility(8);
                }
            });
            zzgv.zzb(zzgv.this).zzkV().zza("/hideOverlay", new zzhx() { // from class: com.google.android.gms.internal.zzgv.3.4
                public void zza(zzqp zzqpVar, Map<String, String> map) {
                    zzgv.zzb(zzgv.this).getView().setVisibility(8);
                }
            });
            zzgv.zzb(zzgv.this).zzkV().zza("/sendMessageToSdk", new zzhx() { // from class: com.google.android.gms.internal.zzgv.3.5
                public void zza(zzqp zzqpVar, Map<String, String> map) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        for (String str : map.keySet()) {
                            jSONObject.put(str, map.get(str));
                        }
                        jSONObject.put("id", zzgv.zza(zzgv.this));
                        zzjbVar.zzb("sendMessageToNativeJs", jSONObject);
                    } catch (JSONException e) {
                        zzpe.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgv(zzgu zzguVar, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzail = bundle;
    }

    @Override // com.google.android.gms.internal.zzhc
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzail);
    }
}
