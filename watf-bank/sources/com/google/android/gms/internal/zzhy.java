package com.google.android.gms.internal;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzhy {
    final long value;
    final String zzbai;
    final int zzbaj;

    /* renamed from: com.google.android.gms.internal.zzhy$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Map zzGB;
        final /* synthetic */ zzqp zzHy;

        AnonymousClass1(Map map, zzqp zzqpVar) {
            this.zzGB = map;
            this.zzHy = zzqpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzpe.zzbc("Received Http request.");
            final JSONObject zzaa = zzhy.this.zzaa((String) this.zzGB.get("http_request"));
            if (zzaa == null) {
                zzpe.e("Response should not be null.");
            } else {
                zzpi.zzWR.post(new Runnable() { // from class: com.google.android.gms.internal.zzhy.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.zzHy.zzb("fetchHttpRequestCompleted", zzaa);
                        zzpe.zzbc("Dispatched http response.");
                    }
                });
            }
        }
    }

    @zzmb
    /* loaded from: assets/classes2.dex */
    static class zza {
        private final String mValue;
        private final String zzAH;

        public zza(String str, String str2) {
            this.zzAH = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zzAH;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzmb
    /* loaded from: assets/classes2.dex */
    static class zzb {
        private final String zzHC;
        private final URL zzHD;
        private final ArrayList<zza> zzHE;
        private final String zzHF;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzHC = str;
            this.zzHD = url;
            if (arrayList == null) {
                this.zzHE = new ArrayList<>();
            } else {
                this.zzHE = arrayList;
            }
            this.zzHF = str2;
        }

        public String zzfZ() {
            return this.zzHC;
        }

        public URL zzga() {
            return this.zzHD;
        }

        public ArrayList<zza> zzgb() {
            return this.zzHE;
        }

        public String zzgc() {
            return this.zzHF;
        }
    }

    @zzmb
    /* loaded from: assets/classes2.dex */
    class zzc {
        private final zzd zzHG;
        private final boolean zzHH;
        private final String zzHI;

        public zzc(zzhy zzhyVar, boolean z, zzd zzdVar, String str) {
            this.zzHH = z;
            this.zzHG = zzdVar;
            this.zzHI = str;
        }

        public String getReason() {
            return this.zzHI;
        }

        public boolean isSuccess() {
            return this.zzHH;
        }

        public zzd zzgd() {
            return this.zzHG;
        }
    }

    @zzmb
    /* loaded from: assets/classes2.dex */
    static class zzd {
        private final String zzFU;
        private final String zzHC;
        private final int zzHJ;
        private final List<zza> zzHK;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzHC = str;
            this.zzHJ = i;
            if (list == null) {
                this.zzHK = new ArrayList();
            } else {
                this.zzHK = list;
            }
            this.zzFU = str2;
        }

        public String getBody() {
            return this.zzFU;
        }

        public int getResponseCode() {
            return this.zzHJ;
        }

        public String zzfZ() {
            return this.zzHC;
        }

        public Iterable<zza> zzge() {
            return this.zzHK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhy(long j, String str, int i) {
        this.value = j;
        this.zzbai = str;
        this.zzbaj = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzhy)) {
            zzhy zzhyVar = (zzhy) obj;
            if (zzhyVar.value == this.value && zzhyVar.zzbaj == this.zzbaj) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
