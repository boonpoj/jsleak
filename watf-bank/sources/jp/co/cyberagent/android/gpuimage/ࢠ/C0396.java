package jp.co.cyberagent.android.gpuimage.ࢠ;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ބ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0396 extends C0390 {
    public C0396() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\n\nvarying vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nconst highp vec3 W = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main()\n{\n  lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n  float luminance = dot(textureColor.rgb, W);\n\n  gl_FragColor = vec4(vec3(luminance), textureColor.a);\n}");
    }
}
