package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzao;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class AdOverlayInfoParcel extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzm();
    public final int orientation;
    public final String url;
    public final zzakd zzaty;
    public final zzc zzciv;
    public final zzje zzciw;
    public final zzn zzcix;
    public final zzanh zzciy;
    public final com.google.android.gms.ads.internal.gmsg.zzb zzciz;
    public final String zzcja;
    public final boolean zzcjb;
    public final String zzcjc;
    public final zzq zzcjd;
    public final int zzcje;
    public final String zzcjf;
    public final zzao zzcjg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdOverlayInfoParcel(zzc zzcVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, zzakd zzakdVar, String str4, zzao zzaoVar) {
        this.zzciv = zzcVar;
        this.zzciw = (zzje) com.google.android.gms.dynamic.zzn.zzx(IObjectWrapper.zza.zzaq(iBinder));
        this.zzcix = (zzn) com.google.android.gms.dynamic.zzn.zzx(IObjectWrapper.zza.zzaq(iBinder2));
        this.zzciy = (zzanh) com.google.android.gms.dynamic.zzn.zzx(IObjectWrapper.zza.zzaq(iBinder3));
        this.zzciz = (com.google.android.gms.ads.internal.gmsg.zzb) com.google.android.gms.dynamic.zzn.zzx(IObjectWrapper.zza.zzaq(iBinder4));
        this.zzcja = str;
        this.zzcjb = z;
        this.zzcjc = str2;
        this.zzcjd = (zzq) com.google.android.gms.dynamic.zzn.zzx(IObjectWrapper.zza.zzaq(iBinder5));
        this.orientation = i;
        this.zzcje = i2;
        this.url = str3;
        this.zzaty = zzakdVar;
        this.zzcjf = str4;
        this.zzcjg = zzaoVar;
    }

    public AdOverlayInfoParcel(zzc zzcVar, zzje zzjeVar, zzn zznVar, zzq zzqVar, zzakd zzakdVar) {
        this.zzciv = zzcVar;
        this.zzciw = zzjeVar;
        this.zzcix = zznVar;
        this.zzciy = null;
        this.zzciz = null;
        this.zzcja = null;
        this.zzcjb = false;
        this.zzcjc = null;
        this.zzcjd = zzqVar;
        this.orientation = -1;
        this.zzcje = 4;
        this.url = null;
        this.zzaty = zzakdVar;
        this.zzcjf = null;
        this.zzcjg = null;
    }

    public AdOverlayInfoParcel(zzje zzjeVar, zzn zznVar, com.google.android.gms.ads.internal.gmsg.zzb zzbVar, zzq zzqVar, zzanh zzanhVar, boolean z, int i, String str, zzakd zzakdVar) {
        this.zzciv = null;
        this.zzciw = zzjeVar;
        this.zzcix = zznVar;
        this.zzciy = zzanhVar;
        this.zzciz = zzbVar;
        this.zzcja = null;
        this.zzcjb = z;
        this.zzcjc = null;
        this.zzcjd = zzqVar;
        this.orientation = i;
        this.zzcje = 3;
        this.url = str;
        this.zzaty = zzakdVar;
        this.zzcjf = null;
        this.zzcjg = null;
    }

    public AdOverlayInfoParcel(zzje zzjeVar, zzn zznVar, com.google.android.gms.ads.internal.gmsg.zzb zzbVar, zzq zzqVar, zzanh zzanhVar, boolean z, int i, String str, String str2, zzakd zzakdVar) {
        this.zzciv = null;
        this.zzciw = zzjeVar;
        this.zzcix = zznVar;
        this.zzciy = zzanhVar;
        this.zzciz = zzbVar;
        this.zzcja = str2;
        this.zzcjb = z;
        this.zzcjc = str;
        this.zzcjd = zzqVar;
        this.orientation = i;
        this.zzcje = 3;
        this.url = null;
        this.zzaty = zzakdVar;
        this.zzcjf = null;
        this.zzcjg = null;
    }

    public AdOverlayInfoParcel(zzje zzjeVar, zzn zznVar, zzq zzqVar, zzanh zzanhVar, int i, zzakd zzakdVar, String str, zzao zzaoVar) {
        this.zzciv = null;
        this.zzciw = zzjeVar;
        this.zzcix = zznVar;
        this.zzciy = zzanhVar;
        this.zzciz = null;
        this.zzcja = null;
        this.zzcjb = false;
        this.zzcjc = null;
        this.zzcjd = zzqVar;
        this.orientation = i;
        this.zzcje = 1;
        this.url = null;
        this.zzaty = zzakdVar;
        this.zzcjf = str;
        this.zzcjg = zzaoVar;
    }

    public AdOverlayInfoParcel(zzje zzjeVar, zzn zznVar, zzq zzqVar, zzanh zzanhVar, boolean z, int i, zzakd zzakdVar) {
        this.zzciv = null;
        this.zzciw = zzjeVar;
        this.zzcix = zznVar;
        this.zzciy = zzanhVar;
        this.zzciz = null;
        this.zzcja = null;
        this.zzcjb = z;
        this.zzcjc = null;
        this.zzcjd = zzqVar;
        this.orientation = i;
        this.zzcje = 2;
        this.url = null;
        this.zzaty = zzakdVar;
        this.zzcjf = null;
        this.zzcjg = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, (Parcelable) this.zzciv, i, false);
        zzbfp.zza(parcel, 3, com.google.android.gms.dynamic.zzn.zzz(this.zzciw).asBinder(), false);
        zzbfp.zza(parcel, 4, com.google.android.gms.dynamic.zzn.zzz(this.zzcix).asBinder(), false);
        zzbfp.zza(parcel, 5, com.google.android.gms.dynamic.zzn.zzz(this.zzciy).asBinder(), false);
        zzbfp.zza(parcel, 6, com.google.android.gms.dynamic.zzn.zzz(this.zzciz).asBinder(), false);
        zzbfp.zza(parcel, 7, this.zzcja, false);
        zzbfp.zza(parcel, 8, this.zzcjb);
        zzbfp.zza(parcel, 9, this.zzcjc, false);
        zzbfp.zza(parcel, 10, com.google.android.gms.dynamic.zzn.zzz(this.zzcjd).asBinder(), false);
        zzbfp.zzc(parcel, 11, this.orientation);
        zzbfp.zzc(parcel, 12, this.zzcje);
        zzbfp.zza(parcel, 13, this.url, false);
        zzbfp.zza(parcel, 14, (Parcelable) this.zzaty, i, false);
        zzbfp.zza(parcel, 16, this.zzcjf, false);
        zzbfp.zza(parcel, 17, (Parcelable) this.zzcjg, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
