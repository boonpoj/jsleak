package com.mopub.volley.toolbox;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
/* loaded from: assets/classes2.dex */
public class NetworkImageView extends ImageView {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f2229;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2230;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2231;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private ImageLoader f2232;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private ImageLoader.ImageContainer f2233;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.volley.toolbox.NetworkImageView$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    public class AnonymousClass1 implements ImageLoader.ImageListener {

        /* renamed from: ࢠ  reason: contains not printable characters */
        final /* synthetic */ boolean f2234;

        AnonymousClass1(boolean z) {
            this.f2234 = z;
        }

        @Override // com.mopub.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (NetworkImageView.this.f2231 != 0) {
                NetworkImageView.this.setImageResource(NetworkImageView.this.f2231);
            }
        }

        @Override // com.mopub.volley.toolbox.ImageLoader.ImageListener
        public void onResponse(final ImageLoader.ImageContainer imageContainer, boolean z) {
            if (z && this.f2234) {
                NetworkImageView.this.post(new Runnable() { // from class: com.mopub.volley.toolbox.NetworkImageView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.onResponse(imageContainer, false);
                    }
                });
            } else if (imageContainer.getBitmap() != null) {
                NetworkImageView.this.setImageBitmap(imageContainer.getBitmap());
            } else if (NetworkImageView.this.f2230 != 0) {
                NetworkImageView.this.setImageResource(NetworkImageView.this.f2230);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1711() {
        if (this.f2230 != 0) {
            setImageResource(this.f2230);
        } else {
            setImageBitmap(null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.f2233 != null) {
            this.f2233.cancelRequest();
            setImageBitmap(null);
            this.f2233 = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m1713(true);
    }

    public void setDefaultImageResId(int i) {
        this.f2230 = i;
    }

    public void setErrorImageResId(int i) {
        this.f2231 = i;
    }

    public void setImageUrl(String str, ImageLoader imageLoader) {
        this.f2229 = str;
        this.f2232 = imageLoader;
        m1713(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* renamed from: ࢠ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m1713(boolean r9) {
        /*
            r8 = this;
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            android.widget.ImageView$ScaleType r7 = r8.getScaleType()
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2a
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            int r2 = r2.width
            r5 = -2
            if (r2 != r5) goto L1f
            r2 = 1
            goto L20
        L1f:
            r2 = 0
        L20:
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            int r6 = r6.height
            if (r6 != r5) goto L2b
            r5 = 1
            goto L2c
        L2a:
            r2 = 0
        L2b:
            r5 = 0
        L2c:
            if (r2 == 0) goto L31
            if (r5 == 0) goto L31
            goto L32
        L31:
            r3 = 0
        L32:
            if (r0 != 0) goto L39
            if (r1 != 0) goto L39
            if (r3 != 0) goto L39
            return
        L39:
            java.lang.String r3 = r8.f2229
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L51
            com.mopub.volley.toolbox.ImageLoader$ImageContainer r9 = r8.f2233
            if (r9 == 0) goto L4d
            com.mopub.volley.toolbox.ImageLoader$ImageContainer r9 = r8.f2233
            r9.cancelRequest()
            r9 = 0
            r8.f2233 = r9
        L4d:
            r8.m1711()
            return
        L51:
            com.mopub.volley.toolbox.ImageLoader$ImageContainer r3 = r8.f2233
            if (r3 == 0) goto L74
            com.mopub.volley.toolbox.ImageLoader$ImageContainer r3 = r8.f2233
            java.lang.String r3 = r3.getRequestUrl()
            if (r3 == 0) goto L74
            com.mopub.volley.toolbox.ImageLoader$ImageContainer r3 = r8.f2233
            java.lang.String r3 = r3.getRequestUrl()
            java.lang.String r6 = r8.f2229
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L6c
            return
        L6c:
            com.mopub.volley.toolbox.ImageLoader$ImageContainer r3 = r8.f2233
            r3.cancelRequest()
            r8.m1711()
        L74:
            if (r2 == 0) goto L77
            r0 = 0
        L77:
            if (r5 == 0) goto L7b
            r6 = 0
            goto L7c
        L7b:
            r6 = r1
        L7c:
            com.mopub.volley.toolbox.ImageLoader r2 = r8.f2232
            java.lang.String r3 = r8.f2229
            com.mopub.volley.toolbox.NetworkImageView$1 r4 = new com.mopub.volley.toolbox.NetworkImageView$1
            r4.<init>(r9)
            r5 = r0
            com.mopub.volley.toolbox.ImageLoader$ImageContainer r9 = r2.get(r3, r4, r5, r6, r7)
            r8.f2233 = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.toolbox.NetworkImageView.m1713(boolean):void");
    }
}
