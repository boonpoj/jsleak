package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface zzzv {

    /* loaded from: assets/classes2.dex */
    public static abstract class zza<R extends Result, A extends Api.zzb> extends zzzx<R> implements zzb<R> {
        private final Api<?> zzawb;
        private final Api.zzc<A> zzayF;

        @Deprecated
        protected zza(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) com.google.android.gms.common.internal.zzac.zzb(googleApiClient, "GoogleApiClient must not be null"));
            this.zzayF = (Api.zzc) com.google.android.gms.common.internal.zzac.zzw(zzcVar);
            this.zzawb = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) com.google.android.gms.common.internal.zzac.zzb(googleApiClient, "GoogleApiClient must not be null"));
            this.zzayF = api.zzuH();
            this.zzawb = api;
        }

        private void zzc(RemoteException remoteException) {
            zzA(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public final Api<?> getApi() {
            return this.zzawb;
        }

        @Override // com.google.android.gms.internal.zzzv.zzb
        public /* synthetic */ void setResult(Object obj) {
            super.zzb((Result) obj);
        }

        @Override // com.google.android.gms.internal.zzzv.zzb
        public final void zzA(Status status) {
            com.google.android.gms.common.internal.zzac.zzb(!status.isSuccess(), "Failed result must not be success");
            zzb(zzc(status));
        }

        protected abstract void zza(A a) throws RemoteException;

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza((zza<R, A>) a);
            } catch (DeadObjectException e) {
                zzc(e);
                throw e;
            } catch (RemoteException e2) {
                zzc(e2);
            }
        }

        public final Api.zzc<A> zzuH() {
            return this.zzayF;
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zzb<R> {
        void setResult(R r);

        void zzA(Status status);
    }
}
