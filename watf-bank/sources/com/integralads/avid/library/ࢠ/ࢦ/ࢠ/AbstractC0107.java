package com.integralads.avid.library.ࢠ.ࢦ.ࢠ;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.AvidBridge;
import com.integralads.avid.library.ࢠ.ࢣ.C0091;
import com.integralads.avid.library.ࢠ.ࢣ.InterfaceC0089;
import com.integralads.avid.library.ࢠ.ࢦ.C0136;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.C0108;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.C0115;
import com.integralads.avid.library.ࢠ.ࢧ.C0140;
import com.integralads.avid.library.ࢠ.ࢧ.C0142;
import com.integralads.avid.library.ࢠ.ࢪ.C0159;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public abstract class AbstractC0107<T extends View> implements C0108.InterfaceC0110 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final C0116 f168;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private C0108 f169;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private C0115 f170;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private C0159<T> f171;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private C0091 f172;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private InterfaceC0121 f173;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f174;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f175;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final C0128 f176;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private EnumC0109 f177;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private double f178;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0109 {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_HIDDEN
    }

    public AbstractC0107(Context context, String str, C0136 c0136) {
        this.f168 = new C0116(context, str, mo187().toString(), mo192().toString(), c0136);
        this.f169 = new C0108(this.f168);
        this.f169.m213(this);
        this.f170 = new C0115(this.f168, this.f169);
        this.f171 = new C0159<>(null);
        this.f174 = !c0136.m249();
        if (!this.f174) {
            this.f172 = new C0091(this, this.f169);
        }
        this.f176 = new C0128();
        m179();
    }

    /* renamed from: ޅ  reason: contains not printable characters */
    private void m179() {
        this.f178 = C0142.m278();
        this.f177 = EnumC0109.AD_STATE_IDLE;
    }

    /* renamed from: ֏  reason: contains not printable characters */
    public void m180() {
        this.f174 = true;
        m185();
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.C0108.InterfaceC0110
    /* renamed from: ؠ  reason: contains not printable characters */
    public void mo181() {
        m185();
    }

    /* renamed from: ހ  reason: contains not printable characters */
    protected void m182() {
        if (m200()) {
            this.f169.m218(C0140.m262().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ށ  reason: contains not printable characters */
    public void mo183() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ނ  reason: contains not printable characters */
    public void m184() {
        this.f170.m229(mo186());
    }

    /* renamed from: ރ  reason: contains not printable characters */
    protected void m185() {
        boolean z = this.f169.m216() && this.f174 && !m199();
        if (this.f175 != z) {
            m194(z);
        }
    }

    /* renamed from: ބ  reason: contains not printable characters */
    public abstract WebView mo186();

    /* renamed from: ࢠ  reason: contains not printable characters */
    public abstract EnumC0129 mo187();

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m188(T t) {
        if (m195(t)) {
            return;
        }
        m179();
        this.f171.m323(t);
        mo183();
        m185();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m189(InterfaceC0121 interfaceC0121) {
        this.f173 = interfaceC0121;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m190(String str, double d) {
        if (d > this.f178) {
            this.f169.m214(str);
            this.f177 = EnumC0109.AD_STATE_VISIBLE;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m191(boolean z) {
        if (m200()) {
            this.f169.m220(z ? AvidBridge.APP_STATE_ACTIVE : AvidBridge.APP_STATE_INACTIVE);
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public abstract EnumC0127 mo192();

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m193(String str, double d) {
        if (d <= this.f178 || this.f177 == EnumC0109.AD_STATE_HIDDEN) {
            return;
        }
        this.f169.m214(str);
        this.f177 = EnumC0109.AD_STATE_HIDDEN;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected void m194(boolean z) {
        this.f175 = z;
        if (this.f173 != null) {
            if (z) {
                this.f173.mo152(this);
            } else {
                this.f173.mo153(this);
            }
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m195(View view) {
        return this.f171.m325(view);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public String m196() {
        return this.f168.m231();
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public T m197() {
        return (T) this.f171.m322();
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    public InterfaceC0089 m198() {
        return this.f172;
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    public boolean m199() {
        return this.f171.m324();
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    public boolean m200() {
        return this.f175;
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    public boolean m201() {
        return this.f174;
    }

    /* renamed from: ࢩ  reason: contains not printable characters */
    public C0108 m202() {
        return this.f169;
    }

    /* renamed from: ࢪ  reason: contains not printable characters */
    public C0128 m203() {
        return this.f176;
    }

    /* renamed from: ࢫ  reason: contains not printable characters */
    public void mo204() {
    }

    /* renamed from: ࢬ  reason: contains not printable characters */
    public void mo205() {
        m182();
        if (this.f172 != null) {
            this.f172.m96();
        }
        this.f169.m219();
        this.f170.m230();
        this.f174 = false;
        m185();
        if (this.f173 != null) {
            this.f173.mo149(this);
        }
    }
}
