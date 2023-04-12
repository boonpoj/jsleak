package com.WaTF.WaTFBank;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
/* loaded from: classes.dex */
public class Root extends AppCompatActivity {
    Button btnAboutme;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        this.btnAboutme = (Button) findViewById(R.id.btnAboutme);
        this.btnAboutme.setOnClickListener(new View.OnClickListener() { // from class: com.WaTF.WaTFBank.Root.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Root.this.ShowPopup();
            }
        });
    }

    public void ShowPopup() {
        Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.activity_about);
        myDialog.show();
    }
}
