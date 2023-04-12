package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
@Deprecated
/* loaded from: classes.dex */
public class MediationAdRequest {
    private final Date zzhh;
    private final AdRequest.Gender zzhi;
    private final Set<String> zzhj;
    private final boolean zzhk;
    private final Location zzhl;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.zzhh = date;
        this.zzhi = gender;
        this.zzhj = set;
        this.zzhk = z;
        this.zzhl = location;
    }

    public Integer getAgeInYears() {
        if (this.zzhh != null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar.setTime(this.zzhh);
            Integer valueOf = Integer.valueOf(calendar2.get(1) - calendar.get(1));
            return (calendar2.get(2) < calendar.get(2) || (calendar2.get(2) == calendar.get(2) && calendar2.get(5) < calendar.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
        }
        return null;
    }

    public Date getBirthday() {
        return this.zzhh;
    }

    public AdRequest.Gender getGender() {
        return this.zzhi;
    }

    public Set<String> getKeywords() {
        return this.zzhj;
    }

    public Location getLocation() {
        return this.zzhl;
    }

    public boolean isTesting() {
        return this.zzhk;
    }
}
