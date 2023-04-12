package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzv
/* loaded from: classes.dex */
public final class zztm {
    final String zzapq;
    final zzjj zzarx;
    final int zzbzv;

    private zztm(zzjj zzjjVar, String str, int i) {
        this.zzarx = zzjjVar;
        this.zzapq = str;
        this.zzbzv = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztm(zzti zztiVar) {
        this(zztiVar.zzkx(), zztiVar.getAdUnitId(), zztiVar.getNetworkType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zztm zzba(String str) throws IOException {
        String[] split = str.split("\u0000");
        if (split.length == 3) {
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    String str2 = new String(Base64.decode(split[0], 0), "UTF-8");
                    int parseInt = Integer.parseInt(split[1]);
                    byte[] decode = Base64.decode(split[2], 0);
                    obtain.unmarshall(decode, 0, decode.length);
                    obtain.setDataPosition(0);
                    return new zztm(zzjj.CREATOR.createFromParcel(obtain), str2, parseInt);
                } finally {
                    obtain.recycle();
                }
            } catch (zzbfo | IllegalArgumentException | IllegalStateException e) {
                com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "QueueSeed.decode");
                throw new IOException("Malformed QueueSeed encoding.", e);
            }
        }
        throw new IOException("Incorrect field count for QueueSeed.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzll() {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                String encodeToString = Base64.encodeToString(this.zzapq.getBytes("UTF-8"), 0);
                String num = Integer.toString(this.zzbzv);
                this.zzarx.writeToParcel(obtain, 0);
                String encodeToString2 = Base64.encodeToString(obtain.marshall(), 0);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 2 + String.valueOf(num).length() + String.valueOf(encodeToString2).length());
                sb.append(encodeToString);
                sb.append("\u0000");
                sb.append(num);
                sb.append("\u0000");
                sb.append(encodeToString2);
                return sb.toString();
            } catch (UnsupportedEncodingException e) {
                zzagf.e("QueueSeed encode failed because UTF-8 is not available.");
                obtain.recycle();
                return "";
            }
        } finally {
            obtain.recycle();
        }
    }
}
