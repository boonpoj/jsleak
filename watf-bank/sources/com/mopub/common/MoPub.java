package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.common.util.Reflection;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: assets/classes2.dex */
public class MoPub {
    public static final String SDK_VERSION = "5.4.1";
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private static Method f381;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private static AdvancedBiddingTokens f385;

    /* renamed from: ࢬ  reason: contains not printable characters */
    private static PersonalInfoManager f386;
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static volatile LocationAwareness f375 = LocationAwareness.NORMAL;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static volatile int f376 = 6;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static volatile long f377 = 60000;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static volatile BrowserAgent f378 = BrowserAgent.IN_APP;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private static volatile boolean f379 = false;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private static boolean f380 = false;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private static boolean f382 = true;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private static boolean f383 = false;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private static boolean f384 = false;

    /* loaded from: assets/classes2.dex */
    public enum BrowserAgent {
        IN_APP,
        NATIVE;

        @NonNull
        public static BrowserAgent fromHeader(@Nullable Integer num) {
            if (num != null && num.intValue() == 1) {
                return NATIVE;
            }
            return IN_APP;
        }
    }

    /* loaded from: assets/classes2.dex */
    public enum LocationAwareness {
        NORMAL,
        TRUNCATED,
        DISABLED
    }

    /* renamed from: com.mopub.common.MoPub$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static class C0171 implements SdkInitializationListener {
        @Nullable

        /* renamed from: ࢠ  reason: contains not printable characters */
        private SdkInitializationListener f390;

        C0171(@Nullable SdkInitializationListener sdkInitializationListener) {
            this.f390 = sdkInitializationListener;
        }

        @Override // com.mopub.common.SdkInitializationListener
        public void onInitializationFinished() {
            MoPub.m442(this.f390);
            this.f390 = null;
        }
    }

    public static boolean canCollectPersonalInformation() {
        return f386 != null && f386.canCollectPersonalInformation();
    }

    public static void disableViewability(@NonNull ExternalViewabilitySessionManager.ViewabilityVendor viewabilityVendor) {
        Preconditions.checkNotNull(viewabilityVendor);
        viewabilityVendor.disable();
    }

    @NonNull
    public static BrowserAgent getBrowserAgent() {
        Preconditions.checkNotNull(f378);
        return f378;
    }

    @NonNull
    public static LocationAwareness getLocationAwareness() {
        Preconditions.checkNotNull(f375);
        return f375;
    }

    public static int getLocationPrecision() {
        return f376;
    }

    public static long getMinimumLocationRefreshTimeMillis() {
        return f377;
    }

    @Nullable
    public static PersonalInfoManager getPersonalInformationManager() {
        return f386;
    }

    public static void initializeSdk(@NonNull Context context, @NonNull SdkConfiguration sdkConfiguration, @Nullable SdkInitializationListener sdkInitializationListener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(sdkConfiguration);
        MoPubLog.d("Initializing MoPub with ad unit: " + sdkConfiguration.getAdUnitId());
        if (context instanceof Activity) {
            m440((Activity) context, sdkConfiguration);
        }
        if (f383) {
            MoPubLog.d("MoPub SDK is already initialized");
            m442(sdkInitializationListener);
        } else if (f384) {
            MoPubLog.d("MoPub SDK is currently initializing.");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            MoPubLog.e("MoPub can only be initialized on the main thread.");
        } else {
            f384 = true;
            C0189 c0189 = new C0189(new C0171(sdkInitializationListener), 2);
            f386 = new PersonalInfoManager(context, sdkConfiguration.getAdUnitId(), c0189);
            ClientMetadata.getInstance(context);
            f385 = new AdvancedBiddingTokens(c0189);
            f385.addAdvancedBidders(sdkConfiguration.getAdvancedBidders());
        }
    }

    public static boolean isAdvancedBiddingEnabled() {
        return f382;
    }

    public static boolean isSdkInitialized() {
        return f383;
    }

    public static void onBackPressed(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onBackPressed(activity);
    }

    public static void onCreate(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onCreate(activity);
        m439(activity);
    }

    public static void onDestroy(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onDestroy(activity);
    }

    public static void onPause(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onPause(activity);
    }

    public static void onRestart(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onRestart(activity);
        m439(activity);
    }

    public static void onResume(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onResume(activity);
        m439(activity);
    }

    public static void onStart(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onStart(activity);
        m439(activity);
    }

    public static void onStop(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onStop(activity);
    }

    @VisibleForTesting
    @Deprecated
    public static void resetBrowserAgent() {
        f378 = BrowserAgent.IN_APP;
        f379 = false;
    }

    public static void setAdvancedBiddingEnabled(boolean z) {
        f382 = z;
    }

    public static void setBrowserAgent(@NonNull BrowserAgent browserAgent) {
        Preconditions.checkNotNull(browserAgent);
        f378 = browserAgent;
        f379 = true;
    }

    public static void setBrowserAgentFromAdServer(@NonNull BrowserAgent browserAgent) {
        Preconditions.checkNotNull(browserAgent);
        if (!f379) {
            f378 = browserAgent;
            return;
        }
        MoPubLog.w("Browser agent already overridden by client with value " + f378);
    }

    public static void setLocationAwareness(@NonNull LocationAwareness locationAwareness) {
        Preconditions.checkNotNull(locationAwareness);
        f375 = locationAwareness;
    }

    public static void setLocationPrecision(int i) {
        f376 = Math.min(Math.max(0, i), 6);
    }

    public static void setMinimumLocationRefreshTimeMillis(long j) {
        f377 = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static String m438(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (!isAdvancedBiddingEnabled() || f385 == null) {
            return null;
        }
        return f385.m355(context);
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m439(@NonNull Activity activity) {
        if (!f380) {
            f380 = true;
            try {
                f381 = Reflection.getDeclaredMethodWithTraversal(Class.forName("com.mopub.mobileads.MoPubRewardedVideoManager"), "updateActivity", Activity.class);
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
            }
        }
        if (f381 != null) {
            try {
                f381.invoke(null, activity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                MoPubLog.e("Error while attempting to access the update activity method - this should not have happened", e);
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m440(@NonNull Activity activity, @NonNull SdkConfiguration sdkConfiguration) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(sdkConfiguration);
        try {
            new Reflection.MethodBuilder(null, "initializeRewardedVideo").setStatic(Class.forName("com.mopub.mobileads.MoPubRewardedVideos")).setAccessible().addParam((Class<Class>) Activity.class, (Class) activity).addParam((Class<Class>) SdkConfiguration.class, (Class) sdkConfiguration).execute();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            MoPubLog.w("initializeRewardedVideo was called without the rewarded video module");
        } catch (Exception e) {
            MoPubLog.e("Error while initializing rewarded video", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static void m442(@Nullable final SdkInitializationListener sdkInitializationListener) {
        f384 = false;
        f383 = true;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mopub.common.MoPub.1
            @Override // java.lang.Runnable
            public void run() {
                if (SdkInitializationListener.this != null) {
                    SdkInitializationListener.this.onInitializationFinished();
                }
            }
        });
    }
}
