package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzamv implements com.google.android.gms.ads.internal.gmsg.zzt<zzamp> {
    private boolean zzdjv;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                zzkb.zzia();
                return zzajr.zzc(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
                sb.append("Could not parse ");
                sb.append(str);
                sb.append(" in a video GMSG: ");
                sb.append(str2);
                zzagf.zzcu(sb.toString());
                return i;
            }
        }
        return i;
    }

    private static void zza(zzamd zzamdVar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        if (str != null) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                zzagf.zzcu(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            Integer.parseInt(str2);
        }
        if (str3 != null) {
            Integer.parseInt(str3);
        }
        if (str4 != null) {
            Integer.parseInt(str4);
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzamp zzampVar, Map map) {
        int i;
        int i2;
        int i3;
        String[] split;
        zzamp zzampVar2 = zzampVar;
        String str = (String) map.get("action");
        if (str == null) {
            zzagf.zzcu("Action missing from video GMSG.");
            return;
        }
        if (zzagf.zzae(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzagf.zzbx(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzagf.zzcu("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzampVar2.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException e) {
                zzagf.zzcu("Invalid color parameter in video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                zzagf.zzcu("No MIME types specified for decoder properties inspection.");
                zzamd.zza(zzampVar2, "missingMimeTypes");
                return;
            } else if (Build.VERSION.SDK_INT < 16) {
                zzagf.zzcu("Video decoder properties available on API versions >= 16.");
                zzamd.zza(zzampVar2, "deficientApiVersion");
                return;
            } else {
                HashMap hashMap = new HashMap();
                for (String str4 : str3.split(",")) {
                    hashMap.put(str4, zzajp.zzco(str4.trim()));
                }
                zzamd.zza(zzampVar2, hashMap);
                return;
            }
        }
        zzamg zzsf = zzampVar2.zzsf();
        if (zzsf == null) {
            zzagf.zzcu("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        if (equals || equals2) {
            Context context = zzampVar2.getContext();
            int zza = zza(context, map, AvidJSONUtil.KEY_X, 0);
            int zza2 = zza(context, map, AvidJSONUtil.KEY_Y, 0);
            int zza3 = zza(context, map, "w", -1);
            int zza4 = zza(context, map, "h", -1);
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbov)).booleanValue()) {
                i = Math.min(zza3, zzampVar2.zzsm() - zza);
                i2 = Math.min(zza4, zzampVar2.zzsl() - zza2);
            } else {
                i = zza3;
                i2 = zza4;
            }
            try {
                i3 = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e2) {
                i3 = 0;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (!equals || zzsf.zzsa() != null) {
                zzsf.zze(zza, zza2, i, i2);
                return;
            }
            zzsf.zza(zza, zza2, i, i2, i3, parseBoolean, new zzamo((String) map.get("flags")));
            zzamd zzsa = zzsf.zzsa();
            if (zzsa != null) {
                zza(zzsa, (Map<String, String>) map);
                return;
            }
            return;
        }
        zzamd zzsa2 = zzsf.zzsa();
        if (zzsa2 == null) {
            zzamd.zza(zzampVar2);
        } else if ("click".equals(str)) {
            Context context2 = zzampVar2.getContext();
            int zza5 = zza(context2, map, AvidJSONUtil.KEY_X, 0);
            int zza6 = zza(context2, map, AvidJSONUtil.KEY_Y, 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, zza5, zza6, 0);
            zzsa2.zzf(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            String str5 = (String) map.get("time");
            if (str5 == null) {
                zzagf.zzcu("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzsa2.seekTo((int) (Float.parseFloat(str5) * 1000.0f));
            } catch (NumberFormatException e3) {
                String valueOf = String.valueOf(str5);
                zzagf.zzcu(valueOf.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf) : new String("Could not parse time parameter from currentTime video GMSG: "));
            }
        } else if ("hide".equals(str)) {
            zzsa2.setVisibility(4);
        } else if ("load".equals(str)) {
            zzsa2.zzrt();
        } else if ("loadControl".equals(str)) {
            zza(zzsa2, (Map<String, String>) map);
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzsa2.zzru();
            } else {
                zzsa2.zzrv();
            }
        } else if ("pause".equals(str)) {
            zzsa2.pause();
        } else if ("play".equals(str)) {
            zzsa2.play();
        } else if ("show".equals(str)) {
            zzsa2.setVisibility(0);
        } else if ("src".equals(str)) {
            zzsa2.zzcv((String) map.get("src"));
        } else if ("touchMove".equals(str)) {
            Context context3 = zzampVar2.getContext();
            zzsa2.zza(zza(context3, map, "dx", 0), zza(context3, map, "dy", 0));
            if (this.zzdjv) {
                return;
            }
            zzampVar2.zzna();
            this.zzdjv = true;
        } else if (!AvidVideoPlaybackListenerImpl.VOLUME.equals(str)) {
            if ("watermark".equals(str)) {
                zzsa2.zzrw();
                return;
            }
            String valueOf2 = String.valueOf(str);
            zzagf.zzcu(valueOf2.length() != 0 ? "Unknown video action: ".concat(valueOf2) : new String("Unknown video action: "));
        } else {
            String str6 = (String) map.get(AvidVideoPlaybackListenerImpl.VOLUME);
            if (str6 == null) {
                zzagf.zzcu("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                zzsa2.zzb(Float.parseFloat(str6));
            } catch (NumberFormatException e4) {
                String valueOf3 = String.valueOf(str6);
                zzagf.zzcu(valueOf3.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf3) : new String("Could not parse volume parameter from volume video GMSG: "));
            }
        }
    }
}
