package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.IInterface;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzqt extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzqt$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zzhx {
        AnonymousClass1() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            if (map != null) {
                String str = map.get("height");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (zzqt.zza(zzqt.this)) {
                        if (zzqt.zzb(zzqt.this) != parseInt) {
                            zzqt.zza(zzqt.this, parseInt);
                            zzqt.this.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzpe.zzc("Exception occurred while getting webview content height", e);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqt$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zzqt.zzc(zzqt.this);
        }
    }

    @zzmb
    /* loaded from: assets/classes2.dex */
    public static class zza extends MutableContextWrapper {
        private Activity zzXO;
        private Context zzZv;
        private Context zzvZ;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return this.zzZv.getSystemService(str);
        }

        @Override // android.content.MutableContextWrapper
        public void setBaseContext(Context context) {
            this.zzvZ = context.getApplicationContext();
            this.zzXO = context instanceof Activity ? (Activity) context : null;
            this.zzZv = context;
            super.setBaseContext(this.zzvZ);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public void startActivity(Intent intent) {
            if (this.zzXO != null) {
                this.zzXO.startActivity(intent);
                return;
            }
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.zzvZ.startActivity(intent);
        }

        public Activity zzkR() {
            return this.zzXO;
        }

        public Context zzkS() {
            return this.zzZv;
        }
    }

    void zza(zzqi zzqiVar) throws RemoteException;
}
