package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.ނ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0220 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final List<String> f1210 = Arrays.asList("image/jpeg", "image/png", "image/bmp", "image/gif");

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static final List<String> f1211 = Arrays.asList("application/x-javascript");
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String f1212;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private EnumC0222 f1213;
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private EnumC0221 f1214;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f1215;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private int f1216;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.ނ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0221 {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.ނ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0222 {
        STATIC_RESOURCE,
        HTML_RESOURCE,
        IFRAME_RESOURCE
    }

    C0220(@NonNull String str, @NonNull EnumC0222 enumC0222, @NonNull EnumC0221 enumC0221, int i, int i2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(enumC0222);
        Preconditions.checkNotNull(enumC0221);
        this.f1212 = str;
        this.f1213 = enumC0222;
        this.f1214 = enumC0221;
        this.f1215 = i;
        this.f1216 = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0220 m1027(@NonNull VastResourceXmlManager vastResourceXmlManager, @NonNull EnumC0222 enumC0222, int i, int i2) {
        EnumC0221 enumC0221;
        Preconditions.checkNotNull(vastResourceXmlManager);
        Preconditions.checkNotNull(enumC0222);
        String m895 = vastResourceXmlManager.m895();
        String m896 = vastResourceXmlManager.m896();
        String m893 = vastResourceXmlManager.m893();
        String m894 = vastResourceXmlManager.m894();
        if (enumC0222 == EnumC0222.STATIC_RESOURCE && m893 != null && m894 != null && (f1210.contains(m894) || f1211.contains(m894))) {
            enumC0221 = f1210.contains(m894) ? EnumC0221.IMAGE : EnumC0221.JAVASCRIPT;
        } else if (enumC0222 == EnumC0222.HTML_RESOURCE && m896 != null) {
            enumC0221 = EnumC0221.NONE;
            m893 = m896;
        } else if (enumC0222 != EnumC0222.IFRAME_RESOURCE || m895 == null) {
            return null;
        } else {
            enumC0221 = EnumC0221.NONE;
            m893 = m895;
        }
        return new C0220(m893, enumC0222, enumC0221, i, i2);
    }

    @Nullable
    public String getCorrectClickThroughUrl(@Nullable String str, @Nullable String str2) {
        switch (this.f1213) {
            case STATIC_RESOURCE:
                if (EnumC0221.IMAGE == this.f1214) {
                    return str;
                }
                if (EnumC0221.JAVASCRIPT == this.f1214) {
                    return str2;
                }
                return null;
            case HTML_RESOURCE:
            case IFRAME_RESOURCE:
                return str2;
            default:
                return null;
        }
    }

    @NonNull
    public EnumC0221 getCreativeType() {
        return this.f1214;
    }

    @NonNull
    public String getResource() {
        return this.f1212;
    }

    @NonNull
    public EnumC0222 getType() {
        return this.f1213;
    }

    public void initializeWebView(@NonNull C0223 c0223) {
        StringBuilder sb;
        String str;
        String str2;
        Preconditions.checkNotNull(c0223);
        if (this.f1213 == EnumC0222.IFRAME_RESOURCE) {
            sb = new StringBuilder();
            sb.append("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"");
            sb.append(this.f1215);
            sb.append("\" height=\"");
            sb.append(this.f1216);
            sb.append("\" src=\"");
            sb.append(this.f1212);
            str = "\"></iframe>";
        } else if (this.f1213 == EnumC0222.HTML_RESOURCE) {
            str2 = this.f1212;
            c0223.m1031(str2);
        } else if (this.f1213 != EnumC0222.STATIC_RESOURCE) {
            return;
        } else {
            if (this.f1214 == EnumC0221.IMAGE) {
                sb = new StringBuilder();
                sb.append("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"");
                sb.append(this.f1212);
                str = "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
            } else if (this.f1214 != EnumC0221.JAVASCRIPT) {
                return;
            } else {
                sb = new StringBuilder();
                sb.append("<script src=\"");
                sb.append(this.f1212);
                str = "\"></script>";
            }
        }
        sb.append(str);
        str2 = sb.toString();
        c0223.m1031(str2);
    }
}
