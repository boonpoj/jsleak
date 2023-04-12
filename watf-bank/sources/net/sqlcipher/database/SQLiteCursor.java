package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.SQLException;
/* loaded from: classes.dex */
public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "Cursor";
    private String[] mColumns;
    private SQLiteDatabase mDatabase;
    private SQLiteCursorDriver mDriver;
    private String mEditTable;
    protected MainThreadNotificationHandler mNotificationHandler;
    private SQLiteQuery mQuery;
    private int mCount = -1;
    private int mMaxRead = Integer.MAX_VALUE;
    private int mInitialRead = Integer.MAX_VALUE;
    private int mCursorState = 0;
    private ReentrantLock mLock = null;
    private boolean mPendingData = false;
    private Throwable mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
    private Map<String, Integer> mColumnNameMap = null;

    public void setLoadStyle(int initialRead, int maxRead) {
        this.mMaxRead = maxRead;
        this.mInitialRead = initialRead;
        this.mLock = new ReentrantLock(true);
    }

    private void queryThreadLock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.lock();
        }
    }

    private void queryThreadUnlock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class QueryThread implements Runnable {
        private final int mThreadState;

        QueryThread(int version) {
            this.mThreadState = version;
        }

        private void sendMessage() {
            if (SQLiteCursor.this.mNotificationHandler == null) {
                SQLiteCursor.this.mPendingData = true;
                return;
            }
            SQLiteCursor.this.mNotificationHandler.sendEmptyMessage(1);
            SQLiteCursor.this.mPendingData = false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
            r5.this$0.mCount = r1;
            sendMessage();
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                net.sqlcipher.CursorWindow r0 = net.sqlcipher.database.SQLiteCursor.access$100(r0)
                int r1 = android.os.Process.myTid()
                r2 = 10
                android.os.Process.setThreadPriority(r1, r2)
            Lf:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                r1.lock()
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                int r1 = net.sqlcipher.database.SQLiteCursor.access$300(r1)
                int r2 = r5.mThreadState
                if (r1 == r2) goto L2c
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                r1.unlock()
                goto L8e
            L2c:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                net.sqlcipher.database.SQLiteQuery r1 = net.sqlcipher.database.SQLiteCursor.access$600(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                int r2 = net.sqlcipher.database.SQLiteCursor.access$400(r2)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                net.sqlcipher.database.SQLiteCursor r3 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                int r3 = net.sqlcipher.database.SQLiteCursor.access$500(r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                int r1 = r1.fillWindow(r0, r2, r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                if (r1 == 0) goto L6f
                r2 = -1
                if (r1 != r2) goto L67
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                net.sqlcipher.database.SQLiteCursor r3 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                int r3 = net.sqlcipher.database.SQLiteCursor.access$500(r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                net.sqlcipher.database.SQLiteCursor r4 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                int r4 = net.sqlcipher.database.SQLiteCursor.access$400(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                int r3 = r3 + r4
                net.sqlcipher.database.SQLiteCursor.access$502(r2, r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                r5.sendMessage()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                r1.unlock()
                goto Lf
            L67:
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                net.sqlcipher.database.SQLiteCursor.access$502(r2, r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
                r5.sendMessage()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L84
            L6f:
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r2 = net.sqlcipher.database.SQLiteCursor.access$200(r2)
                r2.unlock()
                goto L8e
            L79:
                r1 = move-exception
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r2 = net.sqlcipher.database.SQLiteCursor.access$200(r2)
                r2.unlock()
                throw r1
            L84:
                r1 = move-exception
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r2 = net.sqlcipher.database.SQLiteCursor.access$200(r2)
                r2.unlock()
            L8e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteCursor.QueryThread.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class MainThreadNotificationHandler extends Handler {
        private final WeakReference<SQLiteCursor> wrappedCursor;

        MainThreadNotificationHandler(SQLiteCursor cursor) {
            this.wrappedCursor = new WeakReference<>(cursor);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SQLiteCursor cursor = this.wrappedCursor.get();
            if (cursor != null) {
                cursor.notifyDataSetChange();
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
        if ((Integer.MAX_VALUE != this.mMaxRead || Integer.MAX_VALUE != this.mInitialRead) && this.mNotificationHandler == null) {
            queryThreadLock();
            try {
                this.mNotificationHandler = new MainThreadNotificationHandler(this);
                if (this.mPendingData) {
                    notifyDataSetChange();
                    this.mPendingData = false;
                }
            } finally {
                queryThreadUnlock();
            }
        }
    }

    public SQLiteCursor(SQLiteDatabase db, SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
        this.mDatabase = db;
        this.mDriver = driver;
        this.mEditTable = editTable;
        this.mQuery = query;
        try {
            db.lock();
            int columnCount = this.mQuery.columnCountLocked();
            this.mColumns = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                String columnName = this.mQuery.columnNameLocked(i);
                this.mColumns[i] = columnName;
                if ("_id".equals(columnName)) {
                    this.mRowIdColumnIndex = i;
                }
            }
        } finally {
            db.unlock();
        }
    }

    public SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int oldPosition, int newPosition) {
        if (this.mWindow == null || newPosition < this.mWindow.getStartPosition() || newPosition >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            fillWindow(newPosition);
            return true;
        }
        return true;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        if (this.mCount == -1) {
            fillWindow(0);
        }
        return this.mCount;
    }

    private void fillWindow(int startPos) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow.setStartPosition(startPos);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCount == -1) {
            this.mCount = this.mInitialRead + startPos;
            Thread t = new Thread(new QueryThread(this.mCursorState), "query thread");
            t.start();
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getColumnIndex(String columnName) {
        if (this.mColumnNameMap == null) {
            String[] columns = this.mColumns;
            int columnCount = columns.length;
            HashMap<String, Integer> map = new HashMap<>(columnCount, 1.0f);
            for (int i = 0; i < columnCount; i++) {
                map.put(columns[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = map;
        }
        int periodIndex = columnName.lastIndexOf(46);
        if (periodIndex != -1) {
            Exception e = new Exception();
            Log.e(TAG, "requesting column name with table name -- " + columnName, e);
            columnName = columnName.substring(periodIndex + 1);
        }
        Integer i2 = this.mColumnNameMap.get(columnName);
        if (i2 == null) {
            return -1;
        }
        return i2.intValue();
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean deleteRow() {
        boolean success;
        checkPosition();
        if (this.mRowIdColumnIndex == -1 || this.mCurrentRowID == null) {
            Log.e(TAG, "Could not delete row because either the row ID column is not available or ithas not been read.");
            return false;
        }
        this.mDatabase.lock();
        try {
            this.mDatabase.delete(this.mEditTable, this.mColumns[this.mRowIdColumnIndex] + "=?", new String[]{this.mCurrentRowID.toString()});
            success = true;
        } catch (SQLException e) {
            success = false;
        } catch (Throwable th) {
            th = th;
            this.mDatabase.unlock();
            throw th;
        }
        try {
            int pos = this.mPos;
            requery();
            moveToPosition(pos);
            this.mDatabase.unlock();
            if (success) {
                onChange(true);
                return true;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            this.mDatabase.unlock();
            throw th;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean supportsUpdates() {
        return !TextUtils.isEmpty(this.mEditTable);
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> additionalValues) {
        int i = 0;
        if (!supportsUpdates()) {
            Log.e(TAG, "commitUpdates not supported on this cursor, did you include the _id column?");
            return false;
        }
        synchronized (this.mUpdatedRows) {
            if (additionalValues != null) {
                this.mUpdatedRows.putAll(additionalValues);
            }
            if (this.mUpdatedRows.size() == 0) {
                return true;
            }
            this.mDatabase.beginTransaction();
            StringBuilder sql = new StringBuilder(128);
            for (Map.Entry<Long, Map<String, Object>> rowEntry : this.mUpdatedRows.entrySet()) {
                Map<String, Object> values = rowEntry.getValue();
                Long rowIdObj = rowEntry.getKey();
                if (rowIdObj == null || values == null) {
                    throw new IllegalStateException("null rowId or values found! rowId = " + rowIdObj + ", values = " + values);
                } else if (values.size() != 0) {
                    long rowId = rowIdObj.longValue();
                    Iterator<Map.Entry<String, Object>> valuesIter = values.entrySet().iterator();
                    sql.setLength(i);
                    sql.append("UPDATE " + this.mEditTable + " SET ");
                    Object[] bindings = new Object[values.size()];
                    int i2 = i;
                    while (valuesIter.hasNext()) {
                        Map.Entry<String, Object> entry = valuesIter.next();
                        sql.append(entry.getKey());
                        sql.append("=?");
                        bindings[i2] = entry.getValue();
                        if (valuesIter.hasNext()) {
                            sql.append(", ");
                        }
                        i2++;
                    }
                    sql.append(" WHERE " + this.mColumns[this.mRowIdColumnIndex] + '=' + rowId);
                    sql.append(';');
                    this.mDatabase.execSQL(sql.toString(), bindings);
                    this.mDatabase.rowUpdated(this.mEditTable, rowId);
                    i = 0;
                }
            }
            this.mDatabase.setTransactionSuccessful();
            this.mDatabase.endTransaction();
            this.mUpdatedRows.clear();
            onChange(true);
            return true;
        }
    }

    private void deactivateCommon() {
        this.mCursorState = 0;
        if (this.mWindow != null) {
            this.mWindow.close();
            this.mWindow = null;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        deactivateCommon();
        this.mDriver.cursorDeactivated();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        deactivateCommon();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        this.mDatabase.lock();
        try {
            if (this.mWindow != null) {
                this.mWindow.clear();
            }
            this.mPos = -1;
            this.mDriver.cursorRequeried(this);
            this.mCount = -1;
            this.mCursorState++;
            queryThreadLock();
            this.mQuery.requery();
            queryThreadUnlock();
            this.mDatabase.unlock();
            boolean result = super.requery();
            return result;
        } catch (Throwable th) {
            this.mDatabase.unlock();
            throw th;
        }
    }

    @Override // net.sqlcipher.AbstractWindowedCursor
    public void setWindow(CursorWindow window) {
        if (this.mWindow != null) {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.close();
                queryThreadUnlock();
                this.mCount = -1;
            } catch (Throwable th) {
                queryThreadUnlock();
                throw th;
            }
        }
        this.mWindow = window;
    }

    public void setSelectionArguments(String[] selectionArgs) {
        this.mDriver.setBindArguments(selectionArgs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.sqlcipher.AbstractCursor
    public void finalize() {
        try {
            if (this.mWindow != null) {
                int len = this.mQuery.mSql.length();
                StringBuilder sb = new StringBuilder();
                sb.append("Finalizing a Cursor that has not been deactivated or closed. database = ");
                sb.append(this.mDatabase.getPath());
                sb.append(", table = ");
                sb.append(this.mEditTable);
                sb.append(", query = ");
                String str = this.mQuery.mSql;
                int i = 100;
                if (len <= 100) {
                    i = len;
                }
                sb.append(str.substring(0, i));
                Log.e(TAG, sb.toString(), this.mStackTrace);
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public void fillWindow(int startPos, android.database.CursorWindow window) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow.setStartPosition(startPos);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCount == -1) {
            this.mCount = this.mInitialRead + startPos;
            Thread t = new Thread(new QueryThread(this.mCursorState), "query thread");
            t.start();
        }
    }
}
