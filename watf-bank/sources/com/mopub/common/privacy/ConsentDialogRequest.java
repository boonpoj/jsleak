package com.mopub.common.privacy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubRequest;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.HttpHeaderParser;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: assets/classes2.dex */
public class ConsentDialogRequest extends MoPubRequest<C0181> {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Listener f494;

    /* loaded from: assets/classes2.dex */
    public interface Listener extends Response.ErrorListener {
        void onSuccess(C0181 c0181);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConsentDialogRequest(@NonNull Context context, @NonNull String str, @Nullable Listener listener) {
        super(context, str, listener);
        this.f494 = listener;
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f));
        setShouldCache(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Response<C0181> mo502(NetworkResponse networkResponse) {
        try {
            String string = new JSONObject(m1599(networkResponse)).getString("dialog_html");
            if (TextUtils.isEmpty(string)) {
                throw new JSONException("Empty HTML body");
            }
            return Response.success(new C0181(string), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (JSONException unused) {
            return Response.error(new MoPubNetworkError("Unable to parse consent dialog request network response.", MoPubNetworkError.Reason.BAD_BODY, (Integer) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void deliverResponse(C0181 c0181) {
        if (this.f494 != null) {
            this.f494.onSuccess(c0181);
        }
    }
}
