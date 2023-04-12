package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ޅ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0397 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private float f2654;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2655;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private float f2656;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2657;

    public C0397() {
        this(0.2f, 0.0f);
    }

    public C0397(float f, float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform lowp float distance;\nuniform highp float slope;\n\nvoid main()\n{\n\t//todo reconsider precision modifiers\t \n\t highp vec4 color = vec4(1.0);//todo reimplement as a parameter\n\n\t highp float  d = textureCoordinate.y * slope  +  distance; \n\n\t highp vec4 c = texture2D(inputImageTexture, textureCoordinate) ; // consider using unpremultiply\n\n\t c = (c - d * color) / (1.0 -d);\n\n\t gl_FragColor = c; //consider using premultiply(c);\n}\n");
        this.f2654 = f;
        this.f2656 = f2;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2655 = GLES20.glGetUniformLocation(m2106(), "distance");
        this.f2657 = GLES20.glGetUniformLocation(m2106(), "slope");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2138(float f) {
        this.f2654 = f;
        m2107(this.f2655, f);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2138(this.f2654);
        m2139(this.f2656);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2139(float f) {
        this.f2656 = f;
        m2107(this.f2657, f);
    }
}
