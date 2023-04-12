package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ޕ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0413 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2715;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2716;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private float[] f2717;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private float[] f2718;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f2719;

    public C0413() {
        super("attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform mat4 transformMatrix;\n uniform mat4 orthographicMatrix;\n \n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = transformMatrix * vec4(position.xyz, 1.0) * orthographicMatrix;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        this.f2717 = new float[16];
        Matrix.orthoM(this.f2717, 0, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f);
        this.f2718 = new float[16];
        Matrix.setIdentityM(this.f2718, 0);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2715 = GLES20.glGetUniformLocation(m2106(), "transformMatrix");
        this.f2716 = GLES20.glGetUniformLocation(m2106(), "orthographicMatrix");
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2108(int i, int i2) {
        super.mo2108(i, i2);
        if (this.f2719) {
            return;
        }
        float f = i2;
        float f2 = i;
        Matrix.orthoM(this.f2717, 0, -1.0f, 1.0f, ((-1.0f) * f) / f2, (f * 1.0f) / f2, -1.0f, 1.0f);
        m2116(this.f2716, this.f2717);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2110(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (!this.f2719) {
            floatBuffer.position(0);
            floatBuffer.get(r0);
            float f = m2124() / m2123();
            float[] fArr = {0.0f, fArr[1] * f, 0.0f, fArr[3] * f, 0.0f, fArr[5] * f, 0.0f, fArr[7] * f};
            floatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            floatBuffer.put(fArr).position(0);
        }
        super.mo2110(i, floatBuffer, floatBuffer2);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2169(float[] fArr) {
        this.f2718 = fArr;
        m2116(this.f2715, fArr);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2116(this.f2715, this.f2718);
        m2116(this.f2716, this.f2717);
    }
}
