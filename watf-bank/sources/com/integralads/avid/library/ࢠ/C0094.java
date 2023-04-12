package com.integralads.avid.library.ࢠ;

import android.app.Activity;
import android.content.Context;
import com.integralads.avid.library.ࢠ.C0088;
import com.integralads.avid.library.ࢠ.C0100;
import com.integralads.avid.library.ࢠ.ࢠ.C0085;
import com.integralads.avid.library.ࢠ.ࢥ.C0101;
import com.integralads.avid.library.ࢠ.ࢥ.InterfaceC0103;
import com.integralads.avid.library.ࢠ.ࢦ.AbstractC0105;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107;
import com.integralads.avid.library.ࢠ.ࢧ.C0140;
/* renamed from: com.integralads.avid.library.ࢠ.ࢤ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0094 implements C0088.InterfaceC0090, C0100.InterfaceC0102, InterfaceC0103 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0094 f139 = new C0094();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static Context f140;

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static C0094 m117() {
        return f139;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m118() {
        C0100.m135().m142(this);
        C0100.m135().m143();
        if (C0100.m135().m145()) {
            C0104.m156().m169();
        }
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m119() {
        C0085.m84().m90();
        C0104.m156().m170();
        C0100.m135().m144();
        C0088.m100().m111();
        f140 = null;
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean m120() {
        return !C0101.m146().m154();
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private void m121() {
        C0101.m146().m148((InterfaceC0103) null);
        for (AbstractC0107 abstractC0107 : C0101.m146().m151()) {
            abstractC0107.m202().m217();
        }
        C0101.m146().m148(this);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public AbstractC0107 m122(String str) {
        return C0101.m146().m147(str);
    }

    @Override // com.integralads.avid.library.ࢠ.C0088.InterfaceC0090
    /* renamed from: ࢠ */
    public void mo113() {
        if (m120()) {
            m121();
            if (C0101.m146().m155()) {
                m118();
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m123(Activity activity) {
        C0085.m84().m86(activity);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m124(Context context) {
        if (f140 == null) {
            f140 = context.getApplicationContext();
            C0100.m135().m141(f140);
            C0101.m146().m148(this);
            C0140.m265(f140);
        }
    }

    @Override // com.integralads.avid.library.ࢠ.ࢥ.InterfaceC0103
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo125(C0101 c0101) {
        if (c0101.m154() || C0084.m82()) {
            return;
        }
        C0088.m100().m109(this);
        C0088.m100().m108(f140);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m126(AbstractC0105 abstractC0105, AbstractC0107 abstractC0107) {
        C0101.m146().m150(abstractC0105, abstractC0107);
    }

    @Override // com.integralads.avid.library.ࢠ.C0100.InterfaceC0102
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo127(boolean z) {
        if (z) {
            C0104.m156().m169();
        } else {
            C0104.m156().m171();
        }
    }

    @Override // com.integralads.avid.library.ࢠ.ࢥ.InterfaceC0103
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void mo128(C0101 c0101) {
        if (c0101.m155() && C0084.m82()) {
            m118();
        } else {
            m119();
        }
    }
}
