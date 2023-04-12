package com.google.android.gms.internal;

import android.support.v4.view.PointerIconCompat;
import com.google.android.gms.internal.zzffu;
import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zziu {

    /* JADX WARN: Classes with same name are omitted:
      assets/classes2.dex
     */
    /* loaded from: classes.dex */
    public static final class zza extends zzffu<zza, C0046zza> implements zzfhg {
        private static final zza zzbbj;
        private static volatile zzfhk<zza> zzbbk;

        /* renamed from: com.google.android.gms.internal.zziu$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0046zza extends zzffu.zza<zza, C0046zza> implements zzfhg {
            private C0046zza() {
                super(zza.zzbbj);
            }

            /* synthetic */ C0046zza(zziv zzivVar) {
                this();
            }
        }

        /* loaded from: classes.dex */
        public enum zzb implements zzfga {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(PointerIconCompat.TYPE_CONTEXT_MENU),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(PointerIconCompat.TYPE_HAND),
            REQUEST_FAILED_TO_BUILD_URL(PointerIconCompat.TYPE_HELP),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(PointerIconCompat.TYPE_WAIT),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005);
            
            private static final zzfgb<zzb> zzbcl = new zziw();
            private final int value;

            zzb(int i) {
                this.value = i;
            }

            @Override // com.google.android.gms.internal.zzfga
            public final int zzhq() {
                return this.value;
            }
        }

        static {
            zza zzaVar = new zza();
            zzbbj = zzaVar;
            zzaVar.zza(zzffu.zzg.zzphh, (Object) null, (Object) null);
            zzaVar.zzpgr.zzbiy();
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.android.gms.internal.zzffu
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zziv.zzbbi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return zzbbj;
                case 3:
                    return null;
                case 4:
                    return new C0046zza(null);
                case 5:
                    return this;
                case 6:
                    zzffb zzffbVar = (zzffb) obj;
                    if (((zzffm) obj2) != null) {
                        boolean z = false;
                        while (!z) {
                            try {
                                try {
                                    int zzcvt = zzffbVar.zzcvt();
                                    if (zzcvt == 0 || !zza(zzcvt, zzffbVar)) {
                                        z = true;
                                    }
                                } catch (zzfge e) {
                                    throw new RuntimeException(e.zzi(this));
                                }
                            } catch (IOException e2) {
                                throw new RuntimeException(new zzfge(e2.getMessage()).zzi(this));
                            }
                        }
                        break;
                    } else {
                        throw new NullPointerException();
                    }
                case 7:
                    break;
                case 8:
                    if (zzbbk == null) {
                        synchronized (zza.class) {
                            if (zzbbk == null) {
                                zzbbk = new zzffu.zzb(zzbbj);
                            }
                        }
                    }
                    return zzbbk;
                case 9:
                    return (byte) 1;
                case 10:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzbbj;
        }

        @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
        public final void zza(zzffg zzffgVar) throws IOException {
            this.zzpgr.zza(zzffgVar);
        }

        @Override // com.google.android.gms.internal.zzffu, com.google.android.gms.internal.zzfhe
        public final int zzho() {
            int i = this.zzpgs;
            if (i != -1) {
                return i;
            }
            int zzho = this.zzpgr.zzho() + 0;
            this.zzpgs = zzho;
            return zzho;
        }
    }
}
