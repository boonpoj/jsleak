package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzix;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final /* synthetic */ class zziy {

    /* renamed from: com.google.android.gms.internal.zziy$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzqa zzIQ;
        final /* synthetic */ zza zzIR;
        final /* synthetic */ zzav zzIS;
        final /* synthetic */ com.google.android.gms.ads.internal.zzd zzIT;
        final /* synthetic */ String zzIU;
        final /* synthetic */ Context zztd;

        AnonymousClass1(Context context, zzqa zzqaVar, zza zzaVar, zzav zzavVar, com.google.android.gms.ads.internal.zzd zzdVar, String str) {
            this.zztd = context;
            this.zzIQ = zzqaVar;
            this.zzIR = zzaVar;
            this.zzIS = zzavVar;
            this.zzIT = zzdVar;
            this.zzIU = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            zziy.zza(zziy.this, this.zztd, this.zzIQ, this.zzIR, this.zzIS, this.zzIT).zzam(this.zzIU);
        }
    }

    /* renamed from: com.google.android.gms.internal.zziy$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zzix.zza {
        final /* synthetic */ zza zzIR;

        AnonymousClass2(zziy zziyVar, zza zzaVar) {
            this.zzIR = zzaVar;
        }

        @Override // com.google.android.gms.internal.zzix.zza
        public void zzgu() {
            this.zzIR.zzh((zzix) this.zzIR.zzIW);
        }
    }

    /* loaded from: assets/classes2.dex */
    private static class zza<JavascriptEngine> extends zzqc<JavascriptEngine> {
        JavascriptEngine zzIW;

        private zza() {
        }

        /* synthetic */ zza(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
