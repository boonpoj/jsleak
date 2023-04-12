package com.integralads.avid.library.ࢠ.ࢩ.ࢠ;

import com.integralads.avid.library.ࢠ.ࢥ.C0101;
import com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AbstractAsyncTaskC0149;
import java.util.HashSet;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢩ.ࢠ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public abstract class AbstractAsyncTaskC0148 extends AbstractAsyncTaskC0149 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected final C0101 f236;

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected final HashSet<String> f237;

    /* renamed from: ࢣ  reason: contains not printable characters */
    protected final JSONObject f238;

    /* renamed from: ࢤ  reason: contains not printable characters */
    protected final double f239;

    public AbstractAsyncTaskC0148(AbstractAsyncTaskC0149.InterfaceC0151 interfaceC0151, C0101 c0101, HashSet<String> hashSet, JSONObject jSONObject, double d) {
        super(interfaceC0151);
        this.f236 = c0101;
        this.f237 = new HashSet<>(hashSet);
        this.f238 = jSONObject;
        this.f239 = d;
    }
}
