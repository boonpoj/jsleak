package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class zzd<T extends IInterface> {
    private static String[] zzfyy = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Object mLock;
    private final Looper zzall;
    private final com.google.android.gms.common.zzf zzfqc;
    private int zzfyd;
    private long zzfye;
    private long zzfyf;
    private int zzfyg;
    private long zzfyh;
    private zzam zzfyi;
    private final zzag zzfyj;
    private final Object zzfyk;
    private zzay zzfyl;
    protected zzj zzfym;
    private T zzfyn;
    private final ArrayList<zzi<?>> zzfyo;
    private zzl zzfyp;
    private int zzfyq;
    private final zzf zzfyr;
    private final zzg zzfys;
    private final int zzfyt;
    private final String zzfyu;
    private ConnectionResult zzfyv;
    private boolean zzfyw;
    protected AtomicInteger zzfyx;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzd(Context context, Looper looper, int i, zzf zzfVar, zzg zzgVar, String str) {
        this(context, looper, zzag.zzco(context), com.google.android.gms.common.zzf.zzafy(), i, (zzf) zzbq.checkNotNull(zzfVar), (zzg) zzbq.checkNotNull(zzgVar), null);
    }

    protected zzd(Context context, Looper looper, zzag zzagVar, com.google.android.gms.common.zzf zzfVar, int i, zzf zzfVar2, zzg zzgVar, String str) {
        this.mLock = new Object();
        this.zzfyk = new Object();
        this.zzfyo = new ArrayList<>();
        this.zzfyq = 1;
        this.zzfyv = null;
        this.zzfyw = false;
        this.zzfyx = new AtomicInteger(0);
        this.mContext = (Context) zzbq.checkNotNull(context, "Context must not be null");
        this.zzall = (Looper) zzbq.checkNotNull(looper, "Looper must not be null");
        this.zzfyj = (zzag) zzbq.checkNotNull(zzagVar, "Supervisor must not be null");
        this.zzfqc = (com.google.android.gms.common.zzf) zzbq.checkNotNull(zzfVar, "API availability must not be null");
        this.mHandler = new zzh(this, looper);
        this.zzfyt = i;
        this.zzfyr = zzfVar2;
        this.zzfys = zzgVar;
        this.zzfyu = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzay zza(zzd zzdVar, zzay zzayVar) {
        zzdVar.zzfyl = zzayVar;
        return zzayVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object zza(zzd zzdVar) {
        return zzdVar.zzfyk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i, T t) {
        zzbq.checkArgument((i == 4) == (t != null));
        synchronized (this.mLock) {
            this.zzfyq = i;
            this.zzfyn = t;
            if (i != 1) {
                if (i == 2 || i == 3) {
                    if (this.zzfyp != null && this.zzfyi != null) {
                        String zzalo = this.zzfyi.zzalo();
                        String packageName = this.zzfyi.getPackageName();
                        StringBuilder sb = new StringBuilder(String.valueOf(zzalo).length() + 70 + String.valueOf(packageName).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(zzalo);
                        sb.append(" on ");
                        sb.append(packageName);
                        Log.e("GmsClient", sb.toString());
                        this.zzfyj.zza(this.zzfyi.zzalo(), this.zzfyi.getPackageName(), this.zzfyi.zzalk(), this.zzfyp, zzaki());
                        this.zzfyx.incrementAndGet();
                    }
                    this.zzfyp = new zzl(this, this.zzfyx.get());
                    this.zzfyi = new zzam(zzakh(), zzhi(), false, 129);
                    if (!this.zzfyj.zza(new zzah(this.zzfyi.zzalo(), this.zzfyi.getPackageName(), this.zzfyi.zzalk()), this.zzfyp, zzaki())) {
                        String zzalo2 = this.zzfyi.zzalo();
                        String packageName2 = this.zzfyi.getPackageName();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(zzalo2).length() + 34 + String.valueOf(packageName2).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(zzalo2);
                        sb2.append(" on ");
                        sb2.append(packageName2);
                        Log.e("GmsClient", sb2.toString());
                        zza(16, (Bundle) null, this.zzfyx.get());
                    }
                } else if (i == 4) {
                    zza((zzd<T>) t);
                }
            } else if (this.zzfyp != null) {
                this.zzfyj.zza(zzhi(), zzakh(), 129, this.zzfyp, zzaki());
                this.zzfyp = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzd zzdVar, int i) {
        zzdVar.zzcf(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zza(int i, int i2, T t) {
        synchronized (this.mLock) {
            if (this.zzfyq != i) {
                return false;
            }
            zza(i2, (int) t);
            return true;
        }
    }

    private final String zzaki() {
        String str = this.zzfyu;
        return str == null ? this.mContext.getClass().getName() : str;
    }

    private final boolean zzakk() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfyq == 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzakq() {
        if (this.zzfyw || TextUtils.isEmpty(zzhj()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(zzhj());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzcf(int i) {
        int i2;
        if (zzakk()) {
            i2 = 5;
            this.zzfyw = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(i2, this.zzfyx.get(), 16));
    }

    public void disconnect() {
        this.zzfyx.incrementAndGet();
        synchronized (this.zzfyo) {
            int size = this.zzfyo.size();
            for (int i = 0; i < size; i++) {
                this.zzfyo.get(i).removeListener();
            }
            this.zzfyo.clear();
        }
        synchronized (this.zzfyk) {
            this.zzfyl = null;
        }
        zza(1, (int) null);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        zzay zzayVar;
        synchronized (this.mLock) {
            i = this.zzfyq;
            t = this.zzfyn;
        }
        synchronized (this.zzfyk) {
            zzayVar = this.zzfyl;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        printWriter.print(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) zzhj()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (zzayVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(zzayVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzfyf > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.zzfyf;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzfye > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.zzfyd;
            printWriter.append((CharSequence) (i2 != 1 ? i2 != 2 ? String.valueOf(i2) : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED"));
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzfye;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzfyh > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzfyg));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzfyh;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzall;
    }

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public final boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfyq == 4;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfyq == 2 || this.zzfyq == 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzfyg = connectionResult.getErrorCode();
        this.zzfyh = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnectionSuspended(int i) {
        this.zzfyd = i;
        this.zzfye = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(int i, Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzo(this, i, null)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzn(this, i, iBinder, bundle)));
    }

    protected void zza(T t) {
        this.zzfyf = System.currentTimeMillis();
    }

    public final void zza(zzan zzanVar, Set<Scope> set) {
        Bundle zzaap = zzaap();
        zzz zzzVar = new zzz(this.zzfyt);
        zzzVar.zzfzt = this.mContext.getPackageName();
        zzzVar.zzfzw = zzaap;
        if (set != null) {
            zzzVar.zzfzv = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (zzaay()) {
            zzzVar.zzfzx = getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
            if (zzanVar != null) {
                zzzVar.zzfzu = zzanVar.asBinder();
            }
        } else if (zzako()) {
            zzzVar.zzfzx = getAccount();
        }
        zzzVar.zzfzy = zzakl();
        try {
            synchronized (this.zzfyk) {
                if (this.zzfyl != null) {
                    this.zzfyl.zza(new zzk(this, this.zzfyx.get()), zzzVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            zzce(1);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            zza(8, (IBinder) null, (Bundle) null, this.zzfyx.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            zza(8, (IBinder) null, (Bundle) null, this.zzfyx.get());
        }
    }

    public void zza(zzj zzjVar) {
        this.zzfym = (zzj) zzbq.checkNotNull(zzjVar, "Connection progress callbacks cannot be null.");
        zza(2, (int) null);
    }

    protected final void zza(zzj zzjVar, int i, PendingIntent pendingIntent) {
        this.zzfym = (zzj) zzbq.checkNotNull(zzjVar, "Connection progress callbacks cannot be null.");
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3, this.zzfyx.get(), i, pendingIntent));
    }

    public void zza(zzp zzpVar) {
        zzpVar.zzajf();
    }

    protected Bundle zzaap() {
        return new Bundle();
    }

    public boolean zzaay() {
        return false;
    }

    public boolean zzabj() {
        return false;
    }

    public Bundle zzafi() {
        return null;
    }

    public boolean zzagg() {
        return true;
    }

    public final IBinder zzagh() {
        synchronized (this.zzfyk) {
            if (this.zzfyl == null) {
                return null;
            }
            return this.zzfyl.asBinder();
        }
    }

    public final String zzagi() {
        zzam zzamVar;
        if (!isConnected() || (zzamVar = this.zzfyi) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return zzamVar.getPackageName();
    }

    protected String zzakh() {
        return "com.google.android.gms";
    }

    public final void zzakj() {
        int isGooglePlayServicesAvailable = this.zzfqc.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable == 0) {
            zza(new zzm(this));
            return;
        }
        zza(1, (int) null);
        zza(new zzm(this), isGooglePlayServicesAvailable, (PendingIntent) null);
    }

    public com.google.android.gms.common.zzc[] zzakl() {
        return new com.google.android.gms.common.zzc[0];
    }

    protected final void zzakm() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzakn() throws DeadObjectException {
        T t;
        synchronized (this.mLock) {
            if (this.zzfyq == 5) {
                throw new DeadObjectException();
            }
            zzakm();
            zzbq.zza(this.zzfyn != null, "Client is connected but service is null");
            t = this.zzfyn;
        }
        return t;
    }

    public boolean zzako() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<Scope> zzakp() {
        return Collections.EMPTY_SET;
    }

    public final void zzce(int i) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(6, this.zzfyx.get(), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zzd(IBinder iBinder);

    protected abstract String zzhi();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String zzhj();
}
