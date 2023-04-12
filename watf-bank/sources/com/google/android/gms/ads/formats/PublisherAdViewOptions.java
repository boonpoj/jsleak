package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class PublisherAdViewOptions extends zzbfm {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();
    private final boolean zzamr;
    private final zzkx zzams;
    private AppEventListener zzamt;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean zzamr = false;
        private AppEventListener zzamt;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzamt = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzamr = z;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzamr = builder.zzamr;
        this.zzamt = builder.zzamt;
        AppEventListener appEventListener = this.zzamt;
        this.zzams = appEventListener != null ? new zzjp(appEventListener) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublisherAdViewOptions(boolean z, IBinder iBinder) {
        this.zzamr = z;
        this.zzams = iBinder != null ? zzky.zzg(iBinder) : null;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzamt;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzamr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, getManualImpressionsEnabled());
        zzkx zzkxVar = this.zzams;
        zzbfp.zza(parcel, 2, zzkxVar == null ? null : zzkxVar.asBinder(), false);
        zzbfp.zzai(parcel, zze);
    }

    public final zzkx zzbn() {
        return this.zzams;
    }
}
