package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.js.JavascriptEngineFactory;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbuy;
import com.google.android.gms.internal.zzzm;
import com.google.android.gms.internal.zzzv;
import com.mopub.common.AdType;
import java.util.ArrayList;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzzf extends zzyk<zzzf> {
    private final Context mContext;
    private final Object mLock = new Object();
    private final zzakd zzarf;
    private String zzaro;
    private final zzcv zzbuv;
    private final com.google.android.gms.ads.internal.zzba zzclf;
    private JavascriptEngineFactory zzclp;
    private zzakv<zzanh> zzclq;
    private final com.google.android.gms.ads.internal.gmsg.zzz zzclu;
    private final zzox zzclv;
    private static final long zzclr = TimeUnit.SECONDS.toMillis(60);
    private static final Object sLock = new Object();
    private static boolean zzcls = false;
    private static com.google.android.gms.ads.internal.js.zzn zzclt = null;

    /* renamed from: com.google.android.gms.internal.zzzf$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 extends Api.zza<zzzk, Api.ApiOptions.NoOptions> {
        AnonymousClass1() {
        }

        /* JADX WARN: Type inference failed for: r10v1, types: [com.google.android.gms.internal.zzzk] */
        /* renamed from: zze */
        public zzzk zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzgVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new com.google.android.gms.ads.internal.gmsg.zzt(context, looper, zzgVar, connectionCallbacks, onConnectionFailedListener) { // from class: com.google.android.gms.internal.zzzk
                private final zzzf zzclw;
                private final zzanh zzcly;
                private final zzyl zzclz;
                private final zzalf zzcma;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzclw = r1;
                    this.zzcly = r2;
                    this.zzclz = r3;
                    this.zzcma = r4;
                }

                @Override // com.google.android.gms.ads.internal.gmsg.zzt
                public final void zza(Object obj, Map map) {
                    this.zzclw.zza(this.zzcly, this.zzclz, this.zzcma, (zzanh) obj, map);
                }
            };
        }
    }

    /* loaded from: assets/classes2.dex */
    public class zza {
        private boolean zzawA;
        private final zzbuy.zzc zzawB;
        private boolean zzawC;
        private String zzawm;
        private int zzawn;
        private String zzawo;
        private String zzawp;
        private int zzawr;
        private final zzc zzawv;
        private ArrayList<Integer> zzaww;
        private ArrayList<String> zzawx;
        private ArrayList<Integer> zzawy;
        private ArrayList<byte[]> zzawz;

        private zza(zzzf zzzfVar, byte[] bArr) {
            this(bArr, (zzc) null);
        }

        /* synthetic */ zza(zzzf zzzfVar, byte[] bArr, AnonymousClass1 anonymousClass1) {
            this(zzzfVar, bArr);
        }

        private zza(byte[] bArr, zzc zzcVar) {
            this.zzawn = zzzf.zza(zzzf.this);
            this.zzawm = zzzf.zzb(zzzf.this);
            this.zzawo = zzzf.zzc(zzzf.this);
            this.zzawp = zzzf.zzd(zzzf.this);
            this.zzawr = zzzf.zze(zzzf.this);
            this.zzaww = null;
            this.zzawx = null;
            this.zzawy = null;
            this.zzawz = null;
            this.zzawA = true;
            this.zzawB = new zzbuy.zzc();
            this.zzawC = false;
            this.zzawo = zzzf.zzc(zzzf.this);
            this.zzawp = zzzf.zzd(zzzf.this);
            this.zzawB.zzcsy = zzzf.zzf(zzzf.this).currentTimeMillis();
            this.zzawB.zzcsz = zzzf.zzf(zzzf.this).elapsedRealtime();
            this.zzawB.zzcsJ = zzzf.zzg(zzzf.this).zzG(this.zzawB.zzcsy);
            if (bArr != null) {
                this.zzawB.zzcsF = bArr;
            }
            this.zzawv = zzcVar;
        }

        public zza zzcn(int i) {
            this.zzawB.zzcsB = i;
            return this;
        }

        public zza zzco(int i) {
            this.zzawB.zzrn = i;
            return this;
        }

        @Deprecated
        public PendingResult<Status> zze(GoogleApiClient googleApiClient) {
            return zzuv();
        }

        /* JADX WARN: Type inference failed for: r10v0, types: [com.google.android.gms.internal.zzzh] */
        public zzzh zzuu() {
            return new zzakg(new zzawe(zzzf.zzi(zzzf.this), zzzf.zzj(zzzf.this), this.zzawn, this.zzawm, this.zzawo, this.zzawp, zzzf.zzh(zzzf.this), this.zzawr), this.zzawB, this.zzawv, null, zzzf.zze(null), zzzf.zzf(null), zzzf.zze(null), zzzf.zzg(null), this.zzawA) { // from class: com.google.android.gms.internal.zzzh
                private final zzzf zzclw;
                private final JSONObject zzclx;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzclw = r1;
                    this.zzclx = r2;
                }

                @Override // com.google.android.gms.internal.zzakg
                public final zzakv zzc(Object obj) {
                    return this.zzclw.zzc(this.zzclx, (zzanh) obj);
                }
            };
        }

        @Deprecated
        public PendingResult<Status> zzuv() {
            if (this.zzawC) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.zzawC = true;
            zzzh zzuu = zzuu();
            zzawe zzaweVar = zzuu.zzawE;
            return zzzf.zzk(zzzf.this).zzh(zzaweVar.zzbzD, zzaweVar.zzbzz) ? zzzf.zzl(zzzf.this).zza(zzuu) : PendingResults.immediatePendingResult(Status.zzayh);
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zzb {
        boolean zzh(String str, int i);
    }

    /* loaded from: assets/classes2.dex */
    public interface zzc {
        byte[] zzuw();
    }

    /* loaded from: assets/classes2.dex */
    public static class zzd {
        public long zzG(long j) {
            return TimeZone.getDefault().getOffset(j) / 1000;
        }
    }

    public zzzf(Context context, com.google.android.gms.ads.internal.zzba zzbaVar, String str, zzcv zzcvVar, zzakd zzakdVar) {
        zzagf.zzct("Webview loading for native ads.");
        this.mContext = context;
        this.zzclf = zzbaVar;
        this.zzbuv = zzcvVar;
        this.zzarf = zzakdVar;
        this.zzaro = str;
        this.zzclp = new JavascriptEngineFactory();
        com.google.android.gms.ads.internal.zzbs.zzej();
        zzakv<zzanh> zza2 = zzanr.zza(this.mContext, this.zzarf, (String) zzkb.zzif().zzd(zznh.zzbol), this.zzbuv, this.zzclf.zzbq());
        this.zzclu = new com.google.android.gms.ads.internal.gmsg.zzz(this.mContext);
        this.zzclv = new zzox(zzbaVar, str);
        this.zzclq = zzakl.zza(zza2, new zzakg(this) { // from class: com.google.android.gms.internal.zzzg
            private final zzzf zzclw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzclw = this;
            }

            @Override // com.google.android.gms.internal.zzakg
            public final zzakv zzc(Object obj) {
                return this.zzclw.zzh((zzanh) obj);
            }
        }, zzala.zzdff);
        zzakj.zza(this.zzclq, "WebViewNativeAdsUtil.constructor");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzakv zza(JSONObject jSONObject, zzanh zzanhVar) throws Exception {
        jSONObject.put("ads_id", this.zzaro);
        zzanhVar.zzb("google.afma.nativeAds.handleImpressionPing", jSONObject);
        return zzakl.zzi(new JSONObject());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzanh zzanhVar, zzyl zzylVar, zzalf zzalfVar, zzanh zzanhVar2, Map map) {
        JSONObject jSONObject;
        boolean z;
        try {
            String str = (String) map.get("success");
            String str2 = (String) map.get("failure");
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject(str);
                z = true;
            } else {
                jSONObject = new JSONObject(str2);
                z = false;
            }
            if (this.zzaro.equals(jSONObject.optString("ads_id", ""))) {
                zzanhVar.zzb("/nativeAdPreProcess", zzylVar.zzcke);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", z);
                jSONObject2.put(AdType.STATIC_NATIVE, jSONObject);
                zzalfVar.set(jSONObject2);
            }
        } catch (Throwable th) {
            zzagf.zzb("Error while preprocessing json.", th);
            zzalfVar.setException(th);
        }
    }

    @Override // com.google.android.gms.internal.zzyk, com.google.android.gms.internal.zzzb
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzt zztVar) {
        zzakl.zza(this.zzclq, new zzzl(this, str, zztVar), zzala.zzdfe);
    }

    @Override // com.google.android.gms.internal.zzzb
    public final void zza(String str, JSONObject jSONObject) {
        zzakl.zza(this.zzclq, new zzzn(this, str, jSONObject), zzala.zzdfe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzakv zzb(JSONObject jSONObject, zzanh zzanhVar) throws Exception {
        jSONObject.put("ads_id", this.zzaro);
        zzanhVar.zzb("google.afma.nativeAds.handleClickGmsg", jSONObject);
        return zzakl.zzi(new JSONObject());
    }

    @Override // com.google.android.gms.internal.zzyk, com.google.android.gms.internal.zzzb
    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzt zztVar) {
        zzakl.zza(this.zzclq, new zzzm(this, str, zztVar), zzala.zzdfe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzakv zzc(JSONObject jSONObject, final zzanh zzanhVar) throws Exception {
        jSONObject.put("ads_id", this.zzaro);
        final zzalf zzalfVar = new zzalf();
        final zzyl zzylVar = new zzyl();
        com.google.android.gms.ads.internal.gmsg.zzt<? super zzanh> zztVar = new com.google.android.gms.ads.internal.gmsg.zzt(this, zzanhVar, zzylVar, zzalfVar) { // from class: com.google.android.gms.internal.zzzk
            private final zzzf zzclw;
            private final zzanh zzcly;
            private final zzyl zzclz;
            private final zzalf zzcma;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzclw = this;
                this.zzcly = zzanhVar;
                this.zzclz = zzylVar;
                this.zzcma = zzalfVar;
            }

            @Override // com.google.android.gms.ads.internal.gmsg.zzt
            public final void zza(Object obj, Map map) {
                this.zzclw.zza(this.zzcly, this.zzclz, this.zzcma, (zzanh) obj, map);
            }
        };
        zzylVar.zzcke = zztVar;
        zzanhVar.zza("/nativeAdPreProcess", zztVar);
        zzanhVar.zzb("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
        return zzalfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzakv zzh(zzanh zzanhVar) throws Exception {
        zzagf.zzct("Javascript has loaded for native ads.");
        zzani zzsz = zzanhVar.zzsz();
        com.google.android.gms.ads.internal.zzba zzbaVar = this.zzclf;
        zzsz.zza(zzbaVar, zzbaVar, zzbaVar, zzbaVar, false, null, new com.google.android.gms.ads.internal.zzw(this.mContext, null, null), null, null);
        zzanhVar.zzsz().zza("/logScionEvent", this.zzclu);
        zzanhVar.zzsz().zza("/logScionEvent", this.zzclv);
        return zzakl.zzi(zzanhVar);
    }

    @Override // com.google.android.gms.internal.zzzb
    public final zzakv<JSONObject> zzi(final JSONObject jSONObject) {
        return zzakl.zza(this.zzclq, new zzakg(this, jSONObject) { // from class: com.google.android.gms.internal.zzzh
            private final zzzf zzclw;
            private final JSONObject zzclx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzclw = this;
                this.zzclx = jSONObject;
            }

            @Override // com.google.android.gms.internal.zzakg
            public final zzakv zzc(Object obj) {
                return this.zzclw.zzc(this.zzclx, (zzanh) obj);
            }
        }, zzala.zzdfe);
    }

    @Override // com.google.android.gms.internal.zzzb
    public final zzakv<JSONObject> zzj(final JSONObject jSONObject) {
        return zzakl.zza(this.zzclq, new zzakg(this, jSONObject) { // from class: com.google.android.gms.internal.zzzi
            private final zzzf zzclw;
            private final JSONObject zzclx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzclw = this;
                this.zzclx = jSONObject;
            }

            @Override // com.google.android.gms.internal.zzakg
            public final zzakv zzc(Object obj) {
                return this.zzclw.zzb(this.zzclx, (zzanh) obj);
            }
        }, zzala.zzdfe);
    }

    @Override // com.google.android.gms.internal.zzzb
    public final zzakv<JSONObject> zzk(final JSONObject jSONObject) {
        return zzakl.zza(this.zzclq, new zzakg(this, jSONObject) { // from class: com.google.android.gms.internal.zzzj
            private final zzzf zzclw;
            private final JSONObject zzclx;

            /* loaded from: assets/classes2.dex */
            static final class zza extends zzzv.zza<Status, zzzk> {
                private final zzzh zzawO;

                zza(zzzh zzzhVar, GoogleApiClient googleApiClient) {
                    super(zzzf.API, googleApiClient);
                    this.zzawO = zzzhVar;
                }

                public boolean equals(Object obj) {
                    if (obj instanceof zza) {
                        return equals(((zza) obj).zzawO);
                    }
                    return false;
                }

                public String toString() {
                    String valueOf = String.valueOf(this.zzawO);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                    sb.append("LogEventMethodImpl(");
                    sb.append(valueOf);
                    sb.append(")");
                    return sb.toString();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzzv.zza
                public void zza(zzzk zzzkVar) throws RemoteException {
                    zzzm.zza zzaVar = new zzzm.zza() { // from class: com.google.android.gms.internal.zzzj.zza.1
                        public void zzv(Status status) {
                            zza.this.zzb((Result) status);
                        }

                        public void zzw(Status status) {
                            throw new UnsupportedOperationException();
                        }
                    };
                    try {
                        zzzj.zzb(this.zzawO);
                        zzzkVar.zza(zzaVar, this.zzawO);
                    } catch (RuntimeException e) {
                        Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
                        zzA(new Status(10, "MessageProducer"));
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: zzb */
                public Status zzc(Status status) {
                    return status;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzclw = this;
                this.zzclx = jSONObject;
            }

            @Override // com.google.android.gms.internal.zzakg
            public final zzakv zzc(Object obj) {
                return this.zzclw.zza(this.zzclx, (zzanh) obj);
            }
        }, zzala.zzdfe);
    }

    @Override // com.google.android.gms.internal.zzzb
    public final void zzls() {
        zzakl.zza(this.zzclq, new zzzo(this), zzala.zzdfe);
    }
}
