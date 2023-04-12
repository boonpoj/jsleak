package com.mopub.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.mopub.volley.Network;
import com.mopub.volley.RequestQueue;
import java.io.File;
/* loaded from: assets/classes2.dex */
public class Volley {
    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, (BaseHttpStack) null);
    }

    public static RequestQueue newRequestQueue(Context context, BaseHttpStack baseHttpStack) {
        BasicNetwork basicNetwork;
        if (baseHttpStack != null) {
            basicNetwork = new BasicNetwork(baseHttpStack);
        } else if (Build.VERSION.SDK_INT >= 9) {
            basicNetwork = new BasicNetwork((BaseHttpStack) new HurlStack());
        } else {
            String str = "volley/0";
            try {
                String packageName = context.getPackageName();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                str = packageName + "/" + packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            basicNetwork = new BasicNetwork(new HttpClientStack(AndroidHttpClient.newInstance(str)));
        }
        return m1717(context, basicNetwork);
    }

    @Deprecated
    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack) {
        return httpStack == null ? newRequestQueue(context, (BaseHttpStack) null) : m1717(context, new BasicNetwork(httpStack));
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static RequestQueue m1717(Context context, Network network) {
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(new File(context.getCacheDir(), "volley")), network);
        requestQueue.start();
        return requestQueue;
    }
}
