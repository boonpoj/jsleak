package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;
/* renamed from: com.mopub.nativeads.ࢪ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0287 extends ViewGroup {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final ProgressBar f1957;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f1958;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0287(@NonNull Context context) {
        super(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setVisibility(8);
        setBackgroundColor(-16777216);
        getBackground().setAlpha(180);
        this.f1957 = new ProgressBar(context);
        this.f1958 = Dips.asIntPixels(25.0f, getContext());
        this.f1957.setIndeterminate(true);
        addView(this.f1957);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int i5 = (i + i3) / 2;
            int i6 = (i2 + i4) / 2;
            this.f1957.layout(i5 - this.f1958, i6 - this.f1958, i5 + this.f1958, i6 + this.f1958);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m1550() {
        Views.removeFromParent(this);
        setVisibility(8);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m1551(@NonNull View view) {
        Preconditions.checkNotNull(view);
        View rootView = view.getRootView();
        if (rootView == null || !(rootView instanceof ViewGroup)) {
            return false;
        }
        setVisibility(0);
        setMeasuredDimension(rootView.getWidth(), rootView.getHeight());
        ((ViewGroup) rootView).addView(this);
        forceLayout();
        return true;
    }
}
