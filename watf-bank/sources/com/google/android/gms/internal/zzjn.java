package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public class zzjn extends zzbfm {
    public static final Parcelable.Creator<zzjn> CREATOR = new zzjo();
    public final int height;
    public final int heightPixels;
    public final int width;
    public final int widthPixels;
    public final String zzbek;
    public final boolean zzbel;
    public final zzjn[] zzbem;
    public final boolean zzben;
    public final boolean zzbeo;
    public boolean zzbep;

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zzD(int i);

        void zza(int i, zzjv zzjvVar);
    }

    public zzjn() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzjn(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzjn(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjn.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    public zzjn(zzjn zzjnVar, zzjn[] zzjnVarArr) {
        this(zzjnVar.zzbek, zzjnVar.height, zzjnVar.heightPixels, zzjnVar.zzbel, zzjnVar.width, zzjnVar.widthPixels, zzjnVarArr, zzjnVar.zzben, zzjnVar.zzbeo, zzjnVar.zzbep);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjn(String str, int i, int i2, boolean z, int i3, int i4, zzjn[] zzjnVarArr, boolean z2, boolean z3, boolean z4) {
        this.zzbek = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzbel = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzbem = zzjnVarArr;
        this.zzben = z2;
        this.zzbeo = z3;
        this.zzbep = z4;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (zzd(displayMetrics) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzjn zzf(Context context) {
        return new zzjn("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static zzjn zzhs() {
        return new zzjn("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzbek, false);
        zzbfp.zzc(parcel, 3, this.height);
        zzbfp.zzc(parcel, 4, this.heightPixels);
        zzbfp.zza(parcel, 5, this.zzbel);
        zzbfp.zzc(parcel, 6, this.width);
        zzbfp.zzc(parcel, 7, this.widthPixels);
        zzbfp.zza(parcel, 8, (Parcelable[]) this.zzbem, i, false);
        zzbfp.zza(parcel, 9, this.zzben);
        zzbfp.zza(parcel, 10, this.zzbeo);
        zzbfp.zza(parcel, 11, this.zzbep);
        zzbfp.zzai(parcel, zze);
    }

    public final AdSize zzht() {
        return com.google.android.gms.ads.zzb.zza(this.width, this.height, this.zzbek);
    }
}
