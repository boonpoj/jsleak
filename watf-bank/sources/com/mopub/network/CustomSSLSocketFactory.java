package com.mopub.network;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Reflection;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: assets/classes2.dex */
public class CustomSSLSocketFactory extends SSLSocketFactory {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private SSLSocketFactory f2046;

    private CustomSSLSocketFactory() {
    }

    @NonNull
    public static CustomSSLSocketFactory getDefault(int i) {
        CustomSSLSocketFactory customSSLSocketFactory = new CustomSSLSocketFactory();
        customSSLSocketFactory.f2046 = SSLCertificateSocketFactory.getDefault(i, null);
        return customSSLSocketFactory;
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m1590(@NonNull SSLCertificateSocketFactory sSLCertificateSocketFactory, @NonNull SSLSocket sSLSocket, @Nullable String str) {
        Preconditions.checkNotNull(sSLCertificateSocketFactory);
        Preconditions.checkNotNull(sSLSocket);
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            return;
        }
        try {
            new Reflection.MethodBuilder(sSLSocket, "setHostname").addParam((Class<Class>) String.class, (Class) str).execute();
        } catch (Exception unused) {
            MoPubLog.d("Unable to call setHostname() on the socket");
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1591(@Nullable Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1592(@NonNull Socket socket, @Nullable String str) throws IOException {
        Preconditions.checkNotNull(socket);
        if (this.f2046 == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            m1590((SSLCertificateSocketFactory) this.f2046, sSLSocket, str);
            m1593(sSLSocket, str);
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m1593(@NonNull SSLSocket sSLSocket, @Nullable String str) throws IOException {
        Preconditions.checkNotNull(sSLSocket);
        sSLSocket.startHandshake();
        if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSocket.getSession())) {
            throw new SSLHandshakeException("Server Name Identification failed.");
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        if (this.f2046 != null) {
            Socket createSocket = this.f2046.createSocket();
            m1591(createSocket);
            return createSocket;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        if (this.f2046 != null) {
            Socket createSocket = this.f2046.createSocket(str, i);
            m1591(createSocket);
            return createSocket;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        if (this.f2046 != null) {
            Socket createSocket = this.f2046.createSocket(str, i, inetAddress, i2);
            m1591(createSocket);
            return createSocket;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        if (this.f2046 != null) {
            Socket createSocket = this.f2046.createSocket(inetAddress, i);
            m1591(createSocket);
            return createSocket;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        if (this.f2046 != null) {
            Socket createSocket = this.f2046.createSocket(inetAddress, i, inetAddress2, i2);
            m1591(createSocket);
            return createSocket;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (this.f2046 != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                Socket createSocket = this.f2046.createSocket(socket, str, i, z);
                m1591(createSocket);
                return createSocket;
            }
            if (z && socket != null) {
                socket.close();
            }
            Socket createSocket2 = this.f2046.createSocket(InetAddressUtils.getInetAddressByName(str), i);
            m1591(createSocket2);
            m1592(createSocket2, str);
            return createSocket2;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f2046 == null ? new String[0] : this.f2046.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f2046 == null ? new String[0] : this.f2046.getSupportedCipherSuites();
    }
}
