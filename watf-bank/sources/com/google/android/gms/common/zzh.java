package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzat;
import com.google.android.gms.common.internal.zzau;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/* loaded from: classes.dex */
abstract class zzh extends zzau {
    private int zzflb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzh(byte[] bArr) {
        if (bArr.length != 25) {
            int length = bArr.length;
            String zza = com.google.android.gms.common.util.zzl.zza(bArr, 0, bArr.length, false);
            StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 51);
            sb.append("Cert hash data has incorrect length (");
            sb.append(length);
            sb.append("):\n");
            sb.append(zza);
            Log.wtf("GoogleCertificates", sb.toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            boolean z = bArr.length == 25;
            int length2 = bArr.length;
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("cert hash data has incorrect length. length=");
            sb2.append(length2);
            zzbq.checkArgument(z, sb2.toString());
        }
        this.zzflb = Arrays.hashCode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] zzfx(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        IObjectWrapper zzaga;
        if (obj != null && (obj instanceof zzat)) {
            try {
                zzat zzatVar = (zzat) obj;
                if (zzatVar.zzagb() == hashCode() && (zzaga = zzatVar.zzaga()) != null) {
                    return Arrays.equals(getBytes(), (byte[]) com.google.android.gms.dynamic.zzn.zzx(zzaga));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    abstract byte[] getBytes();

    public int hashCode() {
        return this.zzflb;
    }

    @Override // com.google.android.gms.common.internal.zzat
    public final IObjectWrapper zzaga() {
        return com.google.android.gms.dynamic.zzn.zzz(getBytes());
    }

    @Override // com.google.android.gms.common.internal.zzat
    public final int zzagb() {
        return hashCode();
    }
}
