package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.List;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzov extends zzou {

    @zzmb
    /* loaded from: assets/classes2.dex */
    public static final class zza {
        public final int errorCode;
        public final zzmh zzSF;
        public final zzmk zzVB;
        @Nullable
        public final JSONObject zzVp;
        public final zzjj zzVr;
        public final long zzVv;
        public final long zzVw;
        @Nullable
        public final zzec zzvj;

        public zza(zzmh zzmhVar, zzmk zzmkVar, zzjj zzjjVar, zzec zzecVar, int i, long j, long j2, JSONObject jSONObject) {
            this.zzSF = zzmhVar;
            this.zzVB = zzmkVar;
            this.zzVr = zzjjVar;
            this.zzvj = zzecVar;
            this.errorCode = i;
            this.zzVv = j;
            this.zzVw = j2;
            this.zzVp = jSONObject;
        }
    }

    List getImages();
}
