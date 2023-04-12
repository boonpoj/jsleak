package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.ads.AdRequest;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzkg extends zzeu implements zzke {

    /* renamed from: com.google.android.gms.internal.zzkg$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] zzLe;
        static final /* synthetic */ int[] zzLf = new int[AdRequest.ErrorCode.values().length];

        static {
            try {
                zzLf[AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                zzLf[AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                zzLf[AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                zzLf[AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            zzLe = new int[AdRequest.Gender.values().length];
            try {
                zzLe[AdRequest.Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                zzLe[AdRequest.Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                zzLe[AdRequest.Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    @Override // com.google.android.gms.internal.zzke
    public final void onAdClicked() throws RemoteException {
        zzb(1, zzbe());
    }
}
