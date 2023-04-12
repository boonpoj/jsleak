package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ޘ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0416 extends C0415 {
    public C0416(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ނ  reason: contains not printable characters */
    public void m2174() {
        float mo2133 = mo2133();
        C0390 c0390 = m2126().get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(c0390.m2106(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(c0390.m2106(), "texelHeightOffset");
        c0390.m2107(glGetUniformLocation, mo2133 / m2123());
        c0390.m2107(glGetUniformLocation2, 0.0f);
        float mo2132 = mo2132();
        C0390 c03902 = m2126().get(1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(c03902.m2106(), "texelWidthOffset");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(c03902.m2106(), "texelHeightOffset");
        c03902.m2107(glGetUniformLocation3, 0.0f);
        c03902.m2107(glGetUniformLocation4, mo2132 / m2124());
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0392, jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        m2174();
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0392, jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2108(int i, int i2) {
        super.mo2108(i, i2);
        m2174();
    }

    /* renamed from: ࢣ */
    public float mo2132() {
        return 1.0f;
    }

    /* renamed from: ࢤ */
    public float mo2133() {
        return 1.0f;
    }
}
