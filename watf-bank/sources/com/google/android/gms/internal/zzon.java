package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzon extends zzqn implements zzou {
    private final Object mLock = new Object();
    private final zzog zzbua;
    private zzll zzbub;
    private View zzbuc;
    private zzos zzbuf;
    private final String zzbuk;
    private final SimpleArrayMap<String, zzoi> zzbul;
    private final SimpleArrayMap<String, String> zzbum;

    public zzon(String str, SimpleArrayMap<String, zzoi> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zzog zzogVar, zzll zzllVar, View view) {
        this.zzbuk = str;
        this.zzbul = simpleArrayMap;
        this.zzbum = simpleArrayMap2;
        this.zzbua = zzogVar;
        this.zzbub = zzllVar;
        this.zzbuc = view;
    }

    @Override // com.google.android.gms.internal.zzqm
    public final void destroy() {
        zzahn.zzdaw.post(new zzop(this));
        this.zzbub = null;
        this.zzbuc = null;
    }

    @Override // com.google.android.gms.internal.zzqm
    public final List<String> getAvailableAssetNames() {
        String[] strArr = new String[this.zzbul.size() + this.zzbum.size()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.zzbul.size()) {
            strArr[i3] = this.zzbul.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < this.zzbum.size()) {
            strArr[i3] = this.zzbum.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.zzqm, com.google.android.gms.internal.zzou
    public final String getCustomTemplateId() {
        return this.zzbuk;
    }

    @Override // com.google.android.gms.internal.zzqm
    public final zzll getVideoController() {
        return this.zzbub;
    }

    @Override // com.google.android.gms.internal.zzqm
    public final void performClick(String str) {
        synchronized (this.mLock) {
            if (this.zzbuf == null) {
                zzakb.e("Attempt to call performClick before ad initialized.");
            } else {
                this.zzbuf.zza(null, str, null, null, null);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public final void recordImpression() {
        synchronized (this.mLock) {
            if (this.zzbuf == null) {
                zzakb.e("Attempt to perform recordImpression before ad initialized.");
            } else {
                this.zzbuf.zza((View) null, (Map<String, WeakReference<View>>) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public final String zzap(String str) {
        return this.zzbum.get(str);
    }

    @Override // com.google.android.gms.internal.zzqm
    public final zzpq zzaq(String str) {
        return this.zzbul.get(str);
    }

    @Override // com.google.android.gms.internal.zzou
    public final void zzb(zzos zzosVar) {
        synchronized (this.mLock) {
            this.zzbuf = zzosVar;
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public final boolean zzf(IObjectWrapper iObjectWrapper) {
        if (this.zzbuf == null) {
            zzakb.e("Attempt to call renderVideoInMediaView before ad initialized.");
            return false;
        } else if (this.zzbuc == null) {
            return false;
        } else {
            zzoo zzooVar = new zzoo(this);
            this.zzbuf.zza((FrameLayout) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper), zzooVar);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public final IObjectWrapper zzjt() {
        return com.google.android.gms.dynamic.zzn.zzz(this.zzbuf);
    }

    @Override // com.google.android.gms.internal.zzou
    public final String zzju() {
        return "3";
    }

    @Override // com.google.android.gms.internal.zzou
    public final zzog zzjv() {
        return this.zzbua;
    }

    @Override // com.google.android.gms.internal.zzou
    public final View zzjw() {
        return this.zzbuc;
    }

    @Override // com.google.android.gms.internal.zzqm
    public final IObjectWrapper zzka() {
        return com.google.android.gms.dynamic.zzn.zzz(this.zzbuf.getContext().getApplicationContext());
    }
}
