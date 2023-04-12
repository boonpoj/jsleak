package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.WeakHashMap;
@zzzv
/* loaded from: classes.dex */
public final class zzajn {
    private Context zzajx;
    private boolean zzddh;
    private boolean zzajf = false;
    private final Map<BroadcastReceiver, IntentFilter> zzddg = new WeakHashMap();
    private final BroadcastReceiver zzddf = new zzajo(this);

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzc(Context context, Intent intent) {
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.zzddg.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                entry.getKey().onReceive(context, intent);
            }
        }
    }

    public final synchronized void initialize(Context context) {
        if (this.zzajf) {
            return;
        }
        this.zzajx = context.getApplicationContext();
        if (this.zzajx == null) {
            this.zzajx = context;
        }
        zznh.initialize(this.zzajx);
        this.zzddh = ((Boolean) zzkb.zzif().zzd(zznh.zzbox)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.zzajx.registerReceiver(this.zzddf, intentFilter);
        this.zzajf = true;
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzddh) {
            this.zzddg.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzddh) {
            this.zzddg.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
