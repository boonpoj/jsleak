package jp.co.cyberagent.android.gpuimage;

import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class TextureView$SurfaceTextureListenerC0387 extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final String f2587 = "ࢠ";

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static final C0438 f2588 = new C0438();

    /* renamed from: ֏  reason: contains not printable characters */
    private boolean f2589;

    /* renamed from: ؠ  reason: contains not printable characters */
    private List<TextureView.SurfaceTextureListener> f2590;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final WeakReference<TextureView$SurfaceTextureListenerC0387> f2591;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private C0436 f2592;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private InterfaceC0388 f2593;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f2594;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private InterfaceC0428 f2595;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private InterfaceC0430 f2596;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private InterfaceC0432 f2597;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private InterfaceC0440 f2598;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private int f2599;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private int f2600;

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$֏  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0388 {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ؠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private class C0391 extends C0422 {
        public C0391(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private abstract class AbstractC0420 implements InterfaceC0428 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        protected int[] f2741;

        public AbstractC0420(int[] iArr) {
            this.f2741 = m2182(iArr);
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private int[] m2182(int[] iArr) {
            if (TextureView$SurfaceTextureListenerC0387.this.f2600 != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        @Override // jp.co.cyberagent.android.gpuimage.TextureView$SurfaceTextureListenerC0387.InterfaceC0428
        /* renamed from: ࢠ  reason: contains not printable characters */
        public EGLConfig mo2183(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f2741, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f2741, eGLConfigArr, i, iArr)) {
                        EGLConfig mo2184 = mo2184(egl10, eGLDisplay, eGLConfigArr);
                        if (mo2184 != null) {
                            return mo2184;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        abstract EGLConfig mo2184(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private class C0422 extends AbstractC0420 {

        /* renamed from: ࢣ  reason: contains not printable characters */
        protected int f2749;

        /* renamed from: ࢤ  reason: contains not printable characters */
        protected int f2750;

        /* renamed from: ࢥ  reason: contains not printable characters */
        protected int f2751;

        /* renamed from: ࢦ  reason: contains not printable characters */
        protected int f2752;

        /* renamed from: ࢧ  reason: contains not printable characters */
        protected int f2753;

        /* renamed from: ࢨ  reason: contains not printable characters */
        protected int f2754;

        /* renamed from: ࢪ  reason: contains not printable characters */
        private int[] f2756;

        public C0422(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.f2756 = new int[1];
            this.f2749 = i;
            this.f2750 = i2;
            this.f2751 = i3;
            this.f2752 = i4;
            this.f2753 = i5;
            this.f2754 = i6;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private int m2187(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f2756) ? this.f2756[0] : i2;
        }

        @Override // jp.co.cyberagent.android.gpuimage.TextureView$SurfaceTextureListenerC0387.AbstractC0420
        /* renamed from: ࢠ */
        public EGLConfig mo2184(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int m2187 = m2187(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int m21872 = m2187(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (m2187 >= this.f2753 && m21872 >= this.f2754) {
                    int m21873 = m2187(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int m21874 = m2187(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int m21875 = m2187(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int m21876 = m2187(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (m21873 == this.f2749 && m21874 == this.f2750 && m21875 == this.f2751 && m21876 == this.f2752) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢣ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private class C0424 implements InterfaceC0430 {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private int f2761;

        private C0424() {
            this.f2761 = 12440;
        }

        @Override // jp.co.cyberagent.android.gpuimage.TextureView$SurfaceTextureListenerC0387.InterfaceC0430
        /* renamed from: ࢠ  reason: contains not printable characters */
        public EGLContext mo2190(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f2761, TextureView$SurfaceTextureListenerC0387.this.f2600, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TextureView$SurfaceTextureListenerC0387.this.f2600 == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // jp.co.cyberagent.android.gpuimage.TextureView$SurfaceTextureListenerC0387.InterfaceC0430
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void mo2191(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            C0434.m2207("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢤ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static class C0426 implements InterfaceC0432 {
        private C0426() {
        }

        @Override // jp.co.cyberagent.android.gpuimage.TextureView$SurfaceTextureListenerC0387.InterfaceC0432
        /* renamed from: ࢠ  reason: contains not printable characters */
        public EGLSurface mo2193(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e(TextureView$SurfaceTextureListenerC0387.f2587, "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // jp.co.cyberagent.android.gpuimage.TextureView$SurfaceTextureListenerC0387.InterfaceC0432
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void mo2194(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢥ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0428 {
        /* renamed from: ࢠ */
        EGLConfig mo2183(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢦ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0430 {
        /* renamed from: ࢠ */
        EGLContext mo2190(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        /* renamed from: ࢠ */
        void mo2191(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢧ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0432 {
        /* renamed from: ࢠ */
        EGLSurface mo2193(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        /* renamed from: ࢠ */
        void mo2194(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢨ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0434 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        EGL10 f2786;

        /* renamed from: ࢢ  reason: contains not printable characters */
        EGLDisplay f2787;

        /* renamed from: ࢣ  reason: contains not printable characters */
        EGLSurface f2788;

        /* renamed from: ࢤ  reason: contains not printable characters */
        EGLConfig f2789;

        /* renamed from: ࢥ  reason: contains not printable characters */
        EGLContext f2790;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private WeakReference<TextureView$SurfaceTextureListenerC0387> f2791;

        public C0434(WeakReference<TextureView$SurfaceTextureListenerC0387> weakReference) {
            this.f2791 = weakReference;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private void m2206(String str) {
            m2207(str, this.f2786.eglGetError());
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public static void m2207(String str, int i) {
            throw new RuntimeException(m2209(str, i));
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public static void m2208(String str, String str2, int i) {
            Log.w(str, m2209(str2, i));
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        public static String m2209(String str, int i) {
            return str + " failed: " + i;
        }

        /* renamed from: ࢧ  reason: contains not printable characters */
        private void m2210() {
            if (this.f2788 == null || this.f2788 == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f2786.eglMakeCurrent(this.f2787, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            TextureView$SurfaceTextureListenerC0387 textureView$SurfaceTextureListenerC0387 = this.f2791.get();
            if (textureView$SurfaceTextureListenerC0387 != null) {
                textureView$SurfaceTextureListenerC0387.f2597.mo2194(this.f2786, this.f2787, this.f2788);
            }
            this.f2788 = null;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public void m2211() {
            this.f2786 = (EGL10) EGLContext.getEGL();
            this.f2787 = this.f2786.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f2787 == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f2786.eglInitialize(this.f2787, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            TextureView$SurfaceTextureListenerC0387 textureView$SurfaceTextureListenerC0387 = this.f2791.get();
            if (textureView$SurfaceTextureListenerC0387 == null) {
                this.f2789 = null;
                this.f2790 = null;
            } else {
                this.f2789 = textureView$SurfaceTextureListenerC0387.f2595.mo2183(this.f2786, this.f2787);
                this.f2790 = textureView$SurfaceTextureListenerC0387.f2596.mo2190(this.f2786, this.f2787, this.f2789);
            }
            if (this.f2790 == null || this.f2790 == EGL10.EGL_NO_CONTEXT) {
                this.f2790 = null;
                m2206("createContext");
            }
            this.f2788 = null;
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        public boolean m2212() {
            if (this.f2786 != null) {
                if (this.f2787 != null) {
                    if (this.f2789 != null) {
                        m2210();
                        TextureView$SurfaceTextureListenerC0387 textureView$SurfaceTextureListenerC0387 = this.f2791.get();
                        this.f2788 = textureView$SurfaceTextureListenerC0387 != null ? textureView$SurfaceTextureListenerC0387.f2597.mo2193(this.f2786, this.f2787, this.f2789, textureView$SurfaceTextureListenerC0387.getSurfaceTexture()) : null;
                        if (this.f2788 == null || this.f2788 == EGL10.EGL_NO_SURFACE) {
                            if (this.f2786.eglGetError() == 12299) {
                                Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                            }
                            return false;
                        } else if (this.f2786.eglMakeCurrent(this.f2787, this.f2788, this.f2788, this.f2790)) {
                            return true;
                        } else {
                            m2208("EGLHelper", "eglMakeCurrent", this.f2786.eglGetError());
                            return false;
                        }
                    }
                    throw new RuntimeException("eglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        GL m2213() {
            GL gl = this.f2790.getGL();
            TextureView$SurfaceTextureListenerC0387 textureView$SurfaceTextureListenerC0387 = this.f2791.get();
            if (textureView$SurfaceTextureListenerC0387 != null) {
                if (textureView$SurfaceTextureListenerC0387.f2598 != null) {
                    gl = textureView$SurfaceTextureListenerC0387.f2598.m2241(gl);
                }
                if ((textureView$SurfaceTextureListenerC0387.f2599 & 3) != 0) {
                    return GLDebugHelper.wrap(gl, (textureView$SurfaceTextureListenerC0387.f2599 & 1) != 0 ? 1 : 0, (textureView$SurfaceTextureListenerC0387.f2599 & 2) != 0 ? new C0442() : null);
                }
                return gl;
            }
            return gl;
        }

        /* renamed from: ࢤ  reason: contains not printable characters */
        public int m2214() {
            if (this.f2786.eglSwapBuffers(this.f2787, this.f2788)) {
                return 12288;
            }
            return this.f2786.eglGetError();
        }

        /* renamed from: ࢥ  reason: contains not printable characters */
        public void m2215() {
            m2210();
        }

        /* renamed from: ࢦ  reason: contains not printable characters */
        public void m2216() {
            if (this.f2790 != null) {
                TextureView$SurfaceTextureListenerC0387 textureView$SurfaceTextureListenerC0387 = this.f2791.get();
                if (textureView$SurfaceTextureListenerC0387 != null) {
                    textureView$SurfaceTextureListenerC0387.f2596.mo2191(this.f2786, this.f2787, this.f2790);
                }
                this.f2790 = null;
            }
            if (this.f2787 != null) {
                this.f2786.eglTerminate(this.f2787);
                this.f2787 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢩ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0436 extends Thread {

        /* renamed from: ހ  reason: contains not printable characters */
        private boolean f2796;

        /* renamed from: ރ  reason: contains not printable characters */
        private C0434 f2799;

        /* renamed from: ބ  reason: contains not printable characters */
        private WeakReference<TextureView$SurfaceTextureListenerC0387> f2800;

        /* renamed from: ࢠ  reason: contains not printable characters */
        private boolean f2801;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private boolean f2802;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private boolean f2803;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private boolean f2804;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private boolean f2805;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private boolean f2806;

        /* renamed from: ࢧ  reason: contains not printable characters */
        private boolean f2807;

        /* renamed from: ࢨ  reason: contains not printable characters */
        private boolean f2808;

        /* renamed from: ࢩ  reason: contains not printable characters */
        private boolean f2809;

        /* renamed from: ࢪ  reason: contains not printable characters */
        private boolean f2810;

        /* renamed from: ށ  reason: contains not printable characters */
        private ArrayList<Runnable> f2797 = new ArrayList<>();

        /* renamed from: ނ  reason: contains not printable characters */
        private boolean f2798 = true;

        /* renamed from: ࢫ  reason: contains not printable characters */
        private int f2811 = 0;

        /* renamed from: ࢬ  reason: contains not printable characters */
        private int f2812 = 0;

        /* renamed from: ؠ  reason: contains not printable characters */
        private boolean f2795 = true;

        /* renamed from: ֏  reason: contains not printable characters */
        private int f2794 = 1;

        C0436(WeakReference<TextureView$SurfaceTextureListenerC0387> weakReference) {
            this.f2800 = weakReference;
        }

        /* renamed from: ࢨ  reason: contains not printable characters */
        private void m2219() {
            if (this.f2809) {
                this.f2809 = false;
                this.f2799.m2215();
            }
        }

        /* renamed from: ࢩ  reason: contains not printable characters */
        private void m2220() {
            if (this.f2808) {
                this.f2799.m2216();
                this.f2808 = false;
                TextureView$SurfaceTextureListenerC0387.f2588.m2240(this);
            }
        }

        /* renamed from: ࢪ  reason: contains not printable characters */
        private void m2221() throws InterruptedException {
            boolean z;
            boolean z2;
            boolean z3;
            this.f2799 = new C0434(this.f2800);
            this.f2808 = false;
            this.f2809 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            GL10 gl10 = null;
            int i = 0;
            int i2 = 0;
            Runnable runnable = null;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                try {
                    synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                        while (!this.f2801) {
                            if (this.f2797.isEmpty()) {
                                if (this.f2804 != this.f2803) {
                                    z = this.f2803;
                                    this.f2804 = this.f2803;
                                    TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                                } else {
                                    z = false;
                                }
                                if (this.f2810) {
                                    m2219();
                                    m2220();
                                    this.f2810 = false;
                                    z4 = true;
                                }
                                if (z5) {
                                    m2219();
                                    m2220();
                                    z5 = false;
                                }
                                if (z && this.f2809) {
                                    m2219();
                                }
                                if (z && this.f2808) {
                                    TextureView$SurfaceTextureListenerC0387 textureView$SurfaceTextureListenerC0387 = this.f2800.get();
                                    if (!(textureView$SurfaceTextureListenerC0387 == null ? false : textureView$SurfaceTextureListenerC0387.f2589) || TextureView$SurfaceTextureListenerC0387.f2588.m2237()) {
                                        m2220();
                                    }
                                }
                                if (z && TextureView$SurfaceTextureListenerC0387.f2588.m2238()) {
                                    this.f2799.m2216();
                                }
                                if (!this.f2805 && !this.f2807) {
                                    if (this.f2809) {
                                        m2219();
                                    }
                                    this.f2807 = true;
                                    this.f2806 = false;
                                    TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                                }
                                if (this.f2805 && this.f2807) {
                                    this.f2807 = false;
                                    TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                                }
                                if (z6) {
                                    this.f2796 = true;
                                    TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                                    z6 = false;
                                    z11 = false;
                                }
                                if (m2222()) {
                                    if (!this.f2808) {
                                        if (z4) {
                                            z4 = false;
                                        } else if (TextureView$SurfaceTextureListenerC0387.f2588.m2239(this)) {
                                            try {
                                                this.f2799.m2211();
                                                this.f2808 = true;
                                                TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                                                z7 = true;
                                            } catch (RuntimeException e) {
                                                TextureView$SurfaceTextureListenerC0387.f2588.m2240(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.f2808 || this.f2809) {
                                        z2 = z8;
                                    } else {
                                        this.f2809 = true;
                                        z2 = true;
                                        z9 = true;
                                        z10 = true;
                                    }
                                    if (this.f2809) {
                                        if (this.f2798) {
                                            i = this.f2811;
                                            i2 = this.f2812;
                                            z3 = false;
                                            this.f2798 = false;
                                            z2 = true;
                                            z10 = true;
                                            z11 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        this.f2795 = z3;
                                        TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                                        z8 = z2;
                                    } else {
                                        z8 = z2;
                                    }
                                }
                                TextureView$SurfaceTextureListenerC0387.f2588.wait();
                            } else {
                                runnable = this.f2797.remove(0);
                            }
                        }
                        synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                            m2219();
                            m2220();
                        }
                        return;
                    }
                    if (runnable != null) {
                        runnable.run();
                        runnable = null;
                    } else {
                        if (z8) {
                            if (this.f2799.m2212()) {
                                z8 = false;
                            } else {
                                synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                                    this.f2806 = true;
                                    TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                                }
                            }
                        }
                        if (z9) {
                            GL10 gl102 = (GL10) this.f2799.m2213();
                            TextureView$SurfaceTextureListenerC0387.f2588.m2235(gl102);
                            gl10 = gl102;
                            z9 = false;
                        }
                        if (z7) {
                            TextureView$SurfaceTextureListenerC0387 textureView$SurfaceTextureListenerC03872 = this.f2800.get();
                            if (textureView$SurfaceTextureListenerC03872 != null) {
                                textureView$SurfaceTextureListenerC03872.f2593.onSurfaceCreated(gl10, this.f2799.f2789);
                            }
                            z7 = false;
                        }
                        if (z10) {
                            TextureView$SurfaceTextureListenerC0387 textureView$SurfaceTextureListenerC03873 = this.f2800.get();
                            if (textureView$SurfaceTextureListenerC03873 != null) {
                                textureView$SurfaceTextureListenerC03873.f2593.onSurfaceChanged(gl10, i, i2);
                            }
                            z10 = false;
                        }
                        TextureView$SurfaceTextureListenerC0387 textureView$SurfaceTextureListenerC03874 = this.f2800.get();
                        if (textureView$SurfaceTextureListenerC03874 != null) {
                            textureView$SurfaceTextureListenerC03874.f2593.onDrawFrame(gl10);
                        }
                        int m2214 = this.f2799.m2214();
                        if (m2214 != 12288) {
                            if (m2214 != 12302) {
                                C0434.m2208("GLThread", "eglSwapBuffers", m2214);
                                synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                                    this.f2806 = true;
                                    TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                                }
                            } else {
                                z5 = true;
                            }
                        }
                        if (z11) {
                            z6 = true;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                        m2219();
                        m2220();
                        throw th;
                    }
                }
            }
        }

        /* renamed from: ࢫ  reason: contains not printable characters */
        private boolean m2222() {
            return !this.f2804 && this.f2805 && !this.f2806 && this.f2811 > 0 && this.f2812 > 0 && (this.f2795 || this.f2794 == 1);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                m2221();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                TextureView$SurfaceTextureListenerC0387.f2588.m2236(this);
                throw th;
            }
            TextureView$SurfaceTextureListenerC0387.f2588.m2236(this);
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public void m2223(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                this.f2794 = i;
                TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
            }
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public void m2224(int i, int i2) {
            synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                this.f2811 = i;
                this.f2812 = i2;
                this.f2798 = true;
                this.f2795 = true;
                this.f2796 = false;
                TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                while (!this.f2802 && !this.f2804 && !this.f2796 && m2225()) {
                    try {
                        TextureView$SurfaceTextureListenerC0387.f2588.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public boolean m2225() {
            return this.f2808 && this.f2809 && m2222();
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        public int m2226() {
            int i;
            synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                i = this.f2794;
            }
            return i;
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        public void m2227() {
            synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                this.f2795 = true;
                TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
            }
        }

        /* renamed from: ࢤ  reason: contains not printable characters */
        public void m2228() {
            synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                this.f2805 = true;
                TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                while (this.f2807 && !this.f2802) {
                    try {
                        TextureView$SurfaceTextureListenerC0387.f2588.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: ࢥ  reason: contains not printable characters */
        public void m2229() {
            synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                this.f2805 = false;
                TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                while (!this.f2807 && !this.f2802) {
                    try {
                        TextureView$SurfaceTextureListenerC0387.f2588.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: ࢦ  reason: contains not printable characters */
        public void m2230() {
            synchronized (TextureView$SurfaceTextureListenerC0387.f2588) {
                this.f2801 = true;
                TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
                while (!this.f2802) {
                    try {
                        TextureView$SurfaceTextureListenerC0387.f2588.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: ࢧ  reason: contains not printable characters */
        public void m2231() {
            this.f2810 = true;
            TextureView$SurfaceTextureListenerC0387.f2588.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢪ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0438 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private static String f2817 = "GLThreadManager";

        /* renamed from: ࢢ  reason: contains not printable characters */
        private boolean f2818;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private int f2819;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private boolean f2820;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private boolean f2821;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private boolean f2822;

        /* renamed from: ࢧ  reason: contains not printable characters */
        private C0436 f2823;

        private C0438() {
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        private void m2234() {
            if (this.f2818) {
                return;
            }
            this.f2818 = true;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public synchronized void m2235(GL10 gl10) {
            if (!this.f2820) {
                m2234();
                String glGetString = gl10.glGetString(7937);
                if (this.f2819 < 131072) {
                    this.f2821 = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.f2822 = !this.f2821;
                this.f2820 = true;
            }
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public synchronized void m2236(C0436 c0436) {
            c0436.f2802 = true;
            if (this.f2823 == c0436) {
                this.f2823 = null;
            }
            notifyAll();
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public synchronized boolean m2237() {
            return this.f2822;
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        public synchronized boolean m2238() {
            m2234();
            return !this.f2821;
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        public boolean m2239(C0436 c0436) {
            if (this.f2823 == c0436 || this.f2823 == null) {
                this.f2823 = c0436;
                notifyAll();
                return true;
            }
            m2234();
            if (this.f2821) {
                return true;
            }
            if (this.f2823 != null) {
                this.f2823.m2231();
                return false;
            }
            return false;
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        public void m2240(C0436 c0436) {
            if (this.f2823 == c0436) {
                this.f2823 = null;
            }
            notifyAll();
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢫ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0440 {
        /* renamed from: ࢠ  reason: contains not printable characters */
        GL m2241(GL gl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ$ࢬ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0442 extends Writer {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private StringBuilder f2825 = new StringBuilder();

        C0442() {
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private void m2243() {
            if (this.f2825.length() > 0) {
                Log.v("GLTextureView", this.f2825.toString());
                this.f2825.delete(0, this.f2825.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            m2243();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            m2243();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    m2243();
                } else {
                    this.f2825.append(c);
                }
            }
        }
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m2093() {
        if (this.f2592 != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f2592 != null) {
                this.f2592.m2230();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.f2599;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f2589;
    }

    public int getRenderMode() {
        return this.f2592.m2226();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2594 && this.f2593 != null) {
            int m2226 = this.f2592 != null ? this.f2592.m2226() : 1;
            this.f2592 = new C0436(this.f2591);
            if (m2226 != 1) {
                this.f2592.m2223(m2226);
            }
            this.f2592.start();
        }
        this.f2594 = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.f2592 != null) {
            this.f2592.m2230();
        }
        this.f2594 = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m2100(getSurfaceTexture(), 0, i3 - i, i4 - i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        m2099(surfaceTexture);
        m2100(surfaceTexture, 0, i, i2);
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.f2590) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        m2101(surfaceTexture);
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.f2590) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        m2100(surfaceTexture, 0, i, i2);
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.f2590) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        m2098();
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.f2590) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void setDebugFlags(int i) {
        this.f2599 = i;
    }

    public void setEGLConfigChooser(InterfaceC0428 interfaceC0428) {
        m2093();
        this.f2595 = interfaceC0428;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new C0391(z));
    }

    public void setEGLContextClientVersion(int i) {
        m2093();
        this.f2600 = i;
    }

    public void setEGLContextFactory(InterfaceC0430 interfaceC0430) {
        m2093();
        this.f2596 = interfaceC0430;
    }

    public void setEGLWindowSurfaceFactory(InterfaceC0432 interfaceC0432) {
        m2093();
        this.f2597 = interfaceC0432;
    }

    public void setGLWrapper(InterfaceC0440 interfaceC0440) {
        this.f2598 = interfaceC0440;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.f2589 = z;
    }

    public void setRenderMode(int i) {
        this.f2592.m2223(i);
    }

    public void setRenderer(InterfaceC0388 interfaceC0388) {
        m2093();
        if (this.f2595 == null) {
            this.f2595 = new C0391(true);
        }
        if (this.f2596 == null) {
            this.f2596 = new C0424();
        }
        if (this.f2597 == null) {
            this.f2597 = new C0426();
        }
        this.f2593 = interfaceC0388;
        this.f2592 = new C0436(this.f2591);
        this.f2592.start();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2098() {
        this.f2592.m2227();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2099(SurfaceTexture surfaceTexture) {
        this.f2592.m2228();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2100(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        this.f2592.m2224(i2, i3);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2101(SurfaceTexture surfaceTexture) {
        this.f2592.m2229();
    }
}
