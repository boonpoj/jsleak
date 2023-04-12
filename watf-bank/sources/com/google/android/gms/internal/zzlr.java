package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.CountDownLatch;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzlr extends zzbfm {
    public static final Parcelable.Creator<zzlr> CREATOR = new zzls();
    public final int zzbfr;

    /* renamed from: com.google.android.gms.internal.zzlr$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ CountDownLatch zzsA;

        AnonymousClass1(CountDownLatch countDownLatch) {
            this.zzsA = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzlr.this.zzPr) {
                zzlr.zza(zzlr.this, com.google.android.gms.ads.internal.zzo.zza(zzlr.zza(zzlr.this), zzlr.this.zzPM, this.zzsA));
            }
        }
    }

    public zzlr(int i) {
        this.zzbfr = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 2, this.zzbfr);
        zzbfp.zzai(parcel, zze);
    }
}
