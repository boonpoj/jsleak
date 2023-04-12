package com.mopub.common.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: assets/classes2.dex */
public class Reflection {

    /* loaded from: assets/classes2.dex */
    public static class MethodBuilder {
        @Nullable

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final Object f628;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final String f629;
        @Nullable

        /* renamed from: ࢣ  reason: contains not printable characters */
        private Class<?> f630;
        @NonNull

        /* renamed from: ࢤ  reason: contains not printable characters */
        private List<Class<?>> f631;
        @NonNull

        /* renamed from: ࢥ  reason: contains not printable characters */
        private List<Object> f632;

        /* renamed from: ࢦ  reason: contains not printable characters */
        private boolean f633;

        /* renamed from: ࢧ  reason: contains not printable characters */
        private boolean f634;

        public MethodBuilder(@Nullable Object obj, @NonNull String str) {
            Preconditions.checkNotNull(str);
            this.f628 = obj;
            this.f629 = str;
            this.f631 = new ArrayList();
            this.f632 = new ArrayList();
            this.f630 = obj != null ? obj.getClass() : null;
        }

        @NonNull
        public <T> MethodBuilder addParam(@NonNull Class<T> cls, @Nullable T t) {
            Preconditions.checkNotNull(cls);
            this.f631.add(cls);
            this.f632.add(t);
            return this;
        }

        @NonNull
        public MethodBuilder addParam(@NonNull String str, @Nullable Object obj) throws ClassNotFoundException {
            Preconditions.checkNotNull(str);
            this.f631.add(Class.forName(str));
            this.f632.add(obj);
            return this;
        }

        @Nullable
        public Object execute() throws Exception {
            Method declaredMethodWithTraversal = Reflection.getDeclaredMethodWithTraversal(this.f630, this.f629, (Class[]) this.f631.toArray(new Class[this.f631.size()]));
            if (this.f633) {
                declaredMethodWithTraversal.setAccessible(true);
            }
            return declaredMethodWithTraversal.invoke(this.f634 ? null : this.f628, this.f632.toArray());
        }

        @NonNull
        public MethodBuilder setAccessible() {
            this.f633 = true;
            return this;
        }

        @NonNull
        public MethodBuilder setStatic(@NonNull Class<?> cls) {
            Preconditions.checkNotNull(cls);
            this.f634 = true;
            this.f630 = cls;
            return this;
        }

        @NonNull
        public MethodBuilder setStatic(@NonNull String str) throws ClassNotFoundException {
            Preconditions.checkNotNull(str);
            this.f634 = true;
            this.f630 = Class.forName(str);
            return this;
        }
    }

    public static boolean classFound(@NonNull String str) {
        Preconditions.checkNotNull(str);
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Nullable
    public static Method getDeclaredMethodWithTraversal(@Nullable Class<?> cls, @NonNull String str, @NonNull Class<?>... clsArr) throws NoSuchMethodException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(clsArr);
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static Field getPrivateField(@NonNull Class cls, @NonNull String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField;
    }

    @NonNull
    public static <T> T instantiateClassWithConstructor(@NonNull String str, @NonNull Class<? extends T> cls, @NonNull Class[] clsArr, @NonNull Object[] objArr) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(clsArr);
        Preconditions.checkNotNull(objArr);
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(objArr);
    }

    @NonNull
    public static <T> T instantiateClassWithEmptyConstructor(@NonNull String str, @NonNull Class<? extends T> cls) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NullPointerException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(cls);
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(new Object[0]);
    }
}
