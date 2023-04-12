package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class zzi {
    public final int index;
    public final ViewGroup parent;
    public final Context zzair;
    public final ViewGroup.LayoutParams zzcis;

    public zzi(zzanh zzanhVar) throws zzg {
        this.zzcis = zzanhVar.getLayoutParams();
        ViewParent parent = zzanhVar.getParent();
        this.zzair = zzanhVar.zzsu();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        this.parent = (ViewGroup) parent;
        ViewGroup viewGroup = this.parent;
        if (zzanhVar == null) {
            throw null;
        }
        View view = (View) zzanhVar;
        this.index = viewGroup.indexOfChild(view);
        ViewGroup viewGroup2 = this.parent;
        if (zzanhVar == null) {
            throw null;
        }
        viewGroup2.removeView(view);
        zzanhVar.zzad(true);
    }
}
