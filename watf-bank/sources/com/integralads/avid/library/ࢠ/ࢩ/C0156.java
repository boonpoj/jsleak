package com.integralads.avid.library.ࢠ.ࢩ;

import android.support.annotation.VisibleForTesting;
import com.integralads.avid.library.ࢠ.ࢥ.C0101;
import com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AbstractAsyncTaskC0149;
import com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AsyncTaskC0153;
import com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AsyncTaskC0154;
import com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AsyncTaskC0155;
import com.integralads.avid.library.ࢠ.ࢩ.ࢠ.C0152;
import java.util.HashSet;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢩ.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0156 implements AbstractAsyncTaskC0149.InterfaceC0151 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final C0101 f246;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private JSONObject f247;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final C0152 f248;

    public C0156(C0101 c0101, C0152 c0152) {
        this.f246 = c0101;
        this.f248 = c0152;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m317() {
        this.f248.m312(new AsyncTaskC0153(this));
    }

    @Override // com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AbstractAsyncTaskC0149.InterfaceC0151
    @VisibleForTesting
    /* renamed from: ࢠ */
    public void mo309(JSONObject jSONObject) {
        this.f247 = jSONObject;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m318(JSONObject jSONObject, HashSet<String> hashSet, double d) {
        this.f248.m312(new AsyncTaskC0155(this, this.f246, hashSet, jSONObject, d));
    }

    @Override // com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AbstractAsyncTaskC0149.InterfaceC0151
    @VisibleForTesting
    /* renamed from: ࢢ */
    public JSONObject mo310() {
        return this.f247;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m319(JSONObject jSONObject, HashSet<String> hashSet, double d) {
        this.f248.m312(new AsyncTaskC0154(this, this.f246, hashSet, jSONObject, d));
    }
}
