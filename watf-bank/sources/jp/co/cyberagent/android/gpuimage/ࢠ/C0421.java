package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0421 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2743;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2744;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private boolean f2745;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private float f2746;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private float f2747;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private float f2748;

    public C0421() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}");
    }

    public C0421(String str) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform highp float texelWidth; \nuniform highp float texelHeight; \n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate;\n\nvarying vec2 topTextureCoordinate;\nvarying vec2 topLeftTextureCoordinate;\nvarying vec2 topRightTextureCoordinate;\n\nvarying vec2 bottomTextureCoordinate;\nvarying vec2 bottomLeftTextureCoordinate;\nvarying vec2 bottomRightTextureCoordinate;\n\nvoid main()\n{\n    gl_Position = position;\n\n    vec2 widthStep = vec2(texelWidth, 0.0);\n    vec2 heightStep = vec2(0.0, texelHeight);\n    vec2 widthHeightStep = vec2(texelWidth, texelHeight);\n    vec2 widthNegativeHeightStep = vec2(texelWidth, -texelHeight);\n\n    textureCoordinate = inputTextureCoordinate.xy;\n    leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n    rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n\n    topTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n    topLeftTextureCoordinate = inputTextureCoordinate.xy - widthHeightStep;\n    topRightTextureCoordinate = inputTextureCoordinate.xy + widthNegativeHeightStep;\n\n    bottomTextureCoordinate = inputTextureCoordinate.xy + heightStep;\n    bottomLeftTextureCoordinate = inputTextureCoordinate.xy - widthNegativeHeightStep;\n    bottomRightTextureCoordinate = inputTextureCoordinate.xy + widthHeightStep;\n}", str);
        this.f2745 = false;
        this.f2748 = 1.0f;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m2185() {
        m2107(this.f2743, this.f2746);
        m2107(this.f2744, this.f2747);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2743 = GLES20.glGetUniformLocation(m2106(), "texelWidth");
        this.f2744 = GLES20.glGetUniformLocation(m2106(), "texelHeight");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2186(float f) {
        this.f2748 = f;
        this.f2746 = f / m2123();
        this.f2747 = f / m2124();
        m2185();
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2108(int i, int i2) {
        super.mo2108(i, i2);
        if (this.f2745) {
            return;
        }
        m2186(this.f2748);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        if (this.f2746 != 0.0f) {
            m2185();
        }
    }
}
