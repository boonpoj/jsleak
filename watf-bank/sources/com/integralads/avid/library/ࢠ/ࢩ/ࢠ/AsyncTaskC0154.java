package com.integralads.avid.library.ࢠ.ࢩ.ࢠ;

import com.integralads.avid.library.ࢠ.ࢥ.C0101;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107;
import com.integralads.avid.library.ࢠ.ࢧ.C0138;
import com.integralads.avid.library.ࢠ.ࢧ.C0140;
import com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AbstractAsyncTaskC0149;
import java.util.HashSet;
import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢩ.ࢠ.ࢥ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class AsyncTaskC0154 extends AbstractAsyncTaskC0148 {
    public AsyncTaskC0154(AbstractAsyncTaskC0149.InterfaceC0151 interfaceC0151, C0101 c0101, HashSet<String> hashSet, JSONObject jSONObject, double d) {
        super(interfaceC0151, c0101, hashSet, jSONObject, d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String doInBackground(Object... objArr) {
        return C0138.m254(C0140.m264(this.f238, this.f239).toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.integralads.avid.library.ࢠ.ࢩ.ࢠ.AbstractAsyncTaskC0149, android.os.AsyncTask
    /* renamed from: ࢠ */
    public void onPostExecute(String str) {
        for (AbstractC0107 abstractC0107 : this.f236.m151()) {
            if (this.f237.contains(abstractC0107.m196())) {
                abstractC0107.m193(str, this.f239);
            }
        }
        super.onPostExecute(str);
    }
}
