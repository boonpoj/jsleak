package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public abstract class zzana implements Releasable {
    protected Context mContext;
    private String zzczb;
    private WeakReference<zzamp> zzdka;

    public zzana(zzamp zzampVar) {
        this.mContext = zzampVar.getContext();
        this.zzczb = com.google.android.gms.ads.internal.zzbs.zzei().zzp(this.mContext, zzampVar.zzsk().zzcv);
        this.zzdka = new WeakReference<>(zzampVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, Map<String, String> map) {
        zzamp zzampVar = this.zzdka.get();
        if (zzampVar != null) {
            zzampVar.zza(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String zzcy(String str) {
        char c;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            default:
                return "internal";
            case 4:
            case 5:
                return "io";
            case 6:
            case 7:
                return "network";
            case '\b':
            case '\t':
                return "policy";
        }
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(String str, String str2, int i) {
        zzajr.zzajw.post(new zzanc(this, str, str2, i));
    }

    public final void zza(String str, String str2, String str3, String str4) {
        zzajr.zzajw.post(new zzand(this, str, str2, str3, str4));
    }

    public abstract boolean zzcx(String str);
}
