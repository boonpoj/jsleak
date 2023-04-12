package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfhe;
/* loaded from: classes.dex */
public abstract class zzfen<MessageType extends zzfhe> implements zzfhk<MessageType> {
    private static final zzffm zzpfe = zzffm.zzcxb();

    @Override // com.google.android.gms.internal.zzfhk
    public final /* synthetic */ Object zzc(zzffb zzffbVar, zzffm zzffmVar) throws zzfge {
        zzfhe zzfheVar = (zzfhe) zze(zzffbVar, zzffmVar);
        if (zzfheVar == null || zzfheVar.isInitialized()) {
            return zzfheVar;
        }
        throw (!(zzfheVar instanceof zzfek) ? zzfheVar instanceof zzfem ? new zzfim((zzfem) zzfheVar) : new zzfim(zzfheVar) : new zzfim((zzfek) zzfheVar)).zzczt().zzi(zzfheVar);
    }
}
