package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public class PlaceReport extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzl();
    private final String mTag;
    private final String zzdrc;
    private int zzeck;
    private final String zzinh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceReport(int i, String str, String str2, String str3) {
        this.zzeck = i;
        this.zzinh = str;
        this.mTag = str2;
        this.zzdrc = str3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static PlaceReport create(String str, String str2) {
        char c;
        zzbq.checkNotNull(str);
        zzbq.zzgm(str2);
        zzbq.zzgm(EnvironmentCompat.MEDIA_UNKNOWN);
        boolean z = false;
        switch (EnvironmentCompat.MEDIA_UNKNOWN.hashCode()) {
            case -1436706272:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals("inferredGeofencing")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1194968642:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals("userReported")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -284840886:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -262743844:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals("inferredReverseGeocoding")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1164924125:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals("inferredSnappedToRoad")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1287171955:
                if (EnvironmentCompat.MEDIA_UNKNOWN.equals("inferredRadioSignals")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        zzbq.checkArgument((c == 0 || c == 1 || c == 2 || c == 3 || c == 4 || c == 5) ? true : true, "Invalid source");
        return new PlaceReport(1, str, str2, EnvironmentCompat.MEDIA_UNKNOWN);
    }

    public boolean equals(Object obj) {
        if (obj instanceof PlaceReport) {
            PlaceReport placeReport = (PlaceReport) obj;
            return zzbg.equal(this.zzinh, placeReport.zzinh) && zzbg.equal(this.mTag, placeReport.mTag) && zzbg.equal(this.zzdrc, placeReport.zzdrc);
        }
        return false;
    }

    public String getPlaceId() {
        return this.zzinh;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzinh, this.mTag, this.zzdrc});
    }

    public String toString() {
        zzbi zzx = zzbg.zzx(this);
        zzx.zzg("placeId", this.zzinh);
        zzx.zzg("tag", this.mTag);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.zzdrc)) {
            zzx.zzg("source", this.zzdrc);
        }
        return zzx.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, getPlaceId(), false);
        zzbfp.zza(parcel, 3, getTag(), false);
        zzbfp.zza(parcel, 4, this.zzdrc, false);
        zzbfp.zzai(parcel, zze);
    }
}
