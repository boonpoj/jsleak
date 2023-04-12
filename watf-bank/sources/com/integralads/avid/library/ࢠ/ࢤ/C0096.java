package com.integralads.avid.library.ࢠ.ࢤ;

import android.view.View;
import com.integralads.avid.library.ࢠ.ࢠ.C0085;
import com.integralads.avid.library.ࢠ.ࢤ.InterfaceC0098;
import com.integralads.avid.library.ࢠ.ࢧ.C0140;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢤ.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0096 implements InterfaceC0098 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final InterfaceC0098 f143;

    public C0096(InterfaceC0098 interfaceC0098) {
        this.f143 = interfaceC0098;
    }

    @Override // com.integralads.avid.library.ࢠ.ࢤ.InterfaceC0098
    /* renamed from: ࢠ  reason: contains not printable characters */
    public JSONObject mo130(View view) {
        return C0140.m263(0, 0, 0, 0);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢤ.InterfaceC0098
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo131(View view, JSONObject jSONObject, InterfaceC0098.InterfaceC0099 interfaceC0099, boolean z) {
        for (View view2 : C0085.m84().m89()) {
            interfaceC0099.mo134(view2, this.f143, jSONObject);
        }
    }
}
