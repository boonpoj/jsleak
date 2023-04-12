package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzhr {
    private final int zzbac;
    private final zzhq zzbae = new zzhv();
    private final int zzbab = 6;
    private final int zzbad = 0;

    public zzhr(int i) {
        this.zzbac = i;
    }

    private final String zzz(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzht zzhtVar = new zzht();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbac, new zzhs(this));
        for (String str2 : split) {
            String[] zzb = zzhu.zzb(str2, false);
            if (zzb.length != 0) {
                zzhx.zza(zzb, this.zzbac, this.zzbab, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzhtVar.write(this.zzbae.zzy(((zzhy) it.next()).zzbai));
            } catch (IOException e) {
                zzagf.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzhtVar.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            String str = arrayList2.get(i);
            i++;
            stringBuffer.append(str.toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        return zzz(stringBuffer.toString());
    }
}
