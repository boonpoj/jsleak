package com.integralads.avid.library.ࢠ.ࢣ;

import com.integralads.avid.library.ࢠ.ࢢ.AbstractC0087;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.C0108;
/* renamed from: com.integralads.avid.library.ࢠ.ࢣ.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0091 extends AbstractC0087 implements InterfaceC0089 {
    public C0091(AbstractC0107 abstractC0107, C0108 c0108) {
        super(abstractC0107, c0108);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢣ.InterfaceC0089
    public void d_() {
        m99();
        if (m97().m201()) {
            throw new IllegalStateException("The AVID ad session is already ready. Please ensure you are only calling recordReadyEvent once for the deferred AVID ad session.");
        }
        m98().m221();
        m97().m180();
    }
}
