package com.WaTF.WaTFBank;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
/* loaded from: classes.dex */
public class FavoriteAccountProvider extends ContentProvider {
    private DatabaseHelperFavoriteAccount mDatabase;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mDatabase = new DatabaseHelperFavoriteAccount(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        DatabaseHelperFavoriteAccount databaseHelperFavoriteAccount = this.mDatabase;
        queryBuilder.setTables(DatabaseHelperFavoriteAccount.TABLE_NAME);
        return queryBuilder.query(this.mDatabase.getReadableDatabase(), projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase writableDatabase = this.mDatabase.getWritableDatabase();
        DatabaseHelperFavoriteAccount databaseHelperFavoriteAccount = this.mDatabase;
        long id = writableDatabase.insert(DatabaseHelperFavoriteAccount.TABLE_NAME, null, values);
        return ContentUris.withAppendedId(uri, id);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase writableDatabase = this.mDatabase.getWritableDatabase();
        DatabaseHelperFavoriteAccount databaseHelperFavoriteAccount = this.mDatabase;
        return writableDatabase.delete(DatabaseHelperFavoriteAccount.TABLE_NAME, selection, selectionArgs);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase writableDatabase = this.mDatabase.getWritableDatabase();
        DatabaseHelperFavoriteAccount databaseHelperFavoriteAccount = this.mDatabase;
        return writableDatabase.update(DatabaseHelperFavoriteAccount.TABLE_NAME, values, selection, selectionArgs);
    }
}
