package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢤ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0449 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private GLSurfaceView.Renderer f2880;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2881;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2882;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Bitmap f2883;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private EGL10 f2884;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private EGLDisplay f2885;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private EGLConfig[] f2886;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private EGLConfig f2887;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private EGLContext f2888;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private EGLSurface f2889;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private GL10 f2890;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private String f2891;

    public C0449(int i, int i2) {
        this.f2881 = i;
        this.f2882 = i2;
        int[] iArr = {12375, this.f2881, 12374, this.f2882, 12344};
        this.f2884 = (EGL10) EGLContext.getEGL();
        this.f2885 = this.f2884.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f2884.eglInitialize(this.f2885, new int[2]);
        this.f2887 = m2281();
        this.f2888 = this.f2884.eglCreateContext(this.f2885, this.f2887, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        this.f2889 = this.f2884.eglCreatePbufferSurface(this.f2885, this.f2887, iArr);
        this.f2884.eglMakeCurrent(this.f2885, this.f2889, this.f2889, this.f2888);
        this.f2890 = (GL10) this.f2888.getGL();
        this.f2891 = Thread.currentThread().getName();
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private EGLConfig m2281() {
        int[] iArr = {12325, 0, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        int[] iArr2 = new int[1];
        this.f2884.eglChooseConfig(this.f2885, iArr, null, 0, iArr2);
        int i = iArr2[0];
        this.f2886 = new EGLConfig[i];
        this.f2884.eglChooseConfig(this.f2885, iArr, this.f2886, i, iArr2);
        return this.f2886[0];
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m2282() {
        this.f2883 = Bitmap.createBitmap(this.f2881, this.f2882, Bitmap.Config.ARGB_8888);
        GPUImageNativeLibrary.adjustBitmap(this.f2883);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public Bitmap m2283() {
        String str;
        String str2;
        if (this.f2880 == null) {
            str = "PixelBuffer";
            str2 = "getBitmap: Renderer was not set.";
        } else if (Thread.currentThread().getName().equals(this.f2891)) {
            this.f2880.onDrawFrame(this.f2890);
            this.f2880.onDrawFrame(this.f2890);
            m2282();
            return this.f2883;
        } else {
            str = "PixelBuffer";
            str2 = "getBitmap: This thread does not own the OpenGL context.";
        }
        Log.e(str, str2);
        return null;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2284(GLSurfaceView.Renderer renderer) {
        this.f2880 = renderer;
        if (!Thread.currentThread().getName().equals(this.f2891)) {
            Log.e("PixelBuffer", "setRenderer: This thread does not own the OpenGL context.");
            return;
        }
        this.f2880.onSurfaceCreated(this.f2890, this.f2887);
        this.f2880.onSurfaceChanged(this.f2890, this.f2881, this.f2882);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2285() {
        this.f2880.onDrawFrame(this.f2890);
        this.f2880.onDrawFrame(this.f2890);
        this.f2884.eglMakeCurrent(this.f2885, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.f2884.eglDestroySurface(this.f2885, this.f2889);
        this.f2884.eglDestroyContext(this.f2885, this.f2888);
        this.f2884.eglTerminate(this.f2885);
    }
}
