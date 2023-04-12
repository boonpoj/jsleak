package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ށ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0393 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2642;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private float f2643;

    public C0393() {
        this(1.2f);
    }

    public C0393(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float gamma;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);\n }");
        this.f2643 = f;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2642 = GLES20.glGetUniformLocation(m2106(), "gamma");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2130(float f) {
        this.f2643 = f;
        m2107(this.f2642, this.f2643);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2130(this.f2643);
    }
}
