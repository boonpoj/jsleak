package com.WaTF.WaTFBank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import android.widget.Toast;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
/* loaded from: classes.dex */
public class TransferResult extends LogoutButton {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    String amount;
    String tel;
    String toAccount;
    TextView tvResult;
    String username;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_result);
        Bundle bundle = getIntent().getExtras();
        boolean flag = bundle.getBoolean("flag");
        if (!flag) {
            startActivity(new Intent(this, Login.class));
        }
        String message = bundle.getString(AvidVideoPlaybackListenerImpl.MESSAGE);
        this.tel = bundle.getString("tel");
        this.username = bundle.getString("username");
        this.toAccount = bundle.getString("toAccount");
        this.amount = bundle.getString("amount");
        this.tvResult = (TextView) findViewById(R.id.tvResult);
        this.tvResult.setText(message);
        sendSMSMessage();
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

    protected void sendSMSMessage() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.SEND_SMS") != 0) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.SEND_SMS")) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.SEND_SMS"}, 0);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.WaTF.WaTFBank.SEND_SMS");
        intent.putExtra("tel", this.tel);
        intent.putExtra("username", this.username);
        intent.putExtra("toAccount", this.toAccount);
        intent.putExtra("amount", this.amount);
        sendBroadcast(intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                sendSMSMessage();
            } else {
                Toast.makeText(getApplicationContext(), "SMS failed.", 1).show();
            }
        }
    }
}
