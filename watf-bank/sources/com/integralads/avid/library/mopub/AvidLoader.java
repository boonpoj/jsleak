package com.integralads.avid.library.mopub;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import com.integralads.avid.library.mopub.DownloadAvidTask;
import com.integralads.avid.library.mopub.utils.NetworkUtils;
/* loaded from: assets/classes2.dex */
public class AvidLoader implements DownloadAvidTask.DownloadAvidTaskListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AvidLoader f3 = new AvidLoader();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private AvidLoaderListener f4;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private DownloadAvidTask f5;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Context f6;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private TaskRepeater f8;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private TaskExecutor f7 = new TaskExecutor();

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final Runnable f9 = new Runnable() { // from class: com.integralads.avid.library.mopub.AvidLoader.1
        @Override // java.lang.Runnable
        public void run() {
            if (AvidLoader.this.f6 == null || !NetworkUtils.isNetworkAvailable(AvidLoader.this.f6)) {
                AvidLoader.this.m10();
            } else {
                AvidLoader.this.m8();
            }
        }
    };

    /* loaded from: assets/classes2.dex */
    public interface AvidLoaderListener {
        void onAvidLoaded();
    }

    /* loaded from: assets/classes2.dex */
    public class TaskExecutor {
        public TaskExecutor() {
        }

        public void executeTask(DownloadAvidTask downloadAvidTask) {
            if (Build.VERSION.SDK_INT >= 11) {
                AvidLoader.this.f5.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://mobile-static.adsafeprotected.com/avid-v2.js");
            } else {
                AvidLoader.this.f5.execute("https://mobile-static.adsafeprotected.com/avid-v2.js");
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    public class TaskRepeater {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private Handler f13 = new Handler();

        public TaskRepeater() {
        }

        public void cleanup() {
            this.f13.removeCallbacks(AvidLoader.this.f9);
        }

        public void repeatLoading() {
            this.f13.postDelayed(AvidLoader.this.f9, 2000L);
        }
    }

    public static AvidLoader getInstance() {
        return f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m8() {
        if (AvidBridge.isAvidJsReady() || this.f5 != null) {
            return;
        }
        this.f5 = new DownloadAvidTask();
        this.f5.setListener(this);
        this.f7.executeTask(this.f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m10() {
        if (this.f8 != null) {
            this.f8.repeatLoading();
        }
    }

    @Override // com.integralads.avid.library.mopub.DownloadAvidTask.DownloadAvidTaskListener
    public void failedToLoadAvid() {
        this.f5 = null;
        m10();
    }

    public AvidLoaderListener getListener() {
        return this.f4;
    }

    @Override // com.integralads.avid.library.mopub.DownloadAvidTask.DownloadAvidTaskListener
    public void onLoadAvid(String str) {
        this.f5 = null;
        AvidBridge.setAvidJs(str);
        if (this.f4 != null) {
            this.f4.onAvidLoaded();
        }
    }

    public void registerAvidLoader(Context context) {
        this.f6 = context;
        this.f8 = new TaskRepeater();
        m8();
    }

    public void setListener(AvidLoaderListener avidLoaderListener) {
        this.f4 = avidLoaderListener;
    }

    public void unregisterAvidLoader() {
        if (this.f8 != null) {
            this.f8.cleanup();
            this.f8 = null;
        }
        this.f4 = null;
        this.f6 = null;
    }
}
