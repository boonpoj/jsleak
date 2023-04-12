package com.integralads.avid.library.ࢠ.ࢩ.ࢠ;

import com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AbstractAsyncTaskC0149;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: com.integralads.avid.library.ࢠ.ࢩ.ࢠ.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0152 implements AbstractAsyncTaskC0149.InterfaceC0150 {

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final ArrayDeque<AbstractAsyncTaskC0149> f244 = new ArrayDeque<>();

    /* renamed from: ࢤ  reason: contains not printable characters */
    private AbstractAsyncTaskC0149 f245 = null;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final BlockingQueue<Runnable> f242 = new LinkedBlockingQueue();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final ThreadPoolExecutor f243 = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f242);

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m311() {
        this.f245 = this.f244.poll();
        if (this.f245 != null) {
            this.f245.m307(this.f243);
        }
    }

    @Override // com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AbstractAsyncTaskC0149.InterfaceC0150
    /* renamed from: ࢠ */
    public void mo308(AbstractAsyncTaskC0149 abstractAsyncTaskC0149) {
        this.f245 = null;
        m311();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m312(AbstractAsyncTaskC0149 abstractAsyncTaskC0149) {
        abstractAsyncTaskC0149.m305(this);
        this.f244.add(abstractAsyncTaskC0149);
        if (this.f245 == null) {
            m311();
        }
    }
}
