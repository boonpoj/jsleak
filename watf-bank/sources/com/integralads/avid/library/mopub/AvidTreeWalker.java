package com.integralads.avid.library.mopub;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.integralads.avid.library.mopub.processing.AvidProcessorFactory;
import com.integralads.avid.library.mopub.processing.IAvidNodeProcessor;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import com.integralads.avid.library.mopub.utils.AvidTimestamp;
import com.integralads.avid.library.mopub.utils.AvidViewUtil;
import com.integralads.avid.library.mopub.walking.AvidAdViewCache;
import com.integralads.avid.library.mopub.walking.AvidStatePublisher;
import com.integralads.avid.library.mopub.walking.ViewType;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTaskQueue;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AvidTreeWalker implements IAvidNodeProcessor.IAvidViewWalker {

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static HandlerC0081 f24;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private int f27;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private double f31;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private double f32;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AvidTreeWalker f23 = new AvidTreeWalker();

    /* renamed from: ࢪ  reason: contains not printable characters */
    private static final Runnable f25 = new Runnable() { // from class: com.integralads.avid.library.mopub.AvidTreeWalker.1
        @Override // java.lang.Runnable
        public void run() {
            if (AvidTreeWalker.f24 != null) {
                AvidTreeWalker.f24.sendEmptyMessage(0);
                AvidTreeWalker.f24.postDelayed(AvidTreeWalker.f25, 200L);
            }
        }
    };

    /* renamed from: ࢣ  reason: contains not printable characters */
    private List<AvidTreeWalkerTimeLogger> f26 = new ArrayList();

    /* renamed from: ࢦ  reason: contains not printable characters */
    private AvidAdViewCache f29 = new AvidAdViewCache(AvidAdSessionRegistry.getInstance());

    /* renamed from: ࢥ  reason: contains not printable characters */
    private AvidProcessorFactory f28 = new AvidProcessorFactory();

    /* renamed from: ࢧ  reason: contains not printable characters */
    private AvidStatePublisher f30 = new AvidStatePublisher(AvidAdSessionRegistry.getInstance(), new AvidAsyncTaskQueue());

    /* loaded from: assets/classes2.dex */
    public interface AvidTreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.integralads.avid.library.mopub.AvidTreeWalker$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class HandlerC0081 extends Handler {
        private HandlerC0081() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            AvidTreeWalker.getInstance().m30();
        }
    }

    public static AvidTreeWalker getInstance() {
        return f23;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m23(long j) {
        if (this.f26.size() > 0) {
            for (AvidTreeWalkerTimeLogger avidTreeWalkerTimeLogger : this.f26) {
                avidTreeWalkerTimeLogger.onTreeProcessed(this.f27, j);
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m24(View view, IAvidNodeProcessor iAvidNodeProcessor, JSONObject jSONObject, ViewType viewType) {
        iAvidNodeProcessor.iterateChildren(view, jSONObject, this, viewType == ViewType.ROOT_VIEW);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m26(View view, JSONObject jSONObject) {
        String sessionId = this.f29.getSessionId(view);
        if (sessionId != null) {
            AvidJSONUtil.addAvidId(jSONObject, sessionId);
            this.f29.onAdViewProcessed();
            return true;
        }
        return false;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m28(View view, JSONObject jSONObject) {
        ArrayList<String> friendlySessionIds = this.f29.getFriendlySessionIds(view);
        if (friendlySessionIds != null) {
            AvidJSONUtil.addFriendlyObstruction(jSONObject, friendlySessionIds);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m30() {
        m31();
        m35();
        m32();
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private void m31() {
        this.f27 = 0;
        this.f31 = AvidTimestamp.getCurrentTime();
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private void m32() {
        this.f32 = AvidTimestamp.getCurrentTime();
        m23((long) (this.f32 - this.f31));
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    private void m33() {
        if (f24 == null) {
            f24 = new HandlerC0081();
            f24.postDelayed(f25, 200L);
        }
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    private void m34() {
        if (f24 != null) {
            f24.removeCallbacks(f25);
            f24 = null;
        }
    }

    public void addTimeLogger(AvidTreeWalkerTimeLogger avidTreeWalkerTimeLogger) {
        if (this.f26.contains(avidTreeWalkerTimeLogger)) {
            return;
        }
        this.f26.add(avidTreeWalkerTimeLogger);
    }

    public void pause() {
        m34();
    }

    public void removeTimeLogger(AvidTreeWalkerTimeLogger avidTreeWalkerTimeLogger) {
        if (this.f26.contains(avidTreeWalkerTimeLogger)) {
            this.f26.remove(avidTreeWalkerTimeLogger);
        }
    }

    public void start() {
        m33();
        m30();
    }

    public void stop() {
        pause();
        this.f26.clear();
        this.f30.cleanupCache();
    }

    @Override // com.integralads.avid.library.mopub.processing.IAvidNodeProcessor.IAvidViewWalker
    public void walkView(View view, IAvidNodeProcessor iAvidNodeProcessor, JSONObject jSONObject) {
        ViewType viewType;
        if (AvidViewUtil.isViewVisible(view) && (viewType = this.f29.getViewType(view)) != ViewType.UNDERLYING_VIEW) {
            JSONObject state = iAvidNodeProcessor.getState(view);
            AvidJSONUtil.addChildState(jSONObject, state);
            if (!m26(view, state)) {
                m28(view, state);
                m24(view, iAvidNodeProcessor, state, viewType);
            }
            this.f27++;
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m35() {
        this.f29.prepare();
        double currentTime = AvidTimestamp.getCurrentTime();
        IAvidNodeProcessor rootProcessor = this.f28.getRootProcessor();
        if (this.f29.getHiddenSessionIds().size() > 0) {
            this.f30.publishEmptyState(rootProcessor.getState(null), this.f29.getHiddenSessionIds(), currentTime);
        }
        if (this.f29.getVisibleSessionIds().size() > 0) {
            JSONObject state = rootProcessor.getState(null);
            m24(null, rootProcessor, state, ViewType.ROOT_VIEW);
            AvidJSONUtil.fixStateFrame(state);
            this.f30.publishState(state, this.f29.getVisibleSessionIds(), currentTime);
        } else {
            this.f30.cleanupCache();
        }
        this.f29.cleanup();
    }
}
