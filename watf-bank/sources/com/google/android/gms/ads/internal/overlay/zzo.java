package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public final class zzo extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzcjh;
    private final zzt zzcji;

    public zzo(Context context, zzp zzpVar, zzt zztVar) {
        super(context);
        this.zzcji = zztVar;
        setOnClickListener(this);
        this.zzcjh = new ImageButton(context);
        this.zzcjh.setImageResource(17301527);
        this.zzcjh.setBackgroundColor(0);
        this.zzcjh.setOnClickListener(this);
        ImageButton imageButton = this.zzcjh;
        zzkb.zzia();
        int zzc = zzajr.zzc(context, zzpVar.paddingLeft);
        zzkb.zzia();
        int zzc2 = zzajr.zzc(context, 0);
        zzkb.zzia();
        int zzc3 = zzajr.zzc(context, zzpVar.paddingRight);
        zzkb.zzia();
        imageButton.setPadding(zzc, zzc2, zzc3, zzajr.zzc(context, zzpVar.paddingBottom));
        this.zzcjh.setContentDescription("Interstitial close button");
        zzkb.zzia();
        zzajr.zzc(context, zzpVar.size);
        ImageButton imageButton2 = this.zzcjh;
        zzkb.zzia();
        int zzc4 = zzajr.zzc(context, zzpVar.size + zzpVar.paddingLeft + zzpVar.paddingRight);
        zzkb.zzia();
        addView(imageButton2, new FrameLayout.LayoutParams(zzc4, zzajr.zzc(context, zzpVar.size + zzpVar.paddingBottom), 17));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzt zztVar = this.zzcji;
        if (zztVar != null) {
            zztVar.zzmt();
        }
    }

    public final void zza(boolean z, boolean z2) {
        ImageButton imageButton;
        int i;
        if (!z2) {
            imageButton = this.zzcjh;
            i = 0;
        } else if (z) {
            imageButton = this.zzcjh;
            i = 4;
        } else {
            imageButton = this.zzcjh;
            i = 8;
        }
        imageButton.setVisibility(i);
    }
}
