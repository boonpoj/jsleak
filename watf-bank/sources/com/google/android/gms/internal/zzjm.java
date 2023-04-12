package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzjv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzjm {
    public static final zzjm zzbej = new zzjm();

    /* renamed from: com.google.android.gms.internal.zzjm$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzjl zzKw;

        AnonymousClass1(zzjl zzjlVar) {
            this.zzKw = zzjlVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [com.google.android.gms.internal.zzjm, com.google.android.gms.internal.zzjn$zza] */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzjm.zza(zzjm.this)) {
                if (zzjm.zzb(zzjm.this) != -2) {
                    return;
                }
                zzjm.zza(zzjm.this, zzjm.zzc(zzjm.this));
                if (zzjm.zzd(zzjm.this) == null) {
                    zzjm.this.zzD(4);
                } else if (!zzjm.zze(zzjm.this) || zzjm.zza(zzjm.this, 1)) {
                    this.zzKw.zza(zzjm.this);
                    zzjm.zza(zzjm.this, this.zzKw);
                } else {
                    String zzf = zzjm.zzf(zzjm.this);
                    StringBuilder sb = new StringBuilder(String.valueOf(zzf).length() + 56);
                    sb.append("Ignoring adapter ");
                    sb.append(zzf);
                    sb.append(" as delayed impression is not supported");
                    zzpe.zzbe(sb.toString());
                    zzjm.this.zzD(2);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjm$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass2 extends zzjv.zza {
        final /* synthetic */ int zzKy;

        AnonymousClass2(int i) {
            this.zzKy = i;
        }

        public int zzgH() throws RemoteException {
            return this.zzKy;
        }
    }

    protected zzjm() {
    }

    public static zzjj zza(Context context, zzlt zzltVar) {
        Context context2;
        List list;
        String str;
        Date birthday = zzltVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1L;
        String contentUrl = zzltVar.getContentUrl();
        int gender = zzltVar.getGender();
        Set<String> keywords = zzltVar.getKeywords();
        if (keywords.isEmpty()) {
            context2 = context;
            list = null;
        } else {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        }
        boolean isTestDevice = zzltVar.isTestDevice(context2);
        int zzio = zzltVar.zzio();
        Location location = zzltVar.getLocation();
        Bundle networkExtrasBundle = zzltVar.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzltVar.getManualImpressionsEnabled();
        String publisherProvidedId = zzltVar.getPublisherProvidedId();
        SearchAdRequest zzil = zzltVar.zzil();
        zzmn zzmnVar = zzil != null ? new zzmn(zzil) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzkb.zzia();
            str = zzajr.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        return new zzjj(7, time, networkExtrasBundle, gender, list, isTestDevice, zzio, manualImpressionsEnabled, publisherProvidedId, zzmnVar, location, contentUrl, zzltVar.zzin(), zzltVar.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzltVar.zzip())), zzltVar.zzik(), str, zzltVar.isDesignedForFamilies());
    }
}
