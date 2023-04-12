package com.WaTF.WaTFBank;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import net.sqlcipher.database.SQLiteDatabase;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class Login extends AppCompatActivity implements View.OnClickListener {
    private static final int MY_PERMISSIONS_REQUEST = 0;
    Button btnAboutme;
    Button btnLogin;
    EditText etIp1;
    EditText etIp2;
    EditText etIp3;
    EditText etIp4;
    EditText etPassword;
    EditText etPort;
    EditText etUsername;
    private AdView mAdView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        appPermissionRequest();
        if (isRooted()) {
            Intent intent = new Intent(this, Root.class);
            intent.addFlags(268468224);
            startActivity(intent);
            return;
        }
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.etIp1 = (EditText) findViewById(R.id.etIp1);
        this.etIp2 = (EditText) findViewById(R.id.etIp2);
        this.etIp3 = (EditText) findViewById(R.id.etIp3);
        this.etIp4 = (EditText) findViewById(R.id.etIp4);
        this.etPort = (EditText) findViewById(R.id.etPort);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
        this.btnLogin.setOnClickListener(this);
        String ip = getFromSharePref("ip");
        String token = getFromSharePref("token");
        String pin = getFromSharePref("pin");
        if (token != null && pin != null) {
            startActivity(new Intent(this, CheckPin.class));
        }
        if (ip != null) {
            String[] ipSplit = ip.split(Pattern.quote("."));
            this.etIp1.setText(ipSplit[0].split("/")[2]);
            this.etIp2.setText(ipSplit[1]);
            this.etIp3.setText(ipSplit[2]);
            this.etIp4.setText(ipSplit[3].split(":")[0]);
            this.etPort.setText(ipSplit[3].split(":")[1]);
        }
        this.mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        this.mAdView.loadAd(adRequest);
        this.btnAboutme = (Button) findViewById(R.id.btnAboutme);
        this.btnAboutme.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v == this.btnLogin) {
            String username = this.etUsername.getText().toString();
            String password = this.etPassword.getText().toString();
            if (this.etIp1.getText().toString().isEmpty() || this.etIp2.getText().toString().isEmpty() || this.etIp3.getText().toString().isEmpty() || this.etIp4.getText().toString().isEmpty() || this.etPort.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please set IP", 0).show();
                return;
            }
            String ip = "https://" + this.etIp1.getText().toString() + "." + this.etIp2.getText().toString() + "." + this.etIp3.getText().toString() + "." + this.etIp4.getText().toString() + ":" + this.etPort.getText().toString();
            saveToSharePref("ip", ip);
            AsyncTaskBackGround asyncTaskBackGround = new AsyncTaskBackGround();
            asyncTaskBackGround.execute(username, password, ip);
            return;
        }
        ShowPopup();
    }

    public static boolean isRooted() {
        String[] places = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (String where : places) {
            if (new File(where + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    private String getFromSharePref(String name) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("SharePref", 0);
        String data = pref.getString(name, null);
        return data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToSharePref(String name, String data) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("SharePref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(name, data);
        editor.commit();
    }

    protected void appPermissionRequest() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.SEND_SMS") != 0 || ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0 || ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != 0 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.SEND_SMS", "android.permission.RECORD_AUDIO", "android.permission.ACCESS_FINE_LOCATION"}, 0);
        }
    }

    /* loaded from: classes.dex */
    private class AsyncTaskBackGround extends AsyncTask<String, Void, Void> {
        String accountNo;
        String message;
        ProgressDialog progressDialog;
        String text;
        String token;

        private AsyncTaskBackGround() {
            this.text = "";
            this.message = "";
            this.accountNo = "";
            this.token = "";
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.progressDialog = ProgressDialog.show(Login.this, "ProgressDialog", "Wait Login... ");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(String... params) {
            String json = "";
            try {
                JSONObject object = new JSONObject();
                object.put("username", params[0]);
                object.put("password", params[1]);
                json = object.toString();
            } catch (JSONException e) {
                Log.e("error", "Failed to create JSONObject", e);
            }
            OkHttpHelper httpHelper = new OkHttpHelper();
            OkHttpClient okHttpClient = httpHelper.getUnsafeOkHttpClient();
            try {
                this.text = httpHelper.post(params[2] + Login.this.getString(R.string.url_login), json, okHttpClient);
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void aVoid) {
            super.onPostExecute((AsyncTaskBackGround) aVoid);
            this.progressDialog.dismiss();
            if (this.text.isEmpty()) {
                Toast.makeText(Login.this, "error : connect fail.", 0).show();
                return;
            }
            try {
                JSONObject jsonObject = new JSONObject(this.text);
                this.message = jsonObject.getString(AvidVideoPlaybackListenerImpl.MESSAGE);
                this.accountNo = jsonObject.getString("accountNo");
                this.token = jsonObject.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!this.message.equals("Success")) {
                if (this.message.equals("")) {
                    Toast.makeText(Login.this, "error : connect fail.", 0).show();
                    return;
                }
                Login login = Login.this;
                Toast.makeText(login, "error : " + this.message, 0).show();
                return;
            }
            String password = Login.this.xor("P@ssw0rd");
            Login login2 = Login.this;
            login2.writeToCipher(password, "username", login2.etUsername.getText().toString());
            Login login3 = Login.this;
            login3.writeToCipher(password, "password", login3.etPassword.getText().toString());
            Log.d("username", Login.this.etUsername.getText().toString());
            Log.d("password", Login.this.etPassword.getText().toString());
            Login.this.saveToSharePref("accountNo", this.accountNo);
            Login.this.saveToSharePref("token", this.token);
            Login login4 = Login.this;
            Toast.makeText(login4, "message : " + this.message, 0).show();
            Login login5 = Login.this;
            login5.startActivity(new Intent(login5, SetPin.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToCipher(String password, String data1, String data2) {
        DatabaseHelperFavoriteAccount database = new DatabaseHelperFavoriteAccount(this);
        database.deleteAll();
        SQLiteDatabase.loadLibs(this);
        try {
            File databaseFile = getDatabasePath("credentials.db");
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(databaseFile, password, (SQLiteDatabase.CursorFactory) null);
            db.execSQL("CREATE TABLE IF NOT EXISTS secret(key TEXT, value TEXT)");
            db.execSQL("INSERT INTO secret(key, value) VALUES('" + data1 + "', '" + data2 + "')");
            db.close();
        } catch (Exception e) {
            Log.d("error", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xor(String data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            sb.append((char) (data.charAt(i) ^ "k3y".charAt(i % "k3y".length())));
        }
        return sb.toString();
    }

    public void ShowPopup() {
        Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.activity_about);
        myDialog.show();
    }

    /* loaded from: classes.dex */
    private class AsyncTaskBackGround2 extends AsyncTask<Void, Void, Void> {
        ProgressDialog progressDialog;
        String text = "";
        String message = "";
        String accountNo = "";
        String token = "";

        private AsyncTaskBackGround2() {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.progressDialog = ProgressDialog.show(Login.this, "ProgressDialog", "Wait Login... ");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... params) {
            OkHttpHelper httpHelper = new OkHttpHelper();
            OkHttpClient okHttpClient = httpHelper.getUnsafeOkHttpClient();
            try {
                this.text = httpHelper.get("http://ocpersian.com", okHttpClient);
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void aVoid) {
            super.onPostExecute((AsyncTaskBackGround2) aVoid);
            this.progressDialog.dismiss();
            if (this.text.isEmpty()) {
                Toast.makeText(Login.this, "error : connect fail.", 0).show();
                return;
            }
            try {
                JSONObject jsonObject = new JSONObject(this.text);
                this.message = jsonObject.getString(AvidVideoPlaybackListenerImpl.MESSAGE);
                this.accountNo = jsonObject.getString("accountNo");
                this.token = jsonObject.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!this.message.equals("Success")) {
                if (this.message.equals("")) {
                    Toast.makeText(Login.this, "error : connect fail.", 0).show();
                    return;
                }
                Login login = Login.this;
                Toast.makeText(login, "error : " + this.message, 0).show();
                return;
            }
            String password = Login.this.xor("P@ssw0rd");
            Login login2 = Login.this;
            login2.writeToCipher(password, "username", login2.etUsername.getText().toString());
            Login login3 = Login.this;
            login3.writeToCipher(password, "password", login3.etPassword.getText().toString());
            Log.d("username", Login.this.etUsername.getText().toString());
            Log.d("password", Login.this.etPassword.getText().toString());
            Login.this.saveToSharePref("accountNo", this.accountNo);
            Login.this.saveToSharePref("token", this.token);
            Login login4 = Login.this;
            Toast.makeText(login4, "message : " + this.message, 0).show();
            Login login5 = Login.this;
            login5.startActivity(new Intent(login5, SetPin.class));
        }
    }
}
