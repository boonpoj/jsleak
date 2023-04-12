package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zzajm implements Callable<String> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ Context zzdde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajm(zzajl zzajlVar, Context context, Context context2) {
        this.zzdde = context;
        this.val$context = context2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.zzdde != null) {
            zzagf.v("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.zzdde.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzagf.v("Attempting to read user agent from local cache.");
            sharedPreferences = this.val$context.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzagf.v("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.val$context);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzagf.v("Persisting user agent.");
            }
        }
        return string;
    }
}
