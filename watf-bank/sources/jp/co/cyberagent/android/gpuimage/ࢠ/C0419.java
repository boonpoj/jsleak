package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0419 extends C0421 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private float[] f2739;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2740;

    public C0419() {
        this(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f});
    }

    public C0419(float[] fArr) {
        super("precision highp float;\n\nuniform sampler2D inputImageTexture;\n\nuniform mediump mat3 convolutionMatrix;\n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate;\n\nvarying vec2 topTextureCoordinate;\nvarying vec2 topLeftTextureCoordinate;\nvarying vec2 topRightTextureCoordinate;\n\nvarying vec2 bottomTextureCoordinate;\nvarying vec2 bottomLeftTextureCoordinate;\nvarying vec2 bottomRightTextureCoordinate;\n\nvoid main()\n{\n    mediump vec4 bottomColor = texture2D(inputImageTexture, bottomTextureCoordinate);\n    mediump vec4 bottomLeftColor = texture2D(inputImageTexture, bottomLeftTextureCoordinate);\n    mediump vec4 bottomRightColor = texture2D(inputImageTexture, bottomRightTextureCoordinate);\n    mediump vec4 centerColor = texture2D(inputImageTexture, textureCoordinate);\n    mediump vec4 leftColor = texture2D(inputImageTexture, leftTextureCoordinate);\n    mediump vec4 rightColor = texture2D(inputImageTexture, rightTextureCoordinate);\n    mediump vec4 topColor = texture2D(inputImageTexture, topTextureCoordinate);\n    mediump vec4 topRightColor = texture2D(inputImageTexture, topRightTextureCoordinate);\n    mediump vec4 topLeftColor = texture2D(inputImageTexture, topLeftTextureCoordinate);\n\n    mediump vec4 resultColor = topLeftColor * convolutionMatrix[0][0] + topColor * convolutionMatrix[0][1] + topRightColor * convolutionMatrix[0][2];\n    resultColor += leftColor * convolutionMatrix[1][0] + centerColor * convolutionMatrix[1][1] + rightColor * convolutionMatrix[1][2];\n    resultColor += bottomLeftColor * convolutionMatrix[2][0] + bottomColor * convolutionMatrix[2][1] + bottomRightColor * convolutionMatrix[2][2];\n\n    gl_FragColor = resultColor;\n}");
        this.f2739 = fArr;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0421, jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2740 = GLES20.glGetUniformLocation(m2106(), "convolutionMatrix");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2181(float[] fArr) {
        this.f2739 = fArr;
        m2115(this.f2740, this.f2739);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0421, jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2181(this.f2739);
    }
}
