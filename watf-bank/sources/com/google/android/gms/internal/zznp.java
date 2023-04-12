package com.google.android.gms.internal;

import com.google.android.gms.internal.zzov;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zznp extends zzno {

    /* renamed from: com.google.android.gms.internal.zznp$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zznp.zza(zznp.this, 1);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznp$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ zzov.zza zzsI;

        AnonymousClass2(zzov.zza zzaVar) {
            this.zzsI = zzaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zznp.this.zzb(new zzov(this.zzsI, null, null, null, null, null, null, null));
        }
    }

    @Override // com.google.android.gms.internal.zzno
    public final String zze(String str, String str2) {
        return str2;
    }
}
