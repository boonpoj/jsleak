package com.WaTF.WaTFBank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/* loaded from: classes.dex */
public class AddFavoriteAccount extends LogoutButton implements View.OnClickListener {
    Button btnAdd;
    EditText etAccountNo;
    EditText etName;
    DatabaseHelperFavoriteAccount mDatabase;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_favorite_account);
        Bundle bundle = getIntent().getExtras();
        boolean flag = bundle.getBoolean("flag");
        if (!flag) {
            startActivity(new Intent(this, Login.class));
        }
        this.etName = (EditText) findViewById(R.id.etName);
        this.etAccountNo = (EditText) findViewById(R.id.etAccountNo);
        this.btnAdd = (Button) findViewById(R.id.btnAdd);
        this.btnAdd.setOnClickListener(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent(this, TransferFavorite.class);
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
        String name = this.etName.getText().toString();
        String accountNo = this.etAccountNo.getText().toString();
        this.mDatabase = new DatabaseHelperFavoriteAccount(getApplicationContext());
        this.mDatabase.addData(name, accountNo);
        Toast.makeText(this, "Add account successfully", 0).show();
        Intent intent = new Intent(this, Home.class);
        intent.addFlags(67108864);
        intent.putExtra("flag", true);
        startActivity(intent);
    }
}
