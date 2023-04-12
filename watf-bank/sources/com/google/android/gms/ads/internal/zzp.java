package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzzv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
@zzzv
/* loaded from: classes.dex */
public final class zzp {
    private static String bundleToString(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            sb.append(obj == null ? "null" : obj instanceof Bundle ? bundleToString((Bundle) obj) : obj.toString());
        }
        return sb.toString();
    }

    public static Object[] zza(String str, zzjj zzjjVar, String str2, int i, zzjn zzjnVar) {
        HashSet hashSet = new HashSet(Arrays.asList(str.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (hashSet.contains("formatString")) {
            arrayList.add(null);
        }
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzjjVar.zzbdf));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(bundleToString(zzjjVar.extras));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzjjVar.zzbdg));
        }
        if (hashSet.contains("keywords")) {
            if (zzjjVar.zzbdh != null) {
                arrayList.add(zzjjVar.zzbdh.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzjjVar.zzbdi));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzjjVar.zzbdj));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzjjVar.zzbdk));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzjjVar.zzbdl);
        }
        if (hashSet.contains("location")) {
            if (zzjjVar.zzbdn != null) {
                arrayList.add(zzjjVar.zzbdn.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzjjVar.zzbdo);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(bundleToString(zzjjVar.zzbdp));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(bundleToString(zzjjVar.zzbdq));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (zzjjVar.zzbdr != null) {
                arrayList.add(zzjjVar.zzbdr.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzjjVar.zzbds);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzjjVar.zzbdt);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzjjVar.zzbdu));
        }
        return arrayList.toArray();
    }
}
