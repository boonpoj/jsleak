package com.integralads.avid.library.mopub.session.internal.jsbridge;

import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AvidEvent {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f80;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f81;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private JSONObject f82;

    public AvidEvent() {
    }

    public AvidEvent(int i, String str) {
        this(i, str, null);
    }

    public AvidEvent(int i, String str, JSONObject jSONObject) {
        this.f80 = i;
        this.f81 = str;
        this.f82 = jSONObject;
    }

    public JSONObject getData() {
        return this.f82;
    }

    public int getTag() {
        return this.f80;
    }

    public String getType() {
        return this.f81;
    }

    public void setData(JSONObject jSONObject) {
        this.f82 = jSONObject;
    }

    public void setTag(int i) {
        this.f80 = i;
    }

    public void setType(String str) {
        this.f81 = str;
    }
}
