package org.wolroys.task6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PerformanceProxy implements InvocationHandler {
    private final Object delegate;

    public PerformanceProxy(Object delegate) {
        this.delegate = delegate;
    }

    public static <T> T createInstance(T delegate) {
        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new PerformanceProxy(delegate));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Metric.class)) {
            long start = System.nanoTime();
            Object result = method.invoke(delegate, args);
            long end = System.nanoTime();
            System.out.println("Время работы метода: " + (end - start) + " (в наносек)");
            return result;
        } else {
            return method.invoke(delegate, args);
        }
    }
}