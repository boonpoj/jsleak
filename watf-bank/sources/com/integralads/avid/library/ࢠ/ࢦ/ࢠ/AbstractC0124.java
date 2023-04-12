package com.integralads.avid.library.ࢠ.ࢦ.ࢠ;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.ࢠ.ࢦ.C0136;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ.C0118;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ.InterfaceC0117;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢦ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public abstract class AbstractC0124 extends AbstractC0107<View> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private C0118 f209;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final WebView f210;

    public AbstractC0124(Context context, String str, C0136 c0136) {
        super(context, str, c0136);
        this.f210 = new WebView(context.getApplicationContext());
        this.f209 = new C0118(this.f210);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107
    /* renamed from: ބ */
    public WebView mo186() {
        return this.f210;
    }

    /* renamed from: ޅ  reason: contains not printable characters */
    public InterfaceC0117 m239() {
        return this.f209;
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107
    /* renamed from: ࢫ */
    public void mo204() {
        super.mo204();
        m184();
        this.f209.m236();
    }
}
