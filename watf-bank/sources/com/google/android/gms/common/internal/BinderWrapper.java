package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzq();
    private IBinder zzfzf;

    public BinderWrapper() {
        this.zzfzf = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.zzfzf = null;
        this.zzfzf = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzfzf = null;
        this.zzfzf = parcel.readStrongBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ BinderWrapper(Parcel parcel, zzq zzqVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzfzf);
    }
}
