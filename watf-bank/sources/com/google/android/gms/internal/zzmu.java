package com.google.android.gms.internal;

import android.os.Environment;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzqi;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzmu implements Callable<Boolean> {

    /* renamed from: com.google.android.gms.internal.zzmu$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzov.zza zzsI;

        AnonymousClass1(zzov.zza zzaVar) {
            this.zzsI = zzaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzmu.zza(zzmu.this).zza(this.zzsI);
            if (zzmu.zzb(zzmu.this) != null) {
                zzmu.zzb(zzmu.this).release();
                zzmu.zza(zzmu.this, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.gms.internal.zzmu$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ String zzSA;
        final /* synthetic */ JSONObject zzSz;

        AnonymousClass2(JSONObject jSONObject, String str) {
            this.zzSz = jSONObject;
            this.zzSA = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzmu.zza(zzmu.this, zzmu.zzjd().zzgv());
            zzmu.zzb(zzmu.this).zza(new zzqi.zzc<zzjb>() { // from class: com.google.android.gms.internal.zzmu.2.1
                @Override // com.google.android.gms.internal.zzqi.zzc
                /* renamed from: zzb */
                public void zzd(zzjb zzjbVar) {
                    try {
                        zzjbVar.zza("AFMA_getAdapterLessMediationAd", AnonymousClass2.this.zzSz);
                    } catch (Exception e) {
                        zzpe.zzb("Error requesting an ad url", e);
                        zzmu.zzjc().zzac(AnonymousClass2.this.zzSA);
                    }
                }
            }, new zzqi.zza() { // from class: com.google.android.gms.internal.zzmu.2.2
                @Override // com.google.android.gms.internal.zzqi.zza
                public void run() {
                    zzmu.zzjc().zzac(AnonymousClass2.this.zzSA);
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmu$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzmu.zzb(zzmu.this) != null) {
                zzmu.zzb(zzmu.this).release();
                zzmu.zza(zzmu.this, null);
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zza implements zzpn<zzix> {
        /* renamed from: zza */
        public void zzd(zzix zzixVar) {
            zzmu.zzc(zzixVar);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzb implements zzpn<zzix> {
        /* renamed from: zza */
        public void zzd(zzix zzixVar) {
            zzmu.zzb(zzixVar);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zzc implements zzhx {
        public void zza(zzqp zzqpVar, Map<String, String> map) {
            String str = map.get("request_id");
            String valueOf = String.valueOf(map.get("errors"));
            zzpe.zzbe(valueOf.length() != 0 ? "Invalid request: ".concat(valueOf) : new String("Invalid request: "));
            zzmu.zzjc().zzac(str);
        }
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
    }
}
