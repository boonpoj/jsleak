package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AdvancedBiddingTokens implements InterfaceC0186 {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private List<MoPubAdvancedBidder> f268 = new ArrayList();
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final SdkInitializationListener f269;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.common.AdvancedBiddingTokens$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class AsyncTaskC0162 extends AsyncTask<Void, Void, List<MoPubAdvancedBidder>> {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final List<Class<? extends MoPubAdvancedBidder>> f270;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final InterfaceC0186 f271;

        AsyncTaskC0162(@NonNull List<Class<? extends MoPubAdvancedBidder>> list, @NonNull InterfaceC0186 interfaceC0186) {
            Preconditions.checkNotNull(list);
            Preconditions.checkNotNull(interfaceC0186);
            this.f270 = list;
            this.f271 = interfaceC0186;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public List<MoPubAdvancedBidder> doInBackground(Void... voidArr) {
            ArrayList arrayList = new ArrayList();
            for (Class<? extends MoPubAdvancedBidder> cls : this.f270) {
                try {
                    arrayList.add((MoPubAdvancedBidder) Reflection.instantiateClassWithEmptyConstructor(cls.getName(), MoPubAdvancedBidder.class));
                } catch (Exception unused) {
                    MoPubLog.e("Unable to find class " + cls.getName());
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void onPostExecute(List<MoPubAdvancedBidder> list) {
            this.f271.onAdvancedBiddersInitialized(list);
        }
    }

    public AdvancedBiddingTokens(@Nullable SdkInitializationListener sdkInitializationListener) {
        this.f269 = sdkInitializationListener;
    }

    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    private JSONObject m354(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (this.f268.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (MoPubAdvancedBidder moPubAdvancedBidder : this.f268) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("token", moPubAdvancedBidder.getToken(context));
                jSONObject.put(moPubAdvancedBidder.getCreativeNetworkName(), jSONObject2);
            } catch (JSONException unused) {
                MoPubLog.d("JSON parsing failed for creative network name: " + moPubAdvancedBidder.getCreativeNetworkName());
            }
        }
        return jSONObject;
    }

    public void addAdvancedBidders(@NonNull List<Class<? extends MoPubAdvancedBidder>> list) {
        Preconditions.checkNotNull(list);
        AsyncTasks.safeExecuteOnExecutor(new AsyncTaskC0162(list, this), new Void[0]);
    }

    @Override // com.mopub.common.InterfaceC0186
    public void onAdvancedBiddersInitialized(@NonNull List<MoPubAdvancedBidder> list) {
        Preconditions.checkNotNull(list);
        this.f268 = list;
        if (this.f269 != null) {
            this.f269.onInitializationFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m355(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        JSONObject m354 = m354(context);
        if (m354 == null) {
            return null;
        }
        return m354.toString();
    }
}
