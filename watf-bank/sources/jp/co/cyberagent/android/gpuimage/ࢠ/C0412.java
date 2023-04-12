package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.graphics.PointF;
import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ޔ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0412 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private float f2709;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2710;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private float f2711;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2712;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private PointF f2713;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f2714;

    public C0412() {
        this(0.5f, 1.0f, new PointF(0.5f, 0.5f));
    }

    public C0412(float f, float f2, PointF pointF) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp vec2 center;\nuniform highp float radius;\nuniform highp float angle;\n\nvoid main()\n{\nhighp vec2 textureCoordinateToUse = textureCoordinate;\nhighp float dist = distance(center, textureCoordinate);\nif (dist < radius)\n{\ntextureCoordinateToUse -= center;\nhighp float percent = (radius - dist) / radius;\nhighp float theta = percent * percent * angle * 8.0;\nhighp float s = sin(theta);\nhighp float c = cos(theta);\ntextureCoordinateToUse = vec2(dot(textureCoordinateToUse, vec2(c, -s)), dot(textureCoordinateToUse, vec2(s, c)));\ntextureCoordinateToUse += center;\n}\n\ngl_FragColor = texture2D(inputImageTexture, textureCoordinateToUse );\n\n}\n");
        this.f2711 = f;
        this.f2709 = f2;
        this.f2713 = pointF;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2710 = GLES20.glGetUniformLocation(m2106(), "angle");
        this.f2712 = GLES20.glGetUniformLocation(m2106(), "radius");
        this.f2714 = GLES20.glGetUniformLocation(m2106(), "center");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2166(float f) {
        this.f2711 = f;
        m2107(this.f2712, f);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2167(PointF pointF) {
        this.f2713 = pointF;
        m2109(this.f2714, pointF);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2166(this.f2711);
        m2168(this.f2709);
        m2167(this.f2713);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2168(float f) {
        this.f2709 = f;
        m2107(this.f2710, f);
    }
}
