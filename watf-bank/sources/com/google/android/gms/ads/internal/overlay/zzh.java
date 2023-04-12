package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzaig;
import com.google.android.gms.internal.zzzv;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzv
/* loaded from: classes.dex */
public final class zzh extends RelativeLayout {
    private zzaig zzavh;
    boolean zzcir;

    public zzh(Context context, String str, String str2) {
        super(context);
        this.zzavh = new zzaig(context, str);
        this.zzavh.zzcl(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzcir) {
            return false;
        }
        this.zzavh.zze(motionEvent);
        return false;
    }
}
