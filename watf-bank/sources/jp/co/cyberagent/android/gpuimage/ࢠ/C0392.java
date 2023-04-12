package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.C0448;
import jp.co.cyberagent.android.gpuimage.ࢢ.C0447;
import jp.co.cyberagent.android.gpuimage.ࢢ.EnumC0446;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ހ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0392 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private List<C0390> f2635;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private List<C0390> f2636;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int[] f2637;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int[] f2638;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final FloatBuffer f2639;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final FloatBuffer f2640;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final FloatBuffer f2641;

    public C0392() {
        this(null);
    }

    public C0392(List<C0390> list) {
        this.f2635 = list;
        if (this.f2635 == null) {
            this.f2635 = new ArrayList();
        } else {
            m2128();
        }
        this.f2639 = ByteBuffer.allocateDirect(C0448.f2848.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2639.put(C0448.f2848).position(0);
        this.f2640 = ByteBuffer.allocateDirect(C0447.f2843.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2640.put(C0447.f2843).position(0);
        float[] m2255 = C0447.m2255(EnumC0446.NORMAL, false, true);
        this.f2641 = ByteBuffer.allocateDirect(m2255.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2641.put(m2255).position(0);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m2125() {
        if (this.f2638 != null) {
            GLES20.glDeleteTextures(this.f2638.length, this.f2638, 0);
            this.f2638 = null;
        }
        if (this.f2637 != null) {
            GLES20.glDeleteFramebuffers(this.f2637.length, this.f2637, 0);
            this.f2637 = null;
        }
    }

    /* renamed from: ؠ  reason: contains not printable characters */
    public List<C0390> m2126() {
        return this.f2635;
    }

    /* renamed from: ހ  reason: contains not printable characters */
    public List<C0390> m2127() {
        return this.f2636;
    }

    /* renamed from: ށ  reason: contains not printable characters */
    public void m2128() {
        if (this.f2635 == null) {
            return;
        }
        if (this.f2636 == null) {
            this.f2636 = new ArrayList();
        } else {
            this.f2636.clear();
        }
        for (C0390 c0390 : this.f2635) {
            if (c0390 instanceof C0392) {
                C0392 c0392 = (C0392) c0390;
                c0392.m2128();
                List<C0390> m2127 = c0392.m2127();
                if (m2127 != null && !m2127.isEmpty()) {
                    this.f2636.addAll(m2127);
                }
            } else {
                this.f2636.add(c0390);
            }
        }
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        for (C0390 c0390 : this.f2635) {
            c0390.m2117();
        }
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2108(int i, int i2) {
        super.mo2108(i, i2);
        if (this.f2637 != null) {
            m2125();
        }
        int size = this.f2635.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f2635.get(i3).mo2108(i, i2);
        }
        if (this.f2636 == null || this.f2636.size() <= 0) {
            return;
        }
        int i4 = 1;
        int size2 = this.f2636.size() - 1;
        this.f2637 = new int[size2];
        this.f2638 = new int[size2];
        int i5 = 0;
        while (i5 < size2) {
            GLES20.glGenFramebuffers(i4, this.f2637, i5);
            GLES20.glGenTextures(i4, this.f2638, i5);
            GLES20.glBindTexture(3553, this.f2638[i5]);
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.f2637[i5]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f2638[i5], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            i5++;
            i4 = 1;
        }
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    @SuppressLint({"WrongCall"})
    /* renamed from: ࢠ */
    public void mo2110(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        FloatBuffer floatBuffer3;
        FloatBuffer floatBuffer4;
        m2121();
        if (!m2122() || this.f2637 == null || this.f2638 == null || this.f2636 == null) {
            return;
        }
        int size = this.f2636.size();
        int i2 = i;
        int i3 = 0;
        while (i3 < size) {
            C0390 c0390 = this.f2636.get(i3);
            int i4 = size - 1;
            boolean z = i3 < i4;
            if (z) {
                GLES20.glBindFramebuffer(36160, this.f2637[i3]);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            }
            if (i3 == 0) {
                c0390.mo2110(i2, floatBuffer, floatBuffer2);
            } else {
                if (i3 == i4) {
                    floatBuffer3 = this.f2639;
                    if (size % 2 == 0) {
                        floatBuffer4 = this.f2641;
                        c0390.mo2110(i2, floatBuffer3, floatBuffer4);
                    }
                } else {
                    floatBuffer3 = this.f2639;
                }
                floatBuffer4 = this.f2640;
                c0390.mo2110(i2, floatBuffer3, floatBuffer4);
            }
            if (z) {
                GLES20.glBindFramebuffer(36160, 0);
                i2 = this.f2638[i3];
            }
            i3++;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2129(C0390 c0390) {
        if (c0390 == null) {
            return;
        }
        this.f2635.add(c0390);
        m2128();
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢧ */
    public void mo2119() {
        m2125();
        for (C0390 c0390 : this.f2635) {
            c0390.m2118();
        }
        super.mo2119();
    }
}
