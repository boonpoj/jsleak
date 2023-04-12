package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzcbr extends zzbfm {
    public static final Parcelable.Creator<zzcbr> CREATOR = new zzcbs();
    private int versionCode;
    private zzaz zzibr = null;
    private byte[] zzibs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbr(int i, byte[] bArr) {
        this.versionCode = i;
        this.zzibs = bArr;
        zzanj();
    }

    private final void zzanj() {
        if (this.zzibr != null || this.zzibs == null) {
            if (this.zzibr == null || this.zzibs != null) {
                if (this.zzibr != null && this.zzibs != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.zzibr != null || this.zzibs != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.versionCode);
        byte[] bArr = this.zzibs;
        if (bArr == null) {
            bArr = zzfjs.zzc(this.zzibr);
        }
        zzbfp.zza(parcel, 2, bArr, false);
        zzbfp.zzai(parcel, zze);
    }

    public final zzaz zzaur() {
        if (!(this.zzibr != null)) {
            try {
                this.zzibr = (zzaz) zzfjs.zza(new zzaz(), this.zzibs);
                this.zzibs = null;
            } catch (zzfjr e) {
                throw new IllegalStateException(e);
            }
        }
        zzanj();
        return this.zzibr;
    }
}
