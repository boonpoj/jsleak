package com.mopub.volley;

import android.content.Intent;
/* loaded from: assets/classes2.dex */
public class AuthFailureError extends VolleyError {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Intent f2091;

    public AuthFailureError() {
    }

    public AuthFailureError(Intent intent) {
        this.f2091 = intent;
    }

    public AuthFailureError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public AuthFailureError(String str) {
        super(str);
    }

    public AuthFailureError(String str, Exception exc) {
        super(str, exc);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f2091 != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public Intent getResolutionIntent() {
        return this.f2091;
    }
}
