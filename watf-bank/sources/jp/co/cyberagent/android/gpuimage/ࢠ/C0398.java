package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ކ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0398 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2658;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private float f2659;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2660;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private float f2661;

    public C0398() {
        this(0.0f, 1.0f);
    }

    public C0398(float f, float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", " uniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n  \n uniform lowp float shadows;\n uniform lowp float highlights;\n \n const mediump vec3 luminanceWeighting = vec3(0.3, 0.3, 0.3);\n \n void main()\n {\n \tlowp vec4 source = texture2D(inputImageTexture, textureCoordinate);\n \tmediump float luminance = dot(source.rgb, luminanceWeighting);\n \n \tmediump float shadow = clamp((pow(luminance, 1.0/(shadows+1.0)) + (-0.76)*pow(luminance, 2.0/(shadows+1.0))) - luminance, 0.0, 1.0);\n \tmediump float highlight = clamp((1.0 - (pow(1.0-luminance, 1.0/(2.0-highlights)) + (-0.8)*pow(1.0-luminance, 2.0/(2.0-highlights)))) - luminance, -1.0, 0.0);\n \tlowp vec3 result = vec3(0.0, 0.0, 0.0) + ((luminance + shadow + highlight) - 0.0) * ((source.rgb - vec3(0.0, 0.0, 0.0))/(luminance - 0.0));\n \n \tgl_FragColor = vec4(result.rgb, source.a);\n }");
        this.f2661 = f2;
        this.f2659 = f;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2660 = GLES20.glGetUniformLocation(m2106(), "highlights");
        this.f2658 = GLES20.glGetUniformLocation(m2106(), "shadows");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2140(float f) {
        this.f2661 = f;
        m2107(this.f2660, this.f2661);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2140(this.f2661);
        m2141(this.f2659);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2141(float f) {
        this.f2659 = f;
        m2107(this.f2658, this.f2659);
    }
}
