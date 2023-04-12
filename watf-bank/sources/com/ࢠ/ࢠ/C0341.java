package com.ࢠ.ࢠ;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* renamed from: com.ࢠ.ࢠ.ࢬ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0341 extends LinearLayout {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private WindowManager f2393;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private DisplayMetrics f2394;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private ImageView f2395;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f2396;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f2397;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f2398;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private Runnable f2399;

    public C0341(Context context, int i, boolean z) {
        super(context);
        this.f2398 = false;
        this.f2399 = new Runnable() { // from class: com.ࢠ.ࢠ.ࢬ.1
            @Override // java.lang.Runnable
            public void run() {
                C0341.this.f2395.setVisibility(0);
            }
        };
        this.f2393 = (WindowManager) context.getSystemService("window");
        this.f2396 = i;
        this.f2397 = z;
        this.f2394 = getResources().getDisplayMetrics();
        setOrientation(1);
        setBackgroundColor(Color.parseColor("#ffffff"));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2005;
        layoutParams.format = 1;
        layoutParams.flags = 262152;
        layoutParams.width = this.f2394.widthPixels;
        layoutParams.height = C0309.m1773(275.0f);
        layoutParams.gravity = !this.f2397 ? 49 : 17;
        this.f2393.addView(this, layoutParams);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m1909(ࢤ r6) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        frameLayout.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        m1910(r6);
        frameLayout.addView(this.f2395, m1913(r6));
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m1910(ࢤ r5) {
        int m1773 = C0309.m1773(3.0f);
        int m17732 = C0309.m1773(50.0f);
        this.f2395 = new ImageView(getContext());
        this.f2395.setOnClickListener(new View.OnClickListener() { // from class: com.ࢠ.ࢠ.ࢬ.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C0341.this.m1915();
            }
        });
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setCornerRadius(m17732);
        this.f2395.setBackground(gradientDrawable);
        this.f2395.setImageResource(17301560);
        this.f2395.setPadding(m1773, m1773, m1773, m1773);
        this.f2395.setVisibility(4);
        postDelayed(this.f2399, (C0306.m1748().m1753(r5) <= 0 ? C0338.m1885().m1891() : 0L) * 1000);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public ViewGroup m1911(ࢤ r4) {
        m1909(r4);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1912() {
        if (this.f2395 != null) {
            this.f2395.setVisibility(0);
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    FrameLayout.LayoutParams m1913(ࢤ r6) {
        long m1753 = C0306.m1748().m1753(r6);
        int i = 25;
        if (m1753 <= 0) {
            switch (2) {
                case 1:
                    i = 15;
                    break;
                case 2:
                    i = 20;
                    break;
            }
        }
        int m1773 = C0309.m1773(i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m1773, m1773);
        layoutParams.gravity = 53;
        return layoutParams;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m1914() {
        return this.f2398;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public final void m1915() {
        if (this.f2398) {
            return;
        }
        this.f2398 = true;
        removeCallbacks(this.f2399);
        this.f2393.removeViewImmediate(this);
        getContext().sendBroadcast(new Intent(this.f2396 == 1 ? "Ne0hGmDkkivy0aYpZYm" : "PzLLQeMlZSxOpi"));
    }
}
