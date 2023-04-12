package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ދ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0403 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2681;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private float f2682;

    public C0403() {
        this(1.0f);
    }

    public C0403(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "  varying highp vec2 textureCoordinate;\n  \n  uniform sampler2D inputImageTexture;\n  uniform lowp float opacity;\n  \n  void main()\n  {\n      lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n      \n      gl_FragColor = vec4(textureColor.rgb, textureColor.a * opacity);\n  }\n");
        this.f2682 = f;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2681 = GLES20.glGetUniformLocation(m2106(), "opacity");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2153(float f) {
        this.f2682 = f;
        m2107(this.f2681, this.f2682);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2153(this.f2682);
    }
}
