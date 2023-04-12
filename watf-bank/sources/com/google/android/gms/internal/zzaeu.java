package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
/* loaded from: classes.dex */
final class zzaeu implements Runnable {
    private /* synthetic */ zzaes zzcwm;
    private /* synthetic */ zzakv zzcwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeu(zzaes zzaesVar, zzakv zzakvVar) {
        this.zzcwm = zzaesVar;
        this.zzcwn = zzakvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        zzfjw zzfjwVar;
        try {
            this.zzcwm.zzp((Map) this.zzcwn.get());
            if (this.zzcwm.zzcwh) {
                obj = this.zzcwm.mLock;
                synchronized (obj) {
                    zzfjwVar = this.zzcwm.zzcwe;
                    zzfjwVar.zzpnw = 9;
                }
            }
            this.zzcwm.send();
        } catch (InterruptedException | ExecutionException | JSONException e) {
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbqb)).booleanValue()) {
                zzagf.zza("Failed to get SafeBrowsing metadata", e);
            }
        }
    }
}
