package jp.co.cyberagent.android.gpuimage.ࢠ;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢫ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0439 extends C0401 {
    public C0439() {
        super("varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform lowp float mixturePercent;\n \n void main()\n {\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate2);\n    \n    gl_FragColor = mix(textureColor, textureColor2, mixturePercent);\n }");
    }
}
