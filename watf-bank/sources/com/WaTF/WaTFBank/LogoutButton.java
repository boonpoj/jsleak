package com.WaTF.WaTFBank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.io.File;
/* loaded from: classes.dex */
public class LogoutButton extends AppCompatActivity {
    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btnLogout) {
            removeFromSharePref("token");
            removeFromSharePref("pin");
            removeFromSharePref("accountNo");
            clearCipher();
            clearDB();
            Toast.makeText(this, "Logout", 0).show();
            Intent intent = new Intent(this, Login.class);
            intent.addFlags(268468224);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void removeFromSharePref(String text) {
        SharedPreferences preferences = getSharedPreferences("SharePref", 0);
        preferences.edit().remove(text).commit();
    }

    private void clearCipher() {
        File databaseFile = getDatabasePath("credentials.db");
        databaseFile.mkdirs();
        databaseFile.delete();
    }

    private void clearDB() {
        DatabaseHelperFavoriteAccount database = new DatabaseHelperFavoriteAccount(this);
        database.deleteAll();
    }
}
