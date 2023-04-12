package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzxe;
/* loaded from: classes.dex */
public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzxe zzalo;

    private final void zzbf() {
        zzxe zzxeVar = this.zzalo;
        if (zzxeVar != null) {
            try {
                zzxeVar.zzbf();
            } catch (RemoteException e) {
                zzakb.zzc("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzalo.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzakb.zzc("Could not forward onActivityResult to ad overlay:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzalo != null) {
                z = this.zzalo.zzmu();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzalo.zzk(zzn.zzz(configuration));
        } catch (RemoteException e) {
            zzakb.zzc("Failed to wrap configuration.", e);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzalo = zzkb.zzib().zzb(this);
        zzxe zzxeVar = this.zzalo;
        if (zzxeVar == null) {
            zzakb.zzcu("Could not create ad overlay.");
        } else {
            try {
                zzxeVar.onCreate(bundle);
                return;
            } catch (RemoteException e) {
                zzakb.zzc("Could not forward onCreate to ad overlay:", e);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            if (this.zzalo != null) {
                this.zzalo.onDestroy();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            if (this.zzalo != null) {
                this.zzalo.onPause();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        try {
            if (this.zzalo != null) {
                this.zzalo.onRestart();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (this.zzalo != null) {
                this.zzalo.onResume();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzalo != null) {
                this.zzalo.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzakb.zzc("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            if (this.zzalo != null) {
                this.zzalo.onStart();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            if (this.zzalo != null) {
                this.zzalo.onStop();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        zzbf();
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        zzbf();
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzbf();
    }
}
