package com.WaTF.WaTFBank;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
import java.io.IOException;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AccountSummary extends LogoutButton implements View.OnClickListener {
    TextView tvAccountNo;
    TextView tvBalance;
    TextView tvName;
    TextView tvTel;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_summary);
        Bundle bundle = getIntent().getExtras();
        boolean flag = bundle.getBoolean("flag");
        if (!flag) {
            startActivity(new Intent(this, Login.class));
        }
        this.tvName = (TextView) findViewById(R.id.tvName);
        this.tvAccountNo = (TextView) findViewById(R.id.tvAccountNo);
        this.tvTel = (TextView) findViewById(R.id.tvTel);
        this.tvBalance = (TextView) findViewById(R.id.tvBalance);
        String token = getFromSharePref("token");
        String accountNo = getFromSharePref("accountNo");
        AsyncTaskBackGround asyncTaskBackGround = new AsyncTaskBackGround();
        asyncTaskBackGround.execute(token, accountNo);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Intent intent = new Intent(this, CheckPin.class);
        intent.addFlags(268468224);
        startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this, Home.class);
        intent.addFlags(67108864);
        intent.putExtra("flag", true);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFromSharePref(String name) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("SharePref", 0);
        String data = pref.getString(name, null);
        return data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreen(String username, String tel, String balance, String accountNo) {
        this.tvName.setText(username);
        this.tvAccountNo.setText(accountNo);
        this.tvTel.setText(tel);
        TextView textView = this.tvBalance;
        textView.setText("$ " + balance);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        intent.addFlags(268468224);
        intent.putExtra("flag", true);
        startActivity(intent);
    }

    /* loaded from: classes.dex */
    private class AsyncTaskBackGround extends AsyncTask<String, Void, Void> {
        String accountNo;
        String balance;
        String message;
        ProgressDialog progressDialog;
        String tel;
        String text;
        String username;

        private AsyncTaskBackGround() {
            this.text = "";
            this.message = "";
            this.username = "";
            this.tel = "";
            this.balance = "";
            this.accountNo = "";
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.progressDialog = ProgressDialog.show(AccountSummary.this, "ProgressDialog", "Wait Login... ");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(String... params) {
            String json = "";
            try {
                JSONObject object = new JSONObject();
                object.put("token", params[0]);
                object.put("accountNo", params[1]);
                json = object.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            OkHttpHelper httpHelper = new OkHttpHelper();
            OkHttpClient okHttpClient = httpHelper.getUnsafeOkHttpClient();
            try {
                this.text = httpHelper.post(AccountSummary.this.getFromSharePref("ip") + AccountSummary.this.getString(R.string.url_accountSummary), json, okHttpClient);
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
                Toast.makeText(AccountSummary.this, "error : connect fail.", 0).show();
                return;
            }
            try {
                JSONObject jsonObject = new JSONObject(this.text);
                this.message = jsonObject.getString(AvidVideoPlaybackListenerImpl.MESSAGE);
                this.username = jsonObject.getString("username");
                this.tel = jsonObject.getString("tel");
                this.balance = jsonObject.getString("balance");
                this.accountNo = jsonObject.getString("accountNo");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.message.equals("Success")) {
                AccountSummary.this.setScreen(this.username, this.tel, this.balance, this.accountNo);
            } else if (this.message.equals("")) {
                Toast.makeText(AccountSummary.this, "error : connect fail.", 0).show();
            } else {
                AccountSummary accountSummary = AccountSummary.this;
                Toast.makeText(accountSummary, "error : " + this.message, 0).show();
            }
        }
    }
}
