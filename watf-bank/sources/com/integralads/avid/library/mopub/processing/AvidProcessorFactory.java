package com.integralads.avid.library.mopub.processing;
/* loaded from: assets/classes2.dex */
public class AvidProcessorFactory {

    /* renamed from: ࢢ  reason: contains not printable characters */
    private AvidViewProcessor f39 = new AvidViewProcessor();

    /* renamed from: ࢠ  reason: contains not printable characters */
    private AvidSceenProcessor f38 = new AvidSceenProcessor(this.f39);

    public IAvidNodeProcessor getRootProcessor() {
        return this.f38;
    }
}
