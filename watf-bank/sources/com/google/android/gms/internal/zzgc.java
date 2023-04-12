package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzgc implements com.google.android.gms.ads.internal.gmsg.zzt<zzanh> {
    private /* synthetic */ zzgb zzawy;

    /* renamed from: com.google.android.gms.internal.zzgc$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 extends zzgc {
        AnonymousClass1() {
        }

        public String zzf(@Nullable String str, String str2) {
            return str2;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgc$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass2 extends zzgc {
        AnonymousClass2() {
        }

        public String zzf(@Nullable String str, String str2) {
            return str != null ? str : str2;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgc$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass3 extends zzgc {
        AnonymousClass3() {
        }

        @Nullable
        private String zzW(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String zzf(@Nullable String str, String str2) {
            String zzW = zzW(str);
            String zzW2 = zzW(str2);
            if (TextUtils.isEmpty(zzW)) {
                return zzW2;
            }
            if (TextUtils.isEmpty(zzW2)) {
                return zzW;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(zzW).length() + 1 + String.valueOf(zzW2).length());
            sb.append(zzW);
            sb.append(",");
            sb.append(zzW2);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgc(zzgb zzgbVar) {
        this.zzawy = zzgbVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        zzft zzftVar;
        zzftVar = this.zzawy.zzawt;
        zzftVar.zzf(map);
    }
}
