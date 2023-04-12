package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.os.IInterface;
import android.os.RemoteException;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.widget.EditText;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzqw extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzqw$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 implements DialogInterface.OnCancelListener {
        final /* synthetic */ JsResult zzZH;

        AnonymousClass1(JsResult jsResult) {
            this.zzZH = jsResult;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.zzZH.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqw$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass2 implements DialogInterface.OnClickListener {
        final /* synthetic */ JsResult zzZH;

        AnonymousClass2(JsResult jsResult) {
            this.zzZH = jsResult;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzZH.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqw$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass3 implements DialogInterface.OnClickListener {
        final /* synthetic */ JsResult zzZH;

        AnonymousClass3(JsResult jsResult) {
            this.zzZH = jsResult;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzZH.confirm();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqw$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass4 implements DialogInterface.OnCancelListener {
        final /* synthetic */ JsPromptResult zzZI;

        AnonymousClass4(JsPromptResult jsPromptResult) {
            this.zzZI = jsPromptResult;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.zzZI.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqw$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass5 implements DialogInterface.OnClickListener {
        final /* synthetic */ JsPromptResult zzZI;

        AnonymousClass5(JsPromptResult jsPromptResult) {
            this.zzZI = jsPromptResult;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzZI.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqw$6  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass6 implements DialogInterface.OnClickListener {
        final /* synthetic */ JsPromptResult zzZI;
        final /* synthetic */ EditText zzZJ;

        AnonymousClass6(JsPromptResult jsPromptResult, EditText editText) {
            this.zzZI = jsPromptResult;
            this.zzZJ = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzZI.confirm(this.zzZJ.getText().toString());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqw$7  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] zzZK = new int[ConsoleMessage.MessageLevel.values().length];

        static {
            try {
                zzZK[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                zzZK[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                zzZK[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                zzZK[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                zzZK[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    void zzb(zzqm zzqmVar, String str) throws RemoteException;
}
