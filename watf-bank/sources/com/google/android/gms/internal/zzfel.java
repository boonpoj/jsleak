package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfek;
import com.google.android.gms.internal.zzfel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public abstract class zzfel<MessageType extends zzfek<MessageType, BuilderType>, BuilderType extends zzfel<MessageType, BuilderType>> implements zzfhf {
    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzffz.checkNotNull(iterable);
        if (!(iterable instanceof zzfgl)) {
            if (iterable instanceof zzfhl) {
                list.addAll((Collection) iterable);
                return;
            } else {
                zzb(iterable, list);
                return;
            }
        }
        List<?> zzcyl = ((zzfgl) iterable).zzcyl();
        zzfgl zzfglVar = (zzfgl) list;
        int size = list.size();
        for (Object obj : zzcyl) {
            if (obj == null) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Element at index ");
                sb.append(zzfglVar.size() - size);
                sb.append(" is null.");
                String sb2 = sb.toString();
                for (int size2 = zzfglVar.size() - 1; size2 >= size; size2--) {
                    zzfglVar.remove(size2);
                }
                throw new NullPointerException(sb2);
            } else if (!(obj instanceof zzfes)) {
                zzfglVar.add((String) obj);
            }
        }
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size = list.size();
        for (T t : iterable) {
            if (t == null) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Element at index ");
                sb.append(list.size() - size);
                sb.append(" is null.");
                String sb2 = sb.toString();
                for (int size2 = list.size() - 1; size2 >= size; size2--) {
                    list.remove(size2);
                }
                throw new NullPointerException(sb2);
            }
            list.add(t);
        }
    }

    protected abstract BuilderType zza(MessageType messagetype);

    @Override // com.google.android.gms.internal.zzfhf
    /* renamed from: zza */
    public abstract BuilderType zzb(zzffb zzffbVar, zzffm zzffmVar) throws IOException;

    @Override // 
    /* renamed from: zzcvh */
    public abstract BuilderType clone();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzfhf
    public final /* synthetic */ zzfhf zzd(zzfhe zzfheVar) {
        if (zzcxq().getClass().isInstance(zzfheVar)) {
            return zza((zzfek) zzfheVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
