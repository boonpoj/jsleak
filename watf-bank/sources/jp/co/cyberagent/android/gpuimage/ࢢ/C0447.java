package jp.co.cyberagent.android.gpuimage.ࢢ;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢢ.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0447 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static final float[] f2843 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static final float[] f2844 = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: ࢣ  reason: contains not printable characters */
    public static final float[] f2845 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: ࢤ  reason: contains not printable characters */
    public static final float[] f2846 = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static float m2254(float f) {
        return f == 0.0f ? 1.0f : 0.0f;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static float[] m2255(EnumC0446 enumC0446, boolean z, boolean z2) {
        float[] fArr;
        switch (enumC0446) {
            case ROTATION_90:
                fArr = f2844;
                break;
            case ROTATION_180:
                fArr = f2845;
                break;
            case ROTATION_270:
                fArr = f2846;
                break;
            default:
                fArr = f2843;
                break;
        }
        if (z) {
            fArr = new float[]{m2254(fArr[0]), fArr[1], m2254(fArr[2]), fArr[3], m2254(fArr[4]), fArr[5], m2254(fArr[6]), fArr[7]};
        }
        return z2 ? new float[]{fArr[0], m2254(fArr[1]), fArr[2], m2254(fArr[3]), fArr[4], m2254(fArr[5]), fArr[6], m2254(fArr[7])} : fArr;
    }
}
