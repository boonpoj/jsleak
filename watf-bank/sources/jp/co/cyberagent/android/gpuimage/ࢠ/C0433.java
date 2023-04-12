package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢨ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0433 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private float f2782;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private float[] f2783;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2784;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2785;

    public C0433(float f, float[] fArr) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform lowp mat4 colorMatrix;\nuniform lowp float intensity;\n\nvoid main()\n{\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec4 outputColor = textureColor * colorMatrix;\n    \n    gl_FragColor = (intensity * outputColor) + ((1.0 - intensity) * textureColor);\n}");
        this.f2782 = f;
        this.f2783 = fArr;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2784 = GLES20.glGetUniformLocation(m2106(), "colorMatrix");
        this.f2785 = GLES20.glGetUniformLocation(m2106(), "intensity");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2204(float f) {
        this.f2782 = f;
        m2107(this.f2785, f);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2205(float[] fArr) {
        this.f2783 = fArr;
        m2116(this.f2784, fArr);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2204(this.f2782);
        m2205(this.f2783);
    }
}
