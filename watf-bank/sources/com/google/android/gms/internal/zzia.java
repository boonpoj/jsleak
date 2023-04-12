package com.google.android.gms.internal;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzia {
    private final int zzbac;
    private final zzhq zzbae;
    private String zzbam;
    private String zzban;
    private final boolean zzbao = false;
    private final int zzbap;
    private final int zzbaq;

    public zzia(int i, int i2, int i3) {
        this.zzbac = i;
        if (i2 > 64 || i2 < 0) {
            this.zzbap = 64;
        } else {
            this.zzbap = i2;
        }
        if (i3 <= 0) {
            this.zzbaq = 1;
        } else {
            this.zzbaq = i3;
        }
        this.zzbae = new zzhz(this.zzbap);
    }

    private final boolean zza(String str, HashSet<String> hashSet) {
        boolean z;
        String[] split = str.split("\n");
        if (split.length == 0) {
            return true;
        }
        for (String str2 : split) {
            if (str2.indexOf("'") != -1) {
                StringBuilder sb = new StringBuilder(str2);
                int i = 1;
                boolean z2 = false;
                while (true) {
                    int i2 = i + 2;
                    if (i2 > sb.length()) {
                        break;
                    }
                    if (sb.charAt(i) == '\'') {
                        if (sb.charAt(i - 1) != ' ') {
                            int i3 = i + 1;
                            if ((sb.charAt(i3) == 's' || sb.charAt(i3) == 'S') && (i2 == sb.length() || sb.charAt(i2) == ' ')) {
                                sb.insert(i, ' ');
                                i = i2;
                                z2 = true;
                            }
                        }
                        sb.setCharAt(i, ' ');
                        z2 = true;
                    }
                    i++;
                }
                String sb2 = z2 ? sb.toString() : null;
                if (sb2 != null) {
                    this.zzban = sb2;
                    str2 = sb2;
                }
            }
            String[] zzb = zzhu.zzb(str2, true);
            if (zzb.length >= this.zzbaq) {
                for (int i4 = 0; i4 < zzb.length; i4++) {
                    String str3 = "";
                    int i5 = 0;
                    while (true) {
                        if (i5 >= this.zzbaq) {
                            z = true;
                            break;
                        }
                        int i6 = i4 + i5;
                        if (i6 >= zzb.length) {
                            z = false;
                            break;
                        }
                        if (i5 > 0) {
                            str3 = String.valueOf(str3).concat(" ");
                        }
                        String valueOf = String.valueOf(str3);
                        String valueOf2 = String.valueOf(zzb[i6]);
                        str3 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                        i5++;
                    }
                    if (!z) {
                        break;
                    }
                    hashSet.add(str3);
                    if (hashSet.size() >= this.zzbac) {
                        return false;
                    }
                }
                if (hashSet.size() >= this.zzbac) {
                    return false;
                }
            }
        }
        return true;
    }

    public final String zza(ArrayList<String> arrayList, ArrayList<zzhp> arrayList2) {
        Collections.sort(arrayList2, new zzib(this));
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < arrayList2.size() && zza(Normalizer.normalize(arrayList.get(arrayList2.get(i).zzhc()), Normalizer.Form.NFKC).toLowerCase(Locale.US), hashSet); i++) {
        }
        zzht zzhtVar = new zzht();
        this.zzbam = "";
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                zzhtVar.write(this.zzbae.zzy(it.next()));
            } catch (IOException e) {
                zzagf.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzhtVar.toString();
    }
}
