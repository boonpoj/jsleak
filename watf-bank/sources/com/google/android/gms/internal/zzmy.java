package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzmy extends zzmx<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmy(int i, String str, Boolean bool) {
        super(i, str, bool, null);
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ Boolean zza(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), zziv().booleanValue()));
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Boolean bool) {
        editor.putBoolean(getKey(), bool.booleanValue());
    }

    @Override // com.google.android.gms.internal.zzmx
    public final /* synthetic */ Boolean zzc(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(getKey(), zziv().booleanValue()));
    }
}
