package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbfp;
import java.util.List;
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzd();
    private final long mTimeout;
    private int zzeck;
    private final long zzgdl;
    private int zzgdm;
    private final String zzgdn;
    private final String zzgdo;
    private final String zzgdp;
    private final int zzgdq;
    private final List<String> zzgdr;
    private final String zzgds;
    private final long zzgdt;
    private int zzgdu;
    private final String zzgdv;
    private final float zzgdw;
    private long zzgdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.zzeck = i;
        this.zzgdl = j;
        this.zzgdm = i2;
        this.zzgdn = str;
        this.zzgdo = str3;
        this.zzgdp = str5;
        this.zzgdq = i3;
        this.zzgdx = -1L;
        this.zzgdr = list;
        this.zzgds = str2;
        this.zzgdt = j2;
        this.zzgdu = i4;
        this.zzgdv = str4;
        this.zzgdw = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int getEventType() {
        return this.zzgdm;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long getTimeMillis() {
        return this.zzgdl;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, getTimeMillis());
        zzbfp.zza(parcel, 4, this.zzgdn, false);
        zzbfp.zzc(parcel, 5, this.zzgdq);
        zzbfp.zzb(parcel, 6, this.zzgdr, false);
        zzbfp.zza(parcel, 8, this.zzgdt);
        zzbfp.zza(parcel, 10, this.zzgdo, false);
        zzbfp.zzc(parcel, 11, getEventType());
        zzbfp.zza(parcel, 12, this.zzgds, false);
        zzbfp.zza(parcel, 13, this.zzgdv, false);
        zzbfp.zzc(parcel, 14, this.zzgdu);
        zzbfp.zza(parcel, 15, this.zzgdw);
        zzbfp.zza(parcel, 16, this.mTimeout);
        zzbfp.zza(parcel, 17, this.zzgdp, false);
        zzbfp.zzai(parcel, zze);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzamd() {
        return this.zzgdx;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzame() {
        String str = this.zzgdn;
        int i = this.zzgdq;
        List<String> list = this.zzgdr;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i2 = this.zzgdu;
        String str2 = this.zzgdo;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.zzgdv;
        if (str3 == null) {
            str3 = "";
        }
        float f = this.zzgdw;
        String str4 = this.zzgdp;
        String str5 = str4 != null ? str4 : "";
        StringBuilder sb = new StringBuilder(String.valueOf("\t").length() + 37 + String.valueOf(str).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(join).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(str2).length() + String.valueOf("\t").length() + String.valueOf(str3).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(str5).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str5);
        return sb.toString();
    }
}
