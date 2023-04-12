package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class zzaxs extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzaxs> CREATOR = new zzaxt();
    final int mVersionCode;
    final boolean zzbCn;
    final List<Scope> zzbCo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaxs(int i, boolean z, List<Scope> list) {
        this.mVersionCode = i;
        this.zzbCn = z;
        this.zzbCo = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaxt.zza(this, parcel, i);
    }
}
