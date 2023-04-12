package com.mopub.nativeads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.mobileads.VideoViewabilityTracker;
import com.mopub.mobileads.factories.VastManagerFactory;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MediaLayout;
import com.mopub.nativeads.NativeImageHelper;
import com.mopub.nativeads.NativeVideoController;
import com.mopub.network.TrackingRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class MoPubCustomEventVideoNative extends CustomEventNative {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private MoPubVideoNativeAd f1632;

    /* loaded from: assets/classes2.dex */
    public static class MoPubVideoNativeAd extends VideoNativeAd implements AudioManager.OnAudioFocusChangeListener, VastManager.VastManagerListener, NativeVideoController.NativeVideoProgressRunnable.ProgressListener {
        @Nullable

        /* renamed from: ֏  reason: contains not printable characters */
        private View f1635;

        /* renamed from: ؠ  reason: contains not printable characters */
        private final long f1636;

        /* renamed from: ހ  reason: contains not printable characters */
        private boolean f1637;

        /* renamed from: ށ  reason: contains not printable characters */
        private boolean f1638;

        /* renamed from: ނ  reason: contains not printable characters */
        private boolean f1639;

        /* renamed from: ރ  reason: contains not printable characters */
        private boolean f1640;

        /* renamed from: ބ  reason: contains not printable characters */
        private int f1641;

        /* renamed from: ޅ  reason: contains not printable characters */
        private boolean f1642;

        /* renamed from: ކ  reason: contains not printable characters */
        private boolean f1643;

        /* renamed from: އ  reason: contains not printable characters */
        private boolean f1644;

        /* renamed from: ވ  reason: contains not printable characters */
        private boolean f1645;
        @Nullable

        /* renamed from: ࢠ  reason: contains not printable characters */
        VastVideoConfig f1646;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final Context f1647;
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final JSONObject f1648;
        @NonNull

        /* renamed from: ࢤ  reason: contains not printable characters */
        private VideoState f1649;
        @NonNull

        /* renamed from: ࢥ  reason: contains not printable characters */
        private final VisibilityTracker f1650;
        @NonNull

        /* renamed from: ࢦ  reason: contains not printable characters */
        private final String f1651;
        @NonNull

        /* renamed from: ࢧ  reason: contains not printable characters */
        private final CustomEventNative.CustomEventNativeListener f1652;
        @NonNull

        /* renamed from: ࢨ  reason: contains not printable characters */
        private final C0270 f1653;
        @NonNull

        /* renamed from: ࢩ  reason: contains not printable characters */
        private final C0268 f1654;
        @Nullable

        /* renamed from: ࢪ  reason: contains not printable characters */
        private NativeVideoController f1655;
        @NonNull

        /* renamed from: ࢫ  reason: contains not printable characters */
        private final VastManager f1656;
        @Nullable

        /* renamed from: ࢬ  reason: contains not printable characters */
        private MediaLayout f1657;

        /* loaded from: assets/classes2.dex */
        public enum VideoState {
            CREATED,
            LOADING,
            BUFFERING,
            PAUSED,
            PLAYING,
            PLAYING_MUTED,
            ENDED,
            FAILED_LOAD
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$MoPubVideoNativeAd$ࢠ  reason: contains not printable characters */
        /* loaded from: assets/classes2.dex */
        public enum EnumC0266 {
            IMPRESSION_TRACKER("imptracker", true),
            CLICK_TRACKER("clktracker", true),
            TITLE("title", false),
            TEXT("text", false),
            IMAGE_URL("mainimage", false),
            ICON_URL("iconimage", false),
            CLICK_DESTINATION("clk", false),
            FALLBACK("fallback", false),
            CALL_TO_ACTION("ctatext", false),
            VAST_VIDEO("video", false),
            PRIVACY_INFORMATION_ICON_IMAGE_URL("privacyicon", false),
            PRIVACY_INFORMATION_ICON_CLICKTHROUGH_URL("privacyclkurl", false);
            
            @NonNull
            @VisibleForTesting

            /* renamed from: ࢣ  reason: contains not printable characters */
            static final Set<String> f1666 = new HashSet();
            @NonNull

            /* renamed from: ࢠ  reason: contains not printable characters */
            final String f1668;

            /* renamed from: ࢢ  reason: contains not printable characters */
            final boolean f1669;

            static {
                EnumC0266[] values;
                for (EnumC0266 enumC0266 : values()) {
                    if (enumC0266.f1669) {
                        f1666.add(enumC0266.f1668);
                    }
                }
            }

            EnumC0266(String str, boolean z) {
                Preconditions.checkNotNull(str);
                this.f1668 = str;
                this.f1669 = z;
            }

            @Nullable
            /* renamed from: ࢠ  reason: contains not printable characters */
            static EnumC0266 m1386(@NonNull String str) {
                EnumC0266[] values;
                Preconditions.checkNotNull(str);
                for (EnumC0266 enumC0266 : values()) {
                    if (enumC0266.f1668.equals(str)) {
                        return enumC0266;
                    }
                }
                return null;
            }
        }

        @VisibleForTesting
        MoPubVideoNativeAd(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull CustomEventNative.CustomEventNativeListener customEventNativeListener, @NonNull C0270 c0270, @NonNull VisibilityTracker visibilityTracker, @NonNull C0268 c0268, @NonNull String str, @NonNull VastManager vastManager) {
            this.f1639 = false;
            this.f1640 = false;
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(jSONObject);
            Preconditions.checkNotNull(customEventNativeListener);
            Preconditions.checkNotNull(c0270);
            Preconditions.checkNotNull(visibilityTracker);
            Preconditions.checkNotNull(c0268);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(vastManager);
            this.f1647 = context.getApplicationContext();
            this.f1648 = jSONObject;
            this.f1652 = customEventNativeListener;
            this.f1653 = c0270;
            this.f1654 = c0268;
            this.f1651 = str;
            this.f1636 = Utils.generateUniqueId();
            this.f1637 = true;
            this.f1649 = VideoState.CREATED;
            this.f1638 = true;
            this.f1641 = 1;
            this.f1644 = true;
            this.f1650 = visibilityTracker;
            this.f1650.setVisibilityTrackerListener(new VisibilityTracker.VisibilityTrackerListener() { // from class: com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.1
                @Override // com.mopub.common.VisibilityTracker.VisibilityTrackerListener
                public void onVisibilityChanged(List<View> list, List<View> list2) {
                    MoPubVideoNativeAd moPubVideoNativeAd;
                    boolean z;
                    if (!list.isEmpty() && !MoPubVideoNativeAd.this.f1643) {
                        moPubVideoNativeAd = MoPubVideoNativeAd.this;
                        z = true;
                    } else if (list2.isEmpty() || !MoPubVideoNativeAd.this.f1643) {
                        return;
                    } else {
                        moPubVideoNativeAd = MoPubVideoNativeAd.this;
                        z = false;
                    }
                    moPubVideoNativeAd.f1643 = z;
                    MoPubVideoNativeAd.this.m1376();
                }
            });
            this.f1656 = vastManager;
        }

        public MoPubVideoNativeAd(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull CustomEventNative.CustomEventNativeListener customEventNativeListener, @NonNull C0270 c0270, @NonNull String str) {
            this(context, jSONObject, customEventNativeListener, c0270, new VisibilityTracker(context), new C0268(), str, VastManagerFactory.create(context.getApplicationContext(), false));
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private void m1356(@NonNull EnumC0266 enumC0266, @Nullable Object obj) throws ClassCastException {
            Preconditions.checkNotNull(enumC0266);
            Preconditions.checkNotNull(obj);
            try {
                switch (enumC0266) {
                    case IMPRESSION_TRACKER:
                        m1297(obj);
                        break;
                    case TITLE:
                        setTitle((String) obj);
                        break;
                    case TEXT:
                        setText((String) obj);
                        break;
                    case IMAGE_URL:
                        setMainImageUrl((String) obj);
                        break;
                    case ICON_URL:
                        setIconImageUrl((String) obj);
                        break;
                    case CLICK_DESTINATION:
                        setClickDestinationUrl((String) obj);
                        break;
                    case CLICK_TRACKER:
                        m1365(obj);
                        break;
                    case CALL_TO_ACTION:
                        setCallToAction((String) obj);
                        break;
                    case VAST_VIDEO:
                        setVastVideo((String) obj);
                        break;
                    case PRIVACY_INFORMATION_ICON_IMAGE_URL:
                        setPrivacyInformationIconImageUrl((String) obj);
                        break;
                    case PRIVACY_INFORMATION_ICON_CLICKTHROUGH_URL:
                        setPrivacyInformationIconClickThroughUrl((String) obj);
                        break;
                    default:
                        MoPubLog.d("Unable to add JSON key to internal mapping: " + enumC0266.f1668);
                        break;
                }
            } catch (ClassCastException e) {
                if (enumC0266.f1669) {
                    throw e;
                }
                MoPubLog.d("Ignoring class cast exception for optional key: " + enumC0266.f1668);
            }
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private boolean m1359(@Nullable String str) {
            return str != null && str.toLowerCase(Locale.US).endsWith("image");
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private boolean m1360(@NonNull JSONObject jSONObject) {
            Preconditions.checkNotNull(jSONObject);
            HashSet hashSet = new HashSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                hashSet.add(keys.next());
            }
            return hashSet.containsAll(EnumC0266.f1666);
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        private void m1361(VideoState videoState) {
            if (this.f1640 && videoState != VideoState.PLAYING && videoState != VideoState.PLAYING_MUTED) {
                TrackingRequest.makeVastTrackingHttpRequest(this.f1646.getResumeTrackers(), null, Integer.valueOf((int) this.f1655.getCurrentPosition()), null, this.f1647);
                this.f1640 = false;
            }
            this.f1639 = true;
            if (this.f1637) {
                this.f1637 = false;
                this.f1655.seekTo(this.f1655.getCurrentPosition());
            }
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        private void m1365(@NonNull Object obj) {
            if (obj instanceof JSONArray) {
                m1299(obj);
            } else {
                addClickTracker((String) obj);
            }
        }

        /* renamed from: ࢦ  reason: contains not printable characters */
        private void m1372() {
            if (this.f1657 != null) {
                this.f1657.setMode(MediaLayout.Mode.IMAGE);
                this.f1657.setSurfaceTextureListener(null);
                this.f1657.setPlayButtonClickListener(null);
                this.f1657.setMuteControlClickListener(null);
                this.f1657.setOnClickListener(null);
                this.f1650.removeView(this.f1657);
                this.f1657 = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ࢧ  reason: contains not printable characters */
        public void m1374() {
            this.f1637 = true;
            this.f1638 = true;
            this.f1655.setListener(null);
            this.f1655.setOnAudioFocusChangeListener(null);
            this.f1655.setProgressListener(null);
            this.f1655.clear();
            m1384(VideoState.PAUSED, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ࢨ  reason: contains not printable characters */
        public void m1376() {
            VideoState videoState = this.f1649;
            if (this.f1642) {
                videoState = VideoState.FAILED_LOAD;
            } else {
                if (!this.f1645) {
                    if (this.f1641 == 1) {
                        videoState = VideoState.LOADING;
                    } else if (this.f1641 == 2) {
                        videoState = VideoState.BUFFERING;
                    } else if (this.f1641 == 4) {
                        this.f1645 = true;
                    } else if (this.f1641 == 3) {
                        videoState = this.f1643 ? this.f1644 ? VideoState.PLAYING_MUTED : VideoState.PLAYING : VideoState.PAUSED;
                    }
                }
                videoState = VideoState.ENDED;
            }
            m1383(videoState);
        }

        @NonNull
        /* renamed from: ࢩ  reason: contains not printable characters */
        private List<String> m1377() {
            ArrayList arrayList = new ArrayList(getExtras().size());
            for (Map.Entry<String, Object> entry : getExtras().entrySet()) {
                if (m1359(entry.getKey()) && (entry.getValue() instanceof String)) {
                    arrayList.add((String) entry.getValue());
                }
            }
            return arrayList;
        }

        @NonNull
        /* renamed from: ࢪ  reason: contains not printable characters */
        private List<String> m1379() {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(getMainImageUrl())) {
                arrayList.add(getMainImageUrl());
            }
            if (!TextUtils.isEmpty(getIconImageUrl())) {
                arrayList.add(getIconImageUrl());
            }
            if (!TextUtils.isEmpty(getPrivacyInformationIconImageUrl())) {
                arrayList.add(getPrivacyInformationIconImageUrl());
            }
            arrayList.addAll(m1377());
            return arrayList;
        }

        @Override // com.mopub.nativeads.VideoNativeAd, com.mopub.nativeads.BaseNativeAd
        public void clear(@NonNull View view) {
            Preconditions.checkNotNull(view);
            this.f1655.clear();
            m1372();
        }

        @Override // com.mopub.nativeads.VideoNativeAd, com.mopub.nativeads.BaseNativeAd
        public void destroy() {
            invalidate();
            m1372();
            this.f1655.setPlayWhenReady(false);
            this.f1655.release(this);
            NativeVideoController.remove(this.f1636);
            this.f1650.destroy();
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -1 || i == -2) {
                this.f1644 = true;
            } else if (i == -3) {
                this.f1655.setAudioVolume(0.3f);
                return;
            } else if (i != 1) {
                return;
            } else {
                this.f1655.setAudioVolume(1.0f);
            }
            m1376();
        }

        @Override // com.mopub.nativeads.NativeVideoController.Listener
        public void onError(Exception exc) {
            MoPubLog.w("Error playing back video.", exc);
            this.f1642 = true;
            m1376();
        }

        @Override // com.mopub.nativeads.NativeVideoController.Listener
        public void onStateChanged(boolean z, int i) {
            this.f1641 = i;
            m1376();
        }

        @Override // com.mopub.mobileads.VastManager.VastManagerListener
        public void onVastVideoConfigurationPrepared(@Nullable VastVideoConfig vastVideoConfig) {
            if (vastVideoConfig == null) {
                this.f1652.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
                return;
            }
            ArrayList arrayList = new ArrayList();
            NativeVideoController.C0273 c0273 = new NativeVideoController.C0273();
            c0273.f1823 = new C0267(this);
            c0273.f1824 = this.f1653.m1390();
            c0273.f1825 = this.f1653.m1391();
            arrayList.add(c0273);
            c0273.f1828 = this.f1653.m1392();
            for (VastTracker vastTracker : vastVideoConfig.getImpressionTrackers()) {
                NativeVideoController.C0273 c02732 = new NativeVideoController.C0273();
                c02732.f1823 = new C0269(this.f1647, vastTracker.getContent());
                c02732.f1824 = this.f1653.m1390();
                c02732.f1825 = this.f1653.m1391();
                arrayList.add(c02732);
                c02732.f1828 = this.f1653.m1392();
            }
            this.f1646 = vastVideoConfig;
            VideoViewabilityTracker videoViewabilityTracker = this.f1646.getVideoViewabilityTracker();
            if (videoViewabilityTracker != null) {
                NativeVideoController.C0273 c02733 = new NativeVideoController.C0273();
                c02733.f1823 = new C0269(this.f1647, videoViewabilityTracker.getContent());
                c02733.f1824 = videoViewabilityTracker.getPercentViewable();
                c02733.f1825 = videoViewabilityTracker.getViewablePlaytimeMS();
                arrayList.add(c02733);
            }
            this.f1646.setPrivacyInformationIconImageUrl(getPrivacyInformationIconImageUrl());
            this.f1646.setPrivacyInformationIconClickthroughUrl(getPrivacyInformationIconClickThroughUrl());
            HashSet<String> hashSet = new HashSet();
            hashSet.add(this.f1651);
            hashSet.addAll(m1301());
            ArrayList arrayList2 = new ArrayList();
            for (String str : hashSet) {
                arrayList2.add(new VastTracker(str, false));
            }
            this.f1646.addClickTrackers(arrayList2);
            this.f1646.setClickThroughUrl(getClickDestinationUrl());
            this.f1655 = this.f1654.createForId(this.f1636, this.f1647, arrayList, this.f1646);
            this.f1652.onNativeAdLoaded(this);
            JSONObject m1393 = this.f1653.m1393();
            if (m1393 != null) {
                this.f1646.addVideoTrackers(m1393);
            }
        }

        @Override // com.mopub.nativeads.VideoNativeAd, com.mopub.nativeads.BaseNativeAd
        public void prepare(@NonNull View view) {
            Preconditions.checkNotNull(view);
            this.f1635 = view;
            this.f1635.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MoPubVideoNativeAd.this.m1374();
                    MoPubVideoNativeAd.this.f1655.m1451();
                    MoPubVideoNativeAd.this.f1655.handleCtaClick(MoPubVideoNativeAd.this.f1647);
                }
            });
        }

        @Override // com.mopub.nativeads.VideoNativeAd
        public void render(@NonNull MediaLayout mediaLayout) {
            Preconditions.checkNotNull(mediaLayout);
            this.f1650.addView(this.f1635, mediaLayout, this.f1653.m1388(), this.f1653.m1389(), this.f1653.m1392());
            this.f1657 = mediaLayout;
            this.f1657.initForVideo();
            this.f1657.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.3
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    MoPubVideoNativeAd.this.f1655.setListener(MoPubVideoNativeAd.this);
                    MoPubVideoNativeAd.this.f1655.setOnAudioFocusChangeListener(MoPubVideoNativeAd.this);
                    MoPubVideoNativeAd.this.f1655.setProgressListener(MoPubVideoNativeAd.this);
                    MoPubVideoNativeAd.this.f1655.setTextureView(MoPubVideoNativeAd.this.f1657.getTextureView());
                    MoPubVideoNativeAd.this.f1657.resetProgress();
                    long duration = MoPubVideoNativeAd.this.f1655.getDuration();
                    long currentPosition = MoPubVideoNativeAd.this.f1655.getCurrentPosition();
                    if (MoPubVideoNativeAd.this.f1641 == 4 || (duration > 0 && duration - currentPosition < 750)) {
                        MoPubVideoNativeAd.this.f1645 = true;
                    }
                    if (MoPubVideoNativeAd.this.f1638) {
                        MoPubVideoNativeAd.this.f1638 = false;
                        MoPubVideoNativeAd.this.f1655.prepare(MoPubVideoNativeAd.this);
                    }
                    MoPubVideoNativeAd.this.f1637 = true;
                    MoPubVideoNativeAd.this.m1376();
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    MoPubVideoNativeAd.this.f1638 = true;
                    MoPubVideoNativeAd.this.f1655.release(MoPubVideoNativeAd.this);
                    MoPubVideoNativeAd.this.m1383(VideoState.PAUSED);
                    return true;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }
            });
            this.f1657.setPlayButtonClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MoPubVideoNativeAd.this.f1657.resetProgress();
                    MoPubVideoNativeAd.this.f1655.seekTo(0L);
                    MoPubVideoNativeAd.this.f1645 = false;
                    MoPubVideoNativeAd.this.f1637 = false;
                }
            });
            this.f1657.setMuteControlClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MoPubVideoNativeAd.this.f1644 = !MoPubVideoNativeAd.this.f1644;
                    MoPubVideoNativeAd.this.m1376();
                }
            });
            this.f1657.setOnClickListener(new View.OnClickListener() { // from class: com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MoPubVideoNativeAd.this.m1374();
                    MoPubVideoNativeAd.this.f1655.m1451();
                    MraidVideoPlayerActivity.startNativeVideo(MoPubVideoNativeAd.this.f1647, MoPubVideoNativeAd.this.f1636, MoPubVideoNativeAd.this.f1646);
                }
            });
            if (this.f1655.getPlaybackState() == 5) {
                this.f1655.prepare(this);
            }
            m1383(VideoState.PAUSED);
        }

        @Override // com.mopub.nativeads.NativeVideoController.NativeVideoProgressRunnable.ProgressListener
        public void updateProgress(int i) {
            this.f1657.updateProgress(i);
        }

        @VisibleForTesting
        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1383(@NonNull VideoState videoState) {
            m1384(videoState, false);
        }

        @VisibleForTesting
        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1384(@NonNull VideoState videoState, boolean z) {
            MediaLayout mediaLayout;
            MediaLayout.Mode mode;
            MediaLayout mediaLayout2;
            MediaLayout.MuteState muteState;
            Preconditions.checkNotNull(videoState);
            if (this.f1646 == null || this.f1655 == null || this.f1657 == null || this.f1649 == videoState) {
                return;
            }
            VideoState videoState2 = this.f1649;
            this.f1649 = videoState;
            switch (videoState) {
                case FAILED_LOAD:
                    this.f1646.handleError(this.f1647, null, 0);
                    this.f1655.setAppAudioEnabled(false);
                    mediaLayout = this.f1657;
                    mode = MediaLayout.Mode.IMAGE;
                    mediaLayout.setMode(mode);
                    return;
                case CREATED:
                case LOADING:
                    this.f1655.setPlayWhenReady(true);
                    mediaLayout = this.f1657;
                    mode = MediaLayout.Mode.LOADING;
                    mediaLayout.setMode(mode);
                    return;
                case BUFFERING:
                    this.f1655.setPlayWhenReady(true);
                    mediaLayout = this.f1657;
                    mode = MediaLayout.Mode.BUFFERING;
                    mediaLayout.setMode(mode);
                    return;
                case PAUSED:
                    if (z) {
                        this.f1640 = false;
                    }
                    if (!z) {
                        this.f1655.setAppAudioEnabled(false);
                        if (this.f1639) {
                            TrackingRequest.makeVastTrackingHttpRequest(this.f1646.getPauseTrackers(), null, Integer.valueOf((int) this.f1655.getCurrentPosition()), null, this.f1647);
                            this.f1639 = false;
                            this.f1640 = true;
                        }
                    }
                    this.f1655.setPlayWhenReady(false);
                    mediaLayout = this.f1657;
                    mode = MediaLayout.Mode.PAUSED;
                    mediaLayout.setMode(mode);
                    return;
                case PLAYING:
                    m1361(videoState2);
                    this.f1655.setPlayWhenReady(true);
                    this.f1655.setAudioEnabled(true);
                    this.f1655.setAppAudioEnabled(true);
                    this.f1657.setMode(MediaLayout.Mode.PLAYING);
                    mediaLayout2 = this.f1657;
                    muteState = MediaLayout.MuteState.UNMUTED;
                    mediaLayout2.setMuteState(muteState);
                    return;
                case PLAYING_MUTED:
                    m1361(videoState2);
                    this.f1655.setPlayWhenReady(true);
                    this.f1655.setAudioEnabled(false);
                    this.f1655.setAppAudioEnabled(false);
                    this.f1657.setMode(MediaLayout.Mode.PLAYING);
                    mediaLayout2 = this.f1657;
                    muteState = MediaLayout.MuteState.MUTED;
                    mediaLayout2.setMuteState(muteState);
                    return;
                case ENDED:
                    if (this.f1655.hasFinalFrame()) {
                        this.f1657.setMainImageDrawable(this.f1655.getFinalFrame());
                    }
                    this.f1639 = false;
                    this.f1640 = false;
                    this.f1646.handleComplete(this.f1647, 0);
                    this.f1655.setAppAudioEnabled(false);
                    this.f1657.setMode(MediaLayout.Mode.FINISHED);
                    this.f1657.updateProgress(1000);
                    return;
                default:
                    return;
            }
        }

        /* renamed from: ࢥ  reason: contains not printable characters */
        void m1385() throws IllegalArgumentException {
            if (!m1360(this.f1648)) {
                throw new IllegalArgumentException("JSONObject did not contain required keys.");
            }
            Iterator<String> keys = this.f1648.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                EnumC0266 m1386 = EnumC0266.m1386(next);
                if (m1386 != null) {
                    try {
                        m1356(m1386, this.f1648.opt(next));
                    } catch (ClassCastException unused) {
                        throw new IllegalArgumentException("JSONObject key (" + next + ") contained unexpected value.");
                    }
                } else {
                    addExtra(next, this.f1648.opt(next));
                }
            }
            if (TextUtils.isEmpty(getPrivacyInformationIconClickThroughUrl())) {
                setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout/");
            }
            NativeImageHelper.preCacheImages(this.f1647, m1379(), new NativeImageHelper.ImageListener() { // from class: com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.2
                @Override // com.mopub.nativeads.NativeImageHelper.ImageListener
                public void onImagesCached() {
                    if (MoPubVideoNativeAd.this.isInvalidated()) {
                        return;
                    }
                    MoPubVideoNativeAd.this.f1656.prepareVastVideoConfiguration(MoPubVideoNativeAd.this.getVastVideo(), MoPubVideoNativeAd.this, null, MoPubVideoNativeAd.this.f1647);
                }

                @Override // com.mopub.nativeads.NativeImageHelper.ImageListener
                public void onImagesFailedToCache(NativeErrorCode nativeErrorCode) {
                    if (MoPubVideoNativeAd.this.isInvalidated()) {
                        return;
                    }
                    MoPubVideoNativeAd.this.f1652.onNativeAdFailed(nativeErrorCode);
                }
            });
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0267 implements NativeVideoController.C0273.InterfaceC0274 {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final WeakReference<MoPubVideoNativeAd> f1670;

        C0267(@NonNull MoPubVideoNativeAd moPubVideoNativeAd) {
            this.f1670 = new WeakReference<>(moPubVideoNativeAd);
        }

        @Override // com.mopub.nativeads.NativeVideoController.C0273.InterfaceC0274
        public void execute() {
            MoPubVideoNativeAd moPubVideoNativeAd = this.f1670.get();
            if (moPubVideoNativeAd != null) {
                moPubVideoNativeAd.m1296();
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0268 {
        C0268() {
        }

        public NativeVideoController createForId(long j, @NonNull Context context, @NonNull List<NativeVideoController.C0273> list, @NonNull VastVideoConfig vastVideoConfig) {
            return NativeVideoController.createForId(j, context, list, vastVideoConfig);
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$ࢣ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0269 implements NativeVideoController.C0273.InterfaceC0274 {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final Context f1671;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final String f1672;

        C0269(@NonNull Context context, @NonNull String str) {
            this.f1671 = context.getApplicationContext();
            this.f1672 = str;
        }

        @Override // com.mopub.nativeads.NativeVideoController.C0273.InterfaceC0274
        public void execute() {
            TrackingRequest.makeTrackingHttpRequest(this.f1672, this.f1671);
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$ࢤ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0270 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private boolean f1673;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private int f1674;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private int f1675;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private int f1676;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private int f1677;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private int f1678;

        /* renamed from: ࢧ  reason: contains not printable characters */
        private Integer f1679;

        /* renamed from: ࢨ  reason: contains not printable characters */
        private JSONObject f1680;

        C0270(@NonNull Map<String, String> map) {
            try {
                this.f1674 = Integer.parseInt(map.get(DataKeys.PLAY_VISIBLE_PERCENT));
                this.f1675 = Integer.parseInt(map.get(DataKeys.PAUSE_VISIBLE_PERCENT));
                this.f1677 = Integer.parseInt(map.get(DataKeys.IMPRESSION_VISIBLE_MS));
                this.f1678 = Integer.parseInt(map.get(DataKeys.MAX_BUFFER_MS));
                this.f1673 = true;
            } catch (NumberFormatException unused) {
                this.f1673 = false;
            }
            String str = map.get(DataKeys.IMPRESSION_MIN_VISIBLE_PX);
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f1679 = Integer.valueOf(Integer.parseInt(str));
                } catch (NumberFormatException unused2) {
                    MoPubLog.d("Unable to parse impression min visible px from server extras.");
                }
            }
            try {
                this.f1676 = Integer.parseInt(map.get(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT));
            } catch (NumberFormatException unused3) {
                MoPubLog.d("Unable to parse impression min visible percent from server extras.");
                if (this.f1679 == null || this.f1679.intValue() < 0) {
                    this.f1673 = false;
                }
            }
            String str2 = map.get(DataKeys.VIDEO_TRACKERS_KEY);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                this.f1680 = new JSONObject(str2);
            } catch (JSONException e) {
                MoPubLog.d("Failed to parse video trackers to JSON: " + str2, e);
                this.f1680 = null;
            }
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        boolean m1387() {
            return this.f1673;
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        int m1388() {
            return this.f1674;
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        int m1389() {
            return this.f1675;
        }

        /* renamed from: ࢤ  reason: contains not printable characters */
        int m1390() {
            return this.f1676;
        }

        /* renamed from: ࢥ  reason: contains not printable characters */
        int m1391() {
            return this.f1677;
        }

        @Nullable
        /* renamed from: ࢦ  reason: contains not printable characters */
        Integer m1392() {
            return this.f1679;
        }

        /* renamed from: ࢧ  reason: contains not printable characters */
        JSONObject m1393() {
            return this.f1680;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.nativeads.CustomEventNative
    /* renamed from: ࢠ */
    public void mo1302() {
        if (this.f1632 == null) {
            return;
        }
        this.f1632.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.nativeads.CustomEventNative
    /* renamed from: ࢠ */
    public void mo1268(@NonNull Context context, @NonNull CustomEventNative.CustomEventNativeListener customEventNativeListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        NativeErrorCode nativeErrorCode;
        Object obj = map.get(DataKeys.JSON_BODY_KEY);
        if (obj instanceof JSONObject) {
            map.get(DataKeys.EVENT_DETAILS);
            C0270 c0270 = new C0270(map2);
            if (c0270.m1387()) {
                Object obj2 = map.get(DataKeys.CLICK_TRACKING_URL_KEY);
                if (obj2 instanceof String) {
                    String str = (String) obj2;
                    if (!TextUtils.isEmpty(str)) {
                        this.f1632 = new MoPubVideoNativeAd(context, (JSONObject) obj, customEventNativeListener, c0270, str);
                        try {
                            this.f1632.m1385();
                            return;
                        } catch (IllegalArgumentException unused) {
                            customEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                            return;
                        }
                    }
                }
                nativeErrorCode = NativeErrorCode.UNSPECIFIED;
                customEventNativeListener.onNativeAdFailed(nativeErrorCode);
            }
        }
        nativeErrorCode = NativeErrorCode.INVALID_RESPONSE;
        customEventNativeListener.onNativeAdFailed(nativeErrorCode);
    }
}
