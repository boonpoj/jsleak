package com.WaTF.WaTFBank;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;
/* loaded from: classes.dex */
public class FingerprintHelper extends FingerprintManager.AuthenticationCallback {
    AlertDialog alert;
    private CancellationSignal cancellationSignal;
    private Context context;

    public FingerprintHelper(Context context) {
        this.context = context;
    }

    public void startAuth(FingerprintManager manager, FingerprintManager.CryptoObject cryptoObject) {
        this.cancellationSignal = new CancellationSignal();
        if (ActivityCompat.checkSelfPermission(this.context, "android.permission.USE_FINGERPRINT") != 0) {
            return;
        }
        manager.authenticate(cryptoObject, this.cancellationSignal, 0, this, null);
        alertText("Please scan your fingerprint");
    }

    public void stopListening() {
        CancellationSignal cancellationSignal = this.cancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
            this.cancellationSignal = null;
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);
        if (errorCode == 7) {
            this.alert.cancel();
            Toast.makeText(this.context, "Too many attempts. Please enter pin.", 0).show();
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        super.onAuthenticationHelp(helpCode, helpString);
        Context context = this.context;
        Toast.makeText(context, "Authentication help\n" + ((Object) helpString), 0).show();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        Intent intent = new Intent(this.context, Home.class);
        intent.addFlags(268468224);
        intent.putExtra("flag", true);
        this.context.startActivity(intent);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Toast.makeText(this.context, "Authentication failed.", 0).show();
    }

    public void alertText(String text) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this.context);
        dialog.setMessage(text);
        dialog.setTitle("Fingerprint");
        dialog.setIcon(R.drawable.ic_fingerprint_black_24dp);
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.WaTF.WaTFBank.FingerprintHelper.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int whichButton) {
            }
        });
        this.alert = dialog.create();
        this.alert.show();
    }
}
