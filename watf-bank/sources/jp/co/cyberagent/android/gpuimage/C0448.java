package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.C0443;
import jp.co.cyberagent.android.gpuimage.TextureView$SurfaceTextureListenerC0387;
import jp.co.cyberagent.android.gpuimage.ࢠ.C0390;
import jp.co.cyberagent.android.gpuimage.ࢢ.C0444;
import jp.co.cyberagent.android.gpuimage.ࢢ.C0447;
import jp.co.cyberagent.android.gpuimage.ࢢ.EnumC0446;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0448 implements Camera.PreviewCallback, GLSurfaceView.Renderer, TextureView$SurfaceTextureListenerC0387.InterfaceC0388 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static final float[] f2848 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: ֏  reason: contains not printable characters */
    private int f2849;

    /* renamed from: ށ  reason: contains not printable characters */
    private EnumC0446 f2852;

    /* renamed from: ނ  reason: contains not printable characters */
    private boolean f2853;

    /* renamed from: ރ  reason: contains not printable characters */
    private boolean f2854;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private C0390 f2860;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final FloatBuffer f2864;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private IntBuffer f2865;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private int f2866;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private int f2867;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private int f2868;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private int f2869;

    /* renamed from: ࢢ  reason: contains not printable characters */
    public final Object f2859 = new Object();

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2861 = -1;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private SurfaceTexture f2862 = null;

    /* renamed from: ބ  reason: contains not printable characters */
    private C0443.EnumC0445 f2855 = C0443.EnumC0445.CENTER_CROP;

    /* renamed from: ޅ  reason: contains not printable characters */
    private float f2856 = 0.0f;

    /* renamed from: ކ  reason: contains not printable characters */
    private float f2857 = 0.0f;

    /* renamed from: އ  reason: contains not printable characters */
    private float f2858 = 0.0f;

    /* renamed from: ؠ  reason: contains not printable characters */
    private final Queue<Runnable> f2850 = new LinkedList();

    /* renamed from: ހ  reason: contains not printable characters */
    private final Queue<Runnable> f2851 = new LinkedList();

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final FloatBuffer f2863 = ByteBuffer.allocateDirect(f2848.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    public C0448(C0390 c0390) {
        this.f2860 = c0390;
        this.f2863.put(f2848).position(0);
        this.f2864 = ByteBuffer.allocateDirect(C0447.f2843.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        m2277(EnumC0446.NORMAL, false, false);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private float m2256(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m2260(Queue<Runnable> queue) {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m2266() {
        float[] fArr;
        float f = this.f2866;
        float f2 = this.f2867;
        if (this.f2852 == EnumC0446.ROTATION_270 || this.f2852 == EnumC0446.ROTATION_90) {
            f = this.f2867;
            f2 = this.f2866;
        }
        float max = Math.max(f / this.f2868, f2 / this.f2869);
        float round = Math.round(this.f2868 * max) / f;
        float round2 = Math.round(this.f2869 * max) / f2;
        float[] fArr2 = f2848;
        float[] m2255 = C0447.m2255(this.f2852, this.f2853, this.f2854);
        if (this.f2855 == C0443.EnumC0445.CENTER_CROP) {
            float f3 = (1.0f - (1.0f / round)) / 2.0f;
            float f4 = (1.0f - (1.0f / round2)) / 2.0f;
            fArr = new float[]{m2256(m2255[0], f3), m2256(m2255[1], f4), m2256(m2255[2], f3), m2256(m2255[3], f4), m2256(m2255[4], f3), m2256(m2255[5], f4), m2256(m2255[6], f3), m2256(m2255[7], f4)};
        } else {
            fArr2 = new float[]{f2848[0] / round2, f2848[1] / round, f2848[2] / round2, f2848[3] / round, f2848[4] / round2, f2848[5] / round, f2848[6] / round2, f2848[7] / round};
            fArr = m2255;
        }
        this.f2863.clear();
        this.f2863.put(fArr2).position(0);
        this.f2864.clear();
        this.f2864.put(fArr).position(0);
    }

    @Override // android.opengl.GLSurfaceView.Renderer, jp.co.cyberagent.android.gpuimage.TextureView$SurfaceTextureListenerC0387.InterfaceC0388
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16640);
        m2260(this.f2850);
        this.f2860.mo2110(this.f2861, this.f2863, this.f2864);
        m2260(this.f2851);
        if (this.f2862 != null) {
            this.f2862.updateTexImage();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        m2278(bArr, previewSize.width, previewSize.height);
    }

    @Override // android.opengl.GLSurfaceView.Renderer, jp.co.cyberagent.android.gpuimage.TextureView$SurfaceTextureListenerC0387.InterfaceC0388
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.f2866 = i;
        this.f2867 = i2;
        GLES20.glViewport(0, 0, i, i2);
        GLES20.glUseProgram(this.f2860.m2106());
        this.f2860.mo2108(i, i2);
        m2266();
        synchronized (this.f2859) {
            this.f2859.notifyAll();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer, jp.co.cyberagent.android.gpuimage.TextureView$SurfaceTextureListenerC0387.InterfaceC0388
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(this.f2856, this.f2857, this.f2858, 1.0f);
        GLES20.glDisable(2929);
        this.f2860.m2117();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2271() {
        m2273(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢣ.3
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glDeleteTextures(1, new int[]{C0448.this.f2861}, 0);
                C0448.this.f2861 = -1;
            }
        });
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2272(final Bitmap bitmap, final boolean z) {
        if (bitmap == null) {
            return;
        }
        m2273(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢣ.4
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (bitmap.getWidth() % 2 == 1) {
                    bitmap2 = Bitmap.createBitmap(bitmap.getWidth() + 1, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmap2);
                    canvas.drawARGB(0, 0, 0, 0);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    C0448.this.f2849 = 1;
                } else {
                    C0448.this.f2849 = 0;
                    bitmap2 = null;
                }
                C0448.this.f2861 = C0444.m2250(bitmap2 != null ? bitmap2 : bitmap, C0448.this.f2861, z);
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                C0448.this.f2868 = bitmap.getWidth();
                C0448.this.f2869 = bitmap.getHeight();
                C0448.this.m2266();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2273(Runnable runnable) {
        synchronized (this.f2850) {
            this.f2850.add(runnable);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2274(final C0390 c0390) {
        m2273(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢣ.2
            @Override // java.lang.Runnable
            public void run() {
                C0390 c03902 = C0448.this.f2860;
                C0448.this.f2860 = c0390;
                if (c03902 != null) {
                    c03902.m2118();
                }
                C0448.this.f2860.m2117();
                GLES20.glUseProgram(C0448.this.f2860.m2106());
                C0448.this.f2860.mo2108(C0448.this.f2866, C0448.this.f2867);
            }
        });
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2275(C0443.EnumC0445 enumC0445) {
        this.f2855 = enumC0445;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2276(EnumC0446 enumC0446) {
        this.f2852 = enumC0446;
        m2266();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2277(EnumC0446 enumC0446, boolean z, boolean z2) {
        this.f2853 = z;
        this.f2854 = z2;
        m2276(enumC0446);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2278(final byte[] bArr, final int i, final int i2) {
        if (this.f2865 == null) {
            this.f2865 = IntBuffer.allocate(i * i2);
        }
        if (this.f2850.isEmpty()) {
            m2273(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢣ.1
                @Override // java.lang.Runnable
                public void run() {
                    GPUImageNativeLibrary.YUVtoRBGA(bArr, i, i2, C0448.this.f2865.array());
                    C0448.this.f2861 = C0444.m2253(C0448.this.f2865, i, i2, C0448.this.f2861);
                    if (C0448.this.f2868 != i) {
                        C0448.this.f2868 = i;
                        C0448.this.f2869 = i2;
                        C0448.this.m2266();
                    }
                }
            });
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m2279() {
        return this.f2853;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public boolean m2280() {
        return this.f2854;
    }
}
