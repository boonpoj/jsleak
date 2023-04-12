package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import jp.co.cyberagent.android.gpuimage.ࢢ.C0444;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ؠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final LinkedList<Runnable> f2603;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f2604;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final String f2605;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2606;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f2607;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f2608;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private int f2609;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private int f2610;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private int f2611;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private boolean f2612;

    public C0390() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public C0390(String str, String str2) {
        this.f2603 = new LinkedList<>();
        this.f2604 = str;
        this.f2605 = str2;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final void m2105() {
        mo2102();
        mo2104();
    }

    /* renamed from: ֏  reason: contains not printable characters */
    public int m2106() {
        return this.f2606;
    }

    /* renamed from: ࢠ */
    public void mo2102() {
        this.f2606 = C0444.m2252(this.f2604, this.f2605);
        this.f2607 = GLES20.glGetAttribLocation(this.f2606, "position");
        this.f2608 = GLES20.glGetUniformLocation(this.f2606, "inputImageTexture");
        this.f2609 = GLES20.glGetAttribLocation(this.f2606, "inputTextureCoordinate");
        this.f2612 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2107(final int i, final float f) {
        m2112(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢠ.ؠ.2
            @Override // java.lang.Runnable
            public void run() {
                C0390.this.m2117();
                GLES20.glUniform1f(i, f);
            }
        });
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo2108(int i, int i2) {
        this.f2610 = i;
        this.f2611 = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2109(final int i, final PointF pointF) {
        m2112(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢠ.ؠ.5
            @Override // java.lang.Runnable
            public void run() {
                C0390.this.m2117();
                GLES20.glUniform2fv(i, 1, new float[]{pointF.x, pointF.y}, 0);
            }
        });
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo2110(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.f2606);
        m2121();
        if (this.f2612) {
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.f2607, 2, 5126, false, 0, (Buffer) floatBuffer);
            GLES20.glEnableVertexAttribArray(this.f2607);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.f2609, 2, 5126, false, 0, (Buffer) floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.f2609);
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i);
                GLES20.glUniform1i(this.f2608, 0);
            }
            mo2120();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.f2607);
            GLES20.glDisableVertexAttribArray(this.f2609);
            GLES20.glBindTexture(3553, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2111(final int i, final float[] fArr) {
        m2112(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢠ.ؠ.3
            @Override // java.lang.Runnable
            public void run() {
                C0390.this.m2117();
                GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2112(Runnable runnable) {
        synchronized (this.f2603) {
            this.f2603.addLast(runnable);
        }
    }

    /* renamed from: ࢢ */
    public void mo2104() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2113(final int i, final int i2) {
        m2112(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢠ.ؠ.1
            @Override // java.lang.Runnable
            public void run() {
                C0390.this.m2117();
                GLES20.glUniform1i(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2114(final int i, final float[] fArr) {
        m2112(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢠ.ؠ.4
            @Override // java.lang.Runnable
            public void run() {
                C0390.this.m2117();
                GLES20.glUniform3fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m2115(final int i, final float[] fArr) {
        m2112(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢠ.ؠ.6
            @Override // java.lang.Runnable
            public void run() {
                C0390.this.m2117();
                GLES20.glUniformMatrix3fv(i, 1, false, fArr, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m2116(final int i, final float[] fArr) {
        m2112(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢠ.ؠ.7
            @Override // java.lang.Runnable
            public void run() {
                C0390.this.m2117();
                GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
            }
        });
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    public void m2117() {
        if (this.f2612) {
            return;
        }
        m2105();
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    public final void m2118() {
        this.f2612 = false;
        GLES20.glDeleteProgram(this.f2606);
        mo2119();
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    public void mo2119() {
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    protected void mo2120() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢩ  reason: contains not printable characters */
    public void m2121() {
        while (!this.f2603.isEmpty()) {
            this.f2603.removeFirst().run();
        }
    }

    /* renamed from: ࢪ  reason: contains not printable characters */
    public boolean m2122() {
        return this.f2612;
    }

    /* renamed from: ࢫ  reason: contains not printable characters */
    public int m2123() {
        return this.f2610;
    }

    /* renamed from: ࢬ  reason: contains not printable characters */
    public int m2124() {
        return this.f2611;
    }
}
