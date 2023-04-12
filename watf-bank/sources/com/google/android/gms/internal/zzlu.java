package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzgu;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzqe;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class zzlu {
    private String zzbea;
    private String zzbec;
    private String zzbeg;
    private boolean zzbei;
    private Date zzhh;
    private Location zzhl;
    private final HashSet<String> zzbfx = new HashSet<>();
    private final Bundle zzbfs = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzbfy = new HashMap<>();
    private final HashSet<String> zzbfz = new HashSet<>();
    private final Bundle zzbee = new Bundle();
    private final HashSet<String> zzbga = new HashSet<>();
    private int zzbdw = -1;
    private boolean zzamr = false;
    private int zzbdz = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.gms.internal.zzlu$1 */
    /* loaded from: assets/classes2.dex */
    public class AnonymousClass1 extends zzlt.zza {
        final /* synthetic */ String zzQg;
        final /* synthetic */ zzb zzQh;
        final /* synthetic */ zzqc zzQi;

        AnonymousClass1(String str, zzb zzbVar, zzqc zzqcVar) {
            zzlu.this = r1;
            this.zzQg = str;
            this.zzQh = zzbVar;
            this.zzQi = zzqcVar;
        }

        @Override // com.google.android.gms.internal.zzlt.zza
        public void zze(final zzjb zzjbVar) {
            zzhx zzhxVar = new zzhx() { // from class: com.google.android.gms.internal.zzlu.1.1
                {
                    AnonymousClass1.this = this;
                }

                public void zza(zzqp zzqpVar, Map<String, String> map) {
                    try {
                        String str = map.get("success");
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (AnonymousClass1.this.zzQg.equals(new JSONObject(str).optString("ads_id", ""))) {
                            zzjbVar.zzb("/nativeAdPreProcess", AnonymousClass1.this.zzQh.zzQz);
                            AnonymousClass1.this.zzQi.zzh(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        }
                    } catch (JSONException e) {
                        zzpe.zzb("Malformed native JSON response.", e);
                        zzlu.this.zzS(0);
                        com.google.android.gms.common.internal.zzac.zza(zzlu.this.zziQ(), "Unable to set the ad state error!");
                        AnonymousClass1.this.zzQi.zzh(null);
                    }
                }
            };
            this.zzQh.zzQz = zzhxVar;
            zzjbVar.zza("/nativeAdPreProcess", zzhxVar);
            try {
                JSONObject jSONObject = new JSONObject(zzlu.this.zzhh.zzVB.body);
                jSONObject.put("ads_id", this.zzQg);
                zzjbVar.zza("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
            } catch (JSONException e) {
                zzpe.zzc("Exception occurred while invoking javascript", e);
                this.zzQi.zzh(null);
            }
        }

        @Override // com.google.android.gms.internal.zzlt.zza
        public void zziO() {
            this.zzQi.zzh(null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlu$2 */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ zzqc zzQl;
        final /* synthetic */ String zzQm;

        AnonymousClass2(zzqc zzqcVar, String str) {
            zzlu.this = r1;
            this.zzQl = zzqcVar;
            this.zzQm = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.zzQl.zzh((zzhm) zzlu.this.zzbec.zzcs().get(this.zzQm));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlu$3 */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements zzhx {
        final /* synthetic */ zzgr zzQn;

        AnonymousClass3(zzgr zzgrVar) {
            zzlu.this = r1;
            this.zzQn = zzgrVar;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzhh, com.google.android.gms.internal.zzgr] */
        public void zza(zzqp zzqpVar, Map<String, String> map) {
            zzlu.zza(zzlu.this, this.zzQn, map.get("asset"));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlu$4 */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 extends zzlt.zza {
        final /* synthetic */ zzhx zzQo;

        AnonymousClass4(zzlu zzluVar, zzhx zzhxVar) {
            this.zzQo = zzhxVar;
        }

        @Override // com.google.android.gms.internal.zzlt.zza
        public void zze(zzjb zzjbVar) {
            zzjbVar.zza("/nativeAdCustomClick", this.zzQo);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlu$5 */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass5 implements zzqe.zza<List<zzgo>, zzgm> {
        final /* synthetic */ String zzQp;
        final /* synthetic */ Integer zzQq;
        final /* synthetic */ Integer zzQr;
        final /* synthetic */ int zzQs;
        final /* synthetic */ int zzQt;
        final /* synthetic */ int zzQu;
        final /* synthetic */ int zzQv;

        AnonymousClass5(zzlu zzluVar, String str, Integer num, Integer num2, int i, int i2, int i3, int i4) {
            this.zzQp = str;
            this.zzQq = num;
            this.zzQr = num2;
            this.zzQs = i;
            this.zzQt = i2;
            this.zzQu = i3;
            this.zzQv = i4;
        }

        @Override // com.google.android.gms.internal.zzqe.zza
        /* renamed from: zzj */
        public zzgm apply(List<zzgo> list) {
            if (list != null) {
                try {
                    if (list.isEmpty()) {
                        return null;
                    }
                    return new zzgm(this.zzQp, zzlu.zzi(list), this.zzQq, this.zzQr, this.zzQs > 0 ? Integer.valueOf(this.zzQs) : null, this.zzQt + this.zzQu, this.zzQv);
                } catch (RemoteException e) {
                    zzpe.zzb("Could not get attribution icon", e);
                    return null;
                }
            }
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlu$6 */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass6 implements zzpp.zza<zzgo> {
        final /* synthetic */ String zzLG;
        final /* synthetic */ boolean zzQw;
        final /* synthetic */ double zzQx;
        final /* synthetic */ boolean zzQy;

        AnonymousClass6(boolean z, double d, boolean z2, String str) {
            zzlu.this = r1;
            this.zzQw = z;
            this.zzQx = d;
            this.zzQy = z2;
            this.zzLG = str;
        }

        @Override // com.google.android.gms.internal.zzpp.zza
        @TargetApi(19)
        /* renamed from: zzg */
        public zzgo zzh(InputStream inputStream) {
            Bitmap bitmap;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = (int) (this.zzQx * 160.0d);
            if (!this.zzQy) {
                options.inPreferredConfig = Bitmap.Config.RGB_565;
            }
            try {
                bitmap = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (Exception e) {
                zzpe.zzb("Error grabbing image.", e);
                bitmap = null;
            }
            if (bitmap == null) {
                zzlu.this.zza(2, this.zzQw);
                return null;
            }
            if (com.google.android.gms.common.util.zzs.zzyF()) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int allocationByteCount = bitmap.getAllocationByteCount();
                StringBuilder sb = new StringBuilder(61);
                sb.append("Decoded image w: ");
                sb.append(width);
                sb.append(" h:");
                sb.append(height);
                sb.append(" bytes: ");
                sb.append(allocationByteCount);
                zzpe.v(sb.toString());
            }
            return new zzgo(new BitmapDrawable(Resources.getSystem(), bitmap), Uri.parse(this.zzLG), this.zzQx);
        }

        @Override // com.google.android.gms.internal.zzpp.zza
        /* renamed from: zziS */
        public zzgo zziT() {
            zzlu.this.zza(2, this.zzQw);
            return null;
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zza<T extends zzgu.zza> {
        T zza(zzlu zzluVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    /* loaded from: assets/classes2.dex */
    class zzb {
        public zzhx zzQz;

        zzb(zzlu zzluVar) {
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzamr = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzbfy.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(Class<? extends MediationAdapter> cls, Bundle bundle) {
        this.zzbfs.putBundle(cls.getName(), bundle);
    }

    public final void zza(Date date) {
        this.zzhh = date;
    }

    public final void zzad(String str) {
        this.zzbfx.add(str);
    }

    public final void zzae(String str) {
        this.zzbfz.add(str);
    }

    public final void zzaf(String str) {
        this.zzbfz.remove(str);
    }

    public final void zzag(String str) {
        this.zzbec = str;
    }

    public final void zzah(String str) {
        this.zzbea = str;
    }

    public final void zzai(String str) {
        this.zzbeg = str;
    }

    public final void zzaj(String str) {
        this.zzbga.add(str);
    }

    public final void zzb(Location location) {
        this.zzhl = location;
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzbfs.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzbfs.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzbfs.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzd(String str, String str2) {
        this.zzbee.putString(str, str2);
    }

    public final void zzi(boolean z) {
        this.zzbdz = z ? 1 : 0;
    }

    public final void zzj(boolean z) {
        this.zzbei = z;
    }

    public final void zzr(int i) {
        this.zzbdw = i;
    }
}
