package com.WaTF.WaTFBank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes.dex */
public class DatabaseHelperFavoriteAccount extends SQLiteOpenHelper {
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    private static final String COL3 = "accountNo";
    private static final String DATABASE_NAME = "FavoriteAccount.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "favorite_accounts";

    public DatabaseHelperFavoriteAccount(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS favorite_accounts (ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, accountNo TEXT NOT NULL)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS favorite_accounts");
        onCreate(db);
    }

    public boolean addData(String name, String accountNo) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, accountNo);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        }
        return true;
    }

    public Cursor showAll() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM favorite_accounts", null);
        return data;
    }

    public void deleteAll() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM favorite_accounts");
    }
}
