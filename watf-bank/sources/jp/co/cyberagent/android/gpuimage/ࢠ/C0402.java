package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ފ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0402 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2677;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private float f2678;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2679;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private float[] f2680;

    public C0402() {
        this(1.0f, new float[]{0.6f, 0.45f, 0.3f, 1.0f});
    }

    public C0402(float f, float[] fArr) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", " precision lowp float;\n  \n  varying highp vec2 textureCoordinate;\n  \n  uniform sampler2D inputImageTexture;\n  uniform float intensity;\n  uniform vec3 filterColor;\n  \n  const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n  \n  void main()\n  {\n \t//desat, then apply overlay blend\n \tlowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n \tfloat luminance = dot(textureColor.rgb, luminanceWeighting);\n \t\n \tlowp vec4 desat = vec4(vec3(luminance), 1.0);\n \t\n \t//overlay\n \tlowp vec4 outputColor = vec4(\n                                  (desat.r < 0.5 ? (2.0 * desat.r * filterColor.r) : (1.0 - 2.0 * (1.0 - desat.r) * (1.0 - filterColor.r))),\n                                  (desat.g < 0.5 ? (2.0 * desat.g * filterColor.g) : (1.0 - 2.0 * (1.0 - desat.g) * (1.0 - filterColor.g))),\n                                  (desat.b < 0.5 ? (2.0 * desat.b * filterColor.b) : (1.0 - 2.0 * (1.0 - desat.b) * (1.0 - filterColor.b))),\n                                  1.0\n                                  );\n \t\n \t//which is better, or are they equal?\n \tgl_FragColor = vec4( mix(textureColor.rgb, outputColor.rgb, intensity), textureColor.a);\n  }");
        this.f2678 = f;
        this.f2680 = fArr;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2677 = GLES20.glGetUniformLocation(m2106(), "intensity");
        this.f2679 = GLES20.glGetUniformLocation(m2106(), "filterColor");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2150(float f) {
        this.f2678 = f;
        m2107(this.f2677, this.f2678);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2151(float f, float f2, float f3) {
        m2114(this.f2679, new float[]{f, f2, f3});
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2152(float[] fArr) {
        this.f2680 = fArr;
        m2151(this.f2680[0], this.f2680[1], this.f2680[2]);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2150(1.0f);
        m2152(new float[]{0.6f, 0.45f, 0.3f, 1.0f});
    }
}
