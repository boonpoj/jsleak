package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class zzah {
    private final ComponentName mComponentName;
    private final String zzdrp;
    private final String zzgak;
    private final int zzgal;

    public zzah(ComponentName componentName, int i) {
        this.zzdrp = null;
        this.zzgak = null;
        this.mComponentName = (ComponentName) zzbq.checkNotNull(componentName);
        this.zzgal = 129;
    }

    public zzah(String str, String str2, int i) {
        this.zzdrp = zzbq.zzgm(str);
        this.zzgak = zzbq.zzgm(str2);
        this.mComponentName = null;
        this.zzgal = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzah) {
            zzah zzahVar = (zzah) obj;
            return zzbg.equal(this.zzdrp, zzahVar.zzdrp) && zzbg.equal(this.zzgak, zzahVar.zzgak) && zzbg.equal(this.mComponentName, zzahVar.mComponentName) && this.zzgal == zzahVar.zzgal;
        }
        return false;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final String getPackage() {
        return this.zzgak;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzdrp, this.zzgak, this.mComponentName, Integer.valueOf(this.zzgal)});
    }

    public final String toString() {
        String str = this.zzdrp;
        return str == null ? this.mComponentName.flattenToString() : str;
    }

    public final int zzalk() {
        return this.zzgal;
    }

    public final Intent zzall() {
        String str = this.zzdrp;
        return str != null ? new Intent(str).setPackage(this.zzgak) : new Intent().setComponent(this.mComponentName);
    }
}
