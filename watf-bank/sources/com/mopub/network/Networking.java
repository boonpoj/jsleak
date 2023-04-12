package com.mopub.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.DeviceUtils;
import com.mopub.volley.toolbox.BaseHttpStack;
import com.mopub.volley.toolbox.BasicNetwork;
import com.mopub.volley.toolbox.DiskBasedCache;
import com.mopub.volley.toolbox.HurlStack;
import com.mopub.volley.toolbox.ImageLoader;
import java.io.File;
/* loaded from: assets/classes2.dex */
public class Networking {

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static volatile MoPubRequestQueue f2073;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static volatile String f2074;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static volatile MaxWidthImageLoader f2075;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private static HurlStack.UrlRewriter f2077;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final String f2072 = System.getProperty("http.agent");

    /* renamed from: ࢥ  reason: contains not printable characters */
    private static boolean f2076 = false;

    @VisibleForTesting
    public static synchronized void clearForTesting() {
        synchronized (Networking.class) {
            f2073 = null;
            f2075 = null;
            f2074 = null;
        }
    }

    public static String getBaseUrlScheme() {
        return shouldUseHttps() ? Constants.HTTPS : Constants.HTTP;
    }

    @NonNull
    public static String getCachedUserAgent() {
        String str = f2074;
        return str == null ? f2072 : str;
    }

    @NonNull
    public static ImageLoader getImageLoader(@NonNull Context context) {
        MaxWidthImageLoader maxWidthImageLoader = f2075;
        if (maxWidthImageLoader == null) {
            synchronized (Networking.class) {
                maxWidthImageLoader = f2075;
                if (maxWidthImageLoader == null) {
                    MoPubRequestQueue requestQueue = getRequestQueue(context);
                    final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(DeviceUtils.memoryCacheSizeBytes(context)) { // from class: com.mopub.network.Networking.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.support.v4.util.LruCache
                        /* renamed from: ࢠ  reason: contains not printable characters */
                        public int sizeOf(String str, Bitmap bitmap) {
                            return bitmap != null ? bitmap.getRowBytes() * bitmap.getHeight() : super.sizeOf(str, bitmap);
                        }
                    };
                    MaxWidthImageLoader maxWidthImageLoader2 = new MaxWidthImageLoader(requestQueue, context, new ImageLoader.ImageCache() { // from class: com.mopub.network.Networking.2
                        @Override // com.mopub.volley.toolbox.ImageLoader.ImageCache
                        public Bitmap getBitmap(String str) {
                            return (Bitmap) LruCache.this.get(str);
                        }

                        @Override // com.mopub.volley.toolbox.ImageLoader.ImageCache
                        public void putBitmap(String str, Bitmap bitmap) {
                            LruCache.this.put(str, bitmap);
                        }
                    });
                    f2075 = maxWidthImageLoader2;
                    maxWidthImageLoader = maxWidthImageLoader2;
                }
            }
        }
        return maxWidthImageLoader;
    }

    @Nullable
    public static MoPubRequestQueue getRequestQueue() {
        return f2073;
    }

    @NonNull
    public static MoPubRequestQueue getRequestQueue(@NonNull Context context) {
        MoPubRequestQueue moPubRequestQueue = f2073;
        if (moPubRequestQueue == null) {
            synchronized (Networking.class) {
                moPubRequestQueue = f2073;
                if (moPubRequestQueue == null) {
                    BasicNetwork basicNetwork = new BasicNetwork((BaseHttpStack) new RequestQueueHttpStack(getUserAgent(context.getApplicationContext()), getUrlRewriter(context), CustomSSLSocketFactory.getDefault(10000)));
                    File file = new File(context.getCacheDir().getPath() + File.separator + "mopub-volley-cache");
                    MoPubRequestQueue moPubRequestQueue2 = new MoPubRequestQueue(new DiskBasedCache(file, (int) DeviceUtils.diskCacheSizeBytes(file, 10485760L)), basicNetwork);
                    f2073 = moPubRequestQueue2;
                    moPubRequestQueue2.start();
                    moPubRequestQueue = moPubRequestQueue2;
                }
            }
        }
        return moPubRequestQueue;
    }

    public static String getScheme() {
        return Constants.HTTPS;
    }

    @NonNull
    public static HurlStack.UrlRewriter getUrlRewriter(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (f2077 == null) {
            f2077 = new PlayServicesUrlRewriter();
        }
        return f2077;
    }

    @NonNull
    public static String getUserAgent(@NonNull Context context) {
        String str;
        Preconditions.checkNotNull(context);
        String str2 = f2074;
        if (str2 == null) {
            synchronized (Networking.class) {
                str2 = f2074;
                if (str2 == null) {
                    try {
                        str = Build.VERSION.SDK_INT >= 17 ? WebSettings.getDefaultUserAgent(context) : Looper.myLooper() == Looper.getMainLooper() ? new WebView(context).getSettings().getUserAgentString() : f2072;
                    } catch (Exception unused) {
                        str = f2072;
                    }
                    f2074 = str;
                    str2 = str;
                }
            }
        }
        return str2;
    }

    @VisibleForTesting
    public static synchronized void setImageLoaderForTesting(MaxWidthImageLoader maxWidthImageLoader) {
        synchronized (Networking.class) {
            f2075 = maxWidthImageLoader;
        }
    }

    @VisibleForTesting
    public static synchronized void setRequestQueueForTesting(MoPubRequestQueue moPubRequestQueue) {
        synchronized (Networking.class) {
            f2073 = moPubRequestQueue;
        }
    }

    @VisibleForTesting
    public static synchronized void setUserAgentForTesting(String str) {
        synchronized (Networking.class) {
            f2074 = str;
        }
    }

    public static boolean shouldUseHttps() {
        return f2076;
    }

    public static void useHttps(boolean z) {
        f2076 = z;
    }
}
