package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢥ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0427 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2764;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private float f2765;

    public C0427() {
        this(0.0f);
    }

    public C0427(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float brightness;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4((textureColor.rgb + vec3(brightness)), textureColor.w);\n }");
        this.f2765 = f;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2764 = GLES20.glGetUniformLocation(m2106(), "brightness");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2195(float f) {
        this.f2765 = f;
        m2107(this.f2764, this.f2765);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2195(this.f2765);
    }
}
