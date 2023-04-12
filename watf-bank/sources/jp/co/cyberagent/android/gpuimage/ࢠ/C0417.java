package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.graphics.PointF;
import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ޙ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0417 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2727;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private PointF f2728;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2729;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private float[] f2730;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f2731;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private float f2732;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private int f2733;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private float f2734;

    public C0417() {
        this(new PointF(), new float[]{0.0f, 0.0f, 0.0f}, 0.3f, 0.75f);
    }

    public C0417(PointF pointF, float[] fArr, float f, float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", " uniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n \n uniform lowp vec2 vignetteCenter;\n uniform lowp vec3 vignetteColor;\n uniform highp float vignetteStart;\n uniform highp float vignetteEnd;\n \n void main()\n {\n     /*\n     lowp vec3 rgb = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp float d = distance(textureCoordinate, vec2(0.5,0.5));\n     rgb *= (1.0 - smoothstep(vignetteStart, vignetteEnd, d));\n     gl_FragColor = vec4(vec3(rgb),1.0);\n      */\n     \n     lowp vec3 rgb = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp float d = distance(textureCoordinate, vec2(vignetteCenter.x, vignetteCenter.y));\n     lowp float percent = smoothstep(vignetteStart, vignetteEnd, d);\n     gl_FragColor = vec4(mix(rgb.x, vignetteColor.x, percent), mix(rgb.y, vignetteColor.y, percent), mix(rgb.z, vignetteColor.z, percent), 1.0);\n }");
        this.f2728 = pointF;
        this.f2730 = fArr;
        this.f2732 = f;
        this.f2734 = f2;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2727 = GLES20.glGetUniformLocation(m2106(), "vignetteCenter");
        this.f2729 = GLES20.glGetUniformLocation(m2106(), "vignetteColor");
        this.f2731 = GLES20.glGetUniformLocation(m2106(), "vignetteStart");
        this.f2733 = GLES20.glGetUniformLocation(m2106(), "vignetteEnd");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2175(float f) {
        this.f2732 = f;
        m2107(this.f2731, this.f2732);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2176(PointF pointF) {
        this.f2728 = pointF;
        m2109(this.f2727, this.f2728);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2177(float[] fArr) {
        this.f2730 = fArr;
        m2114(this.f2729, this.f2730);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2176(this.f2728);
        m2177(this.f2730);
        m2175(this.f2732);
        m2178(this.f2734);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2178(float f) {
        this.f2734 = f;
        m2107(this.f2733, this.f2734);
    }
}
