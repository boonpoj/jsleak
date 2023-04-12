package com.integralads.avid.library.ࢠ.ࢦ;

import android.app.Activity;
import android.view.View;
import com.integralads.avid.library.ࢠ.C0094;
import com.integralads.avid.library.ࢠ.ࢣ.InterfaceC0089;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107;
import java.util.UUID;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public abstract class AbstractC0105<T extends View> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f167 = UUID.randomUUID().toString();

    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m173() {
        return this.f167;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m174(View view) {
        AbstractC0107 m122 = C0094.m117().m122(m173());
        if (m122 != null) {
            m122.m203().m242(view);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m175(T t, Activity activity) {
        AbstractC0107 m122 = C0094.m117().m122(this.f167);
        if (m122 != null) {
            m122.m188((AbstractC0107) t);
        }
        C0094.m117().m123(activity);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m176() {
        AbstractC0107 m122 = C0094.m117().m122(m173());
        if (m122 != null) {
            m122.mo205();
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public InterfaceC0089 m177() {
        AbstractC0107 m122 = C0094.m117().m122(m173());
        InterfaceC0089 m198 = m122 != null ? m122.m198() : null;
        if (m198 != null) {
            return m198;
        }
        throw new IllegalStateException("The AVID ad session is not deferred. Please ensure you are only using AvidDeferredAdSessionListener for deferred AVID ad session.");
    }
}
