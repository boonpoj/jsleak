package com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ;

import android.text.TextUtils;
import android.webkit.WebView;
import com.integralads.avid.library.ࢠ.C0084;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.C0116;
import com.integralads.avid.library.ࢠ.ࢧ.C0138;
import com.integralads.avid.library.ࢠ.ࢪ.C0160;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0108 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final C0116 f179;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean f180;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f182;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private InterfaceC0110 f183;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final ArrayList<C0111> f184 = new ArrayList<>();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private C0160 f181 = new C0160(null);

    /* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.ࢠ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0110 {
        /* renamed from: ؠ */
        void mo181();
    }

    public C0108(C0116 c0116) {
        this.f179 = c0116;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m206(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        m214(!TextUtils.isEmpty(jSONObject2) ? C0138.m255(str, jSONObject2) : C0138.m257(str));
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private void m207() {
        if (this.f181.m324()) {
            return;
        }
        this.f180 = true;
        this.f181.m320(C0084.m83());
        m209();
        m208();
        m211();
        m210();
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private void m208() {
        if (m216() && this.f182) {
            m214(C0138.m253());
        }
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    private void m209() {
        m214(C0138.m258(this.f179.m232().toString()));
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    private void m210() {
        if (this.f183 != null) {
            this.f183.mo181();
        }
    }

    /* renamed from: ࢩ  reason: contains not printable characters */
    private void m211() {
        Iterator<C0111> it = this.f184.iterator();
        while (it.hasNext()) {
            C0111 next = it.next();
            m206(next.m222(), next.m223());
        }
        this.f184.clear();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m212(WebView webView) {
        if (this.f181.m322() == webView) {
            return;
        }
        this.f181.m323((C0160) webView);
        this.f180 = false;
        if (C0084.m82()) {
            m207();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m213(InterfaceC0110 interfaceC0110) {
        this.f183 = interfaceC0110;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m214(String str) {
        this.f181.m321(str);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m215(String str, JSONObject jSONObject) {
        if (m216()) {
            m206(str, jSONObject);
        } else {
            this.f184.add(new C0111(1, str, jSONObject));
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m216() {
        return this.f180;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m217() {
        m207();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m218(String str) {
        m214(C0138.m254(str));
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m219() {
        m212((WebView) null);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m220(String str) {
        m214(C0138.m256(str));
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m221() {
        this.f182 = true;
        m208();
    }
}
