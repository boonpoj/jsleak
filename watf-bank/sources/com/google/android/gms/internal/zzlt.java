package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzqi;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzlt {
    private final boolean zzamr;
    private final int zzbdw;
    private final int zzbdz;
    private final String zzbea;
    private final String zzbec;
    private final Bundle zzbee;
    private final String zzbeg;
    private final boolean zzbei;
    private final Bundle zzbfs;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzbft;
    private final SearchAdRequest zzbfu;
    private final Set<String> zzbfv;
    private final Set<String> zzbfw;
    private final Date zzhh;
    private final Set<String> zzhj;
    private final Location zzhl;

    /* renamed from: com.google.android.gms.internal.zzlt$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zzqi.zzc<zzjb> {
        final /* synthetic */ zza zzPZ;

        AnonymousClass1(zzlt zzltVar, zza zzaVar) {
            this.zzPZ = zzaVar;
        }

        @Override // com.google.android.gms.internal.zzqi.zzc
        /* renamed from: zzb */
        public void zzd(zzjb zzjbVar) {
            this.zzPZ.zze(zzjbVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlt$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zzqi.zza {
        final /* synthetic */ zza zzPZ;

        AnonymousClass2(zzlt zzltVar, zza zzaVar) {
            this.zzPZ = zzaVar;
        }

        @Override // com.google.android.gms.internal.zzqi.zza
        public void run() {
            this.zzPZ.zziO();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlt$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements zzpn<zzix> {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.internal.zzdt, com.google.android.gms.ads.internal.zzr] */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.google.android.gms.ads.internal.overlay.zzh, com.google.android.gms.ads.internal.zzr] */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.zzht, com.google.android.gms.ads.internal.zzr] */
        /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.gms.ads.internal.overlay.zzq, com.google.android.gms.ads.internal.zzr] */
        /* renamed from: zza */
        public void zzd(zzix zzixVar) {
            zzixVar.zza(zzlt.zza(zzlt.this), zzlt.zza(zzlt.this), zzlt.zza(zzlt.this), zzlt.zza(zzlt.this), false, null, null, null, null);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static abstract class zza {
        public abstract void zze(zzjb zzjbVar);

        public void zziO() {
        }
    }

    public zzlt(zzlu zzluVar) {
        this(zzluVar, null);
    }

    public zzlt(zzlu zzluVar, SearchAdRequest searchAdRequest) {
        this.zzhh = zzlu.zza(zzluVar);
        this.zzbec = zzlu.zzb(zzluVar);
        this.zzbdw = zzlu.zzc(zzluVar);
        this.zzhj = Collections.unmodifiableSet(zzlu.zzd(zzluVar));
        this.zzhl = zzlu.zze(zzluVar);
        this.zzamr = zzlu.zzf(zzluVar);
        this.zzbfs = zzlu.zzg(zzluVar);
        this.zzbft = Collections.unmodifiableMap(zzlu.zzh(zzluVar));
        this.zzbea = zzlu.zzi(zzluVar);
        this.zzbeg = zzlu.zzj(zzluVar);
        this.zzbfu = searchAdRequest;
        this.zzbdz = zzlu.zzk(zzluVar);
        this.zzbfv = Collections.unmodifiableSet(zzlu.zzl(zzluVar));
        this.zzbee = zzlu.zzm(zzluVar);
        this.zzbfw = Collections.unmodifiableSet(zzlu.zzn(zzluVar));
        this.zzbei = zzlu.zzo(zzluVar);
    }

    public final Date getBirthday() {
        return this.zzhh;
    }

    public final String getContentUrl() {
        return this.zzbec;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzbfs.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.zzbee;
    }

    public final int getGender() {
        return this.zzbdw;
    }

    public final Set<String> getKeywords() {
        return this.zzhj;
    }

    public final Location getLocation() {
        return this.zzhl;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzamr;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzbft.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.zzbfs.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.zzbea;
    }

    public final boolean isDesignedForFamilies() {
        return this.zzbei;
    }

    public final boolean isTestDevice(Context context) {
        Set<String> set = this.zzbfv;
        zzkb.zzia();
        return set.contains(zzajr.zzbc(context));
    }

    public final String zzik() {
        return this.zzbeg;
    }

    public final SearchAdRequest zzil() {
        return this.zzbfu;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzim() {
        return this.zzbft;
    }

    public final Bundle zzin() {
        return this.zzbfs;
    }

    public final int zzio() {
        return this.zzbdz;
    }

    public final Set<String> zzip() {
        return this.zzbfw;
    }
}
