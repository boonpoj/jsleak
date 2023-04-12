package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
final class zzahm implements ThreadFactory {
    private final AtomicInteger zzcxh = new AtomicInteger(1);
    private /* synthetic */ String zzdav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahm(String str) {
        this.zzdav = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.zzdav;
        int andIncrement = this.zzcxh.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
