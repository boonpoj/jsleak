package jp.co.cyberagent.android.gpuimage.ࢠ;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢠ.ࢬ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0441 extends C0419 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private float f2824;

    public C0441() {
        this(1.0f);
    }

    public C0441(float f) {
        this.f2824 = f;
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0419, jp.co.cyberagent.android.gpuimage.ࢠ.C0421, jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢠ */
    public void mo2102() {
        super.mo2102();
    }

    @Override // jp.co.cyberagent.android.gpuimage.ࢠ.C0419, jp.co.cyberagent.android.gpuimage.ࢠ.C0421, jp.co.cyberagent.android.gpuimage.ࢠ.C0390
    /* renamed from: ࢢ */
    public void mo2104() {
        super.mo2104();
        m2242(this.f2824);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2242(float f) {
        this.f2824 = f;
        float f2 = -f;
        m2181(new float[]{(-2.0f) * f, f2, 0.0f, f2, 1.0f, f, 0.0f, f, f * 2.0f});
    }
}
