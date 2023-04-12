package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.ࢢ.C0444;
import jp.co.cyberagent.android.gpuimage.ࢢ.C0447;
import jp.co.cyberagent.android.gpuimage.ࢢ.EnumC0446;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ޖ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0414 extends C0390 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2720;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2721;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f2722;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private ByteBuffer f2723;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Bitmap f2724;

    public C0414(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", str);
    }

    public C0414(String str, String str2) {
        super(str, str2);
        this.f2722 = -1;
        m2173(EnumC0446.NORMAL, false, false);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2720 = GLES20.glGetAttribLocation(m2106(), "inputTextureCoordinate2");
        this.f2721 = GLES20.glGetUniformLocation(m2106(), "inputImageTexture2");
        GLES20.glEnableVertexAttribArray(this.f2720);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2172(final Bitmap bitmap) {
        if (bitmap == null || !bitmap.isRecycled()) {
            this.f2724 = bitmap;
            if (this.f2724 == null) {
                return;
            }
            m2112(new Runnable() { // from class: jp.co.cyberagent.android.gpuimage.ࢠ.ޖ.1
                @Override // java.lang.Runnable
                public void run() {
                    if (C0414.this.f2722 != -1 || bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    GLES20.glActiveTexture(33987);
                    C0414.this.f2722 = C0444.m2250(bitmap, -1, false);
                }
            });
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2173(EnumC0446 enumC0446, boolean z, boolean z2) {
        float[] m2255 = C0447.m2255(enumC0446, z, z2);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(m2255);
        asFloatBuffer.flip();
        this.f2723 = order;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        if (this.f2724 == null || this.f2724.isRecycled()) {
            return;
        }
        m2172(this.f2724);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢧ */
    public void mo2119() {
        super.mo2119();
        GLES20.glDeleteTextures(1, new int[]{this.f2722}, 0);
        this.f2722 = -1;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢨ */
    protected void mo2120() {
        GLES20.glEnableVertexAttribArray(this.f2720);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.f2722);
        GLES20.glUniform1i(this.f2721, 3);
        this.f2723.position(0);
        GLES20.glVertexAttribPointer(this.f2720, 2, 5126, false, 0, (Buffer) this.f2723);
    }
}
