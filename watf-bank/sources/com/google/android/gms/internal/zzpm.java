package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.zzpp;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzpm extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzpm$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zzpp.zza<String> {
        final /* synthetic */ String zzsk;

        AnonymousClass1(zzpm zzpmVar, String str) {
            this.zzsk = str;
        }

        @Override // com.google.android.gms.internal.zzpp.zza
        /* renamed from: zzi */
        public String zzh(InputStream inputStream) {
            try {
                String str = new String(com.google.android.gms.common.util.zzo.zza(inputStream, true), "UTF-8");
                String str2 = this.zzsk;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 49 + String.valueOf(str).length());
                sb.append("Response received from server. \nURL: ");
                sb.append(str2);
                sb.append("\n Response: ");
                sb.append(str);
                zzpe.zzbc(sb.toString());
                return str;
            } catch (IOException e) {
                String valueOf = String.valueOf(this.zzsk);
                zzpe.zzc(valueOf.length() != 0 ? "Error connecting to url: ".concat(valueOf) : new String("Error connecting to url: "), e);
                return null;
            }
        }

        @Override // com.google.android.gms.internal.zzpp.zza
        /* renamed from: zzkA */
        public String zziT() {
            String valueOf = String.valueOf(this.zzsk);
            zzpe.zzbe(valueOf.length() != 0 ? "Error getting a response from: ".concat(valueOf) : new String("Error getting a response from: "));
            return null;
        }
    }

    String getText() throws RemoteException;

    List<zzpq> zzjm() throws RemoteException;
}
