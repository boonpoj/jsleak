package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
@zzzv
/* loaded from: classes.dex */
public final class zzads implements RewardItem {
    private final zzadh zzcvd;

    public zzads(zzadh zzadhVar) {
        this.zzcvd = zzadhVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final int getAmount() {
        zzadh zzadhVar = this.zzcvd;
        if (zzadhVar == null) {
            return 0;
        }
        try {
            return zzadhVar.getAmount();
        } catch (RemoteException e) {
            zzakb.zzc("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final String getType() {
        zzadh zzadhVar = this.zzcvd;
        if (zzadhVar == null) {
            return null;
        }
        try {
            return zzadhVar.getType();
        } catch (RemoteException e) {
            zzakb.zzc("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
