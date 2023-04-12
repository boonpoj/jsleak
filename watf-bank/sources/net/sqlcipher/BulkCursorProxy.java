package net.sqlcipher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;
/* compiled from: BulkCursorNative.java */
/* loaded from: classes.dex */
final class BulkCursorProxy implements IBulkCursor {
    private Bundle mExtras = null;
    private IBinder mRemote;

    public BulkCursorProxy(IBinder remote) {
        this.mRemote = remote;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // net.sqlcipher.IBulkCursor
    public CursorWindow getWindow(int startPos) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        data.writeInt(startPos);
        this.mRemote.transact(1, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        CursorWindow window = null;
        if (reply.readInt() == 1) {
            window = CursorWindow.newFromParcel(reply);
        }
        data.recycle();
        reply.recycle();
        return window;
    }

    @Override // net.sqlcipher.IBulkCursor
    public void onMove(int position) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        data.writeInt(position);
        this.mRemote.transact(8, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        data.recycle();
        reply.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public int count() throws RemoteException {
        int count;
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        boolean result = this.mRemote.transact(2, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        if (!result) {
            count = -1;
        } else {
            count = reply.readInt();
        }
        data.recycle();
        reply.recycle();
        return count;
    }

    @Override // net.sqlcipher.IBulkCursor
    public String[] getColumnNames() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(3, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        int numColumns = reply.readInt();
        String[] columnNames = new String[numColumns];
        for (int i = 0; i < numColumns; i++) {
            columnNames[i] = reply.readString();
        }
        data.recycle();
        reply.recycle();
        return columnNames;
    }

    @Override // net.sqlcipher.IBulkCursor
    public void deactivate() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(6, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        data.recycle();
        reply.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public void close() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(12, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        data.recycle();
        reply.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public int requery(IContentObserver observer, CursorWindow window) throws RemoteException {
        int count;
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        data.writeStrongInterface(observer);
        window.writeToParcel(data, 0);
        boolean result = this.mRemote.transact(7, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        if (!result) {
            count = -1;
        } else {
            count = reply.readInt();
            this.mExtras = reply.readBundle(getClass().getClassLoader());
        }
        data.recycle();
        reply.recycle();
        return count;
    }

    @Override // net.sqlcipher.IBulkCursor
    public boolean updateRows(Map values) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        data.writeMap(values);
        this.mRemote.transact(4, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        boolean result = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        return result;
    }

    @Override // net.sqlcipher.IBulkCursor
    public boolean deleteRow(int position) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        data.writeInt(position);
        this.mRemote.transact(5, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        boolean result = reply.readInt() == 1;
        data.recycle();
        reply.recycle();
        return result;
    }

    @Override // net.sqlcipher.IBulkCursor
    public boolean getWantsAllOnMoveCalls() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(9, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        int result = reply.readInt();
        data.recycle();
        reply.recycle();
        return result != 0;
    }

    @Override // net.sqlcipher.IBulkCursor
    public Bundle getExtras() throws RemoteException {
        if (this.mExtras == null) {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            data.writeInterfaceToken(IBulkCursor.descriptor);
            this.mRemote.transact(10, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            this.mExtras = reply.readBundle(getClass().getClassLoader());
            data.recycle();
            reply.recycle();
        }
        return this.mExtras;
    }

    @Override // net.sqlcipher.IBulkCursor
    public Bundle respond(Bundle extras) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IBulkCursor.descriptor);
        data.writeBundle(extras);
        this.mRemote.transact(11, data, reply, 0);
        DatabaseUtils.readExceptionFromParcel(reply);
        Bundle returnExtras = reply.readBundle(getClass().getClassLoader());
        data.recycle();
        reply.recycle();
        return returnExtras;
    }
}
