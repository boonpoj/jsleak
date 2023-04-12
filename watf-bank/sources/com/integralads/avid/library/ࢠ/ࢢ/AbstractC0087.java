package com.integralads.avid.library.ࢠ.ࢢ;

import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.C0108;
/* renamed from: com.integralads.avid.library.ࢠ.ࢢ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public abstract class AbstractC0087 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private AbstractC0107 f126;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private C0108 f127;

    public AbstractC0087(AbstractC0107 abstractC0107, C0108 c0108) {
        this.f126 = abstractC0107;
        this.f127 = c0108;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m96() {
        this.f126 = null;
        this.f127 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public AbstractC0107 m97() {
        return this.f126;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public C0108 m98() {
        return this.f127;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m99() {
        if (this.f126 == null) {
            throw new IllegalStateException("The AVID ad session is ended. Please ensure you are not recording events after the session has ended.");
        }
    }
}
