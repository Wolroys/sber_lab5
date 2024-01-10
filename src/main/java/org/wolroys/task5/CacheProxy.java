package org.wolroys.task5;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class CacheProxy implements InvocationHandler {

    private final Object object;
    private final Map<Method, Map<List<Object>, Object>> cache = new HashMap<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(OwnCache.class)){
            Map<List<Object>, Object> map
                    = cache.computeIfAbsent(method, k -> new HashMap<>());
            List<Object> key = Arrays.asList(args);

            if (!map.containsKey(key)){
                Object result = method.invoke(object, args);

                map.put(key, result);
            }
                return map.get(key);
        } else
            return method.invoke(object, args);
    }
}
