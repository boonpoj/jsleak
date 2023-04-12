package com.google.android.gms.internal;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
@zzzv
/* loaded from: classes.dex */
public class zzaht {
    private zzaht() {
    }

    public static boolean zzi(zzanh zzanhVar) {
        if (zzanhVar == null) {
            return false;
        }
        zzanhVar.onPause();
        return true;
    }

    public static boolean zzj(zzanh zzanhVar) {
        if (zzanhVar == null) {
            return false;
        }
        zzanhVar.onResume();
        return true;
    }

    public static boolean zzqj() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public void setBackground(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public String zza(SslError sslError) {
        return "";
    }

    public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean zza(DownloadManager.Request request) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean zza(Window window) {
        return false;
    }

    public void zzax(Context context) {
        com.google.android.gms.ads.internal.zzbs.zzem().zzpt();
    }

    public CookieManager zzay(Context context) {
        if (zzqj()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzagf.zzb("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzbs.zzem().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public zzani zzb(zzanh zzanhVar, boolean z) {
        return new zzani(zzanhVar, z);
    }

    public void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
    }

    public Set<String> zzg(Uri uri) {
        String encodedQuery;
        if (!uri.isOpaque() && (encodedQuery = uri.getEncodedQuery()) != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            do {
                int indexOf = encodedQuery.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
                i = indexOf + 1;
            } while (i < encodedQuery.length());
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.emptySet();
    }

    public WebChromeClient zzk(zzanh zzanhVar) {
        return null;
    }

    public int zzqf() {
        return 0;
    }

    public int zzqg() {
        return 1;
    }

    public int zzqh() {
        return 5;
    }

    public ViewGroup.LayoutParams zzqi() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public int zzqk() {
        return 0;
    }

    public boolean zzx(View view) {
        return false;
    }

    public boolean zzy(View view) {
        return false;
    }
}
