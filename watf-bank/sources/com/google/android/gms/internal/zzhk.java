package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.internal.zzhf;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzhk extends Thread {
    private final zzhf zzazc;
    private final zzzt zzazd;
    private boolean mStarted = false;
    private boolean zzazb = false;
    private boolean zzbn = false;
    private final Object mLock = new Object();
    private final int zzaya = ((Integer) zzkb.zzif().zzd(zznh.zzbjp)).intValue();
    private final int zzazf = ((Integer) zzkb.zzif().zzd(zznh.zzbjq)).intValue();
    private final int zzayc = ((Integer) zzkb.zzif().zzd(zznh.zzbjr)).intValue();
    private final int zzazg = ((Integer) zzkb.zzif().zzd(zznh.zzbjs)).intValue();
    private final int zzazh = ((Integer) zzkb.zzif().zzd(zznh.zzbjv)).intValue();
    private final int zzazi = ((Integer) zzkb.zzif().zzd(zznh.zzbjx)).intValue();
    private final int zzazj = ((Integer) zzkb.zzif().zzd(zznh.zzbjy)).intValue();
    private final int zzaze = ((Integer) zzkb.zzif().zzd(zznh.zzbjt)).intValue();
    private final String zzazk = (String) zzkb.zzif().zzd(zznh.zzbka);
    private final boolean zzazl = ((Boolean) zzkb.zzif().zzd(zznh.zzbkc)).booleanValue();

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzhk {

        /* renamed from: com.google.android.gms.internal.zzhk$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0040zza implements zzhk {
            private IBinder zzrp;

            C0040zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzhf zzhfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
                    obtain.writeStrongBinder(zzhfVar != null ? zzhfVar.asBinder() : null);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        }

        public static zzhk zzI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzhk)) ? new C0040zza(iBinder) : (zzhk) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
            zza(zzhf.zza.zzF(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    public zzhk(zzhf zzhfVar, zzzt zzztVar) {
        this.zzazc = zzhfVar;
        this.zzazd = zzztVar;
        setName("ContentFetchTask");
    }

    private final zzho zza(View view, zzhe zzheVar) {
        boolean z;
        if (view == null) {
            return new zzho(this, 0, 0);
        }
        Context context = com.google.android.gms.ads.internal.zzbs.zzel().getContext();
        if (context != null) {
            String str = (String) view.getTag(context.getResources().getIdentifier((String) zzkb.zzif().zzd(zznh.zzbjz), "id", context.getPackageName()));
            if (!TextUtils.isEmpty(this.zzazk) && str != null && str.equals(this.zzazk)) {
                return new zzho(this, 0, 0);
            }
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzho(this, 0, 0);
            }
            zzheVar.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new zzho(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzanh)) {
            zzheVar.zzgp();
            WebView webView = (WebView) view;
            if (com.google.android.gms.common.util.zzq.zzaml()) {
                zzheVar.zzgp();
                webView.post(new zzhm(this, zzheVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            return z ? new zzho(this, 0, 1) : new zzho(this, 0, 0);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzho zza2 = zza(viewGroup.getChildAt(i3), zzheVar);
                i += zza2.zzazt;
                i2 += zza2.zzazu;
            }
            return new zzho(this, i, i2);
        } else {
            return new zzho(this, 0, 0);
        }
    }

    private static boolean zzgu() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Context context = com.google.android.gms.ads.internal.zzbs.zzel().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return powerManager == null ? false : powerManager.isScreenOn();
                }
            }
            return false;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzbs.zzem().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void zzgw() {
        synchronized (this.mLock) {
            this.zzazb = true;
            boolean z = this.zzazb;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzagf.zzbx(sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x007f A[EXC_TOP_SPLITTER, LOOP:1: B:46:0x007f->B:53:0x007f, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
        L0:
            boolean r0 = zzgu()     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            if (r0 == 0) goto L59
            com.google.android.gms.internal.zzhg r0 = com.google.android.gms.ads.internal.zzbs.zzel()     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            android.app.Activity r0 = r0.getActivity()     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            if (r0 != 0) goto L19
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.zzagf.zzbx(r0)     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
        L15:
            r4.zzgw()     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            goto L5f
        L19:
            if (r0 == 0) goto L5f
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch: java.lang.Exception -> L3d
            if (r2 == 0) goto L4c
            android.view.Window r2 = r0.getWindow()     // Catch: java.lang.Exception -> L3d
            android.view.View r2 = r2.getDecorView()     // Catch: java.lang.Exception -> L3d
            if (r2 == 0) goto L4c
            android.view.Window r0 = r0.getWindow()     // Catch: java.lang.Exception -> L3d
            android.view.View r0 = r0.getDecorView()     // Catch: java.lang.Exception -> L3d
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)     // Catch: java.lang.Exception -> L3d
            r1 = r0
            goto L4c
        L3d:
            r0 = move-exception
            com.google.android.gms.internal.zzaft r2 = com.google.android.gms.ads.internal.zzbs.zzem()     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zza(r0, r3)     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.zzagf.zzbx(r0)     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
        L4c:
            if (r1 == 0) goto L5f
            if (r1 == 0) goto L5f
            com.google.android.gms.internal.zzhl r0 = new com.google.android.gms.internal.zzhl     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            r0.<init>(r4, r1)     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            r1.post(r0)     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            goto L5f
        L59:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.zzagf.zzbx(r0)     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            goto L15
        L5f:
            int r0 = r4.zzaze     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            java.lang.Thread.sleep(r0)     // Catch: java.lang.Exception -> L68 java.lang.InterruptedException -> L76
            goto L7c
        L68:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.zzagf.zzb(r1, r0)
            com.google.android.gms.internal.zzzt r1 = r4.zzazd
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zza(r0, r2)
            goto L7c
        L76:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.zzagf.zzb(r1, r0)
        L7c:
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
        L7f:
            boolean r1 = r4.zzazb     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L90
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.zzagf.zzbx(r1)     // Catch: java.lang.InterruptedException -> L8e java.lang.Throwable -> L93
            java.lang.Object r1 = r4.mLock     // Catch: java.lang.InterruptedException -> L8e java.lang.Throwable -> L93
            r1.wait()     // Catch: java.lang.InterruptedException -> L8e java.lang.Throwable -> L93
            goto L7f
        L8e:
            r1 = move-exception
            goto L7f
        L90:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            goto L0
        L93:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            goto L97
        L96:
            throw r1
        L97:
            goto L96
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhk.run():void");
    }

    public final void wakeup() {
        synchronized (this.mLock) {
            this.zzazb = false;
            this.mLock.notifyAll();
            zzagf.zzbx("ContentFetchThread: wakeup");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzhe zzheVar, WebView webView, String str, boolean z) {
        zzheVar.zzgo();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzazl || TextUtils.isEmpty(webView.getTitle())) {
                    zzheVar.zza(optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzheVar.zza(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzheVar.zzgj()) {
                this.zzazc.zzb(zzheVar);
            }
        } catch (JSONException e) {
            zzagf.zzbx("Json string may be malformed.");
        } catch (Throwable th) {
            zzagf.zza("Failed to get webview content.", th);
            this.zzazd.zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zzgt() {
        synchronized (this.mLock) {
            if (this.mStarted) {
                zzagf.zzbx("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    public final zzhe zzgv() {
        return this.zzazc.zzgs();
    }

    public final boolean zzgx() {
        return this.zzazb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(View view) {
        try {
            zzhe zzheVar = new zzhe(this.zzaya, this.zzazf, this.zzayc, this.zzazg, this.zzazh, this.zzazi, this.zzazj);
            zzho zza2 = zza(view, zzheVar);
            zzheVar.zzgq();
            if (zza2.zzazt == 0 && zza2.zzazu == 0) {
                return;
            }
            if (zza2.zzazu == 0 && zzheVar.zzgr() == 0) {
                return;
            }
            if (zza2.zzazu == 0 && this.zzazc.zza(zzheVar)) {
                return;
            }
            this.zzazc.zzc(zzheVar);
        } catch (Exception e) {
            zzagf.zzb("Exception in fetchContentOnUIThread", e);
            this.zzazd.zza(e, "ContentFetchTask.fetchContent");
        }
    }
}
