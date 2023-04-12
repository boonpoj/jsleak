package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import java.util.Set;
@zzzv
/* loaded from: classes.dex */
public final class zzwr extends zzxb {
    private static Set<String> zzcgk = com.google.android.gms.common.util.zze.zzb("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private final Object mLock;
    private int zzalv;
    private int zzalw;
    private final zzanh zzbyk;
    private final Activity zzcgb;
    private String zzcgl;
    private boolean zzcgm;
    private int zzcgn;
    private int zzcgo;
    private int zzcgp;
    private int zzcgq;
    private zzapa zzcgr;
    private ImageView zzcgs;
    private LinearLayout zzcgt;
    private zzxc zzcgu;
    private PopupWindow zzcgv;
    private RelativeLayout zzcgw;
    private ViewGroup zzcgx;

    public zzwr(zzanh zzanhVar, zzxc zzxcVar) {
        super(zzanhVar, "resize");
        this.zzcgl = "top-right";
        this.zzcgm = true;
        this.zzcgn = 0;
        this.zzcgo = 0;
        this.zzalw = -1;
        this.zzcgp = 0;
        this.zzcgq = 0;
        this.zzalv = -1;
        this.mLock = new Object();
        this.zzbyk = zzanhVar;
        this.zzcgb = zzanhVar.zzsi();
        this.zzcgu = zzxcVar;
    }

    private final void zza(int i, int i2) {
        zzb(i, i2 - com.google.android.gms.ads.internal.zzbs.zzei().zzh(this.zzcgb)[0], this.zzalv, this.zzalw);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f3, code lost:
        if ((r5 + 50) <= r1[1]) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int[] zzmq() {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwr.zzmq():int[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x02b7 A[Catch: all -> 0x0333, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0117, B:60:0x011c, B:62:0x011e, B:64:0x0139, B:66:0x0141, B:68:0x0145, B:70:0x014c, B:72:0x0155, B:74:0x0160, B:77:0x018a, B:81:0x01c0, B:83:0x01c9, B:84:0x01fb, B:115:0x0252, B:116:0x0255, B:124:0x0276, B:125:0x028e, B:126:0x02af, B:128:0x02b7, B:129:0x02c0, B:130:0x02d6, B:133:0x02d9, B:135:0x02e9, B:137:0x02f3, B:139:0x02fc, B:141:0x0305, B:143:0x0312, B:146:0x0321, B:145:0x0320, B:136:0x02ee, B:117:0x0259, B:118:0x025d, B:119:0x0261, B:120:0x0264, B:121:0x0268, B:122:0x026e, B:123:0x0272, B:86:0x01ff, B:89:0x0209, B:92:0x0213, B:95:0x021d, B:98:0x0227, B:101:0x0231, B:75:0x0184, B:76:0x0185, B:150:0x0325, B:151:0x032a, B:149:0x0324, B:153:0x032c, B:154:0x0331), top: B:163:0x0007, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void execute(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            Method dump skipped, instructions count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwr.execute(java.util.Map):void");
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.mLock) {
            this.zzcgn = i;
            this.zzcgo = i2;
            if (this.zzcgv != null && z) {
                int[] zzmq = zzmq();
                if (zzmq != null) {
                    PopupWindow popupWindow = this.zzcgv;
                    zzkb.zzia();
                    int zzc = zzajr.zzc(this.zzcgb, zzmq[0]);
                    zzkb.zzia();
                    popupWindow.update(zzc, zzajr.zzc(this.zzcgb, zzmq[1]), this.zzcgv.getWidth(), this.zzcgv.getHeight());
                    zza(zzmq[0], zzmq[1]);
                } else {
                    zzl(true);
                }
            }
        }
    }

    public final void zzb(int i, int i2) {
        this.zzcgn = i;
        this.zzcgo = i2;
    }

    public final void zzl(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcgv != null) {
                this.zzcgv.dismiss();
                RelativeLayout relativeLayout = this.zzcgw;
                zzanh zzanhVar = this.zzbyk;
                if (zzanhVar == null) {
                    throw null;
                }
                relativeLayout.removeView((View) zzanhVar);
                if (this.zzcgx != null) {
                    this.zzcgx.removeView(this.zzcgs);
                    ViewGroup viewGroup = this.zzcgx;
                    zzanh zzanhVar2 = this.zzbyk;
                    if (zzanhVar2 == null) {
                        throw null;
                    }
                    viewGroup.addView((View) zzanhVar2);
                    this.zzbyk.zza(this.zzcgr);
                }
                if (z) {
                    zzbo("default");
                    if (this.zzcgu != null) {
                        this.zzcgu.zzcu();
                    }
                }
                this.zzcgv = null;
                this.zzcgw = null;
                this.zzcgx = null;
                this.zzcgt = null;
            }
        }
    }

    public final boolean zzmr() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcgv != null;
        }
        return z;
    }
}
