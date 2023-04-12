package com.google.android.gms.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zztu {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zztt<JSONObject> zzccb = new zztw();
    private static zztr<InputStream> zzccc = zztv.zzccd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ InputStream zzg(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
