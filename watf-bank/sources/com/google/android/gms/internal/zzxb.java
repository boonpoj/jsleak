package com.google.android.gms.internal;

import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public class zzxb {
    private final zzanh zzbyk;
    private final String zzchs;

    public zzxb(zzanh zzanhVar) {
        this(zzanhVar, "");
    }

    public zzxb(zzanh zzanhVar, String str) {
        this.zzbyk = zzanhVar;
        this.zzchs = str;
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzbyk.zza("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            zzagf.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzbyk.zza("onSizeChanged", new JSONObject().put(AvidJSONUtil.KEY_X, i).put(AvidJSONUtil.KEY_Y, i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzagf.zzb("Error occured while dispatching size change.", e);
        }
    }

    public final void zzbm(String str) {
        try {
            this.zzbyk.zza("onError", new JSONObject().put(AvidVideoPlaybackListenerImpl.MESSAGE, str).put("action", this.zzchs));
        } catch (JSONException e) {
            zzagf.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzbn(String str) {
        try {
            this.zzbyk.zza("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzagf.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public final void zzbo(String str) {
        try {
            this.zzbyk.zza("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzagf.zzb("Error occured while dispatching state change.", e);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzbyk.zza("onDefaultPositionReceived", new JSONObject().put(AvidJSONUtil.KEY_X, i).put(AvidJSONUtil.KEY_Y, i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzagf.zzb("Error occured while dispatching default position.", e);
        }
    }
}
