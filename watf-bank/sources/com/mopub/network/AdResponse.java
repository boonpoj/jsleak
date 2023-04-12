package com.mopub.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.util.DateAndTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AdResponse implements Serializable {
    private static final long serialVersionUID = 1;
    @Nullable

    /* renamed from: ֏  reason: contains not printable characters */
    private final String f1986;
    @Nullable

    /* renamed from: ؠ  reason: contains not printable characters */
    private final String f1987;
    @NonNull

    /* renamed from: ހ  reason: contains not printable characters */
    private final List<String> f1988;
    @NonNull

    /* renamed from: ށ  reason: contains not printable characters */
    private final List<String> f1989;
    @NonNull

    /* renamed from: ނ  reason: contains not printable characters */
    private final List<String> f1990;
    @Nullable

    /* renamed from: ރ  reason: contains not printable characters */
    private final String f1991;
    @Nullable

    /* renamed from: ބ  reason: contains not printable characters */
    private final Integer f1992;
    @Nullable

    /* renamed from: ޅ  reason: contains not printable characters */
    private final Integer f1993;
    @Nullable

    /* renamed from: ކ  reason: contains not printable characters */
    private final Integer f1994;
    @Nullable

    /* renamed from: އ  reason: contains not printable characters */
    private final Integer f1995;
    @Nullable

    /* renamed from: ވ  reason: contains not printable characters */
    private final String f1996;
    @Nullable

    /* renamed from: މ  reason: contains not printable characters */
    private final String f1997;
    @Nullable

    /* renamed from: ފ  reason: contains not printable characters */
    private final JSONObject f1998;
    @Nullable

    /* renamed from: ދ  reason: contains not printable characters */
    private final String f1999;
    @Nullable

    /* renamed from: ތ  reason: contains not printable characters */
    private final MoPub.BrowserAgent f2000;
    @NonNull

    /* renamed from: ލ  reason: contains not printable characters */
    private final Map<String, String> f2001;

    /* renamed from: ގ  reason: contains not printable characters */
    private final long f2002;
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f2003;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final String f2004;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final String f2005;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final String f2006;
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final String f2007;
    @Nullable

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final String f2008;
    @Nullable

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final String f2009;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final String f2010;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final Integer f2011;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final boolean f2012;
    @Nullable

    /* renamed from: ࢫ  reason: contains not printable characters */
    private final String f2013;
    @NonNull

    /* renamed from: ࢬ  reason: contains not printable characters */
    private final List<String> f2014;

    /* loaded from: assets/classes2.dex */
    public static class Builder {

        /* renamed from: ֏  reason: contains not printable characters */
        private String f2015;

        /* renamed from: ؠ  reason: contains not printable characters */
        private String f2016;

        /* renamed from: ރ  reason: contains not printable characters */
        private String f2020;

        /* renamed from: ބ  reason: contains not printable characters */
        private Integer f2021;

        /* renamed from: ޅ  reason: contains not printable characters */
        private Integer f2022;

        /* renamed from: ކ  reason: contains not printable characters */
        private Integer f2023;

        /* renamed from: އ  reason: contains not printable characters */
        private Integer f2024;

        /* renamed from: ވ  reason: contains not printable characters */
        private String f2025;

        /* renamed from: މ  reason: contains not printable characters */
        private String f2026;

        /* renamed from: ފ  reason: contains not printable characters */
        private JSONObject f2027;

        /* renamed from: ދ  reason: contains not printable characters */
        private String f2028;

        /* renamed from: ތ  reason: contains not printable characters */
        private MoPub.BrowserAgent f2029;

        /* renamed from: ࢠ  reason: contains not printable characters */
        private String f2031;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private String f2032;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private String f2033;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private String f2034;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private String f2035;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private String f2036;

        /* renamed from: ࢧ  reason: contains not printable characters */
        private String f2037;

        /* renamed from: ࢨ  reason: contains not printable characters */
        private String f2038;

        /* renamed from: ࢩ  reason: contains not printable characters */
        private Integer f2039;

        /* renamed from: ࢪ  reason: contains not printable characters */
        private boolean f2040;

        /* renamed from: ࢫ  reason: contains not printable characters */
        private String f2041;

        /* renamed from: ࢬ  reason: contains not printable characters */
        private List<String> f2042 = new ArrayList();

        /* renamed from: ހ  reason: contains not printable characters */
        private List<String> f2017 = new ArrayList();

        /* renamed from: ށ  reason: contains not printable characters */
        private List<String> f2018 = new ArrayList();

        /* renamed from: ނ  reason: contains not printable characters */
        private List<String> f2019 = new ArrayList();

        /* renamed from: ލ  reason: contains not printable characters */
        private Map<String, String> f2030 = new TreeMap();

        public AdResponse build() {
            return new AdResponse(this);
        }

        public Builder setAdTimeoutDelayMilliseconds(@Nullable Integer num) {
            this.f2023 = num;
            return this;
        }

        public Builder setAdType(@Nullable String str) {
            this.f2031 = str;
            return this;
        }

        public Builder setAdUnitId(@Nullable String str) {
            this.f2032 = str;
            return this;
        }

        public Builder setAfterLoadFailUrls(@NonNull List<String> list) {
            Preconditions.checkNotNull(list);
            this.f2019 = list;
            return this;
        }

        public Builder setAfterLoadSuccessUrls(@NonNull List<String> list) {
            Preconditions.checkNotNull(list);
            this.f2018 = list;
            return this;
        }

        public Builder setAfterLoadUrls(@NonNull List<String> list) {
            Preconditions.checkNotNull(list);
            this.f2017 = list;
            return this;
        }

        public Builder setBeforeLoadUrl(@Nullable String str) {
            this.f2016 = str;
            return this;
        }

        public Builder setBrowserAgent(@Nullable MoPub.BrowserAgent browserAgent) {
            this.f2029 = browserAgent;
            return this;
        }

        public Builder setClickTrackingUrl(@Nullable String str) {
            this.f2041 = str;
            return this;
        }

        public Builder setCustomEventClassName(@Nullable String str) {
            this.f2028 = str;
            return this;
        }

        public Builder setDimensions(@Nullable Integer num, @Nullable Integer num2) {
            this.f2021 = num;
            this.f2022 = num2;
            return this;
        }

        public Builder setDspCreativeId(@Nullable String str) {
            this.f2025 = str;
            return this;
        }

        public Builder setFailoverUrl(@Nullable String str) {
            this.f2015 = str;
            return this;
        }

        public Builder setFullAdType(@Nullable String str) {
            this.f2033 = str;
            return this;
        }

        public Builder setImpressionTrackingUrls(@NonNull List<String> list) {
            Preconditions.checkNotNull(list);
            this.f2042 = list;
            return this;
        }

        public Builder setJsonBody(@Nullable JSONObject jSONObject) {
            this.f2027 = jSONObject;
            return this;
        }

        public Builder setNetworkType(@Nullable String str) {
            this.f2034 = str;
            return this;
        }

        public Builder setRefreshTimeMilliseconds(@Nullable Integer num) {
            this.f2024 = num;
            return this;
        }

        public Builder setRequestId(@Nullable String str) {
            this.f2020 = str;
            return this;
        }

        public Builder setResponseBody(@Nullable String str) {
            this.f2026 = str;
            return this;
        }

        public Builder setRewardedCurrencies(@Nullable String str) {
            this.f2037 = str;
            return this;
        }

        public Builder setRewardedDuration(@Nullable Integer num) {
            this.f2039 = num;
            return this;
        }

        public Builder setRewardedVideoCompletionUrl(@Nullable String str) {
            this.f2038 = str;
            return this;
        }

        public Builder setRewardedVideoCurrencyAmount(@Nullable String str) {
            this.f2036 = str;
            return this;
        }

        public Builder setRewardedVideoCurrencyName(@Nullable String str) {
            this.f2035 = str;
            return this;
        }

        public Builder setServerExtras(@Nullable Map<String, String> map) {
            if (map == null) {
                this.f2030 = new TreeMap();
            } else {
                this.f2030 = new TreeMap(map);
            }
            return this;
        }

        public Builder setShouldRewardOnClick(boolean z) {
            this.f2040 = z;
            return this;
        }
    }

    private AdResponse(@NonNull Builder builder) {
        this.f2003 = builder.f2031;
        this.f2004 = builder.f2032;
        this.f2005 = builder.f2033;
        this.f2006 = builder.f2034;
        this.f2007 = builder.f2035;
        this.f2008 = builder.f2036;
        this.f2009 = builder.f2037;
        this.f2010 = builder.f2038;
        this.f2011 = builder.f2039;
        this.f2012 = builder.f2040;
        this.f2013 = builder.f2041;
        this.f2014 = builder.f2042;
        this.f1986 = builder.f2015;
        this.f1987 = builder.f2016;
        this.f1988 = builder.f2017;
        this.f1989 = builder.f2018;
        this.f1990 = builder.f2019;
        this.f1991 = builder.f2020;
        this.f1992 = builder.f2021;
        this.f1993 = builder.f2022;
        this.f1994 = builder.f2023;
        this.f1995 = builder.f2024;
        this.f1996 = builder.f2025;
        this.f1997 = builder.f2026;
        this.f1998 = builder.f2027;
        this.f1999 = builder.f2028;
        this.f2000 = builder.f2029;
        this.f2001 = builder.f2030;
        this.f2002 = DateAndTime.now().getTime();
    }

    @NonNull
    public Integer getAdTimeoutMillis(int i) {
        return (this.f1994 == null || this.f1994.intValue() < 1000) ? Integer.valueOf(i) : this.f1994;
    }

    @Nullable
    public String getAdType() {
        return this.f2003;
    }

    @Nullable
    public String getAdUnitId() {
        return this.f2004;
    }

    @NonNull
    public List<String> getAfterLoadFailUrls() {
        return this.f1990;
    }

    @NonNull
    public List<String> getAfterLoadSuccessUrls() {
        return this.f1989;
    }

    @NonNull
    public List<String> getAfterLoadUrls() {
        return this.f1988;
    }

    @Nullable
    public String getBeforeLoadUrl() {
        return this.f1987;
    }

    @Nullable
    public MoPub.BrowserAgent getBrowserAgent() {
        return this.f2000;
    }

    @Nullable
    public String getClickTrackingUrl() {
        return this.f2013;
    }

    @Nullable
    public String getCustomEventClassName() {
        return this.f1999;
    }

    @Nullable
    public String getDspCreativeId() {
        return this.f1996;
    }

    @Nullable
    @Deprecated
    public String getFailoverUrl() {
        return this.f1986;
    }

    @Nullable
    public String getFullAdType() {
        return this.f2005;
    }

    @Nullable
    public Integer getHeight() {
        return this.f1993;
    }

    @NonNull
    public List<String> getImpressionTrackingUrls() {
        return this.f2014;
    }

    @Nullable
    public JSONObject getJsonBody() {
        return this.f1998;
    }

    @Nullable
    public String getNetworkType() {
        return this.f2006;
    }

    @Nullable
    public Integer getRefreshTimeMillis() {
        return this.f1995;
    }

    @Nullable
    public String getRequestId() {
        return this.f1991;
    }

    @Nullable
    public String getRewardedCurrencies() {
        return this.f2009;
    }

    @Nullable
    public Integer getRewardedDuration() {
        return this.f2011;
    }

    @Nullable
    public String getRewardedVideoCompletionUrl() {
        return this.f2010;
    }

    @Nullable
    public String getRewardedVideoCurrencyAmount() {
        return this.f2008;
    }

    @Nullable
    public String getRewardedVideoCurrencyName() {
        return this.f2007;
    }

    @NonNull
    public Map<String, String> getServerExtras() {
        return new TreeMap(this.f2001);
    }

    @Nullable
    public String getStringBody() {
        return this.f1997;
    }

    public long getTimestamp() {
        return this.f2002;
    }

    @Nullable
    public Integer getWidth() {
        return this.f1992;
    }

    public boolean hasJson() {
        return this.f1998 != null;
    }

    public boolean shouldRewardOnClick() {
        return this.f2012;
    }

    public Builder toBuilder() {
        return new Builder().setAdType(this.f2003).setNetworkType(this.f2006).setRewardedVideoCurrencyName(this.f2007).setRewardedVideoCurrencyAmount(this.f2008).setRewardedCurrencies(this.f2009).setRewardedVideoCompletionUrl(this.f2010).setRewardedDuration(this.f2011).setShouldRewardOnClick(this.f2012).setClickTrackingUrl(this.f2013).setImpressionTrackingUrls(this.f2014).setFailoverUrl(this.f1986).setBeforeLoadUrl(this.f1987).setAfterLoadUrls(this.f1988).setAfterLoadSuccessUrls(this.f1989).setAfterLoadFailUrls(this.f1990).setDimensions(this.f1992, this.f1993).setAdTimeoutDelayMilliseconds(this.f1994).setRefreshTimeMilliseconds(this.f1995).setDspCreativeId(this.f1996).setResponseBody(this.f1997).setJsonBody(this.f1998).setCustomEventClassName(this.f1999).setBrowserAgent(this.f2000).setServerExtras(this.f2001);
    }
}
