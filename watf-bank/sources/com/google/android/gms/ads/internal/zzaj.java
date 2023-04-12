package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzrc;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class zzaj extends zzko {
    private final Context mContext;
    private final zzv zzanr;
    private final zzux zzanw;
    private zzkh zzape;
    private zzjn zzapj;
    private PublisherAdViewOptions zzapk;
    private zzpe zzapn;
    private zzld zzapp;
    private final String zzapq;
    private final zzakd zzapr;
    private zzqq zzapw;
    private zzrc zzapx;
    private zzqt zzapy;
    private zzrf zzaqb;
    private SimpleArrayMap<String, zzqz> zzaqa = new SimpleArrayMap<>();
    private SimpleArrayMap<String, zzqw> zzapz = new SimpleArrayMap<>();

    public zzaj(Context context, String str, zzux zzuxVar, zzakd zzakdVar, zzv zzvVar) {
        this.mContext = context;
        this.zzapq = str;
        this.zzanw = zzuxVar;
        this.zzapr = zzakdVar;
        this.zzanr = zzvVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzapk = publisherAdViewOptions;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(zzpe zzpeVar) {
        this.zzapn = zzpeVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(zzqq zzqqVar) {
        this.zzapw = zzqqVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(zzqt zzqtVar) {
        this.zzapy = zzqtVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(zzrc zzrcVar) {
        this.zzapx = zzrcVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(zzrf zzrfVar, zzjn zzjnVar) {
        this.zzaqb = zzrfVar;
        this.zzapj = zzjnVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(String str, zzqz zzqzVar, zzqw zzqwVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.zzaqa.put(str, zzqzVar);
        this.zzapz.put(str, zzqwVar);
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zzb(zzkh zzkhVar) {
        this.zzape = zzkhVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zzb(zzld zzldVar) {
        this.zzapp = zzldVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzkk zzdi() {
        return new zzag(this.mContext, this.zzapq, this.zzanw, this.zzapr, this.zzape, this.zzapw, this.zzapx, this.zzapy, this.zzaqa, this.zzapz, this.zzapn, this.zzapp, this.zzanr, this.zzaqb, this.zzapj, this.zzapk);
    }
}
