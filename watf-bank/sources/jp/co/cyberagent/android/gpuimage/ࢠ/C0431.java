package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢧ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0431 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2774;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2775;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2776;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2777;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private float[] f2778;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private float[] f2779;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private float[] f2780;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f2781;

    public C0431() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform lowp vec3 shadowsShift;\nuniform lowp vec3 midtonesShift;\nuniform lowp vec3 highlightsShift;\nuniform int preserveLuminosity;\nlowp vec3 RGBToHSL(lowp vec3 color)\n{\nlowp vec3 hsl; // init to 0 to avoid warnings ? (and reverse if + remove first part)\nlowp float fmin = min(min(color.r, color.g), color.b);    //Min. value of RGB\nlowp float fmax = max(max(color.r, color.g), color.b);    //Max. value of RGB\nlowp float delta = fmax - fmin;             //Delta RGB value\nhsl.z = (fmax + fmin) / 2.0; // Luminance\nif (delta == 0.0)\t\t//This is a gray, no chroma...\n{\n    hsl.x = 0.0;\t// Hue\n    hsl.y = 0.0;\t// Saturation\n}\nelse                                    //Chromatic data...\n{\n    if (hsl.z < 0.5)\n        hsl.y = delta / (fmax + fmin); // Saturation\n    else\n        hsl.y = delta / (2.0 - fmax - fmin); // Saturation\n\n    lowp float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;\n    lowp float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;\n    lowp float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;\n\n    if (color.r == fmax )\n        hsl.x = deltaB - deltaG; // Hue\n    else if (color.g == fmax)\n        hsl.x = (1.0 / 3.0) + deltaR - deltaB; // Hue\n    else if (color.b == fmax)\n        hsl.x = (2.0 / 3.0) + deltaG - deltaR; // Hue\n    if (hsl.x < 0.0)\n        hsl.x += 1.0; // Hue\n    else if (hsl.x > 1.0)\n        hsl.x -= 1.0; // Hue\n}\n\nreturn hsl;\n}\nlowp float HueToRGB(lowp float f1, lowp float f2, lowp float hue)\n{\n    if (hue < 0.0)\n        hue += 1.0;\n    else if (hue > 1.0)\n        hue -= 1.0;\n    lowp float res;\n    if ((6.0 * hue) < 1.0)\n        res = f1 + (f2 - f1) * 6.0 * hue;\n    else if ((2.0 * hue) < 1.0)\n        res = f2;\n    else if ((3.0 * hue) < 2.0)\n        res = f1 + (f2 - f1) * ((2.0 / 3.0) - hue) * 6.0;\n    else\n        res = f1;\n    return res;\n}\nlowp vec3 HSLToRGB(lowp vec3 hsl)\n{\n    lowp vec3 rgb;\n    if (hsl.y == 0.0)\n        rgb = vec3(hsl.z); // Luminance\n    else\n    {\n        lowp float f2;\n        if (hsl.z < 0.5)\n            f2 = hsl.z * (1.0 + hsl.y);\n        else\n            f2 = (hsl.z + hsl.y) - (hsl.y * hsl.z);\n        lowp float f1 = 2.0 * hsl.z - f2;\n        rgb.r = HueToRGB(f1, f2, hsl.x + (1.0/3.0));\n        rgb.g = HueToRGB(f1, f2, hsl.x);\n        rgb.b= HueToRGB(f1, f2, hsl.x - (1.0/3.0));\n    }\n    return rgb;\n  }\nlowp float RGBToL(lowp vec3 color)\n{\n    lowp float fmin = min(min(color.r, color.g), color.b);    //Min. value of RGB\n    lowp float fmax = max(max(color.r, color.g), color.b);    //Max. value of RGB\n    return (fmax + fmin) / 2.0; // Luminance\n}\nvoid main()\n{\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    // Alternative way:\n    //lowp vec3 lightness = RGBToL(textureColor.rgb);\n    lowp vec3 lightness = textureColor.rgb;\n    const lowp float a = 0.25;\n    const lowp float b = 0.333;\n    const lowp float scale = 0.7;\n    lowp vec3 shadows = shadowsShift * (clamp((lightness - b) / -a + 0.5, 0.0, 1.0) * scale);\n    lowp vec3 midtones = midtonesShift * (clamp((lightness - b) / a + 0.5, 0.0, 1.0) *\n        clamp((lightness + b - 1.0) / -a + 0.5, 0.0, 1.0) * scale);\n    lowp vec3 highlights = highlightsShift * (clamp((lightness + b - 1.0) / a + 0.5, 0.0, 1.0) * scale);\n    mediump vec3 newColor = textureColor.rgb + shadows + midtones + highlights;\n    newColor = clamp(newColor, 0.0, 1.0);\n        if (preserveLuminosity != 0) {\n           lowp vec3 newHSL = RGBToHSL(newColor);\n        lowp float oldLum = RGBToL(textureColor.rgb);\n        textureColor.rgb = HSLToRGB(vec3(newHSL.x, newHSL.y, oldLum));\n        gl_FragColor = textureColor;\n    } else {\n        gl_FragColor = vec4(newColor.rgb, textureColor.w);\n    }\n}\n");
        this.f2778 = new float[]{0.0f, 0.0f, 0.0f};
        this.f2779 = new float[]{0.0f, 0.0f, 0.0f};
        this.f2780 = new float[]{0.0f, 0.0f, 0.0f};
        this.f2781 = true;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2774 = GLES20.glGetUniformLocation(m2106(), "shadowsShift");
        this.f2775 = GLES20.glGetUniformLocation(m2106(), "midtonesShift");
        this.f2776 = GLES20.glGetUniformLocation(m2106(), "highlightsShift");
        this.f2777 = GLES20.glGetUniformLocation(m2106(), "preserveLuminosity");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2200(boolean z) {
        this.f2781 = z;
        m2113(this.f2777, z ? 1 : 0);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2201(float[] fArr) {
        this.f2778 = fArr;
        m2114(this.f2774, fArr);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2202(this.f2779);
        m2201(this.f2778);
        m2203(this.f2780);
        m2200(this.f2781);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2202(float[] fArr) {
        this.f2779 = fArr;
        m2114(this.f2775, fArr);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m2203(float[] fArr) {
        this.f2780 = fArr;
        m2114(this.f2776, fArr);
    }
}
