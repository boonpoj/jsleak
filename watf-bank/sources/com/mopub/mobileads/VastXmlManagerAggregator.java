package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Point;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.C0220;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class VastXmlManagerAggregator extends AsyncTask<String, Void, VastVideoConfig> {
    public static final String ADS_BY_AD_SLOT_ID = "adsBy";
    public static final String SOCIAL_ACTIONS_AD_SLOT_ID = "socialActions";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final List<String> f1150 = Arrays.asList("video/mp4", "video/3gpp");
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final WeakReference<InterfaceC0212> f1151;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final double f1152;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final int f1153;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Context f1154;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f1155;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.VastXmlManagerAggregator$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0211 {
        LANDSCAPE,
        PORTRAIT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.VastXmlManagerAggregator$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0212 {
        void onAggregationComplete(@Nullable VastVideoConfig vastVideoConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastXmlManagerAggregator(@NonNull InterfaceC0212 interfaceC0212, double d, int i, @NonNull Context context) {
        Preconditions.checkNotNull(interfaceC0212);
        Preconditions.checkNotNull(context);
        this.f1151 = new WeakReference<>(interfaceC0212);
        this.f1152 = d;
        this.f1153 = i;
        this.f1154 = context.getApplicationContext();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private double m972(int i, int i2) {
        double d = i;
        double d2 = i2;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = (d / d2) / this.f1152;
        double d4 = i * i2;
        double d5 = this.f1153;
        Double.isNaN(d4);
        Double.isNaN(d5);
        return (Math.abs(Math.log(d3)) * 70.0d) + (Math.abs(Math.log(d4 / d5)) * 30.0d);
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private VastVideoConfig m973(@NonNull C0216 c0216, @NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(c0216);
        Preconditions.checkNotNull(list);
        for (C0217 c0217 : c0216.m1098()) {
            String m986 = m986(c0217.m1021());
            if (m986 != null) {
                VastVideoConfig vastVideoConfig = new VastVideoConfig();
                vastVideoConfig.addImpressionTrackers(c0216.m1096());
                m975(c0217, vastVideoConfig);
                vastVideoConfig.setClickThroughUrl(c0217.m1018());
                vastVideoConfig.setNetworkMediaFileUrl(m986);
                List<C0243> list2 = c0216.m1099();
                vastVideoConfig.setVastCompanionAd(m983(list2, EnumC0211.LANDSCAPE), m983(list2, EnumC0211.PORTRAIT));
                vastVideoConfig.setSocialActionsCompanionAds(m988(list2));
                list.addAll(c0216.m1097());
                vastVideoConfig.addErrorTrackers(list);
                m977(c0216, vastVideoConfig);
                m981(c0216, vastVideoConfig);
                return vastVideoConfig;
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private String m974(@NonNull C0226 c0226, @NonNull List<VastTracker> list) {
        String m1032 = c0226.m1032();
        if (m1032 == null) {
            return null;
        }
        try {
            return m980(m1032);
        } catch (Exception e) {
            MoPubLog.d("Failed to follow VAST redirect", e);
            if (!list.isEmpty()) {
                TrackingRequest.makeVastTrackingHttpRequest(list, VastErrorCode.WRAPPER_TIMEOUT, null, null, this.f1154);
            }
            return null;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m975(@NonNull C0217 c0217, @NonNull VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(c0217, "linearXmlManager cannot be null");
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        vastVideoConfig.addAbsoluteTrackers(c0217.m1012());
        vastVideoConfig.addFractionalTrackers(c0217.m1011());
        vastVideoConfig.addPauseTrackers(c0217.m1014());
        vastVideoConfig.addResumeTrackers(c0217.m1015());
        vastVideoConfig.addCompleteTrackers(c0217.m1013());
        vastVideoConfig.addCloseTrackers(c0217.m1016());
        vastVideoConfig.addSkipTrackers(c0217.m1017());
        vastVideoConfig.addClickTrackers(c0217.m1019());
        if (vastVideoConfig.getSkipOffsetString() == null) {
            vastVideoConfig.setSkipOffset(c0217.m1020());
        }
        if (vastVideoConfig.getVastIconConfig() == null) {
            vastVideoConfig.setVastIconConfig(m989(c0217.m1022()));
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m976(@NonNull C0227 c0227, @NonNull VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(c0227, "xmlManager cannot be null");
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        vastVideoConfig.addImpressionTrackers(c0227.m1036());
        if (vastVideoConfig.getCustomCtaText() == null) {
            vastVideoConfig.setCustomCtaText(c0227.m1037());
        }
        if (vastVideoConfig.getCustomSkipText() == null) {
            vastVideoConfig.setCustomSkipText(c0227.m1038());
        }
        if (vastVideoConfig.getCustomCloseIconUrl() == null) {
            vastVideoConfig.setCustomCloseIconUrl(c0227.m1039());
        }
        if (vastVideoConfig.isCustomForceOrientationSet()) {
            return;
        }
        vastVideoConfig.setCustomForceOrientation(c0227.m1040());
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m977(@NonNull AbstractC0242 abstractC0242, @NonNull VastVideoConfig vastVideoConfig) {
        VastExtensionParentXmlManager m1100;
        Preconditions.checkNotNull(abstractC0242);
        Preconditions.checkNotNull(vastVideoConfig);
        if (vastVideoConfig.getVideoViewabilityTracker() == null && (m1100 = abstractC0242.m1100()) != null) {
            for (VastExtensionXmlManager vastExtensionXmlManager : m1100.m874()) {
                if ("MoPub".equals(vastExtensionXmlManager.m878())) {
                    vastVideoConfig.setVideoViewabilityTracker(vastExtensionXmlManager.m875());
                    return;
                }
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static boolean m978(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return Integer.parseInt(str) < 2;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m979(@NonNull List<C0241> list, @NonNull C0227 c0227, @NonNull Context context) {
        if (!list.isEmpty() || c0227.m1035() == null) {
            return false;
        }
        TrackingRequest.makeVastTrackingHttpRequest(Collections.singletonList(c0227.m1035()), this.f1155 > 0 ? VastErrorCode.NO_ADS_VAST_RESPONSE : VastErrorCode.UNDEFINED_ERROR, null, null, context);
        return true;
    }

    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    private String m980(@NonNull String str) throws IOException {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Preconditions.checkNotNull(str);
        BufferedInputStream bufferedInputStream = null;
        if (this.f1155 >= 10) {
            return null;
        }
        this.f1155++;
        try {
            httpURLConnection = MoPubHttpUrlConnection.getHttpUrlConnection(str);
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    String fromStream = Strings.fromStream(bufferedInputStream2);
                    Streams.closeStream(bufferedInputStream2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return fromStream;
                } catch (Throwable th2) {
                    bufferedInputStream = bufferedInputStream2;
                    th = th2;
                    Streams.closeStream(bufferedInputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m981(@NonNull AbstractC0242 abstractC0242, @NonNull VastVideoConfig vastVideoConfig) {
        VastExtensionParentXmlManager m1100 = abstractC0242.m1100();
        if (m1100 != null) {
            for (VastExtensionXmlManager vastExtensionXmlManager : m1100.m874()) {
                if (vastExtensionXmlManager != null) {
                    vastVideoConfig.addAvidJavascriptResources(vastExtensionXmlManager.m876());
                    vastVideoConfig.addMoatImpressionPixels(vastExtensionXmlManager.m877());
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        InterfaceC0212 interfaceC0212 = this.f1151.get();
        if (interfaceC0212 != null) {
            interfaceC0212.onAggregationComplete(null);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        Networking.getUserAgent(this.f1154);
    }

    @NonNull
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    Point m982(int i, int i2, C0220.EnumC0222 enumC0222, EnumC0211 enumC0211) {
        int min;
        int max;
        int i3;
        Point point = new Point(i, i2);
        Display defaultDisplay = ((WindowManager) this.f1154.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int dipsToIntPixels = Dips.dipsToIntPixels(i, this.f1154);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(i2, this.f1154);
        if (EnumC0211.LANDSCAPE == enumC0211) {
            min = Math.max(width, height);
            max = Math.min(width, height);
        } else {
            min = Math.min(width, height);
            max = Math.max(width, height);
        }
        if (dipsToIntPixels > min - 16 || dipsToIntPixels2 > max - 16) {
            Point point2 = new Point();
            if (C0220.EnumC0222.HTML_RESOURCE == enumC0222) {
                point2.x = Math.min(min, dipsToIntPixels);
                i3 = Math.min(max, dipsToIntPixels2);
            } else {
                float f = dipsToIntPixels;
                float f2 = f / min;
                float f3 = dipsToIntPixels2;
                float f4 = f3 / max;
                if (f2 < f4) {
                    point2.x = (int) (f / f4);
                    point2.y = max;
                    point2.x -= 16;
                    point2.y -= 16;
                    if (point2.x >= 0 || point2.y < 0) {
                        return point;
                    }
                    point2.x = Dips.pixelsToIntDips(point2.x, this.f1154);
                    point2.y = Dips.pixelsToIntDips(point2.y, this.f1154);
                    return point2;
                }
                point2.x = min;
                i3 = (int) (f3 / f2);
            }
            point2.y = i3;
            point2.x -= 16;
            point2.y -= 16;
            if (point2.x >= 0) {
            }
            return point;
        }
        return point;
    }

    @Nullable
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    VastCompanionAdConfig m983(@NonNull List<C0243> list, @NonNull EnumC0211 enumC0211) {
        C0220.EnumC0222[] enumC0222Arr;
        ArrayList arrayList;
        int i;
        int intValue;
        int intValue2;
        Preconditions.checkNotNull(list, "managers cannot be null");
        Preconditions.checkNotNull(enumC0211, "orientation cannot be null");
        ArrayList<C0243> arrayList2 = new ArrayList(list);
        C0220.EnumC0222[] values = C0220.EnumC0222.values();
        int length = values.length;
        int i2 = 0;
        double d = Double.POSITIVE_INFINITY;
        C0243 c0243 = null;
        C0220 c0220 = null;
        Point point = null;
        while (i2 < length) {
            C0220.EnumC0222 enumC0222 = values[i2];
            for (C0243 c02432 : arrayList2) {
                Integer m1101 = c02432.m1101();
                Integer m1102 = c02432.m1102();
                if (m1101 != null) {
                    enumC0222Arr = values;
                    if (m1101.intValue() >= 300 && m1102 != null && m1102.intValue() >= 250) {
                        Point m982 = m982(m1101.intValue(), m1102.intValue(), enumC0222, enumC0211);
                        arrayList = arrayList2;
                        i = length;
                        C0220 m1027 = C0220.m1027(c02432.m1104(), enumC0222, m982.x, m982.y);
                        if (m1027 != null) {
                            if (EnumC0211.PORTRAIT == enumC0211) {
                                intValue = m1102.intValue();
                                intValue2 = m1101.intValue();
                            } else {
                                intValue = m1101.intValue();
                                intValue2 = m1102.intValue();
                            }
                            double m972 = m972(intValue, intValue2);
                            if (m972 < d) {
                                point = m982;
                                c0220 = m1027;
                                d = m972;
                                c0243 = c02432;
                            }
                        }
                        values = enumC0222Arr;
                        arrayList2 = arrayList;
                        length = i;
                    }
                } else {
                    enumC0222Arr = values;
                }
                arrayList = arrayList2;
                i = length;
                values = enumC0222Arr;
                arrayList2 = arrayList;
                length = i;
            }
            C0220.EnumC0222[] enumC0222Arr2 = values;
            ArrayList arrayList3 = arrayList2;
            int i3 = length;
            if (c0243 != null) {
                break;
            }
            i2++;
            values = enumC0222Arr2;
            arrayList2 = arrayList3;
            length = i3;
        }
        C0220 c02202 = c0220;
        if (c0243 != null) {
            return new VastCompanionAdConfig(point.x, point.y, c02202, c0243.m1105(), c0243.m1106(), c0243.m1107());
        }
        return null;
    }

    @Nullable
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    VastVideoConfig m984(@NonNull String str, @NonNull List<VastTracker> list) {
        VastVideoConfig m984;
        VastVideoConfig m973;
        Preconditions.checkNotNull(str, "vastXml cannot be null");
        Preconditions.checkNotNull(list, "errorTrackers cannot be null");
        C0227 c0227 = new C0227();
        try {
            c0227.m1034(str);
            List<C0241> m1033 = c0227.m1033();
            if (m979(m1033, c0227, this.f1154)) {
                return null;
            }
            for (C0241 c0241 : m1033) {
                if (m978(c0241.m1095())) {
                    C0216 m1093 = c0241.m1093();
                    if (m1093 != null && (m973 = m973(m1093, list)) != null) {
                        m976(c0227, m973);
                        return m973;
                    }
                    C0226 m1094 = c0241.m1094();
                    if (m1094 != null) {
                        List<VastTracker> arrayList = new ArrayList<>(list);
                        arrayList.addAll(m1094.m1097());
                        String m974 = m974(m1094, arrayList);
                        if (m974 != null && (m984 = m984(m974, arrayList)) != null) {
                            m984.addImpressionTrackers(m1094.m1096());
                            for (C0217 c0217 : m1094.m1098()) {
                                m975(c0217, m984);
                            }
                            m977(m1094, m984);
                            m981(m1094, m984);
                            List<C0243> list2 = m1094.m1099();
                            if (m984.hasCompanionAd()) {
                                VastCompanionAdConfig vastCompanionAd = m984.getVastCompanionAd(2);
                                VastCompanionAdConfig vastCompanionAd2 = m984.getVastCompanionAd(1);
                                if (vastCompanionAd != null && vastCompanionAd2 != null) {
                                    for (C0243 c0243 : list2) {
                                        if (!c0243.m1108()) {
                                            vastCompanionAd.addClickTrackers(c0243.m1106());
                                            vastCompanionAd.addCreativeViewTrackers(c0243.m1107());
                                            vastCompanionAd2.addClickTrackers(c0243.m1106());
                                            vastCompanionAd2.addCreativeViewTrackers(c0243.m1107());
                                        }
                                    }
                                }
                            } else {
                                m984.setVastCompanionAd(m983(list2, EnumC0211.LANDSCAPE), m983(list2, EnumC0211.PORTRAIT));
                            }
                            if (m984.getSocialActionsCompanionAds().isEmpty()) {
                                m984.setSocialActionsCompanionAds(m988(list2));
                            }
                            m976(c0227, m984);
                            return m984;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            MoPubLog.d("Failed to parse VAST XML", e);
            TrackingRequest.makeVastTrackingHttpRequest(list, VastErrorCode.XML_PARSING_ERROR, null, null, this.f1154);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public VastVideoConfig doInBackground(@Nullable String... strArr) {
        if (strArr != null && strArr.length != 0 && strArr[0] != null) {
            try {
                return m984(strArr[0], new ArrayList());
            } catch (Exception e) {
                MoPubLog.d("Unable to generate VastVideoConfig.", e);
            }
        }
        return null;
    }

    @Nullable
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    String m986(@NonNull List<C0219> list) {
        Preconditions.checkNotNull(list, "managers cannot be null");
        Iterator it = new ArrayList(list).iterator();
        double d = Double.POSITIVE_INFINITY;
        String str = null;
        while (it.hasNext()) {
            C0219 c0219 = (C0219) it.next();
            String m1025 = c0219.m1025();
            String m1026 = c0219.m1026();
            if (!f1150.contains(m1025) || m1026 == null) {
                it.remove();
            } else {
                Integer m1023 = c0219.m1023();
                Integer m1024 = c0219.m1024();
                if (m1023 != null && m1023.intValue() > 0 && m1024 != null && m1024.intValue() > 0) {
                    double m972 = m972(m1023.intValue(), m1024.intValue());
                    if (m972 < d) {
                        d = m972;
                        str = m1026;
                    }
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void onPostExecute(@Nullable VastVideoConfig vastVideoConfig) {
        InterfaceC0212 interfaceC0212 = this.f1151.get();
        if (interfaceC0212 != null) {
            interfaceC0212.onAggregationComplete(vastVideoConfig);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0010 A[SYNTHETIC] */
    @android.support.annotation.NonNull
    @com.mopub.common.VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.util.Map<java.lang.String, com.mopub.mobileads.VastCompanionAdConfig> m988(@android.support.annotation.NonNull java.util.List<com.mopub.mobileads.C0243> r18) {
        /*
            r17 = this;
            java.lang.String r0 = "managers cannot be null"
            r1 = r18
            com.mopub.common.Preconditions.checkNotNull(r1, r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Iterator r1 = r18.iterator()
        L10:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lad
            java.lang.Object r2 = r1.next()
            com.mopub.mobileads.ࢫ r2 = (com.mopub.mobileads.C0243) r2
            java.lang.Integer r3 = r2.m1101()
            java.lang.Integer r4 = r2.m1102()
            if (r3 == 0) goto L10
            if (r4 != 0) goto L29
            goto L10
        L29:
            java.lang.String r5 = r2.m1103()
            java.lang.String r6 = "adsBy"
            boolean r6 = r6.equals(r5)
            r7 = 10
            r8 = 50
            if (r6 == 0) goto L56
            int r6 = r3.intValue()
            r9 = 25
            if (r6 < r9) goto L10
            int r6 = r3.intValue()
            r9 = 75
            if (r6 > r9) goto L10
            int r6 = r4.intValue()
            if (r6 < r7) goto L10
            int r6 = r4.intValue()
            if (r6 <= r8) goto L79
            goto L10
        L56:
            java.lang.String r6 = "socialActions"
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L10
            int r6 = r3.intValue()
            if (r6 < r8) goto L10
            int r6 = r3.intValue()
            r9 = 150(0x96, float:2.1E-43)
            if (r6 > r9) goto L10
            int r6 = r4.intValue()
            if (r6 < r7) goto L10
            int r6 = r4.intValue()
            if (r6 <= r8) goto L79
            goto L10
        L79:
            com.mopub.mobileads.VastResourceXmlManager r6 = r2.m1104()
            com.mopub.mobileads.ނ$ࢢ r7 = com.mopub.mobileads.C0220.EnumC0222.HTML_RESOURCE
            int r8 = r3.intValue()
            int r9 = r4.intValue()
            com.mopub.mobileads.ނ r13 = com.mopub.mobileads.C0220.m1027(r6, r7, r8, r9)
            if (r13 != 0) goto L8e
            goto L10
        L8e:
            com.mopub.mobileads.VastCompanionAdConfig r6 = new com.mopub.mobileads.VastCompanionAdConfig
            int r11 = r3.intValue()
            int r12 = r4.intValue()
            java.lang.String r14 = r2.m1105()
            java.util.List r15 = r2.m1106()
            java.util.List r16 = r2.m1107()
            r10 = r6
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r0.put(r5, r6)
            goto L10
        Lad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VastXmlManagerAggregator.m988(java.util.List):java.util.Map");
    }

    @Nullable
    @VisibleForTesting
    /* renamed from: ࢣ  reason: contains not printable characters */
    C0244 m989(@NonNull List<VastIconXmlManager> list) {
        C0220.EnumC0222[] values;
        C0220 m1027;
        Preconditions.checkNotNull(list, "managers cannot be null");
        ArrayList<VastIconXmlManager> arrayList = new ArrayList(list);
        for (C0220.EnumC0222 enumC0222 : C0220.EnumC0222.values()) {
            for (VastIconXmlManager vastIconXmlManager : arrayList) {
                Integer m879 = vastIconXmlManager.m879();
                Integer m880 = vastIconXmlManager.m880();
                if (m879 != null && m879.intValue() > 0 && m879.intValue() <= 300 && m880 != null && m880.intValue() > 0 && m880.intValue() <= 300 && (m1027 = C0220.m1027(vastIconXmlManager.m883(), enumC0222, m879.intValue(), m880.intValue())) != null) {
                    return new C0244(vastIconXmlManager.m879().intValue(), vastIconXmlManager.m880().intValue(), vastIconXmlManager.m881(), vastIconXmlManager.m882(), m1027, vastIconXmlManager.m884(), vastIconXmlManager.m885(), vastIconXmlManager.m886());
                }
            }
        }
        return null;
    }
}
