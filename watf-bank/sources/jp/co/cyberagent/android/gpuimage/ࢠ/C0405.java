package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ލ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0405 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2687;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2688;

    public C0405() {
        this(10);
    }

    public C0405(int i) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform highp float colorLevels;\n\nvoid main()\n{\n   highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n   \n   gl_FragColor = floor((textureColor * colorLevels) + vec4(0.5)) / colorLevels;\n}");
        this.f2688 = i;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2687 = GLES20.glGetUniformLocation(m2106(), "colorLevels");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2155(int i) {
        this.f2688 = i;
        m2107(this.f2687, i);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2155(this.f2688);
    }
}
