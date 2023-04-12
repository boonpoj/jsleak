package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.util.Map;
import net.sqlcipher.AbstractCursor;
/* loaded from: classes.dex */
public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private static final String TAG = "BulkCursor";
    private IBulkCursor mBulkCursor;
    private String[] mColumns;
    private int mCount;
    private AbstractCursor.SelfContentObserver mObserverBridge;
    private boolean mWantsAllOnMoveCalls;

    public void set(IBulkCursor bulkCursor) {
        this.mBulkCursor = bulkCursor;
        try {
            this.mCount = this.mBulkCursor.count();
            this.mWantsAllOnMoveCalls = this.mBulkCursor.getWantsAllOnMoveCalls();
            this.mColumns = this.mBulkCursor.getColumnNames();
            this.mRowIdColumnIndex = findRowIdColumnIndex(this.mColumns);
        } catch (RemoteException e) {
            Log.e(TAG, "Setup failed because the remote process is dead");
        }
    }

    public void set(IBulkCursor bulkCursor, int count, int idIndex) {
        this.mBulkCursor = bulkCursor;
        this.mColumns = null;
        this.mCount = count;
        this.mRowIdColumnIndex = idIndex;
    }

    public static int findRowIdColumnIndex(String[] columnNames) {
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            if (columnNames[i].equals("_id")) {
                return i;
            }
        }
        return -1;
    }

    public synchronized IContentObserver getObserver() {
        if (this.mObserverBridge == null) {
            this.mObserverBridge = new AbstractCursor.SelfContentObserver(this);
        }
        return null;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.mCount;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int oldPosition, int newPosition) {
        try {
            if (this.mWindow != null) {
                if (newPosition >= this.mWindow.getStartPosition() && newPosition < this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
                    if (this.mWantsAllOnMoveCalls) {
                        this.mBulkCursor.onMove(newPosition);
                    }
                }
                this.mWindow = this.mBulkCursor.getWindow(newPosition);
            } else {
                this.mWindow = this.mBulkCursor.getWindow(newPosition);
            }
            if (this.mWindow == null) {
                return false;
            }
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Unable to get window because the remote process is dead");
            return false;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        try {
            this.mBulkCursor.deactivate();
        } catch (RemoteException e) {
            Log.w(TAG, "Remote process exception when deactivating");
        }
        this.mWindow = null;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        try {
            this.mBulkCursor.close();
        } catch (RemoteException e) {
            Log.w(TAG, "Remote process exception when closing");
        }
        this.mWindow = null;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean requery() {
        try {
            int i = this.mCount;
            this.mCount = this.mBulkCursor.requery(getObserver(), new CursorWindow(false));
            if (this.mCount != -1) {
                this.mPos = -1;
                this.mWindow = null;
                super.requery();
                return true;
            }
            deactivate();
            return false;
        } catch (Exception ex) {
            Log.e(TAG, "Unable to requery because the remote process exception " + ex.getMessage());
            deactivate();
            return false;
        }
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean deleteRow() {
        try {
            boolean result = this.mBulkCursor.deleteRow(this.mPos);
            if (result) {
                this.mWindow = null;
                this.mCount = this.mBulkCursor.count();
                if (this.mPos < this.mCount) {
                    int oldPos = this.mPos;
                    this.mPos = -1;
                    moveToPosition(oldPos);
                } else {
                    this.mPos = this.mCount;
                }
                onChange(true);
            }
            return result;
        } catch (RemoteException e) {
            Log.e(TAG, "Unable to delete row because the remote process is dead");
            return false;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        if (this.mColumns == null) {
            try {
                this.mColumns = this.mBulkCursor.getColumnNames();
            } catch (RemoteException e) {
                Log.e(TAG, "Unable to fetch column names because the remote process is dead");
                return null;
            }
        }
        return this.mColumns;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> additionalValues) {
        if (!supportsUpdates()) {
            Log.e(TAG, "commitUpdates not supported on this cursor, did you include the _id column?");
            return false;
        }
        synchronized (this.mUpdatedRows) {
            if (additionalValues != null) {
                this.mUpdatedRows.putAll(additionalValues);
            }
            if (this.mUpdatedRows.size() <= 0) {
                return false;
            }
            try {
                boolean result = this.mBulkCursor.updateRows(this.mUpdatedRows);
                if (result) {
                    this.mUpdatedRows.clear();
                    onChange(true);
                }
                return result;
            } catch (RemoteException e) {
                Log.e(TAG, "Unable to commit updates because the remote process is dead");
                return false;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        try {
            return this.mBulkCursor.getExtras();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public Bundle respond(Bundle extras) {
        try {
            return this.mBulkCursor.respond(extras);
        } catch (RemoteException e) {
            Log.w(TAG, "respond() threw RemoteException, returning an empty bundle.", e);
            return Bundle.EMPTY;
        }
    }

    @Override // net.sqlcipher.AbstractWindowedCursor, net.sqlcipher.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerContentObserver(ContentObserver observer) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver observer) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void unregisterContentObserver(ContentObserver observer) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }
}
