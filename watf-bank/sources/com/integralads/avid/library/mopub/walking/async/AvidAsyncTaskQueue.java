package com.integralads.avid.library.mopub.walking.async;

import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: assets/classes2.dex */
public class AvidAsyncTaskQueue implements AvidAsyncTask.AvidAsyncTaskListener {

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final ArrayDeque<AvidAsyncTask> f118 = new ArrayDeque<>();

    /* renamed from: ࢤ  reason: contains not printable characters */
    private AvidAsyncTask f119 = null;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final BlockingQueue<Runnable> f116 = new LinkedBlockingQueue();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final ThreadPoolExecutor f117 = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f116);

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m76() {
        this.f119 = this.f118.poll();
        if (this.f119 != null) {
            this.f119.start(this.f117);
        }
    }

    @Override // com.integralads.avid.library.mopub.walking.async.AvidAsyncTask.AvidAsyncTaskListener
    public void onTaskCompleted(AvidAsyncTask avidAsyncTask) {
        this.f119 = null;
        m76();
    }

    public void submitTask(AvidAsyncTask avidAsyncTask) {
        avidAsyncTask.setListener(this);
        this.f118.add(avidAsyncTask);
        if (this.f119 == null) {
            m76();
        }
    }
}
