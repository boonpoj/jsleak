package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
/* loaded from: classes.dex */
public class Response<T extends Result> {
    private T zzfne;

    public Response() {
    }

    protected Response(T t) {
        this.zzfne = t;
    }

    protected T getResult() {
        return this.zzfne;
    }

    public void setResult(T t) {
        this.zzfne = t;
    }
}
