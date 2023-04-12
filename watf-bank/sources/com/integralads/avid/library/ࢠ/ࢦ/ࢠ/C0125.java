package com.integralads.avid.library.ࢠ.ࢦ.ࢠ;

import android.content.Context;
import com.integralads.avid.library.ࢠ.ࢦ.C0136;
import com.integralads.avid.library.ࢠ.ࢨ.C0146;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢧ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0125 extends AbstractC0124 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private C0146 f211;

    public C0125(Context context, String str, C0136 c0136) {
        super(context, str, c0136);
        this.f211 = new C0146(this, m202());
    }

    /* renamed from: ކ  reason: contains not printable characters */
    public C0146 m240() {
        return this.f211;
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107
    /* renamed from: ࢠ */
    public EnumC0129 mo187() {
        return EnumC0129.MANAGED_VIDEO;
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107
    /* renamed from: ࢢ */
    public EnumC0127 mo192() {
        return EnumC0127.VIDEO;
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107
    /* renamed from: ࢬ */
    public void mo205() {
        this.f211.m96();
        super.mo205();
    }
}
