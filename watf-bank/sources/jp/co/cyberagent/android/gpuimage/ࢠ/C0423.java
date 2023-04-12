package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0423 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private float f2757;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2758;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2759;

    public C0423() {
        this(8.0f);
    }

    public C0423(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nconst int GAUSSIAN_SAMPLES = 9;\nuniform vec2 singleStepOffset;\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[GAUSSIAN_SAMPLES];\nvoid main()\n{\n\tgl_Position = position;\n\ttextureCoordinate = inputTextureCoordinate.xy;\n\tint multiplier = 0;\n\tvec2 blurStep;\n\tfor (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n\t{\n\t\tmultiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n\t\tblurStep = float(multiplier) * singleStepOffset;\n\t\tblurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n\t}\n}", "uniform sampler2D inputImageTexture;\n const lowp int GAUSSIAN_SAMPLES = 9;\n varying highp vec2 textureCoordinate;\n varying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n uniform mediump float distanceNormalizationFactor;\n void main()\n {\n     lowp vec4 centralColor;\n     lowp float gaussianWeightTotal;\n     lowp vec4 sum;\n     lowp vec4 sampleColor;\n     lowp float distanceFromCentralColor;\n     lowp float gaussianWeight;\n     \n     centralColor = texture2D(inputImageTexture, blurCoordinates[4]);\n     gaussianWeightTotal = 0.18;\n     sum = centralColor * 0.18;\n     \n     sampleColor = texture2D(inputImageTexture, blurCoordinates[0]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.05 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[1]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.09 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[2]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.12 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[3]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.15 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[5]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.15 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[6]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.12 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[7]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.09 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[8]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.05 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     gl_FragColor = sum / gaussianWeightTotal;\n }");
        this.f2757 = f;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m2188(float f, float f2) {
        m2111(this.f2759, new float[]{1.0f / f, 1.0f / f2});
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2758 = GLES20.glGetUniformLocation(m2106(), "distanceNormalizationFactor");
        this.f2759 = GLES20.glGetUniformLocation(m2106(), "singleStepOffset");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2189(float f) {
        this.f2757 = f;
        m2107(this.f2758, f);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2108(int i, int i2) {
        super.mo2108(i, i2);
        m2188(i, i2);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2189(this.f2757);
    }
}
