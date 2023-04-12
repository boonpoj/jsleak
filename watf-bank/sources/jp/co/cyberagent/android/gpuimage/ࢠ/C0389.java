package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.֏  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0389 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2601;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private float f2602;

    public C0389() {
        this(1.0f);
    }

    public C0389(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform highp float exposure;\n \n void main()\n {\n     highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(textureColor.rgb * pow(2.0, exposure), textureColor.w);\n } ");
        this.f2602 = f;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo2102() {
        super.mo2102();
        this.f2601 = GLES20.glGetUniformLocation(m2106(), "exposure");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2103(float f) {
        this.f2602 = f;
        m2107(this.f2601, this.f2602);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void mo2104() {
        super.mo2104();
        m2103(this.f2602);
    }
}
