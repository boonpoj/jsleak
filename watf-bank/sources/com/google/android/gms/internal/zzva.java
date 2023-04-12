package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* loaded from: classes.dex */
public interface zzva extends IInterface {
    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzll getVideoController() throws RemoteException;

    IObjectWrapper getView() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzaem zzaemVar, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, zzaem zzaemVar, String str2) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, zzvd zzvdVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, String str2, zzvd zzvdVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, String str2, zzvd zzvdVar, zzpe zzpeVar, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, zzjj zzjjVar, String str, zzvd zzvdVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, zzjj zzjjVar, String str, String str2, zzvd zzvdVar) throws RemoteException;

    void zza(zzjj zzjjVar, String str, String str2) throws RemoteException;

    void zzc(zzjj zzjjVar, String str) throws RemoteException;

    void zzg(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzvj zzme() throws RemoteException;

    zzvm zzmf() throws RemoteException;

    Bundle zzmg() throws RemoteException;

    Bundle zzmh() throws RemoteException;

    boolean zzmi() throws RemoteException;

    zzqm zzmj() throws RemoteException;
}
