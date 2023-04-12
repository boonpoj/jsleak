package ࢠ;

import android.content.Intent;
import android.os.Bundle;
/* renamed from: ࢠ.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0455 {
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static Bundle m2290(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static Bundle m2291(Intent intent) {
        Bundle m2290 = m2290(intent);
        if (m2290 == null) {
            return null;
        }
        return m2290.getBundle("extras");
    }
}
