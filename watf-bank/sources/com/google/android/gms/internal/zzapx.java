package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzaf;
/* loaded from: assets/classes2.dex */
public final class zzapx extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzapx> CREATOR = new zzapy();
    public final int versionCode;
    private zzaf.zza zzbfG = null;
    private byte[] zzbfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapx(int i, byte[] bArr) {
        this.versionCode = i;
        this.zzbfH = bArr;
        zzzg();
    }

    private void zzze() {
        if (!zzzf()) {
            try {
                this.zzbfG = zzaf.zza.zzd(this.zzbfH);
                this.zzbfH = null;
            } catch (zzbus e) {
                throw new IllegalStateException(e);
            }
        }
        zzzg();
    }

    private boolean zzzf() {
        return this.zzbfG != null;
    }

    private void zzzg() {
        if (this.zzbfG != null || this.zzbfH == null) {
            if (this.zzbfG == null || this.zzbfH != null) {
                if (this.zzbfG != null && this.zzbfH != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.zzbfG != null || this.zzbfH != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzapy.zza(this, parcel, i);
    }

    public byte[] zzFY() {
        return this.zzbfH != null ? this.zzbfH : zzbut.zzf(this.zzbfG);
    }

    public zzaf.zza zzFZ() {
        zzze();
        return this.zzbfG;
    }
}
