package com.mopub.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.ConsentDialogActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class ManifestUtils {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0184 f624 = new C0184();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static final List<Class<? extends Activity>> f625 = new ArrayList(4);

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static final List<Class<? extends Activity>> f626;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static final List<Class<? extends Activity>> f627;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.common.util.ManifestUtils$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0183 {
        public boolean hasKeyboardHidden;
        public boolean hasOrientation;
        public boolean hasScreenSize;

        private C0183() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.common.util.ManifestUtils$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0184 {
        C0184() {
        }

        public boolean hasFlag(Class cls, int i, int i2) {
            return Utils.bitMaskContainsFlag(i, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        try {
            Class<?> cls = Class.forName("com.mopub.mobileads.MoPubActivity");
            Class<?> cls2 = Class.forName("com.mopub.mobileads.MraidActivity");
            Class<?> cls3 = Class.forName("com.mopub.mobileads.RewardedMraidActivity");
            f625.add(cls);
            f625.add(cls2);
            f625.add(cls3);
        } catch (ClassNotFoundException unused) {
            MoPubLog.i("ManifestUtils running without interstitial module");
        }
        f625.add(MraidVideoPlayerActivity.class);
        f625.add(MoPubBrowser.class);
        f626 = new ArrayList(1);
        f626.add(MoPubBrowser.class);
        f627 = new ArrayList(1);
        f627.add(ConsentDialogActivity.class);
    }

    private ManifestUtils() {
    }

    public static void checkGdprActivitiesDeclared(@NonNull Context context) {
        if (Preconditions.NoThrow.checkNotNull(context, "context is not allowed to be null")) {
            m589(context, f627);
            m591(context, f627);
        }
    }

    public static void checkNativeActivitiesDeclared(@NonNull Context context) {
        if (Preconditions.NoThrow.checkNotNull(context, "context is not allowed to be null")) {
            m589(context, f626);
            m591(context, f626);
        }
    }

    public static void checkWebViewActivitiesDeclared(@NonNull Context context) {
        if (Preconditions.NoThrow.checkNotNull(context, "context is not allowed to be null")) {
            m589(context, f625);
            m591(context, f625);
        }
    }

    public static boolean isDebuggable(@NonNull Context context) {
        return Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, 2);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0183 m586(@NonNull Context context, @NonNull Class<? extends Activity> cls) throws PackageManager.NameNotFoundException {
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new ComponentName(context, cls.getName()), 0);
        C0183 c0183 = new C0183();
        c0183.hasKeyboardHidden = f624.hasFlag(cls, activityInfo.configChanges, 32);
        c0183.hasOrientation = f624.hasFlag(cls, activityInfo.configChanges, 128);
        c0183.hasScreenSize = true;
        c0183.hasScreenSize = f624.hasFlag(cls, activityInfo.configChanges, 1024);
        return c0183;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static List<Class<? extends Activity>> m587(@NonNull Context context, @NonNull List<Class<? extends Activity>> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (Class<? extends Activity> cls : list) {
            if (Intents.deviceCanHandleIntent(context, new Intent(context, cls)) == z) {
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m588(@NonNull Context context) {
        if (isDebuggable(context)) {
            Toast makeText = Toast.makeText(context, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities and configuration.", 1);
            makeText.setGravity(7, 0, 0);
            makeText.show();
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m589(@NonNull Context context, @NonNull List<Class<? extends Activity>> list) {
        List<Class<? extends Activity>> m587 = m587(context, list, false);
        if (m587.isEmpty()) {
            return;
        }
        m588(context);
        m590(m587);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m590(@NonNull List<Class<? extends Activity>> list) {
        StringBuilder sb = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
        for (Class<? extends Activity> cls : list) {
            sb.append("\n\t");
            sb.append(cls.getName());
        }
        sb.append("\n\nPlease update your manifest to include them.");
        MoPubLog.w(sb.toString());
    }

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    static void m591(@NonNull Context context, @NonNull List<Class<? extends Activity>> list) {
        List<Class<? extends Activity>> m592 = m592(context, m587(context, list, true));
        if (m592.isEmpty()) {
            return;
        }
        m588(context);
        m593(context, m592);
    }

    @TargetApi(13)
    /* renamed from: ࢣ  reason: contains not printable characters */
    private static List<Class<? extends Activity>> m592(@NonNull Context context, @NonNull List<Class<? extends Activity>> list) {
        ArrayList arrayList = new ArrayList();
        for (Class<? extends Activity> cls : list) {
            try {
                C0183 m586 = m586(context, cls);
                if (!m586.hasKeyboardHidden || !m586.hasOrientation || !m586.hasScreenSize) {
                    arrayList.add(cls);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return arrayList;
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static void m593(@NonNull Context context, @NonNull List<Class<? extends Activity>> list) {
        StringBuilder sb = new StringBuilder("In AndroidManifest, the android:configChanges param is missing values for the following MoPub activities:\n");
        for (Class<? extends Activity> cls : list) {
            try {
                C0183 m586 = m586(context, cls);
                if (!m586.hasKeyboardHidden) {
                    sb.append("\n\tThe android:configChanges param for activity " + cls.getName() + " must include keyboardHidden.");
                }
                if (!m586.hasOrientation) {
                    sb.append("\n\tThe android:configChanges param for activity " + cls.getName() + " must include orientation.");
                }
                if (!m586.hasScreenSize) {
                    sb.append("\n\tThe android:configChanges param for activity " + cls.getName() + " must include screenSize.");
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        sb.append("\n\nPlease update your manifest to include them.");
        MoPubLog.w(sb.toString());
    }
}
