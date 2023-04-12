package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.graphics.PointF;
import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ރ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0395 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private PointF f2646;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2647;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private float f2648;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2649;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private float f2650;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f2651;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private float f2652;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private int f2653;

    public C0395() {
        this(new PointF(0.5f, 0.5f), 0.25f, 0.71f);
    }

    public C0395(PointF pointF, float f, float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp vec2 center;\nuniform highp float radius;\nuniform highp float aspectRatio;\nuniform highp float refractiveIndex;\n// uniform vec3 lightPosition;\nconst highp vec3 lightPosition = vec3(-0.5, 0.5, 1.0);\nconst highp vec3 ambientLightPosition = vec3(0.0, 0.0, 1.0);\n\nvoid main()\n{\nhighp vec2 textureCoordinateToUse = vec2(textureCoordinate.x, (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));\nhighp float distanceFromCenter = distance(center, textureCoordinateToUse);\nlowp float checkForPresenceWithinSphere = step(distanceFromCenter, radius);\n\ndistanceFromCenter = distanceFromCenter / radius;\n\nhighp float normalizedDepth = radius * sqrt(1.0 - distanceFromCenter * distanceFromCenter);\nhighp vec3 sphereNormal = normalize(vec3(textureCoordinateToUse - center, normalizedDepth));\n\nhighp vec3 refractedVector = 2.0 * refract(vec3(0.0, 0.0, -1.0), sphereNormal, refractiveIndex);\nrefractedVector.xy = -refractedVector.xy;\n\nhighp vec3 finalSphereColor = texture2D(inputImageTexture, (refractedVector.xy + 1.0) * 0.5).rgb;\n\n// Grazing angle lighting\nhighp float lightingIntensity = 2.5 * (1.0 - pow(clamp(dot(ambientLightPosition, sphereNormal), 0.0, 1.0), 0.25));\nfinalSphereColor += lightingIntensity;\n\n// Specular lighting\nlightingIntensity  = clamp(dot(normalize(lightPosition), sphereNormal), 0.0, 1.0);\nlightingIntensity  = pow(lightingIntensity, 15.0);\nfinalSphereColor += vec3(0.8, 0.8, 0.8) * lightingIntensity;\n\ngl_FragColor = vec4(finalSphereColor, 1.0) * checkForPresenceWithinSphere;\n}\n");
        this.f2646 = pointF;
        this.f2648 = f;
        this.f2652 = f2;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m2134(float f) {
        this.f2650 = f;
        m2107(this.f2651, f);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2647 = GLES20.glGetUniformLocation(m2106(), "center");
        this.f2649 = GLES20.glGetUniformLocation(m2106(), "radius");
        this.f2651 = GLES20.glGetUniformLocation(m2106(), "aspectRatio");
        this.f2653 = GLES20.glGetUniformLocation(m2106(), "refractiveIndex");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2135(float f) {
        this.f2652 = f;
        m2107(this.f2653, f);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2108(int i, int i2) {
        this.f2650 = i2 / i;
        m2134(this.f2650);
        super.mo2108(i, i2);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2136(PointF pointF) {
        this.f2646 = pointF;
        m2109(this.f2647, pointF);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2134(this.f2650);
        m2137(this.f2648);
        m2136(this.f2646);
        m2135(this.f2652);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2137(float f) {
        this.f2648 = f;
        m2107(this.f2649, f);
    }
}
