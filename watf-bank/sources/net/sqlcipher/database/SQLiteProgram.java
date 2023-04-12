package net.sqlcipher.database;

import android.util.Log;
/* loaded from: classes.dex */
public abstract class SQLiteProgram extends SQLiteClosable {
    private static final String TAG = "SQLiteProgram";
    boolean mClosed = false;
    private SQLiteCompiledSql mCompiledSql;
    @Deprecated
    protected SQLiteDatabase mDatabase;
    final String mSql;
    @Deprecated
    protected long nHandle;
    @Deprecated
    protected long nStatement;

    private final native void native_clear_bindings();

    protected final native void native_bind_blob(int i, byte[] bArr);

    protected final native void native_bind_double(int i, double d);

    protected final native void native_bind_long(int i, long j);

    protected final native void native_bind_null(int i);

    protected final native void native_bind_string(int i, String str);

    @Deprecated
    protected final native void native_compile(String str);

    @Deprecated
    protected final native void native_finalize();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteProgram(SQLiteDatabase db, String sql) {
        this.nHandle = 0L;
        this.nStatement = 0L;
        this.mDatabase = db;
        this.mSql = sql.trim();
        db.acquireReference();
        db.addSQLiteClosable(this);
        this.nHandle = db.mNativeHandle;
        String prefixSql = this.mSql.length() >= 6 ? this.mSql.substring(0, 6) : this.mSql;
        if (!prefixSql.equalsIgnoreCase("INSERT") && !prefixSql.equalsIgnoreCase("UPDATE") && !prefixSql.equalsIgnoreCase("REPLAC") && !prefixSql.equalsIgnoreCase("DELETE") && !prefixSql.equalsIgnoreCase("SELECT")) {
            this.mCompiledSql = new SQLiteCompiledSql(db, sql);
            this.nStatement = this.mCompiledSql.nStatement;
            return;
        }
        this.mCompiledSql = db.getCompiledStatementForSql(sql);
        SQLiteCompiledSql sQLiteCompiledSql = this.mCompiledSql;
        if (sQLiteCompiledSql == null) {
            this.mCompiledSql = new SQLiteCompiledSql(db, sql);
            this.mCompiledSql.acquire();
            db.addToCompiledQueries(sql, this.mCompiledSql);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v(TAG, "Created DbObj (id#" + this.mCompiledSql.nStatement + ") for sql: " + sql);
            }
        } else if (!sQLiteCompiledSql.acquire()) {
            long last = this.mCompiledSql.nStatement;
            this.mCompiledSql = new SQLiteCompiledSql(db, sql);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v(TAG, "** possible bug ** Created NEW DbObj (id#" + this.mCompiledSql.nStatement + ") because the previously created DbObj (id#" + last + ") was not released for sql:" + sql);
            }
        }
        this.nStatement = this.mCompiledSql.nStatement;
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
        this.mDatabase.removeSQLiteClosable(this);
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    protected void onAllReferencesReleasedFromContainer() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
    }

    private void releaseCompiledSqlIfNotInCache() {
        if (this.mCompiledSql == null) {
            return;
        }
        synchronized (this.mDatabase.mCompiledQueries) {
            if (!this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql)) {
                this.mCompiledSql.releaseSqlStatement();
                this.mCompiledSql = null;
                this.nStatement = 0L;
            } else {
                this.mCompiledSql.release();
            }
        }
    }

    public final long getUniqueId() {
        return this.nStatement;
    }

    String getSqlString() {
        return this.mSql;
    }

    @Deprecated
    protected void compile(String sql, boolean forceCompilation) {
    }

    public void bindNull(int index) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        acquireReference();
        try {
            native_bind_null(index);
        } finally {
            releaseReference();
        }
    }

    public void bindLong(int index, long value) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        acquireReference();
        try {
            native_bind_long(index, value);
        } finally {
            releaseReference();
        }
    }

    public void bindDouble(int index, double value) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        acquireReference();
        try {
            native_bind_double(index, value);
        } finally {
            releaseReference();
        }
    }

    public void bindString(int index, String value) {
        if (value == null) {
            throw new IllegalArgumentException("the bind value at index " + index + " is null");
        } else if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        } else {
            if (!this.mDatabase.isOpen()) {
                throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
            }
            acquireReference();
            try {
                native_bind_string(index, value);
            } finally {
                releaseReference();
            }
        }
    }

    public void bindBlob(int index, byte[] value) {
        if (value == null) {
            throw new IllegalArgumentException("the bind value at index " + index + " is null");
        } else if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        } else {
            if (!this.mDatabase.isOpen()) {
                throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
            }
            acquireReference();
            try {
                native_bind_blob(index, value);
            } finally {
                releaseReference();
            }
        }
    }

    public void clearBindings() {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        acquireReference();
        try {
            native_clear_bindings();
        } finally {
            releaseReference();
        }
    }

    public void close() {
        if (this.mClosed || !this.mDatabase.isOpen()) {
            return;
        }
        this.mDatabase.lock();
        try {
            releaseReference();
            this.mDatabase.unlock();
            this.mClosed = true;
        } catch (Throwable th) {
            this.mDatabase.unlock();
            throw th;
        }
    }
}
