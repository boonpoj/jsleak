package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: assets/classes2.dex */
public class ImageLoader {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final RequestQueue f2193;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final ImageCache f2195;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private Runnable f2199;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2194 = 100;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final HashMap<String, C0300> f2196 = new HashMap<>();

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final HashMap<String, C0300> f2197 = new HashMap<>();

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final Handler f2198 = new Handler(Looper.getMainLooper());

    /* loaded from: assets/classes2.dex */
    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    /* loaded from: assets/classes2.dex */
    public class ImageContainer {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private Bitmap f2209;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final ImageListener f2210;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private final String f2211;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private final String f2212;

        public ImageContainer(Bitmap bitmap, String str, String str2, ImageListener imageListener) {
            this.f2209 = bitmap;
            this.f2212 = str;
            this.f2211 = str2;
            this.f2210 = imageListener;
        }

        public void cancelRequest() {
            HashMap hashMap;
            if (this.f2210 == null) {
                return;
            }
            C0300 c0300 = (C0300) ImageLoader.this.f2196.get(this.f2211);
            if (c0300 == null) {
                C0300 c03002 = (C0300) ImageLoader.this.f2197.get(this.f2211);
                if (c03002 == null) {
                    return;
                }
                c03002.removeContainerAndCancelIfNecessary(this);
                if (c03002.f2217.size() != 0) {
                    return;
                }
                hashMap = ImageLoader.this.f2197;
            } else if (!c0300.removeContainerAndCancelIfNecessary(this)) {
                return;
            } else {
                hashMap = ImageLoader.this.f2196;
            }
            hashMap.remove(this.f2211);
        }

        public Bitmap getBitmap() {
            return this.f2209;
        }

        public String getRequestUrl() {
            return this.f2212;
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.volley.toolbox.ImageLoader$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class C0300 {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final Request<?> f2214;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private Bitmap f2215;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private VolleyError f2216;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private final LinkedList<ImageContainer> f2217 = new LinkedList<>();

        public C0300(Request<?> request, ImageContainer imageContainer) {
            this.f2214 = request;
            this.f2217.add(imageContainer);
        }

        public void addContainer(ImageContainer imageContainer) {
            this.f2217.add(imageContainer);
        }

        public VolleyError getError() {
            return this.f2216;
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer imageContainer) {
            this.f2217.remove(imageContainer);
            if (this.f2217.size() == 0) {
                this.f2214.cancel();
                return true;
            }
            return false;
        }

        public void setError(VolleyError volleyError) {
            this.f2216 = volleyError;
        }
    }

    public ImageLoader(RequestQueue requestQueue, ImageCache imageCache) {
        this.f2193 = requestQueue;
        this.f2195 = imageCache;
    }

    public static ImageListener getImageListener(final ImageView imageView, final int i, final int i2) {
        return new ImageListener() { // from class: com.mopub.volley.toolbox.ImageLoader.1
            @Override // com.mopub.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                if (i2 != 0) {
                    imageView.setImageResource(i2);
                }
            }

            @Override // com.mopub.volley.toolbox.ImageLoader.ImageListener
            public void onResponse(ImageContainer imageContainer, boolean z) {
                if (imageContainer.getBitmap() != null) {
                    imageView.setImageBitmap(imageContainer.getBitmap());
                } else if (i != 0) {
                    imageView.setImageResource(i);
                }
            }
        };
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m1693(String str, int i, int i2, ImageView.ScaleType scaleType) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1695() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1696(String str, C0300 c0300) {
        this.f2197.put(str, c0300);
        if (this.f2199 == null) {
            this.f2199 = new Runnable() { // from class: com.mopub.volley.toolbox.ImageLoader.4
                @Override // java.lang.Runnable
                public void run() {
                    for (C0300 c03002 : ImageLoader.this.f2197.values()) {
                        Iterator it = c03002.f2217.iterator();
                        while (it.hasNext()) {
                            ImageContainer imageContainer = (ImageContainer) it.next();
                            if (imageContainer.f2210 != null) {
                                if (c03002.getError() == null) {
                                    imageContainer.f2209 = c03002.f2215;
                                    imageContainer.f2210.onResponse(imageContainer, false);
                                } else {
                                    imageContainer.f2210.onErrorResponse(c03002.getError());
                                }
                            }
                        }
                    }
                    ImageLoader.this.f2197.clear();
                    ImageLoader.this.f2199 = null;
                }
            };
            this.f2198.postDelayed(this.f2199, this.f2194);
        }
    }

    public ImageContainer get(String str, ImageListener imageListener) {
        return get(str, imageListener, 0, 0);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2) {
        return get(str, imageListener, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2, ImageView.ScaleType scaleType) {
        m1695();
        String m1693 = m1693(str, i, i2, scaleType);
        Bitmap bitmap = this.f2195.getBitmap(m1693);
        if (bitmap != null) {
            ImageContainer imageContainer = new ImageContainer(bitmap, str, null, null);
            imageListener.onResponse(imageContainer, true);
            return imageContainer;
        }
        ImageContainer imageContainer2 = new ImageContainer(null, str, m1693, imageListener);
        imageListener.onResponse(imageContainer2, true);
        C0300 c0300 = this.f2196.get(m1693);
        if (c0300 != null) {
            c0300.addContainer(imageContainer2);
            return imageContainer2;
        }
        Request<Bitmap> m1698 = m1698(str, i, i2, scaleType, m1693);
        this.f2193.add(m1698);
        this.f2196.put(m1693, new C0300(m1698, imageContainer2));
        return imageContainer2;
    }

    public boolean isCached(String str, int i, int i2) {
        return isCached(str, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public boolean isCached(String str, int i, int i2, ImageView.ScaleType scaleType) {
        m1695();
        return this.f2195.getBitmap(m1693(str, i, i2, scaleType)) != null;
    }

    public void setBatchedResponseDelay(int i) {
        this.f2194 = i;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected Request<Bitmap> m1698(String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new ImageRequest(str, new Response.Listener<Bitmap>() { // from class: com.mopub.volley.toolbox.ImageLoader.2
            @Override // com.mopub.volley.Response.Listener
            public void onResponse(Bitmap bitmap) {
                ImageLoader.this.m1699(str2, bitmap);
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565, new Response.ErrorListener() { // from class: com.mopub.volley.toolbox.ImageLoader.3
            @Override // com.mopub.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                ImageLoader.this.m1700(str2, volleyError);
            }
        });
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void m1699(String str, Bitmap bitmap) {
        this.f2195.putBitmap(str, bitmap);
        C0300 remove = this.f2196.remove(str);
        if (remove != null) {
            remove.f2215 = bitmap;
            m1696(str, remove);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void m1700(String str, VolleyError volleyError) {
        C0300 remove = this.f2196.remove(str);
        if (remove != null) {
            remove.setError(volleyError);
            m1696(str, remove);
        }
    }
}
