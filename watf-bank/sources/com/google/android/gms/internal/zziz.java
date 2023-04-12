package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzqq;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zziz {
    private final byte[] zzbcp;
    private int zzbcq;
    private int zzbcr;
    private /* synthetic */ zzix zzbcs;

    /* renamed from: com.google.android.gms.internal.zziz$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String zzIX;
        final /* synthetic */ JSONObject zzIY;

        AnonymousClass1(String str, JSONObject jSONObject) {
            this.zzIX = str;
            this.zzIY = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            zziz.zza(zziz.this).zza(this.zzIX, this.zzIY);
        }
    }

    /* renamed from: com.google.android.gms.internal.zziz$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String zzIX;
        final /* synthetic */ String zzJa;

        AnonymousClass2(String str, String str2) {
            this.zzIX = str;
            this.zzJa = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            zziz.zza(zziz.this).zzi(this.zzIX, this.zzJa);
        }
    }

    /* renamed from: com.google.android.gms.internal.zziz$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String zzJb;

        AnonymousClass3(String str) {
            this.zzJb = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            zziz.zza(zziz.this).loadData(this.zzJb, "text/html", "UTF-8");
        }
    }

    /* renamed from: com.google.android.gms.internal.zziz$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String zzJb;

        AnonymousClass4(String str) {
            this.zzJb = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            zziz.zza(zziz.this).loadData(this.zzJb, "text/html", "UTF-8");
        }
    }

    /* renamed from: com.google.android.gms.internal.zziz$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String zzIU;

        AnonymousClass5(String str) {
            this.zzIU = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            zziz.zza(zziz.this).loadUrl(this.zzIU);
        }
    }

    /* renamed from: com.google.android.gms.internal.zziz$6  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass6 implements zzqq.zza {
        final /* synthetic */ zzix.zza zzJc;

        AnonymousClass6(zziz zzizVar, zzix.zza zzaVar) {
            this.zzJc = zzaVar;
        }

        @Override // com.google.android.gms.internal.zzqq.zza
        public void zza(zzqp zzqpVar, boolean z) {
            this.zzJc.zzgu();
        }
    }

    private zziz(zzix zzixVar, byte[] bArr) {
        this.zzbcs = zzixVar;
        this.zzbcp = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zziz(zzix zzixVar, byte[] bArr, zziy zziyVar) {
        this(zzixVar, bArr);
    }

    public final synchronized void zzbk() {
        try {
            if (this.zzbcs.zzbco) {
                this.zzbcs.zzbcn.zzc(this.zzbcp);
                this.zzbcs.zzbcn.zzg(this.zzbcq);
                this.zzbcs.zzbcn.zzh(this.zzbcr);
                this.zzbcs.zzbcn.zza(null);
                this.zzbcs.zzbcn.zzbk();
            }
        } catch (RemoteException e) {
            zzakb.zza("Clearcut log failed", e);
        }
    }

    public final zziz zzp(int i) {
        this.zzbcq = i;
        return this;
    }

    public final zziz zzq(int i) {
        this.zzbcr = i;
        return this;
    }
}
