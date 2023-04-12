package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzadp;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzxl;
import com.google.android.gms.internal.zzxr;
import com.google.android.gms.internal.zzzv;
import java.util.Map;
import java.util.concurrent.Future;
@zzzv
/* loaded from: classes.dex */
public final class zzbm extends zzkt {
    private final Context mContext;
    private zzkh zzape;
    private final zzakd zzapr;
    private final zzjn zzasd;
    private final Future<zzcv> zzase = zzahh.zza(zzahh.zzdar, new zzbp(this));
    private final zzbr zzasf;
    private WebView zzasg;
    private zzcv zzash;
    private AsyncTask<Void, Void, String> zzasi;

    public zzbm(Context context, zzjn zzjnVar, String str, zzakd zzakdVar) {
        this.mContext = context;
        this.zzapr = zzakdVar;
        this.zzasd = zzjnVar;
        this.zzasg = new WebView(this.mContext);
        this.zzasf = new zzbr(str);
        zzk(0);
        this.zzasg.setVerticalScrollBarEnabled(false);
        this.zzasg.getSettings().setJavaScriptEnabled(true);
        this.zzasg.setWebViewClient(new zzbn(this));
        this.zzasg.setOnTouchListener(new zzbo(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzw(String str) {
        if (this.zzash == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzash.zza(parse, this.mContext, null, null);
        } catch (zzcw e) {
            zzagf.zzc("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzx(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.mContext.startActivity(intent);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void destroy() throws RemoteException {
        com.google.android.gms.common.internal.zzbq.zzge("destroy must be called on the main UI thread.");
        this.zzasi.cancel(true);
        this.zzase.cancel(true);
        this.zzasg.destroy();
        this.zzasg = null;
    }

    @Override // com.google.android.gms.internal.zzks
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.zzks
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzll getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzks
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.zzks
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void pause() throws RemoteException {
        com.google.android.gms.common.internal.zzbq.zzge("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void resume() throws RemoteException {
        com.google.android.gms.common.internal.zzbq.zzge("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzks
    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzadp zzadpVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzjn zzjnVar) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzke zzkeVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzkh zzkhVar) throws RemoteException {
        this.zzape = zzkhVar;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzkx zzkxVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzld zzldVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzlr zzlrVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzmr zzmrVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzoa zzoaVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzxl zzxlVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzxr zzxrVar, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final boolean zzb(zzjj zzjjVar) throws RemoteException {
        com.google.android.gms.common.internal.zzbq.checkNotNull(this.zzasg, "This Search Ad has already been torn down");
        this.zzasf.zza(zzjjVar, this.zzapr);
        this.zzasi = new zzbq(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.zzks
    public final IObjectWrapper zzbr() throws RemoteException {
        com.google.android.gms.common.internal.zzbq.zzge("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zzn.zzz(this.zzasg);
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzjn zzbs() throws RemoteException {
        return this.zzasd;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zzbu() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzkx zzcd() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzkh zzce() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.zzks
    public final String zzcp() throws RemoteException {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzdy() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzkb.zzif().zzd(zznh.zzbps));
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzasf.getQuery());
        builder.appendQueryParameter("pubId", this.zzasf.zzeb());
        Map<String, String> zzec = this.zzasf.zzec();
        for (String str : zzec.keySet()) {
            builder.appendQueryParameter(str, zzec.get(str));
        }
        Uri build = builder.build();
        zzcv zzcvVar = this.zzash;
        if (zzcvVar != null) {
            try {
                build = zzcvVar.zza(build, this.mContext);
            } catch (zzcw e) {
                zzagf.zzc("Unable to process ad data", e);
            }
        }
        String zzdz = zzdz();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(zzdz).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(zzdz);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzdz() {
        String zzea = this.zzasf.zzea();
        if (TextUtils.isEmpty(zzea)) {
            zzea = "www.google.com";
        }
        String str = (String) zzkb.zzif().zzd(zznh.zzbps);
        StringBuilder sb = new StringBuilder(String.valueOf("https://").length() + String.valueOf(zzea).length() + String.valueOf(str).length());
        sb.append("https://");
        sb.append(zzea);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzk(int i) {
        if (this.zzasg == null) {
            return;
        }
        this.zzasg.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzv(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzkb.zzia();
            return zzajr.zzc(this.mContext, Integer.parseInt(queryParameter));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
