package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzrr extends zzbfm {
    public static final Parcelable.Creator<zzrr> CREATOR = new zzrs();
    private String url;
    private String[] zzbyo;
    private String[] zzbyp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrr(String str, String[] strArr, String[] strArr2) {
        this.url = str;
        this.zzbyo = strArr;
        this.zzbyp = strArr2;
    }

    public static zzrr zzg(zzr zzrVar) throws zza {
        Map<String, String> headers = zzrVar.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        return new zzrr(zzrVar.getUrl(), strArr, strArr2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.url, false);
        zzbfp.zza(parcel, 2, this.zzbyo, false);
        zzbfp.zza(parcel, 3, this.zzbyp, false);
        zzbfp.zzai(parcel, zze);
    }
}
