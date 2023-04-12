package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzage extends zzagb {
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzage(Context context) {
        this.mContext = context;
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.mContext);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzagf.zzb("Fail to get isAdIdFakeForDebugLogging", e);
            z = false;
        }
        zzajv.zzaa(z);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(z);
        zzagf.zzcu(sb.toString());
    }
}
