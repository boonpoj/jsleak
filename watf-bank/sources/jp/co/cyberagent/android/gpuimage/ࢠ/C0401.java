package jp.co.cyberagent.android.gpuimage.ࢠ;

import android.opengl.GLES20;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.މ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0401 extends C0414 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2675;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private float f2676;

    public C0401(String str) {
        this(str, 0.5f);
    }

    public C0401(String str, float f) {
        super(str);
        this.f2676 = f;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0414, jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
        this.f2675 = GLES20.glGetUniformLocation(m2106(), "mixturePercent");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2149(float f) {
        this.f2676 = f;
        m2107(this.f2675, this.f2676);
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0414, jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2149(this.f2676);
    }
}
