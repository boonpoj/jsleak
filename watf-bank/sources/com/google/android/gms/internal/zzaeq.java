package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
@zzzv
/* loaded from: classes.dex */
public final class zzaeq extends zzbfm {
    public static final Parcelable.Creator<zzaeq> CREATOR = new zzaer();
    public final String type;
    public final int zzcwd;

    public zzaeq(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    public zzaeq(String str, int i) {
        this.type = str;
        this.zzcwd = i;
    }

    public static zzaeq zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzaeq(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public static zzaeq zzbu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return zza(new JSONArray(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzaeq)) {
            zzaeq zzaeqVar = (zzaeq) obj;
            if (com.google.android.gms.common.internal.zzbg.equal(this.type, zzaeqVar.type) && com.google.android.gms.common.internal.zzbg.equal(Integer.valueOf(this.zzcwd), Integer.valueOf(zzaeqVar.zzcwd))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.type, Integer.valueOf(this.zzcwd)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.type, false);
        zzbfp.zzc(parcel, 3, this.zzcwd);
        zzbfp.zzai(parcel, zze);
    }
}
