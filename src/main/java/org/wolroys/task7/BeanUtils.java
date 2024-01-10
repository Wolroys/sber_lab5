package org.wolroys.task7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    public static void assign(Object to, Object from){
        Class<?> fromClass = from.getClass();
        Class<?> toClass = to.getClass();

        Method[] fromMethods = fromClass.getMethods();
        Method[] toMethods = toClass.getMethods();

        for (Method fromMethod : fromMethods){
            if (isGetter(fromMethod)){
                try{
                    String fromName = fromMethod.getName().substring(3);

                    for (Method toMethod : toMethods){
                        if (isSetter(toMethod)){
                            String toName = toMethod.getName().substring(3);

                            if (fromName.equals(toName)){
                                if (toMethod.getParameterTypes()[0].isAssignableFrom(fromMethod.getReturnType())){
                                    toMethod.invoke(to, fromMethod.invoke(from));
                                }
                            }
                        }
                    }
                } catch (IllegalAccessException | InvocationTargetException e){
                    System.out.println("Something went wrong");
                }
            }
        }


    }

    private static boolean isGetter(Method method){
        if (!method.getName().startsWith("get"))
            return false;

        if (void.class.equals(method.getReturnType()))
            return false;

        return method.getParameterCount() == 0;
    }

    private static boolean isSetter(Method method){
        if (!method.getName().startsWith("set"))
            return false;

        if (!void.class.equals(method.getReturnType()))
            return false;

        return method.getParameterCount() == 1;
    }
}
