package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
@zzzv
/* loaded from: classes.dex */
public final class zzaig {
    private final Context mContext;
    private int mState;
    private String zzapq;
    private String zzavn;
    private final float zzchk;
    private String zzcsd;
    private String zzdbh;
    private float zzdbi;
    private float zzdbj;
    private float zzdbk;

    public zzaig(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzchk = context.getResources().getDisplayMetrics().density;
    }

    public zzaig(Context context, String str) {
        this(context);
        this.zzdbh = str;
    }

    private static int zza(List<String> list, String str, boolean z) {
        if (z) {
            list.add(str);
            return list.size() - 1;
        }
        return -1;
    }

    private final void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzdbi = f;
            this.zzdbj = f2;
            this.zzdbk = f2;
            return;
        }
        int i2 = this.mState;
        if (i2 == -1) {
            return;
        }
        if (i != 2) {
            if (i == 1 && i2 == 4) {
                showDialog();
                return;
            }
            return;
        }
        if (f2 > this.zzdbj) {
            this.zzdbj = f2;
        } else if (f2 < this.zzdbk) {
            this.zzdbk = f2;
        }
        if (this.zzdbj - this.zzdbk > this.zzchk * 30.0f) {
            this.mState = -1;
            return;
        }
        int i3 = this.mState;
        if (i3 == 0 || i3 == 2 ? f - this.zzdbi >= this.zzchk * 50.0f : !((i3 != 1 && i3 != 3) || f - this.zzdbi > this.zzchk * (-50.0f))) {
            this.zzdbi = f;
            this.mState++;
        }
        int i4 = this.mState;
        if (i4 == 1 || i4 == 3) {
            if (f > this.zzdbi) {
                this.zzdbi = f;
            }
        } else if (i4 != 2 || f >= this.zzdbi) {
        } else {
            this.zzdbi = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x006c, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzqm() {
        /*
            r5 = this;
            android.content.Context r0 = r5.mContext
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 != 0) goto Lc
            java.lang.String r0 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.zzagf.zzct(r0)
            return
        Lc:
            java.lang.String r0 = r5.zzdbh
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L6f
            java.lang.String r1 = "\\+"
            java.lang.String r2 = "%20"
            java.lang.String r0 = r0.replaceAll(r1, r2)
            android.net.Uri$Builder r1 = new android.net.Uri$Builder
            r1.<init>()
            android.net.Uri$Builder r0 = r1.encodedQuery(r0)
            android.net.Uri r0 = r0.build()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.google.android.gms.ads.internal.zzbs.zzei()
            java.util.Map r0 = com.google.android.gms.internal.zzahn.zzf(r0)
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L3d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L60
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            r1.append(r3)
            java.lang.String r4 = " = "
            r1.append(r4)
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r1.append(r3)
            java.lang.String r3 = "\n\n"
            r1.append(r3)
            goto L3d
        L60:
            java.lang.String r0 = r1.toString()
            java.lang.String r0 = r0.trim()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L6f
            goto L71
        L6f:
            java.lang.String r0 = "No debug information"
        L71:
            android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
            android.content.Context r2 = r5.mContext
            r1.<init>(r2)
            r1.setMessage(r0)
            java.lang.String r2 = "Ad Information"
            r1.setTitle(r2)
            com.google.android.gms.internal.zzaii r2 = new com.google.android.gms.internal.zzaii
            r2.<init>(r5, r0)
            java.lang.String r0 = "Share"
            r1.setPositiveButton(r0, r2)
            com.google.android.gms.internal.zzaij r0 = new com.google.android.gms.internal.zzaij
            r0.<init>(r5)
            java.lang.String r2 = "Close"
            r1.setNegativeButton(r2, r0)
            android.app.AlertDialog r0 = r1.create()
            r0.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaig.zzqm():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzqn() {
        zzagf.zzbx("Debug mode [Creative Preview] selected.");
        zzahh.zza(new zzaik(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzqo() {
        zzagf.zzbx("Debug mode [Troubleshooting] selected.");
        zzahh.zza(new zzail(this));
    }

    public final void setAdUnitId(String str) {
        this.zzapq = str;
    }

    public final void showDialog() {
        if (!((Boolean) zzkb.zzif().zzd(zznh.zzbqv)).booleanValue()) {
            if (!((Boolean) zzkb.zzif().zzd(zznh.zzbqu)).booleanValue()) {
                zzqm();
                return;
            }
        }
        if (!(this.mContext instanceof Activity)) {
            zzagf.zzct("Can not create dialog without Activity Context");
            return;
        }
        String str = !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzbs.zzer().zzqp()) ? "Creative Preview (Enabled)" : "Creative Preview";
        String str2 = com.google.android.gms.ads.internal.zzbs.zzer().zzqq() ? "Troubleshooting (Enabled)" : "Troubleshooting";
        ArrayList arrayList = new ArrayList();
        int zza = zza((List<String>) arrayList, "Ad Information", true);
        int zza2 = zza(arrayList, str, ((Boolean) zzkb.zzif().zzd(zznh.zzbqu)).booleanValue());
        int zza3 = zza(arrayList, str2, ((Boolean) zzkb.zzif().zzd(zznh.zzbqv)).booleanValue());
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext, com.google.android.gms.ads.internal.zzbs.zzek().zzqk());
        builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzaih(this, zza, zza2, zza3));
        builder.create().show();
    }

    public final void zzcl(String str) {
        this.zzavn = str;
    }

    public final void zzcm(String str) {
        this.zzdbh = str;
    }

    public final void zzcn(String str) {
        this.zzcsd = str;
    }

    public final void zze(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
