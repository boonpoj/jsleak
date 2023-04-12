package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ގ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0406 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2689;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private float f2690;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2691;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private float f2692;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f2693;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private float f2694;

    public C0406() {
        this(1.0f, 1.0f, 1.0f);
    }

    public C0406(float f, float f2, float f3) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "  varying highp vec2 textureCoordinate;\n  \n  uniform sampler2D inputImageTexture;\n  uniform highp float red;\n  uniform highp float green;\n  uniform highp float blue;\n  \n  void main()\n  {\n      highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n      \n      gl_FragColor = vec4(textureColor.r * red, textureColor.g * green, textureColor.b * blue, 1.0);\n  }\n");
        this.f2690 = f;
        this.f2692 = f2;
        this.f2694 = f3;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2689 = GLES20.glGetUniformLocation(m2106(), "red");
        this.f2691 = GLES20.glGetUniformLocation(m2106(), "green");
        this.f2693 = GLES20.glGetUniformLocation(m2106(), "blue");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2156(float f) {
        this.f2690 = f;
        m2107(this.f2689, this.f2690);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2156(this.f2690);
        m2157(this.f2692);
        m2158(this.f2694);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2157(float f) {
        this.f2692 = f;
        m2107(this.f2691, this.f2692);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m2158(float f) {
        this.f2694 = f;
        m2107(this.f2693, this.f2694);
    }
}
