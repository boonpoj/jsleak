package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zznc extends zzmx<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zznc(int i, String str, String str2) {
        super(i, str, str2, null);
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ String zza(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(getKey(), zziv());
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, String str) {
        editor.putString(getKey(), str);
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ String zzc(JSONObject jSONObject) {
        return jSONObject.optString(getKey(), zziv());
    }
}
