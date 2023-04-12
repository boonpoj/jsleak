package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ވ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0400 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final String f2664 = "ވ";

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2665;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private float[] f2666;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2667;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private float[] f2668;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f2669;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private float[] f2670;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private int f2671;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private float[] f2672;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private int f2673;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private float[] f2674;

    public C0400() {
        this(new float[]{0.0f, 0.0f, 0.0f}, new float[]{1.0f, 1.0f, 1.0f}, new float[]{1.0f, 1.0f, 1.0f}, new float[]{0.0f, 0.0f, 0.0f}, new float[]{1.0f, 1.0f, 1.0f});
    }

    private C0400(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform mediump vec3 levelMinimum;\n uniform mediump vec3 levelMiddle;\n uniform mediump vec3 levelMaximum;\n uniform mediump vec3 minOutput;\n uniform mediump vec3 maxOutput;\n \n void main()\n {\n     mediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4( mix(minOutput, maxOutput, pow(min(max(textureColor.rgb -levelMinimum, vec3(0.0)) / (levelMaximum - levelMinimum  ), vec3(1.0)), 1.0 /levelMiddle)) , textureColor.a);\n }\n");
        this.f2666 = fArr;
        this.f2668 = fArr2;
        this.f2670 = fArr3;
        this.f2672 = fArr4;
        this.f2674 = fArr5;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2665 = GLES20.glGetUniformLocation(m2106(), "levelMinimum");
        this.f2667 = GLES20.glGetUniformLocation(m2106(), "levelMiddle");
        this.f2669 = GLES20.glGetUniformLocation(m2106(), "levelMaximum");
        this.f2671 = GLES20.glGetUniformLocation(m2106(), "minOutput");
        this.f2673 = GLES20.glGetUniformLocation(m2106(), "maxOutput");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2143(float f, float f2, float f3) {
        m2144(f, f2, f3, 0.0f, 1.0f);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2144(float f, float f2, float f3, float f4, float f5) {
        m2145(f, f2, f3, f4, f5);
        m2147(f, f2, f3, f4, f5);
        m2148(f, f2, f3, f4, f5);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2144(0.0f, 1.0f, 1.0f, 0.0f, 1.0f);
        m2146();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2145(float f, float f2, float f3, float f4, float f5) {
        this.f2666[0] = f;
        this.f2668[0] = f2;
        this.f2670[0] = f3;
        this.f2672[0] = f4;
        this.f2674[0] = f5;
        m2146();
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m2146() {
        m2114(this.f2665, this.f2666);
        m2114(this.f2667, this.f2668);
        m2114(this.f2669, this.f2670);
        m2114(this.f2671, this.f2672);
        m2114(this.f2673, this.f2674);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m2147(float f, float f2, float f3, float f4, float f5) {
        this.f2666[1] = f;
        this.f2668[1] = f2;
        this.f2670[1] = f3;
        this.f2672[1] = f4;
        this.f2674[1] = f5;
        m2146();
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m2148(float f, float f2, float f3, float f4, float f5) {
        this.f2666[2] = f;
        this.f2668[2] = f2;
        this.f2670[2] = f3;
        this.f2672[2] = f4;
        this.f2674[2] = f5;
        m2146();
    }
}
