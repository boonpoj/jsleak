package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;
/* loaded from: assets/classes2.dex */
public class GPUImageNativeLibrary {
    static {
        System.loadLibrary("yuv-decoder");
    }

    public static native void YUVtoRBGA(byte[] bArr, int i, int i2, int[] iArr);

    public static native void adjustBitmap(Bitmap bitmap);
}
