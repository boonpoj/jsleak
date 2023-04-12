package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.graphics.PointF;
import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ޓ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0411 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private PointF f2701;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2702;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private float f2703;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2704;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private float f2705;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f2706;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private float f2707;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private int f2708;

    public C0411() {
        this(new PointF(0.5f, 0.5f), 0.25f, 0.71f);
    }

    public C0411(PointF pointF, float f, float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp vec2 center;\nuniform highp float radius;\nuniform highp float aspectRatio;\nuniform highp float refractiveIndex;\n\nvoid main()\n{\nhighp vec2 textureCoordinateToUse = vec2(textureCoordinate.x, (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));\nhighp float distanceFromCenter = distance(center, textureCoordinateToUse);\nlowp float checkForPresenceWithinSphere = step(distanceFromCenter, radius);\n\ndistanceFromCenter = distanceFromCenter / radius;\n\nhighp float normalizedDepth = radius * sqrt(1.0 - distanceFromCenter * distanceFromCenter);\nhighp vec3 sphereNormal = normalize(vec3(textureCoordinateToUse - center, normalizedDepth));\n\nhighp vec3 refractedVector = refract(vec3(0.0, 0.0, -1.0), sphereNormal, refractiveIndex);\n\ngl_FragColor = texture2D(inputImageTexture, (refractedVector.xy + 1.0) * 0.5) * checkForPresenceWithinSphere;     \n}\n");
        this.f2701 = pointF;
        this.f2703 = f;
        this.f2707 = f2;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m2162(float f) {
        this.f2705 = f;
        m2107(this.f2706, f);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2702 = GLES20.glGetUniformLocation(m2106(), "center");
        this.f2704 = GLES20.glGetUniformLocation(m2106(), "radius");
        this.f2706 = GLES20.glGetUniformLocation(m2106(), "aspectRatio");
        this.f2708 = GLES20.glGetUniformLocation(m2106(), "refractiveIndex");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2163(float f) {
        this.f2707 = f;
        m2107(this.f2708, f);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2108(int i, int i2) {
        this.f2705 = i2 / i;
        m2162(this.f2705);
        super.mo2108(i, i2);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2164(PointF pointF) {
        this.f2701 = pointF;
        m2109(this.f2702, pointF);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2162(this.f2705);
        m2165(this.f2703);
        m2164(this.f2701);
        m2163(this.f2707);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2165(float f) {
        this.f2703 = f;
        m2107(this.f2704, f);
    }
}
