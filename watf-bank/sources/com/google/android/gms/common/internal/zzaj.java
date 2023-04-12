package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaj implements ServiceConnection {
    private ComponentName mComponentName;
    private IBinder zzfzf;
    private boolean zzgar;
    private final zzah zzgas;
    private /* synthetic */ zzai zzgat;
    private final Set<ServiceConnection> zzgaq = new HashSet();
    private int mState = 2;

    public zzaj(zzai zzaiVar, zzah zzahVar) {
        this.zzgat = zzaiVar;
        this.zzgas = zzahVar;
    }

    public final IBinder getBinder() {
        return this.zzfzf;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean isBound() {
        return this.zzgar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.zzgat.zzgam;
        synchronized (hashMap) {
            handler = this.zzgat.mHandler;
            handler.removeMessages(1, this.zzgas);
            this.zzfzf = iBinder;
            this.mComponentName = componentName;
            for (ServiceConnection serviceConnection : this.zzgaq) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.mState = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.zzgat.zzgam;
        synchronized (hashMap) {
            handler = this.zzgat.mHandler;
            handler.removeMessages(1, this.zzgas);
            this.zzfzf = null;
            this.mComponentName = componentName;
            for (ServiceConnection serviceConnection : this.zzgaq) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.mState = 2;
        }
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        com.google.android.gms.common.stats.zza unused;
        Context unused2;
        unused = this.zzgat.zzgan;
        unused2 = this.zzgat.mApplicationContext;
        this.zzgas.zzall();
        this.zzgaq.add(serviceConnection);
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zzgaq.contains(serviceConnection);
    }

    public final boolean zzalm() {
        return this.zzgaq.isEmpty();
    }

    public final void zzb(ServiceConnection serviceConnection, String str) {
        com.google.android.gms.common.stats.zza unused;
        Context unused2;
        unused = this.zzgat.zzgan;
        unused2 = this.zzgat.mApplicationContext;
        this.zzgaq.remove(serviceConnection);
    }

    public final void zzgi(String str) {
        com.google.android.gms.common.stats.zza zzaVar;
        Context context;
        Context context2;
        Handler handler;
        Handler handler2;
        long j;
        com.google.android.gms.common.stats.zza unused;
        this.mState = 3;
        zzaVar = this.zzgat.zzgan;
        context = this.zzgat.mApplicationContext;
        this.zzgar = zzaVar.zza(context, str, this.zzgas.zzall(), this, this.zzgas.zzalk());
        if (this.zzgar) {
            handler = this.zzgat.mHandler;
            Message obtainMessage = handler.obtainMessage(1, this.zzgas);
            handler2 = this.zzgat.mHandler;
            j = this.zzgat.zzgap;
            handler2.sendMessageDelayed(obtainMessage, j);
            return;
        }
        this.mState = 2;
        try {
            unused = this.zzgat.zzgan;
            context2 = this.zzgat.mApplicationContext;
            context2.unbindService(this);
        } catch (IllegalArgumentException e) {
        }
    }

    public final void zzgj(String str) {
        Handler handler;
        Context context;
        com.google.android.gms.common.stats.zza unused;
        handler = this.zzgat.mHandler;
        handler.removeMessages(1, this.zzgas);
        unused = this.zzgat.zzgan;
        context = this.zzgat.mApplicationContext;
        context.unbindService(this);
        this.zzgar = false;
        this.mState = 2;
    }
}
