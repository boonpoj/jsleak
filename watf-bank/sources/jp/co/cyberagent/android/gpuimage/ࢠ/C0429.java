package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.graphics.PointF;
import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢦ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0429 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private float f2766;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2767;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private float f2768;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2769;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private PointF f2770;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f2771;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private float f2772;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private int f2773;

    public C0429() {
        this(0.25f, 0.5f, new PointF(0.5f, 0.5f));
    }

    public C0429(float f, float f2, PointF pointF) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp float aspectRatio;\nuniform highp vec2 center;\nuniform highp float radius;\nuniform highp float scale;\n\nvoid main()\n{\nhighp vec2 textureCoordinateToUse = vec2(textureCoordinate.x, (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));\nhighp float dist = distance(center, textureCoordinateToUse);\ntextureCoordinateToUse = textureCoordinate;\n\nif (dist < radius)\n{\ntextureCoordinateToUse -= center;\nhighp float percent = 1.0 - ((radius - dist) / radius) * scale;\npercent = percent * percent;\n\ntextureCoordinateToUse = textureCoordinateToUse * percent;\ntextureCoordinateToUse += center;\n}\n\ngl_FragColor = texture2D(inputImageTexture, textureCoordinateToUse );    \n}\n");
        this.f2768 = f;
        this.f2766 = f2;
        this.f2770 = pointF;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m2196(float f) {
        this.f2772 = f;
        m2107(this.f2773, f);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2767 = GLES20.glGetUniformLocation(m2106(), "scale");
        this.f2769 = GLES20.glGetUniformLocation(m2106(), "radius");
        this.f2771 = GLES20.glGetUniformLocation(m2106(), "center");
        this.f2773 = GLES20.glGetUniformLocation(m2106(), "aspectRatio");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2197(float f) {
        this.f2768 = f;
        m2107(this.f2769, f);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2108(int i, int i2) {
        this.f2772 = i2 / i;
        m2196(this.f2772);
        super.mo2108(i, i2);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2198(PointF pointF) {
        this.f2770 = pointF;
        m2109(this.f2771, pointF);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2196(this.f2772);
        m2197(this.f2768);
        m2199(this.f2766);
        m2198(this.f2770);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2199(float f) {
        this.f2766 = f;
        m2107(this.f2767, f);
    }
}
