package com.integralads.avid.library.ࢠ;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.integralads.avid.library.ࢠ.ࢤ.C0095;
import com.integralads.avid.library.ࢠ.ࢤ.InterfaceC0098;
import com.integralads.avid.library.ࢠ.ࢥ.C0101;
import com.integralads.avid.library.ࢠ.ࢧ.C0140;
import com.integralads.avid.library.ࢠ.ࢧ.C0142;
import com.integralads.avid.library.ࢠ.ࢧ.C0143;
import com.integralads.avid.library.ࢠ.ࢩ.C0147;
import com.integralads.avid.library.ࢠ.ࢩ.C0156;
import com.integralads.avid.library.ࢠ.ࢩ.EnumC0157;
import com.integralads.avid.library.ࢠ.ࢩ.ࢠ.C0152;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0104 implements InterfaceC0098.InterfaceC0099 {

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static HandlerC0131 f158;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f161;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private double f165;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private double f166;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0104 f157 = new C0104();

    /* renamed from: ࢪ  reason: contains not printable characters */
    private static final Runnable f159 = new Runnable() { // from class: com.integralads.avid.library.ࢠ.ࢦ.1
        @Override // java.lang.Runnable
        public void run() {
            if (C0104.f158 != null) {
                C0104.f158.sendEmptyMessage(0);
                C0104.f158.postDelayed(C0104.f159, 200L);
            }
        }
    };

    /* renamed from: ࢣ  reason: contains not printable characters */
    private List<InterfaceC0106> f160 = new ArrayList();

    /* renamed from: ࢦ  reason: contains not printable characters */
    private C0147 f163 = new C0147(C0101.m146());

    /* renamed from: ࢥ  reason: contains not printable characters */
    private C0095 f162 = new C0095();

    /* renamed from: ࢧ  reason: contains not printable characters */
    private C0156 f164 = new C0156(C0101.m146(), new C0152());

    /* renamed from: com.integralads.avid.library.ࢠ.ࢦ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0106 {
        /* renamed from: ࢠ  reason: contains not printable characters */
        void m178(int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.integralads.avid.library.ࢠ.ࢦ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class HandlerC0131 extends Handler {
        private HandlerC0131() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            C0104.m156().m164();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0104 m156() {
        return f157;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m157(long j) {
        if (this.f160.size() > 0) {
            for (InterfaceC0106 interfaceC0106 : this.f160) {
                interfaceC0106.m178(this.f161, j);
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m158(View view, InterfaceC0098 interfaceC0098, JSONObject jSONObject, EnumC0157 enumC0157) {
        interfaceC0098.mo131(view, jSONObject, this, enumC0157 == EnumC0157.ROOT_VIEW);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m160(View view, JSONObject jSONObject) {
        String m297 = this.f163.m297(view);
        if (m297 != null) {
            C0140.m267(jSONObject, m297);
            this.f163.m304();
            return true;
        }
        return false;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m161(View view, JSONObject jSONObject) {
        ArrayList<String> m299 = this.f163.m299(view);
        if (m299 != null) {
            C0140.m268(jSONObject, m299);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public void m164() {
        m165();
        m172();
        m166();
    }

    /* renamed from: ࢩ  reason: contains not printable characters */
    private void m165() {
        this.f161 = 0;
        this.f165 = C0142.m278();
    }

    /* renamed from: ࢪ  reason: contains not printable characters */
    private void m166() {
        this.f166 = C0142.m278();
        m157((long) (this.f166 - this.f165));
    }

    /* renamed from: ࢫ  reason: contains not printable characters */
    private void m167() {
        if (f158 == null) {
            f158 = new HandlerC0131();
            f158.postDelayed(f159, 200L);
        }
    }

    /* renamed from: ࢬ  reason: contains not printable characters */
    private void m168() {
        if (f158 != null) {
            f158.removeCallbacks(f159);
            f158 = null;
        }
    }

    @Override // com.integralads.avid.library.ࢠ.ࢤ.InterfaceC0098.InterfaceC0099
    /* renamed from: ࢠ */
    public void mo134(View view, InterfaceC0098 interfaceC0098, JSONObject jSONObject) {
        EnumC0157 m301;
        if (C0143.m279(view) && (m301 = this.f163.m301(view)) != EnumC0157.UNDERLYING_VIEW) {
            JSONObject mo130 = interfaceC0098.mo130(view);
            C0140.m269(jSONObject, mo130);
            if (!m160(view, mo130)) {
                m161(view, mo130);
                m158(view, interfaceC0098, mo130, m301);
            }
            this.f161++;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m169() {
        m167();
        m164();
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m170() {
        m171();
        this.f160.clear();
        this.f164.m317();
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m171() {
        m168();
    }

    @VisibleForTesting
    /* renamed from: ࢥ  reason: contains not printable characters */
    void m172() {
        this.f163.m302();
        double m278 = C0142.m278();
        InterfaceC0098 m129 = this.f162.m129();
        if (this.f163.m300().size() > 0) {
            this.f164.m319(m129.mo130(null), this.f163.m300(), m278);
        }
        if (this.f163.m298().size() > 0) {
            JSONObject mo130 = m129.mo130(null);
            m158(null, m129, mo130, EnumC0157.ROOT_VIEW);
            C0140.m266(mo130);
            this.f164.m318(mo130, this.f163.m298(), m278);
        } else {
            this.f164.m317();
        }
        this.f163.m303();
    }
}
