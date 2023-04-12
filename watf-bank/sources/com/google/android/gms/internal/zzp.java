package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzp {
    public final List<zzl> allHeaders;
    public final byte[] data;
    public final int statusCode;
    public final Map<String, String> zzac;
    public final boolean zzad;
    private long zzae;

    private zzp(int i, byte[] bArr, Map<String, String> map, List<zzl> list, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.zzac = map;
        this.allHeaders = list == null ? null : Collections.unmodifiableList(list);
        this.zzad = z;
        this.zzae = j;
    }

    @Deprecated
    public zzp(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, zza(map), z, j);
    }

    public zzp(int i, byte[] bArr, boolean z, long j, List<zzl> list) {
        this(i, bArr, zza(list), list, z, j);
    }

    @Deprecated
    public zzp(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private static List<zzl> zza(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new zzl(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private static Map<String, String> zza(List<zzl> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (zzl zzlVar : list) {
            treeMap.put(zzlVar.getName(), zzlVar.getValue());
        }
        return treeMap;
    }
}
