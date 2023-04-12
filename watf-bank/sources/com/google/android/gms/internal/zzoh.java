package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzoh extends RelativeLayout {
    private static final float[] zzbto = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable zzbtp;

    public zzoh(Context context, zzog zzogVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        com.google.android.gms.common.internal.zzbq.checkNotNull(zzogVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzbto, null, null));
        shapeDrawable.getPaint().setColor(zzogVar.getBackgroundColor());
        setLayoutParams(layoutParams);
        com.google.android.gms.ads.internal.zzbs.zzek().setBackground(this, shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzogVar.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzogVar.getText());
            textView.setTextColor(zzogVar.getTextColor());
            textView.setTextSize(zzogVar.getTextSize());
            zzkb.zzia();
            int zzc = zzajr.zzc(context, 4);
            zzkb.zzia();
            textView.setPadding(zzc, 0, zzajr.zzc(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzoi> zzjn = zzogVar.zzjn();
        if (zzjn != null && zzjn.size() > 1) {
            this.zzbtp = new AnimationDrawable();
            for (zzoi zzoiVar : zzjn) {
                try {
                    this.zzbtp.addFrame((Drawable) com.google.android.gms.dynamic.zzn.zzx(zzoiVar.zzjr()), zzogVar.zzjo());
                } catch (Exception e) {
                    zzagf.zzb("Error while getting drawable.", e);
                }
            }
            com.google.android.gms.ads.internal.zzbs.zzek().setBackground(imageView, this.zzbtp);
        } else if (zzjn.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) com.google.android.gms.dynamic.zzn.zzx(zzjn.get(0).zzjr()));
            } catch (Exception e2) {
                zzagf.zzb("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzbtp;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
