package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.ParseError;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyLog;
/* loaded from: assets/classes2.dex */
public class ImageRequest extends Request<Bitmap> {
    public static final float DEFAULT_IMAGE_BACKOFF_MULT = 2.0f;
    public static final int DEFAULT_IMAGE_MAX_RETRIES = 2;
    public static final int DEFAULT_IMAGE_TIMEOUT_MS = 1000;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private static final Object f2218 = new Object();

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Object f2219;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private Response.Listener<Bitmap> f2220;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Bitmap.Config f2221;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final int f2222;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final int f2223;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final ImageView.ScaleType f2224;

    @Deprecated
    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i, int i2, Bitmap.Config config, Response.ErrorListener errorListener) {
        this(str, listener, i, i2, ImageView.ScaleType.CENTER_INSIDE, config, errorListener);
    }

    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, Response.ErrorListener errorListener) {
        super(0, str, errorListener);
        this.f2219 = new Object();
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.f2220 = listener;
        this.f2221 = config;
        this.f2222 = i;
        this.f2223 = i2;
        this.f2224 = scaleType;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static int m1706(int i, int i2, int i3, int i4) {
        double d = i;
        double d2 = i3;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = i2;
        double d4 = i4;
        Double.isNaN(d3);
        Double.isNaN(d4);
        double min = Math.min(d / d2, d3 / d4);
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static int m1707(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        } else if (i == 0) {
            double d = i2;
            double d2 = i4;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = i3;
            Double.isNaN(d3);
            return (int) (d3 * (d / d2));
        } else if (i2 == 0) {
            return i;
        } else {
            double d4 = i4;
            double d5 = i3;
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = d4 / d5;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d7 = i;
                Double.isNaN(d7);
                double d8 = i2;
                if (d7 * d6 < d8) {
                    Double.isNaN(d8);
                    return (int) (d8 / d6);
                }
                return i;
            }
            double d9 = i;
            Double.isNaN(d9);
            double d10 = i2;
            if (d9 * d6 > d10) {
                Double.isNaN(d10);
                return (int) (d10 / d6);
            }
            return i;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private Response<Bitmap> m1708(NetworkResponse networkResponse) {
        Bitmap decodeByteArray;
        byte[] bArr = networkResponse.data;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f2222 == 0 && this.f2223 == 0) {
            options.inPreferredConfig = this.f2221;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int m1707 = m1707(this.f2222, this.f2223, i, i2, this.f2224);
            int m17072 = m1707(this.f2223, this.f2222, i2, i, this.f2224);
            options.inJustDecodeBounds = false;
            options.inSampleSize = m1706(i, i2, m1707, m17072);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > m1707 || decodeByteArray.getHeight() > m17072)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, m1707, m17072, true);
                decodeByteArray.recycle();
                decodeByteArray = createScaledBitmap;
            }
        }
        return decodeByteArray == null ? Response.error(new ParseError(networkResponse)) : Response.success(decodeByteArray, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    @Override // com.mopub.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f2219) {
            this.f2220 = null;
        }
    }

    @Override // com.mopub.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ */
    public Response<Bitmap> mo502(NetworkResponse networkResponse) {
        Response<Bitmap> m1708;
        synchronized (f2218) {
            try {
                try {
                    m1708 = m1708(networkResponse);
                } catch (OutOfMemoryError e) {
                    VolleyLog.e("Caught OOM for %d byte image, url=%s", Integer.valueOf(networkResponse.data.length), getUrl());
                    return Response.error(new ParseError(e));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return m1708;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void deliverResponse(Bitmap bitmap) {
        Response.Listener<Bitmap> listener;
        synchronized (this.f2219) {
            listener = this.f2220;
        }
        if (listener != null) {
            listener.onResponse(bitmap);
        }
    }
}
