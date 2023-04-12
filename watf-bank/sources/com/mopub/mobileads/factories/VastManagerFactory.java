package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.VastManager;
/* loaded from: assets/classes2.dex */
public class VastManagerFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static VastManagerFactory f1182 = new VastManagerFactory();

    public static VastManager create(Context context) {
        return f1182.internalCreate(context, true);
    }

    public static VastManager create(Context context, boolean z) {
        return f1182.internalCreate(context, z);
    }

    @Deprecated
    public static void setInstance(VastManagerFactory vastManagerFactory) {
        f1182 = vastManagerFactory;
    }

    public VastManager internalCreate(Context context, boolean z) {
        return new VastManager(context, z);
    }
}
