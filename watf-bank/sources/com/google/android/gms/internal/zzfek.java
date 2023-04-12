package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfek;
import com.google.android.gms.internal.zzfel;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
/* loaded from: classes.dex */
public abstract class zzfek<MessageType extends zzfek<MessageType, BuilderType>, BuilderType extends zzfel<MessageType, BuilderType>> implements zzfhe {
    private static boolean zzpfb = false;
    protected int zzpfa = 0;

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfel.zza(iterable, list);
    }

    @Override // com.google.android.gms.internal.zzfhe
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzho()];
            zzffg zzbc = zzffg.zzbc(bArr);
            zza(zzbc);
            zzbc.zzcwt();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.google.android.gms.internal.zzfhe
    public final zzfes toByteString() {
        try {
            zzfex zzko = zzfes.zzko(zzho());
            zza(zzko.zzcvs());
            return zzko.zzcvr();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.google.android.gms.internal.zzfhe
    public final void writeTo(OutputStream outputStream) throws IOException {
        zzffg zzb = zzffg.zzb(outputStream, zzffg.zzlb(zzho()));
        zza(zzb);
        zzb.flush();
    }
}
