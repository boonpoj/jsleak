package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.ࢨ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0239 {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Map<String, CustomEventRewardedAd> f1265 = new TreeMap();
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Map<String, MoPubReward> f1266 = new TreeMap();
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Map<String, Set<MoPubReward>> f1267 = new TreeMap();
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Map<String, String> f1268 = new TreeMap();
    @NonNull

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Map<String, String> f1269 = new TreeMap();
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final Map<Class<? extends CustomEventRewardedAd>, MoPubReward> f1270 = new HashMap();
    @NonNull

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final Map<C0240, Set<String>> f1271 = new HashMap();
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private String f1272;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private String f1273;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.mobileads.ࢨ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0240 extends Pair<Class<? extends CustomEventRewardedAd>, String> {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        final Class<? extends CustomEventRewardedAd> f1274;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        final String f1275;

        public C0240(@NonNull Class<? extends CustomEventRewardedAd> cls, @NonNull String str) {
            super(cls, str);
            this.f1274 = cls;
            this.f1275 = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public MoPubReward m1072(@NonNull Class<? extends CustomEventRewardedAd> cls) {
        return this.f1270.get(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public CustomEventRewardedAd m1073(@Nullable String str) {
        return this.f1265.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m1074() {
        return this.f1272;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public Set<String> m1075(@NonNull Class<? extends CustomEventRewardedAd> cls, @Nullable String str) {
        if (str != null) {
            C0240 c0240 = new C0240(cls, str);
            return this.f1271.containsKey(c0240) ? this.f1271.get(c0240) : Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry<C0240, Set<String>> entry : this.f1271.entrySet()) {
            if (cls == entry.getKey().f1274) {
                hashSet.addAll(entry.getValue());
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1076(@NonNull Class<? extends CustomEventRewardedAd> cls, @Nullable MoPubReward moPubReward) {
        Preconditions.checkNotNull(cls);
        this.f1270.put(cls, moPubReward);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1077(@NonNull Class<? extends CustomEventRewardedAd> cls, @NonNull String str, @NonNull String str2) {
        C0240 c0240 = new C0240(cls, str);
        Iterator<Map.Entry<C0240, Set<String>>> it = this.f1271.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<C0240, Set<String>> next = it.next();
            if (!next.getKey().equals(c0240) && next.getValue().contains(str2)) {
                next.getValue().remove(str2);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        Set<String> set = this.f1271.get(c0240);
        if (set == null) {
            set = new HashSet<>();
            this.f1271.put(c0240, set);
        }
        set.add(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1078(@NonNull String str, @NonNull MoPubReward moPubReward) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(moPubReward);
        Set<MoPubReward> set = this.f1267.get(str);
        if (set == null || set.isEmpty()) {
            MoPubLog.e(String.format(Locale.US, "AdUnit %s does not have any rewards.", str));
        } else if (set.contains(moPubReward)) {
            m1085(str, moPubReward.getLabel(), Integer.toString(moPubReward.getAmount()));
        } else {
            MoPubLog.e(String.format(Locale.US, "Selected reward is invalid for AdUnit %s.", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1079(@NonNull String str, @NonNull CustomEventRewardedAd customEventRewardedAd, @NonNull String str2) {
        this.f1265.put(str, customEventRewardedAd);
        m1077((Class<? extends CustomEventRewardedAd>) customEventRewardedAd.getClass(), str2, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1080(@NonNull String str, @Nullable String str2) {
        Preconditions.checkNotNull(str);
        this.f1268.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1081(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        String format;
        Locale locale;
        String str4;
        Object[] objArr;
        int parseInt;
        Preconditions.checkNotNull(str);
        if (str2 == null || str3 == null) {
            format = String.format(Locale.US, "Currency name and amount cannot be null: name = %s, amount = %s", str2, str3);
        } else {
            try {
                parseInt = Integer.parseInt(str3);
            } catch (NumberFormatException unused) {
                locale = Locale.US;
                str4 = "Currency amount must be an integer: %s";
                objArr = new Object[]{str3};
            }
            if (parseInt >= 0) {
                if (this.f1267.containsKey(str)) {
                    this.f1267.get(str).add(MoPubReward.success(str2, parseInt));
                    return;
                }
                HashSet hashSet = new HashSet();
                hashSet.add(MoPubReward.success(str2, parseInt));
                this.f1267.put(str, hashSet);
                return;
            }
            locale = Locale.US;
            str4 = "Currency amount cannot be negative: %s";
            objArr = new Object[]{str3};
            format = String.format(locale, str4, objArr);
        }
        MoPubLog.e(format);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public MoPubReward m1082(@Nullable String str) {
        return this.f1266.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    public String m1083() {
        return this.f1273;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1084(@NonNull String str, @Nullable String str2) {
        Preconditions.NoThrow.checkNotNull(str);
        this.f1269.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1085(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Preconditions.checkNotNull(str);
        if (str2 == null || str3 == null) {
            this.f1266.remove(str);
            return;
        }
        try {
            int parseInt = Integer.parseInt(str3);
            if (parseInt < 0) {
                MoPubLog.e(String.format(Locale.US, "Currency amount cannot be negative: %s", str3));
            } else {
                this.f1266.put(str, MoPubReward.success(str2, parseInt));
            }
        } catch (NumberFormatException unused) {
            MoPubLog.e(String.format(Locale.US, "Currency amount must be an integer: %s", str3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢣ  reason: contains not printable characters */
    public String m1086(@Nullable String str) {
        return this.f1269.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢤ  reason: contains not printable characters */
    public Set<MoPubReward> m1087(@NonNull String str) {
        Preconditions.checkNotNull(str);
        Set<MoPubReward> set = this.f1267.get(str);
        return set == null ? Collections.emptySet() : set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public void m1088(@NonNull String str) {
        Preconditions.checkNotNull(str);
        Set<MoPubReward> set = this.f1267.get(str);
        if (set == null || set.isEmpty()) {
            return;
        }
        set.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢦ  reason: contains not printable characters */
    public void m1089(@NonNull String str) {
        Preconditions.checkNotNull(str);
        m1085(str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: ࢧ  reason: contains not printable characters */
    public String m1090(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f1268.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public void m1091(@Nullable String str) {
        this.f1272 = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢩ  reason: contains not printable characters */
    public void m1092(@Nullable String str) {
        this.f1273 = str;
    }
}
