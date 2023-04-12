package com.mopub.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.common.Constants;
import com.mopub.volley.AuthFailureError;
@SuppressLint({"MissingPermission"})
/* loaded from: assets/classes2.dex */
public class AndroidAuthenticator implements Authenticator {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final AccountManager f2157;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Account f2158;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final String f2159;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final boolean f2160;

    AndroidAuthenticator(AccountManager accountManager, Account account, String str, boolean z) {
        this.f2157 = accountManager;
        this.f2158 = account;
        this.f2159 = str;
        this.f2160 = z;
    }

    public AndroidAuthenticator(Context context, Account account, String str) {
        this(context, account, str, false);
    }

    public AndroidAuthenticator(Context context, Account account, String str, boolean z) {
        this(AccountManager.get(context), account, str, z);
    }

    public Account getAccount() {
        return this.f2158;
    }

    @Override // com.mopub.volley.toolbox.Authenticator
    public String getAuthToken() throws AuthFailureError {
        AccountManagerFuture<Bundle> authToken = this.f2157.getAuthToken(this.f2158, this.f2159, this.f2160, null, null);
        try {
            Bundle result = authToken.getResult();
            String str = null;
            if (authToken.isDone() && !authToken.isCancelled()) {
                if (result.containsKey(Constants.INTENT_SCHEME)) {
                    throw new AuthFailureError((Intent) result.getParcelable(Constants.INTENT_SCHEME));
                }
                str = result.getString("authtoken");
            }
            if (str != null) {
                return str;
            }
            throw new AuthFailureError("Got null auth token for type: " + this.f2159);
        } catch (Exception e) {
            throw new AuthFailureError("Error while retrieving auth token", e);
        }
    }

    public String getAuthTokenType() {
        return this.f2159;
    }

    @Override // com.mopub.volley.toolbox.Authenticator
    public void invalidateAuthToken(String str) {
        this.f2157.invalidateAuthToken(this.f2158.type, str);
    }
}
