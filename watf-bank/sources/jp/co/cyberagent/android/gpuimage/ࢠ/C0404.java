package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ތ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0404 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2683;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2684;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private float f2685;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2686;

    public C0404() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform float imageWidthFactor;\nuniform float imageHeightFactor;\nuniform sampler2D inputImageTexture;\nuniform float pixel;\nvoid main()\n{\n  vec2 uv  = textureCoordinate.xy;\n  float dx = pixel * imageWidthFactor;\n  float dy = pixel * imageHeightFactor;\n  vec2 coord = vec2(dx * floor(uv.x / dx), dy * floor(uv.y / dy));\n  vec3 tc = texture2D(inputImageTexture, coord).xyz;\n  gl_FragColor = vec4(tc, 1.0);\n}");
        this.f2685 = 1.0f;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2683 = GLES20.glGetUniformLocation(m2106(), "imageWidthFactor");
        this.f2684 = GLES20.glGetUniformLocation(m2106(), "imageHeightFactor");
        this.f2686 = GLES20.glGetUniformLocation(m2106(), "pixel");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2154(float f) {
        this.f2685 = f;
        m2107(this.f2686, this.f2685);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2108(int i, int i2) {
        super.mo2108(i, i2);
        m2107(this.f2683, 1.0f / i);
        m2107(this.f2684, 1.0f / i2);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2154(this.f2685);
    }
}
