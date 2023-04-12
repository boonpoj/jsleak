package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzaig;
import com.google.android.gms.internal.zzajq;
import com.google.android.gms.internal.zzanh;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzbu extends ViewSwitcher {
    private final zzaig zzavh;
    private final zzajq zzavi;
    private boolean zzavj;

    public zzbu(Context context, String str, String str2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(context);
        this.zzavh = new zzaig(context);
        this.zzavh.setAdUnitId(str);
        this.zzavh.zzcl(str2);
        this.zzavj = true;
        if (context instanceof Activity) {
            this.zzavi = new zzajq((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
        } else {
            this.zzavi = new zzajq(null, this, onGlobalLayoutListener, onScrollChangedListener);
        }
        this.zzavi.zzqu();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        zzajq zzajqVar = this.zzavi;
        if (zzajqVar != null) {
            zzajqVar.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zzajq zzajqVar = this.zzavi;
        if (zzajqVar != null) {
            zzajqVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzavj) {
            this.zzavh.zze(motionEvent);
            return false;
        }
        return false;
    }

    @Override // android.widget.ViewAnimator, android.view.ViewGroup
    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof zzanh)) {
                arrayList.add((zzanh) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzanh) obj).destroy();
        }
    }

    public final zzaig zzfn() {
        return this.zzavh;
    }

    public final void zzfo() {
        zzagf.v("Disable position monitoring on adFrame.");
        zzajq zzajqVar = this.zzavi;
        if (zzajqVar != null) {
            zzajqVar.zzqv();
        }
    }

    public final void zzfp() {
        zzagf.v("Enable debug gesture detector on adFrame.");
        this.zzavj = true;
    }

    public final void zzfq() {
        zzagf.v("Disable debug gesture detector on adFrame.");
        this.zzavj = false;
    }
}
