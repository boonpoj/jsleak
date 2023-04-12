package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzvj;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzzv;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzaq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.ads.internal.gmsg.zzt<zzanh> zza(zzvj zzvjVar, zzvm zzvmVar, zzab zzabVar) {
        return new zzav(zzvjVar, zzabVar, zzvmVar);
    }

    private static String zza(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzagf.zzcu("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        String valueOf2 = String.valueOf(encodeToString);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzpq zzpqVar) {
        if (zzpqVar == null) {
            zzagf.zzcu("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzpqVar.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            zzagf.zzcu("Unable to get image uri. Trying data uri next");
        }
        return zzb(zzpqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject zza(Bundle bundle, String str) throws JSONException {
        String valueOf;
        String str2;
        JSONObject jSONObject = new JSONObject();
        if (bundle != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = new JSONObject(str);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (bundle.containsKey(next)) {
                    if ("image".equals(jSONObject2.getString(next))) {
                        Object obj = bundle.get(next);
                        if (obj instanceof Bitmap) {
                            valueOf = zza((Bitmap) obj);
                            jSONObject.put(next, valueOf);
                        } else {
                            str2 = "Invalid type. An image type extra should return a bitmap";
                            zzagf.zzcu(str2);
                        }
                    } else if (bundle.get(next) instanceof Bitmap) {
                        str2 = "Invalid asset type. Bitmap should be returned only for image type";
                        zzagf.zzcu(str2);
                    } else {
                        valueOf = String.valueOf(bundle.get(next));
                        jSONObject.put(next, valueOf);
                    }
                }
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zza(com.google.android.gms.internal.zzanh r25, com.google.android.gms.internal.zzuo r26, java.util.concurrent.CountDownLatch r27) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzaq.zza(com.google.android.gms.internal.zzanh, com.google.android.gms.internal.zzuo, java.util.concurrent.CountDownLatch):boolean");
    }

    private static String zzb(zzpq zzpqVar) {
        String str;
        IObjectWrapper zzjr;
        try {
            zzjr = zzpqVar.zzjr();
        } catch (RemoteException e) {
            str = "Unable to get drawable. Returning empty string";
        }
        if (zzjr == null) {
            zzagf.zzcu("Drawable is null. Returning empty string");
            return "";
        }
        Drawable drawable = (Drawable) com.google.android.gms.dynamic.zzn.zzx(zzjr);
        if (drawable instanceof BitmapDrawable) {
            return zza(((BitmapDrawable) drawable).getBitmap());
        }
        str = "Drawable is not an instance of BitmapDrawable. Returning empty string";
        zzagf.zzcu(str);
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(zzanh zzanhVar) {
        View.OnClickListener onClickListener = zzanhVar.getOnClickListener();
        if (onClickListener != null) {
            if (zzanhVar == null) {
                throw null;
            }
            onClickListener.onClick((View) zzanhVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzpq zzd(Object obj) {
        if (obj instanceof IBinder) {
            return zzpr.zzk((IBinder) obj);
        }
        return null;
    }

    public static View zze(zzafo zzafoVar) {
        if (zzafoVar == null) {
            zzagf.e("AdState is null");
            return null;
        } else if (zzf(zzafoVar) && zzafoVar.zzciy != null) {
            zzanh zzanhVar = zzafoVar.zzciy;
            if (zzanhVar != null) {
                return (View) zzanhVar;
            }
            throw null;
        } else {
            try {
                IObjectWrapper view = zzafoVar.zzcet != null ? zzafoVar.zzcet.getView() : null;
                if (view == null) {
                    zzagf.zzcu("View in mediation adapter is null.");
                    return null;
                }
                return (View) com.google.android.gms.dynamic.zzn.zzx(view);
            } catch (RemoteException e) {
                zzagf.zzc("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    public static boolean zzf(zzafo zzafoVar) {
        return (zzafoVar == null || !zzafoVar.zzcow || zzafoVar.zzces == null || zzafoVar.zzces.zzcdc == null) ? false : true;
    }
}
