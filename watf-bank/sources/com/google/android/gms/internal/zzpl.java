package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzpl implements zzoq {
    private /* synthetic */ View zzbvv;
    private /* synthetic */ zzpj zzbwa;

    /* renamed from: com.google.android.gms.internal.zzpl$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements DialogInterface.OnClickListener {
        final /* synthetic */ int zzXd;
        final /* synthetic */ int zzXe;
        final /* synthetic */ int zzXf;

        AnonymousClass1(int i, int i2, int i3) {
            this.zzXd = i;
            this.zzXe = i2;
            this.zzXf = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == this.zzXd) {
                zzpl.zza(zzpl.this);
            } else if (i == this.zzXe && ((Boolean) zzfx.zzEQ.get()).booleanValue()) {
                zzpl.zzb(zzpl.this);
            } else if (i == this.zzXf && ((Boolean) zzfx.zzER.get()).booleanValue()) {
                zzpl.zzc(zzpl.this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpl$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements DialogInterface.OnClickListener {
        final /* synthetic */ String zzXh;

        AnonymousClass2(String str) {
            this.zzXh = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            com.google.android.gms.ads.internal.zzv.zzcJ().zzb(zzpl.zzd(zzpl.this), Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.zzXh), "Share via"));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpl$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements DialogInterface.OnClickListener {
        AnonymousClass3(zzpl zzplVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpl$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.ads.internal.zzv.zzcR().zzj(zzpl.zzd(zzpl.this), zzpl.zze(zzpl.this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpl$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.ads.internal.zzv.zzcR().zzk(zzpl.zzd(zzpl.this), zzpl.zze(zzpl.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpl(zzpj zzpjVar, View view) {
        this.zzbwa = zzpjVar;
        this.zzbvv = view;
    }

    @Override // com.google.android.gms.internal.zzoq
    public final void zzc(MotionEvent motionEvent) {
        this.zzbwa.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.zzoq
    public final void zzkb() {
        boolean zza;
        zza = this.zzbwa.zza(zzpj.zzbvj);
        if (zza) {
            this.zzbwa.onClick(this.zzbvv);
        }
    }
}
