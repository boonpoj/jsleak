package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzqe extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzqe$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzqc zzYi;
        final /* synthetic */ zza zzYj;
        final /* synthetic */ zzqf zzYk;

        AnonymousClass1(zzqc zzqcVar, zza zzaVar, zzqf zzqfVar) {
            this.zzYi = zzqcVar;
            this.zzYj = zzaVar;
            this.zzYk = zzqfVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.zzYi.zzh(this.zzYj.apply(this.zzYk.get()));
            } catch (InterruptedException | CancellationException | ExecutionException unused) {
                this.zzYi.cancel(true);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqe$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ AtomicInteger zzYl;
        final /* synthetic */ int zzYm;
        final /* synthetic */ zzqc zzYn;
        final /* synthetic */ List zzYo;

        AnonymousClass2(AtomicInteger atomicInteger, int i, zzqc zzqcVar, List list) {
            this.zzYl = atomicInteger;
            this.zzYm = i;
            this.zzYn = zzqcVar;
            this.zzYo = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.zzYl.incrementAndGet() >= this.zzYm) {
                try {
                    this.zzYn.zzh(zzqe.zzq(this.zzYo));
                } catch (InterruptedException | ExecutionException e) {
                    zzpe.zzc("Unable to convert list of futures to a future of list", e);
                }
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zza<D, R> {
        R apply(D d);
    }

    void destroy() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    String getPrice() throws RemoteException;

    double getStarRating() throws RemoteException;

    String getStore() throws RemoteException;

    zzll getVideoController() throws RemoteException;

    void performClick(Bundle bundle) throws RemoteException;

    boolean recordImpression(Bundle bundle) throws RemoteException;

    void reportTouchEvent(Bundle bundle) throws RemoteException;

    zzpq zzjs() throws RemoteException;

    IObjectWrapper zzjt() throws RemoteException;

    IObjectWrapper zzjx() throws RemoteException;

    zzpm zzjy() throws RemoteException;
}
