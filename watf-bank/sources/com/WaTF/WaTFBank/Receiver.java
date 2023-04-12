package com.WaTF.WaTFBank;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;
/* loaded from: classes.dex */
public class Receiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String tel = intent.getExtras().getString("tel");
        String username = intent.getExtras().getString("username");
        String toAccount = intent.getExtras().getString("toAccount");
        String amount = intent.getExtras().getString("amount");
        String message = "Transfer deposit to a/c " + toAccount + " from " + username + " amount $ " + amount + ".";
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(tel, null, message, null, null);
        Toast.makeText(context, "Send sms successful.", 0).show();
    }
}
