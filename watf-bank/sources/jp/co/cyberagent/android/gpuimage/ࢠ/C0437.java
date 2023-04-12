package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢪ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0437 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private float f2813;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2814;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private float f2815;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2816;

    public C0437() {
        this(0.03f, 0.003f);
    }

    public C0437(float f, float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform highp float crossHatchSpacing;\nuniform highp float lineWidth;\nconst highp vec3 W = vec3(0.2125, 0.7154, 0.0721);\nvoid main()\n{\nhighp float luminance = dot(texture2D(inputImageTexture, textureCoordinate).rgb, W);\nlowp vec4 colorToDisplay = vec4(1.0, 1.0, 1.0, 1.0);\nif (luminance < 1.00)\n{\nif (mod(textureCoordinate.x + textureCoordinate.y, crossHatchSpacing) <= lineWidth)\n{\ncolorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);\n}\n}\nif (luminance < 0.75)\n{\nif (mod(textureCoordinate.x - textureCoordinate.y, crossHatchSpacing) <= lineWidth)\n{\ncolorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);\n}\n}\nif (luminance < 0.50)\n{\nif (mod(textureCoordinate.x + textureCoordinate.y - (crossHatchSpacing / 2.0), crossHatchSpacing) <= lineWidth)\n{\ncolorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);\n}\n}\nif (luminance < 0.3)\n{\nif (mod(textureCoordinate.x - textureCoordinate.y - (crossHatchSpacing / 2.0), crossHatchSpacing) <= lineWidth)\n{\ncolorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);\n}\n}\ngl_FragColor = colorToDisplay;\n}\n");
        this.f2813 = f;
        this.f2815 = f2;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2814 = GLES20.glGetUniformLocation(m2106(), "crossHatchSpacing");
        this.f2816 = GLES20.glGetUniformLocation(m2106(), "lineWidth");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2232(float f) {
        float f2 = m2123() != 0 ? 1.0f / m2123() : 4.8828125E-4f;
        if (f < f2) {
            this.f2813 = f2;
        } else {
            this.f2813 = f;
        }
        m2107(this.f2814, this.f2813);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2232(this.f2813);
        m2233(this.f2815);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2233(float f) {
        this.f2815 = f;
        m2107(this.f2816, this.f2815);
    }
}
