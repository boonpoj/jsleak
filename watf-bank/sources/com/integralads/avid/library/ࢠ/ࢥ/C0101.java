package com.integralads.avid.library.ࢠ.ࢥ;

import com.integralads.avid.library.ࢠ.ࢦ.AbstractC0105;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.InterfaceC0121;
import java.util.Collection;
import java.util.HashMap;
/* renamed from: com.integralads.avid.library.ࢠ.ࢥ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0101 implements InterfaceC0121 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0101 f152 = new C0101();

    /* renamed from: ࢤ  reason: contains not printable characters */
    private InterfaceC0103 f155;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final HashMap<String, AbstractC0107> f153 = new HashMap<>();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final HashMap<String, AbstractC0105> f154 = new HashMap<>();

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f156 = 0;

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0101 m146() {
        return f152;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public AbstractC0107 m147(String str) {
        return this.f153.get(str);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m148(InterfaceC0103 interfaceC0103) {
        this.f155 = interfaceC0103;
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.InterfaceC0121
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo149(AbstractC0107 abstractC0107) {
        this.f154.remove(abstractC0107.m196());
        this.f153.remove(abstractC0107.m196());
        abstractC0107.m189((InterfaceC0121) null);
        if (this.f154.size() != 0 || this.f155 == null) {
            return;
        }
        this.f155.mo125(this);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m150(AbstractC0105 abstractC0105, AbstractC0107 abstractC0107) {
        this.f154.put(abstractC0105.m173(), abstractC0105);
        this.f153.put(abstractC0105.m173(), abstractC0107);
        abstractC0107.m189(this);
        if (this.f154.size() != 1 || this.f155 == null) {
            return;
        }
        this.f155.mo125(this);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public Collection<AbstractC0107> m151() {
        return this.f153.values();
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.InterfaceC0121
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void mo152(AbstractC0107 abstractC0107) {
        this.f156++;
        if (this.f156 != 1 || this.f155 == null) {
            return;
        }
        this.f155.mo128(this);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.InterfaceC0121
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void mo153(AbstractC0107 abstractC0107) {
        this.f156--;
        if (this.f156 != 0 || this.f155 == null) {
            return;
        }
        this.f155.mo128(this);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public boolean m154() {
        return this.f154.isEmpty();
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public boolean m155() {
        return this.f156 > 0;
    }
}
