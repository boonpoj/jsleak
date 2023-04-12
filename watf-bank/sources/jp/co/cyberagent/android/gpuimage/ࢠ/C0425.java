package jp.co.cyberagent.android.gpuimage.ࢠ;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢤ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0425 extends C0416 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private float f2762;

    public C0425() {
        this(1.0f);
    }

    public C0425(float f) {
        super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\n\nuniform float texelWidthOffset; \nuniform float texelHeightOffset; \n\nvarying vec2 centerTextureCoordinate;\nvarying vec2 oneStepLeftTextureCoordinate;\nvarying vec2 twoStepsLeftTextureCoordinate;\nvarying vec2 oneStepRightTextureCoordinate;\nvarying vec2 twoStepsRightTextureCoordinate;\n\nvoid main()\n{\ngl_Position = position;\n\nvec2 firstOffset = vec2(1.5 * texelWidthOffset, 1.5 * texelHeightOffset);\nvec2 secondOffset = vec2(3.5 * texelWidthOffset, 3.5 * texelHeightOffset);\n\ncenterTextureCoordinate = inputTextureCoordinate;\noneStepLeftTextureCoordinate = inputTextureCoordinate - firstOffset;\ntwoStepsLeftTextureCoordinate = inputTextureCoordinate - secondOffset;\noneStepRightTextureCoordinate = inputTextureCoordinate + firstOffset;\ntwoStepsRightTextureCoordinate = inputTextureCoordinate + secondOffset;\n}\n", "precision highp float;\n\nuniform sampler2D inputImageTexture;\n\nvarying vec2 centerTextureCoordinate;\nvarying vec2 oneStepLeftTextureCoordinate;\nvarying vec2 twoStepsLeftTextureCoordinate;\nvarying vec2 oneStepRightTextureCoordinate;\nvarying vec2 twoStepsRightTextureCoordinate;\n\nvoid main()\n{\nlowp vec4 fragmentColor = texture2D(inputImageTexture, centerTextureCoordinate) * 0.2;\nfragmentColor += texture2D(inputImageTexture, oneStepLeftTextureCoordinate) * 0.2;\nfragmentColor += texture2D(inputImageTexture, oneStepRightTextureCoordinate) * 0.2;\nfragmentColor += texture2D(inputImageTexture, twoStepsLeftTextureCoordinate) * 0.2;\nfragmentColor += texture2D(inputImageTexture, twoStepsRightTextureCoordinate) * 0.2;\n\ngl_FragColor = fragmentColor;\n}\n", "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\n\nuniform float texelWidthOffset; \nuniform float texelHeightOffset; \n\nvarying vec2 centerTextureCoordinate;\nvarying vec2 oneStepLeftTextureCoordinate;\nvarying vec2 twoStepsLeftTextureCoordinate;\nvarying vec2 oneStepRightTextureCoordinate;\nvarying vec2 twoStepsRightTextureCoordinate;\n\nvoid main()\n{\ngl_Position = position;\n\nvec2 firstOffset = vec2(1.5 * texelWidthOffset, 1.5 * texelHeightOffset);\nvec2 secondOffset = vec2(3.5 * texelWidthOffset, 3.5 * texelHeightOffset);\n\ncenterTextureCoordinate = inputTextureCoordinate;\noneStepLeftTextureCoordinate = inputTextureCoordinate - firstOffset;\ntwoStepsLeftTextureCoordinate = inputTextureCoordinate - secondOffset;\noneStepRightTextureCoordinate = inputTextureCoordinate + firstOffset;\ntwoStepsRightTextureCoordinate = inputTextureCoordinate + secondOffset;\n}\n", "precision highp float;\n\nuniform sampler2D inputImageTexture;\n\nvarying vec2 centerTextureCoordinate;\nvarying vec2 oneStepLeftTextureCoordinate;\nvarying vec2 twoStepsLeftTextureCoordinate;\nvarying vec2 oneStepRightTextureCoordinate;\nvarying vec2 twoStepsRightTextureCoordinate;\n\nvoid main()\n{\nlowp vec4 fragmentColor = texture2D(inputImageTexture, centerTextureCoordinate) * 0.2;\nfragmentColor += texture2D(inputImageTexture, oneStepLeftTextureCoordinate) * 0.2;\nfragmentColor += texture2D(inputImageTexture, oneStepRightTextureCoordinate) * 0.2;\nfragmentColor += texture2D(inputImageTexture, twoStepsLeftTextureCoordinate) * 0.2;\nfragmentColor += texture2D(inputImageTexture, twoStepsRightTextureCoordinate) * 0.2;\n\ngl_FragColor = fragmentColor;\n}\n");
        this.f2762 = f;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2192(float f) {
        this.f2762 = f;
        m2112(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢠ.ࢤ.1
            @Override // java.lang.Runnable
            public void run() {
                C0425.this.m2174();
            }
        });
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2192(this.f2762);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0416
    /* renamed from: ࢣ */
    public float mo2132() {
        return this.f2762;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0416
    /* renamed from: ࢤ */
    public float mo2133() {
        return this.f2762;
    }
}
