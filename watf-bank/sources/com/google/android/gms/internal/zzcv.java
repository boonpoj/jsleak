package com.google.android.gms.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzcv {
    private static final String[] zzaia = {"/aclk", "/pcs/click"};
    private String zzahw = "googleads.g.doubleclick.net";
    private String zzahx = "/pagead/ads";
    private String zzahy = "ad.doubleclick.net";
    private String[] zzahz = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzcr zzaib;

    /* renamed from: com.google.android.gms.internal.zzcv$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zzcv.zza(zzcv.this, 3);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcv$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 extends BroadcastReceiver {
        AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            zzcv.zza(zzcv.this, 3);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static class zza {
        public final long timestamp;
        public final boolean zzwQ;
        public final boolean zzwR;
        public final int zzwS;
        public final Rect zzwT;
        public final Rect zzwU;
        public final Rect zzwV;
        public final boolean zzwW;
        public final Rect zzwX;
        public final boolean zzwY;
        public final Rect zzwZ;
        public final float zzxa;
        public final boolean zzxb;

        public zza(long j, boolean z, boolean z2, int i, Rect rect, Rect rect2, Rect rect3, boolean z3, Rect rect4, boolean z4, Rect rect5, float f, boolean z5) {
            this.timestamp = j;
            this.zzwQ = z;
            this.zzwR = z2;
            this.zzwS = i;
            this.zzwT = rect;
            this.zzwU = rect2;
            this.zzwV = rect3;
            this.zzwW = z3;
            this.zzwX = rect4;
            this.zzwY = z4;
            this.zzwZ = rect5;
            this.zzxa = f;
            this.zzxb = z5;
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zzb {
        void zza(zza zzaVar);
    }

    public zzcv(zzcr zzcrVar) {
        this.zzaib = zzcrVar;
    }

    private final Uri zza(Uri uri, Context context, String str, boolean z, View view, Activity activity) throws zzcw {
        try {
            boolean zza2 = zza(uri);
            if (zza2) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzcw("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzcw("Query parameter already exists: ms");
            }
            String zza3 = z ? this.zzaib.zza(context, str, view, activity) : this.zzaib.zza(context);
            if (!zza2) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf("&adurl");
                if (indexOf == -1) {
                    indexOf = uri2.indexOf("?adurl");
                }
                if (indexOf != -1) {
                    int i = indexOf + 1;
                    return Uri.parse(uri2.substring(0, i) + "ms=" + zza3 + "&" + uri2.substring(i));
                }
                return uri.buildUpon().appendQueryParameter("ms", zza3).build();
            }
            String uri3 = uri.toString();
            int indexOf2 = uri3.indexOf(";adurl");
            if (indexOf2 != -1) {
                int i2 = indexOf2 + 1;
                return Uri.parse(uri3.substring(0, i2) + "dc_ms=" + zza3 + ";" + uri3.substring(i2));
            }
            String encodedPath = uri.getEncodedPath();
            int indexOf3 = uri3.indexOf(encodedPath);
            return Uri.parse(uri3.substring(0, encodedPath.length() + indexOf3) + ";dc_ms=" + zza3 + ";" + uri3.substring(indexOf3 + encodedPath.length()));
        } catch (UnsupportedOperationException e) {
            throw new zzcw("Provided Uri is not in a valid state");
        }
    }

    private final boolean zza(Uri uri) {
        if (uri != null) {
            try {
                return uri.getHost().equals(this.zzahy);
            } catch (NullPointerException e) {
                return false;
            }
        }
        throw new NullPointerException();
    }

    public final Uri zza(Uri uri, Context context) throws zzcw {
        return zza(uri, context, null, false, null, null);
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzcw {
        try {
            return zza(uri, context, uri.getQueryParameter("ai"), true, view, activity);
        } catch (UnsupportedOperationException e) {
            throw new zzcw("Provided Uri is not in a valid state");
        }
    }

    public final void zza(MotionEvent motionEvent) {
        this.zzaib.zza(motionEvent);
    }

    public final zzcr zzaf() {
        return this.zzaib;
    }

    public final boolean zzb(Uri uri) {
        if (uri != null) {
            try {
                String host = uri.getHost();
                for (String str : this.zzahz) {
                    if (host.endsWith(str)) {
                        return true;
                    }
                }
                return false;
            } catch (NullPointerException e) {
                return false;
            }
        }
        throw new NullPointerException();
    }

    public final boolean zzc(Uri uri) {
        if (zzb(uri)) {
            for (String str : zzaia) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
