package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.concurrent.TimeUnit;
@zzzv
/* loaded from: classes.dex */
public final class zzamq {
    private final Context mContext;
    private final zzakd zzarf;
    private final String zzcrt;
    private final zznu zzdgt;
    private boolean zzdgx;
    private final zzns zzdje;
    private final long[] zzdjg;
    private final String[] zzdjh;
    private zzamb zzdjm;
    private boolean zzdjn;
    private boolean zzdjo;
    private final zzair zzdjf = new zzaiu().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzqr();
    private boolean zzdji = false;
    private boolean zzdjj = false;
    private boolean zzdjk = false;
    private boolean zzdjl = false;
    private long zzdjp = -1;

    public zzamq(Context context, zzakd zzakdVar, String str, zznu zznuVar, zzns zznsVar) {
        this.mContext = context;
        this.zzarf = zzakdVar;
        this.zzcrt = str;
        this.zzdgt = zznuVar;
        this.zzdje = zznsVar;
        String str2 = (String) zzkb.zzif().zzd(zznh.zzbil);
        if (str2 == null) {
            this.zzdjh = new String[0];
            this.zzdjg = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzdjh = new String[split.length];
        this.zzdjg = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzdjg[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzagf.zzc("Unable to parse frame hash target time number.", e);
                this.zzdjg[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (!((Boolean) zzkb.zzif().zzd(zznh.zzbik)).booleanValue() || this.zzdjn) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(VastExtensionXmlManager.TYPE, "native-player-metrics");
        bundle.putString("request", this.zzcrt);
        bundle.putString("player", this.zzdjm.zzri());
        for (zzait zzaitVar : this.zzdjf.getBuckets()) {
            String valueOf = String.valueOf("fps_c_");
            String valueOf2 = String.valueOf(zzaitVar.name);
            bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(zzaitVar.count));
            String valueOf3 = String.valueOf("fps_p_");
            String valueOf4 = String.valueOf(zzaitVar.name);
            bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(zzaitVar.zzdcf));
        }
        int i = 0;
        while (true) {
            long[] jArr = this.zzdjg;
            if (i >= jArr.length) {
                com.google.android.gms.ads.internal.zzbs.zzei().zza(this.mContext, this.zzarf.zzcv, "gmob-apps", bundle, true);
                this.zzdjn = true;
                return;
            }
            String str = this.zzdjh[i];
            if (str != null) {
                String valueOf5 = String.valueOf(Long.valueOf(jArr[i]));
                StringBuilder sb = new StringBuilder(String.valueOf("fh_").length() + String.valueOf(valueOf5).length());
                sb.append("fh_");
                sb.append(valueOf5);
                bundle.putString(sb.toString(), str);
            }
            i++;
        }
    }

    public final void zza(zzamb zzambVar) {
        zznn.zza(this.zzdgt, this.zzdje, "vpc2");
        this.zzdji = true;
        zznu zznuVar = this.zzdgt;
        if (zznuVar != null) {
            zznuVar.zzf("vpn", zzambVar.zzri());
        }
        this.zzdjm = zzambVar;
    }

    public final void zzb(zzamb zzambVar) {
        if (this.zzdjk && !this.zzdjl) {
            zznn.zza(this.zzdgt, this.zzdje, "vff2");
            this.zzdjl = true;
        }
        long nanoTime = com.google.android.gms.ads.internal.zzbs.zzeo().nanoTime();
        if (this.zzdgx && this.zzdjo && this.zzdjp != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L);
            double d = nanoTime - this.zzdjp;
            Double.isNaN(nanos);
            Double.isNaN(d);
            this.zzdjf.zza(nanos / d);
        }
        this.zzdjo = this.zzdgx;
        this.zzdjp = nanoTime;
        long longValue = ((Long) zzkb.zzif().zzd(zznh.zzbim)).longValue();
        long currentPosition = zzambVar.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.zzdjh;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && longValue > Math.abs(currentPosition - this.zzdjg[i])) {
                String[] strArr2 = this.zzdjh;
                int i2 = 8;
                Bitmap bitmap = zzambVar.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j = j3;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
            i++;
        }
    }

    public final void zzro() {
        if (!this.zzdji || this.zzdjj) {
            return;
        }
        zznn.zza(this.zzdgt, this.zzdje, "vfr2");
        this.zzdjj = true;
    }

    public final void zzsn() {
        this.zzdgx = true;
        if (!this.zzdjj || this.zzdjk) {
            return;
        }
        zznn.zza(this.zzdgt, this.zzdje, "vfp2");
        this.zzdjk = true;
    }

    public final void zzso() {
        this.zzdgx = false;
    }
}
