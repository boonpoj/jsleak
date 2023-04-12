package jp.co.cyberagent.android.gpuimage.ࢢ;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.IntBuffer;
/* renamed from: jp.co.cyberagent.android.gpuimage.ࢢ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0444 {
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static int m2250(Bitmap bitmap, int i, boolean z) {
        int[] iArr = new int[1];
        if (i == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i;
        }
        if (z) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static int m2251(String str, int i) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.d("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader));
            return 0;
        }
        return glCreateShader;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static int m2252(String str, String str2) {
        String str3;
        String str4;
        int[] iArr = new int[1];
        int m2251 = m2251(str, 35633);
        if (m2251 == 0) {
            str3 = "Load Program";
            str4 = "Vertex Shader Failed";
        } else {
            int m22512 = m2251(str2, 35632);
            if (m22512 == 0) {
                str3 = "Load Program";
                str4 = "Fragment Shader Failed";
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                GLES20.glAttachShader(glCreateProgram, m2251);
                GLES20.glAttachShader(glCreateProgram, m22512);
                GLES20.glLinkProgram(glCreateProgram);
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] > 0) {
                    GLES20.glDeleteShader(m2251);
                    GLES20.glDeleteShader(m22512);
                    return glCreateProgram;
                }
                str3 = "Load Program";
                str4 = "Linking Failed";
            }
        }
        Log.d(str3, str4);
        return 0;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static int m2253(IntBuffer intBuffer, int i, int i2, int i3) {
        int[] iArr = new int[1];
        if (i3 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, intBuffer);
        } else {
            GLES20.glBindTexture(3553, i3);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, i, i2, 6408, 5121, intBuffer);
            iArr[0] = i3;
        }
        return iArr[0];
    }
}
