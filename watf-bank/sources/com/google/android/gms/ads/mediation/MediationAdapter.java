package com.google.android.gms.ads.mediation;

import android.os.Bundle;
/* loaded from: classes.dex */
public interface MediationAdapter {

    /* loaded from: classes.dex */
    public static class zza {
        private int zzdnt;

        public final zza zzah(int i) {
            this.zzdnt = 1;
            return this;
        }

        public final Bundle zzuk() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzdnt);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
