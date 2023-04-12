package jp.co.cyberagent.android.gpuimage;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import jp.co.cyberagent.android.gpuimage.ࢠ.C0390;
import jp.co.cyberagent.android.gpuimage.ࢢ.EnumC0446;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0443 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Context f2826;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final C0448 f2827;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private GLSurfaceView f2829;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private TextureView$SurfaceTextureListenerC0387 f2830;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private C0390 f2831;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private Bitmap f2832;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2828 = 0;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private EnumC0445 f2833 = EnumC0445.CENTER_CROP;

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢢ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0445 {
        CENTER_INSIDE,
        CENTER_CROP
    }

    public C0443(Context context) {
        if (!m2245(context)) {
            throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
        }
        this.f2826 = context;
        this.f2831 = new C0390();
        this.f2827 = new C0448(this.f2831);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m2245(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public Bitmap m2246(Bitmap bitmap) {
        return m2247(bitmap, false);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public Bitmap m2247(Bitmap bitmap, boolean z) {
        if (this.f2829 != null || this.f2830 != null) {
            this.f2827.m2271();
            this.f2827.m2273(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢢ.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (C0443.this.f2831) {
                        C0443.this.f2831.m2118();
                        C0443.this.f2831.notify();
                    }
                }
            });
            synchronized (this.f2831) {
                m2248();
                try {
                    this.f2831.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        C0448 c0448 = new C0448(this.f2831);
        c0448.m2277(EnumC0446.NORMAL, this.f2827.m2279(), this.f2827.m2280());
        c0448.m2275(this.f2833);
        C0449 c0449 = new C0449(bitmap.getWidth(), bitmap.getHeight());
        c0449.m2284(c0448);
        c0448.m2272(bitmap, z);
        Bitmap m2283 = c0449.m2283();
        this.f2831.m2118();
        c0448.m2271();
        c0449.m2285();
        this.f2827.m2274(this.f2831);
        if (this.f2832 != null) {
            this.f2827.m2272(this.f2832, false);
        }
        m2248();
        return m2283;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2248() {
        if (this.f2828 == 0) {
            if (this.f2829 != null) {
                this.f2829.requestRender();
            }
        } else if (this.f2828 != 1 || this.f2830 == null) {
        } else {
            this.f2830.m2098();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2249(C0390 c0390) {
        this.f2831 = c0390;
        this.f2827.m2274(this.f2831);
        m2248();
    }
}
