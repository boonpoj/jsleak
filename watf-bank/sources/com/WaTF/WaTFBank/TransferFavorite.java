package com.WaTF.WaTFBank;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TransferFavorite extends LogoutButton implements View.OnClickListener {
    Button btnAddFav;
    Button btnTransfer;
    EditText etAmount;
    private Spinner spFavAccount;
    HashMap<Integer, String> spinnerMap;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_favorite);
        Bundle bundle = getIntent().getExtras();
        boolean flag = bundle.getBoolean("flag");
        if (!flag) {
            startActivity(new Intent(this, Login.class));
        }
        this.etAmount = (EditText) findViewById(R.id.etAmount);
        this.btnTransfer = (Button) findViewById(R.id.btnTransfer);
        this.btnTransfer.setOnClickListener(this);
        this.btnAddFav = (Button) findViewById(R.id.btnAddFav);
        this.btnAddFav.setOnClickListener(this);
        this.spFavAccount = (Spinner) findViewById(R.id.spFavAccount);
        addItemsOnSpinner();
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btnTransfer) {
            this.spFavAccount.getSelectedItem();
            String toAccountNo = this.spinnerMap.get(Integer.valueOf(this.spFavAccount.getSelectedItemPosition()));
            String token = getFromSharePref("token");
            String accountNo = getFromSharePref("accountNo");
            String amount = this.etAmount.getText().toString();
            if (toAccountNo == null) {
                toAccountNo = "";
            }
            AsyncTaskBackGround asyncTaskBackGround = new AsyncTaskBackGround();
            asyncTaskBackGround.execute(token, accountNo, toAccountNo, amount);
        } else if (view == this.btnAddFav) {
            Intent intent = new Intent(this, AddFavoriteAccount.class);
            intent.putExtra("flag", true);
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFromSharePref(String name) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("SharePref", 0);
        String data = pref.getString(name, null);
        return data;
    }

    public void addItemsOnSpinner() {
        DatabaseHelperFavoriteAccount mDatabaseHelper = new DatabaseHelperFavoriteAccount(this);
        Cursor data = mDatabaseHelper.showAll();
        String[] spinnerArray = new String[data.getCount()];
        this.spinnerMap = new HashMap<>();
        data.moveToFirst();
        for (int i = 0; i < data.getCount(); i++) {
            String tmpName = data.getString(1).toString();
            String tmpAccountNo = data.getString(2).toString();
            this.spinnerMap.put(Integer.valueOf(i), tmpAccountNo);
            spinnerArray[i] = tmpName;
            data.moveToNext();
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, 17367048, spinnerArray);
        dataAdapter.setDropDownViewResource(17367049);
        this.spFavAccount.setAdapter((SpinnerAdapter) dataAdapter);
    }

    /* loaded from: classes.dex */
    private class AsyncTaskBackGround extends AsyncTask<String, Void, Void> {
        String amount;
        String message;
        ProgressDialog progressDialog;
        String tel;
        String text;
        String toAccount;
        String username;

        private AsyncTaskBackGround() {
            this.text = "";
            this.message = "";
            this.tel = "";
            this.toAccount = "";
            this.username = "";
            this.amount = "";
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.progressDialog = ProgressDialog.show(TransferFavorite.this, "ProgressDialog", "Wait Login... ");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(String... params) {
            String json = "";
            try {
                JSONObject object = new JSONObject();
                object.put("token", params[0]);
                object.put("accountNo", params[1]);
                object.put("toAccountNo", params[2]);
                object.put("amount", params[3]);
                json = object.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            OkHttpHelper httpHelper = new OkHttpHelper();
            OkHttpClient okHttpClient = httpHelper.getUnsafeOkHttpClient();
            try {
                this.text = httpHelper.post(TransferFavorite.this.getFromSharePref("ip") + TransferFavorite.this.getString(R.string.url_transfer), json, okHttpClient);
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
            try {
                JSONObject jsonObject = new JSONObject(this.text);
                this.message = jsonObject.getString(AvidVideoPlaybackListenerImpl.MESSAGE);
                this.tel = jsonObject.getString("tel");
                this.username = jsonObject.getString("username");
                this.toAccount = jsonObject.getString("toAccount");
                this.amount = jsonObject.getString("amount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.message.equals("Success")) {
                Intent intent = new Intent(TransferFavorite.this, TransferResult.class);
                intent.putExtra(AvidVideoPlaybackListenerImpl.MESSAGE, this.message);
                intent.putExtra("tel", this.tel);
                intent.putExtra("username", this.username);
                intent.putExtra("toAccount", this.toAccount);
                intent.putExtra("amount", this.amount);
                intent.putExtra("flag", true);
                TransferFavorite.this.startActivity(intent);
            } else if (this.message.equals("")) {
                Toast.makeText(TransferFavorite.this, "error : connect fail.", 0).show();
            } else {
                TransferFavorite transferFavorite = TransferFavorite.this;
                Toast.makeText(transferFavorite, "error : " + this.message, 0).show();
                if (this.message.equals("Invalid token")) {
                    TransferFavorite transferFavorite2 = TransferFavorite.this;
                    transferFavorite2.startActivity(new Intent(transferFavorite2, Login.class));
                }
            }
        }
    }
}
