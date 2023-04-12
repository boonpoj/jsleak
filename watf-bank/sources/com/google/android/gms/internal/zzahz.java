package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.io.File;
/* loaded from: classes.dex */
public class zzahz extends zzaib {
    @Override // com.google.android.gms.internal.zzaht
    public final String getDefaultUserAgent(Context context) {
        zzajl zzqt = zzajl.zzqt();
        if (TextUtils.isEmpty(zzqt.zzczb)) {
            zzqt.zzczb = (String) zzajk.zza(context, new zzajm(zzqt, com.google.android.gms.common.zzp.getRemoteContext(context), context));
        }
        return zzqt.zzczb;
    }

    @Override // com.google.android.gms.internal.zzaht
    public final Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        if (!z || f <= 0.0f || f > 25.0f) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(context);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            return new BitmapDrawable(context.getResources(), createBitmap);
        } catch (RuntimeException e) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }

    @Override // com.google.android.gms.internal.zzaib, com.google.android.gms.internal.zzahw, com.google.android.gms.internal.zzaht
    public final boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    @Override // com.google.android.gms.internal.zzaht
    public final void zzax(Context context) {
        zzajl zzqt = zzajl.zzqt();
        zzagf.v("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(zzqt.zzczb)) {
            Context remoteContext = com.google.android.gms.common.zzp.getRemoteContext(context);
            if (remoteContext == null) {
                SharedPreferences.Editor putString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (remoteContext == null) {
                    putString.apply();
                } else {
                    File file = new File(context.getApplicationInfo().dataDir, "shared_prefs");
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.setExecutable(true, false);
                    }
                    file.setExecutable(true, false);
                    putString.commit();
                    new File(file, String.valueOf("admob_user_agent").concat(".xml")).setReadable(true, false);
                }
            }
            zzqt.zzczb = defaultUserAgent;
        }
        zzagf.v("User agent is updated.");
        com.google.android.gms.ads.internal.zzbs.zzem().zzpt();
    }
}
