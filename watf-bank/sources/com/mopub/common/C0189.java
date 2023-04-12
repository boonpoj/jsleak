package com.mopub.common;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* renamed from: com.mopub.common.ࢤ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0189 implements SdkInitializationListener {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private SdkInitializationListener f654;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f655;

    public C0189(@NonNull SdkInitializationListener sdkInitializationListener, int i) {
        Preconditions.checkNotNull(sdkInitializationListener);
        this.f654 = sdkInitializationListener;
        this.f655 = i;
    }

    @Override // com.mopub.common.SdkInitializationListener
    public void onInitializationFinished() {
        this.f655--;
        if (this.f655 <= 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mopub.common.ࢤ.1
                @Override // java.lang.Runnable
                public void run() {
                    if (C0189.this.f654 != null) {
                        C0189.this.f654.onInitializationFinished();
                        C0189.this.f654 = null;
                    }
                }
            });
        }
    }
}
