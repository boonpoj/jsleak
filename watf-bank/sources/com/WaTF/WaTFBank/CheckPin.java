package com.WaTF.WaTFBank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class CheckPin extends LogoutButton implements View.OnClickListener {
    Button btnSetPin;
    EditText etPin;
    private FingerprintManager.CryptoObject mCryptoObject;
    private FingerprintHelper mFingerprintHelper;
    private FingerprintManager mFingerprintManager;
    TextView tvFingerPrint;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_pin);
        this.etPin = (EditText) findViewById(R.id.etPin);
        this.tvFingerPrint = (TextView) findViewById(R.id.tvFingerPrint);
        this.btnSetPin = (Button) findViewById(R.id.btnSetPin);
        this.btnSetPin.setOnClickListener(this);
        this.mFingerprintManager = (FingerprintManager) getSystemService("fingerprint");
        if (this.mFingerprintManager.isHardwareDetected() && this.mFingerprintManager.hasEnrolledFingerprints()) {
            this.mFingerprintHelper = new FingerprintHelper(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String pinEnter = this.etPin.getText().toString();
        if (checkPin(md5(pinEnter))) {
            watfText();
            Intent intent = new Intent(this, Home.class);
            intent.addFlags(268468224);
            intent.putExtra("flag", true);
            startActivity(intent);
            return;
        }
        Toast.makeText(this, "Wrong Pin, Please Enter Pin Again.", 0).show();
    }

    public boolean checkPin(String pinEnter) {
        String pin = getFromSharePref("pin");
        return pin.equals(pinEnter);
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

    private String getFromSharePref(String name) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("SharePref", 0);
        String data = pref.getString(name, null);
        return data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        FingerprintHelper fingerprintHelper = this.mFingerprintHelper;
        if (fingerprintHelper != null) {
            fingerprintHelper.startAuth(this.mFingerprintManager, this.mCryptoObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        FingerprintHelper fingerprintHelper = this.mFingerprintHelper;
        if (fingerprintHelper != null) {
            fingerprintHelper.stopListening();
        }
    }

    private void watfText() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    String dexPath = getExternalFilesDir(null) + "/watf.jar";
                    PathClassLoader classLoader2 = new PathClassLoader(dexPath, getClassLoader());
                    try {
                        Class<?> c = classLoader2.loadClass("watf");
                        Object o = c.newInstance();
                        Method m = c.getMethod("welcome", new Class[0]);
                        Object res = m.invoke(o, new Object[0]);
                        Toast.makeText(this, res.toString(), 0).show();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
                return;
            }
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        }
    }
}
