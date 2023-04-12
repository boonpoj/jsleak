package com.WaTF.WaTFBank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/* loaded from: classes.dex */
public class Home extends LogoutButton implements View.OnClickListener {
    Button btnAccountSummary;
    Button btnTransactionHistory;
    Button btnTransfer;
    Button btnTransferFavorite;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle bundle = getIntent().getExtras();
        boolean flag = bundle.getBoolean("flag");
        if (!flag) {
            startActivity(new Intent(this, Login.class));
        }
        this.btnAccountSummary = (Button) findViewById(R.id.btnAccountSummary);
        this.btnAccountSummary.setOnClickListener(this);
        this.btnTransferFavorite = (Button) findViewById(R.id.btnTransferFavorite);
        this.btnTransferFavorite.setOnClickListener(this);
        this.btnTransfer = (Button) findViewById(R.id.btnTransfer);
        this.btnTransfer.setOnClickListener(this);
        this.btnTransactionHistory = (Button) findViewById(R.id.btnTransactionHistory);
        this.btnTransactionHistory.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btnAccountSummary) {
            Intent intent = new Intent(this, AccountSummary.class);
            intent.putExtra("flag", true);
            startActivity(intent);
        } else if (view == this.btnTransferFavorite) {
            Intent intent2 = new Intent(this, TransferFavorite.class);
            intent2.putExtra("flag", true);
            startActivity(intent2);
        } else if (view == this.btnTransfer) {
            Intent intent3 = new Intent(this, Transfer.class);
            intent3.putExtra("flag", true);
            startActivity(intent3);
        } else if (view == this.btnTransactionHistory) {
            Intent intent4 = new Intent(this, TransactionHistory.class);
            intent4.putExtra("flag", true);
            startActivity(intent4);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Intent intent = new Intent(this, CheckPin.class);
        intent.addFlags(268468224);
        startActivity(intent);
    }
}
