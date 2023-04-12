package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzaaz extends zzbfm {
    public static final Parcelable.Creator<zzaaz> CREATOR = new zzaba();
    public final boolean zzcpw;
    public final List<String> zzcpx;

    /* loaded from: assets/classes2.dex */
    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.google.android.gms.common.internal.zzac.zzas(message.what == 1);
            zzaaz.this.zzb((zzc) message.obj);
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class zzb<L> {
        private final L mListener;
        private final String zzaBB;

        zzb(L l, String str) {
            this.mListener = l;
            this.zzaBB = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof zzb) {
                zzb zzbVar = (zzb) obj;
                return this.mListener == zzbVar.mListener && this.zzaBB.equals(zzbVar.zzaBB);
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.mListener) * 31) + this.zzaBB.hashCode();
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zzc<L> {
        void zzs(L l);

        void zzvy();
    }

    public zzaaz() {
        this(false, Collections.emptyList());
    }

    public zzaaz(boolean z, List<String> list) {
        this.zzcpw = z;
        this.zzcpx = list;
    }

    public static zzaaz zzl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new zzaaz();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("reporting_urls");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (JSONException e) {
                    zzagf.zzc("Error grabbing url from json.", e);
                }
            }
        }
        return new zzaaz(jSONObject.optBoolean("enable_protection"), arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzcpw);
        zzbfp.zzb(parcel, 3, this.zzcpx, false);
        zzbfp.zzai(parcel, zze);
    }
}
