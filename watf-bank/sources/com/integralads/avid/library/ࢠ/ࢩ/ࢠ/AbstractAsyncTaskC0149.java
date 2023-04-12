package com.integralads.avid.library.ࢠ.ࢩ.ࢠ;

import android.os.AsyncTask;
import android.os.Build;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢩ.ࢠ.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public abstract class AbstractAsyncTaskC0149 extends AsyncTask<Object, Void, String> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private InterfaceC0150 f240;

    /* renamed from: ࢥ  reason: contains not printable characters */
    protected final InterfaceC0151 f241;

    /* renamed from: com.integralads.avid.library.ࢠ.ࢩ.ࢠ.ࢢ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0150 {
        /* renamed from: ࢠ  reason: contains not printable characters */
        void mo308(AbstractAsyncTaskC0149 abstractAsyncTaskC0149);
    }

    /* renamed from: com.integralads.avid.library.ࢠ.ࢩ.ࢠ.ࢢ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0151 {
        /* renamed from: ࢠ  reason: contains not printable characters */
        void mo309(JSONObject jSONObject);

        /* renamed from: ࢢ  reason: contains not printable characters */
        JSONObject mo310();
    }

    public AbstractAsyncTaskC0149(InterfaceC0151 interfaceC0151) {
        this.f241 = interfaceC0151;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m305(InterfaceC0150 interfaceC0150) {
        this.f240 = interfaceC0150;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void onPostExecute(String str) {
        if (this.f240 != null) {
            this.f240.mo308(this);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m307(ThreadPoolExecutor threadPoolExecutor) {
        if (Build.VERSION.SDK_INT > 11) {
            executeOnExecutor(threadPoolExecutor, new Object[0]);
        } else {
            execute(new Object[0]);
        }
    }
}
