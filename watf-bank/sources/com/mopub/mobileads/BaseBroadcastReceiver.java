package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
/* loaded from: assets/classes2.dex */
public abstract class BaseBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final long f789;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private Context f790;

    public BaseBroadcastReceiver(long j) {
        this.f789 = j;
    }

    public static void broadcastAction(@NonNull Context context, long j, @NonNull String str) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "action cannot be null");
        Intent intent = new Intent(str);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, j);
        LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(intent);
    }

    @NonNull
    public abstract IntentFilter getIntentFilter();

    public void register(@NonNull BroadcastReceiver broadcastReceiver, Context context) {
        this.f790 = context;
        LocalBroadcastManager.getInstance(this.f790).registerReceiver(broadcastReceiver, getIntentFilter());
    }

    public boolean shouldConsumeBroadcast(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent, "intent cannot be null");
        return this.f789 == intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1L);
    }

    public void unregister(@Nullable BroadcastReceiver broadcastReceiver) {
        if (this.f790 == null || broadcastReceiver == null) {
            return;
        }
        LocalBroadcastManager.getInstance(this.f790).unregisterReceiver(broadcastReceiver);
        this.f790 = null;
    }
}
