package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.support.annotation.VisibleForTesting;
import com.ࢢ.ࢠ.ࢠ.ࢠ.C0355;
import com.ࢢ.ࢠ.ࢠ.ࢠ.ࢠ.ࢠ.C0369;
import com.ࢢ.ࢠ.ࢠ.ࢠ.ࢠ.ࢢ.C0370;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ބ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0349<T> implements InvocationHandler {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final Object[] f2454 = new Object[0];

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final InterfaceC0350<T> f2455;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Class<T> f2456;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final LinkedList<C0349<T>.C0351> f2457;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f2458;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private T f2459;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ބ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0350<T> {
        /* renamed from: ࢠ */
        C0370<T> mo1950() throws C0348;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ބ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class C0351 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final WeakReference[] f2461;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final LinkedList<Object> f2462;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final Method f2463;

        private C0351(Method method, Object... objArr) {
            this.f2462 = new LinkedList<>();
            objArr = objArr == null ? C0349.f2454 : objArr;
            WeakReference[] weakReferenceArr = new WeakReference[objArr.length];
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Object obj = objArr[i];
                if ((obj instanceof Map) || (obj instanceof Integer) || (obj instanceof Double)) {
                    this.f2462.add(obj);
                }
                weakReferenceArr[i2] = new WeakReference(obj);
                i++;
                i2++;
            }
            this.f2461 = weakReferenceArr;
            this.f2463 = method;
        }

        /* synthetic */ C0351(C0349 c0349, Method method, Object[] objArr, byte b) {
            this(method, objArr);
        }
    }

    @VisibleForTesting
    private C0349(InterfaceC0350<T> interfaceC0350, Class<T> cls) throws C0348 {
        C0369.m2032(interfaceC0350);
        C0369.m2032(cls);
        this.f2455 = interfaceC0350;
        this.f2456 = cls;
        this.f2457 = new LinkedList<>();
        C0355.m2002().m2012(new C0355.InterfaceC0358() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.ބ.1
            @Override // com.ࢢ.ࢠ.ࢠ.ࢠ.C0355.InterfaceC0358
            /* renamed from: ࢤ  reason: contains not printable characters */
            public final void mo1981() throws C0348 {
                C0349.this.m1980();
            }
        });
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Boolean m1976(Method method) {
        try {
            return Boolean.TYPE.equals(method.getReturnType()) ? true : null;
        } catch (Exception e) {
            C0348.m1974(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static <T> T m1977(InterfaceC0350<T> interfaceC0350, Class<T> cls) throws C0348 {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0349(interfaceC0350, cls));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1980() throws C0348 {
        if (!this.f2458) {
            try {
                this.f2459 = this.f2455.mo1950().m2037(null);
            } catch (Exception e) {
                C0379.m2048("OnOffTrackerProxy", this, "Could not create instance", e);
                C0348.m1974(e);
            }
            this.f2458 = true;
        }
        if (this.f2459 == null) {
            return;
        }
        Iterator<C0349<T>.C0351> it = this.f2457.iterator();
        while (it.hasNext()) {
            C0349<T>.C0351 next = it.next();
            try {
                Object[] objArr = new Object[((C0351) next).f2461.length];
                WeakReference[] weakReferenceArr = ((C0351) next).f2461;
                int length = weakReferenceArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    objArr[i2] = weakReferenceArr[i].get();
                    i++;
                    i2++;
                }
                ((C0351) next).f2463.invoke(this.f2459, objArr);
            } catch (Exception e2) {
                C0348.m1974(e2);
            }
        }
        this.f2457.clear();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            Class<?> declaringClass = method.getDeclaringClass();
            C0355 m2002 = C0355.m2002();
            if (Object.class.equals(declaringClass)) {
                String name = method.getName();
                if ("getClass".equals(name)) {
                    return this.f2456;
                }
                if ("toString".equals(name)) {
                    Object invoke = method.invoke(this, objArr);
                    return String.valueOf(invoke).replace(C0349.class.getName(), this.f2456.getName());
                }
                return method.invoke(this, objArr);
            } else if (this.f2458 && this.f2459 == null) {
                this.f2457.clear();
                return m1976(method);
            } else {
                if (m2002.f2486 == C0355.EnumC0357.f2501) {
                    m1980();
                    if (this.f2459 != null) {
                        return method.invoke(this.f2459, objArr);
                    }
                }
                if (m2002.f2486 == C0355.EnumC0357.f2500 && (!this.f2458 || this.f2459 != null)) {
                    if (this.f2457.size() >= 15) {
                        this.f2457.remove(5);
                    }
                    this.f2457.add(new C0351(this, method, objArr, (byte) 0));
                }
                return m1976(method);
            }
        } catch (Exception e) {
            C0348.m1974(e);
            return m1976(method);
        }
    }
}
