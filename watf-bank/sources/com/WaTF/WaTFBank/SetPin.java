package com.WaTF.WaTFBank;

import android.app.KeyguardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class SetPin extends AppCompatActivity implements View.OnClickListener {
    Button btnSetPin;
    Button btnSetting;
    EditText etPin;
    private FingerprintManager mFingerprintManager;
    private KeyguardManager mKeyguardManager;
    TextView tvSetFP;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pin);
        copyAssets();
        this.tvSetFP = (TextView) findViewById(R.id.tvSetFP);
        this.etPin = (EditText) findViewById(R.id.etPin);
        this.btnSetPin = (Button) findViewById(R.id.btnSetPin);
        this.btnSetPin.setOnClickListener(this);
        this.btnSetting = (Button) findViewById(R.id.btnSetting);
        this.btnSetting.setOnClickListener(this);
        this.mKeyguardManager = (KeyguardManager) getSystemService("keyguard");
        this.mFingerprintManager = (FingerprintManager) getSystemService("fingerprint");
        if (ActivityCompat.checkSelfPermission(this, "android.permission.USE_FINGERPRINT") != 0) {
            return;
        }
        if (this.mFingerprintManager.isHardwareDetected()) {
            if (!this.mKeyguardManager.isKeyguardSecure()) {
                Toast.makeText(this, "Please set pin", 0).show();
                return;
            } else if (!this.mFingerprintManager.hasEnrolledFingerprints()) {
                this.tvSetFP.setVisibility(0);
                this.btnSetting.setVisibility(0);
                return;
            } else {
                return;
            }
        }
        Toast.makeText(this, "No hardware", 0).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btnSetPin) {
            String pin = this.etPin.getText().toString();
            if (pin.length() < 4) {
                Toast.makeText(this, "error : Pin must be 4 digit", 0).show();
                return;
            }
            saveToSharePref("pin", md5(pin));
            Intent intent = new Intent(this, Home.class);
            intent.addFlags(268468224);
            intent.putExtra("flag", true);
            startActivity(intent);
        } else if (view == this.btnSetting) {
            startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
        }
    }

    private String md5(String in) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(in.getBytes());
            byte[] a = digest.digest();
            int len = a.length;
            StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++) {
                sb.append(Character.forDigit((a[i] & 240) >> 4, 16));
                sb.append(Character.forDigit(a[i] & 15, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void saveToSharePref(String name, String data) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("SharePref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(name, data);
        editor.commit();
    }

    private void copyAssets() {
        AssetManager assetManager = getAssets();
        try {
            assetManager.list("");
        } catch (IOException e) {
            Log.e("tag", "Failed to get asset file list.", e);
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            try {
                try {
                    in = assetManager.open("watf.jar");
                    File outFile = new File(getExternalFilesDir(null), "watf.jar");
                    out = new FileOutputStream(outFile);
                    copyFile(in, out);
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e2) {
                        }
                    }
                    out.close();
                } catch (Throwable th) {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                Log.e("tag", "Failed to copy asset file: watf.jar", e5);
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e6) {
                    }
                }
                if (out != null) {
                    out.close();
                }
            }
        } catch (IOException e7) {
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        while (true) {
            int read = in.read(buffer);
            if (read != -1) {
                out.write(buffer, 0, read);
            } else {
                return;
            }
        }
    }
}
