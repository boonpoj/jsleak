package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.internal.zzm;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzpp extends NativeAd.AdChoicesInfo {
    private final List<NativeAd.Image> zzbth = new ArrayList();
    private final zzpm zzbwb;
    private String zzbwc;

    /* renamed from: com.google.android.gms.internal.zzpp$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 implements zza<Void> {
        AnonymousClass1() {
        }

        @Override // com.google.android.gms.internal.zzpp.zza
        public /* bridge */ /* synthetic */ Void zzh(InputStream inputStream) {
            return null;
        }

        @Override // com.google.android.gms.internal.zzpp.zza
        public /* bridge */ /* synthetic */ Void zziT() {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpp$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zzm.zza {
        final /* synthetic */ zzc zzXz;
        final /* synthetic */ String zzsk;

        AnonymousClass2(zzpp zzppVar, String str, zzc zzcVar) {
            this.zzsk = str;
            this.zzXz = zzcVar;
        }

        @Override // com.google.android.gms.internal.zzm.zza
        public void zze(zzr zzrVar) {
            String str = this.zzsk;
            String valueOf = String.valueOf(zzrVar.toString());
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(valueOf).length());
            sb.append("Failed to load URL: ");
            sb.append(str);
            sb.append("\n");
            sb.append(valueOf);
            zzpe.zzbe(sb.toString());
            this.zzXz.zzb(null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpp$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 extends zzab {
        final /* synthetic */ byte[] zzXA;
        final /* synthetic */ Map zzXB;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(zzpp zzppVar, int i, String str, zzm.zzb zzbVar, zzm.zza zzaVar, byte[] bArr, Map map) {
            super(i, str, zzbVar, zzaVar);
            this.zzXA = bArr;
            this.zzXB = map;
        }

        public Map<String, String> getHeaders() throws com.google.android.gms.internal.zza {
            return this.zzXB == null ? super.getHeaders() : this.zzXB;
        }

        public byte[] zzm() throws com.google.android.gms.internal.zza {
            return this.zzXA == null ? super.zzm() : this.zzXA;
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zza<T> {
        T zzh(InputStream inputStream);

        T zziT();
    }

    /* loaded from: assets/classes2.dex */
    private static class zzb<T> extends zzk<InputStream> {
        private final zza<T> zzXC;
        private final zzm.zzb<T> zzaF;

        public zzb(String str, final zza<T> zzaVar, final zzm.zzb<T> zzbVar) {
            super(0, str, new zzm.zza() { // from class: com.google.android.gms.internal.zzpp.zzb.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.zzm.zza
                public void zze(zzr zzrVar) {
                    zzm.zzb.this.zzb(zzaVar.zziT());
                }
            });
            this.zzXC = zzaVar;
            this.zzaF = zzbVar;
        }

        protected zzm<InputStream> zza(zzi zziVar) {
            return zzm.zza(new ByteArrayInputStream(zziVar.data), zzx.zzb(zziVar));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: zzj */
        public void zza(InputStream inputStream) {
            this.zzaF.zzb(this.zzXC.zzh(inputStream));
        }
    }

    /* loaded from: assets/classes2.dex */
    private class zzc<T> extends zzqc<T> implements zzm.zzb<T> {
        private zzc(zzpp zzppVar) {
        }

        /* synthetic */ zzc(zzpp zzppVar, AnonymousClass1 anonymousClass1) {
            this(zzppVar);
        }

        @Override // com.google.android.gms.internal.zzm.zzb
        public void zzb(@Nullable T t) {
            super.zzh(t);
        }
    }

    public zzpp(zzpm zzpmVar) {
        zzpq zzpqVar;
        IBinder iBinder;
        this.zzbwb = zzpmVar;
        try {
            this.zzbwc = this.zzbwb.getText();
        } catch (RemoteException e) {
            zzakb.zzb("Error while obtaining attribution text.", e);
            this.zzbwc = "";
        }
        try {
            for (zzpq zzpqVar2 : zzpmVar.zzjm()) {
                if (!(zzpqVar2 instanceof IBinder) || (iBinder = (IBinder) zzpqVar2) == null) {
                    zzpqVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzpqVar = queryLocalInterface instanceof zzpq ? (zzpq) queryLocalInterface : new zzps(iBinder);
                }
                if (zzpqVar != null) {
                    this.zzbth.add(new zzpt(zzpqVar));
                }
            }
        } catch (RemoteException e2) {
            zzakb.zzb("Error while obtaining image.", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzbth;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzbwc;
    }
}
