package com.WaTF.WaTFBank;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TransactionHistory extends LogoutButton {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);
        Bundle bundle = getIntent().getExtras();
        boolean flag = bundle.getBoolean("flag");
        if (!flag) {
            startActivity(new Intent(this, Login.class));
        }
        String token = getFromSharePref("token");
        String accountNo = getFromSharePref("accountNo");
        AsyncTaskBackGround asyncTaskBackGround = new AsyncTaskBackGround();
        asyncTaskBackGround.execute(token, accountNo);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        intent.addFlags(67108864);
        intent.putExtra("flag", true);
        startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Intent intent = new Intent(this, CheckPin.class);
        intent.addFlags(268468224);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFromSharePref(String name) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("SharePref", 0);
        String data = pref.getString(name, null);
        return data;
    }

    /* loaded from: classes.dex */
    private class AsyncTaskBackGround extends AsyncTask<String, Void, Void> {
        String message;
        ProgressDialog progressDialog;
        String text;

        private AsyncTaskBackGround() {
            this.text = "";
            this.message = "";
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.progressDialog = ProgressDialog.show(TransactionHistory.this, "ProgressDialog", "Wait Login... ");
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
                Log.e("error", "Failed to create JSONObject", e);
            }
            OkHttpHelper httpHelper = new OkHttpHelper();
            OkHttpClient okHttpClient = httpHelper.getUnsafeOkHttpClient();
            try {
                this.text = httpHelper.post(TransactionHistory.this.getFromSharePref("ip") + TransactionHistory.this.getString(R.string.url_transferHistory), json, okHttpClient);
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
                Toast.makeText(TransactionHistory.this, "error : connect fail.", 0).show();
                return;
            }
            try {
                JSONObject jsonObject = new JSONObject(this.text);
                this.message = jsonObject.getString(AvidVideoPlaybackListenerImpl.MESSAGE);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.message.equals("Success")) {
                TransactionHistory.this.addToList(this.text);
            } else if (this.message.equals("")) {
                Toast.makeText(TransactionHistory.this, "error : connect fail.", 0).show();
            } else {
                TransactionHistory transactionHistory = TransactionHistory.this;
                Toast.makeText(transactionHistory, "error : " + this.message, 0).show();
            }
        }
    }

    public void addToList(String text) {
        JSONArray students = null;
        try {
            JSONObject jsonObj = new JSONObject(text);
            students = jsonObj.getJSONArray("transaction");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList<HashMap<String, String>> transaction = new ArrayList<>();
        for (int i = 0; i < students.length(); i++) {
            HashMap<String, String> item = new HashMap<>();
            try {
                JSONObject c = students.getJSONObject(i);
                String accountNo = c.getString("accountNo");
                String toAccountNo = c.getString("toAccountNo");
                String amount = c.getString("amount");
                String datetime = c.getString("datetime");
                item.put("account", accountNo);
                item.put("toAccount", toAccountNo);
                item.put("amount", "$ " + amount);
                item.put("datetime", datetime);
                transaction.add(item);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        SimpleAdapter sa = new SimpleAdapter(this, transaction, R.layout.activity_listview, new String[]{"account", "toAccount", "amount", "datetime"}, new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4});
        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter((ListAdapter) sa);
    }
}
