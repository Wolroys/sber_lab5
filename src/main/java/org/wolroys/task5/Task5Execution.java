package org.wolroys.task5;

import java.lang.reflect.Proxy;

public class Task5Execution {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        Service serviceProxy = (Service) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                service.getClass().getInterfaces(),
                new CacheProxy(service));

        long beforeCache = System.currentTimeMillis();
        serviceProxy.concatString("Hello");
        System.out.println(System.currentTimeMillis() - beforeCache);

        long afterCache = System.currentTimeMillis();
        serviceProxy.concatString("Hello");
        System.out.println(System.currentTimeMillis() - afterCache);
    }
}
