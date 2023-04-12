package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Utils;
import com.mopub.network.Networking;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.ރ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0223 extends BaseWebView {
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    InterfaceC0224 f1220;

    /* renamed from: com.mopub.mobileads.ރ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    interface InterfaceC0224 {
        void onVastWebViewClick();
    }

    /* renamed from: com.mopub.mobileads.ރ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    class View$OnTouchListenerC0225 implements View.OnTouchListener {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private boolean f1222;

        View$OnTouchListenerC0225() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f1222 = true;
                    break;
                case 1:
                    if (!this.f1222) {
                        return false;
                    }
                    this.f1222 = false;
                    if (C0223.this.f1220 != null) {
                        C0223.this.f1220.onVastWebViewClick();
                        break;
                    }
                    break;
            }
            return false;
        }
    }

    C0223(Context context) {
        super(context);
        m1029();
        getSettings().setJavaScriptEnabled(true);
        enablePlugins(true);
        setBackgroundColor(0);
        setOnTouchListener(new View$OnTouchListenerC0225());
        setId((int) Utils.generateUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0223 m1028(@NonNull Context context, @NonNull C0220 c0220) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(c0220);
        C0223 c0223 = new C0223(context);
        c0220.initializeWebView(c0223);
        return c0223;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1029() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1030(@NonNull InterfaceC0224 interfaceC0224) {
        this.f1220 = interfaceC0224;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1031(String str) {
        loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", str, "text/html", "utf-8", null);
    }
}
