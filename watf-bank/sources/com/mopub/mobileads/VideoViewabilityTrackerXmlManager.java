package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;
/* loaded from: assets/classes2.dex */
public class VideoViewabilityTrackerXmlManager {
    public static final String PERCENT_VIEWABLE = "percentViewable";
    public static final String VIEWABLE_PLAYTIME = "viewablePlaytime";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Node f1162;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoViewabilityTrackerXmlManager(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.f1162 = node;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    @android.support.annotation.Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Integer m994() {
        /*
            r6 = this;
            org.w3c.dom.Node r0 = r6.f1162
            java.lang.String r1 = "viewablePlaytime"
            java.lang.String r0 = com.mopub.mobileads.util.XmlUtils.getAttributeValue(r0, r1)
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            boolean r2 = com.mopub.common.util.Strings.isAbsoluteTracker(r0)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L27
            java.lang.Integer r2 = com.mopub.common.util.Strings.parseAbsoluteOffset(r0)     // Catch: java.lang.NumberFormatException -> L19
            goto L3d
        L19:
            java.lang.String r2 = "Invalid VAST viewablePlaytime format for \"HH:MM:SS[.mmm]\": %s:"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r3] = r0
        L1f:
            java.lang.String r0 = java.lang.String.format(r2, r4)
            com.mopub.common.logging.MoPubLog.d(r0)
            goto L3c
        L27:
            float r2 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L35
            r5 = 1148846080(0x447a0000, float:1000.0)
            float r2 = r2 * r5
            int r2 = (int) r2     // Catch: java.lang.NumberFormatException -> L35
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.NumberFormatException -> L35
            goto L3d
        L35:
            java.lang.String r2 = "Invalid VAST viewablePlaytime format for \"SS[.mmm]\": %s:"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r3] = r0
            goto L1f
        L3c:
            r2 = r1
        L3d:
            if (r2 == 0) goto L47
            int r0 = r2.intValue()
            if (r0 >= 0) goto L46
            goto L47
        L46:
            return r2
        L47:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VideoViewabilityTrackerXmlManager.m994():java.lang.Integer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public Integer m995() {
        Integer num;
        String attributeValue = XmlUtils.getAttributeValue(this.f1162, PERCENT_VIEWABLE);
        if (attributeValue == null) {
            return null;
        }
        try {
            num = Integer.valueOf((int) Float.parseFloat(attributeValue.replace("%", "")));
        } catch (NumberFormatException unused) {
            MoPubLog.d(String.format("Invalid VAST percentViewable format for \"d{1,3}%%\": %s:", attributeValue));
            num = null;
        }
        if (num == null || num.intValue() < 0 || num.intValue() > 100) {
            return null;
        }
        return num;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢣ  reason: contains not printable characters */
    public String m996() {
        return XmlUtils.getNodeValue(this.f1162);
    }
}
