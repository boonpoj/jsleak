package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Set;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzabj extends zzbfm {
    public static final Parcelable.Creator<zzabj> CREATOR = new zzabl();
    private ParcelFileDescriptor zzcpy;
    private Parcelable zzcpz;
    private boolean zzcqa;

    /* renamed from: com.google.android.gms.internal.zzabj$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzayb zzaAi;

        AnonymousClass1(zzayb zzaybVar) {
            this.zzaAi = zzaybVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzabj.zza(zzabj.this, this.zzaAi);
        }
    }

    @WorkerThread
    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zzb(com.google.android.gms.common.internal.zzr zzrVar, Set<Scope> set);

        void zzi(ConnectionResult connectionResult);
    }

    public zzabj(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzcpy = parcelFileDescriptor;
        this.zzcpz = null;
        this.zzcqa = true;
    }

    public zzabj(zzbfq zzbfqVar) {
        this.zzcpy = null;
        this.zzcpz = zzbfqVar;
        this.zzcqa = false;
    }

    private final <T> ParcelFileDescriptor zze(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] createPipe;
        try {
            createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
        } catch (IOException e) {
            e = e;
            autoCloseOutputStream = null;
        }
        try {
            new Thread(new zzabk(this, autoCloseOutputStream, bArr)).start();
            return createPipe[0];
        } catch (IOException e2) {
            e = e2;
            zzagf.zzb("Error transporting the ad response", e);
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "LargeParcelTeleporter.pipeData.2");
            com.google.android.gms.common.util.zzn.closeQuietly(autoCloseOutputStream);
            return null;
        }
    }

    private final ParcelFileDescriptor zznn() {
        if (this.zzcpy == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzcpz.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzcpy = zze(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.zzcpy;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zznn();
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, (Parcelable) this.zzcpy, i, false);
        zzbfp.zzai(parcel, zze);
    }

    public final <T extends zzbfq> T zza(Parcelable.Creator<T> creator) {
        if (this.zzcqa) {
            ParcelFileDescriptor parcelFileDescriptor = this.zzcpy;
            if (parcelFileDescriptor == null) {
                zzagf.e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr, 0, bArr.length);
                    com.google.android.gms.common.util.zzn.closeQuietly(dataInputStream);
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        this.zzcpz = creator.createFromParcel(obtain);
                        obtain.recycle();
                        this.zzcqa = false;
                    } catch (Throwable th) {
                        obtain.recycle();
                        throw th;
                    }
                } catch (IOException e) {
                    zzagf.zzb("Could not read from parcel file descriptor", e);
                    com.google.android.gms.common.util.zzn.closeQuietly(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                com.google.android.gms.common.util.zzn.closeQuietly(dataInputStream);
                throw th2;
            }
        }
        return (T) this.zzcpz;
    }
}
